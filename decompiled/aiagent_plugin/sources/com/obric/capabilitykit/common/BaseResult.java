package com.obric.capabilitykit.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class BaseResult {
    private String details;
    private ConcurrentHashMap<String, String> ext;
    private File file;
    private Long questionId;
    private String replyFor;
    private Long replyId;
    private int ret;
    private int uiType;

    public BaseResult() {
        this(null, null, 0, null, null, 0, null, null, 255, null);
    }

    public BaseResult(Long r1, Long r2, int r3, String r4, File r5, int r6, String r7, ConcurrentHashMap<String, String> r8) {
        this.questionId = r1;
        this.replyId = r2;
        this.ret = r3;
        this.details = r4;
        this.file = r5;
        this.uiType = r6;
        this.replyFor = r7;
        this.ext = r8;
    }

    public /* synthetic */ BaseResult(Long r3, Long r4, int r5, String r6, File r7, int r8, String r9, ConcurrentHashMap r10, int r11, d.h.b.h r12) {
        if ((r11 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r5 = 1;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r8 = 1;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r9 = "";
    L24:
        if ((r11 & 128) == 0) goto L26;
        r10 = null;
    L26:
        this(r3, r4, r5, r6, r7, r8, r9, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseResult copy$default(BaseResult r9, Long r10, Long r11, int r12, String r13, File r14, int r15, String r16, ConcurrentHashMap r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        Long r2 = r9.questionId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Long r3 = r9.replyId;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r4 = r9.ret;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.details;
    L19:
        if ((r18 & 16) == 0) goto L21;
        File r6 = r9.file;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.uiType;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.replyFor;
    L31:
        if ((r18 & 128) == 0) goto L33;
        ConcurrentHashMap r1 = r9.ext;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final Long component1() {
        return this.questionId;
    }

    public final Long component2() {
        return this.replyId;
    }

    public final int component3() {
        return this.ret;
    }

    public final String component4() {
        return this.details;
    }

    public final File component5() {
        return this.file;
    }

    public final int component6() {
        return this.uiType;
    }

    public final String component7() {
        return this.replyFor;
    }

    public final ConcurrentHashMap<String, String> component8() {
        return this.ext;
    }

    public final BaseResult copy(Long r11, Long r12, int r13, String r14, File r15, int r16, String r17, ConcurrentHashMap<String, String> r18) {
        return new BaseResult(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BaseResult.class) == true) goto L8;
        return false;
    L8:
        BaseResult r6 = (BaseResult) ZeusTransformUtils.preCheckCast(r5, BaseResult.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.questionId, r6.questionId) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.replyId, r6.replyId) == true) goto L15;
        return false;
    L15:
        if (this.ret == r6.ret) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.details, r6.details) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.file, r6.file) == true) goto L24;
        return false;
    L24:
        if (this.uiType == r6.uiType) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.replyFor, r6.replyFor) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.ext, r6.ext) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getDetails() {
        return this.details;
    }

    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    public final File getFile() {
        return this.file;
    }

    public final Long getQuestionId() {
        return this.questionId;
    }

    public final String getReplyFor() {
        return this.replyFor;
    }

    public final Long getReplyId() {
        return this.replyId;
    }

    public final int getRet() {
        return this.ret;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public int hashCode() {
        Long r0 = this.questionId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.replyId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + Integer.hashCode(this.ret)) * 31;
        String r7 = this.details;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        File r10 = this.file;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + Integer.hashCode(this.uiType)) * 31;
        String r13 = this.replyFor;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        ConcurrentHashMap<String, String> r16 = this.ext;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
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

    public final void setDetails(String r1) {
        this.details = r1;
    }

    public final void setExt(ConcurrentHashMap<String, String> r1) {
        this.ext = r1;
    }

    public final void setFile(File r1) {
        this.file = r1;
    }

    public final void setQuestionId(Long r1) {
        this.questionId = r1;
    }

    public final void setReplyFor(String r1) {
        this.replyFor = r1;
    }

    public final void setReplyId(Long r1) {
        this.replyId = r1;
    }

    public final void setRet(int r1) {
        this.ret = r1;
    }

    public final void setUiType(int r1) {
        this.uiType = r1;
    }

    public String toString() {
        return "BaseResult(questionId=" + this.questionId + ", replyId=" + this.replyId + ", ret=" + this.ret + ", details=" + this.details + ", file=" + this.file + ", uiType=" + this.uiType + ", replyFor=" + this.replyFor + ", ext=" + this.ext + ')';
    }
}
