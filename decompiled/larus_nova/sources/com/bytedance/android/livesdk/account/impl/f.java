package com.bytedance.android.livesdk.account.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostDouyinOpenSDKAuth;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;
import com.bytedance.android.livesdk.account.api.AuthScope;
import com.bytedance.android.livesdk.user.i0;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements od1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public od1.a.InterfaceC7035a f103013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f103014b;

    public static final class a {
    }

    public static final class b implements ILoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f103015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f103016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AuthScope f103017c;

        @Override // com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback
        public final void onCancel(Throwable r100) {
            this.f103015a.f103013a = null;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback
        public final void onSuccess(IBaseUser r100) {
            f r101 = this.f103015a;
            AuthScope r102 = this.f103017c;
            Activity r103 = this.f103016b;
            r101.getClass();
            IHostDouyinOpenSDKAuth r104 = TTLiveSDK.hostService().douyinOpenSDKAuth();
            if (r104 == null) goto L6;
            r104.getAccessTokenAsync(new h(r101, r103, r104, r102));
            return;
        }

        public b(f r100, Activity r101, AuthScope r102) {
            this.f103015a = r100;
            this.f103016b = r101;
            this.f103017c = r102;
        }
    }

    public static final class c implements IHostDouyinOpenSDKAuth.Callback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f103018a;

        public c(f r100) {
            this.f103018a = r100;
        }

        @Override // com.bytedance.android.livehostapi.platform.IHostDouyinOpenSDKAuth.Callback
        public final void onFailed(Throwable r100) {
            od1.a.InterfaceC7035a r101 = this.f103018a.f103013a;
        }

        @Override // com.bytedance.android.livehostapi.platform.IHostDouyinOpenSDKAuth.Callback
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            od1.a.InterfaceC7035a r101 = this.f103018a.f103013a;
            if (r101 == null) goto L6;
            ((i0) r101).a();
            return;
        }
    }

    static {
    }

    @Override // od1.a
    public final boolean blockReport() {
        return false;
    }

    @Override // od1.a
    public final boolean enableRevokeAuthorizationInRoom() {
        return false;
    }

    @Override // od1.a
    public final String getOpenId() {
        return null;
    }

    @Override // od1.a
    public final boolean interceptEnterRoom() {
        return false;
    }

    @Override // od1.a
    public final void revokeAuthorization() {
    }

    public f() {
        this.f103014b = new c(this);
    }

    @Override // od1.a
    public final String getAccessToken() {
        IHostDouyinOpenSDKAuth r100 = TTLiveSDK.hostService().douyinOpenSDKAuth();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAccessToken();
    }

    @Override // od1.a
    public final boolean hostIsLogin() {
        IHostDouyinOpenSDKAuth r100 = TTLiveSDK.hostService().douyinOpenSDKAuth();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isLogin() != true) goto L7;
        return true;
    }

    @Override // od1.a
    public final boolean shouldTreatAsLoggedIn() {
        String r100 = getAccessToken();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L16;
        IHostDouyinOpenSDKAuth r102 = TTLiveSDK.hostService().douyinOpenSDKAuth();
        if (r102 != null) goto L13;
        return false;
    L13:
        if (r102.isLogin() != true) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // od1.a
    public final od1.d report() {
        return AuthReporter.f103002b;
    }

    public static void b(IHostDouyinOpenSDKAuth r100, Activity r101, AuthScope r102) {
        com.bytedance.sdk.open.douyin.a.init(new DouYinOpenConfig(r100.getClientKey()));
        DouYinOpenApi r103 = com.bytedance.sdk.open.douyin.a.create(r101);
        Authorization.Request r104 = new Authorization.Request();
        r104.state = "ww";
        if (r102 != AuthScope.BROADCAST) goto L10;
        r104.scope = "user_info,create_room";
        JSONObject r105 = new JSONObject();
        Bundle r106 = new Bundle();
        r105.put("content", "确认授权即表示同意用户授权协议以及抖音主播入驻协议");     // Catch: JSONException -> L7
        JSONArray r107 = new JSONArray();     // Catch: JSONException -> L7
        r105.put("parts", r107);     // Catch: JSONException -> L7
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L7
        r108.put("start", 9);     // Catch: JSONException -> L7
        r108.put("end", 15);     // Catch: JSONException -> L7
        r108.put("url", "https://lf1-webcastcdn-tos.douyinstatic.com/obj/ies-fe-bee/bee_prod/biz_167/bee_prod_167_bee_publish_915.html");     // Catch: JSONException -> L7
        r107.put(r108);     // Catch: JSONException -> L7
        JSONObject r109 = new JSONObject();     // Catch: JSONException -> L7
        r109.put("start", 17);     // Catch: JSONException -> L7
        r109.put("end", 25);     // Catch: JSONException -> L7
        r109.put("url", "https://webcast.amemv.com/falcon/webcast_douyin/page/anchor_agreement/index.html");     // Catch: JSONException -> L7
        r107.put(r109);     // Catch: JSONException -> L7
        r106.putString("privacy_agreements", r105.toString());     // Catch: JSONException -> L7
    L9:
        r104.extras = r106;
    L7:
        e = move-exception;
        e.printStackTrace();
    L10:
        r104.callerLocalEntry = OpenSDKEntryActivity.class.getName();
        r103.authorize(r104);
    }

    @Override // od1.a
    public final void requestUserLogIn(Context r100, com.bytedance.android.livesdk.user.l r101, Function0<Unit> r102, Function1<? super Throwable, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, "onFailed");
        g r104 = new g(r102, r103);
        IHostDouyinOpenSDKAuth r105 = TTLiveSDK.hostService().douyinOpenSDKAuth();
        if (r105 == null) goto L6;
        r105.login(r100, r104);
        return;
    }

    @Override // od1.a
    public final void requestRefresh(AuthScope r100, od1.a.InterfaceC7035a r101, Activity r102, boolean r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r104, "extra");
        this.f103013a = r101;
        if (r102 == null) goto L19;
        if (r103 == false) goto L8;
        IHostDouyinOpenSDKAuth r105 = TTLiveSDK.hostService().douyinOpenSDKAuth();
        if (r105 == null) goto L20;
        b(r105, r102, r100);
        return;
    L20:
        return;
    L8:
        IHostDouyinOpenSDKAuth r106 = TTLiveSDK.hostService().douyinOpenSDKAuth();
        if (r106 != null) goto L11;
    L15:
        IHostDouyinOpenSDKAuth r107 = TTLiveSDK.hostService().douyinOpenSDKAuth();
        if (r107 == null) goto L24;
        r107.getAccessTokenAsync(new h(this, r102, r107, r100));
        return;
    L24:
        return;
    L11:
        if (r106.isLogin() == true) goto L15;
        IHostDouyinOpenSDKAuth r108 = TTLiveSDK.hostService().douyinOpenSDKAuth();
        if (r108 == null) goto L22;
        r108.login(r102, new b(this, r102, r100));
        return;
    L22:
        return;
    }
}
