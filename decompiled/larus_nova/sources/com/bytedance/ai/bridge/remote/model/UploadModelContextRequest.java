package com.bytedance.ai.bridge.remote.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u007f\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006."}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/UploadModelContextRequest;", "Ljava/io/Serializable;", DBDefinition.TASK_ID, "", "packageName", "messageId", "conversationId", "entityId", "content", "timestamp", "", "source", "widgetId", "pageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "getPackageName", "getMessageId", "getConversationId", "getEntityId", "getContent", "getTimestamp", "()J", "getSource", "getWidgetId", "getPageId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadModelContextRequest implements Serializable {

    @SerializedName("content")
    private final String content;

    @SerializedName("conv_id")
    private final String conversationId;

    @SerializedName(PickerReporterConstants.KEY.ENTITY_ID)
    private final String entityId;

    @SerializedName("msg_id")
    private final String messageId;

    @SerializedName("app_key")
    private final String packageName;

    @SerializedName(a.KEY_PAGE_ID)
    private final String pageId;

    @SerializedName("source")
    private final String source;

    @SerializedName("biz_task_id")
    private final String taskId;

    @SerializedName("timestamp")
    private final long timestamp;

    @SerializedName("widget_id")
    private final String widgetId;

    public UploadModelContextRequest() {
        this(null, null, null, null, null, null, 0, null, null, null, 1023, null);
    }

    public static /* synthetic */ UploadModelContextRequest copy$default(UploadModelContextRequest r110, String r111, String r112, String r113, String r114, String r115, String r116, long r117, String r210, String r211, String r212, int r213, Object r214) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = r110.taskId;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r101 = r110.packageName;
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r102 = r110.messageId;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r103 = r110.conversationId;
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r104 = r110.entityId;
    L23:
        if ((r213 & 32) == 0) goto L25;
        String r105 = r110.content;
    L27:
        if ((r213 & 64) == 0) goto L29;
        long r106 = r110.timestamp;
    L31:
        if ((r213 & 128) == 0) goto L33;
        String r118 = r110.source;
    L35:
        if ((r213 & 256) == 0) goto L37;
        String r119 = r110.widgetId;
    L39:
        if ((r213 & 512) == 0) goto L41;
        String r107 = r110.pageId;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r118, r119, r107);
    L41:
        r107 = r212;
        goto L43
    L37:
        r119 = r211;
        goto L39
    L33:
        r118 = r210;
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
        return this.taskId;
    }

    public final String component10() {
        return this.pageId;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.messageId;
    }

    public final String component4() {
        return this.conversationId;
    }

    public final String component5() {
        return this.entityId;
    }

    public final String component6() {
        return this.content;
    }

    public final long component7() {
        return this.timestamp;
    }

    public final String component8() {
        return this.source;
    }

    public final String component9() {
        return this.widgetId;
    }

    public final UploadModelContextRequest copy(String r110, String r111, String r112, String r113, String r114, String r115, long r210, String r211, String r212, String r213) {
        return new UploadModelContextRequest(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UploadModelContextRequest) == true) goto L8;
        return false;
    L8:
        UploadModelContextRequest r101 = (UploadModelContextRequest) r100;
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.entityId, r101.entityId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L27;
        return false;
    L27:
        if (this.timestamp == r101.timestamp) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.widgetId, r101.widgetId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.pageId, r101.pageId) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.taskId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.packageName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.messageId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.conversationId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.entityId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.content;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        long r119 = this.timestamp;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        String r121 = this.source;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        String r124 = this.widgetId;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.pageId;
        if (r127 == null) goto L39;
        r101 = r127.hashCode();
    L39:
        return r126 + r101;
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "UploadModelContextRequest(taskId=" + this.taskId + ", packageName=" + this.packageName + ", messageId=" + this.messageId + ", conversationId=" + this.conversationId + ", entityId=" + this.entityId + ", content=" + this.content + ", timestamp=" + this.timestamp + ", source=" + this.source + ", widgetId=" + this.widgetId + ", pageId=" + this.pageId + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public UploadModelContextRequest(String r100, String r101, String r102, String r103, String r104, String r105, long r106, String r107, String r110, String r111) {
        this.taskId = r100;
        this.packageName = r101;
        this.messageId = r102;
        this.conversationId = r103;
        this.entityId = r104;
        this.content = r105;
        this.timestamp = r106;
        this.source = r107;
        this.widgetId = r110;
        this.pageId = r111;
    }

    public /* synthetic */ UploadModelContextRequest(String r110, String r111, String r112, String r113, String r114, String r115, long r116, String r210, String r211, String r212, int r213, DefaultConstructorMarker r214) {
        String r100 = null;
        if ((r213 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r213 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r213 & 64) == 0) goto L29;
        long r107 = 0;
    L31:
        if ((r213 & 128) == 0) goto L33;
        String r117 = null;
    L35:
        if ((r213 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r213 & 512) != 0) goto L42;
        r100 = r212;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r117, r118, r100);
        return;
    L37:
        r118 = r211;
        goto L39
    L33:
        r117 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
