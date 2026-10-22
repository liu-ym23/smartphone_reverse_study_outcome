package com.bytedance.android.livesdkapi.init;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/LiveInitTaskInfo;", "Lcom/bytedance/android/livesdkapi/init/LiveInitCostInfo;", "periodName", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "()V", "getPeriodName", "()Ljava/lang/String;", "setPeriodName", "(Ljava/lang/String;)V", "threadId", "", "getThreadId", "()J", "setThreadId", "(J)V", "live-utils_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInitTaskInfo extends LiveInitCostInfo {
    private String periodName;
    private long threadId;

    public LiveInitTaskInfo() {
        this.periodName = "";
    }

    public final String getPeriodName() {
        return this.periodName;
    }

    public final long getThreadId() {
        return this.threadId;
    }

    public final void setPeriodName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.periodName = r100;
    }

    public final void setThreadId(long r100) {
        this.threadId = r100;
    }

    public LiveInitTaskInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "periodName");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.periodName = r100;
        setName(r101);
    }
}
