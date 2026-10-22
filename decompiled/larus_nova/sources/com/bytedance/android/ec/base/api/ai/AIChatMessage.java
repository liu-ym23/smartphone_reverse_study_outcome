package com.bytedance.android.ec.base.api.ai;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0001J\u0013\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006,"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/AIChatMessage;", "", "localMessageId", "", "messageId", "replyId", "conversationId", "messageStatusLocal", "Lcom/bytedance/android/ec/base/api/ai/AIChatMessageStatusLocal;", "isSelf", "", "isVisible", "isContentFinished", WsConstants.KEY_PAYLOAD, "ext", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/base/api/ai/AIChatMessageStatusLocal;ZZZLjava/lang/String;Ljava/util/Map;)V", "getConversationId", "()Ljava/lang/String;", "getExt", "()Ljava/util/Map;", "()Z", "getLocalMessageId", "getMessageId", "getMessageStatusLocal", "()Lcom/bytedance/android/ec/base/api/ai/AIChatMessageStatusLocal;", "getPayload", "getReplyId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class AIChatMessage {
    private final String conversationId;
    private final Map<String, String> ext;
    private final boolean isContentFinished;
    private final boolean isSelf;
    private final boolean isVisible;
    private final String localMessageId;
    private final String messageId;
    private final AIChatMessageStatusLocal messageStatusLocal;
    private final String payload;
    private final String replyId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIChatMessage copy$default(AIChatMessage r110, String r111, String r112, String r113, String r114, AIChatMessageStatusLocal r115, boolean r116, boolean r117, boolean r118, String r210, Map r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.localMessageId;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.messageId;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.replyId;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.conversationId;
    L19:
        if ((r212 & 16) == 0) goto L21;
        AIChatMessageStatusLocal r104 = r110.messageStatusLocal;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r105 = r110.isSelf;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r106 = r110.isVisible;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r107 = r110.isContentFinished;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.payload;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Map r108 = r110.ext;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.localMessageId;
    }

    public final Map<String, String> component10() {
        return this.ext;
    }

    public final String component2() {
        return this.messageId;
    }

    public final String component3() {
        return this.replyId;
    }

    public final String component4() {
        return this.conversationId;
    }

    public final AIChatMessageStatusLocal component5() {
        return this.messageStatusLocal;
    }

    public final boolean component6() {
        return this.isSelf;
    }

    public final boolean component7() {
        return this.isVisible;
    }

    public final boolean component8() {
        return this.isContentFinished;
    }

    public final String component9() {
        return this.payload;
    }

    public final AIChatMessage copy(String r110, String r111, String r112, String r113, AIChatMessageStatusLocal r114, boolean r115, boolean r116, boolean r210, String r211, Map<String, String> r212) {
        Intrinsics.checkNotNullParameter(r110, "localMessageId");
        Intrinsics.checkNotNullParameter(r114, "messageStatusLocal");
        Intrinsics.checkNotNullParameter(r212, "ext");
        return new AIChatMessage(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AIChatMessage) == false) goto L26;
        AIChatMessage r101 = (AIChatMessage) r100;
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.messageStatusLocal, r101.messageStatusLocal) == true) goto L16;
        return false;
    L16:
        if (this.isSelf == r101.isSelf) goto L18;
        return false;
    L18:
        if (this.isVisible == r101.isVisible) goto L20;
        return false;
    L20:
        if (this.isContentFinished == r101.isContentFinished) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.payload, r101.payload) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.localMessageId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.messageId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.replyId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.conversationId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        AIChatMessageStatusLocal r113 = this.messageStatusLocal;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.isSelf;
        ?? r117 = 1;
        ?? r118 = r116;
        if (r116 == false) goto L25;
        r118 = 1;
    L25:
        int r119 = (r115 + r118) * 31;
        boolean r120 = this.isVisible;
        ?? r121 = r120;
        if (r120 == false) goto L28;
        r121 = 1;
    L28:
        int r122 = (r119 + r121) * 31;
        boolean r123 = this.isContentFinished;
        if (r123 == true) goto L32;
        r117 = r123;
    L32:
        int r124 = (r122 + r117) * 31;
        String r125 = this.payload;
        if (r125 == null) goto L35;
        int r126 = r125.hashCode();
    L36:
        int r127 = (r124 + r126) * 31;
        Map<String, String> r128 = this.ext;
        if (r128 == null) goto L40;
        r101 = r128.hashCode();
    L40:
        return r127 + r101;
    L35:
        r126 = 0;
        goto L36
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AIChatMessage(localMessageId=" + this.localMessageId + ", messageId=" + this.messageId + ", replyId=" + this.replyId + ", conversationId=" + this.conversationId + ", messageStatusLocal=" + this.messageStatusLocal + ", isSelf=" + this.isSelf + ", isVisible=" + this.isVisible + ", isContentFinished=" + this.isContentFinished + ", payload=" + this.payload + ", ext=" + this.ext + ")";
    }

    public final String getConversationId() {
        return this.conversationId;
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

    public final AIChatMessageStatusLocal getMessageStatusLocal() {
        return this.messageStatusLocal;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final boolean isContentFinished() {
        return this.isContentFinished;
    }

    public final boolean isSelf() {
        return this.isSelf;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public AIChatMessage(String r100, String r101, String r102, String r103, AIChatMessageStatusLocal r104, boolean r105, boolean r106, boolean r107, String r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r100, "localMessageId");
        Intrinsics.checkNotNullParameter(r104, "messageStatusLocal");
        Intrinsics.checkNotNullParameter(r111, "ext");
        this.localMessageId = r100;
        this.messageId = r101;
        this.replyId = r102;
        this.conversationId = r103;
        this.messageStatusLocal = r104;
        this.isSelf = r105;
        this.isVisible = r106;
        this.isContentFinished = r107;
        this.payload = r110;
        this.ext = r111;
    }

    public /* synthetic */ AIChatMessage(String r110, String r111, String r112, String r113, AIChatMessageStatusLocal r114, boolean r115, boolean r116, boolean r117, String r118, Map r210, int r211, DefaultConstructorMarker r212) {
        String r100 = null;
        if ((r211 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r211 & 4) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r211 & 8) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r211 & 16) == 0) goto L17;
        AIChatMessageStatusLocal r104 = AIChatMessageStatusLocal.UNKNOWN;
    L19:
        if ((r211 & 32) == 0) goto L21;
        boolean r105 = false;
    L22:
        boolean r106 = true;
        if ((r211 & 64) == 0) goto L25;
        boolean r107 = true;
    L27:
        if ((r211 & 128) != 0) goto L31;
        r106 = r117;
    L31:
        if ((r211 & 256) != 0) goto L35;
        r100 = r118;
    L35:
        if ((r211 & 512) == 0) goto L37;
        Map r108 = MapsKt.emptyMap();
    L38:
        this(r110, r101, r102, r103, r104, r105, r107, r106, r100, r108);
        return;
    L37:
        r108 = r210;
        goto L38
    L25:
        r107 = r116;
        goto L27
    L21:
        r105 = r115;
        goto L22
    L17:
        r104 = r114;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
