package androidx.camera.core.impl;

import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface EncoderProfilesProxy {
    public static final int CODEC_PROFILE_NONE = -1;

    /* JADX INFO: renamed from: androidx.camera.core.impl.EncoderProfilesProxy$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String getAudioCodecMimeType(int r100) {
            switch(r100) {
                case 1: goto L13;
                case 2: goto L11;
                case 3: goto L9;
                case 4: goto L9;
                case 5: goto L9;
                case 6: goto L7;
                case 7: goto L5;
                default: goto L3;
            };
        L3:
            return AudioProfileProxy.MEDIA_TYPE_NONE;
        L5:
            return "audio/opus";
        L7:
            return "audio/vorbis";
        L9:
            return "audio/mp4a-latm";
        L11:
            return "audio/amr-wb";
        L13:
            return "audio/3gpp";
        }

        public static int getRequiredAudioProfile(int r100) {
            if (r100 != 3) goto L5;
            return 2;
        L5:
            if (r100 == 4) goto L11;
            if (r100 == 5) goto L9;
            return -1;
        L9:
            return 39;
        L11:
            return 5;
        }

        public static String getVideoCodecMimeType(int r100) {
            switch(r100) {
                case 1: goto L19;
                case 2: goto L17;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L7;
                case 8: goto L5;
                default: goto L3;
            };
        L3:
            return VideoProfileProxy.MEDIA_TYPE_NONE;
        L5:
            return "video/av01";
        L7:
            return "video/dolby-vision";
        L9:
            return "video/x-vnd.on2.vp9";
        L11:
            return "video/hevc";
        L13:
            return "video/x-vnd.on2.vp8";
        L15:
            return "video/mp4v-es";
        L17:
            return KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE;
        L19:
            return "video/3gpp";
        }
    }

    public static abstract class AudioProfileProxy {
        public static final String MEDIA_TYPE_NONE = "audio/none";

        @Retention(RetentionPolicy.SOURCE)
        public @interface AudioEncoder {
        }

        public AudioProfileProxy() {
        }

        public abstract int getBitrate();

        public abstract int getChannels();

        public abstract int getCodec();

        public abstract String getMediaType();

        public abstract int getProfile();

        public abstract int getSampleRate();

        public static AudioProfileProxy create(int r100, String r101, int r110, int r111, int r112, int r113) {
            return new AutoValue_EncoderProfilesProxy_AudioProfileProxy(r100, r101, r110, r111, r112, r113);
        }
    }

    public static abstract class ImmutableEncoderProfilesProxy implements EncoderProfilesProxy {
        public ImmutableEncoderProfilesProxy() {
        }

        public static ImmutableEncoderProfilesProxy create(int r100, int r101, List<AudioProfileProxy> r102, List<VideoProfileProxy> r103) {
            return new AutoValue_EncoderProfilesProxy_ImmutableEncoderProfilesProxy(r100, r101, Collections.unmodifiableList(new ArrayList(r102)), Collections.unmodifiableList(new ArrayList(r103)));
        }
    }

    public static abstract class VideoProfileProxy {
        public static final int BIT_DEPTH_10 = 10;
        public static final int BIT_DEPTH_8 = 8;
        public static final String MEDIA_TYPE_NONE = "video/none";

        @Retention(RetentionPolicy.SOURCE)
        public @interface VideoEncoder {
        }

        public VideoProfileProxy() {
        }

        public abstract int getBitDepth();

        public abstract int getBitrate();

        public abstract int getChromaSubsampling();

        public abstract int getCodec();

        public abstract int getFrameRate();

        public abstract int getHdrFormat();

        public abstract int getHeight();

        public abstract String getMediaType();

        public abstract int getProfile();

        public abstract int getWidth();

        public static VideoProfileProxy create(int r110, String r111, int r112, int r113, int r114, int r115, int r116, int r117, int r210, int r211) {
            return new AutoValue_EncoderProfilesProxy_VideoProfileProxy(r110, r111, r112, r113, r114, r115, r116, r117, r210, r211);
        }
    }

    List<AudioProfileProxy> getAudioProfiles();

    int getDefaultDurationSeconds();

    int getRecommendedFileFormat();

    List<VideoProfileProxy> getVideoProfiles();
}
