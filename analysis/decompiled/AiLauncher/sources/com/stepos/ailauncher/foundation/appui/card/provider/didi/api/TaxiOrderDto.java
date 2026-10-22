package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import D6.a;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/TaxiOrderDto;", "", "orderId", "", "status", "statusCode", "", a.KEY_TASK_STATUS, "updatedAt", "nextPollAt", "structuredContent", "Lcom/google/gson/JsonObject;", "integrationId", "upstreamOrderId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)V", "getOrderId", "()Ljava/lang/String;", "getStatus", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTaskStatus", "getUpdatedAt", "getNextPollAt", "getStructuredContent", "()Lcom/google/gson/JsonObject;", "getIntegrationId", "getUpstreamOrderId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/TaxiOrderDto;", "equals", "", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaxiOrderDto {

    @SerializedName("integrationId")
    private final String integrationId;

    @SerializedName("nextPollAt")
    private final String nextPollAt;

    @SerializedName("orderId")
    private final String orderId;

    @SerializedName("status")
    private final String status;

    @SerializedName("statusCode")
    private final Integer statusCode;

    @SerializedName("structuredContent")
    private final JsonObject structuredContent;

    @SerializedName(a.KEY_TASK_STATUS)
    private final Integer taskStatus;

    @SerializedName("updatedAt")
    private final String updatedAt;

    @SerializedName("upstreamOrderId")
    private final String upstreamOrderId;

    public TaxiOrderDto() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ TaxiOrderDto copy$default(TaxiOrderDto taxiOrderDto, String str, String str2, Integer num, Integer num2, String str3, String str4, JsonObject jsonObject, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = taxiOrderDto.orderId;
        }
        if ((i10 & 2) != 0) {
            str2 = taxiOrderDto.status;
        }
        if ((i10 & 4) != 0) {
            num = taxiOrderDto.statusCode;
        }
        if ((i10 & 8) != 0) {
            num2 = taxiOrderDto.taskStatus;
        }
        if ((i10 & 16) != 0) {
            str3 = taxiOrderDto.updatedAt;
        }
        if ((i10 & 32) != 0) {
            str4 = taxiOrderDto.nextPollAt;
        }
        if ((i10 & 64) != 0) {
            jsonObject = taxiOrderDto.structuredContent;
        }
        if ((i10 & 128) != 0) {
            str5 = taxiOrderDto.integrationId;
        }
        if ((i10 & 256) != 0) {
            str6 = taxiOrderDto.upstreamOrderId;
        }
        String str7 = str5;
        String str8 = str6;
        String str9 = str4;
        JsonObject jsonObject2 = jsonObject;
        String str10 = str3;
        Integer num3 = num;
        return taxiOrderDto.copy(str, str2, num3, num2, str10, str9, jsonObject2, str7, str8);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getStatusCode() {
        return this.statusCode;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getTaskStatus() {
        return this.taskStatus;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component6, reason: from getter */
    public final String getNextPollAt() {
        return this.nextPollAt;
    }

    /* renamed from: component7, reason: from getter */
    public final JsonObject getStructuredContent() {
        return this.structuredContent;
    }

    /* renamed from: component8, reason: from getter */
    public final String getIntegrationId() {
        return this.integrationId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getUpstreamOrderId() {
        return this.upstreamOrderId;
    }

    public final TaxiOrderDto copy(String orderId, String status, Integer statusCode, Integer taskStatus, String updatedAt, String nextPollAt, JsonObject structuredContent, String integrationId, String upstreamOrderId) {
        return new TaxiOrderDto(orderId, status, statusCode, taskStatus, updatedAt, nextPollAt, structuredContent, integrationId, upstreamOrderId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaxiOrderDto)) {
            return false;
        }
        TaxiOrderDto taxiOrderDto = (TaxiOrderDto) other;
        return p.d(this.orderId, taxiOrderDto.orderId) && p.d(this.status, taxiOrderDto.status) && p.d(this.statusCode, taxiOrderDto.statusCode) && p.d(this.taskStatus, taxiOrderDto.taskStatus) && p.d(this.updatedAt, taxiOrderDto.updatedAt) && p.d(this.nextPollAt, taxiOrderDto.nextPollAt) && p.d(this.structuredContent, taxiOrderDto.structuredContent) && p.d(this.integrationId, taxiOrderDto.integrationId) && p.d(this.upstreamOrderId, taxiOrderDto.upstreamOrderId);
    }

    public final String getIntegrationId() {
        return this.integrationId;
    }

    public final String getNextPollAt() {
        return this.nextPollAt;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getStatus() {
        return this.status;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final JsonObject getStructuredContent() {
        return this.structuredContent;
    }

    public final Integer getTaskStatus() {
        return this.taskStatus;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getUpstreamOrderId() {
        return this.upstreamOrderId;
    }

    public int hashCode() {
        String str = this.orderId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.status;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.statusCode;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.taskStatus;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.updatedAt;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nextPollAt;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        JsonObject jsonObject = this.structuredContent;
        int iHashCode7 = (iHashCode6 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        String str5 = this.integrationId;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.upstreamOrderId;
        return iHashCode8 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "TaxiOrderDto(orderId=" + this.orderId + ", status=" + this.status + ", statusCode=" + this.statusCode + ", taskStatus=" + this.taskStatus + ", updatedAt=" + this.updatedAt + ", nextPollAt=" + this.nextPollAt + ", structuredContent=" + this.structuredContent + ", integrationId=" + this.integrationId + ", upstreamOrderId=" + this.upstreamOrderId + ")";
    }

    public TaxiOrderDto(String str, String str2, Integer num, Integer num2, String str3, String str4, JsonObject jsonObject, String str5, String str6) {
        this.orderId = str;
        this.status = str2;
        this.statusCode = num;
        this.taskStatus = num2;
        this.updatedAt = str3;
        this.nextPollAt = str4;
        this.structuredContent = jsonObject;
        this.integrationId = str5;
        this.upstreamOrderId = str6;
    }

    public /* synthetic */ TaxiOrderDto(String str, String str2, Integer num, Integer num2, String str3, String str4, JsonObject jsonObject, String str5, String str6, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : num2, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : str4, (i10 & 64) != 0 ? null : jsonObject, (i10 & 128) != 0 ? null : str5, (i10 & 256) != 0 ? null : str6);
    }
}
