package com.android.server;

import android.R;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.BroadcastOptions;
import android.app.compat.CompatChanges;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.BundleMerger;
import android.os.DropBoxManager;
import android.os.FileUtils;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.ShellCommand;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.text.TextUtils;
import android.text.format.TimeMigrationUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.os.IDropBoxManagerService;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.ObjectUtils;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.PackageManagerService;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.zip.GZIPOutputStream;
import libcore.io.IoUtils;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: loaded from: classes.dex */
public final class DropBoxManagerService extends SystemService {
    private static final long COMPRESS_THRESHOLD_BYTES = 16384;
    private static final int DEFAULT_AGE_SECONDS = 259200;
    private static final int DEFAULT_MAX_FILES = 1000;
    private static final int DEFAULT_MAX_FILES_LOWRAM = 300;
    public static final int DEFAULT_QUOTA_KB = 0;
    private static final int DEFAULT_QUOTA_PERCENT = 10;
    private static final int DEFAULT_RESERVE_PERCENT = 0;
    private static final List<String> DISABLED_BY_DEFAULT_TAGS = null;
    private static final long ENFORCE_READ_DROPBOX_DATA = 296060945;
    private static final boolean PROFILE_DUMP = false;
    private static final int PROTO_MAX_DATA_BYTES = 262144;
    private static final int QUOTA_RESCAN_MILLIS = 5000;
    private static final String TAG = "DropBoxManagerService";
    private static final BundleMerger sDropboxEntryAddedExtrasMerger = null;
    private FileList mAllFiles;
    private int mBlockSize;
    private volatile boolean mBooted;
    private int mCachedQuotaBlocks;
    private long mCachedQuotaUptimeMillis;
    private final ContentResolver mContentResolver;
    private final File mDropBoxDir;
    private ArrayMap<String, FileList> mFilesByTag;
    private final DropBoxManagerBroadcastHandler mHandler;
    private long mLowPriorityRateLimitPeriod;
    private ArraySet<String> mLowPriorityTags;
    private int mMaxFiles;
    private final BroadcastReceiver mReceiver;
    private StatFs mStatFs;
    private final IDropBoxManagerService.Stub mStub;

    private class DropBoxManagerBroadcastHandler extends Handler {
        static final int MSG_SEND_BROADCAST = 1;
        static final int MSG_SEND_DEFERRED_BROADCAST = 2;
        private final ArrayMap<String, Intent> mDeferredMap;
        private final Object mLock;
        final /* synthetic */ DropBoxManagerService this$0;

        DropBoxManagerBroadcastHandler(DropBoxManagerService r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
            this.mLock = new Object();
            this.mDeferredMap = new ArrayMap();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L14;
                case 2: goto L5;
                default: goto L20;
            };
        L5:
            Object r0 = this.mLock;
            monitor-enter(r0);
            Intent deferredIntent = this.mDeferredMap.remove((String) msg.obj);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            if (deferredIntent == null) goto L18;
            prepareAndSendBroadcast(deferredIntent, true);
            return;
        L18:
            return;
        L11:
            th = move-exception;
            throw th;
        L14:
            prepareAndSendBroadcast((Intent) msg.obj, false);
            return;
        }

        private void prepareAndSendBroadcast(Intent intent, boolean deferrable) {
            if (DropBoxManagerService.m214$$Nest$fgetmBooted(this.this$0) == true) goto L5;
            intent.addFlags(1073741824);
        L5:
            BroadcastOptions options = BroadcastOptions.makeBasic();
            options.setRequireCompatChange(DropBoxManagerService.ENFORCE_READ_DROPBOX_DATA, true);
            if (deferrable == false) goto L8;
            String matchingKey = intent.getStringExtra("tag") + "-READ_DROPBOX_DATA";
            setBroadcastOptionsForDeferral(options, matchingKey);
        L8:
            this.this$0.getContext().sendBroadcastAsUser(intent, UserHandle.ALL, "android.permission.READ_DROPBOX_DATA", options.toBundle());
            options.setRequireCompatChange(DropBoxManagerService.ENFORCE_READ_DROPBOX_DATA, false);
            if (deferrable == false) goto L11;
            String matchingKey2 = intent.getStringExtra("tag") + "-READ_LOGS";
            setBroadcastOptionsForDeferral(options, matchingKey2);
        L11:
            this.this$0.getContext().sendBroadcastAsUser(intent, UserHandle.ALL, "android.permission.READ_LOGS", options.toBundle());
        }

        private Intent createIntent(String tag, long time) {
            Intent dropboxIntent = new Intent("android.intent.action.DROPBOX_ENTRY_ADDED");
            dropboxIntent.putExtra("tag", tag);
            dropboxIntent.putExtra("time", time);
            dropboxIntent.putExtra("android.os.extra.DROPPED_COUNT", 0);
            return dropboxIntent;
        }

        private void setBroadcastOptionsForDeferral(BroadcastOptions options, String matchingKey) {
            options.setDeliveryGroupPolicy(2).setDeliveryGroupMatchingKey("android.intent.action.DROPBOX_ENTRY_ADDED", matchingKey).setDeliveryGroupExtrasMerger(DropBoxManagerService.m224$$Nest$sfgetsDropboxEntryAddedExtrasMerger()).setDeferralPolicy(2);
        }

        public void sendBroadcast(String tag, long time) {
            sendMessage(obtainMessage(1, createIntent(tag, time)));
        }

        public void maybeDeferBroadcast(String tag, long time) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            Intent intent = this.mDeferredMap.get(tag);     // Catch: Throwable -> L9
            if (intent != null) goto L11;
            this.mDeferredMap.put(tag, createIntent(tag, time));     // Catch: Throwable -> L9
            sendMessageDelayed(obtainMessage(2, tag), DropBoxManagerService.m215$$Nest$fgetmLowPriorityRateLimitPeriod(this.this$0));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            intent.putExtra("time", time);     // Catch: Throwable -> L9
            int dropped = intent.getIntExtra("android.os.extra.DROPPED_COUNT", 0);     // Catch: Throwable -> L9
            intent.putExtra("android.os.extra.DROPPED_COUNT", dropped + 1);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    private final class DropBoxManagerInternalImpl extends DropBoxManagerInternal {
        final /* synthetic */ DropBoxManagerService this$0;

        /* synthetic */ DropBoxManagerInternalImpl(DropBoxManagerService r1, DropBoxManagerServiceIA r2) {
            this(r1);
        }

        private DropBoxManagerInternalImpl(DropBoxManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.DropBoxManagerInternal
        public void addEntry(String tag, DropBoxManagerInternal.EntrySource entry, int flags) {
            this.this$0.addEntry(tag, entry, flags);
        }
    }

    static final class EntryFile implements Comparable<EntryFile> {
        public final int blocks;
        public final int flags;
        public final String tag;
        public final long timestampMillis;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(EntryFile r1) {
            return compareTo2(r1);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public final int compareTo2(EntryFile o) {
            int comp = Long.compare(this.timestampMillis, o.timestampMillis);
            if (comp == 0) goto L5;
            return comp;
        L5:
            int comp2 = ObjectUtils.compare(this.tag, o.tag);
            if (comp2 == 0) goto L8;
            return comp2;
        L8:
            int comp3 = Integer.compare(this.flags, o.flags);
            if (comp3 == 0) goto L12;
            return comp3;
        L12:
            return Integer.compare(hashCode(), o.hashCode());
        }

        public EntryFile(File temp, File dir, String tag, long timestampMillis, int flags, int blockSize) throws IOException {
            if ((flags & 1) != 0) goto L11;
            this.tag = TextUtils.safeIntern(tag);
            this.timestampMillis = timestampMillis;
            this.flags = flags;
            File file = getFile(dir);
            if (temp.renameTo(file) == false) goto L9;
            this.blocks = (int) (((file.length() + ((long) blockSize)) - 1) / ((long) blockSize));
            return;
        L9:
            throw new IOException("Can't rename " + temp + " to " + file);
        L11:
            throw new IllegalArgumentException();
        }

        public EntryFile(File dir, String tag, long timestampMillis) throws IOException {
            this.tag = TextUtils.safeIntern(tag);
            this.timestampMillis = timestampMillis;
            this.flags = 1;
            this.blocks = 0;
            new FileOutputStream(getFile(dir)).close();
        }

        public EntryFile(File file, int blockSize) {
            boolean parseFailure = false;
            String name = file.getName();
            int flags = 0;
            String tag = null;
            long millis = 0;
            int at = name.lastIndexOf(64);
            if (at >= 0) goto L5;
            parseFailure = true;
        L23:
            if (parseFailure == false) goto L26;
            Slog.wtf(DropBoxManagerService.TAG, "Invalid filename: " + file);
            file.delete();
            this.tag = null;
            this.flags = 1;
            this.timestampMillis = 0;
            this.blocks = 0;
            return;
        L26:
            this.blocks = (int) (((file.length() + ((long) blockSize)) - 1) / ((long) blockSize));
            this.tag = TextUtils.safeIntern(tag);
            this.flags = flags;
            this.timestampMillis = millis;
            return;
        L5:
            tag = Uri.decode(name.substring(0, at));
            if (name.endsWith(PackageManagerService.COMPRESSED_EXTENSION) == false) goto L9;
            flags = 0 | 4;
            name = name.substring(0, name.length() - 3);
        L9:
            if (name.endsWith(".lost") == false) goto L12;
            flags = flags | 1;
            name = name.substring(at + 1, name.length() - 5);
        L18:
            if (parseFailure == true) goto L23;
            millis = Long.parseLong(name);     // Catch: NumberFormatException -> L21
        L22:
            parseFailure = true;
            goto L23
        L12:
            if (name.endsWith(".txt") == false) goto L15;
            flags = flags | 2;
            name = name.substring(at + 1, name.length() - 4);
            goto L18
        L15:
            if (name.endsWith(".dat") == false) goto L17;
            name = name.substring(at + 1, name.length() - 4);
            goto L18
        L17:
            parseFailure = true;
            goto L18
        }

        public EntryFile(long millis) {
            this.tag = null;
            this.timestampMillis = millis;
            this.flags = 1;
            this.blocks = 0;
        }

        public boolean hasFile() {
            if (this.tag == null) goto L5;
            return true;
        L5:
            return false;
        }

        private String getExtension() {
            if ((this.flags & 1) == 0) goto L6;
            return ".lost";
        L6:
            StringBuilder r0 = new StringBuilder();
            if ((this.flags & 2) == 0) goto L9;
            String r1 = ".txt";
        L10:
            r0.append(r1);
            if ((this.flags & 4) == 0) goto L13;
            String r2 = PackageManagerService.COMPRESSED_EXTENSION;
        L14:
            r0.append(r2);
            return r0.toString();
        L13:
            r2 = "";
            goto L14
        L9:
            r1 = ".dat";
            goto L10
        }

        public String getFilename() {
            if (hasFile() == true) goto L7;
            return null;
        L7:
            return Uri.encode(this.tag) + "@" + this.timestampMillis + getExtension();
        }

        public File getFile(File dir) {
            if (hasFile() == true) goto L7;
            return null;
        L7:
            return new File(dir, getFilename());
        }

        public void deleteFile(File dir) {
            if (hasFile() == false) goto L6;
            getFile(dir).delete();
            return;
        }
    }

    private static final class FileList implements Comparable<FileList> {
        public int blocks;
        public final TreeSet<EntryFile> contents;

        /* synthetic */ FileList(DropBoxManagerServiceIA r1) {
            this();
        }

        private FileList() {
            this.blocks = 0;
            this.contents = new TreeSet();
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(FileList r1) {
            return compareTo2(r1);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public final int compareTo2(FileList o) {
            if (this.blocks == o.blocks) goto L7;
            return o.blocks - this.blocks;
        L7:
            if (this != o) goto L10;
            return 0;
        L10:
            if (hashCode() >= o.hashCode()) goto L14;
            return -1;
        L14:
            if (hashCode() <= o.hashCode()) goto L17;
            return 1;
        L17:
            return 0;
        }
    }

    private class ShellCmd extends ShellCommand {
        final /* synthetic */ DropBoxManagerService this$0;

        /* synthetic */ ShellCmd(DropBoxManagerService r1, DropBoxManagerServiceIA r2) {
            this(r1);
        }

        private ShellCmd(DropBoxManagerService r1) {
            this.this$0 = r1;
        }

        public int onCommand(String cmd) {
            if (cmd == null) goto L4;
            PrintWriter pw = getOutPrintWriter();
        L12:
            e = move-exception;
            pw.println(e);
        L33:
            return 0;
        L7:
            switch(cmd.hashCode()) {
                case -1412652367: goto L21;
                case -529247831: goto L18;
                case -444925274: goto L15;
                case 1936917209: goto L10;
                default: goto L23;
            };     // Catch: Exception -> L12
        L23:
            byte r2 = -1;
        L24:
            switch(r2) {
                case 0: goto L30;
                case 1: goto L29;
                case 2: goto L28;
                case 3: goto L27;
                default: goto L26;
            };     // Catch: Exception -> L12
        L27:
            DropBoxManagerService.m221$$Nest$mrestoreDefaults(this.this$0);     // Catch: Exception -> L12
            goto L33
        L28:
            String removeTag = getNextArgRequired();     // Catch: Exception -> L12
            DropBoxManagerService.m220$$Nest$mremoveLowPriorityTag(this.this$0, removeTag);     // Catch: Exception -> L12
            goto L33
        L29:
            String addedTag = getNextArgRequired();     // Catch: Exception -> L12
            DropBoxManagerService.m218$$Nest$maddLowPriorityTag(this.this$0, addedTag);     // Catch: Exception -> L12
            goto L33
        L30:
            String addedTag2 = getNextArgRequired();     // Catch: Exception -> L12
            long period = Long.parseLong(addedTag2);     // Catch: Exception -> L12
            DropBoxManagerService.m222$$Nest$msetLowPriorityRateLimit(this.this$0, period);     // Catch: Exception -> L12
            goto L33
        L26:
            return handleDefaultCommands(cmd);
        L10:
            if (cmd.equals("set-rate-limit") == false) goto L23;
            r2 = 0;
            goto L24
        L15:
            if (cmd.equals("remove-low-priority") == false) goto L23;
            r2 = 2;
            goto L24
        L18:
            if (cmd.equals("add-low-priority") == false) goto L23;
            r2 = 1;
            goto L24
        L21:
            if (cmd.equals("restore-defaults") == false) goto L23;
            r2 = 3;
            goto L24
        L4:
            return handleDefaultCommands(cmd);
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            pw.println("Dropbox manager service commands:");
            pw.println("  help");
            pw.println("    Print this help text.");
            pw.println("  set-rate-limit PERIOD");
            pw.println("    Sets low priority broadcast rate limit period to PERIOD ms");
            pw.println("  add-low-priority TAG");
            pw.println("    Add TAG to dropbox low priority list");
            pw.println("  remove-low-priority TAG");
            pw.println("    Remove TAG from dropbox low priority list");
            pw.println("  restore-defaults");
            pw.println("    restore dropbox settings to defaults");
        }
    }

    public static class SimpleEntrySource implements DropBoxManagerInternal.EntrySource {
        private final boolean forceCompress;
        private final InputStream in;
        private final long length;

        public SimpleEntrySource(InputStream in, long length, boolean forceCompress) {
            this.in = in;
            this.length = length;
            this.forceCompress = forceCompress;
        }

        @Override // com.android.server.DropBoxManagerInternal.EntrySource
        public long length() {
            return this.length;
        }

        @Override // com.android.server.DropBoxManagerInternal.EntrySource
        public void writeTo(FileDescriptor fd) throws IOException {
            if (this.forceCompress == false) goto L5;
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(new FileOutputStream(fd));
            FileUtils.copy(this.in, gzipOutputStream);
            gzipOutputStream.close();
            return;
        L5:
            FileUtils.copy(this.in, new FileOutputStream(fd));
        }

        @Override // com.android.server.DropBoxManagerInternal.EntrySource, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            FileUtils.closeQuietly(this.in);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBooted, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m214$$Nest$fgetmBooted(DropBoxManagerService r0) {
        return r0.mBooted;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLowPriorityRateLimitPeriod, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m215$$Nest$fgetmLowPriorityRateLimitPeriod(DropBoxManagerService r2) {
        return r2.mLowPriorityRateLimitPeriod;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmReceiver, reason: not valid java name */
    static /* bridge */ /* synthetic */ BroadcastReceiver m216$$Nest$fgetmReceiver(DropBoxManagerService r0) {
        return r0.mReceiver;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCachedQuotaUptimeMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m217$$Nest$fputmCachedQuotaUptimeMillis(DropBoxManagerService r0, long r1) {
        r0.mCachedQuotaUptimeMillis = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddLowPriorityTag, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m218$$Nest$maddLowPriorityTag(DropBoxManagerService r0, String r1) {
        r0.addLowPriorityTag(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$minit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m219$$Nest$minit(DropBoxManagerService r0) {
        r0.init();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveLowPriorityTag, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m220$$Nest$mremoveLowPriorityTag(DropBoxManagerService r0, String r1) {
        r0.removeLowPriorityTag(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mrestoreDefaults, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m221$$Nest$mrestoreDefaults(DropBoxManagerService r0) {
        r0.restoreDefaults();
    }

    /* JADX INFO: renamed from: -$$Nest$msetLowPriorityRateLimit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m222$$Nest$msetLowPriorityRateLimit(DropBoxManagerService r0, long r1) {
        r0.setLowPriorityRateLimit(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtrimToFit, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m223$$Nest$mtrimToFit(DropBoxManagerService r2) {
        return r2.trimToFit();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsDropboxEntryAddedExtrasMerger, reason: not valid java name */
    static /* bridge */ /* synthetic */ BundleMerger m224$$Nest$sfgetsDropboxEntryAddedExtrasMerger() {
        return sDropboxEntryAddedExtrasMerger;
    }

    static {
        if (Build.IS_USERDEBUG == false) goto L5;
        int r0 = 20480;
    L6:
        DEFAULT_QUOTA_KB = r0;
        DISABLED_BY_DEFAULT_TAGS = List.of("data_app_wtf", "system_app_wtf", "system_server_wtf");
        sDropboxEntryAddedExtrasMerger = new BundleMerger();
        sDropboxEntryAddedExtrasMerger.setDefaultMergeStrategy(1);
        sDropboxEntryAddedExtrasMerger.setMergeStrategy("time", 4);
        sDropboxEntryAddedExtrasMerger.setMergeStrategy("android.os.extra.DROPPED_COUNT", 25);
        return;
    L5:
        r0 = TarConstants.DEFAULT_BLKSIZE;
        goto L6
    }

    public DropBoxManagerService(Context context) {
        this(context, new File("/data/system/dropbox"), FgThread.get().getLooper());
    }

    public DropBoxManagerService(Context context, File path, Looper looper) {
        super(context);
        this.mAllFiles = null;
        this.mFilesByTag = null;
        this.mLowPriorityRateLimitPeriod = 0;
        this.mLowPriorityTags = null;
        this.mStatFs = null;
        this.mBlockSize = 0;
        this.mCachedQuotaBlocks = 0;
        this.mCachedQuotaUptimeMillis = 0;
        this.mBooted = false;
        this.mMaxFiles = -1;
        this.mReceiver = new AnonymousClass1(this);
        this.mStub = new AnonymousClass2(this);
        this.mDropBoxDir = path;
        this.mContentResolver = getContext().getContentResolver();
        this.mHandler = new DropBoxManagerBroadcastHandler(this, looper);
        LocalServices.addService(DropBoxManagerInternal.class, new DropBoxManagerInternalImpl(this, null));
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("dropbox", this.mStub);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        switch(phase) {
            case 500: goto L6;
            case 1000: goto L5;
            default: goto L9;
        };
    L5:
        this.mBooted = true;
        return;
    L6:
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        getContext().registerReceiver(this.mReceiver, filter);
        ContentResolver r2 = this.mContentResolver;
        Uri r3 = Settings.Global.CONTENT_URI;
        final Handler r5 = new Handler();
        r2.registerContentObserver(r3, true, new AnonymousClass3(this, r5));
        getLowPriorityResourceConfigs();
        return;
    }

    public IDropBoxManagerService getServiceStub() {
        return this.mStub;
    }

    public void addData(String tag, byte[] data, int flags) {
        addEntry(tag, new ByteArrayInputStream(data), data.length, flags);
    }

    public void addFile(String tag, ParcelFileDescriptor fd, int flags) {
        StructStat stat = Os.fstat(fd.getFileDescriptor());     // Catch: ErrnoException -> L11
        if (OsConstants.S_ISREG(stat.st_mode) == false) goto L15;
        addEntry(tag, new ParcelFileDescriptor.AutoCloseInputStream(fd), stat.st_size, flags);
        return;
    L15:
    L9:
        e = move-exception;
        ErrnoException e = e;
    L14:
        throw new IllegalArgumentException(e);
    L8:
        throw new IllegalArgumentException(tag + " entry must be real file");     // Catch: ErrnoException -> L9
    L11:
        e = move-exception;
        e = e;
        goto L14
    }

    public void addEntry(String tag, InputStream in, long length, int flags) {
        boolean forceCompress = false;
        if ((flags & 4) == 0) goto L5;
    L7:
        addEntry(tag, new SimpleEntrySource(in, length, forceCompress), flags);
        return;
    L5:
        if (length <= COMPRESS_THRESHOLD_BYTES) goto L7;
        forceCompress = true;
        flags = flags | 4;
        goto L7
    }

    public void addEntry(String tag, DropBoxManagerInternal.EntrySource entry, int flags) {
        File temp = null;
        Slog.i(TAG, "add tag=" + tag + " isTagEnabled=" + isTagEnabled(tag) + " flags=0x" + Integer.toHexString(flags));     // Catch: Throwable -> L14 IOException -> L16
        if ((flags & 1) != 0) goto L47;
        init();     // Catch: Throwable -> L14 IOException -> L16
        if (isTagEnabled(tag) == true) goto L11;
        IoUtils.closeQuietly(entry);
        if (0 == 0) goto L66;
        temp.delete();
        return;
    L66:
        return;
    L11:
        long length = entry.length();     // Catch: Throwable -> L14 IOException -> L16
        long max = trimToFit();     // Catch: Throwable -> L14 IOException -> L16
        if (length <= max) goto L18;
        Slog.w(TAG, "Dropping: " + tag + " (" + length + " > " + max + " bytes)");     // Catch: Throwable -> L14 IOException -> L16
        logDropboxDropped(6, tag, 0);     // Catch: Throwable -> L14 IOException -> L16
        DropBoxManagerInternal.EntrySource r13 = entry;
    L24:
        long time = createEntry(temp, tag, flags);     // Catch: Throwable -> L29 IOException -> L31
        temp = null;
        if (this.mLowPriorityTags != null) goto L27;
    L33:
        this.mHandler.sendBroadcast(tag, time);     // Catch: Throwable -> L29 IOException -> L31
    L34:
        IoUtils.closeQuietly(r13);
        if (0 == 0) goto L53;
    L36:
        temp.delete();
        return;
    L53:
        return;
    L27:
        if (this.mLowPriorityTags.contains(tag) == false) goto L33;
        this.mHandler.maybeDeferBroadcast(tag, time);     // Catch: Throwable -> L29 IOException -> L31
        goto L34
    L18:
        temp = new File(this.mDropBoxDir, "drop" + Thread.currentThread().getId() + ".tmp");     // Catch: Throwable -> L14 IOException -> L16
        FileOutputStream out = new FileOutputStream(temp);     // Catch: Throwable -> L14 IOException -> L16
        r13 = entry;
        r13.writeTo(out.getFD());     // Catch: Throwable -> L37
        out.close();     // Catch: Throwable -> L29 IOException -> L31
    L37:
        th = th;
    L38:
        Throwable r14 = th;
        out.close();     // Catch: Throwable -> L43
        throw r14;     // Catch: Throwable -> L29 IOException -> L31
    L43:
        th = move-exception;
        r14.addSuppressed(th);     // Catch: Throwable -> L29 IOException -> L31
        throw r14;     // Catch: Throwable -> L29 IOException -> L31
    L39:
        th = th;
        goto L38
    L47:
        throw new IllegalArgumentException();     // Catch: Throwable -> L29 IOException -> L31
    L31:
        e = e;
    L49:
        Slog.e(TAG, "Can't write: " + tag, e);     // Catch: Throwable -> L29
        logDropboxDropped(5, tag, 0);     // Catch: Throwable -> L29
        IoUtils.closeQuietly(entry);
        if (0 != 0) goto L36;
        return;
    L29:
        th = th;
    L54:
        IoUtils.closeQuietly(entry);
        if (0 == 0) goto L57;
        temp.delete();
    L57:
        throw th;
    L16:
        e = e;
    L14:
        th = th;
        goto L54
    }

    private void logDropboxDropped(int reason, String tag, long entryAge) {
        FrameworkStatsLog.write(FrameworkStatsLog.DROPBOX_ENTRY_DROPPED, reason, tag, entryAge);
    }

    public boolean isTagEnabled(String tag) {
        long token = Binder.clearCallingIdentity();
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L5:
        if (DISABLED_BY_DEFAULT_TAGS.contains(tag) == false) goto L12;
        boolean r2 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED.equals(Settings.Global.getString(this.mContentResolver, "dropbox:" + tag));     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return r2;
    L12:
        boolean r3 = !ServiceConfigAccessor.PROVIDER_MODE_DISABLED.equals(Settings.Global.getString(this.mContentResolver, "dropbox:" + tag));
        Binder.restoreCallingIdentity(token);
        return r3;
    }

    private boolean checkPermission(int callingUid, String callingPackage, String callingAttributionTag) {
        if (getContext().checkCallingPermission("android.permission.PEEK_DROPBOX_DATA") != 0) goto L5;
        return true;
    L5:
        String permission = "android.permission.READ_LOGS";
        if (CompatChanges.isChangeEnabled(ENFORCE_READ_DROPBOX_DATA, callingUid) == false) goto L8;
        permission = "android.permission.READ_DROPBOX_DATA";
    L8:
        getContext().enforceCallingOrSelfPermission(permission, TAG);
        switch(((AppOpsManager) getContext().getSystemService(AppOpsManager.class)).noteOp(43, callingUid, callingPackage, callingAttributionTag, null)) {
            case 0: goto L14;
            case 3: goto L12;
            default: goto L10;
        };
    L10:
        return false;
    L12:
        getContext().enforceCallingOrSelfPermission("android.permission.PACKAGE_USAGE_STATS", TAG);
        return true;
    L14:
        return true;
    }

    public synchronized DropBoxManager.Entry getNextEntry(String tag, long millis, String callingPackage, String callingAttributionTag) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (checkPermission(Binder.getCallingUid(), callingPackage, callingAttributionTag) == true) goto L47;
        monitor-exit(this);
        return null;
    L47:
        init();     // Catch: Throwable -> L11 IOException -> L39
        if (tag != null) goto L13;
        FileList r0 = this.mAllFiles;     // Catch: Throwable -> L11
    L14:
        FileList list = r0;
        if (list != null) goto L18;
        monitor-exit(this);
        return null;
    L18:
        Iterator<EntryFile> r5 = list.contents.tailSet(new EntryFile(1 + millis)).iterator();     // Catch: Throwable -> L11
    L20:
        if (r5.hasNext() == false) goto L37;
        EntryFile entry = r5.next();     // Catch: Throwable -> L11
        if (entry.tag == null) goto L20;
        if ((entry.flags & 1) != 0) goto L26;
        File file = entry.getFile(this.mDropBoxDir);     // Catch: Throwable -> L11
        DropBoxManager.Entry r7 = new DropBoxManager.Entry(entry.tag, entry.timestampMillis, file, entry.flags);     // Catch: Throwable -> L11 IOException -> L34
    L32:
        monitor-exit(this);
        return r7;
    L34:
        e = move-exception;
        Slog.wtf(TAG, "Can't read: " + file, e);     // Catch: Throwable -> L11
        goto L20
    L26:
        DropBoxManager.Entry r1 = new DropBoxManager.Entry(entry.tag, entry.timestampMillis);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L37:
        monitor-exit(this);
        return null;
    L13:
        r0 = this.mFilesByTag.get(tag);     // Catch: Throwable -> L11
        goto L14
    L39:
        e = move-exception;
        Slog.e(TAG, "Can't init", e);     // Catch: Throwable -> L11
        return null;
    }

    private synchronized void setLowPriorityRateLimit(long period) {
        monitor-enter(this);
        this.mLowPriorityRateLimitPeriod = period;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void addLowPriorityTag(String tag) {
        monitor-enter(this);
        this.mLowPriorityTags.add(tag);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void removeLowPriorityTag(String tag) {
        monitor-enter(this);
        this.mLowPriorityTags.remove(tag);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void restoreDefaults() {
        monitor-enter(this);
        getLowPriorityResourceConfigs();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        DropBoxManagerService r1 = this;
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (DumpUtils.checkDumpAndUsageStatsPermission(r1.getContext(), TAG, pw) == true) goto L189;
        monitor-exit(this);
        return;
    L189:
        r1.init();     // Catch: Throwable -> L34 IOException -> L180
        StringBuilder out = new StringBuilder();     // Catch: Throwable -> L34
        ArrayList<String> searchArgs = new ArrayList();     // Catch: Throwable -> L34
        boolean doFile = false;
        int i = 0;
        boolean dumpProto = false;
        boolean doFile2 = false;
    L10:
        if (args == null) goto L43;
        if (i >= args.length) goto L43;
        if (args[i].equals("-p") == false) goto L16;
    L41:
        doFile = true;
    L42:
        i = i + 1;
        goto L10
    L16:
        if (args[i].equals("--print") == true) goto L41;
        if (args[i].equals("-f") == false) goto L21;
    L40:
        doFile2 = true;
        goto L42
    L21:
        if (args[i].equals("--file") == true) goto L40;
        if (args[i].equals("--proto") == false) goto L27;
        dumpProto = true;
        goto L42
    L27:
        if (args[i].equals("-h") == true) goto L37;
        if (args[i].equals("--help") == true) goto L37;
        if (args[i].startsWith("-") == false) goto L36;
        out.append("Unknown argument: ");     // Catch: Throwable -> L34
        out.append(args[i]);     // Catch: Throwable -> L34
        out.append("\n");     // Catch: Throwable -> L34
        goto L42
    L36:
        searchArgs.add(args[i]);     // Catch: Throwable -> L34
    L37:
        pw.println("Dropbox (dropbox) dump options:");     // Catch: Throwable -> L34
        pw.println("  [-h|--help] [-p|--print] [-f|--file] [timestamp]");     // Catch: Throwable -> L34
        pw.println("    -h|--help: print this help");     // Catch: Throwable -> L34
        pw.println("    -p|--print: print full contents of each entry");     // Catch: Throwable -> L34
        pw.println("    -f|--file: print path of each entry's file");     // Catch: Throwable -> L34
        pw.println("    --proto: dump data to proto");     // Catch: Throwable -> L34
        pw.println("  [timestamp] optionally filters to only those entries.");     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L43:
        if (dumpProto == false) goto L49;
        r1.dumpProtoLocked(fd, searchArgs);     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L49:
        out.append("Drop box contents: ");     // Catch: Throwable -> L34
        out.append(r1.mAllFiles.contents.size());     // Catch: Throwable -> L34
        out.append(" entries\n");     // Catch: Throwable -> L34
        out.append("Max entries: ");     // Catch: Throwable -> L34
        out.append(r1.mMaxFiles);     // Catch: Throwable -> L34
        out.append("\n");     // Catch: Throwable -> L34
        out.append("Low priority rate limit period: ");     // Catch: Throwable -> L34
        out.append(r1.mLowPriorityRateLimitPeriod);     // Catch: Throwable -> L34
        out.append(" ms\n");     // Catch: Throwable -> L34
        out.append("Low priority tags: ");     // Catch: Throwable -> L34
        out.append(r1.mLowPriorityTags);     // Catch: Throwable -> L34
        out.append("\n");     // Catch: Throwable -> L34
        if (searchArgs.isEmpty() == true) goto L56;
        out.append("Searching for:");     // Catch: Throwable -> L34
        Iterator<String> r0 = searchArgs.iterator();     // Catch: Throwable -> L34
    L53:
        if (r0.hasNext() == false) goto L55;
        String a = r0.next();     // Catch: Throwable -> L34
        out.append(" ");     // Catch: Throwable -> L34
        out.append(a);     // Catch: Throwable -> L34
        goto L53
    L55:
        out.append("\n");     // Catch: Throwable -> L34
    L56:
        int numFound = 0;
        out.append("\n");     // Catch: Throwable -> L34
        Iterator<EntryFile> r10 = r1.mAllFiles.contents.iterator();     // Catch: Throwable -> L34
    L58:
        if (r10.hasNext() == false) goto L168;
        EntryFile entry = r10.next();     // Catch: Throwable -> L34
        if (r1.matchEntry(entry, searchArgs) == false) goto L58;
        int numFound2 = numFound + 1;     // Catch: Throwable -> L34
        if (doFile == false) goto L65;
        out.append("========================================\n");     // Catch: Throwable -> L34
    L65:
        String date = TimeMigrationUtils.formatMillisWithFixedFormat(entry.timestampMillis);     // Catch: Throwable -> L34
        out.append(date);     // Catch: Throwable -> L34
        out.append(" ");     // Catch: Throwable -> L34
        if (entry.tag != null) goto L68;
        String r2 = "(no tag)";
    L69:
        out.append(r2);     // Catch: Throwable -> L34
        File file = entry.getFile(r1.mDropBoxDir);     // Catch: Throwable -> L34
        if (file != null) goto L73;
        out.append(" (no file)\n");     // Catch: Throwable -> L34
        boolean doPrint = doFile;
        boolean doFile3 = doFile2;
    L167:
        r1 = this;
        numFound = numFound2;
        doFile = doPrint;
        doFile2 = doFile3;
        goto L58
    L73:
        if ((entry.flags & 1) == 0) goto L75;
        out.append(" (contents lost)\n");     // Catch: Throwable -> L34
        doPrint = doFile;
        doFile3 = doFile2;
        goto L167
    L75:
        out.append(" (");     // Catch: Throwable -> L34
        if ((entry.flags & 4) == 0) goto L79;
        out.append("compressed ");     // Catch: Throwable -> L34
    L79:
        if ((entry.flags & 2) == 0) goto L81;
        String r3 = "text";
    L82:
        out.append(r3);     // Catch: Throwable -> L34
        out.append(", ");     // Catch: Throwable -> L34
        out.append(file.length());     // Catch: Throwable -> L34
        out.append(" bytes)\n");     // Catch: Throwable -> L34
        if (doFile2 == true) goto L87;
        if (doFile == false) goto L92;
        if ((entry.flags & 2) == 0) goto L87;
    L92:
        if ((entry.flags & 2) == 0) goto L163;
        if (doFile == false) goto L163;
        DropBoxManager.Entry dbe = null;
        InputStreamReader isr = null;
        File file2 = file;
        dbe = new DropBoxManager.Entry(entry.tag, entry.timestampMillis, file, entry.flags);     // Catch: Throwable -> L143 IOException -> L145
        if (doFile == true) goto L202;
        doPrint = doFile;
        doFile3 = doFile2;
    L137:
        dbe.close();     // Catch: Throwable -> L34
        if (isr != null) goto L193;
    L164:
        if (doPrint == false) goto L167;
        out.append("\n");     // Catch: Throwable -> L34
        goto L167
    L193:
        isr.close();     // Catch: Throwable -> L34 IOException -> L141
        goto L164
    L202:
        InputStreamReader isr2 = new InputStreamReader(dbe.getInputStream());     // Catch: Throwable -> L132 IOException -> L134
    L204:
        char[] buf = new char[4096];     // Catch: Throwable -> L128 IOException -> L130
        boolean newline = false;
    L101:
        int n = isr2.read(buf);     // Catch: Throwable -> L128 IOException -> L130
    L103:
        if (n <= 0) goto L104;
        doPrint = doFile;
        doFile3 = doFile2;
        out.append(buf, 0, n);     // Catch: Throwable -> L123 IOException -> L125
        char[] buf2 = buf;
        if (buf[n - 1] != '\n') goto L118;
        boolean r4 = true;
    L119:
        newline = r4;
        if (out.length() <= 65536) goto L127;
        pw.write(out.toString());     // Catch: Throwable -> L123 IOException -> L125
        out.setLength(0);     // Catch: Throwable -> L123 IOException -> L125
    L127:
        doFile = doPrint;
        buf = buf2;
        doFile2 = doFile3;
        goto L101
    L118:
        r4 = false;
    L125:
        e = e;
        isr = isr2;
    L191:
        out.append("*** ");     // Catch: Throwable -> L154
        out.append(e.toString());     // Catch: Throwable -> L154
        out.append("\n");     // Catch: Throwable -> L154
        Slog.e(TAG, "Can't read: " + file2, e);     // Catch: Throwable -> L154
        if (dbe == null) goto L151;
        dbe.close();     // Catch: Throwable -> L34
    L151:
        if (isr == null) goto L164;
        isr.close();     // Catch: Throwable -> L34 IOException -> L141
    L154:
        th = move-exception;
        Throwable r5 = th;
    L156:
        if (dbe == null) goto L158;
        dbe.close();     // Catch: Throwable -> L34
    L158:
        if (isr == null) goto L225;
        isr.close();     // Catch: Throwable -> L34 IOException -> L161
        throw r5;     // Catch: Throwable -> L34
    L162:
        throw r5;     // Catch: Throwable -> L34
    L225:
        throw r5;     // Catch: Throwable -> L34
    L123:
        th = move-exception;
        r5 = th;
        isr = isr2;
        goto L156
    L104:
        if (newline == true) goto L112;
        doPrint = doFile;
        out.append("\n");     // Catch: Throwable -> L108 IOException -> L110
    L113:
        doFile3 = doFile2;
        isr = isr2;
        goto L137
    L110:
        e = e;
        doFile3 = doFile2;
        isr = isr2;
    L108:
        th = move-exception;
        r5 = th;
        isr = isr2;
        goto L156
    L112:
        doPrint = doFile;
    L130:
        e = e;
        doPrint = doFile;
        doFile3 = doFile2;
        isr = isr2;
    L128:
        th = move-exception;
        r5 = th;
        isr = isr2;
    L134:
        e = e;
        doPrint = doFile;
        doFile3 = doFile2;
    L132:
        th = move-exception;
        r5 = th;
        goto L156
    L145:
        e = e;
        doPrint = doFile;
        file2 = file;
        doFile3 = doFile2;
    L143:
        th = move-exception;
        r5 = th;
    L163:
        doPrint = doFile;
        doFile3 = doFile2;
    L87:
        if (doFile == true) goto L89;
        out.append("    ");     // Catch: Throwable -> L34
    L89:
        out.append(file.getPath());     // Catch: Throwable -> L34
        out.append("\n");     // Catch: Throwable -> L34
        goto L92
    L81:
        r3 = "data";
        goto L82
    L68:
        r2 = entry.tag;     // Catch: Throwable -> L34
        goto L69
    L168:
        boolean doPrint2 = doFile;
        if (numFound != 0) goto L171;
        out.append("(No entries found.)\n");     // Catch: Throwable -> L34
    L171:
        if (args != null) goto L173;
    L174:
        if (doPrint2 == true) goto L176;
        out.append("\n");     // Catch: Throwable -> L34
    L176:
        out.append("Usage: dumpsys dropbox [--print|--file] [YYYY-mm-dd] [HH:MM:SS] [tag]\n");     // Catch: Throwable -> L34
    L177:
        pw.write(out.toString());     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L173:
        if (args.length != 0) goto L177;
    L180:
        e = move-exception;
        pw.println("Can't initialize: " + e);     // Catch: Throwable -> L34
        Slog.e(TAG, "Can't init", e);     // Catch: Throwable -> L34
    }

    private boolean matchEntry(EntryFile entry, ArrayList<String> searchArgs) {
        String date = TimeMigrationUtils.formatMillisWithFixedFormat(entry.timestampMillis);
        boolean match = true;
        int numArgs = searchArgs.size();
        int i = 0;
    L3:
        if (i >= numArgs) goto L13;
        if (match == false) goto L13;
        String arg = searchArgs.get(i);
        if (date.contains(arg) == false) goto L8;
    L11:
        boolean r5 = true;
    L12:
        match = r5;
        i = i + 1;
        goto L3
    L8:
        if (arg.equals(entry.tag) == true) goto L11;
        r5 = false;
    L13:
        return match;
    }

    private void dumpProtoLocked(FileDescriptor fd, ArrayList<String> searchArgs) {
        DropBoxManagerService r1 = this;
        ProtoOutputStream proto = new ProtoOutputStream(fd);
        Iterator<EntryFile> r4 = r1.mAllFiles.contents.iterator();
    L4:
        if (r4.hasNext() == false) goto L49;
        EntryFile entry = r4.next();
        if (r1.matchEntry(entry, searchArgs) == false) goto L4;
        File file = entry.getFile(r1.mDropBoxDir);
        if (file != null) goto L11;
        r1 = this;
        goto L4
    L11:
        if ((entry.flags & 1) != 0) goto L4;
        long bToken = proto.start(2246267895809L);
        proto.write(1112396529665L, entry.timestampMillis);
        DropBoxManager.Entry dbe = new DropBoxManager.Entry(entry.tag, entry.timestampMillis, file, entry.flags);     // Catch: IOException -> L39
        InputStream is = dbe.getInputStream();     // Catch: Throwable -> L33
        if (is != null) goto L52;
    L35:
        if (is == null) goto L37;
        is.close();     // Catch: Throwable -> L33
    L37:
        dbe.close();     // Catch: IOException -> L39
    L47:
        proto.end(bToken);
        r1 = this;
        goto L4
    L52:
        byte[] buf = new byte[262144];     // Catch: Throwable -> L24
        int readBytes = 0;
        int n = 0;
    L20:
        if (n < 0) goto L26;
        int r15 = readBytes + n;     // Catch: Throwable -> L24
        readBytes = r15;
        if (r15 >= 262144) goto L26;
        n = is.read(buf, readBytes, 262144 - readBytes);     // Catch: Throwable -> L24
    L26:
        proto.write(1151051235330L, Arrays.copyOf(buf, readBytes));     // Catch: Throwable -> L24
        goto L35
    L24:
        th = move-exception;
        is.close();     // Catch: Throwable -> L30
    L32:
        throw th;     // Catch: Throwable -> L33
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        dbe.close();     // Catch: Throwable -> L43
    L74:
        throw th;     // Catch: IOException -> L39
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L39
        throw th;     // Catch: IOException -> L39
    L39:
        e = move-exception;
        Slog.e(TAG, "Can't read: " + file, e);
        goto L47
    L49:
        proto.flush();
    }

    private synchronized void init() throws IOException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mStatFs != null) goto L20;
        if (this.mDropBoxDir.isDirectory() == false) goto L8;
    L38:
        this.mStatFs = new StatFs(this.mDropBoxDir.getPath());     // Catch: Throwable -> L12 IllegalArgumentException -> L16
        this.mBlockSize = this.mStatFs.getBlockSize();     // Catch: Throwable -> L12 IllegalArgumentException -> L16
    L18:
        throw new IOException("Can't statfs: " + this.mDropBoxDir);     // Catch: Throwable -> L12
    L8:
        if (this.mDropBoxDir.mkdirs() == true) goto L38;
        throw new IOException("Can't mkdir: " + this.mDropBoxDir);     // Catch: Throwable -> L12
    L20:
        if (this.mAllFiles != null) goto L34;
        File[] files = this.mDropBoxDir.listFiles();     // Catch: Throwable -> L12
        if (files == null) goto L33;
        this.mAllFiles = new FileList(null);     // Catch: Throwable -> L12
        this.mFilesByTag = new ArrayMap();     // Catch: Throwable -> L12
        int r1 = files.length;     // Catch: Throwable -> L12
        int r2 = 0;
    L24:
        if (r2 >= r1) goto L34;
        File file = files[r2];     // Catch: Throwable -> L12
        if (file.getName().endsWith(".tmp") == false) goto L28;
        Slog.i(TAG, "Cleaning temp file: " + file);     // Catch: Throwable -> L12
        file.delete();     // Catch: Throwable -> L12
    L31:
        r2 = r2 + 1;     // Catch: Throwable -> L12
        goto L24
    L28:
        EntryFile entry = new EntryFile(file, this.mBlockSize);     // Catch: Throwable -> L12
        if (entry.hasFile() == false) goto L31;
        enrollEntry(entry);     // Catch: Throwable -> L12
        goto L31
    L33:
        throw new IOException("Can't list files: " + this.mDropBoxDir);     // Catch: Throwable -> L12
    L34:
        monitor-exit(this);
    }

    private synchronized void enrollEntry(EntryFile entry) {
        monitor-enter(this);
        this.mAllFiles.contents.add(entry);     // Catch: Throwable -> L10
        this.mAllFiles.blocks += entry.blocks;     // Catch: Throwable -> L10
        if (entry.hasFile() == true) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (entry.blocks <= 0) goto L13;
        FileList tagFiles = this.mFilesByTag.get(entry.tag);     // Catch: Throwable -> L10
        if (tagFiles != null) goto L12;
        tagFiles = new FileList(null);     // Catch: Throwable -> L10
        this.mFilesByTag.put(TextUtils.safeIntern(entry.tag), tagFiles);     // Catch: Throwable -> L10
    L12:
        tagFiles.contents.add(entry);     // Catch: Throwable -> L10
        tagFiles.blocks += entry.blocks;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized long createEntry(File temp, String tag, int flags) throws IOException {
        monitor-enter(this);
        long t = System.currentTimeMillis();     // Catch: Throwable -> L7
        SortedSet<EntryFile> tail = this.mAllFiles.contents.tailSet(new EntryFile(JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY + t));     // Catch: Throwable -> L7
        EntryFile[] future = null;
        if (tail.isEmpty() == true) goto L9;
        future = (EntryFile[]) tail.toArray(new EntryFile[tail.size()]);     // Catch: Throwable -> L7
        tail.clear();     // Catch: Throwable -> L7
    L9:
        long r6 = 1;
        if (this.mAllFiles.contents.isEmpty() == true) goto L12;
        t = Math.max(t, this.mAllFiles.contents.last().timestampMillis + 1);     // Catch: Throwable -> L7
    L12:
        if (future == null) goto L26;
        int r5 = future.length;     // Catch: Throwable -> L7
        int r8 = 0;
        long t2 = t;
    L14:
        if (r8 >= r5) goto L25;
        EntryFile late = future[r8];     // Catch: Throwable -> L7
        this.mAllFiles.blocks -= late.blocks;     // Catch: Throwable -> L7
        FileList tagFiles = this.mFilesByTag.get(late.tag);     // Catch: Throwable -> L7
        if (tagFiles == null) goto L21;
        if (tagFiles.contents.remove(late) == false) goto L21;
        tagFiles.blocks -= late.blocks;     // Catch: Throwable -> L7
    L21:
        if ((late.flags & 1) != 0) goto L23;
        long r19 = r6;
        enrollEntry(new EntryFile(late.getFile(this.mDropBoxDir), this.mDropBoxDir, late.tag, t2, late.flags, this.mBlockSize));     // Catch: Throwable -> L7
        t2 = t2 + r6;     // Catch: Throwable -> L7
    L24:
        r8 = r8 + 1;     // Catch: Throwable -> L7
        r6 = r19;
        goto L14
    L23:
        r19 = r6;
        enrollEntry(new EntryFile(this.mDropBoxDir, late.tag, t2));     // Catch: Throwable -> L7
        t2 = t2 + r19;     // Catch: Throwable -> L7
        goto L24
    L25:
        long t3 = t2;
    L27:
        if (temp != null) goto L29;
        enrollEntry(new EntryFile(this.mDropBoxDir, tag, t3));     // Catch: Throwable -> L7
    L30:
        monitor-exit(this);
        return t3;
    L29:
        enrollEntry(new EntryFile(temp, this.mDropBoxDir, tag, t3, flags, this.mBlockSize));     // Catch: Throwable -> L7
        goto L30
    L26:
        t3 = t;
    L7:
        th = move-exception;
        throw th;
    }

    private synchronized long trimToFit() throws IOException {
        monitor-enter(this);
        int ageSeconds = Settings.Global.getInt(this.mContentResolver, "dropbox_age_seconds", DEFAULT_AGE_SECONDS);     // Catch: Throwable -> L16
        ContentResolver r0 = this.mContentResolver;     // Catch: Throwable -> L16
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L7;
        int r4 = 300;
    L8:
        this.mMaxFiles = Settings.Global.getInt(r0, "dropbox_max_files", r4);     // Catch: Throwable -> L16
        long curTimeMillis = System.currentTimeMillis();     // Catch: Throwable -> L16
        long cutoffMillis = curTimeMillis - ((long) (ageSeconds * 1000));     // Catch: Throwable -> L16
    L10:
        if (this.mAllFiles.contents.isEmpty() == true) goto L27;
        EntryFile entry = this.mAllFiles.contents.first();     // Catch: Throwable -> L16
        if (entry.timestampMillis > cutoffMillis) goto L14;
    L18:
        logDropboxDropped(4, entry.tag, curTimeMillis - entry.timestampMillis);     // Catch: Throwable -> L16
        FileList tag = this.mFilesByTag.get(entry.tag);     // Catch: Throwable -> L16
        if (tag == null) goto L24;
        if (tag.contents.remove(entry) == false) goto L24;
        tag.blocks -= entry.blocks;     // Catch: Throwable -> L16
    L24:
        if (this.mAllFiles.contents.remove(entry) == false) goto L26;
        this.mAllFiles.blocks -= entry.blocks;     // Catch: Throwable -> L16
    L26:
        entry.deleteFile(this.mDropBoxDir);     // Catch: Throwable -> L16
        goto L10
    L14:
        if (this.mAllFiles.contents.size() >= this.mMaxFiles) goto L18;
    L27:
        long uptimeMillis = SystemClock.uptimeMillis();     // Catch: Throwable -> L16
        if (uptimeMillis <= (this.mCachedQuotaUptimeMillis + 5000)) goto L38;
        int quotaPercent = Settings.Global.getInt(this.mContentResolver, "dropbox_quota_percent", 10);     // Catch: Throwable -> L16
        int reservePercent = Settings.Global.getInt(this.mContentResolver, "dropbox_reserve_percent", 0);     // Catch: Throwable -> L16
        int quotaKb = Settings.Global.getInt(this.mContentResolver, "dropbox_quota_kb", DEFAULT_QUOTA_KB);     // Catch: Throwable -> L16
        String dirPath = this.mDropBoxDir.getPath();     // Catch: Throwable -> L16
        this.mStatFs.restat(dirPath);     // Catch: Throwable -> L16 IllegalArgumentException -> L33
        long available = this.mStatFs.getAvailableBlocksLong();     // Catch: Throwable -> L16
        long nonreserved = available - ((this.mStatFs.getBlockCountLong() * ((long) reservePercent)) / 100);     // Catch: Throwable -> L16
        long maxAvailableLong = (((long) quotaPercent) * nonreserved) / 100;     // Catch: Throwable -> L16
        int maxAvailable = Math.toIntExact(Math.max(0, Math.min(maxAvailableLong, 2147483647L)));     // Catch: Throwable -> L16
        int maximum = (quotaKb * 1024) / this.mBlockSize;     // Catch: Throwable -> L16
        this.mCachedQuotaBlocks = Math.min(maximum, maxAvailable);     // Catch: Throwable -> L16
        this.mCachedQuotaUptimeMillis = uptimeMillis;     // Catch: Throwable -> L16
        goto L38
    L35:
        throw new IOException("Can't restat: " + this.mDropBoxDir);     // Catch: Throwable -> L16
    L38:
        if (this.mAllFiles.blocks <= this.mCachedQuotaBlocks) goto L71;
        int unsqueezed = this.mAllFiles.blocks;     // Catch: Throwable -> L16
        TreeSet<FileList> tags = new TreeSet(this.mFilesByTag.values());     // Catch: Throwable -> L16
        Iterator<FileList> r5 = tags.iterator();     // Catch: Throwable -> L16
        int squeezed = 0;
        int squeezed2 = unsqueezed;
    L41:
        if (r5.hasNext() == false) goto L48;
        FileList tag2 = r5.next();     // Catch: Throwable -> L16
        if (squeezed <= 0) goto L47;
        if (tag2.blocks <= ((this.mCachedQuotaBlocks - squeezed2) / squeezed)) goto L48;
    L47:
        squeezed2 = squeezed2 - tag2.blocks;     // Catch: Throwable -> L16
        squeezed = squeezed + 1;     // Catch: Throwable -> L16
    L48:
        int tagQuota = (this.mCachedQuotaBlocks - squeezed2) / squeezed;     // Catch: Throwable -> L16
        Iterator<FileList> r6 = tags.iterator();     // Catch: Throwable -> L16
    L50:
        if (r6.hasNext() == false) goto L71;
        FileList tag3 = r6.next();     // Catch: Throwable -> L16
        if (this.mAllFiles.blocks < this.mCachedQuotaBlocks) goto L71;
    L55:
        if (tag3.blocks <= tagQuota) goto L50;
        if (tag3.contents.isEmpty() == true) goto L50;
        EntryFile entry2 = tag3.contents.first();     // Catch: Throwable -> L16
        logDropboxDropped(3, entry2.tag, curTimeMillis - entry2.timestampMillis);     // Catch: Throwable -> L16
        if (tag3.contents.remove(entry2) == false) goto L62;
        tag3.blocks -= entry2.blocks;     // Catch: Throwable -> L16
    L62:
        if (this.mAllFiles.contents.remove(entry2) == false) goto L76;
        this.mAllFiles.blocks -= entry2.blocks;     // Catch: Throwable -> L16
    L76:
        entry2.deleteFile(this.mDropBoxDir);     // Catch: Throwable -> L16 IOException -> L66
        enrollEntry(new EntryFile(this.mDropBoxDir, entry2.tag, entry2.timestampMillis));     // Catch: Throwable -> L16 IOException -> L66
    L66:
        e = move-exception;
        Slog.e(TAG, "Can't write tombstone file", e);     // Catch: Throwable -> L16
    L71:
        long r2 = this.mCachedQuotaBlocks * this.mBlockSize;
        monitor-exit(this);
        return r2;
    L7:
        r4 = 1000;
    L16:
        th = move-exception;
        throw th;
    }

    private void getLowPriorityResourceConfigs() {
        this.mLowPriorityRateLimitPeriod = Resources.getSystem().getInteger(R.integer.config_fixedRefreshRateInHighZone);
        String[] lowPrioritytags = Resources.getSystem().getStringArray(R.array.config_gnssParameters);
        int size = lowPrioritytags.length;
        if (size != 0) goto L6;
        this.mLowPriorityTags = null;
        return;
    L6:
        this.mLowPriorityTags = new ArraySet(size);
        int i = 0;
    L7:
        if (i >= size) goto L10;
        this.mLowPriorityTags.add(lowPrioritytags[i]);
        i = i + 1;
        goto L7
    }
}
