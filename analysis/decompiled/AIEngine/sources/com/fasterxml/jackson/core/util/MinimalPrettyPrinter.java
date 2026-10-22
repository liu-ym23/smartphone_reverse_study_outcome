package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.Serializable;
import v2.d;
import y2.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MinimalPrettyPrinter implements d, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f3645a = d.f13378i.f3610a;

    /* renamed from: b, reason: collision with root package name */
    public final Separators f3646b = d.f13377g;

    @Override // v2.d
    public final void a(b bVar) {
        this.f3646b.getClass();
        bVar.T0(':');
    }

    @Override // v2.d
    public final void c(b bVar) {
        this.f3646b.getClass();
        bVar.T0(',');
    }

    @Override // v2.d
    public final void d(b bVar) {
        bVar.T0('{');
    }

    @Override // v2.d
    public final void e(b bVar, int i10) {
        bVar.T0(']');
    }

    @Override // v2.d
    public final void f(b bVar) {
        this.f3646b.getClass();
        bVar.T0(',');
    }

    @Override // v2.d
    public final void g(b bVar) {
        String str = this.f3645a;
        if (str != null) {
            bVar.U0(str);
        }
    }

    @Override // v2.d
    public final void i(b bVar, int i10) {
        bVar.T0('}');
    }

    @Override // v2.d
    public final void j(b bVar) {
        bVar.T0('[');
    }

    @Override // v2.d
    public final void b(JsonGenerator jsonGenerator) {
    }

    @Override // v2.d
    public final void h(b bVar) {
    }
}
