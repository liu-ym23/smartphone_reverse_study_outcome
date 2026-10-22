package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.workaround.ExtraSupportedSurfaceCombinationsContainer;
import androidx.camera.camera2.internal.compat.workaround.ResolutionCorrector;
import androidx.camera.camera2.internal.compat.workaround.TargetAspectRatio;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraMode;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class SupportedSurfaceCombination {
    private static final String TAG = "SupportedSurfaceCombination";
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final String mCameraId;
    private final CameraCharacteristicsCompat mCharacteristics;
    private final List<SurfaceCombination> mConcurrentSurfaceCombinations;
    private final DisplayInfoManager mDisplayInfoManager;
    private final DynamicRangeResolver mDynamicRangeResolver;
    private final ExtraSupportedSurfaceCombinationsContainer mExtraSupportedSurfaceCombinationsContainer;
    private final Map<FeatureSettings, List<SurfaceCombination>> mFeatureSettingsToSupportedCombinationsMap;
    private final int mHardwareLevel;
    private boolean mIsBurstCaptureSupported;
    private boolean mIsConcurrentCameraModeSupported;
    private boolean mIsPreviewStabilizationSupported;
    private boolean mIsRawSupported;
    private boolean mIsStreamUseCaseSupported;
    private boolean mIsUltraHighResolutionSensorSupported;
    private final List<SurfaceCombination> mPreviewStabilizationSurfaceCombinations;
    private final ResolutionCorrector mResolutionCorrector;
    private final List<SurfaceCombination> mSurfaceCombinations;
    private final List<SurfaceCombination> mSurfaceCombinations10Bit;
    private final List<SurfaceCombination> mSurfaceCombinationsStreamUseCase;
    private final List<SurfaceCombination> mSurfaceCombinationsUltraHdr;
    SurfaceSizeDefinition mSurfaceSizeDefinition;
    List<Integer> mSurfaceSizeDefinitionFormats;
    private final TargetAspectRatio mTargetAspectRatio;
    private final List<SurfaceCombination> mUltraHighSurfaceCombinations;

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Size[] getHighResolutionOutputSizes(StreamConfigurationMap r100, int r101) {
            return r100.getHighResolutionOutputSizes(r101);
        }
    }

    public static abstract class FeatureSettings {
        public FeatureSettings() {
        }

        public abstract int getCameraMode();

        public abstract int getRequiredMaxBitDepth();

        public abstract boolean isPreviewStabilizationOn();

        public abstract boolean isUltraHdrOn();

        public static FeatureSettings of(int r100, int r101, boolean r102, boolean r103) {
            return new AutoValue_SupportedSurfaceCombination_FeatureSettings(r100, r101, r102, r103);
        }
    }

    private void checkCustomization() {
    }

    private void generate10BitSupportedCombinationList() {
        this.mSurfaceCombinations10Bit.addAll(GuaranteedConfigurationsUtil.get10BitSupportedCombinationList());
    }

    private void generateConcurrentSupportedCombinationList() {
        this.mConcurrentSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.getConcurrentSupportedCombinationList());
    }

    private void generatePreviewStabilizationSupportedCombinationList() {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        this.mPreviewStabilizationSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.getPreviewStabilizationSupportedCombinationList());
        return;
    }

    private void generateStreamUseCaseSupportedCombinationList() {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        this.mSurfaceCombinationsStreamUseCase.addAll(GuaranteedConfigurationsUtil.getStreamUseCaseSupportedCombinationList());
        return;
    }

    private void generateSupportedCombinationList() {
        this.mSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.generateSupportedCombinationList(this.mHardwareLevel, this.mIsRawSupported, this.mIsBurstCaptureSupported));
        this.mSurfaceCombinations.addAll(this.mExtraSupportedSurfaceCombinationsContainer.get(this.mCameraId));
    }

    private void generateSurfaceSizeDefinition() {
        Size r100 = this.mDisplayInfoManager.getPreviewSize();
        Size r101 = getRecordSize();
        this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(SizeUtil.RESOLUTION_VGA, new HashMap(), r100, new HashMap(), r101, new HashMap(), new HashMap());
    }

    private void generateUltraHdrSupportedCombinationList() {
        this.mSurfaceCombinationsUltraHdr.addAll(GuaranteedConfigurationsUtil.getUltraHdrSupportedCombinationList());
    }

    private void generateUltraHighSupportedCombinationList() {
        this.mUltraHighSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.getUltraHighResolutionSupportedCombinationList());
    }

    private Size getRecordSize() {
        int r100 = CastIntegerProtector.parseInt(this.mCameraId);     // Catch: NumberFormatException -> L12
        if (this.mCamcorderProfileHelper.hasProfile(r100, 1) == false) goto L6;
        CamcorderProfile r101 = this.mCamcorderProfileHelper.get(r100, 1);
    L7:
        if (r101 == null) goto L11;
        return new Size(r101.videoFrameWidth, r101.videoFrameHeight);
    L11:
        return getRecordSizeByHasProfile(r100);
    L6:
        r101 = null;
    L13:
        return getRecordSizeFromStreamConfigurationMap();
    }

    private Size getRecordSizeFromStreamConfigurationMap() {
        Size[] r100 = this.mCharacteristics.getStreamConfigurationMapCompat().toStreamConfigurationMap().getOutputSizes(MediaRecorder.class);
        if (r100 == null) goto L5;
        Arrays.sort(r100, new CompareSizesByArea(true));
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L15;
        Size r103 = r100[r102];
        int r104 = r103.getWidth();
        Size r105 = SizeUtil.RESOLUTION_1080P;
        if (r104 > r105.getWidth()) goto L13;
        if (r103.getHeight() > r105.getHeight()) goto L13;
        return r103;
    L13:
        r102 = r102 + 1;
        goto L7
    L15:
        return SizeUtil.RESOLUTION_480P;
    L5:
        return SizeUtil.RESOLUTION_480P;
    }

    private boolean isUltraHdrSupported() {
        int[] r100 = this.mCharacteristics.getStreamConfigurationMapCompat().getOutputFormats();
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L12;
        if (r100[r102] == 4101) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private void refreshPreviewSize() {
        this.mDisplayInfoManager.refresh();
        if (this.mSurfaceSizeDefinition != null) goto L5;
        generateSurfaceSizeDefinition();
        return;
    L5:
        Size r100 = this.mDisplayInfoManager.getPreviewSize();
        this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(this.mSurfaceSizeDefinition.getAnalysisSize(), this.mSurfaceSizeDefinition.getS720pSizeMap(), r100, this.mSurfaceSizeDefinition.getS1440pSizeMap(), this.mSurfaceSizeDefinition.getRecordSize(), this.mSurfaceSizeDefinition.getMaximumSizeMap(), this.mSurfaceSizeDefinition.getUltraMaximumSizeMap());
    }

    public String getCameraId() {
        return this.mCameraId;
    }

    public boolean isBurstCaptureSupported() {
        return this.mIsBurstCaptureSupported;
    }

    public boolean isRawSupported() {
        return this.mIsRawSupported;
    }

    private List<List<Size>> getAllPossibleSizeArrangements(List<List<Size>> r110) {
        Iterator<List<Size>> r100 = r110.iterator();
        int r101 = 1;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 * r100.next().size();
        goto L4
    L6:
        if (r101 == 0) goto L22;
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L8:
        if (r103 >= r101) goto L10;
        r102.add(new ArrayList());
        r103 = r103 + 1;
        goto L8
    L10:
        int r104 = r101 / ((List) ListProtector.get(r110, 0)).size();
        int r105 = r101;
        int r106 = 0;
    L12:
        if (r106 >= r110.size()) goto L20;
        List r107 = (List) ListProtector.get(r110, r106);
        int r108 = 0;
    L14:
        if (r108 >= r101) goto L17;
        ((List) ListProtector.get(r102, r108)).add((Size) ListProtector.get(r107, (r108 % r105) / r104));
        r108 = r108 + 1;
        goto L14
    L17:
        if (r106 >= (r110.size() - 1)) goto L19;
        int r109 = r104 / ((List) ListProtector.get(r110, r106 + 1)).size();
        r105 = r104;
        r104 = r109;
    L19:
        r106 = r106 + 1;
        goto L12
    L20:
        return r102;
    L22:
        throw new IllegalArgumentException("Failed to find supported resolutions.");
    }

    private int getMaxSupportedFpsFromAttachedSurfaces(List<AttachedSurfaceInfo> r100) {
        Iterator<AttachedSurfaceInfo> r101 = r100.iterator();
        int r102 = Integer.MAX_VALUE;
    L4:
        if (r101.hasNext() == false) goto L6;
        AttachedSurfaceInfo r103 = r101.next();
        r102 = getUpdatedMaximumFps(r102, r103.getImageFormat(), r103.getSize());
        goto L4
    L6:
        return r102;
    }

    private static int getRangeLength(Range<Integer> r100) {
        return (((Integer) r100.getUpper()).intValue() - ((Integer) r100.getLower()).intValue()) + 1;
    }

    private Size getRecordSizeByHasProfile(int r100) {
        Size r101 = SizeUtil.RESOLUTION_480P;
        if (this.mCamcorderProfileHelper.hasProfile(r100, 10) == false) goto L6;
        CamcorderProfile r102 = this.mCamcorderProfileHelper.get(r100, 10);
    L21:
        if (r102 != null) goto L23;
        return r101;
    L23:
        return new Size(r102.videoFrameWidth, r102.videoFrameHeight);
    L6:
        if (this.mCamcorderProfileHelper.hasProfile(r100, 8) == false) goto L9;
        r102 = this.mCamcorderProfileHelper.get(r100, 8);
        goto L21
    L9:
        if (this.mCamcorderProfileHelper.hasProfile(r100, 12) == false) goto L12;
        r102 = this.mCamcorderProfileHelper.get(r100, 12);
        goto L21
    L12:
        if (this.mCamcorderProfileHelper.hasProfile(r100, 6) == false) goto L15;
        r102 = this.mCamcorderProfileHelper.get(r100, 6);
        goto L21
    L15:
        if (this.mCamcorderProfileHelper.hasProfile(r100, 5) == false) goto L18;
        r102 = this.mCamcorderProfileHelper.get(r100, 5);
        goto L21
    L18:
        if (this.mCamcorderProfileHelper.hasProfile(r100, 4) == false) goto L20;
        r102 = this.mCamcorderProfileHelper.get(r100, 4);
        goto L21
    L20:
        r102 = null;
        goto L21
    }

    private static int getRequiredMaxBitDepth(Map<UseCaseConfig<?>, DynamicRange> r100) {
        Iterator<DynamicRange> r101 = r100.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r101.next().getBitDepth() != 10) goto L4;
        return 10;
    L8:
        return 8;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private List<SurfaceCombination> getSurfaceCombinationsByFeatureSettings(FeatureSettings r100) {
        if (this.mFeatureSettingsToSupportedCombinationsMap.containsKey(r100) == true) goto L5;
        ArrayList r101 = new ArrayList();
        if (r100.isUltraHdrOn() == false) goto L12;
        List<SurfaceCombination> r102 = r101;
        if (r100.getCameraMode() != 0) goto L29;
        r101.addAll(this.mSurfaceCombinationsUltraHdr);
        r102 = r101;
    L29:
        this.mFeatureSettingsToSupportedCombinationsMap.put(r100, r102);
        return r102;
    L12:
        if (r100.getRequiredMaxBitDepth() != 8) goto L24;
        int r103 = r100.getCameraMode();
        if (r103 != 1) goto L16;
        r102 = this.mConcurrentSurfaceCombinations;
        goto L29
    L16:
        if (r103 != 2) goto L18;
        r101.addAll(this.mUltraHighSurfaceCombinations);
        r101.addAll(this.mSurfaceCombinations);
        r102 = r101;
        goto L29
    L18:
        if (r100.isPreviewStabilizationOn() == false) goto L20;
        List<SurfaceCombination> r104 = this.mPreviewStabilizationSurfaceCombinations;
    L21:
        r101.addAll(r104);
        r102 = r101;
        goto L29
    L20:
        r104 = this.mSurfaceCombinations;
        goto L21
    L24:
        r102 = r101;
        if (r100.getRequiredMaxBitDepth() != 10) goto L29;
        r102 = r101;
        if (r100.getCameraMode() != 0) goto L29;
        r101.addAll(this.mSurfaceCombinations10Bit);
        r102 = r101;
        goto L29
    L5:
        return this.mFeatureSettingsToSupportedCombinationsMap.get(r100);
    }

    private static List<Integer> getUseCasesPriorityOrder(List<UseCaseConfig<?>> r100) {
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        Iterator<UseCaseConfig<?>> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        int r104 = r103.next().getSurfaceOccupancyPriority(0);
        if (r102.contains(Integer.valueOf(r104)) == true) goto L4;
        r102.add(Integer.valueOf(r104));
        goto L4
    L8:
        Collections.sort(r102);
        Collections.reverse(r102);
        Iterator r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L17;
        int r106 = ((Integer) r105.next()).intValue();
        Iterator<UseCaseConfig<?>> r107 = r100.iterator();
    L13:
        if (r107.hasNext() == false) goto L10;
        UseCaseConfig<?> r108 = r107.next();
        if (r106 != r108.getSurfaceOccupancyPriority(0)) goto L13;
        r101.add(Integer.valueOf(r100.indexOf(r108)));
        goto L13
    L17:
        return r101;
    }

    public SurfaceSizeDefinition getUpdatedSurfaceSizeDefinitionByFormat(int r100) {
        if (this.mSurfaceSizeDefinitionFormats.contains(Integer.valueOf(r100)) == true) goto L6;
        updateS720pOrS1440pSizeByFormat(this.mSurfaceSizeDefinition.getS720pSizeMap(), SizeUtil.RESOLUTION_720P, r100);
        updateS720pOrS1440pSizeByFormat(this.mSurfaceSizeDefinition.getS1440pSizeMap(), SizeUtil.RESOLUTION_1440P, r100);
        updateMaximumSizeByFormat(this.mSurfaceSizeDefinition.getMaximumSizeMap(), r100);
        updateUltraMaximumSizeByFormat(this.mSurfaceSizeDefinition.getUltraMaximumSizeMap(), r100);
        this.mSurfaceSizeDefinitionFormats.add(Integer.valueOf(r100));
    L6:
        return this.mSurfaceSizeDefinition;
    }

    private Range<Integer> getClosestSupportedDeviceFrameRate(Range<Integer> r100, int r110) {
        if (r100 == null) goto L41;
        Range<Integer> r101 = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        if (r100.equals(r101) == true) goto L41;
        Range<Integer>[] r102 = (Range[]) this.mCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (r102 != null) goto L9;
        return r101;
    L9:
        Range<T> r103 = new Range(Integer.valueOf(Math.min(((Integer) r100.getLower()).intValue(), r110)), Integer.valueOf(Math.min(((Integer) r100.getUpper()).intValue(), r110)));
        int r104 = r102.length;
        int r105 = 0;
        int r106 = 0;
    L10:
        if (r105 >= r104) goto L51;
        Range<Integer> r107 = r102[r105];
        if (r110 < ((Integer) r107.getLower()).intValue()) goto L38;
        if (r101.equals(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED) == false) goto L17;
        r101 = r107;
    L17:
        if (r107.equals(r103) == true) goto L39;
        int r108 = getRangeLength(r107.intersect(r103));     // Catch: IllegalArgumentException -> L25
        if (r106 != 0) goto L22;
        r106 = r108;
    L37:
        r101 = r107;
        goto L38
    L22:
        if (r108 < r106) goto L24;
        r101 = compareIntersectingRanges(r103, r101, r107);     // Catch: IllegalArgumentException -> L25
        r106 = getRangeLength(r103.intersect(r101));     // Catch: IllegalArgumentException -> L25
    L24:
        r107 = r101;
    L26:
        if (r106 != 0) goto L38;
        if (getRangeDistance(r107, r103) < getRangeDistance(r101, r103)) goto L37;
        if (getRangeDistance(r107, r103) != getRangeDistance(r101, r103)) goto L38;
        if (((Integer) r107.getLower()).intValue() > ((Integer) r101.getUpper()).intValue()) goto L37;
        if (getRangeLength(r107) >= getRangeLength(r101)) goto L38;
    L39:
        return r107;
    L38:
        r105 = r105 + 1;
        goto L10
    L51:
        return r101;
    L41:
        return StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
    }

    private static int getRangeDistance(Range<Integer> r100, Range<Integer> r101) {
        if (r100.contains((Integer) r101.getUpper()) == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        Preconditions.checkState(r102, "Ranges must not intersect");
        if (((Integer) r100.getLower()).intValue() <= ((Integer) r101.getUpper()).intValue()) goto L13;
        return ((Integer) r100.getLower()).intValue() - ((Integer) r101.getUpper()).intValue();
    L13:
        return ((Integer) r101.getLower()).intValue() - ((Integer) r100.getUpper()).intValue();
    L5:
        if (r100.contains((Integer) r101.getLower()) == true) goto L7;
        r102 = true;
        goto L8
    }

    private Range<Integer> getUpdatedTargetFramerate(Range<Integer> r100, Range<Integer> r101) {
        if (r101 == null) goto L12;
        if (r100 == null) goto L8;
        return r101.intersect(r100);
    L8:
        return r101;
    L12:
        return r100;
    }

    private static boolean isUltraHdrOn(List<AttachedSurfaceInfo> r100, Map<UseCaseConfig<?>, List<Size>> r101) {
        Iterator<AttachedSurfaceInfo> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (r102.next().getImageFormat() != 4101) goto L4;
        return true;
    L8:
        Iterator<UseCaseConfig<?>> r103 = r101.keySet().iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        if (r103.next().getInputFormat() != 4101) goto L10;
        return true;
    L14:
        return false;
    }

    private void updateMaximumSizeByFormat(Map<Integer, Size> r100, int r101) {
        Size r102 = getMaxOutputSizeByFormat(this.mCharacteristics.getStreamConfigurationMapCompat().toStreamConfigurationMap(), r101, true);
        if (r102 == null) goto L6;
        r100.put(Integer.valueOf(r101), r102);
        return;
    }

    private void updateUltraMaximumSizeByFormat(Map<Integer, Size> r100, int r101) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return;
    L5:
        if (this.mIsUltraHighResolutionSensorSupported == false) goto L13;
        StreamConfigurationMap r102 = (StreamConfigurationMap) this.mCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION);
        if (r102 != null) goto L10;
        return;
    L10:
        r100.put(Integer.valueOf(r101), getMaxOutputSizeByFormat(r102, r101, true));
        return;
    }

    public List<Size> applyResolutionSelectionOrderRelatedWorkarounds(List<Size> r100, int r101) {
        int r102 = this.mTargetAspectRatio.get(this.mCameraId, this.mCharacteristics);
        if (r102 != 0) goto L5;
        Rational r103 = AspectRatioUtil.ASPECT_RATIO_4_3;
    L12:
        if (r103 == null) goto L23;
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        Iterator<Size> r106 = r100.iterator();
    L16:
        if (r106.hasNext() == false) goto L21;
        Size r107 = r106.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r107, r103) == true) goto L19;
        r105.add(r107);
        goto L16
    L19:
        r104.add(r107);
        goto L16
    L21:
        r105.addAll(0, r104);
        r100 = r105;
    L23:
        return this.mResolutionCorrector.insertOrPrioritize(SurfaceConfig.getConfigType(r101), r100);
    L5:
        if (r102 != 1) goto L7;
        r103 = AspectRatioUtil.ASPECT_RATIO_16_9;
        goto L12
    L7:
        if (r102 == 2) goto L9;
        r103 = null;
        goto L12
    L9:
        Size r108 = getUpdatedSurfaceSizeDefinitionByFormat(256).getMaximumSize(256);
        r103 = new Rational(r108.getWidth(), r108.getHeight());
        goto L12
    }

    public boolean checkSupported(FeatureSettings r100, List<SurfaceConfig> r101) {
        Iterator<SurfaceCombination> r102 = getSurfaceCombinationsByFeatureSettings(r100).iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L10;
        if (r102.next().getOrderedSupportedSurfaceConfigList(r101) == null) goto L8;
        r103 = true;
    L9:
        if (r103 == false) goto L4;
    L8:
        r103 = false;
    L10:
        return r103;
    }

    public List<SurfaceConfig> getOrderedSupportedStreamUseCaseSurfaceConfigList(FeatureSettings r100, List<SurfaceConfig> r101) {
        if (StreamUseCaseUtil.shouldUseStreamUseCase(r100) == true) goto L5;
        return null;
    L5:
        Iterator<SurfaceCombination> r102 = this.mSurfaceCombinationsStreamUseCase.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        List<SurfaceConfig> r103 = r102.next().getOrderedSupportedSurfaceConfigList(r101);
        if (r103 == null) goto L7;
        return r103;
    L11:
        return null;
    }

    private static Range<Integer> compareIntersectingRanges(Range<Integer> r110, Range<Integer> r111, Range<Integer> r112) {
        double r100 = getRangeLength(r111.intersect(r110));
        double r101 = getRangeLength(r112.intersect(r110));
        double r102 = r101 / ((double) getRangeLength(r112));
        double r103 = r100 / ((double) getRangeLength(r111));
        if (r101 > r100) goto L5;
        if (r101 != r100) goto L18;
        if (r102 <= r103) goto L13;
        return r112;
    L13:
        if (r102 == r103) goto L15;
    L22:
        return r111;
    L15:
        if (((Integer) r112.getLower()).intValue() <= ((Integer) r111.getLower()).intValue()) goto L22;
        return r112;
    L18:
        if (r103 >= 0.5d) goto L22;
        if (r102 <= r103) goto L22;
        return r112;
    L5:
        if (r102 < 0.5d) goto L7;
    L8:
        return r112;
    L7:
        if (r102 < r103) goto L22;
        goto L8
    }

    private Map<UseCaseConfig<?>, List<Size>> filterSupportedSizes(Map<UseCaseConfig<?>, List<Size>> r110, FeatureSettings r111, Range<Integer> r112) {
        HashMap r100 = new HashMap();
        Iterator<UseCaseConfig<?>> r101 = r110.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L19;
        UseCaseConfig<?> r102 = r101.next();
        ArrayList r103 = new ArrayList();
        HashMap r104 = new HashMap();
        Iterator<Size> r105 = r110.get(r102).iterator();
    L7:
        if (r105.hasNext() == false) goto L18;
        Size r106 = r105.next();
        int r107 = r102.getInputFormat();
        SurfaceConfig.ConfigSize r108 = SurfaceConfig.transformSurfaceConfig(r111.getCameraMode(), r107, r106, getUpdatedSurfaceSizeDefinitionByFormat(r107)).getConfigSize();
        if (r112 == null) goto L11;
        int r109 = getMaxFrameRate(this.mCharacteristics, r107, r106);
    L12:
        Set r113 = (Set) r104.get(r108);
        if (r113 != null) goto L16;
        r113 = new HashSet();
        r104.put(r108, r113);
    L16:
        if (r113.contains(Integer.valueOf(r109)) == true) goto L7;
        r103.add(r106);
        r113.add(Integer.valueOf(r109));
        goto L7
    L11:
        r109 = Integer.MAX_VALUE;
        goto L12
    L18:
        r100.put(r102, r103);
        goto L4
    L19:
        return r100;
    }

    public static int getMaxFrameRate(CameraCharacteristicsCompat r100, int r101, Size r102) {
        return (int) (1.0E9d / ((StreamConfigurationMap) r100.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(r101, r102));
    L4:
        return 0;
    }

    private Size getMaxOutputSizeByFormat(StreamConfigurationMap r100, int r101, boolean r102) {
        if (r101 != 34) goto L5;
        Size[] r103 = r100.getOutputSizes(SurfaceTexture.class);
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        if (r103.length == 0) goto L22;
        CompareSizesByArea r104 = new CompareSizesByArea();
        Size r105 = (Size) Collections.max(Arrays.asList(r103), r104);
        Size r106 = SizeUtil.RESOLUTION_ZERO;
        if (Build.VERSION.SDK_INT < 23) goto L19;
        if (r102 == false) goto L19;
        Size[] r107 = Api23Impl.getHighResolutionOutputSizes(r100, r101);
        if (r107 == null) goto L19;
        if (r107.length <= 0) goto L19;
        r106 = (Size) Collections.max(Arrays.asList(r107), r104);
    L19:
        return (Size) Collections.max(Arrays.asList(new Size[]{r105, r106}), r104);
    L22:
        return null;
    L5:
        r103 = r100.getOutputSizes(r101);
        goto L6
    }

    private Range<Integer> getTargetFpsRange(List<AttachedSurfaceInfo> r100, List<UseCaseConfig<?>> r101, List<Integer> r102) {
        Iterator<AttachedSurfaceInfo> r103 = r100.iterator();
        Range<Integer> r104 = null;
    L4:
        if (r103.hasNext() == false) goto L6;
        r104 = getUpdatedTargetFramerate(r103.next().getTargetFrameRate(), r104);
        goto L4
    L6:
        Iterator<Integer> r105 = r102.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        r104 = getUpdatedTargetFramerate(((UseCaseConfig) ListProtector.get(r101, r105.next().intValue())).getTargetFrameRate(null), r104);
        goto L8
    L10:
        return r104;
    }

    private int getUpdatedMaximumFps(int r100, int r101, Size r102) {
        return Math.min(r100, getMaxFrameRate(this.mCharacteristics, r101, r102));
    }

    private boolean isUseCasesCombinationSupported(FeatureSettings r100, List<AttachedSurfaceInfo> r101, Map<UseCaseConfig<?>, List<Size>> r110) {
        ArrayList r102 = new ArrayList();
        Iterator<AttachedSurfaceInfo> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(r103.next().getSurfaceConfig());
        goto L4
    L6:
        CompareSizesByArea r104 = new CompareSizesByArea();
        Iterator<UseCaseConfig<?>> r105 = r110.keySet().iterator();
    L8:
        if (r105.hasNext() == false) goto L17;
        UseCaseConfig<?> r106 = r105.next();
        List<Size> r107 = r110.get(r106);
        if (r107 != null) goto L12;
    L14:
        boolean r108 = false;
    L15:
        Preconditions.checkArgument(r108, "No available output size is found for " + r106 + ".");
        Size r109 = (Size) Collections.min(r107, r104);
        int r111 = r106.getInputFormat();
        r102.add(SurfaceConfig.transformSurfaceConfig(r100.getCameraMode(), r111, r109, getUpdatedSurfaceSizeDefinitionByFormat(r111)));
        goto L8
    L12:
        if (r107.isEmpty() == true) goto L14;
        r108 = true;
        goto L15
    L17:
        return checkSupported(r100, r102);
    }

    private void updateS720pOrS1440pSizeByFormat(Map<Integer, Size> r100, Size r101, int r102) {
        if (this.mIsConcurrentCameraModeSupported == true) goto L5;
        return;
    L5:
        Size r103 = getMaxOutputSizeByFormat(this.mCharacteristics.getStreamConfigurationMapCompat().toStreamConfigurationMap(), r102, false);
        Integer r104 = Integer.valueOf(r102);
        if (r103 == null) goto L9;
        r101 = (Size) Collections.min(Arrays.asList(new Size[]{r101, r103}), new CompareSizesByArea());
    L9:
        r100.put(r104, r101);
    }

    public SurfaceConfig transformSurfaceConfig(int r100, int r101, Size r102) {
        return SurfaceConfig.transformSurfaceConfig(r100, r101, r102, getUpdatedSurfaceSizeDefinitionByFormat(r101));
    }

    public SupportedSurfaceCombination(Context r100, String r101, CameraManagerCompat r102, CamcorderProfileHelper r103) throws CameraUnavailableException {
        this.mSurfaceCombinations = new ArrayList();
        this.mUltraHighSurfaceCombinations = new ArrayList();
        this.mConcurrentSurfaceCombinations = new ArrayList();
        this.mPreviewStabilizationSurfaceCombinations = new ArrayList();
        this.mFeatureSettingsToSupportedCombinationsMap = new HashMap();
        this.mSurfaceCombinations10Bit = new ArrayList();
        this.mSurfaceCombinationsUltraHdr = new ArrayList();
        this.mSurfaceCombinationsStreamUseCase = new ArrayList();
        int r104 = 0;
        this.mIsRawSupported = false;
        this.mIsBurstCaptureSupported = false;
        this.mIsConcurrentCameraModeSupported = false;
        this.mIsStreamUseCaseSupported = false;
        this.mIsUltraHighResolutionSensorSupported = false;
        this.mIsPreviewStabilizationSupported = false;
        this.mSurfaceSizeDefinitionFormats = new ArrayList();
        this.mTargetAspectRatio = new TargetAspectRatio();
        this.mResolutionCorrector = new ResolutionCorrector();
        String r105 = (String) Preconditions.checkNotNull(r101);
        this.mCameraId = r105;
        this.mCamcorderProfileHelper = (CamcorderProfileHelper) Preconditions.checkNotNull(r103);
        this.mExtraSupportedSurfaceCombinationsContainer = new ExtraSupportedSurfaceCombinationsContainer();
        this.mDisplayInfoManager = DisplayInfoManager.getInstance(r100);
        CameraCharacteristicsCompat r106 = r102.getCameraCharacteristicsCompat(r105);     // Catch: CameraAccessExceptionCompat -> L44
        this.mCharacteristics = r106;     // Catch: CameraAccessExceptionCompat -> L44
        Integer r107 = (Integer) r106.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);     // Catch: CameraAccessExceptionCompat -> L44
        if (r107 == null) goto L6;
        int r108 = r107.intValue();     // Catch: CameraAccessExceptionCompat -> L44
    L7:
        this.mHardwareLevel = r108;     // Catch: CameraAccessExceptionCompat -> L44
        int[] r109 = (int[]) r106.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (r109 == null) goto L24;
        int r110 = r109.length;
    L11:
        if (r104 >= r110) goto L24;
        int r111 = r109[r104];
        if (r111 != 3) goto L16;
        this.mIsRawSupported = true;
    L23:
        r104 = r104 + 1;
        goto L11
    L16:
        if (r111 != 6) goto L19;
        this.mIsBurstCaptureSupported = true;
        goto L23
    L19:
        if (Build.VERSION.SDK_INT < 31) goto L23;
        if (r111 != 16) goto L23;
        this.mIsUltraHighResolutionSensorSupported = true;
    L24:
        DynamicRangeResolver r112 = new DynamicRangeResolver(this.mCharacteristics);
        this.mDynamicRangeResolver = r112;
        generateSupportedCombinationList();
        if (this.mIsUltraHighResolutionSensorSupported == false) goto L27;
        generateUltraHighSupportedCombinationList();
    L27:
        boolean r113 = r100.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent");
        this.mIsConcurrentCameraModeSupported = r113;
        if (r113 == false) goto L31;
        generateConcurrentSupportedCombinationList();
    L31:
        if (r112.is10BitDynamicRangeSupported() == false) goto L34;
        generate10BitSupportedCombinationList();
    L34:
        if (isUltraHdrSupported() == false) goto L36;
        generateUltraHdrSupportedCombinationList();
    L36:
        boolean r114 = StreamUseCaseUtil.isStreamUseCaseSupported(this.mCharacteristics);
        this.mIsStreamUseCaseSupported = r114;
        if (r114 == false) goto L39;
        generateStreamUseCaseSupportedCombinationList();
    L39:
        boolean r115 = VideoStabilizationUtil.isPreviewStabilizationSupported(this.mCharacteristics);
        this.mIsPreviewStabilizationSupported = r115;
        if (r115 == false) goto L42;
        generatePreviewStabilizationSupportedCombinationList();
    L42:
        generateSurfaceSizeDefinition();
        checkCustomization();
        return;
    L6:
        r108 = 2;
    L44:
        e = move-exception;
        throw CameraUnavailableExceptionHelper.createFrom(e);
    }

    private FeatureSettings createFeatureSettings(int r100, Map<UseCaseConfig<?>, DynamicRange> r101, boolean r102, boolean r103) {
        int r104 = getRequiredMaxBitDepth(r101);
        if (r100 == 0) goto L8;
        if (r103 == false) goto L8;
        throw new IllegalArgumentException(String.format("Camera device id is %s. Ultra HDR is not currently supported in %s camera mode.", new Object[]{this.mCameraId, CameraMode.toLabelString(r100)}));
    L8:
        if (r100 == 0) goto L15;
        if (r104 != 10) goto L15;
        throw new IllegalArgumentException(String.format("Camera device id is %s. 10 bit dynamic range is not currently supported in %s camera mode.", new Object[]{this.mCameraId, CameraMode.toLabelString(r100)}));
    L15:
        return FeatureSettings.of(r100, r104, r102, r103);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> getSuggestedStreamSpecifications(int r310, List<AttachedSurfaceInfo> r311, Map<UseCaseConfig<?>, List<Size>> r312, boolean r313, boolean r410) {
        refreshPreviewSize();
        ArrayList r110 = new ArrayList(r312.keySet());
        List<Integer> r111 = getUseCasesPriorityOrder(r110);
        Map<UseCaseConfig<?>, DynamicRange> r112 = this.mDynamicRangeResolver.resolveAndValidateDynamicRanges(r311, r110, r111);
        FeatureSettings r113 = createFeatureSettings(r310, r112, r313, isUltraHdrOn(r311, r312));
        boolean r114 = isUseCasesCombinationSupported(r113, r311, r312);
        String r100 = ".  May be attempting to bind too many use cases. Existing surfaces: ";
        String r101 = " New configs: ";
        String r102 = "No supported surface combination is found for camera device - Id : ";
        if (r114 == false) goto L106;
        Range<Integer> r103 = getTargetFpsRange(r311, r110, r111);
        Map<UseCaseConfig<?>, List<Size>> r104 = filterSupportedSizes(r312, r113, r103);
        ArrayList r105 = new ArrayList();
        Iterator<Integer> r106 = r111.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        UseCaseConfig r107 = (UseCaseConfig) ListProtector.get(r110, r106.next().intValue());
        r105.add(applyResolutionSelectionOrderRelatedWorkarounds(r104.get(r107), r107.getInputFormat()));
        goto L6
    L8:
        List<List<Size>> r115 = getAllPossibleSizeArrangements(r105);
        HashMap r108 = new HashMap();
        HashMap r109 = new HashMap();
        HashMap r116 = new HashMap();
        HashMap r117 = new HashMap();
        boolean r118 = StreamUseCaseUtil.containsZslUseCase(r311, r110);
        int r119 = getMaxSupportedFpsFromAttachedSurfaces(r311);
        HashMap r314 = r117;
        Range<Integer> r120 = null;
        if (this.mIsStreamUseCaseSupported == false) goto L32;
        if (r118 == true) goto L32;
        Iterator<List<Size>> r121 = r115.iterator();
        List<SurfaceConfig> r122 = null;
    L13:
        if (r121.hasNext() == false) goto L25;
        HashMap r315 = r314;
        HashMap r316 = r116;
        HashMap r210 = r109;
        HashMap r211 = r108;
        Map<UseCaseConfig<?>, DynamicRange> r212 = r112;
        Range<Integer> r123 = r103;
        List<Integer> r124 = r111;
        Range<Integer> r213 = r123;
        String r125 = r102;
        int r126 = r119;
        int r214 = r119;
        String r127 = r101;
        List<Integer> r215 = r111;
        String r128 = r100;
        r122 = getOrderedSupportedStreamUseCaseSurfaceConfigList(r113, (List) getSurfaceConfigListAndFpsCeiling(r310, r311, r121.next(), r110, r124, r126, r316, r315).first);
        HashMap r129 = r316;
        HashMap r130 = r315;
        if (r122 != null) goto L17;
    L19:
        if (r122 == null) goto L24;
        if (StreamUseCaseUtil.areStreamUseCasesAvailableForSurfaceConfigs(this.mCharacteristics, r122) == true) goto L26;
        r122 = null;
    L26:
        if (r122 != null) goto L31;
        if (r114 == true) goto L31;
        throw new IllegalArgumentException(r125 + this.mCameraId + r128 + r311 + r127 + r110);
    L31:
        List<SurfaceConfig> r131 = r122;
    L33:
        Iterator<List<Size>> r132 = r115.iterator();
        boolean r133 = false;
        List<Size> r216 = null;
        List<Size> r217 = null;
        int r134 = Integer.MAX_VALUE;
        int r135 = Integer.MAX_VALUE;
        boolean r136 = false;
        boolean r218 = false;
    L35:
        if (r132.hasNext() == false) goto L73;
        List<Size> r317 = r132.next();
        int r318 = r134;
        int r319 = r135;
        String r320 = r127;
        HashMap r137 = r130;
        String r321 = r125;
        HashMap r138 = r129;
        Pair<List<SurfaceConfig>, Integer> r139 = getSurfaceConfigListAndFpsCeiling(r310, r311, r317, r110, r215, r214, null, null);
        List<SurfaceConfig> r140 = (List) r139.first;
        r135 = ((Integer) r139.second).intValue();
        int r141 = r214;
        if (r213 == null) goto L42;
        if (r141 <= r135) goto L42;
        if (r135 >= ((Integer) r213.getLower()).intValue()) goto L42;
        boolean r142 = false;
    L43:
        if (r136 == false) goto L45;
    L55:
        int r143 = r319;
        int r144 = Integer.MAX_VALUE;
    L56:
        if (r131 == null) goto L71;
        if (r218 == true) goto L71;
        if (getOrderedSupportedStreamUseCaseSurfaceConfigList(r113, r140) == null) goto L71;
        if (r318 == r144) goto L64;
        if (r318 < r135) goto L64;
        r134 = r318;
    L66:
        if (r142 == false) goto L72;
        r134 = r135;
        if (r136 == true) goto L69;
        r217 = r317;
        r218 = true;
        goto L72
    L69:
        r135 = r143;
        List<Size> r145 = r216;
        List<Size> r146 = r317;
    L74:
        if (r145 == null) goto L104;
        if (r213 == null) goto L77;
        r120 = getClosestSupportedDeviceFrameRate(r213, r135);
    L77:
        Range<Integer> r147 = r120;
        Iterator r148 = r110.iterator();
    L79:
        if (r148.hasNext() == false) goto L84;
        UseCaseConfig r149 = (UseCaseConfig) r148.next();
        List<Integer> r150 = r215;
        Map<UseCaseConfig<?>, DynamicRange> r151 = r212;
        Iterator r322 = r148;
        StreamSpec.Builder r152 = StreamSpec.builder((Size) ListProtector.get(r145, r150.indexOf(Integer.valueOf(r110.indexOf(r149))))).setDynamicRange((DynamicRange) Preconditions.checkNotNull(r151.get(r149))).setImplementationOptions(StreamUseCaseUtil.getStreamSpecImplementationOptions(r149)).setZslDisabled(r410);
        if (r147 == null) goto L83;
        r152.setExpectedFrameRateRange(r147);
    L83:
        Range<Integer> r323 = r147;
        r210.put(r149, r152.build());
        r148 = r322;
        r215 = r150;
        r212 = r151;
        r147 = r323;
        goto L79
    L84:
        HashMap r153 = r210;
        if (r131 == null) goto L100;
        if (r135 != r134) goto L100;
        if (r145.size() != r146.size()) goto L100;
        int r154 = 0;
    L91:
        if (r154 >= r145.size()) goto L96;
        if (((Size) ListProtector.get(r145, r154)).equals(ListProtector.get(r146, r154)) == false) goto L94;
        r154 = r154 + 1;
        goto L91
    L94:
        r133 = true;
    L96:
        if (r133 == true) goto L100;
        HashMap r155 = r211;
        if (StreamUseCaseUtil.populateStreamUseCaseStreamSpecOptionWithInteropOverride(this.mCharacteristics, r311, r153, r155) == true) goto L102;
        StreamUseCaseUtil.populateStreamUseCaseStreamSpecOptionWithSupportedSurfaceConfigs(r153, r155, r138, r137, r131);
    L102:
        return new Pair(r153, r155);
    L100:
        r155 = r211;
        goto L102
    L104:
        throw new IllegalArgumentException(r321 + this.mCameraId + " and Hardware level: " + this.mHardwareLevel + ". May be the specified resolution is too large and not supported. Existing surfaces: " + r311 + r320 + r110);
    L72:
        r214 = r141;
        r135 = r143;
        r129 = r138;
        r130 = r137;
        r125 = r321;
        r127 = r320;
    L64:
        r134 = r135;
        r217 = r317;
    L71:
        r134 = r318;
        goto L72
    L45:
        if (checkSupported(r113, r140) == false) goto L55;
        r143 = r319;
        r144 = Integer.MAX_VALUE;
        if (r143 == Integer.MAX_VALUE) goto L50;
        if (r143 < r135) goto L50;
    L51:
        if (r142 == false) goto L56;
        if (r218 == true) goto L53;
        r143 = r135;
        r216 = r317;
        r136 = true;
        goto L56
    L53:
        r146 = r217;
        r145 = r317;
        r134 = r318;
    L50:
        r143 = r135;
        r216 = r317;
    L42:
        r142 = true;
        goto L43
    L73:
        r321 = r125;
        r320 = r127;
        r137 = r130;
        r138 = r129;
        r145 = r216;
        r146 = r217;
    L24:
        r129.clear();
        r130.clear();
        r314 = r130;
        r116 = r129;
        r100 = r128;
        r102 = r125;
        r101 = r127;
        r112 = r212;
        r109 = r210;
        r108 = r211;
        r103 = r213;
        r119 = r214;
        r111 = r215;
        goto L13
    L17:
        if (StreamUseCaseUtil.areCaptureTypesEligible(r129, r130, r122) == true) goto L19;
        r122 = null;
        goto L19
    L25:
        r210 = r109;
        r211 = r108;
        r213 = r103;
        r215 = r111;
        r212 = r112;
        r214 = r119;
        r125 = r102;
        r127 = r101;
        r128 = r100;
        r130 = r314;
        r129 = r116;
    L32:
        r129 = r116;
        r210 = r109;
        r211 = r108;
        r213 = r103;
        r215 = r111;
        r212 = r112;
        r214 = r119;
        r125 = "No supported surface combination is found for camera device - Id : ";
        r127 = " New configs: ";
        r130 = r314;
        r131 = null;
        goto L33
    L106:
        throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.mCameraId + ".  May be attempting to bind too many use cases. Existing surfaces: " + r311 + " New configs: " + r110);
    }

    private Pair<List<SurfaceConfig>, Integer> getSurfaceConfigListAndFpsCeiling(int r100, List<AttachedSurfaceInfo> r101, List<Size> r102, List<UseCaseConfig<?>> r103, List<Integer> r104, int r110, Map<Integer, AttachedSurfaceInfo> r111, Map<Integer, UseCaseConfig<?>> r112) {
        ArrayList r105 = new ArrayList();
        Iterator<AttachedSurfaceInfo> r106 = r101.iterator();
    L4:
        if (r106.hasNext() == false) goto L8;
        AttachedSurfaceInfo r107 = r106.next();
        r105.add(r107.getSurfaceConfig());
        if (r111 == null) goto L4;
        r111.put(Integer.valueOf(r105.size() - 1), r107);
        goto L4
    L8:
        int r108 = 0;
    L10:
        if (r108 >= r102.size()) goto L16;
        Size r113 = (Size) ListProtector.get(r102, r108);
        UseCaseConfig<?> r109 = (UseCaseConfig) ListProtector.get(r103, ((Integer) ListProtector.get(r104, r108)).intValue());
        int r114 = r109.getInputFormat();
        r105.add(SurfaceConfig.transformSurfaceConfig(r100, r114, r113, getUpdatedSurfaceSizeDefinitionByFormat(r114)));
        if (r112 == null) goto L14;
        r112.put(Integer.valueOf(r105.size() - 1), r109);
    L14:
        r110 = getUpdatedMaximumFps(r110, r109.getInputFormat(), r113);
        r108 = r108 + 1;
        goto L10
    L16:
        return new Pair(r105, Integer.valueOf(r110));
    }
}
