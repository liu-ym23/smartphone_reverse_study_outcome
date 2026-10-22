package Fa;

import Fa.f;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import p9.InterfaceC5074l;
import ya.AbstractC5990d0;
import ya.S;

/* loaded from: classes5.dex */
public abstract class v implements f {

    /* renamed from: a, reason: collision with root package name */
    public final String f2727a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5074l<C9.j, S> f2728b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2729c;

    public static final class a extends v {

        /* renamed from: d, reason: collision with root package name */
        public static final a f2730d = new a();

        public a() {
            super("Boolean", u.f2726a, null);
        }

        public static final S c(C9.j jVar) {
            kotlin.jvm.internal.p.i(jVar, "<this>");
            AbstractC5990d0 abstractC5990d0O = jVar.o();
            kotlin.jvm.internal.p.h(abstractC5990d0O, "getBooleanType(...)");
            return abstractC5990d0O;
        }
    }

    public static final class b extends v {

        /* renamed from: d, reason: collision with root package name */
        public static final b f2731d = new b();

        public b() {
            super("Int", w.f2733a, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final S c(C9.j jVar) {
            kotlin.jvm.internal.p.i(jVar, "<this>");
            AbstractC5990d0 abstractC5990d0E = jVar.E();
            kotlin.jvm.internal.p.h(abstractC5990d0E, "getIntType(...)");
            return abstractC5990d0E;
        }
    }

    public static final class c extends v {

        /* renamed from: d, reason: collision with root package name */
        public static final c f2732d = new c();

        public c() {
            super("Unit", x.f2734a, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final S c(C9.j jVar) {
            kotlin.jvm.internal.p.i(jVar, "<this>");
            AbstractC5990d0 abstractC5990d0A0 = jVar.a0();
            kotlin.jvm.internal.p.h(abstractC5990d0A0, "getUnitType(...)");
            return abstractC5990d0A0;
        }
    }

    public /* synthetic */ v(String str, InterfaceC5074l interfaceC5074l, kotlin.jvm.internal.i iVar) {
        this(str, interfaceC5074l);
    }

    @Override // Fa.f
    public /* bridge */ String a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        return f.a.a(this, eVar);
    }

    @Override // Fa.f
    public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
        kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
        return kotlin.jvm.internal.p.d(functionDescriptor.getReturnType(), this.f2728b.invoke(DescriptorUtilsKt.m(functionDescriptor)));
    }

    @Override // Fa.f
    public String getDescription() {
        return this.f2729c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(String str, InterfaceC5074l<? super C9.j, ? extends S> interfaceC5074l) {
        this.f2727a = str;
        this.f2728b = interfaceC5074l;
        this.f2729c = "must return " + str;
    }
}
