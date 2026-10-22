package com.stepos.policy.sdk;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity;
import com.stepos.policy.sdk.activity.PolicyPermissionDesActivity;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.config.PolicySdkErrorCode;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import jb.v;
import stepos.support.v7.app.f0;
import stepos.support.v7.app.h0;
import stepos.support.v7.app.i;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class PolicySdk {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface PolicyDefaultDialogOnClick {
        void setLeftOnClickListener();

        void setRightOnClickListener();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface PolicySdkCallback {
        void getResult(PolicySdkResultBean policySdkResultBean);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface PolicySdkEncryptCallback {
        void getResult(ArrayList<DeleteInfoBean> arrayList);
    }

    public static void autoUploadRecord(Context context, String[] strArr, String str, String str2, PolicySdkCallback policySdkCallback) {
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.NOT_NETWORK);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
            policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean2);
        } else {
            PolicyManager.autoUploadRecord(context, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str, str2);
            PolicySdkResultBean policySdkResultBean3 = new PolicySdkResultBean();
            policySdkResultBean3.setCode(0);
            policySdkCallback.getResult(policySdkResultBean3);
        }
    }

    public static void checkNewestPolicy(Context context, boolean z10, String str, String str2, PolicySdkCallback policySdkCallback) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty() || str.isEmpty() || str2.isEmpty()) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        b bVar = new b(7);
        bVar.f2786f = policySdkCallback;
        VarHandle.storeStoreFence();
        PolicyManager.checkNewestPolicy(context, z10, mAppId, mAppSecret, str, str2, mAppVersionName, bVar);
    }

    public static String copyPolicyFile(Context context, String str, String str2) {
        return PolicyManager.copyPolicyFile(context, str, str2);
    }

    public static void encryptCustomDeleteInfoListBySecure(Context context, ArrayList<CustomDeleteInfoBean> arrayList, final PolicySdkEncryptCallback policySdkEncryptCallback) {
        PolicyManager.encryptCustomDeleteInfoListBySecure(context, arrayList, new l() { // from class: com.stepos.policy.sdk.PolicySdk.6
            @Override // xb.l
            public v invoke(ArrayList<DeleteInfoBean> arrayList2) {
                policySdkEncryptCallback.getResult(arrayList2);
                return null;
            }
        });
    }

    public static ArrayList<DeleteInfoBean> encryptDeleteInfoWithoutSecureService(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList) {
        return PolicyManager.encryptDeleteInfoWithoutSecureService(context, arrayList);
    }

    public static void encryptMultiDeleteListBySecure(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList, final PolicySdkEncryptCallback policySdkEncryptCallback) {
        PolicyManager.encryptMultiDeleteListBySecure(context, arrayList, new l() { // from class: com.stepos.policy.sdk.PolicySdk.7
            @Override // xb.l
            public v invoke(ArrayList<DeleteInfoBean> arrayList2) {
                policySdkEncryptCallback.getResult(arrayList2);
                return null;
            }
        });
    }

    public static void getCommonDeleteInfoListBySecure(Context context) {
        PolicyManager.getCommonDeleteInfoList(context, "phone", 1);
    }

    public static void getDeleteInfoWithoutSecureService(Context context, String str, String str2, String str3, PolicySdkCallback policySdkCallback) {
        String mAppVersionName = PolicyManager.INSTANCE.getMAppVersionName();
        b bVar = new b(1);
        bVar.f2786f = policySdkCallback;
        VarHandle.storeStoreFence();
        PolicyManager.getPolicyServiceConfig(context, str, str2, str3, mAppVersionName, bVar);
    }

    public static void getOnlinePolicyMethod(final Context context, final String str, final String str2, final String str3, final Boolean bool, final PolicySdkCallback policySdkCallback) {
        final Bundle bundle = new Bundle();
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            if (!bool.booleanValue()) {
                getPolicy(str, str2, 0L, new PolicySdkCallback() { // from class: com.stepos.policy.sdk.PolicySdk.1
                    @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
                    public void getResult(PolicySdkResultBean policySdkResultBean) {
                        if (policySdkResultBean.getCode() == 0) {
                            PolicySdkLogUtils.Companion.d("getOnlinePolicyMethod", policySdkResultBean.getPolicyUrl());
                            if (bool.booleanValue()) {
                                PolicyHtmlViewerActivity.openPolicy(context, policySdkResultBean.getPolicyUrl(), str3, null);
                            } else {
                                PolicySdkToolsUtils.Companion.startBrowser(context, Uri.parse(policySdkResultBean.getPolicyUrl()));
                            }
                        } else {
                            PolicySdkLogUtils.Companion.d("getOnlinePolicyMethod", "getlocal getPolicyNewestPath");
                            policySdkResultBean = PolicySdk.getPolicyNewestPath(context, str2);
                            if (policySdkResultBean.getCode() == 0) {
                                PolicySdk.openPolicyByMethod(context, bool, str3, str2);
                            } else if (policySdkResultBean.getCode() == -10004 && bool.booleanValue()) {
                                bundle.putString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE, str);
                                bundle.putString(PolicySdkConstants.BUNDLE_KEY_CATEGORY, str2);
                                bundle.putLong(PolicySdkConstants.BUNDLE_KEY_VERSION, 0L);
                                bundle.putInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY, PolicySdkErrorCode.NETWORK_ERROR);
                                PolicyHtmlViewerActivity.openPolicy(context, PolicySdkConstants.ONLINE_POLICY_HTML_VIEWER, str3, bundle);
                            }
                        }
                        PolicySdkCallback policySdkCallback2 = policySdkCallback;
                        if (policySdkCallback2 != null) {
                            policySdkCallback2.getResult(policySdkResultBean);
                        }
                    }
                });
                return;
            }
            bundle.putInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY, 0);
            bundle.putString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE, str);
            bundle.putString(PolicySdkConstants.BUNDLE_KEY_CATEGORY, str2);
            bundle.putLong(PolicySdkConstants.BUNDLE_KEY_VERSION, 0L);
            PolicyHtmlViewerActivity.openPolicy(context, PolicySdkConstants.ONLINE_POLICY_HTML_VIEWER, str3, bundle);
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
            PolicyHtmlViewerActivity.openPolicy(context, PolicySdkConstants.ONLINE_POLICY_HTML_VIEWER, str3, bundle);
        }
        if (policySdkCallback != null) {
            policySdkCallback.getResult(policyNewestPath);
        }
    }

    public static void getOnlinePolicyUrl(String str, String str2, PolicySdkCallback policySdkCallback) {
        getPolicy(str, str2, 0L, policySdkCallback);
    }

    public static void getOnlinePolicyWebViewSetCustomFun(Context context, String str, String str2, String str3, Boolean bool, l lVar) {
        PolicyHtmlViewerActivity.setSettingBtnCallback(lVar);
        getOnlinePolicyMethod(context, str, str2, str3, bool, null);
    }

    public static void getPolicy(String str, String str2, Long l2, PolicySdkCallback policySdkCallback) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("getPolicy", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        b bVar = new b(6);
        bVar.f2786f = policySdkCallback;
        VarHandle.storeStoreFence();
        PolicyManager.getPolicyData(mAppId, mAppSecret, str, str2, l2, mAppVersionName, bVar);
    }

    public static void getPolicyByVersion(String str, Long l2, PolicySdkCallback policySdkCallback) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        b bVar = new b(8);
        bVar.f2786f = policySdkCallback;
        VarHandle.storeStoreFence();
        PolicyManager.getPolicyByVersion(mAppId, mAppSecret, str, l2, mAppVersionName, bVar);
    }

    public static void getPolicyHistoryList(String str, Long l2, String str2, PolicySdkCallback policySdkCallback) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("getPolicyHistoryList", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        long jLongValue = l2.longValue();
        b bVar = new b(3);
        bVar.f2786f = policySdkCallback;
        VarHandle.storeStoreFence();
        PolicyManager.getPolicyHistoryList(mAppId, mAppSecret, str, str2, jLongValue, mAppVersionName, bVar);
    }

    public static String getPolicyHistoryUrl(String str, Long l2, String str2) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !str.isEmpty() && !str2.isEmpty()) {
            return PolicyManager.getPolicyHistoryUrl(policyManager.getMAppId(), str, l2.longValue(), str2);
        }
        PolicySdkLogUtils.Companion.d("getPolicyHistoryUrl", "-10001");
        return "";
    }

    public static PolicySdkResultBean getPolicyNewestPath(Context context, String str) {
        return PolicyManager.getPolicyNewestPathByCustom(context, str);
    }

    public static String getPolicySdkVersion() {
        return "1.0.15_20260708_195137";
    }

    public static void getPrivateDeleteInfoListBySecure(Context context, final PolicySdkEncryptCallback policySdkEncryptCallback) {
        PolicyManager.getPrivateDeleteInfoList(context, PolicyManager.INSTANCE.getMAppId(), "phone", 1, new l() { // from class: com.stepos.policy.sdk.PolicySdk.5
            @Override // xb.l
            public v invoke(ArrayList<DeleteInfoBean> arrayList) {
                policySdkEncryptCallback.getResult(arrayList);
                return null;
            }
        });
    }

    public static void initSDK(Context context, String str, String str2, String str3, HashMap<String, String> map) {
        PolicyManager.initSDK(context, str, str2, str3, map);
    }

    public static boolean isLogEnabled() {
        return PolicySdkLogUtils.Companion.getEnabled();
    }

    public static boolean isSupportSecureService31(Context context) {
        return PolicyManager.isSupportSecureService31(context);
    }

    public static boolean isSupportSecureServiceRSASign(Context context) {
        return PolicyManager.isSupportSecureService(context, 12000011);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ v lambda$checkNewestPolicy$0(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PolicySdkResultBean lambda$getDeleteInfoWithoutSecureService$7(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ v lambda$getPolicy$4(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
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
    public static /* synthetic */ v lambda$uploadPolicyOperateRecord$1(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ v lambda$uploadRecordWithoutSecureService$8(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ v lambda$withdrawalCleanCustomUploadRecord$5(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ v lambda$withdrawalCleanUploadRecordByAccountValidateCode$6(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    public static void openOnlinePolicyByBrowserWithoutLocal(final Context context, String str, String str2, final PolicySdkCallback policySdkCallback) {
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            getPolicy(str, str2, 0L, new PolicySdkCallback() { // from class: com.stepos.policy.sdk.PolicySdk.2
                @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
                public void getResult(PolicySdkResultBean policySdkResultBean) {
                    if (policySdkResultBean.getCode() == 0) {
                        PolicySdkLogUtils.Companion.d("getOnlinePolicyMethod", policySdkResultBean.getPolicyUrl());
                        PolicySdkToolsUtils.Companion.startBrowser(context, Uri.parse(policySdkResultBean.getPolicyUrl()));
                    }
                    PolicySdkCallback policySdkCallback2 = policySdkCallback;
                    if (policySdkCallback2 != null) {
                        policySdkCallback2.getResult(policySdkResultBean);
                    }
                }
            });
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

    public static void setLogEnabled(boolean z10) {
        PolicySdkLogUtils.Companion.setEnabled(z10);
    }

    public static void setPolicyAssetsCSSFileName(String str) {
        PolicyManager.INSTANCE.setCustomPolicyCSSFileName(str);
    }

    public static i showBasicDialog(Context context, String str, CharSequence charSequence, String str2, String str3, f0 f0Var) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException {
        PolicyManager.INSTANCE.saveAgreeStatus(context, 0);
        ReadClipboardUtils.injectClipboardManager(context);
        return PolicyManager.showDialogByCustomView(context, str, charSequence, str2, str3, f0Var);
    }

    public static i showBasicDialogRecord(Context context, String str, CharSequence charSequence, String str2, String str3, String[] strArr, String str4, f0 f0Var) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("showReGrantTwoPolicyDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        policyManager.saveAgreeStatus(context, 0);
        ReadClipboardUtils.injectClipboardManager(context);
        return PolicyManager.showDialogByCustomViewAndUploadRecord(context, str, charSequence, str2, str3, mAppId, mAppSecret, mAppVersionName, strArr, str4, "1", f0Var);
    }

    public static void showCustomPermissionActivity(Context context, String str, String str2, String str3, String[] strArr, String[] strArr2) {
        Intent intent = new Intent();
        intent.putExtra("banner_title", str);
        intent.putExtra("head_title", str2);
        intent.putExtra("list_head_title", str3);
        intent.putExtra("custom_permission_names", strArr);
        intent.putExtra("custom_permission_summaries", strArr2);
        PolicyPermissionDesActivity.Companion.startActivity(context, intent);
    }

    public static i showCustomPolicyDialog(Context context, Boolean bool, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException {
        if (strArr != null) {
            strArr = PolicySdkToolsUtils.Companion.getCustomPermissionKey(context, strArr);
        }
        String[] strArr3 = strArr;
        PolicyManager.INSTANCE.saveAgreeStatus(context, 0);
        ReadClipboardUtils.injectClipboardManager(context);
        return PolicyManager.showCustomPolicyDialog(context, bool.booleanValue(), strArr3, strArr2, str, charSequence, charSequence2, onPermissionClickListener);
    }

    public static i showCustomPolicyDialogRecord(Context context, Boolean bool, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, String[] strArr3, String str2, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("showCustomPolicyDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数");
            return null;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        String[] customPermissionKey = strArr != null ? PolicySdkToolsUtils.Companion.getCustomPermissionKey(context, strArr) : strArr;
        policyManager.saveAgreeStatus(context, 0);
        ReadClipboardUtils.injectClipboardManager(context);
        return PolicyManager.showCustomPolicyDialogAndUploadRecord(context, bool.booleanValue(), customPermissionKey, strArr2, str, charSequence, charSequence2, mAppId, mAppSecret, mAppVersionName, strArr3, str2, onPermissionClickListener);
    }

    public static i showCustomPolicyThreeButtonDialogRecord(Context context, Boolean bool, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, String[] strArr3, String str2, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener, f0 f0Var) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException {
        String[] customPermissionKey = strArr;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("showCustomPolicyThreeButtonDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数");
            return null;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        if (customPermissionKey != null) {
            customPermissionKey = PolicySdkToolsUtils.Companion.getCustomPermissionKey(context, customPermissionKey);
        }
        policyManager.saveAgreeStatus(context, 0);
        ReadClipboardUtils.injectClipboardManager(context);
        return PolicyManager.showCustomPolicyThreeButtonDialogAndUploadRecord(context, bool.booleanValue(), customPermissionKey, strArr2, str, charSequence, charSequence2, mAppId, mAppSecret, mAppVersionName, strArr3, str2, onPermissionClickListener, f0Var);
    }

    public static h0 showDialogByCustomThemeViewBuilder(Context context, int i, String str, CharSequence charSequence, String str2, String str3, f0 f0Var) {
        return PolicyManager.showDialogByCustomThemeViewBuilder(context, i, str, charSequence, str2, str3, f0Var);
    }

    public static h0 showDialogByCustomViewBuilder(Context context, String str, CharSequence charSequence, String str2, String str3, f0 f0Var) {
        return PolicyManager.showDialogByCustomViewBuilder(context, str, charSequence, str2, str3, "3", f0Var);
    }

    public static i showNewestDialog(Context context, String str, String str2, String[] strArr, boolean z10, CharSequence charSequence, String str3, String str4, f0 f0Var) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppSecret().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
            return PolicyManager.showNewestDialogAndUploadRecord(context, str2, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str, z10, charSequence, str3, str4, f0Var);
        }
        PolicySdkLogUtils.Companion.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
        return null;
    }

    public static void showPermissionActivity(Context context, Intent intent) {
        PolicyPermissionDesActivity.Companion.startActivity(context, intent);
    }

    public static i showReGrantDialog(Context context, boolean z10, String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, f0 f0Var) {
        if (!z10) {
            return PolicyManager.showReGrantDialog(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, f0Var);
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty() || str4.isEmpty()) {
            PolicySdkLogUtils.Companion.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        return PolicyManager.showReGrantDialogAndUploadRecord(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), new String[]{str4}, str, f0Var);
    }

    public static i showReGrantTwoPolicyDialog(Context context, boolean z10, String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, String str5, String str6, f0 f0Var) {
        if (!z10) {
            return PolicyManager.showReGrantTwoPolicyDialog(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, str5, str6, f0Var);
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty() || str6.isEmpty() || str4.isEmpty()) {
            PolicySdkLogUtils.Companion.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        return PolicyManager.showReGrantTwoPolicyDialogAndUploadRecord(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, str5, str6, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), new String[]{str6, str4}, str, f0Var);
    }

    public static i showWithdrawalCleanCustomDialog(Context context, String str, CharSequence charSequence, String str2, String str3, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        getCommonDeleteInfoListBySecure(context);
        return PolicyManager.showWithdrawalAndCleanServiceDataDialog(context, str, charSequence, str2, str3, str4, onPermissionClickListener);
    }

    public static i showWithdrawalCleanCustomDialogByAccount(Context context, boolean z10, String str, CharSequence charSequence, String str2, String str3, String str4, String str5, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        getCommonDeleteInfoListBySecure(context);
        return PolicyManager.showWithdrawalAndCleanServiceDataDialogByAccount(context, z10, str, charSequence, str2, str3, str4, str5, onPermissionClickListener);
    }

    public static i showWithdrawalCleanDialog(Context context, CharSequence charSequence, String str, final PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        return showWithdrawalCleanCustomDialog(context, context.getString(R.string.policy_sdk_withdraw_text_title), charSequence, context.getString(R.string.policy_sdk_withdraw_text_exit), context.getString(R.string.policy_sdk_withdraw_text_confirm), str, new PolicyPermissionDialogBuilder.OnPermissionClickListener() { // from class: com.stepos.policy.sdk.PolicySdk.3
            @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
            public void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
                onPermissionClickListener.onPermissionClick(dialogInterface, z11, z10 ? "1" : "0");
            }
        });
    }

    public static i showWithdrawalCleanDialogByAccountVerify(Context context, boolean z10, CharSequence charSequence, String str, String str2, final PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        String string = context.getString(R.string.policy_sdk_withdraw_text_title);
        String string2 = context.getString(R.string.policy_sdk_withdraw_text_confirm);
        String string3 = context.getString(R.string.policy_sdk_withdraw_text_exit);
        getCommonDeleteInfoListBySecure(context);
        return PolicyManager.showWithdrawalAndCleanServiceDataDialogByAccount(context, z10, string, charSequence, string3, string2, str, str2, new PolicyPermissionDialogBuilder.OnPermissionClickListener() { // from class: com.stepos.policy.sdk.PolicySdk.4
            @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
            public void onPermissionClick(DialogInterface dialogInterface, boolean z11, boolean z12, boolean z13) {
                onPermissionClickListener.onPermissionClick(dialogInterface, z11, PolicySdkToolsUtils.Companion.getVerifyType(z12, z13));
            }
        });
    }

    public static i showWithdrawalDialog(Context context, String str, CharSequence charSequence, String str2, String str3, f0 f0Var) {
        h0 h0VarShowDialogByCustomViewBuilder = showDialogByCustomViewBuilder(context, str, charSequence, str2, str3, f0Var);
        h0VarShowDialogByCustomViewBuilder.f12327h = true;
        return h0VarShowDialogByCustomViewBuilder.a();
    }

    public static i showWithdrawalDialogRecord(Context context, String str, CharSequence charSequence, String str2, String str3, String[] strArr, String str4, f0 f0Var) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("showReGrantTwoPolicyDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        h0 h0VarShowDialogUploadRecordBuilder = PolicyManager.showDialogUploadRecordBuilder(context, str, charSequence, str2, str3, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str4, "3", f0Var);
        h0VarShowDialogUploadRecordBuilder.f12327h = true;
        return h0VarShowDialogUploadRecordBuilder.a();
    }

    public static void uploadPolicyOperateRecord(Context context, String[] strArr, String str, String str2, PolicySdkCallback policySdkCallback) {
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.NOT_NETWORK);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
            policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean2);
            return;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(context, strArr, str, str2);
        b bVar = new b(5);
        bVar.f2786f = policySdkCallback;
        VarHandle.storeStoreFence();
        PolicyManager.uploadPolicyOperateRecord(mAppId, mAppSecret, mAppVersionName, policyRecordRequestCreateRecordRequest, bVar);
    }

    public static void uploadRecordWithoutSecureService(Context context, String str, String str2, String str3, ArrayList<DeleteInfoBean> arrayList, String[] strArr, String str4, PolicySdkCallback policySdkCallback) {
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.NOT_NETWORK);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
            policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean2);
            return;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        b bVar = new b(2);
        bVar.f2786f = policySdkCallback;
        VarHandle.storeStoreFence();
        PolicyManager.uploadRecordWithoutSecureService(context, str, str2, str3, arrayList, mAppId, mAppSecret, mAppVersionName, strArr, str4, "3", bVar);
    }

    public static void withdrawalCleanCustomUploadRecord(Context context, String str, ArrayList<DeleteInfoBean> arrayList, String[] strArr, String str2, String str3, PolicySdkCallback policySdkCallback) {
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.NOT_NETWORK);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
            policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean2);
            return;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        b bVar = new b(0);
        bVar.f2786f = policySdkCallback;
        VarHandle.storeStoreFence();
        PolicyManager.uploadRecordToCleanServiceData(context, "", "", str, arrayList, mAppId, mAppSecret, mAppVersionName, strArr, str2, str3, bVar);
    }

    public static void withdrawalCleanUploadRecord(Context context, String str, String str2, PolicySdkCallback policySdkCallback) {
        withdrawalCleanCustomUploadRecord(context, str, null, new String[]{"pp"}, str2, "3", policySdkCallback);
    }

    public static void withdrawalCleanUploadRecordByAccountValidateCode(Context context, String str, String str2, String str3, ArrayList<DeleteInfoBean> arrayList, String[] strArr, String str4, PolicySdkCallback policySdkCallback) {
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.NOT_NETWORK);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
            policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean2);
            return;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        b bVar = new b(4);
        bVar.f2786f = policySdkCallback;
        VarHandle.storeStoreFence();
        PolicyManager.uploadRecordToCleanServiceData(context, str, str2, str3, arrayList, mAppId, mAppSecret, mAppVersionName, strArr, str4, "3", bVar);
    }
}
