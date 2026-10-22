package stepai.aios.guiagent.pipeline.util;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.config.Action;

@c(c = "stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter", f = "GuiActionInterruptionAdapter.kt", l = {229}, m = "startTrackingAction", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class GuiActionInterruptionAdapter$startTrackingAction$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6114a;
    public Action b;
    public String c;
    public kotlinx.coroutines.sync.a d;
    public /* synthetic */ Object e;
    public final /* synthetic */ a f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiActionInterruptionAdapter$startTrackingAction$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.c(null, null, null, this);
    }
}
