package com.bytedance.android.livesdk.account.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.login.ILogin;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostSessionAuth;
import com.bytedance.android.livehostapi.platform.TokenInfo;
import com.bytedance.android.livehostapi.platform.TokenRefreshCallback;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;
import com.bytedance.android.livesdk.account.api.AuthScope;
import com.bytedance.android.livesdk.user.i0;
import com.bytedance.android.livesdk.utils.v5;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements od1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f103025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f103026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f103027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f103028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f103029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f103030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f103031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IHostSessionAuth f103032h;

    public static final class a extends TokenInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f103033a;

        @Override // com.bytedance.android.livehostapi.platform.TokenInfo
        public final String getOpenId() {
            j r100 = this.f103033a;
            if (Intrinsics.areEqual(r100.f103029e, r100.f103032h.getAccountId()) == true) goto L5;
            return null;
        L5:
            return this.f103033a.f103028d;
        }

        public a(j r100) {
            this.f103033a = r100;
            super("session_token", null, "", Long.MAX_VALUE);
        }
    }

    public static final class b implements ILoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f103034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TokenRefreshCallback f103035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Activity f103036c;

        @Override // com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback
        public final void onCancel(Throwable r100) {
            TokenRefreshCallback r101 = this.f103035b;
            if (r101 == null) goto L6;
            r101.onFailed(r100);
            return;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback
        public final void onSuccess(IBaseUser r100) {
            this.f103034a.c(this.f103035b, this.f103036c);
        }

        public b(j r100, TokenRefreshCallback r101, Activity r102) {
            this.f103034a = r100;
            this.f103035b = r101;
            this.f103036c = r102;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f103037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f103038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TokenRefreshCallback f103039c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Activity f103040d;

        public c(j r100, String r101, TokenRefreshCallback r102, Activity r103) {
            this.f103037a = r100;
            this.f103038b = r101;
            this.f103039c = r102;
            this.f103040d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BaseResponse r101 = (BaseResponse) r100;
            String r102 = this.f103037a.f103025a;
            StringBuilder r103 = new StringBuilder("requestExchangeOpenId suc code:");
            r103.append(r101.statusCode);
            r103.append(" openId:");
            SessionAuthApi.a r104 = (SessionAuthApi.a) r101.data;
            if (r104 == null) goto L5;
            String r105 = r104.a();
        L6:
            r103.append(r105);
            ALogger.i(r102, r103.toString());
            if (r101.statusCode != 0) goto L15;
            T r106 = r101.data;
            if (r106 == null) goto L15;
            if (TextUtils.isEmpty(((SessionAuthApi.a) r106).a()) == true) goto L15;
            this.f103037a.d(((SessionAuthApi.a) r101.data).a(), this.f103038b);
            TokenRefreshCallback r107 = this.f103039c;
            if (r107 == null) goto L26;
            r107.onSuccess(this.f103037a.f103031g);
            return;
        L26:
            return;
        L15:
            int r108 = r101.statusCode;
            j r109 = this.f103037a;
            if (r108 != r109.f103030f) goto L28;
            ALogger.i(r109.f103025a, "requestExchangeOpenId ERROR_INVALID_SESSION");
            if (Intrinsics.areEqual(this.f103038b, this.f103037a.f103032h.getAccountId()) == true) goto L20;
        L22:
            TokenRefreshCallback r110 = this.f103039c;
            if (r110 == null) goto L30;
            r110.onFailed(new Exception("uid2OpenId"));
            return;
        L30:
            return;
        L20:
            if (this.f103040d == null) goto L22;
            TTLiveSDK.hostService().user().hostUserLogin(this.f103040d, new k(this));
            return;
        L28:
            return;
        L5:
            r105 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f103041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TokenRefreshCallback f103042b;

        public d(j r100, TokenRefreshCallback r101) {
            this.f103041a = r100;
            this.f103042b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ALogger.i(this.f103041a.f103025a, "requestExchangeOpenId failed:" + r101);
            TokenRefreshCallback r102 = this.f103042b;
            if (r102 == null) goto L6;
            r102.onFailed(r101);
            return;
        }
    }

    public static final class e implements TokenRefreshCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ od1.a.InterfaceC7035a f103043a;

        @Override // com.bytedance.android.livehostapi.platform.TokenRefreshCallback
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        }

        public e(od1.a.InterfaceC7035a r100) {
            this.f103043a = r100;
        }

        @Override // com.bytedance.android.livehostapi.platform.TokenRefreshCallback
        public final void onSuccess(TokenInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "tokenInfo");
            od1.a.InterfaceC7035a r101 = this.f103043a;
            if (r101 == null) goto L6;
            String r102 = r100.accessToken;
            ((i0) r101).a();
            return;
        }
    }

    public static final class f implements TokenRefreshCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f103044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f103045b;

        @Override // com.bytedance.android.livehostapi.platform.TokenRefreshCallback
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            this.f103045b.invoke(r100);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.bytedance.android.livehostapi.platform.TokenRefreshCallback
        public final void onSuccess(TokenInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "tokenInfo");
            this.f103044a.invoke();
        }

        public f(Function0 r100, Function1 r101) {
            this.f103044a = r100;
            this.f103045b = r101;
        }
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
    public final String getAccessToken() {
        return null;
    }

    @Override // od1.a
    public final void revokeAuthorization() {
    }

    @Override // od1.a
    public final String getOpenId() {
        a r100 = this.f103031g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getOpenId();
    }

    @Override // od1.a
    public final boolean hostIsLogin() {
        return this.f103032h.isLogin();
    }

    @Override // od1.a
    public final boolean interceptEnterRoom() {
        return !this.f103032h.isLogin();
    }

    @Override // od1.a
    public final boolean shouldTreatAsLoggedIn() {
        return this.f103032h.isLogin();
    }

    @Override // od1.c
    public final TokenInfo getTokenInfo() {
        return this.f103031g;
    }

    @Override // od1.a
    public final od1.d report() {
        return AuthReporter.f103002b;
    }

    public j(IHostSessionAuth r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f103032h = r100;
        this.f103025a = "AuthLogger";
        this.f103026b = "key_session_open_id";
        this.f103027c = "key_account_id";
        this.f103028d = v5.b().getString("key_session_open_id", "");
        this.f103029e = v5.b().getString("key_account_id", "");
        this.f103030f = 4002177;
        this.f103031g = new a(this);
        if (r100.isLogin() == true) goto L5;
    L7:
        String r101 = getOpenId();
        if (r101 == null) goto L13;
        ILogin r102 = (ILogin) BDLiveSdk.getImp(ILogin.class);
        if (r102 == null) goto L14;
        r102.updateCurrentAuthUserOpenId(r101);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (TextUtils.isEmpty(getOpenId()) == false) goto L7;
        ALogger.i("AuthLogger", "refreshOpenId when init");
        c(null, null);
        goto L7
    }

    public final void b(TokenRefreshCallback r100, Activity r101) {
        ALogger.i(this.f103025a, "refreshOpenId curOpenId: " + getOpenId() + " isHostLogin:" + this.f103032h.isLogin());
        if (this.f103032h.isLogin() == false) goto L5;
        c(r100, r101);
        return;
    L5:
        if (r101 == null) goto L7;
        TTLiveSDK.hostService().user().hostUserLogin(r101, new b(this, r100, r101));
        return;
    L7:
        r100.onFailed(new Exception("Not login and activity null"));
    }

    public final void c(TokenRefreshCallback r100, Activity r101) {
        if (TextUtils.isEmpty(getOpenId()) == true) goto L5;
        d(null, this.f103032h.getAccountId());
    L5:
        String r102 = this.f103032h.getAccountId();
        ((SessionAuthApi) com.bytedance.android.live.network.c.b().e(SessionAuthApi.class)).uid2OpenId().subscribe(new c(this, r102, r100, r101), new d(this, r100));
    }

    public final void d(String r100, String r101) {
        v5.a().putString(this.f103026b, r100).putString(this.f103027c, r101).apply();
        this.f103028d = r100;
        this.f103029e = r101;
        ILogin r102 = (ILogin) BDLiveSdk.getImp(ILogin.class);
        if (r102 == null) goto L6;
        r102.updateCurrentAuthUserOpenId(r100);
        return;
    }

    @Override // od1.a
    public final void requestUserLogIn(Context r100, com.bytedance.android.livesdk.user.l r101, Function0<Unit> r102, Function1<? super Throwable, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, "onFailed");
        if ((r100 instanceof Activity) == true) goto L6;
        ALogger.e(this.f103025a, "requestUserLogIn context not activity, return");
        return;
    L6:
        ALogger.e(this.f103025a, "requestUserLogIn -> refreshOpenId");
        b(new f(r102, r103), (Activity) r100);
    }

    @Override // od1.a
    public final void requestRefresh(AuthScope r100, od1.a.InterfaceC7035a r101, Activity r102, boolean r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r104, "extra");
        ALogger.e(this.f103025a, "requestRefresh -> refreshOpenId");
        b(new e(r101), r102);
    }
}
