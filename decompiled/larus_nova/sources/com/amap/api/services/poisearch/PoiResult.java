package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class PoiResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f28996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<PoiItem> f28997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PoiSearch.Query f28998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PoiSearch.SearchBound f28999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f29000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<SuggestionCity> f29001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f29002g;

    public final PoiSearch.SearchBound getBound() {
        return this.f28999d;
    }

    public final int getPageCount() {
        return this.f28996a;
    }

    public final ArrayList<PoiItem> getPois() {
        return this.f28997b;
    }

    public final PoiSearch.Query getQuery() {
        return this.f28998c;
    }

    public final List<SuggestionCity> getSearchSuggestionCitys() {
        return this.f29001f;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f29000e;
    }

    private PoiResult(PoiSearch.Query r100, PoiSearch.SearchBound r101, List<String> r102, List<SuggestionCity> r103, int r104, int r105, ArrayList<PoiItem> r106) {
        this.f28997b = new ArrayList();
        this.f28998c = r100;
        this.f28999d = r101;
        this.f29000e = r102;
        this.f29001f = r103;
        this.f29002g = r104;
        this.f28996a = ((r105 + r104) - 1) / r104;
        this.f28997b = r106;
    }

    public static PoiResult createPagedResult(PoiSearch.Query r100, PoiSearch.SearchBound r110, List<String> r111, List<SuggestionCity> r112, int r113, int r114, ArrayList<PoiItem> r115) {
        return new PoiResult(r100, r110, r111, r112, r113, r114, r115);
    }
}
