package stepai.aios.guiexecutor.handler;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiParameters;

@J7.c(c = "stepai.aios.guiexecutor.handler.InputCommandHandler", f = "InputCommandHandler.kt", l = {75}, m = "handle", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class InputCommandHandler$handle$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public GuiCommand f6185a;
    public GuiParameters.InputParams b;
    public long c;
    public /* synthetic */ Object d;
    public final /* synthetic */ d e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputCommandHandler$handle$1(d dVar, H7.c cVar) {
        super(cVar);
        this.e = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.handle(null, this);
    }
}
