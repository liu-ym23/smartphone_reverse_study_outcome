package y2;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.Closeable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends v2.b {

    /* renamed from: c, reason: collision with root package name */
    public final d f13985c;

    /* renamed from: d, reason: collision with root package name */
    public androidx.coordinatorlayout.widget.a f13986d;

    /* renamed from: e, reason: collision with root package name */
    public d f13987e;

    /* renamed from: f, reason: collision with root package name */
    public String f13988f;

    /* renamed from: g, reason: collision with root package name */
    public Object f13989g;
    public boolean h;

    public d(int i10, d dVar, androidx.coordinatorlayout.widget.a aVar) {
        this.f13375a = i10;
        this.f13985c = dVar;
        this.f13986d = aVar;
        this.f13376b = -1;
    }

    @Override // v2.b
    public final String a() {
        return this.f13988f;
    }

    @Override // v2.b
    public final Object b() {
        return this.f13989g;
    }

    @Override // v2.b
    public final v2.b c() {
        return this.f13985c;
    }

    @Override // v2.b
    public final void g(Object obj) {
        this.f13989g = obj;
    }

    public final d i() {
        d dVar = this.f13987e;
        if (dVar == null) {
            androidx.coordinatorlayout.widget.a aVar = this.f13986d;
            d dVar2 = new d(1, this, aVar != null ? aVar.a() : null);
            this.f13987e = dVar2;
            return dVar2;
        }
        dVar.f13375a = 1;
        dVar.f13376b = -1;
        dVar.f13988f = null;
        dVar.h = false;
        dVar.f13989g = null;
        androidx.coordinatorlayout.widget.a aVar2 = dVar.f13986d;
        if (aVar2 != null) {
            aVar2.f1475c = null;
            aVar2.f1476d = null;
            aVar2.f1473a = null;
        }
        return dVar;
    }

    public final d j(Object obj) {
        d dVar = this.f13987e;
        if (dVar == null) {
            androidx.coordinatorlayout.widget.a aVar = this.f13986d;
            d dVar2 = new d(1, this, aVar != null ? aVar.a() : null, obj);
            this.f13987e = dVar2;
            return dVar2;
        }
        dVar.f13375a = 1;
        dVar.f13376b = -1;
        dVar.f13988f = null;
        dVar.h = false;
        dVar.f13989g = obj;
        androidx.coordinatorlayout.widget.a aVar2 = dVar.f13986d;
        if (aVar2 != null) {
            aVar2.f1475c = null;
            aVar2.f1476d = null;
            aVar2.f1473a = null;
        }
        return dVar;
    }

    public final d k() {
        d dVar = this.f13987e;
        if (dVar == null) {
            androidx.coordinatorlayout.widget.a aVar = this.f13986d;
            d dVar2 = new d(2, this, aVar != null ? aVar.a() : null);
            this.f13987e = dVar2;
            return dVar2;
        }
        dVar.f13375a = 2;
        dVar.f13376b = -1;
        dVar.f13988f = null;
        dVar.h = false;
        dVar.f13989g = null;
        androidx.coordinatorlayout.widget.a aVar2 = dVar.f13986d;
        if (aVar2 != null) {
            aVar2.f1475c = null;
            aVar2.f1476d = null;
            aVar2.f1473a = null;
        }
        return dVar;
    }

    public final d l(Object obj) {
        d dVar = this.f13987e;
        if (dVar == null) {
            androidx.coordinatorlayout.widget.a aVar = this.f13986d;
            d dVar2 = new d(2, this, aVar != null ? aVar.a() : null, obj);
            this.f13987e = dVar2;
            return dVar2;
        }
        dVar.f13375a = 2;
        dVar.f13376b = -1;
        dVar.f13988f = null;
        dVar.h = false;
        dVar.f13989g = obj;
        androidx.coordinatorlayout.widget.a aVar2 = dVar.f13986d;
        if (aVar2 != null) {
            aVar2.f1475c = null;
            aVar2.f1476d = null;
            aVar2.f1473a = null;
        }
        return dVar;
    }

    public final int m(String str) throws JsonGenerationException {
        if (this.f13375a != 2 || this.h) {
            return 4;
        }
        this.h = true;
        this.f13988f = str;
        androidx.coordinatorlayout.widget.a aVar = this.f13986d;
        if (aVar == null || !aVar.c(str)) {
            return this.f13376b < 0 ? 0 : 1;
        }
        Closeable closeable = (Closeable) aVar.f1474b;
        throw new JsonGenerationException(a0.a.k("Duplicate field '", str, "'"), closeable instanceof JsonGenerator ? (JsonGenerator) closeable : null);
    }

    public final int n() {
        int i10 = this.f13375a;
        if (i10 == 2) {
            if (!this.h) {
                return 5;
            }
            this.h = false;
            this.f13376b++;
            return 2;
        }
        if (i10 == 1) {
            int i11 = this.f13376b;
            this.f13376b = i11 + 1;
            if (i11 >= 0) {
                return 1;
            }
        } else {
            int i12 = this.f13376b + 1;
            this.f13376b = i12;
            if (i12 != 0) {
                return 3;
            }
        }
        return 0;
    }

    public d(int i10, d dVar, androidx.coordinatorlayout.widget.a aVar, Object obj) {
        this.f13375a = i10;
        this.f13985c = dVar;
        this.f13986d = aVar;
        this.f13376b = -1;
        this.f13989g = obj;
    }
}
