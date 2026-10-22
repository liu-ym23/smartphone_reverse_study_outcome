package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.PlaylistTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.CommonMineFirstLevelTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CustomSecondLevelTabFragment;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.ordersong.view.DialogLoadingView;
import com.bytedance.android.live.ktv.common.ordersong.view.SongTextSwitcher;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.MusicListSecondLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.skin.KtvDressWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.ttvideoengine.model.VideoRef;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/firstleveltab/MineFirstLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/CommonMineFirstLevelTabFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MineFirstLevelTabFragment extends CommonMineFirstLevelTabFragment {
    public static final /* synthetic */ int G = 0;
    public final Lazy A;
    public DialogLoadingView B;
    public b C;
    public final ArrayList<String> D;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d E;
    public final com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a F;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f142767x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public WidgetManager f142768y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f142769z;

    public static final class a {
    }

    public static final class b extends ka0.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f142770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final WeakReference<FrameLayout> f142771d;

        @Override // ka0.b
        public final void a(HybridCard r100, String r101) {
            StringCompanionObject r102 = StringCompanionObject.INSTANCE;
            ALogger.e("BannerWidget", String.format("initYourselfInfoView, onLoadFailed failed, infoLynxUrl: %s, errMsg: %s", Arrays.copyOf(new Object[]{this.f142770c, r101}, 2)));
            FrameLayout r103 = this.f142771d.get();
            if (r103 == null) goto L6;
            r103.setVisibility(8);
            return;
        }

        @Override // ka0.b
        public final void b(HybridCard r100, View r101, int r102) {
            StringCompanionObject r103 = StringCompanionObject.INSTANCE;
            ALogger.i("BannerWidget", String.format("initYourselfInfoView, onViewCreated success, infoLynxUrl: %s", Arrays.copyOf(new Object[]{this.f142770c}, 1)));
            FrameLayout r104 = this.f142771d.get();
            if (r104 == null) goto L5;
            r104.removeAllViews();
        L5:
            if (r104 == null) goto L7;
            r104.addView(r100);
        L7:
            if (r104 == null) goto L10;
            r104.setVisibility(0);
            return;
        }

        public b(Context r100, Uri r101, int r102, String r103, WeakReference<FrameLayout> r104) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "originUri");
            Intrinsics.checkNotNullParameter(r103, "infoLynxUrl");
            Intrinsics.checkNotNullParameter(r104, "lynxContainer");
            super(r100, r101, r102);
            this.f142770c = r103;
            this.f142771d = r104;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MineFirstLevelTabFragment f142772a;

        public static final class a<T> implements Observer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f142773a;

            public a(c r100) {
                this.f142773a = r100;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object r100) {
                String r101 = (String) r100;
                MineFirstLevelTabFragment r102 = this.f142773a.f142772a;
                if (r101 != null) goto L5;
                r101 = "";
            L5:
                MineFirstLevelTabFragment.ga0(r102, r101);
            }
        }

        public c(MineFirstLevelTabFragment r100) {
            this.f142772a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r100 = this.f142772a.E;     // Catch: Throwable -> L11
            if (r100 == null) goto L5;
            r100.syncHighScoreSongList(true);     // Catch: Throwable -> L11
        L5:
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r101 = this.f142772a.E;     // Catch: Throwable -> L11
            if (r101 == null) goto L14;
            MutableLiveData<vb0.a> r102 = r101.getOrderSongUiState();     // Catch: Throwable -> L11
            if (r102 == null) goto L18;
            com.bytedance.android.livesdk.ktvapi.util.d.a(r102, this.f142772a, MineFirstLevelTabFragment$initData$1$1.INSTANCE, new a(this));     // Catch: Throwable -> L11
            return;
        L18:
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MineFirstLevelTabFragment f142774a;

        public d(MineFirstLevelTabFragment r100) {
            this.f142774a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            MineFirstLevelTabFragment r102 = this.f142774a;
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            MineFirstLevelTabFragment.ga0(r102, r101);
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MineFirstLevelTabFragment f142775a;

        public e(MineFirstLevelTabFragment r100) {
            this.f142775a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            MineFirstLevelTabFragment r102 = this.f142775a;
            int r103 = MineFirstLevelTabFragment.G;
            if (KSongOrderSongUtilKt.j(r102.f69627q, FirstLevelTab.MySongTab) == false) goto L8;
            DialogLoadingView r104 = this.f142775a.B;
            if (r104 == null) goto L9;
            r104.a(Intrinsics.areEqual(r101, Boolean.TRUE));
            return;
        L9:
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MineFirstLevelTabFragment f142776a;

        public f(MineFirstLevelTabFragment r100) {
            this.f142776a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            if (r101 == null) goto L14;
            int r102 = ((Number) r101.component1()).intValue();
            this.f142776a.getClass();
            FirstLevelTab r103 = FirstLevelTab.MySongTab;
            if (r102 != r103.getValue()) goto L13;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r104 = this.f142776a.f69627q;
            if (r104 == null) goto L10;
            y r105 = r104.getSelectedSecondLevelTabData(r103.getValue());
        L11:
            this.f142776a.ca0(r105);
            return;
        L10:
            r105 = null;
            goto L11
        L13:
            return;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MineFirstLevelTabFragment f142777a;

        public g(MineFirstLevelTabFragment r100) {
            this.f142777a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            MineFirstLevelTabFragment r111 = this.f142777a;
            if (r111.f142769z > 0) goto L5;
        L7:
            r111.f142769z = System.currentTimeMillis();
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r100 = r111.f69627q;
            if (r100 == null) goto L10;
            y r101 = r100.getSelectedSecondLevelTabData(FirstLevelTab.MySongTab.getValue());
        L11:
            if (r101 == null) goto L14;
            List r102 = r101.f69583h;
            if (r102 == null) goto L14;
        L16:
            if (r102.isEmpty() == false) goto L18;
            f2.b(R.string.ttlive_ktv_play_all_already, 0);
            return;
        L18:
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r103 = r111.E;
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
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r108 = r111.E;
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
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.c r114 = com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.c.f142798a;
            x0.c[] r115 = r112.f162248g;
            x0.c r116 = r115[1];
            if (r116 != null) goto L41;
            r116 = new x0.c();
            r115[1] = r116;
        L41:
            r116.f162239a = r113;
            r116.f162240b = r114;
            String r117 = s1.B(R.string.ttlive_ktv_play_all_dialog_confirm);
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.d r118 = new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.d(r111, r104, r101);
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
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r121 = r111.E;
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
            if ((System.currentTimeMillis() - r111.f142769z) >= 3000) goto L7;
            f2.b(R.string.ttlive_ktv_play_all_time_limit, 0);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.MineFirstLevelTabFragment$initData$2, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass2 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(vb0.a.class, "infoLynxUrl", "getInfoLynxUrl()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return ((vb0.a) r100).f554000g;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.MineFirstLevelTabFragment$initData$4, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass4 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass4();
        }

        public AnonymousClass4() {
            super(vb0.a.class, "isRequestRecommendApi", "isRequestRecommendApi()Ljava/lang/Boolean;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return ((vb0.a) r100).f554002i;
        }
    }

    static {
    }

    public MineFirstLevelTabFragment() {
        this(null, null, null, null);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment
    public final Function1<Context, CustomViewTab> W90() {
        return KSongOrderSongUtilKt.a();
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public final void initData() {
        super.initData();
        SongTextSwitcher r100 = this.f69636t;
        if (r100 == null) goto L5;
        KtvOrderSongThemeManager.d(r100, 10);
    L5:
        SongTextSwitcher r101 = this.f69636t;
        if (r101 == null) goto L8;
        r101.setSwitcherTextList(this.D);
    L8:
        SongTextSwitcher r102 = this.f69636t;
        if (r102 == null) goto L15;
        String r103 = (String) CollectionsKt.firstOrNull(this.D);
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        r102.y(r103);
    L15:
        if (KtvUtilsKt.v() == true) goto L39;
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L39;
        if (jc0.a.c() == true) goto L39;
        t61 r104 = com.bytedance.android.livesdk.ktvimpl.base.util.f.a();
        if (r104 != null) goto L23;
    L31:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r105 = this.E;
        if (r105 == null) goto L34;
        r105.syncHighScoreSongList(true);
    L34:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r106 = this.E;
        if (r106 == null) goto L39;
        MutableLiveData<vb0.a> r107 = r106.getOrderSongUiState();
        if (r107 == null) goto L39;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r107, this, AnonymousClass2.INSTANCE, new d(this));
        goto L39
    L23:
        if (u61.a(r104) != true) goto L31;
        FrameLayout r108 = this.f69617g;
        if (r108 == null) goto L39;
        c r109 = new c(this);
        t61 r110 = com.bytedance.android.livesdk.ktvimpl.base.util.f.a();
        if (r110 == null) goto L29;
        long r111 = r110.a3();
    L30:
        r108.postDelayed(r109, r111);
        goto L39
    L29:
        r111 = 1000;
    L39:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r112 = this.E;
        if (r112 == null) goto L44;
        MutableLiveData<vb0.a> r113 = r112.getOrderSongUiState();
        if (r113 == null) goto L44;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r113, this, AnonymousClass4.INSTANCE, new e(this));
    L44:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r114 = this.f69627q;
        if (r114 == null) goto L47;
        r114.observeSelectedFirstLevelTabValueChange(this, new f(this));
    L47:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r115 = this.E;
        if (r115 == null) goto L50;
        r115.observeCurOrderedMusic(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.a(this));
    L50:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r116 = this.E;
        if (r116 == null) goto L53;
        r116.observeCurFavoriteMusic(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.b(this));
    L53:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r117 = this.f69627q;
        ModeType r118 = null;
        if (r117 == null) goto L56;
        y r119 = r117.getSelectedSecondLevelTabData(FirstLevelTab.MySongTab.getValue());
    L57:
        ConstraintLayout r120 = this.f69637u;
        TextView r121 = this.f69638v;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r122 = this.E;
        if (r122 == null) goto L60;
        r118 = r122.getModeType();
    L60:
        KSongOrderSongUtilKt.g(r119, r120, r121, r118);
        ha0(r119);
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L63;
    L64:
        FrameLayout r123 = this.f69635s;
        if (r123 == null) goto L69;
        r123.setVisibility(8);
        return;
    L69:
        return;
    L63:
        if (jc0.a.c() == true) goto L64;
        return;
    L56:
        r119 = null;
        goto L57
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        WidgetManager r100 = this.f142768y;
        if (r100 == null) goto L5;
        r100.unload((KtvDressWidget) this.A.getValue());
    L5:
        FrameLayout r101 = this.f69635s;
        if (r101 == null) goto L8;
        r101.removeAllViews();
    L8:
        b r102 = this.C;
        if (r102 == null) goto L11;
        r102.release();
    L11:
        this.C = null;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment
    public final com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c T90(y r100) {
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
        if (r100.f69582g != PlaylistTabType.TAB_TYPE_DRESS_LIST.getValue()) goto L6;
        int r101 = CustomSecondLevelTabFragment.f69693k;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r102 = this.f69627q;
        Function3<Fragment, FrameLayout, View, Unit> r103 = new MineFirstLevelTabFragment$createSecondLevelTabFragment$1(this);
        Function2<Integer, String, Unit> r104 = new MineFirstLevelTabFragment$createSecondLevelTabFragment$2(this);
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
        return new CustomSecondLevelTabFragment(r102, r100, r103, null, r104);
    L6:
        int r105 = MusicListSecondLevelTabFragment.f142854x;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r106 = this.f69627q;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r107 = this.E;
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
        return new MusicListSecondLevelTabFragment(r100, r106, r107);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final void U50(boolean r100) {
        if (r100 == false) goto L14;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r101 = this.E;
        if (r101 == null) goto L6;
        ModeType r102 = r101.getModeType();
    L7:
        KSongOrderSongUtilKt.o(r102, this.f69627q, FirstLevelTab.MySongTab, null, false, null, 56);
        if (KtvUtilsKt.v() == true) goto L15;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r103 = this.E;
        if (r103 == null) goto L12;
        r103.syncHighScoreSongList(false);
    L12:
        int r104 = com.bytedance.android.live.ktv.common.util.i.f70690a;
        JSONObject r105 = new JSONObject();
        r105.put("eventName", "event_ktv_personal_card_show");
        ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).sendEventToAllJsBridges("H5_webcastNotification", r105);
        return;
    L15:
        return;
    L6:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment
    public final y X90(String r100) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r101 = this.f69627q;
        boolean r102 = true;
        y r103 = null;
        Object r104 = null;
        r103 = null;
        if (r101 == null) goto L16;
        List<y> r105 = r101.getSecondLevelTabDataList(FirstLevelTab.MySongTab.getValue());
        if (r105 == null) goto L16;
        Iterator<T> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L15;
        Object r107 = r106.next();
        if (((y) r107).f69582g != PlaylistTabType.TAB_TYPE_DRESS_LIST.getValue()) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == false) goto L8;
        r104 = r107;
        goto L15
    L12:
        r108 = false;
    L15:
        r103 = (y) r104;
    L16:
        if (r103 == null) goto L26;
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r109 = this.F;
        if (r109 != null) goto L20;
    L22:
        r102 = false;
    L23:
        if (r102 == false) goto L26;
        return r103;
    L20:
        if (r109.hasNewKtvDress() != true) goto L22;
    L26:
        return super.X90(r100);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment
    public final void ca0(y r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (ea0(r110) == false) goto L8;
        return;
    L8:
        if (r110.f69582g != PlaylistTabType.TAB_TYPE_DRESS_LIST.getValue()) goto L12;
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r100 = this.F;
        if (r100 == null) goto L12;
        r100.getPageDressList();
    L12:
        ModeType r111 = null;
        if (Intrinsics.areEqual(r110.f69578c, "recently") == false) goto L15;
    L16:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r101 = this.E;
        if (r101 == null) goto L21;
        MutableLiveData<vb0.a> r102 = r101.getOrderSongUiState();
        if (r102 == null) goto L21;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r102, MineFirstLevelTabFragment$onSecondLevelTabSelected$1.INSTANCE);
    L21:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r103 = this.f69627q;
        if (r103 == null) goto L28;
        long r104 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r105 = this.E;
        if (r105 == null) goto L26;
        ModeType r106 = r105.getModeType();
    L27:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b.a.b(r103, r104, true, 0, KSongOrderSongUtilKt.f(r106), r110, 0, 0, null, new MineFirstLevelTabFragment$onSecondLevelTabSelected$2(this), VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2);
        goto L28
    L26:
        r106 = null;
    L28:
        ConstraintLayout r107 = this.f69637u;
        TextView r108 = this.f69638v;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r109 = this.E;
        if (r109 == null) goto L31;
        r111 = r109.getModeType();
    L31:
        KSongOrderSongUtilKt.g(r110, r107, r108, r111);
        ha0(r110);
        return;
    L15:
        if (Intrinsics.areEqual(r110.f69578c, "favorite") == false) goto L28;
        goto L16
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment
    public final void da0(y r100) {
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
        if (r100.f69586k == FirstLevelTab.MySongTab.getValue()) goto L5;
        return;
    L5:
        y r101 = KSongOrderSongUtilKt.c(this.f69627q);
        ModeType r102 = null;
        if (r101 == null) goto L8;
        String r103 = r101.f69578c;
    L10:
        if (Intrinsics.areEqual(r103, r100.f69578c) == false) goto L16;
        ConstraintLayout r104 = this.f69637u;
        TextView r105 = this.f69638v;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r106 = this.E;
        if (r106 == null) goto L14;
        r102 = r106.getModeType();
    L14:
        KSongOrderSongUtilKt.g(r100, r104, r105, r102);
    L16:
        if (this.f142767x == true) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(r100.f69578c, "recently") == false) goto L22;
        this.f142767x = false;
        ha0(r100);
        return;
    L22:
        return;
    L8:
        r103 = null;
        goto L10
    }

    public final void ha0(final y r100) {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r101 = this.E;
        String r102 = null;
        if (r101 == null) goto L5;
        Boolean r103 = Boolean.valueOf(r101.checkMidiDataInRecentlyLabel(r100));
    L6:
        if (r100 == null) goto L9;
        r102 = r100.f69578c;
    L9:
        if (Intrinsics.areEqual(r102, "recently") == true) goto L11;
    L25:
        SongTextSwitcher r104 = this.f69636t;
        if (r104 == null) goto L31;
        r104.setVisibility(8);
        return;
    L31:
        return;
    L11:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L25;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r105 = this.E;
        if (r105 == null) goto L19;
        String r106 = r105.getCurSortType();
        if (r106 == null) goto L19;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r107 = this.E;
        if (r107 == null) goto L19;
        r107.sortSecondLevelTabByType(r106, r100);
    L19:
        SongTextSwitcher r108 = this.f69636t;
        if (r108 == null) goto L22;
        r108.setOnTextSelectedListener(new MineFirstLevelTabFragment$checkMidiDataChange$2(this, r100));
    L22:
        SongTextSwitcher r109 = this.f69636t;
        if (r109 == null) goto L29;
        r109.setVisibility(0);
        return;
    L29:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.CommonMineFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public final void initView(View r100) {
        super.initView(r100);
        SongTextSwitcher r101 = this.f69636t;
        if (r101 == null) goto L5;
        r101.setOnWindowStateListener(new AnonymousClass1(this));
    L5:
        ConstraintLayout r102 = this.f69637u;
        if (r102 == null) goto L8;
        r102.setOnClickListener(new g(this));
    L8:
        ViewGroup.LayoutParams r103 = null;
        DialogLoadingView r104 = new DialogLoadingView(requireContext(), null, 6, 0);
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(-1, -1);
        r105.gravity = 17;
        r104.setLayoutParams(r105);
        FrameLayout r106 = this.f69617g;
        if (r106 == null) goto L12;
        r106.addView(r104);
    L12:
        if (KSongOrderSongUtilKt.j(this.f69627q, FirstLevelTab.MySongTab) == false) goto L22;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r107 = this.E;
        if (r107 == null) goto L20;
        MutableLiveData<vb0.a> r108 = r107.getOrderSongUiState();
        if (r108 == null) goto L20;
        vb0.a r109 = r108.getValue();
        if (r109 == null) goto L20;
        Boolean r110 = r109.f554002i;
    L21:
        r104.a(Intrinsics.areEqual(r110, Boolean.TRUE));
    L20:
        r110 = null;
    L22:
        Unit r111 = Unit.INSTANCE;
        this.B = r104;
        FrameLayout r112 = this.f69635s;
        if (r112 == null) goto L25;
        r103 = r112.getLayoutParams();
    L25:
        if (r103 == null) goto L27;
        r103.height = (int) (((s1.y() - s1.e(32.0f)) / 343) * 80);
    L27:
        FrameLayout r113 = this.f69635s;
        if (r113 == null) goto L31;
        r113.setLayoutParams(r103);
        return;
    }

    public static final void ga0(MineFirstLevelTabFragment r100, String r101) {
        r100.getClass();
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L5;
        return;
    L5:
        if (jc0.a.c() == true) goto L13;
        Context r102 = r100.getContext();
        if (r102 == null) goto L12;
        b r103 = new b(r102, x6.a.d(r101), s1.y(), r101, new WeakReference(r100.f69635s));
        r100.C = r103;
        r103.loadUrl(r101);
        return;
    L12:
        return;
    }

    public MineFirstLevelTabFragment(String r100, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r101, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r102, com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r103) {
        super(r100, r101);
        this.E = r102;
        this.F = r103;
        this.f142767x = true;
        this.A = LazyKt.lazy(new MineFirstLevelTabFragment$mKtvDressWidget$2(this));
        ArrayList<String> r104 = new ArrayList();
        r104.add(com.bytedance.android.live.ktv.common.util.f.f70688b);
        r104.add(com.bytedance.android.live.ktv.common.util.f.f70687a);
        Unit r105 = Unit.INSTANCE;
        this.D = r104;
    }
}
