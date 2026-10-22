package com.bytedance.android.livesdk.effect;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import tb1.c;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/effect/EffectUpdateHelper;", "", "", "initEffect", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EffectUpdateHelper {
    public static final a Companion = null;
    private static final String TAG = "EffectUpdateHelper";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public EffectUpdateHelper() {
    }

    public final void initEffect() {
        if (c.f545235g == false) goto L15;
        IHostContext r100 = TTLiveSDK.hostService().appContext();
        boolean r101 = v.a();
        String r110 = r100.getServerDeviceId();
        int r111 = r100.appId();
        String r112 = r100.getVersionName();
        Context r102 = r100.context();
        ILiveWrappedEffectSDKService.Companion.getClass();     // Catch: Throwable -> L10
        ILiveWrappedEffectSDKService r103 = ILiveWrappedEffectSDKService.a.a();     // Catch: Throwable -> L10
        if (r103 == null) goto L8;
        r103.buildEffectUpdateRunner(r101, r110, r111, r112, r102);     // Catch: Throwable -> L10
    L8:
        ALogger.d(TAG, "isDebugMode:" + r101 + "  deviceId:" + r110 + "  appId:" + r111 + "  appVersion:" + r112);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        ALogger.e(TAG, "EffectUpdateRunner error: " + th);
        return;
    }
}
