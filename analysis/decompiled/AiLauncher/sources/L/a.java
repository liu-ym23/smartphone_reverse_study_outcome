package L;

import D.C0761b0;
import K.W;
import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;

/* loaded from: classes.dex */
public final class a {
    public static W a(CamcorderProfile camcorderProfile) {
        C0761b0.o("EncoderProfilesProxyCompat", "Should use from(EncoderProfiles) on API " + Build.VERSION.SDK_INT + "instead. CamcorderProfile is deprecated on API 31.");
        return c.a(camcorderProfile);
    }

    public static W b(EncoderProfiles encoderProfiles) {
        return b.a(encoderProfiles);
    }
}
