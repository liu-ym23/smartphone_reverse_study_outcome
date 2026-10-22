package com.amap.api.services.geocoder;

/* JADX INFO: loaded from: classes28.dex */
public class GeocodeQuery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28916c;

    public int hashCode() {
        String r100 = this.f28915b;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 31) * 31;
        String r104 = this.f28914a;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String getCity() {
        return this.f28915b;
    }

    public String getCountry() {
        return this.f28916c;
    }

    public String getLocationName() {
        return this.f28914a;
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
        GeocodeQuery r101 = (GeocodeQuery) r100;
        String r102 = this.f28915b;
        if (r102 != null) goto L17;
        if (r101.f28915b == null) goto L19;
        return false;
    L19:
        String r103 = this.f28914a;
        if (r103 != null) goto L25;
        if (r101.f28914a == null) goto L27;
        return false;
    L27:
        return true;
    L25:
        if (r103.equals(r101.f28914a) == true) goto L27;
        return false;
    L17:
        if (r102.equals(r101.f28915b) == true) goto L19;
        return false;
    }

    public void setCity(String r100) {
        this.f28915b = r100;
    }

    public void setCountry(String r100) {
        this.f28916c = r100;
    }

    public void setLocationName(String r100) {
        this.f28914a = r100;
    }

    public GeocodeQuery(String r100, String r101) {
        this.f28914a = r100;
        this.f28915b = r101;
    }
}
