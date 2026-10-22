package com.bytedance.android.live.effect.beauty.makeups;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.bytedance.android.live.effect.q;
import com.bytedance.android.live.effect.utils.BeautyItemDecoration;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/makeups/LiveMakeupsBeautyFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMakeupsBeautyFragment extends BaseFragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f67314p = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f67315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Sticker f67316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f67317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f67318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, b> f67319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LiveEffectContextFactoryDelegate$Type f67320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f67321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f67322k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f67323l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f67324m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f67325n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f67326o;

    public static final class a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AdjustPercentBar f67327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f67328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Sticker f67329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Sticker.ComposerConfig f67330d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ LiveMakeupsBeautyFragment f67331e;

        public static final class a implements AdjustPercentBar.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f67332a;

            @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
            public final void a(int r100) {
            }

            @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
            public final void b() {
            }

            public a(b r100) {
                this.f67332a = r100;
            }

            @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
            public final void onChanged(int r100) {
                List<String> r101 = LiveEffectContext.f66734h;
                com.bytedance.android.live.effect.beauty.makeups.a r102 = LiveEffectContext.a.a(this.f67332a.f67331e.f67320i).b().f();
                b r103 = this.f67332a;
                com.bytedance.android.live.effect.beauty.makeups.d r104 = (com.bytedance.android.live.effect.beauty.makeups.d) r102;
                r104.e(r103.f67329c, r103.f67330d, r100);
                int r105 = com.bytedance.android.live.effect.beauty.smallitem.d.f67668e;
                com.bytedance.android.live.effect.beauty.smallitem.d.a.a(this.f67332a.f67331e.f67320i);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.makeups.LiveMakeupsBeautyFragment$b$b, reason: collision with other inner class name */
        public static final class C1109b implements AdjustPercentBar.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f67333a;

            @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
            public final void a(int r100) {
            }

            @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
            public final void b() {
            }

            public C1109b(b r100) {
                this.f67333a = r100;
            }

            @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
            public final void onChanged(int r100) {
                List<String> r101 = LiveEffectContext.f66734h;
                com.bytedance.android.live.effect.beauty.makeups.a r102 = LiveEffectContext.a.a(this.f67333a.f67331e.f67320i).b().f();
                b r103 = this.f67333a;
                com.bytedance.android.live.effect.beauty.makeups.d r104 = (com.bytedance.android.live.effect.beauty.makeups.d) r102;
                r104.e(r103.f67329c, r103.f67330d, r100);
                int r105 = com.bytedance.android.live.effect.beauty.smallitem.d.f67668e;
                com.bytedance.android.live.effect.beauty.smallitem.d.a.a(this.f67333a.f67331e.f67320i);
            }
        }

        public b(LiveMakeupsBeautyFragment r110, View r111, Sticker r112, Sticker.ComposerConfig r113) {
            Intrinsics.checkNotNullParameter(r111, "view");
            Intrinsics.checkNotNullParameter(r112, "sticker");
            Intrinsics.checkNotNullParameter(r113, "composerConfig");
            this.f67331e = r110;
            this.f67328b = r111;
            this.f67329c = r112;
            this.f67330d = r113;
            AdjustPercentBar r100 = (AdjustPercentBar) r111.findViewById(R.id.makeups_beauty_seek_bar);
            this.f67327a = r100;
            TextView r101 = (TextView) r111.findViewById(R.id.makeups_title);
            if ((r111 instanceof BeautifyAdjustPercentBar) == false) goto L14;
            if (r113.getDoubleDirection() == false) goto L7;
            ((BeautifyAdjustPercentBar) r111).Y5(50, -50, 0, false);
        L8:
            BeautifyAdjustPercentBar r114 = (BeautifyAdjustPercentBar) r111;
            if (r110.f67323l == false) goto L11;
            int r115 = R.color.ttlive_effect_broadcast_beauty_template_seek_bar_progress_color_red;
        L12:
            r114.U5(s1.h(r115), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_progress_bg_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_circle_color));
            r114.setOnLevelChangeListener(new a(this));
            r114.V5(true, r113.getName());
            return;
        L11:
            r115 = R.color.ttlive_effect_broadcast_beauty_template_seek_bar_progress_color;
            goto L12
        L7:
            ((BeautifyAdjustPercentBar) r111).Y5(100, 0, 0, true);
            goto L8
        L14:
            if (r113.getDoubleDirection() == false) goto L16;
            r100.e(50, -50, 0, false);
        L17:
            ((AdjustPercentBar) r111.findViewById(R.id.makeups_beauty_seek_bar)).c(s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_progress_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_progress_bg_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_circle_color));
            r100.setOnLevelChangeListener(new C1109b(this));
            r101.setText(r113.getName());
            return;
        L16:
            r100.e(100, 0, 0, true);
            goto L17
        }
    }

    public static final class c implements com.bytedance.android.live.effect.beauty.makeups.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveMakeupsBeautyFragment f67334a;

        @Override // com.bytedance.android.live.effect.beauty.makeups.a.c
        public final void onError() {
            LoadingStatusView r100 = (LoadingStatusView) this.f67334a.S90(R.id.makeups_beauty_loading_view);
            if (r100 == null) goto L6;
            r100.showError();
            return;
        }

        public c(LiveMakeupsBeautyFragment r100) {
            this.f67334a = r100;
        }

        @Override // com.bytedance.android.live.effect.beauty.makeups.a.c
        public final void onSuccess(List<Sticker> r100) {
            Intrinsics.checkNotNullParameter(r100, "stickerList");
            if (r100.isEmpty() == false) goto L5;
            LiveEffectMonitor.d(d0.f66761k, 1000, "empty list");
        L5:
            LiveMakeupsBeautyFragment r101 = this.f67334a;
            int r102 = LiveMakeupsBeautyFragment.f67314p;
            LiveMakeupsBeautyAdapter r103 = r101.T90();
            r103.getClass();
            Intrinsics.checkNotNullParameter(r100, "list");
            ((ArrayList) r103.f67296a).clear();
            ArrayList r104 = (ArrayList) r103.f67296a;
            r104.addAll(r100);
            ((ArrayList) r103.f67297b).clear();
            List<String> r105 = r103.f67297b;
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
            LiveMakeupsBeautyFragment r109 = this.f67334a;
            if (r109.f67321j == false) goto L15;
            LoadingStatusView r110 = (LoadingStatusView) r109.S90(R.id.makeups_beauty_loading_view);
            if (r110 == null) goto L17;
            r110.reset();
        L17:
            this.f67334a.V90();
            return;
        L15:
            if (r109.S90(R.id.makeups_beauty_loading_view) == null) goto L17;
            ((LoadingStatusView) this.f67334a.S90(R.id.makeups_beauty_loading_view)).setVisibility(8);
            goto L17
        }
    }

    public static final class d implements com.bytedance.android.live.effect.sticker.presenter.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveMakeupsBeautyFragment f67335a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LiveMakeupsBeautyFragment r100 = this.f67335a;
            int r101 = LiveMakeupsBeautyFragment.f67314p;
            r100.V90();
            this.f67335a.U90();
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            LiveMakeupsBeautyFragment r100 = this.f67335a;
            int r101 = LiveMakeupsBeautyFragment.f67314p;
            r100.getClass();
            List<String> r102 = LiveEffectContext.f66734h;
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(r100.f67320i).a(), d0.f66761k, "LiveMakeupsBeautyFragment_onBeautyModeChange");
            com.bytedance.android.live.effect.beauty.makeups.a r103 = LiveEffectContext.a.a(r100.f67320i).b().f();
            com.bytedance.android.live.effect.beauty.makeups.d r104 = (com.bytedance.android.live.effect.beauty.makeups.d) r103;
            r104.b(r100.f67326o);
        }

        public d(LiveMakeupsBeautyFragment r100) {
            this.f67335a = r100;
        }
    }

    public static final class e implements ILiveEffectComposerManager.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveMakeupsBeautyFragment f67336a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f67337a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f67338b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Sticker f67339c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f67340d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ float f67341e;

            public a(e r100, String r101, Sticker r102, String r103, float r104) {
                this.f67337a = r100;
                this.f67338b = r101;
                this.f67339c = r102;
                this.f67340d = r103;
                this.f67341e = r104;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LiveMakeupsBeautyFragment r100 = this.f67337a.f67336a;     // Catch: Throwable -> L4
                int r101 = LiveMakeupsBeautyFragment.f67314p;     // Catch: Throwable -> L4
                LiveMakeupsBeautyAdapter r102 = r100.T90();     // Catch: Throwable -> L4
                String r103 = this.f67338b;     // Catch: Throwable -> L4
                Sticker r104 = this.f67339c;     // Catch: Throwable -> L4
                String r105 = this.f67340d;     // Catch: Throwable -> L4
                float r106 = this.f67341e;     // Catch: Throwable -> L4
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

        public e(LiveMakeupsBeautyFragment r100) {
            this.f67336a = r100;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
        public final void F(String r100, Sticker r101, String r102, float r103) {
            ILiveEffectComposerManager.c.a.a(this, r100, r101, r102, r103);
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
        public final void u2(String r100, Sticker r101, String r110, float r111, HashMap<String, String> r112) {
            LiveMakeupsBeautyFragment r113 = this.f67336a;
            if (r113.f67321j == true) goto L5;
            return;
        L5:
            if (r113.f67322k == false) goto L11;
            RecyclerView r114 = (RecyclerView) r113.S90(R.id.makeups_beauty_recycle_view);
            if (r114 == null) goto L12;
            r114.post(new a(this, r100, r101, r110, r111));
            return;
        L12:
            return;
        }
    }

    static {
    }

    public final LiveMakeupsBeautyAdapter T90() {
        return (LiveMakeupsBeautyAdapter) this.f67317f.getValue();
    }

    public final void V90() {
        List<String> r100 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.beauty.makeups.d r101 = (com.bytedance.android.live.effect.beauty.makeups.d) LiveEffectContext.a.a(this.f67320i).b().f();
        r101.getClass();
        this.f67316e = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(r101.f67346c).a().o(d0.f66761k));
        com.bytedance.android.live.effect.beauty.makeups.a.C1110a.a(LiveEffectContext.a.a(this.f67320i).b().f(), this.f67316e, "ttlive_anchor_effect_LiveMakeupsBeautyFragment_resetSelectSticker_");
        LiveMakeupsBeautyAdapter r102 = T90();
        Sticker r103 = this.f67316e;
        int r104 = r102.f67298c;
        Iterator r105 = ((ArrayList) r102.f67296a).iterator();
        int r106 = 0;
    L4:
        if (r105.hasNext() == false) goto L9;
        if (((Sticker) r105.next()).equals(r103) == true) goto L10;
        r106 = r106 + 1;
    L10:
        int r107 = r106 + 1;
        r102.f67298c = r107;
        if (r107 >= 0) goto L13;
    L16:
        U90();
        return;
    L13:
        if (r107 >= r102.getItemCount()) goto L16;
        r102.notifyItemChanged(r104);
        r102.notifyItemChanged(r102.f67298c);
        goto L16
    L9:
        r106 = -1;
        goto L10
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        List<String> r100 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67320i).a().K(this.f67324m);
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        List<String> r100 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67320i).b().h().a(this.f67325n, d0.f66761k);
        super.onDestroyView();
        ((LinkedHashMap) this.f67315d).clear();
    }

    public LiveMakeupsBeautyFragment() {
        this.f67315d = new LinkedHashMap();
        this.f67317f = LazyKt.lazy(new LiveMakeupsBeautyFragment$makeupsAdapter$2(this));
        this.f67318g = LazyKt.lazy(new LiveMakeupsBeautyFragment$inflater$2(this));
        this.f67319h = new HashMap();
        this.f67320i = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f67324m = new e(this);
        this.f67325n = new d(this);
        this.f67326o = new c(this);
    }

    public final void U90() {
        LinearLayout r100 = (LinearLayout) S90(R.id.seek_bar_content);
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        List<String> r101 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().U(d0.f66761k) <= 0) goto L9;
        return;
    L9:
        if (getContext() != null) goto L11;
        return;
    L11:
        Sticker r102 = this.f67316e;
        if (r102 == null) goto L14;
        List<Sticker.ComposerConfig> r103 = r102.getComposerConfigList();
    L16:
        if (Lists.isEmpty(r103) == false) goto L18;
        return;
    L18:
        Sticker r104 = this.f67316e;
        if (r104 == null) goto L56;
        List<Sticker.ComposerConfig> r105 = r104.getComposerConfigList();
        if (r105 == null) goto L65;
        Iterator<T> r106 = r105.iterator();
    L24:
        if (r106.hasNext() == false) goto L66;
        Sticker.ComposerConfig r107 = (Sticker.ComposerConfig) r106.next();
        if (((HashMap) this.f67319h).containsKey(r107.getTag()) == true) goto L37;
        Context r108 = getContext();
        if (this.f67321j == false) goto L31;
        if (r108 == null) goto L31;
        View r109 = new BeautifyAdjustPercentBar(r108, null, 6, 0);
    L32:
        Sticker r110 = this.f67316e;
        Intrinsics.checkNotNull(r110);
        b r111 = new b(this, r109, r110, r107);
        Map<String, b> r112 = this.f67319h;
        Sticker r113 = this.f67316e;
        if (r113 == null) goto L35;
        String r114 = r113.getEffectId();
    L36:
        ((HashMap) r112).put(Intrinsics.stringPlus(r114, r107.getTag()), r111);
        goto L37
    L35:
        r114 = null;
    L31:
        r109 = ((LayoutInflater) this.f67318g.getValue()).inflate(R.layout.ttlive_effect_item_makeups_seek_bar, (ViewGroup) S90(R.id.seek_bar_content), false);
    L37:
        Map<String, b> r115 = this.f67319h;
        Sticker r116 = this.f67316e;
        if (r116 == null) goto L40;
        String r117 = r116.getEffectId();
    L41:
        b r118 = (b) ((HashMap) r115).get(Intrinsics.stringPlus(r117, r107.getTag()));
        if (r118 == null) goto L24;
        ((LinearLayout) S90(R.id.seek_bar_content)).addView(r118.f67328b);
        List<String> r119 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.beauty.makeups.a r120 = LiveEffectContext.a.a(this.f67320i).b().f();
        Sticker r121 = this.f67316e;
        if (r121 == null) goto L47;
        String r122 = r121.getEffectId();
        if (r122 == null) goto L47;
    L48:
        com.bytedance.android.live.effect.beauty.makeups.d r123 = (com.bytedance.android.live.effect.beauty.makeups.d) r120;
        r123.getClass();
        Intrinsics.checkNotNullParameter(r122, "effectId");
        Intrinsics.checkNotNullParameter(r107, "composerConfig");
        Float r124 = LiveEffectContext.a.a(r123.f67346c).a().G(r122, r107.getTag());
        if (r124 != null) goto L51;
        int r125 = r107.getDefaultValue();
    L52:
        View r126 = r118.f67328b;
        if ((r126 instanceof BeautifyAdjustPercentBar) == true) goto L54;
        r118.f67327a.setPercent(r125);
        goto L24
    L54:
        ((BeautifyAdjustPercentBar) r126).setPercent(r125);
        goto L24
    L51:
        r125 = q.a(r107, r124.floatValue());
    L47:
        r122 = "";
        goto L48
    L40:
        r117 = null;
        goto L41
    L66:
        return;
    L65:
        return;
    L56:
        return;
    L14:
        r103 = null;
        goto L16
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        LiveMakeupsBeautyAdapter r100 = T90();
        r100.getClass();
        List<String> r101 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.beauty.makeups.a r102 = LiveEffectContext.a.a(r100.f67303h).b().f();
        LiveMakeupsBeautyAdapter.b r103 = r100.f67301f;
        com.bytedance.android.live.effect.beauty.makeups.d r104 = (com.bytedance.android.live.effect.beauty.makeups.d) r102;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (r104.f67345b.contains(r103) == false) goto L5;
        r104.f67345b.remove(r103);
    L5:
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LiveMakeupsBeautyAdapter r100 = T90();
        r100.getClass();
        List<String> r101 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.beauty.makeups.a r102 = LiveEffectContext.a.a(r100.f67303h).b().f();
        LiveMakeupsBeautyAdapter.b r103 = r100.f67301f;
        com.bytedance.android.live.effect.beauty.makeups.d r104 = (com.bytedance.android.live.effect.beauty.makeups.d) r102;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (r104.f67345b.contains(r103) == true) goto L6;
        r104.f67345b.add(r103);
        return;
    }

    public final View S90(int r100) {
        if (this.f67315d != null) goto L5;
        this.f67315d = new LinkedHashMap();
    L5:
        View r101 = this.f67315d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f67315d.put(Integer.valueOf(r100), r103);
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
        r102.setOnClickListener(new com.bytedance.android.live.effect.beauty.makeups.c(this));
        ((LoadingStatusView) S90(R.id.makeups_beauty_loading_view)).setBuilder(new LoadingStatusView.Builder(getContext()).setErrorView(r102).setUseProgressBar(getResources().getDimensionPixelSize(R.dimen.ttlive_effect_default_list_progressbar_size)));
        if (this.f67321j == true) goto L5;
    L6:
        ((LoadingStatusView) S90(R.id.makeups_beauty_loading_view)).showLoading();
    L7:
        List<String> r103 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67320i).a().l(this.f67324m);
        if (this.f67321j == false) goto L10;
        ((RecyclerView) S90(R.id.makeups_beauty_recycle_view)).addItemDecoration(new LiveMakeupsBeautyFragment$initView$2());
    L10:
        RecyclerView r104 = (RecyclerView) S90(R.id.makeups_beauty_recycle_view);
        r104.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        r104.setAdapter(T90());
        if (this.f67323l == false) goto L14;
        r104.addItemDecoration(new BeautyItemDecoration());
    L14:
        if (this.f67321j == false) goto L16;
        a1.k(S90(R.id.makeups_beauty_recycle_view), s1.f(102.0f));
        a1.l(S90(R.id.seek_bar_content), s1.f(228.0f));
    L16:
        U90();
        com.bytedance.android.live.effect.beauty.makeups.a r105 = LiveEffectContext.a.a(this.f67320i).b().f();
        com.bytedance.android.live.effect.beauty.makeups.d r106 = (com.bytedance.android.live.effect.beauty.makeups.d) r105;
        r106.b(this.f67326o);
        V90();
        if (LiveEffectContext.a.a(this.f67320i).b().h().c() == false) goto L20;
        LiveEffectContext.a.a(this.f67320i).b().h().f(this.f67325n, d0.f66761k);
        return;
    L20:
        return;
    L5:
        if (((ArrayList) T90().f67296a).isEmpty() == false) goto L7;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (this.f67323l == false) goto L5;
        int r103 = R.layout.ttlive_effect_fragment_beauty_makeups_vcd_v2;
    L7:
        return r100.inflate(r103, r101, false);
    L5:
        r103 = R.layout.ttlive_effect_fragment_beauty_makeups_vcd;
        goto L7
    }
}
