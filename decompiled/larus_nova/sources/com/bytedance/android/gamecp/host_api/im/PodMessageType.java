package com.bytedance.android.gamecp.host_api.im;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/im/PodMessageType;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "Unknown", "TimeUpNotify", "TimeUp", "GameClose", "UserClose", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PodMessageType extends Enum<PodMessageType> {
    public static final PodMessageType GameClose = null;
    public static final PodMessageType TimeUp = null;
    public static final PodMessageType TimeUpNotify = null;
    public static final PodMessageType Unknown = null;
    public static final PodMessageType UserClose = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PodMessageType[] f57365a = null;
    private int type;

    static {
        PodMessageType r100 = new PodMessageType("Unknown", 0, 0);
        Unknown = r100;
        PodMessageType r101 = new PodMessageType("TimeUpNotify", 1, 1);
        TimeUpNotify = r101;
        PodMessageType r102 = new PodMessageType("TimeUp", 2, 2);
        TimeUp = r102;
        PodMessageType r103 = new PodMessageType("GameClose", 3, 3);
        GameClose = r103;
        PodMessageType r104 = new PodMessageType("UserClose", 4, 4);
        UserClose = r104;
        f57365a = new PodMessageType[]{r100, r101, r102, r103, r104};
    }

    public static PodMessageType valueOf(String r100) {
        return (PodMessageType) a.a(PodMessageType.class, r100);
    }

    public static PodMessageType[] values() {
        return (PodMessageType[]) f57365a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public PodMessageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
