package com.bytedanceos.appstore.buss.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.app.pager.adapter.PagerTypeAdapter;
import com.bytedanceos.appstore.buss.adapter.onetype.AppDetailGiftAdapter;
import com.bytedanceos.appstore.buss.adapter.onetype.AppDetailImageAdapter;
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.appstore.buss.entity.AppDetailGiftEntity;
import com.bytedanceos.appstore.buss.entity.AppInfoEntity;
import com.bytedanceos.appstore.buss.entity.CommonAppCommentEntity;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.TvAppInfoCategoryInfoEntity;
import com.bytedanceos.appstore.buss.entity.TvAppInfoVideoEntity;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.bytedanceos.appstore.buss.entity.netwrap.TvAppDetailWrap;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.appstore.buss.viewmodels.AppDetailViewModel;
import com.bytedanceos.appstore.buss.viewmodels.repository.MyGiftRepository;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.toolbox.SizeConverter;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.obric.appstore.R;
import com.obric.oui.titlebar.OCTitleBar;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 v2\u00020\u00012\u00020\u0002:\u0001wB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0015\u0010\u0004J\u0019\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u0010/\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010+R\u001b\u00103\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010)\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u00107R\u001b\u0010\r\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010)\u001a\u0004\b:\u0010+R\u001b\u0010?\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010)\u001a\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR$\u0010P\u001a\u0012\u0012\u0004\u0012\u00020\u00050Lj\b\u0012\u0004\u0012\u00020\u0005`M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010[R\u0016\u0010_\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010&R\u0018\u0010b\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010aR\u0016\u0010d\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010&R\u0014\u0010g\u001a\u0002048\u0002X\u0082D¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010i\u001a\u0002048\u0002X\u0082D¢\u0006\u0006\n\u0004\bh\u0010fR\u0014\u0010m\u001a\u00020j8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010lR\u0014\u0010q\u001a\u00020n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0014\u0010r\u001a\u0002048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bE\u00107R\u001c\u0010u\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010s8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bI\u0010t¨\u0006x"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/AppDetailFragment;", "Lh7/c;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "source", "", "a0", "(Ljava/lang/String;)V", "s0", "r0", "W", "pageSource", "Y", "p0", "o0", "n0", "E", "initData", "F", "t", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "onDestroyView", "onDestroy", "Lp7/c;", "event", "onEvent", "(Lp7/c;)V", "", "f", "Z", "isLoginUpdate", "g", "Lkotlin/Lazy;", "e0", "()Ljava/lang/String;", "packageName", "h", "c0", "entitySource", "i", "f0", "()Z", "showHomeAsUp", "", "j", "b0", "()I", "autoDownload", "k", "getPageSource", "Lcom/bytedanceos/appstore/buss/viewmodels/AppDetailViewModel;", "l", "h0", "()Lcom/bytedanceos/appstore/buss/viewmodels/AppDetailViewModel;", "viewModel", "Lcom/bytedanceos/appstore/buss/adapter/onetype/AppDetailImageAdapter;", "m", "Lcom/bytedanceos/appstore/buss/adapter/onetype/AppDetailImageAdapter;", "imageAdapter", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PagerTypeAdapter;", "n", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PagerTypeAdapter;", "recommendAdapter", "Lcom/bytedanceos/appstore/buss/adapter/onetype/AppDetailGiftAdapter;", "o", "Lcom/bytedanceos/appstore/buss/adapter/onetype/AppDetailGiftAdapter;", "giftAdapter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "p", "Ljava/util/ArrayList;", "imageDetailList", "Lcom/bytedanceos/appstore/buss/entity/AppDetailGiftEntity;", "q", "Lcom/bytedanceos/appstore/buss/entity/AppDetailGiftEntity;", "tvAppDetailGiftEntity", "Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;", "r", "Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;", "appInfoEntity", "Landroid/widget/ImageView;", "s", "Landroid/widget/ImageView;", "collectView", "shareView", "u", "isCollected", "Lcom/bytedanceos/appstore/buss/widget/dialog/d;", "Lcom/bytedanceos/appstore/buss/widget/dialog/d;", "giftDetailDialog", "w", "isGettingGift", FixCard.FixStyle.KEY_X, "I", "CATEGORY_ID_SYSTEM_APPS", FixCard.FixStyle.KEY_Y, "CATEGORY_ID_INDIE", "Lx7/o;", "d0", "()Lx7/o;", "fragmentTvAppDetailBinding", "Lx7/l0;", "g0", "()Lx7/l0;", "tvItemAppDetailHeaderBinding", "layoutId", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "z", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppDetailFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppDetailFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,636:1\n106#2,15:637\n1#3:652\n50#4,9:653\n50#4,9:662\n50#4,9:671\n*S KotlinDebug\n*F\n+ 1 AppDetailFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppDetailFragment\n*L\n113#1:637,15\n137#1:653,9\n512#1:662,9\n539#1:671,9\n*E\n"})
public final class AppDetailFragment extends h7.c implements View.OnClickListener {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f8472z = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f8476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f8477j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f8478k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f8479l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AppDetailImageAdapter f8480m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PagerTypeAdapter f8481n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AppDetailGiftAdapter f8482o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f8483p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AppDetailGiftEntity f8484q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AppInfoEntity f8485r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f8486s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ImageView f8487t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8488u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.bytedanceos.appstore.buss.widget.dialog.d f8489v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8490w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f8491x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f8492y;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ Fragment b(a r10, String r11, String r12, boolean r13, int r14, String r15, int r16, Object r17) {
            if ((r16 & 2) == 0) goto L5;
            r12 = "local";
        L5:
            String r18 = r12;
            if ((r16 & 4) == 0) goto L8;
            r13 = true;
        L8:
            boolean r19 = r13;
            if ((r16 & 8) == 0) goto L12;
            r14 = 0;
        L12:
            return r10.a(r11, r18, r19, r14, r15);
        }

        public final Fragment a(String r10, String r11, boolean r12, int r13, String r14) {
            kotlin.jvm.internal.q.g(r10, "packageName");
            kotlin.jvm.internal.q.g(r11, "entitySource");
            AppDetailFragment r15 = new AppDetailFragment();
            r15.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("packageName", r10), kotlin.d.a("entitySource", r11), kotlin.d.a("autoDownload", Integer.valueOf(r13)), kotlin.d.a("showHomeAsUp", Boolean.valueOf(r12)), kotlin.d.a(NetKey.PAGE_SOURCE, r14)}));
            return r15;
        }

        public a() {
        }
    }

    public static final class b implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppDetailFragment f8493a;

        public b(AppDetailFragment r10) {
            this.f8493a = r10;
        }

        public void a(View r10, AppDetailGiftEntity r11) {
            kotlin.jvm.internal.q.g(r10, "view");
            kotlin.jvm.internal.q.g(r11, "entity");
            AppDetailFragment.V(this.f8493a, r11);
            AppDetailFragment.O(this.f8493a, "page_gift_detail");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
            a((View) r10, (AppDetailGiftEntity) r11);
            return Unit.f21064a;
        }
    }

    static {
        f8472z = new a(null);
    }

    public AppDetailFragment() {
        this.f8474g = kotlin.b.b(new AppDetailFragment$packageName$2(this));
        this.f8475h = kotlin.b.b(new AppDetailFragment$entitySource$2(this));
        this.f8476i = kotlin.b.b(new AppDetailFragment$showHomeAsUp$2(this));
        this.f8477j = kotlin.b.b(new AppDetailFragment$autoDownload$2(this));
        this.f8478k = kotlin.b.b(new AppDetailFragment$pageSource$2(this));
        Function0<ViewModelProvider.Factory> r10 = new AppDetailFragment$viewModel$2(this);
        final Function0<Fragment> r11 = new AppDetailFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new AppDetailFragment$special$$inlined$viewModels$default$2(r11));
        final Function0 r13 = null;
        this.f8479l = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(AppDetailViewModel.class), new AppDetailFragment$special$$inlined$viewModels$default$3(r12), new AppDetailFragment$special$$inlined$viewModels$default$4(r13, r12), r10);
        this.f8483p = new ArrayList();
        this.f8491x = 122;
        this.f8492y = 112;
    }

    public static /* synthetic */ void G(AppDetailFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        q0(r10, r11);
    }

    public static /* synthetic */ void H(AppDetailFragment r10, View r11) {
        j0(r10, r11);
    }

    public static /* synthetic */ void I(AppDetailFragment r10, BaseQuickAdapter r11, View r12, int r13) {
        l0(r10, r11, r12, r13);
    }

    public static /* synthetic */ void J(AppDetailFragment r10, String r11, com.bytedanceos.appstore.buss.network.h r12) {
        Z(r10, r11, r12);
    }

    public static /* synthetic */ void K(AppDetailFragment r10, BaseQuickAdapter r11, View r12, int r13) {
        k0(r10, r11, r12, r13);
    }

    public static /* synthetic */ void L(AppDetailFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        X(r10, r11);
    }

    public static /* synthetic */ void M(AppDetailFragment r10, CommonAppCommentEntity r11) {
        m0(r10, r11);
    }

    public static /* synthetic */ void N(AppDetailFragment r10, BaseQuickAdapter r11, View r12, int r13) {
        i0(r10, r11, r12, r13);
    }

    public static final /* synthetic */ void O(AppDetailFragment r10, String r11) {
        r10.a0(r11);
    }

    public static final /* synthetic */ BaseActivity P(AppDetailFragment r10) {
        return r10.l();
    }

    public static final /* synthetic */ String Q(AppDetailFragment r10) {
        return r10.c0();
    }

    public static final /* synthetic */ String R(AppDetailFragment r10) {
        return r10.e0();
    }

    public static final /* synthetic */ PagerTypeAdapter S(AppDetailFragment r10) {
        return r10.f8481n;
    }

    public static final /* synthetic */ x7.l0 T(AppDetailFragment r10) {
        return r10.g0();
    }

    public static final /* synthetic */ AppDetailViewModel U(AppDetailFragment r10) {
        return r10.h0();
    }

    public static final /* synthetic */ void V(AppDetailFragment r10, AppDetailGiftEntity r11) {
        r10.f8484q = r11;
    }

    public static final void X(AppDetailFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == true) goto L38;
        boolean r12 = true;
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L29;
        ImageView r13 = r10.f8486s;
        if (r13 == null) goto L11;
        r13.setEnabled(true);
    L11:
        AppInfoEntity r14 = r10.f8485r;
        if (r14 != null) goto L14;
    L16:
        r12 = false;
    L17:
        r10.f8488u = r12;
        String r15 = null;
        if (r12 == false) goto L23;
        kotlin.jvm.internal.x r16 = kotlin.jvm.internal.x.f21192a;
        AppInfoEntity r17 = r10.f8485r;
        if (r17 == null) goto L22;
        r15 = r17.getName();
    L22:
        String r18 = r10.getString(R.string.myapp_toast_app_add, new Object[]{r15});
        kotlin.jvm.internal.q.f(r18, "getString(...)");
        String r19 = String.format(r18, Arrays.copyOf(new Object[0], 0));
        kotlin.jvm.internal.q.f(r19, "format(...)");
        com.bytedanceos.appstore.buss.utilities.s.e(r10, r19);
    L27:
        r10.n0();
        return;
    L23:
        kotlin.jvm.internal.x r20 = kotlin.jvm.internal.x.f21192a;
        AppInfoEntity r21 = r10.f8485r;
        if (r21 == null) goto L26;
        r15 = r21.getName();
    L26:
        String r22 = r10.getString(R.string.myapp_toast_app_delete, new Object[]{r15});
        kotlin.jvm.internal.q.f(r22, "getString(...)");
        String r23 = String.format(r22, Arrays.copyOf(new Object[0], 0));
        kotlin.jvm.internal.q.f(r23, "format(...)");
        com.bytedanceos.appstore.buss.utilities.s.e(r10, r23);
        goto L27
    L14:
        if (r14.getIfcollect() != 1) goto L16;
    L29:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L37;
        com.bytedanceos.appstore.buss.network.h.a r24 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r24.c());
        CommonUtil.f8830a.c(r24.b(), r10.l());
        ImageView r25 = r10.f8486s;
        if (r25 == null) goto L34;
        r25.setEnabled(true);
    L34:
        com.bytedanceos.appstore.buss.utilities.s.e(r10, r24.c());
        return;
    L37:
        return;
    }

    public static final void Z(AppDetailFragment r10, String r11, com.bytedanceos.appstore.buss.network.h r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$pageSource");
        kotlin.jvm.internal.q.d(r12);
        if ((r12 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        return;
    L6:
        if ((r12 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L36;
        r10.f8490w = false;
        AppDetailGiftEntity r13 = r10.f8484q;
        if (r13 == null) goto L39;
        r10.p0(r11);
        r13.setIfReceived(1);
        r10.f8490w = false;
        r13.setRestCount(String.valueOf(Integer.parseInt(r13.getRestCount()) - 1));
        AppDetailGiftAdapter r14 = r10.f8482o;
        View r15 = null;
        if (r14 == null) goto L14;
        List<AppDetailGiftEntity> r16 = r14.getData();
        if (r16 == null) goto L14;
        Integer r17 = Integer.valueOf(r16.indexOf(r13));
    L15:
        if (r17 != null) goto L17;
    L32:
        AppInfoEntity r18 = r10.f8485r;
        if (r18 == null) goto L40;
        MyGiftRepository.f9032b.a().b(r13.convertGiftMyEntity(r18.getName(), r18.getPkg(), r18.getLogo(), r18.getDownload_url(), r18.getFilemd5(), r18.getFilesize(), r18.getVersion_code()));
        return;
    L40:
        return;
    L17:
        if (r17.intValue() <= (-1)) goto L32;
        AppDetailGiftAdapter r19 = r10.f8482o;
        if (r19 == null) goto L23;
        List<AppDetailGiftEntity> r20 = r19.getData();
        if (r20 == null) goto L23;
        AppDetailGiftEntity r21 = r20.set(r17.intValue(), r13);
    L23:
        AppDetailGiftAdapter r22 = r10.f8482o;
        if (r22 == null) goto L26;
        r15 = r22.getViewByPosition(r17.intValue(), R.id.tv_get);
    L26:
        if (r15 == null) goto L29;
        r15.setEnabled(true);
    L29:
        AppDetailGiftAdapter r110 = r10.f8482o;
        if (r110 == null) goto L32;
        r110.notifyItemChanged(r17.intValue());
    L14:
        r17 = null;
        goto L15
    L39:
        return;
    L36:
        if ((r12 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L42;
        com.bytedanceos.appstore.buss.network.h.a r111 = (com.bytedanceos.appstore.buss.network.h.a) r12;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r111.c());
        r10.f8490w = false;
        CommonUtil.f8830a.c(r111.b(), r10.l());
        com.bytedanceos.appstore.buss.utilities.s.e(r10, r111.c());
        return;
    }

    private final String e0() {
        return (String) this.f8474g.getValue();
    }

    private final boolean f0() {
        return ((Boolean) this.f8476i.getValue()).booleanValue();
    }

    private final String getPageSource() {
        return (String) this.f8478k.getValue();
    }

    public static final void i0(AppDetailFragment r10, BaseQuickAdapter r11, View r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "<anonymous parameter 0>");
        kotlin.jvm.internal.q.g(r12, "view");
        if (r12.getId() != R.id.tv_get) goto L12;
        AppDetailGiftAdapter r14 = r10.f8482o;
        if (r14 == null) goto L9;
        List<AppDetailGiftEntity> r15 = r14.getData();
        if (r15 == null) goto L9;
        AppDetailGiftEntity r16 = r15.get(r13);
    L10:
        r10.f8484q = r16;
        r10.a0("page_game_detail");
        return;
    L9:
        r16 = null;
        goto L10
    }

    public static final void j0(AppDetailFragment r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        AppInfoEntity r12 = r10.f8485r;
        String r13 = null;
        if (r12 == null) goto L5;
        AppInfo r14 = r12.convertAppInfo();
    L6:
        if (r14 == null) goto L15;
        AppInfoEntity r15 = r10.f8485r;
        if (r15 == null) goto L13;
        TvAppInfoVideoEntity r16 = r15.getVideo();
        if (r16 == null) goto L13;
        String r17 = r16.getUrl();
    L14:
        r14.mAppVideoUrl = r17;
    L13:
        r17 = null;
    L15:
        if (r14 == null) goto L24;
        AppInfoEntity r18 = r10.f8485r;
        if (r18 == null) goto L22;
        TvAppInfoVideoEntity r19 = r18.getVideo();
        if (r19 == null) goto L22;
        String r20 = r19.getImg();
    L23:
        r14.mAppVideoImage = r20;
    L22:
        r20 = null;
    L24:
        Context r21 = r10.getContext();
        kotlin.jvm.internal.q.e(r21, "null cannot be cast to non-null type android.app.Activity");
        l8.b.b((Activity) r21, r14);
        Bundle r22 = new Bundle();
        if (r14 == null) goto L27;
        r13 = r14.appPackageName;
    L27:
        r22.putString("pkg_name", r13);
        f9.b.b("click_video_pages_detail", r22);
        return;
    L5:
        r14 = null;
        goto L6
    }

    public static final void k0(AppDetailFragment r10, BaseQuickAdapter r11, View r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "<anonymous parameter 0>");
        kotlin.jvm.internal.q.g(r12, "<anonymous parameter 1>");
        AppInfoEntity r14 = r10.f8485r;
        String r15 = null;
        if (r14 == null) goto L5;
        AppInfo r16 = r14.convertAppInfo();
    L6:
        if (r16 == null) goto L15;
        AppInfoEntity r17 = r10.f8485r;
        if (r17 == null) goto L13;
        TvAppInfoVideoEntity r18 = r17.getVideo();
        if (r18 == null) goto L13;
        String r19 = r18.getUrl();
    L14:
        r16.mAppVideoUrl = r19;
    L13:
        r19 = null;
    L15:
        if (r16 == null) goto L24;
        AppInfoEntity r20 = r10.f8485r;
        if (r20 == null) goto L22;
        TvAppInfoVideoEntity r21 = r20.getVideo();
        if (r21 == null) goto L22;
        String r22 = r21.getImg();
    L23:
        r16.mAppVideoImage = r22;
    L22:
        r22 = null;
    L24:
        if (r16 == null) goto L31;
        AppDetailImageAdapter r23 = r10.f8480m;
        if (r23 == null) goto L29;
        List<String> r24 = r23.getData();
    L30:
        kotlin.jvm.internal.q.e(r24, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
        r16.appScreenSnaps = (ArrayList) r24;
        goto L31
    L29:
        r24 = null;
    L31:
        com.bytedanceos.common.toolbox.e.j1(r13, r16);
        Bundle r25 = new Bundle();
        if (r16 == null) goto L34;
        r15 = r16.appPackageName;
    L34:
        r25.putString("pkg_name", r15);
        f9.b.b("click_image_pages_detail", r25);
        return;
    L5:
        r16 = null;
        goto L6
    }

    public static final void l0(AppDetailFragment r10, BaseQuickAdapter r11, View r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "<anonymous parameter 0>");
        kotlin.jvm.internal.q.g(r12, "<anonymous parameter 1>");
        BaseActivity r14 = r10.l();
        AppInfoEntity r15 = r10.f8485r;
        if (r15 == null) goto L5;
        String r16 = r15.getLogo();
    L6:
        AppInfoEntity r17 = r10.f8485r;
        if (r17 == null) goto L9;
        String r18 = r17.getName();
    L10:
        AppDetailGiftAdapter r19 = r10.f8482o;
        if (r19 == null) goto L21;
        List<AppDetailGiftEntity> r20 = r19.getData();
        if (r20 == null) goto L22;
        AppDetailGiftEntity r21 = r20.get(r13);
        if (r21 == null) goto L24;
        r10.f8489v = new com.bytedanceos.appstore.buss.widget.dialog.d(r14, r16, r18, r21, new b(r10));
        Bundle r22 = new Bundle();
        r22.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "page_gift_detail");
        f9.b.b("exposure_pages_main", r22);
        com.bytedanceos.appstore.buss.widget.dialog.d r23 = r10.f8489v;
        if (r23 == null) goto L23;
        r23.show();
        return;
    L23:
        return;
    L24:
        return;
    L22:
        return;
    L21:
        return;
    L9:
        r18 = null;
        goto L10
    L5:
        r16 = null;
        goto L6
    }

    public static final void m0(AppDetailFragment r10, CommonAppCommentEntity r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        if (r10.f8485r == null) goto L6;
        r10.h0().n(r11);
        return;
    }

    public static final void q0(AppDetailFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L8;
        if (r10.f8473f == true) goto L42;
        r10.B();
        return;
    L42:
        return;
    L8:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L39;
        TvAppDetailWrap r12 = (TvAppDetailWrap) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 == null) goto L12;
        AppInfoEntity r13 = r12.getAppInfoEntity();
    L13:
        if (r12 == null) goto L15;
        AppInfoEntity r14 = r12.getAppInfoEntity();
    L16:
        if (r14 != null) goto L18;
        h7.c.A(r10, null, null, 0, 7, null);
        return;
    L18:
        r10.r();
        if (r13 == null) goto L21;
        List<TvAppInfoCategoryInfoEntity> r15 = r13.getCategory_info();
    L22:
        if (r13 == null) goto L30;
        if (r15 == null) goto L28;
        TvAppInfoCategoryInfoEntity r16 = r15.get(0);
        if (r16 == null) goto L28;
        String r17 = r16.getId();
    L29:
        r13.setCid(r17);
    L28:
        r17 = null;
    L30:
        if (r15 != null) goto L32;
    L34:
        r10.f8485r = r13;
        if (r10.f8473f == false) goto L37;
        r10.s0();
        return;
    L37:
        r10.r0();
        kotlinx.coroutines.h.d(androidx.lifecycle.s.a(r10), null, null, new AppDetailFragment$subscribeUi$1$2$1(r12, r10, null), 3, null);
        return;
    L32:
        if (r15.size() <= 1) goto L34;
        r13.setSubCid(r15.get(1).getId());
        goto L34
    L21:
        r15 = null;
        goto L22
    L15:
        r14 = null;
        goto L16
    L12:
        r13 = null;
        goto L13
    L39:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L47;
        com.bytedanceos.appstore.buss.network.h.a r18 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r18.c());
        r10.D(r18);
        return;
    }

    @Override // h7.c
    public void E() {
        h0().p().i(this, new l(this));
    }

    @Override // h7.c
    public void F() {
    }

    public final void W() {
        h0().w().o(this);
        h0().w().p(com.bytedanceos.appstore.buss.network.h.b.f8818a);
        h0().w().i(this, new j(this));
    }

    public final void Y(final String r10) {
        h0().r().o(this);
        h0().r().p(com.bytedanceos.appstore.buss.network.h.b.f8818a);
        h0().r().i(this, new q(this, r10));
    }

    public final void a0(String r10) {
        AppDetailGiftEntity r11 = this.f8484q;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11 != null) goto L8;
    L10:
        AppDetailGiftEntity r12 = this.f8484q;
        if (r12 == null) goto L17;
        String r13 = r12.getRestCount();
        if (r13 == null) goto L17;
        if (Integer.parseInt(r13) != 0) goto L17;
        String r14 = getString(R.string.gift_over);
        kotlin.jvm.internal.q.f(r14, "getString(...)");
        com.bytedanceos.appstore.buss.utilities.s.e(this, r14);
        return;
    L17:
        AppInfoEntity r15 = this.f8485r;
        if (r15 != null) goto L20;
        return;
    L20:
        if (this.f8490w == false) goto L23;
        return;
    L23:
        if (AccountDataCache.b().n() == true) goto L26;
        CommonUtil.f8830a.h(l(), "gift_acquire", true);
        return;
    L26:
        AppDetailGiftEntity r16 = this.f8484q;
        if (r16 == null) goto L33;
        this.f8490w = true;
        Y(r10);
        h0().q(r15.getPkg(), r16.getId());
        return;
    L33:
        return;
    L8:
        if (r11.getIfReceived() != 1) goto L10;
        o0(r10);
    }

    public final int b0() {
        return ((Number) this.f8477j.getValue()).intValue();
    }

    public final String c0() {
        return (String) this.f8475h.getValue();
    }

    public final x7.o d0() {
        x7.o r10 = x7.o.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final x7.l0 g0() {
        x7.l0 r10 = x7.l0.a(m().findViewById(R.id.layout_app_detail_header));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final AppDetailViewModel h0() {
        return (AppDetailViewModel) this.f8479l.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h7.c
    public void initData() {
        EventBus.getDefault().register(this);
        FragmentActivity r10 = getActivity();
        int r11 = 1;
        ItemType r12 = null;
        Object[] r13 = 0;
        if (r10 == null) goto L5;
        com.bytedanceos.appstore.buss.utilities.i.c(r10, 0, 1, null);
    L5:
        OCTitleBar r14 = h7.c.w(this, "应用详情", f0(), false, 4, null);
        u("应用详情");
        if (r14 == null) goto L8;
        r14.h();
    L8:
        com.bytedanceos.appstore.buss.utilities.t r15 = com.bytedanceos.appstore.buss.utilities.t.f8878a;
        this.f8487t = r15.e(r14, this);
        this.f8486s = r15.b(r14, this);
        ImageView r16 = this.f8487t;
        if (r16 == null) goto L12;
        r16.setEnabled(false);
    L12:
        ImageView r17 = this.f8486s;
        if (r17 == null) goto L16;
        r17.setEnabled(false);
    L16:
        g0().f25661l.setOnClickListener(this);
        g0().f25659j.setOnClickListener(this);
        d0().f25718k.setOnClickListener(this);
        g0().f25651b.setOnClickListener(this);
        d0().f25712e.setOnClickListener(this);
        g0().f25651b.setBtnStyle(2);
        d0().f25717j.setLayoutManager(new LinearLayoutManager(l()));
        CommonRecyclerView r18 = d0().f25717j;
        PagerTypeAdapter r19 = this.f8481n;
        if (r19 != null) goto L20;
        r19 = new PagerTypeAdapter(r12, "page_detail", r11, r13 == true ? 1 : 0);
        this.f8481n = r19;
    L20:
        r18.setAdapter(r19);
        d0().f25716i.setLayoutManager(new LinearLayoutManager(l(), 0, false));
        CommonRecyclerView r20 = d0().f25716i;
        AppDetailImageAdapter r21 = this.f8480m;
        if (r21 != null) goto L24;
        r21 = new AppDetailImageAdapter(new m(this));
        this.f8480m = r21;
    L24:
        r20.setAdapter(r21);
        AppDetailImageAdapter r22 = this.f8480m;
        if (r22 == null) goto L27;
        r22.setOnItemClickListener(new n(this));
    L27:
        d0().f25715h.setLayoutManager(new LinearLayoutManager(l()));
        CommonRecyclerView r23 = d0().f25715h;
        AppDetailGiftAdapter r24 = this.f8482o;
        if (r24 != null) goto L31;
        r24 = new AppDetailGiftAdapter();
        this.f8482o = r24;
    L31:
        r23.setAdapter(r24);
        AppDetailGiftAdapter r25 = this.f8482o;
        if (r25 == null) goto L34;
        r25.addChildClickViewIds(new int[]{R.id.tv_get});
    L34:
        AppDetailGiftAdapter r26 = this.f8482o;
        if (r26 == null) goto L37;
        r26.setOnItemClickListener(new o(this));
    L37:
        AppDetailGiftAdapter r27 = this.f8482o;
        if (r27 == null) goto L40;
        r27.setOnItemChildClickListener(new p(this));
    L40:
        Bundle r28 = new Bundle();
        r28.putString("app_pkg", e0());
        r28.putString("detail_source", getPageSource());
        f9.b.b("exposure_pages_detail", r28);
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_app_detail;
    }

    public final void n0() {
        if (this.f8488u == false) goto L12;
        ImageView r10 = this.f8486s;
        if (r10 == null) goto L8;
        r10.setImageTintList(ColorStateList.valueOf(ContextCompat.b(l(), R.color.collect_select_color)));
    L8:
        ImageView r11 = this.f8486s;
        if (r11 == null) goto L22;
        r11.setContentDescription(getString(R.string.collection_done_des));
        return;
    L22:
        return;
    L12:
        ImageView r12 = this.f8486s;
        if (r12 == null) goto L16;
        r12.setImageTintList(ColorStateList.valueOf(ContextCompat.b(l(), R.color.collect_normal_color)));
    L16:
        ImageView r13 = this.f8486s;
        if (r13 == null) goto L23;
        r13.setContentDescription(getString(R.string.collection_des));
        return;
    }

    @Override // h7.c
    public Function0 o() {
        return new AppDetailFragment$onRetryListener$1(this);
    }

    public final void o0(String r11) {
        AppInfoEntity r10 = this.f8485r;
        if (r10 == null) goto L12;
        AppDetailGiftEntity r12 = this.f8484q;
        if (r12 != null) goto L7;
        return;
    L7:
        if (com.bytedanceos.common.toolbox.e.x0(r10.getPkg()) == false) goto L9;
        com.bytedanceos.appstore.buss.widget.dialog.r.f9272a.k(l(), r12.convertGiftMyEntity(r10.getName(), r10.getPkg(), r10.getLogo(), r10.getDownload_url(), r10.getFilemd5(), r10.getFilesize(), r10.getVersion_code()));
    L10:
        Bundle r13 = new Bundle();
        r13.putString(NetKey.PAGE_SOURCE, r11);
        f9.b.b("click_goodies_use_dialog", r13);
        return;
    L9:
        com.bytedanceos.appstore.buss.widget.dialog.r.f9272a.h(l(), r12.convertGiftMyEntity(r10.getName(), r10.getPkg(), r10.getLogo(), r10.getDownload_url(), r10.getFilemd5(), r10.getFilesize(), r10.getVersion_code()));
        goto L10
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        CommonAppEntity r11 = null;
        if (r10 == null) goto L5;
        Integer r12 = Integer.valueOf(r10.getId());
    L7:
        if (r12 != null) goto L10;
    L29:
        if (r12 != null) goto L32;
    L55:
        if (r12 != null) goto L58;
    L62:
        if (r12 != null) goto L65;
    L69:
        if (r12 != null) goto L72;
    L83:
        if (r12 != null) goto L86;
    L92:
        if (r12 != null) goto L95;
        return;
    L95:
        if (r12.intValue() != R.id.grade_view) goto L117;
        AppInfoEntity r13 = this.f8485r;
        if (r13 == null) goto L118;
        i7.a.g(this, AppCommentsFragment.f8466k.a(r13), false, 2, null);
        return;
    L118:
        return;
    L117:
        return;
    L86:
        if (r12.intValue() != R.id.toolbar_share) goto L92;
        if (com.bytedanceos.common.toolbox.e.p0() == false) goto L114;
        AppInfoEntity r14 = this.f8485r;
        if (r14 == null) goto L115;
        kotlinx.coroutines.h.d(androidx.lifecycle.s.a(this), null, null, new AppDetailFragment$onClick$3$1(this, r14, null), 3, null);
        return;
    L115:
        return;
    L114:
        return;
    L72:
        if (r12.intValue() != R.id.toolbar_collect) goto L83;
        if (com.bytedanceos.appstore.buss.widget.dialog.x.f9282a.b(l(), R.string.share_no_user, "dialog_add_wish") == false) goto L112;
        ImageView r15 = this.f8486s;
        if (r15 == null) goto L79;
        r15.setEnabled(false);
    L79:
        W();
        AppDetailViewModel r16 = h0();
        AppInfoEntity r17 = this.f8485r;
        if (r17 == null) goto L82;
        r11 = r17.convertCommonAppEntity();
    L82:
        r16.x(r11);
        return;
    L112:
        return;
    L65:
        if (r12.intValue() != R.id.appStatusLay) goto L69;
        AppInfoEntity r18 = this.f8485r;
        if (r18 == null) goto L110;
        Bundle r19 = new Bundle();
        r19.putString(NetKey.PAGE_SOURCE, "app_detail_page");
        r19.putString("pkg_name", r18.getPkg());
        f9.b.b("click_install_pages_detail", r19);
        l8.a.a(l(), g0().f25651b, r18.convertAppInfo(), getPageSource());
        return;
    L110:
        return;
    L58:
        if (r12.intValue() != R.id.tv_desc) goto L62;
        AppInfoEntity r20 = this.f8485r;
        if (r20 == null) goto L108;
        i7.a.g(this, AppBriefFragment.f8444g.a(r20), false, 2, null);
        return;
    L108:
        return;
    L32:
        if (r12.intValue() != R.id.tv_play) goto L55;
        String r21 = g0().f25661l.getText().toString();
        AppInfoEntity r22 = this.f8485r;
        if (r22 == null) goto L54;
        String r23 = r22.getCid();
        if (r23 == null) goto L103;
        Integer r24 = kotlin.text.n.g(r23);
        if (r24 == null) goto L104;
        int r25 = r24.intValue();
        AppInfoEntity r26 = this.f8485r;
        if (r26 == null) goto L46;
        String r27 = r26.getSubCid();
        if (r27 == null) goto L46;
        Integer r28 = kotlin.text.n.g(r27);
        if (r28 == null) goto L46;
        int r29 = r28.intValue();
    L48:
        if (r25 != this.f8491x) goto L50;
    L53:
        i7.a.g(this, AppCategorySingleFragment.f8457n.a(r21, r24, true), false, 2, null);
        return;
    L50:
        if (r25 == this.f8492y) goto L53;
        i7.a.g(this, AppCategoryFragment.f8446o.a(r21, r24, Integer.valueOf(r29), true), false, 2, null);
        return;
    L46:
        r29 = -1;
        goto L48
    L104:
        return;
    L103:
        return;
    L54:
        return;
    L10:
        if (r12.intValue() != R.id.tv_company) goto L29;
        AppInfoEntity r30 = this.f8485r;
        if (r30 == null) goto L14;
        String r31 = r30.getDeveloper();
    L15:
        AppInfoEntity r32 = this.f8485r;
        if (r32 == null) goto L18;
        String r33 = r32.getDever_id();
    L19:
        if (r31 != null) goto L21;
        return;
    L21:
        if (kotlin.text.o.r(r31) == true) goto L101;
        if (r33 != null) goto L25;
        return;
    L25:
        if (kotlin.text.o.r(r33) == true) goto L102;
        i7.a.g(this, DevAppsFragment.f8559m.a(r31, r33), false, 2, null);
        return;
    L102:
        return;
    L101:
        return;
    L18:
        r33 = null;
        goto L19
    L14:
        r31 = null;
        goto L15
    L5:
        r12 = null;
        goto L7
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        h0().t().i(this, new k(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        h0().t().o(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8486s = null;
        this.f8487t = null;
        this.f8480m = null;
        this.f8481n = null;
        this.f8482o = null;
        h0().y(this);
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull p7.c r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        this.f8473f = true;
        h0().o();
    }

    public final void p0(String r11) {
        AppInfoEntity r10 = this.f8485r;
        if (r10 == null) goto L8;
        AppDetailGiftEntity r12 = this.f8484q;
        if (r12 == null) goto L9;
        com.bytedanceos.appstore.buss.widget.dialog.r.f9272a.n(l(), r12.convertGiftMyEntity(r10.getName(), r10.getPkg(), r10.getLogo(), r10.getDownload_url(), r10.getFilemd5(), r10.getFilesize(), r10.getVersion_code()), com.bytedanceos.common.toolbox.e.x0(r10.getPkg()));
        Bundle r13 = new Bundle();
        r13.putString(NetKey.PAGE_SOURCE, r11);
        f9.b.b("click_goodies_acquire_dialog", r13);
        return;
    L9:
        return;
    }

    public final void r0() {
        AppInfoEntity r10 = this.f8485r;
        if (r10 == null) goto L125;
        g0().f25651b.updateDownloadStatus(r10.convertAppInfo());
        ImageView r11 = g0().f25654e;
        kotlin.jvm.internal.q.f(r11, "ivLogo");
        ImageUtilKt.g(r11, r10.getLogo(), R.dimen.dp_18, 0, 4, null);
        g0().f25660k.setText(r10.getName());
        g0().f25661l.setText(String.valueOf(r10.getCategory()));
        String r12 = null;
        if (TextUtils.isEmpty(r10.getDeveloper()) == false) goto L11;
        TextView r13 = g0().f25659j;
        Context r14 = getContext();
        if (r14 == null) goto L9;
        String r15 = r14.getString(R.string.unkown);
    L10:
        r13.setText(r15);
    L12:
        boolean r16 = false;
        if (TextUtils.isEmpty(r10.getBrief()) == false) goto L15;
        d0().f25718k.setVisibility(8);
        d0().f25710c.setVisibility(8);
    L16:
        d0().f25718k.setText(r10.getBrief());
        String r17 = r10.getComments();
        if (r17 == null) goto L19;
        Integer r18 = kotlin.text.n.g(r17);
    L20:
        if (r18 == null) goto L31;
        String r19 = r10.getComments();
        if (r19 != null) goto L24;
    L26:
        String r20 = r10.getScores();
        if (r20 == null) goto L32;
        Float r21 = kotlin.text.m.f(r20);
        if (r21 == null) goto L32;
        g0().f25655f.setImageResource(com.bytedanceos.common.toolbox.e.b0(getContext(), r21.floatValue(), false));
    L32:
        List<Integer> r22 = r10.getLabel();
        if (r22 == null) goto L35;
        Integer r23 = Integer.valueOf(r22.size());
    L37:
        if (r23 != null) goto L39;
    L57:
        Float r24 = kotlin.text.m.f(r10.getFilesize());
        if (r24 == null) goto L61;
        g0().f25662m.setText(SizeConverter.BTrim.convert(r24.floatValue()));
    L61:
        if (r10.isFromSmt() == false) goto L67;
        d0().f25713f.setVisibility(0);
        if (TextUtils.isEmpty(r10.getDeveloper()) == true) goto L65;
        com.bytedanceos.common.toolbox.e.b1(g0().f25659j, true, 7);
    L66:
        com.bytedanceos.common.toolbox.e.b1(g0().f25661l, true, 5);
    L68:
        d0().f25712e.a(String.valueOf(r10.getScores()), r10.getComments(), r10.getTvGradeWrap(), r10.getResId(), true);
        if (r10.isSystemApp() == false) goto L75;
        ImageView r25 = this.f8487t;
        if (r25 == null) goto L74;
        r25.setVisibility(8);
    L74:
        d0().f25713f.setVisibility(8);
    L75:
        List<AppDetailGiftEntity> r26 = r10.getGifts();
        if (r26 == null) goto L80;
        AppDetailGiftAdapter r27 = this.f8482o;
        if (r27 == null) goto L80;
        r27.setList(r26);
    L80:
        TvAppInfoVideoEntity r28 = r10.getVideo();
        if (r28 == null) goto L84;
        r12 = r28.getUrl();
    L84:
        if (TextUtils.isEmpty(r12) == true) goto L97;
        TvAppInfoVideoEntity r29 = r10.getVideo();
        if (r29 == null) goto L97;
        String r30 = r29.getImg();
        if (r30 == null) goto L97;
        this.f8483p.add(r30);
        AppDetailImageAdapter r31 = this.f8480m;
        if (r31 == null) goto L93;
        r31.d(true);
    L93:
        if ("2".equals(r10.getVideo().getDirect()) == false) goto L97;
        AppDetailImageAdapter r32 = this.f8480m;
        if (r32 == null) goto L97;
        r32.e(true);
    L97:
        List<String> r33 = r10.getPrintscreen();
        if (r33 == null) goto L100;
        this.f8483p.addAll(r33);
    L100:
        AppDetailImageAdapter r34 = this.f8480m;
        if (r34 == null) goto L103;
        r34.setList(this.f8483p);
    L103:
        ImageView r35 = this.f8486s;
        if (r35 == null) goto L107;
        r35.setEnabled(true);
    L107:
        ImageView r36 = this.f8487t;
        if (r36 == null) goto L112;
        r36.setEnabled(true);
    L112:
        if (r10.getIfcollect() != 1) goto L114;
        r16 = true;
    L114:
        this.f8488u = r16;
        n0();
        AppInfo r37 = BaseApplication.c().b().D(r10.getPkg());
        if (r37 == null) goto L122;
        kotlin.jvm.internal.q.d(r37);
        AppInfo r38 = BaseApplication.c().b().G(r10.getPkg());
        if (r38 == null) goto L122;
        if (Integer.parseInt(r10.getVersion_code()) <= r38.appVersionCode) goto L122;
        BaseApplication.c().b().g(r10.convertAppInfo(), r37);
    L122:
        if (b0() != 129) goto L126;
        Bundle r39 = new Bundle();
        r39.putString(NetKey.PAGE_SOURCE, "app_detail_page");
        r39.putString("pkg_name", r10.getPkg());
        f9.b.b("click_install_pages_detail", r39);
        l8.a.a(l(), g0().f25651b, r10.convertAppInfo(), getPageSource());
        return;
    L126:
        return;
    L65:
        com.bytedanceos.common.toolbox.e.a1(g0().f25659j, false);
        goto L66
    L67:
        d0().f25713f.setVisibility(8);
        com.bytedanceos.common.toolbox.e.a1(g0().f25661l, false);
        com.bytedanceos.common.toolbox.e.a1(g0().f25659j, false);
        goto L68
    L39:
        if (r23.intValue() <= 1) goto L48;
        g0().f25656g.setVisibility(0);
        g0().f25657h.setVisibility(0);
        com.bytedanceos.common.toolbox.e.A1(g0().f25656g, r22.get(0).intValue());
        com.bytedanceos.common.toolbox.e.A1(g0().f25657h, r22.get(1).intValue());
        ViewGroup.LayoutParams r40 = g0().f25656g.getLayoutParams();
        kotlin.jvm.internal.q.e(r40, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r41 = (ViewGroup.MarginLayoutParams) r40;
        Context r42 = getContext();
        if (r42 == null) goto L45;
        Resources r43 = r42.getResources();
        if (r43 == null) goto L45;
        Integer r44 = Integer.valueOf(r43.getDimensionPixelSize(R.dimen.lkp_app_detail_label_margin_right));
    L46:
        kotlin.jvm.internal.q.d(r44);
        r41.setMarginEnd(r44.intValue());
        g0().f25656g.setLayoutParams(r41);
    L45:
        r44 = null;
        goto L46
    L48:
        if (r23.intValue() <= 0) goto L56;
        g0().f25656g.setVisibility(0);
        g0().f25657h.setVisibility(8);
        com.bytedanceos.common.toolbox.e.A1(g0().f25656g, r22.get(0).intValue());
        ViewGroup.LayoutParams r45 = g0().f25656g.getLayoutParams();
        kotlin.jvm.internal.q.e(r45, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r46 = (ViewGroup.MarginLayoutParams) r45;
        Context r47 = getContext();
        if (r47 == null) goto L54;
        Resources r48 = r47.getResources();
        if (r48 == null) goto L54;
        Integer r49 = Integer.valueOf(r48.getDimensionPixelSize(R.dimen.lkp_app_detail_label_margin_right_default));
    L55:
        kotlin.jvm.internal.q.d(r49);
        r46.setMarginEnd(r49.intValue());
        g0().f25656g.setLayoutParams(r46);
    L54:
        r49 = null;
        goto L55
    L56:
        g0().f25656g.setVisibility(8);
        g0().f25657h.setVisibility(8);
        goto L57
    L35:
        r23 = null;
        goto L37
    L24:
        if (Integer.parseInt(r19) != 0) goto L26;
    L31:
        g0().f25655f.setImageResource(R.drawable.rate_none);
        goto L32
    L19:
        r18 = null;
        goto L20
    L15:
        d0().f25718k.setVisibility(0);
        d0().f25710c.setVisibility(0);
        d0().f25718k.setText(r10.getBrief());
        goto L16
    L9:
        r15 = null;
        goto L10
    L11:
        g0().f25659j.setText(String.valueOf(r10.getDeveloper()));
        goto L12
    }

    public final void s0() {
        AppInfoEntity r10 = this.f8485r;
        if (r10 == null) goto L10;
        boolean r11 = true;
        if (r10.getIfcollect() == 1) goto L8;
        r11 = false;
    L8:
        this.f8488u = r11;
        n0();
        return;
    }

    @Override // h7.c
    public void t() {
    }
}
