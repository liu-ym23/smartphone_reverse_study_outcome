package com.obric.autogui.agents.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectActionHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.a.a.e f26176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f26177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f26178c;

    public e() {
        this(null, null, 0, 7, null);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, e.class) == true) goto L8;
        return false;
    L8:
        e r8 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f26176a, r8.f26176a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f26177b, r8.f26177b) == true) goto L15;
        return false;
    L15:
        if (this.f26178c == r8.f26178c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        com.obric.autogui.agents.a.a.e r0 = this.f26176a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.f26177b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + Long.hashCode(this.f26178c);
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionEffectHandlerEvaluationSnapshot(directResult=" + this.f26176a + ", frameworkRegistrationToCallbackElapsedMs=" + this.f26177b + ", frameworkCallbackWaitElapsedMs=" + this.f26178c + ')';
    }

    public e(com.obric.autogui.agents.a.a.e r1, Long r2, long r3) {
        this.f26176a = r1;
        this.f26177b = r2;
        this.f26178c = r3;
    }

    public /* synthetic */ e(com.obric.autogui.agents.a.a.e r2, Long r3, long r4, int r6, d.h.b.h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }

    public final com.obric.autogui.agents.a.a.e a() {
        return this.f26176a;
    }

    public final Long b() {
        return this.f26177b;
    }

    public final long c() {
        return this.f26178c;
    }
}
