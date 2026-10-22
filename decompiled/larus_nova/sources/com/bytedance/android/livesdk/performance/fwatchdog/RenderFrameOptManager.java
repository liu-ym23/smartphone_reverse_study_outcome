package com.bytedance.android.livesdk.performance.fwatchdog;

import com.bytedance.android.livesdk.performance.event.EventType;
import com.bytedance.android.livesdk.performance.event.b;
import com.bytedance.android.livesdk.performance.event.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class RenderFrameOptManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f154599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f154600b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f154601c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f154602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f154603e = null;

    public static final class a implements b {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.livesdk.performance.event.b
        public final <T> void a(EventType<T> r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (Intrinsics.areEqual(r100, EventType.c.f154580e) == false) goto L11;
            if (r101 == 0) goto L10;
            if (((Boolean) r101).booleanValue() == false) goto L8;
            k60.b.i();
            return;
        L8:
            k60.b.h();
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
    }

    public static k60.a a() {
        return (k60.a) f154601c.getValue();
    }

    static {
        f154600b = k60.b.g();
        f154601c = LazyKt.lazy(RenderFrameOptManager$config$2.INSTANCE);
        f154603e = new a();
    }

    public static void b(RenderFrameOptScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (a().mEnableDynamicSceneOpt == false) goto L9;
        if (f154602d != 0) goto L7;
        k60.b.k(a().dynamicSceneCheckTime);
    L7:
        f154602d |= r100.getBit();
    L9:
        if (r100 == RenderFrameOptScene.ENTER_ROOM) goto L11;
        return;
    L11:
        if (a().mStrategyVersion != 4) goto L15;
        boolean r101 = c.f154591a;
        c.b(f154603e, new EventType[]{EventType.c.f154580e});
        return;
    }
}
