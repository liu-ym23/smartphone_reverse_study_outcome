package org.tensorflow.lite.task.vision.detector;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.tensorflow.lite.task.vision.core.BaseVisionTaskApi;

/* JADX INFO: loaded from: classes5.dex */
public final class ObjectDetector extends BaseVisionTaskApi {

    public static class ObjectDetectorOptions {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f40665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f40666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f40667c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f40668d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<String> f40669e;
        private final List<String> f;
        private final int g;

        public String getDisplayNamesLocale() {
            return this.f40665a;
        }

        public int getMaxResults() {
            return this.f40666b;
        }

        public float getScoreThreshold() {
            return this.f40667c;
        }

        public boolean getIsScoreThresholdSet() {
            return this.f40668d;
        }

        public List<String> getLabelAllowList() {
            return new ArrayList(this.f40669e);
        }

        public List<String> getLabelDenyList() {
            return new ArrayList(this.f);
        }

        public int getNumThreads() {
            return this.g;
        }
    }

    private native void deinitJni(long r1);

    private static native List<Detection> detectNative(long r0, long r2);

    private static native long initJniWithByteBuffer(ByteBuffer r0, ObjectDetectorOptions r1, long r2);

    private static native long initJniWithModelFdAndOptions(int r0, long r1, long r3, ObjectDetectorOptions r5, long r6);

    @Override // org.tensorflow.lite.task.core.d
    public void a(long r1) {
        deinitJni(r1);
    }
}
