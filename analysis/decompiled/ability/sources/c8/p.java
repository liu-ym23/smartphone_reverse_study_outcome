package c8;

import g1.AbstractC1451a;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class p extends u implements d {
    public final Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Method method, Object obj) {
        super(method, false, 4);
        kotlin.jvm.internal.k.f(method, "method");
        this.f = obj;
    }

    @Override // c8.e
    public final Object call(Object[] args) {
        kotlin.jvm.internal.k.f(args, "args");
        AbstractC1451a.r(this, args);
        return d(this.f, args);
    }
}
