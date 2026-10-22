package androidx.camera.view.video;

/* JADX INFO: loaded from: classes2.dex */
public class AudioConfig {
    public static final AudioConfig AUDIO_DISABLED = null;
    private final boolean mIsAudioEnabled;

    static {
        AUDIO_DISABLED = new AudioConfig(false);
    }

    public boolean getAudioEnabled() {
        return this.mIsAudioEnabled;
    }

    public AudioConfig(boolean r100) {
        this.mIsAudioEnabled = r100;
    }

    public static AudioConfig create(boolean r100) {
        return new AudioConfig(r100);
    }
}
