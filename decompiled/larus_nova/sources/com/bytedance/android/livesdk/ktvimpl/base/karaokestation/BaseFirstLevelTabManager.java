package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.OrderSongRequiredConfig;
import com.bytedance.android.live.ktv.common.karaokestation.model.SecondLevelTabViewSelectedType;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.u;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.model.KtvMode;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdk.config.jg0;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfigData;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseFirstLevelTabManager;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/e;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroid/content/Context;", ce.f26395j, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseFirstLevelTabManager implements e, LifecycleOwnerCompat {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f142537o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f142538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f142539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<FirstLevelTab, Integer> f142540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f142541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TabLayout f142542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LifecycleRegistry f142543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f142544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f142545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f142546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f142547j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b f142548k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.search.viewmodel.a f142549l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d f142550m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a f142551n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFirstLevelTabManager f142552a;

        public b(BaseFirstLevelTabManager r100) {
            this.f142552a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            if (ChorusContext.Companion.c() == true) goto L13;
            BaseFirstLevelTabManager r102 = this.f142552a;
            FirstLevelTab r103 = FirstLevelTab.OrderedSongTab;
            OrderedSongDataContext r104 = r102.f142550m.getOrderedSongDataContext();
            if (r104 == null) goto L10;
            List<SongUniqueInfo> r105 = r104.getKtvPublicSongUniqueInfoList();
            if (r105 == null) goto L10;
            int r106 = r105.size();
        L11:
            r102.u(r103, r106);
            return;
        L10:
            r106 = 0;
            goto L11
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFirstLevelTabManager f142553a;

        public c(BaseFirstLevelTabManager r100) {
            this.f142553a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            if (ChorusContext.Companion.c() == false) goto L11;
            List r102 = (List) sh6.c.b(r101);
            if (r102 == null) goto L8;
            int r103 = r102.size();
        L9:
            this.f142553a.u(FirstLevelTab.OrderedSongTab, r103);
            return;
        L8:
            r103 = 0;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFirstLevelTabManager f142554a;

        public d(BaseFirstLevelTabManager r100) {
            this.f142554a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            BaseFirstLevelTabManager r102 = this.f142554a;
            FirstLevelTab r103 = FirstLevelTab.MySongTab;
            int r104 = BaseFirstLevelTabManager.f142537o;
            if (r102.p() == false) goto L5;
            long r105 = 1L;
        L6:
            r102.v(r103, r105);
            return;
        L5:
            r105 = 0L;
            goto L6
        }
    }

    static {
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public final List<String> l() {
        return (List) this.f142538a.getValue();
    }

    public abstract LiveKtvFirstLevelTabConfigData m();

    public final List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a> o() {
        return (List) this.f142539b.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final void clearData() {
        this.f142543f.setCurrentState(Lifecycle.State.DESTROYED);
        ((CompositeDisposable) this.f142541d.getValue()).clear();
        this.f142542e = null;
        o().clear();
    }

    public void e() {
        this.f142543f.setCurrentState(Lifecycle.State.STARTED);
        FirstLevelTab r100 = FirstLevelTab.MySongTab;
        if (p() == false) goto L5;
        long r101 = 1L;
    L6:
        v(r100, r101);
        FirstLevelTab r102 = FirstLevelTab.OrderedSongTab;
        Integer r103 = KSongOrderSongUtilKt.e(this.f142550m);
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        u(r102, r104);
        return;
    L9:
        r104 = 0;
        goto L10
    L5:
        r101 = 0L;
        goto L6
    }

    public final Function1<List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> f() {
        return new BaseFirstLevelTabManager$bindFirstLevelTabFragmentAction$1(this);
    }

    public final Function3<String, TabLayout, Context, Unit> h() {
        return new BaseFirstLevelTabManager$fillCustomTabAction$1(this);
    }

    public final Function0<Unit> i() {
        return new BaseFirstLevelTabManager$fillFirstLevelTabArrayListAction$1(this);
    }

    public final Function3<Integer, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> j() {
        return new BaseFirstLevelTabManager$firstLevelTabPageSelectedAction$1(this);
    }

    public final boolean p() {
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r100 = this.f142551n;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.hasNewKtvDress() != true) goto L7;
        return true;
    }

    public final Function5<HSImageView, Function0<Unit>, FragmentActivity, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> r() {
        return new BaseFirstLevelTabManager$initBusinessEntryAction$1(this);
    }

    public void s() {
        this.f142543f.setCurrentState(Lifecycle.State.CREATED);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r100 = this.f142550m;
        if (r100 == null) goto L9;
        OrderedSongDataContext r101 = r100.getOrderedSongDataContext();
        if (r101 == null) goto L9;
        Disposable r102 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r101, null, new b(this), 3);
        if (r102 == null) goto L9;
        RxUtilKt.c(r102, (CompositeDisposable) this.f142541d.getValue());
    L9:
        ChorusContext r103 = ChorusContext.Companion.getContext();
        if (r103 == null) goto L18;
        n<List<MusicPanel>> r104 = r103.getChorusSelectedSongList();
        if (r104 == null) goto L18;
        Observable<sh6.b<List<MusicPanel>>> r105 = r104.a();
        if (r105 == null) goto L18;
        Disposable r106 = r105.subscribe(new c(this));
        if (r106 == null) goto L18;
        RxUtilKt.c(r106, (CompositeDisposable) this.f142541d.getValue());
    L18:
        KtvContext.Companion.getClass();
        Disposable r107 = KtvContext.a.g().getKtvAddDressVersion().a().subscribe(new d(this));
        if (r107 == null) goto L22;
        RxUtilKt.c(r107, (CompositeDisposable) this.f142541d.getValue());
        return;
    }

    public final Function0<Unit> t() {
        return new BaseFirstLevelTabManager$postFillCustomTabAction$1(this);
    }

    public final Function0<Unit> w() {
        return new BaseFirstLevelTabManager$selectDefaultFirstLevelTabAction$1(this);
    }

    public final Function3<View, TabLayout, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> x() {
        return new BaseFirstLevelTabManager$setCartAnimAction$1(this);
    }

    public final Function3<Integer, HSImageView, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> y() {
        return new BaseFirstLevelTabManager$showBusinessEntryIfNeedAction$1(this);
    }

    public final Function0<Unit> z() {
        return new BaseFirstLevelTabManager$syncOrderedSongListAction$1(this);
    }

    public final Context getContext() {
        return this.f142547j;
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return this.f142543f;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public com.bytedance.android.live.ktv.common.karaokestation.model.a b(Function0<Unit> r210) {
        return new com.bytedance.android.live.ktv.common.karaokestation.model.a(new OrderSongRequiredConfig(this.f142548k, new BaseFirstLevelTabManager$fillCustomTabAction$1(this), new BaseFirstLevelTabManager$fillFirstLevelTabArrayListAction$1(this), new BaseFirstLevelTabManager$bindFirstLevelTabFragmentAction$1(this)), new u(new BaseFirstLevelTabManager$postFillCustomTabAction$1(this), new BaseFirstLevelTabManager$setCartAnimAction$1(this), new BaseFirstLevelTabManager$selectDefaultFirstLevelTabAction$1(this), new BaseFirstLevelTabManager$syncOrderedSongListAction$1(this), new BaseFirstLevelTabManager$firstLevelTabPageSelectedAction$1(this), new BaseFirstLevelTabManager$showBusinessEntryIfNeedAction$1(this), new BaseFirstLevelTabManager$initBusinessEntryAction$1(this), null, false, null, null, null, null, null, null, 65408));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final void a(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "secondLevelTabName");
        Iterator<T> r100 = o().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r100.next()).O0();
        goto L4
    L6:
        Pair<Integer, String> r112 = k(r110, r111);
        int r113 = r112.component1().intValue();
        String r114 = r112.component2();
        FirstLevelTab[] r101 = FirstLevelTab.values();
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L16;
        FirstLevelTab r104 = r101[r103];
        if (r113 != r104.getValue()) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L17;
        r103 = r103 + 1;
    L17:
        if (r104 != null) goto L19;
        r104 = FirstLevelTab.OrderSongTab;
    L19:
        FirstLevelTab r115 = r104;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r106 = this.f142550m;
        if (r106 == null) goto L22;
        ModeType r107 = r106.getModeType();
    L23:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r108 = this.f142548k;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r109 = this.f142550m;
        if (r109 == null) goto L26;
        String r116 = r109.getRequiredSongInfo();
    L27:
        KSongOrderSongUtilKt.o(r107, r108, r115, r116, false, r114, 16);
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r117 = this.f142548k;
        if (r117 == null) goto L30;
        r117.updateSelectFirstLevelTabValue(r115.getValue(), UpdateTabType.DEFAULT);
    L30:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r118 = this.f142548k;
        if (r118 == null) goto L34;
        y r119 = r118.getSecondLevelTabDataByParams(r115.getValue(), r114);
        if (r119 == null) goto L34;
    L38:
        Iterator<T> r120 = o().iterator();
    L40:
        if (r120.hasNext() == false) goto L47;
        Object r121 = r120.next();
        if (((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r121).VL().getValue() != r115.getValue()) goto L44;
        boolean r122 = true;
    L45:
        if (r122 == false) goto L40;
    L48:
        com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a r123 = (com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r121;
        if (r123 == null) goto L52;
        r123.Tq(r119, SecondLevelTabViewSelectedType.Default);
    L52:
        if (this.f142545h == null) goto L55;
        this.f142545h = null;
    L55:
        if (this.f142546i == null) goto L66;
        this.f142546i = null;
        return;
    L66:
        return;
    L44:
        r122 = false;
        goto L45
    L47:
        r121 = null;
    L34:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r124 = this.f142548k;
        if (r124 == null) goto L37;
        r119 = r124.getSelectedSecondLevelTabData(r115.getValue());
        goto L38
    L37:
        r119 = null;
        goto L38
    L26:
        r116 = null;
        goto L27
    L22:
        r107 = null;
        goto L23
    L12:
        r105 = false;
        goto L13
    L16:
        r104 = null;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final void c(Integer r100, String r101) {
        this.f142545h = r100;
        this.f142546i = r101;
    }

    public final boolean g(int r100, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a> r101) {
        int r102 = ((Number) h.F0.getValue(null, h.f556082a[82])).intValue();
        if (((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) ListProtector.get(r101, r100)).VL().getValue() != FirstLevelTab.OrderedSongTab.getValue()) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (bb0.b.a() == KtvMode.LIVE_KTV) goto L12;
    L32:
        return false;
    L12:
        if (j.i() == true) goto L32;
        DataCenter r104 = (DataCenter) this.f142544g.getValue();
        if (r104 == null) goto L21;
        Integer r105 = (Integer) r104.get("data_link_state", 0);
        if (r105 == null) goto L21;
        int r106 = r105.intValue();
        boolean r107 = v.a(r106, 4);
        boolean r108 = v.a(r106, 64);
        if (r107 == true) goto L20;
        if (r108 == false) goto L21;
    L20:
        boolean r109 = true;
    L22:
        if (r109 == true) goto L32;
        if (r102 <= 0) goto L32;
        if (r103 == false) goto L32;
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L32;
        if (jg0.f120524a.getValue().intValue() <= 0) goto L32;
        if (jc0.a.c() == true) goto L32;
        return true;
    L21:
        r109 = false;
        goto L22
    L5:
        if (((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) ListProtector.get(r101, r100)).VL().getValue() == FirstLevelTab.OrderSongTab.getValue()) goto L8;
        r103 = false;
        goto L10
    }

    public Pair<Integer, String> k(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "secondLevelTabName");
        Integer r102 = this.f142545h;
        if (r102 == null) goto L5;
        r100 = r102.intValue();
    L5:
        String r103 = this.f142546i;
        if (r103 == null) goto L10;
        r101 = r103;
    L10:
        return new Pair(Integer.valueOf(r100), r101);
    }

    public final void u(FirstLevelTab r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "firstLevelTab");
        Iterator<T> r102 = o().iterator();
    L3:
        Object r103 = null;
        if (r102.hasNext() == false) goto L11;
        Object r104 = r102.next();
        if (((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r104).VL().getValue() != r100.getValue()) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L3;
    L12:
        com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a r106 = (com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r104;
        if (r106 == null) goto L16;
        String r107 = r106.aK();
        if (r107 == null) goto L16;
    L17:
        if (r101 == 0) goto L22;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.f143561l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.i() == true) goto L22;
        r107 = r107 + ' ' + r101;
    L22:
        TabLayout r108 = this.f142542e;
        if (r108 == null) goto L31;
        Integer r109 = (Integer) ((LinkedHashMap) this.f142540c).get(r100);
        if (r109 == null) goto L27;
        int r110 = r109.intValue();
    L28:
        TabLayout.Tab r111 = r108.getTabAt(r110);
        if (r111 == null) goto L31;
        View r112 = r111.getCustomView();
    L33:
        if ((r112 instanceof kb0.a) == false) goto L36;
        r103 = r112;
    L36:
        kb0.a r113 = (kb0.a) r103;
        if (r113 == null) goto L45;
        r113.setTabName(r107);
        return;
    L45:
        return;
    L27:
        r110 = -1;
    L31:
        r112 = null;
    L16:
        r107 = "";
        goto L17
    L8:
        r105 = false;
        goto L9
    L11:
        r104 = null;
        goto L12
    }

    public final void v(FirstLevelTab r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "firstLevelTab");
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L6:
        int r103 = -1;
        Object r104 = null;
        if (r102 <= 0) goto L24;
        TabLayout r105 = this.f142542e;
        if (r105 == null) goto L16;
        Integer r106 = (Integer) ((LinkedHashMap) this.f142540c).get(r100);
        if (r106 == null) goto L13;
        r103 = r106.intValue();
    L13:
        TabLayout.Tab r107 = r105.getTabAt(r103);
        if (r107 == null) goto L16;
        View r108 = r107.getCustomView();
    L18:
        if ((r108 instanceof kb0.a) == false) goto L21;
        r104 = r108;
    L21:
        kb0.a r109 = (kb0.a) r104;
        if (r109 == null) goto L41;
        r109.G5(0);
        return;
    L41:
        return;
    L16:
        r108 = null;
        goto L18
    L24:
        TabLayout r110 = this.f142542e;
        if (r110 == null) goto L32;
        Integer r111 = (Integer) ((LinkedHashMap) this.f142540c).get(r100);
        if (r111 == null) goto L29;
        r103 = r111.intValue();
    L29:
        TabLayout.Tab r112 = r110.getTabAt(r103);
        if (r112 == null) goto L32;
        View r113 = r112.getCustomView();
    L34:
        if ((r113 instanceof kb0.a) == false) goto L37;
        r104 = r113;
    L37:
        kb0.a r114 = (kb0.a) r104;
        if (r114 == null) goto L43;
        r114.G5(8);
        return;
    L43:
        return;
    L32:
        r113 = null;
        goto L34
    L5:
        r102 = 0;
        goto L6
    }

    public BaseFirstLevelTabManager(Integer r100, String r101, Context r102, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r103, com.bytedance.android.live.ktv.common.search.viewmodel.a r104, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r105, com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r106) {
        this.f142545h = r100;
        this.f142546i = r101;
        this.f142547j = r102;
        this.f142548k = r103;
        this.f142549l = r104;
        this.f142550m = r105;
        this.f142551n = r106;
        this.f142538a = LazyKt.lazy(BaseFirstLevelTabManager$firstLevelTabArrayList$2.INSTANCE);
        this.f142539b = LazyKt.lazy(BaseFirstLevelTabManager$firstLevelTabFragmentList$2.INSTANCE);
        this.f142540c = new LinkedHashMap();
        this.f142541d = LazyKt.lazy(BaseFirstLevelTabManager$compositeDisposable$2.INSTANCE);
        this.f142543f = new LifecycleRegistry(this);
        this.f142544g = LazyKt.lazy(BaseFirstLevelTabManager$dataCenter$2.INSTANCE);
    }
}
