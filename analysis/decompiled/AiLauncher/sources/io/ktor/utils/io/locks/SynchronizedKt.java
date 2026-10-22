package io.ktor.utils.io.locks;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.utils.io.InternalAPI;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a/\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\u00060\u0000j\u0002`\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a3\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r*\u0010\b\u0007\u0010\u000f\"\u00020\t2\u00020\tB\u0002\b\u000e*\u0010\b\u0007\u0010\u0010\"\u00020\u00002\u00020\u0000B\u0002\b\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"Ljava/util/concurrent/locks/ReentrantLock;", "Lio/ktor/utils/io/locks/ReentrantLock;", "reentrantLock", "()Ljava/util/concurrent/locks/ReentrantLock;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "block", "withLock", "(Ljava/util/concurrent/locks/ReentrantLock;Lp9/a;)Ljava/lang/Object;", "", "Lio/ktor/utils/io/locks/SynchronizedObject;", "lock", "synchronized", "(Ljava/lang/Object;Lp9/a;)Ljava/lang/Object;", "Lio/ktor/utils/io/InternalAPI;", "SynchronizedObject", "ReentrantLock", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SynchronizedKt {
    @InternalAPI
    public static /* synthetic */ void ReentrantLock$annotations() {
    }

    @InternalAPI
    public static /* synthetic */ void SynchronizedObject$annotations() {
    }

    @InternalAPI
    public static final ReentrantLock reentrantLock() {
        return new ReentrantLock();
    }

    @InternalAPI
    /* renamed from: synchronized, reason: not valid java name */
    public static final <T> T m218synchronized(Object lock, InterfaceC5063a<? extends T> block) {
        T tInvoke;
        p.i(lock, "lock");
        p.i(block, "block");
        synchronized (lock) {
            try {
                tInvoke = block.invoke();
                n.b(1);
            } catch (Throwable th) {
                n.b(1);
                n.a(1);
                throw th;
            }
        }
        n.a(1);
        return tInvoke;
    }

    @InternalAPI
    public static final <T> T withLock(ReentrantLock reentrantLock, InterfaceC5063a<? extends T> block) {
        p.i(reentrantLock, "<this>");
        p.i(block, "block");
        reentrantLock.lock();
        try {
            return block.invoke();
        } finally {
            n.b(1);
            reentrantLock.unlock();
            n.a(1);
        }
    }
}
