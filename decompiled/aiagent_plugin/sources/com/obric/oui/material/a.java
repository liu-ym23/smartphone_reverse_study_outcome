package com.obric.oui.material;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: BlurShadowConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f35478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.oui.shadow.a[] f35479b;

    public String toString() {
        return "BlurShadowConfig(blurRadius=" + this.f35478a + ", shadow=" + Arrays.toString(this.f35479b) + ')';
    }

    public a(float r2, com.obric.oui.shadow.a[] r3) {
        d.h.b.o.e(r3, "shadow");
        this.f35478a = r2;
        this.f35479b = r3;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 != null) goto L8;
        Class<?> r3 = null;
    L10:
        if (d.h.b.o.a(r2, r3) == true) goto L12;
        return false;
    L12:
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.material.BlurShadowConfig");
        a r4 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
        if (this.f35478a != ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin")).f35478a) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.f35479b, ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin")).f35479b) == true) goto L21;
        return false;
    L21:
        return true;
    L15:
        r5 = false;
        goto L16
    L8:
        r3 = r7.getClass();
        goto L10
    }

    public int hashCode() {
        return (int) ((31 * this.f35478a) + Arrays.hashCode(this.f35479b));
    }
}
