package stepai.aios.guiexecutor.handler;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiParameters;

@J7.c(c = "stepai.aios.guiexecutor.handler.SystemNavigationCommandHandler", f = "SystemNavigationCommandHandler.kt", l = {38, 41}, m = "handle", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SystemNavigationCommandHandler$handle$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public GuiCommand f6188a;
    public GuiParameters.SystemNavigationParams b;
    public long c;
    public int d;
    public boolean e;
    public /* synthetic */ Object f;
    public final /* synthetic */ f g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemNavigationCommandHandler$handle$1(f fVar, H7.c cVar) {
        super(cVar);
        this.g = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        return this.g.handle(null, this);
    }
}
