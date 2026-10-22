package com.autonavi.aps.protocol.aps.impl.v56.vo.park;

import java.io.Serializable;

/* loaded from: classes.dex */
public class SubParkInfo implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f18707a;

    /* renamed from: b, reason: collision with root package name */
    private int f18708b;

    /* renamed from: c, reason: collision with root package name */
    private int f18709c;

    /* renamed from: d, reason: collision with root package name */
    private int f18710d;

    public String getId() {
        return this.f18707a;
    }

    public int getLat() {
        return this.f18709c;
    }

    public int getLng() {
        return this.f18708b;
    }

    public int getWeight() {
        return this.f18710d;
    }

    public void setId(String str) {
        this.f18707a = str;
    }

    public void setLat(int i10) {
        this.f18709c = i10;
    }

    public void setLng(int i10) {
        this.f18708b = i10;
    }

    public void setWeight(int i10) {
        this.f18710d = i10;
    }
}
