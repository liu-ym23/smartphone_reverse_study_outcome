package com.bytedance.android.livesdk.interactivity.square.common;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f141146a;

    public h(f r100) {
        this.f141146a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IModelListDataManager.a r101 = (IModelListDataManager.a) r100;
        if (r101 == null) goto L31;
        int r102 = g.f141145a[r101.getType().ordinal()];
        if (r102 != 1) goto L8;
        this.f141146a.f141144e.notifyDataSetChanged();
        this.f141146a.f141140a.c();
    L29:
        this.f141146a.f141140a.onEvent(r101);
        return;
    L8:
        if (r102 != 2) goto L10;
        this.f141146a.f141144e.notifyItemInserted(r101.f133738b);
        BaseModelListScrollManager r103 = this.f141146a.f141140a;
        if (r103.f141113a != BaseModelListScrollManager.ScrollState.AutoScroll) goto L29;
        RecyclerView.Adapter r104 = r103.f141122j.getAdapter();
        if (r104 == null) goto L29;
        int r105 = r104.getItemCount() - 1;
        if (r103.f141121i == false) goto L26;
        r103.f141122j.smoothScrollToPosition(r105);
    L27:
        r103.b(r105);
        goto L29
    L26:
        r103.f141122j.scrollToPosition(r105);
        goto L27
    L10:
        if (r102 != 3) goto L12;
        this.f141146a.f141144e.notifyItemInserted(r101.f133738b);
        goto L29
    L12:
        if (r102 != 4) goto L14;
        this.f141146a.f141144e.notifyDataSetChanged();
        goto L29
    L14:
        if (r102 != 5) goto L29;
        this.f141146a.f141144e.notifyItemRangeRemoved(r101.f133739c, r101.f133740d);
        goto L29
    }
}
