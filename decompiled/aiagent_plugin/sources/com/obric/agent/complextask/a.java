package com.obric.agent.complextask;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ComplexTaskInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Long f14325b;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14324a, r6.f14324a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f14325b, r6.f14325b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f14324a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.f14325b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ComplexTaskInfo(logId=" + this.f14324a + ", interactionStopTime=" + this.f14325b + ')';
    }

    public a(String r1, Long r2) {
        this.f14324a = r1;
        this.f14325b = r2;
    }

    public /* synthetic */ a(String r2, Long r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String a() {
        return this.f14324a;
    }

    public final void a(String r1) {
        this.f14324a = r1;
    }

    public final void a(Long r1) {
        this.f14325b = r1;
    }

    public final Long b() {
        return this.f14325b;
    }
}
