package com.bytedanceos.appstore.buss.fragment;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedanceos.appstore.buss.activity.AppImageDetailActivity;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.adapter.app.pager.adapter.PagerTypeAdapter;
import com.bytedanceos.appstore.buss.adapter.onetype.AppDetailImageAdapter;
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.appstore.buss.entity.netwrap.SubDetailGiftEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.SubDetailWrap;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.appstore.buss.viewmodels.SubDetailViewModel;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.obric.appstore.R;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\u0004J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u001d\u0010\u0012\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u001c\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/SubDetailFragment;", "Lh7/c;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "E", "initData", "F", "t", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "S", "", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "wrap", "T", "(Ljava/util/List;)V", "Lkotlinx/coroutines/Job;", "f", "Lkotlinx/coroutines/Job;", "subJob", "", "g", "Lkotlin/Lazy;", "Q", "()Ljava/lang/String;", "subId", "Lcom/bytedanceos/appstore/buss/viewmodels/SubDetailViewModel;", "h", "P", "()Lcom/bytedanceos/appstore/buss/viewmodels/SubDetailViewModel;", "subDetailViewModel", "Lcom/bytedanceos/appstore/buss/adapter/onetype/AppDetailImageAdapter;", "i", "Lcom/bytedanceos/appstore/buss/adapter/onetype/AppDetailImageAdapter;", "imageAdapter", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "j", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "giftAdapter", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PagerTypeAdapter;", "k", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PagerTypeAdapter;", "recommendAdapter", "Lcom/bytedanceos/appstore/buss/entity/netwrap/SubDetailWrap;", "l", "Lcom/bytedanceos/appstore/buss/entity/netwrap/SubDetailWrap;", "subDetailWrap", "", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/y;", "O", "()Lx7/y;", "fragmentTvSubDetailBinding", "m", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSubDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubDetailFragment.kt\ncom/bytedanceos/appstore/buss/fragment/SubDetailFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,211:1\n106#2,15:212\n57#3,3:227\n1#4:230\n50#5,9:231\n50#5,9:240\n*S KotlinDebug\n*F\n+ 1 SubDetailFragment.kt\ncom/bytedanceos/appstore/buss/fragment/SubDetailFragment\n*L\n65#1:212,15\n71#1:227,3\n83#1:231,9\n99#1:240,9\n*E\n"})
public final class SubDetailFragment extends h7.c implements View.OnClickListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f8651m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Job f8652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AppDetailImageAdapter f8655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BinderAdapter f8656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PagerTypeAdapter f8657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SubDetailWrap f8658l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(String r10) {
            kotlin.jvm.internal.q.g(r10, "subId");
            SubDetailFragment r11 = new SubDetailFragment();
            r11.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("subId", r10)}));
            return r11;
        }

        public a() {
        }
    }

    static {
        f8651m = new a(null);
    }

    public SubDetailFragment() {
        this.f8653g = kotlin.b.b(new SubDetailFragment$subId$2(this));
        Function0<ViewModelProvider.Factory> r10 = new SubDetailFragment$subDetailViewModel$2(this);
        final Function0<Fragment> r11 = new SubDetailFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new SubDetailFragment$special$$inlined$viewModels$default$2(r11));
        final Function0 r13 = null;
        this.f8654h = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(SubDetailViewModel.class), new SubDetailFragment$special$$inlined$viewModels$default$3(r12), new SubDetailFragment$special$$inlined$viewModels$default$4(r13, r12), r10);
        this.f8655i = new AppDetailImageAdapter(null);
        BinderAdapter r14 = new BinderAdapter();
        r14.addItemBinder(SubDetailGiftEntity.class, new d7.i(), null);
        this.f8656j = r14;
        this.f8657k = new PagerTypeAdapter(null, null, 3, null);
    }

    public static /* synthetic */ void G(SubDetailFragment r10, BaseQuickAdapter r11, View r12, int r13) {
        R(r10, r11, r12, r13);
    }

    public static /* synthetic */ void H(SubDetailFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        U(r10, r11);
    }

    public static /* synthetic */ void I(SubDetailFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        V(r10, r11);
    }

    public static final /* synthetic */ x7.y J(SubDetailFragment r10) {
        return r10.O();
    }

    public static final /* synthetic */ SubDetailViewModel K(SubDetailFragment r10) {
        return r10.P();
    }

    public static final /* synthetic */ String L(SubDetailFragment r10) {
        return r10.Q();
    }

    public static final /* synthetic */ Job M(SubDetailFragment r10) {
        return r10.f8652f;
    }

    public static final /* synthetic */ void N(SubDetailFragment r10, Job r11) {
        r10.f8652f = r11;
    }

    public static final void R(SubDetailFragment r10, BaseQuickAdapter r11, View r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "<anonymous parameter 0>");
        kotlin.jvm.internal.q.g(r12, "<anonymous parameter 1>");
        AppImageDetailActivity.a r14 = AppImageDetailActivity.f8305e;
        BaseActivity r15 = r10.l();
        List<String> r16 = r10.f8655i.getData();
        kotlin.jvm.internal.q.e(r16, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
        r14.a(r15, null, r13, (ArrayList) r16);
    }

    public static final void U(SubDetailFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        r10.B();
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L12;
        SubDetailWrap r12 = (SubDetailWrap) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 != null) goto L10;
        h7.c.A(r10, null, null, 0, 7, null);
        return;
    L10:
        r10.r();
        r10.f8658l = r12;
        r10.S();
        r10.P().k();
        return;
    L12:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L18;
        com.bytedanceos.appstore.buss.network.h.a r13 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r13.c());
        r10.D(r13);
        return;
    }

    public static final void V(SubDetailFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L12;
        List r12 = (List) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 != null) goto L10;
        r12 = kotlin.collections.t.i();
    L10:
        r10.T(r12);
        return;
    L12:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L16;
        com.bytedanceos.appstore.buss.network.h.a r13 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r13.c());
        com.bytedanceos.appstore.buss.utilities.s.e(r10, r13.c());
        return;
    }

    @Override // h7.c
    public void E() {
        P().j().i(this, new h1(this));
        P().l().i(this, new i1(this));
    }

    @Override // h7.c
    public void F() {
    }

    public final x7.y O() {
        x7.y r10 = x7.y.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final SubDetailViewModel P() {
        return (SubDetailViewModel) this.f8654h.getValue();
    }

    public final String Q() {
        return (String) this.f8653g.getValue();
    }

    public final void S() {
        SubDetailWrap r10 = this.f8658l;
        if (r10 == null) goto L6;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.a(r10);
        ImageView r11 = O().f25798c;
        kotlin.jvm.internal.q.f(r11, "ivIcon");
        ImageUtilKt.g(r11, r10.getLogo(), R.dimen.dp_18, 0, 4, null);
        O().f25804i.setText(r10.getName());
        O().f25805j.setText(com.bytedanceos.common.toolbox.e.T(r10.getOnlineTime()));
        O().f25802g.setText(r10.getCategory());
        O().f25797b.setSubcirbe(r10.isSubscribed());
        O().f25797b.setOnClickListener(this);
        O().f25803h.setText(r10.getBrief());
        this.f8655i.setList(r10.getScreen());
        this.f8656j.setList(r10.getGifts());
        return;
    }

    public final void T(List r10) {
        this.f8657k.setList(r10);
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, "预约详情", true, false, 4, null);
        CommonRecyclerView r10 = O().f25801f;
        LinearLayoutManager r11 = new LinearLayoutManager(l());
        r11.setOrientation(0);
        r10.setLayoutManager(r11);
        O().f25801f.setAdapter(this.f8655i);
        this.f8655i.setOnItemClickListener(new j1(this));
        CommonRecyclerView r12 = O().f25799d;
        LinearLayoutManager r13 = new LinearLayoutManager(l());
        r13.setOrientation(0);
        r12.setLayoutManager(r13);
        O().f25799d.setAdapter(this.f8656j);
        O().f25799d.addItemDecoration(new com.bytedanceos.appstore.buss.widget.e(0, 0, 0, 0, 15, null));
        O().f25800e.setLayoutManager(new LinearLayoutManager(l()));
        O().f25800e.setAdapter(this.f8657k);
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_sub_detail;
    }

    @Override // h7.c
    public Function0 o() {
        return new SubDetailFragment$onRetryListener$1(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (r10 == null) goto L5;
        Integer r11 = Integer.valueOf(r10.getId());
    L6:
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.intValue() != R.id.btn_sub) goto L20;
        final SubDetailWrap r12 = this.f8658l;
        if (r12 != null) goto L13;
        return;
    L13:
        if (r12.getStatus() != 0) goto L18;
        r12.setStatus(1);
        O().f25797b.setSubcirbe(r12.isSubscribed());
        Job r13 = this.f8652f;
        if (r13 == null) goto L17;
        Job.a.b(r13, null, 1, null);
    L17:
        this.f8652f = kotlinx.coroutines.h.d(kotlinx.coroutines.y0.f21772a, null, null, new SubDetailFragment$onClick$1$1(r12, this, null), 3, null);
        return;
    L18:
        com.bytedanceos.appstore.buss.widget.dialog.v r14 = com.bytedanceos.appstore.buss.widget.dialog.v.f9279a;
        Context r15 = getContext();
        kotlin.jvm.internal.q.e(r15, "null cannot be cast to non-null type android.app.Activity");
        r14.e((Activity) r15, new SubDetailFragment$onClick$1$2(r12, this));
        return;
    L20:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // h7.c
    public void t() {
    }
}
