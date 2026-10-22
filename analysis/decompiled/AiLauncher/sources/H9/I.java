package H9;

import E9.C0818x;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public interface I {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3020a = a.f3021a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f3021a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final C0818x<I> f3022b = new C0818x<>("PackageViewDescriptorFactory");

        public final C0818x<I> a() {
            return f3022b;
        }
    }

    public static final class b implements I {

        /* renamed from: b, reason: collision with root package name */
        public static final b f3023b = new b();

        @Override // H9.I
        public E9.L a(F module, ga.c fqName, InterfaceC5869l storageManager) {
            kotlin.jvm.internal.p.i(module, "module");
            kotlin.jvm.internal.p.i(fqName, "fqName");
            kotlin.jvm.internal.p.i(storageManager, "storageManager");
            return new C0844x(module, fqName, storageManager);
        }
    }

    E9.L a(F f10, ga.c cVar, InterfaceC5869l interfaceC5869l);
}
