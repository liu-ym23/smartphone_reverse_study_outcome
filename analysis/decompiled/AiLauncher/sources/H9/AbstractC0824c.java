package H9;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0797b;
import E9.InterfaceC0805j;
import E9.b0;
import E9.i0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: H9.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0824c extends AbstractC0834m implements E9.S {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0824c(F9.g gVar) {
        super(gVar, ga.g.f32749i);
        if (gVar == null) {
            T(0);
        }
    }

    private static /* synthetic */ void T(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "substitutor";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 5:
                objArr[1] = "getTypeParameters";
                break;
            case 6:
                objArr[1] = "getType";
                break;
            case 7:
                objArr[1] = "getValueParameters";
                break;
            case 8:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 9:
                objArr[1] = "getVisibility";
                break;
            case 10:
                objArr[1] = "getOriginal";
                break;
            case 11:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i10) {
            case 3:
                objArr[2] = "substitute";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public E9.S H() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public E9.S K() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean b0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> d() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            T(8);
        }
        return set;
    }

    @Override // E9.InterfaceC0806k
    public E9.W e() {
        E9.W w10 = E9.W.f2444a;
        if (w10 == null) {
            T(11);
        }
        return w10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public ya.S getReturnType() {
        return getType();
    }

    @Override // E9.h0
    public ya.S getType() {
        ya.S type = getValue().getType();
        if (type == null) {
            T(6);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<b0> getTypeParameters() {
        List<b0> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(5);
        }
        return list;
    }

    @Override // E9.InterfaceC0807l, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        AbstractC0811p abstractC0811p = C0810o.f2474f;
        if (abstractC0811p == null) {
            T(9);
        }
        return abstractC0811p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<i0> i() {
        List<i0> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(7);
        }
        return list;
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> interfaceC0805j, D d10) {
        return interfaceC0805j.d(this, d10);
    }

    @Override // H9.AbstractC0834m, E9.InterfaceC0803h
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public E9.M a() {
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0824c(F9.g gVar, ga.e eVar) {
        super(gVar, eVar);
        if (gVar == null) {
            T(1);
        }
        if (eVar == null) {
            T(2);
        }
    }

    @Override // E9.Y
    public E9.S c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            T(3);
        }
        if (!typeSubstitutor.l()) {
            ya.S sQ = b() instanceof InterfaceC0797b ? typeSubstitutor.q(getType(), Variance.OUT_VARIANCE) : typeSubstitutor.q(getType(), Variance.INVARIANT);
            if (sQ == null) {
                return null;
            }
            if (sQ != getType()) {
                return new N(b(), new sa.j(sQ), getAnnotations());
            }
        }
        return this;
    }
}
