package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class BusStationResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f28792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<BusStationItem> f28793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BusStationQuery f28794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f28795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<SuggestionCity> f28796e;

    public final List<BusStationItem> getBusStations() {
        return this.f28793b;
    }

    public final int getPageCount() {
        return this.f28792a;
    }

    public final BusStationQuery getQuery() {
        return this.f28794c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.f28796e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f28795d;
    }

    private BusStationResult(BusStationQuery r100, int r101, List<SuggestionCity> r102, List<String> r103, ArrayList<BusStationItem> r104) {
        this.f28793b = new ArrayList();
        this.f28795d = new ArrayList();
        this.f28796e = new ArrayList();
        this.f28794c = r100;
        int r105 = r100.getPageSize();
        int r106 = ((r101 + r105) - 1) / r105;
        if (r106 <= 30) goto L5;
        r106 = 30;
    L5:
        this.f28792a = r106;
        this.f28796e = r102;
        this.f28795d = r103;
        this.f28793b = r104;
    }

    public static BusStationResult createPagedResult(BusStationQuery r100, int r101, List<SuggestionCity> r102, List<String> r110, ArrayList<BusStationItem> r111) {
        return new BusStationResult(r100, r101, r102, r110, r111);
    }
}
