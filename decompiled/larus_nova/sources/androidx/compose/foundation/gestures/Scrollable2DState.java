package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JA\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\b\nH¦@¢\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\rH&¢\u0006\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/Scrollable2DState;", "", GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "Landroidx/compose/ui/geometry/Offset;", "delta", "dispatchRawDelta-MK-Hz9U", "(J)J", "isScrollInProgress", "", "()Z", "canScroll", "offset", "canScroll-k-4lQ0M", "(J)Z", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Scrollable2DState {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.Scrollable2DState$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object scroll$default(Scrollable2DState r100, MutatePriority r101, Function2 r102, Continuation r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 1) == 0) goto L7;
            r101 = MutatePriority.Default;
        L7:
            return r100.scroll(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scroll");
        }
    }

    /* JADX INFO: renamed from: canScroll-k-4lQ0M */
    boolean mo406canScrollk4lQ0M(long r100);

    /* JADX INFO: renamed from: dispatchRawDelta-MK-Hz9U */
    long mo407dispatchRawDeltaMKHz9U(long r100);

    boolean isScrollInProgress();

    Object scroll(MutatePriority r100, Function2<? super Scroll2DScope, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102);
}
