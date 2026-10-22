package androidx.camera.core.processing;

import androidx.core.util.Preconditions;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class TargetUtils {
    public static int getNumberOfTargets(int r100) {
        int r101 = 0;
    L3:
        if (r100 == 0) goto L5;
        r101 = r101 + (r100 & 1);
        r100 = r100 >> 1;
        goto L3
    L5:
        return r101;
    }

    public static boolean isSuperset(int r100, int r101) {
        if ((r100 & r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    private TargetUtils() {
    }

    public static String getHumanReadableName(int r100) {
        ArrayList r101 = new ArrayList();
        if ((r100 & 4) == 0) goto L6;
        r101.add("IMAGE_CAPTURE");
    L6:
        if ((r100 & 1) == 0) goto L9;
        r101.add("PREVIEW");
    L9:
        if ((r100 & 2) == 0) goto L11;
        r101.add("VIDEO_CAPTURE");
    L11:
        StringBuilder r102 = new StringBuilder();
        Iterator r103 = r101.iterator();
        if (r103.hasNext() == false) goto L17;
    L13:
        r102.append((CharSequence) r103.next());
        if (r103.hasNext() == false) goto L17;
        r102.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
    L17:
        return r102.toString();
    }

    private static String getHumanReadableNames(Collection<Integer> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Integer> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(getHumanReadableName(r102.next().intValue()));
        goto L4
    L6:
        StringBuilder r103 = new StringBuilder("[");
        StringBuilder r104 = new StringBuilder();
        Iterator r105 = r101.iterator();
        if (r105.hasNext() == false) goto L11;
    L8:
        r104.append((CharSequence) r105.next());
        if (r105.hasNext() == false) goto L11;
        r104.append(", ");
    L11:
        r103.append(r104.toString());
        r103.append("]");
        return r103.toString();
    }

    public static void checkSupportedTargets(Collection<Integer> r100, int r101) {
        Preconditions.checkArgument(r100.contains(Integer.valueOf(r101)), String.format(Locale.US, "Effects target %s is not in the supported list %s.", new Object[]{getHumanReadableName(r101), getHumanReadableNames(r100)}));
    }
}
