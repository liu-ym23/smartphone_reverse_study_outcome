package androidx.room;

import java.util.Map;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static final CoroutineDispatcher a(RoomDatabase r10) {
        Map r11 = r10.k();
        Object r12 = r11.get("QueryDispatcher");
        if (r12 != null) goto L5;
        r12 = kotlinx.coroutines.x0.a(r10.o());
        r11.put("QueryDispatcher", r12);
    L5:
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) r12;
    }

    public static final CoroutineDispatcher b(RoomDatabase r10) {
        Map r11 = r10.k();
        Object r12 = r11.get("TransactionDispatcher");
        if (r12 != null) goto L5;
        r12 = kotlinx.coroutines.x0.a(r10.s());
        r11.put("TransactionDispatcher", r12);
    L5:
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) r12;
    }
}
