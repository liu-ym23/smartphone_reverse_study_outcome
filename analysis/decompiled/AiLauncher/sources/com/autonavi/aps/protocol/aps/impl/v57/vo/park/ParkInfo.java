package com.autonavi.aps.protocol.aps.impl.v57.vo.park;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class ParkInfo implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f18865a;

    /* renamed from: b, reason: collision with root package name */
    private int f18866b;

    /* renamed from: c, reason: collision with root package name */
    private int f18867c;

    /* renamed from: d, reason: collision with root package name */
    private int f18868d;

    /* renamed from: e, reason: collision with root package name */
    private String f18869e;

    /* renamed from: f, reason: collision with root package name */
    private List<SubParkInfo> f18870f;

    public String getId() {
        return this.f18865a;
    }

    public int getLat() {
        return this.f18867c;
    }

    public int getLng() {
        return this.f18866b;
    }

    public List<SubParkInfo> getSubParks() {
        return this.f18870f;
    }

    public String getType() {
        return this.f18869e;
    }

    public int getWeight() {
        return this.f18868d;
    }

    public void setId(String str) {
        this.f18865a = str;
    }

    public void setLat(int i10) {
        this.f18867c = i10;
    }

    public void setLng(int i10) {
        this.f18866b = i10;
    }

    public void setSubParks(List<SubParkInfo> list) {
        this.f18870f = list;
    }

    public void setType(String str) {
        this.f18869e = str;
    }

    public void setWeight(int i10) {
        this.f18868d = i10;
    }
}
