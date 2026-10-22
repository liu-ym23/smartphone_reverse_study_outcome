package com.stepos.policy.sdk.bean;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
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
        list.getClass();
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
        str.getClass();
        this.policyNewestPath = str;
    }

    public final void setPolicyNewestVersion(long j10) {
        this.policyNewestVersion = j10;
    }

    public final void setPolicyRecordRequest(PolicyRecordRequest policyRecordRequest) {
        this.policyRecordRequest = policyRecordRequest;
    }

    public final void setPolicyRegrantFlag(boolean z10) {
        this.policyRegrantFlag = z10;
    }

    public final void setPolicyServiceConfigList(List<PolicyServiceConfigBean> list) {
        list.getClass();
        this.policyServiceConfigList = list;
    }

    public final void setPolicyUrl(String str) {
        str.getClass();
        this.policyUrl = str;
    }

    public final void setVersionDesc(String str) {
        str.getClass();
        this.versionDesc = str;
    }

    public final void setVersionServer(int i) {
        this.versionServer = i;
    }
}
