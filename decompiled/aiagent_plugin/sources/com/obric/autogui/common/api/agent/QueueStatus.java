package com.obric.autogui.common.api.agent;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: QueueStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class QueueStatus {
    private final boolean isQueueCompleted;
    private final int remainingQueueSize;

    public static /* synthetic */ QueueStatus copy$default(QueueStatus r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.remainingQueueSize;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isQueueCompleted;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.remainingQueueSize;
    }

    public final boolean component2() {
        return this.isQueueCompleted;
    }

    public final QueueStatus copy(int r1, boolean r2) {
        return new QueueStatus(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, QueueStatus.class) == true) goto L8;
        return false;
    L8:
        QueueStatus r6 = (QueueStatus) ZeusTransformUtils.preCheckCast(r5, QueueStatus.class, "com.obric.aiagent.plugin");
        if (this.remainingQueueSize == r6.remainingQueueSize) goto L12;
        return false;
    L12:
        if (this.isQueueCompleted == r6.isQueueCompleted) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.remainingQueueSize) * 31) + Boolean.hashCode(this.isQueueCompleted);
    }

    public String toString() {
        return "QueueStatus(remainingQueueSize=" + this.remainingQueueSize + ", isQueueCompleted=" + this.isQueueCompleted + ')';
    }

    public QueueStatus(int r1, boolean r2) {
        this.remainingQueueSize = r1;
        this.isQueueCompleted = r2;
    }

    public final int getRemainingQueueSize() {
        return this.remainingQueueSize;
    }

    public final boolean isQueueCompleted() {
        return this.isQueueCompleted;
    }
}
