package androidx.camera.video;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: classes2.dex */
public interface VideoOutput {

    /* JADX INFO: renamed from: androidx.camera.video.VideoOutput$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onSourceStateChanged(VideoOutput r100, SourceState r101) {
        }

        public static Observable $default$getMediaSpec(VideoOutput r100) {
            return ConstantObservable.withValue(null);
        }

        public static Observable $default$getStreamInfo(VideoOutput r100) {
            return StreamInfo.ALWAYS_ACTIVE_OBSERVABLE;
        }

        public static Observable $default$isSourceStreamRequired(VideoOutput r100) {
            return ConstantObservable.withValue(Boolean.FALSE);
        }

        public static VideoCapabilities $default$getMediaCapabilities(VideoOutput r100, CameraInfo r101) {
            return VideoCapabilities.EMPTY;
        }

        public static void $default$onSurfaceRequested(VideoOutput r100, SurfaceRequest r101, Timebase r102) {
            r100.onSurfaceRequested(r101);
        }
    }

    public static final enum SourceState extends Enum<SourceState> {
        private static final /* synthetic */ SourceState[] $VALUES = null;
        public static final SourceState ACTIVE_NON_STREAMING = null;
        public static final SourceState ACTIVE_STREAMING = null;
        public static final SourceState INACTIVE = null;

        private static /* synthetic */ SourceState[] $values() {
            return new SourceState[]{ACTIVE_STREAMING, ACTIVE_NON_STREAMING, INACTIVE};
        }

        static {
            ACTIVE_STREAMING = new SourceState("ACTIVE_STREAMING", 0);
            ACTIVE_NON_STREAMING = new SourceState("ACTIVE_NON_STREAMING", 1);
            INACTIVE = new SourceState("INACTIVE", 2);
            $VALUES = $values();
        }

        public static SourceState[] values() {
            return (SourceState[]) $VALUES.clone();
        }

        public static SourceState valueOf(String r100) {
            return (SourceState) r27.a.a(SourceState.class, r100);
        }

        private SourceState(String r100, int r101) {
            super(r100, r101);
        }
    }

    VideoCapabilities getMediaCapabilities(CameraInfo r100);

    Observable<MediaSpec> getMediaSpec();

    Observable<StreamInfo> getStreamInfo();

    Observable<Boolean> isSourceStreamRequired();

    void onSourceStateChanged(SourceState r100);

    void onSurfaceRequested(SurfaceRequest r100);

    void onSurfaceRequested(SurfaceRequest r100, Timebase r101);
}
