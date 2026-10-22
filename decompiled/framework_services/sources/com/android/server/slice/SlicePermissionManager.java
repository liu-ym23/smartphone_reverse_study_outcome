package com.android.server.slice;

import android.content.ContentProvider;
import android.content.Context;
import android.content.pm.parsing.FrameworkParsingPackageUtils;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Log;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes3.dex */
public class SlicePermissionManager implements DirtyTracker {
    static final int DB_VERSION = 2;
    private static final long PERMISSION_CACHE_PERIOD = 300000;
    private static final String SLICE_DIR = "slice";
    private static final String TAG = "SlicePermissionManager";
    private static final String TAG_LIST = "slice-access-list";
    private static final long WRITE_GRACE_PERIOD = 500;
    private final String ATT_VERSION;
    private final ArrayMap<PkgUser, SliceClientPermissions> mCachedClients;
    private final ArrayMap<PkgUser, SliceProviderPermissions> mCachedProviders;
    private final Context mContext;
    private final ArraySet<DirtyTracker.Persistable> mDirty;
    private final Handler mHandler;
    private final File mSliceDir;

    private final class H extends Handler {
        private static final int MSG_ADD_DIRTY = 1;
        private static final int MSG_CLEAR_CLIENT = 4;
        private static final int MSG_CLEAR_PROVIDER = 5;
        private static final int MSG_PERSIST = 2;
        private static final int MSG_REMOVE = 3;
        final /* synthetic */ SlicePermissionManager this$0;

        public H(SlicePermissionManager r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L13;
                case 5: goto L5;
                default: goto L41;
            };
        L5:
            ArrayMap r0 = SlicePermissionManager.m8158$$Nest$fgetmCachedProviders(this.this$0);
            monitor-enter(r0);
            SlicePermissionManager.m8158$$Nest$fgetmCachedProviders(this.this$0).remove(msg.obj);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            ArrayMap r1 = SlicePermissionManager.m8157$$Nest$fgetmCachedClients(this.this$0);
            monitor-enter(r1);
            SlicePermissionManager.m8157$$Nest$fgetmCachedClients(this.this$0).remove(msg.obj);     // Catch: Throwable -> L18
            monitor-exit(r1);     // Catch: Throwable -> L18
            return;
        L18:
            th = move-exception;
            throw th;
        L21:
            SlicePermissionManager.m8160$$Nest$mhandleRemove(this.this$0, (PkgUser) msg.obj);
            return;
        L22:
            this.this$0.handlePersist();
            return;
        L23:
            SlicePermissionManager r2 = this.this$0;
            monitor-enter(r2);
            SlicePermissionManager.m8159$$Nest$fgetmDirty(this.this$0).add((DirtyTracker.Persistable) msg.obj);     // Catch: Throwable -> L28
            monitor-exit(r2);     // Catch: Throwable -> L28
            return;
        L28:
            th = move-exception;
            throw th;
        }
    }

    private class ParserHolder implements AutoCloseable {
        private InputStream input;
        private XmlPullParser parser;

        /* JADX INFO: renamed from: -$$Nest$fgetinput, reason: not valid java name */
        static /* bridge */ /* synthetic */ InputStream m8161$$Nest$fgetinput(ParserHolder r0) {
            return r0.input;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetparser, reason: not valid java name */
        static /* bridge */ /* synthetic */ XmlPullParser m8162$$Nest$fgetparser(ParserHolder r0) {
            return r0.parser;
        }

        /* JADX INFO: renamed from: -$$Nest$fputinput, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8163$$Nest$fputinput(ParserHolder r0, InputStream r1) {
            r0.input = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputparser, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8164$$Nest$fputparser(ParserHolder r0, XmlPullParser r1) {
            r0.parser = r1;
        }

        /* synthetic */ ParserHolder(SlicePermissionManager r1, SlicePermissionManagerIA r2) {
            this(r1);
        }

        private ParserHolder(SlicePermissionManager r1) {
        }

        @Override // java.lang.AutoCloseable
        public void close() throws IOException {
            this.input.close();
        }
    }

    public static class PkgUser {
        private static final String FORMAT = "%s@%d";
        private static final String SEPARATOR = "@";
        private final String mPkg;
        private final int mUserId;

        /* JADX INFO: renamed from: -$$Nest$fgetmPkg, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8165$$Nest$fgetmPkg(PkgUser r0) {
            return r0.mPkg;
        }

        public PkgUser(String pkg, int userId) {
            this.mPkg = pkg;
            this.mUserId = userId;
            enforceValidPackage();
        }

        public PkgUser(String pkgUserStr) throws IllegalArgumentException {
            String[] vals = pkgUserStr.split(SEPARATOR, 2);     // Catch: Exception -> L6
            this.mPkg = vals[0];     // Catch: Exception -> L6
            this.mUserId = Integer.parseInt(vals[1]);     // Catch: Exception -> L6
            enforceValidPackage();
            return;
        L6:
            e = move-exception;
            throw new IllegalArgumentException(e);
        }

        private void enforceValidPackage() {
            String error = FrameworkParsingPackageUtils.validateName(this.mPkg, false, true);
            if (TextUtils.isEmpty(error) == false) goto L6;
            return;
        L6:
            throw new IllegalArgumentException(error);
        }

        public String getPkg() {
            return this.mPkg;
        }

        public int getUserId() {
            return this.mUserId;
        }

        public int hashCode() {
            return this.mPkg.hashCode() + this.mUserId;
        }

        public boolean equals(Object obj) {
            Class<?> r0 = getClass();
            if (obj == null) goto L5;
            Class<?> r1 = obj.getClass();
        L7:
            if (r0.equals(r1) == true) goto L9;
            return false;
        L9:
            PkgUser other = (PkgUser) obj;
            if (Objects.equals(other.mPkg, this.mPkg) == true) goto L12;
            return false;
        L12:
            if (other.mUserId != this.mUserId) goto L16;
            return true;
        L16:
            return false;
        L5:
            r1 = null;
            goto L7
        }

        public String toString() {
            return String.format(FORMAT, new Object[]{this.mPkg, Integer.valueOf(this.mUserId)});
        }
    }

    public static /* synthetic */ void $r8$lambda$0PrcidSmrHQOvNa3ac3eiLsWIwU(DirtyTracker.Persistable r0) {
        lambda$writeBackup$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCachedClients, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m8157$$Nest$fgetmCachedClients(SlicePermissionManager r0) {
        return r0.mCachedClients;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCachedProviders, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m8158$$Nest$fgetmCachedProviders(SlicePermissionManager r0) {
        return r0.mCachedProviders;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDirty, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m8159$$Nest$fgetmDirty(SlicePermissionManager r0) {
        return r0.mDirty;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleRemove, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8160$$Nest$mhandleRemove(SlicePermissionManager r0, PkgUser r1) {
        r0.handleRemove(r1);
    }

    SlicePermissionManager(Context context, Looper looper, File sliceDir) {
        this.ATT_VERSION = "version";
        this.mCachedProviders = new ArrayMap();
        this.mCachedClients = new ArrayMap();
        this.mDirty = new ArraySet();
        this.mContext = context;
        this.mHandler = new H(this, looper);
        this.mSliceDir = sliceDir;
    }

    public SlicePermissionManager(Context context, Looper looper) {
        this(context, looper, new File(Environment.getDataDirectory(), "system/slice"));
    }

    public void grantFullAccess(String pkg, int userId) {
        PkgUser pkgUser = new PkgUser(pkg, userId);
        SliceClientPermissions client = getClient(pkgUser);
        client.setHasFullAccess(true);
    }

    public void grantSliceAccess(String pkg, int userId, String providerPkg, int providerUser, Uri uri) {
        PkgUser pkgUser = new PkgUser(pkg, userId);
        PkgUser providerPkgUser = new PkgUser(providerPkg, providerUser);
        SliceClientPermissions client = getClient(pkgUser);
        client.grantUri(uri, providerPkgUser);
        SliceProviderPermissions provider = getProvider(providerPkgUser);
        provider.getOrCreateAuthority(ContentProvider.getUriWithoutUserId(uri).getAuthority()).addPkg(pkgUser);
    }

    public void revokeSliceAccess(String pkg, int userId, String providerPkg, int providerUser, Uri uri) {
        PkgUser pkgUser = new PkgUser(pkg, userId);
        PkgUser providerPkgUser = new PkgUser(providerPkg, providerUser);
        SliceClientPermissions client = getClient(pkgUser);
        client.revokeUri(uri, providerPkgUser);
    }

    public void removePkg(String pkg, int userId) {
        PkgUser pkgUser = new PkgUser(pkg, userId);
        SliceProviderPermissions provider = getProvider(pkgUser);
        Iterator<SliceProviderPermissions.SliceAuthority> r2 = provider.getAuthorities().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        SliceProviderPermissions.SliceAuthority authority = r2.next();
        Iterator<PkgUser> r4 = authority.getPkgs().iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        PkgUser p = r4.next();
        getClient(p).removeAuthority(authority.getAuthority(), userId);
        goto L7
    L10:
        SliceClientPermissions client = getClient(pkgUser);
        client.clear();
        this.mHandler.obtainMessage(3, pkgUser).sendToTarget();
    }

    public String[] getAllPackagesGranted(String pkg) {
        ArraySet<String> ret = new ArraySet();
        Iterator<SliceProviderPermissions.SliceAuthority> r1 = getProvider(new PkgUser(pkg, 0)).getAuthorities().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        SliceProviderPermissions.SliceAuthority authority = r1.next();
        Iterator<PkgUser> r3 = authority.getPkgs().iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        PkgUser pkgUser = r3.next();
        ret.add(PkgUser.m8165$$Nest$fgetmPkg(pkgUser));
        goto L7
    L11:
        return (String[]) ret.toArray(new String[ret.size()]);
    }

    public boolean hasFullAccess(String pkg, int userId) {
        PkgUser pkgUser = new PkgUser(pkg, userId);
        return getClient(pkgUser).hasFullAccess();
    }

    public boolean hasPermission(String pkg, int userId, Uri uri) {
        PkgUser pkgUser = new PkgUser(pkg, userId);
        SliceClientPermissions client = getClient(pkgUser);
        int providerUserId = ContentProvider.getUserIdFromUri(uri, userId);
        if (client.hasFullAccess() == false) goto L5;
    L8:
        return true;
    L5:
        if (client.hasPermission(ContentProvider.getUriWithoutUserId(uri), providerUserId) == true) goto L8;
        return false;
    }

    @Override // com.android.server.slice.DirtyTracker
    public void onPersistableDirty(DirtyTracker.Persistable obj) {
        this.mHandler.removeMessages(2);
        this.mHandler.obtainMessage(1, obj).sendToTarget();
        this.mHandler.sendEmptyMessageDelayed(2, 500);
    }

    public void writeBackup(XmlSerializer out) throws IOException, XmlPullParserException {
        monitor-enter(this);
        out.startTag(null, TAG_LIST);     // Catch: Throwable -> L6
        out.attribute(null, "version", String.valueOf(2));     // Catch: Throwable -> L6
        DirtyTracker tracker = new SlicePermissionManager$$ExternalSyntheticLambda0();     // Catch: Throwable -> L6
        if (this.mHandler.hasMessages(2) == false) goto L8;
        this.mHandler.removeMessages(2);     // Catch: Throwable -> L6
        handlePersist();     // Catch: Throwable -> L6
    L8:
        String[] r3 = new File(this.mSliceDir.getAbsolutePath()).list();     // Catch: Throwable -> L6
        int r4 = r3.length;     // Catch: Throwable -> L6
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L36;
        String file = r3[r5];     // Catch: Throwable -> L6
        ParserHolder parser = getParser(file);     // Catch: Throwable -> L6
        DirtyTracker.Persistable p = null;
    L43:
        if (ParserHolder.m8162$$Nest$fgetparser(parser).getEventType() == 1) goto L23;
        if (ParserHolder.m8162$$Nest$fgetparser(parser).getEventType() == 2) goto L17;
        ParserHolder.m8162$$Nest$fgetparser(parser).next();     // Catch: Throwable -> L19
        goto L43
    L17:
        if ("client".equals(ParserHolder.m8162$$Nest$fgetparser(parser).getName()) == false) goto L21;
        p = SliceClientPermissions.createFrom(ParserHolder.m8162$$Nest$fgetparser(parser), tracker);     // Catch: Throwable -> L19
        goto L23
    L21:
        p = SliceProviderPermissions.createFrom(ParserHolder.m8162$$Nest$fgetparser(parser), tracker);     // Catch: Throwable -> L19
    L23:
        if (p == null) goto L25;
        p.writeTo(out);     // Catch: Throwable -> L19
    L26:
        if (parser == null) goto L28;
        parser.close();     // Catch: Throwable -> L6
    L28:
        r5 = r5 + 1;
        goto L9
    L25:
        Slog.w(TAG, "Invalid or empty slice permissions file: " + file);     // Catch: Throwable -> L19
        goto L26
    L19:
        th = move-exception;
        if (parser != null) goto L41;
    L35:
        throw th;     // Catch: Throwable -> L6
    L41:
        parser.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L6
        goto L35
    L36:
        out.endTag(null, TAG_LIST);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$writeBackup$0(DirtyTracker.Persistable obj) {
    }

    public void readRestore(XmlPullParser parser) throws IOException, XmlPullParserException {
        monitor-enter(this);
    L54:
    L8:
        th = move-exception;
        throw th;
    L4:
        if (parser.getEventType() != 2) goto L11;
        if (TAG_LIST.equals(parser.getName()) == false) goto L11;
    L13:
        int xmlVersion = XmlUtils.readIntAttribute(parser, "version", 0);     // Catch: Throwable -> L8
        if (xmlVersion >= 2) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L18:
        if (parser.getEventType() == 1) goto L46;
        if (parser.getEventType() == 2) goto L22;
        parser.next();     // Catch: Throwable -> L8
        goto L18
    L22:
        if ("client".equals(parser.getName()) == true) goto L23;
        if ("provider".equals(parser.getName()) == true) goto L34;
        parser.next();     // Catch: Throwable -> L8
        goto L18
    L34:
        SliceProviderPermissions provider = SliceProviderPermissions.createFrom(parser, this);     // Catch: Throwable -> L8
        ArrayMap<PkgUser, SliceProviderPermissions> r6 = this.mCachedProviders;     // Catch: Throwable -> L8
        monitor-enter(r6);     // Catch: Throwable -> L8
        this.mCachedProviders.put(provider.getPkg(), provider);     // Catch: Throwable -> L40
        monitor-exit(r6);     // Catch: Throwable -> L40
        onPersistableDirty(provider);     // Catch: Throwable -> L8
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(5, provider.getPkg()), 300000);     // Catch: Throwable -> L8
        goto L18
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L23:
        SliceClientPermissions client = SliceClientPermissions.createFrom(parser, this);     // Catch: Throwable -> L8
        ArrayMap<PkgUser, SliceClientPermissions> r7 = this.mCachedClients;     // Catch: Throwable -> L8
        monitor-enter(r7);     // Catch: Throwable -> L8
        this.mCachedClients.put(client.getPkg(), client);     // Catch: Throwable -> L29
        monitor-exit(r7);     // Catch: Throwable -> L29
        onPersistableDirty(client);     // Catch: Throwable -> L8
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(4, client.getPkg()), 300000);     // Catch: Throwable -> L8
        goto L18
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L46:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L11:
        if (parser.getEventType() == 1) goto L13;
        parser.next();     // Catch: Throwable -> L8
        goto L54
    }

    private SliceClientPermissions getClient(PkgUser pkgUser) {
        ArrayMap<PkgUser, SliceClientPermissions> r0 = this.mCachedClients;
        monitor-enter(r0);
        SliceClientPermissions client = this.mCachedClients.get(pkgUser);     // Catch: Throwable -> L47
        monitor-exit(r0);     // Catch: Throwable -> L47
        if (client == null) goto L59;
        return client;
    L59:
        ParserHolder parser = getParser(SliceClientPermissions.getFileName(pkgUser));     // Catch: XmlPullParserException -> L16 IOException -> L18 FileNotFoundException -> L20
        SliceClientPermissions client2 = SliceClientPermissions.createFrom(ParserHolder.m8162$$Nest$fgetparser(parser), this);     // Catch: Throwable -> L23
        ArrayMap<PkgUser, SliceClientPermissions> r2 = this.mCachedClients;     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        this.mCachedClients.put(pkgUser, client2);     // Catch: Throwable -> L25
        monitor-exit(r2);     // Catch: Throwable -> L25
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(4, pkgUser), 300000);     // Catch: Throwable -> L23
        if (parser == null) goto L22;
        parser.close();     // Catch: XmlPullParserException -> L16 IOException -> L18 FileNotFoundException -> L20
    L22:
        return client2;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (parser != null) goto L50;
    L34:
        throw th;     // Catch: XmlPullParserException -> L16 IOException -> L18 FileNotFoundException -> L20
    L50:
        parser.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: XmlPullParserException -> L16 IOException -> L18 FileNotFoundException -> L20
    L18:
        e = move-exception;
        Log.e(TAG, "Can't read client", e);
    L16:
        e = move-exception;
        Log.e(TAG, "Can't read client", e);
    L38:
        SliceClientPermissions client3 = new SliceClientPermissions(pkgUser, this);
        ArrayMap<PkgUser, SliceClientPermissions> r3 = this.mCachedClients;
        monitor-enter(r3);
        this.mCachedClients.put(pkgUser, client3);     // Catch: Throwable -> L43
        monitor-exit(r3);     // Catch: Throwable -> L43
        return client3;
    L43:
        th = move-exception;
        throw th;
    L47:
        th = move-exception;
        throw th;
    }

    private SliceProviderPermissions getProvider(PkgUser pkgUser) {
        ArrayMap<PkgUser, SliceProviderPermissions> r0 = this.mCachedProviders;
        monitor-enter(r0);
        SliceProviderPermissions provider = this.mCachedProviders.get(pkgUser);     // Catch: Throwable -> L47
        monitor-exit(r0);     // Catch: Throwable -> L47
        if (provider == null) goto L59;
        return provider;
    L59:
        ParserHolder parser = getParser(SliceProviderPermissions.getFileName(pkgUser));     // Catch: XmlPullParserException -> L16 IOException -> L18 FileNotFoundException -> L20
        SliceProviderPermissions provider2 = SliceProviderPermissions.createFrom(ParserHolder.m8162$$Nest$fgetparser(parser), this);     // Catch: Throwable -> L23
        ArrayMap<PkgUser, SliceProviderPermissions> r2 = this.mCachedProviders;     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        this.mCachedProviders.put(pkgUser, provider2);     // Catch: Throwable -> L25
        monitor-exit(r2);     // Catch: Throwable -> L25
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(5, pkgUser), 300000);     // Catch: Throwable -> L23
        if (parser == null) goto L22;
        parser.close();     // Catch: XmlPullParserException -> L16 IOException -> L18 FileNotFoundException -> L20
    L22:
        return provider2;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (parser != null) goto L50;
    L34:
        throw th;     // Catch: XmlPullParserException -> L16 IOException -> L18 FileNotFoundException -> L20
    L50:
        parser.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: XmlPullParserException -> L16 IOException -> L18 FileNotFoundException -> L20
    L18:
        e = move-exception;
        Log.e(TAG, "Can't read provider", e);
    L16:
        e = move-exception;
        Log.e(TAG, "Can't read provider", e);
    L38:
        SliceProviderPermissions provider3 = new SliceProviderPermissions(pkgUser, this);
        ArrayMap<PkgUser, SliceProviderPermissions> r3 = this.mCachedProviders;
        monitor-enter(r3);
        this.mCachedProviders.put(pkgUser, provider3);     // Catch: Throwable -> L43
        monitor-exit(r3);     // Catch: Throwable -> L43
        return provider3;
    L43:
        th = move-exception;
        throw th;
    L47:
        th = move-exception;
        throw th;
    }

    private ParserHolder getParser(String fileName) throws FileNotFoundException, XmlPullParserException {
        AtomicFile file = getFile(fileName);
        ParserHolder holder = new ParserHolder(this, null);
        ParserHolder.m8163$$Nest$fputinput(holder, file.openRead());
        ParserHolder.m8164$$Nest$fputparser(holder, XmlPullParserFactory.newInstance().newPullParser());
        ParserHolder.m8162$$Nest$fgetparser(holder).setInput(ParserHolder.m8161$$Nest$fgetinput(holder), Xml.Encoding.UTF_8.name());
        return holder;
    }

    private AtomicFile getFile(String fileName) {
        if (this.mSliceDir.exists() == true) goto L6;
        this.mSliceDir.mkdir();
    L6:
        return new AtomicFile(new File(this.mSliceDir, fileName));
    }

    void handlePersist() {
        monitor-enter(this);
        Iterator<DirtyTracker.Persistable> r0 = this.mDirty.iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L19;
        DirtyTracker.Persistable persistable = r0.next();     // Catch: Throwable -> L10
        AtomicFile file = getFile(persistable.getFileName());     // Catch: Throwable -> L10
        FileOutputStream stream = file.startWrite();     // Catch: Throwable -> L10 IOException -> L15
    L26:
        XmlSerializer out = XmlPullParserFactory.newInstance().newSerializer();     // Catch: Throwable -> L10 Throwable -> L12
        out.setOutput(stream, Xml.Encoding.UTF_8.name());     // Catch: Throwable -> L10 Throwable -> L12
        persistable.writeTo(out);     // Catch: Throwable -> L10 Throwable -> L12
        out.flush();     // Catch: Throwable -> L10 Throwable -> L12
        file.finishWrite(stream);     // Catch: Throwable -> L10 Throwable -> L12
    L12:
        e = move-exception;
        Slog.w(TAG, "Failed to save access file, restoring backup", e);     // Catch: Throwable -> L10
        file.failWrite(stream);     // Catch: Throwable -> L10
    L15:
        e = move-exception;
        Slog.w(TAG, "Failed to save access file", e);     // Catch: Throwable -> L10
        return;
    L19:
        this.mDirty.clear();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void addDirtyImmediate(DirtyTracker.Persistable obj) {
        monitor-enter(this);
        this.mDirty.add(obj);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void handleRemove(PkgUser pkgUser) {
        getFile(SliceClientPermissions.getFileName(pkgUser)).delete();
        getFile(SliceProviderPermissions.getFileName(pkgUser)).delete();
        monitor-enter(this);
        ArrayMap<PkgUser, SliceClientPermissions> r0 = this.mCachedClients;     // Catch: Throwable -> L14
        monitor-enter(r0);     // Catch: Throwable -> L14
        this.mDirty.remove(this.mCachedClients.remove(pkgUser));     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        ArrayMap<PkgUser, SliceProviderPermissions> r1 = this.mCachedProviders;     // Catch: Throwable -> L14
        monitor-enter(r1);     // Catch: Throwable -> L14
        this.mDirty.remove(this.mCachedProviders.remove(pkgUser));     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
