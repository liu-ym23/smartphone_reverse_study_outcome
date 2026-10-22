package com.amap.api.services.busline;

import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class BusLineQuery implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f28771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SearchType f28773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f28774f;

    public static final enum SearchType extends Enum<SearchType> {
        public static final SearchType BY_LINE_ID = null;
        public static final SearchType BY_LINE_NAME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ SearchType[] f28775a = null;

        static {
            SearchType r100 = new SearchType("BY_LINE_ID", 0);
            BY_LINE_ID = r100;
            SearchType r101 = new SearchType("BY_LINE_NAME", 1);
            BY_LINE_NAME = r101;
            f28775a = new SearchType[]{r100, r101};
        }

        public static SearchType[] values() {
            return (SearchType[]) f28775a.clone();
        }

        public static SearchType valueOf(String r100) {
            return (SearchType) a.a(SearchType.class, r100);
        }

        private SearchType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public BusLineQuery clone() {
        BusLineQuery r100 = new BusLineQuery(this.f28769a, this.f28773e, this.f28770b);
        r100.setPageNumber(this.f28772d);
        r100.setPageSize(this.f28771c);
        r100.setExtensions(this.f28774f);
        return r100;
    }

    public int hashCode() {
        SearchType r100 = this.f28773e;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 31) * 31;
        String r104 = this.f28770b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f28772d) * 31) + this.f28771c) * 31;
        String r107 = this.f28769a;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f28774f;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public SearchType getCategory() {
        return this.f28773e;
    }

    public String getCity() {
        return this.f28770b;
    }

    public String getExtensions() {
        return this.f28774f;
    }

    public int getPageNumber() {
        return this.f28772d;
    }

    public int getPageSize() {
        return this.f28771c;
    }

    public String getQueryString() {
        return this.f28769a;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8032clone() throws CloneNotSupportedException {
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
        BusLineQuery r101 = (BusLineQuery) r100;
        if (this.f28773e == r101.f28773e) goto L14;
        return false;
    L14:
        String r102 = this.f28770b;
        if (r102 != null) goto L20;
        if (r101.f28770b == null) goto L23;
        return false;
    L23:
        if (this.f28772d == r101.f28772d) goto L26;
        return false;
    L26:
        if (this.f28771c == r101.f28771c) goto L28;
        return false;
    L28:
        String r103 = this.f28769a;
        if (r103 != null) goto L34;
        if (r101.f28769a == null) goto L36;
        return false;
    L36:
        String r104 = this.f28774f;
        if (r104 != null) goto L42;
        if (r101.f28774f == null) goto L44;
        return false;
    L44:
        return true;
    L42:
        if (r104.equals(r101.f28774f) == true) goto L44;
        return false;
    L34:
        if (r103.equals(r101.f28769a) == true) goto L36;
        return false;
    L20:
        if (r102.equals(r101.f28770b) == true) goto L23;
        return false;
    }

    public void setCategory(SearchType r100) {
        this.f28773e = r100;
    }

    public void setCity(String r100) {
        this.f28770b = r100;
    }

    public void setExtensions(String r100) {
        this.f28774f = r100;
    }

    public void setPageNumber(int r100) {
        if (r100 > 0) goto L4;
        r100 = 1;
    L4:
        this.f28772d = r100;
    }

    public void setPageSize(int r100) {
        this.f28771c = r100;
    }

    public void setQueryString(String r100) {
        this.f28769a = r100;
    }

    public boolean weakEquals(BusLineQuery r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (this.f28769a != null) goto L14;
        if (r100.getQueryString() == null) goto L17;
        return false;
    L17:
        if (this.f28770b != null) goto L22;
        if (r100.getCity() == null) goto L25;
        return false;
    L25:
        if (this.f28771c == r100.getPageSize()) goto L28;
        return false;
    L28:
        if (r100.getCategory().compareTo(this.f28773e) == 0) goto L30;
        return false;
    L30:
        return true;
    L22:
        if (r100.getCity().equals(this.f28770b) == true) goto L25;
        return false;
    L14:
        if (r100.getQueryString().equals(this.f28769a) == true) goto L17;
        return false;
    }

    public BusLineQuery(String r100, SearchType r101, String r102) {
        this.f28771c = 20;
        this.f28772d = 1;
        this.f28774f = "base";
        this.f28769a = r100;
        this.f28773e = r101;
        this.f28770b = r102;
    }
}
