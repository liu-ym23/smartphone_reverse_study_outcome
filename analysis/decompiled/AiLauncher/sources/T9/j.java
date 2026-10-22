package T9;

import E9.InterfaceC0797b;
import E9.O;
import Z9.q;

/* loaded from: classes5.dex */
public interface j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f5904a = new a();

    public static class a implements j {
        public static /* synthetic */ void f(int i10) {
            Object[] objArr = new Object[3];
            switch (i10) {
                case 1:
                    objArr[0] = "member";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i10) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // T9.j
        public void a(Z9.l lVar, kotlin.reflect.jvm.internal.impl.descriptors.c cVar) {
            if (lVar == null) {
                f(3);
            }
            if (cVar == null) {
                f(4);
            }
        }

        @Override // T9.j
        public void b(q qVar, kotlin.reflect.jvm.internal.impl.descriptors.g gVar) {
            if (qVar == null) {
                f(1);
            }
            if (gVar == null) {
                f(2);
            }
        }

        @Override // T9.j
        public void c(Z9.n nVar, O o10) {
            if (nVar == null) {
                f(5);
            }
            if (o10 == null) {
                f(6);
            }
        }

        @Override // T9.j
        public void d(Z9.g gVar, InterfaceC0797b interfaceC0797b) {
            if (gVar == null) {
                f(7);
            }
            if (interfaceC0797b == null) {
                f(8);
            }
        }

        @Override // T9.j
        public InterfaceC0797b e(ga.c cVar) {
            if (cVar != null) {
                return null;
            }
            f(0);
            return null;
        }
    }

    void a(Z9.l lVar, kotlin.reflect.jvm.internal.impl.descriptors.c cVar);

    void b(q qVar, kotlin.reflect.jvm.internal.impl.descriptors.g gVar);

    void c(Z9.n nVar, O o10);

    void d(Z9.g gVar, InterfaceC0797b interfaceC0797b);

    InterfaceC0797b e(ga.c cVar);
}
