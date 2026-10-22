package kotlinx.coroutines;

import Ua.C1056g;
import Ua.C1086v0;
import Ua.P0;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a.\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/d;", "context", "Lkotlin/Function0;", "block", Const.INTENT_KEY_PKGNAME, "(Lkotlin/coroutines/d;Lp9/a;Le9/c;)Ljava/lang/Object;", "coroutineContext", Const.INTENT_KEY_UMID, "(Lkotlin/coroutines/d;Lp9/a;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InterruptibleKt {
    public static final <T> Object b(kotlin.coroutines.d dVar, InterfaceC5063a<? extends T> interfaceC5063a, InterfaceC4014c<? super T> interfaceC4014c) {
        return C1056g.j(dVar, new InterruptibleKt$runInterruptible$2(interfaceC5063a, null), interfaceC4014c);
    }

    public static /* synthetic */ Object c(kotlin.coroutines.d dVar, InterfaceC5063a interfaceC5063a, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return b(dVar, interfaceC5063a, interfaceC4014c);
    }

    public static final <T> T d(kotlin.coroutines.d dVar, InterfaceC5063a<? extends T> interfaceC5063a) throws Throwable {
        try {
            P0 p02 = new P0();
            p02.A(C1086v0.o(dVar));
            try {
                return interfaceC5063a.invoke();
            } finally {
                p02.x();
            }
        } catch (InterruptedException e10) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e10);
        }
    }
}
