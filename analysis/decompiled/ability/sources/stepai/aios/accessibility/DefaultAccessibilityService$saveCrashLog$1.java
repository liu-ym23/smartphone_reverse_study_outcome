package stepai.aios.accessibility;

import C7.r;
import J7.c;
import N9.j;
import S7.n;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.accessibility.DefaultAccessibilityService$saveCrashLog$1", f = "AccessibilityService.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class DefaultAccessibilityService$saveCrashLog$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultAccessibilityService f6016a;
    public final /* synthetic */ Throwable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultAccessibilityService$saveCrashLog$1(DefaultAccessibilityService defaultAccessibilityService, Throwable th, H7.c cVar) {
        super(2, cVar);
        this.f6016a = defaultAccessibilityService;
        this.b = th;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new DefaultAccessibilityService$saveCrashLog$1(this.f6016a, this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) throws IOException {
        DefaultAccessibilityService$saveCrashLog$1 defaultAccessibilityService$saveCrashLog$1 = (DefaultAccessibilityService$saveCrashLog$1) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        defaultAccessibilityService$saveCrashLog$1.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        try {
            File file = new File(this.f6016a.getFilesDir(), "logs");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "crash_" + System.currentTimeMillis() + ".log");
            PrintWriter printWriter = new PrintWriter(file2);
            Throwable th = this.b;
            try {
                printWriter.println("Crash Time: " + System.currentTimeMillis());
                printWriter.println("Exception: ".concat(th.getClass().getSimpleName()));
                printWriter.println("Message: " + th.getMessage());
                printWriter.println("Stack Trace:");
                th.printStackTrace(printWriter);
                printWriter.close();
                j.H("Crash log saved: " + file2.getAbsolutePath(), "DefaultAccessibilityService");
            } finally {
            }
        } catch (Exception e) {
            com.stepos.statsrpk.service.c.n("Failed to save crash log: ", e.getMessage(), "DefaultAccessibilityService");
        }
        return r.f317a;
    }
}
