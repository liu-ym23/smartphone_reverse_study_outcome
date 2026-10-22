package stepai.aios.guiagent.pipeline;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w9.InterfaceC2108a;

@c(c = "stepai.aios.guiagent.pipeline.PerDisplayUiLockProvider", f = "UiLockProvider.kt", l = {36, 27}, m = "withLock", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class PerDisplayUiLockProvider$withLock$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f6108a;
    public int b;
    public SuspendLambda c;
    public InterfaceC2108a d;
    public /* synthetic */ Object e;
    public final /* synthetic */ a f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PerDisplayUiLockProvider$withLock$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.c(0, null, this);
    }
}
