package com.bytedance.android.live.effect.cameramovement;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.common.LiveCommonStickerRenderViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/effect/cameramovement/LiveCameraMovementRenderViewModel;", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerRenderViewModel;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "panel", "", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;)V", "renderSticker", "", "sticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCameraMovementRenderViewModel extends LiveCommonStickerRenderViewModel {
    private final String panel;
    private final LiveEffectScene scene;
    private final LiveEffectContextFactoryDelegate$Type type;

    @Override // com.bytedance.android.live.effect.common.LiveCommonStickerRenderViewModel
    public void renderSticker(Sticker r100) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        List<String> r101 = LiveEffectContext.f66734h;
        ((c) LiveEffectContext.a.a(this.type).b().k()).getClass();
        super.renderSticker(r100);
    }

    public LiveCameraMovementRenderViewModel(LiveEffectContextFactoryDelegate$Type r100, LiveEffectScene r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "panel");
        super(r100, r101, r102);
        this.type = r100;
        this.scene = r101;
        this.panel = r102;
    }
}
