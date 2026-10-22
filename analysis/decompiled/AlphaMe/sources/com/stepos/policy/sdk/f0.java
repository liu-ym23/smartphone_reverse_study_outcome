package com.stepos.policy.sdk;

import android.content.Context;
import android.net.Uri;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;

/* loaded from: classes.dex */
public final class f0 implements PolicySdk.PolicySdkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f12166a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PolicySdk.PolicySdkCallback f12167b;

    public f0(Context context, PolicySdk.PolicySdkCallback policySdkCallback) {
        this.f12166a = context;
        this.f12167b = policySdkCallback;
    }

    @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
    public final void getResult(PolicySdkResultBean policySdkResultBean) {
        if (policySdkResultBean.getCode() == 0) {
            PolicySdkLogUtils.INSTANCE.d("getOnlinePolicyMethod", policySdkResultBean.getPolicyUrl());
            PolicySdkToolsUtils.INSTANCE.startBrowser(this.f12166a, Uri.parse(policySdkResultBean.getPolicyUrl()));
        }
        PolicySdk.PolicySdkCallback policySdkCallback = this.f12167b;
        if (policySdkCallback != null) {
            policySdkCallback.getResult(policySdkResultBean);
        }
    }
}
