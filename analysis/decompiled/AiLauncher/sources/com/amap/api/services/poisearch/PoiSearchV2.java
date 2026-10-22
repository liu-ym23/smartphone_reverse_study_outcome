package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.jmsl.C1631z1;
import com.amap.api.col.jmsl.c3;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class PoiSearchV2 {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";

    /* renamed from: a, reason: collision with root package name */
    private IPoiSearchV2 f17570a;

    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItemV2 poiItemV2, int i10);

        void onPoiSearched(PoiResultV2 poiResultV2, int i10);

        void onVisualSearched(VisualSearchResult visualSearchResult, int i10);
    }

    public enum PremiumType {
        DEFAULT(""),
        ENTIRETY("entirety_poi");


        /* renamed from: a, reason: collision with root package name */
        private final String f17572a;

        PremiumType(String str) {
            this.f17572a = str;
        }

        public static PremiumType a(String str) {
            PremiumType premiumType = DEFAULT;
            if (!str.equals(premiumType.f17572a)) {
                PremiumType premiumType2 = ENTIRETY;
                if (str.equals(premiumType2.f17572a)) {
                    return premiumType2;
                }
            }
            return premiumType;
        }

        public String f() {
            return this.f17572a;
        }
    }

    public static class Query implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private String f17573a;

        /* renamed from: b, reason: collision with root package name */
        private String f17574b;

        /* renamed from: c, reason: collision with root package name */
        private String f17575c;

        /* renamed from: d, reason: collision with root package name */
        private int f17576d;

        /* renamed from: e, reason: collision with root package name */
        private int f17577e;

        /* renamed from: f, reason: collision with root package name */
        private String f17578f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f17579g;

        /* renamed from: h, reason: collision with root package name */
        private String f17580h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f17581i;

        /* renamed from: j, reason: collision with root package name */
        private LatLonPoint f17582j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f17583k;

        /* renamed from: l, reason: collision with root package name */
        private String f17584l;

        /* renamed from: m, reason: collision with root package name */
        private String f17585m;

        /* renamed from: n, reason: collision with root package name */
        private Map<String, String> f17586n;

        /* renamed from: o, reason: collision with root package name */
        private ShowFields f17587o;

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
            if (this.f17576d == query.f17576d && this.f17577e == query.f17577e && this.f17579g == query.f17579g && this.f17581i == query.f17581i && this.f17583k == query.f17583k && Objects.equals(this.f17573a, query.f17573a) && Objects.equals(this.f17574b, query.f17574b) && Objects.equals(this.f17575c, query.f17575c) && Objects.equals(this.f17578f, query.f17578f) && Objects.equals(this.f17580h, query.f17580h) && Objects.equals(this.f17582j, query.f17582j) && Objects.equals(this.f17584l, query.f17584l) && Objects.equals(this.f17585m, query.f17585m) && Objects.equals(this.f17586n, query.f17586n)) {
                return Objects.equals(this.f17587o, query.f17587o);
            }
            return false;
        }

        public String getBuilding() {
            return this.f17580h;
        }

        public String getCategory() {
            String str = this.f17574b;
            return (str == null || str.equals("00") || this.f17574b.equals("00|")) ? "" : this.f17574b;
        }

        public String getChannel() {
            return this.f17584l;
        }

        public String getCity() {
            return this.f17575c;
        }

        public boolean getCityLimit() {
            return this.f17579g;
        }

        public Map<String, String> getCustomParams() {
            return this.f17586n;
        }

        public LatLonPoint getLocation() {
            return this.f17582j;
        }

        public int getPageNum() {
            return this.f17576d;
        }

        public int getPageSize() {
            return this.f17577e;
        }

        public String getPremium() {
            return this.f17585m;
        }

        public String getQueryLanguage() {
            return this.f17578f;
        }

        public String getQueryString() {
            return this.f17573a;
        }

        public ShowFields getShowFields() {
            return this.f17587o;
        }

        public int hashCode() {
            String str = this.f17573a;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f17574b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f17575c;
            int iHashCode3 = (((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f17576d) * 31) + this.f17577e) * 31;
            String str4 = this.f17578f;
            int iHashCode4 = (((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + (this.f17579g ? 1 : 0)) * 31;
            String str5 = this.f17580h;
            int iHashCode5 = (((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + (this.f17581i ? 1 : 0)) * 31;
            LatLonPoint latLonPoint = this.f17582j;
            int iHashCode6 = (((iHashCode5 + (latLonPoint != null ? latLonPoint.hashCode() : 0)) * 31) + (this.f17583k ? 1 : 0)) * 31;
            String str6 = this.f17584l;
            int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.f17585m;
            int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
            Map<String, String> map = this.f17586n;
            int iHashCode9 = (iHashCode8 + (map != null ? map.hashCode() : 0)) * 31;
            ShowFields showFields = this.f17587o;
            return iHashCode9 + (showFields != null ? showFields.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f17581i;
        }

        public boolean isSpecial() {
            return this.f17583k;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearchV2.a(query.f17573a, this.f17573a) && PoiSearchV2.a(query.f17574b, this.f17574b) && PoiSearchV2.a(query.f17578f, this.f17578f) && PoiSearchV2.a(query.f17575c, this.f17575c) && PoiSearchV2.a(query.f17580h, this.f17580h) && PoiSearchV2.a(query.f17584l, this.f17584l) && PoiSearchV2.a(query.f17585m, this.f17585m) && query.f17579g == this.f17579g && query.f17577e == this.f17577e && query.f17581i == this.f17581i && query.f17583k == this.f17583k && query.f17586n.equals(this.f17586n) && query.f17587o.value == this.f17587o.value;
        }

        public void setBuilding(String str) {
            this.f17580h = str;
        }

        public void setChannel(String str) {
            this.f17584l = str;
        }

        public void setCityLimit(boolean z10) {
            this.f17579g = z10;
        }

        public void setCustomParams(Map<String, String> map) {
            this.f17586n = map;
        }

        public void setDistanceSort(boolean z10) {
            this.f17581i = z10;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f17582j = latLonPoint;
        }

        public void setPageNum(int i10) {
            if (i10 < 1) {
                i10 = 1;
            }
            this.f17576d = i10;
        }

        public void setPageSize(int i10) {
            if (i10 <= 0) {
                this.f17577e = 20;
            } else if (i10 > 30) {
                this.f17577e = 30;
            } else {
                this.f17577e = i10;
            }
        }

        public void setPremium(PremiumType premiumType) {
            if (premiumType == null) {
                return;
            }
            this.f17585m = premiumType.f();
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f17578f = "en";
            } else {
                this.f17578f = "zh-CN";
            }
        }

        public void setShowFields(ShowFields showFields) {
            if (showFields == null) {
                this.f17587o = new ShowFields();
            } else {
                this.f17587o = showFields;
            }
        }

        public void setSpecial(boolean z10) {
            this.f17583k = z10;
        }

        public Query(String str, String str2, String str3) {
            this.f17576d = 1;
            this.f17577e = 20;
            this.f17578f = "zh-CN";
            this.f17579g = false;
            this.f17581i = true;
            this.f17583k = true;
            this.f17585m = PremiumType.DEFAULT.f();
            this.f17586n = new HashMap();
            this.f17587o = new ShowFields();
            this.f17573a = str;
            this.f17574b = str2;
            this.f17575c = str3;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m26clone() throws CloneNotSupportedException {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f17573a, this.f17574b, this.f17575c);
            query.setPageNum(this.f17576d);
            query.setPageSize(this.f17577e);
            query.setQueryLanguage(this.f17578f);
            query.setCityLimit(this.f17579g);
            query.setBuilding(this.f17580h);
            query.setLocation(this.f17582j);
            query.setDistanceSort(this.f17581i);
            query.setSpecial(this.f17583k);
            query.setChannel(this.f17584l);
            query.setPremium(PremiumType.a(this.f17585m));
            query.setCustomParams(this.f17586n);
            query.setShowFields(new ShowFields(this.f17587o.value));
            return query;
        }
    }

    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f17588a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f17589b;

        /* renamed from: c, reason: collision with root package name */
        private int f17590c;

        /* renamed from: d, reason: collision with root package name */
        private LatLonPoint f17591d;

        /* renamed from: e, reason: collision with root package name */
        private String f17592e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f17593f;

        /* renamed from: g, reason: collision with root package name */
        private List<LatLonPoint> f17594g;

        public SearchBound(LatLonPoint latLonPoint, int i10) {
            this.f17593f = true;
            this.f17592e = "Bound";
            this.f17590c = i10;
            this.f17591d = latLonPoint;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f17588a = latLonPoint;
            this.f17589b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.f17589b.getLatitude() || this.f17588a.getLongitude() >= this.f17589b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.f17591d = new LatLonPoint((this.f17588a.getLatitude() + this.f17589b.getLatitude()) / 2.0d, (this.f17588a.getLongitude() + this.f17589b.getLongitude()) / 2.0d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            LatLonPoint latLonPoint = this.f17591d;
            if (latLonPoint == null) {
                if (searchBound.f17591d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(searchBound.f17591d)) {
                return false;
            }
            if (this.f17593f != searchBound.f17593f) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f17588a;
            if (latLonPoint2 == null) {
                if (searchBound.f17588a != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(searchBound.f17588a)) {
                return false;
            }
            LatLonPoint latLonPoint3 = this.f17589b;
            if (latLonPoint3 == null) {
                if (searchBound.f17589b != null) {
                    return false;
                }
            } else if (!latLonPoint3.equals(searchBound.f17589b)) {
                return false;
            }
            List<LatLonPoint> list = this.f17594g;
            if (list == null) {
                if (searchBound.f17594g != null) {
                    return false;
                }
            } else if (!list.equals(searchBound.f17594g)) {
                return false;
            }
            if (this.f17590c != searchBound.f17590c) {
                return false;
            }
            String str = this.f17592e;
            if (str == null) {
                if (searchBound.f17592e != null) {
                    return false;
                }
            } else if (!str.equals(searchBound.f17592e)) {
                return false;
            }
            return true;
        }

        public LatLonPoint getCenter() {
            return this.f17591d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f17588a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f17594g;
        }

        public int getRange() {
            return this.f17590c;
        }

        public String getShape() {
            return this.f17592e;
        }

        public LatLonPoint getUpperRight() {
            return this.f17589b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f17591d;
            int iHashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f17593f ? 1231 : 1237)) * 31;
            LatLonPoint latLonPoint2 = this.f17588a;
            int iHashCode2 = (iHashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f17589b;
            int iHashCode3 = (iHashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f17594g;
            int iHashCode4 = (((iHashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f17590c) * 31;
            String str = this.f17592e;
            return iHashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f17593f;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m27clone() throws CloneNotSupportedException {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f17588a, this.f17589b, this.f17590c, this.f17591d, this.f17592e, this.f17594g, this.f17593f);
        }

        public SearchBound(LatLonPoint latLonPoint, int i10, boolean z10) {
            this.f17592e = "Bound";
            this.f17590c = i10;
            this.f17591d = latLonPoint;
            this.f17593f = z10;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f17590c = 1500;
            this.f17593f = true;
            this.f17592e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f17590c = 1500;
            this.f17593f = true;
            this.f17592e = "Polygon";
            this.f17594g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i10, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z10) {
            this.f17588a = latLonPoint;
            this.f17589b = latLonPoint2;
            this.f17590c = i10;
            this.f17591d = latLonPoint3;
            this.f17592e = str;
            this.f17594g = list;
            this.f17593f = z10;
        }
    }

    public static class ShowFields {
        public static final int ALL = -1;
        public static final int BUSINESS = 2;
        public static final int CHILDREN = 1;
        public static final int DEFAULT = 0;
        public static final int INDOOR = 4;
        public static final int NAVI = 8;
        public static final int PHOTOS = 16;
        public int value;

        public ShowFields() {
            this.value = 0;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int i10) {
            this.value = i10;
        }

        public ShowFields(int i10) {
            this.value = i10;
        }
    }

    public static class VisualQuery {

        /* renamed from: a, reason: collision with root package name */
        private String f17595a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f17596b;

        /* renamed from: c, reason: collision with root package name */
        private float f17597c;

        /* renamed from: d, reason: collision with root package name */
        private String f17598d;

        public VisualQuery(String str, LatLonPoint latLonPoint, float f10) {
            this.f17595a = str;
            this.f17596b = latLonPoint;
            this.f17597c = f10;
        }

        public String getAdiu() {
            return this.f17598d;
        }

        public float getAngle() {
            return this.f17597c;
        }

        public LatLonPoint getLocation() {
            return this.f17596b;
        }

        public String getPicUrl() {
            return this.f17595a;
        }

        public void setAdiu(String str) {
            this.f17598d = str;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f17596b = latLonPoint;
        }

        public void setPicUrl(String str) {
            this.f17595a = str;
        }
    }

    public PoiSearchV2(Context context, Query query) throws AMapException {
        this.f17570a = null;
        try {
            this.f17570a = new c3(context, query);
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
        IPoiSearchV2 iPoiSearchV2 = this.f17570a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getBound();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearchV2 iPoiSearchV2 = this.f17570a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getQuery();
        }
        return null;
    }

    public PoiResultV2 searchPOI() throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f17570a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearchV2 iPoiSearchV2 = this.f17570a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIAsyn();
        }
    }

    public VisualSearchResult searchPOIByVisual(VisualQuery visualQuery) throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f17570a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOIByVisual(visualQuery);
        }
        return null;
    }

    public void searchPOIByVisualAsyn(VisualQuery visualQuery) {
        IPoiSearchV2 iPoiSearchV2 = this.f17570a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIByVisualAsyn(visualQuery);
        }
    }

    public PoiItemV2 searchPOIId(String str) throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f17570a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearchV2 iPoiSearchV2 = this.f17570a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearchV2 iPoiSearchV2 = this.f17570a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setBound(searchBound);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearchV2 iPoiSearchV2 = this.f17570a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearchV2 iPoiSearchV2 = this.f17570a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setQuery(query);
        }
    }
}
