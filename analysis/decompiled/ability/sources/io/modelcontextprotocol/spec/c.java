package io.modelcontextprotocol.spec;

import com.stepos.deepbinder.core.monitor.IPCMonitor;
import com.stepos.mcp.sdk.java.server.AndroidMCPServer;
import com.stepos.motionkit.MotionHost;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.circlebutton.StepOSCircleButton;
import kotlin.jvm.internal.k;
import x6.C2116a;
import y6.C2135c;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4741a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i) {
        this.f4741a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f4741a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((McpClientSession) obj).dismissPendingResponses();
                break;
            case 1:
                ((IPCMonitor.IpcState) obj).register();
                break;
            case 2:
                ((AndroidMCPServer) obj).lambda$start$0();
                break;
            case 3:
                ((A6.i) obj).invoke();
                break;
            case 4:
                ((A6.i) obj).invoke();
                break;
            case 5:
                ((A6.i) obj).invoke();
                break;
            case 6:
                ((MotionHost) obj).resume();
                break;
            case 7:
                StepOSButton stepOSButton = (StepOSButton) obj;
                D6.f fVar = stepOSButton.b;
                stepOSButton.d = false;
                if (stepOSButton.isAttachedToWindow()) {
                    if (stepOSButton.isGlassEnabled && stepOSButton.getWidth() > 0 && stepOSButton.getHeight() > 0 && stepOSButton.getVisibility() != 8) {
                        float fMin = Math.min(stepOSButton.getWidth(), stepOSButton.getHeight()) / 2.0f;
                        C2116a c2116a = new C2116a(stepOSButton.getWidth(), stepOSButton.getHeight(), fMin, stepOSButton.getGlassEffect());
                        if (!k.b(stepOSButton.c, c2116a)) {
                            fVar.a(fMin, 0, stepOSButton.getGlassEffect());
                            stepOSButton.c = c2116a;
                            break;
                        }
                    } else {
                        fVar.d();
                        stepOSButton.c = null;
                        break;
                    }
                }
                break;
            default:
                StepOSCircleButton stepOSCircleButton = (StepOSCircleButton) obj;
                stepOSCircleButton.d = false;
                if (stepOSCircleButton.isAttachedToWindow()) {
                    D6.f fVar2 = stepOSCircleButton.b;
                    if (stepOSCircleButton.isGlassEnabled && stepOSCircleButton.getWidth() > 0 && stepOSCircleButton.getHeight() > 0 && stepOSCircleButton.getVisibility() != 8) {
                        float glassCornerRadius = stepOSCircleButton.getGlassCornerRadius() > 0.0f ? stepOSCircleButton.getGlassCornerRadius() : Math.min(stepOSCircleButton.getWidth(), stepOSCircleButton.getHeight()) / 2.0f;
                        D6.a aVar = stepOSCircleButton.e;
                        C2135c c2135c = new C2135c(stepOSCircleButton.getWidth(), stepOSCircleButton.getHeight(), glassCornerRadius, stepOSCircleButton.isGlassCrossWindow, stepOSCircleButton.getGlassEffect(), aVar);
                        if (!k.b(stepOSCircleButton.c, c2135c)) {
                            boolean z10 = stepOSCircleButton.isGlassCrossWindow;
                            if (aVar != null) {
                                fVar2.c(z10 ? 1 : 0, glassCornerRadius, new D6.j(aVar, 1));
                            } else {
                                fVar2.a(glassCornerRadius, z10 ? 1 : 0, stepOSCircleButton.getGlassEffect());
                            }
                            stepOSCircleButton.c = c2135c;
                            stepOSCircleButton.invalidate();
                            break;
                        }
                    } else {
                        stepOSCircleButton.g();
                        break;
                    }
                }
                break;
        }
    }
}
