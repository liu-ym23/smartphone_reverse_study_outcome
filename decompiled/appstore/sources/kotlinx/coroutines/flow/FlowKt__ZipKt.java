package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__ZipKt {

    public static final class a implements Flow {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f21480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Flow f21481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function3 f21482c;

        public a(Flow r10, Flow r11, Function3 r12) {
            this.f21480a = r10;
            this.f21481b = r11;
            this.f21482c = r12;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector r10, Continuation r11) {
            Object r12 = CombineKt.a(r10, new Flow[]{this.f21480a, this.f21481b}, FlowKt__ZipKt.a(), new FlowKt__ZipKt$combine$1$1(this.f21482c, null), r11);
            if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
            return r12;
        L6:
            return Unit.f21064a;
        }
    }

    public static final /* synthetic */ Function0 a() {
        return e();
    }

    public static final Flow b(Flow r10, Flow r11, Function3 r12) {
        return c.B(r10, r11, r12);
    }

    public static final Flow c(Flow r10, Flow r11, Flow r12, final Function4 r13) {
        final Flow[] r14 = {r10, r11, r12};
        return new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1(r14, r13);
    }

    public static final Flow d(Flow r10, Flow r11, Function3 r12) {
        return new a(r10, r11, r12);
    }

    public static final Function0 e() {
        return FlowKt__ZipKt$nullArrayFactory$1.INSTANCE;
    }
}
