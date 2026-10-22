package yc;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import tb.AbstractC5529B;
import tb.y;

/* loaded from: classes5.dex */
public abstract class q<T> {

    public class a extends q<Iterable<T>> {
        public a() {
        }

        @Override // yc.q
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(t tVar, Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                q.this.a(tVar, it.next());
            }
        }
    }

    public class b extends q<Object> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // yc.q
        public void a(t tVar, Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i10 = 0; i10 < length; i10++) {
                q.this.a(tVar, Array.get(obj, i10));
            }
        }
    }

    public static final class c<T> extends q<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f44369a;

        /* renamed from: b, reason: collision with root package name */
        public final int f44370b;

        /* renamed from: c, reason: collision with root package name */
        public final yc.h<T, AbstractC5529B> f44371c;

        public c(Method method, int i10, yc.h<T, AbstractC5529B> hVar) {
            this.f44369a = method;
            this.f44370b = i10;
            this.f44371c = hVar;
        }

        @Override // yc.q
        public void a(t tVar, T t10) {
            if (t10 == null) {
                throw A.p(this.f44369a, this.f44370b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                tVar.l(this.f44371c.convert(t10));
            } catch (IOException e10) {
                throw A.q(this.f44369a, e10, this.f44370b, "Unable to convert " + t10 + " to RequestBody", new Object[0]);
            }
        }
    }

    public static final class d<T> extends q<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f44372a;

        /* renamed from: b, reason: collision with root package name */
        public final yc.h<T, String> f44373b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f44374c;

        public d(String str, yc.h<T, String> hVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f44372a = str;
            this.f44373b = hVar;
            this.f44374c = z10;
        }

        @Override // yc.q
        public void a(t tVar, T t10) throws IOException {
            String strConvert;
            if (t10 == null || (strConvert = this.f44373b.convert(t10)) == null) {
                return;
            }
            tVar.a(this.f44372a, strConvert, this.f44374c);
        }
    }

    public static final class e<T> extends q<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f44375a;

        /* renamed from: b, reason: collision with root package name */
        public final int f44376b;

        /* renamed from: c, reason: collision with root package name */
        public final yc.h<T, String> f44377c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f44378d;

        public e(Method method, int i10, yc.h<T, String> hVar, boolean z10) {
            this.f44375a = method;
            this.f44376b = i10;
            this.f44377c = hVar;
            this.f44378d = z10;
        }

        @Override // yc.q
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(t tVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw A.p(this.f44375a, this.f44376b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw A.p(this.f44375a, this.f44376b, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw A.p(this.f44375a, this.f44376b, "Field map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strConvert = this.f44377c.convert(value);
                if (strConvert == null) {
                    throw A.p(this.f44375a, this.f44376b, "Field map value '" + value + "' converted to null by " + this.f44377c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                tVar.a(key, strConvert, this.f44378d);
            }
        }
    }

    public static final class f<T> extends q<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f44379a;

        /* renamed from: b, reason: collision with root package name */
        public final yc.h<T, String> f44380b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f44381c;

        public f(String str, yc.h<T, String> hVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f44379a = str;
            this.f44380b = hVar;
            this.f44381c = z10;
        }

        @Override // yc.q
        public void a(t tVar, T t10) throws IOException {
            String strConvert;
            if (t10 == null || (strConvert = this.f44380b.convert(t10)) == null) {
                return;
            }
            tVar.b(this.f44379a, strConvert, this.f44381c);
        }
    }

    public static final class g<T> extends q<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f44382a;

        /* renamed from: b, reason: collision with root package name */
        public final int f44383b;

        /* renamed from: c, reason: collision with root package name */
        public final yc.h<T, String> f44384c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f44385d;

        public g(Method method, int i10, yc.h<T, String> hVar, boolean z10) {
            this.f44382a = method;
            this.f44383b = i10;
            this.f44384c = hVar;
            this.f44385d = z10;
        }

        @Override // yc.q
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(t tVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw A.p(this.f44382a, this.f44383b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw A.p(this.f44382a, this.f44383b, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw A.p(this.f44382a, this.f44383b, "Header map contained null value for key '" + key + "'.", new Object[0]);
                }
                tVar.b(key, this.f44384c.convert(value), this.f44385d);
            }
        }
    }

    public static final class h extends q<tb.u> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f44386a;

        /* renamed from: b, reason: collision with root package name */
        public final int f44387b;

        public h(Method method, int i10) {
            this.f44386a = method;
            this.f44387b = i10;
        }

        @Override // yc.q
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(t tVar, tb.u uVar) {
            if (uVar == null) {
                throw A.p(this.f44386a, this.f44387b, "Headers parameter must not be null.", new Object[0]);
            }
            tVar.c(uVar);
        }
    }

    public static final class i<T> extends q<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f44388a;

        /* renamed from: b, reason: collision with root package name */
        public final int f44389b;

        /* renamed from: c, reason: collision with root package name */
        public final tb.u f44390c;

        /* renamed from: d, reason: collision with root package name */
        public final yc.h<T, AbstractC5529B> f44391d;

        public i(Method method, int i10, tb.u uVar, yc.h<T, AbstractC5529B> hVar) {
            this.f44388a = method;
            this.f44389b = i10;
            this.f44390c = uVar;
            this.f44391d = hVar;
        }

        @Override // yc.q
        public void a(t tVar, T t10) {
            if (t10 == null) {
                return;
            }
            try {
                tVar.d(this.f44390c, this.f44391d.convert(t10));
            } catch (IOException e10) {
                throw A.p(this.f44388a, this.f44389b, "Unable to convert " + t10 + " to RequestBody", e10);
            }
        }
    }

    public static final class j<T> extends q<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f44392a;

        /* renamed from: b, reason: collision with root package name */
        public final int f44393b;

        /* renamed from: c, reason: collision with root package name */
        public final yc.h<T, AbstractC5529B> f44394c;

        /* renamed from: d, reason: collision with root package name */
        public final String f44395d;

        public j(Method method, int i10, yc.h<T, AbstractC5529B> hVar, String str) {
            this.f44392a = method;
            this.f44393b = i10;
            this.f44394c = hVar;
            this.f44395d = str;
        }

        @Override // yc.q
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(t tVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw A.p(this.f44392a, this.f44393b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw A.p(this.f44392a, this.f44393b, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw A.p(this.f44392a, this.f44393b, "Part map contained null value for key '" + key + "'.", new Object[0]);
                }
                tVar.d(tb.u.j("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f44395d), this.f44394c.convert(value));
            }
        }
    }

    public static final class k<T> extends q<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f44396a;

        /* renamed from: b, reason: collision with root package name */
        public final int f44397b;

        /* renamed from: c, reason: collision with root package name */
        public final String f44398c;

        /* renamed from: d, reason: collision with root package name */
        public final yc.h<T, String> f44399d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f44400e;

        public k(Method method, int i10, String str, yc.h<T, String> hVar, boolean z10) {
            this.f44396a = method;
            this.f44397b = i10;
            Objects.requireNonNull(str, "name == null");
            this.f44398c = str;
            this.f44399d = hVar;
            this.f44400e = z10;
        }

        @Override // yc.q
        public void a(t tVar, T t10) throws IOException {
            if (t10 != null) {
                tVar.f(this.f44398c, this.f44399d.convert(t10), this.f44400e);
                return;
            }
            throw A.p(this.f44396a, this.f44397b, "Path parameter \"" + this.f44398c + "\" value must not be null.", new Object[0]);
        }
    }

    public static final class l<T> extends q<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f44401a;

        /* renamed from: b, reason: collision with root package name */
        public final yc.h<T, String> f44402b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f44403c;

        public l(String str, yc.h<T, String> hVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f44401a = str;
            this.f44402b = hVar;
            this.f44403c = z10;
        }

        @Override // yc.q
        public void a(t tVar, T t10) throws IOException {
            String strConvert;
            if (t10 == null || (strConvert = this.f44402b.convert(t10)) == null) {
                return;
            }
            tVar.g(this.f44401a, strConvert, this.f44403c);
        }
    }

    public static final class m<T> extends q<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f44404a;

        /* renamed from: b, reason: collision with root package name */
        public final int f44405b;

        /* renamed from: c, reason: collision with root package name */
        public final yc.h<T, String> f44406c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f44407d;

        public m(Method method, int i10, yc.h<T, String> hVar, boolean z10) {
            this.f44404a = method;
            this.f44405b = i10;
            this.f44406c = hVar;
            this.f44407d = z10;
        }

        @Override // yc.q
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(t tVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw A.p(this.f44404a, this.f44405b, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw A.p(this.f44404a, this.f44405b, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw A.p(this.f44404a, this.f44405b, "Query map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strConvert = this.f44406c.convert(value);
                if (strConvert == null) {
                    throw A.p(this.f44404a, this.f44405b, "Query map value '" + value + "' converted to null by " + this.f44406c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                tVar.g(key, strConvert, this.f44407d);
            }
        }
    }

    public static final class n<T> extends q<T> {

        /* renamed from: a, reason: collision with root package name */
        public final yc.h<T, String> f44408a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f44409b;

        public n(yc.h<T, String> hVar, boolean z10) {
            this.f44408a = hVar;
            this.f44409b = z10;
        }

        @Override // yc.q
        public void a(t tVar, T t10) throws IOException {
            if (t10 == null) {
                return;
            }
            tVar.g(this.f44408a.convert(t10), null, this.f44409b);
        }
    }

    public static final class o extends q<y.c> {

        /* renamed from: a, reason: collision with root package name */
        public static final o f44410a = new o();

        @Override // yc.q
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(t tVar, y.c cVar) {
            if (cVar != null) {
                tVar.e(cVar);
            }
        }
    }

    public static final class p extends q<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f44411a;

        /* renamed from: b, reason: collision with root package name */
        public final int f44412b;

        public p(Method method, int i10) {
            this.f44411a = method;
            this.f44412b = i10;
        }

        @Override // yc.q
        public void a(t tVar, Object obj) {
            if (obj == null) {
                throw A.p(this.f44411a, this.f44412b, "@Url parameter is null.", new Object[0]);
            }
            tVar.m(obj);
        }
    }

    /* renamed from: yc.q$q, reason: collision with other inner class name */
    public static final class C0561q<T> extends q<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<T> f44413a;

        public C0561q(Class<T> cls) {
            this.f44413a = cls;
        }

        @Override // yc.q
        public void a(t tVar, T t10) {
            tVar.h(this.f44413a, t10);
        }
    }

    public abstract void a(t tVar, T t10) throws IOException;

    public final q<Object> b() {
        return new b();
    }

    public final q<Iterable<T>> c() {
        return new a();
    }
}
