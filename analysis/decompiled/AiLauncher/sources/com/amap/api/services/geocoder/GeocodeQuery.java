package com.amap.api.services.geocoder;

/* loaded from: classes.dex */
public class GeocodeQuery {

    /* renamed from: a, reason: collision with root package name */
    private String f17438a;

    /* renamed from: b, reason: collision with root package name */
    private String f17439b;

    /* renamed from: c, reason: collision with root package name */
    private String f17440c;

    public GeocodeQuery(String str, String str2) {
        this.f17438a = str;
        this.f17439b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
        String str = this.f17439b;
        if (str == null) {
            if (geocodeQuery.f17439b != null) {
                return false;
            }
        } else if (!str.equals(geocodeQuery.f17439b)) {
            return false;
        }
        String str2 = this.f17438a;
        if (str2 == null) {
            if (geocodeQuery.f17438a != null) {
                return false;
            }
        } else if (!str2.equals(geocodeQuery.f17438a)) {
            return false;
        }
        return true;
    }

    public String getCity() {
        return this.f17439b;
    }

    public String getCountry() {
        return this.f17440c;
    }

    public String getLocationName() {
        return this.f17438a;
    }

    public int hashCode() {
        String str = this.f17439b;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f17438a;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.f17439b = str;
    }

    public void setCountry(String str) {
        this.f17440c = str;
    }

    public void setLocationName(String str) {
        this.f17438a = str;
    }
}
