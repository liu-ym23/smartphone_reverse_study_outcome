package pa;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import V9.j;
import W9.C;
import Z8.F;
import Z9.g;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import ra.InterfaceC5238k;

/* renamed from: pa.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5079c {

    /* renamed from: a, reason: collision with root package name */
    public final j f38251a;

    /* renamed from: b, reason: collision with root package name */
    public final T9.j f38252b;

    public C5079c(j packageFragmentProvider, T9.j javaResolverCache) {
        p.i(packageFragmentProvider, "packageFragmentProvider");
        p.i(javaResolverCache, "javaResolverCache");
        this.f38251a = packageFragmentProvider;
        this.f38252b = javaResolverCache;
    }

    public final j a() {
        return this.f38251a;
    }

    public final InterfaceC0797b b(g javaClass) {
        C c10;
        p.i(javaClass, "javaClass");
        ga.c cVarF = javaClass.f();
        if (cVarF != null && javaClass.G() == LightClassOriginKind.SOURCE) {
            return this.f38252b.e(cVarF);
        }
        g gVarL = javaClass.l();
        if (gVarL == null) {
            if (cVarF == null || (c10 = (C) F.s0(this.f38251a.b(cVarF.d()))) == null) {
                return null;
            }
            return c10.H0(javaClass);
        }
        InterfaceC0797b interfaceC0797bB = b(gVarL);
        InterfaceC5238k interfaceC5238kO = interfaceC0797bB != null ? interfaceC0797bB.O() : null;
        InterfaceC0799d interfaceC0799dD = interfaceC5238kO != null ? interfaceC5238kO.d(javaClass.getName(), NoLookupLocation.FROM_JAVA_LOADER) : null;
        if (interfaceC0799dD instanceof InterfaceC0797b) {
            return (InterfaceC0797b) interfaceC0799dD;
        }
        return null;
    }
}
