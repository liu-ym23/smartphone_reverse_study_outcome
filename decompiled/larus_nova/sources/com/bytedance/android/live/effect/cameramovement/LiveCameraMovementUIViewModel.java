package com.bytedance.android.live.effect.cameramovement;

import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.common.LiveCommonStickerUIViewModel;
import com.bytedance.android.live.effect.utils.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.MobConstants;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/effect/cameramovement/LiveCameraMovementUIViewModel;", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerUIViewModel;", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "", "position", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "", "sendStickerShowLog", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "", "panel", "Ljava/lang/String;", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCameraMovementUIViewModel extends LiveCommonStickerUIViewModel {
    public static final a Companion = null;
    public static final String EVENT_SHOW = "livesdk_camera_movement_effect_show";
    public static final String TAG = "ttlive_anchor_effect_LiveCameraMovementUIViewModel";
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

    public LiveCameraMovementUIViewModel(LiveEffectContextFactoryDelegate$Type r100, LiveEffectScene r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "panel");
        super(r100, r101, r102);
        this.type = r100;
        this.scene = r101;
        this.panel = r102;
    }

    @Override // com.bytedance.android.live.effect.common.LiveCommonStickerUIViewModel
    public void sendStickerShowLog(Sticker r100, int r101, LiveEffectScene r102) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r102, "scene");
        HashMap r103 = new HashMap();
        r103.put(MobConstants.EFFECT_ID, r100.getEffectId());
        String r104 = r100.getName();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r103.put(MobConstants.EFFECT_NAME, r104);
        List<String> r105 = q.f68881a;
        q.e(EVENT_SHOW, r103, r102.getPage());
    }
}
