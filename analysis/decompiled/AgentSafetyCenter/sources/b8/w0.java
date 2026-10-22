package b8;

import java.lang.invoke.VarHandle;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class w0 {

    /* renamed from: a, reason: collision with root package name */
    public static final x0 f2036a;

    static {
        x0 x0Var = new x0();
        x0Var.f2038a = new ConcurrentHashMap();
        VarHandle.storeStoreFence();
        f2036a = x0Var;
    }
}
