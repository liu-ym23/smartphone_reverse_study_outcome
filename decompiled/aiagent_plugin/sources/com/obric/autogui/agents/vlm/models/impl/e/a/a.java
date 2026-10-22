package com.obric.autogui.agents.vlm.models.impl.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OperationExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f27801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f27802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f27803c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f27801a == r6.f27801a) goto L12;
        return false;
    L12:
        if (this.f27802b == r6.f27802b) goto L15;
        return false;
    L15:
        if (o.a(this.f27803c, r6.f27803c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((Boolean.hashCode(this.f27801a) * 31) + Integer.hashCode(this.f27802b)) * 31;
        f r2 = this.f27803c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "OperationExecutionResult(isSuccess=" + this.f27801a + ", executedCount=" + this.f27802b + ", failure=" + this.f27803c + ')';
    }

    public a(boolean r1, int r2, f r3) {
        this.f27801a = r1;
        this.f27802b = r2;
        this.f27803c = r3;
    }

    public /* synthetic */ a(boolean r1, int r2, f r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public final boolean a() {
        return this.f27801a;
    }

    public final int b() {
        return this.f27802b;
    }

    public final f c() {
        return this.f27803c;
    }
}
