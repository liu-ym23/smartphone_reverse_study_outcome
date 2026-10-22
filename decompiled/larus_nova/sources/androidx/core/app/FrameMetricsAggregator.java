package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.Window;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    private static final int LAST_INDEX = 8;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;
    private final FrameMetricsBaseImpl mInstance;

    public static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {
        private static final int NANOS_PER_MS = 1000000;
        private static final int NANOS_ROUNDING_VALUE = 500000;
        private static Handler sHandler;
        private static HandlerThread sHandlerThread;
        private final ArrayList<WeakReference<Activity>> mActivities;
        Window.OnFrameMetricsAvailableListener mListener;
        SparseIntArray[] mMetrics;
        int mTrackingFlags;

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] reset() {
            SparseIntArray[] r100 = this.mMetrics;
            this.mMetrics = new SparseIntArray[9];
            return r100;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] stop() {
            int r100 = this.mActivities.size() - 1;
        L3:
            if (r100 < 0) goto L9;
            WeakReference r101 = (WeakReference) ListProtector.get(this.mActivities, r100);
            Activity r102 = (Activity) r101.get();
            if (r101.get() == null) goto L7;
            r102.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
            ListProtector.remove(this.mActivities, r100);
        L7:
            r100 = r100 - 1;
            goto L3
        L9:
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] getMetrics() {
            return this.mMetrics;
        }

        public FrameMetricsApi24Impl(int r100) {
            this.mMetrics = new SparseIntArray[9];
            this.mActivities = new ArrayList();
            this.mListener = new AnonymousClass1(this);
            this.mTrackingFlags = r100;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void add(Activity r100) {
            if (sHandlerThread != null) goto L5;
            PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("FrameMetricsAggregator");
            sHandlerThread = r101;
            ThreadMethodProxy.start(r101);
            sHandler = new Handler(sHandlerThread.getLooper());
        L5:
            int r102 = 0;
        L7:
            if (r102 > 8) goto L14;
            SparseIntArray[] r103 = this.mMetrics;
            if (r103[r102] != null) goto L13;
            if ((this.mTrackingFlags & (1 << r102)) == 0) goto L13;
            r103[r102] = new SparseIntArray();
        L13:
            r102 = r102 + 1;
            goto L7
        L14:
            r100.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
            this.mActivities.add(new WeakReference(r100));
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] remove(Activity r100) {
            Iterator<WeakReference<Activity>> r101 = this.mActivities.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            WeakReference<Activity> r102 = r101.next();
            if (r102.get() != r100) goto L4;
            this.mActivities.remove(r102);
        L8:
            r100.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
            return this.mMetrics;
        }

        public void addDurationItem(SparseIntArray r100, long r101) {
            if (r100 == null) goto L7;
            int r102 = (int) ((500000 + r101) / 1000000);
            if (r101 < 0) goto L8;
            r100.put(r102, r100.get(r102) + 1);
            return;
        L8:
            return;
        }
    }

    public static class FrameMetricsBaseImpl {
        public void add(Activity r100) {
        }

        public SparseIntArray[] getMetrics() {
            return null;
        }

        public SparseIntArray[] remove(Activity r100) {
            return null;
        }

        public SparseIntArray[] reset() {
            return null;
        }

        public SparseIntArray[] stop() {
            return null;
        }

        public FrameMetricsBaseImpl() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public SparseIntArray[] getMetrics() {
        return this.mInstance.getMetrics();
    }

    public SparseIntArray[] reset() {
        return this.mInstance.reset();
    }

    public SparseIntArray[] stop() {
        return this.mInstance.stop();
    }

    public FrameMetricsAggregator(int r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        this.mInstance = new FrameMetricsApi24Impl(r100);
        return;
    L5:
        this.mInstance = new FrameMetricsBaseImpl();
    }

    public void add(Activity r100) {
        this.mInstance.add(r100);
    }

    public SparseIntArray[] remove(Activity r100) {
        return this.mInstance.remove(r100);
    }
}
