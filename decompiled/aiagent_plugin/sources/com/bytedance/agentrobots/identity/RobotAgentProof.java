package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RobotAgentProof implements Parcelable {
    public static final Parcelable.Creator<RobotAgentProof> CREATOR = null;
    private String agentHash;
    private String agentUuid;
    private List<String> certificateChain;
    private RobotDeviceStatus deviceStatus;
    private byte[] deviceStatusBytes;
    private byte[] signature;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RobotAgentProof() {
    }

    public RobotAgentProof(String r3, String r4, RobotDeviceStatus r5, byte[] r6, List<String> r7, byte[] r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.agentUuid = r3;
        this.agentHash = r4;
        this.deviceStatus = r5;
        this.deviceStatusBytes = r6;
        this.certificateChain = r9;
        this.signature = r8;
    }

    public RobotAgentProof(Parcel r4) {
        this.agentUuid = r4.readString();
        this.agentHash = r4.readString();
        this.deviceStatus = (RobotDeviceStatus) ZeusTransformUtils.preCheckCast(r4.readParcelable(RobotDeviceStatus.class.getClassLoader()), RobotDeviceStatus.class, "com.obric.aiagent.plugin");
        this.deviceStatusBytes = r4.createByteArray();
        this.certificateChain = r4.createStringArrayList();
        this.signature = r4.createByteArray();
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeString(this.agentUuid);
        r2.writeString(this.agentHash);
        r2.writeParcelable(this.deviceStatus, r3);
        r2.writeByteArray(this.deviceStatusBytes);
        r2.writeStringList(this.certificateChain);
        r2.writeByteArray(this.signature);
    }

    public String getAgentUuid() {
        return this.agentUuid;
    }

    public void setAgentUuid(String r1) {
        this.agentUuid = r1;
    }

    public String getAgentHash() {
        return this.agentHash;
    }

    public void setAgentHash(String r1) {
        this.agentHash = r1;
    }

    public RobotDeviceStatus getDeviceStatus() {
        return this.deviceStatus;
    }

    public void setDeviceStatus(RobotDeviceStatus r1) {
        this.deviceStatus = r1;
    }

    public byte[] getDeviceStatusBytes() {
        return this.deviceStatusBytes;
    }

    public void setDeviceStatusBytes(byte[] r1) {
        this.deviceStatusBytes = r1;
    }

    public List<String> getCertificateChain() {
        return this.certificateChain;
    }

    public void setCertificateChain(List<String> r3) {
        this.certificateChain = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public byte[] getSignature() {
        return this.signature;
    }

    public void setSignature(byte[] r1) {
        this.signature = r1;
    }
}
