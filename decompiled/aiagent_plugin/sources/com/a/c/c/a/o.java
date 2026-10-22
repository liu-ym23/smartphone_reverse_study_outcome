package com.a.c.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: OnFieldValueGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class o extends h {
    public o(com.a.c.b.a r1) {
        super(r1);
    }

    @Override // com.a.c.c.a.h
    public int a(int r3) {
        int r2 = ((com.a.c.b.c.f) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.f.class, "com.obric.aiagent.plugin")).b().b().intValue();
        if (r2 <= r3) goto L6;
        return r2;
    L6:
        throw new j();
    }

    @Override // com.a.c.c.a.h
    public List<Integer> a(int r4, int r5) {
        ArrayList r0 = new ArrayList();
        int r3 = ((com.a.c.b.c.f) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.f.class, "com.obric.aiagent.plugin")).b().b().intValue();
        if (r3 <= r4) goto L6;
        if (r3 >= r5) goto L6;
        r0.add(Integer.valueOf(r3));
    L6:
        return r0;
    }

    @Override // com.a.c.c.a.h
    public boolean b(int r3) {
        if (((com.a.c.b.c.f) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.f.class, "com.obric.aiagent.plugin")).b().b().intValue() != r3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.a.c.c.a.h
    public boolean a(com.a.c.b.c.e r1) {
        return ZeusTransformUtils.instanceOf(r1, com.a.c.b.c.f.class);
    }
}
