package com.byted.mgl.merge.service.api.pay.model;

import com.alipay.sdk.m.u.i;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/byted/mgl/merge/service/api/pay/model/WxGamePayParamEntity;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "miniProgramType", "", "getMiniProgramType", "()I", "setMiniProgramType", "(I)V", "originArgs", "getOriginArgs", "setOriginArgs", "path", "getPath", "setPath", "userName", "getUserName", "setUserName", "toString", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public final class WxGamePayParamEntity {
    private String appId;
    private int miniProgramType;
    private String originArgs;
    private String path;
    private String userName;

    public WxGamePayParamEntity() {
    }

    public String toString() {
        return "{userName: " + this.userName + ",path: " + this.path + ",miniProgramType: " + this.miniProgramType + ",originArgs:" + this.originArgs + i.f25855d;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final int getMiniProgramType() {
        return this.miniProgramType;
    }

    public final String getOriginArgs() {
        return this.originArgs;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setAppId(String r100) {
        this.appId = r100;
    }

    public final void setMiniProgramType(int r100) {
        this.miniProgramType = r100;
    }

    public final void setOriginArgs(String r100) {
        this.originArgs = r100;
    }

    public final void setPath(String r100) {
        this.path = r100;
    }

    public final void setUserName(String r100) {
        this.userName = r100;
    }
}
