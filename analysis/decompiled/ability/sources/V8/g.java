package V8;

import h8.C1533p;
import h8.InterfaceC1520c;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public final class g extends J8.m {
    public final /* synthetic */ int c;
    public final /* synthetic */ AbstractCollection d;

    public /* synthetic */ g(AbstractCollection abstractCollection, int i) {
        this.c = i;
        this.d = abstractCollection;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "fromSuper";
        } else if (i != 2) {
            objArr[0] = "fakeOverride";
        } else {
            objArr[0] = "fromCurrent";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
        if (i == 1 || i == 2) {
            objArr[2] = "conflict";
        } else {
            objArr[2] = "addFakeOverride";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // J8.m
    public final void b(InterfaceC1520c fakeOverride) {
        switch (this.c) {
            case 0:
                kotlin.jvm.internal.k.f(fakeOverride, "fakeOverride");
                J8.k.r(fakeOverride, null);
                ((ArrayList) this.d).add(fakeOverride);
                return;
            default:
                if (fakeOverride == null) {
                    a(0);
                    throw null;
                }
                J8.k.r(fakeOverride, null);
                ((LinkedHashSet) this.d).add(fakeOverride);
                return;
        }
    }

    @Override // J8.m
    public final void d(InterfaceC1520c interfaceC1520c, InterfaceC1520c fromCurrent) {
        switch (this.c) {
            case 0:
                kotlin.jvm.internal.k.f(fromCurrent, "fromCurrent");
                if (fromCurrent instanceof k8.t) {
                    ((k8.t) fromCurrent).Y0(C1533p.f4586a, interfaceC1520c);
                    return;
                }
                return;
            default:
                if (fromCurrent != null) {
                    return;
                }
                a(2);
                throw null;
        }
    }
}
