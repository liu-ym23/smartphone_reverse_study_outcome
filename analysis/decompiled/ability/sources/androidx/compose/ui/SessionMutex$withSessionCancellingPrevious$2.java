package androidx.compose.ui;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.ui.SessionMutex;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.a;
import m9.InterfaceC1733z;
import m9.c0;
import o7.s;

@c(c = "androidx.compose.ui.SessionMutex$withSessionCancellingPrevious$2", f = "SessionMutex.kt", l = {s.MESSAGE_POST_FIELD_NUMBER, 63}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes.dex */
public final class SessionMutex$withSessionCancellingPrevious$2 extends SuspendLambda implements n {
    final /* synthetic */ AtomicReference<SessionMutex.Session<T>> $arg0;
    final /* synthetic */ n $session;
    final /* synthetic */ k $sessionInitializer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionMutex$withSessionCancellingPrevious$2(k kVar, AtomicReference<SessionMutex.Session<T>> atomicReference, n nVar, H7.c<? super SessionMutex$withSessionCancellingPrevious$2> cVar) {
        super(2, cVar);
        this.$sessionInitializer = kVar;
        this.$arg0 = atomicReference;
        this.$session = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        SessionMutex$withSessionCancellingPrevious$2 sessionMutex$withSessionCancellingPrevious$2 = new SessionMutex$withSessionCancellingPrevious$2(this.$sessionInitializer, this.$arg0, this.$session, cVar);
        sessionMutex$withSessionCancellingPrevious$2.L$0 = obj;
        return sessionMutex$withSessionCancellingPrevious$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SessionMutex.Session session;
        c0 job;
        SessionMutex.Session session2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        try {
            if (i == 0) {
                b.b(obj);
                InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                session = new SessionMutex.Session(a.i(interfaceC1733z.getCoroutineContext()), this.$sessionInitializer.invoke(interfaceC1733z));
                SessionMutex.Session session3 = (SessionMutex.Session) this.$arg0.getAndSet(session);
                if (session3 != null && (job = session3.getJob()) != null) {
                    this.L$0 = session;
                    this.label = 1;
                    if (a.e(job, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    session2 = (SessionMutex.Session) this.L$0;
                    try {
                        b.b(obj);
                        this.$arg0.compareAndSet(session2, null);
                        return obj;
                    } catch (Throwable th) {
                        th = th;
                        this.$arg0.compareAndSet(session2, null);
                        throw th;
                    }
                }
                session = (SessionMutex.Session) this.L$0;
                b.b(obj);
            }
            n nVar = this.$session;
            Object value = session.getValue();
            this.L$0 = session;
            this.label = 2;
            obj = nVar.invoke(value, this);
            if (obj != coroutineSingletons) {
                session2 = session;
                this.$arg0.compareAndSet(session2, null);
                return obj;
            }
            return coroutineSingletons;
        } catch (Throwable th2) {
            th = th2;
            session2 = session;
            this.$arg0.compareAndSet(session2, null);
            throw th;
        }
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super R> cVar) {
        return ((SessionMutex$withSessionCancellingPrevious$2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
