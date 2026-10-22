package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import com.ss.texturerender.TextureRenderKeys;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveAnchorBeautifyLogHelper implements ILiveEffectComposerManager.e, ILiveEffectComposerManager.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Disposable> f68833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Disposable> f68834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Disposable> f68835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Long> f68836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, HashMap<String, Float>> f68837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, Sticker> f68838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, HashMap<String, String>> f68839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f68840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f68841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f68842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f68843k;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/effect/utils/LiveAnchorBeautifyLogHelper$Companion$AnchorBeautifyLogEventType;", "", "", "", "keyMap", "Ljava/util/Map;", "getKeyMap", "()Ljava/util/Map;", "SELECT", "EFFECTIVE_USE", "USE_TIME", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum AnchorBeautifyLogEventType extends Enum<AnchorBeautifyLogEventType> {
            public static final AnchorBeautifyLogEventType EFFECTIVE_USE = null;
            public static final AnchorBeautifyLogEventType SELECT = null;
            public static final AnchorBeautifyLogEventType USE_TIME = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ AnchorBeautifyLogEventType[] f68844a = null;
            private final Map<String, String> keyMap;

            static {
                String r100 = d0.f66759i;
                String r101 = d0.f66751a;
                String r110 = d0.f66761k;
                AnchorBeautifyLogEventType r102 = new AnchorBeautifyLogEventType("SELECT", 0, MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, "livesdk_beauty_select"), TuplesKt.to("livebody", "livesdk_anchor_beautybody_select"), TuplesKt.to(r101, "livesdk_filter_select"), TuplesKt.to(r110, "livesdk_makeup_select"), TuplesKt.to("live_adjustment", "livesdk_beauty_panel_item_select"), TuplesKt.to("live_camera_move", "livesdk_camera_movement_effect_click")}));
                SELECT = r102;
                AnchorBeautifyLogEventType r103 = new AnchorBeautifyLogEventType("EFFECTIVE_USE", 1, MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, "livesdk_live_take_beauty_effective_use"), TuplesKt.to("livebody", "livesdk_anchor_beautybody_select_effective_use"), TuplesKt.to(r101, "livesdk_live_take_filter_effective_use"), TuplesKt.to(r110, "livesdk_makeup_effective_use"), TuplesKt.to("live_camera_move", "livesdk_camera_movement_effect_effective_use"), TuplesKt.to("live_adjustment", "livesdk_beauty_panel_item_effective_use")}));
                EFFECTIVE_USE = r103;
                AnchorBeautifyLogEventType r104 = new AnchorBeautifyLogEventType("USE_TIME", 2, MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, "livesdk_beauty_use_time"), TuplesKt.to("livebody", "livesdk_beautybody_use_time"), TuplesKt.to(r101, "livesdk_filter_use_time"), TuplesKt.to(r110, "livesdk_makeup_use_time"), TuplesKt.to("live_camera_move", "livesdk_camera_movement_effect_use_time"), TuplesKt.to("live_adjustment", "livesdk_beauty_panel_item_use_time")}));
                USE_TIME = r104;
                f68844a = new AnchorBeautifyLogEventType[]{r102, r103, r104};
            }

            public static AnchorBeautifyLogEventType valueOf(String r100) {
                return (AnchorBeautifyLogEventType) r27.a.a(AnchorBeautifyLogEventType.class, r100);
            }

            public static AnchorBeautifyLogEventType[] values() {
                return (AnchorBeautifyLogEventType[]) f68844a.clone();
            }

            public final Map<String, String> getKeyMap() {
                return this.keyMap;
            }

            public AnchorBeautifyLogEventType(String r100, int r101, Map r102) {
                super(r100, r101);
                this.keyMap = r102;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/utils/LiveAnchorBeautifyLogHelper$Companion$UseTimeTriggerType;", "", "ADD", "REMOVE", "CHANGE_VALUE", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum UseTimeTriggerType extends Enum<UseTimeTriggerType> {
            public static final UseTimeTriggerType ADD = null;
            public static final UseTimeTriggerType CHANGE_VALUE = null;
            public static final UseTimeTriggerType REMOVE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ UseTimeTriggerType[] f68845a = null;

            static {
                UseTimeTriggerType r100 = new UseTimeTriggerType("ADD", 0);
                ADD = r100;
                UseTimeTriggerType r101 = new UseTimeTriggerType("REMOVE", 1);
                REMOVE = r101;
                UseTimeTriggerType r102 = new UseTimeTriggerType("CHANGE_VALUE", 2);
                CHANGE_VALUE = r102;
                f68845a = new UseTimeTriggerType[]{r100, r101, r102};
            }

            public static UseTimeTriggerType valueOf(String r100) {
                return (UseTimeTriggerType) r27.a.a(UseTimeTriggerType.class, r100);
            }

            public static UseTimeTriggerType[] values() {
                return (UseTimeTriggerType[]) f68845a.clone();
            }

            public UseTimeTriggerType(String r100, int r101) {
                super(r100, r101);
            }
        }
    }

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveAnchorBeautifyLogHelper f68846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f68847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Sticker f68848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ HashMap f68849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f68850e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ HashMap f68851f;

        public a(LiveAnchorBeautifyLogHelper r100, String r101, Sticker r102, HashMap r103, long r104, HashMap r105) {
            this.f68846a = r100;
            this.f68847b = r101;
            this.f68848c = r102;
            this.f68849d = r103;
            this.f68850e = r104;
            this.f68851f = r105;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            if (this.f68846a.f68836d.containsKey(this.f68847b) == false) goto L6;
            this.f68846a.n(this.f68847b, this.f68848c, this.f68849d);
            this.f68846a.f68836d.remove(this.f68847b);
        L6:
            if (this.f68846a.g() == true) goto L8;
            return;
        L8:
            if (this.f68846a.h(this.f68848c) == false) goto L12;
            this.f68846a.f68836d.put(this.f68847b, Long.valueOf(this.f68850e));
            this.f68846a.f68837e.put(this.f68847b, this.f68851f);
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveAnchorBeautifyLogHelper f68852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Sticker f68853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HashMap f68854c;

        public b(LiveAnchorBeautifyLogHelper r100, Sticker r101, HashMap r102) {
            this.f68852a = r100;
            this.f68853b = r101;
            this.f68854c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            LiveAnchorBeautifyLogHelper r102 = this.f68852a;
            r102.o(Companion.AnchorBeautifyLogEventType.EFFECTIVE_USE, r102.j(this.f68853b, this.f68854c));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveAnchorBeautifyLogHelper f68855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Sticker f68856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HashMap f68857c;

        public c(LiveAnchorBeautifyLogHelper r100, Sticker r101, HashMap r102) {
            this.f68855a = r100;
            this.f68856b = r101;
            this.f68857c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            LiveAnchorBeautifyLogHelper r102 = this.f68855a;
            r102.o(Companion.AnchorBeautifyLogEventType.SELECT, r102.j(this.f68856b, this.f68857c));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r100, Sticker r101, String r102, float r103) {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
    public final void a(String r100, Sticker r101) {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
    public final void b(boolean r100, String r101, Sticker r102) {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.e
    public final void e(String r100, Sticker r101) {
    }

    public final boolean g() {
        String r100 = this.f68841i;
        if (Intrinsics.areEqual(r100, d0.f66759i) == false) goto L6;
        return m90.b.f512543a.c(this.f68843k).booleanValue();
    L6:
        if (Intrinsics.areEqual(r100, "livebody") == false) goto L9;
        return m90.b.f512552j.c(this.f68843k).booleanValue();
    L9:
        if (Intrinsics.areEqual(r100, "live_adjustment") == true) goto L15;
        return true;
    L15:
        return m90.b.f512544b.c(this.f68843k).booleanValue();
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f68843k;
    }

    public final boolean h(Sticker r100) {
        List<Sticker.ComposerConfig> r101 = r100.getComposerConfigList();
        if (LiveEffectSettings.LIVE_SMALL_BEAUTY_ITEM_LOG_OPT.getValue().booleanValue() == false) goto L9;
        if (Intrinsics.areEqual(this.f68841i, d0.f66759i) == false) goto L9;
        return !r101.isEmpty();
    L9:
        if (r101.isEmpty() == false) goto L11;
        return false;
    L11:
        Iterator<Sticker.ComposerConfig> r102 = r101.iterator();
    L13:
        if (r102.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(((ILiveEffectComposerManager) this.f68840h.getValue()).G(r100.getEffectId(), r102.next().getTag()), 0.0f) == false) goto L13;
        return false;
    L17:
        return true;
    }

    public final HashMap<String, Float> i(Sticker r100) {
        HashMap<String, Float> r101 = new HashMap();
        Iterator<T> r102 = r100.getComposerConfigList().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Sticker.ComposerConfig r103 = (Sticker.ComposerConfig) r102.next();
        r101.put(r103.getTag(), ((ILiveEffectComposerManager) this.f68840h.getValue()).G(r100.getEffectId(), r103.getTag()));
        goto L4
    L6:
        return r101;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.k
    public final void c(List<com.bytedance.android.live.effect.composer.n> r100, Map<String, ? extends List<Sticker>> r101) {
        Intrinsics.checkNotNullParameter(r100, "sortList");
        Intrinsics.checkNotNullParameter(r101, "allStickerList");
        Intrinsics.checkNotNullParameter(r100, "sortList");
        Intrinsics.checkNotNullParameter(r101, "allStickerList");
        Intrinsics.checkNotNullParameter(r100, "sortList");
        Intrinsics.checkNotNullParameter(r101, "allStickerList");
    }

    public final HashMap<String, String> j(Sticker r100, HashMap<String, String> r101) {
        HashMap<String, String> r102 = new HashMap();
        if (r101 != null) goto L5;
    L7:
        String r103 = "0";
    L8:
        r102.put("is_live_take_default", r103);
        String r104 = "";
        if (r101 != null) goto L11;
    L16:
        r102.put(MobConstants.EFFECT_ID, r100.getEffectId());
        String r105 = r100.getName();
        if (r105 == null) goto L20;
        r104 = r105;
    L20:
        r102.put(MobConstants.EFFECT_NAME, r104);
        if (Intrinsics.areEqual(this.f68841i, "live_adjustment") == true) goto L36;
    L34:
        f(r102, i(r100), r100);
        return r102;
    L36:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L32
        List<String> r107 = LiveEffectContext.f66734h;     // Catch: Throwable -> L32
        Iterator r108 = ((CopyOnWriteArrayList) LiveEffectContext.a.a(this.f68843k).b().n().f66849b).iterator();     // Catch: Throwable -> L32
        int r109 = 0;
    L24:
        if (r108.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(((Sticker) r108.next()).getEffectId(), r100.getEffectId()) == true) goto L30;
        r109 = r109 + 1;     // Catch: Throwable -> L32
    L30:
        r102.put(TextureRenderKeys.KEY_IS_EFFECT_ORDER, String.valueOf(r109));     // Catch: Throwable -> L32
        r102.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "adjust");     // Catch: Throwable -> L32
        Result.m9449constructorimpl(r102.put("live_type", "video_live"));     // Catch: Throwable -> L32
        goto L34
    L29:
        r109 = -1;
    L32:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L11:
        if (r101.containsKey("action_type") != true) goto L16;
        String r111 = r101.get("action_type");
        if (r111 != null) goto L15;
        r111 = "";
    L15:
        r102.put("action_type", r111);
        goto L16
    L5:
        if (r101.containsKey("is_restore") != true) goto L7;
        r103 = "1";
        goto L8
    }

    public final void o(Companion.AnchorBeautifyLogEventType r100, HashMap<String, String> r101) {
        String r102 = r100.getKeyMap().get(this.f68841i);
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if (r102.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        com.bytedance.android.live.effect.utils.c.a(r102, r101, this.f68842j);
        return;
    L8:
        r103 = false;
        goto L9
    }

    public LiveAnchorBeautifyLogHelper(String r100, String r101, LiveEffectContextFactoryDelegate$Type r102) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "eventPage");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f68841i = r100;
        this.f68842j = r101;
        this.f68843k = r102;
        new CompositeDisposable();
        this.f68833a = new HashMap();
        this.f68834b = new HashMap();
        this.f68835c = new HashMap();
        this.f68836d = new HashMap();
        this.f68837e = new HashMap();
        this.f68838f = new HashMap();
        this.f68839g = new HashMap();
        this.f68840h = LazyKt.lazy(new LiveAnchorBeautifyLogHelper$composerManager$2(this));
    }

    public final void f(HashMap<String, String> r110, HashMap<String, Float> r111, Sticker r112) {
        HashMap<String, Float> r100 = r111;
        List<Sticker.ComposerConfig> r101 = r112.getComposerConfigList();
        if (r101.size() != 1) goto L15;
        Sticker.ComposerConfig r102 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r101);
        if (r102 != null) goto L7;
        return;
    L7:
        Float r103 = r100.get(r102.getTag());
        float r104 = com.bytedance.android.live.effect.q.c(r102, r102.getDefaultValue());
        if (Intrinsics.areEqual(this.f68841i, "live_adjustment") == false) goto L13;
        if (r103 == null) goto L11;
        float r105 = r103.floatValue();
    L12:
        r110.put("effect_value", String.valueOf(com.bytedance.android.live.effect.q.a(r102, r105)));
        r110.put(ComposerHelper.COMPOSER_DEFAULT_VALUE, String.valueOf(r102.getDefaultValue()));
    L14:
        boolean r106 = Intrinsics.areEqual(r103, r104);
    L23:
        if (r106 == false) goto L25;
        String r107 = "1";
    L26:
        r110.put("is_default_value", r107);
        return;
    L25:
        r107 = "0";
        goto L26
    L11:
        r105 = 0.0f;
        goto L12
    L13:
        r110.put("effect_value", String.valueOf(r103));
        r110.put(ComposerHelper.COMPOSER_DEFAULT_VALUE, String.valueOf(r104));
        goto L14
    L15:
        ArrayList r108 = new ArrayList();
        ArrayList r109 = new ArrayList();
        Iterator<T> r113 = r101.iterator();
        boolean r114 = true;
    L17:
        if (r113.hasNext() == false) goto L22;
        Sticker.ComposerConfig r115 = (Sticker.ComposerConfig) r113.next();
        Float r116 = r100.get(r115.getTag());
        HashMap r117 = new HashMap();
        r117.put("type", r115.getTag());
        r117.put("name", r115.getName());
        r117.put("value", String.valueOf(r116));
        Unit r118 = Unit.INSTANCE;
        r108.add(r117);
        float r119 = com.bytedance.android.live.effect.q.c(r115, r115.getDefaultValue());
        HashMap r120 = new HashMap();
        r120.put("type", r115.getTag());
        r120.put("name", r115.getName());
        r120.put("value", String.valueOf(r119));
        r109.add(r120);
        if ((!Intrinsics.areEqual(r116, r119)) == false) goto L21;
        r114 = false;
    L21:
        r100 = r111;
        goto L17
    L22:
        r110.put("effect_value", GsonProtectorUtils.toJson(GsonHelper.get(), r108));
        r110.put(ComposerHelper.COMPOSER_DEFAULT_VALUE, GsonProtectorUtils.toJson(GsonHelper.get(), r109));
        r106 = r114;
        goto L23
    }

    public final void l(String r100, Sticker r101, HashMap<String, String> r102) {
        Disposable r103 = this.f68833a.remove(r100);
        if (r103 == null) goto L6;
        r103.dispose();
    L6:
        if (g() == true) goto L8;
        return;
    L8:
        if (h(r101) == false) goto L13;
        this.f68833a.put(r100, Observable.timer(LiveEffectSettings.LIVE_FACE_STICKER_EFFECTIVELY_USE_TIME.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r101, r102)));
        return;
    }

    public final void m(String r100, Sticker r101, HashMap<String, String> r102) {
        Disposable r103 = this.f68834b.remove(r100);
        if (r103 == null) goto L6;
        r103.dispose();
    L6:
        if (g() == true) goto L8;
        return;
    L8:
        if (h(r101) == false) goto L13;
        this.f68834b.put(r100, Observable.timer(LiveEffectSettings.LIVE_BODY_BEAUTY_ADJUST_LOG_SQUASH_TIME.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r101, r102)));
        return;
    }

    public final void n(String r100, Sticker r101, HashMap<String, String> r102) {
        HashMap<String, String> r103 = j(r101, r102);
        long r104 = System.currentTimeMillis();
        Long r105 = this.f68836d.get(r100);
        if (r105 != null) goto L5;
        r105 = 0L;
    L5:
        r103.put("use_time", String.valueOf((r104 - r105.longValue()) / ((long) 1000)));
        HashMap<String, Float> r106 = this.f68837e.get(r100);
        if (r106 == null) goto L8;
        f(r103, r106, r101);
    L8:
        o(Companion.AnchorBeautifyLogEventType.USE_TIME, r103);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.e
    public final void d(boolean r100, String r101, Sticker r110, HashMap<String, String> r111) {
        if (Intrinsics.areEqual(r101, this.f68841i) == false) goto L19;
        if (r111 != null) goto L6;
    L7:
        if (r110 == null) goto L21;
        String r102 = r110.getEffectId();
        if (r100 == false) goto L11;
        this.f68838f.put(r102, r110);
        this.f68839g.put(r102, r111);
        m(r102, r110, r111);
        l(r102, r110, r111);
        k(r102, r110, r111, Companion.UseTimeTriggerType.ADD, i(r110));
        return;
    L11:
        this.f68838f.remove(r102);
        this.f68839g.remove(r102);
        Disposable r103 = this.f68834b.remove(r102);
        if (r103 == null) goto L14;
        r103.dispose();
    L14:
        Disposable r104 = this.f68833a.remove(r102);
        if (r104 == null) goto L17;
        r104.dispose();
    L17:
        k(r102, r110, r111, Companion.UseTimeTriggerType.REMOVE, i(r110));
        return;
    L21:
        return;
    L6:
        if (r111.containsKey("is_not_in_use") != true) goto L7;
        return;
    }

    public final void k(String r110, Sticker r111, HashMap<String, String> r112, Companion.UseTimeTriggerType r113, HashMap<String, Float> r114) {
        Disposable r100 = this.f68835c.remove(r110);
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        int r115 = h.f68872a[r113.ordinal()];
        if (r115 != 1) goto L8;
    L15:
        long r101 = System.currentTimeMillis();
        this.f68835c.put(r110, Observable.timer(LiveEffectSettings.LIVE_BODY_BEAUTY_ADJUST_LOG_SQUASH_TIME.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r110, r111, r112, r101, r114)));
        return;
    L8:
        if (r115 == 2) goto L15;
        if (r115 == 3) goto L13;
        return;
    L13:
        if (this.f68836d.containsKey(r110) == false) goto L17;
        n(r110, r111, r112);
        this.f68836d.remove(r110);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r100, Sticker r101, String r102, float r110, HashMap<String, String> r111) {
        if (Intrinsics.areEqual(r100, this.f68841i) == false) goto L17;
        if (r111 != null) goto L6;
    L7:
        if (r101 == null) goto L19;
        String r103 = r101.getEffectId();
        this.f68838f.put(r103, r101);
        this.f68839g.put(r103, r111);
        HashMap<String, String> r104 = new HashMap();
        if (r111 == null) goto L11;
        HashMap<String, String> r105 = r111;
    L12:
        r104.putAll(r105);
        if (Intrinsics.areEqual(this.f68841i, "live_adjustment") == false) goto L15;
        r104.put("action_type", BitableAnalytic.ProgressInputType.DRAG);
    L15:
        Unit r106 = Unit.INSTANCE;
        m(r103, r101, r104);
        l(r103, r101, r111);
        k(r103, r101, r111, Companion.UseTimeTriggerType.CHANGE_VALUE, i(r101));
        return;
    L11:
        r105 = new HashMap();
        goto L12
    L19:
        return;
    L6:
        if (r111.containsKey("is_not_in_use") != true) goto L7;
        return;
    }
}
