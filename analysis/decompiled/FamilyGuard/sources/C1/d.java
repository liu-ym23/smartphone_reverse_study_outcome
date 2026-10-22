package C1;

import A1.t;
import A1.u;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class d implements u, Cloneable {

    /* renamed from: g, reason: collision with root package name */
    public static final d f551g = new d();

    /* renamed from: a, reason: collision with root package name */
    private double f552a = -1.0d;

    /* renamed from: b, reason: collision with root package name */
    private int f553b = 136;

    /* renamed from: c, reason: collision with root package name */
    private boolean f554c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f555d;

    /* renamed from: e, reason: collision with root package name */
    private List<A1.a> f556e;

    /* renamed from: f, reason: collision with root package name */
    private List<A1.a> f557f;

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private t<T> f558a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f559b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f560c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ A1.e f561d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.google.gson.reflect.a f562e;

        a(boolean z5, boolean z6, A1.e eVar, com.google.gson.reflect.a aVar) {
            this.f559b = z5;
            this.f560c = z6;
            this.f561d = eVar;
            this.f562e = aVar;
        }

        private t<T> e() {
            t<T> tVar = this.f558a;
            if (tVar != null) {
                return tVar;
            }
            t<T> tVarM = this.f561d.m(d.this, this.f562e);
            this.f558a = tVarM;
            return tVarM;
        }

        @Override // A1.t
        public T b(G1.a aVar) throws IOException {
            if (!this.f559b) {
                return e().b(aVar);
            }
            aVar.m0();
            return null;
        }

        @Override // A1.t
        public void d(G1.c cVar, T t5) throws IOException {
            if (this.f560c) {
                cVar.D();
            } else {
                e().d(cVar, t5);
            }
        }
    }

    public d() {
        List<A1.a> list = Collections.EMPTY_LIST;
        this.f556e = list;
        this.f557f = list;
    }

    private boolean g(Class<?> cls) {
        if (this.f552a == -1.0d || q((B1.d) cls.getAnnotation(B1.d.class), (B1.e) cls.getAnnotation(B1.e.class))) {
            return (!this.f554c && k(cls)) || j(cls);
        }
        return true;
    }

    private boolean h(Class<?> cls, boolean z5) {
        Iterator<A1.a> it = (z5 ? this.f556e : this.f557f).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean j(Class<?> cls) {
        if (Enum.class.isAssignableFrom(cls)) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    private boolean k(Class<?> cls) {
        return cls.isMemberClass() && !l(cls);
    }

    private boolean l(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean n(B1.d dVar) {
        return dVar == null || dVar.value() <= this.f552a;
    }

    private boolean p(B1.e eVar) {
        return eVar == null || eVar.value() > this.f552a;
    }

    private boolean q(B1.d dVar, B1.e eVar) {
        return n(dVar) && p(eVar);
    }

    @Override // A1.u
    public <T> t<T> b(A1.e eVar, com.google.gson.reflect.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean zG = g(rawType);
        boolean z5 = zG || h(rawType, true);
        boolean z6 = zG || h(rawType, false);
        if (z5 || z6) {
            return new a(z6, z5, eVar, aVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e6) {
            throw new AssertionError(e6);
        }
    }

    public boolean e(Class<?> cls, boolean z5) {
        return g(cls) || h(cls, z5);
    }

    public boolean i(Field field, boolean z5) {
        B1.a aVar;
        if ((this.f553b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f552a != -1.0d && !q((B1.d) field.getAnnotation(B1.d.class), (B1.e) field.getAnnotation(B1.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f555d && ((aVar = (B1.a) field.getAnnotation(B1.a.class)) == null || (!z5 ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f554c && k(field.getType())) || j(field.getType())) {
            return true;
        }
        List<A1.a> list = z5 ? this.f556e : this.f557f;
        if (list.isEmpty()) {
            return false;
        }
        A1.b bVar = new A1.b(field);
        Iterator<A1.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().b(bVar)) {
                return true;
            }
        }
        return false;
    }
}
