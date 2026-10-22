package kotlin.concurrent;

import androidx.exifinterface.media.ExifInterface;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Locks.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a6\u0010\u0006\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\b\u001a6\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"read", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withLock", "Ljava/util/concurrent/locks/Lock;", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "write", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LocksKt {
    private static final <T> T withLock(Lock r1, Function0<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        r1.lock();
        T r3 = r2.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r1.unlock();
        InlineMarker.finallyEnd(1);
        return r3;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r1.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private static final <T> T read(ReentrantReadWriteLock r1, Function0<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        ReentrantReadWriteLock.ReadLock r3 = r1.readLock();
        r3.lock();
        T r4 = r2.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r3.unlock();
        InlineMarker.finallyEnd(1);
        return r4;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r3.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private static final <T> T write(ReentrantReadWriteLock r4, Function0<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        ReentrantReadWriteLock.ReadLock r0 = r4.readLock();
        int r2 = 0;
        if (r4.getWriteHoldCount() != 0) goto L5;
        int r1 = r4.getReadHoldCount();
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r0.unlock();
        r3 = r3 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r6 = r4.writeLock();
        r6.lock();
        T r7 = r5.invoke();     // Catch: Throwable -> L16
        InlineMarker.finallyStart(1);
    L12:
        if (r2 >= r1) goto L14;
        r0.lock();
        r2 = r2 + 1;
        goto L12
    L14:
        r6.unlock();
        InlineMarker.finallyEnd(1);
        return r7;
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
    L18:
        if (r2 >= r1) goto L20;
        r0.lock();
        r2 = r2 + 1;
        goto L18
    L20:
        r6.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r1 = 0;
        goto L6
    }
}
