package androidx.camera.core.streamsharing;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.SupportedOutputSizesSorter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ResolutionsMerger {
    private static final double SAME_AREA_WIDTH_HEIGHT_RATIO = 0.0d;
    private static final String TAG = "ResolutionsMerger";
    private final CameraInfoInternal mCameraInfo;
    private final Map<UseCaseConfig<?>, List<Size>> mChildSizesCache;
    private final Set<UseCaseConfig<?>> mChildrenConfigs;
    private final Rational mFallbackAspectRatio;
    private final Rational mSensorAspectRatio;
    private final Size mSensorSize;
    private final SupportedOutputSizesSorter mSizeSorter;

    public static class CompareAspectRatioByOverlappingAreaToReference implements Comparator<Rational> {
        private final Rational mReferenceAspectRatio;
        private final boolean mReverse;

        public CompareAspectRatioByOverlappingAreaToReference(Rational r100, boolean r101) {
            this.mReferenceAspectRatio = r100;
            this.mReverse = r101;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Rational r100, Rational r101) {
            float r102 = ResolutionsMerger.access$000(r100, this.mReferenceAspectRatio);
            float r103 = ResolutionsMerger.access$000(r101, this.mReferenceAspectRatio);
            if (this.mReverse == false) goto L7;
            return Float.compare(r103, r102);
        L7:
            return Float.compare(r102, r103);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Rational r100, Rational r101) {
            return compare2(r100, r101);
        }
    }

    private boolean areCroppingInDifferentDirection(float r100, float r101, float r102) {
        if (r100 != r101) goto L5;
        return false;
    L5:
        if (r101 != r102) goto L8;
        return false;
    L8:
        if (r100 > r101) goto L10;
        if (r101 <= r102) goto L18;
        return true;
    L18:
        return false;
    L10:
        if (r101 >= r102) goto L16;
        return true;
    L16:
        return false;
    }

    private List<Size> getCameraSupportedHighResolutions() {
        return this.mCameraInfo.getSupportedHighResolutions(34);
    }

    private List<Size> getCameraSupportedResolutions() {
        return this.mCameraInfo.getSupportedResolutions(34);
    }

    private Set<Size> getChildrenRequiredResolutions() {
        HashSet r100 = new HashSet();
        Iterator<UseCaseConfig<?>> r101 = this.mChildrenConfigs.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.addAll(getSortedChildSizes(r101.next()));
        goto L4
    L6:
        return r100;
    }

    private boolean shouldIncludeHighResolutions() {
        Iterator<UseCaseConfig<?>> r100 = this.mChildrenConfigs.iterator();
    L3:
        boolean r101 = false;
        if (r100.hasNext() == false) goto L14;
        UseCaseConfig<?> r102 = r100.next();
        if (r102.isHighResolutionDisabled(false) == true) goto L3;
        if ((r102 instanceof ImageOutputConfig) == false) goto L3;
        ResolutionSelector r103 = ((ImageOutputConfig) r102).getResolutionSelector(null);
        if (r103 == null) goto L3;
        r101 = true;
        if (r103.getAllowedResolutionMode() != 1) goto L3;
    L14:
        return r101;
    }

    private boolean needToAddSensorResolutions() {
        Iterator<Size> r100 = getChildrenRequiredResolutions().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (AspectRatioUtil.hasMatchingAspectRatio(r100.next(), this.mFallbackAspectRatio) == true) goto L4;
        return true;
    L9:
        return false;
    }

    static {
        SAME_AREA_WIDTH_HEIGHT_RATIO = Math.sqrt(2.3703703703703702d);
    }

    private static List<Size> filterOutChildSizesThatWillNeverBeSelected(List<Size> r100) {
        HashMap r101 = new HashMap();
        ArrayList r102 = new ArrayList();
        Iterator<Size> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L24;
        Size r104 = r103.next();
        Iterator r105 = r101.keySet().iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        Rational r106 = (Rational) r105.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r104, r106) == false) goto L7;
    L12:
        if (r106 == null) goto L22;
        Size r107 = (Size) r101.get(r106);
        Objects.requireNonNull(r107);
        if (r104.getHeight() > r107.getHeight()) goto L4;
        if (r104.getWidth() > r107.getWidth()) goto L4;
        if (r104.getWidth() != r107.getWidth()) goto L23;
        if (r104.getHeight() == r107.getHeight()) goto L4;
    L23:
        r102.add(r104);
        r101.put(r106, r104);
        goto L4
    L22:
        r106 = toRational(r104);
        goto L23
    L11:
        r106 = null;
        goto L12
    L24:
        return r102;
    }

    private static Rational findCloserAspectRatio(Size r100) {
        if ((((double) r100.getWidth()) / ((double) r100.getHeight())) <= SAME_AREA_WIDTH_HEIGHT_RATIO) goto L7;
        return AspectRatioUtil.ASPECT_RATIO_16_9;
    L7:
        return AspectRatioUtil.ASPECT_RATIO_4_3;
    }

    private static Rational getFallbackAspectRatio(Rational r100) {
        Rational r101 = AspectRatioUtil.ASPECT_RATIO_4_3;
        if (r100.equals(r101) == false) goto L7;
        return AspectRatioUtil.ASPECT_RATIO_16_9;
    L7:
        if (r100.equals(AspectRatioUtil.ASPECT_RATIO_16_9) == false) goto L10;
        return r101;
    L10:
        throw new IllegalArgumentException("Invalid sensor aspect-ratio: " + r100);
    }

    private static Rational getSensorAspectRatio(Size r100) {
        Rational r101 = findCloserAspectRatio(r100);
        Logger.d(TAG, "The closer aspect ratio to the sensor size (" + r100 + ") is " + r101 + ".");
        return r101;
    }

    private List<Size> getSortedChildSizes(UseCaseConfig<?> r100) {
        if (this.mChildrenConfigs.contains(r100) == false) goto L11;
        if (this.mChildSizesCache.containsKey(r100) == false) goto L8;
        List<Size> r101 = this.mChildSizesCache.get(r100);
        Objects.requireNonNull(r101);
        return r101;
    L8:
        List<Size> r102 = filterOutChildSizesThatWillNeverBeSelected(this.mSizeSorter.getSortedSupportedOutputSizes(r100));
        this.mChildSizesCache.put(r100, r102);
        return r102;
    L11:
        throw new IllegalArgumentException("Invalid child config: " + r100);
    }

    private static List<Size> getSupportedPrivResolutions(List<Pair<Integer, Size[]>> r100) {
        Iterator<Pair<Integer, Size[]>> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Pair<Integer, Size[]> r102 = r101.next();
        if (((Integer) r102.first).equals(34) == false) goto L4;
        return Arrays.asList((Size[]) r102.second);
    L10:
        return new ArrayList();
    }

    private Map<Rational, List<Size>> groupSizesByAspectRatio(List<Size> r100) {
        HashMap r101 = new HashMap();
        Rational r102 = AspectRatioUtil.ASPECT_RATIO_4_3;
        r101.put(r102, new ArrayList());
        Rational r103 = AspectRatioUtil.ASPECT_RATIO_16_9;
        r101.put(r103, new ArrayList());
        ArrayList r104 = new ArrayList();
        r104.add(r102);
        r104.add(r103);
        Iterator<Size> r105 = r100.iterator();
    L4:
        if (r105.hasNext() == false) goto L18;
        Size r106 = r105.next();
        if (r106.getHeight() <= 0) goto L4;
        Iterator r107 = r104.iterator();
    L10:
        if (r107.hasNext() == false) goto L14;
        Rational r108 = (Rational) r107.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r106, r108) == false) goto L10;
        List r109 = (List) r101.get(r108);
    L15:
        if (r109 != null) goto L17;
        r109 = new ArrayList();
        Rational r110 = toRational(r106);
        r104.add(r110);
        r101.put(r110, r109);
    L17:
        r109.add(r106);
        goto L4
    L14:
        r109 = null;
        goto L15
    L18:
        return r101;
    }

    private static List<Size> removeDuplicates(List<Size> r100) {
        if (r100.isEmpty() == false) goto L6;
        return r100;
    L6:
        return new ArrayList(new LinkedHashSet(r100));
    }

    public static Rect reverseRect(Rect r100) {
        return new Rect(r100.top, r100.left, r100.bottom, r100.right);
    }

    private List<Size> selectParentResolutions(List<Size> r100) {
        ArrayList r101 = new ArrayList();
        if (needToAddSensorResolutions() == false) goto L5;
        r101.addAll(selectParentResolutionsByAspectRatio(this.mSensorAspectRatio, r100, false));
    L5:
        r101.addAll(selectParentResolutionsByAspectRatio(this.mFallbackAspectRatio, r100, false));
        r101.addAll(selectOtherAspectRatioParentResolutionsWithFovPriority(r100, false));
        if (r101.isEmpty() == false) goto L8;
        Logger.w(TAG, "Failed to find a parent resolution that does not result in double-cropping, this might due to camera not supporting 4:3 and 16:9resolutions or a strict ResolutionSelector settings. Starting resolution selection process with resolutions that might have a smaller FOV.");
        r101.addAll(selectOtherAspectRatioParentResolutionsWithFovPriority(r100, true));
    L8:
        Logger.d(TAG, "Parent resolutions: " + r101);
        return r101;
    }

    private void sortByFov(List<Rational> r100) {
        Collections.sort(r100, new CompareAspectRatioByOverlappingAreaToReference(toRational(this.mSensorSize), true));
    }

    public static void sortInDescendingOrder(List<Size> r100) {
        Collections.sort(r100, new CompareSizesByArea(true));
    }

    private static Rational toRational(Size r100) {
        return new Rational(r100.getWidth(), r100.getHeight());
    }

    private static Rational toRationalWithMod16Considered(Size r100) {
        Rational r101 = AspectRatioUtil.ASPECT_RATIO_4_3;
        if (AspectRatioUtil.hasMatchingAspectRatio(r100, r101) == false) goto L5;
        return r101;
    L5:
        Rational r102 = AspectRatioUtil.ASPECT_RATIO_16_9;
        if (AspectRatioUtil.hasMatchingAspectRatio(r100, r102) == false) goto L9;
        return r102;
    L9:
        return toRational(r100);
    }

    public List<Size> getMergedResolutions(MutableConfig r100) {
        List<Size> r101 = getCameraSupportedResolutions();
        if (shouldIncludeHighResolutions() == false) goto L5;
        ArrayList r102 = new ArrayList(r101);
        r102.addAll(getCameraSupportedHighResolutions());
        r101 = r102;
    L5:
        List r103 = (List) r100.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, null);
        if (r103 == null) goto L9;
        r101 = getSupportedPrivResolutions(r103);
    L9:
        return selectParentResolutions(r101);
    }

    public ResolutionsMerger(CameraInternal r100, Set<UseCaseConfig<?>> r101) {
        this(TransformUtils.rectToSize(r100.getCameraControlInternal().getSensorRect()), r100.getCameraInfoInternal(), r101);
    }

    public static /* synthetic */ float access$000(Rational r100, Rational r101) {
        return computeAreaOverlapping(r100, r101);
    }

    private static float computeAreaOverlapping(Rational r100, Rational r101) {
        float r102 = r100.floatValue();
        float r103 = r101.floatValue();
        if (r102 <= r103) goto L6;
        return r103 / r102;
    L6:
        return r102 / r103;
    }

    private List<Size> filterOutChildSizesCausingDoubleCropping(Rational r100, List<Size> r101) {
        ArrayList r102 = new ArrayList();
        Iterator<Size> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Size r104 = r103.next();
        if (isDoubleCropping(r100, r104) == true) goto L4;
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    public static List<Size> filterOutParentSizeThatIsTooSmall(Collection<Size> r100, List<Size> r101) {
        if (r100.isEmpty() == true) goto L15;
        if (r101.isEmpty() == true) goto L15;
        ArrayList r102 = new ArrayList();
        Iterator<Size> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        Size r104 = r103.next();
        if (isAnyChildSizeCanBeCroppedOutWithoutUpscalingParent(r100, r104) == false) goto L9;
        r102.add(r104);
        goto L9
    L13:
        return r102;
    L15:
        return new ArrayList();
    }

    public static List<Size> filterResolutionsByAspectRatio(Rational r100, List<Size> r101) {
        ArrayList r102 = new ArrayList();
        Iterator<Size> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Size r104 = r103.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r104, r100) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    private static Rect getCenterCroppedRectangle(Rational r100, Size r101) {
        int r102 = r101.getWidth();
        int r103 = r101.getHeight();
        Rational r104 = toRational(r101);
        if (r100.floatValue() != r104.floatValue()) goto L6;
        RectF r105 = new RectF(0.0f, 0.0f, r102, r103);
    L10:
        Rect r106 = new Rect();
        r105.round(r106);
        return r106;
    L6:
        if (r100.floatValue() <= r104.floatValue()) goto L8;
        float r107 = r102;
        float r108 = r107 / r100.floatValue();
        float r109 = (r103 - r108) / 2.0f;
        RectF r110 = new RectF(0.0f, r109, r107, r108 + r109);
    L9:
        r105 = r110;
        goto L10
    L8:
        float r111 = r103;
        float r112 = r100.floatValue() * r111;
        float r113 = (r102 - r112) / 2.0f;
        r110 = new RectF(r113, 0.0f, r112 + r113, r111);
        goto L9
    }

    public static Rect getCropRectOfReferenceAspectRatio(Size r100, Size r101) {
        return getCenterCroppedRectangle(toRational(r101), r100);
    }

    public static List<Size> getParentSizesThatAreTooLarge(Collection<Size> r100, List<Size> r101) {
        if (r100.isEmpty() == true) goto L18;
        if (r101.isEmpty() == true) goto L18;
        List<Size> r102 = removeDuplicates(r101);
        ArrayList r103 = new ArrayList();
        Iterator<Size> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L14;
        Size r105 = r104.next();
        if (isAllChildSizesCanBeCroppedOutWithoutUpscalingParent(r100, r105) == false) goto L9;
        r103.add(r105);
        goto L9
    L14:
        if (r103.isEmpty() == true) goto L16;
        ListProtector.remove(r103, r103.size() - 1);
    L16:
        return r103;
    L18:
        return new ArrayList();
    }

    public static boolean hasUpscaling(Size r100, Size r101) {
        if (r100.getHeight() <= r101.getHeight()) goto L5;
    L8:
        return true;
    L5:
        if (r100.getWidth() > r101.getWidth()) goto L8;
        return false;
    }

    private static boolean isAllChildSizesCanBeCroppedOutWithoutUpscalingParent(Collection<Size> r100, Size r101) {
        Iterator<Size> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (hasUpscaling(r102.next(), r101) == false) goto L4;
        return false;
    L9:
        return true;
    }

    private static boolean isAnyChildSizeCanBeCroppedOutWithoutUpscalingParent(Collection<Size> r100, Size r101) {
        Iterator<Size> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (hasUpscaling(r102.next(), r101) == true) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean isDoubleCropping(Rational r100, Size r101) {
        if (this.mSensorAspectRatio.equals(r100) == false) goto L5;
        return false;
    L5:
        if (AspectRatioUtil.hasMatchingAspectRatio(r101, r100) == false) goto L8;
        return false;
    L8:
        return areCroppingInDifferentDirection(this.mSensorAspectRatio.floatValue(), r100.floatValue(), toRationalWithMod16Considered(r101).floatValue());
    }

    private List<Size> selectOtherAspectRatioParentResolutionsWithFovPriority(List<Size> r100, boolean r101) {
        Map<Rational, List<Size>> r102 = groupSizesByAspectRatio(r100);
        ArrayList r103 = new ArrayList(r102.keySet());
        sortByFov(r103);
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L11;
        Rational r106 = (Rational) r105.next();
        if (r106.equals(AspectRatioUtil.ASPECT_RATIO_16_9) == true) goto L4;
        if (r106.equals(AspectRatioUtil.ASPECT_RATIO_4_3) == true) goto L4;
        List<Size> r107 = r102.get(r106);
        Objects.requireNonNull(r107);
        r104.addAll(selectParentResolutionsByAspectRatio(r106, r107, r101));
        goto L4
    L11:
        return r104;
    }

    public Size getPreferredChildSize(Size r100, UseCaseConfig<?> r101) {
        List<Size> r102 = getSortedChildSizes(r101);
        Iterator<Size> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Size r104 = r103.next();
        if (isDoubleCropping(r100, r104) == true) goto L4;
        if (hasUpscaling(r104, r100) == true) goto L4;
        return r104;
    L11:
        Iterator<Size> r105 = r102.iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        Size r106 = r105.next();
        if (hasUpscaling(r106, r100) == true) goto L13;
        return r106;
    L17:
        return r100;
    }

    public Size getPreferredChildSizeForViewport(Size r100, UseCaseConfig<?> r101) {
        Iterator<Size> r102 = getSortedChildSizes(r101).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Size r103 = TransformUtils.rectToSize(getCropRectOfReferenceAspectRatio(r102.next(), r100));
        if (hasUpscaling(r103, r100) == true) goto L4;
        return r103;
    L8:
        return r100;
    }

    private boolean isDoubleCropping(Size r100, Size r101) {
        return isDoubleCropping(toRationalWithMod16Considered(r100), r101);
    }

    private ResolutionsMerger(Size r100, CameraInfoInternal r101, Set<UseCaseConfig<?>> r102) {
        this(r100, r101, r102, new SupportedOutputSizesSorter(r101, r100));
    }

    private Pair<Rect, Size> getPreferredChildSizePairInternal(Rect r100, UseCaseConfig<?> r101, boolean r102) {
        if (r102 == false) goto L4;
        Size r103 = getPreferredChildSizeForViewport(TransformUtils.rectToSize(r100), r101);
    L6:
        return new Pair(r100, r103);
    L4:
        Size r104 = TransformUtils.rectToSize(r100);
        r103 = getPreferredChildSize(r104, r101);
        r100 = getCropRectOfReferenceAspectRatio(r104, r103);
        goto L6
    }

    private List<Size> selectParentResolutionsByAspectRatio(Rational r100, List<Size> r101, boolean r102) {
        List<Size> r103 = filterResolutionsByAspectRatio(r100, r101);
        sortInDescendingOrder(r103);
        HashSet r104 = new HashSet(r103);
        Iterator<UseCaseConfig<?>> r105 = this.mChildrenConfigs.iterator();
    L4:
        if (r105.hasNext() == false) goto L13;
        List<Size> r106 = getSortedChildSizes(r105.next());
        if (r102 == true) goto L9;
        r106 = filterOutChildSizesCausingDoubleCropping(r100, r106);
    L9:
        if (r106.isEmpty() == true) goto L11;
        r103 = filterOutParentSizeThatIsTooSmall(r106, r103);
        r104.retainAll(getParentSizesThatAreTooLarge(r106, r103));
        goto L4
    L11:
        return new ArrayList();
    L13:
        ArrayList r107 = new ArrayList();
        Iterator<Size> r108 = r103.iterator();
    L15:
        if (r108.hasNext() == false) goto L19;
        Size r109 = r108.next();
        if (r104.contains(r109) == true) goto L15;
        r107.add(r109);
        goto L15
    L19:
        return r107;
    }

    public ResolutionsMerger(Size r100, CameraInfoInternal r101, Set<UseCaseConfig<?>> r102, SupportedOutputSizesSorter r103) {
        this.mChildSizesCache = new HashMap();
        this.mSensorSize = r100;
        Rational r104 = getSensorAspectRatio(r100);
        this.mSensorAspectRatio = r104;
        this.mFallbackAspectRatio = getFallbackAspectRatio(r104);
        this.mCameraInfo = r101;
        this.mChildrenConfigs = r102;
        this.mSizeSorter = r103;
    }

    public Pair<Rect, Size> getPreferredChildSizePair(UseCaseConfig<?> r100, Rect r101, int r102, boolean r103) {
        if (TransformUtils.is90or270(r102) == false) goto L5;
        r101 = reverseRect(r101);
        boolean r104 = true;
    L6:
        Pair<Rect, Size> r105 = getPreferredChildSizePairInternal(r101, r100, r103);
        Rect r106 = (Rect) r105.first;
        Size r107 = (Size) r105.second;
        if (r104 == false) goto L10;
        r107 = TransformUtils.reverseSize(r107);
        r106 = reverseRect(r106);
    L10:
        return new Pair(r106, r107);
    L5:
        r104 = false;
        goto L6
    }
}
