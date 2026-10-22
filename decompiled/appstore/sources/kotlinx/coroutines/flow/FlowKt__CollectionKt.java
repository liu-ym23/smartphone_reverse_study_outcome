package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__CollectionKt {

    public static final class a implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f21433a;

        public a(Collection r10) {
            this.f21433a = r10;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r10, Continuation r11) {
            this.f21433a.add(r10);
            return Unit.f21064a;
        }
    }

    public static final Object a(Flow r10, Collection r11, Continuation r12) {
        if ((r12 instanceof FlowKt__CollectionKt$toCollection$1) == false) goto L7;
        FlowKt__CollectionKt$toCollection$1 r13 = (FlowKt__CollectionKt$toCollection$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        Collection r18 = (Collection) r13.L$0;
        kotlin.c.b(r15);
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r15);
        a r19 = new a(r11);
        r13.L$0 = r11;
        r13.label = 1;
        if (r10.collect(r19, r13) != r16) goto L18;
        return r16;
    L18:
        return r11;
    L7:
        r13 = new FlowKt__CollectionKt$toCollection$1(r12);
        goto L8
    }
}
