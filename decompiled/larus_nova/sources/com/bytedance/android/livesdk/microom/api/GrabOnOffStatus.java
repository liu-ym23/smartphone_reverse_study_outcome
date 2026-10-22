package com.bytedance.android.livesdk.microom.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/microom/api/GrabOnOffStatus;", "", "", "status", "J", "getStatus", "()J", "OPEN_ON_OFF", "CLOSE_ON_OFF", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GrabOnOffStatus extends Enum<GrabOnOffStatus> {
    public static final GrabOnOffStatus CLOSE_ON_OFF = null;
    public static final GrabOnOffStatus OPEN_ON_OFF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrabOnOffStatus[] f153814a = null;
    private final long status;

    static {
        GrabOnOffStatus r100 = new GrabOnOffStatus("OPEN_ON_OFF", 0, 1);
        OPEN_ON_OFF = r100;
        GrabOnOffStatus r101 = new GrabOnOffStatus("CLOSE_ON_OFF", 1, 2);
        CLOSE_ON_OFF = r101;
        f153814a = new GrabOnOffStatus[]{r100, r101};
    }

    public static GrabOnOffStatus valueOf(String r100) {
        return (GrabOnOffStatus) a.a(GrabOnOffStatus.class, r100);
    }

    public static GrabOnOffStatus[] values() {
        return (GrabOnOffStatus[]) f153814a.clone();
    }

    public final long getStatus() {
        return this.status;
    }

    public GrabOnOffStatus(String r100, int r101, long r102) {
        super(r100, r101);
        this.status = r102;
    }
}
