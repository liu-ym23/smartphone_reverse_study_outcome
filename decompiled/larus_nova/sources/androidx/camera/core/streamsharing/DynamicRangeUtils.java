package androidx.camera.core.streamsharing;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.UseCaseConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicRangeUtils {
    private DynamicRangeUtils() {
    }

    private static DynamicRange intersectDynamicRange(List<DynamicRange> r100) {
        if (r100.isEmpty() == false) goto L5;
        return null;
    L5:
        DynamicRange r101 = (DynamicRange) ListProtector.get(r100, 0);
        Integer r102 = Integer.valueOf(r101.getEncoding());
        Integer r103 = Integer.valueOf(r101.getBitDepth());
        int r104 = 1;
    L7:
        if (r104 >= r100.size()) goto L15;
        DynamicRange r105 = (DynamicRange) ListProtector.get(r100, r104);
        r102 = intersectDynamicRangeEncoding(r102, Integer.valueOf(r105.getEncoding()));
        r103 = intersectDynamicRangeBitDepth(r103, Integer.valueOf(r105.getBitDepth()));
        if (r102 == null) goto L13;
        if (r103 == null) goto L13;
        r104 = r104 + 1;
    L13:
        return null;
    L15:
        return new DynamicRange(r102.intValue(), r103.intValue());
    }

    public static DynamicRange resolveDynamicRange(Set<UseCaseConfig<?>> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<UseCaseConfig<?>> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(r102.next().getDynamicRange());
        goto L4
    L7:
        return intersectDynamicRange(r101);
    }

    private static Integer intersectDynamicRangeBitDepth(Integer r100, Integer r101) {
        if (r100.equals(0) == false) goto L6;
        return r101;
    L6:
        if (r101.equals(0) == false) goto L9;
        return r100;
    L9:
        if (r100.equals(r101) == true) goto L13;
        return null;
    L13:
        return r100;
    }

    private static Integer intersectDynamicRangeEncoding(Integer r100, Integer r101) {
        if (r100.equals(0) == false) goto L6;
        return r101;
    L6:
        if (r101.equals(0) == false) goto L9;
        return r100;
    L9:
        if (r100.equals(2) == false) goto L14;
        if (r101.equals(1) == true) goto L14;
        return r101;
    L14:
        if (r101.equals(2) == false) goto L19;
        if (r100.equals(1) == true) goto L19;
        return r100;
    L19:
        if (r100.equals(r101) == true) goto L23;
        return null;
    L23:
        return r100;
    }
}
