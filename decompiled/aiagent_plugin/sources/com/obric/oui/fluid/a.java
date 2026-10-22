package com.obric.oui.fluid;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: FluidConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f35253a;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public String toString() {
        return "FluidConfig(glassParams=" + Arrays.toString(this.f35253a) + ')';
    }

    public a(float[] r1) {
        this.f35253a = r1;
    }

    public /* synthetic */ a(float[] r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final float[] a() {
        return this.f35253a;
    }

    public final b b() {
        return new b(this.f35253a);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r6 != null) goto L8;
        Class<?> r3 = null;
    L10:
        if (o.a(r2, r3) == true) goto L12;
        return false;
    L12:
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.fluid.FluidConfig");
        a r4 = (a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.aiagent.plugin");
        if (Arrays.equals(this.f35253a, ((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.aiagent.plugin")).f35253a) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r3 = r6.getClass();
        goto L10
    }

    public int hashCode() {
        float[] r0 = this.f35253a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r0);
    }
}
