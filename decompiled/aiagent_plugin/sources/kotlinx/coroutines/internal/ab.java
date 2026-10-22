package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlinx.coroutines.cm;

/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f39355a = true;

    static {
    }

    public static final cm a(MainDispatcherFactory r2, List<? extends MainDispatcherFactory> r3) {
        MainDispatcherFactory r4 = (MainDispatcherFactory) ZeusTransformUtils.wrapperContextForParams(r2, MainDispatcherFactory.class, "com.obric.aiagent.plugin");
        return r4.createDispatcher((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    L5:
        th = move-exception;
        return (cm) ZeusTransformUtils.preCheckCast(a(th, r4.hintOnError()), cm.class, "com.obric.aiagent.plugin");
    }

    public static final boolean a(cm r1) {
        return ZeusTransformUtils.instanceOf(r1.a(), ac.class);
    }

    static /* synthetic */ ac a(Throwable r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = null;
    L9:
        return a(r1, r2);
    }

    private static final ac a(Throwable r1, String r2) {
        if (f39355a == true) goto L5;
        if (r1 == null) goto L8;
        throw r1;
    L8:
        a();
        throw new d.d();
    L5:
        return new ac(r1, r2);
    }

    public static final Void a() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }
}
