package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class BusLineResult {

    /* renamed from: a, reason: collision with root package name */
    private int f17279a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<BusLineItem> f17280b;

    /* renamed from: c, reason: collision with root package name */
    private BusLineQuery f17281c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f17282d;

    /* renamed from: e, reason: collision with root package name */
    private List<SuggestionCity> f17283e;

    private BusLineResult(BusLineQuery busLineQuery, int i10, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        this.f17280b = new ArrayList<>();
        this.f17282d = new ArrayList();
        this.f17283e = new ArrayList();
        this.f17281c = busLineQuery;
        this.f17279a = a(i10);
        this.f17283e = list;
        this.f17282d = list2;
        this.f17280b = arrayList;
    }

    private int a(int i10) {
        int pageSize = ((i10 + r0) - 1) / this.f17281c.getPageSize();
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public static BusLineResult createPagedResult(BusLineQuery busLineQuery, int i10, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        return new BusLineResult(busLineQuery, i10, list, list2, arrayList);
    }

    public List<BusLineItem> getBusLines() {
        return this.f17280b;
    }

    public int getPageCount() {
        return this.f17279a;
    }

    public BusLineQuery getQuery() {
        return this.f17281c;
    }

    public List<SuggestionCity> getSearchSuggestionCities() {
        return this.f17283e;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f17282d;
    }
}
