package com.bytedance.ai.widget.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jk\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006*"}, d2 = {"Lcom/bytedance/ai/widget/models/ConversationWidgetData;", "", "packageName", "", "widgetId", "messageId", "botId", "conversationId", "liteTemplateUrl", "widgetData", "appType", "versionTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getWidgetId", "setWidgetId", "(Ljava/lang/String;)V", "getMessageId", "getBotId", "getConversationId", "getLiteTemplateUrl", "getWidgetData", "getAppType", "getVersionTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationWidgetData {
    private final String appType;
    private final String botId;
    private final String conversationId;
    private final String liteTemplateUrl;
    private final String messageId;
    private final String packageName;
    private final String versionTag;
    private final String widgetData;
    private String widgetId;

    public static /* synthetic */ ConversationWidgetData copy$default(ConversationWidgetData r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.packageName;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.widgetId;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.messageId;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.botId;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.conversationId;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.liteTemplateUrl;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.widgetData;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.appType;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.versionTag;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
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
        return this.packageName;
    }

    public final String component2() {
        return this.widgetId;
    }

    public final String component3() {
        return this.messageId;
    }

    public final String component4() {
        return this.botId;
    }

    public final String component5() {
        return this.conversationId;
    }

    public final String component6() {
        return this.liteTemplateUrl;
    }

    public final String component7() {
        return this.widgetData;
    }

    public final String component8() {
        return this.appType;
    }

    public final String component9() {
        return this.versionTag;
    }

    public final ConversationWidgetData copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210) {
        Intrinsics.checkNotNullParameter(r110, "packageName");
        Intrinsics.checkNotNullParameter(r111, "widgetId");
        Intrinsics.checkNotNullParameter(r112, "messageId");
        Intrinsics.checkNotNullParameter(r113, "botId");
        Intrinsics.checkNotNullParameter(r114, "conversationId");
        return new ConversationWidgetData(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConversationWidgetData) == true) goto L8;
        return false;
    L8:
        ConversationWidgetData r101 = (ConversationWidgetData) r100;
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r101.widgetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.liteTemplateUrl, r101.liteTemplateUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.widgetData, r101.widgetData) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.appType, r101.appType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.versionTag, r101.versionTag) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.packageName.hashCode() * 31) + this.widgetId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.botId.hashCode()) * 31) + this.conversationId.hashCode()) * 31;
        String r101 = this.liteTemplateUrl;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.widgetData;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.appType;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.versionTag;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ConversationWidgetData(packageName=" + this.packageName + ", widgetId=" + this.widgetId + ", messageId=" + this.messageId + ", botId=" + this.botId + ", conversationId=" + this.conversationId + ", liteTemplateUrl=" + this.liteTemplateUrl + ", widgetData=" + this.widgetData + ", appType=" + this.appType + ", versionTag=" + this.versionTag + ')';
    }

    public final String getAppType() {
        return this.appType;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getLiteTemplateUrl() {
        return this.liteTemplateUrl;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getVersionTag() {
        return this.versionTag;
    }

    public final String getWidgetData() {
        return this.widgetData;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public final void setWidgetId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.widgetId = r100;
    }

    public ConversationWidgetData(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "widgetId");
        Intrinsics.checkNotNullParameter(r102, "messageId");
        Intrinsics.checkNotNullParameter(r103, "botId");
        Intrinsics.checkNotNullParameter(r104, "conversationId");
        this.packageName = r100;
        this.widgetId = r101;
        this.messageId = r102;
        this.botId = r103;
        this.conversationId = r104;
        this.liteTemplateUrl = r105;
        this.widgetData = r106;
        this.appType = r107;
        this.versionTag = r110;
    }

    public /* synthetic */ ConversationWidgetData(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 16) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r212 & 32) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r212 & 64) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r212 & 128) == 0) goto L17;
        String r117 = null;
    L19:
        if ((r212 & 256) == 0) goto L21;
        String r118 = null;
    L22:
        this(r110, r111, r112, r113, r100, r101, r102, r117, r118);
        return;
    L21:
        r118 = r211;
        goto L22
    L17:
        r117 = r210;
        goto L19
    L13:
        r102 = r116;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
