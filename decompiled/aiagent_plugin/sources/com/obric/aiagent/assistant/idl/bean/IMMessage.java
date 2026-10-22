package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IMMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IMMessage implements Parcelable {
    public static final Parcelable.Creator<IMMessage> CREATOR = null;

    @SerializedName("biz_content_type")
    private final String bizContentType;

    @SerializedName("business_ext")
    private final Map<String, String> businessExt;

    @SerializedName("content")
    private final String content;

    @SerializedName("content_block")
    private final List<Block> contentBlock;

    @SerializedName(MonitorConstants.EXTRA_CONTENT_TYPE)
    private final int contentType;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("create_time")
    private final long createTime;

    @SerializedName("ext")
    private final Map<String, String> ext;

    @SerializedName("is_new_block_type")
    private final boolean isNewBlockType;

    @SerializedName("local_index")
    private final long localIndex;

    @SerializedName("local_message_id")
    private final String localMessageId;

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName("message_status")
    private final int messageStatus;

    @SerializedName("message_status_local")
    private final int messageStatusLocal;

    @SerializedName("reply_id")
    private final String replyId;

    @SerializedName("section_id")
    private final String sectionId;

    @SerializedName("sender_id")
    private final String senderId;

    @SerializedName("server_index")
    private final long serverIndex;

    @SerializedName("user_type")
    private final int userType;

    /* JADX INFO: compiled from: IMMessage.kt */
    public static final class Creator implements Parcelable.Creator<IMMessage> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IMMessage createFromParcel(Parcel r28) {
            o.e(r28, "parcel");
            String r3 = r28.readString();
            String r4 = r28.readString();
            int r5 = r28.readInt();
            int r6 = r28.readInt();
            int r7 = r28.readInt();
            int r8 = r28.readInt();
            if (r28.readInt() == 0) goto L5;
            boolean r9 = true;
        L6:
            String r10 = r28.readString();
            LinkedHashMap r11 = null;
            if (r28.readInt() != 0) goto L9;
            ArrayList r12 = null;
        L12:
            List r0 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
            if (r28.readInt() == 0) goto L19;
            int r13 = r28.readInt();
            LinkedHashMap r14 = new LinkedHashMap(r13);
            int r15 = 0;
        L16:
            if (r15 == r13) goto L18;
            r14.put(r28.readString(), r28.readString());
            r15 = r15 + 1;
            goto L16
        L18:
            r11 = r14;
        L19:
            Map r16 = (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.aiagent.plugin");
            String r17 = r28.readString();
            String r18 = r28.readString();
            long r19 = r28.readLong();
            long r110 = r28.readLong();
            String r25 = r28.readString();
            int r2 = r28.readInt();
            LinkedHashMap r111 = new LinkedHashMap(r2);
            int r1 = 0;
        L20:
            if (r1 == r2) goto L23;
            r111.put(r28.readString(), r28.readString());
            r1 = r1 + 1;
            r2 = r2;
            r18 = r18;
            goto L20
        L23:
            return new IMMessage(r3, r4, r5, r6, r7, r8, r9, r10, r0, r16, r17, r18, r19, r110, r25, (Map) ZeusTransformUtils.preCheckCast(r111, Map.class, "com.obric.aiagent.plugin"), r28.readString(), r28.readString(), r28.readLong());
        L9:
            int r20 = r28.readInt();
            r12 = new ArrayList(r20);
            int r112 = 0;
        L10:
            if (r112 == r20) goto L12;
            r12.add(r28.readSerializable());
            r112 = r112 + 1;
            goto L10
        L5:
            r9 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IMMessage createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IMMessage[] newArray(int r1) {
            return new IMMessage[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IMMessage[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public IMMessage() {
        this(null, null, 0, 0, 0, 0, false, null, null, null, null, null, 0, 0, null, null, null, null, 0, 524287, null);
    }

    public static /* synthetic */ IMMessage copy$default(IMMessage r17, String r18, String r19, int r20, int r21, int r22, int r23, boolean r24, String r25, List r26, Map r27, String r28, String r29, long r30, long r32, String r34, Map r35, String r36, String r37, long r38, int r40, Object r41) {
        List<Block> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r27, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r35, Map.class, "com.obric.aiagent.plugin");
        if ((r40 & 1) == 0) goto L5;
        String r5 = r17.conversationId;
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r6 = r17.senderId;
    L11:
        if ((r40 & 4) == 0) goto L13;
        int r7 = r17.userType;
    L15:
        if ((r40 & 8) == 0) goto L17;
        int r8 = r17.messageStatusLocal;
    L19:
        if ((r40 & 16) == 0) goto L21;
        int r9 = r17.messageStatus;
    L23:
        if ((r40 & 32) == 0) goto L25;
        int r10 = r17.contentType;
    L27:
        if ((r40 & 64) == 0) goto L29;
        boolean r11 = r17.isNewBlockType;
    L31:
        if ((r40 & 128) == 0) goto L33;
        String r12 = r17.content;
    L35:
        if ((r40 & 256) == 0) goto L38;
        r2 = r17.contentBlock;
    L38:
        if ((r40 & 512) == 0) goto L41;
        r4 = r17.ext;
    L41:
        if ((r40 & 1024) == 0) goto L43;
        String r13 = r17.localMessageId;
    L45:
        if ((r40 & 2048) == 0) goto L47;
        String r14 = r17.messageId;
    L48:
        String r210 = r14;
        if ((r40 & 4096) == 0) goto L51;
        long r15 = r17.localIndex;
    L52:
        long r31 = r15;
        if ((r40 & 8192) == 0) goto L55;
        long r16 = r17.serverIndex;
    L57:
        if ((r40 & 16384) == 0) goto L59;
        String r33 = r17.sectionId;
    L60:
        String r39 = r33;
        if ((r40 & 32768) == 0) goto L63;
        Map<String, String> r42 = r17.businessExt;
    L64:
        Map<String, String> r310 = r42;
        if ((r40 & 65536) == 0) goto L67;
        String r43 = r17.replyId;
    L68:
        String r311 = r43;
        if ((r40 & UiType.FLAG_PHONE_CARD) == 0) goto L71;
        String r44 = r17.bizContentType;
    L72:
        long r312 = r16;
        if ((r40 & 262144) == 0) goto L75;
        long r110 = r17.createTime;
    L77:
        return r17.copy(r5, r6, r7, r8, r9, r10, r11, r12, r2, r4, r13, r210, r31, r312, r39, r310, r311, r44, r110);
    L75:
        r110 = r38;
        goto L77
    L71:
        r44 = r37;
        goto L72
    L67:
        r43 = r36;
        goto L68
    L63:
        r42 = r3;
        goto L64
    L59:
        r33 = r34;
        goto L60
    L55:
        r16 = r32;
        goto L57
    L51:
        r15 = r30;
        goto L52
    L47:
        r14 = r29;
        goto L48
    L43:
        r13 = r28;
        goto L45
    L33:
        r12 = r25;
        goto L35
    L29:
        r11 = r24;
        goto L31
    L25:
        r10 = r23;
        goto L27
    L21:
        r9 = r22;
        goto L23
    L17:
        r8 = r21;
        goto L19
    L13:
        r7 = r20;
        goto L15
    L9:
        r6 = r19;
        goto L11
    L5:
        r5 = r18;
        goto L7
    }

    public final String component1() {
        return this.conversationId;
    }

    public final Map<String, String> component10() {
        return this.ext;
    }

    public final String component11() {
        return this.localMessageId;
    }

    public final String component12() {
        return this.messageId;
    }

    public final long component13() {
        return this.localIndex;
    }

    public final long component14() {
        return this.serverIndex;
    }

    public final String component15() {
        return this.sectionId;
    }

    public final Map<String, String> component16() {
        return this.businessExt;
    }

    public final String component17() {
        return this.replyId;
    }

    public final String component18() {
        return this.bizContentType;
    }

    public final long component19() {
        return this.createTime;
    }

    public final String component2() {
        return this.senderId;
    }

    public final int component3() {
        return this.userType;
    }

    public final int component4() {
        return this.messageStatusLocal;
    }

    public final int component5() {
        return this.messageStatus;
    }

    public final int component6() {
        return this.contentType;
    }

    public final boolean component7() {
        return this.isNewBlockType;
    }

    public final String component8() {
        return this.content;
    }

    public final List<Block> component9() {
        return this.contentBlock;
    }

    public final IMMessage copy(String r26, String r27, int r28, int r29, int r30, int r31, boolean r32, String r33, List<Block> r34, Map<String, String> r35, String r36, String r37, long r38, long r40, String r42, Map<String, String> r43, String r44, String r45, long r46) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.aiagent.plugin");
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r35, Map.class, "com.obric.aiagent.plugin");
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r43, Map.class, "com.obric.aiagent.plugin");
        o.e(r26, "conversationId");
        o.e(r27, "senderId");
        o.e(r36, "localMessageId");
        o.e(r37, "messageId");
        o.e(r1, "businessExt");
        return new IMMessage(r26, r27, r28, r29, r30, r31, r32, r33, r9, r0, r36, r37, r38, r40, r42, r1, r44, r45, r46);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, IMMessage.class) == true) goto L8;
        return false;
    L8:
        IMMessage r10 = (IMMessage) ZeusTransformUtils.preCheckCast(r9, IMMessage.class, "com.obric.aiagent.plugin");
        if (o.a(this.conversationId, r10.conversationId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.senderId, r10.senderId) == true) goto L15;
        return false;
    L15:
        if (this.userType == r10.userType) goto L18;
        return false;
    L18:
        if (this.messageStatusLocal == r10.messageStatusLocal) goto L21;
        return false;
    L21:
        if (this.messageStatus == r10.messageStatus) goto L24;
        return false;
    L24:
        if (this.contentType == r10.contentType) goto L27;
        return false;
    L27:
        if (this.isNewBlockType == r10.isNewBlockType) goto L30;
        return false;
    L30:
        if (o.a(this.content, r10.content) == true) goto L33;
        return false;
    L33:
        if (o.a(this.contentBlock, r10.contentBlock) == true) goto L36;
        return false;
    L36:
        if (o.a(this.ext, r10.ext) == true) goto L39;
        return false;
    L39:
        if (o.a(this.localMessageId, r10.localMessageId) == true) goto L42;
        return false;
    L42:
        if (o.a(this.messageId, r10.messageId) == true) goto L45;
        return false;
    L45:
        if (this.localIndex == r10.localIndex) goto L48;
        return false;
    L48:
        if (this.serverIndex == r10.serverIndex) goto L51;
        return false;
    L51:
        if (o.a(this.sectionId, r10.sectionId) == true) goto L54;
        return false;
    L54:
        if (o.a(this.businessExt, r10.businessExt) == true) goto L57;
        return false;
    L57:
        if (o.a(this.replyId, r10.replyId) == true) goto L60;
        return false;
    L60:
        if (o.a(this.bizContentType, r10.bizContentType) == true) goto L63;
        return false;
    L63:
        if (this.createTime == r10.createTime) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((this.conversationId.hashCode() * 31) + this.senderId.hashCode()) * 31) + Integer.hashCode(this.userType)) * 31) + Integer.hashCode(this.messageStatusLocal)) * 31) + Integer.hashCode(this.messageStatus)) * 31) + Integer.hashCode(this.contentType)) * 31) + Boolean.hashCode(this.isNewBlockType)) * 31;
        String r1 = this.content;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<Block> r5 = this.contentBlock;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, String> r8 = this.ext;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((((((r7 + r9) * 31) + this.localMessageId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + Long.hashCode(this.localIndex)) * 31) + Long.hashCode(this.serverIndex)) * 31;
        String r11 = this.sectionId;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + this.businessExt.hashCode()) * 31;
        String r14 = this.replyId;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.bizContentType;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return ((r16 + r2) * 31) + Long.hashCode(this.createTime);
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("IMMessage(conversationId=").append(this.conversationId).append(", senderId=").append(this.senderId).append(", userType=").append(this.userType).append(", messageStatusLocal=").append(this.messageStatusLocal).append(", messageStatus=").append(this.messageStatus).append(", contentType=").append(this.contentType).append(", isNewBlockType=").append(this.isNewBlockType).append(", content=").append(this.content).append(", contentBlock=").append(this.contentBlock).append(", ext=").append(this.ext).append(", localMessageId=").append(this.localMessageId).append(", messageId=");
        r0.append(this.messageId).append(", localIndex=").append(this.localIndex).append(", serverIndex=").append(this.serverIndex).append(", sectionId=").append(this.sectionId).append(", businessExt=").append(this.businessExt).append(", replyId=").append(this.replyId).append(", bizContentType=").append(this.bizContentType).append(", createTime=").append(this.createTime).append(')');
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        o.e(r6, "dest");
        r6.writeString(this.conversationId);
        r6.writeString(this.senderId);
        r6.writeInt(this.userType);
        r6.writeInt(this.messageStatusLocal);
        r6.writeInt(this.messageStatus);
        r6.writeInt(this.contentType);
        r6.writeInt(this.isNewBlockType ? 1 : 0);
        r6.writeString(this.content);
        List<Block> r8 = this.contentBlock;
        if (r8 != null) goto L5;
        r6.writeInt(0);
    L9:
        Map<String, String> r9 = this.ext;
        if (r9 != null) goto L12;
        r6.writeInt(0);
    L16:
        r6.writeString(this.localMessageId);
        r6.writeString(this.messageId);
        r6.writeLong(this.localIndex);
        r6.writeLong(this.serverIndex);
        r6.writeString(this.sectionId);
        Map<String, String> r10 = this.businessExt;
        r6.writeInt(r10.size());
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        Map.Entry<String, String> r0 = r11.next();
        r6.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        r6.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L18
    L20:
        r6.writeString(this.replyId);
        r6.writeString(this.bizContentType);
        r6.writeLong(this.createTime);
        return;
    L12:
        r6.writeInt(1);
        r6.writeInt(r9.size());
        Iterator<Map.Entry<String, String>> r12 = r9.entrySet().iterator();
    L14:
        if (r12.hasNext() == false) goto L16;
        Map.Entry<String, String> r1 = r12.next();
        r6.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        r6.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L14
    L5:
        r6.writeInt(1);
        r6.writeInt(r8.size());
        Iterator<Block> r13 = r8.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        r6.writeSerializable((Serializable) ZeusTransformUtils.preCheckCast(r13.next(), Serializable.class, "com.obric.aiagent.plugin"));
        goto L7
    }

    public IMMessage(String r11, String r12, int r13, int r14, int r15, int r16, boolean r17, String r18, List<Block> r19, Map<String, String> r20, String r21, String r22, long r23, long r25, String r27, Map<String, String> r28, String r29, String r30, long r31) {
        List<Block> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.aiagent.plugin");
        o.e(r11, "conversationId");
        o.e(r12, "senderId");
        o.e(r21, "localMessageId");
        o.e(r22, "messageId");
        o.e(r6, "businessExt");
        this.conversationId = r11;
        this.senderId = r12;
        this.userType = r13;
        this.messageStatusLocal = r14;
        this.messageStatus = r15;
        this.contentType = r16;
        this.isNewBlockType = r17;
        this.content = r18;
        this.contentBlock = r5;
        this.ext = r7;
        this.localMessageId = r21;
        this.messageId = r22;
        this.localIndex = r23;
        this.serverIndex = r25;
        this.sectionId = r27;
        this.businessExt = r6;
        this.replyId = r29;
        this.bizContentType = r30;
        this.createTime = r31;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final int getMessageStatusLocal() {
        return this.messageStatusLocal;
    }

    public final int getMessageStatus() {
        return this.messageStatus;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final boolean isNewBlockType() {
        return this.isNewBlockType;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<Block> getContentBlock() {
        return this.contentBlock;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final long getLocalIndex() {
        return this.localIndex;
    }

    public final long getServerIndex() {
        return this.serverIndex;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final Map<String, String> getBusinessExt() {
        return this.businessExt;
    }

    public /* synthetic */ IMMessage(String r23, String r24, int r25, int r26, int r27, int r28, boolean r29, String r30, List r31, Map r32, String r33, String r34, long r35, long r37, String r39, Map r40, String r41, String r42, long r43, int r45, h r46) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r40, Map.class, "com.obric.aiagent.plugin");
        String r6 = "";
        if ((r45 & 1) == 0) goto L5;
        String r5 = "";
    L7:
        if ((r45 & 2) == 0) goto L9;
        String r7 = "";
    L10:
        int r9 = -1;
        if ((r45 & 4) == 0) goto L13;
        int r8 = -1;
    L15:
        if ((r45 & 8) == 0) goto L17;
        int r10 = -1;
    L19:
        if ((r45 & 16) == 0) goto L21;
        int r11 = -1;
    L23:
        if ((r45 & 32) != 0) goto L27;
        r9 = r28;
    L27:
        if ((r45 & 64) == 0) goto L29;
        boolean r12 = false;
    L31:
        if ((r45 & 128) == 0) goto L33;
        String r13 = null;
    L35:
        if ((r45 & 256) == 0) goto L38;
        r1 = null;
    L38:
        if ((r45 & 512) == 0) goto L41;
        r3 = null;
    L41:
        if ((r45 & 1024) == 0) goto L43;
        String r15 = "";
    L45:
        if ((r45 & 2048) != 0) goto L48;
        r6 = r34;
    L48:
        long r16 = -1;
        if ((r45 & 4096) == 0) goto L51;
        long r18 = -1;
    L53:
        if ((r45 & 8192) != 0) goto L57;
        r16 = r37;
    L57:
        if ((r45 & 16384) == 0) goto L59;
        String r14 = null;
    L61:
        if ((r45 & 32768) == 0) goto L65;
        r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    L65:
        if ((65536 & r45) == 0) goto L67;
        String r2 = null;
    L69:
        if ((131072 & r45) == 0) goto L71;
        String r17 = null;
    L73:
        if ((r45 & 262144) == 0) goto L75;
        long r20 = 0;
    L76:
        this(r5, r7, r8, r10, r11, r9, r12, r13, r1, r3, r15, r6, r18, r16, r14, r4, r2, r17, r20);
        return;
    L75:
        r20 = r43;
        goto L76
    L71:
        r17 = r42;
        goto L73
    L67:
        r2 = r41;
        goto L69
    L59:
        r14 = r39;
        goto L61
    L51:
        r18 = r35;
        goto L53
    L43:
        r15 = r33;
        goto L45
    L33:
        r13 = r30;
        goto L35
    L29:
        r12 = r29;
        goto L31
    L21:
        r11 = r27;
        goto L23
    L17:
        r10 = r26;
        goto L19
    L13:
        r8 = r25;
        goto L15
    L9:
        r7 = r24;
        goto L10
    L5:
        r5 = r23;
        goto L7
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getBizContentType() {
        return this.bizContentType;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final boolean isBlockType() {
        if (isOldBlockType() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.isNewBlockType == true) goto L8;
        return false;
    }

    public final boolean isOldBlockType() {
        if (this.contentType == 9999) goto L5;
    L7:
        return false;
    L5:
        if (this.isNewBlockType == true) goto L7;
        return true;
    }
}
