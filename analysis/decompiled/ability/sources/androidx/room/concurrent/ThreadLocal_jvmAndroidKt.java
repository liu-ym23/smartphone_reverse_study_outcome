package androidx.room.concurrent;

import H7.f;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import s9.s;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u000f\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t*\u001c\u0010\n\u001a\u0004\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ThreadLocal;", "Landroidx/room/concurrent/ThreadLocal;", "value", "LH7/f;", "asContextElement", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)LH7/f;", "", "currentThreadId", "()J", "ThreadLocal", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ThreadLocal_jvmAndroidKt {
    public static /* synthetic */ void ThreadLocal$annotations() {
    }

    public static final <T> f asContextElement(ThreadLocal<T> threadLocal, T t9) {
        k.f(threadLocal, "<this>");
        return new s(threadLocal, t9);
    }

    public static final long currentThreadId() {
        return Thread.currentThread().getId();
    }
}
