package bu9;

import android.os.Build;
import com.larus.platform.model.camera.CameraSettings;

/* JADX INFO: loaded from: classes.dex */
public final class q {
    public q() {
    }

    public static CameraSettings a() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 != 26) goto L5;
    L8:
        CameraSettings.Companion.getClass();
        return CameraSettings.access$getDefault_in_api_26_or_27$cp();
    L5:
        if (r100 == 27) goto L8;
        CameraSettings.Companion.getClass();
        return CameraSettings.access$getDefault_normal$cp();
    }
}
