package androidx.camera.camera2.internal;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.CamcorderProfileResolutionQuirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.InvalidVideoProfilesQuirk;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.compat.EncoderProfilesProxyCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Camera2EncoderProfilesProvider implements EncoderProfilesProvider {
    private static final String TAG = "Camera2EncoderProfilesProvider";
    private final String mCameraId;
    private final Quirks mCameraQuirks;
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache;
    private final boolean mHasValidCameraId;
    private final int mIntCameraId;

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static EncoderProfiles getAll(String r100, int r101) {
            return CamcorderProfile.getAll(r100, r101);
        }
    }

    private EncoderProfilesProxy findHighestQualityProfiles() {
        Iterator<Integer> r100 = EncoderProfilesProvider.QUALITY_HIGH_TO_LOW.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        EncoderProfilesProxy r101 = getAll(r100.next().intValue());
        if (r101 == null) goto L4;
        return r101;
    L8:
        return null;
    }

    private EncoderProfilesProxy findLowestQualityProfiles() {
        int r100 = EncoderProfilesProvider.QUALITY_HIGH_TO_LOW.size() - 1;
    L3:
        if (r100 < 0) goto L8;
        EncoderProfilesProxy r101 = getAll(r100);
        if (r101 != null) goto L6;
        r100 = r100 - 1;
        goto L3
    L6:
        return r101;
    L8:
        return null;
    }

    private EncoderProfilesProxy createProfilesFromCamcorderProfile(int r100) {
        CamcorderProfile r101 = CamcorderProfile.get(this.mIntCameraId, r100);     // Catch: RuntimeException -> L5
    L7:
        if (r101 != null) goto L9;
        return null;
    L9:
        return EncoderProfilesProxyCompat.from(r101);
    L5:
        e = move-exception;
        Logger.w(TAG, "Unable to get CamcorderProfile by quality: " + r100, e);
        r101 = null;
        goto L7
    }

    private EncoderProfilesProxy getProfilesInternal(int r100) {
        if (Build.VERSION.SDK_INT < 31) goto L20;
        EncoderProfiles r101 = Api31Impl.getAll(this.mCameraId, r100);
        if (r101 != null) goto L9;
        return null;
    L9:
        if (DeviceQuirks.get(InvalidVideoProfilesQuirk.class) == null) goto L11;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L21;
        Logger.d(TAG, "EncoderProfiles contains invalid video profiles, use CamcorderProfile to create EncoderProfilesProxy.");
        goto L20
    L21:
        return EncoderProfilesProxyCompat.from(r101);
    L17:
        e = move-exception;
        Logger.w(TAG, "Failed to create EncoderProfilesProxy, EncoderProfiles might  contain invalid video profiles. Use CamcorderProfile instead.", e);
        goto L20
    L11:
        r102 = false;
    L20:
        return createProfilesFromCamcorderProfile(r100);
    }

    private boolean isEncoderProfilesResolutionValidInQuirk(EncoderProfilesProxy r100) {
        CamcorderProfileResolutionQuirk r101 = (CamcorderProfileResolutionQuirk) this.mCameraQuirks.get(CamcorderProfileResolutionQuirk.class);
        if (r101 != null) goto L5;
        return true;
    L5:
        List<EncoderProfilesProxy.VideoProfileProxy> r102 = r100.getVideoProfiles();
        if (r102.isEmpty() == false) goto L8;
        return true;
    L8:
        EncoderProfilesProxy.VideoProfileProxy r103 = (EncoderProfilesProxy.VideoProfileProxy) ListProtector.get(r102, 0);
        return r101.getSupportedResolutions().contains(new Size(r103.getWidth(), r103.getHeight()));
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r100) {
        EncoderProfilesProxy r101 = null;
        if (this.mHasValidCameraId == true) goto L6;
        return null;
    L6:
        if (CamcorderProfile.hasProfile(this.mIntCameraId, r100) == true) goto L9;
        return null;
    L9:
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(r100)) == true) goto L11;
        EncoderProfilesProxy r102 = getProfilesInternal(r100);
        if (r102 != null) goto L15;
    L21:
        r101 = r102;
    L22:
        this.mEncoderProfilesCache.put(Integer.valueOf(r100), r101);
        return r101;
    L15:
        if (isEncoderProfilesResolutionValidInQuirk(r102) == true) goto L21;
        if (r100 != 1) goto L19;
        r101 = findHighestQualityProfiles();
        goto L22
    L19:
        if (r100 != 0) goto L22;
        r101 = findLowestQualityProfiles();
        goto L22
    L11:
        return this.mEncoderProfilesCache.get(Integer.valueOf(r100));
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r100) {
        if (this.mHasValidCameraId == true) goto L6;
        return false;
    L6:
        if (getAll(r100) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public Camera2EncoderProfilesProvider(String r100, Quirks r101) {
        this.mEncoderProfilesCache = new HashMap();
        this.mCameraId = r100;
        int r102 = CastIntegerProtector.parseInt(r100);     // Catch: NumberFormatException -> L5
        boolean r103 = true;
    L6:
        this.mHasValidCameraId = r103;
        this.mIntCameraId = r102;
        this.mCameraQuirks = r101;
        return;
    L5:
        Logger.w(TAG, "Camera id is not an integer: " + r100 + ", unable to create Camera2EncoderProfilesProvider");
        r103 = false;
        r102 = -1;
        goto L6
    }
}
