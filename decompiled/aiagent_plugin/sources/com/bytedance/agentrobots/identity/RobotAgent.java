package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RobotAgent implements Parcelable {
    public static final Parcelable.Creator<RobotAgent> CREATOR = null;
    private String agentName;
    private b agentType;
    private String agentUuid;
    private String challenge;
    private String packageName;
    private long registeredAt;
    private List<String> requestedPermissions;
    private String signatureHash;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RobotAgent() {
    }

    public RobotAgent(String r3, b r4, String r5, String r6, String r7, String r8, List<String> r9, long r10) {
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        this.agentName = r3;
        this.agentType = r4;
        this.agentUuid = r5;
        this.challenge = r6;
        this.packageName = r7;
        this.signatureHash = r8;
        this.requestedPermissions = r11;
        this.registeredAt = r10;
    }

    public RobotAgent(Parcel r3) {
        this.agentName = r3.readString();
        String r0 = r3.readString();
        if (r0 == null) goto L5;
        b r1 = b.valueOf(r0);
    L6:
        this.agentType = r1;
        this.agentUuid = r3.readString();
        this.challenge = r3.readString();
        this.packageName = r3.readString();
        this.signatureHash = r3.readString();
        this.requestedPermissions = r3.createStringArrayList();
        this.registeredAt = r3.readLong();
        return;
    L5:
        r1 = null;
        goto L6
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.agentName);
        b r5 = this.agentType;
        if (r5 == null) goto L5;
        String r6 = r5.name();
    L6:
        r3.writeString(r6);
        r3.writeString(this.agentUuid);
        r3.writeString(this.challenge);
        r3.writeString(this.packageName);
        r3.writeString(this.signatureHash);
        r3.writeStringList(this.requestedPermissions);
        r3.writeLong(this.registeredAt);
        return;
    L5:
        r6 = null;
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

    public String getAgentUuid() {
        return this.agentUuid;
    }

    public void setAgentUuid(String r1) {
        this.agentUuid = r1;
    }

    public String getChallenge() {
        return this.challenge;
    }

    public void setChallenge(String r1) {
        this.challenge = r1;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String r1) {
        this.packageName = r1;
    }

    public String getSignatureHash() {
        return this.signatureHash;
    }

    public void setSignatureHash(String r1) {
        this.signatureHash = r1;
    }

    public List<String> getRequestedPermissions() {
        return this.requestedPermissions;
    }

    public void setRequestedPermissions(List<String> r3) {
        this.requestedPermissions = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public long getRegisteredAt() {
        return this.registeredAt;
    }

    public void setRegisteredAt(long r1) {
        this.registeredAt = r1;
    }
}
