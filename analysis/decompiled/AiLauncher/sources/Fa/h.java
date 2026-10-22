package Fa;

import Fa.g;
import java.util.Arrays;
import java.util.Collection;
import kotlin.text.Regex;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final ga.e f2641a;

    /* renamed from: b, reason: collision with root package name */
    public final Regex f2642b;

    /* renamed from: c, reason: collision with root package name */
    public final Collection<ga.e> f2643c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5074l<kotlin.reflect.jvm.internal.impl.descriptors.e, String> f2644d;

    /* renamed from: e, reason: collision with root package name */
    public final f[] f2645e;

    public static final class a implements InterfaceC5074l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2646a = new a();

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            kotlin.jvm.internal.p.i(eVar, "<this>");
            return null;
        }
    }

    public static final class b implements InterfaceC5074l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f2647a = new b();

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            kotlin.jvm.internal.p.i(eVar, "<this>");
            return null;
        }
    }

    public static final class c implements InterfaceC5074l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f2648a = new c();

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            kotlin.jvm.internal.p.i(eVar, "<this>");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(ga.e eVar, Regex regex, Collection<ga.e> collection, InterfaceC5074l<? super kotlin.reflect.jvm.internal.impl.descriptors.e, String> interfaceC5074l, f... fVarArr) {
        this.f2641a = eVar;
        this.f2642b = regex;
        this.f2643c = collection;
        this.f2644d = interfaceC5074l;
        this.f2645e = fVarArr;
    }

    public final g a(kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
        kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
        for (f fVar : this.f2645e) {
            String strA = fVar.a(functionDescriptor);
            if (strA != null) {
                return new g.b(strA);
            }
        }
        String strInvoke = this.f2644d.invoke(functionDescriptor);
        return strInvoke != null ? new g.b(strInvoke) : g.c.f2640b;
    }

    public final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
        kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
        if (this.f2641a != null && !kotlin.jvm.internal.p.d(functionDescriptor.getName(), this.f2641a)) {
            return false;
        }
        if (this.f2642b != null) {
            String strB = functionDescriptor.getName().b();
            kotlin.jvm.internal.p.h(strB, "asString(...)");
            if (!this.f2642b.k(strB)) {
                return false;
            }
        }
        Collection<ga.e> collection = this.f2643c;
        return collection == null || collection.contains(functionDescriptor.getName());
    }

    public /* synthetic */ h(ga.e eVar, f[] fVarArr, InterfaceC5074l interfaceC5074l, int i10, kotlin.jvm.internal.i iVar) {
        this(eVar, fVarArr, (InterfaceC5074l<? super kotlin.reflect.jvm.internal.impl.descriptors.e, String>) ((i10 & 4) != 0 ? a.f2646a : interfaceC5074l));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(ga.e name, f[] checks, InterfaceC5074l<? super kotlin.reflect.jvm.internal.impl.descriptors.e, String> additionalChecks) {
        this(name, (Regex) null, (Collection<ga.e>) null, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(checks, "checks");
        kotlin.jvm.internal.p.i(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ h(Regex regex, f[] fVarArr, InterfaceC5074l interfaceC5074l, int i10, kotlin.jvm.internal.i iVar) {
        this(regex, fVarArr, (InterfaceC5074l<? super kotlin.reflect.jvm.internal.impl.descriptors.e, String>) ((i10 & 4) != 0 ? b.f2647a : interfaceC5074l));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Regex regex, f[] checks, InterfaceC5074l<? super kotlin.reflect.jvm.internal.impl.descriptors.e, String> additionalChecks) {
        this((ga.e) null, regex, (Collection<ga.e>) null, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        kotlin.jvm.internal.p.i(regex, "regex");
        kotlin.jvm.internal.p.i(checks, "checks");
        kotlin.jvm.internal.p.i(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ h(Collection collection, f[] fVarArr, InterfaceC5074l interfaceC5074l, int i10, kotlin.jvm.internal.i iVar) {
        this((Collection<ga.e>) collection, fVarArr, (InterfaceC5074l<? super kotlin.reflect.jvm.internal.impl.descriptors.e, String>) ((i10 & 4) != 0 ? c.f2648a : interfaceC5074l));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Collection<ga.e> nameList, f[] checks, InterfaceC5074l<? super kotlin.reflect.jvm.internal.impl.descriptors.e, String> additionalChecks) {
        this((ga.e) null, (Regex) null, nameList, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        kotlin.jvm.internal.p.i(nameList, "nameList");
        kotlin.jvm.internal.p.i(checks, "checks");
        kotlin.jvm.internal.p.i(additionalChecks, "additionalChecks");
    }
}
