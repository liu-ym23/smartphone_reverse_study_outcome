package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ab;
import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Set;

/* JADX INFO: compiled from: UnwrappingBeanSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends com.fasterxml.jackson.databind.j.b.d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l.q f12850a;

    @Override // com.fasterxml.jackson.databind.p
    public boolean c() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d d() {
        return this;
    }

    public t(com.fasterxml.jackson.databind.j.b.d r1, com.fasterxml.jackson.databind.l.q r2) {
        super(r1, r2);
        this.f12850a = r2;
    }

    public t(t r1, i r2) {
        super(r1, r2);
        this.f12850a = r1.f12850a;
    }

    public t(t r1, i r2, Object r3) {
        super(r1, r2, r3);
        this.f12850a = r1.f12850a;
    }

    public t(t r3, Set<String> r4, Set<String> r5) {
        super(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin"));
        this.f12850a = r3.f12850a;
    }

    public t(t r1, com.fasterxml.jackson.databind.j.d[] r2, com.fasterxml.jackson.databind.j.d[] r3) {
        super(r1, r2, r3);
        this.f12850a = r1.f12850a;
    }

    @Override // com.fasterxml.jackson.databind.p
    public com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.l.q r2) {
        return new t(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d a(i r2) {
        return new t(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d a(Object r3) {
        return new t(this, this.j, r3);
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d a(Set<String> r3, Set<String> r4) {
        return new t(this, (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d a(com.fasterxml.jackson.databind.j.d[] r2, com.fasterxml.jackson.databind.j.d[] r3) {
        return new t(this, r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public final void a(Object r2, com.fasterxml.jackson.a.h r3, ac r4) {
        r3.a(r2);
        if (this.j == null) goto L7;
        a(r2, r3, r4, false);
        return;
    L7:
        if (this.h == null) goto L9;
        d(r2, r3, r4);
        return;
    L9:
        c(r2, r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.j.b.d, com.fasterxml.jackson.databind.p
    public void a(Object r3, com.fasterxml.jackson.a.h r4, ac r5, com.fasterxml.jackson.databind.h.h r6) {
        if (r5.a(ab.f) == false) goto L5;
        r5.a(a(), "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
    L5:
        r4.a(r3);
        if (this.j == null) goto L10;
        b(r3, r4, r5, r6);
        return;
    L10:
        if (this.h == null) goto L12;
        d(r3, r4, r5);
        return;
    L12:
        c(r3, r4, r5);
    }

    public String toString() {
        return "UnwrappingBeanSerializer for " + a().getName();
    }
}
