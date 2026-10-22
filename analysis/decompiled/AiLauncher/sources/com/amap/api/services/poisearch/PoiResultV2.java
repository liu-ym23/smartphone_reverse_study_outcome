package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PoiResultV2 {

    /* renamed from: a, reason: collision with root package name */
    private int f17544a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<PoiItemV2> f17545b;

    /* renamed from: c, reason: collision with root package name */
    private PoiSearchV2.Query f17546c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearchV2.SearchBound f17547d;

    private PoiResultV2(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i10, ArrayList<PoiItemV2> arrayList) {
        new ArrayList();
        this.f17546c = query;
        this.f17547d = searchBound;
        this.f17544a = i10;
        this.f17545b = arrayList;
    }

    public static PoiResultV2 createPagedResult(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i10, ArrayList<PoiItemV2> arrayList) {
        return new PoiResultV2(query, searchBound, i10, arrayList);
    }

    public PoiSearchV2.SearchBound getBound() {
        return this.f17547d;
    }

    public int getCount() {
        return this.f17544a;
    }

    public ArrayList<PoiItemV2> getPois() {
        return this.f17545b;
    }

    public PoiSearchV2.Query getQuery() {
        return this.f17546c;
    }
}
