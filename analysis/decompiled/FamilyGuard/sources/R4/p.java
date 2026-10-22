package R4;

import C4.E;
import C4.z;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
abstract class p<T> {

    class a extends p<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // R4.p
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(r rVar, @Nullable Iterable<T> iterable) {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                p.this.a(rVar, it.next());
            }
        }
    }

    class b extends p<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // R4.p
        void a(r rVar, @Nullable Object obj) {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i5 = 0; i5 < length; i5++) {
                p.this.a(rVar, Array.get(obj, i5));
            }
        }
    }

    static final class c<T> extends p<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f5065a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5066b;

        /* renamed from: c, reason: collision with root package name */
        private final R4.f<T, E> f5067c;

        c(Method method, int i5, R4.f<T, E> fVar) {
            this.f5065a = method;
            this.f5066b = i5;
            this.f5067c = fVar;
        }

        @Override // R4.p
        void a(r rVar, @Nullable T t5) {
            if (t5 == null) {
                throw y.o(this.f5065a, this.f5066b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                rVar.l(this.f5067c.a(t5));
            } catch (IOException e6) {
                throw y.p(this.f5065a, e6, this.f5066b, "Unable to convert " + t5 + " to RequestBody", new Object[0]);
            }
        }
    }

    static final class d<T> extends p<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f5068a;

        /* renamed from: b, reason: collision with root package name */
        private final R4.f<T, String> f5069b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f5070c;

        d(String str, R4.f<T, String> fVar, boolean z5) {
            Objects.requireNonNull(str, "name == null");
            this.f5068a = str;
            this.f5069b = fVar;
            this.f5070c = z5;
        }

        @Override // R4.p
        void a(r rVar, @Nullable T t5) {
            String strA;
            if (t5 == null || (strA = this.f5069b.a(t5)) == null) {
                return;
            }
            rVar.a(this.f5068a, strA, this.f5070c);
        }
    }

    static final class e<T> extends p<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f5071a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5072b;

        /* renamed from: c, reason: collision with root package name */
        private final R4.f<T, String> f5073c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f5074d;

        e(Method method, int i5, R4.f<T, String> fVar, boolean z5) {
            this.f5071a = method;
            this.f5072b = i5;
            this.f5073c = fVar;
            this.f5074d = z5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // R4.p
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(r rVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw y.o(this.f5071a, this.f5072b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw y.o(this.f5071a, this.f5072b, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw y.o(this.f5071a, this.f5072b, "Field map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strA = this.f5073c.a(value);
                if (strA == null) {
                    throw y.o(this.f5071a, this.f5072b, "Field map value '" + value + "' converted to null by " + this.f5073c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                rVar.a(key, strA, this.f5074d);
            }
        }
    }

    static final class f<T> extends p<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f5075a;

        /* renamed from: b, reason: collision with root package name */
        private final R4.f<T, String> f5076b;

        f(String str, R4.f<T, String> fVar) {
            Objects.requireNonNull(str, "name == null");
            this.f5075a = str;
            this.f5076b = fVar;
        }

        @Override // R4.p
        void a(r rVar, @Nullable T t5) {
            String strA;
            if (t5 == null || (strA = this.f5076b.a(t5)) == null) {
                return;
            }
            rVar.b(this.f5075a, strA);
        }
    }

    static final class g<T> extends p<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f5077a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5078b;

        /* renamed from: c, reason: collision with root package name */
        private final R4.f<T, String> f5079c;

        g(Method method, int i5, R4.f<T, String> fVar) {
            this.f5077a = method;
            this.f5078b = i5;
            this.f5079c = fVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // R4.p
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(r rVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw y.o(this.f5077a, this.f5078b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw y.o(this.f5077a, this.f5078b, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw y.o(this.f5077a, this.f5078b, "Header map contained null value for key '" + key + "'.", new Object[0]);
                }
                rVar.b(key, this.f5079c.a(value));
            }
        }
    }

    static final class h extends p<C4.v> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f5080a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5081b;

        h(Method method, int i5) {
            this.f5080a = method;
            this.f5081b = i5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // R4.p
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(r rVar, @Nullable C4.v vVar) {
            if (vVar == null) {
                throw y.o(this.f5080a, this.f5081b, "Headers parameter must not be null.", new Object[0]);
            }
            rVar.c(vVar);
        }
    }

    static final class i<T> extends p<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f5082a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5083b;

        /* renamed from: c, reason: collision with root package name */
        private final C4.v f5084c;

        /* renamed from: d, reason: collision with root package name */
        private final R4.f<T, E> f5085d;

        i(Method method, int i5, C4.v vVar, R4.f<T, E> fVar) {
            this.f5082a = method;
            this.f5083b = i5;
            this.f5084c = vVar;
            this.f5085d = fVar;
        }

        @Override // R4.p
        void a(r rVar, @Nullable T t5) {
            if (t5 == null) {
                return;
            }
            try {
                rVar.d(this.f5084c, this.f5085d.a(t5));
            } catch (IOException e6) {
                throw y.o(this.f5082a, this.f5083b, "Unable to convert " + t5 + " to RequestBody", e6);
            }
        }
    }

    static final class j<T> extends p<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f5086a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5087b;

        /* renamed from: c, reason: collision with root package name */
        private final R4.f<T, E> f5088c;

        /* renamed from: d, reason: collision with root package name */
        private final String f5089d;

        j(Method method, int i5, R4.f<T, E> fVar, String str) {
            this.f5086a = method;
            this.f5087b = i5;
            this.f5088c = fVar;
            this.f5089d = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // R4.p
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(r rVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw y.o(this.f5086a, this.f5087b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw y.o(this.f5086a, this.f5087b, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw y.o(this.f5086a, this.f5087b, "Part map contained null value for key '" + key + "'.", new Object[0]);
                }
                rVar.d(C4.v.g("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f5089d), this.f5088c.a(value));
            }
        }
    }

    static final class k<T> extends p<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f5090a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5091b;

        /* renamed from: c, reason: collision with root package name */
        private final String f5092c;

        /* renamed from: d, reason: collision with root package name */
        private final R4.f<T, String> f5093d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f5094e;

        k(Method method, int i5, String str, R4.f<T, String> fVar, boolean z5) {
            this.f5090a = method;
            this.f5091b = i5;
            Objects.requireNonNull(str, "name == null");
            this.f5092c = str;
            this.f5093d = fVar;
            this.f5094e = z5;
        }

        @Override // R4.p
        void a(r rVar, @Nullable T t5) throws EOFException {
            if (t5 != null) {
                rVar.f(this.f5092c, this.f5093d.a(t5), this.f5094e);
                return;
            }
            throw y.o(this.f5090a, this.f5091b, "Path parameter \"" + this.f5092c + "\" value must not be null.", new Object[0]);
        }
    }

    static final class l<T> extends p<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f5095a;

        /* renamed from: b, reason: collision with root package name */
        private final R4.f<T, String> f5096b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f5097c;

        l(String str, R4.f<T, String> fVar, boolean z5) {
            Objects.requireNonNull(str, "name == null");
            this.f5095a = str;
            this.f5096b = fVar;
            this.f5097c = z5;
        }

        @Override // R4.p
        void a(r rVar, @Nullable T t5) {
            String strA;
            if (t5 == null || (strA = this.f5096b.a(t5)) == null) {
                return;
            }
            rVar.g(this.f5095a, strA, this.f5097c);
        }
    }

    static final class m<T> extends p<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f5098a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5099b;

        /* renamed from: c, reason: collision with root package name */
        private final R4.f<T, String> f5100c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f5101d;

        m(Method method, int i5, R4.f<T, String> fVar, boolean z5) {
            this.f5098a = method;
            this.f5099b = i5;
            this.f5100c = fVar;
            this.f5101d = z5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // R4.p
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(r rVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw y.o(this.f5098a, this.f5099b, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw y.o(this.f5098a, this.f5099b, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw y.o(this.f5098a, this.f5099b, "Query map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strA = this.f5100c.a(value);
                if (strA == null) {
                    throw y.o(this.f5098a, this.f5099b, "Query map value '" + value + "' converted to null by " + this.f5100c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                rVar.g(key, strA, this.f5101d);
            }
        }
    }

    static final class n<T> extends p<T> {

        /* renamed from: a, reason: collision with root package name */
        private final R4.f<T, String> f5102a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f5103b;

        n(R4.f<T, String> fVar, boolean z5) {
            this.f5102a = fVar;
            this.f5103b = z5;
        }

        @Override // R4.p
        void a(r rVar, @Nullable T t5) {
            if (t5 == null) {
                return;
            }
            rVar.g(this.f5102a.a(t5), null, this.f5103b);
        }
    }

    static final class o extends p<z.b> {

        /* renamed from: a, reason: collision with root package name */
        static final o f5104a = new o();

        private o() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // R4.p
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(r rVar, @Nullable z.b bVar) {
            if (bVar != null) {
                rVar.e(bVar);
            }
        }
    }

    /* renamed from: R4.p$p, reason: collision with other inner class name */
    static final class C0077p extends p<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f5105a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5106b;

        C0077p(Method method, int i5) {
            this.f5105a = method;
            this.f5106b = i5;
        }

        @Override // R4.p
        void a(r rVar, @Nullable Object obj) {
            if (obj == null) {
                throw y.o(this.f5105a, this.f5106b, "@Url parameter is null.", new Object[0]);
            }
            rVar.m(obj);
        }
    }

    static final class q<T> extends p<T> {

        /* renamed from: a, reason: collision with root package name */
        final Class<T> f5107a;

        q(Class<T> cls) {
            this.f5107a = cls;
        }

        @Override // R4.p
        void a(r rVar, @Nullable T t5) {
            rVar.h(this.f5107a, t5);
        }
    }

    p() {
    }

    abstract void a(r rVar, @Nullable T t5);

    final p<Object> b() {
        return new b();
    }

    final p<Iterable<T>> c() {
        return new a();
    }
}
