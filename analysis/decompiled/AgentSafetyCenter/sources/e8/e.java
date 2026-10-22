package e8;

import java.lang.invoke.VarHandle;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final f f3607a;

    static {
        List list = Collections.EMPTY_LIST;
        f fVar = new f();
        fVar.f3610b = list;
        fVar.f3609a = list;
        VarHandle.storeStoreFence();
        f3607a = fVar;
    }
}
