package com.bytedanceos.appstore.buss.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.onetype.CommentAdapter;
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.appstore.buss.entity.AppCommentEntity;
import com.bytedanceos.appstore.buss.entity.AppInfoEntity;
import com.bytedanceos.appstore.buss.entity.TvGradeWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.AppCommentsWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.TvAppCheckCommentEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.TvAppCheckCommentWrap;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.appstore.buss.viewmodels.AppCommentsViewModel;
import com.bytedanceos.appstore.buss.widget.app.item.ItemHorizontalView;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\u0004J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010.8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00105\u001a\u0002028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/AppCommentsFragment;", "Lh7/c;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "E", "initData", "F", "t", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "onDestroyView", "N", "V", "Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;", "f", "Lkotlin/Lazy;", "S", "()Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;", "entity", "Lcom/bytedanceos/appstore/buss/viewmodels/AppCommentsViewModel;", "g", "R", "()Lcom/bytedanceos/appstore/buss/viewmodels/AppCommentsViewModel;", "appCommentsViewModel", "Lcom/bytedanceos/appstore/buss/adapter/onetype/CommentAdapter;", "h", "Lcom/bytedanceos/appstore/buss/adapter/onetype/CommentAdapter;", "adapter", "", "Lcom/bytedanceos/appstore/buss/entity/AppCommentEntity;", "i", "Ljava/util/List;", "dataList", "Lcom/bytedanceos/appstore/buss/widget/dialog/a;", "j", "Q", "()Lcom/bytedanceos/appstore/buss/widget/dialog/a;", "addCommentDialog", "", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/n;", "T", "()Lx7/n;", "fragmentTvAppCommentsBinding", "k", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppCommentsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppCommentsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppCommentsFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,270:1\n106#2,15:271\n50#3,9:286\n50#3,9:295\n50#3,9:304\n*S KotlinDebug\n*F\n+ 1 AppCommentsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppCommentsFragment\n*L\n59#1:271,15\n76#1:286,9\n215#1:295,9\n240#1:304,9\n*E\n"})
public final class AppCommentsFragment extends h7.c implements View.OnClickListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f8466k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CommentAdapter f8469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f8470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f8471j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(AppInfoEntity r10) {
            kotlin.jvm.internal.q.g(r10, "entity");
            AppCommentsFragment r11 = new AppCommentsFragment();
            r11.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("entity", r10)}));
            return r11;
        }

        public a() {
        }
    }

    static {
        f8466k = new a(null);
    }

    public AppCommentsFragment() {
        this.f8467f = kotlin.b.b(new AppCommentsFragment$entity$2(this));
        Function0<ViewModelProvider.Factory> r10 = new AppCommentsFragment$appCommentsViewModel$2(this);
        final Function0<Fragment> r11 = new AppCommentsFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new AppCommentsFragment$special$$inlined$viewModels$default$2(r11));
        final Function0 r13 = null;
        this.f8468g = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(AppCommentsViewModel.class), new AppCommentsFragment$special$$inlined$viewModels$default$3(r12), new AppCommentsFragment$special$$inlined$viewModels$default$4(r13, r12), r10);
        this.f8470i = new ArrayList();
        this.f8471j = kotlin.b.b(new AppCommentsFragment$addCommentDialog$2(this));
    }

    public static /* synthetic */ void G(AppCommentsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        W(r10, r11);
    }

    public static /* synthetic */ void H(AppCommentsFragment r10) {
        U(r10);
    }

    public static /* synthetic */ void I(AppCommentsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        P(r10, r11);
    }

    public static /* synthetic */ void J(AppCommentsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        O(r10, r11);
    }

    public static final /* synthetic */ AppCommentsViewModel K(AppCommentsFragment r10) {
        return r10.R();
    }

    public static final /* synthetic */ BaseActivity L(AppCommentsFragment r10) {
        return r10.l();
    }

    public static final /* synthetic */ AppInfoEntity M(AppCommentsFragment r10) {
        return r10.S();
    }

    public static final void O(AppCommentsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L9;
        String r12 = r10.getString(R.string.add_comment_success);
        kotlin.jvm.internal.q.f(r12, "getString(...)");
        com.bytedanceos.appstore.buss.utilities.s.e(r10, r12);
        r10.R().q(1);
        r10.R().j();
        Bundle r13 = new Bundle();
        r13.putString("pkg_name", r10.S().getPkg());
        f9.b.b("click_submit_comment_success", r13);
        return;
    L9:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L13;
        com.bytedanceos.appstore.buss.network.h.a r14 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r14.c());
        CommonUtil.f8830a.c(r14.b(), r10.l());
        com.bytedanceos.appstore.buss.utilities.s.e(r10, r14.c());
        return;
    }

    public static final void P(AppCommentsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L31;
        com.bytedanceos.appstore.buss.network.h.c r12 = (com.bytedanceos.appstore.buss.network.h.c) r11;
        if (r10.Q().isShowing() == true) goto L36;
        TvAppCheckCommentWrap r13 = (TvAppCheckCommentWrap) r12.a();
        Float r14 = null;
        if (r13 == null) goto L12;
        TvAppCheckCommentEntity r15 = r13.getComment();
    L13:
        if (r15 == null) goto L15;
        String r16 = r15.getContent();
    L16:
        if (r15 == null) goto L20;
        String r17 = r15.getScore();
        if (r17 == null) goto L20;
        r14 = kotlin.text.m.f(r17);
    L20:
        if (r15 == null) goto L29;
        if (r16 == null) goto L29;
        if (kotlin.text.o.r(r16) == true) goto L29;
        if (r14 == null) goto L29;
        if (Float.isNaN(r14.floatValue()) == true) goto L29;
        r10.Q().a(r14.floatValue(), r16);
    L29:
        r10.Q().show();
        r10.V();
        return;
    L15:
        r16 = null;
        goto L16
    L12:
        r15 = null;
        goto L13
    L36:
        return;
    L31:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L38;
        com.bytedanceos.appstore.buss.network.h.a r18 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r18.c());
        CommonUtil.f8830a.c(r18.b(), r10.l());
        com.bytedanceos.appstore.buss.utilities.s.e(r10, r18.c());
        if (r10.Q().isShowing() == true) goto L39;
        r10.Q().show();
        r10.V();
        return;
    L39:
        return;
    }

    public static final void U(AppCommentsFragment r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.R().j();
    }

    public static final void W(AppCommentsFragment r12, com.bytedanceos.appstore.buss.network.h r13) {
        kotlin.jvm.internal.q.g(r12, "this$0");
        kotlin.jvm.internal.q.d(r13);
        if ((r13 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L8;
        if (r12.R().l() != 1) goto L75;
        r12.B();
        return;
    L75:
        return;
    L8:
        if ((r13 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L65;
        com.bytedanceos.appstore.buss.network.h.c r14 = (com.bytedanceos.appstore.buss.network.h.c) r13;
        AppCommentsWrap r10 = (AppCommentsWrap) r14.a();
        if (r10 == null) goto L12;
        List<AppCommentEntity> r11 = r10.getComments();
    L14:
        if (r12.R().l() != 1) goto L26;
        r12.r();
        if (r10 == null) goto L25;
        if (r11 == null) goto L25;
        if (r11.isEmpty() == true) goto L25;
        r12.T().f25701b.setVisibility(0);
        r12.T().f25702c.setVisibility(0);
        r12.f8470i.clear();
        r12.f8470i.addAll(r11);
        CommentAdapter r15 = r12.f8469h;
        if (r15 == null) goto L24;
        r15.setList(r12.f8470i);
    L24:
        AppCommentsViewModel r16 = r12.R();
        r16.q(r16.l() + 1);
        r12.T().f25701b.a(String.valueOf(r10.getScores()), String.valueOf(r10.getCount()), new TvGradeWrap(String.valueOf(r10.getCount()), String.valueOf(r10.getScores()), r10.getScore()), Integer.valueOf(r10.getResId()), false);
    L42:
        if (r11 != null) goto L44;
    L58:
        CommentAdapter r17 = r12.f8469h;
        if (r17 == null) goto L63;
        BaseLoadMoreModule r18 = r17.getLoadMoreModule();
        if (r18 == null) goto L63;
        BaseLoadMoreModule.loadMoreEnd$default(r18, false, 1, null);
    L63:
        AppCommentsViewModel r19 = r12.R();
        r19.q(r19.l() + 1);
        return;
    L44:
        if (r11.isEmpty() == true) goto L58;
        if (r11.size() < r12.R().n()) goto L58;
        if (r14.b().getHas_more() == null) goto L58;
        if (kotlin.jvm.internal.q.b(r14.b().getHas_more(), Boolean.FALSE) == true) goto L58;
        CommentAdapter r110 = r12.f8469h;
        if (r110 == null) goto L63;
        BaseLoadMoreModule r111 = r110.getLoadMoreModule();
        if (r111 == null) goto L63;
        r111.loadMoreComplete();
    L25:
        r12.T().f25701b.setVisibility(8);
        r12.T().f25702c.setVisibility(8);
        goto L42
    L26:
        r12.r();
        if (r12.f8470i.size() < (r12.R().l() * r12.R().n())) goto L29;
    L38:
        CommentAdapter r20 = r12.f8469h;
        if (r20 == null) goto L41;
        r20.setList(r12.f8470i);
    L41:
        AppCommentsViewModel r21 = r12.R();
        r21.q(r21.l() + 1);
        goto L42
    L29:
        if ((r12.f8470i.size() % r12.R().n()) != 0) goto L38;
        if (r11 == null) goto L41;
        if (r11.isEmpty() == true) goto L41;
        r12.f8470i.addAll(r11);
        CommentAdapter r22 = r12.f8469h;
        if (r22 == null) goto L41;
        r22.setList(r12.f8470i);
        goto L41
    L12:
        r11 = null;
        goto L14
    L65:
        if ((r13 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L78;
        com.bytedanceos.appstore.buss.network.h.a r112 = (com.bytedanceos.appstore.buss.network.h.a) r13;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r112.c());
        if (r12.R().l() != 1) goto L69;
        r12.D(r112);
        return;
    L69:
        CommentAdapter r113 = r12.f8469h;
        if (r113 == null) goto L80;
        BaseLoadMoreModule r114 = r113.getLoadMoreModule();
        if (r114 == null) goto L81;
        r114.loadMoreFail();
        return;
    L81:
        return;
    L80:
        return;
    }

    @Override // h7.c
    public void E() {
        R().k().i(this, new g(this));
    }

    @Override // h7.c
    public void F() {
    }

    public final void N() {
        if (com.bytedanceos.common.toolbox.e.x0(S().getPkg()) == true) goto L6;
        String r10 = getString(R.string.add_comment_no_buy);
        kotlin.jvm.internal.q.f(r10, "getString(...)");
        com.bytedanceos.appstore.buss.utilities.s.e(this, r10);
        return;
    L6:
        com.bytedanceos.appstore.buss.widget.dialog.x r11 = com.bytedanceos.appstore.buss.widget.dialog.x.f9282a;
        Context r12 = getContext();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type android.app.Activity");
        if (r11.b((Activity) r12, R.string.add_comment_no_user, "dialog_add_comments") == true) goto L9;
        return;
    L9:
        String r13 = AccountDataCache.b().f();
        if (r13 != null) goto L12;
    L16:
        com.bytedanceos.appstore.buss.widget.dialog.c.f9250a.b(l());
        return;
    L12:
        if (kotlin.text.o.r(r13) == true) goto L16;
        R().i().o(this);
        R().h().o(this);
        MutableLiveData r14 = R().i();
        com.bytedanceos.appstore.buss.network.h.b r15 = com.bytedanceos.appstore.buss.network.h.b.f8818a;
        r14.p(r15);
        R().h().p(r15);
        R().i().i(this, new h(this));
        R().h().i(this, new i(this));
        R().g();
    }

    public final com.bytedanceos.appstore.buss.widget.dialog.a Q() {
        return (com.bytedanceos.appstore.buss.widget.dialog.a) this.f8471j.getValue();
    }

    public final AppCommentsViewModel R() {
        return (AppCommentsViewModel) this.f8468g.getValue();
    }

    public final AppInfoEntity S() {
        return (AppInfoEntity) this.f8467f.getValue();
    }

    public final x7.n T() {
        x7.n r10 = x7.n.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final void V() {
        Bundle r10 = new Bundle();
        r10.putString("pkg_name", S().getPkg());
        f9.b.b("click_comment", r10);
    }

    @Override // h7.c
    public void initData() {
        R().o();
        com.bytedanceos.appstore.buss.utilities.t.f8878a.d(h7.c.w(this, "应用评价", true, false, 4, null), this);
        T().f25704e.setItemCanClick(false);
        T().f25704e.setOnlyShowRate(true);
        ItemHorizontalView r10 = T().f25704e;
        kotlin.jvm.internal.q.f(r10, "tvAppItemView");
        BaseLoadMoreModule r11 = null;
        ItemHorizontalView.f(r10, S().convertCommonAppEntity(), 0, 2, null);
        T().f25704e.setPageSource("app_detail_comment_page");
        AppInfoEntity r12 = S();
        String r13 = S().getComments();
        if (r13 == null) goto L5;
        Integer r14 = kotlin.text.n.g(r13);
    L6:
        if (r14 == null) goto L13;
        String r15 = S().getComments();
        if (r15 != null) goto L10;
    L12:
        T().f25701b.setVisibility(0);
        T().f25702c.setVisibility(0);
        T().f25701b.a(String.valueOf(r12.getScores()), r12.getComments(), r12.getTvGradeWrap(), r12.getResId(), false);
        goto L13
    L10:
        if (Integer.parseInt(r15) != 0) goto L12;
    L13:
        T().f25703d.setLayoutManager(new LinearLayoutManager(l()));
        CommentAdapter r16 = new CommentAdapter();
        this.f8469h = r16;
        r16.b(S().getPkg());
        T().f25703d.setAdapter(this.f8469h);
        CommentAdapter r17 = this.f8469h;
        if (r17 == null) goto L18;
        BaseLoadMoreModule r18 = r17.getLoadMoreModule();
        if (r18 == null) goto L18;
        r18.setOnLoadMoreListener(new f(this));
    L18:
        CommentAdapter r19 = this.f8469h;
        if (r19 == null) goto L21;
        BaseLoadMoreModule r20 = r19.getLoadMoreModule();
    L22:
        if (r20 == null) goto L25;
        r20.setAutoLoadMore(true);
    L25:
        CommentAdapter r21 = this.f8469h;
        if (r21 == null) goto L28;
        BaseLoadMoreModule r22 = r21.getLoadMoreModule();
    L29:
        if (r22 == null) goto L32;
        r22.setEnableLoadMore(true);
    L32:
        CommentAdapter r110 = this.f8469h;
        if (r110 == null) goto L35;
        r11 = r110.getLoadMoreModule();
    L35:
        if (r11 == null) goto L38;
        r11.setEnableLoadMoreIfNotFullPage(false);
    L38:
        Bundle r111 = new Bundle();
        r111.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "page_comments");
        f9.b.b("exposure_pages_main", r111);
        return;
    L28:
        r22 = null;
        goto L29
    L21:
        r20 = null;
        goto L22
    L5:
        r14 = null;
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_app_comments;
    }

    @Override // h7.c
    public Function0 o() {
        return new AppCommentsFragment$onRetryListener$1(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (r10 == null) goto L4;
        Integer r11 = Integer.valueOf(r10.getId());
    L5:
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.intValue() != R.id.toolbar_modify) goto L11;
        N();
        return;
    L11:
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8469h = null;
        R().p(this);
    }

    @Override // h7.c
    public void t() {
    }
}
