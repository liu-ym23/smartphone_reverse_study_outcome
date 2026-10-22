package com.autonavi.aps.protocol.aps.impl.v57.vo.park;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class ParkResult implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private int f18871a;

    /* renamed from: b, reason: collision with root package name */
    private List<ParkInfo> f18872b;

    public ParkResult(int i10, List<ParkInfo> list) {
        this.f18871a = i10;
        this.f18872b = list;
    }

    public int getConfidence() {
        return this.f18871a;
    }

    public List<ParkInfo> getParkList() {
        return this.f18872b;
    }

    public void setConfidence(int i10) {
        this.f18871a = i10;
    }

    public void setParkList(List<ParkInfo> list) {
        this.f18872b = list;
    }

    public ParkResult() {
    }
}
