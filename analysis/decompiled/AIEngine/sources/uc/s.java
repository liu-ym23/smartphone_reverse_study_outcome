package uc;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.collections.EmptyList;
import rc.j;
import tc.b1;
import tc.d0;
import tc.e0;
import tc.v0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s implements pc.a<r> {

    /* renamed from: a, reason: collision with root package name */
    public static final s f13222a = new s();

    /* renamed from: b, reason: collision with root package name */
    public static final a f13223b = a.f13224b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements rc.e {

        /* renamed from: b, reason: collision with root package name */
        public static final a f13224b = new a();

        /* renamed from: c, reason: collision with root package name */
        public static final String f13225c = "kotlinx.serialization.json.JsonObject";

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f13226a;

        public a() {
            b1 b1Var = b1.f12964a;
            i iVar = i.f13211a;
            b1 b1Var2 = b1.f12964a;
            i iVar2 = i.f13211a;
            b1 b1Var3 = b1.f12964a;
            i iVar3 = i.f13211a;
            v0 keyDesc = b1.f12965b;
            rc.f valueDesc = i.f13212b;
            kotlin.jvm.internal.g.f(keyDesc, "keyDesc");
            kotlin.jvm.internal.g.f(valueDesc, "valueDesc");
            this.f13226a = new d0(keyDesc, valueDesc);
        }

        @Override // rc.e
        public final boolean b() {
            this.f13226a.getClass();
            return false;
        }

        @Override // rc.e
        public final int c(String name) {
            kotlin.jvm.internal.g.f(name, "name");
            return this.f13226a.c(name);
        }

        @Override // rc.e
        public final rc.i d() {
            this.f13226a.getClass();
            return j.c.f11803a;
        }

        @Override // rc.e
        public final int e() {
            this.f13226a.getClass();
            return 2;
        }

        @Override // rc.e
        public final String f(int i10) {
            this.f13226a.getClass();
            return String.valueOf(i10);
        }

        @Override // rc.e
        public final List<Annotation> g(int i10) {
            return this.f13226a.g(i10);
        }

        @Override // rc.e
        public final List<Annotation> getAnnotations() {
            this.f13226a.getClass();
            return EmptyList.f10001a;
        }

        @Override // rc.e
        public final rc.e h(int i10) {
            return this.f13226a.h(i10);
        }

        @Override // rc.e
        public final String i() {
            return f13225c;
        }

        @Override // rc.e
        public final boolean isInline() {
            this.f13226a.getClass();
            return false;
        }

        @Override // rc.e
        public final boolean j(int i10) {
            this.f13226a.j(i10);
            return false;
        }
    }

    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        r value = (r) obj;
        kotlin.jvm.internal.g.f(value, "value");
        jd.b.b(kVar);
        b1 b1Var = b1.f12964a;
        i iVar = i.f13211a;
        new e0().a(kVar, value);
    }

    @Override // pc.a
    public final Object b(sc.d dVar) {
        jd.b.d(dVar);
        b1 b1Var = b1.f12964a;
        i iVar = i.f13211a;
        return new r((Map) new e0().i(dVar));
    }

    @Override // pc.c
    public final rc.e d() {
        return f13223b;
    }
}
