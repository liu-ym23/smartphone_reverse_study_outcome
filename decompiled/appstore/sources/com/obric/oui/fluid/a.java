package com.obric.oui.fluid;

import java.util.Arrays;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f14566a;

    public a(float[] r10) {
        this.f14566a = r10;
    }

    public final float[] a() {
        return this.f14566a;
    }

    public final b b() {
        return new b(this.f14566a);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        Class<?> r11 = null;
    L9:
        if (q.b(a.class, r11) == true) goto L11;
        return false;
    L11:
        if (r10 == null) goto L17;
        if (Arrays.equals(this.f14566a, ((a) r10).f14566a) == true) goto L15;
        return false;
    L15:
        return true;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.fluid.FluidConfig");
    L7:
        r11 = r10.getClass();
        goto L9
    }

    public int hashCode() {
        float[] r10 = this.f14566a;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r10);
    }

    public String toString() {
        return "FluidConfig(glassParams=" + Arrays.toString(this.f14566a) + ')';
    }
}
