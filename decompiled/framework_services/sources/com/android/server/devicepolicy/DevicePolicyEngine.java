package com.android.server.devicepolicy;

import android.app.AppGlobals;
import android.app.BroadcastOptions;
import android.app.admin.BooleanPolicyValue;
import android.app.admin.DevicePolicyIdentifiers;
import android.app.admin.DevicePolicyState;
import android.app.admin.IntentFilterPolicyKey;
import android.app.admin.PolicyKey;
import android.app.admin.PolicyValue;
import android.app.admin.UserRestrictionPolicyKey;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.pm.UserProperties;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.telephony.TelephonyManager;
import android.util.AtomicFile;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.utils.Slogf;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class DevicePolicyEngine {
    private static final String CELLULAR_2G_USER_RESTRICTION_ID = null;
    static final int DEFAULT_POLICY_SIZE_LIMIT = -1;
    static final String DEVICE_LOCK_CONTROLLER_ROLE = "android.app.role.SYSTEM_FINANCED_DEVICE_CONTROLLER";
    static final String SYSTEM_SUPERVISION_ROLE = "android.app.role.SYSTEM_SUPERVISION";
    static final String TAG = "DevicePolicyEngine";
    private final SparseArray<HashMap<EnforcingAdmin, Integer>> mAdminPolicySize;
    private final Context mContext;
    private final DeviceAdminServiceController mDeviceAdminServiceController;
    private final SparseArray<Set<EnforcingAdmin>> mEnforcingAdmins;
    private final Map<PolicyKey, PolicyState<?>> mGlobalPolicies;
    private final SparseArray<Map<PolicyKey, PolicyState<?>>> mLocalPolicies;
    private final Object mLock;
    private int mPolicySizeLimit;
    private final UserManager mUserManager;

    private class DevicePoliciesReaderWriter {
        private static final String ATTR_POLICY_SUM_SIZE = "size";
        private static final String ATTR_USER_ID = "user-id";
        private static final String BACKUP_DIRECTORY = "device_policy_backups";
        private static final String BACKUP_FILENAME = "device_policy_state.%s.xml";
        private static final String DEVICE_POLICIES_XML = "device_policy_state.xml";
        private static final String TAG_ENFORCING_ADMIN = "enforcing-admin";
        private static final String TAG_ENFORCING_ADMINS_ENTRY = "enforcing-admins-entry";
        private static final String TAG_ENFORCING_ADMIN_AND_SIZE = "enforcing-admin-and-size";
        private static final String TAG_GLOBAL_POLICY_ENTRY = "global-policy-entry";
        private static final String TAG_LOCAL_POLICY_ENTRY = "local-policy-entry";
        private static final String TAG_MAX_POLICY_SIZE_LIMIT = "max-policy-size-limit";
        private static final String TAG_POLICY_KEY_ENTRY = "policy-key-entry";
        private static final String TAG_POLICY_STATE_ENTRY = "policy-state-entry";
        private static final String TAG_POLICY_SUM_SIZE = "policy-sum-size";
        private final File mFile;
        final /* synthetic */ DevicePolicyEngine this$0;

        /* synthetic */ DevicePoliciesReaderWriter(DevicePolicyEngine r1, DevicePolicyEngineIA r2) {
            this(r1);
        }

        private static File getFileName() {
            return new File(Environment.getDataSystemDirectory(), DEVICE_POLICIES_XML);
        }

        private DevicePoliciesReaderWriter(DevicePolicyEngine r1) {
            this.this$0 = r1;
            this.mFile = getFileName();
        }

        public static void createBackup(String backupId) {
            File backupDirectory = new File(Environment.getDataSystemDirectory(), BACKUP_DIRECTORY);     // Catch: Exception -> L6
            backupDirectory.mkdir();     // Catch: Exception -> L6
            Path backupPath = Path.of(backupDirectory.getPath(), new String[]{BACKUP_FILENAME.formatted(new Object[]{backupId})});     // Catch: Exception -> L6
            if (backupPath.toFile().exists() == false) goto L8;
            Log.w(DevicePolicyEngine.TAG, "Backup already exist: " + backupPath);     // Catch: Exception -> L6
        L12:
            return;
        L8:
            Files.copy(getFileName().toPath(), backupPath, new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});     // Catch: Exception -> L6
            Log.i(DevicePolicyEngine.TAG, "Backup created at " + backupPath);     // Catch: Exception -> L6
        L6:
            e = move-exception;
            Log.e(DevicePolicyEngine.TAG, "Cannot create backup " + backupId, e);
        }

        void writeToFileLocked() {
            Log.d(DevicePolicyEngine.TAG, "Writing to " + this.mFile);
            AtomicFile f = new AtomicFile(this.mFile);
            FileOutputStream outputStream = null;
            outputStream = f.startWrite();     // Catch: IOException -> L5
            TypedXmlSerializer out = Xml.resolveSerializer(outputStream);     // Catch: IOException -> L5
            out.startDocument(null, true);     // Catch: IOException -> L5
            writeInnerLocked(out);     // Catch: IOException -> L5
            out.endDocument();     // Catch: IOException -> L5
            out.flush();     // Catch: IOException -> L5
            f.finishWrite(outputStream);     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            Log.e(DevicePolicyEngine.TAG, "Exception when writing", e);
            if (outputStream == null) goto L10;
            f.failWrite(outputStream);
        }

        void writeInnerLocked(TypedXmlSerializer serializer) throws IOException {
            writeLocalPoliciesInnerLocked(serializer);
            writeGlobalPoliciesInnerLocked(serializer);
            writeEnforcingAdminsInnerLocked(serializer);
            writeEnforcingAdminSizeInnerLocked(serializer);
            writeMaxPolicySizeInnerLocked(serializer);
        }

        private void writeLocalPoliciesInnerLocked(TypedXmlSerializer serializer) throws IOException {
            if (DevicePolicyEngine.m3335$$Nest$fgetmLocalPolicies(this.this$0) == null) goto L12;
            int i = 0;
        L6:
            if (i >= DevicePolicyEngine.m3335$$Nest$fgetmLocalPolicies(this.this$0).size()) goto L15;
            int userId = DevicePolicyEngine.m3335$$Nest$fgetmLocalPolicies(this.this$0).keyAt(i);
            Iterator r2 = ((Map) DevicePolicyEngine.m3335$$Nest$fgetmLocalPolicies(this.this$0).get(userId)).entrySet().iterator();
        L9:
            if (r2.hasNext() == false) goto L11;
            Map.Entry<PolicyKey, PolicyState<?>> policy = (Map.Entry) r2.next();
            serializer.startTag(null, TAG_LOCAL_POLICY_ENTRY);
            serializer.attributeInt(null, ATTR_USER_ID, userId);
            serializer.startTag(null, TAG_POLICY_KEY_ENTRY);
            policy.getKey().saveToXml(serializer);
            serializer.endTag(null, TAG_POLICY_KEY_ENTRY);
            serializer.startTag(null, TAG_POLICY_STATE_ENTRY);
            policy.getValue().saveToXml(serializer);
            serializer.endTag(null, TAG_POLICY_STATE_ENTRY);
            serializer.endTag(null, TAG_LOCAL_POLICY_ENTRY);
            goto L9
        L11:
            i = i + 1;
            goto L6
        L15:
            return;
        }

        private void writeGlobalPoliciesInnerLocked(TypedXmlSerializer serializer) throws IOException {
            if (DevicePolicyEngine.m3334$$Nest$fgetmGlobalPolicies(this.this$0) == null) goto L8;
            Iterator r0 = DevicePolicyEngine.m3334$$Nest$fgetmGlobalPolicies(this.this$0).entrySet().iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            Map.Entry<PolicyKey, PolicyState<?>> policy = (Map.Entry) r0.next();
            serializer.startTag(null, TAG_GLOBAL_POLICY_ENTRY);
            serializer.startTag(null, TAG_POLICY_KEY_ENTRY);
            policy.getKey().saveToXml(serializer);
            serializer.endTag(null, TAG_POLICY_KEY_ENTRY);
            serializer.startTag(null, TAG_POLICY_STATE_ENTRY);
            policy.getValue().saveToXml(serializer);
            serializer.endTag(null, TAG_POLICY_STATE_ENTRY);
            serializer.endTag(null, TAG_GLOBAL_POLICY_ENTRY);
            goto L6
        L10:
            return;
        }

        private void writeEnforcingAdminsInnerLocked(TypedXmlSerializer serializer) throws IOException {
            if (DevicePolicyEngine.m3333$$Nest$fgetmEnforcingAdmins(this.this$0) == null) goto L12;
            int i = 0;
        L6:
            if (i >= DevicePolicyEngine.m3333$$Nest$fgetmEnforcingAdmins(this.this$0).size()) goto L15;
            int userId = DevicePolicyEngine.m3333$$Nest$fgetmEnforcingAdmins(this.this$0).keyAt(i);
            Iterator r2 = ((Set) DevicePolicyEngine.m3333$$Nest$fgetmEnforcingAdmins(this.this$0).get(userId)).iterator();
        L9:
            if (r2.hasNext() == false) goto L11;
            EnforcingAdmin admin = (EnforcingAdmin) r2.next();
            serializer.startTag(null, TAG_ENFORCING_ADMINS_ENTRY);
            admin.saveToXml(serializer);
            serializer.endTag(null, TAG_ENFORCING_ADMINS_ENTRY);
            goto L9
        L11:
            i = i + 1;
            goto L6
        L15:
            return;
        }

        private void writeEnforcingAdminSizeInnerLocked(TypedXmlSerializer serializer) throws IOException {
            if (DevicePolicyEngine.m3332$$Nest$fgetmAdminPolicySize(this.this$0) == null) goto L12;
            int i = 0;
        L6:
            if (i >= DevicePolicyEngine.m3332$$Nest$fgetmAdminPolicySize(this.this$0).size()) goto L15;
            int userId = DevicePolicyEngine.m3332$$Nest$fgetmAdminPolicySize(this.this$0).keyAt(i);
            Iterator r2 = ((HashMap) DevicePolicyEngine.m3332$$Nest$fgetmAdminPolicySize(this.this$0).get(userId)).keySet().iterator();
        L9:
            if (r2.hasNext() == false) goto L11;
            EnforcingAdmin admin = (EnforcingAdmin) r2.next();
            serializer.startTag(null, TAG_ENFORCING_ADMIN_AND_SIZE);
            serializer.startTag(null, TAG_ENFORCING_ADMIN);
            admin.saveToXml(serializer);
            serializer.endTag(null, TAG_ENFORCING_ADMIN);
            serializer.startTag(null, TAG_POLICY_SUM_SIZE);
            serializer.attributeInt(null, ATTR_POLICY_SUM_SIZE, ((Integer) ((HashMap) DevicePolicyEngine.m3332$$Nest$fgetmAdminPolicySize(this.this$0).get(userId)).get(admin)).intValue());
            serializer.endTag(null, TAG_POLICY_SUM_SIZE);
            serializer.endTag(null, TAG_ENFORCING_ADMIN_AND_SIZE);
            goto L9
        L11:
            i = i + 1;
            goto L6
        L15:
            return;
        }

        private void writeMaxPolicySizeInnerLocked(TypedXmlSerializer serializer) throws IOException {
            serializer.startTag(null, TAG_MAX_POLICY_SIZE_LIMIT);
            serializer.attributeInt(null, ATTR_POLICY_SUM_SIZE, DevicePolicyEngine.m3336$$Nest$fgetmPolicySizeLimit(this.this$0));
            serializer.endTag(null, TAG_MAX_POLICY_SIZE_LIMIT);
        }

        void readFromFileLocked() {
            if (this.mFile.exists() == true) goto L6;
            Log.d(DevicePolicyEngine.TAG, "" + this.mFile + " doesn't exist");
            return;
        L6:
            Log.d(DevicePolicyEngine.TAG, "Reading from " + this.mFile);
            AtomicFile f = new AtomicFile(this.mFile);
            InputStream input = null;
            input = f.openRead();     // Catch: Throwable -> L9 Throwable -> L11
            TypedXmlPullParser parser = Xml.resolvePullParser(input);     // Catch: Throwable -> L9 Throwable -> L11
            readInnerLocked(parser);     // Catch: Throwable -> L9 Throwable -> L11
        L8:
            IoUtils.closeQuietly(input);
            return;
        L11:
            e = move-exception;
            Slogf.wtf(DevicePolicyEngine.TAG, "Error parsing resources file", e);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            IoUtils.closeQuietly(input);
            throw th;
        }

        private void readInnerLocked(TypedXmlPullParser parser) throws IOException, XmlPullParserException, ClassNotFoundException {
            int outerDepth = parser.getDepth();
        L4:
            if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L35;
            String tag = parser.getName();
            switch(tag.hashCode()) {
                case -1900677631: goto L21;
                case -1329955015: goto L18;
                case -949666205: goto L15;
                case 134595137: goto L12;
                case 1016501079: goto L9;
                default: goto L23;
            };
        L23:
            byte r2 = -1;
        L24:
            switch(r2) {
                case 0: goto L30;
                case 1: goto L29;
                case 2: goto L28;
                case 3: goto L27;
                case 4: goto L26;
                default: goto L25;
            };
        L26:
            readMaxPolicySizeInner(parser);
            goto L4
        L27:
            readEnforcingAdminAndSizeInner(parser);
            goto L4
        L28:
            readEnforcingAdminsInner(parser);
            goto L4
        L29:
            readPoliciesInner(parser, DevicePolicyEngine.m3334$$Nest$fgetmGlobalPolicies(this.this$0));
            goto L4
        L30:
            int userId = parser.getAttributeInt(null, ATTR_USER_ID);
            if (DevicePolicyEngine.m3335$$Nest$fgetmLocalPolicies(this.this$0).contains(userId) == true) goto L33;
            DevicePolicyEngine.m3335$$Nest$fgetmLocalPolicies(this.this$0).put(userId, new HashMap());
        L33:
            readPoliciesInner(parser, (Map) DevicePolicyEngine.m3335$$Nest$fgetmLocalPolicies(this.this$0).get(userId));
            goto L4
        L25:
            Slogf.wtf(DevicePolicyEngine.TAG, "Unknown tag " + tag);
            goto L4
        L9:
            if (tag.equals(TAG_ENFORCING_ADMINS_ENTRY) == false) goto L23;
            r2 = 2;
            goto L24
        L12:
            if (tag.equals(TAG_MAX_POLICY_SIZE_LIMIT) == false) goto L23;
            r2 = 4;
            goto L24
        L15:
            if (tag.equals(TAG_ENFORCING_ADMIN_AND_SIZE) == false) goto L23;
            r2 = 3;
            goto L24
        L18:
            if (tag.equals(TAG_LOCAL_POLICY_ENTRY) == false) goto L23;
            r2 = 0;
            goto L24
        L21:
            if (tag.equals(TAG_GLOBAL_POLICY_ENTRY) == false) goto L23;
            r2 = 1;
            goto L24
        }

        private static void readPoliciesInner(TypedXmlPullParser parser, Map<PolicyKey, PolicyState<?>> policyStateMap) throws IOException, XmlPullParserException {
            PolicyKey policyKey = null;
            PolicyDefinition<?> policyDefinition = null;
            PolicyState<?> policyState = null;
            int outerDepth = parser.getDepth();
        L4:
            if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L24;
            String tag = parser.getName();
            switch(tag.hashCode()) {
                case 1439131817: goto L12;
                case 1917578267: goto L9;
                default: goto L14;
            };
        L14:
            byte r6 = -1;
        L15:
            switch(r6) {
                case 0: goto L20;
                case 1: goto L17;
                default: goto L16;
            };
        L17:
            if (policyDefinition == null) goto L18;
            policyState = PolicyState.readFromXml(policyDefinition, parser);
            goto L4
        L18:
            Slogf.w(DevicePolicyEngine.TAG, "Skipping policy state - unknown policy definition");
            goto L4
        L20:
            policyDefinition = PolicyDefinition.readFromXml(parser);
            if (policyDefinition == null) goto L4;
            policyKey = policyDefinition.getPolicyKey();
            goto L4
        L16:
            Slogf.wtf(DevicePolicyEngine.TAG, "Unknown tag for policy entry" + tag);
            goto L4
        L9:
            if (tag.equals(TAG_POLICY_STATE_ENTRY) == false) goto L14;
            r6 = 1;
            goto L15
        L12:
            if (tag.equals(TAG_POLICY_KEY_ENTRY) == false) goto L14;
            r6 = 0;
            goto L15
        L24:
            if (policyKey == null) goto L29;
            if (policyState == null) goto L29;
            policyStateMap.put(policyKey, policyState);
            return;
        L29:
            Slogf.wtf(DevicePolicyEngine.TAG, "Error parsing policy, policyKey is %s, and policyState is %s.", new Object[]{policyKey, policyState});
        }

        private void readEnforcingAdminsInner(TypedXmlPullParser parser) throws XmlPullParserException {
            EnforcingAdmin admin = EnforcingAdmin.readFromXml(parser);
            if (admin != null) goto L7;
            Slogf.wtf(DevicePolicyEngine.TAG, "Error parsing enforcingAdmins, EnforcingAdmin is null.");
            return;
        L7:
            if (DevicePolicyEngine.m3333$$Nest$fgetmEnforcingAdmins(this.this$0).contains(admin.getUserId()) == true) goto L9;
            DevicePolicyEngine.m3333$$Nest$fgetmEnforcingAdmins(this.this$0).put(admin.getUserId(), new HashSet());
        L9:
            ((Set) DevicePolicyEngine.m3333$$Nest$fgetmEnforcingAdmins(this.this$0).get(admin.getUserId())).add(admin);
        }

        private void readEnforcingAdminAndSizeInner(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
            int outerDepth = parser.getDepth();
            EnforcingAdmin admin = null;
            int size = 0;
        L4:
            if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L20;
            String tag = parser.getName();
            switch(tag.hashCode()) {
                case -1290014687: goto L12;
                case -1249111938: goto L9;
                default: goto L14;
            };
        L14:
            byte r5 = -1;
        L15:
            switch(r5) {
                case 0: goto L18;
                case 1: goto L17;
                default: goto L16;
            };
        L17:
            size = parser.getAttributeInt(null, ATTR_POLICY_SUM_SIZE);
            goto L4
        L18:
            admin = EnforcingAdmin.readFromXml(parser);
            goto L4
        L16:
            Slogf.wtf(DevicePolicyEngine.TAG, "Unknown tag " + tag);
            goto L4
        L9:
            if (tag.equals(TAG_POLICY_SUM_SIZE) == false) goto L14;
            r5 = 1;
            goto L15
        L12:
            if (tag.equals(TAG_ENFORCING_ADMIN) == false) goto L14;
            r5 = 0;
            goto L15
        L20:
            if (admin != null) goto L23;
            Slogf.wtf(DevicePolicyEngine.TAG, "Error parsing enforcingAdmins, EnforcingAdmin is null.");
            return;
        L23:
            if (size > 0) goto L27;
            Slogf.wtf(DevicePolicyEngine.TAG, "Error parsing policy size, size is " + size);
            return;
        L27:
            if (DevicePolicyEngine.m3332$$Nest$fgetmAdminPolicySize(this.this$0).contains(admin.getUserId()) == true) goto L29;
            DevicePolicyEngine.m3332$$Nest$fgetmAdminPolicySize(this.this$0).put(admin.getUserId(), new HashMap());
        L29:
            ((HashMap) DevicePolicyEngine.m3332$$Nest$fgetmAdminPolicySize(this.this$0).get(admin.getUserId())).put(admin, Integer.valueOf(size));
        }

        private void readMaxPolicySizeInner(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
            DevicePolicyEngine.m3337$$Nest$fputmPolicySizeLimit(this.this$0, parser.getAttributeInt(null, ATTR_POLICY_SUM_SIZE));
        }
    }

    public static /* synthetic */ void $r8$lambda$50AwKzKYkOlsFpMRChGeKbNAIWw(DevicePolicyEngine r0, Intent r1, EnforcingAdmin r2, PolicyDefinition r3, int r4, int r5) {
        r0.lambda$maybeSendOnPolicyChanged$4(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$HEsFA9ci1FtT28qaffzy5LIPWrk(DevicePolicyEngine r0, int r1, String r2, String r3) {
        r0.lambda$handlePackageChanged$6(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$IxGEP9uo91WWwelHBNTlMPQ4Ci0(DevicePolicyEngine r0, PolicyDefinition r1) {
        r0.lambda$forceEnforcementRefreshLocked$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$UbBIWajvlgkeyZV1KUC4Hq9lSXI(DevicePolicyEngine r0, Intent r1, EnforcingAdmin r2, PolicyDefinition r3, int r4, int r5) {
        r0.lambda$sendPolicyResultToAdmin$3(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$bD2OYhKK2KHgzA47EkdNUupPEOw(DevicePolicyEngine r0, UserInfo r1) {
        r0.lambda$enforcePoliciesOnInheritableProfilesIfApplicable$7(r1);
    }

    public static /* synthetic */ void $r8$lambda$bDNaosMrhDPuq_Z2aOL_ojrwXq8(DevicePolicyEngine r0, Intent r1, int r2, Bundle r3) {
        r0.lambda$sendDevicePolicyChangedToSystem$2(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$kMXmfdDXbRpwOs8CtHJBxfa6iN8(DevicePolicyEngine r0, int r1, PolicyValue r2, PolicyDefinition r3, EnforcingAdmin r4) {
        r0.lambda$applyToInheritableProfiles$1(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$rKfEcU3QBSV-7f98mRsav6nNv-s, reason: not valid java name */
    public static /* synthetic */ Integer m3331$r8$lambda$rKfEcU3QBSV7f98mRsav6nNvs(DevicePolicyEngine r0, int r1) {
        return r0.lambda$getProfileParentId$5(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAdminPolicySize, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m3332$$Nest$fgetmAdminPolicySize(DevicePolicyEngine r0) {
        return r0.mAdminPolicySize;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnforcingAdmins, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m3333$$Nest$fgetmEnforcingAdmins(DevicePolicyEngine r0) {
        return r0.mEnforcingAdmins;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGlobalPolicies, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m3334$$Nest$fgetmGlobalPolicies(DevicePolicyEngine r0) {
        return r0.mGlobalPolicies;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLocalPolicies, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m3335$$Nest$fgetmLocalPolicies(DevicePolicyEngine r0) {
        return r0.mLocalPolicies;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPolicySizeLimit, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3336$$Nest$fgetmPolicySizeLimit(DevicePolicyEngine r0) {
        return r0.mPolicySizeLimit;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPolicySizeLimit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3337$$Nest$fputmPolicySizeLimit(DevicePolicyEngine r0, int r1) {
        r0.mPolicySizeLimit = r1;
    }

    static {
        CELLULAR_2G_USER_RESTRICTION_ID = DevicePolicyIdentifiers.getIdentifierForUserRestriction("no_cellular_2g");
    }

    DevicePolicyEngine(Context context, DeviceAdminServiceController deviceAdminServiceController, Object lock) {
        this.mPolicySizeLimit = -1;
        context.getClass();
        this.mContext = context;
        deviceAdminServiceController.getClass();
        this.mDeviceAdminServiceController = deviceAdminServiceController;
        lock.getClass();
        this.mLock = lock;
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        this.mLocalPolicies = new SparseArray();
        this.mGlobalPolicies = new HashMap();
        this.mEnforcingAdmins = new SparseArray();
        this.mAdminPolicySize = new SparseArray();
    }

    private void forceEnforcementRefreshIfUserRestrictionLocked(PolicyDefinition<?> policyDefinition) {
    L6:
        e = move-exception;
        Log.e(TAG, "Exception thrown during forceEnforcementRefreshIfUserRestrictionLocked", e);
        return;
    L3:
        if (isUserRestrictionPolicy(policyDefinition) == false) goto L13;
        forceEnforcementRefreshLocked(policyDefinition);     // Catch: Throwable -> L6
        return;
    }

    private boolean isUserRestrictionPolicy(PolicyDefinition<?> policyDefinition) {
        if (policyDefinition != null) goto L5;
        return false;
    L5:
        PolicyKey policyKey = policyDefinition.getPolicyKey();
        if (policyKey != null) goto L9;
        return false;
    L9:
        if ((policyKey instanceof UserRestrictionPolicyKey) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private void forceEnforcementRefreshLocked(final PolicyDefinition<Boolean> policyDefinition) {
        Binder.withCleanCallingIdentity(new DevicePolicyEngine$$ExternalSyntheticLambda5(this, policyDefinition));
    }

    private /* synthetic */ void lambda$forceEnforcementRefreshLocked$0(PolicyDefinition policyDefinition) throws Exception {
        PolicyValue<Boolean> globalValue = new BooleanPolicyValue(false);
        PolicyState<Boolean> policyState = getGlobalPolicyStateLocked(policyDefinition);     // Catch: IllegalArgumentException -> L5
        globalValue = policyState.getCurrentResolvedPolicy();     // Catch: IllegalArgumentException -> L5
    L6:
        enforcePolicy(policyDefinition, globalValue, -1);
        Iterator r2 = this.mUserManager.getUsers().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        UserInfo user = (UserInfo) r2.next();
        PolicyValue<Boolean> localValue = new BooleanPolicyValue(false);
        PolicyState<Boolean> localPolicyState = getLocalPolicyStateLocked(policyDefinition, user.id);     // Catch: IllegalArgumentException -> L12
        localValue = localPolicyState.getCurrentResolvedPolicy();     // Catch: IllegalArgumentException -> L12
    L13:
        enforcePolicy(policyDefinition, localValue, user.id);
        goto L8
    }

    <V> void setLocalPolicy(PolicyDefinition<V> policyDefinition, EnforcingAdmin enforcingAdmin, PolicyValue<V> value, int userId, boolean skipEnforcePolicy) {
        policyDefinition.getClass();
        enforcingAdmin.getClass();
        Object r8 = this.mLock;
        monitor-enter(r8);
        PolicyState<V> localPolicyState = getLocalPolicyStateLocked(policyDefinition, userId);     // Catch: Throwable -> L53
        if (handleAdminPolicySizeLimit(localPolicyState, enforcingAdmin, value, policyDefinition, userId) == true) goto L13;
        monitor-exit(r8);     // Catch: Throwable -> L10
        return;
    L13:
        if (policyDefinition.isNonCoexistablePolicy() == true) goto L62;
        boolean hasGlobalPolicies = hasGlobalPolicyLocked(policyDefinition);     // Catch: Throwable -> L19
        if (hasGlobalPolicies == false) goto L26;
        PolicyState<V> globalPolicyState = getGlobalPolicyStateLocked(policyDefinition);     // Catch: Throwable -> L19
        boolean policyChanged = localPolicyState.addPolicy(enforcingAdmin, value, globalPolicyState.getPoliciesSetByAdmins());     // Catch: Throwable -> L19
    L27:
        if (skipEnforcePolicy == true) goto L48;
        forceEnforcementRefreshIfUserRestrictionLocked(policyDefinition);     // Catch: Throwable -> L19
        if (policyChanged == false) goto L31;
        onLocalPolicyChangedLocked(policyDefinition, enforcingAdmin, userId);     // Catch: Throwable -> L19
    L31:
        boolean policyEnforced = Objects.equals(localPolicyState.getCurrentResolvedPolicy(), value);     // Catch: Throwable -> L19
        int r10 = 0;
        if (policyEnforced == false) goto L34;
    L44:
        if (policyEnforced == true) goto L47;
        r10 = 1;
    L47:
        sendPolicyResultToAdmin(enforcingAdmin, policyDefinition, r10, userId);     // Catch: Throwable -> L19
        goto L48
    L34:
        if (shouldApplyPackageSetUnionPolicyHack(policyDefinition) == false) goto L44;
        PolicyValue<V> r13 = localPolicyState.getCurrentResolvedPolicy();     // Catch: Throwable -> L19
        if (r13 == null) goto L41;
        if (value == null) goto L41;
        if (((Set) r13.getValue()).containsAll((Collection) value.getValue()) == false) goto L41;
        boolean r14 = true;
    L42:
        policyEnforced = r14;
    L41:
        r14 = false;
    L48:
        updateDeviceAdminServiceOnPolicyAddLocked(enforcingAdmin);     // Catch: Throwable -> L19
        write();     // Catch: Throwable -> L19
        applyToInheritableProfiles(policyDefinition, enforcingAdmin, value, userId);     // Catch: Throwable -> L19
        monitor-exit(r8);     // Catch: Throwable -> L19
        return;
    L26:
        policyChanged = localPolicyState.addPolicy(enforcingAdmin, value);     // Catch: Throwable -> L19
        goto L27
    L62:
        setNonCoexistableLocalPolicyLocked(policyDefinition, localPolicyState, enforcingAdmin, value, userId, skipEnforcePolicy);     // Catch: Throwable -> L21
        monitor-exit(r8);     // Catch: Throwable -> L19
        return;
    L21:
        th = th;
    L55:
        monitor-exit(r8);     // Catch: Throwable -> L19
        throw th;
    L10:
        th = th;
    L51:
        th = th;
    L19:
        th = th;
    L53:
        th = th;
        goto L55
    }

    private <V> void setNonCoexistableLocalPolicyLocked(PolicyDefinition<V> policyDefinition, PolicyState<V> localPolicyState, EnforcingAdmin enforcingAdmin, PolicyValue<V> value, int userId, boolean skipEnforcePolicy) {
        if (value != null) goto L4;
        localPolicyState.removePolicy(enforcingAdmin);
    L5:
        if (skipEnforcePolicy == true) goto L8;
        enforcePolicy(policyDefinition, value, userId);
    L8:
        if (localPolicyState.getPoliciesSetByAdmins().isEmpty() == false) goto L10;
        removeLocalPolicyStateLocked(policyDefinition, userId);
    L10:
        updateDeviceAdminServiceOnPolicyAddLocked(enforcingAdmin);
        write();
        applyToInheritableProfiles(policyDefinition, enforcingAdmin, value, userId);
        return;
    L4:
        localPolicyState.addPolicy(enforcingAdmin, value);
        goto L5
    }

    <V> void setLocalPolicy(PolicyDefinition<V> policyDefinition, EnforcingAdmin enforcingAdmin, PolicyValue<V> value, int userId) {
        setLocalPolicy(policyDefinition, enforcingAdmin, value, userId, false);
    }

    <V> void removeLocalPolicy(PolicyDefinition<V> policyDefinition, EnforcingAdmin enforcingAdmin, int userId) {
        policyDefinition.getClass();
        enforcingAdmin.getClass();
        Object r1 = this.mLock;
        monitor-enter(r1);
        forceEnforcementRefreshIfUserRestrictionLocked(policyDefinition);     // Catch: Throwable -> L30
        if (hasLocalPolicyLocked(policyDefinition, userId) == false) goto L35;
        PolicyState<V> localPolicyState = getLocalPolicyStateLocked(policyDefinition, userId);     // Catch: Throwable -> L30
        decreasePolicySizeForAdmin(localPolicyState, enforcingAdmin);     // Catch: Throwable -> L30
        if (policyDefinition.isNonCoexistablePolicy() == false) goto L19;
        setNonCoexistableLocalPolicyLocked(policyDefinition, localPolicyState, enforcingAdmin, null, userId, false);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L19:
        if (hasGlobalPolicyLocked(policyDefinition) == false) goto L21;
        PolicyState<V> globalPolicyState = getGlobalPolicyStateLocked(policyDefinition);     // Catch: Throwable -> L16
        boolean policyChanged = localPolicyState.removePolicy(enforcingAdmin, globalPolicyState.getPoliciesSetByAdmins());     // Catch: Throwable -> L16
    L22:
        if (policyChanged == false) goto L24;
        onLocalPolicyChangedLocked(policyDefinition, enforcingAdmin, userId);     // Catch: Throwable -> L16
    L24:
        sendPolicyResultToAdmin(enforcingAdmin, policyDefinition, 2, userId);     // Catch: Throwable -> L16
        if (localPolicyState.getPoliciesSetByAdmins().isEmpty() == false) goto L27;
        removeLocalPolicyStateLocked(policyDefinition, userId);     // Catch: Throwable -> L16
    L27:
        updateDeviceAdminServiceOnPolicyRemoveLocked(enforcingAdmin);     // Catch: Throwable -> L16
        write();     // Catch: Throwable -> L16
        applyToInheritableProfiles(policyDefinition, enforcingAdmin, null, userId);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L21:
        policyChanged = localPolicyState.removePolicy(enforcingAdmin);     // Catch: Throwable -> L16
        goto L22
    L35:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = th;
    L32:
        monitor-exit(r1);     // Catch: Throwable -> L16
        throw th;
    L16:
        th = th;
    L30:
        th = th;
        goto L32
    }

    private <V> void applyToInheritableProfiles(final PolicyDefinition<V> policyDefinition, final EnforcingAdmin enforcingAdmin, final PolicyValue<V> value, final int userId) {
        if (policyDefinition.isInheritable() == true) goto L5;
        return;
    L5:
        Binder.withCleanCallingIdentity(new DevicePolicyEngine$$ExternalSyntheticLambda3(this, userId, value, policyDefinition, enforcingAdmin));
    }

    private /* synthetic */ void lambda$applyToInheritableProfiles$1(int userId, PolicyValue value, PolicyDefinition policyDefinition, EnforcingAdmin enforcingAdmin) throws Exception {
        List<UserInfo> userInfos = this.mUserManager.getProfiles(userId);
        Iterator<UserInfo> r1 = userInfos.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        UserInfo childUserInfo = r1.next();
        int childUserId = childUserInfo.getUserHandle().getIdentifier();
        if (isProfileOfUser(childUserId, userId) == false) goto L4;
        if (isInheritDevicePolicyFromParent(childUserInfo) == false) goto L4;
        if (value != null) goto L10;
        removeLocalPolicy(policyDefinition, enforcingAdmin, childUserId);
        goto L4
    L10:
        setLocalPolicy(policyDefinition, enforcingAdmin, value, childUserId);
        goto L4
    }

    private boolean isProfileOfUser(int childUserId, int parentUserId) {
        UserInfo parentInfo = this.mUserManager.getProfileParent(childUserId);
        if (childUserId == parentUserId) goto L8;
        if (parentInfo == null) goto L8;
        if (parentInfo.getUserHandle().getIdentifier() != parentUserId) goto L8;
        return true;
    L8:
        return false;
    }

    private boolean isInheritDevicePolicyFromParent(UserInfo userInfo) {
        UserProperties userProperties = this.mUserManager.getUserProperties(userInfo.getUserHandle());
        if (userProperties != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mUserManager.getUserProperties(userInfo.getUserHandle()).getInheritDevicePolicy() != 1) goto L7;
        return true;
    }

    private <V> void onLocalPolicyChangedLocked(PolicyDefinition<V> policyDefinition, EnforcingAdmin enforcingAdmin, int userId) {
        PolicyState<V> localPolicyState = getLocalPolicyStateLocked(policyDefinition, userId);
        enforcePolicy(policyDefinition, localPolicyState.getCurrentResolvedPolicy(), userId);
        sendPolicyChangedToAdminsLocked(localPolicyState, enforcingAdmin, policyDefinition, userId);
        if (hasGlobalPolicyLocked(policyDefinition) == false) goto L5;
        PolicyState<V> globalPolicyState = getGlobalPolicyStateLocked(policyDefinition);
        sendPolicyChangedToAdminsLocked(globalPolicyState, enforcingAdmin, policyDefinition, userId);
    L5:
        sendDevicePolicyChangedToSystem(userId);
    }

    <V> void setGlobalPolicy(PolicyDefinition<V> policyDefinition, EnforcingAdmin enforcingAdmin, PolicyValue<V> value) {
        setGlobalPolicy(policyDefinition, enforcingAdmin, value, false);
    }

    <V> void setGlobalPolicy(PolicyDefinition<V> policyDefinition, EnforcingAdmin enforcingAdmin, PolicyValue<V> value, boolean skipEnforcePolicy) {
        policyDefinition.getClass();
        enforcingAdmin.getClass();
        value.getClass();
        Object r7 = this.mLock;
        monitor-enter(r7);
        PolicyState<V> globalPolicyState = getGlobalPolicyStateLocked(policyDefinition);     // Catch: Throwable -> L45
        if (handleAdminPolicySizeLimit(globalPolicyState, enforcingAdmin, value, policyDefinition, -1) == true) goto L13;
        monitor-exit(r7);     // Catch: Throwable -> L10
        return;
    L13:
        if (checkFor2gFailure(policyDefinition, enforcingAdmin) == false) goto L17;
        Log.i(TAG, "Device does not support capabilities required to disable 2g. Not setting global policy state.");     // Catch: Throwable -> L10
        monitor-exit(r7);     // Catch: Throwable -> L10
        return;
    L17:
        boolean policyChanged = globalPolicyState.addPolicy(enforcingAdmin, value);     // Catch: Throwable -> L10
        boolean policyAppliedOnAllUsers = applyGlobalPolicyOnUsersWithLocalPoliciesLocked(policyDefinition, enforcingAdmin, value, skipEnforcePolicy);     // Catch: Throwable -> L10
        if (skipEnforcePolicy == true) goto L42;
        forceEnforcementRefreshIfUserRestrictionLocked(policyDefinition);     // Catch: Throwable -> L10
        if (policyChanged == false) goto L22;
        onGlobalPolicyChangedLocked(policyDefinition, enforcingAdmin);     // Catch: Throwable -> L10
    L22:
        boolean policyAppliedGlobally = Objects.equals(globalPolicyState.getCurrentResolvedPolicy(), value);     // Catch: Throwable -> L10
        int r8 = 0;
        if (policyAppliedGlobally == false) goto L25;
    L33:
        if (policyAppliedGlobally == false) goto L36;
        if (policyAppliedOnAllUsers == false) goto L36;
        boolean policyApplied = true;
    L38:
        if (policyApplied == true) goto L41;
        r8 = 1;
    L41:
        sendPolicyResultToAdmin(enforcingAdmin, policyDefinition, r8, -1);     // Catch: Throwable -> L10
    L36:
        policyApplied = false;
        goto L38
    L25:
        if (shouldApplyPackageSetUnionPolicyHack(policyDefinition) == false) goto L33;
        PolicyValue<V> r11 = globalPolicyState.getCurrentResolvedPolicy();     // Catch: Throwable -> L10
        if (r11 != null) goto L29;
    L31:
        boolean r12 = false;
    L32:
        policyAppliedGlobally = r12;
        goto L33
    L29:
        if (((Set) r11.getValue()).containsAll((Collection) value.getValue()) == false) goto L31;
        r12 = true;
    L42:
        updateDeviceAdminServiceOnPolicyAddLocked(enforcingAdmin);     // Catch: Throwable -> L10
        write();     // Catch: Throwable -> L10
        monitor-exit(r7);     // Catch: Throwable -> L10
        return;
    L10:
        th = th;
    L47:
        monitor-exit(r7);     // Catch: Throwable -> L10
        throw th;
    L45:
        th = th;
        goto L47
    }

    <V> void removeGlobalPolicy(PolicyDefinition<V> policyDefinition, EnforcingAdmin enforcingAdmin) {
        policyDefinition.getClass();
        enforcingAdmin.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        PolicyState<V> policyState = getGlobalPolicyStateLocked(policyDefinition);     // Catch: Throwable -> L7
        decreasePolicySizeForAdmin(policyState, enforcingAdmin);     // Catch: Throwable -> L7
        boolean policyChanged = policyState.removePolicy(enforcingAdmin);     // Catch: Throwable -> L7
        forceEnforcementRefreshIfUserRestrictionLocked(policyDefinition);     // Catch: Throwable -> L7
        if (policyChanged == false) goto L9;
        onGlobalPolicyChangedLocked(policyDefinition, enforcingAdmin);     // Catch: Throwable -> L7
    L9:
        applyGlobalPolicyOnUsersWithLocalPoliciesLocked(policyDefinition, enforcingAdmin, null, false);     // Catch: Throwable -> L7
        sendPolicyResultToAdmin(enforcingAdmin, policyDefinition, 2, -1);     // Catch: Throwable -> L7
        if (policyState.getPoliciesSetByAdmins().isEmpty() == false) goto L12;
        removeGlobalPolicyStateLocked(policyDefinition);     // Catch: Throwable -> L7
    L12:
        updateDeviceAdminServiceOnPolicyRemoveLocked(enforcingAdmin);     // Catch: Throwable -> L7
        write();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private <V> void onGlobalPolicyChangedLocked(PolicyDefinition<V> policyDefinition, EnforcingAdmin enforcingAdmin) {
        PolicyState<V> policyState = getGlobalPolicyStateLocked(policyDefinition);
        enforcePolicy(policyDefinition, policyState.getCurrentResolvedPolicy(), -1);
        sendPolicyChangedToAdminsLocked(policyState, enforcingAdmin, policyDefinition, -1);
        sendDevicePolicyChangedToSystem(-1);
    }

    private <V> boolean applyGlobalPolicyOnUsersWithLocalPoliciesLocked(PolicyDefinition<V> policyDefinition, EnforcingAdmin enforcingAdmin, PolicyValue<V> value, boolean skipEnforcePolicy) {
        if (policyDefinition.isGlobalOnlyPolicy() == false) goto L5;
        return true;
    L5:
        boolean isAdminPolicyApplied = true;
        int i = 0;
    L7:
        if (i >= this.mLocalPolicies.size()) goto L30;
        int userId = this.mLocalPolicies.keyAt(i);
        if (hasLocalPolicyLocked(policyDefinition, userId) == false) goto L28;
        PolicyState<V> localPolicyState = getLocalPolicyStateLocked(policyDefinition, userId);
        PolicyState<V> globalPolicyState = getGlobalPolicyStateLocked(policyDefinition);
        boolean policyChanged = localPolicyState.resolvePolicy(globalPolicyState.getPoliciesSetByAdmins());
        if (policyChanged == false) goto L16;
        if (skipEnforcePolicy == true) goto L16;
        enforcePolicy(policyDefinition, localPolicyState.getCurrentResolvedPolicy(), userId);
        sendPolicyChangedToAdminsLocked(localPolicyState, enforcingAdmin, policyDefinition, userId);
    L16:
        if (shouldApplyPackageSetUnionPolicyHack(policyDefinition) == true) goto L18;
        isAdminPolicyApplied = isAdminPolicyApplied & Objects.equals(value, localPolicyState.getCurrentResolvedPolicy());
        goto L28
    L18:
        if (Objects.equals(value, localPolicyState.getCurrentResolvedPolicy()) == true) goto L28;
        PolicyValue<V> r8 = localPolicyState.getCurrentResolvedPolicy();
        if (r8 == null) goto L25;
        if (value == null) goto L25;
        if (((Set) r8.getValue()).containsAll((Collection) value.getValue()) == false) goto L25;
        boolean r9 = true;
    L26:
        isAdminPolicyApplied = isAdminPolicyApplied & r9;
    L25:
        r9 = false;
    L28:
        i = i + 1;
        goto L7
    L30:
        return isAdminPolicyApplied;
    }

    <V> V getResolvedPolicy(PolicyDefinition<V> r3, int r4) {
        PolicyValue<V> r0 = getResolvedPolicyValue(r3, r4);
        if (r0 != null) goto L6;
        return null;
    L6:
        return (V) r0.getValue();
    }

    private <V> PolicyValue<V> getResolvedPolicyValue(PolicyDefinition<V> policyDefinition, int userId) {
        policyDefinition.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        PolicyValue<V> resolvedValue = null;
    L8:
        th = move-exception;
        throw th;
    L6:
        if (hasLocalPolicyLocked(policyDefinition, userId) == false) goto L11;
        resolvedValue = getLocalPolicyStateLocked(policyDefinition, userId).getCurrentResolvedPolicy();     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return resolvedValue;
    L11:
        if (hasGlobalPolicyLocked(policyDefinition) == false) goto L13;
        resolvedValue = getGlobalPolicyStateLocked(policyDefinition).getCurrentResolvedPolicy();     // Catch: Throwable -> L8
        goto L13
    }

    <V> V getResolvedPolicyAcrossUsers(PolicyDefinition<V> r6, List<Integer> r7) {
        r6.getClass();
        ArrayList r0 = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        Iterator<Integer> r2 = r7.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        PolicyValue<V> r4 = getResolvedPolicyValue(r6, r2.next().intValue());     // Catch: Throwable -> L10
        if (r4 == null) goto L6;
        r0.add(r4);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        PolicyValue<V> r3 = r6.getResolutionMechanism().resolve(r0);
        if (r3 != null) goto L18;
        return null;
    L18:
        return (V) r3.getValue();
    L10:
        th = move-exception;
        throw th;
    }

    <V> V getLocalPolicySetByAdmin(PolicyDefinition<V> r4, EnforcingAdmin r5, int r6) {
        r4.getClass();
        r5.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        V r2 = null;
        if (hasLocalPolicyLocked(r4, r6) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        PolicyValue<V> r1 = getLocalPolicyStateLocked(r4, r6).getPoliciesSetByAdmins().get(r5);     // Catch: Throwable -> L8
        if (r1 == null) goto L14;
        r2 = (V) r1.getValue();
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    <V> V getGlobalPolicySetByAdmin(PolicyDefinition<V> r4, EnforcingAdmin r5) {
        r4.getClass();
        r5.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        V r2 = null;
        if (hasGlobalPolicyLocked(r4) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        PolicyValue<V> r1 = getGlobalPolicyStateLocked(r4).getPoliciesSetByAdmins().get(r5);     // Catch: Throwable -> L8
        if (r1 == null) goto L14;
        r2 = (V) r1.getValue();
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    <V> LinkedHashMap<EnforcingAdmin, PolicyValue<V>> getLocalPoliciesSetByAdmins(PolicyDefinition<V> policyDefinition, int userId) {
        policyDefinition.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (hasLocalPolicyLocked(policyDefinition, userId) == true) goto L11;
        LinkedHashMap<EnforcingAdmin, PolicyValue<V>> r1 = new LinkedHashMap();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        LinkedHashMap<EnforcingAdmin, PolicyValue<V>> r2 = getLocalPolicyStateLocked(policyDefinition, userId).getPoliciesSetByAdmins();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    }

    <V> LinkedHashMap<EnforcingAdmin, PolicyValue<V>> getGlobalPoliciesSetByAdmins(PolicyDefinition<V> policyDefinition) {
        policyDefinition.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (hasGlobalPolicyLocked(policyDefinition) == true) goto L11;
        LinkedHashMap<EnforcingAdmin, PolicyValue<V>> r1 = new LinkedHashMap();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        LinkedHashMap<EnforcingAdmin, PolicyValue<V>> r2 = getGlobalPolicyStateLocked(policyDefinition).getPoliciesSetByAdmins();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    }

    <V> Set<PolicyKey> getLocalPolicyKeysSetByAdmin(PolicyDefinition<V> policyDefinition, EnforcingAdmin enforcingAdmin, int userId) {
        policyDefinition.getClass();
        enforcingAdmin.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (policyDefinition.isGlobalOnlyPolicy() == true) goto L22;
        if (this.mLocalPolicies.contains(userId) == false) goto L22;
        Set<PolicyKey> keys = new HashSet();     // Catch: Throwable -> L17
        Iterator<PolicyKey> r2 = this.mLocalPolicies.get(userId).keySet().iterator();     // Catch: Throwable -> L17
    L11:
        if (r2.hasNext() == false) goto L20;
        PolicyKey key = r2.next();     // Catch: Throwable -> L17
        if (key.hasSameIdentifierAs(policyDefinition.getPolicyKey()) == false) goto L11;
        if (this.mLocalPolicies.get(userId).get(key).getPoliciesSetByAdmins().containsKey(enforcingAdmin) == false) goto L11;
        keys.add(key);     // Catch: Throwable -> L17
        goto L11
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return keys;
    L22:
        Set<PolicyKey> keys2 = Set.of();     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return keys2;
    }

    <V> Set<PolicyKey> getLocalPolicyKeysSetByAllAdmins(PolicyDefinition<V> policyDefinition, int userId) {
        policyDefinition.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (policyDefinition.isGlobalOnlyPolicy() == true) goto L20;
        if (this.mLocalPolicies.contains(userId) == false) goto L20;
        Set<PolicyKey> keys = new HashSet();     // Catch: Throwable -> L15
        Iterator<PolicyKey> r2 = this.mLocalPolicies.get(userId).keySet().iterator();     // Catch: Throwable -> L15
    L11:
        if (r2.hasNext() == false) goto L18;
        PolicyKey key = r2.next();     // Catch: Throwable -> L15
        if (key.hasSameIdentifierAs(policyDefinition.getPolicyKey()) == false) goto L11;
        keys.add(key);     // Catch: Throwable -> L15
        goto L11
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return keys;
    L20:
        Set<PolicyKey> keys2 = Set.of();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return keys2;
    }

    Set<UserRestrictionPolicyKey> getUserRestrictionPolicyKeysForAdmin(EnforcingAdmin admin, int userId) {
        admin.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (userId != (-1)) goto L12;
        Set<UserRestrictionPolicyKey> r1 = getUserRestrictionPolicyKeysForAdminLocked(this.mGlobalPolicies, admin);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        if (this.mLocalPolicies.contains(userId) == true) goto L16;
        Set<UserRestrictionPolicyKey> r2 = Set.of();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L16:
        Set<UserRestrictionPolicyKey> r3 = getUserRestrictionPolicyKeysForAdminLocked(this.mLocalPolicies.get(userId), admin);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <V> void transferPolicies(EnforcingAdmin oldAdmin, EnforcingAdmin newAdmin) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Set<PolicyKey> globalPolicies = new HashSet(this.mGlobalPolicies.keySet());     // Catch: Throwable -> L10
        Iterator<PolicyKey> r2 = globalPolicies.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        PolicyKey policy = r2.next();     // Catch: Throwable -> L10
        PolicyState<?> policyState = this.mGlobalPolicies.get(policy);     // Catch: Throwable -> L10
        if (policyState.getPoliciesSetByAdmins().containsKey(oldAdmin) == false) goto L6;
        PolicyDefinition<V> policyDefinition = policyState.getPolicyDefinition();     // Catch: Throwable -> L10
        PolicyValue<?> policyValue = policyState.getPoliciesSetByAdmins().get(oldAdmin);     // Catch: Throwable -> L10
        setGlobalPolicy(policyDefinition, newAdmin, policyValue);     // Catch: Throwable -> L10
        goto L6
    L13:
        int i = 0;
    L15:
        if (i >= this.mLocalPolicies.size()) goto L25;
        int userId = this.mLocalPolicies.keyAt(i);     // Catch: Throwable -> L10
        Set<PolicyKey> localPolicies = new HashSet(this.mLocalPolicies.get(userId).keySet());     // Catch: Throwable -> L10
        Iterator<PolicyKey> r5 = localPolicies.iterator();     // Catch: Throwable -> L10
    L18:
        if (r5.hasNext() == false) goto L23;
        PolicyKey policy2 = r5.next();     // Catch: Throwable -> L10
        PolicyState<?> policyState2 = this.mLocalPolicies.get(userId).get(policy2);     // Catch: Throwable -> L10
        if (policyState2.getPoliciesSetByAdmins().containsKey(oldAdmin) == false) goto L18;
        PolicyDefinition<V> policyDefinition2 = policyState2.getPolicyDefinition();     // Catch: Throwable -> L10
        PolicyValue<?> policyValue2 = policyState2.getPoliciesSetByAdmins().get(oldAdmin);     // Catch: Throwable -> L10
        setLocalPolicy(policyDefinition2, newAdmin, policyValue2, userId);     // Catch: Throwable -> L10
        goto L18
    L23:
        i = i + 1;     // Catch: Throwable -> L10
        goto L15
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L10
        removePoliciesForAdmin(oldAdmin);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private Set<UserRestrictionPolicyKey> getUserRestrictionPolicyKeysForAdminLocked(Map<PolicyKey, PolicyState<?>> policies, EnforcingAdmin admin) {
        Set<UserRestrictionPolicyKey> keys = new HashSet();
        Iterator<PolicyKey> r1 = policies.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        UserRestrictionPolicyKey r2 = (PolicyKey) r1.next();
        if (policies.get(r2).getPolicyDefinition().isUserRestrictionPolicy() == false) goto L4;
        PolicyValue<?> r3 = policies.get(r2).getPoliciesSetByAdmins().get(admin);
        if (r3 == null) goto L4;
        if (((Boolean) r3.getValue()).booleanValue() == false) goto L4;
        keys.add(r2);
        goto L4
    L14:
        return keys;
    }

    private <V> boolean hasLocalPolicyLocked(PolicyDefinition<V> policyDefinition, int userId) {
        if (policyDefinition.isGlobalOnlyPolicy() == false) goto L6;
        return false;
    L6:
        if (this.mLocalPolicies.contains(userId) == true) goto L9;
        return false;
    L9:
        if (this.mLocalPolicies.get(userId).containsKey(policyDefinition.getPolicyKey()) == true) goto L12;
        return false;
    L12:
        return !this.mLocalPolicies.get(userId).get(policyDefinition.getPolicyKey()).getPoliciesSetByAdmins().isEmpty();
    }

    private <V> boolean hasGlobalPolicyLocked(PolicyDefinition<V> policyDefinition) {
        if (policyDefinition.isLocalOnlyPolicy() == false) goto L6;
        return false;
    L6:
        if (this.mGlobalPolicies.containsKey(policyDefinition.getPolicyKey()) == true) goto L9;
        return false;
    L9:
        return !this.mGlobalPolicies.get(policyDefinition.getPolicyKey()).getPoliciesSetByAdmins().isEmpty();
    }

    private <V> PolicyState<V> getLocalPolicyStateLocked(PolicyDefinition<V> policyDefinition, int userId) {
        if (policyDefinition.isGlobalOnlyPolicy() == true) goto L13;
        if (this.mLocalPolicies.contains(userId) == true) goto L8;
        this.mLocalPolicies.put(userId, new HashMap());
    L8:
        if (this.mLocalPolicies.get(userId).containsKey(policyDefinition.getPolicyKey()) == true) goto L11;
        this.mLocalPolicies.get(userId).put(policyDefinition.getPolicyKey(), new PolicyState(policyDefinition));
    L11:
        return getPolicyStateLocked(this.mLocalPolicies.get(userId), policyDefinition);
    L13:
        throw new IllegalArgumentException(policyDefinition.getPolicyKey() + " is a global only policy.");
    }

    private <V> void removeLocalPolicyStateLocked(PolicyDefinition<V> policyDefinition, int userId) {
        if (this.mLocalPolicies.contains(userId) == true) goto L5;
        return;
    L5:
        this.mLocalPolicies.get(userId).remove(policyDefinition.getPolicyKey());
    }

    private <V> PolicyState<V> getGlobalPolicyStateLocked(PolicyDefinition<V> policyDefinition) {
        if (policyDefinition.isLocalOnlyPolicy() == true) goto L10;
        if (this.mGlobalPolicies.containsKey(policyDefinition.getPolicyKey()) == true) goto L8;
        this.mGlobalPolicies.put(policyDefinition.getPolicyKey(), new PolicyState(policyDefinition));
    L8:
        return getPolicyStateLocked(this.mGlobalPolicies, policyDefinition);
    L10:
        throw new IllegalArgumentException(policyDefinition.getPolicyKey() + " is a local only policy.");
    }

    private <V> void removeGlobalPolicyStateLocked(PolicyDefinition<V> policyDefinition) {
        this.mGlobalPolicies.remove(policyDefinition.getPolicyKey());
    }

    private static <V> PolicyState<V> getPolicyStateLocked(Map<PolicyKey, PolicyState<?>> policies, PolicyDefinition<V> policyDefinition) {
        PolicyState<V> policyState = (PolicyState) policies.get(policyDefinition.getPolicyKey());     // Catch: ClassCastException -> L4
        return policyState;
    L6:
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <V> CompletableFuture<Boolean> enforcePolicy(PolicyDefinition<V> r3, PolicyValue<V> policyValue, int userId) {
        if (policyValue != null) goto L4;
        Object r0 = null;
    L6:
        return r3.enforcePolicy(r0, this.mContext, userId);
    L4:
        r0 = policyValue.getValue();
        goto L6
    }

    private void sendDevicePolicyChangedToSystem(final int userId) {
        final Intent intent = new Intent("android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED");
        intent.setFlags(1073741824);
        final Bundle options = new BroadcastOptions().setDeliveryGroupPolicy(1).setDeferralPolicy(2).toBundle();
        Binder.withCleanCallingIdentity(new DevicePolicyEngine$$ExternalSyntheticLambda0(this, intent, userId, options));
    }

    private /* synthetic */ void lambda$sendDevicePolicyChangedToSystem$2(Intent intent, int userId, Bundle options) throws Exception {
        this.mContext.sendBroadcastAsUser(intent, new UserHandle(userId), null, options);
    }

    private <V> void sendPolicyResultToAdmin(final EnforcingAdmin admin, final PolicyDefinition<V> policyDefinition, final int result, final int userId) {
        final Intent intent = new Intent("android.app.admin.action.DEVICE_POLICY_SET_RESULT");
        intent.setPackage(admin.getPackageName());
        Binder.withCleanCallingIdentity(new DevicePolicyEngine$$ExternalSyntheticLambda1(this, intent, admin, policyDefinition, userId, result));
    }

    private /* synthetic */ void lambda$sendPolicyResultToAdmin$3(Intent intent, EnforcingAdmin admin, PolicyDefinition policyDefinition, int userId, int result) throws Exception {
        List receivers = this.mContext.getPackageManager().queryBroadcastReceiversAsUser(intent, PackageManager.ResolveInfoFlags.of(2), admin.getUserId());
        if (receivers.isEmpty() == false) goto L6;
        Log.i(TAG, "Couldn't find any receivers that handle ACTION_DEVICE_POLICY_SET_RESULT in package " + admin.getPackageName());
        return;
    L6:
        Bundle extras = new Bundle();
        policyDefinition.getPolicyKey().writeToBundle(extras);
        extras.putInt("android.app.admin.extra.POLICY_TARGET_USER_ID", getTargetUser(admin.getUserId(), userId));
        extras.putInt("android.app.admin.extra.POLICY_UPDATE_RESULT_KEY", result);
        intent.putExtras(extras);
        maybeSendIntentToAdminReceivers(intent, UserHandle.of(admin.getUserId()), receivers);
    }

    private <V> void sendPolicyChangedToAdminsLocked(PolicyState<V> policyState, EnforcingAdmin callingAdmin, PolicyDefinition<V> policyDefinition, int userId) {
        Iterator<EnforcingAdmin> r0 = policyState.getPoliciesSetByAdmins().keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        EnforcingAdmin admin = r0.next();
        if (admin.equals(callingAdmin) == true) goto L4;
        if (Objects.equals(policyState.getPoliciesSetByAdmins().get(admin), policyState.getCurrentResolvedPolicy()) == false) goto L11;
        int result = 0;
    L12:
        maybeSendOnPolicyChanged(admin, policyDefinition, result, userId);
        goto L4
    L11:
        result = 1;
        goto L12
    }

    private <V> void maybeSendOnPolicyChanged(final EnforcingAdmin admin, final PolicyDefinition<V> policyDefinition, final int reason, final int userId) {
        final Intent intent = new Intent("android.app.admin.action.DEVICE_POLICY_CHANGED");
        intent.setPackage(admin.getPackageName());
        Binder.withCleanCallingIdentity(new DevicePolicyEngine$$ExternalSyntheticLambda6(this, intent, admin, policyDefinition, userId, reason));
    }

    private /* synthetic */ void lambda$maybeSendOnPolicyChanged$4(Intent intent, EnforcingAdmin admin, PolicyDefinition policyDefinition, int userId, int reason) throws Exception {
        List receivers = this.mContext.getPackageManager().queryBroadcastReceiversAsUser(intent, PackageManager.ResolveInfoFlags.of(2), admin.getUserId());
        if (receivers.isEmpty() == false) goto L6;
        Log.i(TAG, "Couldn't find any receivers that handle ACTION_DEVICE_POLICY_CHANGED in package " + admin.getPackageName());
        return;
    L6:
        Bundle extras = new Bundle();
        policyDefinition.getPolicyKey().writeToBundle(extras);
        extras.putInt("android.app.admin.extra.POLICY_TARGET_USER_ID", getTargetUser(admin.getUserId(), userId));
        extras.putInt("android.app.admin.extra.POLICY_UPDATE_RESULT_KEY", reason);
        intent.putExtras(extras);
        intent.addFlags(268435456);
        maybeSendIntentToAdminReceivers(intent, UserHandle.of(admin.getUserId()), receivers);
    }

    private void maybeSendIntentToAdminReceivers(Intent intent, UserHandle userHandle, List<ResolveInfo> receivers) {
        Iterator<ResolveInfo> r0 = receivers.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ResolveInfo resolveInfo = r0.next();
        if ("android.permission.BIND_DEVICE_ADMIN".equals(resolveInfo.activityInfo.permission) == false) goto L7;
        this.mContext.sendBroadcastAsUser(intent, userHandle);
        goto L4
    L7:
        Log.w(TAG, "Receiver " + resolveInfo.activityInfo + " is not protected by BIND_DEVICE_ADMIN permission!");
        goto L4
    }

    private int getTargetUser(int adminUserId, int targetUserId) {
        if (targetUserId != (-1)) goto L5;
        return -3;
    L5:
        if (adminUserId != targetUserId) goto L8;
        return -1;
    L8:
        if (getProfileParentId(adminUserId) != targetUserId) goto L11;
        return -2;
    L11:
        return -3;
    }

    private int getProfileParentId(final int userId) {
        return ((Integer) Binder.withCleanCallingIdentity(new DevicePolicyEngine$$ExternalSyntheticLambda2(this, userId))).intValue();
    }

    private /* synthetic */ Integer lambda$getProfileParentId$5(int userId) throws Exception {
        UserInfo parentUser = this.mUserManager.getProfileParent(userId);
        if (parentUser == null) goto L5;
        int r1 = parentUser.id;
    L7:
        return Integer.valueOf(r1);
    L5:
        r1 = userId;
        goto L7
    }

    private void updateDeviceAdminsServicesForUser(int userId, boolean enable, String actionForLog) {
        if (enable == true) goto L4;
        this.mDeviceAdminServiceController.stopServicesForUser(userId, actionForLog);
        return;
    L4:
        Iterator<EnforcingAdmin> r0 = getEnforcingAdminsOnUser(userId).iterator();
    L6:
        if (r0.hasNext() == false) goto L17;
        EnforcingAdmin admin = r0.next();
        if (admin.hasAuthority("enterprise") == true) goto L6;
        this.mDeviceAdminServiceController.startServiceForAdmin(admin.getPackageName(), userId, actionForLog);
        goto L6
    }

    void handleStartUser(int userId) {
        updateDeviceAdminsServicesForUser(userId, true, "start-user");
    }

    void handleUnlockUser(int userId) {
        updateDeviceAdminsServicesForUser(userId, true, "unlock-user");
    }

    void handleStopUser(int userId) {
        updateDeviceAdminsServicesForUser(userId, false, "stop-user");
    }

    void handlePackageChanged(final String updatedPackage, final int userId, final String removedDpcPackage) {
        Binder.withCleanCallingIdentity(new DevicePolicyEngine$$ExternalSyntheticLambda7(this, userId, removedDpcPackage, updatedPackage));
    }

    private /* synthetic */ void lambda$handlePackageChanged$6(int userId, String removedDpcPackage, String updatedPackage) throws Exception {
        Set<EnforcingAdmin> admins = getEnforcingAdminsOnUser(userId);
        if (removedDpcPackage == null) goto L12;
        Iterator<EnforcingAdmin> r1 = admins.iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        EnforcingAdmin admin = r1.next();
        if (removedDpcPackage.equals(admin.getPackageName()) == false) goto L6;
        removePoliciesForAdmin(admin);
        return;
    L12:
        Iterator<EnforcingAdmin> r2 = admins.iterator();
    L14:
        if (r2.hasNext() == false) goto L26;
        EnforcingAdmin admin2 = r2.next();
        if (admin2.isSystemAuthority() == true) goto L26;
        if (updatedPackage == null) goto L22;
        if (updatedPackage.equals(admin2.getPackageName()) == false) goto L14;
    L22:
        if (isPackageInstalled(admin2.getPackageName(), userId) == true) goto L14;
        Slogf.i(TAG, String.format("Admin package %s not found for user %d, removing admin policies", new Object[]{admin2.getPackageName(), Integer.valueOf(userId)}));
        removePoliciesForAdmin(admin2);
        return;
    L26:
        if (updatedPackage == null) goto L40;
        updateDeviceAdminServiceOnPackageChanged(updatedPackage, userId);
        removePersistentPreferredActivityPoliciesForPackage(updatedPackage, userId);
        return;
    }

    private void removePersistentPreferredActivityPoliciesForPackage(String packageName, int userId) {
        Set<PolicyKey> policyKeys = getLocalPolicyKeysSetByAllAdmins(PolicyDefinition.GENERIC_PERSISTENT_PREFERRED_ACTIVITY, userId);
        Iterator<PolicyKey> r6 = policyKeys.iterator();
    L4:
        if (r6.hasNext() == false) goto L31;
        IntentFilterPolicyKey r7 = (PolicyKey) r6.next();
        if ((r7 instanceof IntentFilterPolicyKey) == false) goto L30;
        IntentFilterPolicyKey parsedKey = r7;
        IntentFilter intentFilter = parsedKey.getIntentFilter();
        intentFilter.getClass();
        PolicyDefinition<ComponentName> policyDefinition = PolicyDefinition.PERSISTENT_PREFERRED_ACTIVITY(intentFilter);
        LinkedHashMap<EnforcingAdmin, PolicyValue<ComponentName>> policies = getLocalPoliciesSetByAdmins(policyDefinition, userId);
        IPackageManager packageManager = AppGlobals.getPackageManager();
        Iterator<EnforcingAdmin> r13 = policies.keySet().iterator();
    L9:
        if (r13.hasNext() == false) goto L4;
        EnforcingAdmin admin = r13.next();
        if (policies.get(admin).getValue() != null) goto L13;
        Set<PolicyKey> policyKeys2 = policyKeys;
        Iterator<PolicyKey> r16 = r6;
    L27:
        policyKeys = policyKeys2;
        r6 = r16;
        goto L9
    L13:
        if (((ComponentName) policies.get(admin).getValue()).getPackageName().equals(packageName) == false) goto L25;
        policyKeys2 = policyKeys;
        r16 = r6;
        if (packageManager.getPackageInfo(packageName, 0, userId) != null) goto L18;
    L22:
        Slogf.e(TAG, String.format("Persistent preferred activity in package %s not found for user %d, removing policy for admin", new Object[]{packageName, Integer.valueOf(userId)}));     // Catch: RemoteException -> L20
        removeLocalPolicy(policyDefinition, admin, userId);     // Catch: RemoteException -> L20
        goto L27
    L18:
        if (packageManager.getActivityInfo((ComponentName) policies.get(admin).getValue(), 0, userId) != null) goto L27;
    L20:
        re = move-exception;
        Slogf.wtf(TAG, "Error handling package changes", re);
        goto L27
    L25:
        policyKeys2 = policyKeys;
        r16 = r6;
        goto L27
    L30:
        throw new IllegalStateException("PolicyKey for PERSISTENT_PREFERRED_ACTIVITY is not of type IntentFilterPolicyKey");
    }

    private boolean isPackageInstalled(String packageName, int userId) {
        if (AppGlobals.getPackageManager().getPackageInfo(packageName, 0, userId) != null) goto L13;
        return false;
    L13:
        return true;
    L8:
        re = move-exception;
        Slogf.wtf(TAG, "Error handling package changes", re);
        return true;
    }

    void handleUserRemoved(int userId) {
        removeLocalPoliciesForUser(userId);
        removePoliciesForAdminsOnUser(userId);
    }

    void handleUserCreated(UserInfo user) {
        enforcePoliciesOnInheritableProfilesIfApplicable(user);
    }

    void handleRoleChanged(String roleName, int userId) {
        if (DEVICE_LOCK_CONTROLLER_ROLE.equals(roleName) == true) goto L5;
        return;
    L5:
        String roleAuthority = EnforcingAdmin.getRoleAuthorityOf(roleName);
        Set<EnforcingAdmin> admins = getEnforcingAdminsOnUser(userId);
        Iterator<EnforcingAdmin> r2 = admins.iterator();
    L7:
        if (r2.hasNext() == false) goto L14;
        EnforcingAdmin admin = r2.next();
        if (admin.hasAuthority(roleAuthority) == false) goto L7;
        admin.reloadRoleAuthorities();
        if (admin.hasAuthority(roleAuthority) == true) goto L7;
        removePoliciesForAdmin(admin);
        goto L7
    }

    private void enforcePoliciesOnInheritableProfilesIfApplicable(final UserInfo user) {
        if (user.isProfile() == true) goto L5;
        return;
    L5:
        Binder.withCleanCallingIdentity(new DevicePolicyEngine$$ExternalSyntheticLambda4(this, user));
    }

    private /* synthetic */ void lambda$enforcePoliciesOnInheritableProfilesIfApplicable$7(UserInfo user) throws Exception {
        UserProperties userProperties = this.mUserManager.getUserProperties(user.getUserHandle());
        if (userProperties != null) goto L5;
        return;
    L5:
        if (userProperties.getInheritDevicePolicy() != 1) goto L33;
        int userId = user.id;
        UserInfo parentInfo = this.mUserManager.getProfileParent(userId);
        if (parentInfo != null) goto L10;
        return;
    L10:
        if (parentInfo.getUserHandle().getIdentifier() == userId) goto L32;
        Object r3 = this.mLock;
        monitor-enter(r3);
    L18:
        th = move-exception;
        throw th;
    L15:
        if (this.mLocalPolicies.contains(parentInfo.getUserHandle().getIdentifier()) == true) goto L20;
        monitor-exit(r3);     // Catch: Throwable -> L18
        return;
    L20:
        Iterator<Map.Entry<PolicyKey, PolicyState<?>>> r4 = this.mLocalPolicies.get(parentInfo.getUserHandle().getIdentifier()).entrySet().iterator();     // Catch: Throwable -> L18
    L22:
        if (r4.hasNext() == false) goto L24;
        Map.Entry<PolicyKey, PolicyState<?>> entry = r4.next();     // Catch: Throwable -> L18
        enforcePolicyOnUserLocked(userId, entry.getValue());     // Catch: Throwable -> L18
        goto L22
    L24:
        monitor-exit(r3);     // Catch: Throwable -> L18
        return;
    L32:
        return;
    }

    private <V> void enforcePolicyOnUserLocked(int userId, PolicyState<V> policyState) {
        if (policyState.getPolicyDefinition().isInheritable() == true) goto L5;
        return;
    L5:
        Iterator<Map.Entry<EnforcingAdmin, PolicyValue<V>>> r0 = policyState.getPoliciesSetByAdmins().entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<EnforcingAdmin, PolicyValue<V>> enforcingAdminEntry = r0.next();
        setLocalPolicy(policyState.getPolicyDefinition(), enforcingAdminEntry.getKey(), enforcingAdminEntry.getValue(), userId);
        goto L7
    }

    DevicePolicyState getDevicePolicyState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Map<UserHandle, Map<PolicyKey, android.app.admin.PolicyState<?>>> policies = new HashMap();     // Catch: Throwable -> L11
        int i = 0;
    L6:
        if (i >= this.mLocalPolicies.size()) goto L15;
        UserHandle user = UserHandle.of(this.mLocalPolicies.keyAt(i));     // Catch: Throwable -> L11
        policies.put(user, new HashMap());     // Catch: Throwable -> L11
        Iterator<PolicyKey> r4 = this.mLocalPolicies.valueAt(i).keySet().iterator();     // Catch: Throwable -> L11
    L9:
        if (r4.hasNext() == false) goto L13;
        PolicyKey policyKey = r4.next();     // Catch: Throwable -> L11
        policies.get(user).put(policyKey, this.mLocalPolicies.valueAt(i).get(policyKey).getParcelablePolicyState());     // Catch: Throwable -> L11
        goto L9
    L13:
        i = i + 1;     // Catch: Throwable -> L11
        goto L6
    L15:
        if (this.mGlobalPolicies.isEmpty() == true) goto L20;
        policies.put(UserHandle.ALL, new HashMap());     // Catch: Throwable -> L11
        Iterator<PolicyKey> r2 = this.mGlobalPolicies.keySet().iterator();     // Catch: Throwable -> L11
    L18:
        if (r2.hasNext() == false) goto L20;
        PolicyKey policyKey2 = r2.next();     // Catch: Throwable -> L11
        policies.get(UserHandle.ALL).put(policyKey2, this.mGlobalPolicies.get(policyKey2).getParcelablePolicyState());     // Catch: Throwable -> L11
    L20:
        DevicePolicyState r3 = new DevicePolicyState(policies);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L11:
        th = move-exception;
        throw th;
    }

    void removePoliciesForAdmin(EnforcingAdmin admin) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Set<PolicyKey> globalPolicies = new HashSet(this.mGlobalPolicies.keySet());     // Catch: Throwable -> L10
        Iterator<PolicyKey> r2 = globalPolicies.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        PolicyKey policy = r2.next();     // Catch: Throwable -> L10
        PolicyState<?> policyState = this.mGlobalPolicies.get(policy);     // Catch: Throwable -> L10
        if (policyState.getPoliciesSetByAdmins().containsKey(admin) == false) goto L6;
        removeGlobalPolicy(policyState.getPolicyDefinition(), admin);     // Catch: Throwable -> L10
        goto L6
    L13:
        int i = 0;
    L15:
        if (i >= this.mLocalPolicies.size()) goto L25;
        int userId = this.mLocalPolicies.keyAt(i);     // Catch: Throwable -> L10
        Set<PolicyKey> localPolicies = new HashSet(this.mLocalPolicies.get(userId).keySet());     // Catch: Throwable -> L10
        Iterator<PolicyKey> r5 = localPolicies.iterator();     // Catch: Throwable -> L10
    L18:
        if (r5.hasNext() == false) goto L23;
        PolicyKey policy2 = r5.next();     // Catch: Throwable -> L10
        PolicyState<?> policyState2 = this.mLocalPolicies.get(userId).get(policy2);     // Catch: Throwable -> L10
        if (policyState2.getPoliciesSetByAdmins().containsKey(admin) == false) goto L18;
        removeLocalPolicy(policyState2.getPolicyDefinition(), admin, this.mLocalPolicies.keyAt(i));     // Catch: Throwable -> L10
        goto L18
    L23:
        i = i + 1;     // Catch: Throwable -> L10
        goto L15
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void removeLocalPoliciesForUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocalPolicies.contains(userId) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Set<PolicyKey> localPolicies = new HashSet(this.mLocalPolicies.get(userId).keySet());     // Catch: Throwable -> L8
        Iterator<PolicyKey> r2 = localPolicies.iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L18;
        PolicyKey policy = r2.next();     // Catch: Throwable -> L8
        PolicyState<?> policyState = this.mLocalPolicies.get(userId).get(policy);     // Catch: Throwable -> L8
        Set<EnforcingAdmin> admins = new HashSet(policyState.getPoliciesSetByAdmins().keySet());     // Catch: Throwable -> L8
        Iterator<EnforcingAdmin> r6 = admins.iterator();     // Catch: Throwable -> L8
    L15:
        if (r6.hasNext() == false) goto L12;
        EnforcingAdmin admin = r6.next();     // Catch: Throwable -> L8
        removeLocalPolicy(policyState.getPolicyDefinition(), admin, userId);     // Catch: Throwable -> L8
        goto L15
    L18:
        this.mLocalPolicies.remove(userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void removePoliciesForAdminsOnUser(int userId) {
        Set<EnforcingAdmin> admins = getEnforcingAdminsOnUser(userId);
        Iterator<EnforcingAdmin> r1 = admins.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        EnforcingAdmin admin = r1.next();
        removePoliciesForAdmin(admin);
        goto L4
    }

    private void updateDeviceAdminServiceOnPackageChanged(String updatedPackage, int userId) {
        Iterator<EnforcingAdmin> r0 = getEnforcingAdminsOnUser(userId).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        EnforcingAdmin admin = r0.next();
        if (admin.hasAuthority("enterprise") == true) goto L4;
        if (updatedPackage.equals(admin.getPackageName()) == false) goto L4;
        this.mDeviceAdminServiceController.startServiceForAdmin(updatedPackage, userId, "package-broadcast");
        goto L4
    }

    private void updateDeviceAdminServiceOnPolicyAddLocked(EnforcingAdmin enforcingAdmin) {
        int userId = enforcingAdmin.getUserId();
        if (this.mEnforcingAdmins.contains(userId) == false) goto L8;
        if (this.mEnforcingAdmins.get(userId).contains(enforcingAdmin) == false) goto L8;
        return;
    L8:
        if (this.mEnforcingAdmins.contains(enforcingAdmin.getUserId()) == true) goto L10;
        this.mEnforcingAdmins.put(enforcingAdmin.getUserId(), new HashSet());
    L10:
        this.mEnforcingAdmins.get(enforcingAdmin.getUserId()).add(enforcingAdmin);
        if (enforcingAdmin.hasAuthority("enterprise") == false) goto L13;
        return;
    L13:
        this.mDeviceAdminServiceController.startServiceForAdmin(enforcingAdmin.getPackageName(), userId, "policy-added");
    }

    private void updateDeviceAdminServiceOnPolicyRemoveLocked(EnforcingAdmin enforcingAdmin) {
        if (doesAdminHavePoliciesLocked(enforcingAdmin) == false) goto L5;
        return;
    L5:
        int userId = enforcingAdmin.getUserId();
        if (this.mEnforcingAdmins.contains(userId) == false) goto L11;
        this.mEnforcingAdmins.get(userId).remove(enforcingAdmin);
        if (this.mEnforcingAdmins.get(userId).isEmpty() == false) goto L11;
        this.mEnforcingAdmins.remove(enforcingAdmin.getUserId());
    L11:
        if (enforcingAdmin.hasAuthority("enterprise") == false) goto L13;
        return;
    L13:
        this.mDeviceAdminServiceController.stopServiceForAdmin(enforcingAdmin.getPackageName(), userId, "policy-removed");
    }

    private boolean doesAdminHavePoliciesLocked(EnforcingAdmin enforcingAdmin) {
        Iterator<PolicyKey> r0 = this.mGlobalPolicies.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        PolicyKey policy = r0.next();
        PolicyState<?> policyState = this.mGlobalPolicies.get(policy);
        if (policyState.getPoliciesSetByAdmins().containsKey(enforcingAdmin) == false) goto L4;
        return true;
    L9:
        int i = 0;
    L11:
        if (i >= this.mLocalPolicies.size()) goto L20;
        Iterator<PolicyKey> r1 = this.mLocalPolicies.get(this.mLocalPolicies.keyAt(i)).keySet().iterator();
    L14:
        if (r1.hasNext() == false) goto L19;
        PolicyKey policy2 = r1.next();
        PolicyState<?> policyState2 = this.mLocalPolicies.get(this.mLocalPolicies.keyAt(i)).get(policy2);
        if (policyState2.getPoliciesSetByAdmins().containsKey(enforcingAdmin) == false) goto L14;
        return true;
    L19:
        i = i + 1;
        goto L11
    L20:
        return false;
    }

    private Set<EnforcingAdmin> getEnforcingAdminsOnUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnforcingAdmins.contains(userId) == false) goto L9;
        Set<EnforcingAdmin> r1 = new HashSet(this.mEnforcingAdmins.get(userId));     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L9:
        r1 = Collections.emptySet();     // Catch: Throwable -> L7
        goto L10
    }

    private static <V> int sizeOf(PolicyValue<V> value) {
        Parcel parcel = Parcel.obtain();     // Catch: Exception -> L5
        parcel.writeParcelable(value, 0);     // Catch: Exception -> L5
        parcel.setDataPosition(0);     // Catch: Exception -> L5
        byte[] bytes = parcel.marshall();     // Catch: Exception -> L5
        return bytes.length;
    L5:
        e = move-exception;
        Log.e(TAG, "Error calculating size of policy: " + e);
        return 0;
    }

    private <V> boolean handleAdminPolicySizeLimit(PolicyState<V> policyState, EnforcingAdmin admin, PolicyValue<V> value, PolicyDefinition<V> policyDefinition, int userId) {
        int currentAdminPoliciesSize = 0;
        int existingPolicySize = 0;
        if (this.mAdminPolicySize.contains(admin.getUserId()) == false) goto L8;
        if (this.mAdminPolicySize.get(admin.getUserId()).containsKey(admin) == false) goto L8;
        currentAdminPoliciesSize = this.mAdminPolicySize.get(admin.getUserId()).get(admin).intValue();
    L8:
        if (policyState.getPoliciesSetByAdmins().containsKey(admin) == false) goto L10;
        existingPolicySize = sizeOf(policyState.getPoliciesSetByAdmins().get(admin));
    L10:
        int policySize = sizeOf(value);
        if (this.mPolicySizeLimit != (-1)) goto L13;
    L17:
        increasePolicySizeForAdmin(admin, policySize - existingPolicySize);
        return true;
    L13:
        if (((currentAdminPoliciesSize + policySize) - existingPolicySize) < this.mPolicySizeLimit) goto L17;
        Log.w(TAG, "Admin " + admin + "reached max allowed storage limit.");
        sendPolicyResultToAdmin(admin, policyDefinition, 3, userId);
        return false;
    }

    private <V> void increasePolicySizeForAdmin(EnforcingAdmin admin, int policySizeDiff) {
        if (this.mAdminPolicySize.contains(admin.getUserId()) == true) goto L6;
        this.mAdminPolicySize.put(admin.getUserId(), new HashMap());
    L6:
        if (this.mAdminPolicySize.get(admin.getUserId()).containsKey(admin) == true) goto L8;
        this.mAdminPolicySize.get(admin.getUserId()).put(admin, 0);
    L8:
        this.mAdminPolicySize.get(admin.getUserId()).put(admin, Integer.valueOf(this.mAdminPolicySize.get(admin.getUserId()).get(admin).intValue() + policySizeDiff));
    }

    private <V> void decreasePolicySizeForAdmin(PolicyState<V> policyState, EnforcingAdmin admin) {
        if (policyState.getPoliciesSetByAdmins().containsKey(admin) == true) goto L5;
        return;
    L5:
        if (this.mAdminPolicySize.contains(admin.getUserId()) == true) goto L7;
        return;
    L7:
        if (this.mAdminPolicySize.get(admin.getUserId()).containsKey(admin) == false) goto L19;
        this.mAdminPolicySize.get(admin.getUserId()).put(admin, Integer.valueOf(this.mAdminPolicySize.get(admin.getUserId()).get(admin).intValue() - sizeOf(policyState.getPoliciesSetByAdmins().get(admin))));
        if (this.mAdminPolicySize.get(admin.getUserId()).get(admin).intValue() > 0) goto L13;
        this.mAdminPolicySize.get(admin.getUserId()).remove(admin);
    L13:
        if (this.mAdminPolicySize.get(admin.getUserId()).isEmpty() == false) goto L17;
        this.mAdminPolicySize.remove(admin.getUserId());
        return;
    L17:
        return;
    }

    void setMaxPolicyStorageLimit(int storageLimit) {
        this.mPolicySizeLimit = storageLimit;
    }

    int getMaxPolicyStorageLimit() {
        return this.mPolicySizeLimit;
    }

    int getPolicySizeForAdmin(EnforcingAdmin admin) {
        if (this.mAdminPolicySize.contains(admin.getUserId()) == true) goto L5;
        return 0;
    L5:
        if (this.mAdminPolicySize.get(admin.getUserId()).containsKey(admin) == true) goto L7;
        return 0;
    L7:
        return this.mAdminPolicySize.get(admin.getUserId()).get(admin).intValue();
    }

    public void dump(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("Local Policies: ");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        int i = 0;
    L6:
        if (i >= this.mLocalPolicies.size()) goto L14;
        int userId = this.mLocalPolicies.keyAt(i);     // Catch: Throwable -> L11
        pw.printf("User %d:\n", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        Iterator<PolicyKey> r3 = this.mLocalPolicies.get(userId).keySet().iterator();     // Catch: Throwable -> L11
    L9:
        if (r3.hasNext() == false) goto L13;
        PolicyKey policy = r3.next();     // Catch: Throwable -> L11
        PolicyState<?> policyState = this.mLocalPolicies.get(userId).get(policy);     // Catch: Throwable -> L11
        policyState.dump(pw);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        goto L9
    L13:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L6
    L14:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("Global Policies: ");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        Iterator<PolicyKey> r1 = this.mGlobalPolicies.keySet().iterator();     // Catch: Throwable -> L11
    L16:
        if (r1.hasNext() == false) goto L18;
        PolicyKey policy2 = r1.next();     // Catch: Throwable -> L11
        PolicyState<?> policyState2 = this.mGlobalPolicies.get(policy2);     // Catch: Throwable -> L11
        policyState2.dump(pw);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        goto L16
    L18:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("Default admin policy size limit: -1");     // Catch: Throwable -> L11
        pw.println("Current admin policy size limit: " + this.mPolicySizeLimit);     // Catch: Throwable -> L11
        pw.println("Admin Policies size: ");     // Catch: Throwable -> L11
        int i2 = 0;
    L20:
        if (i2 >= this.mAdminPolicySize.size()) goto L26;
        int userId2 = this.mAdminPolicySize.keyAt(i2);     // Catch: Throwable -> L11
        pw.printf("User %d:\n", new Object[]{Integer.valueOf(userId2)});     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        Iterator<EnforcingAdmin> r4 = this.mAdminPolicySize.get(userId2).keySet().iterator();     // Catch: Throwable -> L11
    L23:
        if (r4.hasNext() == false) goto L25;
        EnforcingAdmin admin = r4.next();     // Catch: Throwable -> L11
        pw.printf("Admin : " + admin + " : " + this.mAdminPolicySize.get(userId2).get(admin), new Object[0]);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        goto L23
    L25:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        i2 = i2 + 1;     // Catch: Throwable -> L11
        goto L20
    L26:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void write() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Log.d(TAG, "Writing device policies to file.");     // Catch: Throwable -> L7
        new DevicePoliciesReaderWriter(this, null).writeToFileLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void load() {
        Log.d(TAG, "Reading device policies from file.");
        Object r0 = this.mLock;
        monitor-enter(r0);
        clear();     // Catch: Throwable -> L7
        new DevicePoliciesReaderWriter(this, null).readFromFileLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void createBackup(String backupId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DevicePoliciesReaderWriter.createBackup(backupId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    <V> void reapplyAllPoliciesOnBootLocked() {
        Iterator<PolicyKey> r0 = this.mGlobalPolicies.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        PolicyKey policy = r0.next();
        PolicyState<?> policyState = this.mGlobalPolicies.get(policy);
        PolicyDefinition<V> policyDefinition = policyState.getPolicyDefinition();
        if (policyDefinition.shouldSkipEnforcementIfNotChanged() == true) goto L4;
        PolicyValue<V> policyValue = policyState.getCurrentResolvedPolicy();
        enforcePolicy(policyDefinition, policyValue, -1);
        goto L4
    L9:
        int i = 0;
    L11:
        if (i >= this.mLocalPolicies.size()) goto L21;
        int userId = this.mLocalPolicies.keyAt(i);
        Iterator<PolicyKey> r2 = this.mLocalPolicies.get(userId).keySet().iterator();
    L14:
        if (r2.hasNext() == false) goto L19;
        PolicyKey policy2 = r2.next();
        PolicyState<?> policyState2 = this.mLocalPolicies.get(userId).get(policy2);
        PolicyDefinition<V> policyDefinition2 = policyState2.getPolicyDefinition();
        if (policyDefinition2.shouldSkipEnforcementIfNotChanged() == true) goto L14;
        PolicyValue<V> policyValue2 = policyState2.getCurrentResolvedPolicy();
        enforcePolicy(policyDefinition2, policyValue2, userId);
        goto L14
    L19:
        i = i + 1;
        goto L11
    }

    void clearAllPolicies() {
        clear();
        write();
    }

    private void clear() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mGlobalPolicies.clear();     // Catch: Throwable -> L7
        this.mLocalPolicies.clear();     // Catch: Throwable -> L7
        this.mEnforcingAdmins.clear();     // Catch: Throwable -> L7
        this.mAdminPolicySize.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private <V> boolean checkFor2gFailure(PolicyDefinition<V> policyDefinition, EnforcingAdmin enforcingAdmin) {
        if (policyDefinition.getPolicyKey().getIdentifier().equals(CELLULAR_2G_USER_RESTRICTION_ID) == true) goto L13;
        return false;
    L13:
        boolean isCapabilitySupported = ((TelephonyManager) this.mContext.getSystemService(TelephonyManager.class)).isRadioInterfaceCapabilitySupported("CAPABILITY_USES_ALLOWED_NETWORK_TYPES_BITMASK");     // Catch: IllegalStateException -> L7
    L9:
        if (isCapabilitySupported == true) goto L12;
        sendPolicyResultToAdmin(enforcingAdmin, policyDefinition, 4, -1);
        return true;
    L12:
        return false;
    L8:
        isCapabilitySupported = false;
        goto L9
    }

    private <V> boolean shouldApplyPackageSetUnionPolicyHack(PolicyDefinition<V> policy) {
        String policyKey = policy.getPolicyKey().getIdentifier();
        if (policyKey.equals("userControlDisabledPackages") == false) goto L5;
    L8:
        return true;
    L5:
        if (policyKey.equals("packagesSuspended") == true) goto L8;
        return false;
    }
}
