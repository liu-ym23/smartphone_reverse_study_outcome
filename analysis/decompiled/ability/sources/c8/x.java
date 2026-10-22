package c8;

import g1.AbstractC1451a;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class x extends y {
    @Override // c8.e
    public final Object call(Object[] args) {
        kotlin.jvm.internal.k.f(args, "args");
        AbstractC1451a.r(this, args);
        Object obj = args[0];
        Object[] objArrD0 = args.length <= 1 ? new Object[0] : D7.q.d0(args, 1, args.length);
        return this.f2101a.invoke(obj, Arrays.copyOf(objArrD0, objArrD0.length));
    }
}
