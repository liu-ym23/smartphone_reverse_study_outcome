package androidx.compose.ui.scrollcapture;

import C7.r;
import J7.c;
import S7.n;
import U7.a;
import androidx.compose.foundation.b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0082@¢\u0006\u0004\b\u0007\u0010\fJ\r\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\u0016\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R0\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R$\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/scrollcapture/RelativeScroller;", "", "", "viewportSize", "Lkotlin/Function2;", "", "LH7/c;", "scrollBy", AppAgent.CONSTRUCT, "(ILS7/n;)V", "delta", "LC7/r;", "(FLH7/c;)Ljava/lang/Object;", "reset", "()V", "min", "max", "scrollRangeIntoView", "(IILH7/c;)Ljava/lang/Object;", TypedValues.CycleType.S_WAVE_OFFSET, "mapOffsetToViewport", "(I)I", "scrollTo", "I", "LS7/n;", "value", "scrollAmount", "F", "getScrollAmount", "()F", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class RelativeScroller {
    private float scrollAmount;
    private final n scrollBy;
    private final int viewportSize;

    @c(c = "androidx.compose.ui.scrollcapture.RelativeScroller", f = "ComposeScrollCaptureCallback.android.kt", l = {296}, m = "scrollBy")
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RelativeScroller.this.scrollBy(0.0f, this);
        }
    }

    public RelativeScroller(int i, n nVar) {
        this.viewportSize = i;
        this.scrollBy = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object scrollBy(float r5, H7.c<? super C7.r> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.ui.scrollcapture.RelativeScroller.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1 r0 = (androidx.compose.ui.scrollcapture.RelativeScroller.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1 r0 = new androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r6)
            goto L42
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r6)
            S7.n r6 = r4.scrollBy
            java.lang.Float r2 = new java.lang.Float
            r2.<init>(r5)
            r0.label = r3
            java.lang.Object r6 = r6.invoke(r2, r0)
            if (r6 != r1) goto L42
            return r1
        L42:
            java.lang.Number r6 = (java.lang.Number) r6
            float r5 = r6.floatValue()
            float r6 = r4.scrollAmount
            float r6 = r6 + r5
            r4.scrollAmount = r6
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.scrollcapture.RelativeScroller.scrollBy(float, H7.c):java.lang.Object");
    }

    public final float getScrollAmount() {
        return this.scrollAmount;
    }

    public final int mapOffsetToViewport(int offset) {
        return AbstractC1451a.u(offset - a.U(this.scrollAmount), 0, this.viewportSize);
    }

    public final void reset() {
        this.scrollAmount = 0.0f;
    }

    public final Object scrollRangeIntoView(int i, int i6, H7.c<? super r> cVar) {
        if (i > i6) {
            throw new IllegalArgumentException(b.n(i, i6, "Expected min=", " ≤ max=").toString());
        }
        int i10 = i6 - i;
        int i11 = this.viewportSize;
        if (i10 > i11) {
            StringBuilder sbU = B7.a.u(i10, "Expected range (", ") to be ≤ viewportSize=");
            sbU.append(this.viewportSize);
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        float f = i;
        float f7 = this.scrollAmount;
        r rVar = r.f317a;
        if (f >= f7 && i6 <= i11 + f7) {
            return rVar;
        }
        if (f >= f7) {
            i = i6 - i11;
        }
        Object objScrollTo = scrollTo(i, cVar);
        return objScrollTo == CoroutineSingletons.f4909a ? objScrollTo : rVar;
    }

    public final Object scrollTo(float f, H7.c<? super r> cVar) {
        Object objScrollBy = scrollBy(f - this.scrollAmount, cVar);
        return objScrollBy == CoroutineSingletons.f4909a ? objScrollBy : r.f317a;
    }
}
