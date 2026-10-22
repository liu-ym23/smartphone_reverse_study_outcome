package stepai.aios.guiagent.session;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.model.TakeoverReasonType;

@c(c = "stepai.aios.guiagent.session.SessionManager", f = "SessionManager.kt", l = {537}, m = "updateSessionTakeover", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SessionManager$updateSessionTakeover$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6148a;
    public String b;
    public TakeoverReasonType c;
    public kotlinx.coroutines.sync.a d;
    public long e;
    public /* synthetic */ Object f;
    public final /* synthetic */ a g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionManager$updateSessionTakeover$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.g = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        return this.g.r(null, null, null, 0L, this);
    }
}
