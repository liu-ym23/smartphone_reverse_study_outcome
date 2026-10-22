package androidx.camera.video.internal;

import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.video.CapabilitiesByQuality;
import androidx.camera.video.Quality;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.camera.video.internal.utils.EncoderProfilesUtil;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class QualityExploredEncoderProfilesProvider implements EncoderProfilesProvider {
    private final EncoderProfilesProvider mBaseEncoderProfilesProvider;
    private final Set<Size> mCameraSupportedResolutions;
    private final Map<DynamicRange, CapabilitiesByQuality> mDynamicRangeToCapabilitiesMap;
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache;
    private final Set<DynamicRange> mTargetDynamicRanges;
    private final Set<Quality> mTargetQualities;
    private final Function<VideoEncoderConfig, VideoEncoderInfo> mVideoEncoderInfoFinder;

    private static void checkFullySpecifiedOrThrow(Collection<DynamicRange> r100) {
        Iterator<DynamicRange> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        DynamicRange r102 = r101.next();
        if (r102.isFullySpecified() == true) goto L4;
        throw new IllegalArgumentException("Contains non-fully specified DynamicRange: " + r102);
    }

    private EncoderProfilesProxy exploreProfiles(Quality.ConstantQuality r110) {
        Preconditions.checkArgument(this.mTargetQualities.contains(r110));
        EncoderProfilesProxy r100 = this.mBaseEncoderProfilesProvider.getAll(r110.getValue());
        Iterator<Size> r111 = r110.getTypicalSizes().iterator();
    L4:
        if (r111.hasNext() == false) goto L27;
        Size r101 = r111.next();
        if (this.mCameraSupportedResolutions.contains(r101) == false) goto L4;
        TreeMap r102 = new TreeMap(new CompareSizesByArea());
        ArrayList r103 = new ArrayList();
        Iterator<DynamicRange> r104 = this.mTargetDynamicRanges.iterator();
    L10:
        if (r104.hasNext() == false) goto L24;
        DynamicRange r105 = r104.next();
        if (hasMatchedVideoProfileForDynamicRange(r100, r105) == true) goto L10;
        VideoValidatedEncoderProfilesProxy r106 = getCapabilitiesByQualityFor(r105).findNearestHigherSupportedEncoderProfilesFor(r101);
        if (r106 == null) goto L10;
        EncoderProfilesProxy.VideoProfileProxy r107 = r106.getDefaultVideoProfile();
        VideoEncoderConfig r108 = VideoConfigUtil.toVideoEncoderConfig(r107);
        VideoEncoderInfo r109 = this.mVideoEncoderInfoFinder.apply(r108);
        if (r109 == null) goto L10;
        if (r109.isSizeSupportedAllowSwapping(r101.getWidth(), r101.getHeight()) == false) goto L10;
        r102.put(new Size(r107.getWidth(), r107.getHeight()), r106);
        r103.add(EncoderProfilesUtil.deriveVideoProfile(r107, r101, r109.getSupportedBitrateRange()));
        goto L10
    L24:
        if (r103.isEmpty() == true) goto L4;
        EncoderProfilesProxy r112 = (EncoderProfilesProxy) SizeUtil.findNearestHigherFor(r101, r102);
        Objects.requireNonNull(r112);
        EncoderProfilesProxy r113 = r112;
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r113.getDefaultDurationSeconds(), r113.getRecommendedFileFormat(), r113.getAudioProfiles(), r103);
    L27:
        return null;
    }

    private Quality.ConstantQuality findQualityInTargetQualities(int r100) {
        Iterator<Quality> r101 = this.mTargetQualities.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Quality.ConstantQuality r102 = (Quality.ConstantQuality) r101.next();
        if (r102.getValue() != r100) goto L4;
        return r102;
    L8:
        return null;
    }

    private CapabilitiesByQuality getCapabilitiesByQualityFor(DynamicRange r100) {
        if (this.mDynamicRangeToCapabilitiesMap.containsKey(r100) == false) goto L6;
        CapabilitiesByQuality r101 = this.mDynamicRangeToCapabilitiesMap.get(r100);
        Objects.requireNonNull(r101);
        return r101;
    L6:
        CapabilitiesByQuality r102 = new CapabilitiesByQuality(new DynamicRangeMatchedEncoderProfilesProvider(this.mBaseEncoderProfilesProvider, r100));
        this.mDynamicRangeToCapabilitiesMap.put(r100, r102);
        return r102;
    }

    private EncoderProfilesProxy getProfilesInternal(int r100) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(r100)) == true) goto L5;
        EncoderProfilesProxy r101 = this.mBaseEncoderProfilesProvider.getAll(r100);
        Quality.ConstantQuality r102 = findQualityInTargetQualities(r100);
        if (r102 != null) goto L9;
    L11:
        this.mEncoderProfilesCache.put(Integer.valueOf(r100), r101);
        return r101;
    L9:
        if (hasMatchedVideoProfileForAllTargetDynamicRanges(r101) == true) goto L11;
        r101 = mergeEncoderProfiles(r101, exploreProfiles(r102));
        goto L11
    L5:
        return this.mEncoderProfilesCache.get(Integer.valueOf(r100));
    }

    private boolean hasMatchedVideoProfileForAllTargetDynamicRanges(EncoderProfilesProxy r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<DynamicRange> r101 = this.mTargetDynamicRanges.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        if (hasMatchedVideoProfileForDynamicRange(r100, r101.next()) == true) goto L7;
        return false;
    L11:
        return true;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r100) {
        return getProfilesInternal(r100);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r100) {
        if (getProfilesInternal(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean hasMatchedVideoProfileForDynamicRange(EncoderProfilesProxy r100, DynamicRange r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<EncoderProfilesProxy.VideoProfileProxy> r102 = r100.getVideoProfiles().iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        if (DynamicRangeUtil.isHdrSettingsMatched(r102.next(), r101) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private static EncoderProfilesProxy mergeEncoderProfiles(EncoderProfilesProxy r100, EncoderProfilesProxy r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100 == null) goto L8;
        int r102 = r100.getDefaultDurationSeconds();
    L9:
        if (r100 == null) goto L11;
        int r103 = r100.getRecommendedFileFormat();
    L12:
        if (r100 == null) goto L14;
        List<EncoderProfilesProxy.AudioProfileProxy> r104 = r100.getAudioProfiles();
    L15:
        ArrayList r105 = new ArrayList();
        if (r100 == null) goto L18;
        r105.addAll(r100.getVideoProfiles());
    L18:
        if (r101 == null) goto L21;
        r105.addAll(r101.getVideoProfiles());
    L21:
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r102, r103, r104, r105);
    L14:
        r104 = r101.getAudioProfiles();
        goto L15
    L11:
        r103 = r101.getRecommendedFileFormat();
        goto L12
    L8:
        r102 = r101.getDefaultDurationSeconds();
        goto L9
    }

    public QualityExploredEncoderProfilesProvider(EncoderProfilesProvider r100, Collection<Quality> r101, Collection<DynamicRange> r102, Collection<Size> r103, Function<VideoEncoderConfig, VideoEncoderInfo> r104) {
        this.mEncoderProfilesCache = new HashMap();
        this.mDynamicRangeToCapabilitiesMap = new HashMap();
        checkFullySpecifiedOrThrow(r102);
        this.mBaseEncoderProfilesProvider = r100;
        this.mTargetQualities = new HashSet(r101);
        this.mTargetDynamicRanges = new HashSet(r102);
        this.mCameraSupportedResolutions = new HashSet(r103);
        this.mVideoEncoderInfoFinder = r104;
    }
}
