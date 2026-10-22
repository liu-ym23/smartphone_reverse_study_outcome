package uc;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import rc.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements pc.a<b> {

    /* renamed from: a, reason: collision with root package name */
    public static final c f13198a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final a f13199b = a.f13200b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements rc.e {

        /* renamed from: b, reason: collision with root package name */
        public static final a f13200b = new a();

        /* renamed from: c, reason: collision with root package name */
        public static final String f13201c = "kotlinx.serialization.json.JsonArray";

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ tc.c f13202a;

        public a() {
            rc.e elementDesc = i.f13211a.d();
            kotlin.jvm.internal.g.f(elementDesc, "elementDesc");
            this.f13202a = new tc.c(elementDesc);
        }

        @Override // rc.e
        public final boolean b() {
            this.f13202a.getClass();
            return false;
        }

        @Override // rc.e
        public final int c(String name) {
            kotlin.jvm.internal.g.f(name, "name");
            return this.f13202a.c(name);
        }

        @Override // rc.e
        public final rc.i d() {
            this.f13202a.getClass();
            return j.b.f11802a;
        }

        @Override // rc.e
        public final int e() {
            this.f13202a.getClass();
            return 1;
        }

        @Override // rc.e
        public final String f(int i10) {
            this.f13202a.getClass();
            return String.valueOf(i10);
        }

        @Override // rc.e
        public final List<Annotation> g(int i10) {
            return this.f13202a.g(i10);
        }

        @Override // rc.e
        public final List<Annotation> getAnnotations() {
            this.f13202a.getClass();
            return EmptyList.f10001a;
        }

        @Override // rc.e
        public final rc.e h(int i10) {
            return this.f13202a.h(i10);
        }

        @Override // rc.e
        public final String i() {
            return f13201c;
        }

        @Override // rc.e
        public final boolean isInline() {
            this.f13202a.getClass();
            return false;
        }

        @Override // rc.e
        public final boolean j(int i10) {
            this.f13202a.j(i10);
            return false;
        }
    }

    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        b value = (b) obj;
        kotlin.jvm.internal.g.f(value, "value");
        jd.b.b(kVar);
        i iVar = i.f13211a;
        rc.e elementDesc = iVar.d();
        kotlin.jvm.internal.g.f(elementDesc, "elementDesc");
        tc.c cVar = new tc.c(elementDesc);
        int size = value.size();
        sc.c cVarC = kVar.C(cVar);
        Iterator<g> it = value.iterator();
        for (int i10 = 0; i10 < size; i10++) {
            cVarC.g(cVar, i10, iVar, it.next());
        }
        cVarC.a(cVar);
    }

    @Override // pc.a
    public final Object b(sc.d dVar) {
        jd.b.d(dVar);
        return new b((List) new tc.d(i.f13211a).i(dVar));
    }

    @Override // pc.c
    public final rc.e d() {
        return f13199b;
    }
}
