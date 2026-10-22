package com.bytedance.ai.event;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jg\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006&"}, d2 = {"Lcom/bytedance/ai/event/MessageIndication;", "", "isSend", "", RemoteMessageConst.MSGID, "", "localId", "replyId", "contentType", "messageType", "status", "content", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getMsgId", "()Ljava/lang/String;", "getLocalId", "getReplyId", "getContentType", "getMessageType", "getStatus", "getContent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageIndication {
    public static final String CONTENT_TYPE_TEXT = "text";
    public static final a Companion = null;
    public static final String EVENT_NAME = "msg_indication";
    public static final String MESSAGE_TYPE_LOADING = "loading";
    public static final String MESSAGE_TYPE_MSG = "msg";
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_INTERRUPT = "interrupt";
    public static final String STATUS_PREPARE = "prepare";
    public static final String STATUS_RECEIVED = "received";
    public static final String STATUS_RECEIVE_FAILED = "receive_failed";
    public static final String STATUS_RECEIVING = "receiving";
    public static final String STATUS_SENDING = "sending";
    public static final String STATUS_SUCCESS = "success";

    @SerializedName("content")
    private final String content;

    @SerializedName("contentType")
    private final String contentType;

    @SerializedName("isSend")
    private final boolean isSend;

    @SerializedName("localId")
    private final String localId;

    @SerializedName("messageType")
    private final String messageType;

    @SerializedName(RemoteMessageConst.MSGID)
    private final String msgId;

    @SerializedName("replyId")
    private final String replyId;

    @SerializedName("status")
    private final String status;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MessageIndication() {
        this(false, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ MessageIndication copy$default(MessageIndication r100, boolean r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = r100.isSend;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.msgId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.localId;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.replyId;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.contentType;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.messageType;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.status;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.content;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final boolean component1() {
        return this.isSend;
    }

    public final String component2() {
        return this.msgId;
    }

    public final String component3() {
        return this.localId;
    }

    public final String component4() {
        return this.replyId;
    }

    public final String component5() {
        return this.contentType;
    }

    public final String component6() {
        return this.messageType;
    }

    public final String component7() {
        return this.status;
    }

    public final String component8() {
        return this.content;
    }

    public final MessageIndication copy(boolean r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117) {
        return new MessageIndication(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageIndication) == true) goto L8;
        return false;
    L8:
        MessageIndication r101 = (MessageIndication) r100;
        if (this.isSend == r101.isSend) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msgId, r101.msgId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.localId, r101.localId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.contentType, r101.contentType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageType, r101.messageType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        if (this.isSend == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.msgId;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.localId;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.replyId;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.contentType;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.messageType;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.status;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.content;
        if (r121 == null) goto L35;
        r103 = r121.hashCode();
    L35:
        return r120 + r103;
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "MessageIndication(isSend=" + this.isSend + ", msgId=" + this.msgId + ", localId=" + this.localId + ", replyId=" + this.replyId + ", contentType=" + this.contentType + ", messageType=" + this.messageType + ", status=" + this.status + ", content=" + this.content + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getLocalId() {
        return this.localId;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getStatus() {
        return this.status;
    }

    public final boolean isSend() {
        return this.isSend;
    }

    public MessageIndication(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        this.isSend = r100;
        this.msgId = r101;
        this.localId = r102;
        this.replyId = r103;
        this.contentType = r104;
        this.messageType = r105;
        this.status = r106;
        this.content = r107;
    }

    public /* synthetic */ MessageIndication(boolean r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r100 = false;
    L6:
        String r101 = "";
        if ((r118 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r118 & 128) != 0) goto L34;
        r101 = r117;
    L34:
        this(r100, r102, r103, r104, r105, r106, r107, r101);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
