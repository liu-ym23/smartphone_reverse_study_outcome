package androidx.camera.core.impl.compat;

import android.media.EncoderProfiles;
import androidx.camera.core.impl.EncoderProfilesProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class EncoderProfilesProxyCompatApi31Impl {
    private EncoderProfilesProxyCompatApi31Impl() {
    }

    public static EncoderProfilesProxy from(EncoderProfiles r100) {
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r100.getDefaultDurationSeconds(), r100.getRecommendedFileFormat(), fromAudioProfiles(r100.getAudioProfiles()), fromVideoProfiles(r100.getVideoProfiles()));
    }

    private static List<EncoderProfilesProxy.AudioProfileProxy> fromAudioProfiles(List<EncoderProfiles.AudioProfile> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<EncoderProfiles.AudioProfile> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        EncoderProfiles.AudioProfile r103 = r102.next();
        r101.add(EncoderProfilesProxy.AudioProfileProxy.create(r103.getCodec(), r103.getMediaType(), r103.getBitrate(), r103.getSampleRate(), r103.getChannels(), r103.getProfile()));
        goto L4
    L6:
        return r101;
    }

    private static List<EncoderProfilesProxy.VideoProfileProxy> fromVideoProfiles(List<EncoderProfiles.VideoProfile> r110) {
        ArrayList r100 = new ArrayList();
        Iterator<EncoderProfiles.VideoProfile> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L6;
        EncoderProfiles.VideoProfile r101 = r111.next();
        r100.add(EncoderProfilesProxy.VideoProfileProxy.create(r101.getCodec(), r101.getMediaType(), r101.getBitrate(), r101.getFrameRate(), r101.getWidth(), r101.getHeight(), r101.getProfile(), 8, 0, 0));
        goto L4
    L6:
        return r100;
    }
}
