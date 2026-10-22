package com.bytedanceos.common.ad.entity.req;

/* JADX INFO: loaded from: classes2.dex */
public class ReqAdEntity extends BaseReqAdEntity {
    private ReqAdPlaceEntity adplace;
    private ReqAppEntity app;
    private ReqDeviceEntity device;
    private int load_appinfo;

    public ReqAdEntity() {
        this.load_appinfo = 0;
    }

    public ReqAdPlaceEntity getAdplace() {
        return this.adplace;
    }

    public ReqAppEntity getApp() {
        return this.app;
    }

    public ReqDeviceEntity getDevice() {
        return this.device;
    }

    public int getLoad_appinfo() {
        return this.load_appinfo;
    }

    public void setAdplace(ReqAdPlaceEntity r10) {
        this.adplace = r10;
    }

    public void setApp(ReqAppEntity r10) {
        this.app = r10;
    }

    public void setDevice(ReqDeviceEntity r10) {
        this.device = r10;
    }

    public void setLoad_appinfo(int r10) {
        this.load_appinfo = r10;
    }
}
