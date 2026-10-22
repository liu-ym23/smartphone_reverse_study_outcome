package com.obric.autoaction.vdplayer.legacy.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements com.obric.autoaction.vdplayer.legacy.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f25961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f25962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f25963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<h> f25964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f25965e;
    private final o f;
    private final f g;

    /* JADX INFO: compiled from: VDPlayerUIState.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25966a = null;

        static {
            int[] r0 = new int[l.values().length];
            r0[l.f25914a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[l.f25915b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[l.f25916c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[l.f25917d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[l.f25918e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[l.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[l.g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f25966a = r0;
        }
    }

    public s() {
        this(null, null, null, null, false, null, null, 127, null);
    }

    public static /* synthetic */ s a(s r8, n r9, k r10, h r11, List r12, boolean r13, o r14, f r15, int r16, Object r17) {
        List<h> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r16 & 1) == 0) goto L5;
        n r2 = r8.f25961a;
    L7:
        if ((r16 & 2) == 0) goto L9;
        k r3 = r8.f25962b;
    L11:
        if ((r16 & 4) == 0) goto L13;
        h r4 = r8.f25963c;
    L15:
        if ((r16 & 8) == 0) goto L18;
        r1 = r8.f25964d;
    L18:
        if ((r16 & 16) == 0) goto L20;
        boolean r5 = r8.f25965e;
    L22:
        if ((r16 & 32) == 0) goto L24;
        o r6 = r8.f;
    L26:
        if ((r16 & 64) == 0) goto L28;
        f r7 = r8.g;
    L30:
        return r8.a(r2, r3, r4, r1, r5, r6, r7);
    L28:
        r7 = r15;
        goto L30
    L24:
        r6 = r14;
        goto L26
    L20:
        r5 = r13;
        goto L22
    L13:
        r4 = r11;
        goto L15
    L9:
        r3 = r10;
        goto L11
    L5:
        r2 = r9;
        goto L7
    }

    public final s a(n r9, k r10, h r11, List<h> r12, boolean r13, o r14, f r15) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "taskState");
        d.h.b.o.e(r10, "panelState");
        d.h.b.o.e(r11, "opAppInfo");
        d.h.b.o.e(r4, "operatingAppHistory");
        d.h.b.o.e(r14, "userOperateMode");
        return new s(r9, r10, r11, r4, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, s.class) == true) goto L8;
        return false;
    L8:
        s r6 = (s) ZeusTransformUtils.preCheckCast(r5, s.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f25961a, r6.f25961a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f25962b, r6.f25962b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f25963c, r6.f25963c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f25964d, r6.f25964d) == true) goto L21;
        return false;
    L21:
        if (this.f25965e == r6.f25965e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.f25961a.hashCode() * 31) + this.f25962b.hashCode()) * 31) + this.f25963c.hashCode()) * 31) + this.f25964d.hashCode()) * 31) + Boolean.hashCode(this.f25965e)) * 31) + this.f.hashCode()) * 31;
        f r2 = this.g;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public s(n r3, k r4, h r5, List<h> r6, boolean r7, o r8, f r9) {
        List<h> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "taskState");
        d.h.b.o.e(r4, "panelState");
        d.h.b.o.e(r5, "opAppInfo");
        d.h.b.o.e(r10, "operatingAppHistory");
        d.h.b.o.e(r8, "userOperateMode");
        this.f25961a = r3;
        this.f25962b = r4;
        this.f25963c = r5;
        this.f25964d = r10;
        this.f25965e = r7;
        this.f = r8;
        this.g = r9;
    }

    public /* synthetic */ s(n r13, k r14, h r15, List r16, boolean r17, o r18, f r19, int r20, d.h.b.h r21) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        if ((r20 & 1) == 0) goto L5;
        n r1 = (n) ZeusTransformUtils.preCheckCast(n.b.f25925a, n.class, "com.obric.aiagent.plugin");
    L7:
        if ((r20 & 2) == 0) goto L9;
        k r2 = new k(null, null, null, null, null, false, 63, null);
    L11:
        if ((r20 & 4) == 0) goto L13;
        h r3 = t.a();
    L15:
        if ((r20 & 8) == 0) goto L18;
        r0 = d.a.p.b();
    L18:
        if ((r20 & 16) == 0) goto L20;
        boolean r4 = false;
    L22:
        if ((r20 & 32) == 0) goto L24;
        o r5 = o.f25926a;
    L26:
        if ((r20 & 64) == 0) goto L28;
        f r6 = null;
    L29:
        this(r1, r2, r3, r0, r4, r5, r6);
        return;
    L28:
        r6 = r19;
        goto L29
    L24:
        r5 = r18;
        goto L26
    L20:
        r4 = r17;
        goto L22
    L13:
        r3 = r15;
        goto L15
    L9:
        r2 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }

    public final n a() {
        return this.f25961a;
    }

    public final k b() {
        return this.f25962b;
    }

    public final h c() {
        return this.f25963c;
    }

    public final List<h> d() {
        return this.f25964d;
    }

    public final o e() {
        return this.f;
    }

    public final f f() {
        return this.g;
    }

    public final boolean g() {
        if (this.f == o.f25926a) goto L5;
        return true;
    L5:
        return false;
    }

    public final g h() {
        if (g() == true) goto L5;
        l r1 = this.f25962b.a().a();
        switch(a.f25966a[r1.ordinal()]) {
            case 1: goto L14;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L15;
            case 7: goto L15;
            default: goto L9;
        };
    L9:
        throw new d.k();
    L15:
        return g.f25891a;
    L16:
        return g.f25895e;
    L17:
        return g.f25894d;
    L14:
        return g.f25893c;
    L5:
        return g.f25892b;
    }

    public final e i() {
        if (d.h.b.o.a(this.f25961a, n.a.f25924a) == true) goto L5;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f25963c.c(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L19;
        if (g() == true) goto L19;
        return e.f25883b;
    L19:
        return e.f25882a;
    L9:
        if (r0.length() == 0) goto L12;
        r1 = false;
        goto L13
    L5:
        return e.f25884c;
    }

    public final m j() {
        if (this.f25965e == false) goto L13;
        if (d.h.b.o.a(this.f25961a, n.a.f25924a) == false) goto L9;
        return m.f25920b;
    L9:
        if (g() == false) goto L15;
        return m.f25920b;
    L15:
        return m.f25919a;
    L13:
        return m.f25921c;
    }

    public final s a(s r2) {
        d.h.b.o.e(r2, "oldState");
        return k().b(r2);
    }

    private final s b(s r15) {
        if (g() == false) goto L7;
        j r16 = j.f25905b;
    L5:
        j r3 = r16;
        return a(this, null, k.a(this.f25962b, null, null, r3, null, null, false, 59, null), null, null, false, null, null, 125, null);
    L7:
        if (g() == false) goto L9;
        return this;
    L9:
        if (r15.g() == false) goto L14;
        r16 = a(this.f25962b.c());
        goto L5
    L14:
        return this;
    }

    private final j a(j r1) {
        if (r1 == j.f25905b) goto L5;
        return r1;
    L5:
        return j.f25904a;
    }

    private final s k() {
        if (this.f25963c.c() == null) goto L5;
        boolean r0 = true;
    L6:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.f25962b.b(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r1.iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        com.obric.autoaction.vdplayer.legacy.d.a r2 = (com.obric.autoaction.vdplayer.legacy.d.a) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.autoaction.vdplayer.legacy.d.a.class, "com.obric.aiagent.plugin");
        if (r2.getType() != b.f25875e) goto L12;
        r2 = com.obric.autoaction.vdplayer.legacy.d.a.a(r2, null, r0, false, null, 13, null);
    L12:
        r9.add(r2);
        goto L8
    L13:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        return a(this, null, k.a(this.f25962b, null, r3, null, null, null, false, 61, null), null, null, false, null, null, 125, null);
    L5:
        r0 = false;
        goto L6
    }

    public String toString() {
        return "panelState=" + this.f25962b + " userOperating=" + g() + " effectState=" + h() + " showCover=" + i() + " secureState=" + j();
    }
}
