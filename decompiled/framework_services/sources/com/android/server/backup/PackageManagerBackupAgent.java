package com.android.server.backup;

import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Slog;
import com.android.server.backup.utils.BackupEligibilityRules;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class PackageManagerBackupAgent extends BackupAgent {
    static final String ANCESTRAL_RECORD_KEY = "@ancestral_record@";
    static final int ANCESTRAL_RECORD_VERSION = 1;
    private static final boolean DEBUG = false;
    private static final String DEFAULT_HOME_KEY = "@home@";
    static final String GLOBAL_METADATA_KEY = "@meta@";
    static final String STATE_FILE_HEADER = "=state=";
    static final int STATE_FILE_VERSION = 2;
    private static final String TAG = "PMBA";
    private static final int UNDEFINED_ANCESTRAL_RECORD_VERSION = -1;
    private List<PackageInfo> mAllPackages;
    private final HashSet<String> mExisting;
    private boolean mHasMetadata;
    private PackageManager mPackageManager;
    private ComponentName mRestoredHome;
    private String mRestoredHomeInstaller;
    private ArrayList<byte[]> mRestoredHomeSigHashes;
    private long mRestoredHomeVersion;
    private HashMap<String, Metadata> mRestoredSignatures;
    private HashMap<String, Metadata> mStateVersions;
    private int mStoredAncestralRecordVersion;
    private ComponentName mStoredHomeComponent;
    private ArrayList<byte[]> mStoredHomeSigHashes;
    private long mStoredHomeVersion;
    private String mStoredIncrementalVersion;
    private int mStoredSdkVersion;
    private int mUserId;

    private class AncestralVersion1RestoreDataConsumer implements RestoreDataConsumer {
        final /* synthetic */ PackageManagerBackupAgent this$0;

        /* synthetic */ AncestralVersion1RestoreDataConsumer(PackageManagerBackupAgent r1, PackageManagerBackupAgentIA r2) {
            this(r1);
        }

        private AncestralVersion1RestoreDataConsumer(PackageManagerBackupAgent r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.backup.PackageManagerBackupAgent.RestoreDataConsumer
        public void consumeRestoreData(BackupDataInput data) throws IOException {
            List<ApplicationInfo> restoredApps = new ArrayList();
            HashMap<String, Metadata> sigMap = new HashMap();
        L4:
            if (data.readNextHeader() == false) goto L24;
            String key = data.getKey();
            int dataSize = data.getDataSize();
            byte[] inputBytes = new byte[dataSize];
            data.readEntityData(inputBytes, 0, dataSize);
            ByteArrayInputStream inputBuffer = new ByteArrayInputStream(inputBytes);
            DataInputStream inputBufferStream = new DataInputStream(inputBuffer);
            if (key.equals(PackageManagerBackupAgent.GLOBAL_METADATA_KEY) == true) goto L7;
            if (key.equals(PackageManagerBackupAgent.DEFAULT_HOME_KEY) == true) goto L10;
            int versionCodeInt = inputBufferStream.readInt();
            if (versionCodeInt != Integer.MIN_VALUE) goto L14;
            long versionCode = inputBufferStream.readLong();
        L15:
            ArrayList<byte[]> sigs = PackageManagerBackupAgent.m2488$$Nest$smreadSignatureHashArray(inputBufferStream);
            if (sigs == null) goto L23;
            if (sigs.size() == 0) goto L23;
            ApplicationInfo app = new ApplicationInfo();
            app.packageName = key;
            restoredApps.add(app);
            sigMap.put(key, new Metadata(this.this$0, versionCode, sigs));
        L21:
            restoredApps = restoredApps;
        L23:
            Slog.w(PackageManagerBackupAgent.TAG, "Not restoring package " + key + " since it appears to have no signatures.");
            restoredApps = restoredApps;
            goto L4
        L14:
            versionCode = versionCodeInt;
            goto L15
        L10:
            String cn = inputBufferStream.readUTF();
            PackageManagerBackupAgent.m2481$$Nest$fputmRestoredHome(this.this$0, ComponentName.unflattenFromString(cn));
            PackageManagerBackupAgent.m2484$$Nest$fputmRestoredHomeVersion(this.this$0, inputBufferStream.readLong());
            PackageManagerBackupAgent.m2482$$Nest$fputmRestoredHomeInstaller(this.this$0, inputBufferStream.readUTF());
            PackageManagerBackupAgent.m2483$$Nest$fputmRestoredHomeSigHashes(this.this$0, PackageManagerBackupAgent.m2488$$Nest$smreadSignatureHashArray(inputBufferStream));
            goto L21
        L7:
            int storedSdkVersion = inputBufferStream.readInt();
            PackageManagerBackupAgent.m2487$$Nest$fputmStoredSdkVersion(this.this$0, storedSdkVersion);
            PackageManagerBackupAgent.m2486$$Nest$fputmStoredIncrementalVersion(this.this$0, inputBufferStream.readUTF());
            PackageManagerBackupAgent.m2480$$Nest$fputmHasMetadata(this.this$0, true);
            goto L21
        L24:
            PackageManagerBackupAgent.m2485$$Nest$fputmRestoredSignatures(this.this$0, sigMap);
        }
    }

    private class LegacyRestoreDataConsumer implements RestoreDataConsumer {
        final /* synthetic */ PackageManagerBackupAgent this$0;

        /* synthetic */ LegacyRestoreDataConsumer(PackageManagerBackupAgent r1, PackageManagerBackupAgentIA r2) {
            this(r1);
        }

        private LegacyRestoreDataConsumer(PackageManagerBackupAgent r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.backup.PackageManagerBackupAgent.RestoreDataConsumer
        public void consumeRestoreData(BackupDataInput data) throws IOException {
            List<ApplicationInfo> restoredApps = new ArrayList();
            HashMap<String, Metadata> sigMap = new HashMap();
        L3:
            String key = data.getKey();
            int dataSize = data.getDataSize();
            byte[] inputBytes = new byte[dataSize];
            data.readEntityData(inputBytes, 0, dataSize);
            ByteArrayInputStream inputBuffer = new ByteArrayInputStream(inputBytes);
            DataInputStream inputBufferStream = new DataInputStream(inputBuffer);
            if (key.equals(PackageManagerBackupAgent.GLOBAL_METADATA_KEY) == true) goto L5;
            if (key.equals(PackageManagerBackupAgent.DEFAULT_HOME_KEY) == true) goto L8;
            int versionCodeInt = inputBufferStream.readInt();
            if (versionCodeInt != Integer.MIN_VALUE) goto L12;
            long versionCode = inputBufferStream.readLong();
        L13:
            ArrayList<byte[]> sigs = PackageManagerBackupAgent.m2488$$Nest$smreadSignatureHashArray(inputBufferStream);
            if (sigs == null) goto L24;
            if (sigs.size() == 0) goto L24;
            ApplicationInfo app = new ApplicationInfo();
            app.packageName = key;
            restoredApps.add(app);
            sigMap.put(key, new Metadata(this.this$0, versionCode, sigs));
        L20:
            if (data.readNextHeader() == true) goto L3;
        L26:
            PackageManagerBackupAgent.m2485$$Nest$fputmRestoredSignatures(this.this$0, sigMap);
            return;
        L24:
            Slog.w(PackageManagerBackupAgent.TAG, "Not restoring package " + key + " since it appears to have no signatures.");
            if (data.readNextHeader() == true) goto L3;
        L12:
            versionCode = versionCodeInt;
            goto L13
        L8:
            String cn = inputBufferStream.readUTF();
            PackageManagerBackupAgent.m2481$$Nest$fputmRestoredHome(this.this$0, ComponentName.unflattenFromString(cn));
            PackageManagerBackupAgent.m2484$$Nest$fputmRestoredHomeVersion(this.this$0, inputBufferStream.readLong());
            PackageManagerBackupAgent.m2482$$Nest$fputmRestoredHomeInstaller(this.this$0, inputBufferStream.readUTF());
            PackageManagerBackupAgent.m2483$$Nest$fputmRestoredHomeSigHashes(this.this$0, PackageManagerBackupAgent.m2488$$Nest$smreadSignatureHashArray(inputBufferStream));
            goto L20
        L5:
            int storedSdkVersion = inputBufferStream.readInt();
            PackageManagerBackupAgent.m2487$$Nest$fputmStoredSdkVersion(this.this$0, storedSdkVersion);
            PackageManagerBackupAgent.m2486$$Nest$fputmStoredIncrementalVersion(this.this$0, inputBufferStream.readUTF());
            PackageManagerBackupAgent.m2480$$Nest$fputmHasMetadata(this.this$0, true);
            goto L20
        }
    }

    public class Metadata {
        public ArrayList<byte[]> sigHashes;
        public long versionCode;

        Metadata(PackageManagerBackupAgent this$0, long version, ArrayList<byte[]> hashes) {
            this.versionCode = version;
            this.sigHashes = hashes;
        }
    }

    interface RestoreDataConsumer {
        void consumeRestoreData(BackupDataInput r1) throws IOException;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmHasMetadata, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2480$$Nest$fputmHasMetadata(PackageManagerBackupAgent r0, boolean r1) {
        r0.mHasMetadata = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRestoredHome, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2481$$Nest$fputmRestoredHome(PackageManagerBackupAgent r0, ComponentName r1) {
        r0.mRestoredHome = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRestoredHomeInstaller, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2482$$Nest$fputmRestoredHomeInstaller(PackageManagerBackupAgent r0, String r1) {
        r0.mRestoredHomeInstaller = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRestoredHomeSigHashes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2483$$Nest$fputmRestoredHomeSigHashes(PackageManagerBackupAgent r0, ArrayList r1) {
        r0.mRestoredHomeSigHashes = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRestoredHomeVersion, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2484$$Nest$fputmRestoredHomeVersion(PackageManagerBackupAgent r0, long r1) {
        r0.mRestoredHomeVersion = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRestoredSignatures, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2485$$Nest$fputmRestoredSignatures(PackageManagerBackupAgent r0, HashMap r1) {
        r0.mRestoredSignatures = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStoredIncrementalVersion, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2486$$Nest$fputmStoredIncrementalVersion(PackageManagerBackupAgent r0, String r1) {
        r0.mStoredIncrementalVersion = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStoredSdkVersion, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2487$$Nest$fputmStoredSdkVersion(PackageManagerBackupAgent r0, int r1) {
        r0.mStoredSdkVersion = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$smreadSignatureHashArray, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m2488$$Nest$smreadSignatureHashArray(DataInputStream r0) {
        return readSignatureHashArray(r0);
    }

    public PackageManagerBackupAgent(PackageManager packageMgr, List<PackageInfo> packages, int userId) {
        this.mStateVersions = new HashMap();
        this.mExisting = new HashSet();
        init(packageMgr, packages, userId);
    }

    public PackageManagerBackupAgent(PackageManager packageMgr, int userId, BackupEligibilityRules backupEligibilityRules) {
        this.mStateVersions = new HashMap();
        this.mExisting = new HashSet();
        init(packageMgr, null, userId);
        evaluateStorablePackages(backupEligibilityRules);
    }

    private void init(PackageManager packageMgr, List<PackageInfo> packages, int userId) {
        this.mPackageManager = packageMgr;
        this.mAllPackages = packages;
        this.mRestoredSignatures = null;
        this.mHasMetadata = false;
        this.mStoredSdkVersion = Build.VERSION.SDK_INT;
        this.mStoredIncrementalVersion = Build.VERSION.INCREMENTAL;
        this.mUserId = userId;
    }

    public void evaluateStorablePackages(BackupEligibilityRules backupEligibilityRules) {
        this.mAllPackages = getStorableApplications(this.mPackageManager, this.mUserId, backupEligibilityRules);
    }

    public static List<PackageInfo> getStorableApplications(PackageManager pm, int userId, BackupEligibilityRules backupEligibilityRules) {
        List<PackageInfo> pkgs = pm.getInstalledPackagesAsUser(134217728, userId);
        int N = pkgs.size();
        int a = N - 1;
    L3:
        if (a < 0) goto L9;
        PackageInfo pkg = pkgs.get(a);
        if (backupEligibilityRules.appIsEligibleForBackup(pkg.applicationInfo) == true) goto L7;
        pkgs.remove(a);
    L7:
        a = a - 1;
        goto L3
    L9:
        return pkgs;
    }

    public boolean hasMetadata() {
        return this.mHasMetadata;
    }

    public int getSourceSdk() {
        return this.mStoredSdkVersion;
    }

    public Metadata getRestoredMetadata(String packageName) {
        if (this.mRestoredSignatures != null) goto L7;
        Slog.w(TAG, "getRestoredMetadata() before metadata read!");
        return null;
    L7:
        return this.mRestoredSignatures.get(packageName);
    }

    public Set<String> getRestoredPackages() {
        if (this.mRestoredSignatures != null) goto L7;
        Slog.w(TAG, "getRestoredPackages() before metadata read!");
        return null;
    L7:
        return this.mRestoredSignatures.keySet();
    }

    @Override // android.app.backup.BackupAgent
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data, ParcelFileDescriptor newState) {
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        DataOutputStream outputBufferStream = new DataOutputStream(outputBuffer);
        parseStateFile(oldState);
        if (this.mStoredIncrementalVersion != null) goto L5;
    L6:
        Slog.i(TAG, "Previous metadata " + this.mStoredIncrementalVersion + " mismatch vs " + Build.VERSION.INCREMENTAL + " - rewriting");
        this.mExisting.clear();
    L7:
        boolean upgradingAncestralRecordVersion = false;
        if (this.mExisting.contains(ANCESTRAL_RECORD_KEY) == true) goto L14;
        Slog.d(TAG, "No ancestral record version in the old state. Storing ancestral record version key");     // Catch: IOException -> L11
        outputBufferStream.writeInt(1);     // Catch: IOException -> L11
        writeEntity(data, ANCESTRAL_RECORD_KEY, outputBuffer.toByteArray());     // Catch: IOException -> L11
        upgradingAncestralRecordVersion = true;
    L17:
        outputBuffer.reset();     // Catch: IOException -> L11
        if (this.mExisting.contains(GLOBAL_METADATA_KEY) == true) goto L20;
        outputBufferStream.writeInt(Build.VERSION.SDK_INT);     // Catch: IOException -> L11
        outputBufferStream.writeUTF(Build.VERSION.INCREMENTAL);     // Catch: IOException -> L11
        writeEntity(data, GLOBAL_METADATA_KEY, outputBuffer.toByteArray());     // Catch: IOException -> L11
    L21:
        Iterator<PackageInfo> r7 = this.mAllPackages.iterator();     // Catch: IOException -> L11
    L23:
        if (r7.hasNext() == false) goto L47;
        PackageInfo pkg = r7.next();     // Catch: IOException -> L11
        String packName = pkg.packageName;     // Catch: IOException -> L11
        if (packName.equals(GLOBAL_METADATA_KEY) == true) goto L23;
        PackageInfo info = this.mPackageManager.getPackageInfoAsUser(packName, 134217728, this.mUserId);     // Catch: IOException -> L11 PackageManager.NameNotFoundException -> L44
    L30:
        if (this.mExisting.contains(packName) == false) goto L36;
        this.mExisting.remove(packName);     // Catch: IOException -> L11
        if (upgradingAncestralRecordVersion == true) goto L36;
        if (info.getLongVersionCode() == this.mStateVersions.get(packName).versionCode) goto L23;
    L36:
        SigningInfo signingInfo = info.signingInfo;     // Catch: IOException -> L11
        if (signingInfo == null) goto L38;
        outputBuffer.reset();     // Catch: IOException -> L11
        if (info.versionCodeMajor == 0) goto L42;
        outputBufferStream.writeInt(Integer.MIN_VALUE);     // Catch: IOException -> L11
        outputBufferStream.writeLong(info.getLongVersionCode());     // Catch: IOException -> L11
    L43:
        Signature[] infoSignatures = signingInfo.getApkContentsSigners();     // Catch: IOException -> L11
        writeSignatureHashArray(outputBufferStream, BackupUtils.hashSignatureArray(infoSignatures));     // Catch: IOException -> L11
        writeEntity(data, packName, outputBuffer.toByteArray());     // Catch: IOException -> L11
        goto L23
    L42:
        outputBufferStream.writeInt(info.versionCode);     // Catch: IOException -> L11
        goto L43
    L38:
        Slog.w(TAG, "Not backing up package " + packName + " since it appears to have no signatures.");     // Catch: IOException -> L11
    L45:
        this.mExisting.add(packName);     // Catch: IOException -> L11
        goto L23
    L47:
        if (this.mExisting.isEmpty() == true) goto L54;
        if (upgradingAncestralRecordVersion == false) goto L54;
        Iterator<String> r0 = this.mExisting.iterator();     // Catch: IOException -> L11
    L51:
        if (r0.hasNext() == false) goto L53;
        String pkgName = r0.next();     // Catch: IOException -> L11
        Slog.i(TAG, "Ancestral state updated - Deleting uninstalled package: " + pkgName + " from existing backup");     // Catch: IOException -> L11
        data.writeEntityHeader(pkgName, -1);     // Catch: IOException -> L11
        goto L51
    L53:
        this.mExisting.clear();     // Catch: IOException -> L11
    L54:
        writeStateFile(this.mAllPackages, newState);
        return;
    L20:
        this.mExisting.remove(GLOBAL_METADATA_KEY);     // Catch: IOException -> L11
        goto L21
    L14:
        if (this.mStoredAncestralRecordVersion == 1) goto L16;
        Slog.d(TAG, "Ancestral record version has changed from old state. Storingancestral record version key");     // Catch: IOException -> L11
        outputBufferStream.writeInt(1);     // Catch: IOException -> L11
        writeEntity(data, ANCESTRAL_RECORD_KEY, outputBuffer.toByteArray());     // Catch: IOException -> L11
        upgradingAncestralRecordVersion = true;
        this.mExisting.remove(ANCESTRAL_RECORD_KEY);     // Catch: IOException -> L11
        goto L17
    L16:
        this.mExisting.remove(ANCESTRAL_RECORD_KEY);     // Catch: IOException -> L11
    L56:
        Slog.e(TAG, "Unable to write package backup data file!");
        return;
    L5:
        if (this.mStoredIncrementalVersion.equals(Build.VERSION.INCREMENTAL) == true) goto L7;
        goto L6
    }

    private static void writeEntity(BackupDataOutput data, String key, byte[] bytes) throws IOException {
        data.writeEntityHeader(key, bytes.length);
        data.writeEntityData(bytes, bytes.length);
    }

    @Override // android.app.backup.BackupAgent
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) throws IOException {
        int ancestralRecordVersion = getAncestralRecordVersionValue(data);
        RestoreDataConsumer consumer = getRestoreDataConsumer(ancestralRecordVersion);
        if (consumer != null) goto L6;
        Slog.w(TAG, "Ancestral restore set version is unknown to this Android version; not restoring");
        return;
    L6:
        consumer.consumeRestoreData(data);
    }

    private int getAncestralRecordVersionValue(BackupDataInput data) throws IOException {
        if (data.readNextHeader() == false) goto L8;
        String key = data.getKey();
        int dataSize = data.getDataSize();
        if (ANCESTRAL_RECORD_KEY.equals(key) == false) goto L9;
        byte[] inputBytes = new byte[dataSize];
        data.readEntityData(inputBytes, 0, dataSize);
        ByteArrayInputStream inputBuffer = new ByteArrayInputStream(inputBytes);
        DataInputStream inputBufferStream = new DataInputStream(inputBuffer);
        int ancestralRecordVersionValue = inputBufferStream.readInt();
        return ancestralRecordVersionValue;
    L9:
        return -1;
    L8:
        return -1;
    }

    private RestoreDataConsumer getRestoreDataConsumer(int ancestralRecordVersion) {
        PackageManagerBackupAgentIA r0 = null;
        switch(ancestralRecordVersion) {
            case -1: goto L9;
            case 0: goto L4;
            case 1: goto L7;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "Unrecognized ANCESTRAL_RECORD_VERSION: " + ancestralRecordVersion);
        return null;
    L7:
        return new AncestralVersion1RestoreDataConsumer(this, r0);
    L9:
        return new LegacyRestoreDataConsumer(this, r0);
    }

    private static void writeSignatureHashArray(DataOutputStream out, ArrayList<byte[]> hashes) throws IOException {
        out.writeInt(hashes.size());
        Iterator<byte[]> r0 = hashes.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        byte[] buffer = r0.next();
        out.writeInt(buffer.length);
        out.write(buffer);
        goto L4
    }

    private static ArrayList<byte[]> readSignatureHashArray(DataInputStream in) {
        int num = in.readInt();     // Catch: IOException -> L13 EOFException -> L21
    L5:
        if (num > 20) goto L19;
        boolean nonHashFound = false;
        ArrayList<byte[]> sigs = new ArrayList(num);     // Catch: IOException -> L13
        int i = 0;
    L8:
        if (i >= num) goto L16;
        int len = in.readInt();     // Catch: IOException -> L13
        byte[] readHash = new byte[len];     // Catch: IOException -> L13
        in.read(readHash);     // Catch: IOException -> L13
        sigs.add(readHash);     // Catch: IOException -> L13
        if (len == 32) goto L12;
        nonHashFound = true;
    L12:
        i = i + 1;     // Catch: IOException -> L13
        goto L8
    L16:
        if (nonHashFound == true) goto L18;
        return sigs;
    L18:
        return BackupUtils.hashSignatureArray(sigs);
    L19:
        Slog.e(TAG, "Suspiciously large sig count in restore data; aborting");     // Catch: IOException -> L13
        throw new IllegalStateException("Bad restore state");     // Catch: IOException -> L13
    L24:
        Slog.e(TAG, "Unable to read signatures");
        return null;
    L22:
        Slog.w(TAG, "Read empty signature block");     // Catch: IOException -> L13
        return null;
    }

    /* JADX INFO: Infinite loop detected, blocks: 13, insns: 0 */
    private void parseStateFile(ParcelFileDescriptor stateFile) {
        this.mExisting.clear();
        this.mStateVersions.clear();
        this.mStoredSdkVersion = 0;
        this.mStoredIncrementalVersion = null;
        this.mStoredHomeComponent = null;
        this.mStoredHomeVersion = 0;
        this.mStoredHomeSigHashes = null;
        this.mStoredAncestralRecordVersion = -1;
        FileInputStream instream = new FileInputStream(stateFile.getFileDescriptor());
        BufferedInputStream inbuffer = new BufferedInputStream(instream);
        DataInputStream in = new DataInputStream(inbuffer);
        boolean ignoreExisting = false;
        String pkg = in.readUTF();     // Catch: IOException -> L9 EOFException -> L11
        if (pkg.equals(STATE_FILE_HEADER) == false) goto L14;
        int stateVersion = in.readInt();     // Catch: IOException -> L9 EOFException -> L11
        if (stateVersion <= 2) goto L13;
        Slog.w(TAG, "Unsupported state file version " + stateVersion + ", redoing from start");     // Catch: IOException -> L9 EOFException -> L11
        return;
    L13:
        pkg = in.readUTF();     // Catch: IOException -> L9 EOFException -> L11
    L16:
        if (pkg.equals(ANCESTRAL_RECORD_KEY) == false) goto L21;
        this.mStoredAncestralRecordVersion = in.readInt();     // Catch: IOException -> L9 EOFException -> L11
        if (ignoreExisting == true) goto L20;
        this.mExisting.add(ANCESTRAL_RECORD_KEY);     // Catch: IOException -> L9 EOFException -> L11
    L20:
        pkg = in.readUTF();     // Catch: IOException -> L9 EOFException -> L11
    L23:
        if (pkg.equals(DEFAULT_HOME_KEY) == false) goto L26;
        this.mStoredHomeComponent = ComponentName.unflattenFromString(in.readUTF());     // Catch: IOException -> L9 EOFException -> L11
        this.mStoredHomeVersion = in.readLong();     // Catch: IOException -> L9 EOFException -> L11
        this.mStoredHomeSigHashes = readSignatureHashArray(in);     // Catch: IOException -> L9 EOFException -> L11
        pkg = in.readUTF();     // Catch: IOException -> L9 EOFException -> L11
    L26:
        if (pkg.equals(GLOBAL_METADATA_KEY) == false) goto L37;
        this.mStoredSdkVersion = in.readInt();     // Catch: IOException -> L9 EOFException -> L11
        this.mStoredIncrementalVersion = in.readUTF();     // Catch: IOException -> L9 EOFException -> L11
        if (ignoreExisting == true) goto L30;
        this.mExisting.add(GLOBAL_METADATA_KEY);     // Catch: IOException -> L9 EOFException -> L11
    L30:
        String pkg2 = in.readUTF();     // Catch: IOException -> L9 EOFException -> L11
        int versionCodeInt = in.readInt();     // Catch: IOException -> L9 EOFException -> L11
        if (versionCodeInt != Integer.MIN_VALUE) goto L33;
        long versionCode = in.readLong();     // Catch: IOException -> L9 EOFException -> L11
    L34:
        if (ignoreExisting == true) goto L36;
        this.mExisting.add(pkg2);     // Catch: IOException -> L9 EOFException -> L11
    L36:
        this.mStateVersions.put(pkg2, new Metadata(this, versionCode, null));     // Catch: IOException -> L9 EOFException -> L11
        goto L30
    L33:
        versionCode = versionCodeInt;
        goto L34
    L37:
        Slog.e(TAG, "No global metadata in state file!");     // Catch: IOException -> L9 EOFException -> L11
        return;
    L21:
        Slog.i(TAG, "Older version of saved state - does not contain ancestral record version");     // Catch: IOException -> L9 EOFException -> L11
        goto L23
    L14:
        Slog.i(TAG, "Older version of saved state - rewriting");     // Catch: IOException -> L9 EOFException -> L11
        ignoreExisting = true;
    L9:
        e = move-exception;
        Slog.e(TAG, "Unable to read Package Manager state file: " + e);
        return;
    }

    private ComponentName getPreferredHomeComponent() {
        return this.mPackageManager.getHomeActivities(new ArrayList());
    }

    static void writeStateFile(List<PackageInfo> pkgs, ParcelFileDescriptor stateFile) {
        FileOutputStream outstream = new FileOutputStream(stateFile.getFileDescriptor());
        BufferedOutputStream outbuf = new BufferedOutputStream(outstream);
        DataOutputStream out = new DataOutputStream(outbuf);
        out.writeUTF(STATE_FILE_HEADER);     // Catch: IOException -> L9
        out.writeInt(2);     // Catch: IOException -> L9
        out.writeUTF(ANCESTRAL_RECORD_KEY);     // Catch: IOException -> L9
        out.writeInt(1);     // Catch: IOException -> L9
        out.writeUTF(GLOBAL_METADATA_KEY);     // Catch: IOException -> L9
        out.writeInt(Build.VERSION.SDK_INT);     // Catch: IOException -> L9
        out.writeUTF(Build.VERSION.INCREMENTAL);     // Catch: IOException -> L9
        Iterator<PackageInfo> r3 = pkgs.iterator();     // Catch: IOException -> L9
    L5:
        if (r3.hasNext() == false) goto L13;
        PackageInfo pkg = r3.next();     // Catch: IOException -> L9
        out.writeUTF(pkg.packageName);     // Catch: IOException -> L9
        if (pkg.versionCodeMajor == 0) goto L11;
        out.writeInt(Integer.MIN_VALUE);     // Catch: IOException -> L9
        out.writeLong(pkg.getLongVersionCode());     // Catch: IOException -> L9
        goto L5
    L11:
        out.writeInt(pkg.versionCode);     // Catch: IOException -> L9
        goto L5
    L13:
        out.flush();     // Catch: IOException -> L9
        return;
    L15:
        Slog.e(TAG, "Unable to write package manager state file!");
    }
}
