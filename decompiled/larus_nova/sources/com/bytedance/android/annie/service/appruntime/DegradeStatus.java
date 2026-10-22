package com.bytedance.android.annie.service.appruntime;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/annie/service/appruntime/DegradeStatus;", "", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "liveDegrade", "lowMemory", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum DegradeStatus extends Enum<DegradeStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DegradeStatus[] f39843a = null;
    public static final DegradeStatus liveDegrade = null;
    public static final DegradeStatus lowMemory = null;
    private final String status;

    public static DegradeStatus valueOf(String r100) {
        return (DegradeStatus) a.a(DegradeStatus.class, r100);
    }

    public static DegradeStatus[] values() {
        return (DegradeStatus[]) f39843a.clone();
    }

    static {
        DegradeStatus r100 = new DegradeStatus("liveDegrade", 0, "live_degrade");
        liveDegrade = r100;
        DegradeStatus r101 = new DegradeStatus("lowMemory", 1, "low_memory");
        lowMemory = r101;
        f39843a = new DegradeStatus[]{r100, r101};
    }

    public final String getStatus() {
        return this.status;
    }

    public DegradeStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
