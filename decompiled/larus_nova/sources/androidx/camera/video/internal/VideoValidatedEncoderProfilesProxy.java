package androidx.camera.video.internal;

import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class VideoValidatedEncoderProfilesProxy implements EncoderProfilesProxy {
    public VideoValidatedEncoderProfilesProxy() {
    }

    public abstract EncoderProfilesProxy.AudioProfileProxy getDefaultAudioProfile();

    public abstract EncoderProfilesProxy.VideoProfileProxy getDefaultVideoProfile();

    public static VideoValidatedEncoderProfilesProxy from(EncoderProfilesProxy r100) {
        return create(r100.getDefaultDurationSeconds(), r100.getRecommendedFileFormat(), r100.getAudioProfiles(), r100.getVideoProfiles());
    }

    public static VideoValidatedEncoderProfilesProxy create(int r100, int r110, List<EncoderProfilesProxy.AudioProfileProxy> r111, List<EncoderProfilesProxy.VideoProfileProxy> r112) {
        Preconditions.checkArgument(!r112.isEmpty(), "Should contain at least one VideoProfile.");
        EncoderProfilesProxy.VideoProfileProxy r101 = (EncoderProfilesProxy.VideoProfileProxy) ListProtector.get(r112, 0);
        if (r111.isEmpty() == true) goto L5;
        EncoderProfilesProxy.AudioProfileProxy r102 = (EncoderProfilesProxy.AudioProfileProxy) ListProtector.get(r111, 0);
    L7:
        return new AutoValue_VideoValidatedEncoderProfilesProxy(r100, r110, Collections.unmodifiableList(new ArrayList(r111)), Collections.unmodifiableList(new ArrayList(r112)), r102, r101);
    L5:
        r102 = null;
        goto L7
    }
}
