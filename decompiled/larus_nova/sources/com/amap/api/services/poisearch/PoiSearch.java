package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.s.bc;
import com.amap.api.col.s.i;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class PoiSearch {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IPoiSearch f29003a;

    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItem r100, int r101);

        void onPoiSearched(PoiResult r100, int r101);
    }

    public static class Query implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f29004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f29005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f29006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f29007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f29008e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f29009f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f29010g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f29011h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f29012i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f29013j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private LatLonPoint f29014k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f29015l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f29016m;

        public String getCategory() {
            String r100 = this.f29005b;
            if (r100 != null) goto L5;
            return "";
        L5:
            if (r100.equals(CustomAlbumViewModel.DEFAULT_TAB_ID) == false) goto L7;
            return "";
        L7:
            if (this.f29005b.equals("00|") == false) goto L10;
            return "";
        L10:
            return this.f29005b;
        }

        public int hashCode() {
            String r100 = this.f29005b;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r102 + 31) * 31;
            String r104 = this.f29006c;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            int r107 = 1231;
            if (this.f29010g == false) goto L13;
            int r108 = 1231;
        L14:
            int r109 = (r106 + r108) * 31;
            if (this.f29011h == true) goto L18;
            r107 = 1237;
        L18:
            int r110 = (r109 + r107) * 31;
            String r111 = this.f29009f;
            if (r111 != null) goto L21;
            int r112 = 0;
        L22:
            int r113 = (((((r110 + r112) * 31) + this.f29007d) * 31) + this.f29008e) * 31;
            String r114 = this.f29004a;
            if (r114 != null) goto L25;
            int r115 = 0;
        L26:
            int r116 = (r113 + r115) * 31;
            String r117 = this.f29012i;
            if (r117 == null) goto L31;
            r101 = r117.hashCode();
        L31:
            return r116 + r101;
        L25:
            r115 = r114.hashCode();
            goto L26
        L21:
            r112 = r111.hashCode();
            goto L22
        L13:
            r108 = 1237;
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public Query clone() {
            super.clone();     // Catch: CloneNotSupportedException -> L4
        L6:
            Query r100 = new Query(this.f29004a, this.f29005b, this.f29006c);
            r100.setPageNum(this.f29007d);
            r100.setPageSize(this.f29008e);
            r100.setQueryLanguage(this.f29009f);
            r100.setCityLimit(this.f29010g);
            r100.requireSubPois(this.f29011h);
            r100.setBuilding(this.f29012i);
            r100.setLocation(this.f29014k);
            r100.setDistanceSort(this.f29013j);
            r100.setSpecial(this.f29015l);
            r100.setExtensions(this.f29016m);
            return r100;
        L4:
            e = move-exception;
            i.a(e, "PoiSearch", "queryclone");
            goto L6
        }

        public String getBuilding() {
            return this.f29012i;
        }

        public String getCity() {
            return this.f29006c;
        }

        public boolean getCityLimit() {
            return this.f29010g;
        }

        public String getExtensions() {
            return this.f29016m;
        }

        public LatLonPoint getLocation() {
            return this.f29014k;
        }

        public int getPageNum() {
            return this.f29007d;
        }

        public int getPageSize() {
            return this.f29008e;
        }

        public String getQueryLanguage() {
            return this.f29009f;
        }

        public String getQueryString() {
            return this.f29004a;
        }

        public boolean isDistanceSort() {
            return this.f29013j;
        }

        public boolean isRequireSubPois() {
            return this.f29011h;
        }

        public boolean isSpecial() {
            return this.f29015l;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8037clone() throws CloneNotSupportedException {
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
            Query r101 = (Query) r100;
            String r102 = this.f29005b;
            if (r102 != null) goto L17;
            if (r101.f29005b == null) goto L19;
            return false;
        L19:
            String r103 = this.f29006c;
            if (r103 != null) goto L25;
            if (r101.f29006c == null) goto L27;
            return false;
        L27:
            String r104 = this.f29009f;
            if (r104 != null) goto L33;
            if (r101.f29009f == null) goto L36;
            return false;
        L36:
            if (this.f29007d == r101.f29007d) goto L39;
            return false;
        L39:
            if (this.f29008e == r101.f29008e) goto L41;
            return false;
        L41:
            String r105 = this.f29004a;
            if (r105 != null) goto L47;
            if (r101.f29004a == null) goto L49;
            return false;
        L49:
            String r106 = this.f29012i;
            if (r106 != null) goto L55;
            if (r101.f29012i == null) goto L58;
            return false;
        L58:
            if (this.f29010g == r101.f29010g) goto L61;
            return false;
        L61:
            if (this.f29011h == r101.f29011h) goto L64;
            return false;
        L64:
            if (this.f29015l == r101.f29015l) goto L66;
            return false;
        L66:
            String r107 = this.f29016m;
            if (r107 != null) goto L72;
            if (r101.f29016m == null) goto L74;
            return false;
        L74:
            return true;
        L72:
            if (r107.equals(r101.f29016m) == true) goto L74;
            return false;
        L55:
            if (r106.equals(r101.f29012i) == true) goto L58;
            return false;
        L47:
            if (r105.equals(r101.f29004a) == true) goto L49;
            return false;
        L33:
            if (r104.equals(r101.f29009f) == true) goto L36;
            return false;
        L25:
            if (r103.equals(r101.f29006c) == true) goto L27;
            return false;
        L17:
            if (r102.equals(r101.f29005b) == true) goto L19;
            return false;
        }

        public boolean queryEquals(Query r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (r100 != this) goto L9;
            return true;
        L9:
            if (PoiSearch.a(r100.f29004a, this.f29004a) == true) goto L11;
        L29:
            return false;
        L11:
            if (PoiSearch.a(r100.f29005b, this.f29005b) == false) goto L29;
            if (PoiSearch.a(r100.f29009f, this.f29009f) == false) goto L29;
            if (PoiSearch.a(r100.f29006c, this.f29006c) == false) goto L29;
            if (PoiSearch.a(r100.f29016m, this.f29016m) == false) goto L29;
            if (PoiSearch.a(r100.f29012i, this.f29012i) == false) goto L29;
            if (r100.f29010g != this.f29010g) goto L29;
            if (r100.f29008e != this.f29008e) goto L29;
            if (r100.f29013j != this.f29013j) goto L29;
            if (r100.f29015l != this.f29015l) goto L29;
            return true;
        }

        public void requireSubPois(boolean r100) {
            this.f29011h = r100;
        }

        public void setBuilding(String r100) {
            this.f29012i = r100;
        }

        public void setCityLimit(boolean r100) {
            this.f29010g = r100;
        }

        public void setDistanceSort(boolean r100) {
            this.f29013j = r100;
        }

        public void setExtensions(String r100) {
            this.f29016m = r100;
        }

        public void setLocation(LatLonPoint r100) {
            this.f29014k = r100;
        }

        public void setPageNum(int r100) {
            if (r100 > 0) goto L4;
            r100 = 1;
        L4:
            this.f29007d = r100;
        }

        public void setPageSize(int r100) {
            if (r100 > 0) goto L6;
            this.f29008e = 20;
            return;
        L6:
            if (r100 <= 30) goto L9;
            this.f29008e = 30;
            return;
        L9:
            this.f29008e = r100;
        }

        public void setQueryLanguage(String r100) {
            if ("en".equals(r100) == false) goto L6;
            this.f29009f = "en";
            return;
        L6:
            this.f29009f = "zh-CN";
        }

        public void setSpecial(boolean r100) {
            this.f29015l = r100;
        }

        public Query(String r100, String r101) {
            this(r100, r101, null);
        }

        public Query(String r100, String r101, String r102) {
            this.f29007d = 1;
            this.f29008e = 20;
            this.f29009f = "zh-CN";
            this.f29010g = false;
            this.f29011h = false;
            this.f29013j = true;
            this.f29015l = true;
            this.f29016m = "base";
            this.f29004a = r100;
            this.f29005b = r101;
            this.f29006c = r102;
        }
    }

    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LatLonPoint f29017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LatLonPoint f29018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f29019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private LatLonPoint f29020d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f29021e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f29022f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List<LatLonPoint> f29023g;

        public int hashCode() {
            LatLonPoint r100 = this.f29020d;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r102 + 31) * 31;
            if (this.f29022f == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            LatLonPoint r106 = this.f29017a;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r105 + r107) * 31;
            LatLonPoint r109 = this.f29018b;
            if (r109 != null) goto L17;
            int r110 = 0;
        L18:
            int r111 = (r108 + r110) * 31;
            List<LatLonPoint> r112 = this.f29023g;
            if (r112 != null) goto L21;
            int r113 = 0;
        L22:
            int r114 = (((r111 + r113) * 31) + this.f29019c) * 31;
            String r115 = this.f29021e;
            if (r115 == null) goto L27;
            r101 = r115.hashCode();
        L27:
            return r114 + r101;
        L21:
            r113 = r112.hashCode();
            goto L22
        L17:
            r110 = r109.hashCode();
            goto L18
        L13:
            r107 = r106.hashCode();
            goto L14
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public SearchBound clone() {
            super.clone();     // Catch: CloneNotSupportedException -> L4
        L7:
            return new SearchBound(this.f29017a, this.f29018b, this.f29019c, this.f29020d, this.f29021e, this.f29023g, this.f29022f);
        L4:
            e = move-exception;
            i.a(e, "PoiSearch", "SearchBoundClone");
            goto L7
        }

        public LatLonPoint getCenter() {
            return this.f29020d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f29017a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f29023g;
        }

        public int getRange() {
            return this.f29019c;
        }

        public String getShape() {
            return this.f29021e;
        }

        public LatLonPoint getUpperRight() {
            return this.f29018b;
        }

        public boolean isDistanceSort() {
            return this.f29022f;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8038clone() throws CloneNotSupportedException {
            return clone();
        }

        public SearchBound(List<LatLonPoint> r100) {
            this.f29019c = 1500;
            this.f29022f = true;
            this.f29021e = "Polygon";
            this.f29023g = r100;
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
            SearchBound r101 = (SearchBound) r100;
            LatLonPoint r102 = this.f29020d;
            if (r102 != null) goto L17;
            if (r101.f29020d == null) goto L20;
            return false;
        L20:
            if (this.f29022f == r101.f29022f) goto L22;
            return false;
        L22:
            LatLonPoint r103 = this.f29017a;
            if (r103 != null) goto L28;
            if (r101.f29017a == null) goto L30;
            return false;
        L30:
            LatLonPoint r104 = this.f29018b;
            if (r104 != null) goto L36;
            if (r101.f29018b == null) goto L38;
            return false;
        L38:
            List<LatLonPoint> r105 = this.f29023g;
            if (r105 != null) goto L44;
            if (r101.f29023g == null) goto L47;
            return false;
        L47:
            if (this.f29019c == r101.f29019c) goto L49;
            return false;
        L49:
            String r106 = this.f29021e;
            if (r106 != null) goto L55;
            if (r101.f29021e == null) goto L57;
            return false;
        L57:
            return true;
        L55:
            if (r106.equals(r101.f29021e) == true) goto L57;
            return false;
        L44:
            if (r105.equals(r101.f29023g) == true) goto L47;
            return false;
        L36:
            if (r104.equals(r101.f29018b) == true) goto L38;
            return false;
        L28:
            if (r103.equals(r101.f29017a) == true) goto L30;
            return false;
        L17:
            if (r102.equals(r101.f29020d) == true) goto L20;
            return false;
        }

        public SearchBound(LatLonPoint r100, LatLonPoint r110) {
            this.f29019c = 1500;
            this.f29022f = true;
            this.f29021e = "Rectangle";
            this.f29017a = r100;
            this.f29018b = r110;
            if (r100.getLatitude() < this.f29018b.getLatitude()) goto L5;
        L6:
            new IllegalArgumentException("invalid rect ").printStackTrace();
        L7:
            this.f29020d = new LatLonPoint((this.f29017a.getLatitude() + this.f29018b.getLatitude()) / 2.0d, (this.f29017a.getLongitude() + this.f29018b.getLongitude()) / 2.0d);
            return;
        L5:
            if (this.f29017a.getLongitude() < this.f29018b.getLongitude()) goto L7;
            goto L6
        }

        public SearchBound(LatLonPoint r100, int r101) {
            this.f29022f = true;
            this.f29021e = "Bound";
            this.f29019c = r101;
            this.f29020d = r100;
        }

        public SearchBound(LatLonPoint r100, int r101, boolean r102) {
            this.f29021e = "Bound";
            this.f29019c = r101;
            this.f29020d = r100;
            this.f29022f = r102;
        }

        private SearchBound(LatLonPoint r100, LatLonPoint r101, int r102, LatLonPoint r103, String r104, List<LatLonPoint> r105, boolean r106) {
            this.f29017a = r100;
            this.f29018b = r101;
            this.f29019c = r102;
            this.f29020d = r103;
            this.f29021e = r104;
            this.f29023g = r105;
            this.f29022f = r106;
        }
    }

    public SearchBound getBound() {
        IPoiSearch r100 = this.f29003a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getBound();
    }

    public String getLanguage() {
        IPoiSearch r100 = this.f29003a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getLanguage();
    }

    public Query getQuery() {
        IPoiSearch r100 = this.f29003a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getQuery();
    }

    public PoiResult searchPOI() throws AMapException {
        IPoiSearch r100 = this.f29003a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.searchPOI();
    }

    public void searchPOIAsyn() {
        IPoiSearch r100 = this.f29003a;
        if (r100 == null) goto L6;
        r100.searchPOIAsyn();
        return;
    }

    public PoiItem searchPOIId(String r100) throws AMapException {
        IPoiSearch r101 = this.f29003a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.searchPOIId(r100);
    }

    public void searchPOIIdAsyn(String r100) {
        IPoiSearch r101 = this.f29003a;
        if (r101 == null) goto L6;
        r101.searchPOIIdAsyn(r100);
        return;
    }

    public void setBound(SearchBound r100) {
        IPoiSearch r101 = this.f29003a;
        if (r101 == null) goto L6;
        r101.setBound(r100);
        return;
    }

    public void setLanguage(String r100) {
        IPoiSearch r101 = this.f29003a;
        if (r101 == null) goto L6;
        r101.setLanguage(r100);
        return;
    }

    public void setOnPoiSearchListener(OnPoiSearchListener r100) {
        IPoiSearch r101 = this.f29003a;
        if (r101 == null) goto L6;
        r101.setOnPoiSearchListener(r100);
        return;
    }

    public void setQuery(Query r100) {
        IPoiSearch r101 = this.f29003a;
        if (r101 == null) goto L6;
        r101.setQuery(r100);
        return;
    }

    public PoiSearch(Context r100, Query r101) {
        this.f29003a = null;
        this.f29003a = new bc(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ boolean a(String r100, String r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r100 == null) goto L10;
        if (r101 != null) goto L9;
        return false;
    L9:
        return r100.equals(r101);
    L10:
        return false;
    }
}
