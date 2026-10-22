package com.bytedance.android.shopping.store.hybridproduct;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IntRange f185095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f185096b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f185097c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<Integer, Integer> f185098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentHashMap<Integer, Integer> f185099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ConcurrentHashMap<Integer, Integer> f185100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f185101d;

        public a(int r100) {
            new ConcurrentHashMap();
            this.f185098a = new ConcurrentHashMap();
            this.f185099b = new ConcurrentHashMap();
            this.f185100c = new ConcurrentHashMap();
            this.f185101d = new AtomicInteger(r100);
        }
    }

    static {
        f185095a = RangesKt.until(TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND, 100000);
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new AtomicInteger(0);
        f185096b = new a(0);
        f185097c = new a(TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND);
    }
}
