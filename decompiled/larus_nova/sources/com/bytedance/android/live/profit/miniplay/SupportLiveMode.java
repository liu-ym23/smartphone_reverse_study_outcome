package com.bytedance.android.live.profit.miniplay;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/profit/miniplay/SupportLiveMode;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "VIDEO", "OBS", "MEDIA", "AUDIO", "SCREEN_RECORD", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SupportLiveMode extends Enum<SupportLiveMode> {
    public static final SupportLiveMode AUDIO = null;
    public static final SupportLiveMode MEDIA = null;
    public static final SupportLiveMode OBS = null;
    public static final SupportLiveMode SCREEN_RECORD = null;
    public static final SupportLiveMode UNKNOWN = null;
    public static final SupportLiveMode VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SupportLiveMode[] f88270a = null;
    private final int value;

    static {
        SupportLiveMode r100 = new SupportLiveMode("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        SupportLiveMode r101 = new SupportLiveMode("VIDEO", 1, 0);
        VIDEO = r101;
        SupportLiveMode r102 = new SupportLiveMode("OBS", 2, 1);
        OBS = r102;
        SupportLiveMode r103 = new SupportLiveMode("MEDIA", 3, 2);
        MEDIA = r103;
        SupportLiveMode r104 = new SupportLiveMode("AUDIO", 4, 3);
        AUDIO = r104;
        SupportLiveMode r105 = new SupportLiveMode("SCREEN_RECORD", 5, 4);
        SCREEN_RECORD = r105;
        f88270a = new SupportLiveMode[]{r100, r101, r102, r103, r104, r105};
    }

    public static SupportLiveMode valueOf(String r100) {
        return (SupportLiveMode) a.a(SupportLiveMode.class, r100);
    }

    public static SupportLiveMode[] values() {
        return (SupportLiveMode[]) f88270a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public SupportLiveMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
