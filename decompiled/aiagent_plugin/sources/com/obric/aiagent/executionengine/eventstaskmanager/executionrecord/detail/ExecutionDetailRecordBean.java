package com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: ExecutionDetailRecordBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExecutionDetailRecordBean {
    private final String appName;
    private final String detailText;
    private final int detailType;
    private final long execTime;
    private final Map<String, String> ext;
    private final long id;
    private final String packageName;
    private final String sessionId;

    public static /* synthetic */ ExecutionDetailRecordBean copy$default(ExecutionDetailRecordBean r12, String r13, long r14, String r16, String r17, String r18, int r19, Map r20, long r21, int r23, Object r24) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        if ((r23 & 1) == 0) goto L5;
        String r3 = r12.sessionId;
    L7:
        if ((r23 & 2) == 0) goto L9;
        long r4 = r12.execTime;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r6 = r12.packageName;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r7 = r12.appName;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r8 = r12.detailText;
    L23:
        if ((r23 & 32) == 0) goto L25;
        int r9 = r12.detailType;
    L27:
        if ((r23 & 64) == 0) goto L30;
        r2 = r12.ext;
    L30:
        if ((r23 & 128) == 0) goto L32;
        long r10 = r12.id;
    L34:
        return r12.copy(r3, r4, r6, r7, r8, r9, r2, r10);
    L32:
        r10 = r21;
        goto L34
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }

    public final String component1() {
        return this.sessionId;
    }

    public final long component2() {
        return this.execTime;
    }

    public final String component3() {
        return this.packageName;
    }

    public final String component4() {
        return this.appName;
    }

    public final String component5() {
        return this.detailText;
    }

    public final int component6() {
        return this.detailType;
    }

    public final Map<String, String> component7() {
        return this.ext;
    }

    public final long component8() {
        return this.id;
    }

    public final ExecutionDetailRecordBean copy(String r13, long r14, String r16, String r17, String r18, int r19, Map<String, String> r20, long r21) {
        return new ExecutionDetailRecordBean(r13, r14, r16, r17, r18, r19, (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin"), r21);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ExecutionDetailRecordBean.class) == true) goto L8;
        return false;
    L8:
        ExecutionDetailRecordBean r10 = (ExecutionDetailRecordBean) ZeusTransformUtils.preCheckCast(r9, ExecutionDetailRecordBean.class, "com.obric.aiagent.plugin");
        if (o.a(this.sessionId, r10.sessionId) == true) goto L12;
        return false;
    L12:
        if (this.execTime == r10.execTime) goto L15;
        return false;
    L15:
        if (o.a(this.packageName, r10.packageName) == true) goto L18;
        return false;
    L18:
        if (o.a(this.appName, r10.appName) == true) goto L21;
        return false;
    L21:
        if (o.a(this.detailText, r10.detailText) == true) goto L24;
        return false;
    L24:
        if (this.detailType == r10.detailType) goto L27;
        return false;
    L27:
        if (o.a(this.ext, r10.ext) == true) goto L30;
        return false;
    L30:
        if (this.id == r10.id) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.sessionId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + Long.hashCode(this.execTime)) * 31;
        String r4 = this.packageName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.appName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.detailText;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + Integer.hashCode(this.detailType)) * 31;
        Map<String, String> r13 = this.ext;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return ((r12 + r1) * 31) + Long.hashCode(this.id);
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ExecutionDetailRecordBean(sessionId=" + this.sessionId + ", execTime=" + this.execTime + ", packageName=" + this.packageName + ", appName=" + this.appName + ", detailText=" + this.detailText + ", detailType=" + this.detailType + ", ext=" + this.ext + ", id=" + this.id + ')';
    }

    public ExecutionDetailRecordBean(String r3, long r4, String r6, String r7, String r8, int r9, Map<String, String> r10, long r11) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        this.sessionId = r3;
        this.execTime = r4;
        this.packageName = r6;
        this.appName = r7;
        this.detailText = r8;
        this.detailType = r9;
        this.ext = r12;
        this.id = r11;
    }

    public /* synthetic */ ExecutionDetailRecordBean(String r13, long r14, String r16, String r17, String r18, int r19, Map r20, long r21, int r23, h r24) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        if ((r23 & 128) == 0) goto L5;
        long r10 = 0;
    L6:
        this(r13, r14, r16, r17, r18, r19, r9, r10);
        return;
    L5:
        r10 = r21;
        goto L6
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getExecTime() {
        return this.execTime;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getDetailText() {
        return this.detailText;
    }

    public final int getDetailType() {
        return this.detailType;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final long getId() {
        return this.id;
    }
}
