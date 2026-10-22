package stepai.aios.guiagent.session;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.model.TakeoverReasonType;
import za.h;

@c(c = "stepai.aios.guiagent.session.SessionManager", f = "SessionManager.kt", l = {537}, m = "startTakeover", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SessionManager$startTakeover$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6143a;
    public String b;
    public h c;
    public TakeoverReasonType d;
    public kotlinx.coroutines.sync.a e;
    public /* synthetic */ Object f;
    public final /* synthetic */ a g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionManager$startTakeover$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.g = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        return this.g.m(null, null, null, null, this);
    }
}
