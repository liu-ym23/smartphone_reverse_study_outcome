package androidx.camera.core.internal;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SupportedOutputSizesSorter {
    private static final String TAG = "SupportedOutputSizesCollector";
    private final CameraInfoInternal mCameraInfoInternal;
    private final Rational mFullFovRatio;
    private final int mLensFacing;
    private final int mSensorOrientation;
    private final SupportedOutputSizesSorterLegacy mSupportedOutputSizesSorterLegacy;

    private Rational calculateFullFovRatioFromActiveArraySize(Size r100) {
        return new Rational(r100.getWidth(), r100.getHeight());
    }

    private Rational calculateFullFovRatioFromSupportedOutputSizes(CameraInfoInternal r100) {
        List<Size> r101 = r100.getSupportedResolutions(256);
        if (r101.isEmpty() == false) goto L6;
        return null;
    L6:
        Size r102 = (Size) Collections.max(r101, new CompareSizesByArea());
        return new Rational(r102.getWidth(), r102.getHeight());
    }

    public static List<Rational> getResolutionListGroupingAspectRatioKeys(List<Size> r100) {
        ArrayList r101 = new ArrayList();
        r101.add(AspectRatioUtil.ASPECT_RATIO_4_3);
        r101.add(AspectRatioUtil.ASPECT_RATIO_16_9);
        Iterator<Size> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        Size r103 = r102.next();
        Rational r104 = new Rational(r103.getWidth(), r103.getHeight());
        if (r101.contains(r104) == true) goto L4;
        Iterator r105 = r101.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        if (AspectRatioUtil.hasMatchingAspectRatio(r103, (Rational) r105.next()) == false) goto L9;
        boolean r106 = true;
    L14:
        if (r106 == true) goto L4;
        r101.add(r104);
        goto L4
    L13:
        r106 = false;
        goto L14
    L16:
        return r101;
    }

    public static Map<Rational, List<Size>> groupSizesByAspectRatio(List<Size> r100) {
        HashMap r101 = new HashMap();
        Iterator<Rational> r102 = getResolutionListGroupingAspectRatioKeys(r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.put(r102.next(), new ArrayList());
        goto L4
    L6:
        Iterator<Size> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L15;
        Size r104 = r103.next();
        Iterator r105 = r101.keySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L8;
        Rational r106 = (Rational) r105.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r104, r106) == false) goto L11;
        ((List) r101.get(r106)).add(r104);
        goto L11
    L15:
        return r101;
    }

    public List<Size> getSortedSupportedOutputSizes(UseCaseConfig<?> r110) {
        ImageOutputConfig r100 = (ImageOutputConfig) r110;
        List<Size> r101 = r100.getCustomOrderedResolutions(null);
        if (r101 == null) goto L5;
        return r101;
    L5:
        ResolutionSelector r102 = r100.getResolutionSelector(null);
        List<Size> r103 = getResolutionCandidateList(r100.getSupportedResolutions(null), r110.getInputFormat());
        if (r102 == null) goto L8;
        Size r104 = ((ImageOutputConfig) r110).getMaxResolution(null);
        int r105 = r100.getTargetRotation(0);
        if (r110.isHighResolutionDisabled(false) == true) goto L12;
        r103 = applyHighResolutionSettings(r103, r102, r110.getInputFormat());
    L12:
        ResolutionSelector r106 = r100.getResolutionSelector();
        return sortSupportedOutputSizesByResolutionSelector(r106, r103, r104, r105, this.mFullFovRatio, this.mSensorOrientation, this.mLensFacing);
    L8:
        return this.mSupportedOutputSizesSorterLegacy.sortSupportedOutputSizes(r103, r110);
    }

    public SupportedOutputSizesSorter(CameraInfoInternal r100, Size r101) {
        this.mCameraInfoInternal = r100;
        this.mSensorOrientation = r100.getSensorRotationDegrees();
        this.mLensFacing = r100.getLensFacing();
        if (r101 == null) goto L5;
        Rational r102 = calculateFullFovRatioFromActiveArraySize(r101);
    L6:
        this.mFullFovRatio = r102;
        this.mSupportedOutputSizesSorterLegacy = new SupportedOutputSizesSorterLegacy(r100, r102);
        return;
    L5:
        r102 = calculateFullFovRatioFromSupportedOutputSizes(r100);
        goto L6
    }

    private static void applyMaxResolutionRestriction(LinkedHashMap<Rational, List<Size>> r100, Size r101) {
        int r102 = SizeUtil.getArea(r101);
        Iterator<Rational> r103 = r100.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        List r104 = r100.get(r103.next());
        ArrayList r105 = new ArrayList();
        Iterator r106 = r104.iterator();
    L7:
        if (r106.hasNext() == false) goto L11;
        Size r107 = (Size) r106.next();
        if (SizeUtil.getArea(r107) > r102) goto L7;
        r105.add(r107);
        goto L7
    L11:
        r104.clear();
        r104.addAll(r105);
        goto L4
    }

    private static void applyResolutionStrategy(LinkedHashMap<Rational, List<Size>> r100, ResolutionStrategy r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Iterator<Rational> r102 = r100.keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        applyResolutionStrategyFallbackRule(r100.get(r102.next()), r101);
        goto L6
    }

    private static void applyResolutionStrategyFallbackRule(List<Size> r100, ResolutionStrategy r101) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        Integer r102 = Integer.valueOf(r101.getFallbackRule());
        if (r101.equals(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY) == false) goto L8;
        return;
    L8:
        Size r103 = r101.getBoundSize();
        int r104 = r102.intValue();
        if (r104 != 0) goto L11;
        sortSupportedSizesByFallbackRuleNone(r100, r103);
        return;
    L11:
        if (r104 != 1) goto L13;
        sortSupportedSizesByFallbackRuleClosestHigherThenLower(r100, r103, true);
        return;
    L13:
        if (r104 != 2) goto L15;
        sortSupportedSizesByFallbackRuleClosestHigherThenLower(r100, r103, false);
        return;
    L15:
        if (r104 != 3) goto L17;
        sortSupportedSizesByFallbackRuleClosestLowerThenHigher(r100, r103, true);
        return;
    L17:
        if (r104 != 4) goto L29;
        sortSupportedSizesByFallbackRuleClosestLowerThenHigher(r100, r103, false);
        return;
    }

    private List<Size> getResolutionCandidateList(List<Pair<Integer, Size[]>> r100, int r101) {
        List<Size> r102 = getSizeListByFormat(r100, r101);
        if (r102 != null) goto L5;
        r102 = this.mCameraInfoInternal.getSupportedResolutions(r101);
    L5:
        ArrayList r103 = new ArrayList(r102);
        Collections.sort(r103, new CompareSizesByArea(true));
        if (r103.isEmpty() == false) goto L8;
        Logger.w(TAG, "The retrieved supported resolutions from camera info internal is empty. Format is " + r101 + ".");
    L8:
        return r103;
    }

    private List<Size> getSizeListByFormat(List<Pair<Integer, Size[]>> r100, int r101) {
        if (r100 == null) goto L10;
        Iterator<Pair<Integer, Size[]>> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Pair<Integer, Size[]> r103 = r102.next();
        if (((Integer) r103.first).intValue() != r101) goto L6;
        Size[] r104 = (Size[]) r103.second;
    L11:
        if (r104 != null) goto L14;
        return null;
    L14:
        return Arrays.asList(r104);
    L10:
        r104 = null;
        goto L11
    }

    public static Rational getTargetAspectRatioRationalValue(int r100, boolean r101) {
        if (r100 == (-1)) goto L14;
        if (r100 != 0) goto L6;
        if (r101 == false) goto L19;
        return AspectRatioUtil.ASPECT_RATIO_4_3;
    L19:
        return AspectRatioUtil.ASPECT_RATIO_3_4;
    L6:
        if (r100 == 1) goto L8;
        Logger.e(TAG, "Undefined target aspect ratio: " + r100);
        goto L14
    L8:
        if (r101 == false) goto L17;
        return AspectRatioUtil.ASPECT_RATIO_16_9;
    L17:
        return AspectRatioUtil.ASPECT_RATIO_9_16;
    L14:
        return null;
    }

    private static void sortSupportedSizesByFallbackRuleNone(List<Size> r100, Size r101) {
        boolean r102 = r100.contains(r101);
        r100.clear();
        if (r102 == false) goto L6;
        r100.add(r101);
        return;
    }

    private static LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategy(List<Size> r100, AspectRatioStrategy r101, Rational r102) {
        return applyAspectRatioStrategyFallbackRule(groupSizesByAspectRatio(r100), r101, r102);
    }

    private static LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategyFallbackRule(Map<Rational, List<Size>> r100, AspectRatioStrategy r101, Rational r102) {
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        Rational r104 = getTargetAspectRatioRationalValue(r101.getPreferredAspectRatio(), r103);
        if (r101.getFallbackRule() != 0) goto L16;
        Rational r105 = getTargetAspectRatioRationalValue(r101.getPreferredAspectRatio(), r103);
        Iterator r106 = new ArrayList(r100.keySet()).iterator();
    L12:
        if (r106.hasNext() == false) goto L16;
        Rational r107 = (Rational) r106.next();
        if (r107.equals(r105) == true) goto L12;
        r100.remove(r107);
    L16:
        ArrayList r108 = new ArrayList(r100.keySet());
        Collections.sort(r108, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(r104, r102));
        LinkedHashMap<Rational, List<Size>> r109 = new LinkedHashMap();
        Iterator r110 = r108.iterator();
    L18:
        if (r110.hasNext() == false) goto L20;
        Rational r111 = (Rational) r110.next();
        r109.put(r111, r100.get(r111));
        goto L18
    L20:
        return r109;
    L5:
        if (r102.getNumerator() >= r102.getDenominator()) goto L8;
        r103 = false;
        goto L8
    }

    private List<Size> applyHighResolutionSettings(List<Size> r100, ResolutionSelector r101, int r102) {
        if (r101.getAllowedResolutionMode() != 1) goto L6;
        ArrayList r103 = new ArrayList();
        r103.addAll(r100);
        r103.addAll(this.mCameraInfoInternal.getSupportedHighResolutions(r102));
        Collections.sort(r103, new CompareSizesByArea(true));
        return r103;
    L6:
        return r100;
    }

    public static void sortSupportedSizesByFallbackRuleClosestHigherThenLower(List<Size> r100, Size r101, boolean r102) {
        ArrayList r103 = new ArrayList();
        int r104 = r100.size() - 1;
    L3:
        if (r104 < 0) goto L9;
        Size r105 = (Size) ListProtector.get(r100, r104);
        if (r105.getWidth() < r101.getWidth()) goto L8;
        if (r105.getHeight() >= r101.getHeight()) goto L9;
    L8:
        ListProtector.add(r103, 0, r105);
        r104 = r104 - 1;
    L9:
        r100.removeAll(r103);
        Collections.reverse(r100);
        if (r102 == false) goto L17;
        r100.addAll(r103);
        return;
    }

    private static void sortSupportedSizesByFallbackRuleClosestLowerThenHigher(List<Size> r100, Size r101, boolean r102) {
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L4:
        if (r104 >= r100.size()) goto L10;
        Size r105 = (Size) ListProtector.get(r100, r104);
        if (r105.getWidth() > r101.getWidth()) goto L9;
        if (r105.getHeight() <= r101.getHeight()) goto L10;
    L9:
        ListProtector.add(r103, 0, r105);
        r104 = r104 + 1;
    L10:
        r100.removeAll(r103);
        if (r102 == false) goto L18;
        r100.addAll(r103);
        return;
    }

    private static List<Size> applyResolutionFilter(List<Size> r100, ResolutionFilter r101, int r102, int r103, int r104) {
        if (r101 != null) goto L4;
        return r100;
    L4:
        int r105 = CameraOrientationUtil.surfaceRotationToDegrees(r102);
        boolean r106 = true;
        if (r104 == 1) goto L8;
        r106 = false;
    L8:
        int r107 = CameraOrientationUtil.getRelativeImageRotation(r105, r103, r106);
        List<Size> r108 = r101.filter(new ArrayList(r100), r107);
        if (r100.containsAll(r108) == false) goto L12;
        return r108;
    L12:
        throw new IllegalArgumentException("The returned sizes list of the resolution filter must be a subset of the provided sizes list.");
    }

    public static List<Size> sortSupportedOutputSizesByResolutionSelector(ResolutionSelector r100, List<Size> r101, Size r102, int r103, Rational r104, int r105, int r106) {
        LinkedHashMap<Rational, List<Size>> r107 = applyAspectRatioStrategy(r101, r100.getAspectRatioStrategy(), r104);
        if (r102 == null) goto L5;
        applyMaxResolutionRestriction(r107, r102);
    L5:
        applyResolutionStrategy(r107, r100.getResolutionStrategy());
        ArrayList r108 = new ArrayList();
        Iterator<List<Size>> r109 = r107.values().iterator();
    L7:
        if (r109.hasNext() == false) goto L15;
        Iterator<Size> r110 = r109.next().iterator();
    L10:
        if (r110.hasNext() == false) goto L7;
        Size r111 = r110.next();
        if (r108.contains(r111) == true) goto L10;
        r108.add(r111);
        goto L10
    L15:
        return applyResolutionFilter(r108, r100.getResolutionFilter(), r103, r105, r106);
    }
}
