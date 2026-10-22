package y2;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import java.io.Closeable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends v2.b {

    /* renamed from: c, reason: collision with root package name */
    public final c f13979c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.coordinatorlayout.widget.a f13980d;

    /* renamed from: e, reason: collision with root package name */
    public c f13981e;

    /* renamed from: f, reason: collision with root package name */
    public String f13982f;

    /* renamed from: g, reason: collision with root package name */
    public Object f13983g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f13984i;

    public c(c cVar, androidx.coordinatorlayout.widget.a aVar, int i10, int i11, int i12) {
        this.f13979c = cVar;
        this.f13980d = aVar;
        this.f13375a = i10;
        this.h = i11;
        this.f13984i = i12;
        this.f13376b = -1;
    }

    @Override // v2.b
    public final String a() {
        return this.f13982f;
    }

    @Override // v2.b
    public final Object b() {
        return this.f13983g;
    }

    @Override // v2.b
    public final v2.b c() {
        return this.f13979c;
    }

    @Override // v2.b
    public final void g(Object obj) {
        this.f13983g = obj;
    }

    public final c i(int i10, int i11) {
        c cVar = this.f13981e;
        if (cVar == null) {
            androidx.coordinatorlayout.widget.a aVar = this.f13980d;
            c cVar2 = new c(this, aVar != null ? aVar.a() : null, 1, i10, i11);
            this.f13981e = cVar2;
            return cVar2;
        }
        cVar.f13375a = 1;
        cVar.f13376b = -1;
        cVar.h = i10;
        cVar.f13984i = i11;
        cVar.f13982f = null;
        cVar.f13983g = null;
        androidx.coordinatorlayout.widget.a aVar2 = cVar.f13980d;
        if (aVar2 != null) {
            aVar2.f1475c = null;
            aVar2.f1476d = null;
            aVar2.f1473a = null;
        }
        return cVar;
    }

    public final c j(int i10, int i11) {
        c cVar = this.f13981e;
        if (cVar == null) {
            androidx.coordinatorlayout.widget.a aVar = this.f13980d;
            c cVar2 = new c(this, aVar != null ? aVar.a() : null, 2, i10, i11);
            this.f13981e = cVar2;
            return cVar2;
        }
        cVar.f13375a = 2;
        cVar.f13376b = -1;
        cVar.h = i10;
        cVar.f13984i = i11;
        cVar.f13982f = null;
        cVar.f13983g = null;
        androidx.coordinatorlayout.widget.a aVar2 = cVar.f13980d;
        if (aVar2 != null) {
            aVar2.f1475c = null;
            aVar2.f1476d = null;
            aVar2.f1473a = null;
        }
        return cVar;
    }

    public final boolean k() {
        int i10 = this.f13376b + 1;
        this.f13376b = i10;
        return this.f13375a != 0 && i10 > 0;
    }

    public final void l(String str) {
        this.f13982f = str;
        androidx.coordinatorlayout.widget.a aVar = this.f13980d;
        if (aVar == null || !aVar.c(str)) {
            return;
        }
        Closeable closeable = (Closeable) aVar.f1474b;
        throw new JsonParseException(closeable instanceof JsonParser ? (JsonParser) closeable : null, a0.a.k("Duplicate field '", str, "'"));
    }
}
