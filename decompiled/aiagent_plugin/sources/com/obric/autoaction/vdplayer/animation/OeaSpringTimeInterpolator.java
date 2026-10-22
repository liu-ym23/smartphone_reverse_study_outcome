package com.obric.autoaction.vdplayer.animation;

import android.animation.TimeInterpolator;
import com.obric.common.oea.foundation.animation.g.a.b;
import com.obric.common.oea.foundation.animation.h.e;
import d.h.b.o;

/* JADX INFO: compiled from: OeaSpringTimeInterpolator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OeaSpringTimeInterpolator implements TimeInterpolator {
    private final long durationMillis;
    private final long durationNanos;
    private final SmoothInterpolator i;
    private final b spec;

    public OeaSpringTimeInterpolator(e.c r5, e.a r6) {
        o.e(r5, "duration");
        o.e(r6, "bounce");
        this.i = new SmoothInterpolator();
        b r7 = com.obric.common.oea.foundation.animation.g.b.a(r6, r5, 0, 4, null);
        this.spec = r7;
        long r8 = r7.a(0.0f, 1.0f, 0.0f);
        this.durationNanos = r8;
        this.durationMillis = ((r8 + 1000000) - 1) / 1000000;
    }

    public final long getDurationMillis() {
        return this.durationMillis;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r4) {
        if (r4 > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r4 < 1.0f) goto L9;
        return 1.0f;
    L9:
        return this.i.getInterpolation(r4);
    }
}
