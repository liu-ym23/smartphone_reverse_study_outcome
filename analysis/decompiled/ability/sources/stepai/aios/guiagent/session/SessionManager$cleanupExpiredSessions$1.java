package stepai.aios.guiagent.session;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.session.SessionManager", f = "SessionManager.kt", l = {537}, m = "cleanupExpiredSessions", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SessionManager$cleanupExpiredSessions$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public kotlinx.coroutines.sync.a f6134a;
    public /* synthetic */ Object b;
    public final /* synthetic */ a c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionManager$cleanupExpiredSessions$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.d(this);
    }
}
