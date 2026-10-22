package com.bytedance.android.shopping.jedi;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.jedi.PullUpLoadMoreHelper;
import com.bytedance.android.ec.core.jedi.RecyclerViewWithFooterAdapter;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.hybrid.tools.UIToolsKt;
import com.bytedance.android.shopping.extensions.b;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/jedi/LoadMoreRecyclerViewAdapter;", "Lcom/bytedance/android/ec/core/jedi/RecyclerViewWithFooterAdapter;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LoadMoreViewHolder", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LoadMoreRecyclerViewAdapter extends RecyclerViewWithFooterAdapter {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f176394t = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f176395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f176396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f176397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f176398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f176399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f176400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f176401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f176402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f176403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f176404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f176405l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f176406m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f176407n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final FrameLayout.LayoutParams f176408o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f176409p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LoadMoreViewHolder f176410q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function0<Unit> f176411r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f176412s;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0084\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/jedi/LoadMoreRecyclerViewAdapter$LoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class LoadMoreViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PullUpLoadMoreHelper f176413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f176414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f176415c;

        public LoadMoreViewHolder(LoadMoreRecyclerViewAdapter r100, LoadMoreStatusView r101, TextView r102) {
            Intrinsics.checkNotNullParameter(r102, "mErrorText");
            this.f176415c = r100;
            Intrinsics.checkNotNull(r101);
            super(r101);
            this.f176414b = r102;
            r102.setOnClickListener(new com.bytedance.android.shopping.jedi.a(this));
        }
    }

    public static final class a {
    }

    static {
    }

    public final void resetLoadMoreState() {
        LoadMoreViewHolder r100 = this.f176410q;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        View r101 = r100.itemView;
        if (r101 == null) goto L8;
        ((LoadMoreStatusView) r101).b();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    L9:
        this.f176395b = -1;
        this.f176400g = -1;
    }

    public final void showLoadMoreLoading() {
        LoadMoreViewHolder r100 = this.f176410q;
        if (r100 == null) goto L9;
        View r101 = r100.itemView;
        if (r101 == null) goto L8;
        ((LoadMoreStatusView) r101).a();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    L9:
        this.f176395b = 0;
        if (this.f176400g != (-1)) goto L13;
        this.f176400g = System.currentTimeMillis();
        return;
    }

    public final void y2() {
        LoadMoreViewHolder r100 = this.f176410q;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        View r101 = r100.itemView;
        if (r101 == null) goto L8;
        ((LoadMoreStatusView) r101).b();
        ((LoadMoreStatusView) r100.itemView).setVisibility(8);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    L9:
        this.f176395b = -1;
        this.f176400g = -1;
        notifyItemRangeRemoved(getItemCount() - 1, 1);
    }

    public final void z2() {
        LoadMoreViewHolder r100 = this.f176410q;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        View r101 = r100.itemView;
        if (r101 == null) goto L8;
        ((LoadMoreStatusView) r101).d();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    L9:
        this.f176395b = 1;
    }

    public LoadMoreRecyclerViewAdapter() {
        this.f176395b = -1;
        this.f176400g = -1;
        this.f176402i = b.b(16);
        this.f176405l = b.b(16);
        this.f176407n = "";
        this.f176408o = new FrameLayout.LayoutParams(b.b(210), b.b(20));
        this.f176412s = 17;
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
    public void onBindFooterViewHolder(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        LoadMoreViewHolder r101 = (LoadMoreViewHolder) r100;
        View r102 = r101.itemView;
        if (r102 == null) goto L18;
        LoadMoreStatusView r103 = (LoadMoreStatusView) r102;
        r103.setECStatus(r101.f176415c.f176395b);
        int r104 = r101.f176415c.f176401h;
        if (r104 > 0) goto L8;
        r104 = -2;
    L8:
        r103.setLayoutParams(new RecyclerView.LayoutParams(-1, r104));
        LoadMoreRecyclerViewAdapter r105 = r101.f176415c;
        r103.setPadding(r105.f176403j, r105.f176405l, r105.f176404k, r105.f176402i);
        if (r103.f46008g != (-1)) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L19;
        Function0<Unit> r107 = r101.f176415c.f176411r;
        if (r107 == null) goto L20;
        Unit r108 = r107.invoke();
        return;
    L20:
        return;
    L19:
        return;
    L11:
        r106 = false;
        goto L12
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    }

    @Override // com.bytedance.android.ec.core.jedi.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r101 = LoadMoreStatusView.f46001h;
        LoadMoreStatusView r102 = LoadMoreStatusView.a.a(r100.getContext(), this.f176407n, this.f176408o);
        int r103 = this.f176401h;
        if (r103 > 0) goto L6;
        r103 = -2;
    L6:
        r102.setLayoutParams(new RecyclerView.LayoutParams(-1, r103));
        r102.setPadding(this.f176403j, this.f176405l, this.f176404k, this.f176402i);
        TextView r104 = (TextView) th.a.d(r100.getContext(), R.layout.ec_view_default_empty_list, null, 4);
        this.f176399f = r104;
        if (this.f176396c == 0) goto L10;
        Intrinsics.checkNotNull(r104);
        r104.setTextColor(this.f176396c);
    L10:
        if (this.f176398e == null) goto L12;
        TextView r105 = this.f176399f;
        Intrinsics.checkNotNull(r105);
        r105.setText(this.f176398e);
    L12:
        TextView r106 = this.f176399f;
        Intrinsics.checkNotNull(r106);
        r106.setGravity(this.f176412s);
        Integer r107 = this.f176406m;
        if (r107 == null) goto L15;
        r107.intValue();
        TextView r108 = this.f176399f;
        Intrinsics.checkNotNull(r108);
        Integer r109 = this.f176406m;
        Intrinsics.checkNotNull(r109);
        r108.setPadding(0, r109.intValue(), 0, 0);
    L15:
        View r110 = th.a.d(r100.getContext(), R.layout.ec_view_default_retry_list, null, 4);
        if (r110 == null) goto L27;
        TextView r111 = (TextView) r110;
        r111.setText(R.string.load_status_click_retry);
        r111.setGravity(17);
        int r112 = this.f176397d;
        if (r112 == 0) goto L20;
        r111.setTextColor(r112);
    L20:
        View r113 = this.f176409p;
        if (r113 == null) goto L23;
        UIToolsKt.b(r113);
        r102.f(this.f176409p, this.f176399f, r111);
    L24:
        LoadMoreViewHolder r114 = new LoadMoreViewHolder(this, r102, r111);
        this.f176410q = r114;
        Intrinsics.checkNotNull(r114);
        return r114;
    L23:
        r102.c(r100.getContext(), this.f176399f, r111);
        goto L24
    L27:
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
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewDetachedFromWindow(r100);
        if (this.f176400g != (-1)) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(null) == true) goto L9;
        this.f176400g = -1;
        return;
    }
}
