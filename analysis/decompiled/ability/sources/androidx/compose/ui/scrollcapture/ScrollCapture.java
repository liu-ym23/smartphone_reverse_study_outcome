package androidx.compose.ui.scrollcapture;

import C7.r;
import F7.a;
import H7.h;
import S7.k;
import android.graphics.Point;
import android.view.ScrollCaptureTarget;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRectKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.AdaptedFunctionReference;
import m9.AbstractC1683A;

@StabilityInferred(parameters = 1)
@RequiresApi(31)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0003R+\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/scrollcapture/ScrollCapture;", "Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", AppAgent.CONSTRUCT, "()V", "Landroid/view/View;", "view", "Landroidx/compose/ui/semantics/SemanticsOwner;", "semanticsOwner", "LH7/h;", "coroutineContext", "Ljava/util/function/Consumer;", "Landroid/view/ScrollCaptureTarget;", "targets", "LC7/r;", "onScrollCaptureSearch", "(Landroid/view/View;Landroidx/compose/ui/semantics/SemanticsOwner;LH7/h;Ljava/util/function/Consumer;)V", "onSessionStarted", "onSessionEnded", "", "<set-?>", "scrollCaptureInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "getScrollCaptureInProgress", "()Z", "setScrollCaptureInProgress", "(Z)V", "scrollCaptureInProgress", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollCapture implements ComposeScrollCaptureCallback.ScrollCaptureSessionListener {
    public static final int $stable = 0;

    /* renamed from: scrollCaptureInProgress$delegate, reason: from kotlin metadata */
    private final MutableState scrollCaptureInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements k {
        public AnonymousClass1(Object obj) {
            super(1, MutableVector.class, obj, "add", "add(Ljava/lang/Object;)Z");
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ScrollCaptureCandidate) obj);
            return r.f317a;
        }

        public final void invoke(ScrollCaptureCandidate scrollCaptureCandidate) {
            ((MutableVector) this.receiver).add(scrollCaptureCandidate);
        }
    }

    private final void setScrollCaptureInProgress(boolean z10) {
        this.scrollCaptureInProgress.setValue(Boolean.valueOf(z10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getScrollCaptureInProgress() {
        return ((Boolean) this.scrollCaptureInProgress.getValue()).booleanValue();
    }

    public final void onScrollCaptureSearch(View view, SemanticsOwner semanticsOwner, h coroutineContext, Consumer<ScrollCaptureTarget> targets) {
        MutableVector mutableVector = new MutableVector(new ScrollCaptureCandidate[16], 0);
        ScrollCapture_androidKt.visitScrollCaptureCandidates$default(semanticsOwner.getUnmergedRootSemanticsNode(), 0, new AnonymousClass1(mutableVector), 2, null);
        mutableVector.sortWith(new a(new k[]{new k() { // from class: androidx.compose.ui.scrollcapture.ScrollCapture.onScrollCaptureSearch.2
            @Override // S7.k
            public final Comparable<?> invoke(ScrollCaptureCandidate scrollCaptureCandidate) {
                return Integer.valueOf(scrollCaptureCandidate.getDepth());
            }
        }, new k() { // from class: androidx.compose.ui.scrollcapture.ScrollCapture.onScrollCaptureSearch.3
            @Override // S7.k
            public final Comparable<?> invoke(ScrollCaptureCandidate scrollCaptureCandidate) {
                return Integer.valueOf(scrollCaptureCandidate.getViewportBoundsInWindow().getHeight());
            }
        }}, 0));
        ScrollCaptureCandidate scrollCaptureCandidate = (ScrollCaptureCandidate) (mutableVector.getSize() != 0 ? mutableVector.content[mutableVector.getSize() - 1] : null);
        if (scrollCaptureCandidate == null) {
            return;
        }
        ComposeScrollCaptureCallback composeScrollCaptureCallback = new ComposeScrollCaptureCallback(scrollCaptureCandidate.getNode(), scrollCaptureCandidate.getViewportBoundsInWindow(), AbstractC1683A.b(coroutineContext), this, view);
        Rect rectBoundsInRoot = LayoutCoordinatesKt.boundsInRoot(scrollCaptureCandidate.getCoordinates());
        long jM7001getTopLeftnOccac = scrollCaptureCandidate.getViewportBoundsInWindow().m7001getTopLeftnOccac();
        ScrollCaptureTarget scrollCaptureTarget = new ScrollCaptureTarget(view, RectHelper_androidKt.toAndroidRect(IntRectKt.roundToIntRect(rectBoundsInRoot)), new Point(IntOffset.m6972getXimpl(jM7001getTopLeftnOccac), IntOffset.m6973getYimpl(jM7001getTopLeftnOccac)), composeScrollCaptureCallback);
        scrollCaptureTarget.setScrollBounds(RectHelper_androidKt.toAndroidRect(scrollCaptureCandidate.getViewportBoundsInWindow()));
        targets.accept(scrollCaptureTarget);
    }

    @Override // androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.ScrollCaptureSessionListener
    public void onSessionEnded() {
        setScrollCaptureInProgress(false);
    }

    @Override // androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.ScrollCaptureSessionListener
    public void onSessionStarted() {
        setScrollCaptureInProgress(true);
    }
}
