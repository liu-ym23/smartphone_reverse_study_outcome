package androidx.camera.video.internal.utils;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoConfigUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes2.dex */
public class EncoderProfilesUtil {
    private EncoderProfilesUtil() {
    }

    public static EncoderProfilesProxy.VideoProfileProxy getFirstVideoProfile(EncoderProfilesProxy r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.getVideoProfiles().isEmpty() == false) goto L6;
        return null;
    L6:
        return (EncoderProfilesProxy.VideoProfileProxy) ListProtector.get(r100.getVideoProfiles(), 0);
    }

    public static EncoderProfilesProxy.VideoProfileProxy deriveVideoProfile(EncoderProfilesProxy.VideoProfileProxy r110, Size r210, Range<Integer> r211) {
        int r111 = VideoConfigUtil.scaleAndClampBitrate(r110.getBitrate(), r110.getBitDepth(), r110.getBitDepth(), r110.getFrameRate(), r110.getFrameRate(), r210.getWidth(), r110.getWidth(), r210.getHeight(), r110.getHeight(), r211);
        return EncoderProfilesProxy.VideoProfileProxy.create(r110.getCodec(), r110.getMediaType(), r111, r110.getFrameRate(), r210.getWidth(), r210.getHeight(), r110.getProfile(), r110.getBitDepth(), r110.getChromaSubsampling(), r110.getHdrFormat());
    }
}
