package com.amap.api.services.cloud;

import android.content.Context;
import com.amap.api.col.s.aw;
import com.amap.api.col.s.i;
import com.amap.api.col.s.z;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class CloudSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ICloudSearch f28813a;

    public interface OnCloudSearchListener {
        void onCloudItemDetailSearched(CloudItemDetail r100, int r101);

        void onCloudSearched(CloudResult r100, int r101);
    }

    public static class Query implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f28814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f28815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f28816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f28817d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private SearchBound f28818e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Sortingrules f28819f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ArrayList<z> f28820g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<String> f28821h;

        public String getFilterNumString() {
            StringBuffer r100 = new StringBuffer();
            int r101 = this.f28820g.size();     // Catch: Throwable -> L9
            int r102 = 0;
        L4:
            if (r102 >= r101) goto L12;
            z r103 = (z) ListProtector.get(this.f28820g, r102);     // Catch: Throwable -> L9
            r100.append(r103.a());     // Catch: Throwable -> L9
            r100.append(">=");     // Catch: Throwable -> L9
            r100.append(r103.b());     // Catch: Throwable -> L9
            r100.append("&&");     // Catch: Throwable -> L9
            r100.append(r103.a());     // Catch: Throwable -> L9
            r100.append("<=");     // Catch: Throwable -> L9
            r100.append(r103.c());     // Catch: Throwable -> L9
            if (r102 == (r101 - 1)) goto L8;
            r100.append("&&");     // Catch: Throwable -> L9
        L8:
            r102 = r102 + 1;
        L12:
            return r100.toString();
        L9:
            th = move-exception;
            th.printStackTrace();
            goto L12
        }

        public String getFilterString() {
            StringBuffer r100 = new StringBuffer();
            int r101 = this.f28821h.size();     // Catch: Throwable -> L9
            int r102 = 0;
        L4:
            if (r102 >= r101) goto L12;
            r100.append((String) ListProtector.get(this.f28821h, r102));     // Catch: Throwable -> L9
            if (r102 == (r101 - 1)) goto L8;
            r100.append("&&");     // Catch: Throwable -> L9
        L8:
            r102 = r102 + 1;
        L12:
            return r100.toString();
        L9:
            th = move-exception;
            th.printStackTrace();
            goto L12
        }

        public int hashCode() {
            ArrayList<z> r100 = this.f28820g;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r102 + 31) * 31;
            List<String> r104 = this.f28821h;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            SearchBound r107 = this.f28818e;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (((((r106 + r108) * 31) + this.f28815b) * 31) + this.f28816c) * 31;
            String r110 = this.f28814a;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Sortingrules r113 = this.f28819f;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f28817d;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
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

        private Query() {
            this.f28815b = 1;
            this.f28816c = 20;
            this.f28820g = new ArrayList();
            this.f28821h = new ArrayList();
        }

        public Query clone() {
            super.clone();     // Catch: CloneNotSupportedException -> L4
        L6:
            ArrayList r100 = null;
            Query r101 = new Query(this.f28817d, this.f28814a, this.f28818e);     // Catch: AMapException -> L20
            r101.setPageNum(this.f28815b);     // Catch: AMapException -> L18
            r101.setPageSize(this.f28816c);     // Catch: AMapException -> L18
            r101.setSortingrules(getSortingrules());     // Catch: AMapException -> L18
            if (this.f28820g != null) goto L11;
            ArrayList<z> r102 = null;
        L12:
            r101.f28820g = r102;     // Catch: AMapException -> L18
            if (this.f28821h == null) goto L16;
            r100 = new ArrayList();     // Catch: AMapException -> L18
            r100.addAll(this.f28821h);     // Catch: AMapException -> L18
        L16:
            r101.f28821h = r100;     // Catch: AMapException -> L18
        L23:
            if (r101 == null) goto L25;
            return r101;
        L25:
            return new Query();
        L11:
            r102 = new ArrayList();     // Catch: AMapException -> L18
            r102.addAll(this.f28820g);     // Catch: AMapException -> L18
        L18:
            AMapException e100 = e;
        L22:
            e100.printStackTrace();
        L20:
            e = move-exception;
            r101 = null;
            e100 = e;
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L6
        }

        public SearchBound getBound() {
            return this.f28818e;
        }

        public int getPageNum() {
            return this.f28815b;
        }

        public int getPageSize() {
            return this.f28816c;
        }

        public String getQueryString() {
            return this.f28814a;
        }

        public Sortingrules getSortingrules() {
            return this.f28819f;
        }

        public String getTableID() {
            return this.f28817d;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8034clone() throws CloneNotSupportedException {
            return clone();
        }

        public boolean equals(Object r100) {
            if (r100 != null) goto L5;
        L15:
            return false;
        L5:
            if ((r100 instanceof Query) == false) goto L15;
            if (r100 != this) goto L10;
            return true;
        L10:
            Query r101 = (Query) r100;
            if (queryEquals(r101) == false) goto L15;
            if (r101.f28815b != this.f28815b) goto L15;
            return true;
        }

        public boolean queryEquals(Query r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (r100 != this) goto L9;
            return true;
        L9:
            if (CloudSearch.a(r100.f28814a, this.f28814a) == true) goto L11;
        L37:
            return false;
        L11:
            if (CloudSearch.a(r100.getTableID(), getTableID()) == false) goto L37;
            if (CloudSearch.a(r100.getFilterString(), getFilterString()) == false) goto L37;
            if (CloudSearch.a(r100.getFilterNumString(), getFilterNumString()) == false) goto L37;
            if (r100.f28816c != this.f28816c) goto L37;
            SearchBound r101 = r100.getBound();
            SearchBound r102 = getBound();
            if (r101 != null) goto L22;
            if (r102 != null) goto L22;
            boolean r103 = true;
        L26:
            if (r103 == false) goto L37;
            Sortingrules r104 = r100.getSortingrules();
            Sortingrules r105 = getSortingrules();
            if (r104 != null) goto L31;
            if (r105 != null) goto L31;
            boolean r106 = true;
        L35:
            if (r106 == false) goto L37;
            return true;
        L31:
            if (r104 == null) goto L34;
            if (r105 == null) goto L34;
            r106 = r104.equals(r105);
        L34:
            r106 = false;
        L22:
            if (r101 == null) goto L25;
            if (r102 == null) goto L25;
            r103 = r101.equals(r102);
        L25:
            r103 = false;
            goto L26
        }

        public void setBound(SearchBound r100) {
            this.f28818e = r100;
        }

        public void setPageNum(int r100) {
            this.f28815b = r100;
        }

        public void setPageSize(int r100) {
            if (r100 > 0) goto L6;
            this.f28816c = 20;
            return;
        L6:
            if (r100 <= 100) goto L9;
            this.f28816c = 100;
            return;
        L9:
            this.f28816c = r100;
        }

        public void setSortingrules(Sortingrules r100) {
            this.f28819f = r100;
        }

        public void setTableID(String r100) {
            this.f28817d = r100;
        }

        public void addFilterString(String r100, String r101) {
            if (r100 == null) goto L6;
            if (r101 == null) goto L7;
            this.f28821h.add(r100.concat(r101));
            return;
        L7:
            return;
        }

        public Query(String r100, String r101, SearchBound r102) throws AMapException {
            this.f28815b = 1;
            this.f28816c = 20;
            this.f28820g = new ArrayList();
            this.f28821h = new ArrayList();
            if (i.a(r100) == true) goto L8;
            if (r102 == null) goto L8;
            this.f28817d = r100;
            this.f28814a = r101;
            this.f28818e = r102;
            return;
        L8:
            throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
        }

        public void addFilterNum(String r100, String r101, String r102) {
            z r103 = new z(r100, r101, r102);
            this.f28820g.add(r103);
        }
    }

    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String LOCAL_SHAPE = "Local";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LatLonPoint f28822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LatLonPoint f28823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f28824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private LatLonPoint f28825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f28826e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List<LatLonPoint> f28827f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f28828g;

        private List<LatLonPoint> a() {
            if (this.f28827f != null) goto L6;
            return null;
        L6:
            ArrayList r100 = new ArrayList();
            Iterator<LatLonPoint> r101 = this.f28827f.iterator();
        L8:
            if (r101.hasNext() == false) goto L10;
            LatLonPoint r102 = r101.next();
            r100.add(new LatLonPoint(r102.getLatitude(), r102.getLongitude()));
            goto L8
        L10:
            return r100;
        }

        public int hashCode() {
            LatLonPoint r100 = this.f28825d;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r102 + 31) * 31;
            LatLonPoint r104 = this.f28822a;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            LatLonPoint r107 = this.f28823b;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            List<LatLonPoint> r110 = this.f28827f;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (((r109 + r111) * 31) + this.f28824c) * 31;
            String r113 = this.f28826e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f28828g;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
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

        public SearchBound clone() {
            super.clone();     // Catch: CloneNotSupportedException -> L4
        L7:
            if (getShape().equals("Bound") == false) goto L11;
            return new SearchBound(this.f28825d, this.f28824c);
        L11:
            if (getShape().equals("Polygon") == false) goto L15;
            return new SearchBound(a());
        L15:
            if (getShape().equals(LOCAL_SHAPE) == false) goto L19;
            return new SearchBound(this.f28828g);
        L19:
            return new SearchBound(this.f28822a, this.f28823b);
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        public LatLonPoint getCenter() {
            return this.f28825d;
        }

        public String getCity() {
            return this.f28828g;
        }

        public LatLonPoint getLowerLeft() {
            return this.f28822a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f28827f;
        }

        public int getRange() {
            return this.f28824c;
        }

        public String getShape() {
            return this.f28826e;
        }

        public LatLonPoint getUpperRight() {
            return this.f28823b;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8035clone() throws CloneNotSupportedException {
            return clone();
        }

        public SearchBound(String r100) {
            this.f28826e = LOCAL_SHAPE;
            this.f28828g = r100;
        }

        public boolean equals(Object r100) {
            if (r100 != null) goto L5;
        L44:
            return false;
        L5:
            if ((r100 instanceof SearchBound) == false) goto L44;
            SearchBound r101 = (SearchBound) r100;
            if (getShape().equalsIgnoreCase(r101.getShape()) == true) goto L11;
            return false;
        L11:
            if (getShape().equals("Bound") == false) goto L19;
            if (r101.f28825d.equals(this.f28825d) == true) goto L15;
        L17:
            return false;
        L15:
            if (r101.f28824c != this.f28824c) goto L17;
            return true;
        L19:
            if (getShape().equals("Polygon") == false) goto L36;
            List<LatLonPoint> r102 = r101.f28827f;
            List<LatLonPoint> r103 = this.f28827f;
            if (r102 != null) goto L24;
            if (r103 != null) goto L24;
            return true;
        L24:
            if (r102 == null) goto L34;
            if (r103 == null) goto L34;
            if (r102.size() != r103.size()) goto L34;
            int r104 = r102.size();
            int r105 = 0;
        L29:
            if (r105 >= r104) goto L33;
            if (((LatLonPoint) ListProtector.get(r102, r105)).equals(ListProtector.get(r103, r105)) == false) goto L34;
            r105 = r105 + 1;
            goto L29
        L33:
            return true;
        L34:
            return false;
        L36:
            if (getShape().equals(LOCAL_SHAPE) == false) goto L40;
            return r101.f28828g.equals(this.f28828g);
        L40:
            if (r101.f28822a.equals(this.f28822a) == false) goto L44;
            if (r101.f28823b.equals(this.f28823b) == false) goto L44;
            return true;
        }

        public SearchBound(List<LatLonPoint> r100) {
            this.f28826e = "Polygon";
            this.f28827f = r100;
        }

        public SearchBound(LatLonPoint r100, LatLonPoint r101) {
            this.f28826e = "Rectangle";
            this.f28822a = r100;
            this.f28823b = r101;
            boolean r102 = false;
            if (r100 == null) goto L12;
            if (r101 == null) goto L12;
            if (r100.getLatitude() >= this.f28823b.getLatitude()) goto L12;
            if (this.f28822a.getLongitude() >= this.f28823b.getLongitude()) goto L12;
            r102 = true;
        L12:
            if (r102 == true) goto L15;
            new IllegalArgumentException("invalid rect ").printStackTrace();
            return;
        }

        public SearchBound(LatLonPoint r100, int r101) {
            this.f28826e = "Bound";
            this.f28824c = r101;
            this.f28825d = r100;
        }
    }

    public static class Sortingrules {
        public static final int DISTANCE = 1;
        public static final int WEIGHT = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f28829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f28830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f28831c;

        public int hashCode() {
            if (this.f28831c == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = (r100 + 31) * 31;
            String r102 = this.f28830b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return ((r101 + r103) * 31) + this.f28829a;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public String toString() {
            if (i.a(this.f28830b) == false) goto L12;
            int r100 = this.f28829a;
            if (r100 != 0) goto L8;
            return "_weight:desc";
        L8:
            if (r100 != 1) goto L10;
            return "_distance:asc";
        L10:
            return "";
        L12:
            if (this.f28831c == false) goto L15;
            return this.f28830b + ":asc";
        L15:
            return this.f28830b + ":desc";
        }

        public Sortingrules(int r100) {
            this.f28831c = true;
            this.f28829a = r100;
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
            Sortingrules r101 = (Sortingrules) r100;
            if (this.f28831c == r101.f28831c) goto L14;
            return false;
        L14:
            String r102 = this.f28830b;
            if (r102 != null) goto L20;
            if (r101.f28830b == null) goto L23;
            return false;
        L23:
            if (this.f28829a == r101.f28829a) goto L25;
            return false;
        L25:
            return true;
        L20:
            if (r102.equals(r101.f28830b) == true) goto L23;
            return false;
        }

        public Sortingrules(String r100, boolean r101) {
            this.f28829a = 0;
            this.f28830b = r100;
            this.f28831c = r101;
        }
    }

    public CloudSearch(Context r100) {
        if (this.f28813a != null) goto L11;
        this.f28813a = new aw(r100);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void searchCloudAsyn(Query r100) {
        ICloudSearch r101 = this.f28813a;
        if (r101 == null) goto L6;
        r101.searchCloudAsyn(r100);
        return;
    }

    public void setOnCloudSearchListener(OnCloudSearchListener r100) {
        ICloudSearch r101 = this.f28813a;
        if (r101 == null) goto L6;
        r101.setOnCloudSearchListener(r100);
        return;
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

    public void searchCloudDetailAsyn(String r100, String r101) {
        ICloudSearch r102 = this.f28813a;
        if (r102 == null) goto L6;
        r102.searchCloudDetailAsyn(r100, r101);
        return;
    }
}
