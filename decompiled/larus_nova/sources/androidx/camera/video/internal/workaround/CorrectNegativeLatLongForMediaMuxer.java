package androidx.camera.video.internal.workaround;

import android.util.Pair;
import androidx.camera.video.AudioStats;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.NegativeLatLongSavesIncorrectlyQuirk;

/* JADX INFO: loaded from: classes2.dex */
public final class CorrectNegativeLatLongForMediaMuxer {
    private static double adjustInternal(double r100) {
        if (r100 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        return r100;
    L6:
        return ((r100 * 10000.0d) - 1.0d) / 10000.0d;
    }

    private CorrectNegativeLatLongForMediaMuxer() {
    }

    public static Pair<Double, Double> adjustGeoLocation(double r100, double r101) {
        if (DeviceQuirks.get(NegativeLatLongSavesIncorrectlyQuirk.class) == null) goto L6;
        r100 = adjustInternal(r100);
        r101 = adjustInternal(r101);
    L6:
        return Pair.create(Double.valueOf(r100), Double.valueOf(r101));
    }
}
