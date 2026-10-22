package wa;

import java.util.List;
import p9.InterfaceC5063a;
import xa.InterfaceC5869l;

/* renamed from: wa.Q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5775Q extends C5777a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5775Q(InterfaceC5869l storageManager, InterfaceC5063a<? extends List<? extends F9.c>> compute) {
        super(storageManager, compute);
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(compute, "compute");
    }

    @Override // wa.C5777a, F9.g
    public boolean isEmpty() {
        return false;
    }
}
