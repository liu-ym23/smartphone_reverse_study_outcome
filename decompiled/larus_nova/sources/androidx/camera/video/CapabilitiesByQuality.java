package androidx.camera.video;

import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.core.util.Preconditions;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class CapabilitiesByQuality {
    private static final String TAG = "CapabilitiesByQuality";
    private final TreeMap<Size, Quality> mAreaSortedSizeToQualityMap;
    private final VideoValidatedEncoderProfilesProxy mHighestProfiles;
    private final VideoValidatedEncoderProfilesProxy mLowestProfiles;
    private final Map<Quality, VideoValidatedEncoderProfilesProxy> mSupportedProfilesMap;

    public List<Quality> getSupportedQualities() {
        return new ArrayList(this.mSupportedProfilesMap.keySet());
    }

    public CapabilitiesByQuality(EncoderProfilesProvider r100) {
        this.mSupportedProfilesMap = new LinkedHashMap();
        this.mAreaSortedSizeToQualityMap = new TreeMap(new CompareSizesByArea());
        Iterator<Quality> r101 = Quality.getSortedQualities().iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Quality r102 = r101.next();
        EncoderProfilesProxy r103 = getEncoderProfiles(r102, r100);
        if (r103 == null) goto L4;
        Logger.d(TAG, "profiles = " + r103);
        VideoValidatedEncoderProfilesProxy r104 = toValidatedProfiles(r103);
        if (r104 == null) goto L10;
        EncoderProfilesProxy.VideoProfileProxy r105 = r104.getDefaultVideoProfile();
        this.mAreaSortedSizeToQualityMap.put(new Size(r105.getWidth(), r105.getHeight()), r102);
        this.mSupportedProfilesMap.put(r102, r104);
        goto L4
    L10:
        Logger.w(TAG, "EncoderProfiles of quality " + r102 + " has no video validated profiles.");
        goto L4
    L13:
        if (this.mSupportedProfilesMap.isEmpty() == false) goto L15;
        Logger.e(TAG, "No supported EncoderProfiles");
        this.mLowestProfiles = null;
        this.mHighestProfiles = null;
        return;
    L15:
        ArrayDeque r106 = new ArrayDeque(this.mSupportedProfilesMap.values());
        this.mHighestProfiles = (VideoValidatedEncoderProfilesProxy) r106.peekFirst();
        this.mLowestProfiles = (VideoValidatedEncoderProfilesProxy) r106.peekLast();
    }

    private static void checkQualityConstantsOrThrow(Quality r100) {
        Preconditions.checkArgument(Quality.containsQuality(r100), "Unknown quality: " + r100);
    }

    private VideoValidatedEncoderProfilesProxy toValidatedProfiles(EncoderProfilesProxy r100) {
        if (r100.getVideoProfiles().isEmpty() == false) goto L7;
        return null;
    L7:
        return VideoValidatedEncoderProfilesProxy.from(r100);
    }

    public VideoValidatedEncoderProfilesProxy findNearestHigherSupportedEncoderProfilesFor(Size r100) {
        Quality r101 = findNearestHigherSupportedQualityFor(r100);
        Logger.d(TAG, "Using supported quality of " + r101 + " for size " + r100);
        if (r101 == Quality.NONE) goto L9;
        VideoValidatedEncoderProfilesProxy r102 = getProfiles(r101);
        if (r102 == null) goto L8;
        return r102;
    L8:
        throw new AssertionError("Camera advertised available quality but did not produce EncoderProfiles for advertised quality.");
    L9:
        return null;
    }

    public Quality findNearestHigherSupportedQualityFor(Size r100) {
        Quality r101 = (Quality) SizeUtil.findNearestHigherFor(r100, this.mAreaSortedSizeToQualityMap);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return Quality.NONE;
    }

    public VideoValidatedEncoderProfilesProxy getProfiles(Quality r100) {
        checkQualityConstantsOrThrow(r100);
        if (r100 != Quality.HIGHEST) goto L7;
        return this.mHighestProfiles;
    L7:
        if (r100 != Quality.LOWEST) goto L11;
        return this.mLowestProfiles;
    L11:
        return this.mSupportedProfilesMap.get(r100);
    }

    public boolean isQualitySupported(Quality r100) {
        checkQualityConstantsOrThrow(r100);
        if (getProfiles(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private EncoderProfilesProxy getEncoderProfiles(Quality r100, EncoderProfilesProvider r101) {
        Preconditions.checkState(r100 instanceof Quality.ConstantQuality, "Currently only support ConstantQuality");
        return r101.getAll(((Quality.ConstantQuality) r100).getValue());
    }
}
