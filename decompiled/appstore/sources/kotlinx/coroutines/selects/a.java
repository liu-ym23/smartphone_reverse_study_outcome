package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final void a(SelectBuilder r10, long r11, Function1 r12) {
        r10.invoke(new OnTimeout(r11).b(), r12);
    }

    public static final void b(SelectBuilder r10, long r11, Function1 r12) {
        a(r10, DelayKt.d(r11), r12);
    }
}
