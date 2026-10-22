package com.stepos.policy.sdk.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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

    public final void setCode(int i10) {
        this.code = i10;
    }

    public final void setDeleteInfoBeanList(List<DeleteInfoBean> list) {
        g.f(list, "<set-?>");
        this.deleteInfoBeanList = list;
    }

    public final void setPolicyData(PolicyData policyData) {
        this.policyData = policyData;
    }

    public final void setPolicyHistoryListResponse(PolicyHistoryListResponse policyHistoryListResponse) {
        this.policyHistoryListResponse = policyHistoryListResponse;
    }

    public final void setPolicyNewest(boolean z) {
        this.policyNewest = z;
    }

    public final void setPolicyNewestPath(String str) {
        g.f(str, "<set-?>");
        this.policyNewestPath = str;
    }

    public final void setPolicyNewestVersion(long j10) {
        this.policyNewestVersion = j10;
    }

    public final void setPolicyRecordRequest(PolicyRecordRequest policyRecordRequest) {
        this.policyRecordRequest = policyRecordRequest;
    }

    public final void setPolicyRegrantFlag(boolean z) {
        this.policyRegrantFlag = z;
    }

    public final void setPolicyServiceConfigList(List<PolicyServiceConfigBean> list) {
        g.f(list, "<set-?>");
        this.policyServiceConfigList = list;
    }

    public final void setPolicyUrl(String str) {
        g.f(str, "<set-?>");
        this.policyUrl = str;
    }

    public final void setVersionDesc(String str) {
        g.f(str, "<set-?>");
        this.versionDesc = str;
    }

    public final void setVersionServer(int i10) {
        this.versionServer = i10;
    }
}
