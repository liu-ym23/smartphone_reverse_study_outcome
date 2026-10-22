package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.camera.core.DynamicRange;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class DynamicRangeConversions {
    private static final Map<DynamicRange, List<Long>> DR_TO_PROFILE_MAP = null;
    private static final Map<Long, DynamicRange> PROFILE_TO_DR_MAP = null;

    private DynamicRangeConversions() {
    }

    static {
        HashMap r100 = new HashMap();
        PROFILE_TO_DR_MAP = r100;
        HashMap r101 = new HashMap();
        DR_TO_PROFILE_MAP = r101;
        DynamicRange r102 = DynamicRange.SDR;
        r100.put(1L, r102);
        r101.put(r102, Collections.singletonList(1L));
        r100.put(2L, DynamicRange.HLG_10_BIT);
        r101.put((DynamicRange) r100.get(2L), Collections.singletonList(2L));
        DynamicRange r103 = DynamicRange.HDR10_10_BIT;
        r100.put(4L, r103);
        r101.put(r103, Collections.singletonList(4L));
        DynamicRange r104 = DynamicRange.HDR10_PLUS_10_BIT;
        r100.put(8L, r104);
        r101.put(r104, Collections.singletonList(8L));
        List<Long> r105 = Arrays.asList(new Long[]{64L, 128L, 16L, 32L});
        Iterator<Long> r106 = r105.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        PROFILE_TO_DR_MAP.put(r106.next(), DynamicRange.DOLBY_VISION_10_BIT);
        goto L4
    L6:
        DR_TO_PROFILE_MAP.put(DynamicRange.DOLBY_VISION_10_BIT, r105);
        List<Long> r107 = Arrays.asList(new Long[]{1024L, 2048L, 256L, 512L});
        Iterator<Long> r108 = r107.iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        PROFILE_TO_DR_MAP.put(r108.next(), DynamicRange.DOLBY_VISION_8_BIT);
        goto L8
    L10:
        DR_TO_PROFILE_MAP.put(DynamicRange.DOLBY_VISION_8_BIT, r107);
    }

    public static DynamicRange profileToDynamicRange(long r100) {
        return PROFILE_TO_DR_MAP.get(Long.valueOf(r100));
    }

    public static Long dynamicRangeToFirstSupportedProfile(DynamicRange r100, DynamicRangeProfiles r101) {
        List<Long> r102 = DR_TO_PROFILE_MAP.get(r100);
        if (r102 == null) goto L10;
        Set<Long> r103 = r101.getSupportedProfiles();
        Iterator<Long> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L15;
        Long r105 = r104.next();
        if (r103.contains(r105) == false) goto L6;
        return r105;
    L15:
        return null;
    L10:
        return null;
    }
}
