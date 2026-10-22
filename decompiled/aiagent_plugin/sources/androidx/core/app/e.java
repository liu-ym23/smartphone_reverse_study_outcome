package androidx.core.app;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: FrameMetricsAggregator.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: compiled from: FrameMetricsAggregator.java */
    private static class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static HandlerThread f1076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static Handler f1077d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        SparseIntArray[] f1079b;

        static {
        }

        void a(SparseIntArray r5, long r6) {
            if (r5 == null) goto L7;
            int r4 = (int) ((500000 + r6) / 1000000);
            if (r6 < 0) goto L8;
            r5.put(r4, r5.get(r4) + 1);
            return;
        L8:
            return;
        }
    }

    /* JADX INFO: compiled from: FrameMetricsAggregator.java */
    private static class b {
    }
}
