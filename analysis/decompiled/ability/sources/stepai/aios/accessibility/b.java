package stepai.aios.accessibility;

import android.os.Process;
import com.stepos.statsrpk.service.c;
import java.lang.Thread;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;

/* loaded from: classes4.dex */
public final class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultAccessibilityService f6018a;

    public b(DefaultAccessibilityService defaultAccessibilityService) {
        this.f6018a = defaultAccessibilityService;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread t9, Throwable e) {
        k.f(t9, "t");
        k.f(e, "e");
        c.n("Uncaught exception: ", e.getMessage(), "DefaultAccessibilityService");
        DefaultAccessibilityService defaultAccessibilityService = this.f6018a;
        AbstractC1683A.n(defaultAccessibilityService.f6015a, null, new DefaultAccessibilityService$saveCrashLog$1(defaultAccessibilityService, e, null), 3);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = defaultAccessibilityService.c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(t9, e);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }
}
