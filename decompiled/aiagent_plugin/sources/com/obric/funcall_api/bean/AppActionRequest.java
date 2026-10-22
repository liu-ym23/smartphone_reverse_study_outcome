package com.obric.funcall_api.bean;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AppActionRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppActionRequest {
    private final String content;
    private final long createTime;
    private final ConcurrentHashMap<String, String> ext;
    private final long id;
    private final long messageId;
    private final long questionId;
    private final Bitmap screenshot;

    public AppActionRequest() {
        this(0, 0, 0, 0, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppActionRequest copy$default(AppActionRequest r12, long r13, long r15, long r17, long r19, String r21, Bitmap r22, ConcurrentHashMap r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        long r1 = r12.id;
    L7:
        if ((r24 & 2) == 0) goto L9;
        long r3 = r12.messageId;
    L11:
        if ((r24 & 4) == 0) goto L13;
        long r5 = r12.questionId;
    L15:
        if ((r24 & 8) == 0) goto L17;
        long r7 = r12.createTime;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r9 = r12.content;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Bitmap r10 = r12.screenshot;
    L27:
        if ((r24 & 64) == 0) goto L29;
        ConcurrentHashMap r11 = r12.ext;
    L31:
        return r12.copy(r1, r3, r5, r7, r9, r10, r11);
    L29:
        r11 = r23;
        goto L31
    L25:
        r10 = r22;
        goto L27
    L21:
        r9 = r21;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r5 = r17;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.messageId;
    }

    public final long component3() {
        return this.questionId;
    }

    public final long component4() {
        return this.createTime;
    }

    public final String component5() {
        return this.content;
    }

    public final Bitmap component6() {
        return this.screenshot;
    }

    public final ConcurrentHashMap<String, String> component7() {
        return this.ext;
    }

    public final AppActionRequest copy(long r14, long r16, long r18, long r20, String r22, Bitmap r23, ConcurrentHashMap<String, String> r24) {
        return new AppActionRequest(r14, r16, r18, r20, r22, r23, r24);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AppActionRequest.class) == true) goto L8;
        return false;
    L8:
        AppActionRequest r10 = (AppActionRequest) ZeusTransformUtils.preCheckCast(r9, AppActionRequest.class, "com.obric.aiagent.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (this.messageId == r10.messageId) goto L15;
        return false;
    L15:
        if (this.questionId == r10.questionId) goto L18;
        return false;
    L18:
        if (this.createTime == r10.createTime) goto L21;
        return false;
    L21:
        if (o.a(this.content, r10.content) == true) goto L24;
        return false;
    L24:
        if (o.a(this.screenshot, r10.screenshot) == true) goto L27;
        return false;
    L27:
        if (o.a(this.ext, r10.ext) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.messageId)) * 31) + Long.hashCode(this.questionId)) * 31) + Long.hashCode(this.createTime)) * 31;
        String r1 = this.content;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Bitmap r5 = this.screenshot;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        ConcurrentHashMap<String, String> r8 = this.ext;
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
        return "AppActionRequest(id=" + this.id + ", messageId=" + this.messageId + ", questionId=" + this.questionId + ", createTime=" + this.createTime + ", content=" + this.content + ", screenshot=" + this.screenshot + ", ext=" + this.ext + ')';
    }

    public AppActionRequest(long r1, long r3, long r5, long r7, String r9, Bitmap r10, ConcurrentHashMap<String, String> r11) {
        this.id = r1;
        this.messageId = r3;
        this.questionId = r5;
        this.createTime = r7;
        this.content = r9;
        this.screenshot = r10;
        this.ext = r11;
    }

    public /* synthetic */ AppActionRequest(long r3, long r5, long r7, long r9, String r11, Bitmap r12, ConcurrentHashMap r13, int r14, h r15) {
        if ((r14 & 1) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r5 = -1;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r7 = -1;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r9 = -1;
    L15:
        if ((r14 & 16) == 0) goto L18;
        r11 = "";
    L18:
        if ((r14 & 32) == 0) goto L21;
        r12 = null;
    L21:
        if ((r14 & 64) == 0) goto L23;
        r13 = null;
    L23:
        this(r3, r5, r7, r9, r11, r12, r13);
    }

    public final long getId() {
        return this.id;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getContent() {
        return this.content;
    }

    public final Bitmap getScreenshot() {
        return this.screenshot;
    }

    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }
}
