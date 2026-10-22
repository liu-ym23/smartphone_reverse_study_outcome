package com.bytedance.android.livesdkapi.minigame;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/CanStartLiveStatus;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "CAN_LIVE", "ANCHOR_BLOCKED", "USER_NOT_LOGIN", "USER_NOT_VERIFIED", "USER_IS_CHILDREN", "BAD_NETWORK", "NO_NETWORK", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CanStartLiveStatus extends Enum<CanStartLiveStatus> {
    private static final /* synthetic */ CanStartLiveStatus[] $VALUES = null;
    public static final CanStartLiveStatus ANCHOR_BLOCKED = null;
    public static final CanStartLiveStatus BAD_NETWORK = null;
    public static final CanStartLiveStatus CAN_LIVE = null;
    public static final CanStartLiveStatus NO_NETWORK = null;
    public static final CanStartLiveStatus USER_IS_CHILDREN = null;
    public static final CanStartLiveStatus USER_NOT_LOGIN = null;
    public static final CanStartLiveStatus USER_NOT_VERIFIED = null;
    private final int code;

    static {
        CanStartLiveStatus r100 = new CanStartLiveStatus("CAN_LIVE", 0, 0);
        CAN_LIVE = r100;
        CanStartLiveStatus r101 = new CanStartLiveStatus("ANCHOR_BLOCKED", 1, 1);
        ANCHOR_BLOCKED = r101;
        CanStartLiveStatus r102 = new CanStartLiveStatus("USER_NOT_LOGIN", 2, 2);
        USER_NOT_LOGIN = r102;
        CanStartLiveStatus r103 = new CanStartLiveStatus("USER_NOT_VERIFIED", 3, 3);
        USER_NOT_VERIFIED = r103;
        CanStartLiveStatus r104 = new CanStartLiveStatus("USER_IS_CHILDREN", 4, 4);
        USER_IS_CHILDREN = r104;
        CanStartLiveStatus r105 = new CanStartLiveStatus("BAD_NETWORK", 5, 5);
        BAD_NETWORK = r105;
        CanStartLiveStatus r106 = new CanStartLiveStatus("NO_NETWORK", 6, 6);
        NO_NETWORK = r106;
        $VALUES = new CanStartLiveStatus[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static CanStartLiveStatus valueOf(String r100) {
        return (CanStartLiveStatus) a.a(CanStartLiveStatus.class, r100);
    }

    public static CanStartLiveStatus[] values() {
        return (CanStartLiveStatus[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    private CanStartLiveStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
