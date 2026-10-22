package com.bytedance.android.live.effect.common;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.chain.LiveCommonDownloadStickerInterceptor;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 -2\u00020\u0001:\u0001.B\u001f\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\r\u001a\u00020\nJ\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006R\u001c\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerRenderViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$ComposerConfig;", "composerConfig", "", "getTagValue", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "tryApplySticker", "renderSticker", "clearRenderSticker", "", "", "generateValueMapBySticker", "value", "updateTagValue", "Landroidx/lifecycle/MutableLiveData;", "_renderStickerData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager$delegate", "Lkotlin/Lazy;", "getComposerManager", "()Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager", "Lcom/bytedance/android/live/effect/sticker/chain/l;", "currentStickerItemClickChain", "Lcom/bytedance/android/live/effect/sticker/chain/l;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "panel", "Ljava/lang/String;", "Landroidx/lifecycle/LiveData;", "getRenderStickerData", "()Landroidx/lifecycle/LiveData;", "renderStickerData", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveCommonStickerRenderViewModel extends StickerBaseViewModel {
    public static final a Companion = null;
    public static final String TAG = "ttlive_anchor_effect_LiveCommonStickerRenderViewModel";
    private final MutableLiveData<Sticker> _renderStickerData;
    private final Lazy composerManager$delegate;
    private com.bytedance.android.live.effect.sticker.chain.l currentStickerItemClickChain;
    private final String panel;
    private final LiveEffectScene scene;
    private final LiveEffectContextFactoryDelegate$Type type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final ILiveEffectComposerManager getComposerManager() {
        return (ILiveEffectComposerManager) this.composerManager$delegate.getValue();
    }

    public final void clearRenderSticker() {
        getComposerManager().b(this.panel, "ttlive_anchor_effect_LiveCommonStickerRenderViewModelclearRenderSticker");
        this._renderStickerData.setValue(null);
    }

    public final LiveData<Sticker> getRenderStickerData() {
        return this._renderStickerData;
    }

    public static final /* synthetic */ LiveEffectContextFactoryDelegate$Type access$getType$p(LiveCommonStickerRenderViewModel r100) {
        return r100.type;
    }

    public final Map<String, Integer> generateValueMapBySticker(Sticker r100) {
        if (r100 == null) goto L4;
        List<Sticker.ComposerConfig> r101 = r100.getComposerConfigList();
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        Sticker.ComposerConfig r104 = (Sticker.ComposerConfig) r103.next();
        Pair r105 = TuplesKt.to(r104.getTag(), Integer.valueOf(getTagValue(r100, r104)));
        r102.put(r105.getFirst(), r105.getSecond());
        goto L7
    L9:
        return r102;
    L4:
        return MapsKt.emptyMap();
    }

    public void renderSticker(Sticker r110) {
        Intrinsics.checkNotNullParameter(r110, "sticker");
        getComposerManager().b(this.panel, "ttlive_anchor_effect_LiveCommonStickerRenderViewModelrenderSticker_" + r110.getId());
        getComposerManager().a(this.panel, r110, "ttlive_anchor_effect_LiveCommonStickerRenderViewModelrenderSticker_" + r110.getId());
        Iterator<Sticker.ComposerConfig> r100 = r110.getComposerConfigList().iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        Sticker.ComposerConfig r101 = r100.next();
        String r102 = r101.getTag();
        Float r103 = getComposerManager().G(r110.getEffectId(), r102);
        if (r103 == null) goto L8;
        float r104 = r103.floatValue();
    L9:
        ILiveEffectComposerManager.f.d(getComposerManager(), this.panel, r110, r102, r104, null, 48);
        goto L4
    L8:
        r104 = com.bytedance.android.live.effect.q.d(r110, r101.getDefaultValue());
        goto L9
    L10:
        this._renderStickerData.setValue(r110);
    }

    private final int getTagValue(Sticker r100, Sticker.ComposerConfig r101) {
        Float r102 = getComposerManager().G(r100.getEffectId(), r101.getTag());
        if (r102 != null) goto L6;
        return r101.getDefaultValue();
    L6:
        return com.bytedance.android.live.effect.q.a(r101, r102.floatValue());
    }

    public final void tryApplySticker(Context r110, Sticker r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "sticker");
        Sticker r100 = this._renderStickerData.getValue();
        if (r100 != null) goto L5;
    L7:
        com.bytedance.android.live.effect.sticker.chain.l r101 = this.currentStickerItemClickChain;
        if (r101 == null) goto L18;
        Sticker r102 = r101.f68174g;
        if (r102 == null) goto L18;
        if (r102.getId() != r111.getId()) goto L18;
        com.bytedance.android.live.effect.sticker.chain.l r103 = this.currentStickerItemClickChain;
        if (r103 == null) goto L18;
        if (r103.f68169b != true) goto L18;
        return;
    L18:
        com.bytedance.android.live.effect.sticker.chain.l r104 = this.currentStickerItemClickChain;
        if (r104 == null) goto L21;
        r104.f68169b = false;
    L21:
        com.bytedance.android.live.effect.sticker.chain.l r105 = new com.bytedance.android.live.effect.sticker.chain.l(r110, this.type, this.scene, this.panel, r111, MapsKt.emptyMap(), new LinkedList(CollectionsKt.listOf(new com.bytedance.android.live.effect.sticker.chain.m[]{new com.bytedance.android.live.effect.sticker.chain.j(), new LiveCommonDownloadStickerInterceptor(), new com.bytedance.android.live.effect.sticker.chain.i()})));
        this.currentStickerItemClickChain = r105;
        r105.a();
        return;
    L5:
        if (r100.getId() != r111.getId()) goto L7;
    }

    public LiveCommonStickerRenderViewModel(LiveEffectContextFactoryDelegate$Type r100, LiveEffectScene r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "panel");
        this.type = r100;
        this.scene = r101;
        this.panel = r102;
        List<String> r103 = LiveEffectContext.f66734h;
        this._renderStickerData = new MutableLiveData(CollectionsKt.firstOrNull(LiveEffectContext.a.a(r100).a().o(r102)));
        this.composerManager$delegate = LazyKt.lazy(new LiveCommonStickerRenderViewModel$composerManager$2(this));
    }

    public final void updateTagValue(Sticker r100, Sticker.ComposerConfig r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r110, "composerConfig");
        ILiveEffectComposerManager.f.d(getComposerManager(), this.panel, r100, r110.getTag(), com.bytedance.android.live.effect.q.c(r110, r111), null, 48);
    }
}
