package ie;

import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.VarHandle;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class j0 extends k0 {
    @Override // ie.k0
    public final Executor a() {
        i0 i0Var = new i0(0);
        i0Var.f6001f = new Handler(Looper.getMainLooper());
        VarHandle.storeStoreFence();
        return i0Var;
    }
}
