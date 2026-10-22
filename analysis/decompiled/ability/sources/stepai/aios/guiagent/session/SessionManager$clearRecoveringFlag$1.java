package stepai.aios.guiagent.session;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.session.SessionManager", f = "SessionManager.kt", l = {537}, m = "clearRecoveringFlag", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SessionManager$clearRecoveringFlag$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6135a;
    public kotlinx.coroutines.sync.a b;
    public /* synthetic */ Object c;
    public final /* synthetic */ a d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionManager$clearRecoveringFlag$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.f(null, this);
    }
}
