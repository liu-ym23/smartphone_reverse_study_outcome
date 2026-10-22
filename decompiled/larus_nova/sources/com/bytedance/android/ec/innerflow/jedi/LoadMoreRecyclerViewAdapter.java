package com.bytedance.android.ec.innerflow.jedi;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.jedi.RecyclerViewWithFooterAdapter;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.shopping.extensions.b;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/innerflow/jedi/LoadMoreRecyclerViewAdapter;", "Lcom/bytedance/android/ec/core/jedi/RecyclerViewWithFooterAdapter;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LoadMoreViewHolder", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LoadMoreRecyclerViewAdapter extends RecyclerViewWithFooterAdapter {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f47820r = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f47821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f47822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f47823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f47824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f47825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f47826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f47827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f47828i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f47829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f47830k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f47831l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f47832m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final FrameLayout.LayoutParams f47833n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LoadMoreViewHolder f47834o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function0<Unit> f47835p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f47836q;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0084\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/innerflow/jedi/LoadMoreRecyclerViewAdapter$LoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class LoadMoreViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f47837a;

        public LoadMoreViewHolder(LoadMoreRecyclerViewAdapter r100, LoadMoreStatusView r101, TextView r102) {
            Intrinsics.checkNotNullParameter(r102, "mErrorText");
            this.f47837a = r100;
            Intrinsics.checkNotNull(r101);
            super(r101);
            r102.setOnClickListener(new com.bytedance.android.ec.innerflow.jedi.a(this));
        }
    }

    public static final class a {
    }

    static {
    }

    public final void resetLoadMoreState() {
        LoadMoreViewHolder r100 = this.f47834o;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        View r101 = r100.itemView;
        if (r101 == null) goto L8;
        ((LoadMoreStatusView) r101).b();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    L9:
        this.f47821b = -1;
        this.f47826g = -1;
    }

    public final void showLoadMoreLoading() {
        LoadMoreViewHolder r100 = this.f47834o;
        if (r100 == null) goto L9;
        View r101 = r100.itemView;
        if (r101 == null) goto L8;
        ((LoadMoreStatusView) r101).a();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    L9:
        this.f47821b = 0;
        if (this.f47826g != (-1)) goto L13;
        this.f47826g = System.currentTimeMillis();
        return;
    }

    public void y2() {
        LoadMoreViewHolder r100 = this.f47834o;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        View r101 = r100.itemView;
        if (r101 == null) goto L8;
        ((LoadMoreStatusView) r101).d();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    L9:
        this.f47821b = 1;
    }

    public LoadMoreRecyclerViewAdapter() {
        this.f47821b = -1;
        this.f47826g = -1;
        this.f47827h = b.b(16);
        this.f47830k = b.b(16);
        this.f47832m = "";
        this.f47833n = new FrameLayout.LayoutParams(b.b(210), b.b(20));
        this.f47836q = 17;
    }

    @Override // com.bytedance.android.ec.core.jedi.RecyclerViewWithFooterAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (getBasicItemCount() != 0) goto L6;
        return 0;
    L6:
        return super.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        final RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == false) goto L6;
        ((GridLayoutManager) r101).setSpanSizeLookup(new AnonymousClass1(this, r101));
        return;
    }

    @Override // com.bytedance.android.ec.core.jedi.RecyclerViewWithFooterAdapter
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        LoadMoreViewHolder r101 = (LoadMoreViewHolder) r100;
        View r102 = r101.itemView;
        if (r102 == null) goto L14;
        LoadMoreStatusView r103 = (LoadMoreStatusView) r102;
        r103.setECStatus(r101.f47837a.f47821b);
        r101.f47837a.getClass();
        r103.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        LoadMoreRecyclerViewAdapter r104 = r101.f47837a;
        r103.setPadding(r104.f47828i, r104.f47830k, r104.f47829j, r104.f47827h);
        if (r103.f46008g != (-1)) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L15;
        Function0<Unit> r106 = r101.f47837a.f47835p;
        if (r106 == null) goto L16;
        Unit r107 = r106.invoke();
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r105 = false;
        goto L8
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    }

    @Override // com.bytedance.android.ec.core.jedi.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r101 = LoadMoreStatusView.f46001h;
        LoadMoreStatusView r102 = LoadMoreStatusView.a.a(r100.getContext(), this.f47832m, this.f47833n);
        r102.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        r102.setPadding(this.f47828i, this.f47830k, this.f47829j, this.f47827h);
        TextView r103 = (TextView) th.a.d(r100.getContext(), R.layout.ec_view_default_empty_list, null, 4);
        this.f47825f = r103;
        if (this.f47822c == 0) goto L6;
        Intrinsics.checkNotNull(r103);
        r103.setTextColor(this.f47822c);
    L6:
        if (this.f47824e == null) goto L9;
        TextView r104 = this.f47825f;
        Intrinsics.checkNotNull(r104);
        r104.setText(this.f47824e);
    L9:
        if (this.f47831l == null) goto L11;
        TextView r105 = this.f47825f;
        Intrinsics.checkNotNull(r105);
        Integer r106 = this.f47831l;
        Intrinsics.checkNotNull(r106);
        r105.setTextSize(r106.intValue());
    L11:
        TextView r107 = this.f47825f;
        Intrinsics.checkNotNull(r107);
        r107.setGravity(this.f47836q);
        View r108 = th.a.d(r100.getContext(), R.layout.ec_view_default_retry_list, null, 4);
        if (r108 == null) goto L19;
        TextView r109 = (TextView) r108;
        r109.setText(R.string.load_status_click_retry);
        r109.setGravity(17);
        int r110 = this.f47823d;
        if (r110 == 0) goto L16;
        r109.setTextColor(r110);
    L16:
        r102.c(r100.getContext(), this.f47825f, r109);
        LoadMoreViewHolder r111 = new LoadMoreViewHolder(this, r102, r109);
        this.f47834o = r111;
        Intrinsics.checkNotNull(r111);
        return r111;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewAttachedToWindow(r100);
        if ((r100 instanceof com.bytedance.android.ecom.arch.slice.slices.a) == true) goto L14;
        ViewGroup.LayoutParams r101 = r100.itemView.getLayoutParams();
        if (r101 != null) goto L7;
        return;
    L7:
        if ((r101 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L16;
        StaggeredGridLayoutManager.LayoutParams r102 = (StaggeredGridLayoutManager.LayoutParams) r101;
        if (getItemViewType(r100.getLayoutPosition()) != Integer.MIN_VALUE) goto L11;
        boolean r103 = true;
    L12:
        r102.setFullSpan(r103);
        return;
    L11:
        r103 = false;
        goto L12
    L16:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewDetachedFromWindow(r100);
        if (this.f47826g != (-1)) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(null) == true) goto L9;
        this.f47826g = -1;
        return;
    }
}
