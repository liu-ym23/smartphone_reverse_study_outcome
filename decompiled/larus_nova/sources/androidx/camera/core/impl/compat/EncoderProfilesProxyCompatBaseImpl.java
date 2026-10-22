package androidx.camera.core.impl.compat;

import android.media.CamcorderProfile;
import androidx.camera.core.impl.EncoderProfilesProxy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class EncoderProfilesProxyCompatBaseImpl {
    private EncoderProfilesProxyCompatBaseImpl() {
    }

    public static EncoderProfilesProxy from(CamcorderProfile r100) {
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r100.duration, r100.fileFormat, toAudioProfiles(r100), toVideoProfiles(r100));
    }

    private static List<EncoderProfilesProxy.AudioProfileProxy> toAudioProfiles(CamcorderProfile r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.audioCodec;
        r101.add(EncoderProfilesProxy.AudioProfileProxy.create(r102, EncoderProfilesProxy.CC.getAudioCodecMimeType(r102), r100.audioBitRate, r100.audioSampleRate, r100.audioChannels, EncoderProfilesProxy.CC.getRequiredAudioProfile(r100.audioCodec)));
        return r101;
    }

    private static List<EncoderProfilesProxy.VideoProfileProxy> toVideoProfiles(CamcorderProfile r110) {
        ArrayList r100 = new ArrayList();
        int r101 = r110.videoCodec;
        r100.add(EncoderProfilesProxy.VideoProfileProxy.create(r101, EncoderProfilesProxy.CC.getVideoCodecMimeType(r101), r110.videoBitRate, r110.videoFrameRate, r110.videoFrameWidth, r110.videoFrameHeight, -1, 8, 0, 0));
        return r100;
    }
}
