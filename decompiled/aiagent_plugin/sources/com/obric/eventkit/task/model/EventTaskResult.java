package com.obric.eventkit.task.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: EventTaskResult.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EventTaskResult {
    private final int code;
    private final List<EventTask> data;
    private final String detailReason;
    private final String msg;

    public static /* synthetic */ EventTaskResult copy$default(EventTaskResult r1, int r2, String r3, List r4, String r5, int r6, Object r7) {
        List<EventTask> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.code;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.msg;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.data;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.detailReason;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final List<EventTask> component3() {
        return this.data;
    }

    public final String component4() {
        return this.detailReason;
    }

    public final EventTaskResult copy(int r2, String r3, List<? extends EventTask> r4, String r5) {
        return new EventTaskResult(r2, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, EventTaskResult.class) == true) goto L8;
        return false;
    L8:
        EventTaskResult r6 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r5, EventTaskResult.class, "com.obric.aiagent.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (o.a(this.msg, r6.msg) == true) goto L15;
        return false;
    L15:
        if (o.a(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (o.a(this.detailReason, r6.detailReason) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.code) * 31;
        String r1 = this.msg;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<EventTask> r5 = this.data;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.detailReason;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "EventTaskResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", detailReason=" + this.detailReason + ')';
    }

    public EventTaskResult(int r3, String r4, List<? extends EventTask> r5, String r6) {
        List<EventTask> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.code = r3;
        this.msg = r4;
        this.data = r7;
        this.detailReason = r6;
    }

    public /* synthetic */ EventTaskResult(int r2, String r3, List r4, String r5, int r6, h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r5 = null;
    L5:
        this(r2, r3, r8, r5);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final List<EventTask> getData() {
        return this.data;
    }

    public final String getDetailReason() {
        return this.detailReason;
    }
}
