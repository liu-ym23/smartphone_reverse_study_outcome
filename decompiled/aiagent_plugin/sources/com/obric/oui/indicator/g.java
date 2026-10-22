package com.obric.oui.indicator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IndicatorViewportState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.l.j f35397c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (this.f35395a == r6.f35395a) goto L12;
        return false;
    L12:
        if (this.f35396b == r6.f35396b) goto L15;
        return false;
    L15:
        if (o.a(this.f35397c, r6.f35397c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f35395a) * 31) + Integer.hashCode(this.f35396b)) * 31) + this.f35397c.hashCode();
    }

    public String toString() {
        return "IndicatorViewportState(totalCount=" + this.f35395a + ", selectedIndex=" + this.f35396b + ", visibleRange=" + this.f35397c + ')';
    }

    public g(int r2, int r3, d.l.j r4) {
        o.e(r4, "visibleRange");
        this.f35395a = r2;
        this.f35396b = r3;
        this.f35397c = r4;
    }

    public final int a() {
        return this.f35395a;
    }

    public final d.l.j b() {
        return this.f35397c;
    }

    public final c a(int r6) {
        d.l.j r0 = this.f35397c;
        int r1 = r0.a();
        boolean r3 = true;
        if (r6 > r0.b()) goto L6;
        if (r1 > r6) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L11;
        return c.f35389d;
    L11:
        if (r6 != this.f35396b) goto L15;
        return c.f35386a;
    L15:
        if (r6 == r0.a()) goto L17;
    L19:
        boolean r4 = false;
    L21:
        if (r6 == r0.b()) goto L23;
    L25:
        r3 = false;
    L26:
        if (r4 == true) goto L31;
        if (r3 == true) goto L31;
        return c.f35387b;
    L31:
        return c.f35388c;
    L23:
        if (r0.b() >= (this.f35395a - 1)) goto L25;
    L17:
        if (r0.a() <= 0) goto L19;
        r4 = true;
    L6:
        r2 = false;
        goto L7
    }

    public final boolean b(int r3) {
        d.l.j r2 = this.f35397c;
        int r0 = r2.a();
        if (r3 > r2.b()) goto L7;
        if (r0 > r3) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }
}
