package com.stepos.policy.sdk.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0018\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\u001a\u0010\u001e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\u001a\u0010!\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\u001a\u0010$\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000f¨\u0006'"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "", "()V", "baseInfoList", "", "Lcom/stepos/policy/sdk/bean/PolicyRecordBaseInfo;", "getBaseInfoList", "()Ljava/util/List;", "setBaseInfoList", "(Ljava/util/List;)V", "businessId", "", "getBusinessId", "()Ljava/lang/String;", "setBusinessId", "(Ljava/lang/String;)V", "deleteInfoList", "", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "getDeleteInfoList", "setDeleteInfoList", "operation", "getOperation", "setOperation", "serviceName", "getServiceName", "setServiceName", "type", "getType", "setType", "useId", "getUseId", "setUseId", "validateCode", "getValidateCode", "setValidateCode", "verify_type", "getVerify_type", "setVerify_type", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
        p.i(list, "<set-?>");
        this.baseInfoList = list;
    }

    public final void setBusinessId(String str) {
        p.i(str, "<set-?>");
        this.businessId = str;
    }

    public final void setDeleteInfoList(List<DeleteInfoBean> list) {
        p.i(list, "<set-?>");
        this.deleteInfoList = list;
    }

    public final void setOperation(String str) {
        p.i(str, "<set-?>");
        this.operation = str;
    }

    public final void setServiceName(String str) {
        p.i(str, "<set-?>");
        this.serviceName = str;
    }

    public final void setType(String str) {
        p.i(str, "<set-?>");
        this.type = str;
    }

    public final void setUseId(String str) {
        p.i(str, "<set-?>");
        this.useId = str;
    }

    public final void setValidateCode(String str) {
        p.i(str, "<set-?>");
        this.validateCode = str;
    }

    public final void setVerify_type(String str) {
        p.i(str, "<set-?>");
        this.verify_type = str;
    }
}
