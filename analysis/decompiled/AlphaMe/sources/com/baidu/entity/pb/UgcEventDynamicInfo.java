package com.baidu.entity.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class UgcEventDynamicInfo extends f {
    public static final int EXT_INFO_FIELD_NUMBER = 7;
    public static final int INQUIRY_CONFIG_FIELD_NUMBER = 1;
    public static final int INQUIRY_CONFIG_ID_FIELD_NUMBER = 2;
    public static final int META_FIELD_NUMBER = 3;
    public static final int SUB_TYPE_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 5;
    public static final int UGCEXTINFO_FIELD_NUMBER = 6;
    private boolean hasExtInfo;
    private boolean hasInquiryConfig;
    private boolean hasInquiryConfigId;
    private boolean hasMeta;
    private boolean hasSubType;
    private boolean hasType;
    private boolean hasUgcExtInfo;
    private UgcEventInquiryConfig inquiryConfig_ = null;
    private int inquiryConfigId_ = 0;
    private String meta_ = "";
    private int subType_ = 0;
    private int type_ = 0;
    private UgcExtInfo ugcExtInfo_ = null;
    private String extInfo_ = "";
    private int cachedSize = -1;

    public static UgcEventDynamicInfo parseFrom(b bVar) throws IOException {
        return new UgcEventDynamicInfo().mergeFrom(bVar);
    }

    public final UgcEventDynamicInfo clear() {
        clearInquiryConfig();
        clearInquiryConfigId();
        clearMeta();
        clearSubType();
        clearType();
        clearUgcExtInfo();
        clearExtInfo();
        this.cachedSize = -1;
        return this;
    }

    public UgcEventDynamicInfo clearExtInfo() {
        this.hasExtInfo = false;
        this.extInfo_ = "";
        return this;
    }

    public UgcEventDynamicInfo clearInquiryConfig() {
        this.hasInquiryConfig = false;
        this.inquiryConfig_ = null;
        return this;
    }

    public UgcEventDynamicInfo clearInquiryConfigId() {
        this.hasInquiryConfigId = false;
        this.inquiryConfigId_ = 0;
        return this;
    }

    public UgcEventDynamicInfo clearMeta() {
        this.hasMeta = false;
        this.meta_ = "";
        return this;
    }

    public UgcEventDynamicInfo clearSubType() {
        this.hasSubType = false;
        this.subType_ = 0;
        return this;
    }

    public UgcEventDynamicInfo clearType() {
        this.hasType = false;
        this.type_ = 0;
        return this;
    }

    public UgcEventDynamicInfo clearUgcExtInfo() {
        this.hasUgcExtInfo = false;
        this.ugcExtInfo_ = null;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public String getExtInfo() {
        return this.extInfo_;
    }

    public UgcEventInquiryConfig getInquiryConfig() {
        return this.inquiryConfig_;
    }

    public int getInquiryConfigId() {
        return this.inquiryConfigId_;
    }

    public String getMeta() {
        return this.meta_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iH = hasInquiryConfig() ? d.h(1, getInquiryConfig()) : 0;
        if (hasInquiryConfigId()) {
            iH += d.e(2, getInquiryConfigId());
        }
        if (hasMeta()) {
            iH += d.l(3, getMeta());
        }
        if (hasSubType()) {
            iH += d.e(4, getSubType());
        }
        if (hasType()) {
            iH += d.e(5, getType());
        }
        if (hasUgcExtInfo()) {
            iH += d.h(6, getUgcExtInfo());
        }
        if (hasExtInfo()) {
            iH += d.l(7, getExtInfo());
        }
        this.cachedSize = iH;
        return iH;
    }

    public int getSubType() {
        return this.subType_;
    }

    public int getType() {
        return this.type_;
    }

    public UgcExtInfo getUgcExtInfo() {
        return this.ugcExtInfo_;
    }

    public boolean hasExtInfo() {
        return this.hasExtInfo;
    }

    public boolean hasInquiryConfig() {
        return this.hasInquiryConfig;
    }

    public boolean hasInquiryConfigId() {
        return this.hasInquiryConfigId;
    }

    public boolean hasMeta() {
        return this.hasMeta;
    }

    public boolean hasSubType() {
        return this.hasSubType;
    }

    public boolean hasType() {
        return this.hasType;
    }

    public boolean hasUgcExtInfo() {
        return this.hasUgcExtInfo;
    }

    public final boolean isInitialized() {
        if (this.hasInquiryConfig && this.hasInquiryConfigId && getInquiryConfig().isInitialized()) {
            return !hasUgcExtInfo() || getUgcExtInfo().isInitialized();
        }
        return false;
    }

    public UgcEventDynamicInfo setExtInfo(String str) {
        this.hasExtInfo = true;
        this.extInfo_ = str;
        return this;
    }

    public UgcEventDynamicInfo setInquiryConfig(UgcEventInquiryConfig ugcEventInquiryConfig) {
        if (ugcEventInquiryConfig == null) {
            return clearInquiryConfig();
        }
        this.hasInquiryConfig = true;
        this.inquiryConfig_ = ugcEventInquiryConfig;
        return this;
    }

    public UgcEventDynamicInfo setInquiryConfigId(int i4) {
        this.hasInquiryConfigId = true;
        this.inquiryConfigId_ = i4;
        return this;
    }

    public UgcEventDynamicInfo setMeta(String str) {
        this.hasMeta = true;
        this.meta_ = str;
        return this;
    }

    public UgcEventDynamicInfo setSubType(int i4) {
        this.hasSubType = true;
        this.subType_ = i4;
        return this;
    }

    public UgcEventDynamicInfo setType(int i4) {
        this.hasType = true;
        this.type_ = i4;
        return this;
    }

    public UgcEventDynamicInfo setUgcExtInfo(UgcExtInfo ugcExtInfo) {
        if (ugcExtInfo == null) {
            return clearUgcExtInfo();
        }
        this.hasUgcExtInfo = true;
        this.ugcExtInfo_ = ugcExtInfo;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasInquiryConfig()) {
            dVar.u(1, getInquiryConfig());
        }
        if (hasInquiryConfigId()) {
            dVar.s(2, getInquiryConfigId());
        }
        if (hasMeta()) {
            dVar.A(3, getMeta());
        }
        if (hasSubType()) {
            dVar.s(4, getSubType());
        }
        if (hasType()) {
            dVar.s(5, getType());
        }
        if (hasUgcExtInfo()) {
            dVar.u(6, getUgcExtInfo());
        }
        if (hasExtInfo()) {
            dVar.A(7, getExtInfo());
        }
    }

    public static UgcEventDynamicInfo parseFrom(byte[] bArr) throws e {
        return (UgcEventDynamicInfo) new UgcEventDynamicInfo().mergeFrom(bArr);
    }

    @Override // L1.f
    public UgcEventDynamicInfo mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                UgcEventInquiryConfig ugcEventInquiryConfig = new UgcEventInquiryConfig();
                bVar.f(ugcEventInquiryConfig);
                setInquiryConfig(ugcEventInquiryConfig);
            } else if (iO == 16) {
                setInquiryConfigId(bVar.d());
            } else if (iO == 26) {
                setMeta(bVar.n());
            } else if (iO == 32) {
                setSubType(bVar.d());
            } else if (iO == 40) {
                setType(bVar.d());
            } else if (iO == 50) {
                UgcExtInfo ugcExtInfo = new UgcExtInfo();
                bVar.f(ugcExtInfo);
                setUgcExtInfo(ugcExtInfo);
            } else if (iO == 58) {
                setExtInfo(bVar.n());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
