package com.obric.common.oea.foundation.animation.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Token.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: compiled from: Token.kt */
    static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32448a = null;

        static {
            f32448a = new a();
        }

        a() {
        }

        @Override // com.obric.common.oea.foundation.animation.h.c
        public final float a(float r1) {
            return r1;
        }
    }

    public static final b a(e.d r5) {
        o.e(r5, "$this$toCubicBezierEasing");
        if (r5.a().length != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return new b(r5.a()[0], r5.a()[1], r5.a()[2], r5.a()[3]);
    L10:
        throw new IllegalArgumentException("Easing values must contain exactly 4 floats for cubic bezier.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final c b(e.d r2) {
        o.e(r2, "$this$toLinearEasing");
        return (c) ZeusTransformUtils.preCheckCast(a.f32448a, c.class, "com.obric.aiagent.plugin");
    }
}
