package androidx.compose.foundation.gestures;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J9\u0010\u000f\u001a\u00020\u00102#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00100\u0012H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u0017\u001a\u00020\u0010J9\u0010\u0018\u001a\u00020\u00102#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u0012H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0010\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "", "<init>", "()V", "requests", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "size", "", "getSize", "()I", "isEmpty", "", "enqueue", "request", "forEachFromSmallest", "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", "name", "bounds", "resumeAndRemoveAll", "resumeAndRemoveWhile", "cancelAndRemoveAll", "cause", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BringIntoViewRequestPriorityQueue {
    public static final int $stable = 0;
    private final MutableVector<ContentInViewNode.Request> requests;

    static {
        $stable = MutableVector.$stable;
    }

    public static /* synthetic */ Unit a(BringIntoViewRequestPriorityQueue r100, ContentInViewNode.Request r101, Throwable r102) {
        return enqueue$lambda$1(r100, r101, r102);
    }

    public final int getSize() {
        return this.requests.getSize();
    }

    public final boolean isEmpty() {
        if (this.requests.getSize() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void resumeAndRemoveAll() {
        IntRange r100 = RangesKt.until(0, this.requests.getSize());
        int r101 = r100.getFirst();
        int r102 = r100.getLast();
        if (r101 > r102) goto L7;
    L4:
        this.requests.content[r101].getContinuation().resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        if (r101 == r102) goto L7;
        r101 = r101 + 1;
    L7:
        this.requests.clear();
    }

    public BringIntoViewRequestPriorityQueue() {
        this.requests = new MutableVector(new ContentInViewNode.Request[16], 0);
    }

    public static final /* synthetic */ MutableVector access$getRequests$p(BringIntoViewRequestPriorityQueue r100) {
        return r100.requests;
    }

    public final void cancelAndRemoveAll(Throwable r100) {
        MutableVector<ContentInViewNode.Request> r101 = this.requests;
        int r102 = r101.getSize();
        kotlinx.coroutines.i[] r103 = new kotlinx.coroutines.i[r102];
        boolean r104 = false;
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L5;
        r103[r105] = r101.content[r105].getContinuation();
        r105 = r105 + 1;
        goto L3
    L5:
        int r106 = 0;
    L6:
        if (r106 >= r102) goto L9;
        r103[r106].cancel(r100);
        r106 = r106 + 1;
        goto L6
    L9:
        if (this.requests.getSize() != 0) goto L11;
        r104 = true;
    L11:
        if (r104 == true) goto L16;
        InlineClassHelperKt.throwIllegalStateException("uncancelled requests present");
        return;
    }

    public final boolean enqueue(final ContentInViewNode.Request r100) {
        Rect r101 = r100.getCurrentBounds().invoke();
        if (r101 != null) goto L6;
        kotlinx.coroutines.i<Unit> r102 = r100.getContinuation();
        Result.Companion r103 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        return false;
    L6:
        r100.getContinuation().i(new b0(this, r100));
        IntRange r104 = RangesKt.until(0, this.requests.getSize());
        int r105 = r104.getFirst();
        int r106 = r104.getLast();
        if (r105 > r106) goto L24;
    L8:
        Rect r107 = this.requests.content[r106].getCurrentBounds().invoke();
        if (r107 == null) goto L22;
        Rect r108 = r101.intersect(r107);
        if (Intrinsics.areEqual(r108, r101) == true) goto L13;
        if (Intrinsics.areEqual(r108, r107) == true) goto L22;
        CancellationException r109 = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
        int r110 = this.requests.getSize() - 1;
        if (r110 > r106) goto L22;
    L19:
        this.requests.content[r106].getContinuation().cancel(r109);
        if (r110 == r106) goto L22;
        r110 = r110 + 1;
        goto L19
    L13:
        this.requests.add(r106 + 1, r100);
        return true;
    L22:
        if (r106 == r105) goto L24;
        r106 = r106 - 1;
    L24:
        this.requests.add(0, r100);
        return true;
    }

    public final void forEachFromSmallest(Function1<? super Rect, Unit> r100) {
        MutableVector r101 = access$getRequests$p(this);
        int r102 = r101.getSize() - 1;
        Object[] r103 = r101.content;
        if (r102 >= r103.length) goto L6;
    L4:
        if (r102 < 0) goto L8;
        r100.invoke(((ContentInViewNode.Request) r103[r102]).getCurrentBounds().invoke());
        r102 = r102 - 1;
        goto L4
    L8:
        return;
    }

    public final void resumeAndRemoveWhile(Function1<? super Rect, Boolean> r100) {
    L3:
        if (access$getRequests$p(this).getSize() == 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        if (r100.invoke(((ContentInViewNode.Request) access$getRequests$p(this).last()).getCurrentBounds().invoke()).booleanValue() == false) goto L13;
        ((ContentInViewNode.Request) access$getRequests$p(this).removeAt(access$getRequests$p(this).getSize() - 1)).getContinuation().resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        goto L3
    L13:
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
    }

    private static final Unit enqueue$lambda$1(BringIntoViewRequestPriorityQueue r100, ContentInViewNode.Request r101, Throwable r102) {
        r100.requests.remove(r101);
        return Unit.INSTANCE;
    }
}
