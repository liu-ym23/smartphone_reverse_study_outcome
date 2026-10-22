package com.bytedance.android.live.cloudgrouplive.rtc;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/rtc/AnchorGroupLiveStatus;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "DEFAULT", "WAITING", "READY", "PERFORMING", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AnchorGroupLiveStatus extends Enum<AnchorGroupLiveStatus> {
    public static final AnchorGroupLiveStatus DEFAULT = null;
    public static final AnchorGroupLiveStatus PERFORMING = null;
    public static final AnchorGroupLiveStatus READY = null;
    public static final AnchorGroupLiveStatus WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnchorGroupLiveStatus[] f64464a = null;
    private final String des;

    static {
        AnchorGroupLiveStatus r100 = new AnchorGroupLiveStatus("DEFAULT", 0, "default");
        DEFAULT = r100;
        AnchorGroupLiveStatus r101 = new AnchorGroupLiveStatus("WAITING", 1, "waiting");
        WAITING = r101;
        AnchorGroupLiveStatus r102 = new AnchorGroupLiveStatus("READY", 2, "ready");
        READY = r102;
        AnchorGroupLiveStatus r103 = new AnchorGroupLiveStatus("PERFORMING", 3, "performing");
        PERFORMING = r103;
        f64464a = new AnchorGroupLiveStatus[]{r100, r101, r102, r103};
    }

    public static AnchorGroupLiveStatus valueOf(String r100) {
        return (AnchorGroupLiveStatus) r27.a.a(AnchorGroupLiveStatus.class, r100);
    }

    public static AnchorGroupLiveStatus[] values() {
        return (AnchorGroupLiveStatus[]) f64464a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public AnchorGroupLiveStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.des = r102;
    }
}
