package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/RecyclerViewStackHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewStackHelper extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f140199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f140200b;

    public final void j() {
        RecyclerView r100 = this.f140199a;
        if (r100 != null) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        View r102 = null;
        if ((r101 instanceof LinearLayoutManager) == true) goto L8;
        r101 = null;
    L8:
        LinearLayoutManager r103 = (LinearLayoutManager) r101;
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.getStackFromEnd() == true) goto L14;
        return;
    L14:
        boolean r104 = !this.f140200b;
        if (r104 == false) goto L30;
        int r105 = r103.findFirstCompletelyVisibleItemPosition();
        int r106 = r103.findLastCompletelyVisibleItemPosition();
        if (r105 == (-1)) goto L28;
        if (r106 == (-1)) goto L28;
        if (r105 > r106) goto L28;
    L21:
        View r107 = r103.findViewByPosition(r105);
        if (r107 != null) goto L24;
    L26:
        if (r105 == r106) goto L28;
        r105 = r105 + 1;
        goto L21
    L24:
        if (r107.isFocusableInTouchMode() == false) goto L26;
        r102 = r107;
    L28:
        if (r102 == null) goto L30;
        r102.requestFocus();
    L30:
        if (r104 == false) goto L32;
        return;
    L32:
        if (r100.getFocusedChild() == null) goto L38;
        r100.clearFocus();
        return;
    }

    public RecyclerViewStackHelper() {
        this.f140200b = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        j();
    }
}
