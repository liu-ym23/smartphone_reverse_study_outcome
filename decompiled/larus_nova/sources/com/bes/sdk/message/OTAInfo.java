package com.bes.sdk.message;

import com.bes.sdk.utils.OTAChannel;
import com.bes.sdk.utils.OTAStatus;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class OTAInfo implements Serializable {
    private OTAChannel otaChannel;
    private OTAStatus otaStatus;

    public OTAInfo() {
    }

    public String toString() {
        return "OTAInfo{otaChannel=" + this.otaChannel + ", otaStatus=" + this.otaStatus + '}';
    }

    public OTAChannel getOtaChannel() {
        return this.otaChannel;
    }

    public OTAStatus getOtaStatus() {
        return this.otaStatus;
    }

    public void setOtaChannel(OTAChannel r100) {
        this.otaChannel = r100;
    }

    public void setOtaStatus(OTAStatus r100) {
        this.otaStatus = r100;
    }
}
