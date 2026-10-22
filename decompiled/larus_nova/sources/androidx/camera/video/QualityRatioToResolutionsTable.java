package androidx.camera.video;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.internal.utils.SizeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class QualityRatioToResolutionsTable {
    private static final Map<Integer, Rational> sAspectRatioMap = null;
    private static final Map<Quality, Range<Integer>> sQualityRangeMap = null;
    private final Map<QualityRatio, List<Size>> mTable;

    public static abstract class QualityRatio {
        public QualityRatio() {
        }

        public abstract int getAspectRatio();

        public abstract Quality getQuality();

        public static QualityRatio of(Quality r100, int r101) {
            return new AutoValue_QualityRatioToResolutionsTable_QualityRatio(r100, r101);
        }
    }

    public static /* synthetic */ int a(int r100, Size r101, Size r102) {
        return lambda$sortQualityRatioRow$0(r100, r101, r102);
    }

    static {
        HashMap r100 = new HashMap();
        sQualityRangeMap = r100;
        r100.put(Quality.UHD, Range.create(2160, 4319));
        r100.put(Quality.FHD, Range.create(1080, 1439));
        r100.put(Quality.HD, Range.create(720, 1079));
        r100.put(Quality.SD, Range.create(241, 719));
        HashMap r101 = new HashMap();
        sAspectRatioMap = r101;
        r101.put(0, AspectRatioUtil.ASPECT_RATIO_4_3);
        r101.put(1, AspectRatioUtil.ASPECT_RATIO_16_9);
    }

    private void addProfileSizesToTable(Map<Quality, Size> r100) {
        Iterator<Map.Entry<Quality, Size>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<Quality, Size> r102 = r101.next();
        List<Size> r103 = getQualityRatioRow(r102.getKey(), -1);
        Objects.requireNonNull(r103);
        r103.add(r102.getValue());
        goto L4
    }

    private void addResolutionsToTable(List<Size> r100) {
        Iterator<Size> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        Size r102 = r101.next();
        Quality r103 = findMappedQuality(r102);
        if (r103 == null) goto L4;
        Integer r104 = findMappedAspectRatio(r102);
        if (r104 == null) goto L4;
        List<Size> r105 = getQualityRatioRow(r103, r104.intValue());
        Objects.requireNonNull(r105);
        r105.add(r102);
        goto L4
    }

    private static Integer findMappedAspectRatio(Size r100) {
        Iterator<Map.Entry<Integer, Rational>> r101 = sAspectRatioMap.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<Integer, Rational> r102 = r101.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r100, r102.getValue(), SizeUtil.RESOLUTION_QVGA) == false) goto L4;
        return r102.getKey();
    L9:
        return null;
    }

    private static Quality findMappedQuality(Size r100) {
        Iterator<Map.Entry<Quality, Range<Integer>>> r101 = sQualityRangeMap.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<Quality, Range<Integer>> r102 = r101.next();
        if (r102.getValue().contains(Integer.valueOf(r100.getHeight())) == false) goto L4;
        return r102.getKey();
    L9:
        return null;
    }

    private void sortQualityRatioRow(Map<Quality, Size> r100) {
        Iterator<Map.Entry<QualityRatio, List<Size>>> r101 = this.mTable.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<QualityRatio, List<Size>> r102 = r101.next();
        Size r103 = r100.get(r102.getKey().getQuality());
        if (r103 == null) goto L4;
        final int r104 = SizeUtil.getArea(r103);
        Collections.sort(r102.getValue(), new a(r104));
        goto L4
    }

    public QualityRatioToResolutionsTable(List<Size> r100, Map<Quality, Size> r101) {
        this.mTable = new HashMap();
        Iterator<Quality> r102 = sQualityRangeMap.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Quality r103 = r102.next();
        this.mTable.put(QualityRatio.of(r103, -1), new ArrayList());
        Iterator<Integer> r104 = sAspectRatioMap.keySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L4;
        Integer r105 = r104.next();
        this.mTable.put(QualityRatio.of(r103, r105.intValue()), new ArrayList());
        goto L7
    L9:
        addProfileSizesToTable(r101);
        addResolutionsToTable(r100);
        sortQualityRatioRow(r101);
    }

    private List<Size> getQualityRatioRow(Quality r100, int r101) {
        return this.mTable.get(QualityRatio.of(r100, r101));
    }

    public List<Size> getResolutions(Quality r100, int r101) {
        List<Size> r102 = getQualityRatioRow(r100, r101);
        if (r102 == null) goto L5;
        ArrayList r103 = new ArrayList(r102);
    L6:
        return r103;
    L5:
        r103 = new ArrayList(0);
        goto L6
    }

    private static /* synthetic */ int lambda$sortQualityRatioRow$0(int r100, Size r101, Size r102) {
        return Math.abs(SizeUtil.getArea(r101) - r100) - Math.abs(SizeUtil.getArea(r102) - r100);
    }
}
