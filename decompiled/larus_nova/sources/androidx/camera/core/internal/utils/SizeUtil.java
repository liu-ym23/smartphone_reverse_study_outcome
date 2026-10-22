package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import com.ss.android.ttvecamera.TECameraUtils;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class SizeUtil {
    public static final Size RESOLUTION_1080P = null;
    public static final Size RESOLUTION_1440P = null;
    public static final Size RESOLUTION_480P = null;
    public static final Size RESOLUTION_720P = null;
    public static final Size RESOLUTION_QVGA = null;
    public static final Size RESOLUTION_VGA = null;
    public static final Size RESOLUTION_ZERO = null;

    public static int getArea(int r100, int r101) {
        return r100 * r101;
    }

    static {
        RESOLUTION_ZERO = new Size(0, 0);
        RESOLUTION_QVGA = new Size(320, 240);
        RESOLUTION_VGA = new Size(640, 480);
        RESOLUTION_480P = new Size(720, 480);
        RESOLUTION_720P = new Size(1280, 720);
        RESOLUTION_1080P = new Size(TECameraUtils.CAPTURE_NORMAL, 1080);
        RESOLUTION_1440P = new Size(TECameraUtils.CAPTURE_NORMAL, 1440);
    }

    private SizeUtil() {
    }

    public static int getArea(Size r100) {
        return getArea(r100.getWidth(), r100.getHeight());
    }

    public static Size getMaxSize(List<Size> r100) {
        if (r100.isEmpty() == false) goto L7;
        return null;
    L7:
        return (Size) Collections.max(r100, new CompareSizesByArea());
    }

    public static <T> T findNearestHigherFor(Size r100, TreeMap<Size, T> r101) {
        Map.Entry<Size, T> r102 = r101.ceilingEntry(r100);
        if (r102 != null) goto L5;
        Map.Entry<Size, T> r103 = r101.floorEntry(r100);
        if (r103 != null) goto L9;
        return null;
    L9:
        return r103.getValue();
    L5:
        return r102.getValue();
    }

    public static boolean isLongerInAnyEdge(Size r100, Size r101) {
        if (r100.getWidth() <= r101.getWidth()) goto L5;
    L8:
        return true;
    L5:
        if (r100.getHeight() > r101.getHeight()) goto L8;
        return false;
    }

    public static boolean isSmallerByArea(Size r100, Size r101) {
        if (getArea(r100) >= getArea(r101)) goto L5;
        return true;
    L5:
        return false;
    }
}
