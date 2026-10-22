package androidx.camera.video.internal.audio;

import android.media.AudioTimestamp;
import androidx.core.util.Preconditions;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class AudioUtils {
    public static int channelCountToChannelConfig(int r100) {
        if (r100 != 1) goto L5;
        return 16;
    L5:
        return 12;
    }

    public static int channelCountToChannelMask(int r100) {
        if (r100 != 1) goto L5;
        return 16;
    L5:
        return 12;
    }

    private AudioUtils() {
    }

    public static long frameCountToDurationNs(long r100, int r101) {
        long r102 = r101;
        if (r102 <= 0) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103, "sampleRate must be greater than 0.");
        return (TimeUnit.SECONDS.toNanos(1) * r100) / r102;
    L5:
        r103 = false;
        goto L6
    }

    public static long frameCountToSize(long r100, int r101) {
        long r102 = r101;
        if (r102 <= 0) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103, "bytesPerFrame must be greater than 0.");
        return r100 * r102;
    L5:
        r103 = false;
        goto L6
    }

    public static int getBytesPerFrame(int r100, int r101) {
        if (r101 <= 0) goto L4;
        boolean r102 = true;
    L5:
        Preconditions.checkArgument(r102, "Invalid channel count: " + r101);
        if (r100 == 2) goto L23;
        if (r100 != 3) goto L10;
        return r101;
    L10:
        if (r100 == 4) goto L21;
        if (r100 == 21) goto L19;
        if (r100 == 22) goto L21;
        throw new IllegalArgumentException("Invalid audio encoding: " + r100);
    L19:
        return r101 * 3;
    L21:
        return r101 * 4;
    L23:
        return r101 * 2;
    L4:
        r102 = false;
        goto L5
    }

    public static long sizeToFrameCount(long r100, int r101) {
        long r102 = r101;
        if (r102 <= 0) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103, "bytesPerFrame must be greater than 0.");
        return r100 / r102;
    L5:
        r103 = false;
        goto L6
    }

    public static long computeInterpolatedTimeNs(int r100, long r101, AudioTimestamp r110) {
        boolean r102 = true;
        if (r100 <= 0) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103, "sampleRate must be greater than 0.");
        if (r101 >= 0) goto L10;
        r102 = false;
    L10:
        Preconditions.checkArgument(r102, "framePosition must be no less than 0.");
        long r104 = r110.nanoTime + frameCountToDurationNs(r101 - r110.framePosition, r100);
        if (r104 >= 0) goto L14;
        return 0;
    L14:
        return r104;
    L5:
        r103 = false;
        goto L6
    }
}
