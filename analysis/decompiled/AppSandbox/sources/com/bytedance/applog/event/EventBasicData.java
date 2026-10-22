package com.bytedance.applog.event;

import com.bytedance.bdtracker.a;
import com.bytedance.bdtracker.e4;

/* loaded from: classes.dex */
public class EventBasicData {
    public final String abSdkVersion;
    public final long eventCreateTime;
    public final long eventIndex;
    public final String sessionId;
    public final String ssid;
    public final String uuid;
    public final String uuidType;

    public EventBasicData(e4 e4Var) {
        this.eventIndex = e4Var.d;
        this.eventCreateTime = e4Var.c;
        this.sessionId = e4Var.e;
        this.uuid = e4Var.g;
        this.uuidType = e4Var.h;
        this.ssid = e4Var.i;
        this.abSdkVersion = e4Var.j;
    }

    public String getAbSdkVersion() {
        return this.abSdkVersion;
    }

    public long getEventCreateTime() {
        return this.eventCreateTime;
    }

    public long getEventIndex() {
        return this.eventIndex;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSsid() {
        return this.ssid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getUuidType() {
        return this.uuidType;
    }

    public String toString() {
        StringBuilder sbA = a.a("EventBasisData{eventIndex=");
        sbA.append(this.eventIndex);
        sbA.append(", eventCreateTime=");
        sbA.append(this.eventCreateTime);
        sbA.append(", sessionId='");
        sbA.append(this.sessionId);
        sbA.append('\'');
        sbA.append(", uuid='");
        sbA.append(this.uuid);
        sbA.append('\'');
        sbA.append(", uuidType='");
        sbA.append(this.uuidType);
        sbA.append('\'');
        sbA.append(", ssid='");
        sbA.append(this.ssid);
        sbA.append('\'');
        sbA.append(", abSdkVersion='");
        sbA.append(this.abSdkVersion);
        sbA.append('\'');
        sbA.append('}');
        return sbA.toString();
    }
}
