package com.stepos.policy.sdk.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
        g.f(list, "<set-?>");
        this.baseInfoList = list;
    }

    public final void setBusinessId(String str) {
        g.f(str, "<set-?>");
        this.businessId = str;
    }

    public final void setDeleteInfoList(List<DeleteInfoBean> list) {
        g.f(list, "<set-?>");
        this.deleteInfoList = list;
    }

    public final void setOperation(String str) {
        g.f(str, "<set-?>");
        this.operation = str;
    }

    public final void setServiceName(String str) {
        g.f(str, "<set-?>");
        this.serviceName = str;
    }

    public final void setType(String str) {
        g.f(str, "<set-?>");
        this.type = str;
    }

    public final void setUseId(String str) {
        g.f(str, "<set-?>");
        this.useId = str;
    }

    public final void setValidateCode(String str) {
        g.f(str, "<set-?>");
        this.validateCode = str;
    }

    public final void setVerify_type(String str) {
        g.f(str, "<set-?>");
        this.verify_type = str;
    }
}
