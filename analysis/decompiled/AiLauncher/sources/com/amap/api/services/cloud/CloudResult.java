package com.amap.api.services.cloud;

import com.amap.api.services.cloud.CloudSearch;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class CloudResult {

    /* renamed from: a, reason: collision with root package name */
    private int f17312a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<CloudItem> f17313b;

    /* renamed from: c, reason: collision with root package name */
    private int f17314c;

    /* renamed from: d, reason: collision with root package name */
    private int f17315d;

    /* renamed from: e, reason: collision with root package name */
    private CloudSearch.Query f17316e;

    /* renamed from: f, reason: collision with root package name */
    private CloudSearch.SearchBound f17317f;

    private CloudResult(CloudSearch.Query query, int i10, CloudSearch.SearchBound searchBound, int i11, ArrayList<CloudItem> arrayList) {
        this.f17316e = query;
        this.f17314c = i10;
        this.f17315d = i11;
        this.f17312a = a(i10);
        this.f17313b = arrayList;
        this.f17317f = searchBound;
    }

    private int a(int i10) {
        return ((i10 + r0) - 1) / this.f17315d;
    }

    public static CloudResult createPagedResult(CloudSearch.Query query, int i10, CloudSearch.SearchBound searchBound, int i11, ArrayList<CloudItem> arrayList) {
        return new CloudResult(query, i10, searchBound, i11, arrayList);
    }

    public CloudSearch.SearchBound getBound() {
        return this.f17317f;
    }

    public ArrayList<CloudItem> getClouds() {
        return this.f17313b;
    }

    public int getPageCount() {
        return this.f17312a;
    }

    public CloudSearch.Query getQuery() {
        return this.f17316e;
    }

    public int getTotalCount() {
        return this.f17314c;
    }
}
