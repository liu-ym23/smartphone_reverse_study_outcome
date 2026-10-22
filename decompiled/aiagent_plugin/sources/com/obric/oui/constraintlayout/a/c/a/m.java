package com.obric.oui.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: RunGroup.java */
/* JADX INFO: loaded from: classes4.dex */
class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f34705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f34706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f34707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    p f34708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    p f34709e;
    ArrayList<p> f;
    int g;
    int h;

    m(p r3, int r4) {
        this.f34706b = 0;
        this.f34707c = false;
        this.f34708d = null;
        this.f34709e = null;
        this.f = new ArrayList();
        this.g = 0;
        int r0 = f34705a;
        this.g = r0;
        f34705a = r0 + 1;
        this.f34708d = r3;
        this.f34709e = r3;
        this.h = r4;
    }

    public void a(p r2) {
        this.f.add(r2);
        this.f34709e = r2;
    }

    private long a(f r9, long r10) {
        p r0 = r9.f34693d;
        if (ZeusTransformUtils.instanceOf(r0, k.class) == false) goto L5;
        return r10;
    L5:
        int r1 = r9.k.size();
        int r2 = 0;
        long r3 = r10;
    L6:
        if (r2 >= r1) goto L15;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r9.k.get(r2), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, f.class) == false) goto L13;
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (r6.f34693d == r0) goto L13;
        r3 = Math.max(r3, a(r6, ((long) r6.f) + r10));
    L13:
        r2 = r2 + 1;
        goto L6
    L15:
        if (r9 != r0.j) goto L22;
        long r4 = r0.b();
        long r11 = r10 + r4;
        return Math.max(Math.max(r3, a(r0.k, r11)), r11 - ((long) r0.k.f));
    L22:
        return r3;
    }

    private long b(f r9, long r10) {
        p r0 = r9.f34693d;
        if (ZeusTransformUtils.instanceOf(r0, k.class) == false) goto L5;
        return r10;
    L5:
        int r1 = r9.k.size();
        int r2 = 0;
        long r3 = r10;
    L6:
        if (r2 >= r1) goto L15;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r9.k.get(r2), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, f.class) == false) goto L13;
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (r6.f34693d == r0) goto L13;
        r3 = Math.min(r3, b(r6, ((long) r6.f) + r10));
    L13:
        r2 = r2 + 1;
        goto L6
    L15:
        if (r9 != r0.k) goto L22;
        long r4 = r0.b();
        long r11 = r10 - r4;
        return Math.min(Math.min(r3, b(r0.j, r11)), r11 - ((long) r0.j.f));
    L22:
        return r3;
    }

    public long a(com.obric.oui.constraintlayout.a.c.f r12, int r13) {
        long r1 = 0;
        if (ZeusTransformUtils.instanceOf(this.f34708d, c.class) == true) goto L5;
        if (r13 != 0) goto L12;
        if (ZeusTransformUtils.instanceOf(this.f34708d, l.class) == true) goto L14;
        return 0;
    L14:
        if (r13 != 0) goto L16;
        f r0 = r12.f.j;
    L17:
        if (r13 != 0) goto L19;
        f r14 = r12.f.k;
    L20:
        boolean r2 = this.f34708d.j.l.contains(r0);
        boolean r15 = this.f34708d.k.l.contains(r14);
        long r3 = this.f34708d.b();
        if (r2 == false) goto L33;
        if (r15 == false) goto L33;
        long r5 = a(this.f34708d.j, 0);
        long r7 = b(this.f34708d.k, 0);
        long r6 = r5 - r3;
        if (r6 < (-this.f34708d.k.f)) goto L26;
        r6 = r6 + ((long) this.f34708d.k.f);
    L26:
        long r8 = ((-r7) - r3) - ((long) this.f34708d.j.f);
        if (r8 < this.f34708d.j.f) goto L29;
        r8 = r8 - ((long) this.f34708d.j.f);
    L29:
        float r16 = this.f34708d.f34724d.n(r13);
        if (r16 <= 0.0f) goto L32;
        r1 = (long) ((r8 / r16) + (r6 / (1.0f - r16)));
    L32:
        float r17 = r1;
        long r18 = ((long) this.f34708d.j.f) + ((((long) ((r17 * r16) + 0.5f)) + r3) + ((long) ((r17 * (1.0f - r16)) + 0.5f)));
        int r11 = this.f34708d.k.f;
    L39:
        return r18 - ((long) r11);
    L33:
        if (r2 == true) goto L40;
        if (r15 == false) goto L37;
        long r19 = b(this.f34708d.k, this.f34708d.k.f);
        return Math.max(-r19, ((long) (-this.f34708d.k.f)) + r3);
    L37:
        r18 = ((long) this.f34708d.j.f) + this.f34708d.b();
        r11 = this.f34708d.k.f;
        goto L39
    L40:
        return Math.max(a(this.f34708d.j, this.f34708d.j.f), ((long) this.f34708d.j.f) + r3);
    L19:
        r14 = r12.g.k;
        goto L20
    L16:
        r0 = r12.g.j;
        goto L17
    L12:
        if (ZeusTransformUtils.instanceOf(this.f34708d, n.class) == true) goto L14;
        return 0;
    L5:
        if (((c) ZeusTransformUtils.preCheckCast(this.f34708d, c.class, "com.obric.aiagent.plugin")).h == r13) goto L14;
        return 0;
    }
}
