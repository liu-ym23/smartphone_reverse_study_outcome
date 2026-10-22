package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.text.TextUtils;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.params.DynamicRangeConversions;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class DynamicRangeResolver {
    private static final String TAG = "DynamicRangeResolver";
    private final CameraCharacteristicsCompat mCharacteristics;
    private final DynamicRangesCompat mDynamicRangesInfo;
    private final boolean mIs10BitSupported;

    public static final class Api33Impl {
        private Api33Impl() {
        }

        public static DynamicRange getRecommended10BitDynamicRange(CameraCharacteristicsCompat r100) {
            Long r101 = (Long) r100.get(CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE);
            if (r101 != null) goto L5;
            return null;
        L5:
            return DynamicRangeConversions.profileToDynamicRange(r101.longValue());
        }
    }

    public boolean is10BitDynamicRangeSupported() {
        return this.mIs10BitSupported;
    }

    public DynamicRangeResolver(CameraCharacteristicsCompat r100) {
        this.mCharacteristics = r100;
        this.mDynamicRangesInfo = DynamicRangesCompat.fromCameraCharacteristics(r100);
        int[] r101 = (int[]) r100.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        boolean r102 = false;
        if (r101 == null) goto L10;
        int r103 = r101.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L10;
        if (r101[r104] == 18) goto L8;
        r104 = r104 + 1;
        goto L5
    L8:
        r102 = true;
    L10:
        this.mIs10BitSupported = r102;
    }

    private static boolean isFullyUnspecified(DynamicRange r100) {
        return Objects.equals(r100, DynamicRange.UNSPECIFIED);
    }

    private static boolean isPartiallySpecified(DynamicRange r100) {
        if (r100.getEncoding() != 2) goto L5;
    L14:
        return true;
    L5:
        if (r100.getEncoding() == 0) goto L9;
        if (r100.getBitDepth() == 0) goto L14;
    L9:
        if (r100.getEncoding() == 0) goto L11;
    L13:
        return false;
    L11:
        if (r100.getBitDepth() == 0) goto L13;
        goto L13
    }

    private static boolean canResolve(DynamicRange r100, DynamicRange r101) {
        Preconditions.checkState(r101.isFullySpecified(), "Fully specified range is not actually fully specified.");
        if (r100.getEncoding() != 2) goto L8;
        if (r101.getEncoding() != 1) goto L8;
        return false;
    L8:
        if (r100.getEncoding() == 2) goto L15;
        if (r100.getEncoding() == 0) goto L15;
        if (r100.getEncoding() == r101.getEncoding()) goto L15;
        return false;
    L15:
        if (r100.getBitDepth() != 0) goto L17;
        return true;
    L17:
        if (r100.getBitDepth() == r101.getBitDepth()) goto L22;
        return false;
    L22:
        return true;
    }

    private static boolean canResolveWithinConstraints(DynamicRange r100, DynamicRange r101, Set<DynamicRange> r102) {
        if (r102.contains(r101) == true) goto L7;
        Logger.d(TAG, String.format("Candidate Dynamic range is not within constraints.\nDynamic range to resolve:\n  %s\nCandidate dynamic range:\n  %s", new Object[]{r100, r101}));
        return false;
    L7:
        return canResolve(r100, r101);
    }

    private static DynamicRange findSupportedHdrMatch(DynamicRange r100, Collection<DynamicRange> r101, Set<DynamicRange> r102) {
        if (r100.getEncoding() != 1) goto L5;
        return null;
    L5:
        Iterator<DynamicRange> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L14;
        DynamicRange r104 = r103.next();
        Preconditions.checkNotNull(r104, "Fully specified DynamicRange cannot be null.");
        int r105 = r104.getEncoding();
        Preconditions.checkState(r104.isFullySpecified(), "Fully specified DynamicRange must have fully defined encoding.");
        if (r105 == 1) goto L7;
        if (canResolveWithinConstraints(r100, r104, r102) == false) goto L7;
        return r104;
    L14:
        return null;
    }

    private static void updateConstraints(Set<DynamicRange> r100, DynamicRange r101, DynamicRangesCompat r102) {
        Preconditions.checkState(!r100.isEmpty(), "Cannot update already-empty constraints.");
        Set<DynamicRange> r103 = r102.getDynamicRangeCaptureRequestConstraints(r101);
        if (r103.isEmpty() == true) goto L9;
        HashSet r104 = new HashSet(r100);
        r100.retainAll(r103);
        if (r100.isEmpty() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(String.format("Constraints of dynamic range cannot be combined with existing constraints.\nDynamic range:\n  %s\nConstraints:\n  %s\nExisting constraints:\n  %s", new Object[]{r101, TextUtils.join("\n  ", r103), TextUtils.join("\n  ", r104)}));
    }

    public Map<UseCaseConfig<?>, DynamicRange> resolveAndValidateDynamicRanges(List<AttachedSurfaceInfo> r110, List<UseCaseConfig<?>> r111, List<Integer> r112) {
        LinkedHashSet r100 = new LinkedHashSet();
        Iterator<AttachedSurfaceInfo> r113 = r110.iterator();
    L4:
        if (r113.hasNext() == false) goto L6;
        r100.add(r113.next().getDynamicRange());
        goto L4
    L6:
        Set<DynamicRange> r114 = this.mDynamicRangesInfo.getSupportedDynamicRanges();
        HashSet r101 = new HashSet(r114);
        Iterator<DynamicRange> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        updateConstraints(r101, r102.next(), this.mDynamicRangesInfo);
        goto L8
    L10:
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        Iterator<Integer> r115 = r112.iterator();
    L12:
        if (r115.hasNext() == false) goto L20;
        UseCaseConfig r106 = (UseCaseConfig) ListProtector.get(r111, r115.next().intValue());
        DynamicRange r107 = r106.getDynamicRange();
        if (isFullyUnspecified(r107) == true) goto L15;
        if (isPartiallySpecified(r107) == true) goto L18;
        r103.add(r106);
        goto L12
    L18:
        r104.add(r106);
        goto L12
    L15:
        r105.add(r106);
        goto L12
    L20:
        HashMap r116 = new HashMap();
        LinkedHashSet r117 = new LinkedHashSet();
        ArrayList r108 = new ArrayList();
        r108.addAll(r103);
        r108.addAll(r104);
        r108.addAll(r105);
        Iterator r109 = r108.iterator();
    L22:
        if (r109.hasNext() == false) goto L26;
        UseCaseConfig<?> r118 = (UseCaseConfig) r109.next();
        DynamicRange r119 = resolveDynamicRangeAndUpdateConstraints(r114, r100, r117, r118, r101);
        r116.put(r118, r119);
        if (r100.contains(r119) == true) goto L22;
        r117.add(r119);
        goto L22
    L26:
        return r116;
    }

    private DynamicRange resolveDynamicRange(DynamicRange r100, Set<DynamicRange> r110, Set<DynamicRange> r111, Set<DynamicRange> r112, String r113) {
        if (r100.isFullySpecified() == true) goto L5;
        int r101 = r100.getEncoding();
        int r102 = r100.getBitDepth();
        if (r101 != 1) goto L15;
        if (r102 != 0) goto L15;
        DynamicRange r103 = DynamicRange.SDR;
        if (r110.contains(r103) == false) goto L14;
        return r103;
    L14:
        return null;
    L15:
        DynamicRange r114 = findSupportedHdrMatch(r100, r111, r110);
        if (r114 == null) goto L19;
        Logger.d(TAG, String.format("Resolved dynamic range for use case %s from existing attached surface.\n%s\n->\n%s", new Object[]{r113, r100, r114}));
        return r114;
    L19:
        DynamicRange r115 = findSupportedHdrMatch(r100, r112, r110);
        if (r115 == null) goto L23;
        Logger.d(TAG, String.format("Resolved dynamic range for use case %s from concurrently bound use case.\n%s\n->\n%s", new Object[]{r113, r100, r115}));
        return r115;
    L23:
        DynamicRange r116 = DynamicRange.SDR;
        if (canResolveWithinConstraints(r100, r116, r110) == false) goto L27;
        Logger.d(TAG, String.format("Resolved dynamic range for use case %s to no compatible HDR dynamic ranges.\n%s\n->\n%s", new Object[]{r113, r100, r116}));
        return r116;
    L27:
        if (r101 == 2) goto L29;
    L45:
        Iterator<DynamicRange> r117 = r110.iterator();
    L47:
        if (r117.hasNext() == false) goto L55;
        DynamicRange r118 = r117.next();
        Preconditions.checkState(r118.isFullySpecified(), "Candidate dynamic range must be fully specified.");
        if (r118.equals(DynamicRange.SDR) == true) goto L47;
        if (canResolve(r100, r118) == false) goto L47;
        Logger.d(TAG, String.format("Resolved dynamic range for use case %s from validated dynamic range constraints or supported HDR dynamic ranges.\n%s\n->\n%s", new Object[]{r113, r100, r118}));
        return r118;
    L55:
        return null;
    L29:
        if (r102 == 10) goto L31;
        if (r102 != 0) goto L45;
    L31:
        LinkedHashSet r119 = new LinkedHashSet();
        if (Build.VERSION.SDK_INT < 33) goto L36;
        DynamicRange r120 = Api33Impl.getRecommended10BitDynamicRange(this.mCharacteristics);
        if (r120 == null) goto L37;
        r119.add(r120);
    L37:
        r119.add(DynamicRange.HLG_10_BIT);
        DynamicRange r121 = findSupportedHdrMatch(r100, r119, r110);
        if (r121 == null) goto L45;
        Object[] r122 = new Object[4];
        r122[0] = r113;
        if (r121.equals(r120) == false) goto L42;
        String r123 = "recommended";
    L43:
        r122[1] = r123;
        r122[2] = r100;
        r122[3] = r121;
        Logger.d(TAG, String.format("Resolved dynamic range for use case %s from %s 10-bit supported dynamic range.\n%s\n->\n%s", r122));
        return r121;
    L42:
        r123 = "required";
        goto L43
    L36:
        r120 = null;
        goto L37
    L5:
        if (r110.contains(r100) == false) goto L7;
        return r100;
    L7:
        return null;
    }

    private DynamicRange resolveDynamicRangeAndUpdateConstraints(Set<DynamicRange> r100, Set<DynamicRange> r101, Set<DynamicRange> r110, UseCaseConfig<?> r111, Set<DynamicRange> r112) {
        DynamicRange r102 = r111.getDynamicRange();
        DynamicRange r103 = resolveDynamicRange(r102, r112, r101, r110, r111.getTargetName());
        if (r103 == null) goto L7;
        updateConstraints(r112, r103, this.mDynamicRangesInfo);
        return r103;
    L7:
        throw new IllegalArgumentException(String.format("Unable to resolve supported dynamic range. The dynamic range may not be supported on the device or may not be allowed concurrently with other attached use cases.\nUse case:\n  %s\nRequested dynamic range:\n  %s\nSupported dynamic ranges:\n  %s\nConstrained set of concurrent dynamic ranges:\n  %s", new Object[]{r111.getTargetName(), r102, TextUtils.join("\n  ", r100), TextUtils.join("\n  ", r112)}));
    }
}
