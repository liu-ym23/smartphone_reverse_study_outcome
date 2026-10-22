package H9;

import E9.InterfaceC0803h;
import E9.Z;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import xa.InterfaceC5869l;

/* renamed from: H9.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0823b extends AbstractC0829h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0823b(InterfaceC5869l interfaceC5869l, InterfaceC0803h interfaceC0803h, F9.g gVar, ga.e eVar, Variance variance, boolean z10, int i10, E9.W w10, Z z11) {
        super(interfaceC5869l, interfaceC0803h, gVar, eVar, variance, z10, i10, w10, z11);
        if (interfaceC5869l == null) {
            T(0);
        }
        if (interfaceC0803h == null) {
            T(1);
        }
        if (gVar == null) {
            T(2);
        }
        if (eVar == null) {
            T(3);
        }
        if (variance == null) {
            T(4);
        }
        if (w10 == null) {
            T(5);
        }
        if (z11 == null) {
            T(6);
        }
    }

    public static /* synthetic */ void T(int i10) {
        Object[] objArr = new Object[3];
        switch (i10) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // H9.AbstractC0834m
    public String toString() {
        String str = "";
        String str2 = w() ? "reified " : "";
        if (l() != Variance.INVARIANT) {
            str = l() + " ";
        }
        return String.format("%s%s%s", str2, str, getName());
    }
}
