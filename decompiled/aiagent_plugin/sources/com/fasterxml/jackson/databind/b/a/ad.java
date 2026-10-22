package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: UnwrappedPropertyHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final List<com.fasterxml.jackson.databind.b.v> f12272a;

    public ad() {
        this.f12272a = new ArrayList();
    }

    public ad(List<com.fasterxml.jackson.databind.b.v> r3) {
        this.f12272a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public void a(com.fasterxml.jackson.databind.b.v r1) {
        this.f12272a.add(r1);
    }

    public ad a(com.fasterxml.jackson.databind.l.q r5) {
        ArrayList r0 = new ArrayList(this.f12272a.size());
        Iterator<com.fasterxml.jackson.databind.b.v> r4 = this.f12272a.iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        com.fasterxml.jackson.databind.b.v r1 = (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(r4.next(), com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b.v r2 = r1.a(r5.a(r1.a()));
        com.fasterxml.jackson.databind.l<Object> r3 = r2.o();
        if (r3 == null) goto L10;
        com.fasterxml.jackson.databind.l<Object> r6 = r3.a(r5);
        if (r6 == r3) goto L10;
        r2 = r2.a(r6);
    L10:
        r0.add(r2);
        goto L4
    L12:
        return new ad(r0);
    }

    public Object a(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6, Object r7, com.fasterxml.jackson.databind.l.y r8) {
        int r9 = this.f12272a.size();
        int r0 = 0;
    L3:
        if (r0 >= r9) goto L5;
        com.fasterxml.jackson.databind.b.v r1 = (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(this.f12272a.get(r0), com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.a.k r2 = r8.o();
        r2.g();
        r1.a(r2, r6, r7);
        r0 = r0 + 1;
        goto L3
    L5:
        return r7;
    }
}
