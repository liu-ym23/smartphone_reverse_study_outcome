package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes2.dex */
public class CodecStuckOnFlushQuirk implements Quirk {
    public CodecStuckOnFlushQuirk() {
    }

    private static boolean isNokia1() {
        if ("Nokia".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("Nokia 1".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        return isNokia1();
    }

    public boolean isProblematicMimeType(String r100) {
        return "video/mp4v-es".equals(r100);
    }
}
