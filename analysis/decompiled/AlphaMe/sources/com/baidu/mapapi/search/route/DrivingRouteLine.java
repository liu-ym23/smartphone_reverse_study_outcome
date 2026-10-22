package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrivingRouteLine extends RouteLine<DrivingStep> implements Parcelable {
    public static final Parcelable.Creator<DrivingRouteLine> CREATOR = new a();

    /* renamed from: i, reason: collision with root package name */
    private boolean f7456i;

    /* renamed from: j, reason: collision with root package name */
    private List<RouteNode> f7457j;

    /* renamed from: k, reason: collision with root package name */
    private int f7458k;

    /* renamed from: l, reason: collision with root package name */
    private int f7459l;

    /* renamed from: m, reason: collision with root package name */
    private int f7460m;

    public static class DrivingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<DrivingStep> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        private int f7461e;

        /* renamed from: f, reason: collision with root package name */
        private RouteNode f7462f;

        /* renamed from: g, reason: collision with root package name */
        private RouteNode f7463g;

        /* renamed from: h, reason: collision with root package name */
        private String f7464h;

        /* renamed from: i, reason: collision with root package name */
        private String f7465i;

        /* renamed from: j, reason: collision with root package name */
        private String f7466j;

        /* renamed from: k, reason: collision with root package name */
        private String f7467k;

        /* renamed from: l, reason: collision with root package name */
        private int f7468l;

        /* renamed from: m, reason: collision with root package name */
        List<LatLng> f7469m;

        /* renamed from: n, reason: collision with root package name */
        int[] f7470n;

        /* renamed from: o, reason: collision with root package name */
        private int f7471o;

        /* renamed from: p, reason: collision with root package name */
        private String f7472p;

        public static class a implements Parcelable.Creator<DrivingStep> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DrivingStep createFromParcel(Parcel parcel) {
                return new DrivingStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DrivingStep[] newArray(int i4) {
                return new DrivingStep[i4];
            }
        }

        public DrivingStep() {
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f7461e;
        }

        public RouteNode getEntrance() {
            return this.f7462f;
        }

        public String getEntranceInstructions() {
            return this.f7465i;
        }

        public RouteNode getExit() {
            return this.f7463g;
        }

        public String getExitInstructions() {
            return this.f7466j;
        }

        public String getInstructions() {
            return this.f7467k;
        }

        public int getNumTurns() {
            return this.f7468l;
        }

        public int getRoadLevel() {
            return this.f7471o;
        }

        public String getRoadName() {
            return this.f7472p;
        }

        public int[] getTrafficList() {
            return this.f7470n;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f7464h);
            }
            return this.f7469m;
        }

        public void setDirection(int i4) {
            this.f7461e = i4;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f7462f = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.f7465i = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f7463g = routeNode;
        }

        public void setExitInstructions(String str) {
            this.f7466j = str;
        }

        public void setInstructions(String str) {
            this.f7467k = str;
        }

        public void setNumTurns(int i4) {
            this.f7468l = i4;
        }

        public void setPathList(List<LatLng> list) {
            this.f7469m = list;
        }

        public void setPathString(String str) {
            this.f7464h = str;
        }

        public void setRoadLevel(int i4) {
            this.f7471o = i4;
        }

        public void setRoadName(String str) {
            this.f7472p = str;
        }

        public void setTrafficList(int[] iArr) {
            this.f7470n = iArr;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f7461e);
            parcel.writeParcelable(this.f7462f, 1);
            parcel.writeParcelable(this.f7463g, 1);
            parcel.writeString(this.f7464h);
            parcel.writeString(this.f7465i);
            parcel.writeString(this.f7466j);
            parcel.writeString(this.f7467k);
            parcel.writeInt(this.f7468l);
            parcel.writeTypedList(this.f7469m);
            parcel.writeIntArray(this.f7470n);
            parcel.writeInt(this.f7471o);
            parcel.writeString(this.f7472p);
        }

        public DrivingStep(Parcel parcel) {
            super(parcel);
            this.f7461e = parcel.readInt();
            this.f7462f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7463g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7464h = parcel.readString();
            this.f7465i = parcel.readString();
            this.f7466j = parcel.readString();
            this.f7467k = parcel.readString();
            this.f7468l = parcel.readInt();
            this.f7469m = parcel.createTypedArrayList(LatLng.CREATOR);
            this.f7470n = parcel.createIntArray();
            this.f7471o = parcel.readInt();
            this.f7472p = parcel.readString();
        }
    }

    public static class a implements Parcelable.Creator<DrivingRouteLine> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrivingRouteLine createFromParcel(Parcel parcel) {
            return new DrivingRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrivingRouteLine[] newArray(int i4) {
            return new DrivingRouteLine[i4];
        }
    }

    public DrivingRouteLine() {
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCongestionDistance() {
        return this.f7458k;
    }

    public int getLightNum() {
        return this.f7459l;
    }

    public int getToll() {
        return this.f7460m;
    }

    public List<RouteNode> getWayPoints() {
        return this.f7457j;
    }

    @Deprecated
    public boolean isSupportTraffic() {
        return this.f7456i;
    }

    public void setCongestionDistance(int i4) {
        this.f7458k = i4;
    }

    public void setLightNum(int i4) {
        this.f7459l = i4;
    }

    public void setSupportTraffic(boolean z4) {
        this.f7456i = z4;
    }

    public void setToll(int i4) {
        this.f7460m = i4;
    }

    public void setWayPoints(List<RouteNode> list) {
        this.f7457j = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.setType(RouteLine.TYPE.DRIVESTEP);
        super.writeToParcel(parcel, i4);
        parcel.writeByte(this.f7456i ? (byte) 1 : (byte) 0);
        parcel.writeList(this.f7457j);
        parcel.writeInt(this.f7458k);
        parcel.writeInt(this.f7459l);
        parcel.writeInt(this.f7460m);
    }

    public DrivingRouteLine(Parcel parcel) {
        super(parcel);
        this.f7456i = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        this.f7457j = arrayList;
        parcel.readList(arrayList, RouteNode.class.getClassLoader());
        this.f7458k = parcel.readInt();
        this.f7459l = parcel.readInt();
        this.f7460m = parcel.readInt();
    }
}
