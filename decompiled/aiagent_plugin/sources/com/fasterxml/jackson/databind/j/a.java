package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.databind.aa;
import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.j.b.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: AnyGetterWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.d f12800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.j f12801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.p<Object> f12802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected u f12803d;

    public a(com.fasterxml.jackson.databind.d r3, com.fasterxml.jackson.databind.e.j r4, com.fasterxml.jackson.databind.p<?> r5) {
        com.fasterxml.jackson.databind.d r6 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        this.f12801b = r4;
        this.f12800a = r6;
        this.f12802c = r5;
        if (ZeusTransformUtils.instanceOf(r5, u.class) == false) goto L6;
        this.f12803d = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin");
        return;
    }

    public void a(aa r2) {
        this.f12801b.a(r2.a(com.fasterxml.jackson.databind.r.o));
    }

    public void a(Object r5, com.fasterxml.jackson.a.h r6, ac r7) {
        Object r8 = this.f12801b.b(r5);
        if (r8 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, Map.class) == true) goto L8;
        r7.b(this.f12800a.getType(), String.format("Value returned by 'any-getter' %s() not java.util.Map but %s", new Object[]{this.f12801b.b(), r8.getClass().getName()}));
    L8:
        u r0 = this.f12803d;
        if (r0 == null) goto L12;
        r0.b((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin"), r6, r7);
        return;
    L12:
        this.f12802c.a(r8, r6, r7);
    }

    public void a(Object r10, com.fasterxml.jackson.a.h r11, ac r12, n r13) {
        n r7 = (n) ZeusTransformUtils.wrapperContextForParams(r13, n.class, "com.obric.aiagent.plugin");
        Object r14 = this.f12801b.b(r10);
        if (r14 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r14, Map.class) == true) goto L8;
        r12.b(this.f12800a.getType(), String.format("Value returned by 'any-getter' (%s()) not java.util.Map but %s", new Object[]{this.f12801b.b(), r14.getClass().getName()}));
    L8:
        u r2 = this.f12803d;
        if (r2 == null) goto L12;
        r2.a(r12, r11, r10, (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin"), r7, null);
        return;
    L12:
        this.f12802c.a(r14, r11, r12);
    }

    public void a(ac r3) {
        if (ZeusTransformUtils.instanceOf(this.f12802c, j.class) == false) goto L8;
        com.fasterxml.jackson.databind.p<?> r4 = r3.a(this.f12802c, this.f12800a);
        this.f12802c = r4;
        if (ZeusTransformUtils.instanceOf(r4, u.class) == false) goto L9;
        this.f12803d = (u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.aiagent.plugin");
        return;
    L9:
        return;
    }
}
