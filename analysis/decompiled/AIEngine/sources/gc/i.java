package gc;

import fc.q;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i implements h {

    /* renamed from: a, reason: collision with root package name */
    public final Matcher f9136a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f9137b;

    /* renamed from: c, reason: collision with root package name */
    public final b f9138c;

    /* renamed from: d, reason: collision with root package name */
    public a f9139d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends mb.c<String> {
        public a() {
        }

        @Override // mb.a
        public final int a() {
            return i.this.f9136a.groupCount() + 1;
        }

        @Override // mb.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return super.contains((String) obj);
            }
            return false;
        }

        @Override // java.util.List
        public final Object get(int i10) {
            String strGroup = i.this.f9136a.group(i10);
            return strGroup == null ? "" : strGroup;
        }

        @Override // mb.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return super.indexOf((String) obj);
            }
            return -1;
        }

        @Override // mb.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return super.lastIndexOf((String) obj);
            }
            return -1;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends mb.a<g> {
        public b() {
        }

        @Override // mb.a
        public final int a() {
            return i.this.f9136a.groupCount() + 1;
        }

        public final g b(int i10) {
            Matcher matcher = i.this.f9136a;
            dc.e eVarE0 = dc.h.e0(matcher.start(i10), matcher.end(i10));
            if (eVarE0.f8451a < 0) {
                return null;
            }
            String strGroup = matcher.group(i10);
            kotlin.jvm.internal.g.e(strGroup, "group(...)");
            return new g(strGroup, eVarE0);
        }

        @Override // mb.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof g) {
                return super.contains((g) obj);
            }
            return false;
        }

        @Override // mb.a, java.util.Collection
        public final boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<g> iterator() {
            return new q.a(new fc.q(kotlin.collections.a.l0(new dc.e(0, a() - 1, 1)), new androidx.compose.runtime.i(this, 9)));
        }
    }

    public i(Matcher matcher, CharSequence input) {
        kotlin.jvm.internal.g.f(input, "input");
        this.f9136a = matcher;
        this.f9137b = input;
        this.f9138c = new b();
    }

    @Override // gc.h
    public final List<String> a() {
        if (this.f9139d == null) {
            this.f9139d = new a();
        }
        a aVar = this.f9139d;
        kotlin.jvm.internal.g.c(aVar);
        return aVar;
    }

    public final dc.e b() {
        Matcher matcher = this.f9136a;
        return dc.h.e0(matcher.start(), matcher.end());
    }

    @Override // gc.h
    public final String getValue() {
        String strGroup = this.f9136a.group();
        kotlin.jvm.internal.g.e(strGroup, "group(...)");
        return strGroup;
    }
}
