package com.obric.capabilitykit.common;

import androidx.annotation.Keep;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedanceos.common.model.AppInfo;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0017\u00102\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eHÆ\u0003Jv\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0006HÖ\u0001J\t\u00109\u001a\u00020\bHÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(¨\u0006:"}, d2 = {"Lcom/obric/capabilitykit/common/BaseResult;", "", "questionId", "", "replyId", SlardarConfigConsts.CONFIG_RET, "", "details", "", "file", "Ljava/io/File;", "uiType", "replyFor", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "(Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/io/File;ILjava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;)V", "getDetails", "()Ljava/lang/String;", "setDetails", "(Ljava/lang/String;)V", "getExt", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExt", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "getQuestionId", "()Ljava/lang/Long;", "setQuestionId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getReplyFor", "setReplyFor", "getReplyId", "setReplyId", "getRet", "()I", "setRet", "(I)V", "getUiType", "setUiType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/io/File;ILjava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;)Lcom/obric/capabilitykit/common/BaseResult;", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BaseResult {

    @Nullable
    private String details;

    @Nullable
    private ConcurrentHashMap<String, String> ext;

    @Nullable
    private File file;

    @Nullable
    private Long questionId;

    @Nullable
    private String replyFor;

    @Nullable
    private Long replyId;
    private int ret;
    private int uiType;

    public BaseResult() {
        Long r10 = null;
        Long r11 = null;
        int r12 = 0;
        String r13 = null;
        File r14 = null;
        int r15 = 0;
        String r16 = null;
        ConcurrentHashMap r17 = null;
        this(r10, r11, r12, r13, r14, r15, r16, r17, PrivateKeyType.INVALID, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseResult copy$default(BaseResult r10, Long r11, Long r12, int r13, String r14, File r15, int r16, String r17, ConcurrentHashMap r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        Long r20 = r10.questionId;
    L7:
        if ((r19 & 2) == 0) goto L9;
        Long r21 = r10.replyId;
    L11:
        if ((r19 & 4) == 0) goto L13;
        int r22 = r10.ret;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r23 = r10.details;
    L19:
        if ((r19 & 16) == 0) goto L21;
        File r24 = r10.file;
    L23:
        if ((r19 & 32) == 0) goto L25;
        int r25 = r10.uiType;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r26 = r10.replyFor;
    L31:
        if ((r19 & 128) == 0) goto L33;
        ConcurrentHashMap r27 = r10.ext;
    L35:
        return r10.copy(r20, r21, r22, r23, r24, r25, r26, r27);
    L33:
        r27 = r18;
        goto L35
    L29:
        r26 = r17;
        goto L31
    L25:
        r25 = r16;
        goto L27
    L21:
        r24 = r15;
        goto L23
    L17:
        r23 = r14;
        goto L19
    L13:
        r22 = r13;
        goto L15
    L9:
        r21 = r12;
        goto L11
    L5:
        r20 = r11;
        goto L7
    }

    @Nullable
    public final Long component1() {
        return this.questionId;
    }

    @Nullable
    public final Long component2() {
        return this.replyId;
    }

    public final int component3() {
        return this.ret;
    }

    @Nullable
    public final String component4() {
        return this.details;
    }

    @Nullable
    public final File component5() {
        return this.file;
    }

    public final int component6() {
        return this.uiType;
    }

    @Nullable
    public final String component7() {
        return this.replyFor;
    }

    @Nullable
    public final ConcurrentHashMap<String, String> component8() {
        return this.ext;
    }

    @NotNull
    public final BaseResult copy(@Nullable Long r11, @Nullable Long r12, int r13, @Nullable String r14, @Nullable File r15, int r16, @Nullable String r17, @Nullable ConcurrentHashMap<String, String> r18) {
        return new BaseResult(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof BaseResult) == true) goto L8;
        return false;
    L8:
        BaseResult r11 = (BaseResult) r10;
        if (kotlin.jvm.internal.q.b(this.questionId, r11.questionId) == true) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.replyId, r11.replyId) == true) goto L15;
        return false;
    L15:
        if (this.ret == r11.ret) goto L18;
        return false;
    L18:
        if (kotlin.jvm.internal.q.b(this.details, r11.details) == true) goto L21;
        return false;
    L21:
        if (kotlin.jvm.internal.q.b(this.file, r11.file) == true) goto L24;
        return false;
    L24:
        if (this.uiType == r11.uiType) goto L27;
        return false;
    L27:
        if (kotlin.jvm.internal.q.b(this.replyFor, r11.replyFor) == true) goto L30;
        return false;
    L30:
        if (kotlin.jvm.internal.q.b(this.ext, r11.ext) == true) goto L32;
        return false;
    L32:
        return true;
    }

    @Nullable
    public final String getDetails() {
        return this.details;
    }

    @Nullable
    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    @Nullable
    public final File getFile() {
        return this.file;
    }

    @Nullable
    public final Long getQuestionId() {
        return this.questionId;
    }

    @Nullable
    public final String getReplyFor() {
        return this.replyFor;
    }

    @Nullable
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
        Long r10 = this.questionId;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Long r14 = this.replyId;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (((r13 + r15) * 31) + Integer.hashCode(this.ret)) * 31;
        String r17 = this.details;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        File r20 = this.file;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (((r19 + r21) * 31) + Integer.hashCode(this.uiType)) * 31;
        String r23 = this.replyFor;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        ConcurrentHashMap<String, String> r26 = this.ext;
        if (r26 == null) goto L27;
        r11 = r26.hashCode();
    L27:
        return r25 + r11;
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setDetails(@Nullable String r10) {
        this.details = r10;
    }

    public final void setExt(@Nullable ConcurrentHashMap<String, String> r10) {
        this.ext = r10;
    }

    public final void setFile(@Nullable File r10) {
        this.file = r10;
    }

    public final void setQuestionId(@Nullable Long r10) {
        this.questionId = r10;
    }

    public final void setReplyFor(@Nullable String r10) {
        this.replyFor = r10;
    }

    public final void setReplyId(@Nullable Long r10) {
        this.replyId = r10;
    }

    public final void setRet(int r10) {
        this.ret = r10;
    }

    public final void setUiType(int r10) {
        this.uiType = r10;
    }

    @NotNull
    public String toString() {
        return "BaseResult(questionId=" + this.questionId + ", replyId=" + this.replyId + ", ret=" + this.ret + ", details=" + this.details + ", file=" + this.file + ", uiType=" + this.uiType + ", replyFor=" + this.replyFor + ", ext=" + this.ext + ')';
    }

    public BaseResult(@Nullable Long r10, @Nullable Long r11, int r12, @Nullable String r13, @Nullable File r14, int r15, @Nullable String r16, @Nullable ConcurrentHashMap<String, String> r17) {
        this.questionId = r10;
        this.replyId = r11;
        this.ret = r12;
        this.details = r13;
        this.file = r14;
        this.uiType = r15;
        this.replyFor = r16;
        this.ext = r17;
    }

    public /* synthetic */ BaseResult(Long r10, Long r11, int r12, String r13, File r14, int r15, String r16, ConcurrentHashMap r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r18 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r18 & 4) == 0) goto L12;
        r12 = 1;
    L12:
        if ((r18 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r18 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r18 & 32) == 0) goto L21;
        r15 = 1;
    L21:
        if ((r18 & 64) == 0) goto L24;
        r16 = "";
    L24:
        if ((r18 & 128) == 0) goto L26;
        r17 = null;
    L26:
        this(r10, r11, r12, r13, r14, r15, r16, r17);
    }
}
