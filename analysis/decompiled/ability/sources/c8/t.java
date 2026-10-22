package c8;

import g1.AbstractC1451a;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class t extends u {
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Method method, int i) {
        super(method, false, 6);
        this.f = i;
        switch (i) {
            case 1:
                kotlin.jvm.internal.k.f(method, "method");
                super(method, true, 4);
                break;
            case 2:
                kotlin.jvm.internal.k.f(method, "method");
                super(method, false, 6);
                break;
            default:
                kotlin.jvm.internal.k.f(method, "method");
                break;
        }
    }

    @Override // c8.e
    public final Object call(Object[] args) {
        switch (this.f) {
            case 0:
                kotlin.jvm.internal.k.f(args, "args");
                AbstractC1451a.r(this, args);
                return d(args[0], args.length <= 1 ? new Object[0] : D7.q.d0(args, 1, args.length));
            case 1:
                kotlin.jvm.internal.k.f(args, "args");
                AbstractC1451a.r(this, args);
                c(D7.q.n0(args));
                return d(null, args.length <= 1 ? new Object[0] : D7.q.d0(args, 1, args.length));
            default:
                kotlin.jvm.internal.k.f(args, "args");
                AbstractC1451a.r(this, args);
                return d(null, args);
        }
    }
}
