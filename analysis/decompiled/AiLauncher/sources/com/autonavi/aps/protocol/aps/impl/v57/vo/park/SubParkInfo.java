package com.autonavi.aps.protocol.aps.impl.v57.vo.park;

import java.io.Serializable;

/* loaded from: classes.dex */
public class SubParkInfo implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f18873a;

    /* renamed from: b, reason: collision with root package name */
    private int f18874b;

    /* renamed from: c, reason: collision with root package name */
    private int f18875c;

    /* renamed from: d, reason: collision with root package name */
    private int f18876d;

    public String getId() {
        return this.f18873a;
    }

    public int getLat() {
        return this.f18875c;
    }

    public int getLng() {
        return this.f18874b;
    }

    public int getWeight() {
        return this.f18876d;
    }

    public void setId(String str) {
        this.f18873a = str;
    }

    public void setLat(int i10) {
        this.f18875c = i10;
    }

    public void setLng(int i10) {
        this.f18874b = i10;
    }

    public void setWeight(int i10) {
        this.f18876d = i10;
    }
}
