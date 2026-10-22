package com.bytedance.android.shopping.api.mall.common.feed.jsb;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallPreloadResourceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function6<? super String, ? super String, ? super String, ? super Integer, ? super Integer, ? super Function1<? super ConcurrentHashMap<String, Object>, Unit>, Unit> f170271a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f170272b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f170273c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference<String> f170274d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f170275e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f170276f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<ConcurrentHashMap<String, Object>> f170277g = null;

    static {
        f170271a = ECMallPreloadResourceHelper$preLoadImageResource$1.INSTANCE;
        f170272b = new AtomicInteger(0);
        f170273c = new AtomicInteger(1);
        f170274d = new AtomicReference("success: all preload success");
        f170275e = new ConcurrentHashMap();
        f170276f = new ConcurrentHashMap();
        f170277g = new ConcurrentLinkedQueue();
    }
}
