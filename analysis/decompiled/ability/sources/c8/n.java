package c8;

import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public final class n extends o {
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Field field, boolean z10, boolean z11, int i) {
        super(field, z10, z11);
        this.f = i;
    }

    @Override // c8.o, c8.v
    public void b(Object[] args) {
        switch (this.f) {
            case 1:
                kotlin.jvm.internal.k.f(args, "args");
                super.b(args);
                c(D7.q.n0(args));
                break;
            default:
                super.b(args);
                break;
        }
    }
}
