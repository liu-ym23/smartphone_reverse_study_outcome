package com.stepos.datacenter.entity;

import O6.l;
import d7.c;
import java.util.UUID;

/* loaded from: classes3.dex */
public abstract class BaseEntity {
    private String businessDataBody;
    private long checkPoint;
    private long dataExpireTs;
    private String dataPrivacyLevel;
    private String dataSourceModule;
    private String dataType;
    private long dataUpdateTs;
    private String globalDataId;
    private long id;
    private long uniqueVectorId;
    private String verticalDomainId;

    public BaseEntity() {
        this.id = 0L;
        this.uniqueVectorId = c.f32138a.a(0L, 0L);
        this.globalDataId = UUID.randomUUID() + l.DATE_SEPARATOR + System.currentTimeMillis();
        this.verticalDomainId = null;
        this.dataUpdateTs = 0L;
        this.dataExpireTs = 0L;
        this.dataType = DataType.STRUCTURED.name();
        this.dataSourceModule = null;
        this.dataPrivacyLevel = null;
        this.businessDataBody = null;
        this.checkPoint = 0L;
    }

    public String getBusinessDataBody() {
        return this.businessDataBody;
    }

    public long getCheckPoint() {
        return this.checkPoint;
    }

    public long getDataExpireTs() {
        return this.dataExpireTs;
    }

    public String getDataPrivacyLevel() {
        return this.dataPrivacyLevel;
    }

    public String getDataSourceModule() {
        return this.dataSourceModule;
    }

    public String getDataType() {
        return this.dataType;
    }

    public long getDataUpdateTs() {
        return this.dataUpdateTs;
    }

    public String getGlobalDataId() {
        return this.globalDataId;
    }

    public long getId() {
        return this.id;
    }

    public long getUniqueVectorId() {
        return this.uniqueVectorId;
    }

    public String getVerticalDomainId() {
        return this.verticalDomainId;
    }

    public void setBusinessDataBody(String str) {
        this.businessDataBody = str;
    }

    public void setCheckPoint(long j10) {
        this.checkPoint = j10;
    }

    public void setDataExpireTs(long j10) {
        this.dataExpireTs = j10;
    }

    public void setDataPrivacyLevel(String str) {
        this.dataPrivacyLevel = str;
    }

    public void setDataSourceModule(String str) {
        this.dataSourceModule = str;
    }

    public void setDataType(String str) {
        this.dataType = str;
    }

    public void setDataUpdateTs(long j10) {
        this.dataUpdateTs = j10;
    }

    public void setGlobalDataId(String str) {
        this.globalDataId = str;
    }

    public void setId(long j10) {
        this.id = j10;
    }

    public void setUniqueVectorId(long j10) {
        this.uniqueVectorId = j10;
    }

    public void setVerticalDomainId(String str) {
        this.verticalDomainId = str;
    }

    public BaseEntity(long j10, long j11, String str, String str2, long j12, long j13, String str3, String str4, String str5, String str6, long j14) {
        this.id = 0L;
        this.uniqueVectorId = c.f32138a.a(0L, 0L);
        this.globalDataId = UUID.randomUUID() + l.DATE_SEPARATOR + System.currentTimeMillis();
        this.verticalDomainId = null;
        this.dataUpdateTs = 0L;
        this.dataExpireTs = 0L;
        DataType.STRUCTURED.name();
        this.id = j10;
        this.uniqueVectorId = j11;
        this.globalDataId = str;
        this.verticalDomainId = str2;
        this.dataUpdateTs = j12;
        this.dataExpireTs = j13;
        this.dataType = str3;
        this.dataSourceModule = str4;
        this.dataPrivacyLevel = str5;
        this.businessDataBody = str6;
        this.checkPoint = j14;
    }
}
