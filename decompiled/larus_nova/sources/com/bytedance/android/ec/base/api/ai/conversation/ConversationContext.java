package com.bytedance.android.ec.base.api.ai.conversation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/conversation/ConversationContext;", "", "conversationId", "", "originMessageId", "originBcmId", "isFirstOpenInSourcePage", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getConversationId", "()Ljava/lang/String;", "()Z", "getOriginBcmId", "getOriginMessageId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class ConversationContext {
    private final String conversationId;
    private final boolean isFirstOpenInSourcePage;
    private final String originBcmId;
    private final String originMessageId;

    public static /* synthetic */ ConversationContext copy$default(ConversationContext r100, String r101, String r102, String r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.originMessageId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.originBcmId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isFirstOpenInSourcePage;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.originMessageId;
    }

    public final String component3() {
        return this.originBcmId;
    }

    public final boolean component4() {
        return this.isFirstOpenInSourcePage;
    }

    public final ConversationContext copy(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        return new ConversationContext(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ConversationContext) == false) goto L14;
        ConversationContext r101 = (ConversationContext) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.originMessageId, r101.originMessageId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.originBcmId, r101.originBcmId) == true) goto L12;
        return false;
    L12:
        if (this.isFirstOpenInSourcePage == r101.isFirstOpenInSourcePage) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.conversationId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.originMessageId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.originBcmId;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.isFirstOpenInSourcePage;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ConversationContext(conversationId=" + this.conversationId + ", originMessageId=" + this.originMessageId + ", originBcmId=" + this.originBcmId + ", isFirstOpenInSourcePage=" + this.isFirstOpenInSourcePage + ")";
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getOriginBcmId() {
        return this.originBcmId;
    }

    public final String getOriginMessageId() {
        return this.originMessageId;
    }

    public final boolean isFirstOpenInSourcePage() {
        return this.isFirstOpenInSourcePage;
    }

    public ConversationContext(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.conversationId = r100;
        this.originMessageId = r101;
        this.originBcmId = r102;
        this.isFirstOpenInSourcePage = r103;
    }

    public /* synthetic */ ConversationContext(String r100, String r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = true;
    L11:
        this(r100, r101, r102, r103);
    }
}
