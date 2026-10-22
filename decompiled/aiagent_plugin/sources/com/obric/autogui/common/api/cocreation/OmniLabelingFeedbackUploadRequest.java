package com.obric.autogui.common.api.cocreation;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: IOmniLabelingFeedbackUploader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OmniLabelingFeedbackUploadRequest {
    private final String content;
    private final String recordId;
    private final List<String> tags;
    private final String taskId;
    private final String type;

    public static /* synthetic */ OmniLabelingFeedbackUploadRequest copy$default(OmniLabelingFeedbackUploadRequest r6, String r7, String r8, String r9, List r10, String r11, int r12, Object r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.taskId;
    L5:
        String r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.recordId;
    L8:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.content;
    L11:
        String r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r14 = r6.tags;
    L14:
        List<String> r4 = r14;
        if ((r12 & 16) == 0) goto L18;
        r11 = r6.type;
    L18:
        return r6.copy(r1, r2, r3, r4, r11);
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component2() {
        return this.recordId;
    }

    public final String component3() {
        return this.content;
    }

    public final List<String> component4() {
        return this.tags;
    }

    public final String component5() {
        return this.type;
    }

    public final OmniLabelingFeedbackUploadRequest copy(String r7, String r8, String r9, List<String> r10, String r11) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        o.e(r7, DBDefinition.TASK_ID);
        o.e(r8, "recordId");
        o.e(r4, "tags");
        return new OmniLabelingFeedbackUploadRequest(r7, r8, r9, r4, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OmniLabelingFeedbackUploadRequest.class) == true) goto L8;
        return false;
    L8:
        OmniLabelingFeedbackUploadRequest r6 = (OmniLabelingFeedbackUploadRequest) ZeusTransformUtils.preCheckCast(r5, OmniLabelingFeedbackUploadRequest.class, "com.obric.aiagent.plugin");
        if (o.a(this.taskId, r6.taskId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.recordId, r6.recordId) == true) goto L15;
        return false;
    L15:
        if (o.a(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (o.a(this.tags, r6.tags) == true) goto L21;
        return false;
    L21:
        if (o.a(this.type, r6.type) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.taskId.hashCode() * 31) + this.recordId.hashCode()) * 31;
        String r1 = this.content;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.tags.hashCode()) * 31;
        String r5 = this.type;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniLabelingFeedbackUploadRequest(taskId=" + this.taskId + ", recordId=" + this.recordId + ", content=" + this.content + ", tags=" + this.tags + ", type=" + this.type + ')';
    }

    public OmniLabelingFeedbackUploadRequest(String r3, String r4, String r5, List<String> r6, String r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r3, DBDefinition.TASK_ID);
        o.e(r4, "recordId");
        o.e(r8, "tags");
        this.taskId = r3;
        this.recordId = r4;
        this.content = r5;
        this.tags = r8;
        this.type = r7;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final String getContent() {
        return this.content;
    }

    public /* synthetic */ OmniLabelingFeedbackUploadRequest(String r8, String r9, String r10, List r11, String r12, int r13, h r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r13 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        r15 = p.b();
    L9:
        List r5 = r15;
        if ((r13 & 16) == 0) goto L12;
        String r6 = null;
    L13:
        this(r8, r9, r4, r5, r6);
        return;
    L12:
        r6 = r12;
        goto L13
    L5:
        r4 = r10;
        goto L7
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getType() {
        return this.type;
    }
}
