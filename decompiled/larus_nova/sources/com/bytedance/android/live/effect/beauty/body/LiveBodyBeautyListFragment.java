package com.bytedance.android.live.effect.beauty.body;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.bytedance.android.live.effect.utils.BeautyWithSwitchItemDecoration;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/body/LiveBodyBeautyListFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBodyBeautyListFragment extends BaseFragment {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f67145y = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f67146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f67147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Sticker f67148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f67149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f67150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f67151i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f67152j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f67153k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LiveEffectContextFactoryDelegate$Type f67154l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f67155m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f67156n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f67157o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f67158p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f67159q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f67160r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final e f67161s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f67162t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f67163u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f67164v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f67165w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f67166x;

    public static final class a {
    }

    public static final class b implements LiveSmallItemBeautyHelper.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBodyBeautyListFragment f67167a;

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
        public final void onError() {
            LoadingStatusView r100 = (LoadingStatusView) this.f67167a.S90(R.id.small_item_beauty_loading_view);
            if (r100 == null) goto L6;
            r100.showError();
            return;
        }

        public b(LiveBodyBeautyListFragment r100) {
            this.f67167a = r100;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
        public final void onSuccess(List<Sticker> r100) {
            Intrinsics.checkNotNullParameter(r100, "stickerList");
            LiveBodyBeautyListFragment r101 = this.f67167a;
            int r102 = LiveBodyBeautyListFragment.f67145y;
            LiveBodyBeautyAdapter r103 = r101.U90();
            r103.getClass();
            Intrinsics.checkNotNullParameter(r100, "list");
            ((ArrayList) r103.f67116a).clear();
            ArrayList r104 = (ArrayList) r103.f67116a;
            r104.addAll(r100);
            ((ArrayList) r103.f67117b).clear();
            List<String> r105 = r103.f67117b;
            List<Sticker> r106 = r100;
            ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
            Iterator<T> r108 = r106.iterator();
        L4:
            if (r108.hasNext() == false) goto L6;
            r107.add(((Sticker) r108.next()).getEffectId());
            goto L4
        L6:
            ((ArrayList) r105).addAll(r107);
            r103.notifyDataSetChanged();
            LiveBodyBeautyListFragment r109 = this.f67167a;
            if (r109.f67148f != null) goto L12;
            if (m90.b.f512552j.c(r109.f67154l).booleanValue() == false) goto L12;
            LiveBodyBeautyListFragment r110 = this.f67167a;
            r110.f67148f = (Sticker) ListProtector.get(r100, 0);
        L12:
            if (this.f67167a.S90(R.id.small_item_beauty_loading_view) == null) goto L14;
            ((LoadingStatusView) this.f67167a.S90(R.id.small_item_beauty_loading_view)).setVisibility(8);
        L14:
            this.f67167a.X90();
        }
    }

    public static final class c implements com.bytedance.android.live.effect.sticker.presenter.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBodyBeautyListFragment f67168a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LiveBodyBeautyListFragment r100 = this.f67168a;
            int r101 = LiveBodyBeautyListFragment.f67145y;
            r100.X90();
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            LiveBodyBeautyListFragment r100 = this.f67168a;
            int r101 = LiveBodyBeautyListFragment.f67145y;
            r100.getClass();
            List<String> r102 = LiveEffectContext.f66734h;
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(r100.f67154l).a(), "livebody", "LiveBodyBeautyListFragment_onBeautyModeChange");
            LiveEffectContext.a.a(r100.f67154l).b().p().b(r100.f67166x);
        }

        public c(LiveBodyBeautyListFragment r100) {
            this.f67168a = r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBodyBeautyListFragment f67169a;

        public d(LiveBodyBeautyListFragment r100) {
            this.f67169a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            n90.b r101 = (n90.b) r100;
            if (Intrinsics.areEqual(r101.f518384a, "livebody") == false) goto L6;
            LiveBodyBeautyListFragment r102 = this.f67169a;
            r102.f67156n = true;
            r102.f67157o = r101.f518385b;
            return;
        }
    }

    public static final class e implements ILiveEffectComposerManager.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBodyBeautyListFragment f67170a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f67171a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f67172b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Sticker f67173c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f67174d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ float f67175e;

            public a(e r100, String r101, Sticker r102, String r103, float r104) {
                this.f67171a = r100;
                this.f67172b = r101;
                this.f67173c = r102;
                this.f67174d = r103;
                this.f67175e = r104;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LiveBodyBeautyListFragment r100 = this.f67171a.f67170a;     // Catch: Throwable -> L4
                int r101 = LiveBodyBeautyListFragment.f67145y;     // Catch: Throwable -> L4
                LiveBodyBeautyAdapter r102 = r100.U90();     // Catch: Throwable -> L4
                String r103 = this.f67172b;     // Catch: Throwable -> L4
                Sticker r104 = this.f67173c;     // Catch: Throwable -> L4
                String r105 = this.f67174d;     // Catch: Throwable -> L4
                float r106 = this.f67175e;     // Catch: Throwable -> L4
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

        public e(LiveBodyBeautyListFragment r100) {
            this.f67170a = r100;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
        public final void F(String r100, Sticker r101, String r102, float r103) {
            ILiveEffectComposerManager.c.a.a(this, r100, r101, r102, r103);
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
        public final void u2(String r100, Sticker r101, String r110, float r111, HashMap<String, String> r112) {
            LiveBodyBeautyListFragment r113 = this.f67170a;
            if (r113.f67155m == false) goto L7;
            if (r113.f67160r == false) goto L7;
        L10:
            RecyclerView r114 = (RecyclerView) r113.S90(R.id.small_item_beauty_recycle_view);
            if (r114 == null) goto L16;
            r114.post(new a(this, r100, r101, r110, r111));
            return;
        L16:
            return;
        L7:
            if (r113.f67158p == true) goto L9;
            return;
        L9:
            if (r113.f67160r == true) goto L10;
        }
    }

    static {
    }

    public final LiveBodyBeautyAdapter U90() {
        return (LiveBodyBeautyAdapter) this.f67159q.getValue();
    }

    public final View V90() {
        return (View) this.f67164v.getValue();
    }

    public final View W90() {
        return (View) this.f67163u.getValue();
    }

    public final void T90() {
        List<String> r100 = LiveEffectContext.f66734h;
        Iterator<T> r101 = LiveEffectContext.a.a(this.f67154l).a().o("livebody").iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L39;
        Sticker r103 = (Sticker) r101.next();
        float r104 = 0.0f;
        String r105 = "";
        if (this.f67155m == true) goto L7;
        Sticker.ComposerConfig r106 = r103.getSmallItemConfig();
        if (r106 == null) goto L26;
        int r107 = r106.getDefaultValue();
    L27:
        List<String> r108 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r109 = LiveEffectContext.a.a(this.f67154l).a();
        String r110 = r103.getEffectId();
        Sticker.ComposerConfig r111 = r103.getSmallItemConfig();
        if (r111 == null) goto L33;
        String r112 = r111.getTag();
        if (r112 == null) goto L33;
        r105 = r112;
    L33:
        Float r113 = r109.G(r110, r105);
        if (r113 == null) goto L37;
        r104 = r113.floatValue();
    L37:
        if (r104 <= r107) goto L4;
    L38:
        r102 = true;
        goto L4
    L26:
        r107 = 0;
        goto L27
    L7:
        Sticker.ComposerConfig r114 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r103.getComposerConfigList());
        if (r114 == null) goto L10;
        int r115 = r114.getDefaultValue();
    L11:
        float r116 = com.bytedance.android.live.effect.q.d(r103, r115);
        List<String> r117 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r118 = LiveEffectContext.a.a(this.f67154l).a();
        String r119 = r103.getEffectId();
        Sticker.ComposerConfig r120 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r103.getComposerConfigList());
        if (r120 == null) goto L17;
        String r121 = r120.getTag();
        if (r121 == null) goto L17;
        r105 = r121;
    L17:
        Float r122 = r118.G(r119, r105);
        if (r122 == null) goto L21;
        r104 = r122.floatValue();
    L21:
        if (r104 == r116) goto L4;
    L10:
        r115 = 0;
        goto L11
    L39:
        this.f67149g = r102;
        if (r102 == false) goto L42;
        V90().setClickable(true);
        V90().setAlpha(1.0f);
        V90().setContentDescription(s1.B(R.string.ttlive_effect_live_beauty_small_reset));
        return;
    L42:
        V90().setClickable(false);
        V90().setAlpha(0.5f);
        V90().setContentDescription(s1.B(R.string.ttlive_effect_live_beauty_small_reset_disable));
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        List<String> r100 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67154l).a().K(this.f67161s);
        super.onDestroy();
        Disposable r101 = this.f67147e;
        if (r101 != null) goto L5;
    L7:
        this.f67147e = null;
        return;
    L5:
        if (r101.isDisposed() == true) goto L7;
        r101.dispose();
        goto L7
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        List<String> r100 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67154l).b().h().a(this.f67162t, "livebody");
        super.onDestroyView();
        ((LinkedHashMap) this.f67146d).clear();
    }

    public LiveBodyBeautyListFragment() {
        this.f67146d = new LinkedHashMap();
        this.f67149g = true;
        this.f67152j = R.layout.ttlive_effect_item_external_beauty_small_item;
        this.f67153k = R.layout.ttlive_effect_item_beauty_small_item;
        this.f67154l = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        new com.bytedance.android.live.effect.sticker.e("beauty");
        this.f67159q = LazyKt.lazy(new LiveBodyBeautyListFragment$beautyAdapter$2(this));
        this.f67161s = new e(this);
        this.f67162t = new c(this);
        this.f67163u = LazyKt.lazy(new LiveBodyBeautyListFragment$smallItemBeautySeekBar$2(this));
        this.f67164v = LazyKt.lazy(new LiveBodyBeautyListFragment$smallItemBeautyResetView$2(this));
        this.f67166x = new b(this);
    }

    public final void X90() {
        if (W90() != null) goto L6;
        return;
    L6:
        if (m90.b.f512552j.c(this.f67154l).booleanValue() == true) goto L12;
        W90().setVisibility(8);
        RecyclerView r100 = (RecyclerView) S90(R.id.small_item_beauty_recycle_view);
        if (r100 == null) goto L10;
        r100.setAlpha(0.75f);
    L10:
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67154l).a().T("ttlive_anchor_effect_LiveBodyBeautyListFragment_refreshView_enable", false);
        return;
    L12:
        RecyclerView r102 = (RecyclerView) S90(R.id.small_item_beauty_recycle_view);
        if (r102 == null) goto L15;
        r102.setAlpha(1.0f);
    L15:
        List<String> r103 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67154l).a().T("ttlive_anchor_effect_LiveBodyBeautyListFragment_refreshView_disable", false);
        if (LiveEffectContext.a.a(this.f67154l).a().U("livebody") <= 0) goto L19;
        W90().setVisibility(8);
        return;
    L19:
        Sticker r104 = this.f67148f;
        View r105 = null;
        if (r104 == null) goto L22;
        Sticker.ComposerConfig r106 = r104.getSmallItemConfig();
    L23:
        if (r106 != null) goto L26;
        W90().setVisibility(8);
        return;
    L26:
        W90().setVisibility(0);
        View r107 = W90();
        Sticker r108 = this.f67148f;
        if (r108 == null) goto L29;
        String r109 = r108.getName();
    L30:
        r107.setTag(r109);
        ILiveEffectComposerManager r110 = LiveEffectContext.a.a(this.f67154l).a();
        Sticker r111 = this.f67148f;
        String r112 = "";
        if (r111 == null) goto L34;
        String r113 = r111.getEffectId();
        if (r113 == null) goto L34;
    L35:
        Sticker r114 = this.f67148f;
        if (r114 == null) goto L43;
        Sticker.ComposerConfig r115 = r114.getSmallItemConfig();
        if (r115 == null) goto L43;
        String r116 = r115.getTag();
        if (r116 == null) goto L43;
        r112 = r116;
    L43:
        Float r117 = r110.G(r113, r112);
        if (r117 != null) goto L52;
        Sticker r118 = this.f67148f;
        Intrinsics.checkNotNull(r118);
        Sticker r119 = this.f67148f;
        if (r119 == null) goto L50;
        Sticker.ComposerConfig r120 = r119.getSmallItemConfig();
        if (r120 == null) goto L50;
        Integer r121 = Integer.valueOf(r120.getDefaultValue());
    L51:
        Intrinsics.checkNotNull(r121);
        r117 = Float.valueOf(com.bytedance.android.live.effect.q.d(r118, r121.intValue()));
    L50:
        r121 = null;
    L52:
        Sticker r122 = this.f67148f;
        if (r122 == null) goto L75;
        Sticker.ComposerConfig r123 = r122.getSmallItemConfig();
        if (r123 == null) goto L75;
        if (r123.getDoubleDirection() != true) goto L75;
        if ((W90() instanceof BeautifyAdjustPercentBar) == false) goto L67;
        View r124 = W90();
        if ((r124 instanceof BeautifyAdjustPercentBar) == true) goto L63;
        r124 = null;
    L63:
        BeautifyAdjustPercentBar r125 = (BeautifyAdjustPercentBar) r124;
        if (r125 == null) goto L91;
        r125.Y5(50, -50, 0, false);
    L91:
        if ((W90() instanceof BeautifyAdjustPercentBar) == false) goto L100;
        View r126 = W90();
        if ((r126 instanceof BeautifyAdjustPercentBar) == false) goto L96;
        r105 = r126;
    L96:
        BeautifyAdjustPercentBar r127 = (BeautifyAdjustPercentBar) r105;
        if (r127 == null) goto L108;
        Sticker r128 = this.f67148f;
        Intrinsics.checkNotNull(r128);
        r127.setPercent(com.bytedance.android.live.effect.q.b(r128, r117.floatValue()));
    L108:
        Sticker r129 = this.f67148f;
        if (r129 == null) goto L112;
        LiveEffectContext.a.a(this.f67154l).a().a("livebody", r129, "ttlive_anchor_effect_LiveBodyBeautyListFragment_refreshView");
        return;
    L112:
        return;
    L100:
        if ((W90() instanceof AdjustPercentBar) == false) goto L108;
        View r130 = W90();
        if ((r130 instanceof AdjustPercentBar) == false) goto L105;
        r105 = r130;
    L105:
        AdjustPercentBar r131 = (AdjustPercentBar) r105;
        if (r131 == null) goto L108;
        Sticker r132 = this.f67148f;
        Intrinsics.checkNotNull(r132);
        r131.setPercent(com.bytedance.android.live.effect.q.b(r132, r117.floatValue()));
        goto L108
    L67:
        if ((W90() instanceof AdjustPercentBar) == false) goto L91;
        View r133 = W90();
        if ((r133 instanceof AdjustPercentBar) == true) goto L71;
        r133 = null;
    L71:
        AdjustPercentBar r134 = (AdjustPercentBar) r133;
        if (r134 == null) goto L91;
        r134.e(50, -50, 0, false);
    L75:
        if ((W90() instanceof BeautifyAdjustPercentBar) == false) goto L83;
        View r135 = W90();
        if ((r135 instanceof BeautifyAdjustPercentBar) == true) goto L79;
        r135 = null;
    L79:
        BeautifyAdjustPercentBar r136 = (BeautifyAdjustPercentBar) r135;
        if (r136 == null) goto L91;
        r136.Y5(100, 0, 0, true);
        goto L91
    L83:
        if ((W90() instanceof AdjustPercentBar) == false) goto L91;
        View r137 = W90();
        if ((r137 instanceof AdjustPercentBar) == true) goto L87;
        r137 = null;
    L87:
        AdjustPercentBar r138 = (AdjustPercentBar) r137;
        if (r138 == null) goto L91;
        r138.e(100, 0, 0, true);
    L34:
        r113 = "";
        goto L35
    L29:
        r109 = null;
        goto L30
    L22:
        r106 = null;
        goto L23
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        LiveBodyBeautyAdapter r100 = U90();
        r100.getClass();
        List<String> r101 = LiveEffectContext.f66734h;
        g r102 = LiveEffectContext.a.a(r100.f67127l).b().p();
        LiveBodyBeautyAdapter.c r103 = r100.f67123h;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (((ArrayList) r102.f67190b).contains(r103) == false) goto L5;
        ((ArrayList) r102.f67190b).remove(r103);
    L5:
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LiveBodyBeautyAdapter r100 = U90();
        r100.getClass();
        List<String> r101 = LiveEffectContext.f66734h;
        g r102 = LiveEffectContext.a.a(r100.f67127l).b().p();
        LiveBodyBeautyAdapter.c r103 = r100.f67123h;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (((ArrayList) r102.f67190b).contains(r103) == true) goto L6;
        ((ArrayList) r102.f67190b).add(r103);
        return;
    }

    public final View S90(int r100) {
        if (this.f67146d != null) goto L5;
        this.f67146d = new LinkedHashMap();
    L5:
        View r101 = this.f67146d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f67146d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.liveuikit_layout_loading_error, null);
        r102.setOnClickListener(new l(this));
        ((LoadingStatusView) S90(R.id.small_item_beauty_loading_view)).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r102).setUseProgressBar(getResources().getDimensionPixelSize(R.dimen.ttlive_effect_default_list_progressbar_size)));
        ((LoadingStatusView) S90(R.id.small_item_beauty_loading_view)).showLoading();
        if (this.f67158p == false) goto L5;
        int r103 = R.color.ttlive_effect_broadcast_beauty_template_seek_bar_progress_color_red;
    L7:
        if ((W90() instanceof BeautifyAdjustPercentBar) == false) goto L15;
        View r104 = W90();
        if ((r104 instanceof BeautifyAdjustPercentBar) == true) goto L11;
        r104 = null;
    L11:
        BeautifyAdjustPercentBar r105 = (BeautifyAdjustPercentBar) r104;
        if (r105 == null) goto L22;
        r105.U5(s1.h(r103), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_progress_bg_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_circle_color));
    L22:
        this.f67165w = V90().findViewById(R.id.reset_icon);
        TextView r106 = (TextView) V90().findViewById(R.id.reset_text);
        n r107 = new n(this);
        if ((W90() instanceof BeautifyAdjustPercentBar) == false) goto L31;
        View r108 = W90();
        if ((r108 instanceof BeautifyAdjustPercentBar) == true) goto L27;
        r108 = null;
    L27:
        BeautifyAdjustPercentBar r109 = (BeautifyAdjustPercentBar) r108;
        if (r109 == null) goto L38;
        r109.setOnLevelChangeListener(r107);
    L38:
        List<String> r110 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67154l).a().l(this.f67161s);
        RecyclerView r111 = (RecyclerView) S90(R.id.small_item_beauty_recycle_view);
        r111.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        r111.setAdapter(U90());
        if (this.f67158p == false) goto L42;
        r111.addItemDecoration(new BeautyWithSwitchItemDecoration());
    L42:
        if (this.f67155m == false) goto L47;
        View r112 = getView();
        if (r112 == null) goto L46;
        a1.k(r112, s1.f(102.0f));
    L46:
        a1.k(S90(R.id.small_item_beauty_recycle_view), s1.f(102.0f));
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).addItemDecoration(new LiveBodyBeautyListFragment$initView$2());
    L47:
        V90().setOnClickListener(new m(this));
        X90();
        T90();
        LiveEffectContext.a.a(this.f67154l).b().p().b(this.f67166x);
        if (LiveEffectContext.a.a(this.f67154l).b().h().c() == false) goto L50;
        LiveEffectContext.a.a(this.f67154l).b().h().f(this.f67162t, "livebody");
    L50:
        Disposable r113 = this.f67147e;
        if (r113 != null) goto L53;
    L55:
        this.f67147e = null;
        this.f67147e = xs2.b.a().b(n90.b.class).subscribe(new d(this));
        return;
    L53:
        if (r113.isDisposed() == true) goto L55;
        r113.dispose();
        goto L55
    L31:
        if ((W90() instanceof AdjustPercentBar) == false) goto L38;
        View r114 = W90();
        if ((r114 instanceof AdjustPercentBar) == true) goto L35;
        r114 = null;
    L35:
        AdjustPercentBar r115 = (AdjustPercentBar) r114;
        if (r115 == null) goto L38;
        r115.setOnLevelChangeListener(r107);
        goto L38
    L15:
        if ((W90() instanceof AdjustPercentBar) == false) goto L22;
        View r116 = W90();
        if ((r116 instanceof AdjustPercentBar) == true) goto L19;
        r116 = null;
    L19:
        AdjustPercentBar r117 = (AdjustPercentBar) r116;
        if (r117 == null) goto L22;
        r117.c(s1.h(r103), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_progress_bg_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_circle_color));
        goto L22
    L5:
        r103 = R.color.ttlive_effect_broadcast_beauty_template_seek_bar_progress_color;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (this.f67158p == false) goto L5;
        int r103 = R.layout.ttlive_effect_fragment_beauty_small_item_v2;
    L7:
        return r100.inflate(r103, r101, false);
    L5:
        r103 = R.layout.ttlive_effect_fragment_beauty_small_item;
        goto L7
    }
}
