package com.obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmptySupportRecyclerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/obric/widget/EmptySupportRecyclerView;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "emptyObserver", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$AdapterDataObserver;", "emptyView", "Landroid/view/View;", "getEmptyView", "()Landroid/view/View;", "setEmptyView", "(Landroid/view/View;)V", "setAdapter", "", "adapter", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "updateEmptyView", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EmptySupportRecyclerView extends RecyclerView {
    private final RecyclerView.AdapterDataObserver emptyObserver;
    private View emptyView;

    /* JADX WARN: Multi-variable type inference failed */
    public EmptySupportRecyclerView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ EmptySupportRecyclerView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ void access$updateEmptyView(EmptySupportRecyclerView r0) {
        r0.updateEmptyView();
    }

    public EmptySupportRecyclerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.emptyObserver = new EmptySupportRecyclerView$emptyObserver$1(this);
    }

    public final View getEmptyView() {
        return this.emptyView;
    }

    public final void setEmptyView(View r1) {
        this.emptyView = r1;
    }

    private final void updateEmptyView() {
        View r0 = this.emptyView;
        if (r0 == null) goto L13;
        RecyclerView.Adapter r1 = getAdapter();
        if (r1 != null) goto L7;
        return;
    L7:
        if (this.emptyView != null) goto L9;
        return;
    L9:
        if (r1.getItemCount() != 0) goto L11;
        r0.setVisibility(0);
        setVisibility(8);
        return;
    L11:
        r0.setVisibility(8);
        setVisibility(0);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter<?> r3) {
        RecyclerView.Adapter r0 = getAdapter();
        if (r0 == null) goto L5;
        r0.unregisterAdapterDataObserver(this.emptyObserver);
    L5:
        super.setAdapter(r3);
        RecyclerView.Adapter r4 = getAdapter();
        if (r4 == null) goto L8;
        r4.registerAdapterDataObserver(this.emptyObserver);
    L8:
        this.emptyObserver.onChanged();
    }
}
