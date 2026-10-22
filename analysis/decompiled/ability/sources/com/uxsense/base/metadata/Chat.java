package com.uxsense.base.metadata;

import A9.d;
import B9.C0177d;
import B9.L;
import B9.T;
import B9.d0;
import B9.h0;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0002JIB\u0085\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\u0004\b\u0013\u0010\u0014B\u0091\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0013\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001dJ\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001aJ\u0010\u0010!\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b%\u0010$J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fHÆ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u001aJ\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fHÆ\u0003¢\u0006\u0004\b)\u0010'J\u0094\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fHÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b,\u0010\u001dJ\u0010\u0010-\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b-\u0010\"J\u001a\u0010/\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100J'\u00109\u001a\u0002062\u0006\u00101\u001a\u00020\u00002\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u000204H\u0001¢\u0006\u0004\b7\u00108R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010:\u001a\u0004\b;\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010:\u001a\u0004\b<\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010=\u001a\u0004\b>\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010=\u001a\u0004\b?\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010=\u001a\u0004\b@\u0010\u001dR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010:\u001a\u0004\bA\u0010\u001aR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010B\u001a\u0004\bC\u0010\"R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010D\u001a\u0004\b\r\u0010$R\u0017\u0010\u000e\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010D\u001a\u0004\b\u000e\u0010$R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010E\u001a\u0004\bF\u0010'R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010:\u001a\u0004\bG\u0010\u001aR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010E\u001a\u0004\bH\u0010'¨\u0006K"}, d2 = {"Lcom/uxsense/base/metadata/Chat;", "", "", "chatId", "userId", "", "nickname", "avatar", "lastMessage", "lastMessageAt", "", "unreadCount", "", "isPinned", "isMuted", "", "pageIds", "lastViewedAt", "screenshots", AppAgent.CONSTRUCT, "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JIZZLjava/util/List;JLjava/util/List;)V", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JIZZLjava/util/List;JLjava/util/List;LB9/d0;)V", "component1", "()J", "component2", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "component7", "()I", "component8", "()Z", "component9", "component10", "()Ljava/util/List;", "component11", "component12", "copy", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JIZZLjava/util/List;JLjava/util/List;)Lcom/uxsense/base/metadata/Chat;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/metadata/Chat;LA9/d;Lz9/g;)V", "write$Self", "J", "getChatId", "getUserId", "Ljava/lang/String;", "getNickname", "getAvatar", "getLastMessage", "getLastMessageAt", "I", "getUnreadCount", "Z", "Ljava/util/List;", "getPageIds", "getLastViewedAt", "getScreenshots", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Chat {
    private static final f[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String avatar;
    private final long chatId;
    private final boolean isMuted;
    private final boolean isPinned;
    private final String lastMessage;
    private final long lastMessageAt;
    private final long lastViewedAt;
    private final String nickname;
    private final List<Long> pageIds;
    private final List<String> screenshots;
    private final int unreadCount;
    private final long userId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/metadata/Chat$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/Chat;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return Chat$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        $childSerializers = new f[]{null, null, null, null, null, null, null, null, null, kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(13)), null, kotlin.a.b(lazyThreadSafetyMode, new com.stepos.ability.voicewakeup.service.f(14))};
    }

    public Chat(int i, long j5, long j6, String str, String str2, String str3, long j10, int i6, boolean z10, boolean z11, List list, long j11, List list2, d0 d0Var) {
        if (1027 != (i & 1027)) {
            T.g(Chat$$serializer.INSTANCE.getDescriptor(), i, 1027);
            throw null;
        }
        this.chatId = j5;
        this.userId = j6;
        if ((i & 4) == 0) {
            this.nickname = "";
        } else {
            this.nickname = str;
        }
        if ((i & 8) == 0) {
            this.avatar = "";
        } else {
            this.avatar = str2;
        }
        if ((i & 16) == 0) {
            this.lastMessage = "";
        } else {
            this.lastMessage = str3;
        }
        if ((i & 32) == 0) {
            this.lastMessageAt = 0L;
        } else {
            this.lastMessageAt = j10;
        }
        if ((i & 64) == 0) {
            this.unreadCount = 0;
        } else {
            this.unreadCount = i6;
        }
        if ((i & 128) == 0) {
            this.isPinned = false;
        } else {
            this.isPinned = z10;
        }
        if ((i & 256) == 0) {
            this.isMuted = false;
        } else {
            this.isMuted = z11;
        }
        this.pageIds = (i & 512) == 0 ? EmptyList.f4893a : list;
        this.lastViewedAt = j11;
        this.screenshots = (i & 2048) == 0 ? EmptyList.f4893a : list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_() {
        return new C0177d(L.f223a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$0() {
        return new C0177d(h0.f242a);
    }

    public static /* synthetic */ Chat copy$default(Chat chat, long j5, long j6, String str, String str2, String str3, long j10, int i, boolean z10, boolean z11, List list, long j11, List list2, int i6, Object obj) {
        long j12;
        long j13;
        long j14 = (i6 & 1) != 0 ? chat.chatId : j5;
        long j15 = (i6 & 2) != 0 ? chat.userId : j6;
        String str4 = (i6 & 4) != 0 ? chat.nickname : str;
        String str5 = (i6 & 8) != 0 ? chat.avatar : str2;
        String str6 = (i6 & 16) != 0 ? chat.lastMessage : str3;
        long j16 = (i6 & 32) != 0 ? chat.lastMessageAt : j10;
        int i10 = (i6 & 64) != 0 ? chat.unreadCount : i;
        boolean z12 = (i6 & 128) != 0 ? chat.isPinned : z10;
        boolean z13 = (i6 & 256) != 0 ? chat.isMuted : z11;
        List list3 = (i6 & 512) != 0 ? chat.pageIds : list;
        if ((i6 & 1024) != 0) {
            j12 = j14;
            j13 = chat.lastViewedAt;
        } else {
            j12 = j14;
            j13 = j11;
        }
        return chat.copy(j12, j15, str4, str5, str6, j16, i10, z12, z13, list3, j13, (i6 & 2048) != 0 ? chat.screenshots : list2);
    }

    public static final void write$Self$uxsense_release(Chat self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.chatId);
        output.encodeLongElement(serialDesc, 1, self.userId);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !k.b(self.nickname, "")) {
            output.encodeStringElement(serialDesc, 2, self.nickname);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !k.b(self.avatar, "")) {
            output.encodeStringElement(serialDesc, 3, self.avatar);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !k.b(self.lastMessage, "")) {
            output.encodeStringElement(serialDesc, 4, self.lastMessage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.lastMessageAt != 0) {
            output.encodeLongElement(serialDesc, 5, self.lastMessageAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.unreadCount != 0) {
            output.encodeIntElement(serialDesc, 6, self.unreadCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.isPinned) {
            output.encodeBooleanElement(serialDesc, 7, self.isPinned);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.isMuted) {
            output.encodeBooleanElement(serialDesc, 8, self.isMuted);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !k.b(self.pageIds, EmptyList.f4893a)) {
            output.encodeSerializableElement(serialDesc, 9, (x9.f) fVarArr[9].getF4884a(), self.pageIds);
        }
        output.encodeLongElement(serialDesc, 10, self.lastViewedAt);
        if (!output.shouldEncodeElementDefault(serialDesc, 11) && k.b(self.screenshots, EmptyList.f4893a)) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 11, (x9.f) fVarArr[11].getF4884a(), self.screenshots);
    }

    /* renamed from: component1, reason: from getter */
    public final long getChatId() {
        return this.chatId;
    }

    public final List<Long> component10() {
        return this.pageIds;
    }

    /* renamed from: component11, reason: from getter */
    public final long getLastViewedAt() {
        return this.lastViewedAt;
    }

    public final List<String> component12() {
        return this.screenshots;
    }

    /* renamed from: component2, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLastMessage() {
        return this.lastMessage;
    }

    /* renamed from: component6, reason: from getter */
    public final long getLastMessageAt() {
        return this.lastMessageAt;
    }

    /* renamed from: component7, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsPinned() {
        return this.isPinned;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    public final Chat copy(long chatId, long userId, String nickname, String avatar, String lastMessage, long lastMessageAt, int unreadCount, boolean isPinned, boolean isMuted, List<Long> pageIds, long lastViewedAt, List<String> screenshots) {
        k.f(nickname, "nickname");
        k.f(avatar, "avatar");
        k.f(lastMessage, "lastMessage");
        k.f(pageIds, "pageIds");
        k.f(screenshots, "screenshots");
        return new Chat(chatId, userId, nickname, avatar, lastMessage, lastMessageAt, unreadCount, isPinned, isMuted, pageIds, lastViewedAt, screenshots);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Chat)) {
            return false;
        }
        Chat chat = (Chat) other;
        return this.chatId == chat.chatId && this.userId == chat.userId && k.b(this.nickname, chat.nickname) && k.b(this.avatar, chat.avatar) && k.b(this.lastMessage, chat.lastMessage) && this.lastMessageAt == chat.lastMessageAt && this.unreadCount == chat.unreadCount && this.isPinned == chat.isPinned && this.isMuted == chat.isMuted && k.b(this.pageIds, chat.pageIds) && this.lastViewedAt == chat.lastViewedAt && k.b(this.screenshots, chat.screenshots);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final long getChatId() {
        return this.chatId;
    }

    public final String getLastMessage() {
        return this.lastMessage;
    }

    public final long getLastMessageAt() {
        return this.lastMessageAt;
    }

    public final long getLastViewedAt() {
        return this.lastViewedAt;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final List<Long> getPageIds() {
        return this.pageIds;
    }

    public final List<String> getScreenshots() {
        return this.screenshots;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.screenshots.hashCode() + androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.e(this.pageIds, androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.unreadCount, androidx.appfunctions.metadata.a.c(B7.a.c(B7.a.c(B7.a.c(androidx.appfunctions.metadata.a.c(Long.hashCode(this.chatId) * 31, 31, this.userId), 31, this.nickname), 31, this.avatar), 31, this.lastMessage), 31, this.lastMessageAt), 31), 31, this.isPinned), 31, this.isMuted), 31), 31, this.lastViewedAt);
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Chat(chatId=");
        sb.append(this.chatId);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(", lastMessage=");
        sb.append(this.lastMessage);
        sb.append(", lastMessageAt=");
        sb.append(this.lastMessageAt);
        sb.append(", unreadCount=");
        sb.append(this.unreadCount);
        sb.append(", isPinned=");
        sb.append(this.isPinned);
        sb.append(", isMuted=");
        sb.append(this.isMuted);
        sb.append(", pageIds=");
        sb.append(this.pageIds);
        sb.append(", lastViewedAt=");
        sb.append(this.lastViewedAt);
        sb.append(", screenshots=");
        return B7.a.r(sb, this.screenshots, ')');
    }

    public Chat(long j5, long j6, String nickname, String avatar, String lastMessage, long j10, int i, boolean z10, boolean z11, List<Long> pageIds, long j11, List<String> screenshots) {
        k.f(nickname, "nickname");
        k.f(avatar, "avatar");
        k.f(lastMessage, "lastMessage");
        k.f(pageIds, "pageIds");
        k.f(screenshots, "screenshots");
        this.chatId = j5;
        this.userId = j6;
        this.nickname = nickname;
        this.avatar = avatar;
        this.lastMessage = lastMessage;
        this.lastMessageAt = j10;
        this.unreadCount = i;
        this.isPinned = z10;
        this.isMuted = z11;
        this.pageIds = pageIds;
        this.lastViewedAt = j11;
        this.screenshots = screenshots;
    }

    public Chat(long j5, long j6, String str, String str2, String str3, long j10, int i, boolean z10, boolean z11, List list, long j11, List list2, int i6, e eVar) {
        this(j5, j6, (i6 & 4) != 0 ? "" : str, (i6 & 8) != 0 ? "" : str2, (i6 & 16) != 0 ? "" : str3, (i6 & 32) != 0 ? 0L : j10, (i6 & 64) != 0 ? 0 : i, (i6 & 128) != 0 ? false : z10, (i6 & 256) != 0 ? false : z11, (i6 & 512) != 0 ? EmptyList.f4893a : list, j11, (i6 & 2048) != 0 ? EmptyList.f4893a : list2);
    }
}
