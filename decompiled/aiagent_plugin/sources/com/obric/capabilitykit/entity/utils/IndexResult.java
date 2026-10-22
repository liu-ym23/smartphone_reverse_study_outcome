package com.obric.capabilitykit.entity.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class IndexResult {
    private final int code;
    private final String message;

    public IndexResult(int r2, String r3) {
        o.e(r3, "message");
        this.code = r2;
        this.message = r3;
    }

    public static /* synthetic */ IndexResult copy$default(IndexResult r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final IndexResult copy(int r1, String r2) {
        o.e(r2, "message");
        return new IndexResult(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IndexResult.class) == true) goto L8;
        return false;
    L8:
        IndexResult r6 = (IndexResult) ZeusTransformUtils.preCheckCast(r5, IndexResult.class, "com.obric.aiagent.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (o.a(this.message, r6.message) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (Integer.hashCode(this.code) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "IndexResult(code=" + this.code + ", message=" + this.message + ')';
    }
}
