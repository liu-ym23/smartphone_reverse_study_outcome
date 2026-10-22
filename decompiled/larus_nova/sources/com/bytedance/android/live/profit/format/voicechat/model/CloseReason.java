package com.bytedance.android.live.profit.format.voicechat.model;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/model/CloseReason;", "", "", "type", "I", "getType", "()I", "UNKNOWN", "COUNT_DOWN", "USER_CLOSE", FlowDoraWifiScene.OTHER, "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CloseReason extends Enum<CloseReason> {
    public static final CloseReason COUNT_DOWN = null;
    public static final CloseReason OTHER = null;
    public static final CloseReason UNKNOWN = null;
    public static final CloseReason USER_CLOSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CloseReason[] f87664a = null;
    private final int type;

    static {
        CloseReason r100 = new CloseReason("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        CloseReason r101 = new CloseReason("COUNT_DOWN", 1, 1);
        COUNT_DOWN = r101;
        CloseReason r102 = new CloseReason("USER_CLOSE", 2, 2);
        USER_CLOSE = r102;
        CloseReason r103 = new CloseReason(FlowDoraWifiScene.OTHER, 3, 3);
        OTHER = r103;
        f87664a = new CloseReason[]{r100, r101, r102, r103};
    }

    public static CloseReason valueOf(String r100) {
        return (CloseReason) r27.a.a(CloseReason.class, r100);
    }

    public static CloseReason[] values() {
        return (CloseReason[]) f87664a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public CloseReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
