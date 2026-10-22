package com.scp.moderation.crypto.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.tonyodev.fetch2core.server.FileResponse;
import u2.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@q({ModelDownloadNotifier.EXTRA_NOTIF_ID, "content", "matchMode", "sensitiveType", FileResponse.FIELD_STATUS, "riskTagId", "tableId", "matchType", "remark", "createTime", "updateTime", "expireTime"})
/* loaded from: classes.dex */
public final class SensitiveWord {
    private final String content;
    private final String createTime;
    private final String expireTime;

    /* renamed from: id, reason: collision with root package name */
    private final long f5548id;
    private final int matchMode;
    private final String matchType;
    private final String remark;
    private final String riskTagId;
    private final Integer sensitiveType;
    private final int status;
    private final long tableId;
    private final String updateTime;

    @JsonCreator
    public SensitiveWord(@JsonProperty(required = true, value = ModelDownloadNotifier.EXTRA_NOTIF_ID) Long l10, @JsonProperty(required = true, value = "content") String str, @JsonProperty(required = true, value = "matchMode") Integer num, @JsonProperty("sensitiveType") Integer num2, @JsonProperty(required = true, value = FileResponse.FIELD_STATUS) Integer num3, @JsonProperty(required = true, value = "riskTagId") String str2, @JsonProperty(required = true, value = "tableId") Long l11, @JsonProperty(required = true, value = "matchType") String str3, @JsonProperty("remark") String str4, @JsonProperty("createTime") String str5, @JsonProperty("updateTime") String str6, @JsonProperty("expireTime") String str7) {
        if (l10 == null || str == null || num == null || num3 == null || str2 == null || l11 == null || str3 == null) {
            throw new IllegalArgumentException("missing required sensitive word field");
        }
        this.f5548id = l10.longValue();
        this.content = str;
        this.matchMode = num.intValue();
        this.sensitiveType = num2;
        this.status = num3.intValue();
        this.riskTagId = str2;
        this.tableId = l11.longValue();
        this.matchType = str3;
        this.remark = str4;
        this.createTime = str5;
        this.updateTime = str6;
        this.expireTime = str7;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public long getId() {
        return this.f5548id;
    }

    public int getMatchMode() {
        return this.matchMode;
    }

    public String getMatchType() {
        return this.matchType;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getRiskTagId() {
        return this.riskTagId;
    }

    public Integer getSensitiveType() {
        return this.sensitiveType;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTableId() {
        return this.tableId;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }
}
