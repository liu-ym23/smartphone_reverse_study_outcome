package com.android.server.os;

import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.IDumpstate;
import android.os.IDumpstateListener;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.LocalLog;
import android.util.MutableBoolean;
import android.util.Pair;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.SystemConfig;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.Slogf;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class BugreportManagerServiceImpl extends IDumpstate.Stub {
    private static final String ATTR_BUGREPORT_FILE = "bugreport-file";
    private static final String ATTR_CALLING_PACKAGE = "calling-package";
    private static final String ATTR_CALLING_UID = "calling-uid";
    private static final String BUGREPORT_SERVICE = "bugreportd";
    private static final boolean DEBUG = false;
    private static final long DEFAULT_BUGREPORT_CONSENTLESS_GRACE_PERIOD_MILLIS = 0;
    private static final long DEFAULT_BUGREPORT_SERVICE_TIMEOUT_MILLIS = 30000;
    private static final int LOCAL_LOG_SIZE = 20;
    private static final String ROLE_SYSTEM_AUTOMOTIVE_PROJECTION = "android.app.role.SYSTEM_AUTOMOTIVE_PROJECTION";
    private static final String TAG = "BugreportManagerService";
    private static final String TAG_BUGREPORT_DATA = "bugreport-data";
    private static final String TAG_BUGREPORT_MAP = "bugreport-map";
    private static final String TAG_PERSISTENT_BUGREPORT = "persistent-bugreport";
    private static final FeatureFlags sFeatureFlags = null;
    private final AppOpsManager mAppOps;
    private final ArraySet<String> mBugreportAllowlistedPackages;
    private final BugreportFileManager mBugreportFileManager;
    private final Context mContext;
    private DumpstateListener mCurrentDumpstateListener;
    private final LocalLog mFinishedBugreports;
    private final Injector mInjector;
    private final Object mLock;
    private int mNumberFinishedBugreports;
    private OptionalInt mPreDumpedDataUid;
    private final TelephonyManager mTelephonyManager;

    static class BugreportFileManager {
        private ArrayMap<Pair<Integer, String>, ArraySet<String>> mBugreportFiles;
        final Set<String> mBugreportFilesToPersist;
        private Map<String, Pair<Long, Boolean>> mConsentGranted;
        private final Object mLock;
        private final AtomicFile mMappingFile;
        private boolean mReadBugreportMapping;

        public static /* synthetic */ Integer $r8$lambda$fBfJvKZPDrJ3uT2wI7dWGFbqpgw(PackageManager r0, Pair r1, int r2, String r3) {
            return lambda$ensureCallerPreviouslyGeneratedFile$0(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmBugreportFiles, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m6436$$Nest$fgetmBugreportFiles(BugreportFileManager r0) {
            return r0.mBugreportFiles;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
        static /* bridge */ /* synthetic */ Object m6437$$Nest$fgetmLock(BugreportFileManager r0) {
            return r0.mLock;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmReadBugreportMapping, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6438$$Nest$fgetmReadBugreportMapping(BugreportFileManager r0) {
            return r0.mReadBugreportMapping;
        }

        BugreportFileManager(AtomicFile mappingFile) {
            this.mLock = new Object();
            this.mReadBugreportMapping = false;
            this.mBugreportFiles = new ArrayMap();
            this.mConsentGranted = new HashMap();
            this.mBugreportFilesToPersist = new HashSet();
            this.mMappingFile = mappingFile;
        }

        void ensureCallerPreviouslyGeneratedFile(Context context, final PackageManager packageManager, final Pair<Integer, String> callingInfo, final int userId, final String bugreportFile, boolean forceUpdateMapping) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int uidForUser = ((Integer) Binder.withCleanCallingIdentity(new BugreportManagerServiceImpl$BugreportFileManager$$ExternalSyntheticLambda0(packageManager, callingInfo, userId, bugreportFile))).intValue();     // Catch: Throwable -> L11
            if (uidForUser == ((Integer) callingInfo.first).intValue()) goto L14;
            if (context.checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS") == 0) goto L14;
            throw new SecurityException(((String) callingInfo.second) + " does not hold the INTERACT_ACROSS_USERS permission to access cross-user bugreports.");     // Catch: Throwable -> L11
        L14:
            if (this.mReadBugreportMapping == false) goto L16;
            if (forceUpdateMapping == true) goto L16;
        L17:
            ArraySet<String> bugreportFilesForUid = this.mBugreportFiles.get(new Pair(Integer.valueOf(uidForUser), (String) callingInfo.second));     // Catch: Throwable -> L11
            if (bugreportFilesForUid != null) goto L20;
        L21:
            throwInvalidBugreportFileForCallerException(bugreportFile, (String) callingInfo.second);     // Catch: Throwable -> L11
        L22:
            boolean keepBugreportOnRetrieval = this.mBugreportFilesToPersist.contains(bugreportFile);     // Catch: Throwable -> L11
            if (keepBugreportOnRetrieval == true) goto L26;
            bugreportFilesForUid.remove(bugreportFile);     // Catch: Throwable -> L11
        L26:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L20:
            if (bugreportFilesForUid.contains(bugreportFile) == true) goto L22;
        L16:
            readBugreportMappingLocked();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ Integer lambda$ensureCallerPreviouslyGeneratedFile$0(PackageManager packageManager, Pair callingInfo, int userId, String bugreportFile) throws Exception {
            return Integer.valueOf(packageManager.getPackageUidAsUser((String) callingInfo.second, userId));
        L5:
            throwInvalidBugreportFileForCallerException(bugreportFile, (String) callingInfo.second);
            return -1;
        }

        private static void throwInvalidBugreportFileForCallerException(String bugreportFile, String packageName) {
            throw new IllegalArgumentException("File " + bugreportFile + " was not generated on behalf of calling package " + packageName);
        }

        void addBugreportFileForCaller(Pair<Integer, String> caller, String bugreportFile, boolean keepOnRetrieval) {
            addBugreportMapping(caller, bugreportFile);
            Object r0 = this.mLock;
            monitor-enter(r0);
            if (keepOnRetrieval == true) goto L13;
        L8:
            writeBugreportDataLocked();     // Catch: Throwable -> L6
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        L13:
            this.mBugreportFilesToPersist.add(bugreportFile);     // Catch: Throwable -> L6
            goto L8
        }

        void logConsentGrantedForCaller(String packageName, boolean consentGranted, boolean isDeferredReport) {
            if (Build.IS_DEBUGGABLE == true) goto L5;
            return;
        L5:
            Object r0 = this.mLock;
            monitor-enter(r0);
            if (consentGranted == false) goto L11;
            this.mConsentGranted.put(packageName, new Pair(Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(isDeferredReport)));     // Catch: Throwable -> L9
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            if (isDeferredReport == true) goto L18;
            if (this.mConsentGranted.containsKey(packageName) == true) goto L17;
            Slog.e(BugreportManagerServiceImpl.TAG, "Previous consent from package: " + packageName + " shouldhave been logged.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L17:
            this.mConsentGranted.put(packageName, new Pair((Long) this.mConsentGranted.get(packageName).first, false));     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        boolean canSkipConsentScreen(String packageName, boolean isFullReport) {
            if (Build.IS_DEBUGGABLE == true) goto L5;
            return false;
        L5:
            Object r0 = this.mLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L8:
            if (this.mConsentGranted.containsKey(packageName) == true) goto L13;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return false;
        L13:
            long currentTime = System.currentTimeMillis();     // Catch: Throwable -> L11
            long consentGrantedTime = ((Long) this.mConsentGranted.get(packageName).first).longValue();     // Catch: Throwable -> L11
            if ((BugreportManagerServiceImpl.m6434$$Nest$sfgetDEFAULT_BUGREPORT_CONSENTLESS_GRACE_PERIOD_MILLIS() + consentGrantedTime) >= currentTime) goto L18;
            this.mConsentGranted.remove(packageName);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return false;
        L18:
            boolean skipConsentForFullReport = ((Boolean) this.mConsentGranted.get(packageName).second).booleanValue();     // Catch: Throwable -> L11
            if (isFullReport == false) goto L23;
            if (skipConsentForFullReport == true) goto L23;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return false;
        L23:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return true;
        }

        private void addBugreportMapping(Pair<Integer, String> caller, String bugreportFile) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mBugreportFiles.containsKey(caller) == true) goto L9;
            this.mBugreportFiles.put(caller, new ArraySet());     // Catch: Throwable -> L7
        L9:
            ArraySet<String> bugreportFilesForCaller = this.mBugreportFiles.get(caller);     // Catch: Throwable -> L7
            bugreportFilesForCaller.add(bugreportFile);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        private void readBugreportMappingLocked() {
            this.mBugreportFiles = new ArrayMap();
            InputStream inputStream = this.mMappingFile.openRead();     // Catch: Throwable -> L28 FileNotFoundException -> L30
            TypedXmlPullParser parser = Xml.resolvePullParser(inputStream);     // Catch: Throwable -> L13
            XmlUtils.beginDocument(parser, BugreportManagerServiceImpl.TAG_BUGREPORT_DATA);     // Catch: Throwable -> L13
            int depth = parser.getDepth();     // Catch: Throwable -> L13
        L5:
            byte r5 = 1;
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L24;
            String tag = parser.getName();     // Catch: Throwable -> L13
            switch(tag.hashCode()) {
                case -1731556110: goto L16;
                case 761901751: goto L11;
                default: goto L18;
            };     // Catch: Throwable -> L13
        L18:
            r5 = -1;
        L19:
            switch(r5) {
                case 0: goto L22;
                case 1: goto L21;
                default: goto L20;
            };     // Catch: Throwable -> L13
        L20:
            Slog.e(BugreportManagerServiceImpl.TAG, "Unknown tag while reading bugreport mapping file: " + tag);     // Catch: Throwable -> L13
            goto L5
        L21:
            readPersistentBugreportEntry(parser);     // Catch: Throwable -> L13
            goto L5
        L22:
            readBugreportMapEntry(parser);     // Catch: Throwable -> L13
            goto L5
        L11:
            if (tag.equals(BugreportManagerServiceImpl.TAG_BUGREPORT_MAP) == false) goto L18;
            r5 = 0;
            goto L19
        L16:
            if (tag.equals(BugreportManagerServiceImpl.TAG_PERSISTENT_BUGREPORT) == false) goto L18;
        L24:
            this.mReadBugreportMapping = true;     // Catch: Throwable -> L13
            if (inputStream == null) goto L52;
            inputStream.close();     // Catch: Throwable -> L28 Throwable -> L28 FileNotFoundException -> L30
            return;
        L52:
            return;
        L13:
            th = move-exception;
            if (inputStream != null) goto L46;
        L39:
            throw th;     // Catch: Throwable -> L28 Throwable -> L28 FileNotFoundException -> L30
        L46:
            inputStream.close();     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L28 Throwable -> L28 FileNotFoundException -> L30
            goto L39
        L41:
            Slog.i(BugreportManagerServiceImpl.TAG, "Bugreport mapping file does not exist");
            return;
        L40:
            this.mMappingFile.delete();
        }

        private void writeBugreportDataLocked() {
            if (this.mBugreportFiles.isEmpty() == true) goto L5;
        L38:
            FileOutputStream stream = this.mMappingFile.startWrite();     // Catch: IOException -> L26
            TypedXmlSerializer out = Xml.resolveSerializer(stream);     // Catch: Throwable -> L15
            out.startDocument(null, true);     // Catch: Throwable -> L15
            out.startTag(null, BugreportManagerServiceImpl.TAG_BUGREPORT_DATA);     // Catch: Throwable -> L15
            Iterator<Map.Entry<Pair<Integer, String>, ArraySet<String>>> r3 = this.mBugreportFiles.entrySet().iterator();     // Catch: Throwable -> L15
        L10:
            if (r3.hasNext() == false) goto L18;
            Map.Entry<Pair<Integer, String>, ArraySet<String>> entry = r3.next();     // Catch: Throwable -> L15
            Pair<Integer, String> callingInfo = entry.getKey();     // Catch: Throwable -> L15
            ArraySet<String> callersBugreports = entry.getValue();     // Catch: Throwable -> L15
            Iterator<String> r8 = callersBugreports.iterator();     // Catch: Throwable -> L15
        L13:
            if (r8.hasNext() == false) goto L10;
            String bugreportFile = r8.next();     // Catch: Throwable -> L15
            writeBugreportMapEntry(callingInfo, bugreportFile, out);     // Catch: Throwable -> L15
            goto L13
        L18:
            Iterator<String> r4 = this.mBugreportFilesToPersist.iterator();     // Catch: Throwable -> L15
        L20:
            if (r4.hasNext() == false) goto L22;
            String file = r4.next();     // Catch: Throwable -> L15
            writePersistentBugreportEntry(file, out);     // Catch: Throwable -> L15
            goto L20
        L22:
            out.endTag(null, BugreportManagerServiceImpl.TAG_BUGREPORT_DATA);     // Catch: Throwable -> L15
            out.endDocument();     // Catch: Throwable -> L15
            this.mMappingFile.finishWrite(stream);     // Catch: Throwable -> L15
            if (stream == null) goto L46;
            stream.close();     // Catch: IOException -> L26
            return;
        L46:
            return;
        L15:
            th = move-exception;
            if (stream != null) goto L39;
        L35:
            throw th;     // Catch: IOException -> L26
        L39:
            stream.close();     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L26
        L26:
            e = move-exception;
            Slog.e(BugreportManagerServiceImpl.TAG, "Failed to write bugreport mapping file", e);
            return;
        L5:
            if (this.mBugreportFilesToPersist.isEmpty() == false) goto L38;
        }

        private void readBugreportMapEntry(TypedXmlPullParser parser) throws XmlPullParserException {
            int callingUid = parser.getAttributeInt(null, BugreportManagerServiceImpl.ATTR_CALLING_UID);
            String callingPackage = parser.getAttributeValue(null, BugreportManagerServiceImpl.ATTR_CALLING_PACKAGE);
            String bugreportFile = parser.getAttributeValue(null, BugreportManagerServiceImpl.ATTR_BUGREPORT_FILE);
            addBugreportMapping(new Pair(Integer.valueOf(callingUid), callingPackage), bugreportFile);
        }

        private void readPersistentBugreportEntry(TypedXmlPullParser parser) throws XmlPullParserException {
            String bugreportFile = parser.getAttributeValue(null, BugreportManagerServiceImpl.ATTR_BUGREPORT_FILE);
            Object r1 = this.mLock;
            monitor-enter(r1);
            this.mBugreportFilesToPersist.add(bugreportFile);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void writeBugreportMapEntry(Pair<Integer, String> callingInfo, String bugreportFile, TypedXmlSerializer out) throws IOException {
            out.startTag(null, BugreportManagerServiceImpl.TAG_BUGREPORT_MAP);
            out.attributeInt(null, BugreportManagerServiceImpl.ATTR_CALLING_UID, ((Integer) callingInfo.first).intValue());
            out.attribute(null, BugreportManagerServiceImpl.ATTR_CALLING_PACKAGE, (String) callingInfo.second);
            out.attribute(null, BugreportManagerServiceImpl.ATTR_BUGREPORT_FILE, bugreportFile);
            out.endTag(null, BugreportManagerServiceImpl.TAG_BUGREPORT_MAP);
        }

        private void writePersistentBugreportEntry(String bugreportFile, TypedXmlSerializer out) throws IOException {
            out.startTag(null, BugreportManagerServiceImpl.TAG_PERSISTENT_BUGREPORT);
            out.attribute(null, BugreportManagerServiceImpl.ATTR_BUGREPORT_FILE, bugreportFile);
            out.endTag(null, BugreportManagerServiceImpl.TAG_PERSISTENT_BUGREPORT);
        }
    }

    private final class DumpstateListener extends IDumpstateListener.Stub implements IBinder.DeathRecipient {
        private static int sNextId;
        private final Pair<Integer, String> mCaller;
        private boolean mConsentGranted;
        private boolean mDone;
        private final IDumpstate mDs;
        private final int mId;
        private boolean mIsDeferredReport;
        private boolean mKeepBugreportOnRetrieval;
        private final IDumpstateListener mListener;
        private int mProgress;
        private final boolean mReportFinishedFile;
        final /* synthetic */ BugreportManagerServiceImpl this$0;

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6439$$Nest$mdump(DumpstateListener r0, PrintWriter r1) {
            r0.dump(r1);
        }

        DumpstateListener(BugreportManagerServiceImpl r10, IDumpstateListener listener, IDumpstate ds, Pair<Integer, String> caller, boolean reportFinishedFile, boolean consentGranted, boolean isDeferredReport) {
            this(r10, listener, ds, caller, reportFinishedFile, false, consentGranted, isDeferredReport);
        }

        DumpstateListener(BugreportManagerServiceImpl r3, IDumpstateListener listener, IDumpstate ds, Pair<Integer, String> caller, boolean reportFinishedFile, boolean keepBugreportOnRetrieval, boolean consentGranted, boolean isDeferredReport) {
            this.this$0 = r3;
            int r4 = sNextId + 1;
            sNextId = r4;
            this.mId = r4;
            this.mListener = listener;
            this.mDs = ds;
            this.mCaller = caller;
            this.mReportFinishedFile = reportFinishedFile;
            this.mKeepBugreportOnRetrieval = keepBugreportOnRetrieval;
            this.mConsentGranted = consentGranted;
            this.mIsDeferredReport = isDeferredReport;
            this.mDs.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(BugreportManagerServiceImpl.TAG, "Unable to register Death Recipient for IDumpstate", e);
        }

        @Override // android.os.IDumpstateListener
        public void onProgress(int progress) throws RemoteException {
            this.mProgress = progress;
            this.mListener.onProgress(progress);
        }

        @Override // android.os.IDumpstateListener
        public void onError(int errorCode) throws RemoteException {
            Slogf.e(BugreportManagerServiceImpl.TAG, "onError(): %d", new Object[]{Integer.valueOf(errorCode)});
            Object r0 = BugreportManagerServiceImpl.m6430$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            releaseItselfLocked();     // Catch: Throwable -> L8
            reportFinishedLocked("ErroCode: " + errorCode);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            this.mListener.onError(errorCode);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.os.IDumpstateListener
        public void onFinished(String bugreportFile) throws RemoteException {
            Slogf.i(BugreportManagerServiceImpl.TAG, "onFinished(): %s", new Object[]{bugreportFile});
            Object r0 = BugreportManagerServiceImpl.m6430$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            releaseItselfLocked();     // Catch: Throwable -> L11
            reportFinishedLocked("File: " + bugreportFile);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            if (this.mReportFinishedFile == false) goto L9;
            BugreportManagerServiceImpl.m6427$$Nest$fgetmBugreportFileManager(this.this$0).addBugreportFileForCaller(this.mCaller, bugreportFile, this.mKeepBugreportOnRetrieval);
        L9:
            BugreportManagerServiceImpl.m6427$$Nest$fgetmBugreportFileManager(this.this$0).logConsentGrantedForCaller((String) this.mCaller.second, this.mConsentGranted, this.mIsDeferredReport);
            this.mListener.onFinished(bugreportFile);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // android.os.IDumpstateListener
        public void onScreenshotTaken(boolean success) throws RemoteException {
            this.mListener.onScreenshotTaken(success);
        }

        @Override // android.os.IDumpstateListener
        public void onUiIntensiveBugreportDumpsFinished() throws RemoteException {
            this.mListener.onUiIntensiveBugreportDumpsFinished();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Thread.sleep(1000);     // Catch: InterruptedException -> L5
        L6:
            Object r0 = BugreportManagerServiceImpl.m6430$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.mDone == true) goto L16;
            Slog.e(BugreportManagerServiceImpl.TAG, "IDumpstate likely crashed. Notifying listener");     // Catch: Throwable -> L13
            this.mListener.onError(2);     // Catch: Throwable -> L13 RemoteException -> L15
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L13
            this.mDs.asBinder().unlinkToDeath(this, 0);
        }

        public String toString() {
            return "DumpstateListener[id=" + this.mId + ", progress=" + this.mProgress + "]";
        }

        private void reportFinishedLocked(String message) {
            BugreportManagerServiceImpl r0 = this.this$0;
            BugreportManagerServiceImpl.m6433$$Nest$fputmNumberFinishedBugreports(r0, BugreportManagerServiceImpl.m6431$$Nest$fgetmNumberFinishedBugreports(r0) + 1);
            BugreportManagerServiceImpl.m6429$$Nest$fgetmFinishedBugreports(this.this$0).log("Caller: " + BugreportManagerServiceImpl.m6435$$Nest$smcallerToString(this.mCaller) + " " + message);
        }

        private void dump(PrintWriter pw) {
            pw.println("DumpstateListener:");
            pw.printf("  id: %d\n", new Object[]{Integer.valueOf(this.mId)});
            pw.printf("  caller: %s\n", new Object[]{BugreportManagerServiceImpl.m6435$$Nest$smcallerToString(this.mCaller)});
            pw.printf("  reports finished file: %b\n", new Object[]{Boolean.valueOf(this.mReportFinishedFile)});
            pw.printf("  progress: %d\n", new Object[]{Integer.valueOf(this.mProgress)});
            pw.printf("  done: %b\n", new Object[]{Boolean.valueOf(this.mDone)});
        }

        private void releaseItselfLocked() {
            this.mDone = true;
            if (BugreportManagerServiceImpl.m6428$$Nest$fgetmCurrentDumpstateListener(this.this$0) != this) goto L5;
            BugreportManagerServiceImpl.m6432$$Nest$fputmCurrentDumpstateListener(this.this$0, null);
            return;
        L5:
            Slogf.w(BugreportManagerServiceImpl.TAG, "releaseItselfLocked(): " + this + " is finished, but current listener is " + BugreportManagerServiceImpl.m6428$$Nest$fgetmCurrentDumpstateListener(this.this$0));
        }
    }

    static class Injector {
        ArraySet<String> mAllowlistedPackages;
        Context mContext;
        AtomicFile mMappingFile;
        RoleManagerWrapper mRoleManagerWrapper;

        class RoleManagerWrapper {
            final /* synthetic */ Injector this$0;

            RoleManagerWrapper(Injector this$0) {
                this.this$0 = this$0;
            }

            List<String> getRoleHolders(String roleName) {
                return ((RoleManager) this.this$0.mContext.getSystemService(RoleManager.class)).getRoleHolders(roleName);
            }
        }

        Injector(Context context, ArraySet<String> allowlistedPackages, AtomicFile mappingFile) {
            this.mContext = context;
            this.mAllowlistedPackages = allowlistedPackages;
            this.mMappingFile = mappingFile;
            this.mRoleManagerWrapper = new RoleManagerWrapper(this);
        }

        Context getContext() {
            return this.mContext;
        }

        ArraySet<String> getAllowlistedPackages() {
            return this.mAllowlistedPackages;
        }

        AtomicFile getMappingFile() {
            return this.mMappingFile;
        }

        UserManager getUserManager() {
            return (UserManager) this.mContext.getSystemService(UserManager.class);
        }

        DevicePolicyManager getDevicePolicyManager() {
            return (DevicePolicyManager) this.mContext.getSystemService(DevicePolicyManager.class);
        }

        void setSystemProperty(String key, String value) {
            SystemProperties.set(key, value);
        }

        RoleManagerWrapper getRoleManagerWrapper() {
            return this.mRoleManagerWrapper;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBugreportFileManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ BugreportFileManager m6427$$Nest$fgetmBugreportFileManager(BugreportManagerServiceImpl r0) {
        return r0.mBugreportFileManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentDumpstateListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ DumpstateListener m6428$$Nest$fgetmCurrentDumpstateListener(BugreportManagerServiceImpl r0) {
        return r0.mCurrentDumpstateListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFinishedBugreports, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocalLog m6429$$Nest$fgetmFinishedBugreports(BugreportManagerServiceImpl r0) {
        return r0.mFinishedBugreports;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6430$$Nest$fgetmLock(BugreportManagerServiceImpl r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNumberFinishedBugreports, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6431$$Nest$fgetmNumberFinishedBugreports(BugreportManagerServiceImpl r0) {
        return r0.mNumberFinishedBugreports;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentDumpstateListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6432$$Nest$fputmCurrentDumpstateListener(BugreportManagerServiceImpl r0, DumpstateListener r1) {
        r0.mCurrentDumpstateListener = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNumberFinishedBugreports, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6433$$Nest$fputmNumberFinishedBugreports(BugreportManagerServiceImpl r0, int r1) {
        r0.mNumberFinishedBugreports = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEFAULT_BUGREPORT_CONSENTLESS_GRACE_PERIOD_MILLIS, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6434$$Nest$sfgetDEFAULT_BUGREPORT_CONSENTLESS_GRACE_PERIOD_MILLIS() {
        return DEFAULT_BUGREPORT_CONSENTLESS_GRACE_PERIOD_MILLIS;
    }

    /* JADX INFO: renamed from: -$$Nest$smcallerToString, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6435$$Nest$smcallerToString(Pair r0) {
        return callerToString(r0);
    }

    static {
        DEFAULT_BUGREPORT_CONSENTLESS_GRACE_PERIOD_MILLIS = TimeUnit.MINUTES.toMillis(2);
        sFeatureFlags = new FeatureFlagsImpl();
    }

    BugreportManagerServiceImpl(Context context) {
        this(new Injector(context, SystemConfig.getInstance().getBugreportWhitelistedPackages(), new AtomicFile(new File(new File(Environment.getDataDirectory(), "system"), "bugreport-mapping.xml"))));
    }

    BugreportManagerServiceImpl(Injector injector) {
        this.mLock = new Object();
        this.mPreDumpedDataUid = OptionalInt.empty();
        this.mFinishedBugreports = new LocalLog(20);
        this.mInjector = injector;
        this.mContext = injector.getContext();
        this.mAppOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);
        this.mBugreportFileManager = new BugreportFileManager(injector.getMappingFile());
        this.mBugreportAllowlistedPackages = injector.getAllowlistedPackages();
    }

    @Override // android.os.IDumpstate
    public void preDumpUiData(String callingPackage) {
        enforcePermission(callingPackage, Binder.getCallingUid(), true);
        Object r0 = this.mLock;
        monitor-enter(r0);
        preDumpUiDataLocked(callingPackage);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.os.IDumpstate
    public void startBugreport(int callingUidUnused, String callingPackage, FileDescriptor bugreportFd, FileDescriptor screenshotFd, int bugreportMode, int bugreportFlags, IDumpstateListener listener, boolean isScreenshotRequested, boolean skipUserConsentUnused) {
        callingPackage.getClass();
        bugreportFd.getClass();
        listener.getClass();
        validateBugreportMode(bugreportMode);
        validateBugreportFlags(bugreportFlags);
        int callingUid = Binder.getCallingUid();
        if (bugreportMode != 4) goto L5;
        boolean r0 = true;
    L6:
        enforcePermission(callingPackage, callingUid, r0);
        ensureUserCanTakeBugReport(bugreportMode);
        Slogf.i(TAG, "Starting bugreport for %s / %d", new Object[]{callingPackage, Integer.valueOf(callingUid)});
        new MutableBoolean(false);
        Object r11 = this.mLock;
        monitor-enter(r11);
        startBugreportLocked(callingUid, callingPackage, bugreportFd, screenshotFd, bugreportMode, bugreportFlags, listener, isScreenshotRequested);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    private /* synthetic */ void lambda$startBugreport$0(MutableBoolean handoffLock, int callingUid, String callingPackage, FileDescriptor bugreportFd, FileDescriptor screenshotFd, int bugreportMode, int bugreportFlags, IDumpstateListener listener, boolean isScreenshotRequested) {
        Object r1 = this.mLock;     // Catch: Exception -> L19
        monitor-enter(r1);     // Catch: Exception -> L19
        monitor-enter(handoffLock);     // Catch: Throwable -> L12
        handoffLock.value = true;     // Catch: Throwable -> L14
        handoffLock.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(handoffLock);     // Catch: Throwable -> L14
    L9:
        startBugreportLocked(callingUid, callingPackage, bugreportFd, screenshotFd, bugreportMode, bugreportFlags, listener, isScreenshotRequested);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        Slog.e(TAG, "Cannot start a new bugreport due to an unknown error", e);
        reportError(listener, 2);
    }

    @Override // android.os.IDumpstate
    public void cancelBugreport(int callingUidUnused, String callingPackage) {
        int callingUid = Binder.getCallingUid();
        enforcePermission(callingPackage, callingUid, true);
        Slogf.i(TAG, "Cancelling bugreport for %s / %d", new Object[]{callingPackage, Integer.valueOf(callingUid)});
        Object r1 = this.mLock;
        monitor-enter(r1);
        IDumpstate ds = getDumpstateBinderServiceLocked();     // Catch: Throwable -> L9
        if (ds != null) goto L20;
        Slog.w(TAG, "cancelBugreport: Could not find native dumpstate service");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L20:
        ds.cancelBugreport(callingUid, callingPackage);     // Catch: Throwable -> L9 RemoteException -> L13
    L15:
        stopDumpstateBinderServiceLocked();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L13:
        e = move-exception;
        Slog.e(TAG, "RemoteException in cancelBugreport", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // android.os.IDumpstate
    public void retrieveBugreport(int callingUidUnused, String callingPackage, int userId, FileDescriptor bugreportFd, String bugreportFile, boolean keepBugreportOnRetrievalUnused, boolean skipUserConsentUnused, IDumpstateListener listener) {
        int callingUid = Binder.getCallingUid();
        enforcePermission(callingPackage, callingUid, false);
        Slogf.i(TAG, "Retrieving bugreport for %s / %d", new Object[]{callingPackage, Integer.valueOf(callingUid)});
        this.mBugreportFileManager.ensureCallerPreviouslyGeneratedFile(this.mContext, this.mContext.getPackageManager(), new Pair(Integer.valueOf(callingUid), callingPackage), userId, bugreportFile, false);     // Catch: IllegalArgumentException -> L39
        Object r10 = this.mLock;
        monitor-enter(r10);
    L35:
        th = th;
    L37:
        monitor-exit(r10);     // Catch: Throwable -> L27
        throw th;
    L42:
        if (isDumpstateBinderServiceRunningLocked() == false) goto L13;
        Slog.w(TAG, "'dumpstate' is already running. Cannot retrieve a bugreport while another one is currently in progress.");     // Catch: Throwable -> L11
        reportError(listener, 5);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L13:
        IDumpstate ds = startAndGetDumpstateBinderServiceLocked();     // Catch: Throwable -> L35
        if (ds != null) goto L18;
        Slog.w(TAG, "Unable to get bugreport service");     // Catch: Throwable -> L11
        reportError(listener, 2);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L18:
        boolean skipUserConsent = this.mBugreportFileManager.canSkipConsentScreen(callingPackage, false);     // Catch: Throwable -> L35
        boolean r5 = false;
        Pair r4 = new Pair(Integer.valueOf(callingUid), callingPackage);     // Catch: Throwable -> L35
        if (skipUserConsent == true) goto L21;
        r5 = true;
    L21:
        DumpstateListener myListener = new DumpstateListener(this, listener, ds, r4, true, r5, true);     // Catch: Throwable -> L35
        boolean keepBugreportOnRetrieval = this.mBugreportFileManager.mBugreportFilesToPersist.contains(bugreportFile);     // Catch: Throwable -> L33
        setCurrentDumpstateListenerLocked(myListener);     // Catch: Throwable -> L33
        ds.retrieveBugreport(callingUid, callingPackage, userId, bugreportFd, bugreportFile, keepBugreportOnRetrieval, skipUserConsent, myListener);     // Catch: Throwable -> L27 RemoteException -> L29
    L31:
        monitor-exit(r10);     // Catch: Throwable -> L27
        return;
    L29:
        e = move-exception;
        Slog.e(TAG, "RemoteException in retrieveBugreport", e);     // Catch: Throwable -> L27
    L33:
        th = th;
    L11:
        th = th;
    L27:
        th = th;
    L39:
        e = move-exception;
        Slog.e(TAG, e.getMessage());
        reportError(listener, 6);
    }

    private void setCurrentDumpstateListenerLocked(DumpstateListener listener) {
        if (this.mCurrentDumpstateListener == null) goto L5;
        Slogf.w(TAG, "setCurrentDumpstateListenerLocked(%s): called when mCurrentDumpstateListener is already set (%s)", new Object[]{listener, this.mCurrentDumpstateListener});
    L5:
        this.mCurrentDumpstateListener = listener;
    }

    private void validateBugreportMode(int mode) {
        if (mode != 0) goto L4;
        return;
    L4:
        if (mode != 1) goto L6;
        return;
    L6:
        if (mode != 2) goto L8;
        return;
    L8:
        if (mode != 3) goto L10;
        return;
    L10:
        if (mode != 4) goto L12;
        return;
    L12:
        if (mode != 5) goto L14;
        return;
    L14:
        if (mode == 7) goto L24;
        Slog.w(TAG, "Unknown bugreport mode: " + mode);
        throw new IllegalArgumentException("Unknown bugreport mode: " + mode);
    }

    private void validateBugreportFlags(int flags) {
        int flags2 = clearBugreportFlag(flags, 7);
        if (flags2 != 0) goto L5;
        return;
    L5:
        Slog.w(TAG, "Unknown bugreport flags: " + flags2);
        throw new IllegalArgumentException("Unknown bugreport flags: " + flags2);
    }

    private void enforcePermission(String callingPackage, int callingUid, boolean checkCarrierPrivileges) {
        this.mAppOps.checkPackage(callingUid, callingPackage);
        boolean allowlisted = this.mBugreportAllowlistedPackages.contains(callingPackage);
        if (allowlisted == true) goto L10;
        long token = Binder.clearCallingIdentity();
        allowlisted = this.mInjector.getRoleManagerWrapper().getRoleHolders(ROLE_SYSTEM_AUTOMOTIVE_PROJECTION).contains(callingPackage);     // Catch: Throwable -> L7
        Binder.restoreCallingIdentity(token);
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L10:
        if (allowlisted == true) goto L12;
    L14:
        long token2 = Binder.clearCallingIdentity();
        if (checkCarrierPrivileges == true) goto L32;
    L24:
        Binder.restoreCallingIdentity(token2);
        StringBuilder r3 = new StringBuilder();
        r3.append(callingPackage);
        r3.append(" does not hold the DUMP permission or is not bugreport-whitelisted or does not have an allowed role ");
        if (checkCarrierPrivileges == false) goto L27;
        String r4 = "and does not have carrier privileges ";
    L28:
        r3.append(r4);
        r3.append("to request a bugreport");
        String message = r3.toString();
        Slog.w(TAG, message);
        throw new SecurityException(message);
    L27:
        r4 = "";
        goto L28
    L32:
        if (this.mTelephonyManager.checkCarrierPrivilegesForPackageAnyPhone(callingPackage) != 1) goto L24;
        Binder.restoreCallingIdentity(token2);
        return;
    L21:
        th = move-exception;
        Binder.restoreCallingIdentity(token2);
        throw th;
    L12:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.DUMP") != 0) goto L14;
    }

    private void ensureUserCanTakeBugReport(int bugreportMode) {
        int effectiveCallingUserId = UserHandle.getUserId(Binder.getCallingUid());
        long identity = Binder.clearCallingIdentity();
        UserInfo profileParent = this.mInjector.getUserManager().getProfileParent(effectiveCallingUserId);     // Catch: Throwable -> L6
        if (profileParent != null) goto L8;
        boolean isAdminUser = this.mInjector.getUserManager().isUserAdmin(effectiveCallingUserId);     // Catch: Throwable -> L6
    L9:
        Binder.restoreCallingIdentity(identity);
        if (isAdminUser == false) goto L12;
        return;
    L12:
        if (bugreportMode == 2) goto L14;
    L16:
        logAndThrow(TextUtils.formatSimple("Calling user %s is not an admin user. Only admin users and their profiles are allowed to take bugreport.", new Object[]{Integer.valueOf(effectiveCallingUserId)}));
        return;
    L14:
        if (isUserAffiliated(effectiveCallingUserId) == false) goto L16;
        return;
    L8:
        effectiveCallingUserId = profileParent.id;     // Catch: Throwable -> L6
        isAdminUser = profileParent.isAdmin();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private boolean isUserAffiliated(int userId) {
        DevicePolicyManager dpm = this.mInjector.getDevicePolicyManager();
        int deviceOwnerUid = dpm.getDeviceOwnerUserId();
        if (deviceOwnerUid != (-10000)) goto L6;
        return false;
    L6:
        if (userId != deviceOwnerUid) goto L8;
        return true;
    L8:
        if (dpm.isAffiliatedUser(userId) == true) goto L13;
        logAndThrow("User " + userId + " is not affiliated to the device owner.");
        return true;
    L13:
        return true;
    }

    private void preDumpUiDataLocked(String callingPackage) {
        this.mPreDumpedDataUid = OptionalInt.empty();
        if (isDumpstateBinderServiceRunningLocked() == false) goto L6;
        Slog.e(TAG, "'dumpstate' is already running. Cannot pre-dump data while another operation is currently in progress.");
        return;
    L6:
        IDumpstate ds = startAndGetDumpstateBinderServiceLocked();
        if (ds != null) goto L19;
        Slog.e(TAG, "Unable to get bugreport service");
        return;
    L19:
        ds.preDumpUiData(callingPackage);     // Catch: Throwable -> L13 RemoteException -> L16
        stopDumpstateBinderServiceLocked();
        this.mPreDumpedDataUid = OptionalInt.of(Binder.getCallingUid());
        return;
    L13:
        th = move-exception;
        stopDumpstateBinderServiceLocked();
        throw th;
    L17:
        stopDumpstateBinderServiceLocked();
    }

    private void startBugreportLocked(int callingUid, String callingPackage, FileDescriptor bugreportFd, FileDescriptor screenshotFd, int bugreportMode, int bugreportFlags, IDumpstateListener listener, boolean isScreenshotRequested) {
        if (isDumpstateBinderServiceRunningLocked() == false) goto L6;
        Slog.w(TAG, "'dumpstate' is already running. Cannot start a new bugreport while another operation is currently in progress.");
        reportError(listener, 5);
        return;
    L6:
        boolean r5 = true;
        if ((bugreportFlags & 1) != 0) goto L9;
        int r10 = callingUid;
    L15:
        int bugreportFlags2 = bugreportFlags;
    L17:
        if ((bugreportFlags2 & 2) == 0) goto L19;
        boolean r0 = true;
    L20:
        boolean isDeferredConsentReport = r0;
        if ((bugreportFlags2 & 4) == 0) goto L23;
        boolean r1 = true;
    L24:
        boolean keepBugreportOnRetrieval = r1;
        IDumpstate ds = startAndGetDumpstateBinderServiceLocked();
        if (ds != null) goto L28;
        Slog.w(TAG, "Unable to get bugreport service");
        reportError(listener, 2);
        return;
    L28:
        BugreportFileManager r4 = this.mBugreportFileManager;
        if (isDeferredConsentReport == true) goto L31;
        boolean r8 = true;
    L32:
        boolean skipUserConsent = r4.canSkipConsentScreen(callingPackage, r8);
        Pair r6 = new Pair(Integer.valueOf(r10), callingPackage);
        if (isDeferredConsentReport == true) goto L36;
        if (skipUserConsent == true) goto L36;
    L37:
        boolean keepBugreportOnRetrieval2 = r5;
        DumpstateListener myListener = new DumpstateListener(this, listener, ds, r6, isDeferredConsentReport, keepBugreportOnRetrieval, keepBugreportOnRetrieval2, isDeferredConsentReport);
        setCurrentDumpstateListenerLocked(myListener);
        ds.startBugreport(r10, callingPackage, bugreportFd, screenshotFd, bugreportMode, bugreportFlags2, myListener, isScreenshotRequested, skipUserConsent);     // Catch: RemoteException -> L40
        return;
    L41:
        cancelBugreport(callingUid, callingPackage);
        return;
    L36:
        r5 = false;
        goto L37
    L31:
        r8 = false;
        goto L32
    L23:
        r1 = false;
        goto L24
    L19:
        r0 = false;
        goto L20
    L9:
        if (this.mPreDumpedDataUid.isEmpty() == false) goto L11;
        int bugreportFlags3 = clearBugreportFlag(bugreportFlags, 1);
        Slog.w(TAG, "Ignoring BUGREPORT_FLAG_USE_PREDUMPED_UI_DATA. No pre-dumped data is available.");
        r10 = callingUid;
        bugreportFlags2 = bugreportFlags3;
        goto L17
    L11:
        r10 = callingUid;
        if (this.mPreDumpedDataUid.getAsInt() == r10) goto L15;
        int bugreportFlags4 = clearBugreportFlag(bugreportFlags, 1);
        Slog.w(TAG, "Ignoring BUGREPORT_FLAG_USE_PREDUMPED_UI_DATA. Data was pre-dumped by a different UID.");
        bugreportFlags2 = bugreportFlags4;
        goto L17
    }

    private boolean isDumpstateBinderServiceRunningLocked() {
        if (getDumpstateBinderServiceLocked() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private IDumpstate getDumpstateBinderServiceLocked() {
        return IDumpstate.Stub.asInterface(ServiceManager.getService("dumpstate"));
    }

    private IDumpstate startAndGetDumpstateBinderServiceLocked() {
        this.mInjector.setSystemProperty("ctl.start", BUGREPORT_SERVICE);
        IDumpstate ds = null;
        boolean timedOut = false;
        int totalTimeWaitedMillis = 0;
        int seedWaitTimeMillis = 500;
    L4:
        if (timedOut == true) goto L13;
        ds = getDumpstateBinderServiceLocked();
        if (ds != null) goto L7;
        SystemClock.sleep(seedWaitTimeMillis);
        Slog.i(TAG, "Waiting to get dumpstate service handle (" + totalTimeWaitedMillis + "ms)");
        totalTimeWaitedMillis = totalTimeWaitedMillis + seedWaitTimeMillis;
        seedWaitTimeMillis = seedWaitTimeMillis * 2;
        if (totalTimeWaitedMillis <= 30000) goto L11;
        boolean r4 = true;
    L12:
        timedOut = r4;
        goto L4
    L11:
        r4 = false;
        goto L12
    L7:
        Slog.i(TAG, "Got bugreport service handle.");
    L13:
        if (timedOut == false) goto L15;
        Slog.w(TAG, "Timed out waiting to get dumpstate service handle (" + totalTimeWaitedMillis + "ms)");
    L15:
        return ds;
    }

    private void stopDumpstateBinderServiceLocked() {
        this.mInjector.setSystemProperty("ctl.stop", BUGREPORT_SERVICE);
    }

    @Override // android.os.Binder
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        pw.printf("Allow-listed packages: %s\n", new Object[]{this.mBugreportAllowlistedPackages});
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.print("Pre-dumped data UID: ");     // Catch: Throwable -> L10
        if (this.mPreDumpedDataUid.isEmpty() == false) goto L12;
        pw.println("none");     // Catch: Throwable -> L10
    L14:
        if (this.mCurrentDumpstateListener != null) goto L16;
        pw.println("Not taking a bug report");     // Catch: Throwable -> L10
    L18:
        if (this.mNumberFinishedBugreports != 0) goto L20;
        pw.println("No finished bugreports");     // Catch: Throwable -> L10
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L10
        Object r1 = BugreportFileManager.m6437$$Nest$fgetmLock(this.mBugreportFileManager);
        monitor-enter(r1);
    L31:
        th = move-exception;
        throw th;
    L29:
        if (BugreportFileManager.m6438$$Nest$fgetmReadBugreportMapping(this.mBugreportFileManager) == true) goto L33;
        pw.println("Has not read bugreport mapping");     // Catch: Throwable -> L31
    L33:
        int numberFiles = BugreportFileManager.m6436$$Nest$fgetmBugreportFiles(this.mBugreportFileManager).size();     // Catch: Throwable -> L31
        Integer r4 = Integer.valueOf(numberFiles);     // Catch: Throwable -> L31
        if (numberFiles <= 1) goto L36;
        String r2 = "s";
    L37:
        pw.printf("%d pending file%s", new Object[]{r4, r2});     // Catch: Throwable -> L31
        if (numberFiles <= 0) goto L43;
        int i = 0;
    L40:
        if (i >= numberFiles) goto L44;
        Pair<Integer, String> caller = (Pair) BugreportFileManager.m6436$$Nest$fgetmBugreportFiles(this.mBugreportFileManager).keyAt(i);     // Catch: Throwable -> L31
        ArraySet<String> files = (ArraySet) BugreportFileManager.m6436$$Nest$fgetmBugreportFiles(this.mBugreportFileManager).valueAt(i);     // Catch: Throwable -> L31
        pw.printf("  %s: %s\n", new Object[]{callerToString(caller), files});     // Catch: Throwable -> L31
        i = i + 1;     // Catch: Throwable -> L31
    L44:
        monitor-exit(r1);     // Catch: Throwable -> L31
        return;
    L43:
        pw.println();     // Catch: Throwable -> L31
        goto L44
    L36:
        r2 = "";
        goto L37
    L20:
        Integer r3 = Integer.valueOf(this.mNumberFinishedBugreports);     // Catch: Throwable -> L10
        if (this.mNumberFinishedBugreports <= 1) goto L23;
        String r5 = "s";
    L24:
        pw.printf("%d finished bugreport%s. Last %d:\n", new Object[]{r3, r5, Integer.valueOf(Math.min(this.mNumberFinishedBugreports, 20))});     // Catch: Throwable -> L10
        this.mFinishedBugreports.dump("  ", pw);     // Catch: Throwable -> L10
        goto L25
    L23:
        r5 = "";
        goto L24
    L16:
        DumpstateListener.m6439$$Nest$mdump(this.mCurrentDumpstateListener, pw);     // Catch: Throwable -> L10
        goto L18
    L12:
        pw.println(this.mPreDumpedDataUid.getAsInt());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private static String callerToString(Pair<Integer, String> caller) {
        if (caller != null) goto L5;
        return "N/A";
    L5:
        return ((String) caller.second) + SliceClientPermissions.SliceAuthority.DELIMITER + caller.first;
    }

    private int clearBugreportFlag(int flags, int flag) {
        return flags & (~flag);
    }

    private void reportError(IDumpstateListener listener, int errorCode) {
        listener.onError(errorCode);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "onError() transaction threw RemoteException: " + e.getMessage());
    }

    private void logAndThrow(String message) {
        Slog.w(TAG, message);
        throw new IllegalArgumentException(message);
    }
}
