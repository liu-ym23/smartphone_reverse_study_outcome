package com.obric.network.request.intelligentvoice;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntelligentVoiceResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/network/request/intelligentvoice/ConversationSceneConf;", "", "conversationKey", "", "conversationType", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConversationKey", "()Ljava/lang/String;", "setConversationKey", "(Ljava/lang/String;)V", "getConversationType", "getMessage", "setMessage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConversationSceneConf {

    @SerializedName("conversation_key")
    private String conversationKey;

    @SerializedName("conversation_type")
    private final String conversationType;

    @SerializedName("message")
    private String message;

    public static /* synthetic */ ConversationSceneConf copy$default(ConversationSceneConf r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.conversationKey;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.conversationType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.message;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.conversationKey;
    }

    public final String component2() {
        return this.conversationType;
    }

    public final String component3() {
        return this.message;
    }

    public final ConversationSceneConf copy(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationType");
        return new ConversationSceneConf(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ConversationSceneConf) == true) goto L8;
        return false;
    L8:
        ConversationSceneConf r6 = (ConversationSceneConf) r5;
        if (Intrinsics.areEqual(this.conversationKey, r6.conversationKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationType, r6.conversationType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.conversationKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.conversationType.hashCode()) * 31;
        String r4 = this.message;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ConversationSceneConf(conversationKey=" + this.conversationKey + ", conversationType=" + this.conversationType + ", message=" + this.message + ')';
    }

    public ConversationSceneConf(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "conversationType");
        this.conversationKey = r2;
        this.conversationType = r3;
        this.message = r4;
    }

    public final String getConversationKey() {
        return this.conversationKey;
    }

    public final void setConversationKey(String r1) {
        this.conversationKey = r1;
    }

    public final String getConversationType() {
        return this.conversationType;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }
}
