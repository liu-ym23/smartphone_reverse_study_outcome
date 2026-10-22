package com.bytedance.android.livesdk.account.impl;

import am2.x;
import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostAccountAuth;
import com.bytedance.android.livehostapi.platform.IHostCoinState;
import com.bytedance.android.livehostapi.platform.depend.Callback;
import com.bytedance.android.livesdk.account.api.AuthScope;
import com.bytedance.android.livesdk.account.impl.util.LoginParamsExtensionsKt;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.i0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements od1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHostAccountAuth f103010a;

    public static final class a implements Callback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ od1.a.InterfaceC7035a f103011a;

        public a(od1.a.InterfaceC7035a r100) {
            this.f103011a = r100;
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public void call2(String r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            od1.a.InterfaceC7035a r101 = this.f103011a;
            if (r101 == null) goto L6;
            ((i0) r101).a();
            return;
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.Callback
        public /* bridge */ /* synthetic */ void call(String r100) {
            call2(r100);
        }
    }

    public static final class b implements ve1.a.InterfaceC7988a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f103012a;

        @Override // ve1.a.InterfaceC7988a
        public final void a() {
            this.f103012a.getClass();
            e.b("livesdk_aweme_play_authorization_popup_click", false);
        }

        @Override // ve1.a.InterfaceC7988a
        public final void onCancel() {
            this.f103012a.getClass();
            e.b("livesdk_aweme_play_authorization_popup_click", true);
        }

        public b(e r100) {
            this.f103012a = r100;
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
    public final boolean interceptEnterRoom() {
        return false;
    }

    @Override // od1.a
    public final void revokeAuthorization() {
    }

    @Override // od1.a
    public final String getAccessToken() {
        return this.f103010a.getDouyinToken();
    }

    @Override // od1.a
    public final String getOpenId() {
        return this.f103010a.getOpenId();
    }

    @Override // od1.a
    public final boolean hostIsLogin() {
        return this.f103010a.isLogin();
    }

    @Override // od1.a
    public final boolean shouldTreatAsLoggedIn() {
        return this.f103010a.hasDouyinInteractivePrivilege();
    }

    @Override // od1.a
    public final od1.d report() {
        return AuthReporter.f103002b;
    }

    public e(IHostAccountAuth r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f103010a = r100;
    }

    public static void b(String r100, boolean r101) {
        HashMap r102 = new HashMap();
        if (Intrinsics.areEqual("livesdk_aweme_play_authorization_popup_click", r100) == false) goto L8;
        if (r101 == false) goto L6;
        String r103 = "cancel";
    L7:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r103);
        goto L8
    L6:
        r103 = "confirm";
    L8:
        r102.put("action_type", "click");
        Room r104 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        if (r104 == null) goto L11;
        r102.put("anchor_id", r104.getOwnerUserIdString());
        r102.put("room_id", r104.getIdStr());
        r102.put("request_id", r104.getRequestId());
        r102.put("log_pb", r104.getLog_pb());
    L11:
        o r105 = u.l().c(x.class);
        if (r105 == null) goto L14;
        String r106 = r105.getMap().get("enter_from_merge");
        String r107 = r105.getMap().get("enter_method");
    L15:
        r102.put("enter_from_merge", r106);
        r102.put("enter_method", r107);
        u.l().sendLog(r100, r102, new Object[0]);
        return;
    L14:
        r106 = "";
        r107 = "";
        goto L15
    }

    @Override // od1.a
    public final void requestUserLogIn(Context r100, com.bytedance.android.livesdk.user.l r101, Function0<Unit> r102, Function1<? super Throwable, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r110, "onFailed");
        Boolean r103 = null;
        if (r101 == null) goto L5;
        String r104 = r101.f158679d;
    L6:
        com.bytedance.android.livesdk.account.impl.b r105 = new com.bytedance.android.livesdk.account.impl.b(r102, r110);
        if (r101 == null) goto L10;
        Map<String, String> r106 = LoginParamsExtensionsKt.a(r101);
        if (r106 == null) goto L10;
    L12:
        if (this.f103010a.hasBoundDouyin() == true) goto L15;
        this.f103010a.loginOrBindDouyin(r100, r105, r106);
        return;
    L15:
        if (Intrinsics.areEqual("guide", r104) == false) goto L17;
        this.f103010a.requestInteractivePrivilege(r105, r106);
        return;
    L17:
        b("livesdk_aweme_authorization_popup_show", false);
        b r107 = new b(this);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "callback");
        Intrinsics.checkNotNullParameter(r107, "listener");
        Intrinsics.checkNotNullParameter(r106, "extra");
        int r108 = ve1.a.f554322a;
        IHostCoinState r109 = TTLiveSDK.hostService().coinState();
        if (r109 == null) goto L21;
        r103 = Boolean.valueOf(r109.isEnableBindAccountAwardTask());
    L21:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L23;
        int r111 = R.string.ttlive_account_auth_content_with_coin;
    L24:
        lm3.d.a r112 = new lm3.d.a(r100);
        r112.f509870a = r100.getString(R.string.ttlive_account_auth_title);
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        String r114 = r100.getString(r111);
        Object[] r115 = new Object[1];
        String r116 = this.f103010a.getNickname();
        if (r116 != null) goto L27;
        r116 = "";
    L27:
        r115[0] = r116;
        r112.f509871b = String.format(r114, Arrays.copyOf(r115, 1));
        lm3.c r117 = new lm3.c();
        r117.f509864b = r100.getString(R.string.ttlive_account_auth_cancel);
        r117.f509865c = new c(r107);
        lm3.c r118 = new lm3.c();
        r118.f509864b = r100.getString(R.string.ttlive_account_auth_confirm);
        r118.f509865c = new d(this, r107, r105, r106);
        ArrayList r119 = new ArrayList(2);
        r119.add(r117);
        r119.add(r118);
        r112.f509874e = r119;
        r112.f509879j = false;
        r112.a();
        return;
    L23:
        r111 = R.string.ttlive_account_auth_content;
    L10:
        r106 = MapsKt.emptyMap();
        goto L12
    L5:
        r104 = null;
        goto L6
    }

    @Override // od1.a
    public final void requestRefresh(AuthScope r100, od1.a.InterfaceC7035a r101, Activity r102, boolean r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r104, "extra");
        this.f103010a.refreshDouyinToken(new a(r101));
    }
}
