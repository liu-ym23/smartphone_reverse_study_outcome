package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/room/discovery/AnchorPerfDialogScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "canScroll", "", "setCanScroll", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPerfDialogScrollView extends NestedScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f99185a;

    public AnchorPerfDialogScrollView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return super.dispatchTouchEvent(r100);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f99185a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f99185a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r100) == false) goto L7;
        return true;
    }

    public final void setCanScroll(boolean r100) {
        this.f99185a = r100;
    }

    public AnchorPerfDialogScrollView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public AnchorPerfDialogScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f99185a = true;
        setNestedScrollingEnabled(true);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        if (r102 <= 0) goto L5;
        byte r105 = 1;
    L8:
        if (r105 == (-1)) goto L24;
        if (r105 == 0) goto L22;
        if (r105 != 1) goto L32;
        int r106 = 0 - getScrollY();
        if (r106 > 0) goto L15;
    L17:
        int r107 = r102;
    L18:
        if (r107 > 0) goto L20;
        return;
    L20:
        if (r100.canScrollVertically(1) == false) goto L28;
        r100.scrollBy(0, r107);
        r103[1] = r102;
        return;
    L28:
        return;
    L15:
        if (canScrollVertically(1) == false) goto L17;
        int r108 = RangesKt.coerceAtMost(r102, r106);
        scrollBy(0, r108);
        r103[1] = r108;
        r107 = r102 - r108;
        goto L18
    L32:
        return;
    L22:
        r103[1] = 0;
        return;
    L24:
        if (r100.canScrollVertically(-1) == false) goto L31;
        int r109 = -RangesKt.coerceAtMost(Math.abs(r102), Math.abs(r100.getScrollY()));
        r100.scrollBy(0, r109);
        r103[1] = r109;
        return;
    L31:
        return;
    L5:
        if (r102 >= 0) goto L7;
        r105 = -1;
        goto L8
    L7:
        r105 = 0;
        goto L8
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        boolean r106 = true;
        if (r104 > 0) goto L5;
    L6:
        if (r104 < 0) goto L8;
    L10:
        r106 = false;
    L11:
        if (r106 == false) goto L14;
        scrollBy(0, r104);
        return;
    L14:
        return;
    L8:
        if (canScrollVertically(-1) == false) goto L10;
    L5:
        if (canScrollVertically(1) == true) goto L11;
        goto L6
    }
}
