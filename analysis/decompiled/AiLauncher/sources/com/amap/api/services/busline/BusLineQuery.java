package com.amap.api.services.busline;

/* loaded from: classes.dex */
public class BusLineQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f17272a;

    /* renamed from: b, reason: collision with root package name */
    private String f17273b;

    /* renamed from: e, reason: collision with root package name */
    private SearchType f17276e;

    /* renamed from: c, reason: collision with root package name */
    private int f17274c = 20;

    /* renamed from: d, reason: collision with root package name */
    private int f17275d = 1;

    /* renamed from: f, reason: collision with root package name */
    private String f17277f = "base";

    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.f17272a = str;
        this.f17276e = searchType;
        this.f17273b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusLineQuery busLineQuery = (BusLineQuery) obj;
        if (this.f17276e != busLineQuery.f17276e) {
            return false;
        }
        String str = this.f17273b;
        if (str == null) {
            if (busLineQuery.f17273b != null) {
                return false;
            }
        } else if (!str.equals(busLineQuery.f17273b)) {
            return false;
        }
        if (this.f17275d != busLineQuery.f17275d || this.f17274c != busLineQuery.f17274c) {
            return false;
        }
        String str2 = this.f17272a;
        if (str2 == null) {
            if (busLineQuery.f17272a != null) {
                return false;
            }
        } else if (!str2.equals(busLineQuery.f17272a)) {
            return false;
        }
        String str3 = this.f17277f;
        if (str3 == null) {
            if (busLineQuery.f17277f != null) {
                return false;
            }
        } else if (!str3.equals(busLineQuery.f17277f)) {
            return false;
        }
        return true;
    }

    public SearchType getCategory() {
        return this.f17276e;
    }

    public String getCity() {
        return this.f17273b;
    }

    public String getExtensions() {
        return this.f17277f;
    }

    public int getPageNumber() {
        return this.f17275d;
    }

    public int getPageSize() {
        return this.f17274c;
    }

    public String getQueryString() {
        return this.f17272a;
    }

    public int hashCode() {
        SearchType searchType = this.f17276e;
        int iHashCode = ((searchType == null ? 0 : searchType.hashCode()) + 31) * 31;
        String str = this.f17273b;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f17275d) * 31) + this.f17274c) * 31;
        String str2 = this.f17272a;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f17277f;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public void setCategory(SearchType searchType) {
        this.f17276e = searchType;
    }

    public void setCity(String str) {
        this.f17273b = str;
    }

    public void setExtensions(String str) {
        this.f17277f = str;
    }

    public void setPageNumber(int i10) {
        if (i10 < 1) {
            i10 = 1;
        }
        this.f17275d = i10;
    }

    public void setPageSize(int i10) {
        this.f17274c = i10;
    }

    public void setQueryString(String str) {
        this.f17272a = str;
    }

    public boolean weakEquals(BusLineQuery busLineQuery) {
        if (this == busLineQuery) {
            return true;
        }
        if (busLineQuery == null) {
            return false;
        }
        if (this.f17272a == null) {
            if (busLineQuery.getQueryString() != null) {
                return false;
            }
        } else if (!busLineQuery.getQueryString().equals(this.f17272a)) {
            return false;
        }
        if (this.f17273b == null) {
            if (busLineQuery.getCity() != null) {
                return false;
            }
        } else if (!busLineQuery.getCity().equals(this.f17273b)) {
            return false;
        }
        return this.f17274c == busLineQuery.getPageSize() && busLineQuery.getCategory().compareTo(this.f17276e) == 0;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BusLineQuery m19clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.f17272a, this.f17276e, this.f17273b);
        busLineQuery.setPageNumber(this.f17275d);
        busLineQuery.setPageSize(this.f17274c);
        busLineQuery.setExtensions(this.f17277f);
        return busLineQuery;
    }
}
