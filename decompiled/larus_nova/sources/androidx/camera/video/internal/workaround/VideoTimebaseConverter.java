package androidx.camera.video.internal.workaround;

import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.compat.quirk.CameraUseInconsistentTimebaseQuirk;
import androidx.camera.video.internal.encoder.TimeProvider;

/* JADX INFO: loaded from: classes2.dex */
public class VideoTimebaseConverter {
    private static final String TAG = "VideoTimebaseConverter";
    private static final long UPTIME_REALTIME_DIFF_THRESHOLD_US = 3000000;
    private final CameraUseInconsistentTimebaseQuirk mCameraUseInconsistentTimebaseQuirk;
    private final Timebase mInputTimebase;
    private Timebase mResolvedInputTimebase;
    private final TimeProvider mTimeProvider;
    private long mUptimeToRealtimeOffsetUs;

    /* JADX INFO: renamed from: androidx.camera.video.internal.workaround.VideoTimebaseConverter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$Timebase = null;

        static {
            int[] r100 = new int[Timebase.values().length];
            $SwitchMap$androidx$camera$core$impl$Timebase = r100;
            r100[Timebase.REALTIME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$androidx$camera$core$impl$Timebase[Timebase.UPTIME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private long calculateUptimeToRealtimeOffsetUs() {
        long r100 = Long.MAX_VALUE;
        int r101 = 0;
        long r102 = 0;
    L4:
        if (r101 >= 3) goto L12;
        long r103 = this.mTimeProvider.uptimeUs();
        long r110 = this.mTimeProvider.realtimeUs();
        long r111 = this.mTimeProvider.uptimeUs();
        long r112 = r111 - r103;
        if (r101 != 0) goto L8;
    L9:
        r102 = r110 - ((r103 + r111) >> 1);
        r100 = r112;
    L10:
        r101 = r101 + 1;
        goto L4
    L8:
        if (r112 >= r100) goto L10;
    L12:
        return Math.max(0, r102);
    }

    private boolean exceedUptimeRealtimeDiffThreshold() {
        long r100 = this.mTimeProvider.uptimeUs();
        if ((this.mTimeProvider.realtimeUs() - r100) <= UPTIME_REALTIME_DIFF_THRESHOLD_US) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isCloseToRealtime(long r100) {
        long r101 = this.mTimeProvider.uptimeUs();
        if (Math.abs(r100 - this.mTimeProvider.realtimeUs()) >= Math.abs(r100 - r101)) goto L5;
        return true;
    L5:
        return false;
    }

    private Timebase resolveInputTimebase(long r100) {
        if (this.mCameraUseInconsistentTimebaseQuirk == null) goto L6;
        Logger.w(TAG, "CameraUseInconsistentTimebaseQuirk is enabled");
        boolean r101 = false;
    L9:
        if (isCloseToRealtime(r100) == false) goto L11;
        Timebase r102 = Timebase.REALTIME;
    L12:
        if (r101 == true) goto L14;
    L20:
        Logger.d(TAG, "Detect input timebase = " + r102);
    L21:
        return r102;
    L14:
        if (r102 == this.mInputTimebase) goto L20;
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 31) goto L18;
        String r104 = ", SOC: " + Build.SOC_MODEL;
    L19:
        Logger.e(TAG, String.format("Detected camera timebase inconsistent. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: %s, Model: %s, Hardware: %s, API Level: %d%s].\nCamera timebase is inconsistent. The timebase reported by the camera is %s, but the actual timebase contained in the frame is detected as %s.", new Object[]{Build.MANUFACTURER, Build.MODEL, Build.HARDWARE, Integer.valueOf(r103), r104, this.mInputTimebase, r102}));
        goto L21
    L18:
        r104 = "";
        goto L19
    L11:
        r102 = Timebase.UPTIME;
        goto L12
    L6:
        if (exceedUptimeRealtimeDiffThreshold() == false) goto L23;
        r101 = true;
        goto L9
    L23:
        return this.mInputTimebase;
    }

    public long convertToUptimeUs(long r100) {
        if (this.mResolvedInputTimebase != null) goto L5;
        this.mResolvedInputTimebase = resolveInputTimebase(r100);
    L5:
        int r101 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$Timebase[this.mResolvedInputTimebase.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 != 2) goto L11;
        return r100;
    L11:
        throw new AssertionError("Unknown timebase: " + this.mResolvedInputTimebase);
    L13:
        if (this.mUptimeToRealtimeOffsetUs != (-1)) goto L16;
        this.mUptimeToRealtimeOffsetUs = calculateUptimeToRealtimeOffsetUs();
        Logger.d(TAG, "mUptimeToRealtimeOffsetUs = " + this.mUptimeToRealtimeOffsetUs);
    L16:
        return r100 - this.mUptimeToRealtimeOffsetUs;
    }

    public VideoTimebaseConverter(TimeProvider r100, Timebase r101, CameraUseInconsistentTimebaseQuirk r102) {
        this.mUptimeToRealtimeOffsetUs = -1;
        this.mTimeProvider = r100;
        this.mInputTimebase = r101;
        this.mCameraUseInconsistentTimebaseQuirk = r102;
    }
}
