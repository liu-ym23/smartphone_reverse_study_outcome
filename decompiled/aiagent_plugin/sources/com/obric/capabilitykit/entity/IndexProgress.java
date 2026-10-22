package com.obric.capabilitykit.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class IndexProgress {
    private final int left;
    private final int total;

    public IndexProgress(int r1, int r2) {
        this.left = r1;
        this.total = r2;
    }

    public static /* synthetic */ IndexProgress copy$default(IndexProgress r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.left;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.total;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.total;
    }

    public final IndexProgress copy(int r1, int r2) {
        return new IndexProgress(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IndexProgress.class) == true) goto L8;
        return false;
    L8:
        IndexProgress r6 = (IndexProgress) ZeusTransformUtils.preCheckCast(r5, IndexProgress.class, "com.obric.aiagent.plugin");
        if (this.left == r6.left) goto L12;
        return false;
    L12:
        if (this.total == r6.total) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (Integer.hashCode(this.left) * 31) + Integer.hashCode(this.total);
    }

    public String toString() {
        return "IndexProgress(left=" + this.left + ", total=" + this.total + ')';
    }
}
