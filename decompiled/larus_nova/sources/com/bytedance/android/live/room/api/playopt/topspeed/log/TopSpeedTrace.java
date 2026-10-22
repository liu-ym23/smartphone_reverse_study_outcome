package com.bytedance.android.live.room.api.playopt.topspeed.log;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class TopSpeedTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f99078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TopSpeedTrace f99079b = null;

    public TopSpeedTrace() {
    }

    public static StringBuffer b() {
        return (StringBuffer) f99078a.getValue();
    }

    static {
        f99079b = new TopSpeedTrace();
        f99078a = LazyKt.lazy(TopSpeedTrace$traceBuffer$2.INSTANCE);
    }

    @JvmStatic
    public static final void c(com.bytedance.android.live.room.api.base.alog.a r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        Throwable r101 = r100.f98900b;
        if (r101 == null) goto L5;
        ALogger.e("LiveTopSpeedLog", r100.f98899a, r101);
        return;
    L5:
        ALogger.i("LiveTopSpeedLog", r100.f98899a);
        Unit r102 = Unit.INSTANCE;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (TopSpeedModeUtils.b() == false) goto L6;
        ALogger.w("LiveTopSpeedLog", r100);
        b().append(r100 + "\n");
        return;
    }
}
