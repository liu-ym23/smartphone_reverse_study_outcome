package com.a.c.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: FieldValueGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.a.c.b.a f3156c;

    public abstract int a(int r1);

    public abstract List<Integer> a(int r1, int r2);

    public abstract boolean a(com.a.c.b.c.e r1);

    public abstract boolean b(int r1);

    public h(com.a.c.b.a r4) {
        this.f3156c = (com.a.c.b.a) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r4, "CronField must not be null"), com.a.c.b.a.class, "com.obric.aiagent.plugin");
        com.a.e.a.a(a(r4.b()), "FieldExpression does not match required class");
    }

    public final List<Integer> b(int r3, int r4) {
        List<Integer> r0 = a(r3, r4);
        if (b(r3) == false) goto L6;
        r0.add(Integer.valueOf(r3));
    L6:
        if (b(r4) == false) goto L8;
        r0.add(Integer.valueOf(r4));
    L8:
        LinkedList r2 = new LinkedList(new HashSet(r0));
        Collections.sort(r2);
        return r2;
    }
}
