package com.bytedance.android.ui.base.widget.viewflipper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u00011\b\u0007\u0018\u00002\u00020\u0001:\u0005FGHIJB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u00106\u001a\u00020!2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u0014H\u0014J\u0010\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0007H\u0016J\u0016\u0010<\u001a\u00020\u00142\f\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010>H\u0016J\u0012\u0010?\u001a\u00020\u00142\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u000e\u0010B\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u001aJ\u0010\u0010C\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0007H\u0016J\u0006\u0010D\u001a\u00020\u0014J\u0006\u0010E\u001a\u00020\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0004\n\u0002\u00102R$\u00103\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u0011¨\u0006K"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "countDownHandler", "Landroid/os/Handler;", "currentPos", "getCurrentPos", "()I", "value", "currentPosInternal", "setCurrentPosInternal", "(I)V", "endCallback", "Lkotlin/Function0;", "", "getEndCallback", "()Lkotlin/jvm/functions/Function0;", "setEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "flipperAdapter", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperAdapter;", VideoThumbInfo.KEY_INTERVAL, "", "getInterval", "()J", "setInterval", "(J)V", "", "isInfinity", "()Z", "setInfinity", "(Z)V", "isRunning", "needKeepLastView", "getNeedKeepLastView", "setNeedKeepLastView", "positionChangeListener", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$IOnPositionChangeListener;", "getPositionChangeListener", "()Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$IOnPositionChangeListener;", "setPositionChangeListener", "(Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$IOnPositionChangeListener;)V", "runnable", "com/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$runnable$1", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$runnable$1;", "scrollSpeed", "getScrollSpeed", "setScrollSpeed", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "scrollToPosition", "position", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setLayoutManager", "layout", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setViewFlipperAdapter", "smoothScrollToPosition", "startFlipping", "stopFlipping", "ECViewFlipperAdapter", "ECViewFlipperHolder", "EmptyFlipperHolder", "IOnPositionChangeListener", "SmoothLinearLayoutManager", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECViewFlipper extends RecyclerView {
    private final Handler countDownHandler;
    private int currentPosInternal;
    private Function0<Unit> endCallback;
    private ECViewFlipperAdapter flipperAdapter;
    private long interval;
    private boolean isInfinity;
    private boolean isRunning;
    private boolean needKeepLastView;
    private IOnPositionChangeListener positionChangeListener;
    private ECViewFlipper$runnable$1 runnable;
    private int scrollSpeed;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u000eH&J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH&J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH&J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperHolder;", "()V", "viewFlipper", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper;", "getViewFlipper", "()Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper;", "setViewFlipper", "(Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper;)V", "bindFooterHolder", "", "holder", "getFlipperItemCount", "", "getFlipperItemViewType", "position", "getItemCount", "getItemViewType", "onBindViewFlipperHolder", "onBindViewHolder", "onCreateViewFlipperHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onCreateViewHolder", "Companion", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class ECViewFlipperAdapter extends RecyclerView.Adapter<ECViewFlipperHolder> {
        public static final Companion Companion = null;
        private static final int EMPTY_FOOTER = 100000;
        public ECViewFlipper viewFlipper;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperAdapter$Companion;", "", "()V", "EMPTY_FOOTER", "", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        private final void bindFooterHolder(ECViewFlipperHolder r100) {
        }

        public abstract int getFlipperItemCount();

        public final int getFlipperItemViewType(int r100) {
            return 1;
        }

        public abstract void onBindViewFlipperHolder(ECViewFlipperHolder r100, int r101);

        public abstract ECViewFlipperHolder onCreateViewFlipperHolder(ViewGroup r100, int r101);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ECViewFlipper r100 = this.viewFlipper;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("viewFlipper");
        L6:
            if (r100.isInfinity() == false) goto L9;
            return Integer.MAX_VALUE;
        L9:
            ECViewFlipper r101 = this.viewFlipper;
            if (r101 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("viewFlipper");
        L13:
            if (r101.getNeedKeepLastView() == false) goto L17;
            return getFlipperItemCount();
        L17:
            return getFlipperItemCount() + 1;
        }

        public final ECViewFlipper getViewFlipper() {
            ECViewFlipper r100 = this.viewFlipper;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewFlipper");
        L5:
            return r100;
        }

        public ECViewFlipperAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int r100) {
            ECViewFlipper r101 = this.viewFlipper;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("viewFlipper");
        L6:
            if (r101.getNeedKeepLastView() == true) goto L12;
            if (r100 != getFlipperItemCount()) goto L12;
            return 100000;
        L12:
            return getFlipperItemViewType(r100);
        }

        public final void setViewFlipper(ECViewFlipper r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.viewFlipper = r100;
        }

        public void onBindViewHolder(ECViewFlipperHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            int r102 = getFlipperItemCount();
            if (r102 != 0) goto L5;
            return;
        L5:
            ECViewFlipper r103 = this.viewFlipper;
            if (r103 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("viewFlipper");
        L9:
            if (r103.getNeedKeepLastView() == true) goto L12;
            if (r101 != r102) goto L12;
            bindFooterHolder(r100);
            return;
        L12:
            onBindViewFlipperHolder(r100, r101 % r102);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ECViewFlipperHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            RecyclerView.LayoutParams r102 = new RecyclerView.LayoutParams(-1, -1);
            if (r101 != 100000) goto L6;
            EmptyFlipperHolder r103 = new EmptyFlipperHolder(r100.getContext());
            r103.itemView.setLayoutParams(r102);
            return r103;
        L6:
            ECViewFlipperHolder r104 = onCreateViewFlipperHolder(r100, r101);
            r104.itemView.setLayoutParams(r102);
            return r104;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            onBindViewHolder((ECViewFlipperHolder) r100, r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            return onCreateViewHolder(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class ECViewFlipperHolder extends RecyclerView.ViewHolder {
        public ECViewFlipperHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$EmptyFlipperHolder;", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EmptyFlipperHolder extends ECViewFlipperHolder {
        public EmptyFlipperHolder(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(new View(r100));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$IOnPositionChangeListener;", "", "onPositionChange", "", "oldPosition", "", "position", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IOnPositionChangeListener {
        void onPositionChange(int r100, int r101);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$SmoothLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper;Landroid/content/Context;)V", "smoothScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "getSmoothScroller", "()Landroidx/recyclerview/widget/LinearSmoothScroller;", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class SmoothLinearLayoutManager extends LinearLayoutManager {
        private final LinearSmoothScroller smoothScroller;
        final /* synthetic */ ECViewFlipper this$0;

        public final LinearSmoothScroller getSmoothScroller() {
            return this.smoothScroller;
        }

        public SmoothLinearLayoutManager(ECViewFlipper r100, final Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.this$0 = r100;
            super(r101);
            this.smoothScroller = new ECViewFlipper$SmoothLinearLayoutManager$smoothScroller$1(this, r101, r101);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            this.smoothScroller.setTargetPosition(r102);
            startSmoothScroll(this.smoothScroller);
        }
    }

    public ECViewFlipper(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public ECViewFlipper(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter<?> r100) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager r100) {
    }

    public final int getCurrentPos() {
        ECViewFlipperAdapter r100 = this.flipperAdapter;
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.getFlipperItemCount());
    L7:
        if (r101 == null) goto L13;
        if (r101.intValue() != 0) goto L13;
        return -1;
    L13:
        if (this.isInfinity == false) goto L20;
        int r102 = this.currentPosInternal;
        if (r101 == null) goto L17;
        int r103 = r101.intValue();
    L29:
        return r102 % r103;
    L17:
        r103 = 1;
        goto L29
    L20:
        if (this.needKeepLastView == false) goto L28;
        int r104 = this.currentPosInternal;
        if (r101 == null) goto L28;
        if (r104 != r101.intValue()) goto L28;
        return -1;
    L28:
        return this.currentPosInternal;
    L5:
        r101 = null;
        goto L7
    }

    public final void startFlipping() {
        ECViewFlipperAdapter r100 = this.flipperAdapter;
        if (r100 == null) goto L5;
        int r101 = r100.getFlipperItemCount();
    L7:
        if (r101 > 1) goto L10;
        return;
    L10:
        if (this.isRunning == false) goto L12;
        return;
    L12:
        this.isRunning = true;
        this.countDownHandler.postDelayed(this.runnable, this.interval);
        return;
    L5:
        r101 = 0;
        goto L7
    }

    public final void stopFlipping() {
        this.countDownHandler.removeCallbacks(this.runnable);
        this.isRunning = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopFlipping();
    }

    public final Function0<Unit> getEndCallback() {
        return this.endCallback;
    }

    public final long getInterval() {
        return this.interval;
    }

    public final boolean getNeedKeepLastView() {
        return this.needKeepLastView;
    }

    public final IOnPositionChangeListener getPositionChangeListener() {
        return this.positionChangeListener;
    }

    public final int getScrollSpeed() {
        return this.scrollSpeed;
    }

    public final boolean isInfinity() {
        return this.isInfinity;
    }

    public static final /* synthetic */ Handler access$getCountDownHandler$p(ECViewFlipper r100) {
        return r100.countDownHandler;
    }

    public static final /* synthetic */ int access$getCurrentPosInternal$p(ECViewFlipper r100) {
        return r100.currentPosInternal;
    }

    public static final /* synthetic */ ECViewFlipperAdapter access$getFlipperAdapter$p(ECViewFlipper r100) {
        return r100.flipperAdapter;
    }

    public static final /* synthetic */ boolean access$isRunning$p(ECViewFlipper r100) {
        return r100.isRunning;
    }

    private final void setCurrentPosInternal(int r100) {
        int r101 = this.currentPosInternal;
        this.currentPosInternal = r100;
        if (r100 == r101) goto L8;
        IOnPositionChangeListener r102 = this.positionChangeListener;
        if (r102 == null) goto L9;
        r102.onPositionChange(r101, r100);
        return;
    L9:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int r100) {
        setCurrentPosInternal(r100);
        super.scrollToPosition(r100);
    }

    public final void setEndCallback(Function0<Unit> r100) {
        this.endCallback = r100;
    }

    public final void setInfinity(boolean r100) {
        if (this.isRunning == false) goto L5;
        return;
    L5:
        if (this.currentPosInternal > getCurrentPos()) goto L10;
        this.isInfinity = r100;
        return;
    }

    public final void setInterval(long r100) {
        this.interval = r100;
    }

    public final void setNeedKeepLastView(boolean r100) {
        if (this.isRunning == false) goto L5;
        return;
    L5:
        if (this.currentPosInternal > getCurrentPos()) goto L10;
        this.needKeepLastView = r100;
        return;
    }

    public final void setPositionChangeListener(IOnPositionChangeListener r100) {
        this.positionChangeListener = r100;
    }

    public final void setScrollSpeed(int r100) {
        this.scrollSpeed = Math.max(0, Math.min(r100, 1000));
    }

    public final void setViewFlipperAdapter(ECViewFlipperAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        this.flipperAdapter = r100;
        if (r100 == null) goto L5;
        r100.setViewFlipper(this);
    L5:
        super.setAdapter(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int r100) {
        setCurrentPosInternal(r100);
        super.smoothScrollToPosition(r100);
    }

    public static final /* synthetic */ void access$setCurrentPosInternal$p(ECViewFlipper r100, int r101) {
        r100.setCurrentPosInternal(r101);
    }

    public static final /* synthetic */ void access$setFlipperAdapter$p(ECViewFlipper r100, ECViewFlipperAdapter r101) {
        r100.flipperAdapter = r101;
    }

    public static final /* synthetic */ void access$setRunning$p(ECViewFlipper r100, boolean r101) {
        r100.isRunning = r101;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper$runnable$1] */
    public ECViewFlipper(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.interval = 2000;
        this.scrollSpeed = 200;
        this.needKeepLastView = true;
        this.isInfinity = true;
        this.runnable = new ECViewFlipper$runnable$1(this);
        this.countDownHandler = new Handler(Looper.getMainLooper());
        setEnabled(false);
        super.setLayoutManager(new SmoothLinearLayoutManager(this, r100));
    }

    public /* synthetic */ ECViewFlipper(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
