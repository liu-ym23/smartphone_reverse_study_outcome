package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BusInfo;
import com.baidu.mapapi.search.core.CoachInfo;
import com.baidu.mapapi.search.core.PlaneInfo;
import com.baidu.mapapi.search.core.PriceInfo;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TrainInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class MassTransitRouteLine extends RouteLine<TransitStep> implements Parcelable {
    public static final Parcelable.Creator<MassTransitRouteLine> CREATOR = new a();

    /* renamed from: i, reason: collision with root package name */
    private String f7497i;

    /* renamed from: j, reason: collision with root package name */
    private double f7498j;

    /* renamed from: k, reason: collision with root package name */
    private List<PriceInfo> f7499k;

    /* renamed from: l, reason: collision with root package name */
    private List<List<TransitStep>> f7500l;

    public static class TransitStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<TransitStep> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        private List<TrafficCondition> f7501e;

        /* renamed from: f, reason: collision with root package name */
        private LatLng f7502f;

        /* renamed from: g, reason: collision with root package name */
        private LatLng f7503g;

        /* renamed from: h, reason: collision with root package name */
        private TrainInfo f7504h;

        /* renamed from: i, reason: collision with root package name */
        private PlaneInfo f7505i;

        /* renamed from: j, reason: collision with root package name */
        private CoachInfo f7506j;

        /* renamed from: k, reason: collision with root package name */
        private BusInfo f7507k;

        /* renamed from: l, reason: collision with root package name */
        private StepVehicleInfoType f7508l;

        /* renamed from: m, reason: collision with root package name */
        private String f7509m;

        /* renamed from: n, reason: collision with root package name */
        private String f7510n;

        public enum StepVehicleInfoType {
            ESTEP_TRAIN(1),
            ESTEP_PLANE(2),
            ESTEP_BUS(3),
            ESTEP_DRIVING(4),
            ESTEP_WALK(5),
            ESTEP_COACH(6);


            /* renamed from: a, reason: collision with root package name */
            private int f7511a;

            StepVehicleInfoType(int i4) {
                this.f7511a = i4;
            }

            public int getInt() {
                return this.f7511a;
            }
        }

        public static class TrafficCondition implements Parcelable {
            public static final Parcelable.Creator<TrafficCondition> CREATOR = new a();

            /* renamed from: a, reason: collision with root package name */
            private int f7512a;

            /* renamed from: b, reason: collision with root package name */
            private int f7513b;

            public static class a implements Parcelable.Creator<TrafficCondition> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public TrafficCondition createFromParcel(Parcel parcel) {
                    return new TrafficCondition(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public TrafficCondition[] newArray(int i4) {
                    return new TrafficCondition[i4];
                }
            }

            public TrafficCondition() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public int getTrafficGeoCnt() {
                return this.f7513b;
            }

            public int getTrafficStatus() {
                return this.f7512a;
            }

            public void setTrafficGeoCnt(int i4) {
                this.f7513b = i4;
            }

            public void setTrafficStatus(int i4) {
                this.f7512a = i4;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i4) {
                parcel.writeInt(this.f7512a);
                parcel.writeInt(this.f7513b);
            }

            public TrafficCondition(Parcel parcel) {
                this.f7512a = parcel.readInt();
                this.f7513b = parcel.readInt();
            }
        }

        public static class a implements Parcelable.Creator<TransitStep> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TransitStep createFromParcel(Parcel parcel) {
                return new TransitStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TransitStep[] newArray(int i4) {
                return new TransitStep[i4];
            }
        }

        public TransitStep() {
        }

        private List<LatLng> a(String str) {
            String[] strArrSplit;
            ArrayList arrayList = new ArrayList();
            String[] strArrSplit2 = str.split(";");
            if (strArrSplit2 != null) {
                for (String str2 : strArrSplit2) {
                    if (str2 != null && str2 != "" && (strArrSplit = str2.split(",")) != null && strArrSplit[1] != "" && strArrSplit[0] != "") {
                        LatLng latLng = new LatLng(Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[0]));
                        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                            latLng = CoordTrans.baiduToGcj(latLng);
                        }
                        arrayList.add(latLng);
                    }
                }
            }
            return arrayList;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public BusInfo getBusInfo() {
            return this.f7507k;
        }

        public CoachInfo getCoachInfo() {
            return this.f7506j;
        }

        public LatLng getEndLocation() {
            return this.f7503g;
        }

        public String getInstructions() {
            return this.f7509m;
        }

        public PlaneInfo getPlaneInfo() {
            return this.f7505i;
        }

        public LatLng getStartLocation() {
            return this.f7502f;
        }

        public List<TrafficCondition> getTrafficConditions() {
            return this.f7501e;
        }

        public TrainInfo getTrainInfo() {
            return this.f7504h;
        }

        public StepVehicleInfoType getVehileType() {
            return this.f7508l;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = a(this.f7510n);
            }
            return this.mWayPoints;
        }

        public void setBusInfo(BusInfo busInfo) {
            this.f7507k = busInfo;
        }

        public void setCoachInfo(CoachInfo coachInfo) {
            this.f7506j = coachInfo;
        }

        public void setEndLocation(LatLng latLng) {
            this.f7503g = latLng;
        }

        public void setInstructions(String str) {
            this.f7509m = str;
        }

        public void setPathString(String str) {
            this.f7510n = str;
        }

        public void setPlaneInfo(PlaneInfo planeInfo) {
            this.f7505i = planeInfo;
        }

        public void setStartLocation(LatLng latLng) {
            this.f7502f = latLng;
        }

        public void setTrafficConditions(List<TrafficCondition> list) {
            this.f7501e = list;
        }

        public void setTrainInfo(TrainInfo trainInfo) {
            this.f7504h = trainInfo;
        }

        public void setVehileType(StepVehicleInfoType stepVehicleInfoType) {
            this.f7508l = stepVehicleInfoType;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeTypedList(this.f7501e);
            parcel.writeParcelable(this.f7502f, i4);
            parcel.writeParcelable(this.f7503g, i4);
            parcel.writeParcelable(this.f7504h, i4);
            parcel.writeParcelable(this.f7505i, i4);
            parcel.writeParcelable(this.f7506j, i4);
            parcel.writeParcelable(this.f7507k, i4);
            parcel.writeInt(this.f7508l.getInt());
            parcel.writeString(this.f7509m);
            parcel.writeString(this.f7510n);
        }

        public TransitStep(Parcel parcel) {
            super(parcel);
            this.f7501e = parcel.createTypedArrayList(TrafficCondition.CREATOR);
            this.f7502f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7503g = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7504h = (TrainInfo) parcel.readParcelable(TrainInfo.class.getClassLoader());
            this.f7505i = (PlaneInfo) parcel.readParcelable(PlaneInfo.class.getClassLoader());
            this.f7506j = (CoachInfo) parcel.readParcelable(CoachInfo.class.getClassLoader());
            this.f7507k = (BusInfo) parcel.readParcelable(BusInfo.class.getClassLoader());
            switch (parcel.readInt()) {
                case 1:
                    this.f7508l = StepVehicleInfoType.ESTEP_TRAIN;
                    break;
                case 2:
                    this.f7508l = StepVehicleInfoType.ESTEP_PLANE;
                    break;
                case 3:
                    this.f7508l = StepVehicleInfoType.ESTEP_BUS;
                    break;
                case 4:
                    this.f7508l = StepVehicleInfoType.ESTEP_DRIVING;
                    break;
                case 5:
                    this.f7508l = StepVehicleInfoType.ESTEP_WALK;
                    break;
                case 6:
                    this.f7508l = StepVehicleInfoType.ESTEP_COACH;
                    break;
            }
            this.f7509m = parcel.readString();
            this.f7510n = parcel.readString();
        }
    }

    public static class a implements Parcelable.Creator<MassTransitRouteLine> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MassTransitRouteLine createFromParcel(Parcel parcel) {
            return new MassTransitRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MassTransitRouteLine[] newArray(int i4) {
            return new MassTransitRouteLine[i4];
        }
    }

    public MassTransitRouteLine() {
        this.f7500l = null;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveTime() {
        return this.f7497i;
    }

    public List<List<TransitStep>> getNewSteps() {
        return this.f7500l;
    }

    public double getPrice() {
        return this.f7498j;
    }

    public List<PriceInfo> getPriceInfo() {
        return this.f7499k;
    }

    public void setArriveTime(String str) {
        this.f7497i = str;
    }

    public void setNewSteps(List<List<TransitStep>> list) {
        this.f7500l = list;
    }

    public void setPrice(double d4) {
        this.f7498j = d4;
    }

    public void setPriceInfo(List<PriceInfo> list) {
        this.f7499k = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        List<List<TransitStep>> list = this.f7500l;
        parcel.writeInt(list == null ? 0 : list.size());
        parcel.writeString(this.f7497i);
        parcel.writeDouble(this.f7498j);
        parcel.writeTypedList(this.f7499k);
        Iterator<List<TransitStep>> it = this.f7500l.iterator();
        while (it.hasNext()) {
            parcel.writeTypedList(it.next());
        }
    }

    public MassTransitRouteLine(Parcel parcel) {
        super(parcel);
        this.f7500l = null;
        int i4 = parcel.readInt();
        this.f7497i = parcel.readString();
        this.f7498j = parcel.readDouble();
        this.f7499k = parcel.createTypedArrayList(PriceInfo.CREATOR);
        if (i4 > 0) {
            this.f7500l = new ArrayList();
            for (int i5 = 0; i5 < i4; i5++) {
                this.f7500l.add(parcel.createTypedArrayList(TransitStep.CREATOR));
            }
        }
    }
}
