package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.jmsl.C1631z1;
import com.amap.api.col.jmsl.V2;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class PoiSearch {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";

    /* renamed from: a, reason: collision with root package name */
    private IPoiSearch f17548a;

    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItem poiItem, int i10);

        void onPoiSearched(PoiResult poiResult, int i10);
    }

    public static class Query implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private String f17549a;

        /* renamed from: b, reason: collision with root package name */
        private String f17550b;

        /* renamed from: c, reason: collision with root package name */
        private String f17551c;

        /* renamed from: d, reason: collision with root package name */
        private int f17552d;

        /* renamed from: e, reason: collision with root package name */
        private int f17553e;

        /* renamed from: f, reason: collision with root package name */
        private String f17554f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f17555g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f17556h;

        /* renamed from: i, reason: collision with root package name */
        private String f17557i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f17558j;

        /* renamed from: k, reason: collision with root package name */
        private LatLonPoint f17559k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f17560l;

        /* renamed from: m, reason: collision with root package name */
        private Map<String, String> f17561m;

        /* renamed from: n, reason: collision with root package name */
        private String f17562n;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Query query = (Query) obj;
            if (this.f17552d == query.f17552d && this.f17553e == query.f17553e && this.f17555g == query.f17555g && this.f17556h == query.f17556h && this.f17558j == query.f17558j && this.f17560l == query.f17560l && Objects.equals(this.f17549a, query.f17549a) && Objects.equals(this.f17550b, query.f17550b) && Objects.equals(this.f17551c, query.f17551c) && Objects.equals(this.f17554f, query.f17554f) && Objects.equals(this.f17557i, query.f17557i) && Objects.equals(this.f17559k, query.f17559k) && Objects.equals(this.f17561m, query.f17561m)) {
                return Objects.equals(this.f17562n, query.f17562n);
            }
            return false;
        }

        public String getBuilding() {
            return this.f17557i;
        }

        public String getCategory() {
            String str = this.f17550b;
            return (str == null || str.equals("00") || this.f17550b.equals("00|")) ? "" : this.f17550b;
        }

        public String getCity() {
            return this.f17551c;
        }

        public boolean getCityLimit() {
            return this.f17555g;
        }

        public Map<String, String> getCustomParams() {
            return this.f17561m;
        }

        public String getExtensions() {
            return this.f17562n;
        }

        public LatLonPoint getLocation() {
            return this.f17559k;
        }

        public int getPageNum() {
            return this.f17552d;
        }

        public int getPageSize() {
            return this.f17553e;
        }

        public String getQueryLanguage() {
            return this.f17554f;
        }

        public String getQueryString() {
            return this.f17549a;
        }

        public int hashCode() {
            String str = this.f17549a;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f17550b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f17551c;
            int iHashCode3 = (((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f17552d) * 31) + this.f17553e) * 31;
            String str4 = this.f17554f;
            int iHashCode4 = (((((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + (this.f17555g ? 1 : 0)) * 31) + (this.f17556h ? 1 : 0)) * 31;
            String str5 = this.f17557i;
            int iHashCode5 = (((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + (this.f17558j ? 1 : 0)) * 31;
            LatLonPoint latLonPoint = this.f17559k;
            int iHashCode6 = (((iHashCode5 + (latLonPoint != null ? latLonPoint.hashCode() : 0)) * 31) + (this.f17560l ? 1 : 0)) * 31;
            Map<String, String> map = this.f17561m;
            int iHashCode7 = (iHashCode6 + (map != null ? map.hashCode() : 0)) * 31;
            String str6 = this.f17562n;
            return iHashCode7 + (str6 != null ? str6.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f17558j;
        }

        public boolean isRequireSubPois() {
            return this.f17556h;
        }

        public boolean isSpecial() {
            return this.f17560l;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearch.a(query.f17549a, this.f17549a) && PoiSearch.a(query.f17550b, this.f17550b) && PoiSearch.a(query.f17554f, this.f17554f) && PoiSearch.a(query.f17551c, this.f17551c) && PoiSearch.a(query.f17562n, this.f17562n) && PoiSearch.a(query.f17557i, this.f17557i) && query.f17555g == this.f17555g && query.f17553e == this.f17553e && query.f17558j == this.f17558j && query.f17561m.equals(this.f17561m) && query.f17560l == this.f17560l;
        }

        public void requireSubPois(boolean z10) {
            this.f17556h = z10;
        }

        public void setBuilding(String str) {
            this.f17557i = str;
        }

        public void setCityLimit(boolean z10) {
            this.f17555g = z10;
        }

        public void setCustomParams(Map<String, String> map) {
            if (map != null) {
                this.f17561m.putAll(map);
            }
        }

        public void setDistanceSort(boolean z10) {
            this.f17558j = z10;
        }

        public void setExtensions(String str) {
            this.f17562n = str;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f17559k = latLonPoint;
        }

        public void setPageNum(int i10) {
            if (i10 < 1) {
                i10 = 1;
            }
            this.f17552d = i10;
        }

        public void setPageSize(int i10) {
            if (i10 <= 0) {
                this.f17553e = 20;
            } else if (i10 > 30) {
                this.f17553e = 30;
            } else {
                this.f17553e = i10;
            }
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f17554f = "en";
            } else {
                this.f17554f = "zh-CN";
            }
        }

        public void setSpecial(boolean z10) {
            this.f17560l = z10;
        }

        public Query(String str, String str2, String str3) {
            this.f17552d = 1;
            this.f17553e = 20;
            this.f17554f = "zh-CN";
            this.f17555g = false;
            this.f17556h = false;
            this.f17558j = true;
            this.f17560l = true;
            this.f17561m = new HashMap();
            this.f17562n = "base";
            this.f17549a = str;
            this.f17550b = str2;
            this.f17551c = str3;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m24clone() throws CloneNotSupportedException {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f17549a, this.f17550b, this.f17551c);
            query.setPageNum(this.f17552d);
            query.setPageSize(this.f17553e);
            query.setQueryLanguage(this.f17554f);
            query.setCityLimit(this.f17555g);
            query.requireSubPois(this.f17556h);
            query.setBuilding(this.f17557i);
            query.setLocation(this.f17559k);
            query.setDistanceSort(this.f17558j);
            query.setSpecial(this.f17560l);
            query.setExtensions(this.f17562n);
            query.setCustomParams(this.f17561m);
            return query;
        }
    }

    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f17563a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f17564b;

        /* renamed from: c, reason: collision with root package name */
        private int f17565c;

        /* renamed from: d, reason: collision with root package name */
        private LatLonPoint f17566d;

        /* renamed from: e, reason: collision with root package name */
        private String f17567e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f17568f;

        /* renamed from: g, reason: collision with root package name */
        private List<LatLonPoint> f17569g;

        public SearchBound(LatLonPoint latLonPoint, int i10) {
            this.f17568f = true;
            this.f17567e = "Bound";
            this.f17565c = i10;
            this.f17566d = latLonPoint;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f17563a = latLonPoint;
            this.f17564b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.f17564b.getLatitude() || this.f17563a.getLongitude() >= this.f17564b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.f17566d = new LatLonPoint((this.f17563a.getLatitude() + this.f17564b.getLatitude()) / 2.0d, (this.f17563a.getLongitude() + this.f17564b.getLongitude()) / 2.0d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            LatLonPoint latLonPoint = this.f17566d;
            if (latLonPoint == null) {
                if (searchBound.f17566d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(searchBound.f17566d)) {
                return false;
            }
            if (this.f17568f != searchBound.f17568f) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f17563a;
            if (latLonPoint2 == null) {
                if (searchBound.f17563a != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(searchBound.f17563a)) {
                return false;
            }
            LatLonPoint latLonPoint3 = this.f17564b;
            if (latLonPoint3 == null) {
                if (searchBound.f17564b != null) {
                    return false;
                }
            } else if (!latLonPoint3.equals(searchBound.f17564b)) {
                return false;
            }
            List<LatLonPoint> list = this.f17569g;
            if (list == null) {
                if (searchBound.f17569g != null) {
                    return false;
                }
            } else if (!list.equals(searchBound.f17569g)) {
                return false;
            }
            if (this.f17565c != searchBound.f17565c) {
                return false;
            }
            String str = this.f17567e;
            if (str == null) {
                if (searchBound.f17567e != null) {
                    return false;
                }
            } else if (!str.equals(searchBound.f17567e)) {
                return false;
            }
            return true;
        }

        public LatLonPoint getCenter() {
            return this.f17566d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f17563a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f17569g;
        }

        public int getRange() {
            return this.f17565c;
        }

        public String getShape() {
            return this.f17567e;
        }

        public LatLonPoint getUpperRight() {
            return this.f17564b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f17566d;
            int iHashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f17568f ? 1231 : 1237)) * 31;
            LatLonPoint latLonPoint2 = this.f17563a;
            int iHashCode2 = (iHashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f17564b;
            int iHashCode3 = (iHashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f17569g;
            int iHashCode4 = (((iHashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f17565c) * 31;
            String str = this.f17567e;
            return iHashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f17568f;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m25clone() throws CloneNotSupportedException {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f17563a, this.f17564b, this.f17565c, this.f17566d, this.f17567e, this.f17569g, this.f17568f);
        }

        public SearchBound(LatLonPoint latLonPoint, int i10, boolean z10) {
            this.f17567e = "Bound";
            this.f17565c = i10;
            this.f17566d = latLonPoint;
            this.f17568f = z10;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f17565c = 1500;
            this.f17568f = true;
            this.f17567e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f17565c = 1500;
            this.f17568f = true;
            this.f17567e = "Polygon";
            this.f17569g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i10, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z10) {
            this.f17563a = latLonPoint;
            this.f17564b = latLonPoint2;
            this.f17565c = i10;
            this.f17566d = latLonPoint3;
            this.f17567e = str;
            this.f17569g = list;
            this.f17568f = z10;
        }
    }

    public PoiSearch(Context context, Query query) throws AMapException {
        this.f17548a = null;
        try {
            this.f17548a = new V2(context, query);
        } catch (Exception e10) {
            e10.printStackTrace();
            if (e10 instanceof AMapException) {
                throw ((AMapException) e10);
            }
        }
    }

    public static boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public SearchBound getBound() {
        IPoiSearch iPoiSearch = this.f17548a;
        if (iPoiSearch != null) {
            return iPoiSearch.getBound();
        }
        return null;
    }

    public String getLanguage() {
        IPoiSearch iPoiSearch = this.f17548a;
        if (iPoiSearch != null) {
            return iPoiSearch.getLanguage();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearch iPoiSearch = this.f17548a;
        if (iPoiSearch != null) {
            return iPoiSearch.getQuery();
        }
        return null;
    }

    public PoiResult searchPOI() throws AMapException {
        IPoiSearch iPoiSearch = this.f17548a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearch iPoiSearch = this.f17548a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIAsyn();
        }
    }

    public PoiItem searchPOIId(String str) throws AMapException {
        IPoiSearch iPoiSearch = this.f17548a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearch iPoiSearch = this.f17548a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearch iPoiSearch = this.f17548a;
        if (iPoiSearch != null) {
            iPoiSearch.setBound(searchBound);
        }
    }

    public void setLanguage(String str) {
        IPoiSearch iPoiSearch = this.f17548a;
        if (iPoiSearch != null) {
            iPoiSearch.setLanguage(str);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearch iPoiSearch = this.f17548a;
        if (iPoiSearch != null) {
            iPoiSearch.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearch iPoiSearch = this.f17548a;
        if (iPoiSearch != null) {
            iPoiSearch.setQuery(query);
        }
    }
}
