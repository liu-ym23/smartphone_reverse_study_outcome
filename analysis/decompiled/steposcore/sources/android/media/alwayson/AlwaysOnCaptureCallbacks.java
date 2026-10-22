package android.media.alwayson;

import android.media.steposmanager.AlwaysOnRecordSceneInfo;
import android.media.steposmanager.AlwaysOnRecordSceneSegment;

/* loaded from: classes.dex */
public interface AlwaysOnCaptureCallbacks {
    default void onCapturePipelineStarted(AlwaysOnCaptureAudioFormat format) {
    }

    default void onPcmAvailable(byte[] buffer, int size, long timestampNanos) {
    }

    default void onSceneChanged(AlwaysOnRecordSceneInfo scene) {
    }

    default void onSceneSegmentClosed(AlwaysOnRecordSceneSegment segment) {
    }

    default void onCapturePipelineStopping(int reason) {
    }
}
