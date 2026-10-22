package m5;

import H7.f;
import S7.k;
import android.graphics.Bitmap;
import com.mdisdk.observer.DisplayObserverManager;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import com.stepos.deepbinder.core.utils.TypeUtils;
import com.stepos.motionkit.FxConfig;
import com.stepos.motionkit.FxInstance;
import com.stepos.motionkit.fx.CompositeFxInstance;
import com.stepos.motionkit.fx.FxInstanceImpl;
import com.stepos.motionkit.fx.FxModuleImpl;
import com.stepos.motionkit.fx.MotionHostExtKt;
import com.stepos.motionkit.fx.anim.AnimationBuilder;
import com.stepos.motionkit.fx.anim.SequenceBuilder;
import com.stepos.motionkit.fx.anim.TrackBuilder;
import com.stepos.motionkit.fx.effects.EdgeBlurDispersionKt;
import j9.InterfaceC1616j;
import m9.AbstractC1729v;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.llm.cell.GeminiModelCell;
import stepai.aios.guiagent.llm.cell.LocalModelCell;
import stepai.aios.guiagent.llm.cell.StepGelabModelCell;
import stepai.aios.guiagent.llm.cell.StepPlanTreeModelCell;
import stepai.aios.guiagent.tracer.GuiTaskNodeTraceSnapshot;
import stepai.aios.guiagent.tracer.GuiTaskTracer;
import za.b;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5302a;

    public /* synthetic */ a(int i) {
        this.f5302a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f5302a) {
            case 0:
                return Reply.pool$lambda$8((Reply) obj);
            case 1:
                f fVar = (f) obj;
                if (fVar instanceof AbstractC1729v) {
                    return (AbstractC1729v) fVar;
                }
                return null;
            case 2:
                return MethodWrapper.pool$lambda$6((MethodWrapper) obj);
            case 3:
                return ParameterWrapper.pool$lambda$7((ParameterWrapper) obj);
            case 4:
                return ServiceWrapper.pool$lambda$7((ServiceWrapper) obj);
            case 5:
                return TypeUtils.getMethodForGettingInstance$lambda$10((Class) obj);
            case 6:
                return TypeUtils.getMethodParameters$lambda$13((Class) obj);
            case 7:
                return TypeUtils.getMethod$lambda$7((Class) obj);
            case 8:
                return TypeUtils.getMethodParameters$lambda$12((ParameterWrapper) obj);
            case 9:
                return DisplayObserverManager.addTaskObserverId$lambda$6((String) obj);
            case 10:
                return CompositeFxInstance.name$lambda$0((FxInstance) obj);
            case 11:
                return Boolean.valueOf(FxModuleImpl.stop$lambda$1((FxInstanceImpl) obj));
            case 12:
                return MotionHostExtKt.play$lambda$1((FxConfig) obj);
            case 13:
                return LlmConfig._init_$lambda$0((Bitmap) obj);
            case 14:
                return GeminiModelCell.buildActionPrompt$lambda$0((b) obj);
            case 15:
                return Integer.valueOf(LocalModelCell.parseJsonParam$lambda$0$0((InterfaceC1616j) obj));
            case 16:
                return Integer.valueOf(LocalModelCell.parseParam$lambda$3((InterfaceC1616j) obj));
            case 17:
                return LocalModelCell.getSessionState$lambda$0((String) obj);
            case 18:
                return Integer.valueOf(StepGelabModelCell.parseJsonPointText$lambda$0((InterfaceC1616j) obj));
            case 19:
                return Integer.valueOf(StepGelabModelCell.parseParam$lambda$3((InterfaceC1616j) obj));
            case 20:
                return StepGelabModelCell.getSessionState$lambda$0((String) obj);
            case 21:
                return StepPlanTreeModelCell.buildActionPrompt$lambda$0((b) obj);
            case 22:
                return GuiTaskTracer.snapshotNodesForTree$lambda$0((GuiTaskNodeTraceSnapshot) obj);
            case 23:
                return GuiTaskTracer.snapshotNodesForTree$lambda$1((GuiTaskNodeTraceSnapshot) obj);
            case 24:
                return GuiTaskTracer.snapshotNodesForTree$lambda$2((GuiTaskNodeTraceSnapshot) obj);
            case 25:
                return EdgeBlurDispersionKt.EdgeBlurDispersion$lambda$4$lambda$1$lambda$0((SequenceBuilder) obj);
            case 26:
                return EdgeBlurDispersionKt.EdgeBlurDispersion$lambda$4((AnimationBuilder) obj);
            case 27:
                return EdgeBlurDispersionKt.EdgeBlurDispersion$lambda$4$lambda$1((TrackBuilder) obj);
            case 28:
                return EdgeBlurDispersionKt.EdgeBlurDispersion$lambda$4$lambda$3((TrackBuilder) obj);
            default:
                return EdgeBlurDispersionKt.EdgeBlurDispersion$lambda$4$lambda$3$lambda$2((SequenceBuilder) obj);
        }
    }
}
