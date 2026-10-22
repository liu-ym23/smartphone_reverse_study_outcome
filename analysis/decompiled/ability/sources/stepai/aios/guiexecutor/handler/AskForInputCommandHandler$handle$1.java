package stepai.aios.guiexecutor.handler;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.input.UserInputType;

@J7.c(c = "stepai.aios.guiexecutor.handler.AskForInputCommandHandler", f = "AskForInputCommandHandler.kt", l = {72}, m = "handle", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class AskForInputCommandHandler$handle$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public GuiCommand f6179a;
    public String b;
    public UserInputType c;
    public long d;
    public /* synthetic */ Object e;
    public final /* synthetic */ a f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AskForInputCommandHandler$handle$1(a aVar, H7.c cVar) {
        super(cVar);
        this.f = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.handle(null, this);
    }
}
