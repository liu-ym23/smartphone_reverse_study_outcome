package com.obric.oui.material;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f15213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.obric.oui.shadow.a[] f15214b;

    public a(float r10, com.obric.oui.shadow.a[] r11) {
        kotlin.jvm.internal.q.g(r11, "shadow");
        this.f15213a = r10;
        this.f15214b = r11;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        Class<?> r11 = null;
    L9:
        if (kotlin.jvm.internal.q.b(a.class, r11) == true) goto L11;
        return false;
    L11:
        if (r10 == null) goto L20;
        a r12 = (a) r10;
        if (this.f15213a == r12.f15213a) goto L15;
        return false;
    L15:
        if (Arrays.equals(this.f15214b, r12.f15214b) == true) goto L17;
        return false;
    L17:
        return true;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.BlurShadowConfig");
    L7:
        r11 = r10.getClass();
        goto L9
    }

    public int hashCode() {
        return (int) ((31 * this.f15213a) + Arrays.hashCode(this.f15214b));
    }

    public String toString() {
        return "BlurShadowConfig(blurRadius=" + this.f15213a + ", shadow=" + Arrays.toString(this.f15214b) + ')';
    }
}
