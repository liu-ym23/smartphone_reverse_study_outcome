package com.bytedance.android.livesdk.interactivity.comment.input;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.dito.data.DitoNode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/LoadMoreScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadMoreScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f135041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f135042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayoutManager f135043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f135044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Integer, Unit> f135045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<Integer, Integer, Unit> f135046f;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        if (r101 != 0) goto L9;
        int r102 = this.f135043c.getItemCount();
        if (this.f135042b != 0) goto L9;
        if (this.f135041a != (r102 - 1)) goto L9;
        this.f135042b = 1;
        this.f135044d.invoke();
    L9:
        this.f135045e.invoke(Integer.valueOf(r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        this.f135041a = this.f135043c.findLastVisibleItemPosition();
        int r103 = this.f135043c.findFirstVisibleItemPosition();
        this.f135046f.invoke(Integer.valueOf(r103), Integer.valueOf(this.f135041a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoadMoreScrollListener(LinearLayoutManager r100, Function0<Unit> r101, Function1<? super Integer, Unit> r102, Function2<? super Integer, ? super Integer, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        Intrinsics.checkNotNullParameter(r101, DitoNode.LOAD_MORE);
        Intrinsics.checkNotNullParameter(r102, "scrollStateChanged");
        Intrinsics.checkNotNullParameter(r103, "visibleRangeChange");
        this.f135043c = r100;
        this.f135044d = r101;
        this.f135045e = r102;
        this.f135046f = r103;
    }
}
