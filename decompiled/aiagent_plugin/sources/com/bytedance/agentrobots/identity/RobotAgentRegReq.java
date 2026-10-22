package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RobotAgentRegReq implements Parcelable {
    public static final Parcelable.Creator<RobotAgentRegReq> CREATOR = null;
    private String agentName;
    private b agentType;
    private String challenge;
    private List<String> requestedPermissions;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RobotAgentRegReq() {
    }

    public RobotAgentRegReq(String r3, b r4, List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.agentName = r3;
        this.agentType = r4;
        this.requestedPermissions = r6;
    }

    public RobotAgentRegReq(Parcel r3) {
        this.agentName = r3.readString();
        int r0 = r3.readInt();
        if (r0 != (-1)) goto L5;
        b r1 = null;
    L6:
        this.agentType = r1;
        this.challenge = r3.readString();
        this.requestedPermissions = r3.createStringArrayList();
        return;
    L5:
        r1 = b.values()[r0];
        goto L6
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.agentName);
        b r3 = this.agentType;
        if (r3 == null) goto L5;
        int r4 = r3.ordinal();
    L6:
        r1.writeInt(r4);
        r1.writeString(this.challenge);
        r1.writeStringList(this.requestedPermissions);
        return;
    L5:
        r4 = -1;
        goto L6
    }

    public String getAgentName() {
        return this.agentName;
    }

    public void setAgentName(String r1) {
        this.agentName = r1;
    }

    public b getAgentType() {
        return this.agentType;
    }

    public void setAgentType(b r1) {
        this.agentType = r1;
    }

    public String getChallenge() {
        return this.challenge;
    }

    public void setChallenge(String r1) {
        this.challenge = r1;
    }

    public List<String> getRequestedPermissions() {
        return this.requestedPermissions;
    }

    public void setRequestedPermissions(List<String> r3) {
        this.requestedPermissions = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }
}
