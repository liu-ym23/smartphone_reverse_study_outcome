package com.bytedance.android.livesdkapi.depend.model.live;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveRoomMode;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "Normal", "ThirdParty", "Media", ServiceType.AUDIO, "Screenshot", "Acquaintance", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveRoomMode extends Enum<LiveRoomMode> {
    private static final /* synthetic */ LiveRoomMode[] $VALUES = null;
    public static final LiveRoomMode Acquaintance = null;
    public static final LiveRoomMode Audio = null;
    public static final LiveRoomMode Media = null;
    public static final LiveRoomMode Normal = null;
    public static final LiveRoomMode Screenshot = null;
    public static final LiveRoomMode ThirdParty = null;
    private final long value;

    static {
        LiveRoomMode r100 = new LiveRoomMode("Normal", 0, 0);
        Normal = r100;
        LiveRoomMode r101 = new LiveRoomMode("ThirdParty", 1, 1);
        ThirdParty = r101;
        LiveRoomMode r102 = new LiveRoomMode("Media", 2, 2);
        Media = r102;
        LiveRoomMode r103 = new LiveRoomMode(ServiceType.AUDIO, 3, 3);
        Audio = r103;
        LiveRoomMode r104 = new LiveRoomMode("Screenshot", 4, 4);
        Screenshot = r104;
        LiveRoomMode r105 = new LiveRoomMode("Acquaintance", 5, 5);
        Acquaintance = r105;
        $VALUES = new LiveRoomMode[]{r100, r101, r102, r103, r104, r105};
    }

    public static LiveRoomMode valueOf(String r100) {
        return (LiveRoomMode) a.a(LiveRoomMode.class, r100);
    }

    public static LiveRoomMode[] values() {
        return (LiveRoomMode[]) $VALUES.clone();
    }

    public final long getValue() {
        return this.value;
    }

    private LiveRoomMode(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
