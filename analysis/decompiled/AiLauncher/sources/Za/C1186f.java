package Za;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\" \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\u000b"}, d2 = {"", "exception", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Throwable;)V", "", "LUa/J;", Const.INTENT_KEY_APIKEY, "Ljava/util/Collection;", "()Ljava/util/Collection;", "platformExceptionHandlers", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: Za.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1186f {

    /* renamed from: a, reason: collision with root package name */
    public static final Collection<Ua.J> f7729a = SequencesKt___SequencesKt.d0(Ka.t.h(ServiceLoader.load(Ua.J.class, Ua.J.class.getClassLoader()).iterator()));

    public static final Collection<Ua.J> a() {
        return f7729a;
    }

    public static final void b(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        try {
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
        } catch (Throwable unused) {
        }
    }
}
