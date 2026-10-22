package stepai.aios.guiagent.takeover;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.takeover.TakeoverErrorHandler", f = "TakeoverErrorHandler.kt", l = {238}, m = "handleConcurrentOperationError", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class TakeoverErrorHandler$handleConcurrentOperationError$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6153a;
    public final /* synthetic */ a b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeoverErrorHandler$handleConcurrentOperationError$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6153a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.e(null, this);
    }
}
