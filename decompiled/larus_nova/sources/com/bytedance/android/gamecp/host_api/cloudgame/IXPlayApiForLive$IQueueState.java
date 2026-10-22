package com.bytedance.android.gamecp.host_api.cloudgame;

import kotlin.Metadata;
import r27.a;
import tv.b;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/android/gamecp/host_api/cloudgame/IXPlayApiForLive$IQueueState", "", "Lcom/bytedance/android/gamecp/host_api/cloudgame/IXPlayApiForLive$IQueueState;", "", "toString", "DEFULT_ERROR", "ERROR", "INQUEUE", "DEQUEUE", "RANKING", "READY", "EXPIRE", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IXPlayApiForLive$IQueueState extends Enum<IXPlayApiForLive$IQueueState> {
    public static final IXPlayApiForLive$IQueueState DEFULT_ERROR = null;
    public static final IXPlayApiForLive$IQueueState DEQUEUE = null;
    public static final IXPlayApiForLive$IQueueState ERROR = null;
    public static final IXPlayApiForLive$IQueueState EXPIRE = null;
    public static final IXPlayApiForLive$IQueueState INQUEUE = null;
    public static final IXPlayApiForLive$IQueueState RANKING = null;
    public static final IXPlayApiForLive$IQueueState READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IXPlayApiForLive$IQueueState[] f57359a = null;

    static {
        IXPlayApiForLive$IQueueState r100 = new IXPlayApiForLive$IQueueState("DEFULT_ERROR", 0);
        DEFULT_ERROR = r100;
        IXPlayApiForLive$IQueueState r101 = new IXPlayApiForLive$IQueueState("ERROR", 1);
        ERROR = r101;
        IXPlayApiForLive$IQueueState r102 = new IXPlayApiForLive$IQueueState("INQUEUE", 2);
        INQUEUE = r102;
        IXPlayApiForLive$IQueueState r103 = new IXPlayApiForLive$IQueueState("DEQUEUE", 3);
        DEQUEUE = r103;
        IXPlayApiForLive$IQueueState r104 = new IXPlayApiForLive$IQueueState("RANKING", 4);
        RANKING = r104;
        IXPlayApiForLive$IQueueState r105 = new IXPlayApiForLive$IQueueState("READY", 5);
        READY = r105;
        IXPlayApiForLive$IQueueState r106 = new IXPlayApiForLive$IQueueState("EXPIRE", 6);
        EXPIRE = r106;
        f57359a = new IXPlayApiForLive$IQueueState[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static IXPlayApiForLive$IQueueState valueOf(String r100) {
        return (IXPlayApiForLive$IQueueState) a.a(IXPlayApiForLive$IQueueState.class, r100);
    }

    public static IXPlayApiForLive$IQueueState[] values() {
        return (IXPlayApiForLive$IQueueState[]) f57359a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(b.f547663a[ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "EXPIRE";
    L6:
        return "READY";
    L7:
        return "RANKING";
    L8:
        return "DEQUEUE";
    L9:
        return "INQUEUE";
    L10:
        return "ERROR";
    }

    public IXPlayApiForLive$IQueueState(String r100, int r101) {
        super(r100, r101);
    }
}
