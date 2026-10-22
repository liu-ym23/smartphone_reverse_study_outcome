package com.autonavi.aps.protocol.aps.impl.v56.vo.park;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class ParkInfo implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f18699a;

    /* renamed from: b, reason: collision with root package name */
    private int f18700b;

    /* renamed from: c, reason: collision with root package name */
    private int f18701c;

    /* renamed from: d, reason: collision with root package name */
    private int f18702d;

    /* renamed from: e, reason: collision with root package name */
    private String f18703e;

    /* renamed from: f, reason: collision with root package name */
    private List<SubParkInfo> f18704f;

    public String getId() {
        return this.f18699a;
    }

    public int getLat() {
        return this.f18701c;
    }

    public int getLng() {
        return this.f18700b;
    }

    public List<SubParkInfo> getSubParks() {
        return this.f18704f;
    }

    public String getType() {
        return this.f18703e;
    }

    public int getWeight() {
        return this.f18702d;
    }

    public void setId(String str) {
        this.f18699a = str;
    }

    public void setLat(int i10) {
        this.f18701c = i10;
    }

    public void setLng(int i10) {
        this.f18700b = i10;
    }

    public void setSubParks(List<SubParkInfo> list) {
        this.f18704f = list;
    }

    public void setType(String str) {
        this.f18703e = str;
    }

    public void setWeight(int i10) {
        this.f18702d = i10;
    }
}
