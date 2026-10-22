package com.bytedance.ai.bridge.method.widget;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JI\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/ai/bridge/method/widget/UpdateCardInstanceRequest;", "", com.heytap.mcssdk.constant.b.f276376z, "", "cardInstanceId", "messageId", "widgetId", "widgetData", "timestamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAppKey", "()Ljava/lang/String;", "getCardInstanceId", "getMessageId", "getWidgetId", "getWidgetData", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("card_instance_id")
    private final String cardInstanceId;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("timestamp")
    private final long timestamp;

    @SerializedName("widget_data")
    private final String widgetData;

    @SerializedName("widget_id")
    private final String widgetId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardInstanceId, r101.cardInstanceId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.widgetId, r101.widgetId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.widgetData, r101.widgetData) == true) goto L24;
        return false;
    L24:
        if (this.timestamp == r101.timestamp) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.appKey.hashCode() * 31) + this.cardInstanceId.hashCode()) * 31;
        String r101 = this.messageId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.widgetId;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (((r104 + r102) * 31) + this.widgetData.hashCode()) * 31;
        long r107 = this.timestamp;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UpdateCardInstanceRequest(appKey=" + this.appKey + ", cardInstanceId=" + this.cardInstanceId + ", messageId=" + this.messageId + ", widgetId=" + this.widgetId + ", widgetData=" + this.widgetData + ", timestamp=" + this.timestamp + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
        Intrinsics.checkNotNullParameter(r101, "cardInstanceId");
        Intrinsics.checkNotNullParameter(r104, "widgetData");
        this.appKey = r100;
        this.cardInstanceId = r101;
        this.messageId = r102;
        this.widgetId = r103;
        this.widgetData = r104;
        this.timestamp = r105;
    }
}
