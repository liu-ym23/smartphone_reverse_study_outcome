package stepai.aios.guiagent.takeover;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.takeover.TakeoverSafetyManager", f = "TakeoverSafetyManager.kt", l = {322}, m = "completeOperation", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class TakeoverSafetyManager$completeOperation$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6160a;
    public kotlinx.coroutines.sync.a b;
    public boolean c;
    public /* synthetic */ Object d;
    public final /* synthetic */ b e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeoverSafetyManager$completeOperation$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.c(null, false, this);
    }
}
