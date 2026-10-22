package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EncoderNotUsePersistentInputSurfaceQuirk implements Quirk {
    private static final List<String> DEVICE_MODELS = null;

    public EncoderNotUsePersistentInputSurfaceQuirk() {
    }

    static {
        DEVICE_MODELS = Arrays.asList(new String[]{"SM-N9208", "SM-G920V"});
    }

    public static boolean load() {
        if (Build.VERSION.SDK_INT > 22) goto L5;
    L8:
        return true;
    L5:
        if (DEVICE_MODELS.contains(Build.MODEL.toUpperCase()) == true) goto L8;
        return false;
    }
}
