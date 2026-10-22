package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.ax;
import com.amap.api.col.s.i;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IDistanceSearch;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class DistanceSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int TYPE_DISTANCE = 0;
    public static final int TYPE_DRIVING_DISTANCE = 1;
    public static final int TYPE_WALK_DISTANCE = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IDistanceSearch f29065a;

    public static class DistanceQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DistanceQuery> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f29066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<LatLonPoint> f29067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private LatLonPoint f29068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f29069d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f29070e;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public DistanceQuery() {
            this.f29066a = 1;
            this.f29067b = new ArrayList();
            this.f29069d = "base";
            this.f29070e = 4;
        }

        public DistanceQuery clone() {
            super.clone();     // Catch: CloneNotSupportedException -> L4
        L6:
            DistanceQuery r100 = new DistanceQuery();
            r100.setType(this.f29066a);
            r100.setOrigins(this.f29067b);
            r100.setDestination(this.f29068c);
            r100.setExtensions(this.f29069d);
            r100.setMode(this.f29070e);
            return r100;
        L4:
            e = move-exception;
            i.a(e, "DistanceSearch", "DistanceQueryclone");
            goto L6
        }

        public LatLonPoint getDestination() {
            return this.f29068c;
        }

        public String getExtensions() {
            return this.f29069d;
        }

        public int getMode() {
            return this.f29070e;
        }

        public List<LatLonPoint> getOrigins() {
            return this.f29067b;
        }

        public int getType() {
            return this.f29066a;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8039clone() throws CloneNotSupportedException {
            return clone();
        }

        public DistanceQuery(Parcel r100) {
            this.f29066a = 1;
            this.f29067b = new ArrayList();
            this.f29069d = "base";
            this.f29070e = 4;
            this.f29066a = r100.readInt();
            this.f29067b = r100.createTypedArrayList(LatLonPoint.CREATOR);
            this.f29068c = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
            this.f29069d = r100.readString();
            this.f29070e = r100.readInt();
        }

        public void addOrigins(LatLonPoint... r100) {
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L8;
            LatLonPoint r103 = r100[r102];
            if (r103 == null) goto L7;
            this.f29067b.add(r103);
        L7:
            r102 = r102 + 1;
            goto L3
        }

        public void setDestination(LatLonPoint r100) {
            this.f29068c = r100;
        }

        public void setExtensions(String r100) {
            this.f29069d = r100;
        }

        public void setMode(int r100) {
            this.f29070e = r100;
        }

        public void setOrigins(List<LatLonPoint> r100) {
            if (r100 == null) goto L5;
            this.f29067b = r100;
            return;
        }

        public void setType(int r100) {
            this.f29066a = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.f29066a);
            r100.writeTypedList(this.f29067b);
            r100.writeParcelable(this.f29068c, r101);
            r100.writeString(this.f29069d);
            r100.writeInt(this.f29070e);
        }
    }

    public interface OnDistanceSearchListener {
        void onDistanceSearched(DistanceResult r100, int r101);
    }

    public DistanceSearch(Context r100) {
        if (this.f29065a != null) goto L11;
        this.f29065a = new ax(r100);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public DistanceResult calculateRouteDistance(DistanceQuery r100) throws AMapException {
        IDistanceSearch r101 = this.f29065a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.calculateRouteDistance(r100);
    }

    public void calculateRouteDistanceAsyn(DistanceQuery r100) {
        IDistanceSearch r101 = this.f29065a;
        if (r101 == null) goto L6;
        r101.calculateRouteDistanceAsyn(r100);
        return;
    }

    public void setDistanceSearchListener(OnDistanceSearchListener r100) {
        IDistanceSearch r101 = this.f29065a;
        if (r101 == null) goto L6;
        r101.setDistanceSearchListener(r100);
        return;
    }
}
