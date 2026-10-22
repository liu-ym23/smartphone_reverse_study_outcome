package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes2.dex */
public class RepeatingStreamConstraintForVideoRecordingQuirk implements Quirk {
    public RepeatingStreamConstraintForVideoRecordingQuirk() {
    }

    public static boolean isHuaweiMate9() {
        if ("Huawei".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("mha-l29".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        return isHuaweiMate9();
    }
}
