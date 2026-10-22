package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class v extends BaseOpenMethod<JSONObject> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f60572h;

    public static final class a implements com.bytedance.bdp.live.livecontainer.sonicgame.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f60573a;

        @Override // com.bytedance.bdp.live.livecontainer.sonicgame.c
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter("onSettingClick", "status");
            Intrinsics.checkNotNullParameter(r100, "data");
        }

        @Override // com.bytedance.bdp.live.livecontainer.sonicgame.c
        public final void onFail(String r100) {
            Intrinsics.checkNotNullParameter(r100, "errMsg");
        }

        public a(v r100) {
            this.f60573a = r100;
        }

        @Override // com.bytedance.bdp.live.livecontainer.sonicgame.c
        public final void onSuccess(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            v r101 = this.f60573a;     // Catch: JSONException -> L5
            JSONObject r102 = new JSONObject();     // Catch: JSONException -> L5
            r102.put("authSetting", r100);     // Catch: JSONException -> L5
            Unit r103 = Unit.INSTANCE;     // Catch: JSONException -> L5
            r101.r(r102);     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            this.f60573a.o(e);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "getSetting";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((OpenBaseAuthService) this.f60306d.o(OpenBaseAuthService.class)).a(this.f60572h, new a(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r100, CallContext r101) {
        call2(r100, r101);
    }

    public v(PluginContext r100, String r101, Queue<Long> r102) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        Intrinsics.checkNotNullParameter(r101, "appId");
        super(r100, r102);
        this.f60572h = r101;
    }
}
