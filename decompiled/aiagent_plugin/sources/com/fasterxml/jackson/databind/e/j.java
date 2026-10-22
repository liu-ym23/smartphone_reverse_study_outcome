package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;

/* JADX INFO: compiled from: AnnotatedMember.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends b implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final transient ag f12632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final transient q f12633c;

    public abstract void a(Object r1, Object r2);

    public abstract b b(q r1);

    public abstract Object b(Object r1);

    public abstract Class<?> f();

    public abstract Member g();

    public j(ag r3, q r4) {
        this.f12632b = (ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin");
        this.f12633c = r4;
    }

    public String i() {
        return f().getName() + "#" + b();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public final <A extends Annotation> A a(Class<A> r1) {
        q r0 = this.f12633c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (A) r0.a(r1);
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public final boolean b(Class<?> r1) {
        q r0 = this.f12633c;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b(r1);
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public boolean a(Class<? extends Annotation>[] r1) {
        q r0 = this.f12633c;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r1);
    }

    public q j() {
        return this.f12633c;
    }

    public final void a(boolean r1) {
        Member r0 = g();
        if (r0 == null) goto L6;
        com.fasterxml.jackson.databind.l.h.a(r0, r1);
        return;
    }
}
