package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ab;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.j.b.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: StringCollectionSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class o extends ac<Collection<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f12845a = null;

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.j.b.ac, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        a((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    static {
        f12845a = new o();
    }

    public o() {
        super(Collection.class);
    }

    public o(o r1, Boolean r2) {
        super(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.j.b.ac
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.d r3, Boolean r4) {
        com.fasterxml.jackson.databind.d r5 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        return new o(this, r4);
    }

    public void a(Collection<String> r4, com.fasterxml.jackson.a.h r5, com.fasterxml.jackson.databind.ac r6) {
        Collection<String> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        int r0 = r7.size();
        if (r0 == 1) goto L5;
    L12:
        r5.a(r7, r0);
        b(r7, r5, r6);
        r5.i();
        return;
    L5:
        if (this.f12868b != null) goto L9;
        if (r6.a(ab.u) == false) goto L9;
    L10:
        b(r7, r5, r6);
        return;
    L9:
        if (this.f12868b != Boolean.TRUE) goto L12;
        goto L10
    }

    @Override // com.fasterxml.jackson.databind.j.b.ac
    public void a(Collection<String> r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        Collection<String> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.a.g.b r0 = r6.a(r4, r6.a(r7, com.fasterxml.jackson.a.n.f12154d));
        r4.a(r7);
        b(r7, r4, r5);
        r6.b(r4, r0);
    }

    private final void b(Collection<String> r6, com.fasterxml.jackson.a.h r7, com.fasterxml.jackson.databind.ac r8) {
        Collection r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        Iterator r2 = r9.iterator();     // Catch: Exception -> L11
    L4:
        if (r2.hasNext() == false) goto L19;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L11
        if (r3 != null) goto L9;
        r8.a(r7);     // Catch: Exception -> L11
    L10:
        r0 = r0 + 1;
        goto L4
    L9:
        r7.b(r3);     // Catch: Exception -> L11
        goto L10
    L19:
        return;
    L11:
        e = move-exception;
        a(r8, e, r9, r0);
    }
}
