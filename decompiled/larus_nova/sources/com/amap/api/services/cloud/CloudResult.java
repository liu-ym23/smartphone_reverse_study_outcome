package com.amap.api.services.cloud;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public final class CloudResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f28807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<CloudItem> f28808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f28809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CloudSearch.Query f28811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CloudSearch.SearchBound f28812f;

    public final CloudSearch.SearchBound getBound() {
        return this.f28812f;
    }

    public final ArrayList<CloudItem> getClouds() {
        return this.f28808b;
    }

    public final int getPageCount() {
        return this.f28807a;
    }

    public final CloudSearch.Query getQuery() {
        return this.f28811e;
    }

    public final int getTotalCount() {
        return this.f28809c;
    }

    private CloudResult(CloudSearch.Query r100, int r101, CloudSearch.SearchBound r102, int r103, ArrayList<CloudItem> r104) {
        this.f28811e = r100;
        this.f28809c = r101;
        this.f28810d = r103;
        this.f28807a = ((r101 + r103) - 1) / r103;
        this.f28808b = r104;
        this.f28812f = r102;
    }

    public static CloudResult createPagedResult(CloudSearch.Query r100, int r101, CloudSearch.SearchBound r102, int r110, ArrayList<CloudItem> r111) {
        return new CloudResult(r100, r101, r102, r110, r111);
    }
}
