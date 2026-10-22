package androidx.camera.video.internal.compat;

import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;

/* JADX INFO: loaded from: classes2.dex */
public final class Api24Impl {
    private Api24Impl() {
    }

    public static int getClientAudioSessionId(AudioRecordingConfiguration r100) {
        return r100.getClientAudioSessionId();
    }

    public static int getTimestamp(AudioRecord r100, AudioTimestamp r101, int r102) {
        return r100.getTimestamp(r101, r102);
    }
}
