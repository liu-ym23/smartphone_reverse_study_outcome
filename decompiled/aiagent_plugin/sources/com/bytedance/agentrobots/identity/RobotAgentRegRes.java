package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class RobotAgentRegRes implements Parcelable {
    public static final Parcelable.Creator<RobotAgentRegRes> CREATOR = null;
    private RobotAgent agent;
    private RobotAgentProof agentProof;
    private RobotDeviceStatus deviceStatus;
    private int result;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RobotAgentRegRes() {
    }

    public RobotAgentRegRes(int r1, RobotAgent r2, RobotAgentProof r3, RobotDeviceStatus r4) {
        this.result = r1;
        this.agent = r2;
        this.agentProof = r3;
        this.deviceStatus = r4;
    }

    public RobotAgentRegRes(Parcel r4) {
        this.result = r4.readInt();
        this.agent = (RobotAgent) ZeusTransformUtils.preCheckCast(r4.readParcelable(RobotAgent.class.getClassLoader()), RobotAgent.class, "com.obric.aiagent.plugin");
        this.agentProof = (RobotAgentProof) ZeusTransformUtils.preCheckCast(r4.readParcelable(RobotAgentProof.class.getClassLoader()), RobotAgentProof.class, "com.obric.aiagent.plugin");
        this.deviceStatus = (RobotDeviceStatus) ZeusTransformUtils.preCheckCast(r4.readParcelable(RobotDeviceStatus.class.getClassLoader()), RobotDeviceStatus.class, "com.obric.aiagent.plugin");
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(this.result);
        r2.writeParcelable(this.agent, r3);
        r2.writeParcelable(this.agentProof, r3);
        r2.writeParcelable(this.deviceStatus, r3);
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int r1) {
        this.result = r1;
    }

    public RobotAgent getAgent() {
        return this.agent;
    }

    public void setAgent(RobotAgent r1) {
        this.agent = r1;
    }

    public RobotAgentProof getAgentProof() {
        return this.agentProof;
    }

    public void setAgentProof(RobotAgentProof r1) {
        this.agentProof = r1;
    }

    public RobotDeviceStatus getDeviceStatus() {
        return this.deviceStatus;
    }

    public void setDeviceStatus(RobotDeviceStatus r1) {
        this.deviceStatus = r1;
    }
}
