package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes2.dex */
public class NegativeLatLongSavesIncorrectlyQuirk implements Quirk {
    public NegativeLatLongSavesIncorrectlyQuirk() {
    }

    public static boolean load() {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return true;
    L5:
        return false;
    }
}
