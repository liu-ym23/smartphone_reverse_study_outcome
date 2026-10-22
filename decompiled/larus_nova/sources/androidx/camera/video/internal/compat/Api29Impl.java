package androidx.camera.video.internal.compat;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class Api29Impl {
    private Api29Impl() {
    }

    public static AudioRecordingConfiguration getActiveRecordingConfiguration(AudioRecord r100) {
        return r100.getActiveRecordingConfiguration();
    }

    public static boolean isClientSilenced(AudioRecordingConfiguration r100) {
        return r100.isClientSilenced();
    }

    public static void unregisterAudioRecordingCallback(AudioRecord r100, AudioManager.AudioRecordingCallback r101) {
        r100.unregisterAudioRecordingCallback(r101);
    }

    public static void registerAudioRecordingCallback(AudioRecord r100, Executor r101, AudioManager.AudioRecordingCallback r102) {
        r100.registerAudioRecordingCallback(r101, r102);
    }
}
