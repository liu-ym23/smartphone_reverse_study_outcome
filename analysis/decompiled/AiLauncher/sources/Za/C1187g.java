package Za;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import kotlin.Metadata;
import kotlinx.coroutines.internal.DiagnosticCoroutineContextException;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/coroutines/d;", "context", "", "exception", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lkotlin/coroutines/d;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: Za.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1187g {
    public static final void a(kotlin.coroutines.d dVar, Throwable th) {
        Iterator<Ua.J> it = C1186f.a().iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(dVar, th);
            } catch (Throwable th2) {
                C1186f.b(Ua.K.b(th, th2));
            }
        }
        try {
            Y8.d.a(th, new DiagnosticCoroutineContextException(dVar));
        } catch (Throwable unused) {
        }
        C1186f.b(th);
    }
}
