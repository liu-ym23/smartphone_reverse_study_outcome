package com.obric.autogui.agents.vlm.models.impl.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: PageStateDigest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f27609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f27610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f27611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f27612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f27613e;
    private final boolean f;
    private final Integer g;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f27609a == r6.f27609a) goto L12;
        return false;
    L12:
        if (this.f27610b == r6.f27610b) goto L15;
        return false;
    L15:
        if (this.f27611c == r6.f27611c) goto L18;
        return false;
    L18:
        if (this.f27612d == r6.f27612d) goto L21;
        return false;
    L21:
        if (this.f27613e == r6.f27613e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (o.a(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((Boolean.hashCode(this.f27609a) * 31) + Boolean.hashCode(this.f27610b)) * 31) + Boolean.hashCode(this.f27611c)) * 31) + Boolean.hashCode(this.f27612d)) * 31) + Boolean.hashCode(this.f27613e)) * 31) + Boolean.hashCode(this.f)) * 31;
        Integer r2 = this.g;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "PageStateComparison(activityComparisonAvailable=" + this.f27609a + ", activityChanged=" + this.f27610b + ", viewTreeComparisonAvailable=" + this.f27611c + ", viewTreeChanged=" + this.f27612d + ", imageComparisonAvailable=" + this.f27613e + ", imageChanged=" + this.f + ", imageHammingDistance=" + this.g + ')';
    }

    public a(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, Integer r7) {
        this.f27609a = r1;
        this.f27610b = r2;
        this.f27611c = r3;
        this.f27612d = r4;
        this.f27613e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final boolean a() {
        return this.f27609a;
    }

    public final boolean b() {
        return this.f27610b;
    }

    public final boolean c() {
        return this.f27611c;
    }

    public final boolean d() {
        return this.f27612d;
    }

    public final boolean e() {
        return this.f27613e;
    }

    public final boolean f() {
        return this.f;
    }

    public final Integer g() {
        return this.g;
    }

    public final boolean h() {
        if (this.f27609a == false) goto L5;
    L10:
        return true;
    L5:
        if (this.f27611c == true) goto L10;
        if (this.f27613e == true) goto L10;
        return false;
    }

    public final boolean i() {
        if (this.f27609a == false) goto L7;
        if (this.f27610b == false) goto L7;
    L14:
        return true;
    L7:
        if (this.f27611c == false) goto L11;
        if (this.f27612d == true) goto L14;
    L11:
        if (this.f27613e == true) goto L13;
    L15:
        return false;
    L13:
        if (this.f == false) goto L15;
        goto L14
    }

    public final String j() {
        List r0 = p.a();
        if (this.f27609a == false) goto L8;
        if (this.f27610b == false) goto L8;
        r0.add("activity");
    L8:
        if (this.f27611c == false) goto L13;
        if (this.f27612d == false) goto L13;
        r0.add("viewtree");
    L13:
        if (this.f27613e == false) goto L18;
        if (this.f == false) goto L18;
        r0.add("image");
    L18:
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(p.a(r0), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    }

    public final String k() {
        List r0 = p.a();
        if (this.f27609a == false) goto L6;
        r0.add("activity");
    L6:
        if (this.f27611c == false) goto L9;
        r0.add("viewtree");
    L9:
        if (this.f27613e == false) goto L12;
        r0.add("image");
    L12:
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(p.a(r0), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    }
}
