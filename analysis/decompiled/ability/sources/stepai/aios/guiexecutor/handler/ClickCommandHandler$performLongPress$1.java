package stepai.aios.guiexecutor.handler;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "stepai.aios.guiexecutor.handler.ClickCommandHandler", f = "ClickCommandHandler.kt", l = {209, 218}, m = "performLongPress", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ClickCommandHandler$performLongPress$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f6183a;
    public boolean b;
    public /* synthetic */ Object c;
    public final /* synthetic */ c d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickCommandHandler$performLongPress$1(c cVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.b(null, 0, null, this);
    }
}
