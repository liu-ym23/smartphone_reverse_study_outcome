package com.amap.api.services.busline;

import com.amap.api.col.s.i;

/* JADX INFO: loaded from: classes28.dex */
public class BusStationQuery implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f28790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28791d;

    public BusStationQuery clone() {
        BusStationQuery r100 = new BusStationQuery(this.f28788a, this.f28789b);
        r100.setPageNumber(this.f28791d);
        r100.setPageSize(this.f28790c);
        return r100;
    }

    public int hashCode() {
        String r100 = this.f28789b;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r102 + 31) * 31) + this.f28791d) * 31) + this.f28790c) * 31;
        String r104 = this.f28788a;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String getCity() {
        return this.f28789b;
    }

    public int getPageNumber() {
        return this.f28791d;
    }

    public int getPageSize() {
        return this.f28790c;
    }

    public String getQueryString() {
        return this.f28788a;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8033clone() throws CloneNotSupportedException {
        return clone();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        BusStationQuery r101 = (BusStationQuery) r100;
        String r102 = this.f28789b;
        if (r102 != null) goto L17;
        if (r101.f28789b == null) goto L20;
        return false;
    L20:
        if (this.f28791d == r101.f28791d) goto L23;
        return false;
    L23:
        if (this.f28790c == r101.f28790c) goto L25;
        return false;
    L25:
        String r103 = this.f28788a;
        if (r103 != null) goto L31;
        if (r101.f28788a == null) goto L33;
        return false;
    L33:
        return true;
    L31:
        if (r103.equals(r101.f28788a) == true) goto L33;
        return false;
    L17:
        if (r102.equals(r101.f28789b) == true) goto L20;
        return false;
    }

    public void setCity(String r100) {
        this.f28789b = r100;
    }

    public void setPageNumber(int r100) {
        if (r100 > 0) goto L4;
        r100 = 1;
    L4:
        this.f28791d = r100;
    }

    public void setPageSize(int r100) {
        this.f28790c = r100;
    }

    public void setQueryString(String r100) {
        this.f28788a = r100;
    }

    public boolean weakEquals(BusStationQuery r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        return false;
    L8:
        String r101 = this.f28789b;
        if (r101 != null) goto L14;
        if (r100.f28789b == null) goto L17;
        return false;
    L17:
        if (this.f28790c == r100.f28790c) goto L19;
        return false;
    L19:
        String r102 = this.f28788a;
        if (r102 != null) goto L25;
        if (r100.f28788a == null) goto L27;
        return false;
    L27:
        return true;
    L25:
        if (r102.equals(r100.f28788a) == true) goto L27;
        return false;
    L14:
        if (r101.equals(r100.f28789b) == true) goto L17;
        return false;
    }

    public BusStationQuery(String r100, String r101) {
        this.f28790c = 20;
        this.f28791d = 1;
        this.f28788a = r100;
        this.f28789b = r101;
        if ((!i.a(r100)) == true) goto L6;
        new IllegalArgumentException("Empty query").printStackTrace();
        return;
    }
}
