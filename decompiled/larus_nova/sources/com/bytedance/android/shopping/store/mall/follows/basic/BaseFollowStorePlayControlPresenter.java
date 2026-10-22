package com.bytedance.android.shopping.store.mall.follows.basic;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.android.shopping.store.mall.follows.FollowStoreResponse;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.ies.xbridge.s;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class BaseFollowStorePlayControlPresenter<T extends BaseFollowStoreViewModel> extends QFragmentPresenter {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f185558q = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ECHybridListContainer f185559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f185560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Pair<Integer, Integer>> f185561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Pair<String, Integer> f185562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f185563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f185564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<String> f185565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PlayAreaConfig f185566m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f185567n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f185568o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Class<T> f185569p;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFollowStorePlayControlPresenter f185570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f185571b;

        public b(BaseFollowStorePlayControlPresenter r100, View r101) {
            this.f185570a = r100;
            this.f185571b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            FollowStoreResponse r101 = (FollowStoreResponse) r100;
            if (r101.isFirstFrame() == false) goto L5;
        L6:
            this.f185571b.postDelayed(new g(this), 1000);
            return;
        L5:
            if (r101.getRequestAfterCache() == true) goto L6;
        }
    }

    public static final class c implements JsEventSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFollowStorePlayControlPresenter f185572a;

        public c(BaseFollowStorePlayControlPresenter r100) {
            this.f185572a = r100;
        }

        @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
        public final void onReceiveJsEvent(Js2NativeEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "jsEvent");
            dm.a.b r101 = dm.a.a("FollowStore");
            StringBuilder r102 = new StringBuilder("manualTriggerPlayControl--skip:");
            XReadableMap r103 = r100.getParams();
            String r104 = null;
            if (r103 == null) goto L5;
            Integer r105 = Integer.valueOf(s.d(r103, "skip", 0));
        L6:
            r102.append(r105);
            r102.append(",item_id:");
            XReadableMap r106 = r100.getParams();
            if (r106 == null) goto L9;
            String r107 = s.f(r106, "item_id", "");
        L10:
            r102.append(r107);
            r101.a(r102.toString());
            XReadableMap r108 = r100.getParams();
            if (r108 != null) goto L13;
        L19:
            this.f185572a.j0(false, true, true);
            return;
        L13:
            if (s.d(r108, "skip", 0) != 1) goto L19;
            String r109 = s.f(r108, "item_id", "");
            if (com.bytedance.android.shopping.extensions.k.c(r109) == false) goto L17;
            r104 = r109;
        L17:
            if (r104 == null) goto L19;
            this.f185572a.f185565l.add(r104);
            goto L19
        L9:
            r107 = null;
            goto L10
        L5:
            r105 = null;
            goto L6
        }
    }

    static {
    }

    public final T h0() {
        return (T) this.f185567n.getValue();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        EventCenter.unregisterJsEventSubscriber("ec.shop.manualTriggerPlayControl", this.f185568o);
    }

    public final PlayAreaConfig i0() {
        PlayAreaConfig r100 = this.f185566m;
        if (r100 != null) goto L6;
        float r101 = e0();
        float r102 = 1 - e0();
        View r103 = Z().b(R.id.ec_follow_store_container).f();
        int[] r104 = {0, 0};
        r103.getLocationOnScreen(r104);
        int r105 = r104[1];
        Pair r106 = new Pair(Integer.valueOf(r105), Integer.valueOf(r103.getHeight() + r105));
        int r107 = ((Number) r106.getFirst()).intValue();
        float r108 = ((Number) r106.getSecond()).intValue() - r107;
        int r109 = ((int) (r101 * r108)) + r107;
        int r110 = r107 + ((int) (r108 * r102));
        PlayAreaConfig r111 = new PlayAreaConfig(r109, r110, r110 - r109);
        this.f185566m = r111;
        return r111;
    L6:
        return r100;
    }

    public final float e0() {
        hj3.g r100 = h0().getMomentConfig();
        if (r100 == null) goto L8;
        Float r101 = r100.h();
        if (r101 != null) goto L7;
        return 0.2f;
    L7:
        return (1 - r101.floatValue()) / 2;
    L8:
        return 0.2f;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        EventCenter.registerJsEventSubscriber("ec.shop.manualTriggerPlayControl", this.f185568o);
        View r101 = Z().b(R.id.ec_follow_store_container).f();
        ECHybridListContainer r102 = (ECHybridListContainer) Z().b(R.id.ec_follow_store_hybridContainer).f();
        this.f185559f = r102;
        r102.getRecyclerView().addOnScrollListener(new BaseFollowStorePlayControlPresenter$onBind$$inlined$apply$lambda$1(this));
        h0().getResponse().b(ECQuickUtilKt.a(Y()), new b(this, r101));
    }

    public BaseFollowStorePlayControlPresenter(Fragment r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "f");
        Intrinsics.checkNotNullParameter(r101, "vmClazz");
        super(r100);
        this.f185569p = r101;
        this.f185561h = new LinkedHashMap();
        this.f185565l = new LinkedHashSet();
        this.f185567n = LazyKt.lazy(new BaseFollowStorePlayControlPresenter$viewModel$2(this));
        this.f185568o = new c(this);
    }

    public final float d0(ECHybridListEngine r100, ECHybridListItemVO r110) {
        String r101 = r110.f47029d;
        if (r101 != null) goto L5;
        return 0.0f;
    L5:
        View r102 = null;
        BaseViewHolder r103 = r100.e(null, r101);
        if (r103 != null) goto L9;
        return 0.0f;
    L9:
        if (this.f185561h.containsKey(r101) == true) goto L32;
        String r104 = r110.f47029d;
        if (r104 == null) goto L32;
        Integer r111 = r110.f47028c;
        if (r111 != null) goto L16;
        String r112 = "";
    L22:
        if (r112 != null) goto L24;
    L30:
        if (r102 == null) goto L32;
        int[] r113 = new int[2];
        int[] r105 = new int[2];
        r102.getLocationOnScreen(r113);
        r103.itemView.getLocationOnScreen(r105);
        this.f185561h.put(r104, new Pair(Integer.valueOf(r113[1] - r105[1]), Integer.valueOf(r102.getHeight())));
        goto L32
    L24:
        if ((r103 instanceof ECLynxCardHolder) == true) goto L26;
        BaseViewHolder r106 = null;
    L27:
        ECLynxCardHolder r107 = (ECLynxCardHolder) r106;
        if (r107 == null) goto L30;
        r102 = r107.k4(r112);
        goto L30
    L26:
        r106 = r103;
        goto L27
    L16:
        hj3.g r108 = h0().getMomentConfig();
        if (r108 == null) goto L21;
        Map<String, String> r109 = r108.i();
        if (r109 == null) goto L21;
        r112 = r109.get(String.valueOf(r111.intValue()));
    L21:
        r112 = null;
    L32:
        Pair r114 = (Pair) ((LinkedHashMap) this.f185561h).get(r101);
        if (r114 == null) goto L38;
        PlayAreaConfig r115 = i0();
        int r116 = ((Number) r114.getSecond()).intValue();
        if (r116 <= 0) goto L38;
        int[] r117 = {0, 0};
        r103.itemView.getLocationOnScreen(r117);
        int r118 = r117[1] + com.bytedance.android.shopping.extensions.k.f((Integer) r114.getFirst());
        float r119 = (RangesKt.coerceAtMost(r115.getEndPlay(), com.bytedance.android.shopping.extensions.k.f((Integer) r114.getSecond()) + r118) - RangesKt.coerceAtLeast(r118, r115.getStartPlay())) / r116;
        dm.a.a("FollowStore").a("itemId:" + r101 + " ,showPct：" + r119);
        return r119;
    L38:
        return 0.0f;
    }

    public final void j0(boolean r110, boolean r210, boolean r211) {
        ECHybridListContainer r100 = this.f185559f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hybridContainer");
    L5:
        ECHybridListEngine r101 = r100.getEngine();
        if (r101 == null) goto L171;
        VirtualLayoutManager r102 = r101.f46871b.getLayoutManager();
        String r103 = null;
        if ((r102 instanceof LinearLayoutManager) == true) goto L10;
        r102 = null;
    L10:
        Pair<String, Integer> r104 = this.f185562i;
        if (r104 == null) goto L21;
        Integer r105 = r104.getSecond();
        if (r105 == null) goto L21;
        int r106 = r105.intValue();
        if (this.f185564k > 0) goto L25;
        if (r102 == null) goto L19;
        Integer r107 = Integer.valueOf(r102.findFirstVisibleItemPosition());
    L20:
        r106 = com.bytedance.android.shopping.extensions.k.f(r107);
        goto L25
    L19:
        r107 = null;
    L25:
        Pair<String, Integer> r108 = this.f185562i;
        if (r108 == null) goto L35;
        Integer r109 = r108.getSecond();
        if (r109 == null) goto L35;
        int r111 = r109.intValue();
        if (this.f185564k <= 0) goto L39;
        if (r102 == null) goto L33;
        Integer r112 = Integer.valueOf(r102.findLastVisibleItemPosition());
    L34:
        r111 = com.bytedance.android.shopping.extensions.k.f(r112);
        goto L39
    L33:
        r112 = null;
    L39:
        dm.a.a("FollowStore").a("queryPlayItemId：first:" + r106 + ",second:" + r111);
        if (r106 > r111) goto L143;
        int r113 = r106;
    L42:
        if (r113 < 0) goto L143;
        if (r113 >= r101.i()) goto L143;
        ECHybridListItemVO r114 = r101.h(r113);
        if (r114 != null) goto L50;
    L48:
        int r115 = r113;
    L140:
        int r116 = r115;
        if (r116 == r111) goto L143;
        r113 = r116 + 1;
        goto L42
    L50:
        if (h0().isDoubleRaw() == true) goto L52;
        hj3.g r117 = h0().getMomentConfig();
        if (r117 == null) goto L70;
        Map<String, String> r118 = r117.i();
        if (r118 == null) goto L70;
        String r119 = r118.get(String.valueOf(r114.f47028c));
    L71:
        boolean r120 = com.bytedance.android.shopping.extensions.k.c(r119);
    L72:
        if (r120 == false) goto L48;
        int r121 = r113 + 1;
        if (r121 < r106) goto L78;
        if (r121 > r111) goto L78;
        ECHybridListItemVO r122 = r101.h(r121);
    L80:
        if (h0().isDoubleRaw() == false) goto L134;
        String r123 = r114.f47029d;
        if (r123 == null) goto L97;
        float r124 = d0(r101, r114);
        int r125 = i0().getPlayableHeight();
        if (r125 == 0) goto L87;
        float r126 = this.f185564k / r125;
    L88:
        dm.a.b r127 = dm.a.a("FollowStore");
        StringBuilder r128 = new StringBuilder("itemId:");
        r128.append(r123);
        r128.append(" ,totalDyPct：");
        r128.append(r126);
        r128.append(",currentPlayingItemId：");
        Pair<String, Integer> r129 = this.f185562i;
        if (r129 == null) goto L91;
        String r130 = r129.getFirst();
    L92:
        r128.append(r130);
        r128.append(",pendingPlayItemId：");
        r128.append(this.f185563j);
        r127.a(r128.toString());
        if (r211 == true) goto L95;
        Pair<String, Integer> r131 = this.f185562i;
        if (r131 == null) goto L101;
        String r132 = r131.getFirst();
    L103:
        if (Intrinsics.areEqual(r123, r132) == false) goto L126;
        if (r122 == null) goto L116;
        int r133 = i0().getPlayableHeight();
        if (r133 == 0) goto L108;
        float r134 = this.f185564k / r133;
    L109:
        r115 = r113;
        if (Math.abs(r134) > 0.1d) goto L112;
    L117:
        boolean r135 = false;
    L118:
        if (r135 == false) goto L124;
        if (r122 == null) goto L121;
        String r136 = r122.f47029d;
    L122:
        this.f185563j = r136;
    L137:
        boolean r137 = false;
    L138:
        if (r137 == false) goto L140;
        Pair<String, Integer> r138 = new Pair(r114.f47029d, Integer.valueOf(r115));
    L144:
        this.f185563j = null;
        dm.a.b r139 = dm.a.a("FollowStore");
        StringBuilder r140 = new StringBuilder("try sendPlayEvent：");
        if (r138 == null) goto L147;
        String r141 = r138.getFirst();
    L148:
        r140.append(r141);
        r139.a(r140.toString());
        Pair<String, Integer> r142 = this.f185562i;
        if (r142 == null) goto L151;
        String r143 = r142.getFirst();
    L152:
        if (r138 == null) goto L154;
        String r144 = r138.getFirst();
    L156:
        if ((!Intrinsics.areEqual(r143, r144)) == true) goto L158;
        if (r210 == true) goto L158;
        return;
    L158:
        this.f185564k = 0;
        dm.a.b r145 = dm.a.a("FollowStore");
        StringBuilder r146 = new StringBuilder("real sendPlayEvent：");
        if (r138 == null) goto L161;
        String r147 = r138.getFirst();
    L162:
        r146.append(r147);
        r145.a(r146.toString());
        this.f185562i = r138;
        long r148 = System.currentTimeMillis();
        String r149 = h0().getSceneId();
        if (r138 == null) goto L165;
        r103 = r138.getFirst();
    L165:
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.shop.playControl", r148, r149, false, MapsKt.mapOf(TuplesKt.to("item_id", r103)), false, 32));
        return;
    L161:
        r147 = null;
        goto L162
    L154:
        r144 = null;
        goto L156
    L151:
        r143 = null;
        goto L152
    L147:
        r141 = null;
        goto L148
    L121:
        r136 = null;
        goto L122
    L124:
        if (r124 <= 0.6d) goto L137;
    L136:
        r137 = true;
        goto L138
    L112:
        if (d0(r101, r122) <= 0.6d) goto L117;
        if (CollectionsKt.contains(this.f185565l, r122.f47029d) == true) goto L117;
        r135 = true;
        goto L118
    L108:
        r134 = 0.0f;
        goto L109
    L116:
        r115 = r113;
        goto L117
    L126:
        r115 = r113;
        if (Intrinsics.areEqual(this.f185563j, r123) == false) goto L132;
        this.f185563j = null;
        if (r124 <= 0.6d) goto L137;
    L132:
        if (r124 < 1) goto L137;
    L101:
        r132 = null;
        goto L103
    L95:
        if (r124 < 0.5d) goto L97;
        r115 = r113;
        goto L136
    L91:
        r130 = null;
        goto L92
    L87:
        r126 = 0.0f;
    L97:
        r115 = r113;
        goto L137
    L134:
        r115 = r113;
        if (d0(r101, r114) <= 0.4d) goto L137;
    L78:
        r122 = null;
    L70:
        r119 = null;
        goto L71
    L52:
        if (com.bytedance.android.shopping.extensions.k.c(r114.f47029d) == true) goto L54;
    L64:
        r120 = false;
        goto L72
    L54:
        if (CollectionsKt.contains(this.f185565l, r114.f47029d) == true) goto L64;
        Integer r150 = r114.f47028c;
        if (r150 != null) goto L58;
    L61:
        boolean r151 = true;
    L62:
        if (r151 == true) goto L64;
        r120 = true;
        goto L72
    L58:
        if (r150.intValue() == 50106) goto L61;
        r151 = false;
    L143:
        r138 = null;
    L35:
        if (r102 == null) goto L37;
        Integer r152 = Integer.valueOf(r102.findLastVisibleItemPosition());
    L38:
        r111 = com.bytedance.android.shopping.extensions.k.f(r152);
        goto L39
    L37:
        r152 = null;
    L21:
        if (r102 == null) goto L23;
        Integer r153 = Integer.valueOf(r102.findFirstVisibleItemPosition());
    L24:
        r106 = com.bytedance.android.shopping.extensions.k.f(r153);
        goto L25
    L23:
        r153 = null;
        goto L24
    }
}
