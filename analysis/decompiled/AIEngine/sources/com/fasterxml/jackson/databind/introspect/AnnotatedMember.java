package com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class AnnotatedMember extends i3.a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final transient i f4122a;

    /* renamed from: b, reason: collision with root package name */
    public final transient i3.c f4123b;

    public AnnotatedMember(i iVar, i3.c cVar) {
        this.f4122a = iVar;
        this.f4123b = cVar;
    }

    @Override // i3.a
    public final <A extends Annotation> A c(Class<A> cls) {
        i3.c cVar = this.f4123b;
        if (cVar == null) {
            return null;
        }
        return (A) cVar.a(cls);
    }

    public final void g(boolean z) {
        Member memberJ = j();
        if (memberJ != null) {
            com.fasterxml.jackson.databind.util.a.e(memberJ, z);
        }
    }

    public abstract Class<?> h();

    public String i() {
        return h().getName() + "#" + d();
    }

    public abstract Member j();

    public abstract Object k(Object obj);

    public final boolean l(Class<?> cls) {
        HashMap map;
        i3.c cVar = this.f4123b;
        if (cVar == null || (map = cVar.f9494b) == null) {
            return false;
        }
        return map.containsKey(cls);
    }

    public final boolean m(Class<? extends Annotation>[] clsArr) {
        i3.c cVar = this.f4123b;
        if (cVar == null || cVar.f9494b == null) {
            return false;
        }
        for (Class<? extends Annotation> cls : clsArr) {
            if (cVar.f9494b.containsKey(cls)) {
                return true;
            }
        }
        return false;
    }

    public abstract i3.a n(i3.c cVar);
}
