package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.common.p001const.VolumeTypes;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class w1 extends ECShopBasePresenter {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f184444u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f184445v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f184446w;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w1 f184447a;

        public a(w1 r100) {
            this.f184447a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.android.shopping.store.home.entity.n r101 = (com.bytedance.android.shopping.store.home.entity.n) r100;
            String r102 = this.f184447a.T().getStoreParam().getShopId();
            if (r102 == null) goto L5;
            w1 r103 = this.f184447a;
            HashSet<String> r104 = com.bytedance.android.shopping.store.home.x.f184761a;
            Intrinsics.checkNotNullParameter(r102, "shopId");
            r103.f184445v = !com.bytedance.android.shopping.store.home.x.f184761a.contains(r102);
        L5:
            com.bytedance.android.shopping.store.home.entity.i r105 = r101.f183753g;
            if (r105 == null) goto L8;
            Integer r106 = r105.f183731c;
        L9:
            if (r106 == null) goto L15;
            if (r106.intValue() != 2) goto L15;
            this.f184447a.f184445v = true;
        L15:
            if (this.f184447a.T().getStoreParam().getShopId() != null) goto L18;
            this.f184447a.f184445v = false;
        L18:
            if (this.f184447a.I() == true) goto L22;
            if (this.f184447a.G() == true) goto L22;
        L23:
            this.f184447a.T().getHeadAnimationEnd().setValue(Boolean.TRUE);
            return;
        L22:
            if (this.f184447a.U() == true) goto L23;
            return;
        L8:
            r106 = null;
            goto L9
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w1 f184448a;

        public b(w1 r100) {
            this.f184448a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ECStoreTabAreaVO r101 = (ECStoreTabAreaVO) r100;
            com.bytedance.android.shopping.store.home.entity.n r102 = this.f184448a.T().getHeaderArea().getValue();
            Integer r103 = null;
            if (r102 == null) goto L7;
            com.bytedance.android.shopping.store.home.entity.i r104 = r102.f183753g;
            if (r104 == null) goto L7;
            Integer r105 = r104.f183731c;
        L9:
            if (r105 == null) goto L63;
            boolean r106 = true;
            if (r105.intValue() != 1) goto L63;
            w1 r107 = this.f184448a;
            if (r107.f184445v == false) goto L63;
            Pair<Integer, Integer> r108 = r107.O();
            List<uj3.j> r109 = r101.f183634b;
            if (r109 == null) goto L40;
            uj3.j r110 = (uj3.j) CollectionsKt.getOrNull(r109, r108.getFirst().intValue());
            if (r110 == null) goto L40;
            List<uj3.j> r111 = r110.f550298b;
            if (r111 != null) goto L22;
        L25:
            boolean r112 = true;
        L27:
            if ((!r112) == true) goto L30;
            r110 = null;
        L30:
            if (r110 == null) goto L40;
            List<uj3.j> r113 = r110.f550298b;
            if (r113 == null) goto L36;
            uj3.j r114 = (uj3.j) CollectionsKt.getOrNull(r113, r108.getSecond().intValue());
            if (r114 == null) goto L36;
            Integer r115 = Integer.valueOf(r114.f550300d);
        L37:
            if (r115 == null) goto L40;
            r103 = r115;
        L45:
            this.f184448a.getClass();
            if (r103 == null) goto L58;
            int r116 = r103.intValue();
            if (r116 != TabEnum.SELECTION_TAB.getType()) goto L50;
        L59:
            if (r106 == true) goto L61;
            this.f184448a.f184445v = false;
        L61:
            this.f184448a.T().getVideoInfo().a(this.f184448a.W(), new x1(this), false);
            goto L63
        L50:
            if (r116 == TabEnum.ISV_PLUS_TAB.getType()) goto L59;
            if (r116 == TabEnum.MIXED_SELECTION_TAB.getType()) goto L59;
            if (r116 == TabEnum.STRATEGY_SELECTION_TAB.getType()) goto L59;
            if (r116 == TabEnum.CONFIGURED_SELECTION_TAB.getType()) goto L59;
        L58:
            r106 = false;
        L36:
            r115 = null;
            goto L37
        L22:
            if (r111.isEmpty() == true) goto L25;
            r112 = false;
        L40:
            List<uj3.j> r117 = r101.f183634b;
            if (r117 == null) goto L45;
            uj3.j r118 = (uj3.j) CollectionsKt.getOrNull(r117, r108.getFirst().intValue());
            if (r118 == null) goto L45;
            r103 = Integer.valueOf(r118.f550300d);
        L63:
            if (this.f184448a.I() == true) goto L65;
        L66:
            w1 r119 = this.f184448a;
            r119.T().getFloatArea().a(r119.W(), new y1(r119), false);
            return;
        L65:
            if (this.f184448a.G() == false) goto L66;
            return;
        L7:
            r105 = null;
            goto L9
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w1 f184449a;

        public c(w1 r100) {
            this.f184449a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ShopHeaderVideoVO r101 = (ShopHeaderVideoVO) r100;
            com.bytedance.android.shopping.store.home.entity.n r102 = this.f184449a.T().getHeaderArea().getValue();
            if (r102 == null) goto L7;
            com.bytedance.android.shopping.store.home.entity.i r103 = r102.f183753g;
            if (r103 == null) goto L7;
            Integer r104 = r103.f183731c;
        L8:
            if (r104 != null) goto L11;
        L14:
            w1.q0(this.f184449a);
            return;
        L11:
            if (r104.intValue() != 1) goto L14;
            if (this.f184449a.f184445v == false) goto L14;
            return;
        L7:
            r104 = null;
            goto L8
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w1 f184450a;

        public d(w1 r100) {
            this.f184450a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            StoreV3LiveRoomVO r101 = (StoreV3LiveRoomVO) r100;
            if (this.f184450a.I() == true) goto L69;
            w1 r102 = this.f184450a;
            if (r102.U() == true) goto L73;
            boolean r103 = r102.E();
            if (r102.G() == true) goto L10;
        L14:
            boolean r104 = false;
        L15:
            Boolean r105 = null;
            if (r102.U() == false) goto L18;
        L31:
            boolean r106 = false;
        L32:
            if (r106 == false) goto L40;
            int r107 = ECSdk.f48106a;
            IAdapterService r108 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r108 == null) goto L40;
            com.bytedance.android.ec.adapter.api.j r109 = r108.getLiveWindowService();
            if (r109 == null) goto L40;
            Activity r110 = com.bytedance.android.ec.core.utils.l0.b(r102.u().c());
            if (r110 == null) goto L40;
            r109.c(r110, new com.bytedance.android.ec.adapter.api.a());
        L40:
            if (r104 == false) goto L50;
            im.b r111 = r102.T().getLiveManager();
            Integer r112 = r102.T().getStoreParam().getStoreUIParam().getVolume();
            int r113 = VolumeTypes.MUTE.getType();
            if (r112 != null) goto L45;
        L46:
            boolean r114 = true;
        L48:
            im.b.i(r111, false, r114, 1);
            goto L50
        L45:
            if (r112.intValue() != r113) goto L46;
            r114 = false;
        L50:
            if (r103 == false) goto L62;
            com.bytedance.android.shopping.store.home.entity.n r115 = r102.T().getHeaderArea().getValue();
            if (r115 == null) goto L57;
            com.bytedance.android.shopping.store.home.entity.g r116 = r115.f183751e;
            if (r116 == null) goto L57;
            r105 = r116.f183717j;
        L57:
            if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L59;
            r102.y().post(new v1(r102));
            r102.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.PREVIEW_COLLAPSE, 2));
            return;
        L59:
            if (r104 == false) goto L61;
            r102.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.PREVIEW_COLLAPSE, 2));
        L63:
            r102.T().getFloatArea().a(r102.W(), new y1(r102), false);
            if (r103 == true) goto L66;
            return;
        L66:
            if (r102.T().getFlagHasDisplayTopLive() == true) goto L72;
            r102.T().setFlagHasDisplayTopLive(true);
            return;
        L72:
            return;
        L61:
            r102.T().getChangeStateEvent().setValue(new ui3.c(4, ShopStatus.PREVIEW_EXPANDED, 2));
            goto L63
        L62:
            r102.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.NORMAL, 2));
            goto L63
        L18:
            if (com.bytedance.android.ec.core.utils.y0.a() == true) goto L20;
        L22:
            boolean r117 = false;
        L23:
            if (r117 == false) goto L31;
            int r118 = ECSdk.f48106a;
            s83.g r119 = (s83.g) ECSdk.a(s83.g.class);
            if (r119 == null) goto L27;
            Boolean r120 = r119.hasLivePlayingMute();
        L29:
            if (Intrinsics.areEqual(r120, Boolean.FALSE) == false) goto L31;
            r106 = true;
            goto L32
        L27:
            r120 = null;
            goto L29
        L20:
            if (Intrinsics.areEqual(r102.T().isLiveOn().getValue(), Boolean.FALSE) == false) goto L22;
            r117 = true;
            goto L23
        L10:
            if (r102.U() == true) goto L14;
            if (r102.T().canShowLiveFloatView() == false) goto L14;
            r104 = true;
            goto L15
        L73:
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w1 f184451a;

        public e(w1 r100) {
            this.f184451a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            w1 r102 = this.f184451a;
            Pair<Integer, Integer> r103 = r102.T().getLastSelectedTabLocation();
            boolean r104 = false;
            if (r103 != null) goto L6;
        L8:
            boolean r105 = false;
        L9:
            w1 r106 = this.f184451a;
            Pair<Integer, Integer> r107 = r106.T().getLastSelectedTabLocation();
            if (r107 != null) goto L13;
        L15:
            boolean r108 = false;
        L16:
            if (r105 == true) goto L18;
            if (r108 == true) goto L18;
            return;
        L18:
            w1 r109 = this.f184451a;
            if (r109.U() == false) goto L22;
            return;
        L22:
            if (r109.I() == false) goto L24;
            r109.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.PREVIEW_COLLAPSE, 2));
            return;
        L24:
            boolean r110 = r109.E();
            if (r109.Z() < 1.0f) goto L34;
            AbsECShopPresenter$currentIsProductTab$1 r111 = AbsECShopPresenter$currentIsProductTab$1.INSTANCE;
            ECStoreTabAreaVO r112 = r109.T().getTabArea().getValue();
            if (r112 == null) goto L32;
            List<uj3.j> r113 = r112.f183634b;
            if (r113 == null) goto L32;
            int r114 = com.bytedance.android.shopping.store.home.t.f184508a;
            boolean r115 = com.bytedance.android.shopping.store.home.t.c(r113, r109.N(), r111);
        L33:
            if (r115 == false) goto L34;
        L35:
            if (r104 == false) goto L41;
            if (r110 == false) goto L42;
            r109.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.PREVIEW_COLLAPSE, 2));
            return;
        L42:
            return;
        L41:
            return;
        L32:
            r115 = false;
        L34:
            r104 = true;
            goto L35
        L13:
            if (r107.getSecond().intValue() == r106.N().getSecond().intValue()) goto L15;
            r108 = true;
            goto L16
        L6:
            if (r103.getFirst().intValue() == r102.N().getFirst().intValue()) goto L8;
            r105 = true;
            goto L9
        }
    }

    public w1(Fragment r100) {
        super(r100);
        this.f184444u = true;
        this.f184445v = true;
        this.f184446w = true;
    }

    public static final void q0(w1 r100) {
        if (r100.U() == false) goto L5;
        return;
    L5:
        if (r100.I() == true) goto L8;
        return;
    L8:
        if (r100.I() == true) goto L10;
    L12:
        boolean r101 = false;
    L13:
        com.bytedance.android.shopping.store.home.entity.n r102 = r100.T().getHeaderArea().getValue();
        if (r102 == null) goto L18;
        com.bytedance.android.shopping.store.home.entity.g r103 = r102.f183751e;
        if (r103 == null) goto L18;
        Boolean r104 = r103.f183717j;
    L19:
        boolean r105 = Intrinsics.areEqual(r104, Boolean.TRUE);
        if (r100.f184444u == false) goto L37;
        if (r101 == true) goto L23;
    L34:
        r100.f184444u = false;
        return;
    L23:
        if (r105 == false) goto L25;
    L33:
        r100.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.PREVIEW_COLLAPSE, 2));
        r100.f184444u = false;
        return;
    L25:
        if (r100.f184445v == false) goto L33;
        String r106 = r100.T().getStoreParam().getShopId();
        if (r106 == null) goto L32;
        HashSet<String> r107 = com.bytedance.android.shopping.store.home.x.f184761a;
        Intrinsics.checkNotNullParameter(r106, "shopId");
        HashSet<String> r108 = com.bytedance.android.shopping.store.home.x.f184761a;
        if (r108.contains(r106) == true) goto L32;
        Intrinsics.checkNotNullParameter(r106, "shopId");
        r108.add(r106);
    L32:
        r100.T().getChangeStateEvent().setValue(new ui3.c(4, ShopStatus.PREVIEW_EXPANDED, 2));
        goto L34
    L37:
        return;
    L18:
        r104 = null;
        goto L19
    L10:
        if (r100.U() == true) goto L12;
        r101 = true;
        goto L13
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        T().getHeaderArea().a(W(), new a(this), false);
        T().getTabArea().a(W(), new b(this), false);
        T().getVideoInfo().a(W(), new c(this), false);
        T().getLiveInfo().a(W(), new d(this), false);
        T().getSelectedTabLocation().a(W(), new e(this), false);
    }
}
