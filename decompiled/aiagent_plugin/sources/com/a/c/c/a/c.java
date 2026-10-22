package com.a.c.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AndFieldValueGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.b.c f3147a = null;

    public static /* synthetic */ Integer lambda$qOBRr9vqDiwvQaK6YU6_8fdwH5U(int r0, h r1) {
        return a(r0, r1);
    }

    static {
        f3147a = org.b.d.a(c.class);
    }

    public c(com.a.c.b.a r1) {
        super(r1);
    }

    @Override // com.a.c.c.a.h
    public int a(final int r2) {
        List<Integer> r1 = a(new $$Lambda$c$qOBRr9vqDiwvQaK6YU6_8fdwH5U(r2));
        if (r1.isEmpty() == true) goto L7;
        return ((Integer) ZeusTransformUtils.preCheckCast(r1.get(0), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L7:
        throw new j();
    }

    private static /* synthetic */ Integer a(int r0, h r1) {
        return Integer.valueOf(r1.a(r0));
    L5:
        return Integer.MIN_VALUE;
    }

    @Override // com.a.c.c.a.h
    public List<Integer> a(int r3, int r4) {
        ArrayList r0 = new ArrayList();
        int r5 = a(r3);     // Catch: j -> L7
    L4:
        if (r5 >= r4) goto L9;
        r0.add(Integer.valueOf(r5));     // Catch: j -> L7
        r5 = a(r5);     // Catch: j -> L7
    L9:
        return r0;
    L7:
        e = move-exception;
        f3147a.a("Catched expected exception while generating candidates", e);
        goto L9
    }

    @Override // com.a.c.c.a.h
    public boolean b(int r8) {
        Iterator<com.a.c.b.c.e> r0 = ((com.a.c.b.c.b) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.b.class, "com.obric.aiagent.plugin")).b().iterator();
    L3:
        boolean r3 = false;
    L5:
        if (r0.hasNext() == false) goto L11;
        com.a.c.b.c.e r4 = (com.a.c.b.c.e) ZeusTransformUtils.preCheckCast(r0.next(), com.a.c.b.c.e.class, "com.obric.aiagent.plugin");
        if (r3 == true) goto L10;
        if (a(new com.a.c.b.a(this.f3156c.a(), r4, this.f3156c.c())).b(r8) == false) goto L3;
    L10:
        r3 = true;
        goto L5
    L11:
        return r3;
    }

    @Override // com.a.c.c.a.h
    public boolean a(com.a.c.b.c.e r1) {
        return ZeusTransformUtils.instanceOf(r1, com.a.c.b.c.b.class);
    }

    private List<Integer> a(com.a.a<h, Integer> r8) {
        com.a.a r9 = (com.a.a) ZeusTransformUtils.wrapperContextForParams(r8, com.a.a.class, "com.obric.aiagent.plugin");
        com.a.c.b.c.b r0 = (com.a.c.b.c.b) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.b.class, "com.obric.aiagent.plugin");
        ArrayList r2 = new ArrayList();
        Iterator<com.a.c.b.c.e> r1 = r0.b().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        com.a.c.b.c.e r3 = (com.a.c.b.c.e) ZeusTransformUtils.preCheckCast(r1.next(), com.a.c.b.c.e.class, "com.obric.aiagent.plugin");
        r2.add(r9.apply(a(new com.a.c.b.a(this.f3156c.a(), r3, this.f3156c.c()))));
        goto L4
    L6:
        ArrayList r7 = new ArrayList();
        Iterator r10 = r2.iterator();
    L8:
        if (r10.hasNext() == false) goto L12;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r10.next(), Integer.class, "com.obric.aiagent.plugin");
        if (r4.intValue() < 0) goto L8;
        r7.add(r4);
        goto L8
    L12:
        Collections.sort(r7);
        return r7;
    }

    private h a(com.a.c.b.a r3) {
        com.a.c.b.c.e r2 = r3.b();
        if (ZeusTransformUtils.instanceOf(r2, com.a.c.b.c.a.class) == false) goto L7;
        return new a(r3);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, com.a.c.b.c.c.class) == false) goto L11;
        return new e(r3);
    L11:
        if (ZeusTransformUtils.instanceOf(r2, com.a.c.b.c.d.class) == false) goto L15;
        return new g(r3);
    L15:
        if (ZeusTransformUtils.instanceOf(r2, com.a.c.b.c.f.class) == false) goto L19;
        return new o(r3);
    L19:
        throw new IllegalArgumentException(String.format("FieldExpression %s not supported!", new Object[]{r2.getClass()}));
    }
}
