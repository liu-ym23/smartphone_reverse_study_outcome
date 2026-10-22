package stepai.aios.guiexecutor.handler;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiParameters;

@J7.c(c = "stepai.aios.guiexecutor.handler.WaitCommandHandler", f = "WaitCommandHandler.kt", l = {38}, m = "handle", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class WaitCommandHandler$handle$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public GuiCommand f6189a;
    public GuiParameters.WaitParams b;
    public long c;
    public /* synthetic */ Object d;
    public final /* synthetic */ g e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaitCommandHandler$handle$1(g gVar, H7.c cVar) {
        super(cVar);
        this.e = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.handle(null, this);
    }
}
