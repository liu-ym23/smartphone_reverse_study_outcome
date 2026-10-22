package com.android.server.devicepolicy;

import android.app.admin.SystemUpdateInfo;
import android.app.admin.SystemUpdatePolicy;
import android.content.ComponentName;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.am.ProcessList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
class OwnersData {
    private static final String ATTR_CAN_ACCESS_DEVICE_IDS = "canAccessDeviceIds";
    private static final String ATTR_COMPONENT_NAME = "component";
    private static final String ATTR_DEVICE_OWNER_TYPE_VALUE = "value";
    private static final String ATTR_FREEZE_RECORD_END = "end";
    private static final String ATTR_FREEZE_RECORD_START = "start";
    private static final String ATTR_MEMORY_TAGGING_MIGRATED = "memoryTaggingMigrated";
    private static final String ATTR_MIGRATED_POST_UPGRADE = "migratedPostUpgrade";
    private static final String ATTR_MIGRATED_TO_POLICY_ENGINE = "migratedToPolicyEngine";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PACKAGE = "package";
    private static final String ATTR_PROFILE_OWNER_OF_ORG_OWNED_DEVICE = "isPoOrganizationOwnedDevice";
    private static final String ATTR_REMOTE_BUGREPORT_HASH = "remoteBugreportHash";
    private static final String ATTR_REMOTE_BUGREPORT_URI = "remoteBugreportUri";
    private static final String ATTR_REQUIRED_PASSWORD_COMPLEXITY_MIGRATED = "passwordComplexityMigrated";
    private static final String ATTR_RESET_PASSWORD_WITH_TOKEN_MIGRATED = "resetPasswordWithTokenMigrated";
    private static final String ATTR_SECURITY_LOG_MIGRATED = "securityLogMigrated";
    private static final String ATTR_SET_KEYGUARD_DISABLED_FEATURES_MIGRATED = "setKeyguardDisabledFeaturesMigrated";
    private static final String ATTR_SIZE = "size";
    private static final String ATTR_SUSPENDED_PACKAGES_MIGRATED = "suspendedPackagesMigrated";
    private static final String ATTR_USERID = "userId";
    private static final boolean DEBUG = false;
    private static final String DEVICE_OWNER_XML = "device_owner_2.xml";
    private static final String PROFILE_OWNER_XML = "profile_owner.xml";
    private static final String TAG = "DevicePolicyManagerService";
    private static final String TAG_DEVICE_OWNER = "device-owner";
    private static final String TAG_DEVICE_OWNER_CONTEXT = "device-owner-context";
    private static final String TAG_DEVICE_OWNER_PROTECTED_PACKAGES = "device-owner-protected-packages";
    private static final String TAG_DEVICE_OWNER_TYPE = "device-owner-type";
    private static final String TAG_FREEZE_PERIOD_RECORD = "freeze-record";
    private static final String TAG_PENDING_OTA_INFO = "pending-ota-info";
    private static final String TAG_POLICY_ENGINE_MIGRATION = "policy-engine-migration";
    private static final String TAG_PROFILE_OWNER = "profile-owner";
    private static final String TAG_ROOT = "root";
    private static final String TAG_SYSTEM_UPDATE_POLICY = "system-update-policy";
    OwnerInfo mDeviceOwner;

    @Deprecated
    ArrayMap<String, List<String>> mDeviceOwnerProtectedPackages;
    final ArrayMap<String, Integer> mDeviceOwnerTypes;
    int mDeviceOwnerUserId;
    boolean mMemoryTaggingMigrated;
    boolean mMigratedToPolicyEngine;
    private final PolicyPathProvider mPathProvider;
    boolean mPoliciesMigratedPostUpdate;
    final ArrayMap<Integer, OwnerInfo> mProfileOwners;
    boolean mRequiredPasswordComplexityMigrated;
    boolean mResetPasswordWithTokenMigrated;
    boolean mSecurityLoggingMigrated;
    boolean mSetKeyguardDisabledFeaturesMigrated;
    boolean mSuspendedPackagesMigrated;
    LocalDate mSystemUpdateFreezeEnd;
    LocalDate mSystemUpdateFreezeStart;
    SystemUpdateInfo mSystemUpdateInfo;
    SystemUpdatePolicy mSystemUpdatePolicy;

    private class DeviceOwnerReadWriter extends FileReadWriter {
        final /* synthetic */ OwnersData this$0;

        protected DeviceOwnerReadWriter(OwnersData r1) {
            this.this$0 = r1;
            super(r1.getDeviceOwnerFile());
        }

        @Override // com.android.server.devicepolicy.OwnersData.FileReadWriter
        boolean shouldWrite() {
            return true;
        }

        @Override // com.android.server.devicepolicy.OwnersData.FileReadWriter
        void writeInner(TypedXmlSerializer out) throws IOException {
            if (this.this$0.mDeviceOwner == null) goto L6;
            this.this$0.mDeviceOwner.writeToXml(out, OwnersData.TAG_DEVICE_OWNER);
            out.startTag(null, OwnersData.TAG_DEVICE_OWNER_CONTEXT);
            out.attributeInt(null, "userId", this.this$0.mDeviceOwnerUserId);
            out.endTag(null, OwnersData.TAG_DEVICE_OWNER_CONTEXT);
        L6:
            if (this.this$0.mDeviceOwnerTypes.isEmpty() == true) goto L12;
            Iterator<Map.Entry<String, Integer>> r0 = this.this$0.mDeviceOwnerTypes.entrySet().iterator();
        L9:
            if (r0.hasNext() == false) goto L12;
            Map.Entry<String, Integer> entry = r0.next();
            out.startTag(null, OwnersData.TAG_DEVICE_OWNER_TYPE);
            out.attribute(null, "package", entry.getKey());
            out.attributeInt(null, OwnersData.ATTR_DEVICE_OWNER_TYPE_VALUE, entry.getValue().intValue());
            out.endTag(null, OwnersData.TAG_DEVICE_OWNER_TYPE);
        L12:
            if (this.this$0.mSystemUpdatePolicy == null) goto L15;
            out.startTag(null, OwnersData.TAG_SYSTEM_UPDATE_POLICY);
            this.this$0.mSystemUpdatePolicy.saveToXml(out);
            out.endTag(null, OwnersData.TAG_SYSTEM_UPDATE_POLICY);
        L15:
            if (this.this$0.mSystemUpdateInfo == null) goto L18;
            this.this$0.mSystemUpdateInfo.writeToXml(out, OwnersData.TAG_PENDING_OTA_INFO);
        L18:
            if (this.this$0.mSystemUpdateFreezeStart == null) goto L20;
        L21:
            out.startTag(null, OwnersData.TAG_FREEZE_PERIOD_RECORD);
            if (this.this$0.mSystemUpdateFreezeStart == null) goto L25;
            out.attribute(null, "start", this.this$0.mSystemUpdateFreezeStart.toString());
        L25:
            if (this.this$0.mSystemUpdateFreezeEnd == null) goto L27;
            out.attribute(null, OwnersData.ATTR_FREEZE_RECORD_END, this.this$0.mSystemUpdateFreezeEnd.toString());
        L27:
            out.endTag(null, OwnersData.TAG_FREEZE_PERIOD_RECORD);
        L28:
            out.startTag(null, OwnersData.TAG_POLICY_ENGINE_MIGRATION);
            out.attributeBoolean(null, OwnersData.ATTR_MIGRATED_TO_POLICY_ENGINE, this.this$0.mMigratedToPolicyEngine);
            out.attributeBoolean(null, OwnersData.ATTR_MIGRATED_POST_UPGRADE, this.this$0.mPoliciesMigratedPostUpdate);
            out.attributeBoolean(null, OwnersData.ATTR_SECURITY_LOG_MIGRATED, this.this$0.mSecurityLoggingMigrated);
            out.attributeBoolean(null, OwnersData.ATTR_SUSPENDED_PACKAGES_MIGRATED, this.this$0.mSuspendedPackagesMigrated);
            out.attributeBoolean(null, OwnersData.ATTR_MEMORY_TAGGING_MIGRATED, this.this$0.mMemoryTaggingMigrated);
            out.endTag(null, OwnersData.TAG_POLICY_ENGINE_MIGRATION);
            return;
        L20:
            if (this.this$0.mSystemUpdateFreezeEnd == null) goto L28;
            goto L21
        }

        @Override // com.android.server.devicepolicy.OwnersData.FileReadWriter
        boolean readInner(TypedXmlPullParser parser, int depth, String tag) {
            byte r1 = 2;
            if (depth <= 2) goto L6;
            return true;
        L6:
            switch(tag.hashCode()) {
                case -2101756875: goto L30;
                case -2020438916: goto L27;
                case -1900517026: goto L24;
                case -725102274: goto L21;
                case -465393379: goto L18;
                case 544117227: goto L15;
                case 1303827527: goto L12;
                case 1748301720: goto L9;
                default: goto L32;
            };
        L32:
            r1 = -1;
        L34:
            switch(r1) {
                case 0: goto L59;
                case 1: goto L58;
                case 2: goto L57;
                case 3: goto L56;
                case 4: goto L50;
                case 5: goto L49;
                case 6: goto L42;
                case 7: goto L37;
                default: goto L35;
            };
        L35:
            Slog.e(OwnersData.TAG, "Unexpected tag: " + tag);
            return false;
        L37:
            this.this$0.mMigratedToPolicyEngine = parser.getAttributeBoolean(null, OwnersData.ATTR_MIGRATED_TO_POLICY_ENGINE, false);
            this.this$0.mPoliciesMigratedPostUpdate = parser.getAttributeBoolean(null, OwnersData.ATTR_MIGRATED_POST_UPGRADE, false);
            this.this$0.mSecurityLoggingMigrated = parser.getAttributeBoolean(null, OwnersData.ATTR_SECURITY_LOG_MIGRATED, false);
            this.this$0.mRequiredPasswordComplexityMigrated = false;
            OwnersData r2 = this.this$0;
            if (parser.getAttributeBoolean(null, OwnersData.ATTR_SUSPENDED_PACKAGES_MIGRATED, false) == false) goto L40;
            boolean r3 = true;
        L41:
            r2.mSuspendedPackagesMigrated = r3;
            this.this$0.mResetPasswordWithTokenMigrated = false;
            this.this$0.mMemoryTaggingMigrated = parser.getAttributeBoolean(null, OwnersData.ATTR_MEMORY_TAGGING_MIGRATED, false);
            this.this$0.mSetKeyguardDisabledFeaturesMigrated = false;
        L60:
            return true;
        L40:
            r3 = false;
            goto L41
        L42:
            String packageName = parser.getAttributeValue(null, "package");
            int protectedPackagesSize = parser.getAttributeInt(null, OwnersData.ATTR_SIZE, 0);
            List<String> protectedPackages = new ArrayList();
            int i = 0;
        L43:
            if (i >= protectedPackagesSize) goto L46;
            protectedPackages.add(parser.getAttributeValue(null, "name" + i));
            i = i + 1;
            goto L43
        L46:
            if (this.this$0.mDeviceOwnerProtectedPackages != null) goto L48;
            this.this$0.mDeviceOwnerProtectedPackages = new ArrayMap();
        L48:
            this.this$0.mDeviceOwnerProtectedPackages.put(packageName, protectedPackages);
            goto L60
        L49:
            String packageName2 = parser.getAttributeValue(null, "package");
            int deviceOwnerType = parser.getAttributeInt(null, OwnersData.ATTR_DEVICE_OWNER_TYPE_VALUE, 0);
            this.this$0.mDeviceOwnerTypes.put(packageName2, Integer.valueOf(deviceOwnerType));
            goto L60
        L50:
            String startDate = parser.getAttributeValue(null, "start");
            String endDate = parser.getAttributeValue(null, OwnersData.ATTR_FREEZE_RECORD_END);
            if (startDate == null) goto L60;
            if (endDate == null) goto L60;
            this.this$0.mSystemUpdateFreezeStart = LocalDate.parse(startDate);
            this.this$0.mSystemUpdateFreezeEnd = LocalDate.parse(endDate);
            if (this.this$0.mSystemUpdateFreezeStart.isAfter(this.this$0.mSystemUpdateFreezeEnd) == false) goto L60;
            Slog.e(OwnersData.TAG, "Invalid system update freeze record loaded");
            this.this$0.mSystemUpdateFreezeStart = null;
            this.this$0.mSystemUpdateFreezeEnd = null;
            goto L60
        L56:
            this.this$0.mSystemUpdateInfo = SystemUpdateInfo.readFromXml(parser);
            goto L60
        L57:
            this.this$0.mSystemUpdatePolicy = SystemUpdatePolicy.restoreFromXml(parser);
            goto L60
        L58:
            this.this$0.mDeviceOwnerUserId = parser.getAttributeInt(null, "userId", this.this$0.mDeviceOwnerUserId);
            goto L60
        L59:
            this.this$0.mDeviceOwner = OwnerInfo.readFromXml(parser);
            this.this$0.mDeviceOwnerUserId = 0;
            goto L60
        L9:
            if (tag.equals(OwnersData.TAG_SYSTEM_UPDATE_POLICY) == false) goto L32;
        L12:
            if (tag.equals(OwnersData.TAG_FREEZE_PERIOD_RECORD) == false) goto L32;
            r1 = 4;
            goto L34
        L15:
            if (tag.equals(OwnersData.TAG_DEVICE_OWNER_TYPE) == false) goto L32;
            r1 = 5;
            goto L34
        L18:
            if (tag.equals(OwnersData.TAG_DEVICE_OWNER_PROTECTED_PACKAGES) == false) goto L32;
            r1 = 6;
            goto L34
        L21:
            if (tag.equals(OwnersData.TAG_POLICY_ENGINE_MIGRATION) == false) goto L32;
            r1 = 7;
            goto L34
        L24:
            if (tag.equals(OwnersData.TAG_DEVICE_OWNER_CONTEXT) == false) goto L32;
            r1 = 1;
            goto L34
        L27:
            if (tag.equals(OwnersData.TAG_DEVICE_OWNER) == false) goto L32;
            r1 = 0;
            goto L34
        L30:
            if (tag.equals(OwnersData.TAG_PENDING_OTA_INFO) == false) goto L32;
            r1 = 3;
            goto L34
        }
    }

    private static abstract class FileReadWriter {
        private final File mFile;

        abstract boolean readInner(TypedXmlPullParser r1, int r2, String r3);

        abstract boolean shouldWrite();

        abstract void writeInner(TypedXmlSerializer r1) throws IOException;

        protected FileReadWriter(File file) {
            this.mFile = file;
        }

        boolean writeToFileLocked() {
            if (shouldWrite() == false) goto L5;
            AtomicFile f = new AtomicFile(this.mFile);
            FileOutputStream outputStream = null;
            outputStream = f.startWrite();     // Catch: IOException -> L14
            TypedXmlSerializer out = Xml.resolveSerializer(outputStream);     // Catch: IOException -> L14
            out.startDocument(null, true);     // Catch: IOException -> L14
            out.startTag(null, OwnersData.TAG_ROOT);     // Catch: IOException -> L14
            writeInner(out);     // Catch: IOException -> L14
            out.endTag(null, OwnersData.TAG_ROOT);     // Catch: IOException -> L14
            out.endDocument();     // Catch: IOException -> L14
            out.flush();     // Catch: IOException -> L14
            f.finishWrite(outputStream);     // Catch: IOException -> L14
            return true;
        L14:
            e = move-exception;
            Slog.e(OwnersData.TAG, "Exception when writing", e);
            if (outputStream == null) goto L22;
            f.failWrite(outputStream);
            return false;
        L22:
            return false;
        L5:
            if (this.mFile.exists() == true) goto L7;
        L9:
            return true;
        L7:
            if (this.mFile.delete() == true) goto L9;
            Slog.e(OwnersData.TAG, "Failed to remove " + this.mFile.getPath());
            goto L9
        }

        void readFromFileLocked() {
            if (this.mFile.exists() == true) goto L5;
            return;
        L5:
            AtomicFile f = new AtomicFile(this.mFile);
            InputStream input = null;
            input = f.openRead();     // Catch: Throwable -> L20 Throwable -> L22
            TypedXmlPullParser parser = Xml.resolvePullParser(input);     // Catch: Throwable -> L20 Throwable -> L22
            int depth = 0;
        L7:
            int type = parser.next();     // Catch: Throwable -> L20 Throwable -> L22
            if (type == 1) goto L30;
            switch(type) {
                case 2: goto L13;
                case 3: goto L11;
                default: goto L7;
            };     // Catch: Throwable -> L20 Throwable -> L22
        L13:
            depth = depth + 1;     // Catch: Throwable -> L20 Throwable -> L22
            String tag = parser.getName();     // Catch: Throwable -> L20 Throwable -> L22
            if (depth == 1) goto L16;
            if (readInner(parser, depth, tag) == true) goto L7;
            IoUtils.closeQuietly(input);
            return;
        L16:
            if (OwnersData.TAG_ROOT.equals(tag) == true) goto L7;
            Slog.e(OwnersData.TAG, "Invalid root tag: " + tag);     // Catch: Throwable -> L20 Throwable -> L22
            IoUtils.closeQuietly(input);
            return;
        L11:
            depth = depth - 1;     // Catch: Throwable -> L20 Throwable -> L22
        L30:
            IoUtils.closeQuietly(input);
            return;
        L20:
            th = move-exception;
            IoUtils.closeQuietly(input);
            throw th;
        L22:
            e = move-exception;
            Slog.e(OwnersData.TAG, "Error parsing owners information file", e);     // Catch: Throwable -> L20
            goto L30
        }
    }

    static class OwnerInfo {
        public final ComponentName admin;
        public boolean isOrganizationOwnedDevice;
        public final String packageName;
        public String remoteBugreportHash;
        public String remoteBugreportUri;

        OwnerInfo(ComponentName admin, String remoteBugreportUri, String remoteBugreportHash, boolean isOrganizationOwnedDevice) {
            this.admin = admin;
            this.packageName = admin.getPackageName();
            this.remoteBugreportUri = remoteBugreportUri;
            this.remoteBugreportHash = remoteBugreportHash;
            this.isOrganizationOwnedDevice = isOrganizationOwnedDevice;
        }

        public void writeToXml(TypedXmlSerializer out, String tag) throws IOException {
            out.startTag(null, tag);
            if (this.admin == null) goto L6;
            out.attribute(null, OwnersData.ATTR_COMPONENT_NAME, this.admin.flattenToString());
        L6:
            if (this.remoteBugreportUri == null) goto L9;
            out.attribute(null, OwnersData.ATTR_REMOTE_BUGREPORT_URI, this.remoteBugreportUri);
        L9:
            if (this.remoteBugreportHash == null) goto L12;
            out.attribute(null, OwnersData.ATTR_REMOTE_BUGREPORT_HASH, this.remoteBugreportHash);
        L12:
            if (this.isOrganizationOwnedDevice == false) goto L14;
            out.attributeBoolean(null, OwnersData.ATTR_PROFILE_OWNER_OF_ORG_OWNED_DEVICE, this.isOrganizationOwnedDevice);
        L14:
            out.endTag(null, tag);
        }

        public static OwnerInfo readFromXml(TypedXmlPullParser parser) {
            String componentName = parser.getAttributeValue(null, OwnersData.ATTR_COMPONENT_NAME);
            String remoteBugreportUri = parser.getAttributeValue(null, OwnersData.ATTR_REMOTE_BUGREPORT_URI);
            String remoteBugreportHash = parser.getAttributeValue(null, OwnersData.ATTR_REMOTE_BUGREPORT_HASH);
            String canAccessDeviceIdsStr = parser.getAttributeValue(null, OwnersData.ATTR_CAN_ACCESS_DEVICE_IDS);
            boolean canAccessDeviceIds = "true".equals(canAccessDeviceIdsStr);
            String isOrgOwnedDeviceStr = parser.getAttributeValue(null, OwnersData.ATTR_PROFILE_OWNER_OF_ORG_OWNED_DEVICE);
            boolean isOrgOwnedDevice = "true".equals(isOrgOwnedDeviceStr) | canAccessDeviceIds;
            if (componentName != null) goto L6;
            Slog.e(OwnersData.TAG, "Owner component not found");
            return null;
        L6:
            ComponentName admin = ComponentName.unflattenFromString(componentName);
            if (admin != null) goto L11;
            Slog.e(OwnersData.TAG, "Owner component not parsable: " + componentName);
            return null;
        L11:
            return new OwnerInfo(admin, remoteBugreportUri, remoteBugreportHash, isOrgOwnedDevice);
        }

        public void dump(IndentingPrintWriter pw) {
            pw.println("admin=" + this.admin);
            pw.println("package=" + this.packageName);
            pw.println("isOrganizationOwnedDevice=" + this.isOrganizationOwnedDevice);
        }
    }

    private class ProfileOwnerReadWriter extends FileReadWriter {
        private final int mUserId;
        final /* synthetic */ OwnersData this$0;

        ProfileOwnerReadWriter(OwnersData r1, int userId) {
            this.this$0 = r1;
            super(r1.getProfileOwnerFile(userId));
            this.mUserId = userId;
        }

        @Override // com.android.server.devicepolicy.OwnersData.FileReadWriter
        boolean shouldWrite() {
            if (this.this$0.mProfileOwners.get(Integer.valueOf(this.mUserId)) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.devicepolicy.OwnersData.FileReadWriter
        void writeInner(TypedXmlSerializer out) throws IOException {
            OwnerInfo profileOwner = this.this$0.mProfileOwners.get(Integer.valueOf(this.mUserId));
            if (profileOwner == null) goto L6;
            profileOwner.writeToXml(out, OwnersData.TAG_PROFILE_OWNER);
            return;
        }

        @Override // com.android.server.devicepolicy.OwnersData.FileReadWriter
        boolean readInner(TypedXmlPullParser parser, int depth, String tag) {
            if (depth <= 2) goto L6;
            return true;
        L6:
            switch(tag.hashCode()) {
                case 2145316239: goto L9;
                default: goto L11;
            };
        L11:
            byte r0 = -1;
        L12:
            switch(r0) {
                case 0: goto L15;
                default: goto L13;
            };
        L13:
            Slog.e(OwnersData.TAG, "Unexpected tag: " + tag);
            return false;
        L15:
            this.this$0.mProfileOwners.put(Integer.valueOf(this.mUserId), OwnerInfo.readFromXml(parser));
            return true;
        L9:
            if (tag.equals(OwnersData.TAG_PROFILE_OWNER) == false) goto L11;
            r0 = 0;
            goto L12
        }
    }

    OwnersData(PolicyPathProvider pathProvider) {
        this.mDeviceOwnerUserId = ProcessList.INVALID_ADJ;
        this.mDeviceOwnerTypes = new ArrayMap();
        this.mProfileOwners = new ArrayMap();
        this.mMigratedToPolicyEngine = false;
        this.mSecurityLoggingMigrated = false;
        this.mRequiredPasswordComplexityMigrated = false;
        this.mSuspendedPackagesMigrated = false;
        this.mResetPasswordWithTokenMigrated = false;
        this.mMemoryTaggingMigrated = false;
        this.mSetKeyguardDisabledFeaturesMigrated = false;
        this.mPoliciesMigratedPostUpdate = false;
        this.mPathProvider = pathProvider;
    }

    void load(int[] allUsers) {
        new DeviceOwnerReadWriter(this).readFromFileLocked();
        int r0 = allUsers.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int userId = allUsers[r1];
        new ProfileOwnerReadWriter(this, userId).readFromFileLocked();
        r1 = r1 + 1;
        goto L3
    L5:
        OwnerInfo profileOwner = this.mProfileOwners.get(Integer.valueOf(this.mDeviceOwnerUserId));
        if (profileOwner == null) goto L8;
        ComponentName admin = profileOwner.admin;
    L10:
        if (this.mDeviceOwner == null) goto L15;
        if (admin == null) goto L16;
        Slog.w(TAG, String.format("User %d has both DO and PO, which is not supported", new Object[]{Integer.valueOf(this.mDeviceOwnerUserId)}));
        return;
    L16:
        return;
    L15:
        return;
    L8:
        admin = null;
        goto L10
    }

    boolean writeDeviceOwner() {
        return new DeviceOwnerReadWriter(this).writeToFileLocked();
    }

    boolean writeProfileOwner(int userId) {
        return new ProfileOwnerReadWriter(this, userId).writeToFileLocked();
    }

    void dump(IndentingPrintWriter pw) {
        boolean needBlank = false;
        if (this.mDeviceOwner == null) goto L6;
        pw.println("Device Owner: ");
        pw.increaseIndent();
        this.mDeviceOwner.dump(pw);
        pw.println("User ID: " + this.mDeviceOwnerUserId);
        pw.decreaseIndent();
        needBlank = true;
    L6:
        if (this.mSystemUpdatePolicy == null) goto L11;
        if (needBlank == false) goto L9;
        pw.println();
    L9:
        pw.println("System Update Policy: " + this.mSystemUpdatePolicy);
        needBlank = true;
    L11:
        if (this.mProfileOwners == null) goto L20;
        Iterator<Map.Entry<Integer, OwnerInfo>> r1 = this.mProfileOwners.entrySet().iterator();
    L14:
        if (r1.hasNext() == false) goto L20;
        Map.Entry<Integer, OwnerInfo> entry = r1.next();
        if (needBlank == false) goto L18;
        pw.println();
    L18:
        pw.println("Profile Owner (User " + entry.getKey() + "): ");
        pw.increaseIndent();
        entry.getValue().dump(pw);
        pw.decreaseIndent();
        needBlank = true;
    L20:
        if (this.mSystemUpdateInfo == null) goto L25;
        if (needBlank == false) goto L23;
        pw.println();
    L23:
        pw.println("Pending System Update: " + this.mSystemUpdateInfo);
        needBlank = true;
    L25:
        if (this.mSystemUpdateFreezeStart == null) goto L27;
    L28:
        if (needBlank == false) goto L30;
        pw.println();
    L30:
        pw.println("System update freeze record: " + getSystemUpdateFreezePeriodRecordAsString());
        return;
    L27:
        if (this.mSystemUpdateFreezeEnd != null) goto L28;
    }

    String getSystemUpdateFreezePeriodRecordAsString() {
        StringBuilder freezePeriodRecord = new StringBuilder();
        freezePeriodRecord.append("start: ");
        if (this.mSystemUpdateFreezeStart == null) goto L5;
        freezePeriodRecord.append(this.mSystemUpdateFreezeStart.toString());
    L6:
        freezePeriodRecord.append("; end: ");
        if (this.mSystemUpdateFreezeEnd == null) goto L9;
        freezePeriodRecord.append(this.mSystemUpdateFreezeEnd.toString());
    L11:
        return freezePeriodRecord.toString();
    L9:
        freezePeriodRecord.append("null");
        goto L11
    L5:
        freezePeriodRecord.append("null");
        goto L6
    }

    File getDeviceOwnerFile() {
        return new File(this.mPathProvider.getDataSystemDirectory(), DEVICE_OWNER_XML);
    }

    File getProfileOwnerFile(int userId) {
        return new File(this.mPathProvider.getUserSystemDirectory(userId), PROFILE_OWNER_XML);
    }
}
