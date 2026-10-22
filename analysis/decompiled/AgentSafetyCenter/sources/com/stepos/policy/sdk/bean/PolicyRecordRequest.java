package com.stepos.policy.sdk.bean;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyRecordRequest {
    private String businessId = "";
    private String operation = "";
    private String type = "";
    private String useId = "";
    private List<PolicyRecordBaseInfo> baseInfoList = new ArrayList();
    private List<DeleteInfoBean> deleteInfoList = new ArrayList();
    private String verify_type = "";
    private String serviceName = "";
    private String validateCode = "";

    public final List<PolicyRecordBaseInfo> getBaseInfoList() {
        return this.baseInfoList;
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final List<DeleteInfoBean> getDeleteInfoList() {
        return this.deleteInfoList;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final String getServiceName() {
        return this.serviceName;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUseId() {
        return this.useId;
    }

    public final String getValidateCode() {
        return this.validateCode;
    }

    public final String getVerify_type() {
        return this.verify_type;
    }

    public final void setBaseInfoList(List<PolicyRecordBaseInfo> list) {
        list.getClass();
        this.baseInfoList = list;
    }

    public final void setBusinessId(String str) {
        str.getClass();
        this.businessId = str;
    }

    public final void setDeleteInfoList(List<DeleteInfoBean> list) {
        list.getClass();
        this.deleteInfoList = list;
    }

    public final void setOperation(String str) {
        str.getClass();
        this.operation = str;
    }

    public final void setServiceName(String str) {
        str.getClass();
        this.serviceName = str;
    }

    public final void setType(String str) {
        str.getClass();
        this.type = str;
    }

    public final void setUseId(String str) {
        str.getClass();
        this.useId = str;
    }

    public final void setValidateCode(String str) {
        str.getClass();
        this.validateCode = str;
    }

    public final void setVerify_type(String str) {
        str.getClass();
        this.verify_type = str;
    }
}
