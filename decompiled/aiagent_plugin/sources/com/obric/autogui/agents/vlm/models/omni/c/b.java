package com.obric.autogui.agents.vlm.models.omni.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppPredictionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28241a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f28241a, r6.f28241a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f28241a.hashCode();
    }

    public String toString() {
        return "AppPrediction(packageName=" + this.f28241a + ')';
    }

    public b(String r2) {
        d.h.b.o.e(r2, "packageName");
        this.f28241a = r2;
    }

    public final String a() {
        return this.f28241a;
    }
}
