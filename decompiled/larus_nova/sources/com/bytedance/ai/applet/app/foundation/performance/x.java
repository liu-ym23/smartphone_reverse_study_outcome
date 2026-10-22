package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class x extends l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v f34391v;

    @Override // com.bytedance.ai.applet.app.foundation.performance.l
    public final void p(long r100) {
        k.d(this, AppletPerformanceOutcome.SUCCESS, r100, AppletPerformanceErrorCode.SUCCESS, null, 8);
    }

    public x(c r100, final v r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "config");
        super(r100, r101.f34384a, new w(r101));
        this.f34391v = r101;
    }

    @Override // com.bytedance.ai.applet.app.foundation.performance.k
    public final e b(AppletPerformanceOutcome r210, long r211, AppletPerformanceErrorCode r212, String r213) {
        Intrinsics.checkNotNullParameter(r210, "outcome");
        Intrinsics.checkNotNullParameter(r212, "errorCode");
        c r100 = this.f34339a;
        String r101 = r100.f34270a;
        String r102 = r100.f34271b;
        long r103 = this.f34341c;
        long r104 = this.f34340b;
        long r105 = r211 - r104;
        Long r110 = Long.valueOf(this.f34391v.f34386c);
        Long r111 = Long.valueOf(this.f34391v.f34385b);
        Long r112 = l.e(this.f34351n, this.f34352o);
        Long r113 = l.e(this.f34354q, this.f34355r);
        Long r114 = l.e(this.f34356s, this.f34357t);
        Long r106 = this.f34357t;
        o r115 = this.f34348k;
        if (r115 == null) goto L5;
        Long r116 = Long.valueOf(r115.f34362b);
    L6:
        Long r117 = l.e(r106, r116);
        boolean r107 = this.f34353p;
        Long r108 = this.f34358u;
        v r109 = this.f34391v;
        return new j(r101, r102, r103, r104, r105, r212, r213, r110, r111, r112, r113, r114, r117, r107, r108, r109.f34387d, r109.f34388e, r109.f34389f);
    L5:
        r116 = null;
        goto L6
    }
}
