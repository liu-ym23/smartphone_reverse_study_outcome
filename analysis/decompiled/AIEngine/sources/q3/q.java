package q3;

import com.fasterxml.jackson.core.JsonLocation;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q extends v2.b {

    /* renamed from: c, reason: collision with root package name */
    public final v2.b f11605c;

    /* renamed from: d, reason: collision with root package name */
    public final JsonLocation f11606d;

    /* renamed from: e, reason: collision with root package name */
    public String f11607e;

    /* renamed from: f, reason: collision with root package name */
    public Object f11608f;

    public q() {
        super(0);
        this.f11605c = null;
        this.f11606d = JsonLocation.h;
    }

    @Override // v2.b
    public final String a() {
        return this.f11607e;
    }

    @Override // v2.b
    public final Object b() {
        return this.f11608f;
    }

    @Override // v2.b
    public final v2.b c() {
        return this.f11605c;
    }

    @Override // v2.b
    public final void g(Object obj) {
        this.f11608f = obj;
    }

    public q(q qVar, int i10) {
        super(i10);
        this.f11605c = qVar;
        this.f11606d = qVar.f11606d;
    }

    public q(v2.b bVar, JsonLocation jsonLocation) {
        this.f13375a = bVar.f13375a;
        this.f13376b = bVar.f13376b;
        this.f11605c = bVar.c();
        this.f11607e = bVar.a();
        this.f11608f = bVar.b();
        this.f11606d = jsonLocation;
    }
}
