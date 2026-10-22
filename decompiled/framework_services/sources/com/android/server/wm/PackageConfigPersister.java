package com.android.server.wm;

import android.os.Environment;
import android.os.LocaleList;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class PackageConfigPersister {
    private static final String ATTR_LOCALES = "locale_list";
    private static final String ATTR_NIGHT_MODE = "night_mode";
    private static final String ATTR_PACKAGE_NAME = "package_name";
    private static final boolean DEBUG = false;
    private static final String PACKAGE_DIRNAME = "package_configs";
    private static final String SUFFIX_FILE_NAME = "_config.xml";
    private static final String TAG = null;
    private static final String TAG_CONFIG = "config";
    private final ActivityTaskManagerService mAtm;
    private final Object mLock;
    private final SparseArray<HashMap<String, PackageConfigRecord>> mModified;
    private final SparseArray<HashMap<String, PackageConfigRecord>> mPendingWrite;
    private final PersisterQueue mPersisterQueue;

    private static class DeletePackageItem implements PersisterQueue.WriteQueueItem {
        final String mPackageName;
        final int mUserId;

        DeletePackageItem(int userId, String packageName) {
            this.mUserId = userId;
            this.mPackageName = packageName;
        }

        @Override // com.android.server.wm.PersisterQueue.WriteQueueItem
        public void process() {
            File userConfigsDir = PackageConfigPersister.m10073$$Nest$smgetUserConfigsDir(this.mUserId);
            if (userConfigsDir.isDirectory() == true) goto L5;
            return;
        L5:
            AtomicFile atomicFile = new AtomicFile(new File(userConfigsDir, this.mPackageName + PackageConfigPersister.SUFFIX_FILE_NAME));
            if (atomicFile.exists() == false) goto L9;
            atomicFile.delete();
            return;
        }
    }

    static class PackageConfigRecord {
        Integer mGrammaticalGender;
        LocaleList mLocales;
        final String mName;
        Integer mNightMode;
        final int mUserId;

        PackageConfigRecord(String name, int userId) {
            this.mName = name;
            this.mUserId = userId;
        }

        boolean isResetNightMode() {
            if (this.mNightMode.intValue() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return "PackageConfigRecord package name: " + this.mName + " userId " + this.mUserId + " nightMode " + this.mNightMode + " locales " + this.mLocales;
        }
    }

    private class WriteProcessItem implements PersisterQueue.WriteQueueItem {
        final PackageConfigRecord mRecord;
        final /* synthetic */ PackageConfigPersister this$0;

        WriteProcessItem(PackageConfigPersister r1, PackageConfigRecord record) {
            this.this$0 = r1;
            this.mRecord = record;
        }

        @Override // com.android.server.wm.PersisterQueue.WriteQueueItem
        public void process() {
            byte[] data = null;
            Object r1 = PackageConfigPersister.m10069$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            data = saveToXml();     // Catch: Throwable -> L6 Exception -> L8
        L6:
            th = move-exception;
            throw th;
        L9:
            PackageConfigPersister.m10071$$Nest$mremoveRecord(this.this$0, PackageConfigPersister.m10070$$Nest$fgetmPendingWrite(this.this$0), this.mRecord);     // Catch: Throwable -> L6
            monitor-exit(r1);     // Catch: Throwable -> L6
            if (data == null) goto L34;
            AtomicFile atomicFile = null;
            File userConfigsDir = PackageConfigPersister.m10073$$Nest$smgetUserConfigsDir(this.mRecord.mUserId);     // Catch: IOException -> L19
            if (userConfigsDir.isDirectory() == false) goto L16;
        L21:
            AtomicFile atomicFile2 = new AtomicFile(new File(userConfigsDir, this.mRecord.mName + PackageConfigPersister.SUFFIX_FILE_NAME));     // Catch: IOException -> L19
            FileOutputStream file = atomicFile2.startWrite();     // Catch: IOException -> L19
            file.write(data);     // Catch: IOException -> L19
            atomicFile2.finishWrite(file);     // Catch: IOException -> L19
            return;
        L16:
            if (userConfigsDir.mkdirs() == true) goto L21;
            Slog.e(PackageConfigPersister.m10072$$Nest$sfgetTAG(), "Failure creating tasks directory for user " + this.mRecord.mUserId + ": " + userConfigsDir);     // Catch: IOException -> L19
            return;
        L19:
            e = move-exception;
            if (0 == 0) goto L26;
            atomicFile.failWrite(null);
        L26:
            Slog.e(PackageConfigPersister.m10072$$Nest$sfgetTAG(), "Unable to open null for persisting. " + e);
            return;
        }

        private byte[] saveToXml() throws IOException {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            TypedXmlSerializer xmlSerializer = Xml.resolveSerializer(os);
            xmlSerializer.startDocument(null, true);
            xmlSerializer.startTag(null, PackageConfigPersister.TAG_CONFIG);
            xmlSerializer.attribute(null, PackageConfigPersister.ATTR_PACKAGE_NAME, this.mRecord.mName);
            if (this.mRecord.mNightMode == null) goto L6;
            xmlSerializer.attributeInt(null, PackageConfigPersister.ATTR_NIGHT_MODE, this.mRecord.mNightMode.intValue());
        L6:
            if (this.mRecord.mLocales == null) goto L8;
            xmlSerializer.attribute(null, PackageConfigPersister.ATTR_LOCALES, this.mRecord.mLocales.toLanguageTags());
        L8:
            xmlSerializer.endTag(null, PackageConfigPersister.TAG_CONFIG);
            xmlSerializer.endDocument();
            xmlSerializer.flush();
            return os.toByteArray();
        }
    }

    public static /* synthetic */ boolean $r8$lambda$iSRBi5n3VpljuRAISUCymNqheUQ(PackageConfigRecord r0, WriteProcessItem r1) {
        return lambda$removePackage$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$kBFoPe6pCdq8Zbpn9XNnCpYp-os, reason: not valid java name */
    public static /* synthetic */ void m10068$r8$lambda$kBFoPe6pCdq8Zbpn9XNnCpYpos(PackageConfigPersister r0, String r1, PackageConfigRecord r2) {
        r0.lambda$removeUser$0(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m10069$$Nest$fgetmLock(PackageConfigPersister r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingWrite, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m10070$$Nest$fgetmPendingWrite(PackageConfigPersister r0) {
        return r0.mPendingWrite;
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10071$$Nest$mremoveRecord(PackageConfigPersister r0, SparseArray r1, PackageConfigRecord r2) {
        r0.removeRecord(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m10072$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smgetUserConfigsDir, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m10073$$Nest$smgetUserConfigsDir(int r0) {
        return getUserConfigsDir(r0);
    }

    static {
        TAG = PackageConfigPersister.class.getSimpleName();
    }

    private static File getUserConfigsDir(int userId) {
        return new File(Environment.getDataSystemCeDirectory(userId), PACKAGE_DIRNAME);
    }

    PackageConfigPersister(PersisterQueue queue, ActivityTaskManagerService atm) {
        this.mLock = new Object();
        this.mPendingWrite = new SparseArray();
        this.mModified = new SparseArray();
        this.mPersisterQueue = queue;
        this.mAtm = atm;
    }

    void loadUserPackages(int userId) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        File userConfigsDir = getUserConfigsDir(userId);     // Catch: Throwable -> L9
        File[] configFiles = userConfigsDir.listFiles();     // Catch: Throwable -> L9
        if (configFiles != null) goto L11;
        Slog.v(TAG, "loadPackages: empty list files from " + userConfigsDir);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L11:
        int fileIndex = 0;
    L13:
        if (fileIndex >= configFiles.length) goto L88;
        File configFile = configFiles[fileIndex];     // Catch: Throwable -> L9
        if (configFile.getName().endsWith(SUFFIX_FILE_NAME) == false) goto L86;
        InputStream is = new FileInputStream(configFile);     // Catch: Throwable -> L9 XmlPullParserException -> L76 IOException -> L78 FileNotFoundException -> L80
    L92:
        TypedXmlPullParser in = Xml.resolvePullParser(is);     // Catch: Throwable -> L36
        String packageName = null;
        Integer nightMode = null;
        LocaleList locales = null;
    L20:
        int event = in.next();     // Catch: Throwable -> L36
        if (event == 1) goto L53;
        if (event == 3) goto L53;
        String name = in.getName();     // Catch: Throwable -> L36
        if (event != 2) goto L52;
        if (TAG_CONFIG.equals(name) == false) goto L52;
        int attIdx = in.getAttributeCount() - 1;     // Catch: Throwable -> L36
    L29:
        if (attIdx < 0) goto L52;
        String attrName = in.getAttributeName(attIdx);     // Catch: Throwable -> L36
        String attrValue = in.getAttributeValue(attIdx);     // Catch: Throwable -> L36
        switch(attrName.hashCode()) {
            case -1877165340: goto L43;
            case -601793174: goto L40;
            case 1912882019: goto L34;
            default: goto L45;
        };     // Catch: Throwable -> L36
    L45:
        byte r13 = -1;
    L46:
        switch(r13) {
            case 0: goto L50;
            case 1: goto L49;
            case 2: goto L48;
            default: goto L51;
        };     // Catch: Throwable -> L36
    L48:
        locales = LocaleList.forLanguageTags(attrValue);     // Catch: Throwable -> L36
        goto L51
    L49:
        Integer nightMode2 = Integer.valueOf(Integer.parseInt(attrValue));     // Catch: Throwable -> L36
        nightMode = nightMode2;
        goto L51
    L50:
        packageName = attrValue;
    L51:
        attIdx = attIdx - 1;     // Catch: Throwable -> L36
        goto L29
    L34:
        if (attrName.equals(ATTR_LOCALES) == false) goto L45;
        r13 = 2;
        goto L46
    L40:
        if (attrName.equals(ATTR_NIGHT_MODE) == false) goto L45;
        r13 = 1;
        goto L46
    L43:
        if (attrName.equals(ATTR_PACKAGE_NAME) == false) goto L45;
        r13 = 0;
    L52:
        XmlUtils.skipCurrentTag(in);     // Catch: Throwable -> L36
    L53:
        if (packageName == null) goto L102;
        PackageConfigRecord initRecord = findRecordOrCreate(this.mModified, packageName, userId);     // Catch: Throwable -> L58
        initRecord.mNightMode = nightMode;     // Catch: Throwable -> L58
        initRecord.mLocales = locales;     // Catch: Throwable -> L58
    L58:
        th = th;
    L38:
        Throwable r8 = th;
        is.close();     // Catch: Throwable -> L73
    L75:
        throw r8;     // Catch: Throwable -> L63 XmlPullParserException -> L65 IOException -> L67 FileNotFoundException -> L69
    L69:
        e = e;
    L85:
        e.printStackTrace();     // Catch: Throwable -> L63
    L67:
        e = e;
    L84:
        e.printStackTrace();     // Catch: Throwable -> L63
    L65:
        e = e;
    L83:
        e.printStackTrace();     // Catch: Throwable -> L63
    L73:
        th = move-exception;
        r8.addSuppressed(th);     // Catch: Throwable -> L63 XmlPullParserException -> L65 IOException -> L67 FileNotFoundException -> L69
    L102:
        is.close();     // Catch: Throwable -> L63 XmlPullParserException -> L65 IOException -> L67 FileNotFoundException -> L69
    L36:
        th = th;
    L80:
        e = e;
    L78:
        e = e;
    L76:
        e = e;
    L86:
        fileIndex = fileIndex + 1;     // Catch: Throwable -> L63
        goto L13
    L88:
        monitor-exit(r2);     // Catch: Throwable -> L63
        return;
    L9:
        th = th;
    L90:
        monitor-exit(r2);     // Catch: Throwable -> L63
        throw th;
    L63:
        th = th;
        goto L90
    }

    void updateConfigIfNeeded(ConfigurationContainer container, int userId, String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackageConfigRecord modifiedRecord = findRecord(this.mModified, packageName, userId);     // Catch: Throwable -> L7
        if (modifiedRecord == null) goto L9;
        container.applyAppSpecificConfig(modifiedRecord.mNightMode, LocaleOverlayHelper.combineLocalesIfOverlayExists(modifiedRecord.mLocales, this.mAtm.getGlobalConfiguration().getLocales()), modifiedRecord.mGrammaticalGender);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        container.applyAppSpecificConfig(null, null, null);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    boolean updateFromImpl(String packageName, int userId, PackageConfigurationUpdaterImpl impl) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean isRecordPresent = false;
        PackageConfigRecord record = findRecord(this.mModified, packageName, userId);     // Catch: Throwable -> L14
        if (record == null) goto L8;
        isRecordPresent = true;
    L9:
        boolean isNightModeChanged = updateNightMode(impl.getNightMode(), record);     // Catch: Throwable -> L14
        boolean isLocalesChanged = updateLocales(impl.getLocales(), record);     // Catch: Throwable -> L14
        boolean isGenderChanged = updateGender(impl.getGrammaticalGender(), record);     // Catch: Throwable -> L14
        if (record.mNightMode == null) goto L17;
        if (record.isResetNightMode() == true) goto L17;
    L26:
        if (isNightModeChanged == true) goto L31;
        if (isLocalesChanged == true) goto L31;
        if (isGenderChanged == true) goto L31;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    L31:
        PackageConfigRecord pendingRecord = findRecord(this.mPendingWrite, record.mName, record.mUserId);     // Catch: Throwable -> L14
        if (pendingRecord != null) goto L34;
        PackageConfigRecord writeRecord = findRecordOrCreate(this.mPendingWrite, record.mName, record.mUserId);     // Catch: Throwable -> L14
    L36:
        if (updateNightMode(record.mNightMode, writeRecord) == false) goto L38;
    L43:
        this.mPersisterQueue.addItem(new WriteProcessItem(this, writeRecord), false);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L38:
        if (updateLocales(record.mLocales, writeRecord) == true) goto L43;
        if (updateGender(record.mGrammaticalGender, writeRecord) == true) goto L43;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    L34:
        writeRecord = pendingRecord;
    L17:
        if (record.mLocales == null) goto L21;
        if (record.mLocales.isEmpty() == false) goto L26;
    L21:
        if (record.mGrammaticalGender != null) goto L23;
    L47:
        removePackage(packageName, userId);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return isRecordPresent;
    L23:
        if (record.mGrammaticalGender.intValue() != 0) goto L26;
    L8:
        record = findRecordOrCreate(this.mModified, packageName, userId);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private boolean updateNightMode(Integer requestedNightMode, PackageConfigRecord record) {
        if (requestedNightMode != null) goto L4;
        return false;
    L4:
        if (requestedNightMode.equals(record.mNightMode) == true) goto L10;
        record.mNightMode = requestedNightMode;
        return true;
    L10:
        return false;
    }

    private boolean updateLocales(LocaleList requestedLocaleList, PackageConfigRecord record) {
        if (requestedLocaleList != null) goto L4;
        return false;
    L4:
        if (requestedLocaleList.equals(record.mLocales) == true) goto L10;
        record.mLocales = requestedLocaleList;
        return true;
    L10:
        return false;
    }

    private boolean updateGender(Integer requestedGender, PackageConfigRecord record) {
        if (requestedGender != null) goto L4;
        return false;
    L4:
        if (requestedGender.equals(record.mGrammaticalGender) == true) goto L10;
        record.mGrammaticalGender = requestedGender;
        return true;
    L10:
        return false;
    }

    void removeUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        HashMap<String, PackageConfigRecord> modifyRecords = this.mModified.get(userId);     // Catch: Throwable -> L9
        HashMap<String, PackageConfigRecord> writeRecords = this.mPendingWrite.get(userId);     // Catch: Throwable -> L9
        if (modifyRecords == null) goto L11;
        if (modifyRecords.size() == 0) goto L11;
    L15:
        HashMap<String, PackageConfigRecord> tempList = new HashMap(modifyRecords);     // Catch: Throwable -> L9
        tempList.forEach(new PackageConfigPersister$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        if (writeRecords != null) goto L13;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L13:
        if (writeRecords.size() != 0) goto L15;
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$removeUser$0(String name, PackageConfigRecord record) {
        removePackage(record.mName, record.mUserId);
    }

    void onPackageUninstall(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removePackage(packageName, userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onPackageDataCleared(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removePackage(packageName, userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removePackage(String packageName, int userId) {
        final PackageConfigRecord record = findRecord(this.mPendingWrite, packageName, userId);
        if (record == null) goto L5;
        removeRecord(this.mPendingWrite, record);
        this.mPersisterQueue.removeItems(new PackageConfigPersister$$ExternalSyntheticLambda1(record), WriteProcessItem.class);
    L5:
        PackageConfigRecord modifyRecord = findRecord(this.mModified, packageName, userId);
        if (modifyRecord == null) goto L9;
        removeRecord(this.mModified, modifyRecord);
        this.mPersisterQueue.addItem(new DeletePackageItem(userId, packageName), false);
        return;
    }

    private static /* synthetic */ boolean lambda$removePackage$1(PackageConfigRecord record, WriteProcessItem item) {
        if (item.mRecord.mName == record.mName) goto L5;
    L7:
        return false;
    L5:
        if (item.mRecord.mUserId != record.mUserId) goto L7;
        return true;
    }

    ActivityTaskManagerInternal.PackageConfig findPackageConfiguration(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackageConfigRecord packageConfigRecord = findRecord(this.mModified, packageName, userId);     // Catch: Throwable -> L10
        if (packageConfigRecord != null) goto L12;
        Slog.w(TAG, "App-specific configuration not found for packageName: " + packageName + " and userId: " + userId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return null;
    L12:
        ActivityTaskManagerInternal.PackageConfig r2 = new ActivityTaskManagerInternal.PackageConfig(packageConfigRecord.mNightMode, packageConfigRecord.mLocales, packageConfigRecord.mGrammaticalGender);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw, int userId) {
        pw.println("INSTALLED PACKAGES HAVING APP-SPECIFIC CONFIGURATIONS");
        pw.println("Current user ID : " + userId);
        Object r0 = this.mLock;
        monitor-enter(r0);
        HashMap<String, PackageConfigRecord> persistedPackageConfigMap = this.mModified.get(userId);     // Catch: Throwable -> L10
        if (persistedPackageConfigMap == null) goto L12;
        Iterator<PackageConfigRecord> r2 = persistedPackageConfigMap.values().iterator();     // Catch: Throwable -> L10
    L8:
        if (r2.hasNext() == false) goto L12;
        PackageConfigRecord packageConfig = r2.next();     // Catch: Throwable -> L10
        pw.println();     // Catch: Throwable -> L10
        pw.println("    PackageName : " + packageConfig.mName);     // Catch: Throwable -> L10
        pw.println("        NightMode : " + packageConfig.mNightMode);     // Catch: Throwable -> L10
        pw.println("        Locales : " + packageConfig.mLocales);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private PackageConfigRecord findRecordOrCreate(SparseArray<HashMap<String, PackageConfigRecord>> list, String name, int userId) {
        HashMap<String, PackageConfigRecord> records = list.get(userId);
        if (records != null) goto L5;
        records = new HashMap();
        list.put(userId, records);
    L5:
        PackageConfigRecord record = records.get(name);
        if (record == null) goto L8;
        return record;
    L8:
        PackageConfigRecord record2 = new PackageConfigRecord(name, userId);
        records.put(name, record2);
        return record2;
    }

    private PackageConfigRecord findRecord(SparseArray<HashMap<String, PackageConfigRecord>> list, String name, int userId) {
        HashMap<String, PackageConfigRecord> packages = list.get(userId);
        if (packages != null) goto L7;
        return null;
    L7:
        return packages.get(name);
    }

    private void removeRecord(SparseArray<HashMap<String, PackageConfigRecord>> list, PackageConfigRecord record) {
        HashMap<String, PackageConfigRecord> processes = list.get(record.mUserId);
        if (processes == null) goto L6;
        processes.remove(record.mName);
        return;
    }
}
