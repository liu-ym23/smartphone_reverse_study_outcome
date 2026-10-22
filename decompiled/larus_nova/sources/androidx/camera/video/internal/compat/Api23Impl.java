package androidx.camera.video.internal.compat;

import android.media.AudioFormat;
import android.media.AudioRecord;

/* JADX INFO: loaded from: classes2.dex */
public final class Api23Impl {
    public static AudioRecord.Builder createAudioRecordBuilder() {
        return new AudioRecord.Builder();
    }

    private Api23Impl() {
    }

    public static AudioRecord build(AudioRecord.Builder r100) {
        return r100.build();
    }

    public static void setAudioFormat(AudioRecord.Builder r100, AudioFormat r101) {
        r100.setAudioFormat(r101);
    }

    public static void setAudioSource(AudioRecord.Builder r100, int r101) {
        r100.setAudioSource(r101);
    }

    public static void setBufferSizeInBytes(AudioRecord.Builder r100, int r101) {
        r100.setBufferSizeInBytes(r101);
    }
}
