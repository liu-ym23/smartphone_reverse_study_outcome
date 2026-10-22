package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AnchorVStreamPerfConfig;", "", "()V", "calTimes", "", "getCalTimes", "()I", "effectList", "", "", "getEffectList", "()Ljava/util/Map;", "enable", "", "getEnable", "()Z", VideoThumbInfo.KEY_INTERVAL, "", "getInterval", "()J", "streamList", "getStreamList", "getRealCalTimes", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorVStreamPerfConfig {
    public static final Companion Companion = null;
    public static final int TYPE_DOUBLE = 1;
    public static final int TYPE_INT = 0;
    public static final int TYPE_STRING = 2;

    @SerializedName("cal_counts")
    private final int calTimes;

    @SerializedName("effect")
    private final Map<String, Integer> effectList;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final long interval;

    @SerializedName("stream")
    private final Map<String, Integer> streamList;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AnchorVStreamPerfConfig$Companion;", "", "()V", "TYPE_DOUBLE", "", "TYPE_INT", "TYPE_STRING", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final int getRealCalTimes() {
        int r100 = this.calTimes;
        if (r100 >= 0) goto L6;
        r100 = 1;
    L6:
        if (r100 <= 30) goto L9;
        return 30;
    L9:
        return r100;
    }

    public AnchorVStreamPerfConfig() {
        this.interval = 180;
        this.calTimes = 10;
        this.streamList = MapsKt.emptyMap();
        this.effectList = MapsKt.emptyMap();
    }

    public final int getCalTimes() {
        return this.calTimes;
    }

    public final Map<String, Integer> getEffectList() {
        return this.effectList;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final long getInterval() {
        return this.interval;
    }

    public final Map<String, Integer> getStreamList() {
        return this.streamList;
    }
}
