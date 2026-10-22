package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class BusLineResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f28776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<BusLineItem> f28777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BusLineQuery f28778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f28779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<SuggestionCity> f28780e;

    public final List<BusLineItem> getBusLines() {
        return this.f28777b;
    }

    public final int getPageCount() {
        return this.f28776a;
    }

    public final BusLineQuery getQuery() {
        return this.f28778c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.f28780e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f28779d;
    }

    private BusLineResult(BusLineQuery r100, int r101, List<SuggestionCity> r102, List<String> r103, ArrayList<BusLineItem> r104) {
        this.f28777b = new ArrayList();
        this.f28779d = new ArrayList();
        this.f28780e = new ArrayList();
        this.f28778c = r100;
        int r105 = r100.getPageSize();
        int r106 = ((r101 + r105) - 1) / r105;
        if (r106 <= 30) goto L5;
        r106 = 30;
    L5:
        this.f28776a = r106;
        this.f28780e = r102;
        this.f28779d = r103;
        this.f28777b = r104;
    }

    public static BusLineResult createPagedResult(BusLineQuery r100, int r101, List<SuggestionCity> r102, List<String> r110, ArrayList<BusLineItem> r111) {
        return new BusLineResult(r100, r101, r102, r110, r111);
    }
}
