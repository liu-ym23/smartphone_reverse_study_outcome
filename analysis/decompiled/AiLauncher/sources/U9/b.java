package U9;

import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.W;
import H9.C0830i;
import Z8.C1173v;
import java.util.List;
import ka.C4827g;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import ya.S;

/* loaded from: classes5.dex */
public class b extends C0830i implements a {

    /* renamed from: F, reason: collision with root package name */
    public Boolean f6317F;

    /* renamed from: G, reason: collision with root package name */
    public Boolean f6318G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(InterfaceC0797b interfaceC0797b, b bVar, F9.g gVar, boolean z10, CallableMemberDescriptor.Kind kind, W w10) {
        super(interfaceC0797b, bVar, gVar, z10, kind, w10);
        if (interfaceC0797b == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (kind == null) {
            T(2);
        }
        if (w10 == null) {
            T(3);
        }
        this.f6317F = null;
        this.f6318G = null;
    }

    private static /* synthetic */ void T(int i10) {
        String str = (i10 == 11 || i10 == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 11 || i10 == 18) ? 2 : 3];
        switch (i10) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i10 == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i10 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 11 && i10 != 18) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static b n1(InterfaceC0797b interfaceC0797b, F9.g gVar, boolean z10, W w10) {
        if (interfaceC0797b == null) {
            T(4);
        }
        if (gVar == null) {
            T(5);
        }
        if (w10 == null) {
            T(6);
        }
        return new b(interfaceC0797b, null, gVar, z10, CallableMemberDescriptor.Kind.DECLARATION, w10);
    }

    @Override // H9.AbstractC0839s
    public boolean K0() {
        return this.f6317F.booleanValue();
    }

    @Override // H9.AbstractC0839s
    public void S0(boolean z10) {
        this.f6317F = Boolean.valueOf(z10);
    }

    @Override // H9.AbstractC0839s
    public void T0(boolean z10) {
        this.f6318G = Boolean.valueOf(z10);
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean b0() {
        return this.f6318G.booleanValue();
    }

    public b m1(InterfaceC0797b interfaceC0797b, b bVar, CallableMemberDescriptor.Kind kind, W w10, F9.g gVar) {
        if (interfaceC0797b == null) {
            T(12);
        }
        if (kind == null) {
            T(13);
        }
        if (w10 == null) {
            T(14);
        }
        if (gVar == null) {
            T(15);
        }
        return new b(interfaceC0797b, bVar, gVar, this.f3129E, kind, w10);
    }

    @Override // H9.C0830i
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public b F0(InterfaceC0803h interfaceC0803h, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, CallableMemberDescriptor.Kind kind, ga.e eVar2, F9.g gVar, W w10) {
        if (interfaceC0803h == null) {
            T(7);
        }
        if (kind == null) {
            T(8);
        }
        if (gVar == null) {
            T(9);
        }
        if (w10 == null) {
            T(10);
        }
        if (kind == CallableMemberDescriptor.Kind.DECLARATION || kind == CallableMemberDescriptor.Kind.SYNTHESIZED) {
            b bVarM1 = m1((InterfaceC0797b) interfaceC0803h, (b) eVar, kind, w10, gVar);
            bVarM1.S0(K0());
            bVarM1.T0(b0());
            return bVarM1;
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + interfaceC0803h + "\nkind: " + kind);
    }

    @Override // U9.a
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public b B0(S s10, List<S> list, S s11, Pair<a.InterfaceC0437a<?>, ?> pair) {
        if (list == null) {
            T(16);
        }
        if (s11 == null) {
            T(17);
        }
        b bVarF0 = F0(b(), null, getKind(), null, getAnnotations(), e());
        bVarF0.L0(s10 == null ? null : C4827g.i(bVarF0, s10, F9.g.f2609m0.b()), H(), C1173v.m(), getTypeParameters(), g.a(list, i(), bVarF0), s11, p(), getVisibility());
        if (pair != null) {
            bVarF0.O0(pair.e(), pair.f());
        }
        return bVarF0;
    }
}
