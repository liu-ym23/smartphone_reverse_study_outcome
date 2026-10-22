package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AudioMimeInfo extends MimeInfo {

    public static abstract class Builder extends MimeInfo.Builder<Builder> {
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public abstract AudioMimeInfo build();

        public abstract Builder setCompatibleAudioProfile(EncoderProfilesProxy.AudioProfileProxy r100);

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public /* bridge */ /* synthetic */ MimeInfo build() {
            return build();
        }

        public Builder() {
        }
    }

    public abstract EncoderProfilesProxy.AudioProfileProxy getCompatibleAudioProfile();

    public AudioMimeInfo() {
    }

    public static Builder builder(String r100) {
        return new AutoValue_AudioMimeInfo.Builder().setMimeType(r100).setProfile(-1);
    }
}
