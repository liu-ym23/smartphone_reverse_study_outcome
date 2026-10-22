package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class r extends BaseOpenMethod<JSONObject> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f60548h;

    public static final class a implements com.bytedance.android.live.profit.scoreboard.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f60549a;

        public a(r r100) {
            this.f60549a = r100;
        }

        @Override // com.bytedance.android.live.profit.scoreboard.f
        public final void a(com.bytedance.android.live.profit.scoreboard.b r110) {
            String r100 = GsonProtectorUtils.toJson(GsonHelper.get(), r110);
            if (r100 != null) goto L6;
            r100 = "";
        L6:
            if (r110 != null) goto L8;
            r110 = new com.bytedance.android.live.profit.scoreboard.b(0);
        L8:
            AudienceGameContext.Companion.getClass();
            AudienceGameContext r101 = AudienceGameContext.a.a();
            if (r101 == null) goto L15;
            com.bytedance.live.datacontext.m<Boolean> r102 = r101.getDisableEntrance();
            if (r102 == null) goto L15;
            Boolean r103 = r102.getValue();
            if (r103 == null) goto L15;
            boolean r104 = r103.booleanValue();
        L16:
            this.f60549a.getClass();
            if ((!Intrinsics.areEqual(r110.b(), "0")) == true) goto L19;
        L23:
            boolean r105 = false;
        L25:
            if (r105 == false) goto L28;
            if (r104 == true) goto L28;
            boolean r106 = com.bytedance.android.live.revenue.core.util.h.f91037a;
            ((com.bytedance.android.live.profit.scoreboard.h) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class)).k2(this.f60549a.f60306d.f60809m.f61083i);
            int r107 = 1;
        L29:
            r r108 = this.f60549a;
            JSONObject r109 = new JSONObject(r100);
            this.f60549a.getClass();     // Catch: JSONException -> L36
            if (r107 == 2) goto L33;
            int r111 = (int) (r110.c() - r110.e());     // Catch: JSONException -> L36
        L34:
            r109.put("left_time", r111);     // Catch: JSONException -> L36
            r109.put("total_time", r110.c() - r110.d());     // Catch: JSONException -> L36
            r109.put("type", r107);     // Catch: JSONException -> L36
        L38:
            Unit r112 = Unit.INSTANCE;
            r108.r(r109);
            return;
        L33:
            r111 = 0;
        L36:
            e = move-exception;
            int r113 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.e(this.f60549a.f60548h, new Object[]{"GetCounterRankMethod e = " + e.getMessage()});
        L28:
            r107 = 2;
            goto L29
        L19:
            if (r110.a() != 0) goto L23;
            if ((r110.c() - r110.e()) <= 0) goto L23;
            r105 = true;
        L15:
            r104 = false;
            goto L16
        }

        @Override // com.bytedance.android.live.profit.scoreboard.f
        public final void onFailed(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMsg");
            BaseOpenMethod.p(this.f60549a, r100, r101, null, 12);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "getCounterRank";
    }

    public r(PluginContext r100, Queue<Long> r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        super(r100, r101);
        this.f60548h = "GetCounterRankMethod";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = r100.optString("counter_id", "0");
        boolean r103 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.scoreboard.h) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class)).s1(this.f60306d.f60809m.f61083i, r102, new a(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r100, CallContext r101) {
        call2(r100, r101);
    }
}
