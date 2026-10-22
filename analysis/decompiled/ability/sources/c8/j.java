package c8;

import g1.AbstractC1451a;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public final class j extends k {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Field field, boolean z10, int i) {
        super(field, z10);
        this.e = i;
    }

    @Override // c8.v
    public void b(Object[] args) {
        switch (this.e) {
            case 1:
                kotlin.jvm.internal.k.f(args, "args");
                AbstractC1451a.r(this, args);
                c(D7.q.n0(args));
                break;
            default:
                super.b(args);
                break;
        }
    }
}
