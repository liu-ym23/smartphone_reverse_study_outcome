package com.stepos.policy.sdk.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R \u00107\u001a\b\u0012\u0004\u0012\u0002080\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR\u001a\u0010;\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010%\"\u0004\b=\u0010'R\u001a\u0010>\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010%\"\u0004\b@\u0010'R\u001a\u0010A\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\b¨\u0006D"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "deleteInfoBeanList", "", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "getDeleteInfoBeanList", "()Ljava/util/List;", "setDeleteInfoBeanList", "(Ljava/util/List;)V", "policyData", "Lcom/stepos/policy/sdk/bean/PolicyData;", "getPolicyData", "()Lcom/stepos/policy/sdk/bean/PolicyData;", "setPolicyData", "(Lcom/stepos/policy/sdk/bean/PolicyData;)V", "policyHistoryListResponse", "Lcom/stepos/policy/sdk/bean/PolicyHistoryListResponse;", "getPolicyHistoryListResponse", "()Lcom/stepos/policy/sdk/bean/PolicyHistoryListResponse;", "setPolicyHistoryListResponse", "(Lcom/stepos/policy/sdk/bean/PolicyHistoryListResponse;)V", "policyNewest", "", "getPolicyNewest", "()Z", "setPolicyNewest", "(Z)V", "policyNewestPath", "", "getPolicyNewestPath", "()Ljava/lang/String;", "setPolicyNewestPath", "(Ljava/lang/String;)V", "policyNewestVersion", "", "getPolicyNewestVersion", "()J", "setPolicyNewestVersion", "(J)V", "policyRecordRequest", "Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "getPolicyRecordRequest", "()Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "setPolicyRecordRequest", "(Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;)V", "policyRegrantFlag", "getPolicyRegrantFlag", "setPolicyRegrantFlag", "policyServiceConfigList", "Lcom/stepos/policy/sdk/bean/PolicyServiceConfigBean;", "getPolicyServiceConfigList", "setPolicyServiceConfigList", "policyUrl", "getPolicyUrl", "setPolicyUrl", "versionDesc", "getVersionDesc", "setVersionDesc", "versionServer", "getVersionServer", "setVersionServer", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicySdkResultBean {
    private int code;
    private PolicyData policyData;
    private PolicyHistoryListResponse policyHistoryListResponse;
    private boolean policyNewest;
    private long policyNewestVersion;
    private PolicyRecordRequest policyRecordRequest;
    private boolean policyRegrantFlag;
    private String policyNewestPath = "";
    private String policyUrl = "";
    private String versionDesc = "";
    private int versionServer = -1;
    private List<PolicyServiceConfigBean> policyServiceConfigList = new ArrayList();
    private List<DeleteInfoBean> deleteInfoBeanList = new ArrayList();

    public final int getCode() {
        return this.code;
    }

    public final List<DeleteInfoBean> getDeleteInfoBeanList() {
        return this.deleteInfoBeanList;
    }

    public final PolicyData getPolicyData() {
        return this.policyData;
    }

    public final PolicyHistoryListResponse getPolicyHistoryListResponse() {
        return this.policyHistoryListResponse;
    }

    public final boolean getPolicyNewest() {
        return this.policyNewest;
    }

    public final String getPolicyNewestPath() {
        return this.policyNewestPath;
    }

    public final long getPolicyNewestVersion() {
        return this.policyNewestVersion;
    }

    public final PolicyRecordRequest getPolicyRecordRequest() {
        return this.policyRecordRequest;
    }

    public final boolean getPolicyRegrantFlag() {
        return this.policyRegrantFlag;
    }

    public final List<PolicyServiceConfigBean> getPolicyServiceConfigList() {
        return this.policyServiceConfigList;
    }

    public final String getPolicyUrl() {
        return this.policyUrl;
    }

    public final String getVersionDesc() {
        return this.versionDesc;
    }

    public final int getVersionServer() {
        return this.versionServer;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setDeleteInfoBeanList(List<DeleteInfoBean> list) {
        k.f(list, "<set-?>");
        this.deleteInfoBeanList = list;
    }

    public final void setPolicyData(PolicyData policyData) {
        this.policyData = policyData;
    }

    public final void setPolicyHistoryListResponse(PolicyHistoryListResponse policyHistoryListResponse) {
        this.policyHistoryListResponse = policyHistoryListResponse;
    }

    public final void setPolicyNewest(boolean z10) {
        this.policyNewest = z10;
    }

    public final void setPolicyNewestPath(String str) {
        k.f(str, "<set-?>");
        this.policyNewestPath = str;
    }

    public final void setPolicyNewestVersion(long j5) {
        this.policyNewestVersion = j5;
    }

    public final void setPolicyRecordRequest(PolicyRecordRequest policyRecordRequest) {
        this.policyRecordRequest = policyRecordRequest;
    }

    public final void setPolicyRegrantFlag(boolean z10) {
        this.policyRegrantFlag = z10;
    }

    public final void setPolicyServiceConfigList(List<PolicyServiceConfigBean> list) {
        k.f(list, "<set-?>");
        this.policyServiceConfigList = list;
    }

    public final void setPolicyUrl(String str) {
        k.f(str, "<set-?>");
        this.policyUrl = str;
    }

    public final void setVersionDesc(String str) {
        k.f(str, "<set-?>");
        this.versionDesc = str;
    }

    public final void setVersionServer(int i) {
        this.versionServer = i;
    }
}
