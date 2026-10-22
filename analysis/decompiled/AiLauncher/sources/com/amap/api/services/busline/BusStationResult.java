package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class BusStationResult {

    /* renamed from: a, reason: collision with root package name */
    private int f17297a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<BusStationItem> f17298b;

    /* renamed from: c, reason: collision with root package name */
    private BusStationQuery f17299c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f17300d;

    /* renamed from: e, reason: collision with root package name */
    private List<SuggestionCity> f17301e;

    private BusStationResult(BusStationQuery busStationQuery, int i10, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        this.f17298b = new ArrayList<>();
        this.f17300d = new ArrayList();
        this.f17301e = new ArrayList();
        this.f17299c = busStationQuery;
        this.f17297a = a(i10);
        this.f17301e = list;
        this.f17300d = list2;
        this.f17298b = arrayList;
    }

    private int a(int i10) {
        int pageSize = ((i10 + r0) - 1) / this.f17299c.getPageSize();
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public static BusStationResult createPagedResult(BusStationQuery busStationQuery, int i10, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        return new BusStationResult(busStationQuery, i10, list, list2, arrayList);
    }

    public List<BusStationItem> getBusStations() {
        return this.f17298b;
    }

    public int getPageCount() {
        return this.f17297a;
    }

    public BusStationQuery getQuery() {
        return this.f17299c;
    }

    public List<SuggestionCity> getSearchSuggestionCities() {
        return this.f17301e;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f17300d;
    }
}
