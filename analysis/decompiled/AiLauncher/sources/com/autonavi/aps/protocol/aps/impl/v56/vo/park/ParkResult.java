package com.autonavi.aps.protocol.aps.impl.v56.vo.park;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class ParkResult implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private int f18705a;

    /* renamed from: b, reason: collision with root package name */
    private List<ParkInfo> f18706b;

    public ParkResult(int i10, List<ParkInfo> list) {
        this.f18705a = i10;
        this.f18706b = list;
    }

    public int getConfidence() {
        return this.f18705a;
    }

    public List<ParkInfo> getParkList() {
        return this.f18706b;
    }

    public void setConfidence(int i10) {
        this.f18705a = i10;
    }

    public void setParkList(List<ParkInfo> list) {
        this.f18706b = list;
    }

    public ParkResult() {
    }
}
