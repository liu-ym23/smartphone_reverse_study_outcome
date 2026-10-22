package com.bytedance.android.livesdk.player.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/player/model/f;", "", "Lcom/bytedance/android/livesdk/player/model/g;", "vrInfo", "Lcom/bytedance/android/livesdk/player/model/g;", "d", "()Lcom/bytedance/android/livesdk/player/model/g;", "", "enableSixDofLite", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "sixDoFLiteStreamLayout", "c", "useNewLivePlayer", "getUseNewLivePlayer", "", "resolution", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "suggestFormat", "getSuggestFormat", "<init>", "()V", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("EnableSixDofLite")
    private final int enableSixDofLite;

    @SerializedName("resolution")
    private final String resolution;

    @SerializedName("SixDoFLiteStreamLayout")
    private final int sixDoFLiteStreamLayout;

    @SerializedName("SuggestFormat")
    private final String suggestFormat;

    @SerializedName("UseNewLivePlayer")
    private final int useNewLivePlayer;

    @SerializedName("VR")
    private final g vrInfo;

    public f() {
        this.enableSixDofLite = -1;
        this.sixDoFLiteStreamLayout = -1;
        this.useNewLivePlayer = -1;
        this.resolution = "";
        this.suggestFormat = "";
    }

    public final int a() {
        return this.enableSixDofLite;
    }

    public final String b() {
        return this.resolution;
    }

    public final int c() {
        return this.sixDoFLiteStreamLayout;
    }

    public final g d() {
        return this.vrInfo;
    }
}
