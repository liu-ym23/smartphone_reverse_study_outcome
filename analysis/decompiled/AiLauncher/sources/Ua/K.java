package Ua;

import Za.C1187g;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.coroutines.DispatchException;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/coroutines/d;", "context", "", "exception", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lkotlin/coroutines/d;Ljava/lang/Throwable;)V", "originalException", "thrownException", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class K {
    public static final void a(kotlin.coroutines.d dVar, Throwable th) {
        if (th instanceof DispatchException) {
            th = ((DispatchException) th).getCause();
        }
        try {
            J j10 = (J) dVar.get(J.INSTANCE);
            if (j10 != null) {
                j10.handleException(dVar, th);
            } else {
                C1187g.a(dVar, th);
            }
        } catch (Throwable th2) {
            C1187g.a(dVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        Y8.d.a(runtimeException, th);
        return runtimeException;
    }
}
