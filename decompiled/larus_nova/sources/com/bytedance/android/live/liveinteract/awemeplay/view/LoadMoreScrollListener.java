package com.bytedance.android.live.liveinteract.awemeplay.view;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.dito.data.DitoNode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/view/LoadMoreScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LoadMoreScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f71600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f71601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GridLayoutManager f71602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f71603d;

    public static final class a {
    }

    static {
    }

    public LoadMoreScrollListener(GridLayoutManager r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        Intrinsics.checkNotNullParameter(r101, DitoNode.LOAD_MORE);
        this.f71602c = r100;
        this.f71603d = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        if (r101 != 0) goto L10;
        int r102 = this.f71602c.getItemCount();
        if (this.f71601b == 0) goto L7;
        return;
    L7:
        if (this.f71600a != (r102 - 1)) goto L12;
        this.f71601b = 1;
        this.f71603d.invoke();
        return;
    L12:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        this.f71600a = this.f71602c.findLastVisibleItemPosition();
    }
}
