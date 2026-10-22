package com.bytedance.android.live.hostadapter.network.ws;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/hostadapter/network/ws/Status;", "", "(Ljava/lang/String;I)V", "CONNECTING", "CONNECTED", State.DISCONNECTED, "FAILED", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public final enum Status extends Enum<Status> {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final Status CONNECTED = null;
    public static final Status CONNECTING = null;
    public static final Status DISCONNECTED = null;
    public static final Status FAILED = null;

    static {
        Status r100 = new Status("CONNECTING", 0);
        CONNECTING = r100;
        Status r101 = new Status("CONNECTED", 1);
        CONNECTED = r101;
        Status r102 = new Status(State.DISCONNECTED, 2);
        DISCONNECTED = r102;
        Status r103 = new Status("FAILED", 3);
        FAILED = r103;
        $VALUES = new Status[]{r100, r101, r102, r103};
    }

    public static Status valueOf(String r100) {
        return (Status) a.a(Status.class, r100);
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }

    private Status(String r100, int r101) {
        super(r100, r101);
    }
}
