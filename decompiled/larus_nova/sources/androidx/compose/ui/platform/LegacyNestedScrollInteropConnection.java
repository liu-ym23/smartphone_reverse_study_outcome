package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/platform/LegacyNestedScrollInteropConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "nestedScrollChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "consumedScrollCache", "", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interruptOngoingScrolls", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LegacyNestedScrollInteropConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private final int[] consumedScrollCache;
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    private final View view;

    private final void interruptOngoingScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0) == false) goto L6;
        this.nestedScrollChildHelper.stopNestedScroll(0);
    L6:
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1) == false) goto L9;
        this.nestedScrollChildHelper.stopNestedScroll(1);
        return;
    }

    public LegacyNestedScrollInteropConnection(View r100) {
        this.view = r100;
        NestedScrollingChildHelper r101 = new NestedScrollingChildHelper(r100);
        r101.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = r101;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(r100, true);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo498onPreFlingQWom1Mo(long r100, Continuation<? super Velocity> r101) {
        if (this.nestedScrollChildHelper.dispatchNestedPreFling(NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.m7786getXimpl(r100)), NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.m7787getYimpl(r100))) == true) goto L6;
        r100 = Velocity.Companion.m7797getZero9UxMQ8M();
    L6:
        interruptOngoingScrolls();
        return Velocity.m7777boximpl(r100);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo499onPreScrollOzD1aCk(long r110, int r111) {
        if (this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m6731access$getScrollAxesk4lQ0M(r110), NestedScrollInteropConnectionKt.m6733access$toViewTypeGyEprt8(r111)) == false) goto L7;
        ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, null);
        this.nestedScrollChildHelper.dispatchNestedPreScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (r110 >> 32))), NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r110))), this.consumedScrollCache, null, NestedScrollInteropConnectionKt.m6733access$toViewTypeGyEprt8(r111));
        return NestedScrollInteropConnectionKt.m6732access$toOffsetUv8p0NA(this.consumedScrollCache, r110);
    L7:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo496onPostFlingRZ2iAVY(long r100, long r101, Continuation<? super Velocity> r102) {
        if (this.nestedScrollChildHelper.dispatchNestedFling(NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.m7786getXimpl(r101)), NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.m7787getYimpl(r101)), true) == true) goto L6;
        r101 = Velocity.Companion.m7797getZero9UxMQ8M();
    L6:
        interruptOngoingScrolls();
        return Velocity.m7777boximpl(r101);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo497onPostScrollDzOQY0M(long r110, long r210, int r211) {
        if (this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m6731access$getScrollAxesk4lQ0M(r210), NestedScrollInteropConnectionKt.m6733access$toViewTypeGyEprt8(r211)) == false) goto L7;
        ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, null);
        this.nestedScrollChildHelper.dispatchNestedScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (r110 >> 32))), NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (r110 & BodyPartID.bodyIdMax))), NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (r210 >> 32))), NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (r210 & BodyPartID.bodyIdMax))), null, NestedScrollInteropConnectionKt.m6733access$toViewTypeGyEprt8(r211), this.consumedScrollCache);
        return NestedScrollInteropConnectionKt.m6732access$toOffsetUv8p0NA(this.consumedScrollCache, r210);
    L7:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }
}
