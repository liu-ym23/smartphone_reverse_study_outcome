package com.stepos.policy.sdk;

import V3.v;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity;
import com.stepos.policy.sdk.activity.PolicyPermissionDesActivity;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.config.PolicySdkErrorCode;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.util.PolicyCloudPolicyIndex;
import com.stepos.policy.sdk.util.PolicyDialogScrollHelper;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkGate;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;
import i4.InterfaceC0772l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.libpag.BuildConfig;
import stepos.support.v7.app.r;

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

    public static /* synthetic */ v a(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    public static void autoUploadRecord(Context context, String[] strArr, String str, String str2, PolicySdkCallback policySdkCallback) {
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.NOT_NETWORK);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
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

    public static /* synthetic */ v b(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    public static /* synthetic */ v c(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    public static void checkNewestPolicy(Context context, boolean z5, String str, String str2, final PolicySdkCallback policySdkCallback) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppVersionName().isEmpty() && !str.isEmpty() && !str2.isEmpty()) {
            PolicyManager.checkNewestPolicy(context, z5, policyManager.getMAppId(), policyManager.getMAppSecret(), str, str2, policyManager.getMAppVersionName(), new InterfaceC0772l() { // from class: com.stepos.policy.sdk.l
                @Override // i4.InterfaceC0772l
                public final Object invoke(Object obj) {
                    return PolicySdk.a(policySdkCallback, (PolicySdkResultBean) obj);
                }
            });
            return;
        }
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
        policySdkCallback.getResult(policySdkResultBean);
    }

    public static String copyPolicyFile(Context context, String str, String str2) {
        return PolicyManager.copyPolicyFile(context, str, str2);
    }

    public static /* synthetic */ PolicySdkResultBean d(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    public static /* synthetic */ v e(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    public static void encryptCustomDeleteInfoListBySecure(Context context, ArrayList<CustomDeleteInfoBean> arrayList, final PolicySdkEncryptCallback policySdkEncryptCallback) {
        PolicyManager.encryptCustomDeleteInfoListBySecure(context, arrayList, new InterfaceC0772l<ArrayList<DeleteInfoBean>, v>() { // from class: com.stepos.policy.sdk.PolicySdk.6
            @Override // i4.InterfaceC0772l
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
        PolicyManager.encryptMultiDeleteListBySecure(context, arrayList, new InterfaceC0772l<ArrayList<DeleteInfoBean>, v>() { // from class: com.stepos.policy.sdk.PolicySdk.7
            @Override // i4.InterfaceC0772l
            public v invoke(ArrayList<DeleteInfoBean> arrayList2) {
                policySdkEncryptCallback.getResult(arrayList2);
                return null;
            }
        });
    }

    public static /* synthetic */ PolicySdkResultBean f(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    public static /* synthetic */ v g(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    public static void getCommonDeleteInfoListBySecure(Context context) {
        PolicyManager.getCommonDeleteInfoList(context, "phone", 1);
    }

    public static void getDeleteInfoWithoutSecureService(Context context, String str, String str2, String str3, final PolicySdkCallback policySdkCallback) {
        PolicyManager.getPolicyServiceConfig(context, str, str2, str3, PolicyManager.INSTANCE.getMAppVersionName(), new InterfaceC0772l() { // from class: com.stepos.policy.sdk.f
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return PolicySdk.d(policySdkCallback, (PolicySdkResultBean) obj);
            }
        });
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

    public static void getOnlinePolicyWebViewSetCustomFun(Context context, String str, String str2, String str3, Boolean bool, InterfaceC0772l<Context, v> interfaceC0772l) {
        PolicyHtmlViewerActivity.setSettingBtnCallback(interfaceC0772l);
        getOnlinePolicyMethod(context, str, str2, str3, bool, null);
    }

    public static void getPolicy(String str, String str2, Long l5, final PolicySdkCallback policySdkCallback) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
            PolicyManager.getPolicyData(policyManager.getMAppId(), policyManager.getMAppSecret(), str, str2, l5, policyManager.getMAppVersionName(), new InterfaceC0772l() { // from class: com.stepos.policy.sdk.k
                @Override // i4.InterfaceC0772l
                public final Object invoke(Object obj) {
                    return PolicySdk.i(policySdkCallback, (PolicySdkResultBean) obj);
                }
            });
            return;
        }
        PolicySdkLogUtils.Companion.e("getPolicy", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
        policySdkCallback.getResult(policySdkResultBean);
    }

    public static void getPolicyByVersion(String str, Long l5, final PolicySdkCallback policySdkCallback) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
            PolicyManager.getPolicyByVersion(policyManager.getMAppId(), policyManager.getMAppSecret(), str, l5, policyManager.getMAppVersionName(), new InterfaceC0772l() { // from class: com.stepos.policy.sdk.m
                @Override // i4.InterfaceC0772l
                public final Object invoke(Object obj) {
                    return PolicySdk.h(policySdkCallback, (PolicySdkResultBean) obj);
                }
            });
            return;
        }
        PolicySdkLogUtils.Companion.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
        policySdkCallback.getResult(policySdkResultBean);
    }

    public static void getPolicyHistoryList(String str, Long l5, String str2, final PolicySdkCallback policySdkCallback) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("getPolicyHistoryList", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager.getPolicyHistoryList(policyManager.getMAppId(), policyManager.getMAppSecret(), str, str2, l5.longValue(), policyManager.getMAppVersionName(), new InterfaceC0772l() { // from class: com.stepos.policy.sdk.h
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return PolicySdk.f(policySdkCallback, (PolicySdkResultBean) obj);
            }
        });
    }

    public static String getPolicyHistoryUrl(String str, Long l5, String str2) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !str.isEmpty() && !str2.isEmpty()) {
            return PolicyManager.getPolicyHistoryUrl(policyManager.getMAppId(), str, l5.longValue(), str2);
        }
        PolicySdkLogUtils.Companion.d("getPolicyHistoryUrl", "-10001");
        return BuildConfig.FLAVOR;
    }

    public static PolicySdkResultBean getPolicyNewestPath(Context context, String str) {
        return PolicyManager.getPolicyNewestPathByCustom(context, str);
    }

    public static String getPolicySdkVersion() {
        return PolicySdkConstants.VERSION_NAME;
    }

    public static void getPrivateDeleteInfoListBySecure(Context context, final PolicySdkEncryptCallback policySdkEncryptCallback) {
        PolicyManager.getPrivateDeleteInfoList(context, PolicyManager.INSTANCE.getMAppId(), "phone", 1, new InterfaceC0772l<ArrayList<DeleteInfoBean>, v>() { // from class: com.stepos.policy.sdk.PolicySdk.5
            @Override // i4.InterfaceC0772l
            public v invoke(ArrayList<DeleteInfoBean> arrayList) {
                policySdkEncryptCallback.getResult(arrayList);
                return null;
            }
        });
    }

    public static /* synthetic */ PolicySdkResultBean h(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    public static /* synthetic */ v i(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        Log.d("PolicySdk", "getPolicy: =" + policySdkResultBean.getCode());
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    public static void initSDK(Context context, String str, String str2, String str3, HashMap<String, String> map) {
        PolicyManager.initSDK(context, str, str2, str3, map);
    }

    public static boolean isBlockNetworkBeforeAgree() {
        return PolicySdkNetworkGate.isBlockNetworkBeforeAgree();
    }

    public static boolean isLogEnabled() {
        return PolicySdkLogUtils.Companion.getEnabled();
    }

    public static boolean isReadAndroidIdEnabled() {
        return PolicyManager.getReadAndroidIdEnabled();
    }

    public static boolean isSupportSecureService31(Context context) {
        return PolicyManager.isSupportSecureService31(context);
    }

    public static boolean isSupportSecureServiceRSASign(Context context) {
        return PolicyManager.isSupportSecureService(context, 12000011);
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

    public static void recoveryOKHttpConnect() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        SocketHookUtil.recoveryPlatform();
    }

    public static void replaceOKHttpConnect() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        SocketHookUtil.replacePlatform();
    }

    public static void setBlockNetworkBeforeAgree(boolean z5) {
        PolicySdkNetworkGate.setBlockNetworkBeforeAgree(z5);
    }

    public static void setCloudPolicyUidCategoryMap(Map<String, String> map) {
        PolicyCloudPolicyIndex.putAll(map);
    }

    public static void setCompanyCode(String str) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        policyManager.setCompanyCode(str);
        policyManager.setBrand(str);
    }

    public static void setInitSDKByDeviceProtectedStorageContext(Boolean bool) {
        PolicyManager.INSTANCE.setInitSDKByDeviceProtectedStorageContext(bool.booleanValue());
    }

    public static void setLogEnabled(boolean z5) {
        PolicySdkLogUtils.Companion.setEnabled(z5);
    }

    public static void setPolicyAssetsCSSFileName(String str) {
        PolicyManager.INSTANCE.setCustomPolicyCSSFileName(str);
    }

    public static void setReadAndroidIdEnabled(boolean z5) {
        PolicyManager.setReadAndroidIdEnabled(z5);
    }

    public static stepos.support.v7.app.c showBasicDialog(Context context, String str, CharSequence charSequence, String str2, String str3, r.h hVar) {
        PolicyManager.INSTANCE.saveAgreeStatus(context, 0);
        return PolicyManager.showDialogByCustomView(context, str, charSequence, str2, str3, hVar);
    }

    public static stepos.support.v7.app.c showBasicDialogRecord(Context context, String str, CharSequence charSequence, String str2, String str3, String[] strArr, String str4, r.h hVar) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("showReGrantTwoPolicyDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        policyManager.saveAgreeStatus(context, 0);
        return PolicyManager.showDialogByCustomViewAndUploadRecord(context, str, charSequence, str2, str3, mAppId, mAppSecret, mAppVersionName, strArr, str4, "1", hVar);
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

    public static stepos.support.v7.app.c showCustomPolicyDialog(Context context, Boolean bool, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        if (strArr != null) {
            strArr = PolicySdkToolsUtils.Companion.getCustomPermissionKey(context, strArr);
        }
        String[] strArr3 = strArr;
        PolicyManager.INSTANCE.saveAgreeStatus(context, 0);
        return PolicyManager.showCustomPolicyDialog(context, bool.booleanValue(), strArr3, strArr2, str, charSequence, charSequence2, onPermissionClickListener);
    }

    public static stepos.support.v7.app.c showCustomPolicyDialogRecord(Context context, Boolean bool, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, String[] strArr3, String str2, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("showCustomPolicyDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数");
            return null;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        String[] customPermissionKey = strArr != null ? PolicySdkToolsUtils.Companion.getCustomPermissionKey(context, strArr) : strArr;
        policyManager.saveAgreeStatus(context, 0);
        return PolicyManager.showCustomPolicyDialogAndUploadRecord(context, bool.booleanValue(), customPermissionKey, strArr2, str, charSequence, charSequence2, mAppId, mAppSecret, mAppVersionName, strArr3, str2, onPermissionClickListener);
    }

    public static stepos.support.v7.app.c showCustomPolicyThreeButtonDialogRecord(Context context, Boolean bool, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, String[] strArr3, String str2, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener, r.h hVar) {
        String[] customPermissionKey = strArr;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
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
        return PolicyManager.showCustomPolicyThreeButtonDialogAndUploadRecord(context, bool.booleanValue(), customPermissionKey, strArr2, str, charSequence, charSequence2, mAppId, mAppSecret, mAppVersionName, strArr3, str2, onPermissionClickListener, hVar);
    }

    public static stepos.support.v7.app.r showDialogByCustomThemeViewBuilder(Context context, int i5, String str, CharSequence charSequence, String str2, String str3, r.h hVar) {
        return PolicyManager.showDialogByCustomThemeViewBuilder(context, i5, str, charSequence, str2, str3, hVar);
    }

    public static stepos.support.v7.app.r showDialogByCustomViewBuilder(Context context, String str, CharSequence charSequence, String str2, String str3, r.h hVar) {
        return PolicyManager.showDialogByCustomViewBuilder(context, str, charSequence, str2, str3, "3", hVar);
    }

    public static stepos.support.v7.app.c showNewestDialog(Context context, String str, String str2, String[] strArr, boolean z5, CharSequence charSequence, String str3, String str4, r.h hVar) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
            return PolicyManager.showNewestDialogAndUploadRecord(context, str2, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str, z5, charSequence, str3, str4, hVar);
        }
        PolicySdkLogUtils.Companion.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
        return null;
    }

    public static void showPermissionActivity(Context context, Intent intent) {
        PolicyPermissionDesActivity.Companion.startActivity(context, intent);
    }

    public static stepos.support.v7.app.c showReGrantDialog(Context context, boolean z5, String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, r.h hVar) {
        if (!z5) {
            return PolicyManager.showReGrantDialog(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, hVar);
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppVersionName().isEmpty() || str4.isEmpty()) {
            PolicySdkLogUtils.Companion.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        return PolicyManager.showReGrantDialogAndUploadRecord(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), new String[]{str4}, str, hVar);
    }

    public static stepos.support.v7.app.c showReGrantTwoPolicyDialog(Context context, boolean z5, String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, String str5, String str6, r.h hVar) {
        if (!z5) {
            return PolicyManager.showReGrantTwoPolicyDialog(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, str5, str6, hVar);
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppVersionName().isEmpty() || str6.isEmpty() || str4.isEmpty()) {
            PolicySdkLogUtils.Companion.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        return PolicyManager.showReGrantTwoPolicyDialogAndUploadRecord(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, str5, str6, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), new String[]{str6, str4}, str, hVar);
    }

    public static stepos.support.v7.app.c showWithdrawalCleanCustomDialog(Context context, String str, CharSequence charSequence, String str2, String str3, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        getCommonDeleteInfoListBySecure(context);
        return PolicyManager.showWithdrawalAndCleanServiceDataDialog(context, str, charSequence, str2, str3, str4, onPermissionClickListener);
    }

    public static stepos.support.v7.app.c showWithdrawalCleanCustomDialogByAccount(Context context, boolean z5, String str, CharSequence charSequence, String str2, String str3, String str4, String str5, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        getCommonDeleteInfoListBySecure(context);
        return PolicyManager.showWithdrawalAndCleanServiceDataDialogByAccount(context, z5, str, charSequence, str2, str3, str4, str5, onPermissionClickListener);
    }

    public static stepos.support.v7.app.c showWithdrawalCleanDialog(Context context, CharSequence charSequence, String str, final PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        return showWithdrawalCleanCustomDialog(context, context.getString(s.f15822D), charSequence, context.getString(s.f15848z), context.getString(s.f15847y), str, new PolicyPermissionDialogBuilder.OnPermissionClickListener() { // from class: com.stepos.policy.sdk.PolicySdk.3
            @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
            public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
                onPermissionClickListener.onPermissionClick(dialogInterface, z6, z5 ? "1" : "0");
            }
        });
    }

    public static stepos.support.v7.app.c showWithdrawalCleanDialogByAccountVerify(Context context, boolean z5, CharSequence charSequence, String str, String str2, final PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        String string = context.getString(s.f15822D);
        String string2 = context.getString(s.f15847y);
        String string3 = context.getString(s.f15848z);
        getCommonDeleteInfoListBySecure(context);
        return PolicyManager.showWithdrawalAndCleanServiceDataDialogByAccount(context, z5, string, charSequence, string3, string2, str, str2, new PolicyPermissionDialogBuilder.OnPermissionClickListener() { // from class: com.stepos.policy.sdk.PolicySdk.4
            @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
            public void onPermissionClick(DialogInterface dialogInterface, boolean z6, boolean z7, boolean z8) {
                onPermissionClickListener.onPermissionClick(dialogInterface, z6, PolicySdkToolsUtils.Companion.getVerifyType(z7, z8));
            }
        });
    }

    public static stepos.support.v7.app.c showWithdrawalDialog(Context context, String str, CharSequence charSequence, String str2, String str3, r.h hVar) throws Resources.NotFoundException {
        stepos.support.v7.app.c cVarE = showDialogByCustomViewBuilder(context, str, charSequence, str2, str3, hVar).j(true).e();
        PolicyDialogScrollHelper.attach(cVarE);
        return cVarE;
    }

    public static stepos.support.v7.app.c showWithdrawalDialogRecord(Context context, String str, CharSequence charSequence, String str2, String str3, String[] strArr, String str4, r.h hVar) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("showReGrantTwoPolicyDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        stepos.support.v7.app.c cVarE = PolicyManager.showDialogUploadRecordBuilder(context, str, charSequence, str2, str3, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str4, "3", hVar).j(true).e();
        PolicyDialogScrollHelper.attach(cVarE);
        return cVarE;
    }

    public static void uploadPolicyOperateRecord(Context context, String[] strArr, String str, String str2, final PolicySdkCallback policySdkCallback) {
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.NOT_NETWORK);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
            PolicyManager.uploadPolicyOperateRecord(policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), PolicyManager.createRecordRequest(context, strArr, str, str2), new InterfaceC0772l() { // from class: com.stepos.policy.sdk.j
                @Override // i4.InterfaceC0772l
                public final Object invoke(Object obj) {
                    return PolicySdk.b(policySdkCallback, (PolicySdkResultBean) obj);
                }
            });
            return;
        }
        PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
        policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
        policySdkCallback.getResult(policySdkResultBean2);
    }

    public static void uploadRecordWithoutSecureService(Context context, String str, String str2, String str3, ArrayList<DeleteInfoBean> arrayList, String[] strArr, String str4, final PolicySdkCallback policySdkCallback) {
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.NOT_NETWORK);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
            PolicyManager.uploadRecordWithoutSecureService(context, str, str2, str3, arrayList, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str4, "3", new InterfaceC0772l() { // from class: com.stepos.policy.sdk.g
                @Override // i4.InterfaceC0772l
                public final Object invoke(Object obj) {
                    return PolicySdk.c(policySdkCallback, (PolicySdkResultBean) obj);
                }
            });
            return;
        }
        PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
        policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
        policySdkCallback.getResult(policySdkResultBean2);
    }

    public static void withdrawalCleanCustomUploadRecord(Context context, String str, ArrayList<DeleteInfoBean> arrayList, String[] strArr, String str2, String str3, final PolicySdkCallback policySdkCallback) {
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.NOT_NETWORK);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
            PolicyManager.uploadRecordToCleanServiceData(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, str, arrayList, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str2, str3, new InterfaceC0772l() { // from class: com.stepos.policy.sdk.e
                @Override // i4.InterfaceC0772l
                public final Object invoke(Object obj) {
                    return PolicySdk.g(policySdkCallback, (PolicySdkResultBean) obj);
                }
            });
            return;
        }
        PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
        policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
        policySdkCallback.getResult(policySdkResultBean2);
    }

    public static void withdrawalCleanUploadRecord(Context context, String str, String str2, PolicySdkCallback policySdkCallback) {
        withdrawalCleanCustomUploadRecord(context, str, null, new String[]{"pp"}, str2, "3", policySdkCallback);
    }

    public static void withdrawalCleanUploadRecordByAccountValidateCode(Context context, String str, String str2, String str3, ArrayList<DeleteInfoBean> arrayList, String[] strArr, String str4, final PolicySdkCallback policySdkCallback) {
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.NOT_NETWORK);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !policyManager.getMAppVersionName().isEmpty()) {
            PolicyManager.uploadRecordToCleanServiceData(context, str, str2, str3, arrayList, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str4, "3", new InterfaceC0772l() { // from class: com.stepos.policy.sdk.i
                @Override // i4.InterfaceC0772l
                public final Object invoke(Object obj) {
                    return PolicySdk.e(policySdkCallback, (PolicySdkResultBean) obj);
                }
            });
            return;
        }
        PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
        policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
        policySdkCallback.getResult(policySdkResultBean2);
    }

    public static void getOnlinePolicyUrl(String str, PolicySdkCallback policySdkCallback) {
        getOnlinePolicyUrl(PolicySdkToolsUtils.Companion.getLanguage(), str, policySdkCallback);
    }

    public static void initSDK(Context context, String str, String str2, HashMap<String, String> map) {
        initSDK(context, str, BuildConfig.FLAVOR, str2, map);
    }

    public static void getOnlinePolicyWebViewSetCustomFun(Context context, String str, String str2, Boolean bool, InterfaceC0772l<Context, v> interfaceC0772l) {
        getOnlinePolicyWebViewSetCustomFun(context, PolicySdkToolsUtils.Companion.getLanguage(), str, str2, bool, interfaceC0772l);
    }

    public static void openOnlinePolicyByBrowserWithoutLocal(Context context, String str, PolicySdkCallback policySdkCallback) {
        openOnlinePolicyByBrowserWithoutLocal(context, PolicySdkToolsUtils.Companion.getLanguage(), str, policySdkCallback);
    }

    public static void getOnlinePolicyMethod(Context context, String str, String str2, Boolean bool, PolicySdkCallback policySdkCallback) {
        getOnlinePolicyMethod(context, PolicySdkToolsUtils.Companion.getLanguage(), str, str2, bool, policySdkCallback);
    }
}
