package com.bes.bessdk.service.base;

import com.bes.sdk.device.HmDevice;
import com.bes.sdk.utils.DeviceProtocol;
import java.io.Serializable;
import java.util.UUID;

/* JADX INFO: loaded from: classes39.dex */
public class BesServiceConfig implements Serializable {
    private Integer USER_FLAG;
    private UUID characteristicsTX;
    private UUID characteristicsUUID;
    private Boolean curAckType;
    private Integer curUpgateType;
    private Integer curUser;
    private UUID descriptorUUID;
    private HmDevice device;
    private DeviceProtocol deviceProtocol;
    private Integer imageSideSelection;
    private Boolean isSilenceOTA;
    private Boolean isUserOtaService;
    private Boolean isWithoutResponse;
    private UUID serviceUUID;
    private Boolean totaConnect;
    private Boolean useTotaV2;

    public BesServiceConfig() {
        Boolean r100 = Boolean.FALSE;
        this.totaConnect = r100;
        this.useTotaV2 = r100;
        this.USER_FLAG = 0;
        this.curUser = 1;
        this.curUpgateType = 1;
        this.curAckType = r100;
        this.imageSideSelection = 0;
        this.isWithoutResponse = r100;
        this.isUserOtaService = r100;
        this.isSilenceOTA = r100;
    }

    public UUID getCharacteristicsTX() {
        return this.characteristicsTX;
    }

    public UUID getCharacteristicsUUID() {
        return this.characteristicsUUID;
    }

    public Boolean getCurAckType() {
        return this.curAckType;
    }

    public Integer getCurUpgateType() {
        return this.curUpgateType;
    }

    public Integer getCurUser() {
        return this.curUser;
    }

    public UUID getDescriptorUUID() {
        return this.descriptorUUID;
    }

    public HmDevice getDevice() {
        return this.device;
    }

    public DeviceProtocol getDeviceProtocol() {
        return this.deviceProtocol;
    }

    public Integer getImageSideSelection() {
        return this.imageSideSelection;
    }

    public Boolean getIsSilenceOTA() {
        return this.isSilenceOTA;
    }

    public Boolean getIsUserOtaService() {
        return this.isUserOtaService;
    }

    public Boolean getIsWithoutResponse() {
        return this.isWithoutResponse;
    }

    public UUID getServiceUUID() {
        return this.serviceUUID;
    }

    public Boolean getTotaConnect() {
        return this.totaConnect;
    }

    public Integer getUSER_FLAG() {
        return this.USER_FLAG;
    }

    public Boolean getUseTotaV2() {
        return this.useTotaV2;
    }

    public void setCharacteristicsTX(UUID r100) {
        this.characteristicsTX = r100;
    }

    public void setCharacteristicsUUID(UUID r100) {
        this.characteristicsUUID = r100;
    }

    public void setCurAckType(Boolean r100) {
        this.curAckType = r100;
    }

    public void setCurUpgateType(Integer r100) {
        this.curUpgateType = r100;
    }

    public void setCurUser(Integer r100) {
        this.curUser = r100;
    }

    public void setDescriptorUUID(UUID r100) {
        this.descriptorUUID = r100;
    }

    public void setDevice(HmDevice r100) {
        this.device = r100;
    }

    public void setDeviceProtocol(DeviceProtocol r100) {
        this.deviceProtocol = r100;
    }

    public void setImageSideSelection(Integer r100) {
        this.imageSideSelection = r100;
    }

    public void setIsSilenceOTA(Boolean r100) {
        this.isSilenceOTA = r100;
    }

    public void setIsUserOtaService(Boolean r100) {
        this.isUserOtaService = r100;
    }

    public void setIsWithoutResponse(Boolean r100) {
        this.isWithoutResponse = r100;
    }

    public void setServiceUUID(UUID r100) {
        this.serviceUUID = r100;
    }

    public void setTotaConnect(Boolean r100) {
        this.totaConnect = r100;
    }

    public void setUSER_FLAG(Integer r100) {
        this.USER_FLAG = r100;
    }

    public void setUseTotaV2(Boolean r100) {
        this.useTotaV2 = r100;
    }
}
