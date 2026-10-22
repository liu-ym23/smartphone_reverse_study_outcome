package com.bytedance.android.livesdk.performance.degrade.ability;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import com.facebook.keyframes.model.KFAnimation;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements LevelAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LivePerformanceScheduleStrategy f154535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f154536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, b> f154537c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f154538d = null;

    public d() {
    }

    static {
        f154538d = new d();
        f154535a = LivePerformanceScheduleStrategy.ORIGIN;
        f154537c = new HashMap();
    }

    public static boolean a() {
        if (f154536b == true) goto L6;
        return true;
    L6:
        if (f154535a != LivePerformanceScheduleStrategy.FORBIDDEN) goto L10;
        return false;
    L10:
        return true;
    }

    public static void b(LivePerformanceScheduleStrategy r100) {
        if (f154536b == true) goto L6;
        return;
    L6:
        if (f154535a != r100) goto L9;
        return;
    L9:
        if (r100 != LivePerformanceScheduleStrategy.FORBIDDEN) goto L14;
        b r101 = f154537c.get("gpu_monitor_schedule_ability");
        if (r101 == null) goto L13;
        r101.a();
    L13:
        ALogger.d("LivePerformanceScheduleAtomicAbility", "GpuMonitor:forbidden");
    L14:
        f154535a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.service.LevelAbility
    public final boolean onLevelChange(int r100) {
        if (r100 >= 0) goto L4;
        b(LivePerformanceScheduleStrategy.FORBIDDEN);
        return true;
    L4:
        b(LivePerformanceScheduleStrategy.ORIGIN);
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.service.AtomicAbility
    public final void onPropertyChange(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        Object r102 = r100.get("gpu_monitor_schedule_ability");     // Catch: Throwable -> L18
        Object r103 = null;
        if (r102 != null) goto L6;
    L8:
        r102 = null;
    L10:
        if ((r102 instanceof String) == false) goto L13;
        r103 = r102;
    L13:
        String r104 = (String) r103;     // Catch: Throwable -> L18
        if (r104 == null) goto L16;
        f154536b = Intrinsics.areEqual(r104, "1");     // Catch: Throwable -> L18
    L16:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
        return;
    L6:
        if ((r102 instanceof String) == false) goto L8;
    L18:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
