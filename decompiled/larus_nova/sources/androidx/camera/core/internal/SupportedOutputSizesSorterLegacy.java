package androidx.camera.core.internal;

import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class SupportedOutputSizesSorterLegacy {
    private static final String TAG = "SupportedOutputSizesCollector";
    private final Rational mFullFovRatio;
    private final boolean mIsSensorLandscapeResolution;
    private final int mLensFacing;
    private final int mSensorOrientation;

    private Size getTargetSize(ImageOutputConfig r100) {
        int r101 = r100.getTargetRotation(0);
        return flipSizeByRotation(r100.getTargetResolution(null), r101, this.mLensFacing, this.mSensorOrientation);
    }

    public SupportedOutputSizesSorterLegacy(CameraInfoInternal r100, Rational r101) {
        this.mSensorOrientation = r100.getSensorRotationDegrees();
        this.mLensFacing = r100.getLensFacing();
        this.mFullFovRatio = r101;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        this.mIsSensorLandscapeResolution = r102;
        return;
    L5:
        if (r101.getNumerator() >= r101.getDenominator()) goto L8;
        r102 = false;
        goto L8
    }

    private static Rational getAspectRatioGroupKeyOfTargetSize(Size r100, List<Size> r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<Rational> r102 = SupportedOutputSizesSorter.getResolutionListGroupingAspectRatioKeys(r101).iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        Rational r103 = r102.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r100, r103) == false) goto L7;
        return r103;
    L12:
        return new Rational(r100.getWidth(), r100.getHeight());
    }

    private Rational getTargetAspectRatioByLegacyApi(ImageOutputConfig r100, List<Size> r101) {
        if (r100.hasTargetAspectRatio() == true) goto L10;
        Size r102 = getTargetSize(r100);
        if (r102 != null) goto L11;
        return null;
    L11:
        return getAspectRatioGroupKeyOfTargetSize(r102, r101);
    L10:
        return SupportedOutputSizesSorter.getTargetAspectRatioRationalValue(r100.getTargetAspectRatio(), this.mIsSensorLandscapeResolution);
    }

    public List<Size> sortSupportedOutputSizes(List<Size> r110, UseCaseConfig<?> r111) {
        if (r110.isEmpty() == false) goto L5;
        return r110;
    L5:
        ArrayList r100 = new ArrayList(r110);
        Collections.sort(r100, new CompareSizesByArea(true));
        ArrayList r112 = new ArrayList();
        ImageOutputConfig r113 = (ImageOutputConfig) r111;
        Size r101 = r113.getMaxResolution(null);
        Size r102 = (Size) ListProtector.get(r100, 0);
        if (r101 != null) goto L8;
    L9:
        r101 = r102;
    L10:
        Size r103 = getTargetSize(r113);
        Size r104 = SizeUtil.RESOLUTION_VGA;
        int r105 = SizeUtil.getArea(r104);
        if (SizeUtil.getArea(r101) >= r105) goto L13;
        r104 = SizeUtil.RESOLUTION_ZERO;
    L17:
        Iterator r106 = r100.iterator();
    L19:
        if (r106.hasNext() == false) goto L28;
        Size r107 = (Size) r106.next();
        if (SizeUtil.getArea(r107) > SizeUtil.getArea(r101)) goto L19;
        if (SizeUtil.getArea(r107) < SizeUtil.getArea(r104)) goto L19;
        if (r112.contains(r107) == true) goto L19;
        r112.add(r107);
        goto L19
    L28:
        if (r112.isEmpty() == true) goto L54;
        Rational r108 = getTargetAspectRatioByLegacyApi(r113, r112);
        if (r103 != null) goto L32;
        r103 = r113.getDefaultResolution(null);
    L32:
        ArrayList r114 = new ArrayList();
        new HashMap();
        if (r108 != null) goto L37;
        r114.addAll(r112);
        if (r103 == null) goto L52;
        SupportedOutputSizesSorter.sortSupportedSizesByFallbackRuleClosestHigherThenLower(r114, r103, true);
    L52:
        return r114;
    L37:
        Map<Rational, List<Size>> r115 = SupportedOutputSizesSorter.groupSizesByAspectRatio(r112);
        if (r103 == null) goto L43;
        Iterator<Rational> r109 = r115.keySet().iterator();
    L41:
        if (r109.hasNext() == false) goto L43;
        SupportedOutputSizesSorter.sortSupportedSizesByFallbackRuleClosestHigherThenLower(r115.get(r109.next()), r103, true);
    L43:
        ArrayList r116 = new ArrayList(r115.keySet());
        Collections.sort(r116, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(r108, this.mFullFovRatio));
        Iterator r117 = r116.iterator();
    L45:
        if (r117.hasNext() == false) goto L52;
        Iterator<Size> r118 = r115.get((Rational) r117.next()).iterator();
    L48:
        if (r118.hasNext() == false) goto L45;
        Size r119 = r118.next();
        if (r114.contains(r119) == true) goto L48;
        r114.add(r119);
        goto L48
    L54:
        throw new IllegalArgumentException("All supported output sizes are filtered out according to current resolution selection settings. \nminSize = " + r104 + "\nmaxSize = " + r101 + "\ninitial size list: " + r100);
    L13:
        if (r103 == null) goto L17;
        if (SizeUtil.getArea(r103) >= r105) goto L17;
        r104 = r103;
        goto L17
    L8:
        if (SizeUtil.getArea(r102) >= SizeUtil.getArea(r101)) goto L10;
        goto L9
    }

    private static boolean isRotationNeeded(int r100, int r101, int r102) {
        int r103 = CameraOrientationUtil.surfaceRotationToDegrees(r100);
        if (1 != r101) goto L5;
        boolean r104 = true;
    L6:
        int r105 = CameraOrientationUtil.getRelativeImageRotation(r103, r102, r104);
        if (r105 != 90) goto L9;
    L10:
        return true;
    L9:
        if (r105 == 270) goto L10;
        return false;
    L5:
        r104 = false;
        goto L6
    }

    private static Size flipSizeByRotation(Size r100, int r101, int r102, int r103) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (isRotationNeeded(r101, r102, r103) == true) goto L6;
        return r100;
    L6:
        return new Size(r100.getHeight(), r100.getWidth());
    }
}
