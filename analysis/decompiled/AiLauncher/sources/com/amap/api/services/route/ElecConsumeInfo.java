package com.amap.api.services.route;

import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ElecConsumeInfo {

    /* renamed from: a, reason: collision with root package name */
    private int f17750a;

    /* renamed from: b, reason: collision with root package name */
    private int f17751b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f17752c;

    /* renamed from: d, reason: collision with root package name */
    private List<Integer> f17753d = new ArrayList();

    public int getConsumeEnergy() {
        return this.f17750a;
    }

    public List<Integer> getLeftEnergy() {
        return this.f17753d;
    }

    public LatLonPoint getRunOutPoint() {
        return this.f17752c;
    }

    public int getRunOutStepIndex() {
        return this.f17751b;
    }

    public void setConsumeEnergy(int i10) {
        this.f17750a = i10;
    }

    public void setLeftEnergy(List<Integer> list) {
        this.f17753d = list;
    }

    public void setRunOutPoint(LatLonPoint latLonPoint) {
        this.f17752c = latLonPoint;
    }

    public void setRunOutStepIndex(int i10) {
        this.f17751b = i10;
    }
}
