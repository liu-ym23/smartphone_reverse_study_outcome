package androidx.camera.video.internal.audio;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AudioSettings {
    public static final List<Integer> COMMON_SAMPLE_RATES = null;

    public static abstract class Builder {
        public abstract AudioSettings autoBuild();

        public abstract Builder setAudioFormat(int r100);

        public abstract Builder setAudioSource(int r100);

        public abstract Builder setChannelCount(int r100);

        public abstract Builder setSampleRate(int r100);

        public final AudioSettings build() {
            AudioSettings r100 = autoBuild();
            if (r100.getAudioSource() != (-1)) goto L5;
            String r101 = " audioSource";
        L7:
            if (r100.getSampleRate() > 0) goto L10;
            r101 = r101 + " sampleRate";
        L10:
            if (r100.getChannelCount() > 0) goto L13;
            r101 = r101 + " channelCount";
        L13:
            if (r100.getAudioFormat() != (-1)) goto L16;
            r101 = r101 + " audioFormat";
        L16:
            if (r101.isEmpty() == false) goto L19;
            return r100;
        L19:
            throw new IllegalArgumentException("Required settings missing or non-positive:".concat(r101));
        L5:
            r101 = "";
            goto L7
        }

        public Builder() {
        }
    }

    static {
        COMMON_SAMPLE_RATES = Collections.unmodifiableList(Arrays.asList(new Integer[]{48000, 44100, 22050, 11025, 8000, 4800}));
    }

    public abstract int getAudioFormat();

    public abstract int getAudioSource();

    public abstract int getChannelCount();

    public abstract int getSampleRate();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_AudioSettings.Builder().setAudioSource(-1).setSampleRate(-1).setChannelCount(-1).setAudioFormat(-1);
    }

    public int getBytesPerFrame() {
        return AudioUtils.getBytesPerFrame(getAudioFormat(), getChannelCount());
    }

    public AudioSettings() {
    }
}
