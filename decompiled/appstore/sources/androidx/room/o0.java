package androidx.room;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes.dex */
public abstract class o0 {
    public static final /* synthetic */ CoroutineContext a(RoomDatabase r10, ContinuationInterceptor r11) {
        return b(r10, r11);
    }

    public static final CoroutineContext b(RoomDatabase r10, ContinuationInterceptor r11) {
        w0 r12 = new w0(r11);
        ThreadContextElement r13 = y1.a(r10.r(), Integer.valueOf(System.identityHashCode(r12)));
        return r11.plus(r12).plus(r13);
    }
}
