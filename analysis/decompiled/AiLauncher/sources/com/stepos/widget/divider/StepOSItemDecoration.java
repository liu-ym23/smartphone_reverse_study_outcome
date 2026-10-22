package com.stepos.widget.divider;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.container.wallpaper.a;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.widget.R;
import com.stepos.widget.divider.StepOSItemDecoration;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.list.StepOSSwipeActionLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00112\b\b\u0001\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0013J!\u0010\u0018\u001a\u00020\u00112\b\b\u0001\u0010\u0016\u001a\u00020\u000f2\b\b\u0001\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J'\u0010#\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/stepos/widget/divider/StepOSItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "", "isVerticalLinear", "(Landroidx/recyclerview/widget/RecyclerView;)Z", "Landroid/view/View;", "v", "interactionHidesDivider", "(Landroid/view/View;)Z", "", "color", "LY8/t;", "setDividerColor", "(I)V", "px", "setDividerThickness", "start", a.PHASE_END, "setDividerInsets", "(II)V", "Landroid/graphics/Rect;", "outRect", "view", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Lcom/stepos/widget/divider/StepOSDividerPainter;", "painter", "Lcom/stepos/widget/divider/StepOSDividerPainter;", "Lcom/stepos/widget/divider/StepOSItemDecoration$Policy;", PolicySdkConstants.policyFileDir, "Lcom/stepos/widget/divider/StepOSItemDecoration$Policy;", "getPolicy", "()Lcom/stepos/widget/divider/StepOSItemDecoration$Policy;", "setPolicy", "(Lcom/stepos/widget/divider/StepOSItemDecoration$Policy;)V", "Policy", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSItemDecoration extends RecyclerView.ItemDecoration {
    private final StepOSDividerPainter painter;
    private Policy policy;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/divider/StepOSItemDecoration$Policy;", "", "shouldDrawAfter", "", "position", "", "itemCount", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Policy {
        boolean shouldDrawAfter(int position, int itemCount);
    }

    public StepOSItemDecoration(Context context) {
        p.i(context, "context");
        StepOSDividerPainter stepOSDividerPainter = new StepOSDividerPainter();
        Resources resources = context.getResources();
        stepOSDividerPainter.setThickness$StepOSWidget_release(resources.getDimensionPixelSize(R.dimen.stepos_divider_height));
        stepOSDividerPainter.setInsetStart$StepOSWidget_release(resources.getDimensionPixelSize(R.dimen.stepos_divider_inset_start));
        stepOSDividerPainter.setInsetEnd$StepOSWidget_release(resources.getDimensionPixelSize(R.dimen.stepos_divider_inset_end));
        stepOSDividerPainter.setColor$StepOSWidget_release(context.getColor(R.color.stepos_divider));
        this.painter = stepOSDividerPainter;
        this.policy = new Policy() { // from class: P7.a
            @Override // com.stepos.widget.divider.StepOSItemDecoration.Policy
            public final boolean shouldDrawAfter(int i10, int i11) {
                return StepOSItemDecoration.policy$lambda$1(i10, i11);
            }
        };
    }

    private final boolean interactionHidesDivider(View v10) {
        StepOSListItem contentListItem$StepOSWidget_release;
        StepOSSwipeActionLayout stepOSSwipeActionLayout = v10 instanceof StepOSSwipeActionLayout ? (StepOSSwipeActionLayout) v10 : null;
        if (stepOSSwipeActionLayout != null && (contentListItem$StepOSWidget_release = stepOSSwipeActionLayout.getContentListItem$StepOSWidget_release()) != null) {
            v10 = contentListItem$StepOSWidget_release;
        }
        StepOSListItem stepOSListItem = v10 instanceof StepOSListItem ? (StepOSListItem) v10 : null;
        return stepOSListItem != null ? stepOSListItem.getHidesAdjacentDividers$StepOSWidget_release() : v10 != null && v10.isPressed();
    }

    private final boolean isVerticalLinear(RecyclerView parent) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        return linearLayoutManager != null && linearLayoutManager.getOrientation() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean policy$lambda$1(int i10, int i11) {
        return i10 < i11 - 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        p.i(outRect, "outRect");
        p.i(view, "view");
        p.i(parent, "parent");
        p.i(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (!isVerticalLinear(parent) || this.painter.getThickness() <= 0 || childAdapterPosition == -1 || !this.policy.shouldDrawAfter(childAdapterPosition, state.getItemCount())) {
            outRect.setEmpty();
        } else {
            outRect.set(0, 0, 0, this.painter.getThickness());
        }
    }

    public final Policy getPolicy() {
        return this.policy;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008d  */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r10, androidx.recyclerview.widget.RecyclerView r11, androidx.recyclerview.widget.RecyclerView.State r12) {
        /*
            r9 = this;
            java.lang.String r0 = "canvas"
            kotlin.jvm.internal.p.i(r10, r0)
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.p.i(r11, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.p.i(r12, r0)
            boolean r0 = r9.isVerticalLinear(r11)
            if (r0 == 0) goto L92
            com.stepos.widget.divider.StepOSDividerPainter r0 = r9.painter
            int r0 = r0.getThickness()
            if (r0 > 0) goto L1f
            goto L92
        L1f:
            int r4 = r11.getPaddingLeft()
            int r0 = r11.getWidth()
            int r1 = r11.getPaddingRight()
            int r5 = r0 - r1
            int r6 = r11.getLayoutDirection()
            int r0 = r11.getChildCount()
            r1 = 0
            r8 = r1
        L37:
            if (r8 >= r0) goto L92
            android.view.View r1 = r11.getChildAt(r8)
            int r2 = r11.getChildAdapterPosition(r1)
            r3 = -1
            if (r2 == r3) goto L8d
            com.stepos.widget.divider.StepOSItemDecoration$Policy r3 = r9.policy
            int r7 = r12.getItemCount()
            boolean r3 = r3.shouldDrawAfter(r2, r7)
            if (r3 == 0) goto L8d
            int r2 = r2 + 1
            androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r11.findViewHolderForAdapterPosition(r2)
            if (r2 == 0) goto L5b
            android.view.View r2 = r2.itemView
            goto L5c
        L5b:
            r2 = 0
        L5c:
            boolean r3 = r9.interactionHidesDivider(r1)
            if (r3 != 0) goto L8d
            boolean r2 = r9.interactionHidesDivider(r2)
            if (r2 == 0) goto L69
            goto L8d
        L69:
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            java.lang.String r3 = "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams"
            kotlin.jvm.internal.p.g(r2, r3)
            androidx.recyclerview.widget.RecyclerView$LayoutParams r2 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r2
            int r3 = r1.getBottom()
            int r2 = r2.bottomMargin
            int r3 = r3 + r2
            float r2 = (float) r3
            float r3 = r1.getTranslationY()
            float r3 = r3 + r2
            r2 = r1
            com.stepos.widget.divider.StepOSDividerPainter r1 = r9.painter
            float r7 = r2.getAlpha()
            r2 = r10
            r1.draw$StepOSWidget_release(r2, r3, r4, r5, r6, r7)
            goto L8e
        L8d:
            r2 = r10
        L8e:
            int r8 = r8 + 1
            r10 = r2
            goto L37
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.divider.StepOSItemDecoration.onDraw(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    public final void setDividerColor(int color) {
        this.painter.setColor$StepOSWidget_release(color);
    }

    public final void setDividerInsets(int start, int end) {
        if (start >= 0 && end >= 0) {
            this.painter.setInsetStart$StepOSWidget_release(start);
            this.painter.setInsetEnd$StepOSWidget_release(end);
            return;
        }
        throw new IllegalArgumentException(("divider insets must be >= 0 but were start=" + start + " end=" + end).toString());
    }

    public final void setDividerThickness(int px) {
        if (px >= 0) {
            this.painter.setThickness$StepOSWidget_release(px);
            return;
        }
        throw new IllegalArgumentException(("divider thickness must be >= 0 but was " + px).toString());
    }

    public final void setPolicy(Policy policy) {
        p.i(policy, "<set-?>");
        this.policy = policy;
    }
}
