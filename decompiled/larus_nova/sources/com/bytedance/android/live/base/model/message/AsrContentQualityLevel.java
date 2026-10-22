package com.bytedance.android.live.base.model.message;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/message/AsrContentQualityLevel;", "", "", "value", "I", "getValue", "()I", "AsrContentQualityLevelUnDefined", "AsrContentQualityLevelLow", "AsrContentQualityLevelHigh", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AsrContentQualityLevel extends Enum<AsrContentQualityLevel> {
    public static final AsrContentQualityLevel AsrContentQualityLevelHigh = null;
    public static final AsrContentQualityLevel AsrContentQualityLevelLow = null;
    public static final AsrContentQualityLevel AsrContentQualityLevelUnDefined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrContentQualityLevel[] f58848a = null;
    private final int value;

    static {
        AsrContentQualityLevel r100 = new AsrContentQualityLevel("AsrContentQualityLevelUnDefined", 0, 0);
        AsrContentQualityLevelUnDefined = r100;
        AsrContentQualityLevel r101 = new AsrContentQualityLevel("AsrContentQualityLevelLow", 1, 1);
        AsrContentQualityLevelLow = r101;
        AsrContentQualityLevel r102 = new AsrContentQualityLevel("AsrContentQualityLevelHigh", 2, 2);
        AsrContentQualityLevelHigh = r102;
        f58848a = new AsrContentQualityLevel[]{r100, r101, r102};
    }

    public static AsrContentQualityLevel valueOf(String r100) {
        return (AsrContentQualityLevel) r27.a.a(AsrContentQualityLevel.class, r100);
    }

    public static AsrContentQualityLevel[] values() {
        return (AsrContentQualityLevel[]) f58848a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AsrContentQualityLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
