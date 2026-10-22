package com.bytedance.android.livesdk.revenue.service.performance;

/* JADX INFO: loaded from: classes11.dex */
public interface d extends dy0.a {

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final a f157423i1 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f157424a = null;

        public a() {
        }

        static {
            f157424a = new a();
        }
    }

    static {
        f157423i1 = a.f157424a;
    }

    boolean Jc();

    boolean canLoad(int r100);

    void e6(int r100, lq2.b r101);

    int getCurrentPerformanceLevel();

    long lg();

    void unregisterPerformanceStrategyTask(int r100);
}
