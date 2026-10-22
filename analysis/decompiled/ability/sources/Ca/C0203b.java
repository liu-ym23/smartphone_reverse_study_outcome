package Ca;

import java.util.concurrent.CountDownLatch;
import stepai.aios.guiagent.tracer.GuiStepScreenshotRef;
import stepai.aios.guiagent.tracer.GuiTracerManager;

/* renamed from: Ca.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C0203b implements S7.o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f345a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0203b(Object obj, int i) {
        this.f345a = i;
        this.b = obj;
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.f345a;
        Object obj4 = this.b;
        switch (i) {
            case 0:
                stepai.aios.guiagent.runtime.a aVar = (stepai.aios.guiagent.runtime.a) obj4;
                String sessionId = (String) obj;
                String stepId = (String) obj2;
                GuiStepScreenshotRef screenshotRef = (GuiStepScreenshotRef) obj3;
                kotlin.jvm.internal.k.f(sessionId, "sessionId");
                kotlin.jvm.internal.k.f(stepId, "stepId");
                kotlin.jvm.internal.k.f(screenshotRef, "screenshotRef");
                GuiTracerManager guiTracerManager = aVar.e;
                if (guiTracerManager != null) {
                    guiTracerManager.onScreenshotCaptured(sessionId, stepId, screenshotRef);
                }
                aVar.b.invoke(sessionId, stepId, screenshotRef);
                break;
            case 1:
                ((Integer) obj2).intValue();
                kotlin.jvm.internal.k.f((String) obj, "<unused var>");
                kotlin.jvm.internal.k.f((String) obj3, "<unused var>");
                ((CountDownLatch) obj4).countDown();
                break;
            case 2:
                ((S7.k) obj4).invoke((Throwable) obj);
                break;
            case 3:
                return new W3.c(2, (kotlinx.coroutines.sync.a) obj4, obj2);
            default:
                ((kotlinx.coroutines.sync.b) obj4).c();
                break;
        }
        return C7.r.f317a;
    }
}
