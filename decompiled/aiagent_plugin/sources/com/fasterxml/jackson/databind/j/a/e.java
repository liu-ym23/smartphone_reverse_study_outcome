package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ab;
import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: IndexedListSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public final class e extends com.fasterxml.jackson.databind.j.b.b<List<?>> {
    @Override // com.fasterxml.jackson.databind.j.b.b, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, ac r5) {
        a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(ac r3, Object r4) {
        return a(r3, (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public /* synthetic */ boolean a(Object r3) {
        return a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.b
    public /* synthetic */ com.fasterxml.jackson.databind.j.b.b<List<?>> b(com.fasterxml.jackson.databind.d r3, com.fasterxml.jackson.databind.h.h r4, com.fasterxml.jackson.databind.p r5, Boolean r6) {
        return a((com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.j.b.b
    public /* synthetic */ void b(List<?> r3, com.fasterxml.jackson.a.h r4, ac r5) {
        b2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public e(com.fasterxml.jackson.databind.k r7, boolean r8, com.fasterxml.jackson.databind.h.h r9, com.fasterxml.jackson.databind.p<Object> r10) {
        super(List.class, r7, r8, r9, r10);
    }

    public e(e r7, com.fasterxml.jackson.databind.d r8, com.fasterxml.jackson.databind.h.h r9, com.fasterxml.jackson.databind.p<?> r10, Boolean r11) {
        super(r7, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r9, r10, r11);
    }

    public e a(com.fasterxml.jackson.databind.d r7, com.fasterxml.jackson.databind.h.h r8, com.fasterxml.jackson.databind.p<?> r9, Boolean r10) {
        return new e(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r8, r9, r10);
    }

    public boolean a(ac r1, List<?> r2) {
        return ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin")).isEmpty();
    }

    public boolean a(List<?> r2) {
        if (((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin")).size() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public com.fasterxml.jackson.databind.j.i<?> b(com.fasterxml.jackson.databind.h.h r8) {
        return new e(this, this.f12889b, r8, this.f, this.f12891d);
    }

    public final void a(List<?> r4, com.fasterxml.jackson.a.h r5, ac r6) {
        List<?> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        int r0 = r7.size();
        if (r0 == 1) goto L5;
    L12:
        r5.a(r7, r0);
        b2(r7, r5, r6);
        r5.i();
        return;
    L5:
        if (this.f12891d != null) goto L9;
        if (r6.a(ab.u) == false) goto L9;
    L10:
        b2(r7, r5, r6);
        return;
    L9:
        if (this.f12891d != Boolean.TRUE) goto L12;
        goto L10
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public void b2(List<?> r7, com.fasterxml.jackson.a.h r8, ac r9) {
        List<?> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (this.f == null) goto L7;
        a(r10, r8, r9, this.f);
        return;
    L7:
        if (this.f12892e == null) goto L10;
        c(r10, r8, r9);
        return;
    L10:
        int r0 = r10.size();
        if (r0 != 0) goto L13;
        return;
    L13:
        int r1 = 0;
        k r2 = this.g;     // Catch: Exception -> L28
    L15:
        if (r1 >= r0) goto L36;
        Object r3 = r10.get(r1);     // Catch: Exception -> L28
        if (r3 != null) goto L19;
        r9.a(r8);     // Catch: Exception -> L28
    L27:
        r1 = r1 + 1;
        goto L15
    L19:
        Class<?> r4 = r3.getClass();     // Catch: Exception -> L28
        com.fasterxml.jackson.databind.p<Object> r5 = r2.a(r4);     // Catch: Exception -> L28
        if (r5 == null) goto L22;
    L26:
        r5.a(r3, r8, r9);     // Catch: Exception -> L28
        goto L27
    L22:
        if (this.f12888a.v() == false) goto L24;
        com.fasterxml.jackson.databind.p<Object> r6 = a(r2, r9.a(this.f12888a, r4), r9);     // Catch: Exception -> L28
    L25:
        r5 = r6;
        r2 = this.g;     // Catch: Exception -> L28
        goto L26
    L24:
        r6 = a(r2, r4, r9);     // Catch: Exception -> L28
        goto L25
    L36:
        return;
    L28:
        e = move-exception;
        a(r9, e, r10, r1);
    }

    public void a(List<?> r5, com.fasterxml.jackson.a.h r6, ac r7, com.fasterxml.jackson.databind.p<Object> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        int r0 = r9.size();
        if (r0 != 0) goto L5;
        return;
    L5:
        com.fasterxml.jackson.databind.h.h r1 = this.f12892e;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L18;
        Object r3 = r9.get(r2);
        if (r3 == null) goto L19;
        if (r1 != null) goto L14;
        r8.a(r3, r6, r7);     // Catch: Exception -> L10
    L17:
        r2 = r2 + 1;
        goto L6
    L14:
        r8.a(r3, r6, r7, r1);     // Catch: Exception -> L10
        goto L17
    L19:
        r7.a(r6);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        a(r7, e, r9, r2);
        goto L17
    }

    public void c(List<?> r8, com.fasterxml.jackson.a.h r9, ac r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        int r0 = r11.size();
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = 0;
        com.fasterxml.jackson.databind.h.h r2 = this.f12892e;     // Catch: Exception -> L20
        k r3 = this.g;     // Catch: Exception -> L20
    L7:
        if (r1 >= r0) goto L28;
        Object r4 = r11.get(r1);     // Catch: Exception -> L20
        if (r4 != null) goto L11;
        r10.a(r9);     // Catch: Exception -> L20
    L19:
        r1 = r1 + 1;
        goto L7
    L11:
        Class<?> r5 = r4.getClass();     // Catch: Exception -> L20
        com.fasterxml.jackson.databind.p<Object> r6 = r3.a(r5);     // Catch: Exception -> L20
        if (r6 == null) goto L14;
    L18:
        r6.a(r4, r9, r10, r2);     // Catch: Exception -> L20
        goto L19
    L14:
        if (this.f12888a.v() == false) goto L16;
        com.fasterxml.jackson.databind.p<Object> r7 = a(r3, r10.a(this.f12888a, r5), r10);     // Catch: Exception -> L20
    L17:
        r6 = r7;
        r3 = this.g;     // Catch: Exception -> L20
        goto L18
    L16:
        r7 = a(r3, r5, r10);     // Catch: Exception -> L20
        goto L17
    L28:
        return;
    L20:
        e = move-exception;
        a(r10, e, r11, r1);
    }
}
