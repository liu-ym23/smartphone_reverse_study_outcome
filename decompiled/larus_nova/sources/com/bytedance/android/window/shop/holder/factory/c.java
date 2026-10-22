package com.bytedance.android.window.shop.holder.factory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Integer>> f187943a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, Pair<Integer, Integer>> f187944b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pair<Integer, Integer> f187945c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final IntRange f187946d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicInteger f187947e = null;

    static {
        f187943a = new ConcurrentHashMap();
        f187944b = new ConcurrentHashMap();
        f187945c = TuplesKt.to(0, 0);
        f187946d = RangesKt.until(200001, 300000);
        f187947e = new AtomicInteger(200001);
    }
}
