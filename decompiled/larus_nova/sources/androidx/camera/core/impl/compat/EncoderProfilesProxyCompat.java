package androidx.camera.core.impl.compat;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;

/* JADX INFO: loaded from: classes2.dex */
public final class EncoderProfilesProxyCompat {
    private static final String TAG = "EncoderProfilesProxyCompat";

    private EncoderProfilesProxyCompat() {
    }

    public static EncoderProfilesProxy from(EncoderProfiles r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 33) goto L7;
        return EncoderProfilesProxyCompatApi33Impl.from(r100);
    L7:
        if (r101 < 31) goto L11;
        return EncoderProfilesProxyCompatApi31Impl.from(r100);
    L11:
        throw new RuntimeException("Unable to call from(EncoderProfiles) on API " + r101 + ". Version 31 or higher required.");
    }

    public static EncoderProfilesProxy from(CamcorderProfile r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 31) goto L6;
        Logger.w(TAG, "Should use from(EncoderProfiles) on API " + r101 + "instead. CamcorderProfile is deprecated on API 31.");
    L6:
        return EncoderProfilesProxyCompatBaseImpl.from(r100);
    }
}
