package com.obric.oui.indicator;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bg.c f15061c;

    public d(int r10, int r11, bg.c r12) {
        q.g(r12, "visibleRange");
        this.f15059a = r10;
        this.f15060b = r11;
        this.f15061c = r12;
    }

    public final IndicatorDotVisualState a(int r10) {
        bg.c r11 = this.f15061c;
        int r12 = r11.a();
        if (r10 > r11.b()) goto L27;
        if (r12 > r10) goto L27;
        if (r10 == this.f15060b) goto L8;
        boolean r13 = false;
        if (r10 == r11.a()) goto L12;
    L14:
        boolean r14 = false;
    L16:
        if (r10 == r11.b()) goto L18;
    L20:
        if (r14 == true) goto L25;
        if (r13 == true) goto L25;
        return IndicatorDotVisualState.NORMAL;
    L25:
        return IndicatorDotVisualState.EDGE;
    L18:
        if (r11.b() >= (this.f15059a - 1)) goto L20;
        r13 = true;
        goto L20
    L12:
        if (r11.a() <= 0) goto L14;
        r14 = true;
        goto L16
    L8:
        return IndicatorDotVisualState.ACTIVE;
    L27:
        return IndicatorDotVisualState.HIDDEN;
    }

    public final int b() {
        return this.f15059a;
    }

    public final bg.c c() {
        return this.f15061c;
    }

    public final boolean d(int r10) {
        bg.c r11 = this.f15061c;
        int r12 = r11.a();
        if (r10 > r11.b()) goto L7;
        if (r12 > r10) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (this.f15059a == r11.f15059a) goto L12;
        return false;
    L12:
        if (this.f15060b == r11.f15060b) goto L15;
        return false;
    L15:
        if (q.b(this.f15061c, r11.f15061c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f15059a) * 31) + Integer.hashCode(this.f15060b)) * 31) + this.f15061c.hashCode();
    }

    public String toString() {
        return "IndicatorViewportState(totalCount=" + this.f15059a + ", selectedIndex=" + this.f15060b + ", visibleRange=" + this.f15061c + ')';
    }
}
