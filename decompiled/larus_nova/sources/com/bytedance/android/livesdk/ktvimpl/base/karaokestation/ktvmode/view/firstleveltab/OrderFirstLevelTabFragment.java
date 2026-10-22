package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.CommonOrderFirstLevelTabFragment;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.live.ktv.common.model.api.u;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.ordersong.view.DialogLoadingView;
import com.bytedance.android.live.ktv.common.ordersong.view.KtvTextSwitcher;
import com.bytedance.android.live.ktv.common.search.view.CommonSearchContainer;
import com.bytedance.android.live.liveinteract.banner.LabelBannerUrl;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.search.SearchOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.MusicListSecondLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/firstleveltab/OrderFirstLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/CommonOrderFirstLevelTabFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OrderFirstLevelTabFragment extends CommonOrderFirstLevelTabFragment {
    public static final /* synthetic */ int E = 0;
    public CommonSearchContainer A;
    public final Lazy B;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d C;
    public final com.bytedance.android.live.ktv.common.search.viewmodel.a D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f142778y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public DialogLoadingView f142779z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderFirstLevelTabFragment f142780a;

        public b(OrderFirstLevelTabFragment r100) {
            this.f142780a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            td2.a r101 = (td2.a) r100;
            OrderFirstLevelTabFragment r102 = this.f142780a;
            int r103 = OrderFirstLevelTabFragment.E;
            FrameLayout r104 = r102.f69645x;
            if (r104 != null) goto L5;
            return;
        L5:
            if (r104.getVisibility() != 0) goto L9;
            ((SearchOuterCallback) this.f142780a.B.getValue()).onSearchExit();
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderFirstLevelTabFragment f142781a;

        public c(OrderFirstLevelTabFragment r100) {
            this.f142781a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            if (r101 == null) goto L13;
            int r102 = ((Number) r101.component1()).intValue();
            this.f142781a.getClass();
            if (r102 != FirstLevelTab.OrderSongTab.getValue()) goto L11;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r103 = this.f142781a.C;
            if (r103 == null) goto L12;
            r103.updateCurrentTabData();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderFirstLevelTabFragment f142782a;

        public d(OrderFirstLevelTabFragment r100) {
            this.f142782a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            OrderFirstLevelTabFragment r102 = this.f142782a;
            int r103 = OrderFirstLevelTabFragment.E;
            r102.ha0();
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderFirstLevelTabFragment f142783a;

        public e(OrderFirstLevelTabFragment r100) {
            this.f142783a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            OrderFirstLevelTabFragment r102 = this.f142783a;
            int r103 = OrderFirstLevelTabFragment.E;
            r102.ha0();
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderFirstLevelTabFragment f142784a;

        public f(OrderFirstLevelTabFragment r100) {
            this.f142784a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            List r101 = (List) r100;
            if (r101 == null) goto L13;
            List r102 = r101;
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r104 = r102.iterator();
        L6:
            if (r104.hasNext() == false) goto L8;
            r103.add(((u) r104.next()).a());
            goto L6
        L8:
            OrderFirstLevelTabFragment r105 = this.f142784a;
            int r106 = OrderFirstLevelTabFragment.E;
            KtvTextSwitcher r107 = r105.f69642u;
            if (r107 == null) goto L14;
            r107.setItems(r103);
            return;
        L14:
            return;
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderFirstLevelTabFragment f142785a;

        public g(OrderFirstLevelTabFragment r100) {
            this.f142785a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            OrderFirstLevelTabFragment r102 = this.f142785a;
            int r103 = OrderFirstLevelTabFragment.E;
            if (KSongOrderSongUtilKt.j(r102.f69627q, FirstLevelTab.OrderSongTab) == false) goto L8;
            DialogLoadingView r104 = this.f142785a.f142779z;
            if (r104 == null) goto L9;
            r104.a(Intrinsics.areEqual(r101, Boolean.TRUE));
            return;
        L9:
            return;
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderFirstLevelTabFragment f142786a;

        public h(OrderFirstLevelTabFragment r100) {
            this.f142786a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            OrderFirstLevelTabFragment r101 = this.f142786a;
            int r102 = OrderFirstLevelTabFragment.E;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r103 = r101.f69627q;
            KSongOrderSongUtilKt.h(r103, (Long) r100, "recommend", FirstLevelTab.OrderSongTab);
        }
    }

    public static final class i<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderFirstLevelTabFragment f142787a;

        public i(OrderFirstLevelTabFragment r100) {
            this.f142787a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Map r101 = (Map) r100;
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == true) goto L43;
            OrderFirstLevelTabFragment r103 = this.f142787a;
            int r104 = OrderFirstLevelTabFragment.E;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r105 = r103.f69627q;
            if (r105 == null) goto L31;
            List<y> r106 = r105.getSecondLevelTabDataList(FirstLevelTab.OrderSongTab.getValue());
            if (r106 == null) goto L42;
            Iterator<T> r107 = r106.iterator();
        L17:
            if (r107.hasNext() == false) goto L44;
            y r108 = (y) r107.next();
            Map<String, String> r109 = r108.f69580e;
            if (r109 == null) goto L17;
            int r110 = o0.f69985a;
            String r111 = r109.get("activity_id");
            if (r111 == null) goto L17;
            Iterator<T> r112 = this.f142787a.Y90().iterator();
        L24:
            if (r112.hasNext() == false) goto L17;
            com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c r113 = (com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c) r112.next();
            if (Intrinsics.areEqual(r108.f69578c, r113.Ms()) == false) goto L24;
            ArrayList r114 = new ArrayList();
            LabelBannerUrl r115 = (LabelBannerUrl) r101.get(r111);
            if (r115 == null) goto L30;
            r114.add(r115);
        L30:
            Unit r116 = Unit.INSTANCE;
            r113.ok(r108, r113.ms(r114));
            goto L17
        L44:
            return;
        L42:
            return;
        L31:
            return;
        L43:
            return;
        L5:
            if (r101.isEmpty() == true) goto L8;
            r102 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.OrderFirstLevelTabFragment$initData$6, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass6 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass6();
        }

        public AnonymousClass6() {
            super(vb0.a.class, "isRequestRecommendApi", "isRequestRecommendApi()Ljava/lang/Boolean;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return ((vb0.a) r100).f554002i;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.OrderFirstLevelTabFragment$initData$8, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass8 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass8();
        }

        public AnonymousClass8() {
            super(vb0.a.class, "applyListenUnreadNum", "getApplyListenUnreadNum()Ljava/lang/Long;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return ((vb0.a) r100).f553995b;
        }
    }

    public static final class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderFirstLevelTabFragment f142788a;

        public j(OrderFirstLevelTabFragment r100) {
            this.f142788a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            OrderFirstLevelTabFragment r111 = this.f142788a;
            if (r111.f142778y > 0) goto L5;
        L7:
            r111.f142778y = System.currentTimeMillis();
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r100 = r111.f69627q;
            if (r100 == null) goto L10;
            y r101 = r100.getSelectedSecondLevelTabData(FirstLevelTab.OrderSongTab.getValue());
        L11:
            if (r101 == null) goto L14;
            List r102 = r101.f69583h;
            if (r102 == null) goto L14;
        L16:
            if (r102.isEmpty() == false) goto L18;
            f2.b(R.string.ttlive_ktv_play_all_already, 0);
            return;
        L18:
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r103 = r111.C;
            if (r103 != null) goto L21;
        L48:
            f2.b(R.string.ttlive_ktv_play_all_order_limit, 0);
            return;
        L21:
            if (r103.canSelectMore() != true) goto L48;
            ArrayList r104 = new ArrayList();
            Iterator r105 = r102.iterator();
        L25:
            if (r105.hasNext() == false) goto L30;
            MusicPanel r106 = (MusicPanel) r105.next();
            if (r106.f153578b != 1) goto L25;
            r104.add(r106);
            goto L25
        L30:
            if (r104.isEmpty() == false) goto L32;
            f2.b(R.string.ttlive_ktv_play_all_already, 0);
            return;
        L32:
            com.bytedance.android.livesdk.sharedpref.e<Boolean> r107 = com.bytedance.android.livesdk.sharedpref.c.f158281l;
            if (r107.getValue().booleanValue() == false) goto L45;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r108 = r111.C;
            if (r108 == null) goto L45;
            if (r108.isAudienceEnableSing() != true) goto L45;
            Context r109 = r111.getContext();
            x0.d r112 = new x0.d();
            r112.f162243b = r109;
            r112.f162242a = 0;
            r112.f162242a = 7;
            r112.f162244c = s1.B(R.string.ttlive_ktv_play_all_dialog_title);
            r112.f162245d = s1.B(R.string.ttlive_ktv_play_all_dialog_content);
            r112.f162254m = Float.valueOf(2.0f);
            String r113 = s1.B(R.string.ttlive_ktv_play_all_dialog_cancle);
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.g r114 = com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.g.f142804a;
            x0.c[] r115 = r112.f162248g;
            x0.c r116 = r115[1];
            if (r116 != null) goto L41;
            r116 = new x0.c();
            r115[1] = r116;
        L41:
            r116.f162239a = r113;
            r116.f162240b = r114;
            String r117 = s1.B(R.string.ttlive_ktv_play_all_dialog_confirm);
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.h r118 = new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.h(r111, r104, r101);
            x0.c[] r119 = r112.f162248g;
            x0.c r120 = r119[0];
            if (r120 != null) goto L44;
            r120 = new x0.c();
            r119[0] = r120;
        L44:
            r120.f162239a = r117;
            r120.f162240b = r118;
            r112.f162252k = true;
            x0.b.g(new x0(r112.f162243b, r112));
            com.bytedance.android.livesdk.sharedpref.f.d(r107, Boolean.FALSE);
            return;
        L45:
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r121 = r111.C;
            if (r121 == null) goto L59;
            r121.orderPlayAllSong(r104, r101);
            return;
        L59:
            return;
        L14:
            r102 = new ArrayList();
            goto L16
        L10:
            r101 = null;
            goto L11
        L5:
            if ((System.currentTimeMillis() - r111.f142778y) >= 3000) goto L7;
            f2.b(R.string.ttlive_ktv_play_all_time_limit, 0);
        }
    }

    static {
    }

    public OrderFirstLevelTabFragment() {
        this(null, null, null, null);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.CommonOrderFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final String aK() {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r100 = this.C;
        if (r100 == null) goto L5;
        ModeType r101 = r100.getModeType();
    L7:
        if (r101 == ModeType.MUSIC_EFFECT) goto L9;
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == true) goto L19;
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L19;
        if (jc0.a.c() == true) goto L19;
        return s1.B(R.string.ttlive_ktv_tab_sing_song);
    L19:
        return s1.B(R.string.ttlive_ktv_tab_select);
    L9:
        return s1.B(R.string.ttlive_effect_music_tab_name);
    L5:
        r101 = null;
        goto L7
    }

    public final void ha0() {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r100 = this.C;
        if (r100 == null) goto L6;
        r100.observeSecondLevelTabBanner(this, new i(this));
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment
    public final Function1<Context, CustomViewTab> W90() {
        return KSongOrderSongUtilKt.a();
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public final void initData() {
        super.initData();
        Disposable r100 = xs2.b.a().b(td2.a.class).subscribe(new b(this));
        if (r100 == null) goto L5;
        S90(r100);
    L5:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r101 = this.f69627q;
        if (r101 == null) goto L9;
        r101.observeSelectedFirstLevelTabValueChange(this, new c(this));
    L9:
        if (this.f69616f == false) goto L11;
        S90(Observable.timer(this.f69615e, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this)));
    L12:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r102 = this.D;
        if (r102 == null) goto L15;
        r102.observeHotWordListChange(this, new f(this));
    L15:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r103 = this.D;
        if (r103 == null) goto L18;
        r103.syncHotWords();
    L18:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r104 = this.C;
        if (r104 == null) goto L24;
        MutableLiveData<vb0.a> r105 = r104.getOrderSongUiState();
        if (r105 == null) goto L24;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r105, this, AnonymousClass6.INSTANCE, new g(this));
    L24:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L32;
        KtvContext.Companion.getClass();
        if (KtvContext.a.c(1) == false) goto L32;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r106 = this.C;
        if (r106 == null) goto L32;
        MutableLiveData<vb0.a> r107 = r106.getOrderSongUiState();
        if (r107 == null) goto L32;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r107, this, AnonymousClass8.INSTANCE, new h(this));
    L32:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r108 = this.C;
        if (r108 == null) goto L35;
        r108.observeCurOrderedMusic(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.e(this));
    L35:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r109 = this.C;
        if (r109 == null) goto L38;
        r109.observeCurFavoriteMusic(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.f(this));
    L38:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r110 = this.f69627q;
        ModeType r111 = null;
        if (r110 == null) goto L41;
        y r112 = r110.getSelectedSecondLevelTabData(FirstLevelTab.OrderSongTab.getValue());
    L42:
        ConstraintLayout r113 = this.f69643v;
        TextView r114 = this.f69644w;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r115 = this.C;
        if (r115 == null) goto L45;
        r111 = r115.getModeType();
    L45:
        KSongOrderSongUtilKt.g(r112, r113, r114, r111);
        return;
    L41:
        r112 = null;
        goto L42
    L11:
        ha0();
        goto L12
    }

    public static final void ga0(OrderFirstLevelTabFragment r100) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r101 = r100.f69627q;
        if (r101 == null) goto L8;
        y r102 = r101.getSelectedSecondLevelTabData(FirstLevelTab.OrderSongTab.getValue());
        if (r102 == null) goto L8;
        String r103 = r102.f69578c;
        if (r103 == null) goto L8;
    L9:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r104 = r100.D;
        if (r104 == null) goto L12;
        r104.updateExtraRequestData(new xb0.a(r103, 3));
    L12:
        CommonSearchContainer r105 = r100.A;
        if (r105 == null) goto L15;
        r105.f();
    L15:
        ConstraintLayout r106 = r100.f69640s;
        if (r106 == null) goto L18;
        r106.setVisibility(8);
    L18:
        FrameLayout r107 = r100.f69645x;
        if (r107 == null) goto L22;
        r107.setVisibility(0);
        return;
    L22:
        return;
    L8:
        r103 = "";
        goto L9
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment
    public final com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c T90(y r100) {
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
        int r101 = MusicListSecondLevelTabFragment.f142854x;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r102 = this.f69627q;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r103 = this.C;
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
        return new MusicListSecondLevelTabFragment(r100, r102, r103);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final void U50(boolean r100) {
        if (r100 == false) goto L15;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r101 = this.C;
        String r102 = null;
        if (r101 == null) goto L6;
        ModeType r103 = r101.getModeType();
    L7:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r104 = this.f69627q;
        FirstLevelTab r105 = FirstLevelTab.OrderSongTab;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r106 = this.C;
        if (r106 == null) goto L10;
        r102 = r106.getRequiredSongInfo();
    L10:
        KSongOrderSongUtilKt.o(r103, r104, r105, r102, false, null, 48);
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r107 = this.f69627q;
        if (r107 == null) goto L17;
        y r108 = r107.getSelectedSecondLevelTabData(r105.getValue());
        if (r108 == null) goto L18;
        ka0(r108);
        return;
    L18:
        return;
    L17:
        return;
    L6:
        r103 = null;
        goto L7
    L15:
        xs2.b.a().post(new td2.a("leave_order_song_tab"));
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment
    public final void ca0(y r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (ea0(r100) == true) goto L16;
        ConstraintLayout r101 = this.f69643v;
        TextView r102 = this.f69644w;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r103 = this.C;
        if (r103 == null) goto L9;
        ModeType r104 = r103.getModeType();
    L10:
        KSongOrderSongUtilKt.g(r100, r101, r102, r104);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r105 = this.C;
        if (r105 == null) goto L13;
        r105.updateCurrentTabData();
    L13:
        ka0(r100);
        return;
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment
    public final void da0(y r100) {
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
        if (r100.f69586k == FirstLevelTab.OrderSongTab.getValue()) goto L5;
        return;
    L5:
        y r101 = KSongOrderSongUtilKt.c(this.f69627q);
        ModeType r102 = null;
        if (r101 == null) goto L8;
        String r103 = r101.f69578c;
    L10:
        if (Intrinsics.areEqual(r103, r100.f69578c) == false) goto L16;
        ConstraintLayout r104 = this.f69643v;
        TextView r105 = this.f69644w;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r106 = this.C;
        if (r106 == null) goto L14;
        r102 = r106.getModeType();
    L14:
        KSongOrderSongUtilKt.g(r100, r104, r105, r102);
        return;
    L16:
        return;
    L8:
        r103 = null;
        goto L10
    }

    public final void ia0(View r100) {
        if (r100 == null) goto L6;
        final Context r101 = r100.getContext();
        if (r101 == null) goto L6;
        CommonSearchContainer r102 = new CommonSearchContainer((SearchOuterCallback) this.B.getValue(), r101, false, 28);
        r102.setGoFeedbackAction(new OrderFirstLevelTabFragment$initSearchContainer$$inlined$let$lambda$1(r101, this));
        UtilityKotlinExtentionsKt.t(r102);
    L7:
        this.A = r102;
        FrameLayout r103 = this.f69645x;
        if (r103 == null) goto L10;
        r103.removeAllViews();
    L10:
        CommonSearchContainer r104 = this.A;
        if (r104 == null) goto L15;
        FrameLayout r105 = this.f69645x;
        if (r105 == null) goto L15;
        r105.addView(r104);
    L15:
        FrameLayout r106 = this.f69645x;
        if (r106 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r106);
        return;
    L19:
        return;
    L6:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.CommonOrderFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public final void initView(View r100) {
        super.initView(r100);
        ConstraintLayout r101 = this.f69643v;
        if (r101 == null) goto L5;
        r101.setOnClickListener(new j(this));
    L5:
        Boolean r102 = null;
        DialogLoadingView r103 = new DialogLoadingView(requireContext(), null, 6, 0);
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(s1.f(100.0f), s1.f(90.0f));
        r104.leftToLeft = 0;
        r104.rightToRight = 0;
        r104.topToBottom = R.id.play_all;
        r104.bottomToBottom = 0;
        r103.setLayoutParams(r104);
        if ((r100 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r100).addView(r103);
    L9:
        if (KSongOrderSongUtilKt.j(this.f69627q, FirstLevelTab.OrderSongTab) == false) goto L18;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r105 = this.C;
        if (r105 == null) goto L17;
        MutableLiveData<vb0.a> r106 = r105.getOrderSongUiState();
        if (r106 == null) goto L17;
        vb0.a r107 = r106.getValue();
        if (r107 == null) goto L17;
        r102 = r107.f554002i;
    L17:
        r103.a(Intrinsics.areEqual(r102, Boolean.TRUE));
    L18:
        Unit r108 = Unit.INSTANCE;
        this.f142779z = r103;
        View r109 = this.f69641t;
        if (r109 == null) goto L21;
        KtvOrderSongThemeManager.c(r109, KtvOrderSongThemeManager.f70200i);
    L21:
        KtvTextSwitcher r110 = this.f69642u;
        if (r110 == null) goto L24;
        r110.setItems(new ArrayList());
    L24:
        KtvTextSwitcher r111 = this.f69642u;
        if (r111 == null) goto L27;
        r111.a(KtvOrderSongThemeManager.a(8));
    L27:
        KtvTextSwitcher r112 = this.f69642u;
        if (r112 == null) goto L30;
        r112.setTextSwitchClickListener(new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.i(this));
    L30:
        ConstraintLayout r113 = this.f69640s;
        if (r113 == null) goto L33;
        KtvOrderSongThemeManager.c(r113, KtvOrderSongThemeManager.f70199h);
    L33:
        ia0(r100);
    }

    public final void ja0(y r110) {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r100 = this.C;
        if (r100 == null) goto L7;
        MutableLiveData<vb0.a> r101 = r100.getOrderSongUiState();
        if (r101 == null) goto L7;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r101, OrderFirstLevelTabFragment$reLoadSongList$1.INSTANCE);
    L7:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r102 = this.f69627q;
        if (r102 == null) goto L19;
        long r103 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r104 = this.C;
        if (r104 == null) goto L12;
        ModeType r105 = r104.getModeType();
    L13:
        int r106 = KSongOrderSongUtilKt.f(r105);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r107 = this.C;
        if (r107 == null) goto L16;
        String r111 = r107.getRequiredSongInfo();
    L17:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b.a.b(r102, r103, true, 0, r106, r110, 0, 0, r111, new OrderFirstLevelTabFragment$reLoadSongList$2(this), 100);
        return;
    L16:
        r111 = null;
        goto L17
    L12:
        r105 = null;
        goto L13
    }

    public final void ka0(y r100) {
        KtvContext.Companion.getClass();
        if (KtvContext.a.c(1) == true) goto L5;
    L10:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r101 = this.C;
        if (r101 == null) goto L13;
        ModeType r102 = r101.getModeType();
    L15:
        if (r102 != ModeType.MUSIC_EFFECT) goto L18;
        ja0(r100);
    L18:
        if (KtvContext.a.k() == true) goto L20;
        return;
    L20:
        if (jc0.a.a() == true) goto L24;
        ja0(r100);
        return;
    L24:
        return;
    L13:
        r102 = null;
        goto L15
    L5:
        if (Intrinsics.areEqual(r100.f69578c, "recommend") == false) goto L10;
        KtvComponentContext r103 = KtvComponentContext.Companion.getContext();
        if (r103 == null) goto L9;
        r103.updateListenApplyUnreadCount(0);
    L9:
        ja0(r100);
        goto L10
    }

    public OrderFirstLevelTabFragment(String r100, final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r101, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r102, com.bytedance.android.live.ktv.common.search.viewmodel.a r103) {
        super(r100, r101);
        this.C = r102;
        this.D = r103;
        this.B = LazyKt.lazy(new OrderFirstLevelTabFragment$commonSearchOuterCallback$2(this, r101));
    }
}
