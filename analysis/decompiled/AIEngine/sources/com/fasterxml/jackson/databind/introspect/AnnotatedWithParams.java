package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class AnnotatedWithParams extends AnnotatedMember {

    /* renamed from: c, reason: collision with root package name */
    public final i3.c[] f4132c;

    public AnnotatedWithParams(i iVar, i3.c cVar, i3.c[] cVarArr) {
        super(iVar, cVar);
        this.f4132c = cVarArr;
    }

    public abstract Object o();

    public abstract Object p(Object[] objArr);

    public abstract Object q(Object obj);

    public final AnnotatedParameter r(int i10) {
        JavaType javaTypeT = t(i10);
        i3.c[] cVarArr = this.f4132c;
        return new AnnotatedParameter(this, javaTypeT, this.f4122a, (cVarArr == null || i10 < 0 || i10 >= cVarArr.length) ? null : cVarArr[i10], i10);
    }

    public abstract int s();

    public abstract JavaType t(int i10);

    public abstract Class<?> u(int i10);
}
