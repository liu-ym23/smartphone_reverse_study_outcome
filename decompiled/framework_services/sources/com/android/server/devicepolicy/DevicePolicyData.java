package com.android.server.devicepolicy;

import android.app.admin.DeviceAdminInfo;
import android.content.ComponentName;
import android.os.FileUtils;
import android.os.PersistableBundle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.DebugUtils;
import android.util.IndentingPrintWriter;
import android.util.Xml;
import com.android.internal.util.JournaledFile;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.utils.Slogf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class DevicePolicyData {
    private static final String ATTR_ALIAS = "alias";
    private static final String ATTR_DEVICE_PAIRED = "device-paired";
    private static final String ATTR_DEVICE_PROVISIONING_CONFIG_APPLIED = "device-provisioning-config-applied";
    private static final String ATTR_DISABLED = "disabled";
    private static final String ATTR_FACTORY_RESET_FLAGS = "factory-reset-flags";
    private static final String ATTR_FACTORY_RESET_REASON = "factory-reset-reason";
    private static final String ATTR_ID = "id";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_NEW_USER_DISCLAIMER = "new-user-disclaimer";
    private static final String ATTR_PERMISSION_POLICY = "permission-policy";
    private static final String ATTR_PERMISSION_PROVIDER = "permission-provider";
    private static final String ATTR_PROVISIONING_STATE = "provisioning-state";
    private static final String ATTR_SETUP_COMPLETE = "setup-complete";
    private static final String ATTR_VALUE = "value";
    public static final int FACTORY_RESET_FLAG_ON_BOOT = 1;
    public static final int FACTORY_RESET_FLAG_WIPE_EUICC = 4;
    public static final int FACTORY_RESET_FLAG_WIPE_EXTERNAL_STORAGE = 2;
    public static final int FACTORY_RESET_FLAG_WIPE_FACTORY_RESET_PROTECTION = 8;
    static final String NEW_USER_DISCLAIMER_ACKNOWLEDGED = "acked";
    static final String NEW_USER_DISCLAIMER_NEEDED = "needed";
    static final String NEW_USER_DISCLAIMER_NOT_NEEDED = "not_needed";
    private static final String TAG = "DevicePolicyManager";
    private static final String TAG_ACCEPTED_CA_CERTIFICATES = "accepted-ca-certificate";
    private static final String TAG_ADMIN_BROADCAST_PENDING = "admin-broadcast-pending";
    private static final String TAG_AFFILIATION_ID = "affiliation-id";
    private static final String TAG_APPS_SUSPENDED = "apps-suspended";
    private static final String TAG_BYPASS_ROLE_QUALIFICATIONS = "bypass-role-qualifications";
    private static final String TAG_CURRENT_INPUT_METHOD_SET = "current-ime-set";
    private static final String TAG_DO_NOT_ASK_CREDENTIALS_ON_BOOT = "do-not-ask-credentials-on-boot";
    private static final String TAG_INITIALIZATION_BUNDLE = "initialization-bundle";
    private static final String TAG_KEEP_PROFILES_RUNNING = "keep-profiles-running";
    private static final String TAG_LAST_BUG_REPORT_REQUEST = "last-bug-report-request";
    private static final String TAG_LAST_NETWORK_LOG_RETRIEVAL = "last-network-log-retrieval";
    private static final String TAG_LAST_SECURITY_LOG_RETRIEVAL = "last-security-log-retrieval";
    private static final String TAG_LOCK_TASK_COMPONENTS = "lock-task-component";
    private static final String TAG_LOCK_TASK_FEATURES = "lock-task-features";
    private static final String TAG_OWNER_INSTALLED_CA_CERT = "owner-installed-ca-cert";
    private static final String TAG_PASSWORD_TOKEN_HANDLE = "password-token";
    private static final String TAG_PROTECTED_PACKAGES = "protected-packages";
    private static final String TAG_SECONDARY_LOCK_SCREEN = "secondary-lock-screen";
    private static final String TAG_STATUS_BAR = "statusbar";
    private static final boolean VERBOSE_LOG = false;
    final ArraySet<String> mAcceptedCaCertificates;
    boolean mAdminBroadcastPending;
    final ArrayList<ActiveAdmin> mAdminList;
    final ArrayMap<ComponentName, ActiveAdmin> mAdminMap;
    Set<String> mAffiliationIds;
    boolean mAppsSuspended;
    boolean mBypassDevicePolicyManagementRoleQualifications;
    boolean mCurrentInputMethodSet;
    String mCurrentRoleHolder;
    final ArrayMap<String, List<String>> mDelegationMap;
    boolean mDeviceProvisioningConfigApplied;
    boolean mDoNotAskCredentialsOnBoot;
    boolean mEffectiveKeepProfilesRunning;
    int mFactoryResetFlags;
    String mFactoryResetReason;
    int mFailedPasswordAttempts;
    PersistableBundle mInitBundle;
    long mLastBugReportRequestTime;
    long mLastMaximumTimeToLock;
    long mLastNetworkLogsRetrievalTime;
    long mLastSecurityLogRetrievalTime;
    int mLockTaskFeatures;
    List<String> mLockTaskPackages;
    String mNewUserDisclaimer;
    Set<String> mOwnerInstalledCaCerts;
    boolean mPaired;
    int mPasswordOwner;
    long mPasswordTokenHandle;
    boolean mPasswordValidAtLastCheckpoint;
    int mPermissionPolicy;
    final ArrayList<ComponentName> mRemovingAdmins;
    ComponentName mRestrictionsProvider;
    boolean mSecondaryLockscreenEnabled;
    boolean mStatusBarDisabled;

    @Deprecated
    List<String> mUserControlDisabledPackages;
    final int mUserId;
    int mUserProvisioningState;
    boolean mUserSetupComplete;

    DevicePolicyData(int userId) {
        this.mFailedPasswordAttempts = 0;
        this.mPasswordValidAtLastCheckpoint = true;
        this.mPasswordOwner = -1;
        this.mLastMaximumTimeToLock = -1;
        this.mUserSetupComplete = false;
        this.mBypassDevicePolicyManagementRoleQualifications = false;
        this.mPaired = false;
        this.mDeviceProvisioningConfigApplied = false;
        this.mAdminMap = new ArrayMap();
        this.mAdminList = new ArrayList();
        this.mRemovingAdmins = new ArrayList();
        this.mAcceptedCaCertificates = new ArraySet();
        this.mLockTaskPackages = new ArrayList();
        this.mLockTaskFeatures = 16;
        this.mStatusBarDisabled = false;
        this.mDelegationMap = new ArrayMap();
        this.mDoNotAskCredentialsOnBoot = false;
        this.mAffiliationIds = new ArraySet();
        this.mLastSecurityLogRetrievalTime = -1;
        this.mLastBugReportRequestTime = -1;
        this.mLastNetworkLogsRetrievalTime = -1;
        this.mCurrentInputMethodSet = false;
        this.mSecondaryLockscreenEnabled = false;
        this.mOwnerInstalledCaCerts = new ArraySet();
        this.mAdminBroadcastPending = false;
        this.mInitBundle = null;
        this.mPasswordTokenHandle = 0;
        this.mAppsSuspended = false;
        this.mNewUserDisclaimer = NEW_USER_DISCLAIMER_NOT_NEEDED;
        this.mEffectiveKeepProfilesRunning = false;
        this.mUserId = userId;
    }

    static boolean store(DevicePolicyData policyData, JournaledFile file) {
        FileOutputStream stream = null;
        File chooseForWrite = null;
        chooseForWrite = file.chooseForWrite();     // Catch: Throwable -> L129
        stream = new FileOutputStream(chooseForWrite, false);     // Catch: Throwable -> L125
        TypedXmlSerializer out = Xml.resolveSerializer(stream);     // Catch: Throwable -> L125
        out.startDocument(null, true);     // Catch: Throwable -> L12
        out.startTag(null, "policies");     // Catch: Throwable -> L12
        if (policyData.mRestrictionsProvider == null) goto L16;
        out.attribute(null, ATTR_PERMISSION_PROVIDER, policyData.mRestrictionsProvider.flattenToString());     // Catch: Throwable -> L12
    L16:
        if (policyData.mUserSetupComplete == false) goto L19;
        out.attributeBoolean(null, ATTR_SETUP_COMPLETE, true);     // Catch: Throwable -> L12
    L19:
        if (policyData.mPaired == false) goto L22;
        out.attributeBoolean(null, ATTR_DEVICE_PAIRED, true);     // Catch: Throwable -> L12
    L22:
        if (policyData.mDeviceProvisioningConfigApplied == false) goto L25;
        out.attributeBoolean(null, ATTR_DEVICE_PROVISIONING_CONFIG_APPLIED, true);     // Catch: Throwable -> L12
    L25:
        if (policyData.mUserProvisioningState == 0) goto L28;
        out.attributeInt(null, ATTR_PROVISIONING_STATE, policyData.mUserProvisioningState);     // Catch: Throwable -> L12
    L28:
        if (policyData.mPermissionPolicy == 0) goto L31;
        out.attributeInt(null, ATTR_PERMISSION_POLICY, policyData.mPermissionPolicy);     // Catch: Throwable -> L12
    L31:
        if (NEW_USER_DISCLAIMER_NEEDED.equals(policyData.mNewUserDisclaimer) == false) goto L34;
        out.attribute(null, ATTR_NEW_USER_DISCLAIMER, policyData.mNewUserDisclaimer);     // Catch: Throwable -> L12
    L34:
        if (policyData.mFactoryResetFlags == 0) goto L37;
        out.attributeInt(null, ATTR_FACTORY_RESET_FLAGS, policyData.mFactoryResetFlags);     // Catch: Throwable -> L12
    L37:
        if (policyData.mFactoryResetReason == null) goto L39;
        out.attribute(null, ATTR_FACTORY_RESET_REASON, policyData.mFactoryResetReason);     // Catch: Throwable -> L12
    L39:
        int i = 0;
    L41:
        if (i >= policyData.mDelegationMap.size()) goto L47;
        String scope = policyData.mDelegationMap.keyAt(i);     // Catch: Throwable -> L12
        List<String> scopes = policyData.mDelegationMap.valueAt(i);     // Catch: Throwable -> L12
        Iterator<String> r25 = scopes.iterator();     // Catch: Throwable -> L12
    L44:
        if (r25.hasNext() == false) goto L46;
        String scope2 = r25.next();     // Catch: Throwable -> L12
        out.startTag(null, "delegation");     // Catch: Throwable -> L12
        out.attribute(null, "delegatePackage", scope);     // Catch: Throwable -> L12
        String delegatePackage = scope;
        out.attribute(null, "scope", scope2);     // Catch: Throwable -> L12
        out.endTag(null, "delegation");     // Catch: Throwable -> L12
        i = i;
        scopes = scopes;
        scope = delegatePackage;
        goto L44
    L46:
        i = i + 1;     // Catch: Throwable -> L12
        goto L41
    L47:
        int n = policyData.mAdminList.size();     // Catch: Throwable -> L12
        int i2 = 0;
    L50:
        if (i2 >= n) goto L56;
        ActiveAdmin ap = policyData.mAdminList.get(i2);     // Catch: Throwable -> L12 Throwable -> L12
        if (ap == null) goto L55;
        out.startTag(null, "admin");     // Catch: Throwable -> L12 Throwable -> L12
        out.attribute(null, "name", ap.info.getComponent().flattenToString());     // Catch: Throwable -> L12 Throwable -> L12
        ap.writeToXml(out);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, "admin");     // Catch: Throwable -> L12 Throwable -> L12
    L55:
        i2 = i2 + 1;     // Catch: Throwable -> L12 Throwable -> L12
        n = n;
        goto L50
    L56:
        int n2 = policyData.mPasswordOwner;     // Catch: Throwable -> L12 Throwable -> L12
        if (n2 < 0) goto L62;
        out.startTag(null, "password-owner");     // Catch: Throwable -> L12 Throwable -> L12
        out.attributeInt(null, ATTR_VALUE, policyData.mPasswordOwner);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, "password-owner");     // Catch: Throwable -> L12 Throwable -> L12
    L62:
        if (policyData.mFailedPasswordAttempts == 0) goto L64;
        out.startTag(null, "failed-password-attempts");     // Catch: Throwable -> L12 Throwable -> L12
        out.attributeInt(null, ATTR_VALUE, policyData.mFailedPasswordAttempts);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, "failed-password-attempts");     // Catch: Throwable -> L12 Throwable -> L12
    L64:
        int i3 = 0;
    L66:
        if (i3 >= policyData.mAcceptedCaCertificates.size()) goto L68;
        out.startTag(null, TAG_ACCEPTED_CA_CERTIFICATES);     // Catch: Throwable -> L12 Throwable -> L12
        out.attribute(null, "name", policyData.mAcceptedCaCertificates.valueAt(i3));     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_ACCEPTED_CA_CERTIFICATES);     // Catch: Throwable -> L12 Throwable -> L12
        i3 = i3 + 1;     // Catch: Throwable -> L12 Throwable -> L12
        goto L66
    L68:
        int i4 = 0;
    L70:
        if (i4 >= policyData.mLockTaskPackages.size()) goto L72;
        String component = policyData.mLockTaskPackages.get(i4);     // Catch: Throwable -> L12 Throwable -> L12
        out.startTag(null, TAG_LOCK_TASK_COMPONENTS);     // Catch: Throwable -> L12 Throwable -> L12
        out.attribute(null, "name", component);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_LOCK_TASK_COMPONENTS);     // Catch: Throwable -> L12 Throwable -> L12
        i4 = i4 + 1;     // Catch: Throwable -> L12 Throwable -> L12
        goto L70
    L72:
        int i5 = policyData.mLockTaskFeatures;     // Catch: Throwable -> L12 Throwable -> L12
        if (i5 == 0) goto L76;
        out.startTag(null, TAG_LOCK_TASK_FEATURES);     // Catch: Throwable -> L12 Throwable -> L12
        out.attributeInt(null, ATTR_VALUE, policyData.mLockTaskFeatures);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_LOCK_TASK_FEATURES);     // Catch: Throwable -> L12 Throwable -> L12
    L76:
        if (policyData.mSecondaryLockscreenEnabled == false) goto L79;
        out.startTag(null, TAG_SECONDARY_LOCK_SCREEN);     // Catch: Throwable -> L12 Throwable -> L12
        out.attributeBoolean(null, ATTR_VALUE, true);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_SECONDARY_LOCK_SCREEN);     // Catch: Throwable -> L12 Throwable -> L12
    L79:
        if (policyData.mStatusBarDisabled == false) goto L82;
        out.startTag(null, TAG_STATUS_BAR);     // Catch: Throwable -> L12 Throwable -> L12
        out.attributeBoolean(null, "disabled", policyData.mStatusBarDisabled);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_STATUS_BAR);     // Catch: Throwable -> L12 Throwable -> L12
    L82:
        if (policyData.mDoNotAskCredentialsOnBoot == false) goto L84;
        out.startTag(null, TAG_DO_NOT_ASK_CREDENTIALS_ON_BOOT);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_DO_NOT_ASK_CREDENTIALS_ON_BOOT);     // Catch: Throwable -> L12 Throwable -> L12
    L84:
        Iterator<String> r0 = policyData.mAffiliationIds.iterator();     // Catch: Throwable -> L12 Throwable -> L12
    L86:
        if (r0.hasNext() == false) goto L89;
        String id = r0.next();     // Catch: Throwable -> L12 Throwable -> L12
        out.startTag(null, TAG_AFFILIATION_ID);     // Catch: Throwable -> L12 Throwable -> L12
        out.attribute(null, ATTR_ID, id);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_AFFILIATION_ID);     // Catch: Throwable -> L12 Throwable -> L12
        goto L86
    L89:
        if (policyData.mLastSecurityLogRetrievalTime < 0) goto L92;
        out.startTag(null, TAG_LAST_SECURITY_LOG_RETRIEVAL);     // Catch: Throwable -> L12 Throwable -> L12
        out.attributeLong(null, ATTR_VALUE, policyData.mLastSecurityLogRetrievalTime);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_LAST_SECURITY_LOG_RETRIEVAL);     // Catch: Throwable -> L12 Throwable -> L12
    L92:
        if (policyData.mLastBugReportRequestTime < 0) goto L95;
        out.startTag(null, TAG_LAST_BUG_REPORT_REQUEST);     // Catch: Throwable -> L12 Throwable -> L12
        out.attributeLong(null, ATTR_VALUE, policyData.mLastBugReportRequestTime);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_LAST_BUG_REPORT_REQUEST);     // Catch: Throwable -> L12 Throwable -> L12
    L95:
        if (policyData.mLastNetworkLogsRetrievalTime < 0) goto L98;
        out.startTag(null, TAG_LAST_NETWORK_LOG_RETRIEVAL);     // Catch: Throwable -> L12 Throwable -> L12
        out.attributeLong(null, ATTR_VALUE, policyData.mLastNetworkLogsRetrievalTime);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_LAST_NETWORK_LOG_RETRIEVAL);     // Catch: Throwable -> L12 Throwable -> L12
    L98:
        if (policyData.mAdminBroadcastPending == false) goto L101;
        out.startTag(null, TAG_ADMIN_BROADCAST_PENDING);     // Catch: Throwable -> L12 Throwable -> L12
        out.attributeBoolean(null, ATTR_VALUE, policyData.mAdminBroadcastPending);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_ADMIN_BROADCAST_PENDING);     // Catch: Throwable -> L12 Throwable -> L12
    L101:
        if (policyData.mInitBundle == null) goto L104;
        out.startTag(null, TAG_INITIALIZATION_BUNDLE);     // Catch: Throwable -> L12 Throwable -> L12
        policyData.mInitBundle.saveToXml(out);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_INITIALIZATION_BUNDLE);     // Catch: Throwable -> L12 Throwable -> L12
    L104:
        if (policyData.mPasswordTokenHandle == 0) goto L107;
        out.startTag(null, TAG_PASSWORD_TOKEN_HANDLE);     // Catch: Throwable -> L12 Throwable -> L12
        out.attributeLong(null, ATTR_VALUE, policyData.mPasswordTokenHandle);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_PASSWORD_TOKEN_HANDLE);     // Catch: Throwable -> L12 Throwable -> L12
    L107:
        if (policyData.mCurrentInputMethodSet == false) goto L109;
        out.startTag(null, TAG_CURRENT_INPUT_METHOD_SET);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_CURRENT_INPUT_METHOD_SET);     // Catch: Throwable -> L12 Throwable -> L12
    L109:
        Iterator<String> r1 = policyData.mOwnerInstalledCaCerts.iterator();     // Catch: Throwable -> L12 Throwable -> L12
    L111:
        if (r1.hasNext() == false) goto L114;
        String cert = r1.next();     // Catch: Throwable -> L12 Throwable -> L12
        out.startTag(null, TAG_OWNER_INSTALLED_CA_CERT);     // Catch: Throwable -> L12 Throwable -> L12
        out.attribute(null, ATTR_ALIAS, cert);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_OWNER_INSTALLED_CA_CERT);     // Catch: Throwable -> L12 Throwable -> L12
        goto L111
    L114:
        if (policyData.mAppsSuspended == false) goto L117;
        out.startTag(null, TAG_APPS_SUSPENDED);     // Catch: Throwable -> L12 Throwable -> L12
        out.attributeBoolean(null, ATTR_VALUE, policyData.mAppsSuspended);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_APPS_SUSPENDED);     // Catch: Throwable -> L12 Throwable -> L12
    L117:
        if (policyData.mBypassDevicePolicyManagementRoleQualifications == false) goto L120;
        out.startTag(null, TAG_BYPASS_ROLE_QUALIFICATIONS);     // Catch: Throwable -> L12 Throwable -> L12
        out.attribute(null, ATTR_VALUE, policyData.mCurrentRoleHolder);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_BYPASS_ROLE_QUALIFICATIONS);     // Catch: Throwable -> L12 Throwable -> L12
    L120:
        if (policyData.mEffectiveKeepProfilesRunning == false) goto L122;
        out.startTag(null, TAG_KEEP_PROFILES_RUNNING);     // Catch: Throwable -> L12 Throwable -> L12
        out.attributeBoolean(null, ATTR_VALUE, policyData.mEffectiveKeepProfilesRunning);     // Catch: Throwable -> L12 Throwable -> L12
        out.endTag(null, TAG_KEEP_PROFILES_RUNNING);     // Catch: Throwable -> L12 Throwable -> L12
    L122:
        out.endTag(null, "policies");     // Catch: Throwable -> L12 Throwable -> L12
        out.endDocument();     // Catch: Throwable -> L12 Throwable -> L12
        stream.flush();     // Catch: Throwable -> L12 Throwable -> L12
        FileUtils.sync(stream);     // Catch: Throwable -> L12 Throwable -> L12
        stream.close();     // Catch: Throwable -> L12 Throwable -> L12
        file.commit();     // Catch: Throwable -> L12 Throwable -> L12
        return true;
    L12:
        e = e;
        chooseForWrite = chooseForWrite;
    L130:
        Slogf.w(TAG, e, "failed writing file %s", new Object[]{chooseForWrite});
        if (stream != null) goto L141;
    L137:
        file.rollback();
        return false;
    L141:
        stream.close();     // Catch: IOException -> L134
    L125:
        e = e;
        chooseForWrite = chooseForWrite;
    L127:
        e = e;
    L129:
        e = e;
        goto L130
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0166: MOVE (r3 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY] A[D('stream' java.io.FileInputStream)]), block:B:78:0x0166 */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x016b: MOVE (r3 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY] A[D('stream' java.io.FileInputStream)]), block:B:80:0x016b */
    static void load(DevicePolicyData policy, JournaledFile journaledFile, Function<ComponentName, DeviceAdminInfo> adminInfoSupplier, ComponentName ownerComponent) {
        FileInputStream stream = null;
        File file = journaledFile.chooseForRead();
        boolean needsRewrite = false;
        stream = new FileInputStream(file);     // Catch: Throwable -> L197 FileNotFoundException -> L199
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L191 FileNotFoundException -> L193
    L6:
        int type = parser.next();     // Catch: Throwable -> L191 FileNotFoundException -> L193
        if (type == 1) goto L11;
        if (type != 2) goto L6;
    L11:
        String tag = parser.getName();     // Catch: Throwable -> L191 FileNotFoundException -> L193
        if ("policies".equals(tag) == false) goto L196;
        String permissionProvider = parser.getAttributeValue(null, ATTR_PERMISSION_PROVIDER);     // Catch: Throwable -> L191 FileNotFoundException -> L193
        if (permissionProvider != null) goto L219;
    L21:
        String userSetupComplete = parser.getAttributeValue(null, ATTR_SETUP_COMPLETE);     // Catch: Throwable -> L191 Throwable -> L191 Throwable -> L191 Throwable -> L191 Throwable -> L191 FileNotFoundException -> L193
        if (Boolean.toString(true).equals(userSetupComplete) == false) goto L24;
        policy.mUserSetupComplete = true;     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17 FileNotFoundException -> L19
    L24:
        String paired = parser.getAttributeValue(null, ATTR_DEVICE_PAIRED);     // Catch: Throwable -> L191 Throwable -> L191 Throwable -> L191 Throwable -> L191 Throwable -> L191 FileNotFoundException -> L193
        if (Boolean.toString(true).equals(paired) == false) goto L27;
        policy.mPaired = true;     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17 FileNotFoundException -> L19
    L27:
        String deviceProvisioningConfigApplied = parser.getAttributeValue(null, ATTR_DEVICE_PROVISIONING_CONFIG_APPLIED);     // Catch: Throwable -> L191 Throwable -> L191 Throwable -> L191 Throwable -> L191 Throwable -> L191 FileNotFoundException -> L193
        if (Boolean.toString(true).equals(deviceProvisioningConfigApplied) == false) goto L30;
        policy.mDeviceProvisioningConfigApplied = true;     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17 FileNotFoundException -> L19
    L30:
        int provisioningState = parser.getAttributeInt(null, ATTR_PROVISIONING_STATE, -1);     // Catch: Throwable -> L191 Throwable -> L191 Throwable -> L191 Throwable -> L191 Throwable -> L191 FileNotFoundException -> L193
        if (provisioningState == (-1)) goto L33;
        policy.mUserProvisioningState = provisioningState;     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17 FileNotFoundException -> L19
    L33:
        int permissionPolicy = parser.getAttributeInt(null, ATTR_PERMISSION_POLICY, -1);     // Catch: Throwable -> L191 Throwable -> L191 Throwable -> L191 Throwable -> L191 Throwable -> L191 FileNotFoundException -> L193
        if (permissionPolicy == (-1)) goto L36;
        policy.mPermissionPolicy = permissionPolicy;     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17 FileNotFoundException -> L19
    L17:
        e = e;
        File file2 = file;
    L201:
        Slogf.w(TAG, e, "failed parsing %s", new Object[]{file2});
    L36:
        policy.mNewUserDisclaimer = parser.getAttributeValue(null, ATTR_NEW_USER_DISCLAIMER);     // Catch: Throwable -> L191 Throwable -> L191 Throwable -> L191 Throwable -> L191 Throwable -> L191 FileNotFoundException -> L193
        goto L203
    L217:
        policy.mFactoryResetFlags = parser.getAttributeInt(null, ATTR_FACTORY_RESET_FLAGS, 0);     // Catch: Throwable -> L183 FileNotFoundException -> L185
        policy.mFactoryResetReason = parser.getAttributeValue(null, ATTR_FACTORY_RESET_REASON);     // Catch: Throwable -> L183 FileNotFoundException -> L185
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L183 FileNotFoundException -> L185
        policy.mLockTaskPackages.clear();     // Catch: Throwable -> L183 FileNotFoundException -> L185
        policy.mAdminList.clear();     // Catch: Throwable -> L183 FileNotFoundException -> L185
        policy.mAdminMap.clear();     // Catch: Throwable -> L183 FileNotFoundException -> L185
        policy.mAffiliationIds.clear();     // Catch: Throwable -> L183 FileNotFoundException -> L185
        policy.mOwnerInstalledCaCerts.clear();     // Catch: Throwable -> L183 FileNotFoundException -> L185
        policy.mUserControlDisabledPackages = null;     // Catch: Throwable -> L183 FileNotFoundException -> L185
    L39:
        int type2 = parser.next();     // Catch: Throwable -> L183 FileNotFoundException -> L185
        if (type2 == 1) goto L190;
        if (type2 == 3) goto L233;
    L52:
        if (type2 == 3) goto L188;
        if (type2 == 4) goto L188;
        String tag2 = parser.getName();     // Catch: Throwable -> L183 Throwable -> L183 Throwable -> L183 Throwable -> L183 Throwable -> L183 FileNotFoundException -> L185
        goto L186
    L58:
        if ("admin".equals(tag2) == false) goto L104;
        file2 = file;
        String name = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L95 FileNotFoundException -> L97
        goto L88
    L213:
        DeviceAdminInfo dai = adminInfoSupplier.apply(ComponentName.unflattenFromString(name));     // Catch: Throwable -> L85 FileNotFoundException -> L87 RuntimeException -> L93
        if (dai == null) goto L91;
        String name2 = name;
        boolean needsRewrite2 = needsRewrite;
    L83:
        e = e;
        int type3 = type2;
    L102:
        Slogf.w(TAG, e, "Failed loading admin %s", new Object[]{name2});     // Catch: Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
    L103:
        int permissionPolicy2 = permissionPolicy;
        Object r4 = null;
    L182:
        file = file2;
        permissionPolicy = permissionPolicy2;
        needsRewrite = needsRewrite2;
        goto L39
    L70:
        if (dai.getComponent().equals(ownerComponent) == true) goto L72;
        boolean overwritePolicies = true;
    L73:
        type3 = type2;
        ActiveAdmin ap = new ActiveAdmin(dai, false);     // Catch: Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79 RuntimeException -> L81
        ap.readFromXml(parser, overwritePolicies);     // Catch: Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79 RuntimeException -> L81
        policy.mAdminMap.put(ap.info.getComponent(), ap);     // Catch: Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79 RuntimeException -> L81
    L81:
        e = e;
        goto L102
    L72:
        overwritePolicies = false;
        goto L73
    L89:
        e = e;
        needsRewrite2 = needsRewrite;
        type3 = type2;
        goto L102
    L91:
        needsRewrite2 = needsRewrite;
        type3 = type2;
    L85:
        e = e;
    L86:
        stream = stream;
    L93:
        e = e;
    L94:
        name2 = name;
        needsRewrite2 = needsRewrite;
        type3 = type2;
    L99:
        e = e;
    L95:
        e = e;
    L88:
        stream = stream;
        goto L203
    L104:
        file2 = file;
        needsRewrite2 = needsRewrite;
        type3 = type2;
        if ("delegation".equals(tag2) == false) goto L115;
        String delegatePackage = parser.getAttributeValue(null, "delegatePackage");     // Catch: Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        String scope = parser.getAttributeValue(null, "scope");     // Catch: Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        List<String> scopes = policy.mDelegationMap.get(delegatePackage);     // Catch: Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        if (scopes != null) goto L110;
        scopes = new ArrayList();     // Catch: Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        policy.mDelegationMap.put(delegatePackage, scopes);     // Catch: Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
    L110:
        if (scopes.contains(scope) == true) goto L112;
        scopes.add(scope);     // Catch: Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
    L112:
        permissionPolicy2 = permissionPolicy;
        r4 = null;
        goto L182
    L115:
        if ("failed-password-attempts".equals(tag2) == false) goto L119;
        policy.mFailedPasswordAttempts = parser.getAttributeInt(null, ATTR_VALUE);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        permissionPolicy2 = permissionPolicy;
        r4 = null;
        goto L182
    L119:
        if ("password-owner".equals(tag2) == false) goto L122;
        policy.mPasswordOwner = parser.getAttributeInt(null, ATTR_VALUE);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        permissionPolicy2 = permissionPolicy;
        r4 = null;
        goto L182
    L122:
        if (TAG_ACCEPTED_CA_CERTIFICATES.equals(tag2) == false) goto L125;
        policy.mAcceptedCaCertificates.add(parser.getAttributeValue(null, "name"));     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        permissionPolicy2 = permissionPolicy;
        r4 = null;
        goto L182
    L125:
        if (TAG_LOCK_TASK_COMPONENTS.equals(tag2) == false) goto L128;
        policy.mLockTaskPackages.add(parser.getAttributeValue(null, "name"));     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        permissionPolicy2 = permissionPolicy;
        r4 = null;
        goto L182
    L128:
        if (TAG_LOCK_TASK_FEATURES.equals(tag2) == false) goto L131;
        policy.mLockTaskFeatures = parser.getAttributeInt(null, ATTR_VALUE);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        permissionPolicy2 = permissionPolicy;
        r4 = null;
        goto L182
    L131:
        if (TAG_SECONDARY_LOCK_SCREEN.equals(tag2) == false) goto L134;
        policy.mSecondaryLockscreenEnabled = parser.getAttributeBoolean(null, ATTR_VALUE, false);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        permissionPolicy2 = permissionPolicy;
        r4 = null;
        goto L182
    L134:
        if (TAG_STATUS_BAR.equals(tag2) == false) goto L137;
        policy.mStatusBarDisabled = parser.getAttributeBoolean(null, "disabled", false);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        permissionPolicy2 = permissionPolicy;
        r4 = null;
        goto L182
    L137:
        if (TAG_DO_NOT_ASK_CREDENTIALS_ON_BOOT.equals(tag2) == false) goto L140;
        policy.mDoNotAskCredentialsOnBoot = true;     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        permissionPolicy2 = permissionPolicy;
        r4 = null;
        goto L182
    L140:
        if (TAG_AFFILIATION_ID.equals(tag2) == false) goto L143;
        policy.mAffiliationIds.add(parser.getAttributeValue(null, ATTR_ID));     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        permissionPolicy2 = permissionPolicy;
        r4 = null;
        goto L182
    L143:
        if (TAG_LAST_SECURITY_LOG_RETRIEVAL.equals(tag2) == false) goto L145;
        permissionPolicy2 = permissionPolicy;
        policy.mLastSecurityLogRetrievalTime = parser.getAttributeLong(null, ATTR_VALUE);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        r4 = null;
        goto L182
    L145:
        permissionPolicy2 = permissionPolicy;
        if (TAG_LAST_BUG_REPORT_REQUEST.equals(tag2) == false) goto L149;
        policy.mLastBugReportRequestTime = parser.getAttributeLong(null, ATTR_VALUE);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        r4 = null;
        goto L182
    L149:
        if (TAG_LAST_NETWORK_LOG_RETRIEVAL.equals(tag2) == false) goto L152;
        policy.mLastNetworkLogsRetrievalTime = parser.getAttributeLong(null, ATTR_VALUE);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        r4 = null;
        goto L182
    L152:
        if (TAG_ADMIN_BROADCAST_PENDING.equals(tag2) == false) goto L155;
        String pending = parser.getAttributeValue(null, ATTR_VALUE);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        policy.mAdminBroadcastPending = Boolean.toString(true).equals(pending);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        r4 = null;
        goto L182
    L155:
        if (TAG_INITIALIZATION_BUNDLE.equals(tag2) == false) goto L158;
        policy.mInitBundle = PersistableBundle.restoreFromXml(parser);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        r4 = null;
        goto L182
    L158:
        if (TAG_PASSWORD_TOKEN_HANDLE.equals(tag2) == false) goto L161;
        policy.mPasswordTokenHandle = parser.getAttributeLong(null, ATTR_VALUE);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        r4 = null;
        goto L182
    L161:
        if (TAG_CURRENT_INPUT_METHOD_SET.equals(tag2) == false) goto L164;
        policy.mCurrentInputMethodSet = true;     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        r4 = null;
        goto L182
    L164:
        if (TAG_OWNER_INSTALLED_CA_CERT.equals(tag2) == false) goto L167;
        policy.mOwnerInstalledCaCerts.add(parser.getAttributeValue(null, ATTR_ALIAS));     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        r4 = null;
        goto L182
    L167:
        if (TAG_APPS_SUSPENDED.equals(tag2) == false) goto L170;
        policy.mAppsSuspended = parser.getAttributeBoolean(null, ATTR_VALUE, false);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        r4 = null;
        goto L182
    L170:
        if (TAG_BYPASS_ROLE_QUALIFICATIONS.equals(tag2) == false) goto L173;
        policy.mBypassDevicePolicyManagementRoleQualifications = true;     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        policy.mCurrentRoleHolder = parser.getAttributeValue(null, ATTR_VALUE);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        r4 = null;
        goto L182
    L173:
        if (TAG_KEEP_PROFILES_RUNNING.equals(tag2) == false) goto L176;
        policy.mEffectiveKeepProfilesRunning = parser.getAttributeBoolean(null, ATTR_VALUE, false);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        r4 = null;
        goto L182
    L176:
        if (TAG_PROTECTED_PACKAGES.equals(tag2) == true) goto L178;
        r4 = null;
        Slogf.w(TAG, "Unknown tag: %s", new Object[]{tag2});     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
        goto L182
    L178:
        if (policy.mUserControlDisabledPackages != null) goto L180;
        policy.mUserControlDisabledPackages = new ArrayList();     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
    L180:
        r4 = null;
        policy.mUserControlDisabledPackages.add(parser.getAttributeValue(null, "name"));     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
    L188:
        file = file;
        permissionPolicy = permissionPolicy;
        needsRewrite = needsRewrite;
        goto L39
    L233:
        if (parser.getDepth() <= outerDepth) goto L190;
    L48:
        e = e;
        file2 = file;
        stream = stream;
    L51:
        stream = stream;
    L190:
        stream = stream;
    L183:
        e = e;
        file2 = file;
        stream = stream;
    L186:
        stream = stream;
        goto L203
    L219:
        policy.mRestrictionsProvider = ComponentName.unflattenFromString(permissionProvider);     // Catch: Throwable -> L17 FileNotFoundException -> L19
        goto L21
    L196:
        throw new XmlPullParserException("Settings do not start with policies tag: found " + tag);     // Catch: Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 Throwable -> L77 FileNotFoundException -> L79
    L77:
        e = e;
        stream = stream;
        goto L201
    L80:
        stream = stream;
    L191:
        e = e;
        file2 = file;
        goto L201
    L197:
        e = e;
        file2 = file;
    L203:
        if (stream != null) goto L229;
    L209:
        policy.mAdminList.addAll(policy.mAdminMap.values());
        return;
    L229:
        stream.close();     // Catch: IOException -> L206
        goto L209
    }

    void validatePasswordOwner() {
        if (this.mPasswordOwner < 0) goto L15;
        boolean haveOwner = false;
        int i = this.mAdminList.size() - 1;
    L5:
        if (i < 0) goto L10;
        if (this.mAdminList.get(i).getUid() == this.mPasswordOwner) goto L8;
        i = i - 1;
        goto L5
    L8:
        haveOwner = true;
    L10:
        if (haveOwner == true) goto L16;
        Slogf.w(TAG, "Previous password owner %s no longer active; disabling", new Object[]{Integer.valueOf(this.mPasswordOwner)});
        this.mPasswordOwner = -1;
        return;
    L16:
        return;
    }

    void setDelayedFactoryReset(String reason, boolean wipeExtRequested, boolean wipeEuicc, boolean wipeResetProtectionData) {
        this.mFactoryResetReason = reason;
        this.mFactoryResetFlags = 1;
        if (wipeExtRequested == false) goto L5;
        this.mFactoryResetFlags |= 2;
    L5:
        if (wipeEuicc == false) goto L7;
        this.mFactoryResetFlags |= 4;
    L7:
        if (wipeResetProtectionData == false) goto L10;
        this.mFactoryResetFlags |= 8;
        return;
    }

    boolean isNewUserDisclaimerAcknowledged() {
        if (this.mNewUserDisclaimer == null) goto L5;
        String r0 = this.mNewUserDisclaimer;
        switch(r0.hashCode()) {
            case -1238968671: goto L19;
            case -1049376843: goto L16;
            case 92636904: goto L13;
            default: goto L21;
        };
    L21:
        byte r1 = -1;
    L22:
        switch(r1) {
            case 0: goto L26;
            case 1: goto L26;
            case 2: goto L25;
            default: goto L23;
        };
    L23:
        Slogf.w(TAG, "isNewUserDisclaimerAcknowledged(%d): invalid value %d", new Object[]{Integer.valueOf(this.mUserId), this.mNewUserDisclaimer});
        return false;
    L25:
        return false;
    L26:
        return true;
    L13:
        if (r0.equals(NEW_USER_DISCLAIMER_ACKNOWLEDGED) == false) goto L21;
        r1 = 0;
        goto L22
    L16:
        if (r0.equals(NEW_USER_DISCLAIMER_NEEDED) == false) goto L21;
        r1 = 2;
        goto L22
    L19:
        if (r0.equals(NEW_USER_DISCLAIMER_NOT_NEEDED) == false) goto L21;
        r1 = 1;
        goto L22
    L5:
        if (this.mUserId != 0) goto L7;
        return true;
    L7:
        Slogf.w(TAG, "isNewUserDisclaimerAcknowledged(%d): mNewUserDisclaimer is null", new Object[]{Integer.valueOf(this.mUserId)});
        return false;
    }

    void dump(IndentingPrintWriter pw) {
        pw.println();
        pw.println("Enabled Device Admins (User " + this.mUserId + ", provisioningState: " + this.mUserProvisioningState + "):");
        int n = this.mAdminList.size();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        ActiveAdmin ap = this.mAdminList.get(i);
        if (ap == null) goto L7;
        pw.increaseIndent();
        pw.print(ap.info.getComponent().flattenToShortString());
        pw.println(":");
        pw.increaseIndent();
        ap.dump(pw);
        pw.decreaseIndent();
        pw.decreaseIndent();
    L7:
        i = i + 1;
        goto L3
    L9:
        if (this.mRemovingAdmins.isEmpty() == true) goto L11;
        pw.increaseIndent();
        pw.println("Removing Device Admins (User " + this.mUserId + "): " + this.mRemovingAdmins);
        pw.decreaseIndent();
    L11:
        pw.println();
        pw.increaseIndent();
        pw.print("mPasswordOwner=");
        pw.println(this.mPasswordOwner);
        pw.print("mPasswordTokenHandle=");
        pw.println(Long.toHexString(this.mPasswordTokenHandle));
        pw.print("mAppsSuspended=");
        pw.println(this.mAppsSuspended);
        pw.print("mUserSetupComplete=");
        pw.println(this.mUserSetupComplete);
        pw.print("mAffiliationIds=");
        pw.println(this.mAffiliationIds);
        pw.print("mNewUserDisclaimer=");
        pw.println(this.mNewUserDisclaimer);
        if (this.mFactoryResetFlags == 0) goto L15;
        pw.print("mFactoryResetFlags=");
        pw.print(this.mFactoryResetFlags);
        pw.print(" (");
        pw.print(factoryResetFlagsToString(this.mFactoryResetFlags));
        pw.println(')');
    L15:
        if (this.mFactoryResetReason == null) goto L18;
        pw.print("mFactoryResetReason=");
        pw.println(this.mFactoryResetReason);
    L18:
        if (this.mDelegationMap.size() == 0) goto L28;
        pw.println("mDelegationMap=");
        pw.increaseIndent();
        int i2 = 0;
    L21:
        if (i2 >= this.mDelegationMap.size()) goto L27;
        List<String> delegationScopes = this.mDelegationMap.valueAt(i2);
        pw.println(this.mDelegationMap.keyAt(i2) + "[size=" + delegationScopes.size() + "]");
        pw.increaseIndent();
        int j = 0;
    L24:
        if (j >= delegationScopes.size()) goto L26;
        pw.println(j + ": " + delegationScopes.get(j));
        j = j + 1;
        goto L24
    L26:
        pw.decreaseIndent();
        i2 = i2 + 1;
        goto L21
    L27:
        pw.decreaseIndent();
    L28:
        pw.decreaseIndent();
    }

    static String factoryResetFlagsToString(int flags) {
        return DebugUtils.flagsToString(DevicePolicyData.class, "FACTORY_RESET_FLAG_", flags);
    }
}
