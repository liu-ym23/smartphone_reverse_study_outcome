package com.bytedance.android.live.revlink.impl.perf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Pair;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f95319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f95320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f95321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f95322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f95323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Pair<Double, Long>> f95324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Double> f95325g;

    public b() {
        this.f95319a = "";
        this.f95323e = new ConcurrentHashMap();
        this.f95324f = new ConcurrentHashMap();
        this.f95325g = new ConcurrentLinkedQueue();
    }

    public final Pair<Double, Long> a(int r100) {
        return this.f95324f.get(Integer.valueOf(r100));
    }
}
