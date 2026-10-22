package com.obric.oui.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f13362h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WidgetRun f13365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WidgetRun f13366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f13367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13369g;

    public j(WidgetRun r10, int r11) {
        this.f13363a = 0;
        this.f13364b = false;
        this.f13365c = null;
        this.f13366d = null;
        this.f13367e = new ArrayList();
        int r12 = f13362h;
        this.f13368f = r12;
        f13362h = r12 + 1;
        this.f13365c = r10;
        this.f13366d = r10;
        this.f13369g = r11;
    }

    public void a(WidgetRun r10) {
        this.f13367e.add(r10);
        this.f13366d = r10;
    }

    public long b(com.obric.oui.constraintlayout.core.widgets.d r12, int r13) {
        WidgetRun r10 = this.f13365c;
        long r11 = 0;
        if ((r10 instanceof b) == true) goto L5;
        if (r13 != 0) goto L12;
        if ((r10 instanceof i) == true) goto L14;
        return 0;
    L14:
        if (r13 != 0) goto L17;
        WidgetRun r14 = r12.f13259e;
    L16:
        DependencyNode r15 = r14.f13341h;
        if (r13 != 0) goto L21;
        WidgetRun r16 = r12.f13259e;
    L20:
        DependencyNode r17 = r16.f13342i;
        boolean r18 = r10.f13341h.f13333l.contains(r15);
        boolean r19 = this.f13365c.f13342i.f13333l.contains(r17);
        long r20 = this.f13365c.i();
        if (r18 == false) goto L35;
        if (r19 == false) goto L35;
        long r21 = d(this.f13365c.f13341h, 0);
        long r22 = c(this.f13365c.f13342i, 0);
        long r23 = r21 - r20;
        WidgetRun r110 = this.f13365c;
        int r24 = r110.f13342i.f13327f;
        if (r23 < (-r24)) goto L28;
        r23 = r23 + ((long) r24);
    L28:
        int r25 = r110.f13341h.f13327f;
        long r26 = ((-r22) - r20) - ((long) r25);
        if (r26 < r25) goto L31;
        r26 = r26 - ((long) r25);
    L31:
        float r111 = r110.f13335b.p(r13);
        if (r111 <= 0.0f) goto L34;
        r11 = (long) ((r26 / r111) + (r23 / (1.0f - r111)));
    L34:
        float r112 = r11;
        long r27 = (((long) ((r112 * r111) + 0.5f)) + r20) + ((long) ((r112 * (1.0f - r111)) + 0.5f));
        WidgetRun r113 = this.f13365c;
        return (((long) r113.f13341h.f13327f) + r27) - ((long) r113.f13342i.f13327f);
    L35:
        if (r18 == false) goto L37;
        DependencyNode r114 = this.f13365c.f13341h;
        return Math.max(d(r114, r114.f13327f), ((long) this.f13365c.f13341h.f13327f) + r20);
    L37:
        if (r19 == false) goto L39;
        DependencyNode r115 = this.f13365c.f13342i;
        long r116 = c(r115, r115.f13327f);
        return Math.max(-r116, ((long) (-this.f13365c.f13342i.f13327f)) + r20);
    L39:
        WidgetRun r117 = this.f13365c;
        return (((long) r117.f13341h.f13327f) + r117.i()) - ((long) this.f13365c.f13342i.f13327f);
    L21:
        r16 = r12.f13261f;
        goto L20
    L17:
        r14 = r12.f13261f;
        goto L16
    L12:
        if ((r10 instanceof k) == true) goto L14;
        return 0;
    L5:
        if (((b) r10).f13339f == r13) goto L14;
        return 0;
    }

    public final long c(DependencyNode r10, long r11) {
        WidgetRun r12 = r10.f13325d;
        if ((r12 instanceof h) == false) goto L5;
        return r11;
    L5:
        int r13 = r10.f13332k.size();
        int r14 = 0;
        long r15 = r11;
    L6:
        if (r14 >= r13) goto L15;
        Dependency r16 = (Dependency) r10.f13332k.get(r14);
        if ((r16 instanceof DependencyNode) == false) goto L13;
        DependencyNode r17 = (DependencyNode) r16;
        if (r17.f13325d == r12) goto L13;
        r15 = Math.min(r15, c(r17, ((long) r17.f13327f) + r11));
    L13:
        r14 = r14 + 1;
        goto L6
    L15:
        if (r10 != r12.f13342i) goto L22;
        long r18 = r12.i();
        long r19 = r11 - r18;
        return Math.min(Math.min(r15, c(r12.f13341h, r19)), r19 - ((long) r12.f13341h.f13327f));
    L22:
        return r15;
    }

    public final long d(DependencyNode r10, long r11) {
        WidgetRun r12 = r10.f13325d;
        if ((r12 instanceof h) == false) goto L5;
        return r11;
    L5:
        int r13 = r10.f13332k.size();
        int r14 = 0;
        long r15 = r11;
    L6:
        if (r14 >= r13) goto L15;
        Dependency r16 = (Dependency) r10.f13332k.get(r14);
        if ((r16 instanceof DependencyNode) == false) goto L13;
        DependencyNode r17 = (DependencyNode) r16;
        if (r17.f13325d == r12) goto L13;
        r15 = Math.max(r15, d(r17, ((long) r17.f13327f) + r11));
    L13:
        r14 = r14 + 1;
        goto L6
    L15:
        if (r10 != r12.f13341h) goto L22;
        long r18 = r12.i();
        long r19 = r11 + r18;
        return Math.max(Math.max(r15, d(r12.f13342i, r19)), r19 - ((long) r12.f13342i.f13327f));
    L22:
        return r15;
    }
}
