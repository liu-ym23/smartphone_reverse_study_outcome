package com.stepos.policy.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.stepos.alphame.R;
import com.stepos.policy.sdk.activity.PolicyPermissionDesActivity;
import com.stepos.policy.sdk.activity.PolicyWebViewActivity;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.config.PolicySdkErrorCode;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import stepos.support.v7.app.DialogInterfaceC0865j;

/* loaded from: classes.dex */
public class PolicySdk {

    public interface PolicyDefaultDialogOnClick {
        void setLeftOnClickListener();

        void setRightOnClickListener();
    }

    public interface PolicySdkCallback {
        void getResult(PolicySdkResultBean policySdkResultBean);
    }

    public interface PolicySdkEncryptCallback {
        void getResult(ArrayList<DeleteInfoBean> arrayList);
    }

    public static void autoUploadRecord(Context context, String[] strArr, String str, String str2, PolicySdkCallback policySdkCallback) {
        PolicySdkResultBean policySdkResultBean;
        int i4;
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            policySdkResultBean = new PolicySdkResultBean();
            i4 = PolicySdkErrorCode.NOT_NETWORK;
        } else {
            PolicyManager policyManager = PolicyManager.INSTANCE;
            if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
                policySdkResultBean = new PolicySdkResultBean();
                i4 = PolicySdkErrorCode.PARAMETER_ERROR;
            } else {
                PolicyManager.autoUploadRecord(context, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str, str2);
                policySdkResultBean = new PolicySdkResultBean();
                i4 = 0;
            }
        }
        policySdkResultBean.setCode(i4);
        policySdkCallback.getResult(policySdkResultBean);
    }

    public static void checkNewestPolicy(Context context, boolean z4, String str, String str2, PolicySdkCallback policySdkCallback) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppSecret().isEmpty() && !policyManager.getMAppVersionName().isEmpty() && !str.isEmpty() && !str2.isEmpty()) {
            PolicyManager.checkNewestPolicy(context, z4, policyManager.getMAppId(), policyManager.getMAppSecret(), str, str2, policyManager.getMAppVersionName(), new C0516o(policySdkCallback, 7));
            return;
        }
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
        policySdkCallback.getResult(policySdkResultBean);
    }

    public static String copyPolicyFile(Context context, String str, String str2) {
        return PolicyManager.copyPolicyFile(context, str, str2);
    }

    public static void encryptCustomDeleteInfoListBySecure(Context context, ArrayList<CustomDeleteInfoBean> arrayList, PolicySdkEncryptCallback policySdkEncryptCallback) {
        PolicyManager.encryptCustomDeleteInfoListBySecure(context, arrayList, new C0504c(policySdkEncryptCallback));
    }

    public static ArrayList<DeleteInfoBean> encryptDeleteInfoWithoutSecureService(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList) {
        return PolicyManager.encryptDeleteInfoWithoutSecureService(context, arrayList);
    }

    public static void encryptMultiDeleteListBySecure(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList, PolicySdkEncryptCallback policySdkEncryptCallback) {
        PolicyManager.encryptMultiDeleteListBySecure(context, arrayList, new C0505d(policySdkEncryptCallback));
    }

    public static void getCommonDeleteInfoListBySecure(Context context) {
        PolicyManager.getCommonDeleteInfoList(context, "phone", 1);
    }

    public static void getDeleteInfoWithoutSecureService(Context context, String str, String str2, String str3, PolicySdkCallback policySdkCallback) {
        PolicyManager.getPolicyServiceConfig(context, str, str2, str3, PolicyManager.INSTANCE.getMAppVersionName(), new C0516o(policySdkCallback, 1));
    }

    public static void getOnlinePolicyMethod(Context context, String str, String str2, String str3, Boolean bool, PolicySdkCallback policySdkCallback) {
        Bundle bundle = new Bundle();
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            if (!bool.booleanValue()) {
                getPolicy(str, str2, 0L, new d0(bool, context, str3, str2, bundle, str, policySdkCallback));
                return;
            }
            bundle.putInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY, 0);
            bundle.putString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE, str);
            bundle.putString(PolicySdkConstants.BUNDLE_KEY_CATEGORY, str2);
            bundle.putLong(PolicySdkConstants.BUNDLE_KEY_VERSION, 0L);
            PolicyWebViewActivity.INSTANCE.startOnLineWebViewActivity(context, PolicySdkConstants.ONLINE_POLICY_WEB_VIEW, str3, bundle);
            return;
        }
        PolicySdkResultBean policyNewestPath = getPolicyNewestPath(context, str2);
        if (policyNewestPath.getCode() == 0) {
            openPolicyByMethod(context, bool, str3, str2);
        } else if (bool.booleanValue()) {
            bundle.putString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE, str);
            bundle.putString(PolicySdkConstants.BUNDLE_KEY_CATEGORY, str2);
            bundle.putLong(PolicySdkConstants.BUNDLE_KEY_VERSION, 0L);
            bundle.putInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY, PolicySdkErrorCode.NOT_NETWORK);
            PolicyWebViewActivity.INSTANCE.startOnLineWebViewActivity(context, PolicySdkConstants.ONLINE_POLICY_WEB_VIEW, str3, bundle);
        }
        if (policySdkCallback != null) {
            policySdkCallback.getResult(policyNewestPath);
        }
    }

    public static void getOnlinePolicyUrl(String str, String str2, PolicySdkCallback policySdkCallback) {
        getPolicy(str, str2, 0L, policySdkCallback);
    }

    public static void getOnlinePolicyWebViewSetCustomFun(Context context, String str, String str2, String str3, Boolean bool, Function1<Context, Unit> function1) {
        PolicyWebViewActivity.INSTANCE.setSettingBtnCallback(function1);
        getOnlinePolicyMethod(context, str, str2, str3, bool, null);
    }

    public static void getPolicy(String str, String str2, Long l4, PolicySdkCallback policySdkCallback) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppSecret().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
            PolicyManager.getPolicyData(policyManager.getMAppId(), policyManager.getMAppSecret(), str, str2, l4, policyManager.getMAppVersionName(), new C0516o(policySdkCallback, 6));
            return;
        }
        PolicySdkLogUtils.INSTANCE.e("getPolicy", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
        policySdkCallback.getResult(policySdkResultBean);
    }

    public static void getPolicyByVersion(String str, Long l4, PolicySdkCallback policySdkCallback) throws Exception {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppSecret().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
            PolicyManager.getPolicyByVersion(policyManager.getMAppId(), policyManager.getMAppSecret(), str, l4, policyManager.getMAppVersionName(), new C0516o(policySdkCallback, 8));
            return;
        }
        PolicySdkLogUtils.INSTANCE.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
        policySdkCallback.getResult(policySdkResultBean);
    }

    public static void getPolicyHistoryList(String str, Long l4, String str2, PolicySdkCallback policySdkCallback) throws Exception {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.INSTANCE.e("getPolicyHistoryList", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager.getPolicyHistoryList(policyManager.getMAppId(), policyManager.getMAppSecret(), str, str2, l4.longValue(), policyManager.getMAppVersionName(), new C0516o(policySdkCallback, 3));
    }

    public static String getPolicyHistoryUrl(String str, Long l4, String str2) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !str.isEmpty() && !str2.isEmpty()) {
            return PolicyManager.getPolicyHistoryUrl(policyManager.getMAppId(), str, l4.longValue(), str2);
        }
        PolicySdkLogUtils.INSTANCE.d("getPolicyHistoryUrl", "-10001");
        return "";
    }

    public static PolicySdkResultBean getPolicyNewestPath(Context context, String str) {
        return PolicyManager.getPolicyNewestPathByCustom(context, str);
    }

    public static String getPolicySdkVersion() {
        return PolicySdkConstants.VERSION_NAME;
    }

    public static void getPrivateDeleteInfoListBySecure(Context context, PolicySdkEncryptCallback policySdkEncryptCallback) {
        PolicyManager.getPrivateDeleteInfoList(context, PolicyManager.INSTANCE.getMAppId(), "phone", 1, new C0499a(policySdkEncryptCallback));
    }

    public static void initSDK(Context context, String str, String str2, String str3, HashMap<String, String> map) {
        PolicyManager.initSDK(context, str, str2, str3, map);
    }

    public static boolean isSupportSecureService31(Context context) {
        return PolicyManager.isSupportSecureService31(context);
    }

    public static boolean isSupportSecureServiceRSASign(Context context) {
        return PolicyManager.isSupportSecureService(context, 12000011);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$checkNewestPolicy$0(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PolicySdkResultBean lambda$getDeleteInfoWithoutSecureService$7(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$getPolicy$4(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        Log.d("PolicySdk", "getPolicy: =" + policySdkResultBean.getCode());
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PolicySdkResultBean lambda$getPolicyByVersion$2(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PolicySdkResultBean lambda$getPolicyHistoryList$3(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$uploadPolicyOperateRecord$1(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$uploadRecordWithoutSecureService$8(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$withdrawalCleanCustomUploadRecord$5(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$withdrawalCleanUploadRecordByAccountValidateCode$6(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    public static void openOnlinePolicyByBrowserWithoutLocal(Context context, String str, String str2, PolicySdkCallback policySdkCallback) {
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            getPolicy(str, str2, 0L, new f0(context, policySdkCallback));
            return;
        }
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        policySdkResultBean.setCode(PolicySdkErrorCode.NOT_NETWORK);
        if (policySdkCallback != null) {
            policySdkCallback.getResult(policySdkResultBean);
        }
    }

    public static PolicySdkResultBean openPolicyByMethod(Context context, Boolean bool, String str, String str2) {
        return PolicyManager.openPolicyMethod(context, bool.booleanValue(), str, str2);
    }

    public static void recoveryOKHttpConnect() {
        SocketHookUtil.recoveryPlatform();
    }

    public static void replaceOKHttpConnect() {
        SocketHookUtil.replacePlatform();
    }

    public static void setCompanyCode(String str) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        policyManager.setCompanyCode(str);
        policyManager.setBrand(str);
    }

    public static void setInitSDKByDeviceProtectedStorageContext(Boolean bool) {
        PolicyManager.INSTANCE.setInitSDKByDeviceProtectedStorageContext(bool.booleanValue());
    }

    public static void setPolicyAssetsCSSFileName(String str) {
        PolicyManager.INSTANCE.setCustomPolicyCSSFileName(str);
    }

    public static DialogInterfaceC0865j showBasicDialog(Context context, String str, CharSequence charSequence, String str2, String str3, stepos.support.v7.app.S s4) {
        PolicyManager.INSTANCE.saveAgreeStatus(context, 0);
        ReadClipboardUtils.injectClipboardManager(context);
        return PolicyManager.showDialogByCustomView(context, str, charSequence, str2, str3, s4);
    }

    public static DialogInterfaceC0865j showBasicDialogRecord(Context context, String str, CharSequence charSequence, String str2, String str3, String[] strArr, String str4, stepos.support.v7.app.S s4) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.INSTANCE.e("showReGrantTwoPolicyDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        policyManager.saveAgreeStatus(context, 0);
        ReadClipboardUtils.injectClipboardManager(context);
        return PolicyManager.showDialogByCustomViewAndUploadRecord(context, str, charSequence, str2, str3, mAppId, mAppSecret, mAppVersionName, strArr, str4, "1", s4);
    }

    public static DialogInterfaceC0865j showCustomPolicyDialog(Context context, Boolean bool, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        if (strArr != null) {
            strArr = PolicySdkToolsUtils.INSTANCE.getCustomPermissionKey(context, strArr);
        }
        String[] strArr3 = strArr;
        PolicyManager.INSTANCE.saveAgreeStatus(context, 0);
        ReadClipboardUtils.injectClipboardManager(context);
        return PolicyManager.showCustomPolicyDialog(context, bool.booleanValue(), strArr3, strArr2, str, charSequence, charSequence2, onPermissionClickListener);
    }

    public static DialogInterfaceC0865j showCustomPolicyDialogRecord(Context context, Boolean bool, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, String[] strArr3, String str2, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        String[] customPermissionKey = strArr;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.INSTANCE.e("showCustomPolicyDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数");
            return null;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        if (customPermissionKey != null) {
            customPermissionKey = PolicySdkToolsUtils.INSTANCE.getCustomPermissionKey(context, strArr);
        }
        String[] strArr4 = customPermissionKey;
        policyManager.saveAgreeStatus(context, 0);
        ReadClipboardUtils.injectClipboardManager(context);
        return PolicyManager.showCustomPolicyDialogAndUploadRecord(context, bool.booleanValue(), strArr4, strArr2, str, charSequence, charSequence2, mAppId, mAppSecret, mAppVersionName, strArr3, str2, onPermissionClickListener);
    }

    public static stepos.support.v7.app.U showDialogByCustomThemeViewBuilder(Context context, int i4, String str, CharSequence charSequence, String str2, String str3, stepos.support.v7.app.S s4) {
        return PolicyManager.showDialogByCustomThemeViewBuilder(context, i4, str, charSequence, str2, str3, s4);
    }

    public static stepos.support.v7.app.U showDialogByCustomViewBuilder(Context context, String str, CharSequence charSequence, String str2, String str3, stepos.support.v7.app.S s4) {
        return PolicyManager.showDialogByCustomViewBuilder(context, str, charSequence, str2, str3, "3", s4);
    }

    public static DialogInterfaceC0865j showNewestDialog(Context context, String str, String str2, String[] strArr, boolean z4, CharSequence charSequence, String str3, String str4, stepos.support.v7.app.S s4) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppSecret().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
            return PolicyManager.showNewestDialogAndUploadRecord(context, str2, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str, z4, charSequence, str3, str4, s4);
        }
        PolicySdkLogUtils.INSTANCE.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
        return null;
    }

    public static void showPermissionActivity(Context context, Intent intent) {
        int i4 = PolicyPermissionDesActivity.f12107k;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            intent.setClass(context, PolicyPermissionDesActivity.class);
            context.startActivity(intent);
        } catch (Exception e4) {
            PolicySdkLogUtils.INSTANCE.e("PolicyPermissionDesActivity", "startPermissionDesActivity Exception: " + e4.getMessage());
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setClass(context, PolicyPermissionDesActivity.class);
            context.startActivity(intent);
        }
    }

    public static DialogInterfaceC0865j showReGrantDialog(Context context, boolean z4, String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, stepos.support.v7.app.S s4) {
        if (!z4) {
            return PolicyManager.showReGrantDialog(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, s4);
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty() || str4.isEmpty()) {
            PolicySdkLogUtils.INSTANCE.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        return PolicyManager.showReGrantDialogAndUploadRecord(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), new String[]{str4}, str, s4);
    }

    public static DialogInterfaceC0865j showReGrantTwoPolicyDialog(Context context, boolean z4, String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, String str5, String str6, stepos.support.v7.app.S s4) {
        if (!z4) {
            return PolicyManager.showReGrantTwoPolicyDialog(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, str5, str6, s4);
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty() || str6.isEmpty() || str4.isEmpty()) {
            PolicySdkLogUtils.INSTANCE.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        return PolicyManager.showReGrantTwoPolicyDialogAndUploadRecord(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, str5, str6, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), new String[]{str6, str4}, str, s4);
    }

    public static DialogInterfaceC0865j showWithdrawalCleanCustomDialog(Context context, String str, CharSequence charSequence, String str2, String str3, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        getCommonDeleteInfoListBySecure(context);
        return PolicyManager.showWithdrawalAndCleanServiceDataDialog(context, str, charSequence, str2, str3, str4, onPermissionClickListener);
    }

    public static DialogInterfaceC0865j showWithdrawalCleanCustomDialogByAccount(Context context, boolean z4, String str, CharSequence charSequence, String str2, String str3, String str4, String str5, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        getCommonDeleteInfoListBySecure(context);
        return PolicyManager.showWithdrawalAndCleanServiceDataDialogByAccount(context, z4, str, charSequence, str2, str3, str4, str5, onPermissionClickListener);
    }

    public static DialogInterfaceC0865j showWithdrawalCleanDialog(Context context, CharSequence charSequence, String str, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        return showWithdrawalCleanCustomDialog(context, context.getString(R.string.policy_sdk_withdraw_text_title), charSequence, context.getString(R.string.policy_sdk_withdraw_text_exit), context.getString(R.string.policy_sdk_withdraw_text_confirm), str, new h0(onPermissionClickListener));
    }

    public static DialogInterfaceC0865j showWithdrawalCleanDialogByAccountVerify(Context context, boolean z4, CharSequence charSequence, String str, String str2, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        String string = context.getString(R.string.policy_sdk_withdraw_text_title);
        String string2 = context.getString(R.string.policy_sdk_withdraw_text_confirm);
        String string3 = context.getString(R.string.policy_sdk_withdraw_text_exit);
        getCommonDeleteInfoListBySecure(context);
        return PolicyManager.showWithdrawalAndCleanServiceDataDialogByAccount(context, z4, string, charSequence, string3, string2, str, str2, new j0(onPermissionClickListener));
    }

    public static DialogInterfaceC0865j showWithdrawalDialog(Context context, String str, CharSequence charSequence, String str2, String str3, stepos.support.v7.app.S s4) {
        stepos.support.v7.app.U uShowDialogByCustomViewBuilder = showDialogByCustomViewBuilder(context, str, charSequence, str2, str3, s4);
        uShowDialogByCustomViewBuilder.f14344h = true;
        return uShowDialogByCustomViewBuilder.a();
    }

    public static DialogInterfaceC0865j showWithdrawalDialogRecord(Context context, String str, CharSequence charSequence, String str2, String str3, String[] strArr, String str4, stepos.support.v7.app.S s4) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.INSTANCE.e("showReGrantTwoPolicyDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        stepos.support.v7.app.U uShowDialogUploadRecordBuilder = PolicyManager.showDialogUploadRecordBuilder(context, str, charSequence, str2, str3, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str4, "3", s4);
        uShowDialogUploadRecordBuilder.f14344h = true;
        return uShowDialogUploadRecordBuilder.a();
    }

    public static void uploadPolicyOperateRecord(Context context, String[] strArr, String str, String str2, PolicySdkCallback policySdkCallback) {
        PolicySdkResultBean policySdkResultBean;
        int i4;
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            policySdkResultBean = new PolicySdkResultBean();
            i4 = PolicySdkErrorCode.NOT_NETWORK;
        } else {
            PolicyManager policyManager = PolicyManager.INSTANCE;
            if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppSecret().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
                PolicyManager.uploadPolicyOperateRecord(policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), PolicyManager.createRecordRequest(context, strArr, str, str2), new C0516o(policySdkCallback, 5));
                return;
            } else {
                policySdkResultBean = new PolicySdkResultBean();
                i4 = PolicySdkErrorCode.PARAMETER_ERROR;
            }
        }
        policySdkResultBean.setCode(i4);
        policySdkCallback.getResult(policySdkResultBean);
    }

    public static void uploadRecordWithoutSecureService(Context context, String str, String str2, String str3, ArrayList<DeleteInfoBean> arrayList, String[] strArr, String str4, PolicySdkCallback policySdkCallback) {
        PolicySdkResultBean policySdkResultBean;
        int i4;
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            policySdkResultBean = new PolicySdkResultBean();
            i4 = PolicySdkErrorCode.NOT_NETWORK;
        } else {
            PolicyManager policyManager = PolicyManager.INSTANCE;
            if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppSecret().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
                PolicyManager.uploadRecordWithoutSecureService(context, str, str2, str3, arrayList, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str4, "3", new C0516o(policySdkCallback, 2));
                return;
            } else {
                policySdkResultBean = new PolicySdkResultBean();
                i4 = PolicySdkErrorCode.PARAMETER_ERROR;
            }
        }
        policySdkResultBean.setCode(i4);
        policySdkCallback.getResult(policySdkResultBean);
    }

    public static void withdrawalCleanCustomUploadRecord(Context context, String str, ArrayList<DeleteInfoBean> arrayList, String[] strArr, String str2, String str3, PolicySdkCallback policySdkCallback) {
        PolicySdkResultBean policySdkResultBean;
        int i4;
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            policySdkResultBean = new PolicySdkResultBean();
            i4 = PolicySdkErrorCode.NOT_NETWORK;
        } else {
            PolicyManager policyManager = PolicyManager.INSTANCE;
            if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppSecret().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
                PolicyManager.uploadRecordToCleanServiceData(context, "", "", str, arrayList, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str2, str3, new C0516o(policySdkCallback, 0));
                return;
            } else {
                policySdkResultBean = new PolicySdkResultBean();
                i4 = PolicySdkErrorCode.PARAMETER_ERROR;
            }
        }
        policySdkResultBean.setCode(i4);
        policySdkCallback.getResult(policySdkResultBean);
    }

    public static void withdrawalCleanUploadRecord(Context context, String str, String str2, PolicySdkCallback policySdkCallback) {
        withdrawalCleanCustomUploadRecord(context, str, null, new String[]{"pp"}, str2, "3", policySdkCallback);
    }

    public static void withdrawalCleanUploadRecordByAccountValidateCode(Context context, String str, String str2, String str3, ArrayList<DeleteInfoBean> arrayList, String[] strArr, String str4, PolicySdkCallback policySdkCallback) {
        PolicySdkResultBean policySdkResultBean;
        int i4;
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            policySdkResultBean = new PolicySdkResultBean();
            i4 = PolicySdkErrorCode.NOT_NETWORK;
        } else {
            PolicyManager policyManager = PolicyManager.INSTANCE;
            if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppSecret().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
                PolicyManager.uploadRecordToCleanServiceData(context, str, str2, str3, arrayList, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str4, "3", new C0516o(policySdkCallback, 4));
                return;
            } else {
                policySdkResultBean = new PolicySdkResultBean();
                i4 = PolicySdkErrorCode.PARAMETER_ERROR;
            }
        }
        policySdkResultBean.setCode(i4);
        policySdkCallback.getResult(policySdkResultBean);
    }
}
