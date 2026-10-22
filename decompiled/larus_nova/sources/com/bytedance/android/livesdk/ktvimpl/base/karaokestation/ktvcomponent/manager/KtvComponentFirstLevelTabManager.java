package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.OrderSongRequiredConfig;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.u;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.j;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfig;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfigData;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.n;
import com.google.android.material.tabs.TabLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/manager/KtvComponentFirstLevelTabManager;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseFirstLevelTabManager;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentFirstLevelTabManager extends BaseFirstLevelTabManager {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f142608q = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LiveKtvFirstLevelTabConfigData f142609p;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentFirstLevelTabManager f142610a;

        public b(KtvComponentFirstLevelTabManager r100) {
            this.f142610a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            long r101 = (Long) r100;
            KtvComponentFirstLevelTabManager r102 = this.f142610a;
            int r103 = KtvComponentFirstLevelTabManager.f142608q;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r104 = r102.f142548k;
            if (r104 == null) goto L9;
            Pair<Integer, UpdateTabType> r105 = r104.getSelectedFirstLevelTabValue();
            if (r105 == null) goto L9;
            if (r105.getFirst().intValue() != FirstLevelTab.OrderSongTab.getValue()) goto L9;
            boolean r106 = true;
        L10:
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r107 = this.f142610a.f142548k;
            if (r107 == null) goto L15;
            y r108 = r107.getSelectedSecondLevelTabData(FirstLevelTab.OrderSongTab.getValue());
            if (r108 == null) goto L15;
            String r109 = r108.f69578c;
        L16:
            boolean r110 = Intrinsics.areEqual(r109, "recommend");
            KtvComponentFirstLevelTabManager r111 = this.f142610a;
            FirstLevelTab r112 = FirstLevelTab.OrderSongTab;
            if (r106 == false) goto L19;
            if (r110 == false) goto L19;
        L21:
            r101 = 0L;
        L22:
            r111.v(r112, r101);
            return;
        L19:
            j.f143561l.getClass();
            if (j.i() == false) goto L22;
        L15:
            r109 = null;
        L9:
            r106 = false;
            goto L10
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentFirstLevelTabManager f142611a;

        public c(KtvComponentFirstLevelTabManager r100) {
            this.f142611a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Long r101 = (Long) r100;
            KtvComponentFirstLevelTabManager r102 = this.f142611a;
            FirstLevelTab r103 = FirstLevelTab.AudienceSingTab;
            if (r101 == null) goto L5;
            int r104 = (int) r101.longValue();
        L6:
            int r105 = KtvComponentFirstLevelTabManager.f142608q;
            r102.u(r103, r104);
            return;
        L5:
            r104 = 0;
            goto L6
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentFirstLevelTabManager f142612a;

        public d(KtvComponentFirstLevelTabManager r100) {
            this.f142612a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            long r101 = (Long) r100;
            KtvComponentFirstLevelTabManager r102 = this.f142612a;
            FirstLevelTab r103 = FirstLevelTab.OrderedSongTab;
            j.f143561l.getClass();
            if (j.i() == false) goto L5;
            r101 = 0L;
        L5:
            int r104 = KtvComponentFirstLevelTabManager.f142608q;
            r102.v(r103, r101);
        }
    }

    static {
    }

    public final void B() {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r100 = this.f142550m;
        if (r100 == null) goto L8;
        MutableLiveData<vb0.a> r101 = r100.getOrderSongUiState();
        if (r101 == null) goto L9;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r101, new KtvComponentFirstLevelTabManager$updateSingListenApplyUnReadNum$1(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final void e() {
        super.e();
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L17;
        FirstLevelTab r100 = FirstLevelTab.OrderedSongTab;
        j.f143561l.getClass();
        if (j.i() == false) goto L7;
        Long r101 = 0L;
    L15:
        v(r100, r101);
        return;
    L7:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r102 = this.f142550m;
        if (r102 == null) goto L14;
        MutableLiveData<vb0.a> r103 = r102.getOrderSongUiState();
        if (r103 == null) goto L14;
        vb0.a r104 = r103.getValue();
        if (r104 == null) goto L14;
        r101 = r104.f553994a;
    L14:
        r101 = null;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final void s() {
        super.s();
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L41;
        B();
        KtvComponentContext.a r100 = KtvComponentContext.Companion;
        KtvComponentContext r101 = r100.getContext();
        if (r101 == null) goto L13;
        n<KtvComponentUIContext> r102 = r101.getKtvComponentUIContext();
        if (r102 == null) goto L13;
        KtvComponentUIContext r103 = r102.getValue();
        if (r103 == null) goto L13;
        NextLiveData<Long> r104 = r103.getApplyListenUnreadNum();
        if (r104 == null) goto L13;
        r104.observe(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager.b(this));
    L13:
        KtvComponentContext r105 = r100.getContext();
        if (r105 == null) goto L22;
        n<KtvComponentUIContext> r106 = r105.getKtvComponentUIContext();
        if (r106 == null) goto L22;
        KtvComponentUIContext r107 = r106.getValue();
        if (r107 == null) goto L22;
        NextLiveData<Long> r108 = r107.getApplySingUnreadNum();
        if (r108 == null) goto L22;
        r108.observe(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager.c(this));
    L22:
        KtvComponentContext r109 = r100.getContext();
        if (r109 == null) goto L31;
        n<KtvComponentUIContext> r110 = r109.getKtvComponentUIContext();
        if (r110 == null) goto L31;
        KtvComponentUIContext r111 = r110.getValue();
        if (r111 == null) goto L31;
        MutableLiveData<Long> r112 = r111.getUnreadMultiChorusApplyNum();
        if (r112 == null) goto L31;
        r112.observe(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager.d(this));
    L31:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r113 = this.f142550m;
        if (r113 == null) goto L36;
        MutableLiveData<vb0.a> r114 = r113.getOrderSongUiState();
        if (r114 == null) goto L36;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r114, this, KtvComponentFirstLevelTabManager$initData$1.INSTANCE, new b(this));
    L36:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r115 = this.f142550m;
        if (r115 == null) goto L61;
        MutableLiveData<vb0.a> r116 = r115.getOrderSongUiState();
        if (r116 == null) goto L62;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r116, this, KtvComponentFirstLevelTabManager$initData$3.INSTANCE, new c(this));
        return;
    L62:
        return;
    L61:
        return;
    L41:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r117 = this.f142550m;
        if (r117 == null) goto L46;
        MutableLiveData<vb0.a> r118 = r117.getOrderSongUiState();
        if (r118 == null) goto L46;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r118, KtvComponentFirstLevelTabManager$updateOrderSongUnreadCount$1.INSTANCE);
    L46:
        KtvComponentContext r119 = KtvComponentContext.Companion.getContext();
        if (r119 == null) goto L55;
        n<KtvComponentUIContext> r120 = r119.getKtvComponentUIContext();
        if (r120 == null) goto L55;
        KtvComponentUIContext r121 = r120.getValue();
        if (r121 == null) goto L55;
        NextLiveData<Integer> r122 = r121.getOrderSongUnReadNum();
        if (r122 == null) goto L55;
        r122.observe(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager.a(this));
    L55:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r123 = this.f142550m;
        if (r123 == null) goto L64;
        MutableLiveData<vb0.a> r124 = r123.getOrderSongUiState();
        if (r124 == null) goto L65;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r124, this, KtvComponentFirstLevelTabManager$initData$5.INSTANCE, new d(this));
        return;
    L65:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final LiveKtvFirstLevelTabConfigData m() {
        return this.f142609p;
    }

    public static final long A(KtvComponentFirstLevelTabManager r100) {
        r100.getClass();
        KtvComponentContext r101 = KtvComponentContext.Companion.getContext();
        if (r101 == null) goto L13;
        n<KtvComponentUIContext> r102 = r101.getKtvComponentUIContext();
        if (r102 == null) goto L13;
        KtvComponentUIContext r103 = r102.getValue();
        if (r103 == null) goto L13;
        MutableLiveData<Long> r104 = r103.getUnreadMultiChorusApplyNum();
        if (r104 == null) goto L13;
        Long r105 = r104.getValue();
        if (r105 == null) goto L13;
        return r105.longValue();
    L13:
        return 0;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final com.bytedance.android.live.ktv.common.karaokestation.model.a b(Function0<Unit> r210) {
        OrderSongRequiredConfig r100 = new OrderSongRequiredConfig(this.f142548k, h(), i(), f());
        Function0<Unit> r101 = t();
        Function3<View, TabLayout, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r102 = x();
        Function0<Unit> r110 = w();
        Function0<Unit> r111 = z();
        Function3<Integer, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> r112 = j();
        Function5<HSImageView, Function0<Unit>, FragmentActivity, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> r113 = r();
        return new com.bytedance.android.live.ktv.common.karaokestation.model.a(r100, new u(r101, r102, r110, r111, r112, y(), r113, Integer.valueOf(s1.f(541.0f)), true, KtvComponentFirstLevelTabManager$initTopControlBarAction$1.INSTANCE, KtvComponentFirstLevelTabManager$updateOrderSongDialogTopAreaAction$1.INSTANCE, null, null, null, null, 61568));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final Pair<Integer, String> k(int r110, String r210) {
        String r100 = r210;
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabName");
        String r101 = this.f142546i;
        if (r101 != null) goto L6;
        r101 = r100;
    L6:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L85;
        KtvComponentContext.a r102 = KtvComponentContext.Companion;
        KtvComponentContext r103 = r102.getContext();
        if (r103 == null) goto L10;
        long r104 = r103.getSingApplyUnreadCount();
    L11:
        KtvComponentContext r105 = r102.getContext();
        if (r105 == null) goto L14;
        long r111 = r105.getListenApplyUnreadCount();
    L15:
        KtvComponentContext r106 = r102.getContext();
        if (r106 == null) goto L25;
        n<KtvComponentUIContext> r107 = r106.getKtvComponentUIContext();
        if (r107 == null) goto L25;
        KtvComponentUIContext r108 = r107.getValue();
        if (r108 == null) goto L25;
        MutableLiveData<Long> r109 = r108.getUnreadMultiChorusApplyNum();
        if (r109 == null) goto L25;
        Long r112 = r109.getValue();
        if (r112 == null) goto L25;
    L26:
        long r113 = r112.longValue();
        long r114 = r104 + r113;
        KtvComponentContext r115 = r102.getContext();
        if (r115 == null) goto L33;
        n<KtvComponentUIContext> r116 = r115.getKtvComponentUIContext();
        if (r116 == null) goto L33;
        KtvComponentUIContext r117 = r116.getValue();
        if (r117 == null) goto L33;
        Integer r118 = r117.getLastApplyMsgType();
    L35:
        if (r111 > 0) goto L37;
    L66:
        if (r111 <= 0) goto L70;
        if (r114 != 0) goto L70;
    L72:
        if (r111 <= 0) goto L75;
        int r119 = FirstLevelTab.OrderSongTab.getValue();
    L99:
        Integer r120 = this.f142545h;
        if (r120 == null) goto L104;
        if (r120 == null) goto L103;
        r119 = r120.intValue();
        goto L104
    L103:
        r119 = r110;
    L104:
        String r121 = this.f142546i;
        if (r121 == null) goto L110;
        if (r121 == null) goto L109;
        r100 = r121;
    L109:
        r101 = r100;
    L110:
        KtvComponentContext r122 = KtvComponentContext.Companion.getContext();
        if (r122 == null) goto L118;
        n<KtvComponentUIContext> r123 = r122.getKtvComponentUIContext();
        if (r123 == null) goto L118;
        KtvComponentUIContext r124 = r123.getValue();
        if (r124 == null) goto L118;
        r124.setLastApplyMsgType(null);
    L118:
        return new Pair(Integer.valueOf(r119), r101);
    L75:
        if (r114 <= 0) goto L82;
        r119 = FirstLevelTab.AudienceSingTab.getValue();
        if (r113 <= 0) goto L80;
        r101 = "multi_chorus";
        goto L99
    L80:
        if (r104 <= 0) goto L99;
        r101 = "single_sing";
        goto L99
    L82:
        r119 = FirstLevelTab.OrderSongTab.getValue();
    L70:
        if (r114 <= 0) goto L83;
        if (r111 == 0) goto L72;
    L83:
        r119 = FirstLevelTab.OrderSongTab.getValue();
        goto L99
    L37:
        if (r114 <= 0) goto L66;
        if (r118 != null) goto L42;
    L43:
        if (r118 != null) goto L46;
    L48:
        if (r118 != null) goto L51;
    L53:
        r119 = FirstLevelTab.OrderSongTab.getValue();
        goto L99
    L51:
        if (r118.intValue() != 10) goto L53;
        r119 = FirstLevelTab.OrderSongTab.getValue();
        goto L99
    L46:
        if (r118.intValue() != 15) goto L48;
    L54:
        int r125 = FirstLevelTab.AudienceSingTab.getValue();
        if (r118 != null) goto L58;
    L61:
        if (r118 != null) goto L64;
    L60:
        r119 = r125;
        goto L99
    L64:
        if (r118.intValue() != 15) goto L60;
        r101 = "multi_chorus";
        goto L60
    L58:
        if (r118.intValue() != 9) goto L61;
        r101 = "single_sing";
        goto L60
    L42:
        if (r118.intValue() == 9) goto L54;
    L33:
        r118 = null;
    L25:
        r112 = 0L;
        goto L26
    L14:
        r111 = 0;
        goto L15
    L10:
        r104 = 0;
        goto L11
    L85:
        if (KtvUtilsKt.f() == false) goto L95;
        KtvComponentContext r126 = KtvComponentContext.Companion.getContext();
        if (r126 == null) goto L91;
        n<Boolean> r127 = r126.isAudienceEnableSing();
        if (r127 == null) goto L91;
        Boolean r128 = r127.getValue();
    L93:
        if (Intrinsics.areEqual(r128, Boolean.TRUE) == false) goto L95;
        boolean r129 = true;
    L96:
        if (r129 == false) goto L98;
        r119 = FirstLevelTab.OrderSongTab.getValue();
        goto L99
    L98:
        r119 = FirstLevelTab.WantListenTab.getValue();
    L91:
        r128 = null;
    L95:
        r129 = false;
        goto L96
    }

    public KtvComponentFirstLevelTabManager(Integer r100, String r101, Context r102, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r103, com.bytedance.android.live.ktv.common.search.viewmodel.a r104, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r105, com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r106) {
        super(r100, r101, r102, r103, r104, r105, r106);
        LiveKtvFirstLevelTabConfig r107 = h.n();
        LiveKtvFirstLevelTabConfigData r108 = null;
        Object r109 = null;
        r108 = null;
        if (r107 == null) goto L13;
        List<LiveKtvFirstLevelTabConfigData> r110 = r107.getLiveKtvFirstLevelTabConfig();
        if (r110 == null) goto L13;
        Iterator<T> r111 = r110.iterator();
    L8:
        if (r111.hasNext() == false) goto L12;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((LiveKtvFirstLevelTabConfigData) r112).getModeType(), ModeType.KTV_COMPONENT.getValue()) == false) goto L8;
        r109 = r112;
    L12:
        r108 = (LiveKtvFirstLevelTabConfigData) r109;
    L13:
        this.f142609p = r108;
    }
}
