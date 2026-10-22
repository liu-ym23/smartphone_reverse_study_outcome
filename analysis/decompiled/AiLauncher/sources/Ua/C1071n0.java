package Ua;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0004*\u00020\u0005¢\u0006\u0004\b\b\u0010\t*\f\b\u0007\u0010\n\"\u00020\u00012\u00020\u0001¨\u0006\u000b"}, d2 = {"Ljava/util/concurrent/ExecutorService;", "LUa/l0;", "c", "(Ljava/util/concurrent/ExecutorService;)LUa/l0;", "Ljava/util/concurrent/Executor;", "LUa/I;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/concurrent/Executor;)LUa/I;", Const.INTENT_KEY_APIKEY, "(LUa/I;)Ljava/util/concurrent/Executor;", "CloseableCoroutineDispatcher", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.n0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1071n0 {
    public static final Executor a(I i10) {
        Executor executorU1;
        AbstractC1067l0 abstractC1067l0 = i10 instanceof AbstractC1067l0 ? (AbstractC1067l0) i10 : null;
        return (abstractC1067l0 == null || (executorU1 = abstractC1067l0.getExecutor()) == null) ? new X(i10) : executorU1;
    }

    public static final I b(Executor executor) {
        I i10;
        X x10 = executor instanceof X ? (X) executor : null;
        return (x10 == null || (i10 = x10.dispatcher) == null) ? new C1069m0(executor) : i10;
    }

    public static final AbstractC1067l0 c(ExecutorService executorService) {
        return new C1069m0(executorService);
    }
}
