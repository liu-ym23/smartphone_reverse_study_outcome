package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i {
    public static final Object a(Function2 r10, Continuation r11) {
        h r12 = new h(r11.getContext(), r11);
        Object r13 = cg.b.c(r12, r12, r10);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L5;
        tf.d.c(r11);
    L5:
        return r13;
    }
}
