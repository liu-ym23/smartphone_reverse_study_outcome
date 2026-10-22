package com.obric.aiagent.product.platform.api.notification;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ToastShowInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ToastShowInfo {
    private final String content;
    private final long timestampMs;
    private final String type;

    public static /* synthetic */ ToastShowInfo copy$default(ToastShowInfo r0, String r1, String r2, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.timestampMs;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.content;
    }

    public final long component3() {
        return this.timestampMs;
    }

    public final ToastShowInfo copy(String r1, String r2, long r3) {
        o.e(r2, "content");
        return new ToastShowInfo(r1, r2, r3);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ToastShowInfo.class) == true) goto L8;
        return false;
    L8:
        ToastShowInfo r8 = (ToastShowInfo) ZeusTransformUtils.preCheckCast(r7, ToastShowInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.type, r8.type) == true) goto L12;
        return false;
    L12:
        if (o.a(this.content, r8.content) == true) goto L15;
        return false;
    L15:
        if (this.timestampMs == r8.timestampMs) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.type;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.timestampMs);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ToastShowInfo(type=" + this.type + ", content=" + this.content + ", timestampMs=" + this.timestampMs + ')';
    }

    public ToastShowInfo(String r2, String r3, long r4) {
        o.e(r3, "content");
        this.type = r2;
        this.content = r3;
        this.timestampMs = r4;
    }

    public final String getType() {
        return this.type;
    }

    public final String getContent() {
        return this.content;
    }

    public /* synthetic */ ToastShowInfo(String r1, String r2, long r3, int r5, h r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = System.currentTimeMillis();
    L5:
        this(r1, r2, r3);
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }
}
