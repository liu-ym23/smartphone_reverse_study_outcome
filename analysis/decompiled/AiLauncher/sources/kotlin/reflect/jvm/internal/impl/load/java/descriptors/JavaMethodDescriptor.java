package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import E9.AbstractC0811p;
import E9.InterfaceC0803h;
import E9.S;
import E9.W;
import E9.b0;
import E9.i0;
import Fa.s;
import H9.O;
import ga.e;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import java.util.Map;
import ka.C4827g;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.g;

/* loaded from: classes5.dex */
public class JavaMethodDescriptor extends O implements U9.a {

    /* renamed from: G, reason: collision with root package name */
    public static final a.InterfaceC0437a<i0> f35120G = new a();

    /* renamed from: H, reason: collision with root package name */
    public static final a.InterfaceC0437a<Boolean> f35121H = new b();

    /* renamed from: E, reason: collision with root package name */
    public ParameterNamesStatus f35122E;

    /* renamed from: F, reason: collision with root package name */
    public final boolean f35123F;

    public enum ParameterNamesStatus {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);

        public final boolean isStable;
        public final boolean isSynthesized;

        private static /* synthetic */ void $$$reportNull$$$0(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
        }

        ParameterNamesStatus(boolean z10, boolean z11) {
            this.isStable = z10;
            this.isSynthesized = z11;
        }

        public static ParameterNamesStatus get(boolean z10, boolean z11) {
            ParameterNamesStatus parameterNamesStatus = z10 ? z11 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z11 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            if (parameterNamesStatus == null) {
                $$$reportNull$$$0(0);
            }
            return parameterNamesStatus;
        }
    }

    public static class a implements a.InterfaceC0437a<i0> {
    }

    public static class b implements a.InterfaceC0437a<Boolean> {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaMethodDescriptor(InterfaceC0803h interfaceC0803h, g gVar, F9.g gVar2, e eVar, CallableMemberDescriptor.Kind kind, W w10, boolean z10) {
        super(interfaceC0803h, gVar, gVar2, eVar, kind, w10);
        if (interfaceC0803h == null) {
            T(0);
        }
        if (gVar2 == null) {
            T(1);
        }
        if (eVar == null) {
            T(2);
        }
        if (kind == null) {
            T(3);
        }
        if (w10 == null) {
            T(4);
        }
        this.f35122E = null;
        this.f35123F = z10;
    }

    private static /* synthetic */ void T(int i10) {
        String str = (i10 == 13 || i10 == 18 || i10 == 21) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 13 || i10 == 18 || i10 == 21) ? 2 : 3];
        switch (i10) {
            case 1:
            case 6:
            case 16:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 15:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 17:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "contextReceiverParameters";
                break;
            case 10:
                objArr[0] = "typeParameters";
                break;
            case 11:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 14:
                objArr[0] = "newOwner";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i10 == 13) {
            objArr[1] = McpSchema.METHOD_INITIALIZE;
        } else if (i10 == 18) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i10 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = McpSchema.METHOD_INITIALIZE;
                break;
            case 13:
            case 18:
            case 21:
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 13 && i10 != 18 && i10 != 21) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static JavaMethodDescriptor j1(InterfaceC0803h interfaceC0803h, F9.g gVar, e eVar, W w10, boolean z10) {
        if (interfaceC0803h == null) {
            T(5);
        }
        if (gVar == null) {
            T(6);
        }
        if (eVar == null) {
            T(7);
        }
        if (w10 == null) {
            T(8);
        }
        return new JavaMethodDescriptor(interfaceC0803h, null, gVar, eVar, CallableMemberDescriptor.Kind.DECLARATION, w10, z10);
    }

    @Override // H9.AbstractC0839s
    public boolean K0() {
        return this.f35122E.isStable;
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean b0() {
        return this.f35122E.isSynthesized;
    }

    @Override // H9.O
    public O i1(S s10, S s11, List<S> list, List<? extends b0> list2, List<i0> list3, ya.S s12, Modality modality, AbstractC0811p abstractC0811p, Map<? extends a.InterfaceC0437a<?>, ?> map) {
        if (list == null) {
            T(9);
        }
        if (list2 == null) {
            T(10);
        }
        if (list3 == null) {
            T(11);
        }
        if (abstractC0811p == null) {
            T(12);
        }
        O oI1 = super.i1(s10, s11, list, list2, list3, s12, modality, abstractC0811p, map);
        Z0(s.f2665a.a(oI1).a());
        if (oI1 == null) {
            T(13);
        }
        return oI1;
    }

    @Override // H9.O, H9.AbstractC0839s
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public JavaMethodDescriptor F0(InterfaceC0803h interfaceC0803h, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, CallableMemberDescriptor.Kind kind, e eVar2, F9.g gVar, W w10) {
        if (interfaceC0803h == null) {
            T(14);
        }
        if (kind == null) {
            T(15);
        }
        if (gVar == null) {
            T(16);
        }
        if (w10 == null) {
            T(17);
        }
        g gVar2 = (g) eVar;
        if (eVar2 == null) {
            eVar2 = getName();
        }
        JavaMethodDescriptor javaMethodDescriptor = new JavaMethodDescriptor(interfaceC0803h, gVar2, gVar, eVar2, kind, w10, this.f35123F);
        javaMethodDescriptor.m1(K0(), b0());
        return javaMethodDescriptor;
    }

    @Override // U9.a
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public JavaMethodDescriptor B0(ya.S s10, List<ya.S> list, ya.S s11, Pair<a.InterfaceC0437a<?>, ?> pair) {
        if (list == null) {
            T(19);
        }
        if (s11 == null) {
            T(20);
        }
        JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) s().b(U9.g.a(list, i(), this)).o(s11).k(s10 == null ? null : C4827g.i(this, s10, F9.g.f2609m0.b())).a().j().build();
        if (pair != null) {
            javaMethodDescriptor.O0(pair.e(), pair.f());
        }
        if (javaMethodDescriptor == null) {
            T(21);
        }
        return javaMethodDescriptor;
    }

    public void m1(boolean z10, boolean z11) {
        this.f35122E = ParameterNamesStatus.get(z10, z11);
    }
}
