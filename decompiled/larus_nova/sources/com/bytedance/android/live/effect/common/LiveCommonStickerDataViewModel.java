package com.bytedance.android.live.effect.common;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerLoadingStatus;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB+\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R#\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u00068F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerDataViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "", "panel", "", "fetchStickerList", "Lcom/bytedance/android/live/effect/sticker/viewmodel/c;", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "_stickerListMap", "Lcom/bytedance/android/live/effect/sticker/viewmodel/c;", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerLoadingStatus;", "_stickerListLoadingStatusMap", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "", "Lcom/bytedance/android/live/effect/common/y;", "panelConfigMap", "Ljava/util/Map;", "getStickerListMap", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/c;", "stickerListMap", "getStickerListLoadingStatusMap", "stickerListLoadingStatusMap", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/util/Map;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommonStickerDataViewModel extends StickerBaseViewModel {
    public static final a Companion = null;
    public static final String TAG = "ttlive_anchor_effect_LiveCommonStickerDataViewModel";
    private final com.bytedance.android.live.effect.sticker.viewmodel.c<String, StickerLoadingStatus> _stickerListLoadingStatusMap;
    private final com.bytedance.android.live.effect.sticker.viewmodel.c<String, List<Sticker>> _stickerListMap;
    private final Map<String, y> panelConfigMap;
    private final LiveEffectScene scene;
    private final LiveEffectContextFactoryDelegate$Type type;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.android.live.effect.api.k.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCommonStickerDataViewModel f67812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f67813b;

        @Override // com.bytedance.android.live.effect.api.k.i
        public final void a(EffectChannelResponse r100) {
        }

        @Override // com.bytedance.android.live.effect.api.k.i
        public final void b() {
            LiveCommonStickerDataViewModel.access$get_stickerListLoadingStatusMap$p(this.f67812a).update(this.f67813b, StickerLoadingStatus.Error);
        }

        public b(LiveCommonStickerDataViewModel r100, String r101) {
            this.f67812a = r100;
            this.f67813b = r101;
        }

        @Override // com.bytedance.android.live.effect.api.k.j
        public final void c(EffectChannelResponse r100, EffectDataFetchCacheType r101) {
            Intrinsics.checkNotNullParameter(r101, "cacheType");
            if (r100 != null) goto L5;
        L13:
            LiveCommonStickerDataViewModel.access$get_stickerListLoadingStatusMap$p(this.f67812a).update(this.f67813b, StickerLoadingStatus.Error);
            return;
        L5:
            if (r100.getAllCategoryEffects().isEmpty() == true) goto L13;
            com.bytedance.android.live.effect.sticker.viewmodel.c r102 = LiveCommonStickerDataViewModel.access$get_stickerListMap$p(this.f67812a);
            String r103 = this.f67813b;
            List<Effect> r104 = r100.getAllCategoryEffects();
            ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
            Iterator<T> r106 = r104.iterator();
        L9:
            if (r106.hasNext() == false) goto L11;
            r105.add(com.bytedance.android.live.effect.sticker.d.d((Effect) r106.next(), this.f67813b));
            goto L9
        L11:
            r102.update(r103, r105);
            LiveCommonStickerDataViewModel.access$get_stickerListLoadingStatusMap$p(this.f67812a).update(this.f67813b, StickerLoadingStatus.Normal);
        }
    }

    static {
        Companion = new a();
    }

    public final com.bytedance.android.live.effect.sticker.viewmodel.c<String, StickerLoadingStatus> getStickerListLoadingStatusMap() {
        return this._stickerListLoadingStatusMap;
    }

    public final com.bytedance.android.live.effect.sticker.viewmodel.c<String, List<Sticker>> getStickerListMap() {
        return this._stickerListMap;
    }

    public static final /* synthetic */ com.bytedance.android.live.effect.sticker.viewmodel.c access$get_stickerListLoadingStatusMap$p(LiveCommonStickerDataViewModel r100) {
        return r100._stickerListLoadingStatusMap;
    }

    public static final /* synthetic */ com.bytedance.android.live.effect.sticker.viewmodel.c access$get_stickerListMap$p(LiveCommonStickerDataViewModel r100) {
        return r100._stickerListMap;
    }

    public final void fetchStickerList(String r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        this._stickerListLoadingStatusMap.update(r100, StickerLoadingStatus.Loading);
        List<String> r101 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.sticker.presenter.o r102 = LiveEffectContext.a.a(this.type).b().d();
        b r103 = new b(this, r100);
        y r104 = this.panelConfigMap.get(r100);
        if (r104 == null) goto L5;
        boolean r105 = r104.f67879a;
    L6:
        y r106 = this.panelConfigMap.get(r100);
        if (r106 == null) goto L9;
        boolean r107 = r106.f67880b;
    L10:
        r102.a(r100, r103, false, r105, false, r107);
        return;
    L9:
        r107 = false;
        goto L10
    L5:
        r105 = false;
        goto L6
    }

    public LiveCommonStickerDataViewModel(LiveEffectContextFactoryDelegate$Type r100, LiveEffectScene r101, Map<String, y> r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "panelConfigMap");
        this.type = r100;
        this.scene = r101;
        this.panelConfigMap = r102;
        this._stickerListMap = new com.bytedance.android.live.effect.sticker.viewmodel.c();
        this._stickerListLoadingStatusMap = new com.bytedance.android.live.effect.sticker.viewmodel.c();
    }
}
