package com.bytedance.android.ec.adapter.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010\t\u001a\u0004\b\u000b\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/model/ECLiveMode;", "", "", "logStreamingType", "Ljava/lang/String;", "getLogStreamingType", "()Ljava/lang/String;", "", "isStreamingBackground", "Z", "()Z", "isUsingCamera", "VIDEO", "AUDIO", "THIRD_PARTY", "SCREEN_RECORD", "MEDIA", "OFFICIAL_ACTIVITY", "UNDEFINED", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECLiveMode extends Enum<ECLiveMode> {
    public static final ECLiveMode AUDIO = null;
    public static final ECLiveMode MEDIA = null;
    public static final ECLiveMode OFFICIAL_ACTIVITY = null;
    public static final ECLiveMode SCREEN_RECORD = null;
    public static final ECLiveMode THIRD_PARTY = null;
    public static final ECLiveMode UNDEFINED = null;
    public static final ECLiveMode VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECLiveMode[] f42681a = null;
    private final boolean isStreamingBackground;
    private final boolean isUsingCamera;
    private final String logStreamingType;

    static {
        ECLiveMode r100 = new ECLiveMode("VIDEO", 0, "general", false);
        VIDEO = r100;
        ECLiveMode r101 = new ECLiveMode("AUDIO", 1, "general", false);
        AUDIO = r101;
        ECLiveMode r102 = new ECLiveMode("THIRD_PARTY", 2, "thirdparty", false);
        THIRD_PARTY = r102;
        ECLiveMode r103 = new ECLiveMode("SCREEN_RECORD", 3, "game", false);
        SCREEN_RECORD = r103;
        ECLiveMode r104 = new ECLiveMode("MEDIA", 4, "media", true);
        MEDIA = r104;
        ECLiveMode r105 = new ECLiveMode("OFFICIAL_ACTIVITY", 5, "official_activity", false);
        OFFICIAL_ACTIVITY = r105;
        ECLiveMode r106 = new ECLiveMode("UNDEFINED", 6, "undefined", false);
        UNDEFINED = r106;
        f42681a = new ECLiveMode[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ECLiveMode valueOf(String r100) {
        return (ECLiveMode) a.a(ECLiveMode.class, r100);
    }

    public static ECLiveMode[] values() {
        return (ECLiveMode[]) f42681a.clone();
    }

    public final String getLogStreamingType() {
        return this.logStreamingType;
    }

    public final boolean isStreamingBackground() {
        return this.isStreamingBackground;
    }

    public final boolean isUsingCamera() {
        return this.isUsingCamera;
    }

    public ECLiveMode(String r100, int r101, String r102, boolean r103) {
        super(r100, r101);
        this.logStreamingType = r102;
        this.isStreamingBackground = r103;
        this.isUsingCamera = false;
    }
}
