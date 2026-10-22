package i9;

import B9.T;
import C7.r;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import com.stepos.taskrobot.llmapi.stepfun.view.popup.PassiveTakeoverPromptPopup;
import com.stepos.taskrobot.service.TaskRobotService;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.circlebutton.StepOSCircleButton;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.config.TaskConfigResolver;
import z9.C2200b;
import z9.C2201c;

/* loaded from: classes4.dex */
public final /* synthetic */ class l implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4624a;
    public final /* synthetic */ Object b;

    public /* synthetic */ l(Object obj, int i) {
        this.f4624a = i;
        this.b = obj;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f4624a;
        r rVar = r.f317a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return obj;
            case 1:
                return ShaderBrushSpan.shaderState$lambda$0((ShaderBrushSpan) obj);
            case 2:
                return PassiveTakeoverPromptPopup.createContentView$lambda$3((PassiveTakeoverPromptPopup) obj);
            case 3:
                return TaskRobotService.taskRobotManagerImpl_delegate$lambda$0((TaskRobotService) obj);
            case 4:
                return TaskConfigResolver.resolve$lambda$0((LlmConfig) obj);
            case 5:
                StepOSButton stepOSButton = (StepOSButton) obj;
                int i6 = StepOSButton.f4086j;
                stepOSButton.b.d();
                stepOSButton.c = null;
                stepOSButton.b();
                return rVar;
            case 6:
                x9.c cVar = (x9.c) obj;
                z9.h hVarL = z2.l.l("kotlinx.serialization.Polymorphic", C2201c.c, new z9.g[0], new com.stepos.taskrobot.llmapi.stepfun.g(cVar, 16));
                Z7.d context = cVar.f6883a;
                kotlin.jvm.internal.k.f(context, "context");
                return new C2200b(hVarL, context);
            case 7:
                StepOSCircleButton stepOSCircleButton = (StepOSCircleButton) obj;
                int i10 = StepOSCircleButton.f4088F;
                stepOSCircleButton.g();
                stepOSCircleButton.h();
                return rVar;
            default:
                z9.h hVar = (z9.h) obj;
                return Integer.valueOf(T.e(hVar, hVar.k));
        }
    }
}
