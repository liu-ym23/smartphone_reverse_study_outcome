package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
public class TruckNaviOption extends NaviParaOption {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f31684i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    double f31685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    double f31686k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    double f31687l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    double f31688m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    double f31689n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f31690o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f31691p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    String f31692q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f31693r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f31694s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f31695t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f31696u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f31697v;

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public String getEndName() {
        return super.getEndName();
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public LatLng getEndPoint() {
        return super.getEndPoint();
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public String getNaviRoutePolicy() {
        return super.getNaviRoutePolicy();
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public JSONArray getWayPoint() {
        return super.getWayPoint();
    }

    public TruckNaviOption() {
    }

    public int getAxleCount() {
        return this.f31690o;
    }

    public double getAxleWeight() {
        return this.f31689n;
    }

    public int getDisplacement() {
        return this.f31694s;
    }

    public int getEmissionLimit() {
        return this.f31696u;
    }

    public double getHeight() {
        return this.f31685j;
    }

    public boolean getIsTrailer() {
        return this.f31691p;
    }

    public double getLength() {
        return this.f31688m;
    }

    public int getLoadWeight() {
        return this.f31697v;
    }

    public int getPlateColor() {
        return this.f31693r;
    }

    public String getPlateNumber() {
        return this.f31692q;
    }

    public int getPowerType() {
        return this.f31695t;
    }

    public int getTruckType() {
        return this.f31684i;
    }

    public double getWeight() {
        return this.f31687l;
    }

    public double getWidth() {
        return this.f31686k;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption endName(String r100) {
        return (TruckNaviOption) super.endName(r100);
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption endPoint(LatLng r100) {
        return (TruckNaviOption) super.endPoint(r100);
    }

    public TruckNaviOption setAxleCount(int r100) {
        this.f31690o = r100;
        return this;
    }

    public TruckNaviOption setAxleWeight(double r100) {
        this.f31689n = r100;
        return this;
    }

    public TruckNaviOption setDisplacement(int r100) {
        this.f31694s = r100;
        return this;
    }

    public TruckNaviOption setEmissionLimit(int r100) {
        this.f31696u = r100;
        return this;
    }

    public TruckNaviOption setHeight(double r100) {
        this.f31685j = r100;
        return this;
    }

    public TruckNaviOption setIsTrailer(boolean r100) {
        this.f31691p = r100;
        return this;
    }

    public TruckNaviOption setLength(double r100) {
        this.f31688m = r100;
        return this;
    }

    public TruckNaviOption setLoadWeight(int r100) {
        this.f31697v = r100;
        return this;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption setNaviRoutePolicy(NaviParaOption.NaviRoutePolicy r100) {
        return (TruckNaviOption) super.setNaviRoutePolicy(r100);
    }

    public TruckNaviOption setPlateColor(int r100) {
        this.f31693r = r100;
        return this;
    }

    public TruckNaviOption setPlateNumber(String r100) {
        this.f31692q = r100;
        return this;
    }

    public TruckNaviOption setPowerType(int r100) {
        this.f31695t = r100;
        return this;
    }

    public TruckNaviOption setTruckType(int r100) {
        this.f31684i = r100;
        return this;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption setWayPoint(WayPoint r100) {
        return (TruckNaviOption) super.setWayPoint(r100);
    }

    public TruckNaviOption setWeight(double r100) {
        this.f31687l = r100;
        return this;
    }

    public TruckNaviOption setWidth(double r100) {
        this.f31686k = r100;
        return this;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public /* bridge */ /* synthetic */ NaviParaOption endName(String r100) {
        return endName(r100);
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public /* bridge */ /* synthetic */ NaviParaOption endPoint(LatLng r100) {
        return endPoint(r100);
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public /* bridge */ /* synthetic */ NaviParaOption setNaviRoutePolicy(NaviParaOption.NaviRoutePolicy r100) {
        return setNaviRoutePolicy(r100);
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public /* bridge */ /* synthetic */ NaviParaOption setWayPoint(WayPoint r100) {
        return setWayPoint(r100);
    }
}
