package com.a.c.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BetweenFieldValueGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class e extends h {
    public e(com.a.c.b.a r1) {
        super(r1);
    }

    @Override // com.a.c.c.a.h
    public int a(int r3) {
        com.a.c.b.c.c r2 = (com.a.c.b.c.c) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.c.class, "com.obric.aiagent.plugin");
    L3:
        r3 = r3 + 1;
        if (r3 < a(r2.b())) goto L3;
        if (r3 > a(r2.c())) goto L9;
        return r3;
    L9:
        throw new j();
    }

    @Override // com.a.c.c.a.h
    public List<Integer> a(int r5, int r6) {
        ArrayList r0 = new ArrayList();
        com.a.c.b.c.c r1 = (com.a.c.b.c.c) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.c.class, "com.obric.aiagent.plugin");
        int r2 = a(r1.b());
        int r3 = a(r1.c());
        if (r5 > r3) goto L19;
        if (r2 > r6) goto L19;
        if (r3 < r6) goto L9;
        r3 = r6;
    L9:
        if (a(r1.b()) > r5) goto L12;
        r2 = r5;
    L12:
        if (r2 != r5) goto L21;
    L14:
        int r7 = a(r2);     // Catch: j -> L20
    L15:
        if (r7 >= r3) goto L17;
        r0.add(Integer.valueOf(r7));     // Catch: j -> L20
        r7 = a(r7);     // Catch: j -> L20
        goto L15
    L17:
        if (r3 == r6) goto L19;
        r0.add(Integer.valueOf(r7));     // Catch: j -> L20
        goto L19
    L21:
        r0.add(Integer.valueOf(r2));     // Catch: j -> L20
    L19:
        return r0;
    }

    @Override // com.a.c.c.a.h
    public boolean b(int r3) {
        com.a.c.b.c.c r2 = (com.a.c.b.c.c) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.c.class, "com.obric.aiagent.plugin");
        if (r3 >= a(r2.b())) goto L5;
    L7:
        return false;
    L5:
        if (r3 > a(r2.c())) goto L7;
        return true;
    }

    @Override // com.a.c.c.a.h
    public boolean a(com.a.c.b.c.e r1) {
        return ZeusTransformUtils.instanceOf(r1, com.a.c.b.c.c.class);
    }

    static int a(com.a.c.b.d.a<?> r2) {
        if (ZeusTransformUtils.instanceOf(r2, com.a.c.b.d.b.class) == false) goto L7;
        return ((com.a.c.b.d.b) ZeusTransformUtils.preCheckCast(r2, com.a.c.b.d.b.class, "com.obric.aiagent.plugin")).b().intValue();
    L7:
        throw new IllegalArgumentException("Non integer values at intervals are not fully supported yet.");
    }
}
