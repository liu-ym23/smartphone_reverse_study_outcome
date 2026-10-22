package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BikingRouteLine extends RouteLine<BikingStep> implements Parcelable {
    public static final Parcelable.Creator<BikingRouteLine> CREATOR = new a();

    public static class BikingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<BikingStep> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        private int f7442e;

        /* renamed from: f, reason: collision with root package name */
        private RouteNode f7443f;

        /* renamed from: g, reason: collision with root package name */
        private RouteNode f7444g;

        /* renamed from: h, reason: collision with root package name */
        private String f7445h;

        /* renamed from: i, reason: collision with root package name */
        private String f7446i;

        /* renamed from: j, reason: collision with root package name */
        private String f7447j;

        /* renamed from: k, reason: collision with root package name */
        private String f7448k;

        /* renamed from: l, reason: collision with root package name */
        private String f7449l;

        /* renamed from: m, reason: collision with root package name */
        private String f7450m;

        /* renamed from: n, reason: collision with root package name */
        private int f7451n;

        public static class a implements Parcelable.Creator<BikingStep> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public BikingStep createFromParcel(Parcel parcel) {
                return new BikingStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public BikingStep[] newArray(int i4) {
                return new BikingStep[i4];
            }
        }

        public BikingStep() {
        }

        private List<LatLng> a(String str) {
            if (str != null && str.length() != 0) {
                ArrayList arrayList = new ArrayList();
                String[] strArrSplit = str.split(";");
                if (strArrSplit != null && strArrSplit.length != 0) {
                    for (String str2 : strArrSplit) {
                        String[] strArrSplit2 = str2.split(",");
                        if (strArrSplit2 != null && strArrSplit2.length >= 2) {
                            LatLng latLng = new LatLng(Double.valueOf(strArrSplit2[1]).doubleValue(), Double.valueOf(strArrSplit2[0]).doubleValue());
                            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                                latLng = CoordTrans.baiduToGcj(latLng);
                            }
                            arrayList.add(latLng);
                        }
                    }
                    return arrayList;
                }
            }
            return null;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f7442e;
        }

        public RouteNode getEntrance() {
            return this.f7443f;
        }

        public String getEntranceInstructions() {
            return this.f7446i;
        }

        public RouteNode getExit() {
            return this.f7444g;
        }

        public String getExitInstructions() {
            return this.f7447j;
        }

        public String getInstructions() {
            return this.f7448k;
        }

        public String getRestrictionsInfo() {
            return this.f7450m;
        }

        public int getRestrictionsStatus() {
            return this.f7451n;
        }

        public String getTurnType() {
            return this.f7449l;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = a(this.f7445h);
            }
            return this.mWayPoints;
        }

        public void setDirection(int i4) {
            this.f7442e = i4;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f7443f = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.f7446i = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f7444g = routeNode;
        }

        public void setExitInstructions(String str) {
            this.f7447j = str;
        }

        public void setInstructions(String str) {
            this.f7448k = str;
        }

        public void setPathString(String str) {
            this.f7445h = str;
        }

        public void setRestrictionsInfo(String str) {
            this.f7450m = str;
        }

        public void setRestrictionsStatus(int i4) {
            this.f7451n = i4;
        }

        public void setTurnType(String str) {
            this.f7449l = str;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, 1);
            parcel.writeInt(this.f7442e);
            parcel.writeParcelable(this.f7443f, 1);
            parcel.writeParcelable(this.f7444g, 1);
            parcel.writeString(this.f7445h);
            parcel.writeString(this.f7446i);
            parcel.writeString(this.f7447j);
            parcel.writeString(this.f7448k);
            parcel.writeString(this.f7449l);
        }

        public BikingStep(Parcel parcel) {
            super(parcel);
            this.f7442e = parcel.readInt();
            this.f7443f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7444g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7445h = parcel.readString();
            this.f7446i = parcel.readString();
            this.f7447j = parcel.readString();
            this.f7448k = parcel.readString();
            this.f7449l = parcel.readString();
        }
    }

    public static class a implements Parcelable.Creator<BikingRouteLine> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BikingRouteLine createFromParcel(Parcel parcel) {
            return new BikingRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BikingRouteLine[] newArray(int i4) {
            return new BikingRouteLine[i4];
        }
    }

    public BikingRouteLine() {
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine
    public List<BikingStep> getAllStep() {
        return super.getAllStep();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.setType(RouteLine.TYPE.BIKINGSTEP);
        super.writeToParcel(parcel, 1);
    }

    public BikingRouteLine(Parcel parcel) {
        super(parcel);
    }
}
