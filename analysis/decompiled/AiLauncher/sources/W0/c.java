package W0;

import Ua.L0;
import Ua.Y;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"LW0/b;", Const.INTENT_KEY_APIKEY, "()LW0/b;", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {
    public static final b a() {
        kotlin.coroutines.d dVarU1;
        try {
            dVarU1 = Y.c().u1();
        } catch (IllegalStateException unused) {
            dVarU1 = EmptyCoroutineContext.f34779a;
        } catch (NotImplementedError unused2) {
            dVarU1 = EmptyCoroutineContext.f34779a;
        }
        return new b(dVarU1.plus(L0.b(null, 1, null)));
    }
}
