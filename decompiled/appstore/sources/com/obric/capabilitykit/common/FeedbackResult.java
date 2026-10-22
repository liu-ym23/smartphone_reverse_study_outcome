package com.obric.capabilitykit.common;

import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/common/FeedbackResult;", "", ServerElements.CODE, "", "msg", "", "data", "uiType", "replyFor", "shouldNotify", "", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "getCode", "()I", "getData", "()Ljava/lang/String;", "getMsg", "getReplyFor", "getShouldNotify", "()Z", "getUiType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FeedbackResult {

    @SerializedName(ServerElements.CODE)
    private final int code;

    @SerializedName("data")
    @Nullable
    private final String data;

    @SerializedName("msg")
    @Nullable
    private final String msg;

    @SerializedName("replyFor")
    @Nullable
    private final String replyFor;

    @SerializedName("shouldNotify")
    private final boolean shouldNotify;

    @SerializedName("uiType")
    private final int uiType;

    public FeedbackResult() {
        int r10 = 0;
        String r11 = null;
        String r12 = null;
        int r13 = 0;
        String r14 = null;
        boolean r15 = false;
        this(r10, r11, r12, r13, r14, r15, 63, null);
    }

    public static /* synthetic */ FeedbackResult copy$default(FeedbackResult r10, int r11, String r12, String r13, int r14, String r15, boolean r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.code;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.msg;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.data;
    L11:
        String r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.uiType;
    L14:
        int r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.replyFor;
    L17:
        String r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.shouldNotify;
    L20:
        int r23 = r11;
        return r10.copy(r23, r19, r20, r21, r22, r16);
    }

    public final int component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.msg;
    }

    @Nullable
    public final String component3() {
        return this.data;
    }

    public final int component4() {
        return this.uiType;
    }

    @Nullable
    public final String component5() {
        return this.replyFor;
    }

    public final boolean component6() {
        return this.shouldNotify;
    }

    @NotNull
    public final FeedbackResult copy(int r10, @Nullable String r11, @Nullable String r12, int r13, @Nullable String r14, boolean r15) {
        return new FeedbackResult(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof FeedbackResult) == true) goto L8;
        return false;
    L8:
        FeedbackResult r11 = (FeedbackResult) r10;
        if (this.code == r11.code) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.msg, r11.msg) == true) goto L15;
        return false;
    L15:
        if (kotlin.jvm.internal.q.b(this.data, r11.data) == true) goto L18;
        return false;
    L18:
        if (this.uiType == r11.uiType) goto L21;
        return false;
    L21:
        if (kotlin.jvm.internal.q.b(this.replyFor, r11.replyFor) == true) goto L24;
        return false;
    L24:
        if (this.shouldNotify == r11.shouldNotify) goto L26;
        return false;
    L26:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final String getReplyFor() {
        return this.replyFor;
    }

    public final boolean getShouldNotify() {
        return this.shouldNotify;
    }

    public final int getUiType() {
        return this.uiType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r10 = Integer.hashCode(this.code) * 31;
        String r11 = this.msg;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        String r15 = this.data;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (((r14 + r16) * 31) + Integer.hashCode(this.uiType)) * 31;
        String r18 = this.replyFor;
        if (r18 == null) goto L14;
        r12 = r18.hashCode();
    L14:
        int r19 = (r17 + r12) * 31;
        boolean r20 = this.shouldNotify;
        ?? r21 = r20;
        if (r20 == false) goto L18;
        r21 = 1;
    L18:
        return r19 + r21;
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "FeedbackResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", uiType=" + this.uiType + ", replyFor=" + this.replyFor + ", shouldNotify=" + this.shouldNotify + ')';
    }

    public FeedbackResult(int r10, @Nullable String r11, @Nullable String r12, int r13, @Nullable String r14, boolean r15) {
        this.code = r10;
        this.msg = r11;
        this.data = r12;
        this.uiType = r13;
        this.replyFor = r14;
        this.shouldNotify = r15;
    }

    public /* synthetic */ FeedbackResult(int r10, String r11, String r12, int r13, String r14, boolean r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r16 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r16 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r16 & 8) == 0) goto L15;
        r13 = 0;
    L15:
        if ((r16 & 16) == 0) goto L18;
        r14 = "";
    L18:
        if ((r16 & 32) == 0) goto L20;
        r15 = true;
    L20:
        this(r10, r11, r12, r13, r14, r15);
    }
}
