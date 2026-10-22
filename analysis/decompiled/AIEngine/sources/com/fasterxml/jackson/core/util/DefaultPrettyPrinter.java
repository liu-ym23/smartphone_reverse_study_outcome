package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import java.io.Serializable;
import v2.d;
import v2.e;
import y2.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DefaultPrettyPrinter implements d, a3.d<DefaultPrettyPrinter>, Serializable {

    /* renamed from: k, reason: collision with root package name */
    public static final SerializedString f3635k = new SerializedString(" ");

    /* renamed from: a, reason: collision with root package name */
    public final a f3636a;

    /* renamed from: b, reason: collision with root package name */
    public final a f3637b;

    /* renamed from: c, reason: collision with root package name */
    public final e f3638c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3639d;

    /* renamed from: e, reason: collision with root package name */
    public transient int f3640e;
    public final Separators h;

    /* renamed from: j, reason: collision with root package name */
    public final String f3641j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class FixedSpaceIndenter extends NopIndenter {

        /* renamed from: a, reason: collision with root package name */
        public static final FixedSpaceIndenter f3642a = new FixedSpaceIndenter();

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter, com.fasterxml.jackson.core.util.DefaultPrettyPrinter.a
        public final void a(JsonGenerator jsonGenerator, int i10) {
            jsonGenerator.T0(' ');
        }

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter, com.fasterxml.jackson.core.util.DefaultPrettyPrinter.a
        public final boolean isInline() {
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void a(JsonGenerator jsonGenerator, int i10);

        boolean isInline();
    }

    public DefaultPrettyPrinter() {
        this.f3636a = FixedSpaceIndenter.f3642a;
        this.f3637b = DefaultIndenter.f3631d;
        this.f3639d = true;
        this.f3638c = f3635k;
        Separators separators = d.f13377g;
        this.h = separators;
        separators.getClass();
        this.f3641j = " : ";
    }

    @Override // v2.d
    public final void a(b bVar) {
        if (this.f3639d) {
            bVar.U0(this.f3641j);
        } else {
            this.h.getClass();
            bVar.T0(':');
        }
    }

    @Override // v2.d
    public final void b(JsonGenerator jsonGenerator) {
        this.f3637b.a(jsonGenerator, this.f3640e);
    }

    @Override // v2.d
    public final void c(b bVar) {
        this.h.getClass();
        bVar.T0(',');
        this.f3637b.a(bVar, this.f3640e);
    }

    @Override // v2.d
    public final void d(b bVar) {
        bVar.T0('{');
        if (this.f3637b.isInline()) {
            return;
        }
        this.f3640e++;
    }

    @Override // v2.d
    public final void e(b bVar, int i10) {
        a aVar = this.f3636a;
        if (!aVar.isInline()) {
            this.f3640e--;
        }
        if (i10 > 0) {
            aVar.a(bVar, this.f3640e);
        } else {
            bVar.T0(' ');
        }
        bVar.T0(']');
    }

    @Override // v2.d
    public final void f(b bVar) {
        this.h.getClass();
        bVar.T0(',');
        this.f3636a.a(bVar, this.f3640e);
    }

    @Override // v2.d
    public final void g(b bVar) {
        e eVar = this.f3638c;
        if (eVar != null) {
            bVar.V0(eVar);
        }
    }

    @Override // v2.d
    public final void h(b bVar) {
        this.f3636a.a(bVar, this.f3640e);
    }

    @Override // v2.d
    public final void i(b bVar, int i10) {
        a aVar = this.f3637b;
        if (!aVar.isInline()) {
            this.f3640e--;
        }
        if (i10 > 0) {
            aVar.a(bVar, this.f3640e);
        } else {
            bVar.T0(' ');
        }
        bVar.T0('}');
    }

    @Override // v2.d
    public final void j(b bVar) {
        if (!this.f3636a.isInline()) {
            this.f3640e++;
        }
        bVar.T0('[');
    }

    @Override // a3.d
    public final DefaultPrettyPrinter k() {
        if (getClass() == DefaultPrettyPrinter.class) {
            return new DefaultPrettyPrinter(this);
        }
        throw new IllegalStateException("Failed `createInstance()`: " + getClass().getName() + " does not override method; it has to");
    }

    public DefaultPrettyPrinter(DefaultPrettyPrinter defaultPrettyPrinter) {
        e eVar = defaultPrettyPrinter.f3638c;
        this.f3636a = FixedSpaceIndenter.f3642a;
        this.f3637b = DefaultIndenter.f3631d;
        this.f3639d = true;
        this.f3636a = defaultPrettyPrinter.f3636a;
        this.f3637b = defaultPrettyPrinter.f3637b;
        this.f3639d = defaultPrettyPrinter.f3639d;
        this.f3640e = defaultPrettyPrinter.f3640e;
        this.h = defaultPrettyPrinter.h;
        this.f3641j = defaultPrettyPrinter.f3641j;
        this.f3638c = eVar;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class NopIndenter implements a, Serializable {
        static {
            new NopIndenter();
        }

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.a
        public boolean isInline() {
            return !(this instanceof DefaultIndenter);
        }

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.a
        public void a(JsonGenerator jsonGenerator, int i10) {
        }
    }
}
