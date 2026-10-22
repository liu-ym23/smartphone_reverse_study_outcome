package com.stepos.policy.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.activity.PolicyWebViewActivity;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.config.PolicySdkErrorCode;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;

/* loaded from: classes.dex */
public final class d0 implements PolicySdk.PolicySdkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Boolean f12140a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f12141b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12142c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12143d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Bundle f12144e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f12145f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ PolicySdk.PolicySdkCallback f12146g;

    public d0(Boolean bool, Context context, String str, String str2, Bundle bundle, String str3, PolicySdk.PolicySdkCallback policySdkCallback) {
        this.f12140a = bool;
        this.f12141b = context;
        this.f12142c = str;
        this.f12143d = str2;
        this.f12144e = bundle;
        this.f12145f = str3;
        this.f12146g = policySdkCallback;
    }

    @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
    public final void getResult(PolicySdkResultBean policySdkResultBean) {
        int code = policySdkResultBean.getCode();
        String str = this.f12142c;
        Boolean bool = this.f12140a;
        Context context = this.f12141b;
        if (code == 0) {
            PolicySdkLogUtils.INSTANCE.d("getOnlinePolicyMethod", policySdkResultBean.getPolicyUrl());
            if (bool.booleanValue()) {
                PolicyWebViewActivity.INSTANCE.startWebViewActivity(context, policySdkResultBean.getPolicyUrl(), str);
            } else {
                PolicySdkToolsUtils.INSTANCE.startBrowser(context, Uri.parse(policySdkResultBean.getPolicyUrl()));
            }
        } else {
            PolicySdkLogUtils.INSTANCE.d("getOnlinePolicyMethod", "getlocal getPolicyNewestPath");
            String str2 = this.f12143d;
            PolicySdkResultBean policyNewestPath = PolicySdk.getPolicyNewestPath(context, str2);
            if (policyNewestPath.getCode() == 0) {
                PolicySdk.openPolicyByMethod(context, bool, str, str2);
            } else if (policyNewestPath.getCode() == -10004 && bool.booleanValue()) {
                String str3 = this.f12145f;
                Bundle bundle = this.f12144e;
                bundle.putString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE, str3);
                bundle.putString(PolicySdkConstants.BUNDLE_KEY_CATEGORY, str2);
                bundle.putLong(PolicySdkConstants.BUNDLE_KEY_VERSION, 0L);
                bundle.putInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY, PolicySdkErrorCode.NETWORK_ERROR);
                PolicyWebViewActivity.INSTANCE.startWebViewActivity(context, PolicySdkConstants.ONLINE_POLICY_WEB_VIEW, str);
            }
            policySdkResultBean = policyNewestPath;
        }
        PolicySdk.PolicySdkCallback policySdkCallback = this.f12146g;
        if (policySdkCallback != null) {
            policySdkCallback.getResult(policySdkResultBean);
        }
    }
}
