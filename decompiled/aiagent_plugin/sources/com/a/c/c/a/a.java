package com.a.c.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AlwaysFieldValueGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class a extends h {
    public a(com.a.c.b.a r1) {
        super(r1);
    }

    @Override // com.a.c.c.a.h
    public int a(int r1) {
        int r2 = r1 + 1;
        if (r2 > this.f3156c.c().b()) goto L6;
        return r2;
    L6:
        throw new j();
    }

    @Override // com.a.c.c.a.h
    public List<Integer> a(int r2, int r3) {
        ArrayList r1 = new ArrayList();
    L3:
        r2 = r2 + 1;
        if (r2 >= r3) goto L6;
        r1.add(Integer.valueOf(r2));
        goto L3
    L6:
        return r1;
    }

    @Override // com.a.c.c.a.h
    public boolean b(int r3) {
        if (this.f3156c.a() != com.a.c.b.b.f) goto L5;
    L8:
        return true;
    L5:
        if (this.f3156c.c().a(r3) == true) goto L8;
        return false;
    }

    @Override // com.a.c.c.a.h
    public boolean a(com.a.c.b.c.e r1) {
        return ZeusTransformUtils.instanceOf(r1, com.a.c.b.c.a.class);
    }
}
