package com.bytedance.apm.trace.model.cross;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import dt3.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
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

    public String toString() {
        return "NativeSpan{, spanName='" + this.spanName + "', spanId=" + this.spanId + ", parentId=" + this.parentId + ", referenceId=" + this.referenceId + ", startTime=" + this.startTime + ", finishTime=" + this.finishTime + ", threadName='" + this.threadName + "', tags=" + this.tags + ", isErrorSpan=" + this.isErrorSpan + ", isFinish=" + this.isFinish + '}';
    }

    public long getFinishTime() {
        return this.finishTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public a parseToSpan(gt3.a r100) {
        if (this.isFinish == true) goto L5;
        return null;
    L5:
        CastLongProtector.parseLong(this.spanId);
        throw null;
    }

    public NativeSpan(String r100, String r101, String r102, String r103, long r104, long r105, String r106, HashMap<String, String> r110, boolean r111, boolean r112) {
        this.spanName = r100;
        this.spanId = r101;
        this.parentId = r102;
        this.referenceId = r103;
        this.startTime = r104;
        this.finishTime = r105;
        this.threadName = r106;
        this.tags = r110;
        this.isErrorSpan = r111;
        this.isFinish = r112;
    }
}
