package xd;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import xd.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends f.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f13779a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: xd.a$a, reason: collision with other inner class name */
    public static final class C0171a implements xd.f<ad.t, ad.t> {

        /* renamed from: g, reason: collision with root package name */
        public static final C0171a f13780g = new C0171a();

        @Override // xd.f
        public final ad.t a(ad.t tVar) {
            ad.t tVar2 = tVar;
            try {
                sd.e eVar = new sd.e();
                tVar2.w().d0(eVar);
                return new bd.g(tVar2.o(), tVar2.a(), eVar);
            } finally {
                tVar2.close();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements xd.f<ad.s, ad.s> {

        /* renamed from: g, reason: collision with root package name */
        public static final b f13781g = new b();

        @Override // xd.f
        public final ad.s a(ad.s sVar) {
            return sVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c implements xd.f<ad.t, ad.t> {

        /* renamed from: g, reason: collision with root package name */
        public static final c f13782g = new c();

        @Override // xd.f
        public final ad.t a(ad.t tVar) {
            return tVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d implements xd.f<Object, String> {

        /* renamed from: g, reason: collision with root package name */
        public static final d f13783g = new d();

        @Override // xd.f
        public final String a(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e implements xd.f<ad.t, lb.n> {

        /* renamed from: g, reason: collision with root package name */
        public static final e f13784g = new e();

        @Override // xd.f
        public final lb.n a(ad.t tVar) {
            tVar.close();
            return lb.n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class f implements xd.f<ad.t, Void> {

        /* renamed from: g, reason: collision with root package name */
        public static final f f13785g = new f();

        @Override // xd.f
        public final Void a(ad.t tVar) {
            tVar.close();
            return null;
        }
    }

    @Override // xd.f.a
    public final xd.f a(Type type) {
        if (ad.s.class.isAssignableFrom(retrofit2.b.e(type))) {
            return b.f13781g;
        }
        return null;
    }

    @Override // xd.f.a
    public final xd.f<ad.t, ?> b(Type type, Annotation[] annotationArr, t tVar) {
        if (type == ad.t.class) {
            return retrofit2.b.h(annotationArr, zd.w.class) ? c.f13782g : C0171a.f13780g;
        }
        if (type == Void.class) {
            return f.f13785g;
        }
        if (!this.f13779a || type != lb.n.class) {
            return null;
        }
        try {
            return e.f13784g;
        } catch (NoClassDefFoundError unused) {
            this.f13779a = false;
            return null;
        }
    }
}
