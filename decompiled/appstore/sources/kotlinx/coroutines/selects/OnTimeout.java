package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes4.dex */
public final class OnTimeout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21697a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectInstance f21698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnTimeout f21699b;

        public a(SelectInstance r10, OnTimeout r11) {
            this.f21698a = r10;
            this.f21699b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f21698a.trySelect(this.f21699b, Unit.f21064a);
        }
    }

    public OnTimeout(long r10) {
        this.f21697a = r10;
    }

    public static final /* synthetic */ void a(OnTimeout r10, SelectInstance r11, Object r12) {
        r10.c(r11, r12);
    }

    public final SelectClause0 b() {
        OnTimeout$selectClause$1 r10 = OnTimeout$selectClause$1.INSTANCE;
        q.e(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new c(this, (Function3) y.e(r10, 3), null, 4, null);
    }

    public final void c(SelectInstance r10, Object r11) {
        if (this.f21697a > 0) goto L6;
        r10.selectInRegistrationPhase(Unit.f21064a);
        return;
    L6:
        a r12 = new a(r10, this);
        q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        SelectImplementation r13 = (SelectImplementation) r10;
        CoroutineContext r14 = r10.getContext();
        r10.disposeOnCompletion(DelayKt.c(r14).invokeOnTimeout(this.f21697a, r12, r14));
    }
}
