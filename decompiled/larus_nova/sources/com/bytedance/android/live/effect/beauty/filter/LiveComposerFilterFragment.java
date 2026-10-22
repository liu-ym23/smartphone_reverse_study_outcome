package com.bytedance.android.live.effect.beauty.filter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.bytedance.android.live.effect.sticker.presenter.n;
import com.bytedance.android.live.effect.utils.BeautyItemDecoration;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.config.ul;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/filter/LiveComposerFilterFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "m", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveComposerFilterFragment extends BaseFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f67245q = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f67246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f67247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f67248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f67249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f67250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f67251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f67252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f67253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f67254l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67255m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final q90.b f67256n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f67257o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f67258p;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.presenter.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveComposerFilterFragment f67259a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LiveComposerFilterFragment r100 = this.f67259a;
            int r101 = LiveComposerFilterFragment.f67245q;
            r100.V90();
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            LiveComposerFilterFragment r100 = this.f67259a;
            int r101 = LiveComposerFilterFragment.f67245q;
            LiveComposerFilterHelper.a(r100.U90(), null, "ttlive_anchor_effect_LiveComposerFilterFragment_onBeautyModeChange", r100.f67257o, true, false, 48);
            r100.U90().d(r100.f67254l, r100.f67257o);
        }

        public b(LiveComposerFilterFragment r100) {
            this.f67259a = r100;
        }
    }

    public static final class c implements LiveSmallItemBeautyHelper.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveComposerFilterFragment f67260a;

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
        public final void onError() {
            LoadingStatusView r100 = (LoadingStatusView) this.f67260a.S90(R.id.loading_view);
            if (r100 == null) goto L6;
            r100.showError();
            return;
        }

        public c(LiveComposerFilterFragment r100) {
            this.f67260a = r100;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
        public final void onSuccess(List<Sticker> r100) {
            Intrinsics.checkNotNullParameter(r100, "stickerList");
            if (r100.isEmpty() == false) goto L8;
            LiveEffectMonitor.d(d0.f66751a, 1000, "ttlive_anchor_effect_LiveComposerFilterFragment empty list");
            LoadingStatusView r101 = (LoadingStatusView) this.f67260a.S90(R.id.loading_view);
            if (r101 == null) goto L18;
            r101.showError();
            return;
        L18:
            return;
        L8:
            LiveComposerFilterFragment r102 = this.f67260a;
            int r103 = LiveComposerFilterFragment.f67245q;
            LiveComposerFilterAdapter r104 = r102.T90();
            r104.getClass();
            Intrinsics.checkNotNullParameter(r100, "list");
            ((ArrayList) r104.f67221a).clear();
            ArrayList r105 = (ArrayList) r104.f67221a;
            r105.addAll(r100);
            ((ArrayList) r104.f67222b).clear();
            List<String> r106 = r104.f67222b;
            List<Sticker> r107 = r100;
            ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
            Iterator<T> r109 = r107.iterator();
        L10:
            if (r109.hasNext() == false) goto L12;
            r108.add(((Sticker) r109.next()).getEffectId());
            goto L10
        L12:
            ((ArrayList) r106).addAll(r108);
            r104.notifyDataSetChanged();
            LoadingStatusView r110 = (LoadingStatusView) this.f67260a.S90(R.id.loading_view);
            if (r110 == null) goto L15;
            r110.reset();
        L15:
            this.f67260a.V90();
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveComposerFilterFragment f67261a;

        public d(LiveComposerFilterFragment r100) {
            this.f67261a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r100 = (RecyclerView) this.f67261a.S90(R.id.rcl_filter);     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.scrollToPosition(this.f67261a.T90().f67224d);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e implements ILiveEffectComposerManager.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveComposerFilterFragment f67262a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f67263a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f67264b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Sticker f67265c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f67266d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ float f67267e;

            public a(e r100, String r101, Sticker r102, String r103, float r104) {
                this.f67263a = r100;
                this.f67264b = r101;
                this.f67265c = r102;
                this.f67266d = r103;
                this.f67267e = r104;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LiveComposerFilterFragment r100 = this.f67263a.f67262a;     // Catch: Throwable -> L4
                int r101 = LiveComposerFilterFragment.f67245q;     // Catch: Throwable -> L4
                LiveComposerFilterAdapter r102 = r100.T90();     // Catch: Throwable -> L4
                String r103 = this.f67264b;     // Catch: Throwable -> L4
                Sticker r104 = this.f67265c;     // Catch: Throwable -> L4
                String r105 = this.f67266d;     // Catch: Throwable -> L4
                float r106 = this.f67267e;     // Catch: Throwable -> L4
                r102.getClass();     // Catch: Throwable -> L4
                ILiveEffectComposerManager.c.a.a(r102, r103, r104, r105, r106);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public e(LiveComposerFilterFragment r100) {
            this.f67262a = r100;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
        public final void F(String r100, Sticker r101, String r102, float r103) {
            ILiveEffectComposerManager.c.a.a(this, r100, r101, r102, r103);
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
        public final void u2(String r100, Sticker r101, String r110, float r111, HashMap<String, String> r112) {
            LiveComposerFilterFragment r113 = this.f67262a;
            if (r113.f67258p == true) goto L5;
            return;
        L5:
            if (r113.f67248f == false) goto L11;
            RecyclerView r114 = (RecyclerView) r113.S90(R.id.rcl_filter);
            if (r114 == null) goto L12;
            r114.post(new a(this, r100, r101, r110, r111));
            return;
        L12:
            return;
        }
    }

    static {
    }

    public final LiveComposerFilterAdapter T90() {
        return (LiveComposerFilterAdapter) this.f67252j.getValue();
    }

    public final LiveComposerFilterHelper U90() {
        return (LiveComposerFilterHelper) this.f67250h.getValue();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        List<String> r100 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67255m).a().K(this.f67249g);
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ((n) this.f67251i.getValue()).a(this.f67253k, d0.f66762l);
        super.onDestroyView();
        ((LinkedHashMap) this.f67246d).clear();
    }

    public final void V90() {
        LiveComposerFilterAdapter r100 = T90();
        int r101 = r100.f67224d;
        if (r101 >= 0) goto L5;
    L23:
        r100.notifyDataSetChanged();
    L24:
        List<String> r102 = LiveEffectContext.f66734h;
        LiveEffectContextFactoryDelegate$Type r103 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        ILiveEffectComposerManager r104 = LiveEffectContext.a.a(r103).a();
        String r105 = d0.f66751a;
        if (r104.U(r105) <= 0) goto L27;
        boolean r106 = true;
    L28:
        View r107 = S90(R.id.toast_view);
        if (r107 == null) goto L34;
        if (r106 == false) goto L32;
        int r108 = 0;
    L33:
        r107.setVisibility(r108);
        goto L34
    L32:
        r108 = 4;
    L34:
        ul r109 = ul.f121383a;
        if (r109.getValue() != null) goto L37;
    L41:
        boolean r110 = false;
    L42:
        if (r110 == true) goto L44;
    L55:
        boolean r111 = false;
    L56:
        T90().f67223c = !r111;
        if (r106 == true) goto L63;
        if (r111 == true) goto L63;
        RecyclerView r112 = (RecyclerView) S90(R.id.rcl_filter);
        if (r112 == null) goto L67;
        r112.setAlpha(1.0f);
    L67:
        if (LiveEffectContext.a.a(r103).a().U(r105) <= 0) goto L69;
        boolean r113 = true;
    L70:
        LiveComposerFilterAdapter r114 = T90();
        int r115 = r114.f67224d;
        if (r115 >= 0) goto L73;
    L76:
        Sticker r116 = new Sticker();
    L78:
        if (this.f67258p == false) goto L99;
        if (r113 == true) goto L95;
        Sticker.ComposerConfig r117 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r116.getComposerConfigList());
        if (r117 == null) goto L92;
        BeautifyAdjustPercentBar r118 = (BeautifyAdjustPercentBar) S90(R.id.filter_seek_bar_new);
        if (r118 == null) goto L86;
        r118.Y5(100, 0, r117.getDefaultValue(), true);
    L86:
        BeautifyAdjustPercentBar r119 = (BeautifyAdjustPercentBar) S90(R.id.filter_seek_bar_new);
        if (r119 == null) goto L89;
        r119.setPercent(U90().c(r116, r117));
    L89:
        BeautifyAdjustPercentBar r120 = (BeautifyAdjustPercentBar) S90(R.id.filter_seek_bar_new);
        if (r120 == null) goto L117;
        r120.setVisibility(0);
    L117:
        RecyclerView r121 = (RecyclerView) S90(R.id.rcl_filter);
        if (r121 == null) goto L123;
        r121.post(new d(this));
        return;
    L123:
        return;
    L92:
        BeautifyAdjustPercentBar r122 = (BeautifyAdjustPercentBar) S90(R.id.filter_seek_bar_new);
        if (r122 == null) goto L117;
        r122.setVisibility(4);
        goto L117
    L95:
        BeautifyAdjustPercentBar r123 = (BeautifyAdjustPercentBar) S90(R.id.filter_seek_bar_new);
        if (r123 == null) goto L117;
        r123.setVisibility(4);
        goto L117
    L99:
        if (r113 == true) goto L114;
        Sticker.ComposerConfig r124 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r116.getComposerConfigList());
        if (r124 == null) goto L111;
        AdjustPercentBar r125 = (AdjustPercentBar) S90(R.id.filter_seek_bar);
        if (r125 == null) goto L105;
        r125.setPercent(U90().c(r116, r124));
    L105:
        AdjustPercentBar r126 = (AdjustPercentBar) S90(R.id.filter_seek_bar);
        if (r126 == null) goto L108;
        r126.e(100, 0, r124.getDefaultValue(), true);
    L108:
        AdjustPercentBar r127 = (AdjustPercentBar) S90(R.id.filter_seek_bar);
        if (r127 == null) goto L117;
        r127.setVisibility(0);
        goto L117
    L111:
        AdjustPercentBar r128 = (AdjustPercentBar) S90(R.id.filter_seek_bar);
        if (r128 == null) goto L117;
        r128.setVisibility(4);
        goto L117
    L114:
        AdjustPercentBar r129 = (AdjustPercentBar) S90(R.id.filter_seek_bar);
        if (r129 == null) goto L117;
        r129.setVisibility(4);
        goto L117
    L73:
        if (r115 >= r114.getItemCount()) goto L76;
        r116 = (Sticker) ListProtector.get(r114.f67221a, r114.f67224d);
        goto L78
    L69:
        r113 = false;
    L63:
        RecyclerView r130 = (RecyclerView) S90(R.id.rcl_filter);
        if (r130 == null) goto L67;
        r130.setAlpha(0.5f);
        goto L67
    L44:
        if (m90.b.D.c(r103).booleanValue() == false) goto L55;
        if (r109.getValue() != null) goto L48;
    L52:
        boolean r131 = false;
    L53:
        if (r131 == true) goto L55;
        r111 = true;
        goto L56
    L48:
        if (r109.getValue().a() == null) goto L52;
        Boolean r132 = r109.getValue().a();
        Intrinsics.checkNotNull(r132);
        if (r132.booleanValue() == false) goto L52;
        r131 = true;
        goto L53
    L37:
        if (r109.getValue().b() == null) goto L41;
        Boolean r133 = r109.getValue().b();
        Intrinsics.checkNotNull(r133);
        if (r133.booleanValue() == false) goto L41;
        r110 = true;
        goto L42
    L27:
        r106 = false;
        goto L28
    L5:
        if (r101 >= r100.getItemCount()) goto L23;
        List<String> r134 = LiveEffectContext.f66734h;
        Sticker r135 = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(r100.f67227g).a().o(d0.f66751a));
        if (r135 == null) goto L11;
        String r136 = r135.getResourceId();
        if (r136 == null) goto L11;
    L12:
        Iterator r137 = ((ArrayList) r100.f67221a).iterator();
        int r138 = 0;
    L14:
        if (r137.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(((Sticker) r137.next()).getResourceId(), r136) == true) goto L20;
        r138 = r138 + 1;
    L20:
        int r139 = r100.f67224d;
        if (r139 == r138) goto L24;
        r100.notifyItemChanged(r139);
        r100.notifyItemChanged(r138);
        r100.f67224d = r138;
        goto L24
    L19:
        r138 = -1;
    L11:
        r136 = "";
        goto L12
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        LiveComposerFilterAdapter r100 = T90();
        r100.getClass();
        List<String> r101 = LiveEffectContext.f66734h;
        LiveComposerFilterHelper r102 = LiveEffectContext.a.a(r100.f67227g).b().m();
        com.bytedance.android.live.effect.beauty.filter.a r103 = r100.f67225e;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (((ArrayList) r102.f67271c).contains(r103) == false) goto L6;
        ((ArrayList) r102.f67271c).remove(r103);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LiveComposerFilterAdapter r100 = T90();
        r100.getClass();
        List<String> r101 = LiveEffectContext.f66734h;
        LiveComposerFilterHelper r102 = LiveEffectContext.a.a(r100.f67227g).b().m();
        com.bytedance.android.live.effect.beauty.filter.a r103 = r100.f67225e;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (((ArrayList) r102.f67271c).contains(r103) == true) goto L6;
        ((ArrayList) r102.f67271c).add(r103);
        return;
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f67255m;
    }

    public final View S90(int r100) {
        if (this.f67246d != null) goto L5;
        this.f67246d = new LinkedHashMap();
    L5:
        View r101 = this.f67246d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f67246d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        if (r100 == true) goto L6;
        V90();
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_effect_broadcast_beauty_panel_error_layout, null);
        if (r102 == null) goto L5;
        r102.setOnClickListener(new com.bytedance.android.live.effect.beauty.filter.b(this));
    L5:
        LoadingStatusView r103 = (LoadingStatusView) S90(R.id.loading_view);
        if (r103 == null) goto L8;
        r103.setBuilder(new LoadingStatusView.Builder(getContext()).setErrorView(r102));
    L8:
        LoadingStatusView r104 = (LoadingStatusView) S90(R.id.loading_view);
        if (r104 == null) goto L11;
        r104.showLoading();
    L11:
        com.bytedance.android.live.effect.beauty.filter.d r105 = new com.bytedance.android.live.effect.beauty.filter.d(this);
        if (this.f67258p == false) goto L26;
        AdjustPercentBar r106 = (AdjustPercentBar) S90(R.id.filter_seek_bar);
        if (r106 == null) goto L16;
        r106.setVisibility(8);
    L16:
        BeautifyAdjustPercentBar r107 = (BeautifyAdjustPercentBar) S90(R.id.filter_seek_bar_new);
        if (r107 == null) goto L19;
        r107.setVisibility(0);
    L19:
        BeautifyAdjustPercentBar r108 = (BeautifyAdjustPercentBar) S90(R.id.filter_seek_bar_new);
        if (r108 != null) goto L22;
    L35:
        List<String> r109 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67255m).a().l(this.f67249g);
        RecyclerView r110 = (RecyclerView) S90(R.id.rcl_filter);
        if (r110 == null) goto L38;
        r110.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L38:
        RecyclerView.ItemDecoration r111 = this.f67256n.f532070b;
        if (r111 == null) goto L46;
        RecyclerView r112 = (RecyclerView) S90(R.id.rcl_filter);
        if (r112 == null) goto L46;
        if (this.f67247e == false) goto L45;
        r111 = new BeautyItemDecoration();
    L45:
        r112.addItemDecoration(r111);
    L46:
        RecyclerView r113 = (RecyclerView) S90(R.id.rcl_filter);
        if (r113 == null) goto L49;
        r113.setAdapter(T90());
    L49:
        View r114 = S90(R.id.toast_view);
        if (r114 == null) goto L53;
        r114.setOnClickListener(com.bytedance.android.live.effect.beauty.filter.c.f67275a);
    L53:
        if (this.f67258p == false) goto L60;
        RecyclerView r115 = (RecyclerView) S90(R.id.rcl_filter);
        if (r115 == null) goto L57;
        a1.k(r115, s1.f(102.0f));
    L57:
        RecyclerView r116 = (RecyclerView) S90(R.id.rcl_filter);
        if (r116 == null) goto L60;
        r116.addItemDecoration(new LiveComposerFilterFragment$initView$6());
    L60:
        V90();
        U90().d(this.f67254l, this.f67257o);
        if (((n) this.f67251i.getValue()).c() == false) goto L64;
        ((n) this.f67251i.getValue()).f(this.f67253k, d0.f66762l);
        return;
    L64:
        return;
    L22:
        if (this.f67247e == false) goto L24;
        int r117 = R.color.ttlive_effect_broadcast_beauty_template_seek_bar_progress_color_red;
    L25:
        r108.U5(s1.h(r117), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_progress_bg_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_circle_color));
        r108.setOnLevelChangeListener(r105);
        a1.l(r108, s1.f(69.0f));
        goto L35
    L24:
        r117 = R.color.ttlive_effect_broadcast_beauty_template_seek_bar_progress_color;
        goto L25
    L26:
        AdjustPercentBar r118 = (AdjustPercentBar) S90(R.id.filter_seek_bar);
        if (r118 == null) goto L29;
        r118.setVisibility(0);
    L29:
        BeautifyAdjustPercentBar r119 = (BeautifyAdjustPercentBar) S90(R.id.filter_seek_bar_new);
        if (r119 == null) goto L32;
        r119.setVisibility(8);
    L32:
        AdjustPercentBar r120 = (AdjustPercentBar) S90(R.id.filter_seek_bar);
        if (r120 == null) goto L35;
        r120.c(s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_progress_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_progress_bg_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_circle_color));
        r120.setDefaultCircleConfig(R.color.white);
        r120.setOnLevelChangeListener(r105);
        goto L35
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (this.f67247e == false) goto L5;
        int r103 = R.layout.ttlive_effect_fragment_composer_filter_v2;
    L7:
        return r100.inflate(r103, r101, false);
    L5:
        r103 = R.layout.ttlive_effect_fragment_composer_filter;
        goto L7
    }

    public LiveComposerFilterFragment(LiveEffectContextFactoryDelegate$Type r100, q90.b r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r102, "page");
        this.f67255m = r100;
        this.f67256n = r101;
        this.f67257o = r102;
        this.f67258p = r103;
        this.f67246d = new LinkedHashMap();
        this.f67249g = new e(this);
        this.f67250h = LazyKt.lazy(new LiveComposerFilterFragment$filterHelper$2(this));
        this.f67251i = LazyKt.lazy(new LiveComposerFilterFragment$beautyModeManager$2(this));
        this.f67252j = LazyKt.lazy(new LiveComposerFilterFragment$filterAdapter$2(this));
        this.f67253k = new b(this);
        this.f67254l = new c(this);
    }
}
