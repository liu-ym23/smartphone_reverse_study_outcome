package com.obric.eventkit.task.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ConditionTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ConditionTaskResult {
    private final int code;
    private final List<ConditionTask> data;
    private final String msg;

    public static /* synthetic */ ConditionTaskResult copy$default(ConditionTaskResult r1, int r2, String r3, List r4, int r5, Object r6) {
        List<ConditionTask> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.code;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.msg;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r7 = r1.data;
    L12:
        return r1.copy(r2, r3, r7);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final List<ConditionTask> component3() {
        return this.data;
    }

    public final ConditionTaskResult copy(int r2, String r3, List<ConditionTask> r4) {
        return new ConditionTaskResult(r2, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ConditionTaskResult.class) == true) goto L8;
        return false;
    L8:
        ConditionTaskResult r6 = (ConditionTaskResult) ZeusTransformUtils.preCheckCast(r5, ConditionTaskResult.class, "com.obric.aiagent.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (o.a(this.msg, r6.msg) == true) goto L15;
        return false;
    L15:
        if (o.a(this.data, r6.data) == true) goto L17;
        return false;
    L17:
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
        List<ConditionTask> r5 = this.data;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ConditionTaskResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
    }

    public ConditionTaskResult(int r3, String r4, List<ConditionTask> r5) {
        List<ConditionTask> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.code = r3;
        this.msg = r4;
        this.data = r6;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final List<ConditionTask> getData() {
        return this.data;
    }
}
