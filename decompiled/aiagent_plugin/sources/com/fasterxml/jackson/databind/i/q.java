package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ab;
import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: ObjectNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends f<q> implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Map<String, com.fasterxml.jackson.databind.n> f12795b;

    public q(l r1) {
        super(r1);
        this.f12795b = new LinkedHashMap();
    }

    @Override // com.fasterxml.jackson.databind.o.a
    public boolean a(ac r1) {
        return this.f12795b.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.n
    public Iterator<com.fasterxml.jackson.databind.n> c() {
        return this.f12795b.values().iterator();
    }

    @Override // com.fasterxml.jackson.databind.n
    public com.fasterxml.jackson.databind.n a(String r2) {
        return (com.fasterxml.jackson.databind.n) ZeusTransformUtils.preCheckCast(this.f12795b.get(r2), com.fasterxml.jackson.databind.n.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public void a(com.fasterxml.jackson.a.h r6, ac r7) {
        if (r7 != null) goto L4;
    L6:
        boolean r0 = false;
    L7:
        r6.c(this);
        Iterator<Map.Entry<String, com.fasterxml.jackson.databind.n>> r5 = this.f12795b.entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1.getValue(), b.class, "com.obric.aiagent.plugin");
        if (r0 == false) goto L17;
        if (r2.a() == false) goto L17;
        if (r2.a(r7) == true) goto L9;
    L17:
        r6.a((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"));
        r2.a(r6, r7);
        goto L9
    L18:
        r6.k();
        return;
    L4:
        if (r7.a(ab.t) == true) goto L6;
        r0 = true;
        goto L7
    }

    @Override // com.fasterxml.jackson.databind.o
    public void a(com.fasterxml.jackson.a.h r7, ac r8, com.fasterxml.jackson.databind.h.h r9) {
        if (r8 != null) goto L4;
    L6:
        boolean r0 = false;
    L7:
        com.fasterxml.jackson.a.g.b r1 = r9.a(r7, r9.a(this, com.fasterxml.jackson.a.n.f12152b));
        Iterator<Map.Entry<String, com.fasterxml.jackson.databind.n>> r6 = this.f12795b.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2.getValue(), b.class, "com.obric.aiagent.plugin");
        if (r0 == false) goto L17;
        if (r3.a() == false) goto L17;
        if (r3.a(r8) == true) goto L9;
    L17:
        r7.a((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"));
        r3.a(r7, r8);
        goto L9
    L18:
        r9.b(r7, r1);
        return;
    L4:
        if (r8.a(ab.t) == true) goto L6;
        r0 = true;
        goto L7
    }

    public <T extends com.fasterxml.jackson.databind.n> T a(String r2, com.fasterxml.jackson.databind.n r3) {
        if (r3 != null) goto L4;
        r3 = d();
    L4:
        this.f12795b.put(r2, r3);
        return this;
    }

    public com.fasterxml.jackson.databind.n b(String r1, com.fasterxml.jackson.databind.n r2) {
        if (r2 != null) goto L5;
        r2 = d();
    L5:
        return (com.fasterxml.jackson.databind.n) ZeusTransformUtils.preCheckCast(this.f12795b.put(r1, r2), com.fasterxml.jackson.databind.n.class, "com.obric.aiagent.plugin");
    }

    public boolean equals(Object r4) {
        if (r4 != this) goto L7;
        return true;
    L7:
        if (r4 != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, q.class) == true) goto L12;
        return false;
    L12:
        return a((q) ZeusTransformUtils.preCheckCast(r4, q.class, "com.obric.aiagent.plugin"));
    }

    public boolean a(q r1) {
        return this.f12795b.equals(r1.f12795b);
    }

    public int hashCode() {
        return this.f12795b.hashCode();
    }
}
