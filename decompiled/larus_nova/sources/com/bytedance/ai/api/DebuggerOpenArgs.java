package com.bytedance.ai.api;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/ai/api/DebuggerOpenArgs;", "Ljava/io/Serializable;", "conversationId", "", "botId", "sourceConversationId", "mode", "Lcom/bytedance/ai/api/DebuggerMode;", "entryFrom", RemoteMessageConst.MessageBody.MSG_CONTENT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/api/DebuggerMode;Ljava/lang/String;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getBotId", "getSourceConversationId", "getMode", "()Lcom/bytedance/ai/api/DebuggerMode;", "getEntryFrom", "getMsgContent", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DebuggerOpenArgs implements Serializable {
    private final String botId;
    private final String conversationId;
    private final String entryFrom;
    private final DebuggerMode mode;
    private final String msgContent;
    private final String sourceConversationId;

    public static /* synthetic */ DebuggerOpenArgs copy$default(DebuggerOpenArgs r100, String r101, String r102, String r103, DebuggerMode r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.botId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.sourceConversationId;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.mode;
    L14:
        DebuggerMode r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.entryFrom;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.msgContent;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.botId;
    }

    public final String component3() {
        return this.sourceConversationId;
    }

    public final DebuggerMode component4() {
        return this.mode;
    }

    public final String component5() {
        return this.entryFrom;
    }

    public final String component6() {
        return this.msgContent;
    }

    public final DebuggerOpenArgs copy(String r100, String r110, String r111, DebuggerMode r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r110, "botId");
        Intrinsics.checkNotNullParameter(r111, "sourceConversationId");
        Intrinsics.checkNotNullParameter(r112, "mode");
        Intrinsics.checkNotNullParameter(r113, "entryFrom");
        return new DebuggerOpenArgs(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DebuggerOpenArgs) == true) goto L8;
        return false;
    L8:
        DebuggerOpenArgs r101 = (DebuggerOpenArgs) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceConversationId, r101.sourceConversationId) == true) goto L18;
        return false;
    L18:
        if (this.mode == r101.mode) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.entryFrom, r101.entryFrom) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.msgContent, r101.msgContent) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.conversationId.hashCode() * 31) + this.botId.hashCode()) * 31) + this.sourceConversationId.hashCode()) * 31) + this.mode.hashCode()) * 31) + this.entryFrom.hashCode()) * 31;
        String r101 = this.msgContent;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "DebuggerOpenArgs(conversationId=" + this.conversationId + ", botId=" + this.botId + ", sourceConversationId=" + this.sourceConversationId + ", mode=" + this.mode + ", entryFrom=" + this.entryFrom + ", msgContent=" + this.msgContent + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getEntryFrom() {
        return this.entryFrom;
    }

    public final DebuggerMode getMode() {
        return this.mode;
    }

    public final String getMsgContent() {
        return this.msgContent;
    }

    public final String getSourceConversationId() {
        return this.sourceConversationId;
    }

    public DebuggerOpenArgs(String r100, String r101, String r102, DebuggerMode r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "botId");
        Intrinsics.checkNotNullParameter(r102, "sourceConversationId");
        Intrinsics.checkNotNullParameter(r103, "mode");
        Intrinsics.checkNotNullParameter(r104, "entryFrom");
        this.conversationId = r100;
        this.botId = r101;
        this.sourceConversationId = r102;
        this.mode = r103;
        this.entryFrom = r104;
        this.msgContent = r105;
    }

    public /* synthetic */ DebuggerOpenArgs(String r100, String r101, String r110, DebuggerMode r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 32) == 0) goto L5;
        r113 = null;
    L5:
        this(r100, r101, r110, r111, r112, r113);
    }
}
