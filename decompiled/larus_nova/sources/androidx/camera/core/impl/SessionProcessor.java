package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.CameraInfo;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface SessionProcessor {

    /* JADX INFO: renamed from: androidx.camera.core.impl.SessionProcessor$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Pair $default$getRealtimeCaptureLatency(SessionProcessor r100) {
            return null;
        }

        public static int $default$startTrigger(SessionProcessor r100, Config r101, TagBundle r102, CaptureCallback r103) {
            return -1;
        }

        public static Set $default$getSupportedCameraOperations(SessionProcessor r100) {
            return Collections.emptySet();
        }

        public static Map $default$getSupportedPostviewSize(SessionProcessor r100, Size r101) {
            return Collections.emptyMap();
        }
    }

    public interface CaptureCallback {

        /* JADX INFO: renamed from: androidx.camera.core.impl.SessionProcessor$CaptureCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCaptureCompleted(CaptureCallback r100, long r101, int r102, CameraCaptureResult r103) {
            }

            public static void $default$onCaptureFailed(CaptureCallback r100, int r101) {
            }

            public static void $default$onCaptureProcessProgressed(CaptureCallback r100, int r101) {
            }

            public static void $default$onCaptureProcessStarted(CaptureCallback r100, int r101) {
            }

            public static void $default$onCaptureSequenceAborted(CaptureCallback r100, int r101) {
            }

            public static void $default$onCaptureSequenceCompleted(CaptureCallback r100, int r101) {
            }

            public static void $default$onCaptureStarted(CaptureCallback r100, int r101, long r102) {
            }
        }

        void onCaptureCompleted(long r100, int r101, CameraCaptureResult r102);

        void onCaptureFailed(int r100);

        void onCaptureProcessProgressed(int r100);

        void onCaptureProcessStarted(int r100);

        void onCaptureSequenceAborted(int r100);

        void onCaptureSequenceCompleted(int r100);

        void onCaptureStarted(int r100, long r101);
    }

    void abortCapture(int r100);

    void deInitSession();

    Pair<Long, Long> getRealtimeCaptureLatency();

    Set<Integer> getSupportedCameraOperations();

    Map<Integer, List<Size>> getSupportedPostviewSize(Size r100);

    SessionConfig initSession(CameraInfo r100, OutputSurfaceConfiguration r101);

    void onCaptureSessionEnd();

    void onCaptureSessionStart(RequestProcessor r100);

    void setParameters(Config r100);

    int startCapture(boolean r100, TagBundle r101, CaptureCallback r102);

    int startRepeating(TagBundle r100, CaptureCallback r101);

    int startTrigger(Config r100, TagBundle r101, CaptureCallback r102);

    void stopRepeating();
}
