package com.bytedance.apm.trace.model.cross;

import com.bytedance.apm.trace.a.c;
import com.bytedance.apm.trace.model.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NativeSpan {
    private long finishTime;
    private boolean isErrorSpan;
    private boolean isFinish;
    private String parentId;
    private String referenceId;
    private String spanId;
    private String spanName;
    private long startTime;
    private Map<String, String> tags;
    private String threadName;

    public NativeSpan(String r1, String r2, String r3, String r4, long r5, long r7, String r9, HashMap<String, String> r10, boolean r11, boolean r12) {
        this.spanName = r1;
        this.spanId = r2;
        this.parentId = r3;
        this.referenceId = r4;
        this.startTime = r5;
        this.finishTime = r7;
        this.threadName = r9;
        this.tags = r10;
        this.isErrorSpan = r11;
        this.isFinish = r12;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getFinishTime() {
        return this.finishTime;
    }

    public c parseToSpan(a r5) {
        if (this.isFinish == true) goto L6;
        return null;
    L6:
        c r6 = r5.a(this.spanName, Long.parseLong(this.spanId));
        String r0 = this.parentId;
        if (r0 != null) goto L9;
    L11:
        String r1 = this.referenceId;
        if (r1 != null) goto L14;
    L16:
        r6.a(this.threadName);
        Iterator<Map.Entry<String, String>> r4 = this.tags.entrySet().iterator();
    L18:
        if (r4.hasNext() == false) goto L20;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r6.a((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L18
    L20:
        return r6;
    L14:
        if (r1.isEmpty() == true) goto L16;
        r6.b(Long.parseLong(this.referenceId));
        goto L16
    L9:
        if (r0.isEmpty() == true) goto L11;
        r6.a(Long.parseLong(this.parentId));
        goto L11
    }

    public String toString() {
        return "NativeSpan{, spanName='" + this.spanName + "', spanId=" + this.spanId + ", parentId=" + this.parentId + ", referenceId=" + this.referenceId + ", startTime=" + this.startTime + ", finishTime=" + this.finishTime + ", threadName='" + this.threadName + "', tags=" + this.tags + ", isErrorSpan=" + this.isErrorSpan + ", isFinish=" + this.isFinish + '}';
    }
}
