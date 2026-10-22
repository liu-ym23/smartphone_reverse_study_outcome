package com.bytedance.android.ec.hybrid.data.entity;

import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/entity/ECPreloadConfigDeviceScore;", "Ljava/io/Serializable;", "()V", "androidScoreMap", "", "", "", "getAndroidScoreMap", "()Ljava/util/Map;", "setAndroidScoreMap", "(Ljava/util/Map;)V", "iOSScoreMap", "getIOSScoreMap", "setIOSScoreMap", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPreloadConfigDeviceScore implements Serializable {

    @SerializedName("android")
    private Map<String, Integer> androidScoreMap;

    @SerializedName(BackupSeiMessage.SOURCE_IOS)
    private Map<String, Integer> iOSScoreMap;

    public ECPreloadConfigDeviceScore() {
    }

    public final Map<String, Integer> getAndroidScoreMap() {
        return this.androidScoreMap;
    }

    public final Map<String, Integer> getIOSScoreMap() {
        return this.iOSScoreMap;
    }

    public final void setAndroidScoreMap(Map<String, Integer> r100) {
        this.androidScoreMap = r100;
    }

    public final void setIOSScoreMap(Map<String, Integer> r100) {
        this.iOSScoreMap = r100;
    }
}
