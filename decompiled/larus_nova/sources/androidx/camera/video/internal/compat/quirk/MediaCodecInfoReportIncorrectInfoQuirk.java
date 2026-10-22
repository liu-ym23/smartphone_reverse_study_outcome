package androidx.camera.video.internal.compat.quirk;

import android.media.MediaFormat;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import com.ss.android.ttvecamera.TECameraUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class MediaCodecInfoReportIncorrectInfoQuirk implements Quirk {
    public static final List<String> INCORRECT_FHD_PROFILE_MODEL_LIST = null;

    public static class MediaFormatResolver {
        private final MediaFormat mMediaFormat;

        private String getMime() {
            return this.mMediaFormat.getString("mime");
        }

        public boolean isAvc() {
            return KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE.equalsIgnoreCase(getMime());
        }

        public boolean isMpeg4() {
            return "video/mp4v-es".equalsIgnoreCase(getMime());
        }

        public boolean isVideo() {
            String r100 = getMime();
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.contains("video/") == false) goto L7;
            return true;
        }

        public MediaFormatResolver(MediaFormat r100) {
            this.mMediaFormat = r100;
        }

        public boolean isSize(int r100, int r101) {
            int r102 = this.mMediaFormat.getInteger("width");
            int r103 = this.mMediaFormat.getInteger("height");
            if (r102 != r100) goto L6;
            if (r103 != r101) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public MediaCodecInfoReportIncorrectInfoQuirk() {
    }

    static {
        INCORRECT_FHD_PROFILE_MODEL_LIST = Arrays.asList(new String[]{"lg-k430", "redmi note 4", "m2003j15sc", "m2004j19c", "rmx3231", "v2117", "sm-a032f", "moto g(20)", "sm-a035m", "v2204", "23078pnd5g", "pht110", "23053rn02l", "rmx3710", "rmx3511", "v2207", "moto e20"});
    }

    private static boolean isFHDProblematicDevice() {
        return INCORRECT_FHD_PROFILE_MODEL_LIST.contains(Build.MODEL.toLowerCase(Locale.US));
    }

    private static boolean isHuaweiMate9() {
        if ("Huawei".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("mha-l29".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isMotoC() {
        if ("motorola".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("moto c".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isNokia1() {
        if ("Nokia".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("Nokia 1".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isPositivoTwist2Pro() {
        if ("positivo".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("twist 2 pro".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isRedmiNote8Pro() {
        if ("Redmi".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("Redmi Note 8 Pro".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isX230() {
        if ("LGE".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("LG-X230".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isX650() {
        if ("infinix".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("infinix x650".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static Set<Size> getExtraSupportedSizes() {
        if (isFHDProblematicDevice() == false) goto L7;
        return Collections.singleton(new Size(TECameraUtils.CAPTURE_NORMAL, 1080));
    L7:
        return Collections.emptySet();
    }

    public static boolean load() {
        if (isNokia1() == false) goto L5;
    L20:
        return true;
    L5:
        if (isMotoC() == true) goto L20;
        if (isX650() == true) goto L20;
        if (isX230() == true) goto L20;
        if (isHuaweiMate9() == true) goto L20;
        if (isRedmiNote8Pro() == true) goto L20;
        if (isPositivoTwist2Pro() == true) goto L20;
        if (isFHDProblematicDevice() == true) goto L20;
        return false;
    }

    public boolean isUnSupportMediaCodecInfo(MediaFormat r100) {
        MediaFormatResolver r101 = new MediaFormatResolver(r100);
        if (isNokia1() == true) goto L36;
        if (isMotoC() == true) goto L36;
        if (isX650() == true) goto L36;
        if (isX230() == true) goto L36;
        if (isPositivoTwist2Pro() == true) goto L36;
        if (isHuaweiMate9() == true) goto L29;
        if (isRedmiNote8Pro() == true) goto L29;
        if (isFHDProblematicDevice() == true) goto L21;
        return false;
    L21:
        if (r101.isAvc() == true) goto L23;
    L25:
        return false;
    L23:
        if (r101.isSize(TECameraUtils.CAPTURE_NORMAL, 1080) == false) goto L25;
        return true;
    L29:
        if (r101.isVideo() == true) goto L31;
    L33:
        return false;
    L31:
        if (r101.isSize(3840, 2160) == false) goto L33;
        return true;
    L36:
        return r101.isMpeg4();
    }
}
