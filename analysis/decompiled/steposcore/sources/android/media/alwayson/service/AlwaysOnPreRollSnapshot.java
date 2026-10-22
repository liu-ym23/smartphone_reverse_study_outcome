package android.media.alwayson.service;

import android.media.alwayson.AlwaysOnCaptureAudioFormat;
import android.media.steposmanager.AlwaysOnRecordSceneSegment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AlwaysOnPreRollSnapshot {
    public final long endTimeNanos;
    public final AlwaysOnCaptureAudioFormat format;
    public final byte[] pcm;
    public final List<AlwaysOnRecordSceneSegment> sceneSegments;
    public final int sizeInBytes;
    public final long startTimeNanos;

    public AlwaysOnPreRollSnapshot(byte[] pcm, int sizeInBytes, long startTimeNanos, long endTimeNanos, AlwaysOnCaptureAudioFormat format, List<AlwaysOnRecordSceneSegment> sceneSegments) {
        this.pcm = (byte[]) Objects.requireNonNull(pcm, "pcm");
        this.sizeInBytes = Math.min(sizeInBytes, pcm.length);
        this.startTimeNanos = startTimeNanos;
        this.endTimeNanos = endTimeNanos;
        this.format = (AlwaysOnCaptureAudioFormat) Objects.requireNonNull(format, "format");
        this.sceneSegments = Collections.unmodifiableList(new ArrayList((Collection) Objects.requireNonNull(sceneSegments, "sceneSegments")));
    }
}
