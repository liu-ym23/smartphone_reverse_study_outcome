package o3;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends f<Object> implements n3.c {

    /* renamed from: a, reason: collision with root package name */
    public final e f10749a;

    /* renamed from: b, reason: collision with root package name */
    public final f<Object> f10750b;

    public c(e eVar, f<?> fVar) {
        this.f10749a = eVar;
        this.f10750b = fVar;
    }

    @Override // n3.c
    public final f<?> a(h hVar, BeanProperty beanProperty) {
        f<?> fVar = this.f10750b;
        f<?> fVarB = fVar instanceof n3.c ? hVar.B(fVar, beanProperty) : fVar;
        return fVarB == fVar ? this : new c(this.f10749a, fVarB);
    }

    @Override // b3.f
    public final Class<Object> c() {
        return Object.class;
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        this.f10750b.g(obj, jsonGenerator, hVar, this.f10749a);
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        this.f10750b.g(obj, jsonGenerator, hVar, eVar);
    }
}
