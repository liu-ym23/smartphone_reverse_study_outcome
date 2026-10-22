package com.uxsense.base.metadata;

import A9.d;
import B9.C0177d;
import B9.T;
import B9.d0;
import C7.c;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0002MLBk\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014By\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\bHÆ\u0003¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001bJ\u0010\u0010%\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b)\u0010\u001bJ|\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b,\u0010!J\u0010\u0010-\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00100\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101J'\u0010:\u001a\u0002072\u0006\u00102\u001a\u00020\u00002\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205H\u0001¢\u0006\u0004\b8\u00109R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010;\u001a\u0004\b<\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010;\u001a\u0004\b=\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010;\u001a\u0004\b>\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010?\u001a\u0004\b@\u0010\u001fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010A\u001a\u0004\bB\u0010!R\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\f\u0010C\u001a\u0004\bD\u0010#R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010;\u001a\u0004\bE\u0010\u001bR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010F\u001a\u0004\bG\u0010&R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010H\u001a\u0004\b\u0011\u0010(R \u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010;\u0012\u0004\bJ\u0010K\u001a\u0004\bI\u0010\u001b¨\u0006N"}, d2 = {"Lcom/uxsense/base/metadata/ChatMessage;", "", "", "messageId", "chatId", "senderId", "Lcom/uxsense/base/metadata/MessageType;", "type", "", "text", "", "Lcom/uxsense/base/metadata/Media;", "media", "sentAt", "Lcom/uxsense/base/metadata/MessageStatus;", "status", "", "isRead", "userId", AppAgent.CONSTRUCT, "(JJJLcom/uxsense/base/metadata/MessageType;Ljava/lang/String;Ljava/util/List;JLcom/uxsense/base/metadata/MessageStatus;ZJ)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IJJJLcom/uxsense/base/metadata/MessageType;Ljava/lang/String;Ljava/util/List;JLcom/uxsense/base/metadata/MessageStatus;ZJLB9/d0;)V", "component1", "()J", "component2", "component3", "component4", "()Lcom/uxsense/base/metadata/MessageType;", "component5", "()Ljava/lang/String;", "component6", "()Ljava/util/List;", "component7", "component8", "()Lcom/uxsense/base/metadata/MessageStatus;", "component9", "()Z", "component10", "copy", "(JJJLcom/uxsense/base/metadata/MessageType;Ljava/lang/String;Ljava/util/List;JLcom/uxsense/base/metadata/MessageStatus;ZJ)Lcom/uxsense/base/metadata/ChatMessage;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/metadata/ChatMessage;LA9/d;Lz9/g;)V", "write$Self", "J", "getMessageId", "getChatId", "getSenderId", "Lcom/uxsense/base/metadata/MessageType;", "getType", "Ljava/lang/String;", "getText", "Ljava/util/List;", "getMedia", "getSentAt", "Lcom/uxsense/base/metadata/MessageStatus;", "getStatus", "Z", "getUserId", "getUserId$annotations", "()V", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatMessage {
    private static final f[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long chatId;
    private final boolean isRead;
    private final List<Media> media;
    private final long messageId;
    private final long senderId;
    private final long sentAt;
    private final MessageStatus status;
    private final String text;
    private final MessageType type;
    private final long userId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/metadata/ChatMessage$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/ChatMessage;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return ChatMessage$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        $childSerializers = new f[]{null, null, null, kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(15)), null, kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(16)), null, kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(17)), null, null};
    }

    public /* synthetic */ ChatMessage(int i, long j5, long j6, long j10, MessageType messageType, String str, List list, long j11, MessageStatus messageStatus, boolean z10, long j12, d0 d0Var) {
        if (71 != (i & 71)) {
            T.g(ChatMessage$$serializer.INSTANCE.getDescriptor(), i, 71);
            throw null;
        }
        this.messageId = j5;
        this.chatId = j6;
        this.senderId = j10;
        if ((i & 8) == 0) {
            this.type = MessageType.TEXT;
        } else {
            this.type = messageType;
        }
        if ((i & 16) == 0) {
            this.text = "";
        } else {
            this.text = str;
        }
        if ((i & 32) == 0) {
            this.media = null;
        } else {
            this.media = list;
        }
        this.sentAt = j11;
        this.status = (i & 128) == 0 ? MessageStatus.SENT : messageStatus;
        this.isRead = (i & 256) == 0 ? false : z10;
        if ((i & 512) == 0) {
            this.userId = j10;
        } else {
            this.userId = j12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_() {
        return MessageType.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$0() {
        return new C0177d(Media$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$1() {
        return MessageStatus.INSTANCE.serializer();
    }

    public static /* synthetic */ ChatMessage copy$default(ChatMessage chatMessage, long j5, long j6, long j10, MessageType messageType, String str, List list, long j11, MessageStatus messageStatus, boolean z10, long j12, int i, Object obj) {
        long j13;
        long j14;
        long j15 = (i & 1) != 0 ? chatMessage.messageId : j5;
        long j16 = (i & 2) != 0 ? chatMessage.chatId : j6;
        long j17 = (i & 4) != 0 ? chatMessage.senderId : j10;
        MessageType messageType2 = (i & 8) != 0 ? chatMessage.type : messageType;
        String str2 = (i & 16) != 0 ? chatMessage.text : str;
        List list2 = (i & 32) != 0 ? chatMessage.media : list;
        long j18 = (i & 64) != 0 ? chatMessage.sentAt : j11;
        MessageStatus messageStatus2 = (i & 128) != 0 ? chatMessage.status : messageStatus;
        boolean z11 = (i & 256) != 0 ? chatMessage.isRead : z10;
        if ((i & 512) != 0) {
            j13 = chatMessage.userId;
            j14 = j15;
        } else {
            j13 = j12;
            j14 = j15;
        }
        return chatMessage.copy(j14, j16, j17, messageType2, str2, list2, j18, messageStatus2, z11, j13);
    }

    @c
    public static /* synthetic */ void getUserId$annotations() {
    }

    public static final /* synthetic */ void write$Self$uxsense_release(ChatMessage self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.messageId);
        output.encodeLongElement(serialDesc, 1, self.chatId);
        output.encodeLongElement(serialDesc, 2, self.senderId);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.type != MessageType.TEXT) {
            output.encodeSerializableElement(serialDesc, 3, (x9.f) fVarArr[3].getF4884a(), self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !k.b(self.text, "")) {
            output.encodeStringElement(serialDesc, 4, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.media != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (x9.f) fVarArr[5].getF4884a(), self.media);
        }
        output.encodeLongElement(serialDesc, 6, self.sentAt);
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.status != MessageStatus.SENT) {
            output.encodeSerializableElement(serialDesc, 7, (x9.f) fVarArr[7].getF4884a(), self.status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.isRead) {
            output.encodeBooleanElement(serialDesc, 8, self.isRead);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.userId == self.senderId) {
            return;
        }
        output.encodeLongElement(serialDesc, 9, self.userId);
    }

    /* renamed from: component1, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* renamed from: component10, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getChatId() {
        return this.chatId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSenderId() {
        return this.senderId;
    }

    /* renamed from: component4, reason: from getter */
    public final MessageType getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final List<Media> component6() {
        return this.media;
    }

    /* renamed from: component7, reason: from getter */
    public final long getSentAt() {
        return this.sentAt;
    }

    /* renamed from: component8, reason: from getter */
    public final MessageStatus getStatus() {
        return this.status;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsRead() {
        return this.isRead;
    }

    public final ChatMessage copy(long messageId, long chatId, long senderId, MessageType type, String text, List<Media> media, long sentAt, MessageStatus status, boolean isRead, long userId) {
        k.f(type, "type");
        k.f(text, "text");
        k.f(status, "status");
        return new ChatMessage(messageId, chatId, senderId, type, text, media, sentAt, status, isRead, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatMessage)) {
            return false;
        }
        ChatMessage chatMessage = (ChatMessage) other;
        return this.messageId == chatMessage.messageId && this.chatId == chatMessage.chatId && this.senderId == chatMessage.senderId && this.type == chatMessage.type && k.b(this.text, chatMessage.text) && k.b(this.media, chatMessage.media) && this.sentAt == chatMessage.sentAt && this.status == chatMessage.status && this.isRead == chatMessage.isRead && this.userId == chatMessage.userId;
    }

    public final long getChatId() {
        return this.chatId;
    }

    public final List<Media> getMedia() {
        return this.media;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final long getSenderId() {
        return this.senderId;
    }

    public final long getSentAt() {
        return this.sentAt;
    }

    public final MessageStatus getStatus() {
        return this.status;
    }

    public final String getText() {
        return this.text;
    }

    public final MessageType getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iC = B7.a.c((this.type.hashCode() + androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(Long.hashCode(this.messageId) * 31, 31, this.chatId), 31, this.senderId)) * 31, 31, this.text);
        List<Media> list = this.media;
        return Long.hashCode(this.userId) + androidx.appfunctions.metadata.a.d((this.status.hashCode() + androidx.appfunctions.metadata.a.c((iC + (list == null ? 0 : list.hashCode())) * 31, 31, this.sentAt)) * 31, 31, this.isRead);
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChatMessage(messageId=");
        sb.append(this.messageId);
        sb.append(", chatId=");
        sb.append(this.chatId);
        sb.append(", senderId=");
        sb.append(this.senderId);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", text=");
        sb.append(this.text);
        sb.append(", media=");
        sb.append(this.media);
        sb.append(", sentAt=");
        sb.append(this.sentAt);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", isRead=");
        sb.append(this.isRead);
        sb.append(", userId=");
        return B7.a.p(sb, this.userId, ')');
    }

    public ChatMessage(long j5, long j6, long j10, MessageType type, String text, List<Media> list, long j11, MessageStatus status, boolean z10, long j12) {
        k.f(type, "type");
        k.f(text, "text");
        k.f(status, "status");
        this.messageId = j5;
        this.chatId = j6;
        this.senderId = j10;
        this.type = type;
        this.text = text;
        this.media = list;
        this.sentAt = j11;
        this.status = status;
        this.isRead = z10;
        this.userId = j12;
    }

    public /* synthetic */ ChatMessage(long j5, long j6, long j10, MessageType messageType, String str, List list, long j11, MessageStatus messageStatus, boolean z10, long j12, int i, e eVar) {
        this(j5, j6, j10, (i & 8) != 0 ? MessageType.TEXT : messageType, (i & 16) != 0 ? "" : str, (i & 32) != 0 ? null : list, j11, (i & 128) != 0 ? MessageStatus.SENT : messageStatus, (i & 256) != 0 ? false : z10, (i & 512) != 0 ? j10 : j12);
    }
}
