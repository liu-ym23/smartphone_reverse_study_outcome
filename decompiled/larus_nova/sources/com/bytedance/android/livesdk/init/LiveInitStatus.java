package com.bytedance.android.livesdk.init;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/init/LiveInitStatus;", "", "NOT_INIT", "INITING", "INITED", "live-spi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveInitStatus extends Enum<LiveInitStatus> {
    public static final LiveInitStatus INITED = null;
    public static final LiveInitStatus INITING = null;
    public static final LiveInitStatus NOT_INIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveInitStatus[] f132650a = null;

    static {
        LiveInitStatus r100 = new LiveInitStatus("NOT_INIT", 0);
        NOT_INIT = r100;
        LiveInitStatus r101 = new LiveInitStatus("INITING", 1);
        INITING = r101;
        LiveInitStatus r102 = new LiveInitStatus("INITED", 2);
        INITED = r102;
        f132650a = new LiveInitStatus[]{r100, r101, r102};
    }

    public static LiveInitStatus valueOf(String r100) {
        return (LiveInitStatus) r27.a.a(LiveInitStatus.class, r100);
    }

    public static LiveInitStatus[] values() {
        return (LiveInitStatus[]) f132650a.clone();
    }

    public LiveInitStatus(String r100, int r101) {
        super(r100, r101);
    }
}
