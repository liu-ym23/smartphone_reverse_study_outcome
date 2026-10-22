package com.amap.api.services.busline;

import com.amap.api.col.jmsl.C1631z1;

/* loaded from: classes.dex */
public class BusStationQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f17293a;

    /* renamed from: b, reason: collision with root package name */
    private String f17294b;

    /* renamed from: c, reason: collision with root package name */
    private int f17295c = 20;

    /* renamed from: d, reason: collision with root package name */
    private int f17296d = 1;

    public BusStationQuery(String str, String str2) {
        this.f17293a = str;
        this.f17294b = str2;
        if (a()) {
            return;
        }
        new IllegalArgumentException("Empty query").printStackTrace();
    }

    private boolean a() {
        return !C1631z1.p(this.f17293a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusStationQuery busStationQuery = (BusStationQuery) obj;
        String str = this.f17294b;
        if (str == null) {
            if (busStationQuery.f17294b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.f17294b)) {
            return false;
        }
        if (this.f17296d != busStationQuery.f17296d || this.f17295c != busStationQuery.f17295c) {
            return false;
        }
        String str2 = this.f17293a;
        if (str2 == null) {
            if (busStationQuery.f17293a != null) {
                return false;
            }
        } else if (!str2.equals(busStationQuery.f17293a)) {
            return false;
        }
        return true;
    }

    public String getCity() {
        return this.f17294b;
    }

    public int getPageNumber() {
        return this.f17296d;
    }

    public int getPageSize() {
        return this.f17295c;
    }

    public String getQueryString() {
        return this.f17293a;
    }

    public int hashCode() {
        String str = this.f17294b;
        int iHashCode = ((((((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f17296d) * 31) + this.f17295c) * 31;
        String str2 = this.f17293a;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.f17294b = str;
    }

    public void setPageNumber(int i10) {
        if (i10 < 1) {
            i10 = 1;
        }
        this.f17296d = i10;
    }

    public void setPageSize(int i10) {
        this.f17295c = i10;
    }

    public void setQueryString(String str) {
        this.f17293a = str;
    }

    public boolean weakEquals(BusStationQuery busStationQuery) {
        if (this == busStationQuery) {
            return true;
        }
        if (busStationQuery == null) {
            return false;
        }
        String str = this.f17294b;
        if (str == null) {
            if (busStationQuery.f17294b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.f17294b)) {
            return false;
        }
        if (this.f17295c != busStationQuery.f17295c) {
            return false;
        }
        String str2 = this.f17293a;
        if (str2 == null) {
            if (busStationQuery.f17293a != null) {
                return false;
            }
        } else if (!str2.equals(busStationQuery.f17293a)) {
            return false;
        }
        return true;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BusStationQuery m20clone() {
        BusStationQuery busStationQuery = new BusStationQuery(this.f17293a, this.f17294b);
        busStationQuery.setPageNumber(this.f17296d);
        busStationQuery.setPageSize(this.f17295c);
        return busStationQuery;
    }
}
