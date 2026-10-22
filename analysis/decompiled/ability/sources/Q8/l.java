package Q8;

import h8.InterfaceC1501I;
import h8.InterfaceC1519b;
import k8.K;

/* loaded from: classes4.dex */
public final class l implements S7.k {
    public static final l b = new l(0);
    public static final l c = new l(1);
    public static final l d = new l(2);
    public static final l e = new l(3);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1127a;

    public /* synthetic */ l(int i) {
        this.f1127a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1127a) {
            case 0:
                G8.f it = (G8.f) obj;
                kotlin.jvm.internal.k.f(it, "it");
                return Boolean.TRUE;
            case 1:
                K selectMostSpecificInEachOverridableGroup = (K) obj;
                kotlin.jvm.internal.k.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
                return selectMostSpecificInEachOverridableGroup;
            case 2:
                InterfaceC1501I selectMostSpecificInEachOverridableGroup2 = (InterfaceC1501I) obj;
                kotlin.jvm.internal.k.f(selectMostSpecificInEachOverridableGroup2, "$this$selectMostSpecificInEachOverridableGroup");
                return selectMostSpecificInEachOverridableGroup2;
            default:
                InterfaceC1519b selectMostSpecificInEachOverridableGroup3 = (InterfaceC1519b) obj;
                kotlin.jvm.internal.k.f(selectMostSpecificInEachOverridableGroup3, "$this$selectMostSpecificInEachOverridableGroup");
                return selectMostSpecificInEachOverridableGroup3;
        }
    }
}
