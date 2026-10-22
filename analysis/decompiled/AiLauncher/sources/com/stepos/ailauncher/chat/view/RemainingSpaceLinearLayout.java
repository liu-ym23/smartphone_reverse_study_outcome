package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/chat/view/RemainingSpaceLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "LY8/t;", "onMeasure", "(II)V", Const.INTENT_KEY_APIKEY, "()I", "Landroid/graphics/Rect;", "siblingBounds", "Landroid/graphics/Rect;", "HostLayoutManager", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemainingSpaceLinearLayout extends LinearLayout {
    private final Rect siblingBounds;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0013\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u000eR\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/chat/view/RemainingSpaceLinearLayout$HostLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/View;", "child", "", "widthUsed", "heightUsed", "LY8/t;", "measureChildWithMargins", "(Landroid/view/View;II)V", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "onLayoutChildren", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)V", "v", "()V", "Lcom/stepos/ailauncher/chat/view/RemainingSpaceLinearLayout;", "u", "()Lcom/stepos/ailauncher/chat/view/RemainingSpaceLinearLayout;", "Landroid/graphics/Rect;", "fillerBounds", "Landroid/graphics/Rect;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class HostLayoutManager extends LinearLayoutManager {
        private final Rect fillerBounds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HostLayoutManager(Context context) {
            super(context, 1, false);
            kotlin.jvm.internal.p.i(context, "context");
            this.fillerBounds = new Rect();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void measureChildWithMargins(View child, int widthUsed, int heightUsed) {
            kotlin.jvm.internal.p.i(child, "child");
            if (child instanceof RemainingSpaceLinearLayout) {
                child.forceLayout();
            }
            super.measureChildWithMargins(child, widthUsed, heightUsed);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            kotlin.jvm.internal.p.i(recycler, "recycler");
            kotlin.jvm.internal.p.i(state, "state");
            super.onLayoutChildren(recycler, state);
            if (state.isPreLayout()) {
                return;
            }
            v();
        }

        public final RemainingSpaceLinearLayout u() {
            View childAt;
            int childCount = getChildCount();
            do {
                childCount--;
                if (-1 >= childCount) {
                    return null;
                }
                childAt = getChildAt(childCount);
            } while (!(childAt instanceof RemainingSpaceLinearLayout));
            return (RemainingSpaceLinearLayout) childAt;
        }

        public final void v() {
            RemainingSpaceLinearLayout remainingSpaceLinearLayoutU = u();
            if (remainingSpaceLinearLayoutU == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = remainingSpaceLinearLayoutU.getLayoutParams();
            RecyclerView.LayoutParams layoutParams2 = layoutParams instanceof RecyclerView.LayoutParams ? (RecyclerView.LayoutParams) layoutParams : null;
            if (layoutParams2 == null) {
                return;
            }
            getDecoratedBoundsWithMargins(remainingSpaceLinearLayoutU, this.fillerBounds);
            measureChildWithMargins(remainingSpaceLinearLayoutU, 0, 0);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(remainingSpaceLinearLayoutU) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
            Rect rect = this.fillerBounds;
            int i10 = rect.left;
            int i11 = rect.top;
            layoutDecoratedWithMargins(remainingSpaceLinearLayoutU, i10, i11, rect.right, i11 + decoratedMeasuredHeight);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RemainingSpaceLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final int a() {
        RecyclerView.LayoutManager layoutManager;
        int height;
        RecyclerView.Adapter adapter;
        int i10;
        int childLayoutPosition;
        ViewParent parent = getParent();
        RecyclerView recyclerView = parent instanceof RecyclerView ? (RecyclerView) parent : null;
        int i11 = 0;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (height = layoutManager.getHeight()) > 0 && (adapter = recyclerView.getAdapter()) != null) {
            int itemCount = adapter.getItemCount();
            int childLayoutPosition2 = recyclerView.getChildLayoutPosition(this);
            if (childLayoutPosition2 != itemCount - 1 || childLayoutPosition2 >= 64) {
                return 0;
            }
            int paddingTop = layoutManager.getPaddingTop();
            int childCount = recyclerView.getChildCount();
            int i12 = 0;
            long j10 = 0;
            while (i12 < childCount) {
                View childAt = recyclerView.getChildAt(i12);
                if (childAt != this) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    i10 = i11;
                    RecyclerView.LayoutParams layoutParams2 = layoutParams instanceof RecyclerView.LayoutParams ? (RecyclerView.LayoutParams) layoutParams : null;
                    if (layoutParams2 == null) {
                        return i10;
                    }
                    if (!layoutParams2.isItemRemoved() && (childLayoutPosition = recyclerView.getChildLayoutPosition(childAt)) >= 0 && childLayoutPosition < childLayoutPosition2) {
                        long j11 = 1 << childLayoutPosition;
                        if ((j10 & j11) == 0) {
                            j10 |= j11;
                            recyclerView.getDecoratedBoundsWithMargins(childAt, this.siblingBounds);
                            paddingTop += this.siblingBounds.height();
                        }
                    }
                } else {
                    i10 = i11;
                }
                i12++;
                i11 = i10;
            }
            int i13 = i11;
            if (Long.bitCount(j10) != childLayoutPosition2) {
                return i13;
            }
            ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
            return (((height - layoutManager.getPaddingBottom()) - paddingTop) - (marginLayoutParams != null ? marginLayoutParams.bottomMargin + marginLayoutParams.topMargin : i13)) - (layoutManager.getTopDecorationHeight(this) + layoutManager.getBottomDecorationHeight(this));
        }
        return 0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int iA = a();
        if (iA > getMeasuredHeight()) {
            setMeasuredDimension(getMeasuredWidthAndState(), iA);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemainingSpaceLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.siblingBounds = new Rect();
    }

    public /* synthetic */ RemainingSpaceLinearLayout(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
