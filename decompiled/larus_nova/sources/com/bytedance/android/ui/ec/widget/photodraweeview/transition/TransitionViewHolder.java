package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b'\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "transitionLayout", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionLayout;", "getTransitionLayout", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionLayout;", "getView", "()Landroid/view/View;", "onTransitionBegin", "", "state", "", "onTransitionChanged", "factor", "", "onTransitionEnd", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class TransitionViewHolder extends RecyclerView.ViewHolder implements TransitionListener {
    private final View view;

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public void onTransitionBegin(int r100) {
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public void onTransitionChanged(int r100, float r101) {
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public void onTransitionEnd(int r100) {
    }

    public final TransitionLayout getTransitionLayout() {
        View r100 = this.itemView;
        if (r100 == null) goto L7;
        return (TransitionLayout) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionLayout");
    }

    public final View getView() {
        return this.view;
    }

    public TransitionViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        TransitionLayout r101 = new TransitionLayout(r100.getContext(), null, 0, 6, null);
        r101.addView(r100, -1, -1);
        TransitionPhotoDraweeView r102 = TransitionViewHolderKt.access$findTransitionPhotoView(r100);
        if (r102 == null) goto L5;
        r102.setHorizontalNestedScrollEnabled(true);
        r101.setDelegateDragTransitionView(r102);
    L5:
        r101.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        Unit r103 = Unit.INSTANCE;
        super(r101);
        this.view = r100;
        getTransitionLayout().addTransitionListener(this);
    }
}
