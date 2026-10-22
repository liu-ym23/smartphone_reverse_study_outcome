package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class RouteParaOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LatLng f31745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LatLng f31746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f31747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f31748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f31749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f31750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f31751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    EBusStrategyType f31752h;

    public static final enum EBusStrategyType extends Enum<EBusStrategyType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ EBusStrategyType[] f31753a = null;
        public static final EBusStrategyType bus_no_subway = null;
        public static final EBusStrategyType bus_recommend_way = null;
        public static final EBusStrategyType bus_time_first = null;
        public static final EBusStrategyType bus_transfer_little = null;
        public static final EBusStrategyType bus_walk_little = null;

        static {
            EBusStrategyType r100 = new EBusStrategyType("bus_time_first", 0);
            bus_time_first = r100;
            EBusStrategyType r101 = new EBusStrategyType("bus_transfer_little", 1);
            bus_transfer_little = r101;
            EBusStrategyType r102 = new EBusStrategyType("bus_walk_little", 2);
            bus_walk_little = r102;
            EBusStrategyType r103 = new EBusStrategyType("bus_no_subway", 3);
            bus_no_subway = r103;
            EBusStrategyType r104 = new EBusStrategyType("bus_recommend_way", 4);
            bus_recommend_way = r104;
            f31753a = new EBusStrategyType[]{r100, r101, r102, r103, r104};
        }

        public static EBusStrategyType[] values() {
            return (EBusStrategyType[]) f31753a.clone();
        }

        public static EBusStrategyType valueOf(String r100) {
            return (EBusStrategyType) a.a(EBusStrategyType.class, r100);
        }

        private EBusStrategyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public RouteParaOption() {
        this.f31752h = EBusStrategyType.bus_recommend_way;
    }

    public EBusStrategyType getBusStrategyType() {
        return this.f31752h;
    }

    public String getCityName() {
        return this.f31749e;
    }

    public String getEndName() {
        return this.f31748d;
    }

    public String getEndPoiId() {
        return this.f31751g;
    }

    public LatLng getEndPoint() {
        return this.f31746b;
    }

    public String getStartName() {
        return this.f31747c;
    }

    public String getStartPoiId() {
        return this.f31750f;
    }

    public LatLng getStartPoint() {
        return this.f31745a;
    }

    public RouteParaOption busStrategyType(EBusStrategyType r100) {
        this.f31752h = r100;
        return this;
    }

    public RouteParaOption cityName(String r100) {
        this.f31749e = r100;
        return this;
    }

    public RouteParaOption endName(String r100) {
        this.f31748d = r100;
        return this;
    }

    public RouteParaOption endPoiId(String r100) {
        this.f31751g = r100;
        return this;
    }

    public RouteParaOption endPoint(LatLng r100) {
        this.f31746b = r100;
        return this;
    }

    public RouteParaOption startName(String r100) {
        this.f31747c = r100;
        return this;
    }

    public RouteParaOption startPoiId(String r100) {
        this.f31750f = r100;
        return this;
    }

    public RouteParaOption startPoint(LatLng r100) {
        this.f31745a = r100;
        return this;
    }
}
