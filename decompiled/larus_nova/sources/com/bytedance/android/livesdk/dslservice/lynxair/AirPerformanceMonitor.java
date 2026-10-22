package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.livesdk.dslservice.util.DSLMonitor;
import com.bytedance.android.livesdk.dslservice.util.m;
import com.bytedance.ies.bullet.core.t;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yt1.q;

/* JADX INFO: loaded from: classes8.dex */
public final class AirPerformanceMonitor implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f122839a;

    public AirPerformanceMonitor(q r100) {
        this.f122839a = r100;
    }

    @Override // com.bytedance.ies.bullet.core.t
    public final void a(final JSONObject r110, final JSONObject r111) {
        Intrinsics.checkNotNullParameter(r110, "engineMetrics");
        Intrinsics.checkNotNullParameter(r111, "bulletMetrics");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r111, "duration");     // Catch: Throwable -> L14
        long r102 = JSONObjectProtectorUtils.getLong(r101, "schema_convert");     // Catch: Throwable -> L14
        long r103 = JSONObjectProtectorUtils.getLong(r101, "jsb_register");     // Catch: Throwable -> L14
        long r104 = JSONObjectProtectorUtils.getLong(r101, "create_lynxview");     // Catch: Throwable -> L14
        long r105 = (r102 + r103) + r104;     // Catch: Throwable -> L14
        final long r106 = r105 + JSONObjectProtectorUtils.getLong(r101, "render_template_main");     // Catch: Throwable -> L14
        q r107 = this.f122839a;     // Catch: Throwable -> L14
        if (r107 == null) goto L7;
        final String r108 = r107.f569037a;     // Catch: Throwable -> L14
        if (r108 == null) goto L7;
    L8:
        m r109 = m.f123003h;     // Catch: Throwable -> L14
        r109.a(new AirPerformanceMonitor$onSetup$$inlined$runCatching$lambda$1(r108, this, r111, r110));     // Catch: Throwable -> L14
        r109.a(new AirPerformanceMonitor$onSetup$$inlined$runCatching$lambda$2(r108, this, r111, r110));     // Catch: Throwable -> L14
        r109.a(new AirPerformanceMonitor$onSetup$1$3(r108, r106));     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r108, "id");     // Catch: Throwable -> L14
        if (m.f123001f == false) goto L11;
        String r112 = "1";
    L12:
        Map r113 = MapsKt.mapOf(TuplesKt.to("isFirst", r112));     // Catch: Throwable -> L14
        m.f123001f = false;     // Catch: Throwable -> L14
        DSLMonitor.g(m.f123002g, r113, 1, r106);     // Catch: Throwable -> L14
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L11:
        r112 = "0";
    L7:
        r108 = "UnKnow";
    L14:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.ies.bullet.core.t
    public final void b(JSONObject r100, JSONObject r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "engineMetrics");
        Intrinsics.checkNotNullParameter(r101, "bulletMetrics");
        Intrinsics.checkNotNullParameter(r100, "engineMetrics");
        Intrinsics.checkNotNullParameter(r101, "bulletMetrics");
    }
}
