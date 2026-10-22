package com.bytedance.frameworks.baselib.network.queryfilter;

/* JADX INFO: loaded from: classes2.dex */
final class QueryActionInfo {
    private long mActionEndTime;
    private boolean mActionHit;
    private int mActionPriority;
    private long mActionStartTime;

    QueryActionInfo() {
        this.mActionHit = false;
        this.mActionPriority = -1;
        this.mActionStartTime = -1;
        this.mActionEndTime = -1;
    }

    public long getDispatchActionDuration() {
        long r0 = this.mActionStartTime;
        if (r0 < 0) goto L11;
        long r4 = this.mActionEndTime;
        if (r4 >= 0) goto L7;
        return -1;
    L7:
        if (r0 <= r4) goto L10;
        return -1;
    L10:
        return r4 - r0;
    L11:
        return -1;
    }

    public boolean isActionHit() {
        return this.mActionHit;
    }

    public void setActionHit(boolean r1) {
        this.mActionHit = r1;
    }

    public int getActionPriority() {
        return this.mActionPriority;
    }

    public void setActionPriority(int r1) {
        this.mActionPriority = r1;
    }

    public void setActionStartTime(long r1) {
        this.mActionStartTime = r1;
    }

    public void setActionEndTime(long r1) {
        this.mActionEndTime = r1;
    }
}
