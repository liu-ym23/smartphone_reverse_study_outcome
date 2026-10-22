package com.stepos.policy.sdk.bean;

import j4.k;
import java.util.ArrayList;
import java.util.List;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class PolicyRecordRequest {
    private String businessId = BuildConfig.FLAVOR;
    private String operation = BuildConfig.FLAVOR;
    private String type = BuildConfig.FLAVOR;
    private String useId = BuildConfig.FLAVOR;
    private List<PolicyRecordBaseInfo> baseInfoList = new ArrayList();
    private List<DeleteInfoBean> deleteInfoList = new ArrayList();
    private String verify_type = BuildConfig.FLAVOR;
    private String serviceName = BuildConfig.FLAVOR;
    private String validateCode = BuildConfig.FLAVOR;

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
        k.g(list, "<set-?>");
        this.baseInfoList = list;
    }

    public final void setBusinessId(String str) {
        k.g(str, "<set-?>");
        this.businessId = str;
    }

    public final void setDeleteInfoList(List<DeleteInfoBean> list) {
        k.g(list, "<set-?>");
        this.deleteInfoList = list;
    }

    public final void setOperation(String str) {
        k.g(str, "<set-?>");
        this.operation = str;
    }

    public final void setServiceName(String str) {
        k.g(str, "<set-?>");
        this.serviceName = str;
    }

    public final void setType(String str) {
        k.g(str, "<set-?>");
        this.type = str;
    }

    public final void setUseId(String str) {
        k.g(str, "<set-?>");
        this.useId = str;
    }

    public final void setValidateCode(String str) {
        k.g(str, "<set-?>");
        this.validateCode = str;
    }

    public final void setVerify_type(String str) {
        k.g(str, "<set-?>");
        this.verify_type = str;
    }
}
