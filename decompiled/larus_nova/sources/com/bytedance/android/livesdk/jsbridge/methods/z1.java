package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "login")
public final class z1 extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f142258a;

    public static class a {

        @SerializedName("action_type")
        String actionType;

        @SerializedName("enter_from")
        String enterFrom;

        @SerializedName("from_type")
        int fromType;

        @SerializedName("image_url")
        String imageUrl;

        @SerializedName("loginDesc")
        String loginDesc;

        @SerializedName("msg")
        String msg;

        @SerializedName("source")
        String source;

        @SerializedName("themeId")
        String themeId;

        @SerializedName("through_aweme")
        boolean useSaaSAuthInfo;

        @SerializedName("user_agree_auth")
        boolean userAgreeAuth;

        @SerializedName("version")
        int version;

        public a() {
            this.useSaaSAuthInfo = true;
        }
    }

    public static final class b {

        @SerializedName("status")
        int status;

        public b() {
        }

        public b(int r100) {
            this.status = r100;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f142258a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public z1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        Activity r103 = ContextUtil.contextToActivity(r101.getContext());
        boolean r104 = true;
        if (r102.version != 1) goto L5;
        boolean r105 = true;
    L6:
        if (r103 != null) goto L9;
        finishWithFailure();
    L9:
        if (r102.useSaaSAuthInfo == false) goto L29;
        if (((IUserService) jc1.k.f(IUserService.class)).user().isLogin() == false) goto L15;
        if (r105 == false) goto L14;
        finishWithResult(new b(0));
        return;
    L14:
        finishWithSuccess();
        return;
    L15:
        Bundle r106 = new Bundle();
        if (TextUtils.isEmpty(r102.themeId) == true) goto L19;
        r106.putString("themeId", r102.themeId);
    L19:
        if (TextUtils.isEmpty(r102.loginDesc) == true) goto L21;
        r106.putString("loginDesc", r102.loginDesc);
    L21:
        String r107 = r102.source;
        if (r107 != null) goto L24;
        r107 = "unknown";
    L24:
        com.bytedance.android.livesdk.user.f r108 = ((IUserService) jc1.k.f(IUserService.class)).user();
        Context r109 = r101.getContext();
        com.bytedance.android.livesdk.user.l.a r110 = new com.bytedance.android.livesdk.user.l.a();
        String r111 = r102.msg;
        if (r111 != null) goto L27;
        r111 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_login_dialog_message);
    L27:
        r110.f158685a = r111;
        r110.f158686b = r102.imageUrl;
        r110.f158687c = r102.fromType;
        r110.f158688d = r107;
        r110.f158689e = r102.enterFrom;
        r110.f158691g = r102.actionType;
        r110.f158693i = r102.userAgreeAuth;
        r110.f158692h = r106;
        r108.login(r109, new com.bytedance.android.livesdk.user.l(r110)).subscribe(new x1(this, r105));
        return;
    L29:
        if (r102.version == 1) goto L33;
        r104 = false;
    L33:
        if (TTLiveSDK.hostService().user().hostUserId() == 0) goto L37;
        if (r104 == false) goto L36;
        finishWithResult(new b(0));
        return;
    L36:
        finishWithSuccess();
        return;
    L37:
        Context r112 = r101.getContext();
        if ((r112 instanceof FragmentActivity) == false) goto L41;
        FragmentActivity r113 = (FragmentActivity) r112;
    L45:
        TTLiveSDK.hostService().user().hostUserLogin(r113, new y1(this, r104));
        return;
    L41:
        if ((r112 instanceof ContextWrapper) == false) goto L48;
        ContextWrapper r114 = (ContextWrapper) r112;
        if ((r114.getBaseContext() instanceof FragmentActivity) == false) goto L48;
        r113 = (FragmentActivity) r114.getBaseContext();
    L48:
        throw new IllegalArgumentException("Argument \"context\" cannot be transformed to FragmentActivity in UserCenter.login() method. ");
    L5:
        r105 = false;
        goto L6
    }
}
