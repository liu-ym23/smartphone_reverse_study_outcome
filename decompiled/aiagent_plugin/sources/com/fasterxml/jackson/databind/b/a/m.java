package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ManagedReferenceProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends com.fasterxml.jackson.databind.b.v.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final String f12315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final boolean f12316e;
    protected final com.fasterxml.jackson.databind.b.v f;

    public m(com.fasterxml.jackson.databind.b.v r1, String r2, com.fasterxml.jackson.databind.b.v r3, boolean r4) {
        super(r1);
        this.f12315d = r2;
        this.f = r3;
        this.f12316e = r4;
    }

    @Override // com.fasterxml.jackson.databind.b.v.a
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.b.v r1) {
        throw new IllegalStateException("Should never try to reset delegate");
    }

    @Override // com.fasterxml.jackson.databind.b.v.a, com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.databind.g r2) {
        this.f12540c.a(r2);
        this.f.a(r2);
    }

    @Override // com.fasterxml.jackson.databind.b.v.a, com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, Object r4) {
        a(r4, this.f12540c.a(r2, r3));
    }

    @Override // com.fasterxml.jackson.databind.b.v.a, com.fasterxml.jackson.databind.b.v
    public Object b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Object r3) {
        return b(r3, a(r1, r2));
    }

    @Override // com.fasterxml.jackson.databind.b.v.a, com.fasterxml.jackson.databind.b.v
    public final void a(Object r1, Object r2) {
        b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.v.a, com.fasterxml.jackson.databind.b.v
    public Object b(Object r6, Object r7) {
        if (r7 == null) goto L33;
        if (this.f12316e == true) goto L6;
        this.f.a(r7, r6);
        goto L33
    L6:
        if ((r7 instanceof Object[]) == false) goto L14;
        Object[] r0 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r7, Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");
        int r1 = r0.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L33;
        Object r3 = r0[r2];
        if (r3 == null) goto L12;
        this.f.a(r3, r6);
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == false) goto L22;
        Iterator r4 = ((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).iterator();
    L17:
        if (r4.hasNext() == false) goto L33;
        Object r5 = r4.next();
        if (r5 == null) goto L17;
        this.f.a(r5, r6);
        goto L17
    L22:
        if (ZeusTransformUtils.instanceOf(r7, Map.class) == false) goto L30;
        Iterator r8 = ((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.aiagent.plugin")).values().iterator();
    L25:
        if (r8.hasNext() == false) goto L33;
        Object r9 = r8.next();
        if (r9 == null) goto L25;
        this.f.a(r9, r6);
        goto L25
    L30:
        throw new IllegalStateException("Unsupported container type (" + r7.getClass().getName() + ") when resolving reference '" + this.f12315d + "'");
    L33:
        return this.f12540c.b(r6, r7);
    }
}
