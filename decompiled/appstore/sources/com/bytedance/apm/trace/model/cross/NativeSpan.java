package com.bytedance.apm.trace.model.cross;

import androidx.annotation.Keep;
import com.bytedance.apm.trace.api.ITracingWindowSpan;
import i2.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
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

    public NativeSpan(String r10, String r11, String r12, String r13, long r14, long r15, String r16, HashMap<String, String> r17, boolean r18, boolean r19) {
        this.spanName = r10;
        this.spanId = r11;
        this.parentId = r12;
        this.referenceId = r13;
        this.startTime = r14;
        this.finishTime = r15;
        this.threadName = r16;
        this.tags = r17;
        this.isErrorSpan = r18;
        this.isFinish = r19;
    }

    public long getFinishTime() {
        return this.finishTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public ITracingWindowSpan parseToSpan(a r10) {
        if (this.isFinish == true) goto L5;
        return null;
    L5:
        Long.parseLong(this.spanId);
        throw null;
    }

    public String toString() {
        return "NativeSpan{, spanName='" + this.spanName + "', spanId=" + this.spanId + ", parentId=" + this.parentId + ", referenceId=" + this.referenceId + ", startTime=" + this.startTime + ", finishTime=" + this.finishTime + ", threadName='" + this.threadName + "', tags=" + this.tags + ", isErrorSpan=" + this.isErrorSpan + ", isFinish=" + this.isFinish + '}';
    }
}
