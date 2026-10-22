package com.obric.oui.texteffects.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f36410a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin");
        if (this.f36410a == r6.f36410a) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f36410a.hashCode();
    }

    public String toString() {
        return "MaterialLayerSpec(blurDirection=" + this.f36410a + ')';
    }

    public k(b r2) {
        d.h.b.o.e(r2, "blurDirection");
        this.f36410a = r2;
    }

    public final b a() {
        return this.f36410a;
    }
}
