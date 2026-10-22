package bw3;

import androidx.camera.video.AudioStats;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class i0 {
    public static final String a(double r100) {
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.3f", Arrays.copyOf(new Object[]{Double.valueOf(r100)}, 1));
    }

    public static final double b(double r100) {
        if (Double.isInfinite(r100) == false) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L11;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L11:
        return RangesKt.coerceAtLeast(r100, AudioStats.AUDIO_AMPLITUDE_NONE);
    L5:
        if (Double.isNaN(r100) == true) goto L7;
        r101 = true;
        goto L9
    }
}
