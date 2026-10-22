package com.bytedance.android.live.effect.beauty.smallitem;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdk.config.wc0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import com.ss.android.ugc.effectmanager.effect.model.PanelInfoModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f67668e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<EffectCategoryModel>> f67669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Map<String, List<Sticker>>> f67670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Map<String, List<Effect>>> f67671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67672d;

    public static final class a {
        @JvmStatic
        public static void a(LiveEffectContextFactoryDelegate$Type r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            wc0 r101 = wc0.f121514a;
            if (r101.getValue().booleanValue() == false) goto L10;
            int r102 = com.bytedance.android.live.effect.beauty.newtemp.c.f67389d;
            Intrinsics.checkNotNullParameter(r100, "type");
            if (r101.getValue().booleanValue() == false) goto L14;
            m90.b.f512545c.e(r100, -1);
            com.bytedance.android.live.effect.utils.k.b();
            return;
        L14:
            return;
        L10:
            if (LiveEffectSettings.LIVE_ENABLE_STICKER_BEAUTY_TEMPLATE.getValue().booleanValue() == true) goto L12;
            return;
        L12:
            m90.b.f512545c.e(r100, -1);
            com.bytedance.android.live.effect.utils.k.b();
        }
    }

    public static final class b implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f67673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f67674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.effect.api.j f67675c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f67676d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ List f67677e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ q f67678f;

        @Override // com.bytedance.android.live.effect.beauty.smallitem.q
        public final void onError() {
            q r100 = this.f67678f;
            if (r100 == null) goto L6;
            r100.onError();
            return;
        }

        @Override // com.bytedance.android.live.effect.beauty.smallitem.q
        public final void a(List<Sticker> r100, List<Integer> r101) {
            Intrinsics.checkNotNullParameter(r100, "stickerList");
            Ref.IntRef r102 = this.f67676d;
            int r103 = r102.element + 1;
            r102.element = r103;
            if (r103 != this.f67677e.size()) goto L35;
            ArrayList r104 = new ArrayList();
            ArrayList r105 = new ArrayList();
            ArrayList r106 = new ArrayList();
            Map<String, Map<String, List<Effect>>> r107 = this.f67673a.f67671c;
            LinkedHashMap r108 = (LinkedHashMap) r107;
            Map r109 = (Map) r108.get(this.f67674b);
            if (r109 == null) goto L13;
            Collection r110 = r109.values();
            if (r110 == null) goto L13;
            Iterator r111 = r110.iterator();
        L10:
            if (r111.hasNext() == false) goto L13;
            r106.addAll((List) r111.next());
        L13:
            if (Intrinsics.areEqual(this.f67674b, "beautyclassify") == false) goto L15;
            this.f67675c.d().l(com.bytedance.android.live.effect.api.d0.f66759i, r106);
        L15:
            Iterator r112 = this.f67677e.iterator();
        L17:
            if (r112.hasNext() == false) goto L23;
            EffectCategoryModel r113 = (EffectCategoryModel) r112.next();
            Map<String, Map<String, List<Sticker>>> r114 = this.f67673a.f67670b;
            LinkedHashMap r115 = (LinkedHashMap) r114;
            Map r116 = (Map) r115.get(this.f67674b);
            if (r116 == null) goto L17;
            List r117 = (List) r116.get(r113.getKey());
            if (r117 == null) goto L17;
            r104.addAll(r117);
            r105.add(Integer.valueOf(r117.size()));
            goto L17
        L23:
            q r118 = this.f67678f;
            if (r118 == null) goto L36;
            r118.a(r104, r105);
            return;
        L36:
            return;
        }

        public b(d r100, String r101, com.bytedance.android.live.effect.api.j r102, Ref.IntRef r103, List r104, q r105) {
            this.f67673a = r100;
            this.f67674b = r101;
            this.f67675c = r102;
            this.f67676d = r103;
            this.f67677e = r104;
            this.f67678f = r105;
        }
    }

    public static final class c implements com.bytedance.android.live.effect.api.k.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f67679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f67680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.effect.api.j f67681c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WeakReference f67682d;

        @Override // com.bytedance.android.live.effect.api.k.d
        public final void onFetchFailed() {
            WeakReference r100 = this.f67682d;
            if (r100 == null) goto L8;
            com.bytedance.android.live.effect.beauty.smallitem.b r101 = (com.bytedance.android.live.effect.beauty.smallitem.b) r100.get();
            if (r101 == null) goto L9;
            r101.onError();
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.live.effect.api.k.d
        public final void a(PanelInfoModel r100, EffectDataFetchCacheType r101) {
            Intrinsics.checkNotNullParameter(r100, "panelInfo");
            Intrinsics.checkNotNullParameter(r101, "cacheType");
            ALogger.i("ttlive_anchor_effect_LiveBeautyMultiCategoryHelper", "on loadSmallItemBeautyData FetchSuccess");
            d r102 = this.f67679a;
            String r103 = this.f67680b;
            com.bytedance.android.live.effect.api.j r104 = this.f67681c;
            WeakReference r105 = this.f67682d;
            r102.getClass();
            if ((!r100.getCategory_list().isEmpty()) == false) goto L11;
            List<String> r106 = LiveEffectContext.f66734h;
            EffectCategoryModel r107 = LiveEffectContext.a.a(r102.f67672d).b().d().i(r103, r100);
            if (r107 != null) goto L10;
            if (r105 == null) goto L16;
            com.bytedance.android.live.effect.beauty.smallitem.b r108 = (com.bytedance.android.live.effect.beauty.smallitem.b) r105.get();
            if (r108 == null) goto L17;
            r108.onError();
            return;
        L17:
            return;
        L16:
            return;
        L10:
            r104.d().p(r103, r107.getKey(), r107.getChildren_categories(), true, new f(r102, r103, r104, r105));
            return;
        L11:
            if (r105 == null) goto L20;
            com.bytedance.android.live.effect.beauty.smallitem.b r109 = (com.bytedance.android.live.effect.beauty.smallitem.b) r105.get();
            if (r109 == null) goto L21;
            r109.onError();
            return;
        L21:
            return;
        }

        public c(d r100, String r101, com.bytedance.android.live.effect.api.j r102, WeakReference r103) {
            this.f67679a = r100;
            this.f67680b = r101;
            this.f67681c = r102;
            this.f67682d = r103;
        }
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f67672d;
    }

    public d(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f67672d = r100;
        LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG.getValue().getClass();
        this.f67669a = new LinkedHashMap();
        this.f67670b = new LinkedHashMap();
        this.f67671c = new LinkedHashMap();
    }

    public final void a(LiveEffectContextFactoryDelegate$Type r100, String r101, List<EffectCategoryModel> r102, q r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "panel");
        Intrinsics.checkNotNullParameter(r102, "models");
        List<String> r104 = LiveEffectContext.f66734h;
        b(r101, r102, LiveEffectContext.a.a(r100).b(), r103);
    }

    public final void b(String r110, List<EffectCategoryModel> r111, com.bytedance.android.live.effect.api.j r112, q r210) {
        Intrinsics.checkNotNullParameter(r110, "panel");
        Intrinsics.checkNotNullParameter(r111, "models");
        Intrinsics.checkNotNullParameter(r112, "iLiveEffectService");
        y50.c.f566208d.b("beauty_multi_load_effects");
        Ref.IntRef r113 = new Ref.IntRef();
        r113.element = 0;
        Iterator<T> r114 = r111.iterator();
    L4:
        if (r114.hasNext() == false) goto L11;
        String r115 = ((EffectCategoryModel) r114.next()).getKey();
        b r116 = new b(this, r110, r112, r113, r111, r210);
        Map r100 = (Map) ((LinkedHashMap) this.f67670b).get(r110);
        if (r100 == null) goto L10;
        List<Sticker> r101 = (List) r100.get(r115);
        if (r101 == null) goto L10;
        r116.a(r101, null);
    L10:
        r112.d().o(r110, r115, new e(this, r110, r115, r112, r116));
        goto L4
    L11:
        y50.c.f566208d.a("beauty_multi_load_effects");
    }

    public final void c(String r100, LiveEffectContextFactoryDelegate$Type r101, WeakReference<com.bytedance.android.live.effect.beauty.smallitem.b> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "type");
        List<String> r104 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.api.j r105 = LiveEffectContext.a.a(r101).b();
        if (r103 == true) goto L12;
        List<EffectCategoryModel> r106 = (List) ((LinkedHashMap) this.f67669a).get(r100);
        if (r106 == null) goto L12;
        if (r102 == null) goto L10;
        com.bytedance.android.live.effect.beauty.smallitem.b r107 = r102.get();
        if (r107 == null) goto L10;
        r107.onSuccess(r106);
    L10:
        b(r100, r106, r105, null);
        return;
    L12:
        r105.d().f(r100, new c(this, r100, r105, r102));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(d r100, String r101, LiveEffectContextFactoryDelegate$Type r102, WeakReference r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.c(r101, r102, r103, false);
    }
}
