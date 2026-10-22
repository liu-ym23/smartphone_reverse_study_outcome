package E9;

import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import p9.InterfaceC5074l;
import ra.InterfaceC5238k;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;
import ya.v0;

/* loaded from: classes5.dex */
public final class V<T extends InterfaceC5238k> {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0797b f2440a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5074l<kotlin.reflect.jvm.internal.impl.types.checker.c, T> f2441b;

    /* renamed from: c, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.types.checker.c f2442c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5865h f2443d;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f2439f = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(V.class, "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};

    /* renamed from: e, reason: collision with root package name */
    public static final a f2438e = new a(null);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final <T extends InterfaceC5238k> V<T> a(InterfaceC0797b classDescriptor, InterfaceC5869l storageManager, kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefinerForOwnerModule, InterfaceC5074l<? super kotlin.reflect.jvm.internal.impl.types.checker.c, ? extends T> scopeFactory) {
            kotlin.jvm.internal.p.i(classDescriptor, "classDescriptor");
            kotlin.jvm.internal.p.i(storageManager, "storageManager");
            kotlin.jvm.internal.p.i(kotlinTypeRefinerForOwnerModule, "kotlinTypeRefinerForOwnerModule");
            kotlin.jvm.internal.p.i(scopeFactory, "scopeFactory");
            return new V<>(classDescriptor, storageManager, scopeFactory, kotlinTypeRefinerForOwnerModule, null);
        }

        public a() {
        }
    }

    public /* synthetic */ V(InterfaceC0797b interfaceC0797b, InterfaceC5869l interfaceC5869l, InterfaceC5074l interfaceC5074l, kotlin.reflect.jvm.internal.impl.types.checker.c cVar, kotlin.jvm.internal.i iVar) {
        this(interfaceC0797b, interfaceC5869l, interfaceC5074l, cVar);
    }

    public static final InterfaceC5238k d(V v10, kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        return v10.f2441b.invoke(cVar);
    }

    public static final InterfaceC5238k f(V v10) {
        return v10.f2441b.invoke(v10.f2442c);
    }

    public final T c(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.d(DescriptorUtilsKt.s(this.f2440a))) {
            return (T) e();
        }
        v0 v0VarJ = this.f2440a.j();
        kotlin.jvm.internal.p.h(v0VarJ, "getTypeConstructor(...)");
        return !kotlinTypeRefiner.e(v0VarJ) ? (T) e() : (T) kotlinTypeRefiner.c(this.f2440a, new U(this, kotlinTypeRefiner));
    }

    public final T e() {
        return (T) C5868k.a(this.f2443d, this, f2439f[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V(InterfaceC0797b interfaceC0797b, InterfaceC5869l interfaceC5869l, InterfaceC5074l<? super kotlin.reflect.jvm.internal.impl.types.checker.c, ? extends T> interfaceC5074l, kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        this.f2440a = interfaceC0797b;
        this.f2441b = interfaceC5074l;
        this.f2442c = cVar;
        this.f2443d = interfaceC5869l.i(new T(this));
    }
}
