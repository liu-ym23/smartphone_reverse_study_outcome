package stepai.aios.guiagent.takeover;

import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;

@c(c = "stepai.aios.guiagent.takeover.TakeoverErrorHandler", f = "TakeoverErrorHandler.kt", l = {93, 106, 124}, m = "executeWithRetry", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class TakeoverErrorHandler$executeWithRetry$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6150a;
    public k b;
    public Ref$ObjectRef c;
    public int d;
    public int e;
    public int f;
    public int g;
    public long h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a f6151j;
    public int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeoverErrorHandler$executeWithRetry$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f6151j = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.k |= Integer.MIN_VALUE;
        return this.f6151j.c(null, 0, 0L, null, this);
    }
}
