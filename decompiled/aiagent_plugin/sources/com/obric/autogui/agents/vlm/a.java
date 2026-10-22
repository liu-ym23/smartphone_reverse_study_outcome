package com.obric.autogui.agents.vlm;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VlmAgent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f27107b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f27106a == r6.f27106a) goto L12;
        return false;
    L12:
        if (this.f27107b == r6.f27107b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f27106a) * 31) + Integer.hashCode(this.f27107b);
    }

    public String toString() {
        return "ActionEffectActionPosition(actionIndex=" + this.f27106a + ", actionCount=" + this.f27107b + ')';
    }

    public a(int r1, int r2) {
        this.f27106a = r1;
        this.f27107b = r2;
    }

    public final int a() {
        return this.f27106a;
    }

    public final int b() {
        return this.f27107b;
    }

    public final boolean c() {
        if (this.f27107b > 1) goto L7;
        return false;
    L7:
        return true;
    }
}
