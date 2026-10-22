package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.video.Quality;

/* JADX INFO: loaded from: classes2.dex */
public class VideoEncoderCrashQuirk implements VideoQualityQuirk {
    public VideoEncoderCrashQuirk() {
    }

    private static boolean isPositivoTwist2Pro() {
        if ("positivo".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("twist 2 pro".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        return isPositivoTwist2Pro();
    }

    @Override // androidx.camera.video.internal.compat.quirk.VideoQualityQuirk
    public boolean isProblematicVideoQuality(CameraInfoInternal r100, Quality r101) {
        if (isPositivoTwist2Pro() == true) goto L5;
        return false;
    L5:
        if (r100.getLensFacing() == 0) goto L7;
        return false;
    L7:
        if (r101 != Quality.SD) goto L12;
        return true;
    L12:
        return false;
    }
}
