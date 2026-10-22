package androidx.camera.video.internal;

import android.util.Rational;
import androidx.arch.core.util.Function;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BackupHdrProfileEncoderProfilesProvider implements EncoderProfilesProvider {
    private static final String TAG = "BackupHdrProfileEncoderProfilesProvider";
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache;
    private final EncoderProfilesProvider mEncoderProfilesProvider;
    private final Function<VideoEncoderConfig, VideoEncoderInfo> mVideoEncoderInfoFinder;

    private static int deriveCodec(int r100) {
        if (r100 != 0) goto L4;
        return 5;
    L4:
        if (r100 != 1) goto L6;
        return 5;
    L6:
        if (r100 != 2) goto L8;
        return 5;
    L8:
        if (r100 != 3) goto L10;
        return 5;
    L10:
        if (r100 != 4) goto L13;
        return 5;
    L13:
        throw new IllegalArgumentException("Unexpected HDR format: " + r100);
    }

    private static String deriveMediaType(int r100) {
        return EncoderProfilesProxy.CC.getVideoCodecMimeType(r100);
    }

    private static int deriveProfile(int r100) {
        if (r100 != 0) goto L5;
        return 1;
    L5:
        if (r100 == 1) goto L19;
        if (r100 != 2) goto L8;
        return 4096;
    L8:
        if (r100 != 3) goto L10;
        return 8192;
    L10:
        if (r100 != 4) goto L14;
        return -1;
    L14:
        throw new IllegalArgumentException("Unexpected HDR format: " + r100);
    L19:
        return 2;
    }

    private EncoderProfilesProxy getProfilesInternal(int r100) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(r100)) == false) goto L7;
        return this.mEncoderProfilesCache.get(Integer.valueOf(r100));
    L7:
        if (this.mEncoderProfilesProvider.hasProfile(r100) == false) goto L9;
        EncoderProfilesProxy r101 = appendBackupVideoProfile(this.mEncoderProfilesProvider.getAll(r100), 1, 10);
        this.mEncoderProfilesCache.put(Integer.valueOf(r100), r101);
        return r101;
    L9:
        return null;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r100) {
        return getProfilesInternal(r100);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r100) {
        if (this.mEncoderProfilesProvider.hasProfile(r100) == true) goto L6;
        return false;
    L6:
        if (getProfilesInternal(r100) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public BackupHdrProfileEncoderProfilesProvider(EncoderProfilesProvider r100, Function<VideoEncoderConfig, VideoEncoderInfo> r101) {
        this.mEncoderProfilesCache = new HashMap();
        this.mEncoderProfilesProvider = r100;
        this.mVideoEncoderInfoFinder = r101;
    }

    private static EncoderProfilesProxy.VideoProfileProxy modifyBitrate(EncoderProfilesProxy.VideoProfileProxy r110, int r111) {
        return EncoderProfilesProxy.VideoProfileProxy.create(r110.getCodec(), r110.getMediaType(), r111, r110.getFrameRate(), r110.getWidth(), r110.getHeight(), r110.getProfile(), r110.getBitDepth(), r110.getChromaSubsampling(), r110.getHdrFormat());
    }

    public static EncoderProfilesProxy.VideoProfileProxy validateOrAdapt(EncoderProfilesProxy.VideoProfileProxy r100, Function<VideoEncoderConfig, VideoEncoderInfo> r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        VideoEncoderConfig r102 = VideoConfigUtil.toVideoEncoderConfig(r100);
        VideoEncoderInfo r103 = r101.apply(r102);
        if (r103 != null) goto L8;
    L15:
        return null;
    L8:
        if (r103.isSizeSupportedAllowSwapping(r100.getWidth(), r100.getHeight()) == false) goto L15;
        int r104 = r102.getBitrate();
        int r105 = ((Integer) r103.getSupportedBitrateRange().clamp(Integer.valueOf(r104))).intValue();
        if (r105 != r104) goto L14;
        return r100;
    L14:
        return modifyBitrate(r100, r105);
    }

    private EncoderProfilesProxy appendBackupVideoProfile(EncoderProfilesProxy r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r103 = new ArrayList(r100.getVideoProfiles());
        Iterator<EncoderProfilesProxy.VideoProfileProxy> r104 = r100.getVideoProfiles().iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        EncoderProfilesProxy.VideoProfileProxy r105 = r104.next();
        if (r105.getHdrFormat() != 0) goto L7;
    L12:
        EncoderProfilesProxy.VideoProfileProxy r106 = validateOrAdapt(generateBackupProfile(r105, r101, r102), this.mVideoEncoderInfoFinder);
        if (r106 == null) goto L16;
        r103.add(r106);
    L16:
        if (r103.isEmpty() == false) goto L19;
        return null;
    L19:
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r100.getDefaultDurationSeconds(), r100.getRecommendedFileFormat(), r100.getAudioProfiles(), r103);
    L11:
        r105 = null;
        goto L12
    }

    private static EncoderProfilesProxy.VideoProfileProxy generateBackupProfile(EncoderProfilesProxy.VideoProfileProxy r110, int r111, int r112) {
        if (r110 != null) goto L5;
        return null;
    L5:
        int r100 = r110.getCodec();
        String r101 = r110.getMediaType();
        int r102 = r110.getProfile();
        if (r111 == r110.getHdrFormat()) goto L8;
        r100 = deriveCodec(r111);
        r101 = deriveMediaType(r100);
        r102 = deriveProfile(r111);
    L8:
        int r103 = scaleBitrate(r110.getBitrate(), r112, r110.getBitDepth());
        int r104 = r110.getFrameRate();
        int r105 = r110.getWidth();
        int r106 = r110.getHeight();
        return EncoderProfilesProxy.VideoProfileProxy.create(r100, r101, r103, r104, r105, r106, r102, r112, r110.getChromaSubsampling(), r111);
    }

    private static int scaleBitrate(int r100, int r101, int r102) {
        if (r101 != r102) goto L4;
        return r100;
    L4:
        int r103 = (int) (((double) r100) * new Rational(r101, r102).doubleValue());
        if (Logger.isDebugEnabled(TAG) == false) goto L7;
        Logger.d(TAG, String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) = %d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103)}));
    L7:
        return r103;
    }
}
