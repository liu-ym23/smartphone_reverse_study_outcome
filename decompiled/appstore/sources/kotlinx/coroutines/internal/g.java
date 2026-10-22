package kotlinx.coroutines.internal;

import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collection f21591a = null;

    static {
        f21591a = SequencesKt___SequencesKt.w(SequencesKt__SequencesKt.c(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));
    }

    public static final Collection a() {
        return f21591a;
    }

    public static final void b(Throwable r10) {
        Thread r11 = Thread.currentThread();
        r11.getUncaughtExceptionHandler().uncaughtException(r11, r10);
    }
}
