package kotlin.sequences;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g {
    public g() {
    }

    public abstract Object a(Object r10, Continuation r11);

    public abstract Object b(Iterator r10, Continuation r11);

    public final Object c(Sequence r10, Continuation r11) {
        Object r12 = b(r10.iterator(), r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r12;
    L6:
        return Unit.f21064a;
    }
}
