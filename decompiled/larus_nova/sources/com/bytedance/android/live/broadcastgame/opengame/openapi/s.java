package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonParseException;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class s extends BaseOpenMethod<JSONObject> {

    public static final class a implements com.bytedance.android.live.profit.scoreboard.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f60554a;

        public a(s r100) {
            this.f60554a = r100;
        }

        @Override // com.bytedance.android.live.profit.scoreboard.e
        public final void a(com.bytedance.android.live.profit.scoreboard.a r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.f60554a.r(tv5.a.a(GsonHelper.get(), r100));     // Catch: JsonParseException -> L5
            return;
        L5:
            e = move-exception;
            s r101 = this.f60554a;
            String r102 = e.getMessage();
            if (r102 != null) goto L9;
            r102 = "";
        L9:
            BaseOpenMethod.p(r101, -1, r102, null, 8);
        }

        @Override // com.bytedance.android.live.profit.scoreboard.e
        public final void onFailed(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMsg");
            BaseOpenMethod.p(this.f60554a, r100, r101, null, 8);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "getCounterRuleInfo";
    }

    public s(PluginContext r100, Queue<Long> r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        super(r100, r101);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        com.bytedance.android.live.profit.scoreboard.h r103 = (com.bytedance.android.live.profit.scoreboard.h) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class);
        com.bytedance.android.live.broadcastgame.opengame.t r104 = this.f60306d.f60809m;
        r103.H5(r104.f61083i, r104.f61075a, new a(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r100, CallContext r101) {
        call2(r100, r101);
    }
}
