package com.obric.oui.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: HelperReferences.java */
/* JADX INFO: loaded from: classes4.dex */
class k extends p {
    @Override // com.obric.oui.constraintlayout.a.c.a.p
    boolean a() {
        return false;
    }

    k(com.obric.oui.constraintlayout.a.c.e r1) {
        super(r1);
    }

    @Override // com.obric.oui.constraintlayout.a.c.a.p
    void c() {
        this.f34725e = null;
        this.j.a();
    }

    @Override // com.obric.oui.constraintlayout.a.c.a.p
    void d() {
        this.j.j = false;
    }

    private void a(f r2) {
        this.j.k.add(r2);
        r2.l.add(this.j);
    }

    @Override // com.obric.oui.constraintlayout.a.c.a.p
    void f() {
        if (ZeusTransformUtils.instanceOf(this.f34724d, com.obric.oui.constraintlayout.a.c.a.class) == false) goto L69;
        this.j.f34691b = true;
        com.obric.oui.constraintlayout.a.c.a r0 = (com.obric.oui.constraintlayout.a.c.a) ZeusTransformUtils.preCheckCast(this.f34724d, com.obric.oui.constraintlayout.a.c.a.class, "com.obric.aiagent.plugin");
        int r2 = r0.b();
        boolean r3 = r0.c();
        int r5 = 0;
        if (r2 == 0) goto L45;
        if (r2 != 1) goto L8;
        f r1 = this.j;
        r1.f34694e = f.a.f34699e;
    L36:
        if (r5 >= r0.aA) goto L44;
        com.obric.oui.constraintlayout.a.c.e r4 = r0.az[r5];
        if (r3 == false) goto L40;
    L42:
        f r6 = r4.f.k;
        r6.k.add(this.j);
        this.j.l.add(r6);
    L43:
        r5 = r5 + 1;
        goto L36
    L40:
        if (r4.B() != 8) goto L42;
    L44:
        a(this.f34724d.f.j);
        a(this.f34724d.f.k);
        return;
    L8:
        if (r2 != 2) goto L10;
        f r7 = this.j;
        r7.f34694e = f.a.f;
    L25:
        if (r5 >= r0.aA) goto L33;
        com.obric.oui.constraintlayout.a.c.e r8 = r0.az[r5];
        if (r3 == false) goto L29;
    L31:
        f r9 = r8.g.j;
        r9.k.add(this.j);
        this.j.l.add(r9);
    L32:
        r5 = r5 + 1;
        goto L25
    L29:
        if (r8.B() != 8) goto L31;
    L33:
        a(this.f34724d.g.j);
        a(this.f34724d.g.k);
        return;
    L10:
        if (r2 != 3) goto L73;
        f r10 = this.j;
        r10.f34694e = f.a.g;
    L14:
        if (r5 >= r0.aA) goto L22;
        com.obric.oui.constraintlayout.a.c.e r11 = r0.az[r5];
        if (r3 == false) goto L18;
    L20:
        f r12 = r11.g.k;
        r12.k.add(this.j);
        this.j.l.add(r12);
    L21:
        r5 = r5 + 1;
        goto L14
    L18:
        if (r11.B() != 8) goto L20;
    L22:
        a(this.f34724d.g.j);
        a(this.f34724d.g.k);
        return;
    L73:
        return;
    L45:
        f r13 = this.j;
        r13.f34694e = f.a.f34698d;
    L47:
        if (r5 >= r0.aA) goto L55;
        com.obric.oui.constraintlayout.a.c.e r14 = r0.az[r5];
        if (r3 == false) goto L51;
    L53:
        f r15 = r14.f.j;
        r15.k.add(this.j);
        this.j.l.add(r15);
    L54:
        r5 = r5 + 1;
        goto L47
    L51:
        if (r14.B() != 8) goto L53;
    L55:
        a(this.f34724d.f.j);
        a(this.f34724d.f.k);
        return;
    }

    @Override // com.obric.oui.constraintlayout.a.c.a.p, com.obric.oui.constraintlayout.a.c.a.d
    public void update(d r9) {
        d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
        com.obric.oui.constraintlayout.a.c.a r11 = (com.obric.oui.constraintlayout.a.c.a) ZeusTransformUtils.preCheckCast(this.f34724d, com.obric.oui.constraintlayout.a.c.a.class, "com.obric.aiagent.plugin");
        int r0 = r11.b();
        Iterator<f> r2 = this.j.l.iterator();
        int r4 = 0;
        int r5 = -1;
    L4:
        if (r2.hasNext() == false) goto L11;
        int r6 = ((f) ZeusTransformUtils.preCheckCast(r2.next(), f.class, "com.obric.aiagent.plugin")).g;
        if (r5 == (-1)) goto L8;
        if (r6 < r5) goto L8;
    L9:
        if (r4 >= r6) goto L4;
        r4 = r6;
    L8:
        r5 = r6;
        goto L9
    L11:
        if (r0 != 0) goto L13;
    L16:
        this.j.a(r5 + r11.g());
        return;
    L13:
        if (r0 == 2) goto L16;
        this.j.a(r4 + r11.g());
    }

    @Override // com.obric.oui.constraintlayout.a.c.a.p
    public void e() {
        if (ZeusTransformUtils.instanceOf(this.f34724d, com.obric.oui.constraintlayout.a.c.a.class) == false) goto L12;
        int r0 = ((com.obric.oui.constraintlayout.a.c.a) ZeusTransformUtils.preCheckCast(this.f34724d, com.obric.oui.constraintlayout.a.c.a.class, "com.obric.aiagent.plugin")).b();
        if (r0 != 0) goto L7;
    L10:
        this.f34724d.o(this.j.g);
        return;
    L7:
        if (r0 == 1) goto L10;
        this.f34724d.p(this.j.g);
        return;
    }
}
