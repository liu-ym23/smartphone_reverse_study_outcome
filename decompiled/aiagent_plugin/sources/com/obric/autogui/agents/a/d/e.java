package com.obric.autogui.agents.a.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectImageFingerprint.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f26365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f26366b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (this.f26365a == r6.f26365a) goto L12;
        return false;
    L12:
        if (this.f26366b == r6.f26366b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f26365a) * 31) + Integer.hashCode(this.f26366b);
    }

    public String toString() {
        return "ActionEffectImageTarget(xPermille=" + this.f26365a + ", yPermille=" + this.f26366b + ')';
    }

    public e(int r1, int r2) {
        this.f26365a = r1;
        this.f26366b = r2;
    }

    public final int a() {
        return this.f26365a;
    }

    public final int b() {
        return this.f26366b;
    }
}
