package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class w extends BaseOpenMethod<JSONObject> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f60574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f60575i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f60576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OpenBaseAuthService f60577b;

        public b(w r100, OpenBaseAuthService r101) {
            this.f60576a = r100;
            this.f60577b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            int r102 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("GetUserInfoV2Method", new Object[]{"on request success, user info: " + ((com.bytedance.android.live.broadcastgame.opengame.network.d0) r101.data).a()});
            String r103 = ((com.bytedance.android.live.broadcastgame.opengame.network.d0) r101.data).a().a();
            String r104 = ((com.bytedance.android.live.broadcastgame.opengame.network.d0) r101.data).a().b();
            ArrayList r105 = new ArrayList();
            r105.add("scope.userInfo");
            JSONObject r106 = new JSONObject().put("nickName", r104).put("avatarUrl", r103);
            OpenBaseAuthService r107 = this.f60577b;
            this.f60576a.getClass();
            r107.c(this.f60576a.f60574h, r105, r106, new x(this, r104, r103, r101));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f60578a;

        public c(w r100) {
            this.f60578a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            int r102 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.e("GetUserInfoV2Method", new Object[]{"on request fail, error: ", r101});
            this.f60578a.o(r101);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "getUserInfoV2";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("GetUserInfoV2Method", new Object[]{"on call, params: " + r100});
        OpenBaseAuthService r103 = (OpenBaseAuthService) this.f60306d.o(OpenBaseAuthService.class);
        Lazy r104 = LiveOpenGameClient.f60290d;
        j(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).getUserInfoV2(this.f60574h, this.f60575i).compose(new x10.d(this.f60306d, "/webcast/openapi/user/unencrypted_info/mine", null)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r103), new c(this)));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r100, CallContext r101) {
        call2(r100, r101);
    }

    public w(PluginContext r100, String r101, long r102, Queue<Long> r103) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        Intrinsics.checkNotNullParameter(r101, "appId");
        super(r100, r103);
        this.f60574h = r101;
        this.f60575i = r102;
    }
}
