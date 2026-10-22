package com.bytedance.android.live.effect.avadjust;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.utils.BeautyWithSwitchItemDecoration;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/LiveColorAdjustFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "p", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveColorAdjustFragment extends BaseFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f66807r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f66808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Sticker f66809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f66810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.effect.sticker.e f66811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f66812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f66813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f66814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f66815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f66816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f66817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f66818n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f66819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f66820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f66821q;

    public static final class a {
    }

    public static final class b implements l.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveColorAdjustFragment f66822a;

        @Override // com.bytedance.android.live.effect.avadjust.l.c
        public final void onError() {
            LoadingStatusView r100 = (LoadingStatusView) this.f66822a.S90(R.id.small_item_beauty_loading_view);
            if (r100 == null) goto L5;
            r100.showError();
        L5:
            this.f66822a.f66811g.m();
        }

        public b(LiveColorAdjustFragment r100) {
            this.f66822a = r100;
        }

        @Override // com.bytedance.android.live.effect.avadjust.l.c
        public final void onSuccess(List<Sticker> r100) {
            Intrinsics.checkNotNullParameter(r100, "stickerList");
            if (r100.isEmpty() == false) goto L5;
            LiveEffectMonitor.d("live_adjustment", 1000, "empty list");
        L5:
            LiveColorAdjustFragment r101 = this.f66822a;
            int r102 = LiveColorAdjustFragment.f66807r;
            LiveColorAdjustAdapter r103 = r101.U90();
            r103.getClass();
            Intrinsics.checkNotNullParameter(r100, "list");
            ((ArrayList) r103.f66791a).clear();
            ArrayList r104 = (ArrayList) r103.f66791a;
            r104.addAll(r100);
            ((ArrayList) r103.f66792b).clear();
            List<String> r105 = r103.f66792b;
            List<Sticker> r106 = r100;
            ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
            Iterator<T> r108 = r106.iterator();
        L7:
            if (r108.hasNext() == false) goto L9;
            r107.add(((Sticker) r108.next()).getEffectId());
            goto L7
        L9:
            ((ArrayList) r105).addAll(r107);
            r103.notifyDataSetChanged();
            if (m90.b.f512544b.c(this.f66822a.getType()).booleanValue() == false) goto L13;
            LiveColorAdjustFragment r109 = this.f66822a;
            r109.f66809e = (Sticker) ListProtector.get(r100, 0);
        L13:
            if (this.f66822a.S90(R.id.small_item_beauty_loading_view) == null) goto L15;
            ((LoadingStatusView) this.f66822a.S90(R.id.small_item_beauty_loading_view)).setVisibility(8);
        L15:
            this.f66822a.V90("ttlive_anchor_effect_LiveColorAdjustFragment_colorAdjustLoadCallback_onSuccess");
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveColorAdjustFragment f66823a;

        public c(LiveColorAdjustFragment r100) {
            this.f66823a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveColorAdjustFragment r100 = this.f66823a;     // Catch: Throwable -> L4
            int r101 = LiveColorAdjustFragment.f66807r;     // Catch: Throwable -> L4
            r100.V90("onHiddenChanged");     // Catch: Throwable -> L4
            this.f66823a.T90();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements ILiveEffectComposerManager.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveColorAdjustFragment f66824a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f66825a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f66826b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Sticker f66827c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f66828d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ float f66829e;

            public a(d r100, String r101, Sticker r102, String r103, float r104) {
                this.f66825a = r100;
                this.f66826b = r101;
                this.f66827c = r102;
                this.f66828d = r103;
                this.f66829e = r104;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LiveColorAdjustFragment r100 = this.f66825a.f66824a;     // Catch: Throwable -> L4
                int r101 = LiveColorAdjustFragment.f66807r;     // Catch: Throwable -> L4
                LiveColorAdjustAdapter r102 = r100.U90();     // Catch: Throwable -> L4
                String r103 = this.f66826b;     // Catch: Throwable -> L4
                Sticker r104 = this.f66827c;     // Catch: Throwable -> L4
                String r105 = this.f66828d;     // Catch: Throwable -> L4
                float r106 = this.f66829e;     // Catch: Throwable -> L4
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

        public d(LiveColorAdjustFragment r100) {
            this.f66824a = r100;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
        public final void F(String r100, Sticker r101, String r102, float r103) {
            ILiveEffectComposerManager.c.a.a(this, r100, r101, r102, r103);
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
        public final void u2(String r100, Sticker r101, String r110, float r111, HashMap<String, String> r112) {
            LiveColorAdjustFragment r113 = this.f66824a;
            if (r113.f66813i == false) goto L8;
            RecyclerView r114 = (RecyclerView) r113.S90(R.id.small_item_beauty_recycle_view);
            if (r114 == null) goto L9;
            r114.post(new a(this, r100, r101, r110, r111));
            return;
        L9:
            return;
        }
    }

    public final LiveColorAdjustAdapter U90() {
        return (LiveColorAdjustAdapter) this.f66812h.getValue();
    }

    static {
        UtilityKotlinExtentionsKt.i(15);
    }

    public final void T90() {
        List<String> r100 = LiveEffectContext.f66734h;
        Iterator<T> r101 = LiveEffectContext.a.a(this.f66820p).a().o("live_adjustment").iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L21;
        Sticker r103 = (Sticker) r101.next();
        Sticker.ComposerConfig r104 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r103.getComposerConfigList());
        if (r104 == null) goto L8;
        int r105 = r104.getDefaultValue();
    L9:
        float r106 = com.bytedance.android.live.effect.q.d(r103, r105);
        List<String> r107 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r108 = LiveEffectContext.a.a(this.f66820p).a();
        String r109 = r103.getEffectId();
        Sticker.ComposerConfig r110 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r103.getComposerConfigList());
        if (r110 == null) goto L13;
        String r111 = r110.getTag();
        if (r111 == null) goto L13;
    L14:
        Float r112 = r108.G(r109, r111);
        if (r112 == null) goto L17;
        float r113 = r112.floatValue();
    L19:
        if (r113 == r106) goto L4;
        r102 = true;
        goto L4
    L17:
        r113 = 0.0f;
    L13:
        r111 = "";
        goto L14
    L8:
        r105 = 0;
        goto L9
    L21:
        ALogger.i("LiveColorAdjustFragment", "checkResetStatus newResetStatus = " + r102);
        this.f66817m = r102;
        if (r102 == false) goto L32;
        View r114 = this.f66816l;
        if (r114 == null) goto L26;
        r114.setClickable(true);
    L26:
        View r115 = this.f66816l;
        if (r115 == null) goto L29;
        r115.setAlpha(1.0f);
    L29:
        View r116 = this.f66816l;
        if (r116 == null) goto L47;
        r116.setContentDescription(s1.B(R.string.ttlive_effect_live_beauty_small_reset));
        return;
    L47:
        return;
    L32:
        View r117 = this.f66816l;
        if (r117 == null) goto L35;
        r117.setClickable(false);
    L35:
        View r118 = this.f66816l;
        if (r118 == null) goto L38;
        r118.setAlpha(0.5f);
    L38:
        View r119 = this.f66816l;
        if (r119 == null) goto L49;
        r119.setContentDescription(s1.B(R.string.ttlive_effect_live_beauty_small_reset_disable));
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        List<String> r100 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f66820p).a().K(this.f66819o);
        U90().f66793c = 0;
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f66808d.clear();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        LiveColorAdjustAdapter r100 = U90();
        r100.getClass();
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r100.f66801k).b().g().e(r100.f66797g);
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LiveColorAdjustAdapter r100 = U90();
        r100.getClass();
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r100.f66801k).b().g().a(r100.f66797g);
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f66820p;
    }

    public final View S90(int r100) {
        if (this.f66808d != null) goto L5;
        this.f66808d = new LinkedHashMap();
    L5:
        View r101 = this.f66808d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f66808d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void V90(String r100) {
        if (isDestroyed() == false) goto L6;
        return;
    L6:
        if (S90(R.id.color_adjust_seek_bar) != null) goto L9;
        return;
    L9:
        if (m90.b.f512544b.c(this.f66820p).booleanValue() == true) goto L16;
        ((AdjustPercentBar) S90(R.id.color_adjust_seek_bar)).setVisibility(8);
        if (S90(R.id.small_item_beauty_recycle_view) == null) goto L13;
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setAlpha(0.75f);
    L13:
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f66820p).a().T(r100, false);
        return;
    L16:
        if (S90(R.id.small_item_beauty_recycle_view) == null) goto L18;
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setAlpha(1.0f);
    L18:
        List<String> r102 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f66820p).a().T(r100, false);
        Sticker r103 = this.f66809e;
        Integer r104 = null;
        if (r103 == null) goto L21;
        Sticker.ComposerConfig r105 = r103.getSmallItemConfig();
    L22:
        if (r105 != null) goto L25;
        ((AdjustPercentBar) S90(R.id.color_adjust_seek_bar)).setVisibility(8);
        return;
    L25:
        ((AdjustPercentBar) S90(R.id.color_adjust_seek_bar)).setVisibility(0);
        AdjustPercentBar r106 = (AdjustPercentBar) S90(R.id.color_adjust_seek_bar);
        Sticker r107 = this.f66809e;
        if (r107 == null) goto L28;
        String r108 = r107.getName();
    L29:
        r106.setTag(r108);
        ILiveEffectComposerManager r109 = LiveEffectContext.a.a(this.f66820p).a();
        Sticker r110 = this.f66809e;
        String r111 = "";
        if (r110 == null) goto L33;
        String r112 = r110.getEffectId();
        if (r112 == null) goto L33;
    L34:
        Sticker r113 = this.f66809e;
        if (r113 == null) goto L42;
        Sticker.ComposerConfig r114 = r113.getSmallItemConfig();
        if (r114 == null) goto L42;
        String r115 = r114.getTag();
        if (r115 == null) goto L42;
        r111 = r115;
    L42:
        Float r116 = r109.G(r112, r111);
        if (r116 != null) goto L50;
        Sticker r117 = this.f66809e;
        Intrinsics.checkNotNull(r117);
        Sticker r118 = this.f66809e;
        if (r118 == null) goto L49;
        Sticker.ComposerConfig r119 = r118.getSmallItemConfig();
        if (r119 == null) goto L49;
        r104 = Integer.valueOf(r119.getDefaultValue());
    L49:
        Intrinsics.checkNotNull(r104);
        r116 = Float.valueOf(com.bytedance.android.live.effect.q.d(r117, r104.intValue()));
    L50:
        Sticker r120 = this.f66809e;
        Intrinsics.checkNotNull(r120);
        ((AdjustPercentBar) S90(R.id.color_adjust_seek_bar)).setPercent(com.bytedance.android.live.effect.q.b(r120, r116.floatValue()));
        Sticker r121 = this.f66809e;
        if (r121 == null) goto L57;
        Sticker.ComposerConfig r122 = r121.getSmallItemConfig();
        if (r122 == null) goto L57;
        if (r122.getDoubleDirection() != true) goto L57;
        ((AdjustPercentBar) S90(R.id.color_adjust_seek_bar)).e(50, -50, 0, false);
    L58:
        ILiveEffectComposerManager r123 = LiveEffectContext.a.a(this.f66820p).a();
        Sticker r124 = this.f66809e;
        Intrinsics.checkNotNull(r124);
        r123.a("live_adjustment", r124, "ttlive_anchor_effect_LiveColorAdjustFragment_refreshView");
        return;
    L57:
        ((AdjustPercentBar) S90(R.id.color_adjust_seek_bar)).e(100, 0, 0, true);
    L33:
        r112 = "";
        goto L34
    L28:
        r108 = null;
        goto L29
    L21:
        r105 = null;
        goto L22
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r100 == true) goto L10;
        View r101 = getView();
        if (r101 == null) goto L11;
        r101.post(new c(this));
        return;
    L11:
        return;
    }

    public LiveColorAdjustFragment(LiveEffectContextFactoryDelegate$Type r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "eventPage");
        this.f66820p = r100;
        this.f66821q = r101;
        this.f66808d = new LinkedHashMap();
        this.f66810f = R.layout.ttlive_effect_item_av_adjust_small_item;
        this.f66811g = new com.bytedance.android.live.effect.sticker.e("live_adjustment");
        this.f66812h = LazyKt.lazy(new LiveColorAdjustFragment$avAdjustAdapter$2(this));
        this.f66818n = new b(this);
        this.f66819o = new d(this);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LiveDoubleColorBallAnimationView r102 = null;
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.liveuikit_layout_loading_error, null);
        r103.setOnClickListener(new f(this));
        Context r104 = getContext();
        if (r104 == null) goto L5;
        r102 = new LiveDoubleColorBallAnimationView(r104);
        int r105 = r102.getResources().getDimensionPixelSize(R.dimen.ttlive_effect_default_list_progressbar_size);
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(r105, r105);
        r106.gravity = 17;
        r102.setLayoutParams(r106);
    L5:
        ((LoadingStatusView) S90(R.id.small_item_beauty_loading_view)).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r103).setLoadingView(r102));
        ((LoadingStatusView) S90(R.id.small_item_beauty_loading_view)).showLoading();
        ((AdjustPercentBar) S90(R.id.color_adjust_seek_bar)).c(s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_progress_color), s1.h(R.color.ttlive_effect_broadcast_av_adjust_seek_bar_progress_bg_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_circle_color));
        ((AdjustPercentBar) S90(R.id.color_adjust_seek_bar)).setDefaultCircleConfig(R.color.white);
        ((AdjustPercentBar) S90(R.id.color_adjust_seek_bar)).setDefaultCircleRadius(s1.f(3.0f));
        this.f66816l = S90(R.id.color_adjust_reset_view);
        this.f66814j = ((ConstraintLayout) S90(R.id.color_adjust_reset_view)).findViewById(R.id.icon);
        this.f66815k = ((ConstraintLayout) S90(R.id.color_adjust_reset_view)).findViewById(R.id.reset_text);
        ((AdjustPercentBar) S90(R.id.color_adjust_seek_bar)).setOnLevelChangeListener(new g(this));
        List<String> r107 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f66820p).a().l(this.f66819o);
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setAdapter(U90());
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).addItemDecoration(new BeautyWithSwitchItemDecoration());
        ((ConstraintLayout) S90(R.id.color_adjust_reset_view)).setOnClickListener(new h(this));
        V90("ttlive_anchor_effect_LiveColorAdjustFragment_colorAdjustInitView");
        T90();
        l.b(LiveEffectContext.a.a(this.f66820p).b().n(), this.f66818n);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_effect_fragment_av_adjust_small_item, r101, false);
    }
}
