package okhttp3;

import ad.s;
import gc.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import mb.m;
import okhttp3.f;
import okhttp3.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final g f10992a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10993b;

    /* renamed from: c, reason: collision with root package name */
    public final f f10994c;

    /* renamed from: d, reason: collision with root package name */
    public final s f10995d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<ec.c<?>, Object> f10996e;

    /* renamed from: f, reason: collision with root package name */
    public b f10997f;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public g f10998a;

        /* renamed from: d, reason: collision with root package name */
        public s f11001d;

        /* renamed from: e, reason: collision with root package name */
        public Object f11002e = kotlin.collections.b.d0();

        /* renamed from: b, reason: collision with root package name */
        public String f10999b = "GET";

        /* renamed from: c, reason: collision with root package name */
        public f.a f11000c = new f.a();

        public final void a(String name, String value) {
            kotlin.jvm.internal.g.f(name, "name");
            kotlin.jvm.internal.g.f(value, "value");
            this.f11000c.a(name, value);
        }

        public final void b(String name, String value) {
            kotlin.jvm.internal.g.f(name, "name");
            kotlin.jvm.internal.g.f(value, "value");
            f.a aVar = this.f11000c;
            aVar.getClass();
            bd.b.b(name);
            bd.b.c(value, name);
            aVar.c(name);
            bd.b.a(aVar, name, value);
        }

        public final void c(String method, s sVar) {
            kotlin.jvm.internal.g.f(method, "method");
            if (method.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (sVar == null) {
                if (method.equals("POST") || method.equals("PUT") || method.equals("PATCH") || method.equals("PROPPATCH") || method.equals("REPORT")) {
                    throw new IllegalArgumentException(a0.a.k("method ", method, " must have a request body.").toString());
                }
            } else if (!a4.a.s(method)) {
                throw new IllegalArgumentException(a0.a.k("method ", method, " must not have a request body.").toString());
            }
            this.f10999b = method;
            this.f11001d = sVar;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.Map] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.util.Map] */
        public final void d(Class type, Object obj) {
            Map mapB;
            kotlin.jvm.internal.g.f(type, "type");
            kotlin.jvm.internal.c cVarA = i.a(type);
            if (obj == null) {
                if (this.f11002e.isEmpty()) {
                    return;
                }
                Object obj2 = this.f11002e;
                kotlin.jvm.internal.g.d(obj2, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.reflect.KClass<*>, kotlin.Any>");
                k.b(obj2).remove(cVarA);
                return;
            }
            if (this.f11002e.isEmpty()) {
                mapB = new LinkedHashMap();
                this.f11002e = mapB;
            } else {
                Object obj3 = this.f11002e;
                kotlin.jvm.internal.g.d(obj3, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.reflect.KClass<*>, kotlin.Any>");
                mapB = k.b(obj3);
            }
            mapB.put(cVarA, obj);
        }

        public final void e(String url) {
            kotlin.jvm.internal.g.f(url, "url");
            if (o.k0(url, "ws:", true)) {
                String strSubstring = url.substring(3);
                kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
                url = "http:".concat(strSubstring);
            } else if (o.k0(url, "wss:", true)) {
                String strSubstring2 = url.substring(4);
                kotlin.jvm.internal.g.e(strSubstring2, "substring(...)");
                url = "https:".concat(strSubstring2);
            }
            kotlin.jvm.internal.g.f(url, "<this>");
            g.a aVar = new g.a();
            aVar.d(null, url);
            this.f10998a = aVar.b();
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, java.util.Map] */
    public h(a builder) {
        kotlin.jvm.internal.g.f(builder, "builder");
        g gVar = builder.f10998a;
        if (gVar == null) {
            throw new IllegalStateException("url == null");
        }
        this.f10992a = gVar;
        this.f10993b = builder.f10999b;
        this.f10994c = builder.f11000c.b();
        this.f10995d = builder.f11001d;
        this.f10996e = kotlin.collections.b.n0(builder.f11002e);
    }

    public final String a(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        return this.f10994c.a(name);
    }

    public final a b() {
        a aVar = new a();
        aVar.f11002e = kotlin.collections.b.d0();
        aVar.f10998a = this.f10992a;
        aVar.f10999b = this.f10993b;
        aVar.f11001d = this.f10995d;
        Map<ec.c<?>, Object> map = this.f10996e;
        aVar.f11002e = map.isEmpty() ? kotlin.collections.b.d0() : kotlin.collections.b.o0(map);
        aVar.f11000c = this.f10994c.e();
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Request{method=");
        sb2.append(this.f10993b);
        sb2.append(", url=");
        sb2.append(this.f10992a);
        f fVar = this.f10994c;
        if (fVar.size() != 0) {
            sb2.append(", headers=[");
            Iterator<Pair<? extends String, ? extends String>> it = fVar.iterator();
            int i10 = 0;
            while (true) {
                kotlin.jvm.internal.a aVar = (kotlin.jvm.internal.a) it;
                if (!aVar.hasNext()) {
                    sb2.append(']');
                    break;
                }
                Object next = aVar.next();
                int i11 = i10 + 1;
                if (i10 < 0) {
                    m.f0();
                    throw null;
                }
                Pair pair = (Pair) next;
                String str = (String) pair.f9985a;
                String str2 = (String) pair.f9986b;
                if (i10 > 0) {
                    sb2.append(", ");
                }
                sb2.append(str);
                sb2.append(':');
                if (bd.i.k(str)) {
                    str2 = "██";
                }
                sb2.append(str2);
                i10 = i11;
            }
        }
        Map<ec.c<?>, Object> map = this.f10996e;
        if (!map.isEmpty()) {
            sb2.append(", tags=");
            sb2.append(map);
        }
        sb2.append('}');
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }
}
