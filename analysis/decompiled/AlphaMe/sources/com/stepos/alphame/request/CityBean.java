package com.stepos.alphame.request;

import B0.g;
import com.stepos.alphame.NotProguard;

@NotProguard
/* loaded from: classes.dex */
public class CityBean {
    private String city;
    private String country;
    private String province;

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getProvince() {
        return this.province;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CityBean{country='");
        sb.append(this.country);
        sb.append("', province='");
        sb.append(this.province);
        sb.append("', city=");
        return g.q(sb, this.city, '}');
    }
}
