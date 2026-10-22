package H9;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0805j;
import E9.a0;
import java.util.Collections;
import java.util.List;
import ka.C4828h;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import ra.C5234g;
import ra.InterfaceC5238k;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.E0;
import ya.H0;

/* renamed from: H9.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0822a extends z {

    /* renamed from: b, reason: collision with root package name */
    public final ga.e f3097b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5865h<AbstractC5990d0> f3098c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5865h<InterfaceC5238k> f3099d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5865h<E9.S> f3100e;

    /* renamed from: H9.a$a, reason: collision with other inner class name */
    public class C0048a implements InterfaceC5063a<AbstractC5990d0> {

        /* renamed from: H9.a$a$a, reason: collision with other inner class name */
        public class C0049a implements InterfaceC5074l<kotlin.reflect.jvm.internal.impl.types.checker.c, AbstractC5990d0> {
            public C0049a() {
            }

            @Override // p9.InterfaceC5074l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AbstractC5990d0 invoke(kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
                InterfaceC0799d interfaceC0799dF = cVar.f(AbstractC0822a.this);
                return interfaceC0799dF == null ? AbstractC0822a.this.f3098c.invoke() : interfaceC0799dF instanceof a0 ? ya.V.c((a0) interfaceC0799dF, H0.g(interfaceC0799dF.j().getParameters())) : interfaceC0799dF instanceof z ? H0.v(interfaceC0799dF.j().a(cVar), ((z) interfaceC0799dF).c0(cVar), this) : interfaceC0799dF.n();
            }
        }

        public C0048a() {
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC5990d0 invoke() {
            AbstractC0822a abstractC0822a = AbstractC0822a.this;
            return H0.u(abstractC0822a, abstractC0822a.R(), new C0049a());
        }
    }

    /* renamed from: H9.a$b */
    public class b implements InterfaceC5063a<InterfaceC5238k> {
        public b() {
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC5238k invoke() {
            return new C5234g(AbstractC0822a.this.R());
        }
    }

    /* renamed from: H9.a$c */
    public class c implements InterfaceC5063a<E9.S> {
        public c() {
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public E9.S invoke() {
            return new C0840t(AbstractC0822a.this);
        }
    }

    public AbstractC0822a(InterfaceC5869l interfaceC5869l, ga.e eVar) {
        if (interfaceC5869l == null) {
            y0(0);
        }
        if (eVar == null) {
            y0(1);
        }
        this.f3097b = eVar;
        this.f3098c = interfaceC5869l.i(new C0048a());
        this.f3099d = interfaceC5869l.i(new b());
        this.f3100e = interfaceC5869l.i(new c());
    }

    private static /* synthetic */ void y0(int i10) {
        String str = (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 6 || i10 == 9 || i10 == 12 || i10 == 14 || i10 == 16 || i10 == 17 || i10 == 19 || i10 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 6 || i10 == 9 || i10 == 12 || i10 == 14 || i10 == 16 || i10 == 17 || i10 == 19 || i10 == 20) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 7:
            case 13:
                objArr[0] = "typeArguments";
                break;
            case 8:
            case 11:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 10:
            case 15:
                objArr[0] = "typeSubstitution";
                break;
            case 18:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i10 == 2) {
            objArr[1] = "getName";
        } else if (i10 == 3) {
            objArr[1] = "getOriginal";
        } else if (i10 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i10 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i10 == 6) {
            objArr[1] = "getContextReceivers";
        } else if (i10 == 9 || i10 == 12 || i10 == 14 || i10 == 16) {
            objArr[1] = "getMemberScope";
        } else if (i10 == 17) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i10 == 19) {
            objArr[1] = "substitute";
        } else if (i10 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                break;
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
                objArr[2] = "getMemberScope";
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5 && i10 != 6 && i10 != 9 && i10 != 12 && i10 != 14 && i10 != 16 && i10 != 17 && i10 != 19 && i10 != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // E9.Y
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public InterfaceC0797b c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            y0(18);
        }
        return typeSubstitutor.l() ? this : new C0845y(this, typeSubstitutor);
    }

    @Override // E9.InterfaceC0797b
    public E9.S D0() {
        E9.S sInvoke = this.f3100e.invoke();
        if (sInvoke == null) {
            y0(5);
        }
        return sInvoke;
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC5238k O() {
        InterfaceC5238k interfaceC5238kInvoke = this.f3099d.invoke();
        if (interfaceC5238kInvoke == null) {
            y0(4);
        }
        return interfaceC5238kInvoke;
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC5238k R() {
        InterfaceC5238k interfaceC5238kC0 = c0(DescriptorUtilsKt.r(C4828h.g(this)));
        if (interfaceC5238kC0 == null) {
            y0(17);
        }
        return interfaceC5238kC0;
    }

    @Override // H9.z
    public InterfaceC5238k T(E0 e02, kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        if (e02 == null) {
            y0(10);
        }
        if (cVar == null) {
            y0(11);
        }
        if (!e02.f()) {
            return new ra.t(c0(cVar), TypeSubstitutor.h(e02));
        }
        InterfaceC5238k interfaceC5238kC0 = c0(cVar);
        if (interfaceC5238kC0 == null) {
            y0(12);
        }
        return interfaceC5238kC0;
    }

    @Override // E9.InterfaceC0797b
    public List<E9.S> V() {
        List<E9.S> list = Collections.EMPTY_LIST;
        if (list == null) {
            y0(6);
        }
        return list;
    }

    @Override // E9.A
    public ga.e getName() {
        ga.e eVar = this.f3097b;
        if (eVar == null) {
            y0(2);
        }
        return eVar;
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC5238k k0(E0 e02) {
        if (e02 == null) {
            y0(15);
        }
        InterfaceC5238k interfaceC5238kT = T(e02, DescriptorUtilsKt.r(C4828h.g(this)));
        if (interfaceC5238kT == null) {
            y0(16);
        }
        return interfaceC5238kT;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0799d
    public AbstractC5990d0 n() {
        AbstractC5990d0 abstractC5990d0Invoke = this.f3098c.invoke();
        if (abstractC5990d0Invoke == null) {
            y0(20);
        }
        return abstractC5990d0Invoke;
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> interfaceC0805j, D d10) {
        return interfaceC0805j.a(this, d10);
    }

    @Override // H9.z, E9.InterfaceC0803h
    public InterfaceC0797b a() {
        return this;
    }
}
