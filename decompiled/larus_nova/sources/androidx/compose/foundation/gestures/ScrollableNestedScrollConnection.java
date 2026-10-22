package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0017H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollLogic;", "enabled", "", "<init>", "(Landroidx/compose/foundation/gestures/ScrollLogic;Z)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollLogic;", "getEnabled", "()Z", "setEnabled", "(Z)V", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private boolean enabled;
    private final ScrollLogic scrollingLogic;

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public final /* synthetic */ Object mo498onPreFlingQWom1Mo(long r100, Continuation r101) {
        return NestedScrollConnection.CC.m5987$default$onPreFlingQWom1Mo(this, r100, r101);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public final /* synthetic */ long mo499onPreScrollOzD1aCk(long r100, int r101) {
        return NestedScrollConnection.CC.m5988$default$onPreScrollOzD1aCk(this, r100, r101);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final ScrollLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    public final void setEnabled(boolean r100) {
        this.enabled = r100;
    }

    public ScrollableNestedScrollConnection(ScrollLogic r100, boolean r101) {
        this.scrollingLogic = r100;
        this.enabled = r101;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object mo496onPostFlingRZ2iAVY(long r100, long r101, Continuation<? super Velocity> r102) {
        if ((r102 instanceof ScrollableNestedScrollConnection$onPostFling$1) == false) goto L7;
        ScrollableNestedScrollConnection$onPostFling$1 r103 = (ScrollableNestedScrollConnection$onPostFling$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.J$0;
        ResultKt.throwOnFailure(r105);
    L22:
        long r108 = ((Velocity) r105).m7795unboximpl();
    L23:
        long r109 = Velocity.m7789minusAH228Gc(r101, r108);
    L26:
        return Velocity.m7777boximpl(r109);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (this.enabled == true) goto L17;
        r109 = Velocity.Companion.m7797getZero9UxMQ8M();
        goto L26
    L17:
        if (this.scrollingLogic.isFlinging() == false) goto L19;
        r108 = Velocity.Companion.m7797getZero9UxMQ8M();
        goto L23
    L19:
        ScrollLogic r110 = this.scrollingLogic;
        r103.J$0 = r101;
        r103.label = 1;
        r105 = r110.mo485doFlingAnimationQWom1Mo(r101, r103);
        if (r105 != r106) goto L22;
        return r106;
    L7:
        r103 = new ScrollableNestedScrollConnection$onPostFling$1(this, r102);
        goto L8
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long mo497onPostScrollDzOQY0M(long r100, long r101, int r102) {
        if (this.enabled == false) goto L6;
        return this.scrollingLogic.mo486performRawScrollMKHz9U(r101);
    L6:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }
}
