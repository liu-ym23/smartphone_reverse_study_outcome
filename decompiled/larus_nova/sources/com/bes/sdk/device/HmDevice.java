package com.bes.sdk.device;

import com.bes.sdk.message.BatteryInfo;
import com.bes.sdk.utils.AudioChannel;
import com.bes.sdk.utils.DeviceProtocol;
import com.bes.sdk.utils.DeviceRole;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes39.dex */
public class HmDevice implements Serializable {
    private BatteryInfo batteryInfo;
    private String bleAddress;
    private AudioChannel channel;

    /* JADX INFO: renamed from: crc, reason: collision with root package name */
    private String f33664crc;
    private String deviceMAC;
    private String deviceMid;
    private String deviceName;
    private String devicePid;
    private String deviceUid;
    private String deviceVid;
    private String firmwareVer;
    private boolean isConnectable;
    private DeviceProtocol preferredProtocol;
    private DeviceRole role;
    private int rssi;
    private long scannedTimestamp;

    public HmDevice() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.deviceMAC});
    }

    public String toString() {
        return "HmDevice{\ndevicePid='" + this.devicePid + "'\ndeviceVid='" + this.deviceVid + "'\ndeviceMid='" + this.deviceMid + "'\nfirmwareVer='" + this.firmwareVer + "'\ndeviceMAC='" + this.deviceMAC + "'\ndeviceName='" + this.deviceName + "'\nbatteryInfo=" + this.batteryInfo + "\nrole=" + this.role + "\nisConnectable=" + this.isConnectable + "\nscannedTimestamp=" + this.scannedTimestamp + "\ncrc='" + this.f33664crc + "'\npreferredProtocol=" + this.preferredProtocol + "\ndeviceUid='" + this.deviceUid + "'\nchannel=" + this.channel + '}';
    }

    public BatteryInfo getBatteryInfo() {
        return this.batteryInfo;
    }

    public String getBleAddress() {
        return this.bleAddress;
    }

    public AudioChannel getChannel() {
        return this.channel;
    }

    public String getCrc() {
        return this.f33664crc;
    }

    public String getDeviceMAC() {
        return this.deviceMAC;
    }

    public String getDeviceMid() {
        return this.deviceMid;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDevicePid() {
        return this.devicePid;
    }

    public String getDeviceUid() {
        return this.deviceUid;
    }

    public String getDeviceVid() {
        return this.deviceVid;
    }

    public String getFirmwareVer() {
        return this.firmwareVer;
    }

    public DeviceProtocol getPreferredProtocol() {
        return this.preferredProtocol;
    }

    public DeviceRole getRole() {
        return this.role;
    }

    public int getRssi() {
        return this.rssi;
    }

    public long getScannedTimestamp() {
        return this.scannedTimestamp;
    }

    public boolean isConnectable() {
        return this.isConnectable;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.deviceMAC, ((HmDevice) r100).deviceMAC);
    }

    public void setBatteryInfo(BatteryInfo r100) {
        this.batteryInfo = r100;
    }

    public void setBleAddress(String r100) {
        this.bleAddress = r100;
    }

    public void setChannel(AudioChannel r100) {
        this.channel = r100;
    }

    public void setConnectable(boolean r100) {
        this.isConnectable = r100;
    }

    public void setCrc(String r100) {
        this.f33664crc = r100;
    }

    public void setDevice(HmDevice r100) {
        this.devicePid = r100.devicePid;
        this.deviceVid = r100.deviceVid;
        this.deviceMid = r100.deviceMid;
        this.firmwareVer = r100.firmwareVer;
        this.deviceMAC = r100.deviceMAC;
        this.bleAddress = r100.bleAddress;
        this.deviceName = r100.deviceName;
        this.batteryInfo = r100.batteryInfo;
        this.role = r100.role;
        this.isConnectable = r100.isConnectable;
        this.scannedTimestamp = r100.scannedTimestamp;
        this.f33664crc = r100.f33664crc;
        this.preferredProtocol = r100.preferredProtocol;
        this.deviceUid = r100.deviceUid;
        this.channel = r100.channel;
    }

    public void setDeviceMAC(String r100) {
        this.deviceMAC = r100;
    }

    public void setDeviceMid(String r100) {
        this.deviceMid = r100;
    }

    public void setDeviceName(String r100) {
        this.deviceName = r100;
    }

    public void setDevicePid(String r100) {
        this.devicePid = r100;
    }

    public void setDeviceUid(String r100) {
        this.deviceUid = r100;
    }

    public void setDeviceVid(String r100) {
        this.deviceVid = r100;
    }

    public void setFirmwareVer(String r100) {
        this.firmwareVer = r100;
    }

    public void setPreferredProtocol(DeviceProtocol r100) {
        this.preferredProtocol = r100;
    }

    public void setRole(DeviceRole r100) {
        this.role = r100;
    }

    public void setRssi(int r100) {
        this.rssi = r100;
    }

    public void setScannedTimestamp(long r100) {
        this.scannedTimestamp = r100;
    }
}
