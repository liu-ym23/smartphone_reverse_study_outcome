package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/VideoTalkBgDeviceConfig;", "", "anchorScore", "", "audienceScore", "(FF)V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoTalkBgDeviceConfig {
    public static final Companion Companion = null;

    @SerializedName("anchor_score")
    public float anchorScore;

    @SerializedName("audience_score")
    public float audienceScore;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/VideoTalkBgDeviceConfig$Companion;", "", "()V", "defaultConfig", "Lcom/bytedance/android/livesdkapi/model/VideoTalkBgDeviceConfig;", "defaultKtvConfig", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final VideoTalkBgDeviceConfig defaultConfig() {
            return new VideoTalkBgDeviceConfig(8.17f, 7.95f);
        }

        @JvmStatic
        public final VideoTalkBgDeviceConfig defaultKtvConfig() {
            return new VideoTalkBgDeviceConfig(8.34f, 7.4f);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final VideoTalkBgDeviceConfig defaultConfig() {
        return Companion.defaultConfig();
    }

    @JvmStatic
    public static final VideoTalkBgDeviceConfig defaultKtvConfig() {
        return Companion.defaultKtvConfig();
    }

    public VideoTalkBgDeviceConfig(float r100, float r101) {
        this.anchorScore = r100;
        this.audienceScore = r101;
    }
}
