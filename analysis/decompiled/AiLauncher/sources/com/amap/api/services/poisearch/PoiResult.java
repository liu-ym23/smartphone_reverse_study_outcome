package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class PoiResult {

    /* renamed from: a, reason: collision with root package name */
    private int f17537a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<PoiItem> f17538b;

    /* renamed from: c, reason: collision with root package name */
    private PoiSearch.Query f17539c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearch.SearchBound f17540d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f17541e;

    /* renamed from: f, reason: collision with root package name */
    private List<SuggestionCity> f17542f;

    /* renamed from: g, reason: collision with root package name */
    private int f17543g;

    private PoiResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i10, int i11, ArrayList<PoiItem> arrayList) {
        this.f17538b = new ArrayList<>();
        this.f17539c = query;
        this.f17540d = searchBound;
        this.f17541e = list;
        this.f17542f = list2;
        this.f17543g = i10;
        this.f17537a = a(i11);
        this.f17538b = arrayList;
    }

    private int a(int i10) {
        return ((i10 + r0) - 1) / this.f17543g;
    }

    public static PoiResult createPagedResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i10, int i11, ArrayList<PoiItem> arrayList) {
        return new PoiResult(query, searchBound, list, list2, i10, i11, arrayList);
    }

    public PoiSearch.SearchBound getBound() {
        return this.f17540d;
    }

    public int getPageCount() {
        return this.f17537a;
    }

    public ArrayList<PoiItem> getPois() {
        return this.f17538b;
    }

    public PoiSearch.Query getQuery() {
        return this.f17539c;
    }

    public List<SuggestionCity> getSearchSuggestionCitys() {
        return this.f17542f;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f17541e;
    }
}
