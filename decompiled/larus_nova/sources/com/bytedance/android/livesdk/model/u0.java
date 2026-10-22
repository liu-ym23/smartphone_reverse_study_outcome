package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014RB\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/model/u0;", "", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/livesdk/model/v0;", "Lkotlin/collections/HashMap;", "spatialAudioListenerPositionConfigByLayout", "Ljava/util/HashMap;", "b", "()Ljava/util/HashMap;", "setSpatialAudioListenerPositionConfigByLayout", "(Ljava/util/HashMap;)V", "", "audioKtvListenerZ", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setAudioKtvListenerZ", "(J)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u0 {

    @SerializedName("audio_ktv_listener_z")
    private long audioKtvListenerZ;

    @SerializedName("listener_position_config_by_layout")
    private HashMap<Integer, v0> spatialAudioListenerPositionConfigByLayout;

    public u0() {
        this.spatialAudioListenerPositionConfigByLayout = new HashMap();
        this.audioKtvListenerZ = -200;
    }

    public final long a() {
        return this.audioKtvListenerZ;
    }

    public final HashMap<Integer, v0> b() {
        return this.spatialAudioListenerPositionConfigByLayout;
    }
}
