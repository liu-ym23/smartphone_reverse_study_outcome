package com.bytedance.android.livesdk.interactivity.api.message;

import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.c;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.e;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.f;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.g;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.h;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.i;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.j;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.k;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.l;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.m;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.n;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.o;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.p;
import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageInject;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import y32.b;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\u0001\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018j\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/message/InteractivityMessageType;", "", "Lcom/bytedance/android/livesdkapi/message/ExternalMessageInject$InjectInfo;", "toInjectInfo", "Lcom/bytedance/android/livesdkapi/message/ExternalMessageType;", "externalMessageType", "Lcom/bytedance/android/livesdkapi/message/ExternalMessageType;", "getExternalMessageType", "()Lcom/bytedance/android/livesdkapi/message/ExternalMessageType;", "", "messageIntType", "I", "getMessageIntType", "()I", "", "messageMethod", "Ljava/lang/String;", "getMessageMethod", "()Ljava/lang/String;", "Ljava/lang/Class;", "Lcom/bytedance/android/livesdkapi/message/ExternalBaseMessage;", "messageType", "Ljava/lang/Class;", "getMessageType", "()Ljava/lang/Class;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "RoomChannelAccess", "RoomChannelAccessReply", "RoomChannelRole", "RoomChannelChat", "RoomChannelEmojiChat", "RoomChannelGift", "RoomChannelDisband", "RoomChannelKickOut", "RoomChannelState", "RoomChannelSystem", "RoomChannelAsset", "RoomChannelSocialGroup", "AnswerReview", "PlatformAdvise", "RoomChannelEncrypt", "RoomChannelInteractivityEmojiChat", "RoomChannelSecretChatCreate", "RoomChannelSecretChatStatus", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InteractivityMessageType extends Enum<InteractivityMessageType> {
    public static final InteractivityMessageType AnswerReview = null;
    public static final a Companion = null;
    public static final InteractivityMessageType PlatformAdvise = null;
    public static final InteractivityMessageType RoomChannelAccess = null;
    public static final InteractivityMessageType RoomChannelAccessReply = null;
    public static final InteractivityMessageType RoomChannelAsset = null;
    public static final InteractivityMessageType RoomChannelChat = null;
    public static final InteractivityMessageType RoomChannelDisband = null;
    public static final InteractivityMessageType RoomChannelEmojiChat = null;
    public static final InteractivityMessageType RoomChannelEncrypt = null;
    public static final InteractivityMessageType RoomChannelGift = null;
    public static final InteractivityMessageType RoomChannelInteractivityEmojiChat = null;
    public static final InteractivityMessageType RoomChannelKickOut = null;
    public static final InteractivityMessageType RoomChannelRole = null;
    public static final InteractivityMessageType RoomChannelSecretChatCreate = null;
    public static final InteractivityMessageType RoomChannelSecretChatStatus = null;
    public static final InteractivityMessageType RoomChannelSocialGroup = null;
    public static final InteractivityMessageType RoomChannelState = null;
    public static final InteractivityMessageType RoomChannelSystem = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractivityMessageType[] f133293a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<ExternalMessageInject.InjectInfo> f133294b = null;
    private final ExternalMessageType externalMessageType;
    private final int messageIntType;
    private final String messageMethod;
    private final Class<? extends ExternalBaseMessage> messageType;

    public static final class a {
        public a() {
        }
    }

    public static final ArrayList<ExternalMessageInject.InjectInfo> getInjectInfoList() {
        return f133294b;
    }

    public static InteractivityMessageType valueOf(String r100) {
        return (InteractivityMessageType) r27.a.a(InteractivityMessageType.class, r100);
    }

    public static InteractivityMessageType[] values() {
        return (InteractivityMessageType[]) f133293a.clone();
    }

    static {
        int r100 = b.f565846a;
        b.f565846a = r100 + 1;
        InteractivityMessageType r101 = new InteractivityMessageType("RoomChannelAccess", 0, r100, "WebcastRoomChannelAccessMessage", com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b.class);
        RoomChannelAccess = r101;
        int r102 = 0;
        int r110 = b.f565846a;
        b.f565846a = r110 + 1;
        InteractivityMessageType r103 = new InteractivityMessageType("RoomChannelAccessReply", 1, r110, "WebcastReplyRoomChannelMessage", com.bytedance.android.livesdk.interactivity.api.chatchannel.message.a.class);
        RoomChannelAccessReply = r103;
        int r104 = b.f565846a;
        b.f565846a = r104 + 1;
        InteractivityMessageType r105 = new InteractivityMessageType("RoomChannelRole", 2, r104, "WebcastRoomChannelRoleMessage", k.class);
        RoomChannelRole = r105;
        int r106 = b.f565846a;
        b.f565846a = r106 + 1;
        InteractivityMessageType r107 = new InteractivityMessageType("RoomChannelChat", 3, r106, "WebcastRoomChannelChatMessage", d.class);
        RoomChannelChat = r107;
        int r108 = b.f565846a;
        b.f565846a = r108 + 1;
        InteractivityMessageType r109 = new InteractivityMessageType("RoomChannelEmojiChat", 4, r108, "WebcastRoomChannelEmojiChatMessage", g.class);
        RoomChannelEmojiChat = r109;
        int r111 = b.f565846a;
        b.f565846a = r111 + 1;
        InteractivityMessageType r112 = new InteractivityMessageType("RoomChannelGift", 5, r111, "WebcastRoomChannelGiftMessage", h.class);
        RoomChannelGift = r112;
        int r113 = b.f565846a;
        b.f565846a = r113 + 1;
        InteractivityMessageType r114 = new InteractivityMessageType("RoomChannelDisband", 6, r113, "WebcastRoomChannelDisbandMessage", f.class);
        RoomChannelDisband = r114;
        int r115 = b.f565846a;
        b.f565846a = r115 + 1;
        InteractivityMessageType r116 = new InteractivityMessageType("RoomChannelKickOut", 7, r115, "WebcastRoomChannelKickOutMessage", j.class);
        RoomChannelKickOut = r116;
        int r117 = b.f565846a;
        b.f565846a = r117 + 1;
        InteractivityMessageType r118 = new InteractivityMessageType("RoomChannelState", 8, r117, "WebcastRoomChannelStateMessage", o.class);
        RoomChannelState = r118;
        int r119 = b.f565846a;
        b.f565846a = r119 + 1;
        InteractivityMessageType r120 = new InteractivityMessageType("RoomChannelSystem", 9, r119, "WebcastRoomChannelSystemMessage", p.class);
        RoomChannelSystem = r120;
        int r121 = b.f565846a;
        b.f565846a = r121 + 1;
        InteractivityMessageType r122 = new InteractivityMessageType("RoomChannelAsset", 10, r121, "WebcastRoomChannelAssetMessage", c.class);
        RoomChannelAsset = r122;
        int r123 = b.f565846a;
        b.f565846a = r123 + 1;
        InteractivityMessageType r124 = new InteractivityMessageType("RoomChannelSocialGroup", 11, r123, "WebcastRoomChannelSaveGroupMessage", n.class);
        RoomChannelSocialGroup = r124;
        int r125 = b.f565846a;
        b.f565846a = r125 + 1;
        InteractivityMessageType r126 = new InteractivityMessageType("AnswerReview", 12, r125, "WebcastAnswerReviewMessage", com.bytedance.android.livesdk.interactivity.api.message.model.a.class);
        AnswerReview = r126;
        int r127 = b.f565846a;
        b.f565846a = r127 + 1;
        InteractivityMessageType r128 = new InteractivityMessageType("PlatformAdvise", 13, r127, "WebcastPlatformAdviseMessage", com.bytedance.android.livesdk.interactivity.api.message.model.b.class);
        PlatformAdvise = r128;
        int r129 = b.f565846a;
        b.f565846a = r129 + 1;
        InteractivityMessageType r130 = new InteractivityMessageType("RoomChannelEncrypt", 14, r129, "WebcastRoomChannelCipherMessage", e.class);
        RoomChannelEncrypt = r130;
        int r131 = b.f565846a;
        b.f565846a = r131 + 1;
        InteractivityMessageType r132 = new InteractivityMessageType("RoomChannelInteractivityEmojiChat", 15, r131, "WebcastRoomChannelInteractiveEmojiChatMessage", i.class);
        RoomChannelInteractivityEmojiChat = r132;
        int r133 = b.f565846a;
        b.f565846a = r133 + 1;
        InteractivityMessageType r134 = new InteractivityMessageType("RoomChannelSecretChatCreate", 16, r133, "WebcastRoomSecretCreateMessage", l.class);
        RoomChannelSecretChatCreate = r134;
        int r135 = b.f565846a;
        b.f565846a = r135 + 1;
        InteractivityMessageType r136 = new InteractivityMessageType("RoomChannelSecretChatStatus", 17, r135, "WebcastRoomChannelSecretStatusMessage", m.class);
        RoomChannelSecretChatStatus = r136;
        f133293a = new InteractivityMessageType[]{r101, r103, r105, r107, r109, r112, r114, r116, r118, r120, r122, r124, r126, r128, r130, r132, r134, r136};
        Companion = new a();
        f133294b = new ArrayList();
        InteractivityMessageType[] r137 = values();
        int r138 = r137.length;
    L3:
        if (r102 >= r138) goto L5;
        f133294b.add(r137[r102].toInjectInfo());
        r102 = r102 + 1;
        goto L3
    }

    public final ExternalMessageInject.InjectInfo toInjectInfo() {
        return new ExternalMessageInject.InjectInfo(this.messageMethod, this.messageType);
    }

    public static final /* synthetic */ ArrayList access$getInjectInfoList$cp() {
        return f133294b;
    }

    public final ExternalMessageType getExternalMessageType() {
        return this.externalMessageType;
    }

    public final int getMessageIntType() {
        return this.messageIntType;
    }

    public final String getMessageMethod() {
        return this.messageMethod;
    }

    public final Class<? extends ExternalBaseMessage> getMessageType() {
        return this.messageType;
    }

    public InteractivityMessageType(String r100, int r101, int r102, String r103, Class r104) {
        super(r100, r101);
        this.messageIntType = r102;
        this.messageMethod = r103;
        this.messageType = r104;
        this.externalMessageType = ExternalMessageType.EXTERNAL_LIVE_INTERACTIVITY;
    }
}
