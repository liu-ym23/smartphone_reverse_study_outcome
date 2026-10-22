package androidx.camera.core.impl;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface RequestProcessor {

    public interface Callback {

        /* JADX INFO: renamed from: androidx.camera.core.impl.RequestProcessor$Callback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCaptureBufferLost(Callback r100, Request r101, long r102, int r103) {
            }

            public static void $default$onCaptureCompleted(Callback r100, Request r101, CameraCaptureResult r102) {
            }

            public static void $default$onCaptureFailed(Callback r100, Request r101, CameraCaptureFailure r102) {
            }

            public static void $default$onCaptureProgressed(Callback r100, Request r101, CameraCaptureResult r102) {
            }

            public static void $default$onCaptureSequenceAborted(Callback r100, int r101) {
            }

            public static void $default$onCaptureSequenceCompleted(Callback r100, int r101, long r102) {
            }

            public static void $default$onCaptureStarted(Callback r100, Request r101, long r102, long r103) {
            }
        }

        void onCaptureBufferLost(Request r100, long r101, int r102);

        void onCaptureCompleted(Request r100, CameraCaptureResult r101);

        void onCaptureFailed(Request r100, CameraCaptureFailure r101);

        void onCaptureProgressed(Request r100, CameraCaptureResult r101);

        void onCaptureSequenceAborted(int r100);

        void onCaptureSequenceCompleted(int r100, long r101);

        void onCaptureStarted(Request r100, long r101, long r102);
    }

    public interface Request {
        Config getParameters();

        List<Integer> getTargetOutputConfigIds();

        int getTemplateId();
    }

    void abortCaptures();

    int setRepeating(Request r100, Callback r101);

    void stopRepeating();

    int submit(Request r100, Callback r101);

    int submit(List<Request> r100, Callback r101);
}
