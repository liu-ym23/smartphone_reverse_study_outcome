package stepai.aios.guiexecutor.handler;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiexecutor.api.GuiCommand;

@J7.c(c = "stepai.aios.guiexecutor.handler.SwipeCommandHandler", f = "SwipeCommandHandler.kt", l = {142}, m = "performSwipe", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SwipeCommandHandler$performSwipe$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public GuiCommand f6187a;
    public /* synthetic */ Object b;
    public final /* synthetic */ e c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeCommandHandler$performSwipe$1(e eVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(null, null, this);
    }
}
