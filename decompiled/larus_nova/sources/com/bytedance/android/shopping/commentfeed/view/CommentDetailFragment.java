package com.bytedance.android.shopping.commentfeed.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.legacy.AbsFragment;
import com.bytedance.android.ec.core.widget.DoubleColorBallStatusView;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ec.core.widget.d;
import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import com.bytedance.android.shopping.commentfeed.adapter.CommentDetailPagerAdapter;
import com.bytedance.android.shopping.commentfeed.model.CommentDetailParams;
import com.bytedance.android.shopping.commentfeed.utils.CommentListViewModel;
import com.bytedance.android.shopping.commentfeed.widget.CommonPageLoadingView;
import com.bytedance.android.shopping.commentfeed.widget.OverScrolledViewPager;
import com.bytedance.android.shopping.extensions.m;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/view/CommentDetailFragment;", "Lcom/bytedance/android/ec/core/legacy/AbsFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentDetailFragment extends AbsFragment {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f172338t = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.commerce.base.viewmodel.a f172339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OverScrolledViewPager f172340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f172341h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f172342i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CommentDetailParams f172343j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CommentDetailPagerAdapter f172344k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f172345l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f172346m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f172347n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CommonPageLoadingView f172348o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ECStatusView f172349p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f172350q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f172351r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f172352s;

    public static final class a {
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ CommentDetailFragment f172353g;

        public b(CommentDetailFragment r100) {
            this.f172353g = r100;
            super(null, null, 3);
        }

        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r110) {
            Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
            CommentDetailFragment r111 = this.f172353g;
            int r100 = CommentDetailFragment.f172338t;
            CommentListViewModel r112 = r111.S90();
            if (r112 == null) goto L8;
            CommentDetailFragment r101 = this.f172353g;
            CommentDetailParams r102 = r101.f172343j;
            if (r102 == null) goto L9;
            r101.T90(true);
            r112.loadCommentList(new zb3.d(r102.getProductId(), r102.getCommentCursor(), 12, "detail", true));
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final CommentListViewModel S90() {
        return (CommentListViewModel) this.f172339f.getValue();
    }

    public CommentDetailFragment() {
        CommentDetailFragment$viewModel$2 r100 = CommentDetailFragment$viewModel$2.INSTANCE;
        this.f172339f = new com.bytedance.commerce.base.viewmodel.a(Reflection.getOrCreateKotlinClass(CommentListViewModel.class), new CommentDetailFragment$$special$$inlined$activityViewModels$1(this), r100);
        this.f172345l = true;
        this.f172352s = new b(this);
    }

    public final void T90(boolean r100) {
        if (r100 == false) goto L8;
        CommonPageLoadingView r101 = this.f172348o;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L7:
        r101.setVisibility(0);
        r101.f172421a.a();
        DoubleColorBallStatusView r102 = r101.f172421a;
        r102.setVisibility(0);
        r102.setECStatus(0);
        return;
    L8:
        CommonPageLoadingView r103 = this.f172348o;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L11:
        r103.setVisibility(8);
        r103.f172421a.a();
    }

    public final void U90(boolean r100) {
        if (r100 == false) goto L25;
        ViewGroup r101 = this.f172342i;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L7:
        ViewGroup r102 = this.f172342i;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L10:
        r101.setBackgroundColor(th.a.f(r102.getContext()).getColor(R.color.commerce_color_FFFFFF));
        ImageView r103 = this.f172341h;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("ivBack");
    L13:
        r103.setImageResource(R.drawable.ec_commerce_icon_back_black);
        View r104 = this.f172346m;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("netWorkErrorView");
    L16:
        r104.setVisibility(0);
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L21;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L21;
        m.a(r106, true);
    L21:
        OverScrolledViewPager r107 = this.f172340g;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L24:
        r107.setVisibility(4);
        return;
    L25:
        ViewGroup r108 = this.f172342i;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L28:
        ViewGroup r109 = this.f172342i;
        if (r109 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L31:
        r108.setBackgroundColor(th.a.f(r109.getContext()).getColor(R.color.shopping_color_000000));
        ImageView r110 = this.f172341h;
        if (r110 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("ivBack");
    L34:
        r110.setImageResource(R.drawable.ec_commerce_icon_back_white);
        View r111 = this.f172346m;
        if (r111 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("netWorkErrorView");
    L37:
        r111.setVisibility(8);
        OverScrolledViewPager r112 = this.f172340g;
        if (r112 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L40:
        r112.setVisibility(0);
        FragmentActivity r113 = getActivity();
        if (r113 == null) goto L47;
        Window r114 = r113.getWindow();
        if (r114 == null) goto L48;
        m.a(r114, false);
        return;
    L48:
        return;
    }

    @Override // com.bytedance.android.ec.core.legacy.AbsFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        Serializable r102 = null;
        if (r101 == null) goto L5;
        Serializable r103 = r101.getSerializable(com.bytedance.android.ec.core.event.a.KEY_COMMENT_DETAIL);
    L7:
        if ((r103 instanceof CommentDetailParams) == false) goto L10;
        r102 = r103;
    L10:
        CommentDetailParams r104 = (CommentDetailParams) r102;
        if (r104 == null) goto L14;
        this.f172343j = r104;
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.ec.core.legacy.AbsFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f172340g = (OverScrolledViewPager) r110.findViewById(R.id.ec_comment_detail_list_viewpager);
        this.f172341h = (ImageView) r110.findViewById(R.id.ec_comment_detail_iv_back);
        View r112 = r110.findViewById(R.id.ec_comment_network_error_view);
        this.f172346m = r112;
        if (r112 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("netWorkErrorView");
    L5:
        this.f172347n = r112.findViewById(R.id.ec_commerce_btn_network_retry);
        this.f172342i = (ViewGroup) r110.findViewById(R.id.ec_comment_detail_fragment_rootview);
        this.f172349p = (ECStatusView) r110.findViewById(R.id.ec_comment_detail_load_status);
        this.f172348o = (CommonPageLoadingView) r110.findViewById(R.id.ec_comment_loading_view);
        ECStatusView r113 = this.f172349p;
        if (r113 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadStatusView");
    L8:
        Context r100 = r110.getContext();
        Context r114 = r110.getContext();
        ViewGroup r101 = this.f172342i;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        boolean r102 = false;
        View r115 = th.a.c(r114, R.layout.ec_commerce_comment_no_more_data_layout, r101, false);
        List<PromotionProductCommentDTO> r103 = null;
        r113.b(r100, r115, null);
        View r116 = this.f172347n;
        if (r116 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("networkRetryView");
    L14:
        r116.setOnClickListener(this.f172352s);
        this.f172344k = new CommentDetailPagerAdapter(getChildFragmentManager());
        OverScrolledViewPager r117 = this.f172340g;
        if (r117 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L17:
        r117.setAdapter(this.f172344k);
        OverScrolledViewPager r118 = this.f172340g;
        if (r118 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L20:
        r118.setOffscreenPageLimit(2);
        OverScrolledViewPager r119 = this.f172340g;
        if (r119 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L23:
        ((ArrayList) r119.S).add(new CommentDetailFragment$initViews$1(this));
        OverScrolledViewPager r120 = this.f172340g;
        if (r120 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L26:
        r120.setOnRefreshListener(new com.bytedance.android.shopping.commentfeed.view.a(this));
        ImageView r121 = this.f172341h;
        if (r121 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("ivBack");
    L29:
        r121.setOnClickListener(new com.bytedance.android.shopping.commentfeed.view.b(this));
        CommentListViewModel r122 = S90();
        if (r122 == null) goto L61;
        CommentDetailParams r123 = this.f172343j;
        if (r123 == null) goto L59;
        String r124 = r123.getProductId();
        if (r124 == null) goto L59;
        if (r124.length() <= 0) goto L38;
        r102 = true;
    L38:
        if (r102 == false) goto L40;
        String r104 = r124;
    L41:
        if (r104 == null) goto L59;
        HashMap<String, List<PromotionProductCommentDTO>> r125 = ac3.c.f2669a;
        Intrinsics.checkNotNullParameter(r104, "productId");
        List<PromotionProductCommentDTO> r126 = ac3.c.f2669a.get(r104);
        if (r126 != null) goto L45;
    L49:
        T90(true);
        long r105 = r122.getCommentCursor();
        CommentDetailParams r127 = this.f172343j;
        if (r127 == null) goto L52;
        long r106 = r127.getCommentCursor();
    L53:
        long r107 = 12;
        if (r105 == 0) goto L56;
    L58:
        r122.loadCommentList(new zb3.d(r104, r105, r107, "detail", true));
        goto L59
    L56:
        if (12 >= (1 + r106)) goto L58;
        r107 = r106 + ((long) 3);
        goto L58
    L52:
        r106 = 0;
        goto L53
    L45:
        if ((!r126.isEmpty()) == false) goto L47;
        r103 = r126;
    L47:
        if (r103 == null) goto L49;
        r122.setCommentModel(r103);
        this.f172351r = true;
        goto L59
    L40:
        r104 = null;
    L59:
        r122.getCommentList().observe(this, new CommentDetailFragment$initViewModel$$inlined$apply$lambda$1(this));
        r122.isRequestSucceed().observe(this, new CommentDetailFragment$initViewModel$$inlined$apply$lambda$2(this));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ec_comment_detail_list_fragment_layout, r101, false);
    }
}
