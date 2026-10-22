package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ab;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.j.b.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: IndexedStringListSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public final class f extends ac<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12806a = null;

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.j.b.ac, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.j.b.ac
    public /* synthetic */ void a(Collection r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        a((List) ZeusTransformUtils.preCheckCast((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin"), List.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    static {
        f12806a = new f();
    }

    public f() {
        super(List.class);
    }

    public f(f r1, Boolean r2) {
        super(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.j.b.ac
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.d r3, Boolean r4) {
        com.fasterxml.jackson.databind.d r5 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        return new f(this, r4);
    }

    public void a(List<String> r5, com.fasterxml.jackson.a.h r6, com.fasterxml.jackson.databind.ac r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        int r0 = r8.size();
        if (r0 == 1) goto L5;
    L12:
        r6.a(r8, r0);
        a(r8, r6, r7, r0);
        r6.i();
        return;
    L5:
        if (this.f12868b != null) goto L9;
        if (r7.a(ab.u) == false) goto L9;
    L10:
        a(r8, r6, r7, 1);
        return;
    L9:
        if (this.f12868b != Boolean.TRUE) goto L12;
        goto L10
    }

    public void a(List<String> r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.a.g.b r0 = r6.a(r4, r6.a(r7, com.fasterxml.jackson.a.n.f12154d));
        r4.a(r7);
        a(r7, r4, r5, r7.size());
        r6.b(r4, r0);
    }

    private final void a(List<String> r5, com.fasterxml.jackson.a.h r6, com.fasterxml.jackson.databind.ac r7, int r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L3:
        if (r0 >= r8) goto L17;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r9.get(r0), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
        if (r2 != null) goto L7;
        r7.a(r6);     // Catch: Exception -> L9
    L8:
        r0 = r0 + 1;
        goto L3
    L7:
        r6.b(r2);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        a(r7, e, r9, r0);
        return;
    }
}
