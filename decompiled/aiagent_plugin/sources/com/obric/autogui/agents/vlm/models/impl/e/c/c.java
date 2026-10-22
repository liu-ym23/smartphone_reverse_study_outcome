package com.obric.autogui.agents.vlm.models.impl.e.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: LoopGuard.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f27840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27841b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f27840a == r6.f27840a) goto L12;
        return false;
    L12:
        if (o.a(this.f27841b, r6.f27841b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f27840a) * 31;
        String r1 = this.f27841b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "LoopGuardResult(shouldContinue=" + this.f27840a + ", modelWarning=" + this.f27841b + ')';
    }

    public c(boolean r1, String r2) {
        this.f27840a = r1;
        this.f27841b = r2;
    }

    public /* synthetic */ c(boolean r1, String r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final boolean a() {
        return this.f27840a;
    }

    public final String b() {
        return this.f27841b;
    }
}
