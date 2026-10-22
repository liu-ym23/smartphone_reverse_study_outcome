package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveStreamType;", "", "(Ljava/lang/String;I)V", "VIDEO", "AUDIO", "UNDEFINED", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveStreamType extends Enum<LiveStreamType> {
    private static final /* synthetic */ LiveStreamType[] $VALUES = null;
    public static final LiveStreamType AUDIO = null;
    public static final LiveStreamType UNDEFINED = null;
    public static final LiveStreamType VIDEO = null;

    static {
        LiveStreamType r100 = new LiveStreamType("VIDEO", 0);
        VIDEO = r100;
        LiveStreamType r101 = new LiveStreamType("AUDIO", 1);
        AUDIO = r101;
        LiveStreamType r102 = new LiveStreamType("UNDEFINED", 2);
        UNDEFINED = r102;
        $VALUES = new LiveStreamType[]{r100, r101, r102};
    }

    public static LiveStreamType valueOf(String r100) {
        return (LiveStreamType) a.a(LiveStreamType.class, r100);
    }

    public static LiveStreamType[] values() {
        return (LiveStreamType[]) $VALUES.clone();
    }

    private LiveStreamType(String r100, int r101) {
        super(r100, r101);
    }
}
