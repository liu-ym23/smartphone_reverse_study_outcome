package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class n {

    public static final class a implements Flow {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f21557a;

        public a(Object r10) {
            this.f21557a = r10;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector r10, Continuation r11) {
            Object r12 = r10.emit(this.f21557a, r11);
            if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
            return r12;
        L6:
            return Unit.f21064a;
        }
    }

    public static final Flow a(Function2 r10) {
        return new CallbackFlowBuilder(r10, null, 0, null, 14, null);
    }

    public static final Flow b(Function2 r10) {
        return new a1(r10);
    }

    public static final Flow c(Object r10) {
        return new a(r10);
    }
}
