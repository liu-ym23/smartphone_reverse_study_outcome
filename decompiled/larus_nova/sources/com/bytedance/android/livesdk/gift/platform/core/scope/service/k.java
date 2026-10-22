package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/k;", "", "", "soundOn", "Z", "getSoundOn", "()Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Z)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@RpcMessage(messageName = "webcast.revenue.biz.effect.CurrentSoundVibrationStatus")
public final class k {

    @SerializedName("sound_on")
    private boolean soundOn;

    public k() {
        this.soundOn = true;
    }

    public final void a(boolean r100) {
        this.soundOn = r100;
    }
}
