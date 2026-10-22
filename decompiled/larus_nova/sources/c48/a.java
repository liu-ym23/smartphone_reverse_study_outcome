package c48;

import com.larus.init.task.accountsdk.e;
import d48.d;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f22412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f22413b = null;

    static {
        f22413b = new AtomicBoolean(false);
    }

    public static d a() {
        d r100 = f22412a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("FlowAccountSaasRuntime is not initialized. Call FlowAccountSaasRuntime.init(depend) before using account saas runtime.".toString());
    }

    public static void b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "depend");
        AtomicBoolean r101 = f22413b;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r101.get() == true) goto L7;
        f22412a = r100;     // Catch: Throwable -> L14
        r101.set(true);     // Catch: Throwable -> L14
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r101);
        return;
    L7:
        d r103 = f22412a;     // Catch: Throwable -> L14
        if (r103 == null) goto L12;
        r103.e();     // Catch: Throwable -> L14
        e.f351141a.a("FlowAccountSaasRuntime", "has already init");     // Catch: Throwable -> L14
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
        goto L12
    }
}
