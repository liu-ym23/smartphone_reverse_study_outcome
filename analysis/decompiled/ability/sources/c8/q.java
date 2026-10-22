package c8;

import g1.AbstractC1451a;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class q extends u implements d {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Method method) {
        super(method, false, 4);
        kotlin.jvm.internal.k.f(method, "method");
    }

    @Override // c8.e
    public final Object call(Object[] args) {
        kotlin.jvm.internal.k.f(args, "args");
        AbstractC1451a.r(this, args);
        return d(null, args);
    }
}
