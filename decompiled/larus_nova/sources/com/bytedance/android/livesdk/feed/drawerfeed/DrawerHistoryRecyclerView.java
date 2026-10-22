package com.bytedance.android.livesdk.feed.drawerfeed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import ew1.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/DrawerHistoryRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerHistoryRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f123696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f123697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f123698c;

    public DrawerHistoryRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DrawerHistoryRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.f123696a = (int) r100.getX();
        this.f123697b = (int) r100.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f123698c = false;
    L31:
        return super.dispatchTouchEvent(r100);
    L5:
        if (r101 != 2) goto L31;
        int r102 = (int) r100.getX();
        int r103 = (int) r100.getY();
        int r104 = Math.abs(r102 - this.f123696a);
        int r105 = Math.abs(r103 - this.f123697b);
        RecyclerView.LayoutManager r106 = getLayoutManager();
        if ((r106 instanceof LinearLayoutManager) == true) goto L10;
        r106 = null;
    L10:
        LinearLayoutManager r107 = (LinearLayoutManager) r106;
        if (r107 == null) goto L31;
        int r108 = r107.findLastCompletelyVisibleItemPosition();
        int r109 = r107.findFirstCompletelyVisibleItemPosition();
        int r110 = r107.getItemCount();
        if (r104 > r105) goto L15;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L31
    L15:
        if (r108 == (r110 - 1)) goto L17;
    L21:
        if (r109 == 0) goto L23;
    L27:
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f123698c = true;
        goto L31
    L23:
        if (this.f123696a >= r102) goto L27;
        if (this.f123698c == true) goto L27;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L31
    L17:
        if (this.f123696a <= r102) goto L21;
        if (this.f123698c == true) goto L21;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L31
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        b.a("onMeasure", th);
    }

    public DrawerHistoryRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ DrawerHistoryRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        b.a("onLayout", th);
    }
}
