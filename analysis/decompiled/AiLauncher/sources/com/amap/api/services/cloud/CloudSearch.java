package com.amap.api.services.cloud;

import android.content.Context;
import com.amap.api.col.jmsl.C1533a2;
import com.amap.api.col.jmsl.C1631z1;
import com.amap.api.col.jmsl.Z1;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CloudSearch {

    /* renamed from: a, reason: collision with root package name */
    private ICloudSearch f17318a;

    public interface OnCloudSearchListener {
        void onCloudItemDetailSearched(CloudItemDetail cloudItemDetail, int i10);

        void onCloudSearched(CloudResult cloudResult, int i10);
    }

    public static class Query implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private String f17319a;

        /* renamed from: d, reason: collision with root package name */
        private String f17322d;

        /* renamed from: e, reason: collision with root package name */
        private SearchBound f17323e;

        /* renamed from: f, reason: collision with root package name */
        private Sortingrules f17324f;

        /* renamed from: b, reason: collision with root package name */
        private int f17320b = 1;

        /* renamed from: c, reason: collision with root package name */
        private int f17321c = 20;

        /* renamed from: g, reason: collision with root package name */
        private ArrayList<Z1> f17325g = new ArrayList<>();

        /* renamed from: h, reason: collision with root package name */
        private List<String> f17326h = new ArrayList();

        public Query(String str, String str2, SearchBound searchBound) throws AMapException {
            if (C1631z1.p(str) || searchBound == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            this.f17322d = str;
            this.f17319a = str2;
            this.f17323e = searchBound;
        }

        public void addFilterNum(String str, String str2, String str3) {
            this.f17325g.add(new Z1(str, str2, str3));
        }

        public void addFilterString(String str, String str2) {
            if (str == null || str2 == null) {
                return;
            }
            this.f17326h.add(str + str2);
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Query)) {
                if (obj == this) {
                    return true;
                }
                Query query = (Query) obj;
                if (queryEquals(query) && query.f17320b == this.f17320b) {
                    return true;
                }
            }
            return false;
        }

        public SearchBound getBound() {
            return this.f17323e;
        }

        public String getFilterNumString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.f17325g.size();
                for (int i10 = 0; i10 < size; i10++) {
                    Z1 z12 = this.f17325g.get(i10);
                    stringBuffer.append(z12.a());
                    stringBuffer.append(">=");
                    stringBuffer.append(z12.b());
                    stringBuffer.append("&&");
                    stringBuffer.append(z12.a());
                    stringBuffer.append("<=");
                    stringBuffer.append(z12.c());
                    if (i10 != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public String getFilterString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.f17326h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    stringBuffer.append(this.f17326h.get(i10));
                    if (i10 != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public int getPageNum() {
            return this.f17320b;
        }

        public int getPageSize() {
            return this.f17321c;
        }

        public String getQueryString() {
            return this.f17319a;
        }

        public Sortingrules getSortingrules() {
            return this.f17324f;
        }

        public String getTableID() {
            return this.f17322d;
        }

        public int hashCode() {
            ArrayList<Z1> arrayList = this.f17325g;
            int iHashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
            List<String> list = this.f17326h;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            SearchBound searchBound = this.f17323e;
            int iHashCode3 = (((((iHashCode2 + (searchBound == null ? 0 : searchBound.hashCode())) * 31) + this.f17320b) * 31) + this.f17321c) * 31;
            String str = this.f17319a;
            int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            Sortingrules sortingrules = this.f17324f;
            int iHashCode5 = (iHashCode4 + (sortingrules == null ? 0 : sortingrules.hashCode())) * 31;
            String str2 = this.f17322d;
            return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            if (CloudSearch.a(query.f17319a, this.f17319a) && CloudSearch.a(query.getTableID(), getTableID()) && CloudSearch.a(query.getFilterString(), getFilterString()) && CloudSearch.a(query.getFilterNumString(), getFilterNumString()) && query.f17321c == this.f17321c) {
                SearchBound bound = query.getBound();
                SearchBound bound2 = getBound();
                if ((bound == null && bound2 == null) ? true : (bound == null || bound2 == null) ? false : bound.equals(bound2)) {
                    Sortingrules sortingrules = query.getSortingrules();
                    Sortingrules sortingrules2 = getSortingrules();
                    if ((sortingrules == null && sortingrules2 == null) ? true : (sortingrules == null || sortingrules2 == null) ? false : sortingrules.equals(sortingrules2)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void setBound(SearchBound searchBound) {
            this.f17323e = searchBound;
        }

        public void setPageNum(int i10) {
            this.f17320b = i10;
        }

        public void setPageSize(int i10) {
            if (i10 <= 0) {
                this.f17321c = 20;
            } else if (i10 > 100) {
                this.f17321c = 100;
            } else {
                this.f17321c = i10;
            }
        }

        public void setSortingrules(Sortingrules sortingrules) {
            this.f17324f = sortingrules;
        }

        public void setTableID(String str) {
            this.f17322d = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0059 A[RETURN] */
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.amap.api.services.cloud.CloudSearch.Query m21clone() throws java.lang.CloneNotSupportedException {
            /*
                r5 = this;
                super.clone()     // Catch: java.lang.CloneNotSupportedException -> L4
                goto L8
            L4:
                r0 = move-exception
                r0.printStackTrace()
            L8:
                r0 = 0
                com.amap.api.services.cloud.CloudSearch$Query r1 = new com.amap.api.services.cloud.CloudSearch$Query     // Catch: com.amap.api.services.core.AMapException -> L4c
                java.lang.String r2 = r5.f17322d     // Catch: com.amap.api.services.core.AMapException -> L4c
                java.lang.String r3 = r5.f17319a     // Catch: com.amap.api.services.core.AMapException -> L4c
                com.amap.api.services.cloud.CloudSearch$SearchBound r4 = r5.f17323e     // Catch: com.amap.api.services.core.AMapException -> L4c
                r1.<init>(r2, r3, r4)     // Catch: com.amap.api.services.core.AMapException -> L4c
                int r2 = r5.f17320b     // Catch: com.amap.api.services.core.AMapException -> L49
                r1.setPageNum(r2)     // Catch: com.amap.api.services.core.AMapException -> L49
                int r2 = r5.f17321c     // Catch: com.amap.api.services.core.AMapException -> L49
                r1.setPageSize(r2)     // Catch: com.amap.api.services.core.AMapException -> L49
                com.amap.api.services.cloud.CloudSearch$Sortingrules r2 = r5.getSortingrules()     // Catch: com.amap.api.services.core.AMapException -> L49
                r1.setSortingrules(r2)     // Catch: com.amap.api.services.core.AMapException -> L49
                java.util.ArrayList<com.amap.api.col.jmsl.Z1> r2 = r5.f17325g     // Catch: com.amap.api.services.core.AMapException -> L49
                if (r2 != 0) goto L2b
                r2 = r0
                goto L35
            L2b:
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch: com.amap.api.services.core.AMapException -> L49
                r2.<init>()     // Catch: com.amap.api.services.core.AMapException -> L49
                java.util.ArrayList<com.amap.api.col.jmsl.Z1> r3 = r5.f17325g     // Catch: com.amap.api.services.core.AMapException -> L49
                r2.addAll(r3)     // Catch: com.amap.api.services.core.AMapException -> L49
            L35:
                r1.f17325g = r2     // Catch: com.amap.api.services.core.AMapException -> L49
                java.util.List<java.lang.String> r2 = r5.f17326h     // Catch: com.amap.api.services.core.AMapException -> L49
                if (r2 != 0) goto L3c
                goto L46
            L3c:
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch: com.amap.api.services.core.AMapException -> L49
                r0.<init>()     // Catch: com.amap.api.services.core.AMapException -> L49
                java.util.List<java.lang.String> r5 = r5.f17326h     // Catch: com.amap.api.services.core.AMapException -> L49
                r0.addAll(r5)     // Catch: com.amap.api.services.core.AMapException -> L49
            L46:
                r1.f17326h = r0     // Catch: com.amap.api.services.core.AMapException -> L49
                goto L51
            L49:
                r5 = move-exception
                r0 = r1
                goto L4d
            L4c:
                r5 = move-exception
            L4d:
                r5.printStackTrace()
                r1 = r0
            L51:
                if (r1 != 0) goto L59
                com.amap.api.services.cloud.CloudSearch$Query r5 = new com.amap.api.services.cloud.CloudSearch$Query
                r5.<init>()
                return r5
            L59:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.cloud.CloudSearch.Query.m21clone():com.amap.api.services.cloud.CloudSearch$Query");
        }

        private Query() {
        }
    }

    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String LOCAL_SHAPE = "Local";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f17327a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f17328b;

        /* renamed from: c, reason: collision with root package name */
        private int f17329c;

        /* renamed from: d, reason: collision with root package name */
        private LatLonPoint f17330d;

        /* renamed from: e, reason: collision with root package name */
        private String f17331e;

        /* renamed from: f, reason: collision with root package name */
        private List<LatLonPoint> f17332f;

        /* renamed from: g, reason: collision with root package name */
        private String f17333g;

        public SearchBound(LatLonPoint latLonPoint, int i10) {
            this.f17331e = "Bound";
            this.f17329c = i10;
            this.f17330d = latLonPoint;
        }

        private boolean a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f17327a = latLonPoint;
            this.f17328b = latLonPoint2;
            return latLonPoint != null && latLonPoint2 != null && latLonPoint.getLatitude() < this.f17328b.getLatitude() && this.f17327a.getLongitude() < this.f17328b.getLongitude();
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof SearchBound)) {
                SearchBound searchBound = (SearchBound) obj;
                if (!getShape().equalsIgnoreCase(searchBound.getShape())) {
                    return false;
                }
                if (getShape().equals("Bound")) {
                    return searchBound.f17330d.equals(this.f17330d) && searchBound.f17329c == this.f17329c;
                }
                if (getShape().equals("Polygon")) {
                    List<LatLonPoint> list = searchBound.f17332f;
                    List<LatLonPoint> list2 = this.f17332f;
                    if (list != null || list2 != null) {
                        if (list != null && list2 != null && list.size() == list2.size()) {
                            int size = list.size();
                            for (int i10 = 0; i10 < size; i10++) {
                                if (list.get(i10).equals(list2.get(i10))) {
                                }
                            }
                        }
                        return false;
                    }
                    return true;
                }
                if (getShape().equals(LOCAL_SHAPE)) {
                    return searchBound.f17333g.equals(this.f17333g);
                }
                if (searchBound.f17327a.equals(this.f17327a) && searchBound.f17328b.equals(this.f17328b)) {
                    return true;
                }
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.f17330d;
        }

        public String getCity() {
            return this.f17333g;
        }

        public LatLonPoint getLowerLeft() {
            return this.f17327a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f17332f;
        }

        public int getRange() {
            return this.f17329c;
        }

        public String getShape() {
            return this.f17331e;
        }

        public LatLonPoint getUpperRight() {
            return this.f17328b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f17330d;
            int iHashCode = ((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint2 = this.f17327a;
            int iHashCode2 = (iHashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f17328b;
            int iHashCode3 = (iHashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f17332f;
            int iHashCode4 = (((iHashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f17329c) * 31;
            String str = this.f17331e;
            int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f17333g;
            return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m22clone() throws CloneNotSupportedException {
            ArrayList arrayList;
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                e10.printStackTrace();
            }
            if (getShape().equals("Bound")) {
                return new SearchBound(this.f17330d, this.f17329c);
            }
            if (!getShape().equals("Polygon")) {
                return getShape().equals(LOCAL_SHAPE) ? new SearchBound(this.f17333g) : new SearchBound(this.f17327a, this.f17328b);
            }
            if (this.f17332f == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (LatLonPoint latLonPoint : this.f17332f) {
                    arrayList2.add(new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
                }
                arrayList = arrayList2;
            }
            return new SearchBound(arrayList);
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f17331e = "Rectangle";
            if (a(latLonPoint, latLonPoint2)) {
                return;
            }
            new IllegalArgumentException("invalid rect ").printStackTrace();
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f17331e = "Polygon";
            this.f17332f = list;
        }

        public SearchBound(String str) {
            this.f17331e = LOCAL_SHAPE;
            this.f17333g = str;
        }
    }

    public CloudSearch(Context context) throws AMapException {
        if (this.f17318a == null) {
            try {
                this.f17318a = new C1533a2(context);
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof AMapException) {
                    throw ((AMapException) e10);
                }
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

    public void searchCloudAsyn(Query query) {
        ICloudSearch iCloudSearch = this.f17318a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudAsyn(query);
        }
    }

    public void searchCloudDetailAsyn(String str, String str2) {
        ICloudSearch iCloudSearch = this.f17318a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudDetailAsyn(str, str2);
        }
    }

    public void setOnCloudSearchListener(OnCloudSearchListener onCloudSearchListener) {
        ICloudSearch iCloudSearch = this.f17318a;
        if (iCloudSearch != null) {
            iCloudSearch.setOnCloudSearchListener(onCloudSearchListener);
        }
    }

    public static class Sortingrules {
        public static final int DISTANCE = 1;
        public static final int WEIGHT = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f17334a;

        /* renamed from: b, reason: collision with root package name */
        private String f17335b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f17336c;

        public Sortingrules(String str, boolean z10) {
            this.f17334a = 0;
            this.f17335b = str;
            this.f17336c = z10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Sortingrules sortingrules = (Sortingrules) obj;
            if (this.f17336c != sortingrules.f17336c) {
                return false;
            }
            String str = this.f17335b;
            if (str == null) {
                if (sortingrules.f17335b != null) {
                    return false;
                }
            } else if (!str.equals(sortingrules.f17335b)) {
                return false;
            }
            return this.f17334a == sortingrules.f17334a;
        }

        public int hashCode() {
            int i10 = ((this.f17336c ? 1231 : 1237) + 31) * 31;
            String str = this.f17335b;
            return ((i10 + (str == null ? 0 : str.hashCode())) * 31) + this.f17334a;
        }

        public String toString() {
            if (C1631z1.p(this.f17335b)) {
                int i10 = this.f17334a;
                return i10 == 0 ? "_weight:desc" : i10 == 1 ? "_distance:asc" : "";
            }
            if (this.f17336c) {
                return this.f17335b + ":asc";
            }
            return this.f17335b + ":desc";
        }

        public Sortingrules(int i10) {
            this.f17336c = true;
            this.f17334a = i10;
        }
    }
}
