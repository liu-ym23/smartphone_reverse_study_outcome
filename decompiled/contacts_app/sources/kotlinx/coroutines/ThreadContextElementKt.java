package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.ThreadLocalElement;
import kotlinx.coroutines.internal.ThreadLocalKey;

/* JADX INFO: compiled from: ThreadContextElement.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u0003H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u0003H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"asContextElement", "Lkotlinx/coroutines/ThreadContextElement;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ThreadLocal;", "value", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlinx/coroutines/ThreadContextElement;", "ensurePresent", "", "(Ljava/lang/ThreadLocal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPresent", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThreadContextElementKt {
    public static /* synthetic */ ThreadContextElement asContextElement$default(ThreadLocal r0, Object r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.get();
    L6:
        return asContextElement(r0, r1);
    }

    public static final <T> ThreadContextElement<T> asContextElement(ThreadLocal<T> r1, T r2) {
        return new ThreadLocalElement(r2, r1);
    }

    public static final Object isPresent(ThreadLocal<?> r1, Continuation<? super Boolean> r2) {
        if (r2.getContext().get(new ThreadLocalKey(r1)) == null) goto L5;
        boolean r3 = true;
    L7:
        return Boxing.boxBoolean(r3);
    L5:
        r3 = false;
        goto L7
    }

    private static final Object isPresent$$forInline(ThreadLocal<?> r0, Continuation<? super Boolean> r1) {
        InlineMarker.mark(3);
        Continuation r2 = null;
        r2.getContext();
        throw null;
    }

    public static final Object ensurePresent(ThreadLocal<?> r2, Continuation<? super Unit> r3) {
        if (r3.getContext().get(new ThreadLocalKey(r2)) == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException(("ThreadLocal " + r2 + " is missing from context " + r3.getContext()).toString());
    L5:
        r0 = false;
        goto L6
    }

    private static final Object ensurePresent$$forInline(ThreadLocal<?> r0, Continuation<? super Unit> r1) {
        InlineMarker.mark(3);
        Continuation r2 = null;
        r2.getContext();
        throw null;
    }
}
