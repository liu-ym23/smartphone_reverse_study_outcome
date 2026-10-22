package com.bytedance.android.live.effect.view;

import android.os.Message;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/view/EffectLiveBroadcastActivityProxy;", "Lcom/bytedance/android/live/effect/view/LiveEffectActivityProxy;", "", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EffectLiveBroadcastActivityProxy extends LiveEffectActivityProxy implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f68882a = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
    }

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onCreate() {
        super.onCreate();
        throw null;
    }

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onDestroy() {
        super.onDestroy();
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r100 = ILiveWrappedEffectSDKService.a.a();
        if (r100 == null) goto L6;
        r100.getMessageCenter();
    L6:
        throw null;
    }

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onPause() {
        throw null;
    }
}
