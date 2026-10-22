package xd;

import ad.m;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import okhttp3.f;
import xd.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class n<T> {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f13818a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13819b;

        /* renamed from: c, reason: collision with root package name */
        public final xd.f<T, ad.s> f13820c;

        public a(Method method, int i10, xd.f<T, ad.s> fVar) {
            this.f13818a = method;
            this.f13819b = i10;
            this.f13820c = fVar;
        }

        @Override // xd.n
        public final void a(p pVar, T t8) {
            int i10 = this.f13819b;
            Method method = this.f13818a;
            if (t8 == null) {
                throw retrofit2.b.j(method, i10, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                pVar.f13871k = this.f13820c.a(t8);
            } catch (IOException e10) {
                throw retrofit2.b.k(method, e10, i10, "Unable to convert " + t8 + " to RequestBody", new Object[0]);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f13821a;

        /* renamed from: b, reason: collision with root package name */
        public final a.d f13822b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f13823c;

        public b(String str, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.f13821a = str;
            this.f13822b = a.d.f13783g;
            this.f13823c = z;
        }

        @Override // xd.n
        public final void a(p pVar, T t8) {
            if (t8 == null) {
                return;
            }
            this.f13822b.getClass();
            String string = t8.toString();
            if (string == null) {
                return;
            }
            pVar.a(this.f13821a, string, this.f13823c);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c<T> extends n<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f13824a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13825b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f13826c;

        public c(Method method, int i10, boolean z) {
            this.f13824a = method;
            this.f13825b = i10;
            this.f13826c = z;
        }

        @Override // xd.n
        public final void a(p pVar, Object obj) {
            Map map = (Map) obj;
            int i10 = this.f13825b;
            Method method = this.f13824a;
            if (map == null) {
                throw retrofit2.b.j(method, i10, "Field map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw retrofit2.b.j(method, i10, "Field map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw retrofit2.b.j(method, i10, a0.a.k("Field map contained null value for key '", str, "'."), new Object[0]);
                }
                String string = value.toString();
                if (string == null) {
                    throw retrofit2.b.j(method, i10, "Field map value '" + value + "' converted to null by " + a.d.class.getName() + " for key '" + str + "'.", new Object[0]);
                }
                pVar.a(str, string, this.f13826c);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f13827a;

        /* renamed from: b, reason: collision with root package name */
        public final a.d f13828b;

        public d(String str) {
            Objects.requireNonNull(str, "name == null");
            this.f13827a = str;
            this.f13828b = a.d.f13783g;
        }

        @Override // xd.n
        public final void a(p pVar, T t8) {
            if (t8 == null) {
                return;
            }
            this.f13828b.getClass();
            String string = t8.toString();
            if (string == null) {
                return;
            }
            pVar.b(this.f13827a, string);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e<T> extends n<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f13829a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13830b;

        public e(int i10, Method method) {
            this.f13829a = method;
            this.f13830b = i10;
        }

        @Override // xd.n
        public final void a(p pVar, Object obj) {
            Map map = (Map) obj;
            int i10 = this.f13830b;
            Method method = this.f13829a;
            if (map == null) {
                throw retrofit2.b.j(method, i10, "Header map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw retrofit2.b.j(method, i10, "Header map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw retrofit2.b.j(method, i10, a0.a.k("Header map contained null value for key '", str, "'."), new Object[0]);
                }
                pVar.b(str, value.toString());
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class f extends n<okhttp3.f> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f13831a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13832b;

        public f(int i10, Method method) {
            this.f13831a = method;
            this.f13832b = i10;
        }

        @Override // xd.n
        public final void a(p pVar, okhttp3.f fVar) {
            okhttp3.f fVar2 = fVar;
            if (fVar2 == null) {
                throw retrofit2.b.j(this.f13831a, this.f13832b, "Headers parameter must not be null.", new Object[0]);
            }
            f.a aVar = pVar.f13867f;
            aVar.getClass();
            int size = fVar2.size();
            for (int i10 = 0; i10 < size; i10++) {
                bd.b.a(aVar, fVar2.b(i10), fVar2.g(i10));
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class g<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f13833a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13834b;

        /* renamed from: c, reason: collision with root package name */
        public final okhttp3.f f13835c;

        /* renamed from: d, reason: collision with root package name */
        public final xd.f<T, ad.s> f13836d;

        public g(Method method, int i10, okhttp3.f fVar, xd.f<T, ad.s> fVar2) {
            this.f13833a = method;
            this.f13834b = i10;
            this.f13835c = fVar;
            this.f13836d = fVar2;
        }

        @Override // xd.n
        public final void a(p pVar, T t8) {
            if (t8 == null) {
                return;
            }
            try {
                pVar.c(this.f13835c, this.f13836d.a(t8));
            } catch (IOException e10) {
                throw retrofit2.b.j(this.f13833a, this.f13834b, "Unable to convert " + t8 + " to RequestBody", e10);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class h<T> extends n<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f13837a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13838b;

        /* renamed from: c, reason: collision with root package name */
        public final xd.f<T, ad.s> f13839c;

        /* renamed from: d, reason: collision with root package name */
        public final String f13840d;

        public h(Method method, int i10, xd.f<T, ad.s> fVar, String str) {
            this.f13837a = method;
            this.f13838b = i10;
            this.f13839c = fVar;
            this.f13840d = str;
        }

        @Override // xd.n
        public final void a(p pVar, Object obj) {
            Map map = (Map) obj;
            int i10 = this.f13838b;
            Method method = this.f13837a;
            if (map == null) {
                throw retrofit2.b.j(method, i10, "Part map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw retrofit2.b.j(method, i10, "Part map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw retrofit2.b.j(method, i10, a0.a.k("Part map contained null value for key '", str, "'."), new Object[0]);
                }
                pVar.c(f.b.a("Content-Disposition", a0.a.k("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", this.f13840d), (ad.s) this.f13839c.a(value));
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class i<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f13841a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13842b;

        /* renamed from: c, reason: collision with root package name */
        public final String f13843c;

        /* renamed from: d, reason: collision with root package name */
        public final a.d f13844d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f13845e;

        public i(Method method, int i10, String str, boolean z) {
            this.f13841a = method;
            this.f13842b = i10;
            Objects.requireNonNull(str, "name == null");
            this.f13843c = str;
            this.f13844d = a.d.f13783g;
            this.f13845e = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00e0  */
        @Override // xd.n
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(xd.p r18, T r19) throws java.io.EOFException {
            /*
                Method dump skipped, instructions count: 261
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: xd.n.i.a(xd.p, java.lang.Object):void");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class j<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f13846a;

        /* renamed from: b, reason: collision with root package name */
        public final a.d f13847b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f13848c;

        public j(String str, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.f13846a = str;
            this.f13847b = a.d.f13783g;
            this.f13848c = z;
        }

        @Override // xd.n
        public final void a(p pVar, T t8) {
            if (t8 == null) {
                return;
            }
            this.f13847b.getClass();
            String string = t8.toString();
            if (string == null) {
                return;
            }
            pVar.d(this.f13846a, string, this.f13848c);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class k<T> extends n<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f13849a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13850b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f13851c;

        public k(Method method, int i10, boolean z) {
            this.f13849a = method;
            this.f13850b = i10;
            this.f13851c = z;
        }

        @Override // xd.n
        public final void a(p pVar, Object obj) {
            Map map = (Map) obj;
            int i10 = this.f13850b;
            Method method = this.f13849a;
            if (map == null) {
                throw retrofit2.b.j(method, i10, "Query map was null", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw retrofit2.b.j(method, i10, "Query map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw retrofit2.b.j(method, i10, a0.a.k("Query map contained null value for key '", str, "'."), new Object[0]);
                }
                String string = value.toString();
                if (string == null) {
                    throw retrofit2.b.j(method, i10, "Query map value '" + value + "' converted to null by " + a.d.class.getName() + " for key '" + str + "'.", new Object[0]);
                }
                pVar.d(str, string, this.f13851c);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class l<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f13852a;

        public l(boolean z) {
            this.f13852a = z;
        }

        @Override // xd.n
        public final void a(p pVar, T t8) {
            if (t8 == null) {
                return;
            }
            pVar.d(t8.toString(), null, this.f13852a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class m extends n<m.b> {

        /* renamed from: a, reason: collision with root package name */
        public static final m f13853a = new m();

        @Override // xd.n
        public final void a(p pVar, m.b bVar) {
            m.b bVar2 = bVar;
            if (bVar2 != null) {
                m.a aVar = pVar.f13869i;
                aVar.getClass();
                aVar.f114c.add(bVar2);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: xd.n$n, reason: collision with other inner class name */
    public static final class C0174n extends n<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f13854a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13855b;

        public C0174n(int i10, Method method) {
            this.f13854a = method;
            this.f13855b = i10;
        }

        @Override // xd.n
        public final void a(p pVar, Object obj) {
            if (obj != null) {
                pVar.f13864c = obj.toString();
            } else {
                throw retrofit2.b.j(this.f13854a, this.f13855b, "@Url parameter is null.", new Object[0]);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class o<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<T> f13856a;

        public o(Class<T> cls) {
            this.f13856a = cls;
        }

        @Override // xd.n
        public final void a(p pVar, T t8) {
            pVar.f13866e.d(this.f13856a, t8);
        }
    }

    public abstract void a(p pVar, T t8);
}
