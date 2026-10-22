package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.ICheckChannelListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchCategoryInfoListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectChannelListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchPanelInfoListener;
import com.ss.android.ugc.effectmanager.effect.model.CategoryEffectModel;
import com.ss.android.ugc.effectmanager.effect.model.CategoryInfoModelList;
import com.ss.android.ugc.effectmanager.effect.model.CategoryPageModel;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import com.ss.android.ugc.effectmanager.effect.model.PanelInfoModel;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveStickerDataManager implements o {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f68217m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, EffectChannelResponse> f68218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f68219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, EffectChannelResponse> f68220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, PanelInfoModel> f68221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, CopyOnWriteArrayList<o.d>> f68222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Map<String, CategoryInfoModelList>> f68223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Map<String, CategoryPageModel>> f68224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, List<Effect>> f68225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Long> f68226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Long> f68227j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f68228k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f68229l;

    public static final class a {
    }

    public static final class b implements ICheckChannelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveStickerDataManager f68230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f68231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f68232c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f68233d;

        @Override // com.ss.android.ugc.effectmanager.effect.listener.ICheckChannelListener
        public final void checkChannelFailed(ExceptionResult r100) {
            this.f68230a.q(this.f68231b, this.f68232c, this.f68233d, true);
        }

        @Override // com.ss.android.ugc.effectmanager.effect.listener.ICheckChannelListener
        public final void checkChannelSuccess(boolean r100) {
            this.f68230a.q(this.f68231b, this.f68232c, this.f68233d, r100);
        }

        public b(LiveStickerDataManager r100, AtomicBoolean r101, String r102, c r103) {
            this.f68230a = r100;
            this.f68231b = r101;
            this.f68232c = r102;
            this.f68233d = r103;
        }
    }

    public static final class c implements IFetchEffectChannelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveStickerDataManager f68234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f68235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f68236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f68237d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f68238e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f68239f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f68240g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ LiveStickerDataManager$fetchAllSticker$1 f68241h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.effect.api.k.i f68242i;

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectChannelListener
        public final void onFail(ExceptionResult r100) {
            String r101 = this.f68235b;
            if (r100 == null) goto L5;
            int r102 = r100.getErrorCode();
        L6:
            if (r100 == null) goto L9;
            String r103 = r100.getMsg();
            if (r103 == null) goto L9;
        L10:
            LiveEffectMonitor.d(r101, r102, r103);
            com.bytedance.android.live.effect.api.k.i r104 = this.f68242i;
            if (r104 == null) goto L14;
            r104.b();
            return;
        L14:
            return;
        L9:
            r103 = "";
            goto L10
        L5:
            r102 = -1;
            goto L6
        }

        @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
        public final void onSuccess(EffectChannelResponse r100) {
            EffectChannelResponse r101 = r100;
            if (r101 != null) goto L5;
        L28:
            LiveEffectMonitor.d(this.f68235b, 1000, "Empty effect list");
            return;
        L5:
            if (r101.getCategoryResponseList().isEmpty() == false) goto L10;
            if (r101.getAllCategoryEffects().isEmpty() == true) goto L28;
        L10:
            if (this.f68236c == true) goto L12;
        L17:
            this.f68234a.f68218a.put(this.f68235b, r101);
            if (this.f68238e.get() == false) goto L21;
            String r102 = this.f68235b;
            long r103 = System.currentTimeMillis() - this.f68239f;
            PthreadHandlerThreadV2 r104 = LiveEffectMonitor.f68860a;
            Intrinsics.checkNotNullParameter(r102, "panel");
            NewBroadcastMonitor.a r105 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_FETCH_EFFECT_LIST, null, null, 14);
            r105.l(0);
            r105.c(r102);
            r105.g("duration", r103);
            r105.a().report();
        L21:
            if (this.f68240g == false) goto L23;
            Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r106 = com.bytedance.android.live.effect.api.u.f66774a;
            com.bytedance.android.live.effect.api.u.c(this.f68234a.getType()).d(this.f68235b, r101.getAllCategoryEffects(), new LiveStickerDataManager$fetchAllSticker$fetchEffectChannelListener$1$onSuccess$1(this.f68234a));
        L23:
            LiveStickerDataManager$fetchAllSticker$1 r107 = this.f68241h;
            if (this.f68238e.get() == false) goto L26;
            EffectDataFetchCacheType r108 = EffectDataFetchCacheType.NoCache;
        L27:
            r107.invoke2(r101, r108);
            return;
        L26:
            r108 = EffectDataFetchCacheType.HitEPCache;
            goto L27
        L12:
            if (this.f68237d == false) goto L14;
            this.f68234a.f68220c.put(this.f68235b, r101);
            LiveStickerDataManager r109 = this.f68234a;
            Map<String, Integer> r110 = r109.f68219b;
            String r111 = this.f68235b;
            r110.put(r111, Integer.valueOf(r109.j(r111, "")));
        L14:
            r101.setAllCategoryEffects(this.f68234a.s(this.f68235b, r101));
            if (r101.getAllCategoryEffects().isEmpty() == false) goto L17;
            LiveEffectMonitor.d(this.f68235b, 1000, "Empty effect list after filter");
        }

        public c(LiveStickerDataManager r100, String r101, boolean r102, boolean r103, AtomicBoolean r104, long r105, boolean r106, LiveStickerDataManager$fetchAllSticker$1 r107, com.bytedance.android.live.effect.api.k.i r110) {
            this.f68234a = r100;
            this.f68235b = r101;
            this.f68236c = r102;
            this.f68237d = r103;
            this.f68238e = r104;
            this.f68239f = r105;
            this.f68240g = r106;
            this.f68241h = r107;
            this.f68242i = r110;
        }
    }

    public static final class d implements IFetchCategoryInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveStickerDataManager f68243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.effect.api.k.c f68244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f68245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f68246d;

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchCategoryInfoListener
        public final void onFail(ExceptionResult r100) {
            com.bytedance.android.live.effect.api.k.c r101 = this.f68244b;
            if (r101 == null) goto L5;
            r101.onFetchFailed();
        L5:
            String r102 = this.f68245c;
            if (r100 == null) goto L8;
            int r103 = r100.getErrorCode();
        L9:
            if (r100 == null) goto L11;
            String r104 = r100.getMsg();
        L12:
            LiveEffectMonitor.e(r102, r103, r104);
            return;
        L11:
            r104 = null;
            goto L12
        L8:
            r103 = -1;
            goto L9
        }

        @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
        public final void onSuccess(CategoryInfoModelList r100) {
            CategoryInfoModelList r101 = r100;
            if (r101 == null) goto L22;
            List<EffectCategoryModel> r102 = r101.getCategoryList();
            if (r102 != null) goto L7;
        L10:
            boolean r103 = true;
        L11:
            if (r103 == true) goto L22;
            Map<String, Map<String, CategoryInfoModelList>> r104 = this.f68243a.f68223f;
            LinkedHashMap r105 = (LinkedHashMap) r104;
            if (r105.get(this.f68245c) != null) goto L16;
            this.f68243a.f68223f.put(this.f68245c, new LinkedHashMap());
        L16:
            Map<String, Map<String, CategoryInfoModelList>> r106 = this.f68243a.f68223f;
            LinkedHashMap r107 = (LinkedHashMap) r106;
            Map r108 = (Map) r107.get(this.f68245c);
            if (r108 == null) goto L19;
            CategoryInfoModelList r109 = (CategoryInfoModelList) r108.put(this.f68246d, r101);
        L19:
            com.bytedance.android.live.effect.api.k.c r110 = this.f68244b;
            if (r110 == null) goto L26;
            r110.a(r101, EffectDataFetchCacheType.NoCache);
            return;
        L26:
            return;
        L7:
            if (r102.isEmpty() == true) goto L10;
            r103 = false;
        L22:
            com.bytedance.android.live.effect.api.k.c r111 = this.f68244b;
            if (r111 == null) goto L28;
            r111.onFetchFailed();
            return;
        }

        public d(LiveStickerDataManager r100, com.bytedance.android.live.effect.api.k.c r101, String r102, String r103) {
            this.f68243a = r100;
            this.f68244b = r101;
            this.f68245c = r102;
            this.f68246d = r103;
        }
    }

    public static final class e implements IFetchEffectChannelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveStickerDataManager f68247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IFetchEffectChannelListener f68248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f68249c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f68250d;

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectChannelListener
        public final void onFail(ExceptionResult r100) {
            this.f68247a.q(this.f68249c, this.f68250d, this.f68248b, true);
        }

        @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
        public final void onSuccess(EffectChannelResponse r100) {
            IFetchEffectChannelListener r101 = this.f68248b;
            r101.onSuccess(r100);
        }

        public e(LiveStickerDataManager r100, IFetchEffectChannelListener r101, AtomicBoolean r102, String r103) {
            this.f68247a = r100;
            this.f68248b = r101;
            this.f68249c = r102;
            this.f68250d = r103;
        }
    }

    public static final class f implements o.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o.b f68251a;

        public f(o.b r100) {
            this.f68251a = r100;
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.o.b
        public final void a(boolean r100) {
            this.f68251a.a(r100);
        }
    }

    public static final class g implements ICheckChannelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveStickerDataManager f68252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f68253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f68254c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f68255d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f68256e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f68257f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f68258g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f68259h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h f68260i;

        @Override // com.ss.android.ugc.effectmanager.effect.listener.ICheckChannelListener
        public final void checkChannelFailed(ExceptionResult r100) {
            this.f68254c.set(false);
            this.f68252a.t().fetchPanelInfo(this.f68255d, this.f68256e, this.f68257f, this.f68258g, this.f68259h, this.f68260i);
        }

        @Override // com.ss.android.ugc.effectmanager.effect.listener.ICheckChannelListener
        public final void checkChannelSuccess(boolean r110) {
            if (r110 == false) goto L4;
        L7:
            this.f68254c.set(false);
            if (this.f68253b == false) goto L10;
            this.f68252a.t().fetchPanelInfo(this.f68255d, this.f68256e, this.f68257f, this.f68258g, this.f68259h, true, null, this.f68260i);
            return;
        L10:
            this.f68252a.t().fetchPanelInfo(this.f68255d, this.f68256e, this.f68257f, this.f68258g, this.f68259h, this.f68260i);
            return;
        L4:
            if (this.f68253b == true) goto L7;
            this.f68254c.set(true);
            this.f68252a.t().fetchPanelInfoFromCache(this.f68255d, this.f68256e, this.f68257f, this.f68258g, this.f68259h, this.f68260i);
        }

        public g(LiveStickerDataManager r100, boolean r101, AtomicBoolean r102, String r103, boolean r104, String r105, int r106, int r107, h r108) {
            this.f68252a = r100;
            this.f68253b = r101;
            this.f68254c = r102;
            this.f68255d = r103;
            this.f68256e = r104;
            this.f68257f = r105;
            this.f68258g = r106;
            this.f68259h = r107;
            this.f68260i = r108;
        }
    }

    public static final class h implements IFetchPanelInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveStickerDataManager f68261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.effect.api.k.d f68262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f68263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f68264d;

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchPanelInfoListener
        public final void onFail(ExceptionResult r100) {
            com.bytedance.android.live.effect.api.k.d r101 = this.f68262b;
            if (r101 == null) goto L5;
            r101.onFetchFailed();
        L5:
            String r102 = this.f68263c;
            if (r100 == null) goto L8;
            int r103 = r100.getErrorCode();
        L9:
            if (r100 == null) goto L11;
            String r104 = r100.getMsg();
        L12:
            LiveEffectMonitor.e(r102, r103, r104);
            return;
        L11:
            r104 = null;
            goto L12
        L8:
            r103 = -1;
            goto L9
        }

        @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
        public final void onSuccess(PanelInfoModel r100) {
            PanelInfoModel r101 = r100;
            if (r101 != null) goto L5;
        L25:
            com.bytedance.android.live.effect.api.k.d r102 = this.f68262b;
            if (r102 == null) goto L28;
            r102.onFetchFailed();
        L28:
            LiveEffectMonitor.e(this.f68263c, 1000, "fetchPanelInfo empty result");
            return;
        L5:
            if (r101.getCategoryList().isEmpty() == true) goto L25;
            this.f68261a.f68221d.put(this.f68263c, r101);
            com.bytedance.android.live.effect.api.k.d r103 = this.f68262b;
            if (r103 == null) goto L15;
            if (this.f68264d.get() == false) goto L12;
            EffectDataFetchCacheType r104 = EffectDataFetchCacheType.HitEPCache;
        L13:
            r103.a(r101, r104);
            goto L15
        L12:
            r104 = EffectDataFetchCacheType.NoCache;
        L15:
            if (LiveEffectSettings.LIVE_EFFECT_ENABLE_PERMEATE_STICKER_STRATEGY_UPGRADE.getValue().booleanValue() == false) goto L24;
            Map<String, CopyOnWriteArrayList<o.d>> r105 = this.f68261a.f68222e;
            LinkedHashMap r106 = (LinkedHashMap) r105;
            List r107 = (CopyOnWriteArrayList) r106.get(this.f68263c);
            if (r107 != null) goto L20;
            r107 = CollectionsKt.emptyList();
        L20:
            Iterator r108 = r107.iterator();
        L22:
            if (r108.hasNext() == false) goto L24;
            ((o.d) r108.next()).a(r101);
        L24:
            LiveEffectMonitor.f(this.f68263c, r101.getCategoryList());
        }

        public h(LiveStickerDataManager r100, com.bytedance.android.live.effect.api.k.d r101, String r102, AtomicBoolean r103) {
            this.f68261a = r100;
            this.f68262b = r101;
            this.f68263c = r102;
            this.f68264d = r103;
        }
    }

    static {
    }

    public final EffectManager t() {
        return (EffectManager) this.f68228k.getValue();
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f68229l;
    }

    public LiveStickerDataManager(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f68229l = r100;
        this.f68218a = new LinkedHashMap();
        this.f68219b = new LinkedHashMap();
        this.f68220c = new LinkedHashMap();
        this.f68221d = new LinkedHashMap();
        this.f68222e = new LinkedHashMap();
        this.f68223f = new LinkedHashMap();
        this.f68224g = new LinkedHashMap();
        this.f68225h = new LinkedHashMap();
        this.f68226i = new LinkedHashMap();
        this.f68227j = new ArrayList();
        this.f68228k = LazyKt.lazy(new LiveStickerDataManager$effectManager$2(this));
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        List r101 = (List) ((LinkedHashMap) this.f68225h).get(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if ((!r101.isEmpty()) != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final List<Effect> c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        List<Effect> r101 = (List) ((LinkedHashMap) this.f68225h).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final int m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        if (Intrinsics.areEqual(r100, com.bytedance.android.live.effect.api.d0.f66759i) == true) goto L36;
        if (Intrinsics.areEqual(r100, "beauty") == true) goto L36;
        if (Intrinsics.areEqual(r100, "livebody") == false) goto L11;
        return LiveEffectSettings.LIVE_BODY_BEAUTY_AB_GROUP.getValue().intValue();
    L11:
        if (Intrinsics.areEqual(r100, com.bytedance.android.live.effect.api.d0.f66761k) == false) goto L14;
        return LiveEffectSettings.LIVE_MAKEUP_AB_GROUP.getValue().intValue();
    L14:
        if (Intrinsics.areEqual(r100, com.bytedance.android.live.effect.api.d0.f66751a) == true) goto L45;
        if (Intrinsics.areEqual(r100, com.bytedance.android.live.effect.api.d0.f66762l) == true) goto L45;
        if (Intrinsics.areEqual(r100, "style") == false) goto L22;
        return LiveEffectSettings.LIVE_ANCHOR_BEAUTY_TEMPLATE_AB_GROUP.getValue().intValue();
    L22:
        if (Intrinsics.areEqual(r100, "inspiration_beautification") == false) goto L25;
        return LiveEffectSettings.LIVE_ANCHOR_ONE_TAP_BEAUTY_AB_GROUP.getValue().intValue();
    L25:
        if (Intrinsics.areEqual(r100, "beautyclassify") == false) goto L28;
        return LiveEffectSettings.LIVE_ANCHOR_CLASSIFY_BEAUTY_AB_GROUP.getValue().intValue();
    L28:
        if (Intrinsics.areEqual(r100, "live_adjustment") == false) goto L31;
        return LiveEffectSettings.LIVE_ANCHOR_AV_ADJUST_COLOR_AB_GROUP.getValue().intValue();
    L31:
        if (Intrinsics.areEqual(r100, "live_camera_move") == true) goto L43;
        return 0;
    L43:
        return LiveEffectSettings.LIVE_ANCHOR_CAMERA_MOVEMENT_AB_GROUP.getValue().intValue();
    L45:
        return LiveEffectSettings.LIVE_FILTER_AB_GROUP.getValue().intValue();
    L36:
        return LiveEffectSettings.LIVE_SMALL_BEAUTY_AB_GROUP.getValue().intValue();
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void f(String r110, com.bytedance.android.live.effect.api.k.d r111) {
        Intrinsics.checkNotNullParameter(r110, "panel");
        Intrinsics.checkNotNullParameter("", "category");
        this.f68221d.containsKey(r110);
        b0 r100 = new b0(this, r111, r110);
        t().fetchPanelInfo(r110, false, "", 0, 0, true, null, r100);
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final EffectCategoryModel i(String r100, PanelInfoModel r101) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "panelInfo");
        int r102 = j(r100, "");
        Iterator<EffectCategoryModel> r103 = r101.getCategoryList().iterator();
    L3:
        Integer r104 = null;
        if (r103.hasNext() == false) goto L21;
        EffectCategoryModel r105 = r103.next();
        String r106 = r105.getExtra();
        if (r106 == null) goto L3;
        JsonElement r107 = GsonProtectorUtils.parse(new JsonParser(), r106).getAsJsonObject().get("ab_group");     // Catch: ClassCastException -> L15 IllegalStateException -> L17 JsonParseException -> L19
    L8:
        if (r107 == null) goto L10;
        r104 = Integer.valueOf(r107.getAsInt());     // Catch: ClassCastException -> L15 IllegalStateException -> L17 JsonParseException -> L19
    L10:
        if (r104 == null) goto L3;
        if (r104.intValue() != r102) goto L3;
        return r105;
    L19:
        e = move-exception;
        ALogger.e("LiveStickerDataManager", e);
    L15:
        e = move-exception;
        ALogger.e("LiveStickerDataManager", e);
    L17:
        e = move-exception;
        ALogger.e("LiveStickerDataManager", e);
        goto L3
    L21:
        return null;
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final int j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "forceModeKey");
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r102 = com.bytedance.android.live.effect.api.u.f66774a;
        if (com.bytedance.android.live.effect.api.u.b(this.f68229l).e().c() == false) goto L54;
        boolean r103 = false;
        if (Intrinsics.areEqual(r100, com.bytedance.android.live.effect.api.d0.f66759i) == false) goto L7;
    L37:
        Integer r104 = LiveEffectSettings.LIVE_SMALL_BEAUTY_AB_GROUP.getValue();
    L39:
        if (r101.length() <= 0) goto L41;
        r103 = true;
    L41:
        if (r103 == true) goto L44;
        r101 = (String) m90.b.F.c(LiveEffectContextFactoryDelegate$Type.DEFAULT).first;
    L44:
        BeautyModeInfo r105 = com.bytedance.android.live.effect.api.u.b(this.f68229l).e().j(r101);
        if (r105 == null) goto L52;
        Map r106 = (Map) r105.f68216a.getValue();
        if (r106 == null) goto L52;
        Integer r107 = (Integer) r106.get(r100);
        if (r107 == null) goto L52;
        return r107.intValue();
    L52:
        return r104.intValue();
    L7:
        if (Intrinsics.areEqual(r100, "beauty") == true) goto L37;
        if (Intrinsics.areEqual(r100, "livebody") == false) goto L13;
        r104 = LiveEffectSettings.LIVE_BODY_BEAUTY_AB_GROUP.getValue();
        goto L39
    L13:
        if (Intrinsics.areEqual(r100, com.bytedance.android.live.effect.api.d0.f66761k) == false) goto L16;
        r104 = LiveEffectSettings.LIVE_MAKEUP_AB_GROUP.getValue();
        goto L39
    L16:
        if (Intrinsics.areEqual(r100, com.bytedance.android.live.effect.api.d0.f66751a) == false) goto L18;
    L36:
        r104 = LiveEffectSettings.LIVE_FILTER_AB_GROUP.getValue();
        goto L39
    L18:
        if (Intrinsics.areEqual(r100, com.bytedance.android.live.effect.api.d0.f66762l) == true) goto L36;
        if (Intrinsics.areEqual(r100, "style") == false) goto L24;
        r104 = LiveEffectSettings.LIVE_ANCHOR_BEAUTY_TEMPLATE_AB_GROUP.getValue();
        goto L39
    L24:
        if (Intrinsics.areEqual(r100, "inspiration_beautification") == false) goto L27;
        r104 = LiveEffectSettings.LIVE_ANCHOR_ONE_TAP_BEAUTY_AB_GROUP.getValue();
        goto L39
    L27:
        if (Intrinsics.areEqual(r100, "beautyclassify") == false) goto L30;
        r104 = LiveEffectSettings.LIVE_ANCHOR_CLASSIFY_BEAUTY_AB_GROUP.getValue();
        goto L39
    L30:
        if (Intrinsics.areEqual(r100, "live_adjustment") == false) goto L33;
        r104 = LiveEffectSettings.LIVE_ANCHOR_AV_ADJUST_COLOR_AB_GROUP.getValue();
        goto L39
    L33:
        if (Intrinsics.areEqual(r100, "live_camera_move") == false) goto L35;
        r104 = LiveEffectSettings.LIVE_ANCHOR_CAMERA_MOVEMENT_AB_GROUP.getValue();
        goto L39
    L35:
        r104 = 0;
        goto L39
    L54:
        return m(r100);
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void l(String r100, List<? extends Effect> r101) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "allSticker");
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r102 = com.bytedance.android.live.effect.api.u.f66774a;
        com.bytedance.android.live.effect.api.u.c(this.f68229l).d(r100, r101, new LiveStickerDataManager$restoreSaveNode$1(this));
    }

    public final List<Effect> s(String r100, EffectChannelResponse r101) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "response");
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        if (r101.getCategoryResponseList().isEmpty() == true) goto L5;
        Iterator<EffectCategoryResponse> r104 = r101.getCategoryResponseList().iterator();
    L7:
        int r105 = 0;
        if (r104.hasNext() == false) goto L30;
        EffectCategoryResponse r106 = r104.next();
        String r107 = r106.getExtra();
        if (r107 != null) goto L34;
    L21:
        if (r105 != 0) goto L26;
        if (r103.isEmpty() == false) goto L26;
        r103.addAll(r106.getTotalEffects());
    L26:
        if (r105 != j(r100, "")) goto L7;
        if (r102.isEmpty() == false) goto L7;
        r102.addAll(r106.getTotalEffects());
        r105 = 1;
        goto L30
    L34:
        JsonElement r108 = GsonProtectorUtils.parse(new JsonParser(), r107).getAsJsonObject().get("ab_group");     // Catch: ClassCastException -> L15 IllegalStateException -> L17 JsonParseException -> L19
        if (r108 == null) goto L21;
        r105 = r108.getAsInt();     // Catch: ClassCastException -> L15 IllegalStateException -> L17 JsonParseException -> L19
    L19:
        e = move-exception;
        ALogger.e("LiveStickerDataManager", e);
    L15:
        e = move-exception;
        ALogger.e("LiveStickerDataManager", e);
    L17:
        e = move-exception;
        ALogger.e("LiveStickerDataManager", e);
    L30:
        if (r105 == 0) goto L33;
        return r102;
    L33:
        return r103;
    L5:
        return r101.getAllCategoryEffects();
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void d(String r100, String r101, Sticker r102) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "category");
        Intrinsics.checkNotNullParameter(r102, "sticker");
        if (r102.getEffect() != null) goto L5;
        return;
    L5:
        Map r103 = (Map) ((LinkedHashMap) this.f68224g).get(r100);
        if (r103 == null) goto L15;
        CategoryPageModel r104 = (CategoryPageModel) r103.get(r101);
        if (r104 == null) goto L15;
        CategoryEffectModel r105 = r104.getCategoryEffects();
        if (r105 == null) goto L15;
        List<Effect> r106 = r105.getEffects();
        if (r106 == null) goto L15;
        List<? extends Effect> r107 = CollectionsKt.toMutableList(r106);
        if (r107 == null) goto L15;
    L16:
        List<? extends Effect> r108 = r107;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r110 = r108.iterator();
    L18:
        if (r110.hasNext() == false) goto L20;
        r109.add(((Effect) r110.next()).getEffect_id());
        goto L18
    L20:
        Effect r111 = r102.getEffect();
        if (r111 == null) goto L23;
        String r112 = r111.getEffect_id();
    L25:
        if (CollectionsKt.contains(r109, r112) == false) goto L27;
        return;
    L27:
        Effect r113 = r102.getEffect();
        Intrinsics.checkNotNull(r113);
        ListProtector.add(r107, 0, r113);
        Map r114 = (Map) ((LinkedHashMap) this.f68224g).get(r100);
        if (r114 == null) goto L36;
        CategoryPageModel r115 = (CategoryPageModel) r114.get(r101);
        if (r115 == null) goto L37;
        CategoryEffectModel r116 = r115.getCategoryEffects();
        if (r116 == null) goto L38;
        r116.setEffects(r107);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L23:
        r112 = null;
    L15:
        r107 = new ArrayList();
        goto L16
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void g(Sticker r100, boolean r101, o.b r102) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r102, "listener");
        Effect r103 = r100.getEffect();
        f r104 = new f(r102);
        Intrinsics.checkNotNullParameter(r104, "listener");
        if (r103 != null) goto L5;
        r104.a(false);
        return;
    L5:
        Observable r105 = Observable.create(new i0(this, r103)).subscribeOn(Schedulers.io());
        if (r101 == false) goto L8;
        Scheduler r106 = AndroidSchedulers.mainThread();
    L9:
        r105.observeOn(r106).subscribe(new j0(r104));
        return;
    L8:
        r106 = Schedulers.io();
        goto L9
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void h(String r100, Sticker r101, com.bytedance.android.live.effect.sticker.chain.b.C1115b r102) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "sticker");
        g(r101, false, new a0(this, r102, r101, r100));
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void o(String r110, String r111, com.bytedance.android.live.effect.api.k.b r112) {
        Intrinsics.checkNotNullParameter(r110, "panel");
        Intrinsics.checkNotNullParameter(r111, "category");
        e0 r100 = new e0(r112);
        Intrinsics.checkNotNullParameter(r110, "panel");
        Intrinsics.checkNotNullParameter(r111, "category");
        Intrinsics.checkNotNullParameter("0", "version");
        LiveStickerDataManager$fetchManagerEffectByCategory$1 r101 = new LiveStickerDataManager$fetchManagerEffectByCategory$1(r100);
        LiveStickerDataManager$fetchManagerEffectByCategory$2 r102 = LiveStickerDataManager$fetchManagerEffectByCategory$2.INSTANCE;
        Map r103 = (Map) ((LinkedHashMap) this.f68224g).get(r110);
        if (r103 == null) goto L9;
        CategoryPageModel r104 = (CategoryPageModel) r103.get(r111);
        if (r104 == null) goto L9;
        CategoryEffectModel r105 = r104.getCategoryEffects();
        if (r105 == null) goto L9;
        List<Effect> r106 = r105.getEffects();
    L10:
        if (r106 == null) goto L12;
        r101.invoke2(r106, EffectDataFetchCacheType.HitLiveCache);
        return;
    L12:
        long r107 = System.currentTimeMillis();
        AtomicBoolean r113 = new AtomicBoolean(false);
        d0 r114 = new d0(this, r100, r110, r111, r101, r113, r107);
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == false) goto L15;
        t().checkCategoryIsUpdate(r110, r111, new c0(this, r113, r110, r111, r114));
        return;
    L15:
        r113.set(true);
        t().fetchCategoryEffectFromCache(r110, r111, 0, 0, 0, "0", r114);
        return;
    L9:
        r106 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void k(String r100, String r101, int r102, com.bytedance.android.live.effect.api.k.a r103) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "category");
        r(r100, r101, r102, r103);
    }

    public final void q(AtomicBoolean r100, String r101, IFetchEffectChannelListener r102, boolean r103) {
        r100.set(r103);
        if (r103 == false) goto L5;
        t().fetchEffectList(r101, false, r102);
        return;
    L5:
        t().fetchEffectListFromCache(r101, new e(this, r102, r100, r101));
    }

    public final void r(String r110, String r111, int r210, com.bytedance.android.live.effect.api.k.a r211) {
        Intrinsics.checkNotNullParameter(r110, "panel");
        Intrinsics.checkNotNullParameter(r111, "category");
        Intrinsics.checkNotNullParameter("0", "version");
        LiveStickerDataManager$fetchStickerByCategory$1 r100 = new LiveStickerDataManager$fetchStickerByCategory$1(r211);
        Map r101 = (Map) ((LinkedHashMap) this.f68224g).get(r110);
        if (r101 == null) goto L9;
        CategoryPageModel r102 = (CategoryPageModel) r101.get(r111);
        if (r102 == null) goto L9;
        CategoryEffectModel r103 = r102.getCategoryEffects();
        if (r103 == null) goto L9;
        List<Effect> r104 = r103.getEffects();
    L10:
        if (r104 == null) goto L13;
        r100.invoke2(r104, EffectDataFetchCacheType.HitLiveCache);
        return;
    L13:
        long r105 = System.currentTimeMillis();
        AtomicBoolean r112 = new AtomicBoolean(false);
        h0 r113 = new h0(this, r211, r110, r111, r100, r112, r105);
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == false) goto L16;
        t().checkCategoryIsUpdate(r110, r111, new g0(this, r112, r110, r111, r210, r113));
        return;
    L16:
        r112.set(true);
        t().fetchCategoryEffectFromCache(r110, r111, r210, 0, 0, "0", r113);
        return;
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void p(String r100, String r101, List<Integer> r102, boolean r103, com.bytedance.android.live.effect.api.k.c r104) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "categoryKey");
        Intrinsics.checkNotNullParameter(r102, "categoryIds");
        if (this.f68223f.containsKey(r100) == false) goto L15;
        Map r105 = (Map) ((LinkedHashMap) this.f68223f).get(r100);
        if (r105 == null) goto L15;
        if (r105.containsKey(r101) != true) goto L15;
        if (r103 == true) goto L15;
        Map r106 = (Map) ((LinkedHashMap) this.f68223f).get(r100);
        if (r106 == null) goto L17;
        CategoryInfoModelList r107 = (CategoryInfoModelList) r106.get(r101);
        if (r107 == null) goto L18;
        r104.a(r107, EffectDataFetchCacheType.HitLiveCache);
        return;
    L18:
        return;
    L17:
        return;
    L15:
        d r108 = new d(this, r104, r100, r101);
        t().fetchCategoryInfo(r100, r102, null, r108);
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void a(final String r110, com.bytedance.android.live.effect.api.k.i r111, final boolean r112, boolean r113, boolean r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "panel");
        final LiveStickerDataManager$fetchAllSticker$1 r100 = new LiveStickerDataManager$fetchAllSticker$1(r111);
        Function0<Unit> r101 = new LiveStickerDataManager$fetchAllSticker$2(this, r110, r112, r100);
        if (r211 == false) goto L24;
        if (r210 == true) goto L24;
        if (this.f68218a.containsKey(r110) == false) goto L28;
        int r102 = j(r110, "");
        Integer r103 = (Integer) ((LinkedHashMap) this.f68219b).get(r110);
        if (r103 == null) goto L15;
        if (r103.intValue() != r102) goto L15;
        r101.invoke2();
        return;
    L15:
        if (this.f68220c.containsKey(r110) == false) goto L28;
        EffectChannelResponse r104 = (EffectChannelResponse) ((LinkedHashMap) this.f68220c).get(r110);
        if (r104 == null) goto L21;
        EffectChannelResponse r105 = (EffectChannelResponse) ((LinkedHashMap) this.f68218a).get(r110);
        if (r105 == null) goto L21;
        r105.setAllCategoryEffects(s(r110, r104));
    L21:
        this.f68219b.put(r110, Integer.valueOf(r102));
        r101.invoke2();
        return;
    L28:
        long r106 = System.currentTimeMillis();
        AtomicBoolean r114 = new AtomicBoolean();
        c r115 = new c(this, r110, r113, r211, r114, r106, r112, r100, r111);
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == false) goto L33;
        if (r210 == false) goto L32;
        q(r114, r110, r115, true);
        return;
    L32:
        t().checkedEffectListUpdate(r110, new b(this, r114, r110, r115));
        return;
    L33:
        q(r114, r110, r115, false);
        return;
    L24:
        if (this.f68218a.containsKey(r110) == false) goto L28;
        if (r210 == true) goto L28;
        r101.invoke2();
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void e(String r110, String r111, int r112, int r113, String r114, Map r115, com.bytedance.android.live.effect.api.k.e r116) {
        Intrinsics.checkNotNullParameter(r110, "panel");
        Intrinsics.checkNotNullParameter(r111, "categoryKey");
        Intrinsics.checkNotNullParameter(r114, "version");
        LiveStickerDataManager$fetchRewardEffectList$1 r100 = new LiveStickerDataManager$fetchRewardEffectList$1(r116);
        t().fetchCategoryEffect(r110, r111, 200, r112, r113, r114, r115, new f0(this, r110, r116, r100));
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void n(String r110, boolean r111, String r112, int r113, int r114, boolean r210, com.bytedance.android.live.effect.api.k.d r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r110, "panel");
        Intrinsics.checkNotNullParameter(r112, "category");
        if (this.f68221d.containsKey(r110) == false) goto L20;
        if (r210 == true) goto L20;
        PanelInfoModel r100 = (PanelInfoModel) ((LinkedHashMap) this.f68221d).get(r110);
        if (r100 == null) goto L19;
        if (r211 == null) goto L10;
        r211.a(r100, EffectDataFetchCacheType.HitLiveCache);
    L10:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_PERMEATE_STICKER_STRATEGY_UPGRADE.getValue().booleanValue() == false) goto L28;
        List r101 = (CopyOnWriteArrayList) ((LinkedHashMap) this.f68222e).get(r110);
        if (r101 != null) goto L15;
        r101 = CollectionsKt.emptyList();
    L15:
        Iterator r102 = r101.iterator();
    L17:
        if (r102.hasNext() == false) goto L29;
        ((o.d) r102.next()).a(r100);
        goto L17
    L29:
        return;
    L28:
        return;
    L19:
        return;
    L20:
        AtomicBoolean r103 = new AtomicBoolean(false);
        h r104 = new h(this, r211, r110, r103);
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == false) goto L25;
        if (r210 == false) goto L24;
        r103.set(false);
        t().fetchPanelInfo(r110, r111, r112, r113, r114, r104);
        return;
    L24:
        t().checkPanelIsUpdate(r110, new g(this, r212, r103, r110, r111, r112, r113, r114, r104));
        return;
    L25:
        r103.set(true);
        t().fetchPanelInfoFromCache(r110, r111, r112, r113, r114, r104);
    }
}
