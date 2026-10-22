package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import C9.o;
import E9.E;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.InterfaceC0819y;
import E9.W;
import H9.C0832k;
import Z8.C1172u;
import Z8.F;
import Z8.X;
import Z8.Y;
import ga.d;
import ga.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import p9.InterfaceC5074l;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public final class c implements G9.b {

    /* renamed from: g, reason: collision with root package name */
    public static final e f35004g;

    /* renamed from: h, reason: collision with root package name */
    public static final ga.b f35005h;

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0819y f35006a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5074l<InterfaceC0819y, InterfaceC0803h> f35007b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5865h f35008c;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f35002e = {t.i(new PropertyReference1Impl(c.class, "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;", 0))};

    /* renamed from: d, reason: collision with root package name */
    public static final a f35001d = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final ga.c f35003f = o.f1810B;

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public final ga.b a() {
            return c.f35005h;
        }

        public a() {
        }
    }

    static {
        d dVar = o.a.f1900d;
        f35004g = dVar.j();
        f35005h = ga.b.f32721d.c(dVar.m());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(InterfaceC5869l storageManager, InterfaceC0819y moduleDescriptor, InterfaceC5074l<? super InterfaceC0819y, ? extends InterfaceC0803h> computeContainingDeclaration) {
        p.i(storageManager, "storageManager");
        p.i(moduleDescriptor, "moduleDescriptor");
        p.i(computeContainingDeclaration, "computeContainingDeclaration");
        this.f35006a = moduleDescriptor;
        this.f35007b = computeContainingDeclaration;
        this.f35008c = storageManager.i(new D9.c(this, storageManager));
    }

    public static final C9.c d(InterfaceC0819y module) {
        p.i(module, "module");
        List<E> listD0 = module.f0(f35003f).d0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listD0) {
            if (obj instanceof C9.c) {
                arrayList.add(obj);
            }
        }
        return (C9.c) F.q0(arrayList);
    }

    public static final C0832k h(c cVar, InterfaceC5869l interfaceC5869l) {
        C0832k c0832k = new C0832k(cVar.f35007b.invoke(cVar.f35006a), f35004g, Modality.ABSTRACT, ClassKind.INTERFACE, C1172u.e(cVar.f35006a.g().i()), W.f2444a, false, interfaceC5869l);
        c0832k.E0(new kotlin.reflect.jvm.internal.impl.builtins.jvm.a(interfaceC5869l, c0832k), Y.e(), null);
        return c0832k;
    }

    @Override // G9.b
    public InterfaceC0797b a(ga.b classId) {
        p.i(classId, "classId");
        if (p.d(classId, f35005h)) {
            return i();
        }
        return null;
    }

    @Override // G9.b
    public Collection<InterfaceC0797b> b(ga.c packageFqName) {
        p.i(packageFqName, "packageFqName");
        return p.d(packageFqName, f35003f) ? X.d(i()) : Y.e();
    }

    @Override // G9.b
    public boolean c(ga.c packageFqName, e name) {
        p.i(packageFqName, "packageFqName");
        p.i(name, "name");
        return p.d(name, f35004g) && p.d(packageFqName, f35003f);
    }

    public final C0832k i() {
        return (C0832k) C5868k.a(this.f35008c, this, f35002e[0]);
    }

    public /* synthetic */ c(InterfaceC5869l interfaceC5869l, InterfaceC0819y interfaceC0819y, InterfaceC5074l interfaceC5074l, int i10, i iVar) {
        this(interfaceC5869l, interfaceC0819y, (i10 & 4) != 0 ? D9.d.f2293a : interfaceC5074l);
    }
}
