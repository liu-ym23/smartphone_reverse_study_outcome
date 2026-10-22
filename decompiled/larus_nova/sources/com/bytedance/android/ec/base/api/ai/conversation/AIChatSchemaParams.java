package com.bytedance.android.ec.base.api.ai.conversation;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J-\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/conversation/AIChatSchemaParams;", "", "", "component1", "component2", "component3", "conversationId", "originMessageId", "originBcmId", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getConversationId", "()Ljava/lang/String;", "getOriginMessageId", "getOriginBcmId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class AIChatSchemaParams {
    public static final a Companion = null;
    public static final AIChatSchemaParams EMPTY = null;
    private final String conversationId;
    private final String originBcmId;
    private final String originMessageId;

    public static final class a {
        public a() {
        }
    }

    public AIChatSchemaParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AIChatSchemaParams copy$default(AIChatSchemaParams r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.originMessageId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.originBcmId;
    L12:
        return r100.copy(r101, r102, r103);
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

    public final AIChatSchemaParams copy(String r100, String r101, String r102) {
        return new AIChatSchemaParams(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AIChatSchemaParams) == false) goto L12;
        AIChatSchemaParams r101 = (AIChatSchemaParams) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.originMessageId, r101.originMessageId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.originBcmId, r101.originBcmId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

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
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AIChatSchemaParams(conversationId=" + this.conversationId + ", originMessageId=" + this.originMessageId + ", originBcmId=" + this.originBcmId + ")";
    }

    static {
        Companion = new a();
        EMPTY = new AIChatSchemaParams(null, null, null, 7, null);
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

    public AIChatSchemaParams(String r100, String r101, String r102) {
        this.conversationId = r100;
        this.originMessageId = r101;
        this.originBcmId = r102;
    }

    public /* synthetic */ AIChatSchemaParams(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
