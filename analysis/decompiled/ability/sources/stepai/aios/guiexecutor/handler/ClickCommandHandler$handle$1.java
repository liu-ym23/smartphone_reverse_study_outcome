package stepai.aios.guiexecutor.handler;

import android.graphics.Point;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiParameters;

@J7.c(c = "stepai.aios.guiexecutor.handler.ClickCommandHandler", f = "ClickCommandHandler.kt", l = {51, 64, ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL, 68, 69}, m = "handle", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ClickCommandHandler$handle$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public GuiCommand f6181a;
    public GuiParameters.TouchParams b;
    public Point c;
    public long d;
    public int e;
    public /* synthetic */ Object f;
    public final /* synthetic */ c g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickCommandHandler$handle$1(c cVar, H7.c cVar2) {
        super(cVar2);
        this.g = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        return this.g.handle(null, this);
    }
}
