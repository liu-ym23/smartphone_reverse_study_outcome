package U9;

import C9.j;
import E9.AbstractC0811p;
import E9.C0801f;
import E9.InterfaceC0803h;
import E9.O;
import E9.Q;
import E9.W;
import H9.K;
import H9.L;
import H9.M;
import Z8.C1173v;
import aa.q0;
import java.util.List;
import ka.C4827g;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import ma.AbstractC4927g;
import p9.InterfaceC5063a;
import xa.InterfaceC5866i;
import ya.S;

/* loaded from: classes5.dex */
public class e extends K implements a {

    /* renamed from: C, reason: collision with root package name */
    public final boolean f6322C;

    /* renamed from: D, reason: collision with root package name */
    public final Pair<a.InterfaceC0437a<?>, ?> f6323D;

    /* renamed from: E, reason: collision with root package name */
    public S f6324E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(InterfaceC0803h interfaceC0803h, F9.g gVar, Modality modality, AbstractC0811p abstractC0811p, boolean z10, ga.e eVar, W w10, O o10, CallableMemberDescriptor.Kind kind, boolean z11, Pair<a.InterfaceC0437a<?>, ?> pair) {
        super(interfaceC0803h, o10, gVar, modality, abstractC0811p, z10, eVar, kind, w10, false, false, false, false, false, false);
        if (interfaceC0803h == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (modality == null) {
            T(2);
        }
        if (abstractC0811p == null) {
            T(3);
        }
        if (eVar == null) {
            T(4);
        }
        if (w10 == null) {
            T(5);
        }
        if (kind == null) {
            T(6);
        }
        this.f6324E = null;
        this.f6322C = z11;
        this.f6323D = pair;
    }

    private static /* synthetic */ void T(int i10) {
        String str = i10 != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 21 ? 3 : 2];
        switch (i10) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case 22:
                objArr[0] = "inType";
                break;
        }
        if (i10 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            case 22:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 == 21) {
            throw new IllegalStateException(str2);
        }
    }

    public static e Z0(InterfaceC0803h interfaceC0803h, F9.g gVar, Modality modality, AbstractC0811p abstractC0811p, boolean z10, ga.e eVar, W w10, boolean z11) {
        if (interfaceC0803h == null) {
            T(7);
        }
        if (gVar == null) {
            T(8);
        }
        if (modality == null) {
            T(9);
        }
        if (abstractC0811p == null) {
            T(10);
        }
        if (eVar == null) {
            T(11);
        }
        if (w10 == null) {
            T(12);
        }
        return new e(interfaceC0803h, gVar, modality, abstractC0811p, z10, eVar, w10, null, CallableMemberDescriptor.Kind.DECLARATION, z11, null);
    }

    @Override // U9.a
    public a B0(S s10, List<S> list, S s11, Pair<a.InterfaceC0437a<?>, ?> pair) {
        L l10;
        M m10;
        if (list == null) {
            T(19);
        }
        if (s11 == null) {
            T(20);
        }
        O oA = a() == this ? null : a();
        e eVar = new e(b(), getAnnotations(), p(), getVisibility(), J(), getName(), e(), oA, getKind(), this.f6322C, pair);
        L getter = getGetter();
        if (getter != null) {
            L l11 = new L(eVar, getter.getAnnotations(), getter.p(), getter.getVisibility(), getter.D(), getter.isExternal(), getter.isInline(), getKind(), oA == null ? null : oA.getGetter(), getter.e());
            l11.H0(getter.m0());
            l11.K0(s11);
            l10 = l11;
        } else {
            l10 = null;
        }
        Q setter = getSetter();
        if (setter != null) {
            m10 = new M(eVar, setter.getAnnotations(), setter.p(), setter.getVisibility(), setter.D(), setter.isExternal(), setter.isInline(), getKind(), oA == null ? null : oA.getSetter(), setter.e());
            m10.H0(m10.m0());
            m10.L0(setter.i().get(0));
        } else {
            m10 = null;
        }
        eVar.P0(l10, m10, r0(), L());
        eVar.U0(Q0());
        InterfaceC5063a<InterfaceC5866i<AbstractC4927g<?>>> interfaceC5063a = this.f3096h;
        if (interfaceC5063a != null) {
            eVar.E0(this.f3095g, interfaceC5063a);
        }
        eVar.x0(d());
        eVar.V0(s11, getTypeParameters(), H(), s10 != null ? C4827g.i(this, s10, F9.g.f2609m0.b()) : null, C1173v.m());
        return eVar;
    }

    @Override // H9.K
    public K J0(InterfaceC0803h interfaceC0803h, Modality modality, AbstractC0811p abstractC0811p, O o10, CallableMemberDescriptor.Kind kind, ga.e eVar, W w10) {
        if (interfaceC0803h == null) {
            T(13);
        }
        if (modality == null) {
            T(14);
        }
        if (abstractC0811p == null) {
            T(15);
        }
        if (kind == null) {
            T(16);
        }
        if (eVar == null) {
            T(17);
        }
        if (w10 == null) {
            T(18);
        }
        return new e(interfaceC0803h, getAnnotations(), modality, abstractC0811p, J(), eVar, w10, o10, kind, this.f6322C, this.f6323D);
    }

    @Override // H9.K
    public void T0(S s10) {
        if (s10 == null) {
            T(22);
        }
        this.f6324E = s10;
    }

    @Override // H9.X, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean b0() {
        return false;
    }

    @Override // H9.K, E9.j0
    public boolean isConst() {
        S type = getType();
        if (this.f6322C && C0801f.a(type)) {
            return !q0.i(type) || j.w0(type);
        }
        return false;
    }

    @Override // H9.K, kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V o0(a.InterfaceC0437a<V> interfaceC0437a) {
        Pair<a.InterfaceC0437a<?>, ?> pair = this.f6323D;
        if (pair == null || !pair.e().equals(interfaceC0437a)) {
            return null;
        }
        return (V) this.f6323D.f();
    }
}
