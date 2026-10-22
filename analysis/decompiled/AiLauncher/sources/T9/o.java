package T9;

import E9.InterfaceC0797b;
import E9.b0;
import E9.i0;
import Z9.r;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import ya.S;

/* loaded from: classes5.dex */
public interface o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f5911a = new a();

    public static class a implements o {
        public static /* synthetic */ void c(int i10) {
            Object[] objArr = new Object[3];
            switch (i10) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = "method";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i10 == 5 || i10 == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // T9.o
        public b a(r rVar, InterfaceC0797b interfaceC0797b, S s10, S s11, List<i0> list, List<b0> list2) {
            if (rVar == null) {
                c(0);
            }
            if (interfaceC0797b == null) {
                c(1);
            }
            if (s10 == null) {
                c(2);
            }
            if (list == null) {
                c(3);
            }
            if (list2 == null) {
                c(4);
            }
            return new b(s10, s11, list, list2, Collections.EMPTY_LIST, false);
        }

        @Override // T9.o
        public void b(CallableMemberDescriptor callableMemberDescriptor, List<String> list) {
            if (callableMemberDescriptor == null) {
                c(5);
            }
            if (list == null) {
                c(6);
            }
            throw new UnsupportedOperationException("Should not be called");
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final S f5912a;

        /* renamed from: b, reason: collision with root package name */
        public final S f5913b;

        /* renamed from: c, reason: collision with root package name */
        public final List<i0> f5914c;

        /* renamed from: d, reason: collision with root package name */
        public final List<b0> f5915d;

        /* renamed from: e, reason: collision with root package name */
        public final List<String> f5916e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f5917f;

        public b(S s10, S s11, List<i0> list, List<b0> list2, List<String> list3, boolean z10) {
            if (s10 == null) {
                a(0);
            }
            if (list == null) {
                a(1);
            }
            if (list2 == null) {
                a(2);
            }
            if (list3 == null) {
                a(3);
            }
            this.f5912a = s10;
            this.f5913b = s11;
            this.f5914c = list;
            this.f5915d = list2;
            this.f5916e = list3;
            this.f5917f = z10;
        }

        public static /* synthetic */ void a(int i10) {
            String str = (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : 3];
            switch (i10) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i10 == 4) {
                objArr[1] = "getReturnType";
            } else if (i10 == 5) {
                objArr[1] = "getValueParameters";
            } else if (i10 == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i10 != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
            }
            if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public List<String> b() {
            List<String> list = this.f5916e;
            if (list == null) {
                a(7);
            }
            return list;
        }

        public S c() {
            return this.f5913b;
        }

        public S d() {
            S s10 = this.f5912a;
            if (s10 == null) {
                a(4);
            }
            return s10;
        }

        public List<b0> e() {
            List<b0> list = this.f5915d;
            if (list == null) {
                a(6);
            }
            return list;
        }

        public List<i0> f() {
            List<i0> list = this.f5914c;
            if (list == null) {
                a(5);
            }
            return list;
        }

        public boolean g() {
            return this.f5917f;
        }
    }

    b a(r rVar, InterfaceC0797b interfaceC0797b, S s10, S s11, List<i0> list, List<b0> list2);

    void b(CallableMemberDescriptor callableMemberDescriptor, List<String> list);
}
