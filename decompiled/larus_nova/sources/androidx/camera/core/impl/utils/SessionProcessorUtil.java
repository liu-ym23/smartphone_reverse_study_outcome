package androidx.camera.core.impl.utils;

import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.impl.SessionProcessor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class SessionProcessorUtil {
    private SessionProcessorUtil() {
    }

    public static FocusMeteringAction getModifiedFocusMeteringAction(SessionProcessor r100, FocusMeteringAction r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        FocusMeteringAction.Builder r102 = new FocusMeteringAction.Builder(r101);
        boolean r103 = true;
        if (r101.getMeteringPointsAf().isEmpty() == false) goto L7;
    L9:
        boolean r104 = false;
    L11:
        if (r101.getMeteringPointsAe().isEmpty() == true) goto L16;
        if (isOperationSupported(r100, new int[]{3}) == true) goto L16;
        r102.removePoints(2);
        r104 = true;
    L16:
        if (r101.getMeteringPointsAwb().isEmpty() == false) goto L18;
    L20:
        r103 = r104;
    L21:
        if (r103 == true) goto L23;
        return r101;
    L23:
        FocusMeteringAction r105 = r102.build();
        if (r105.getMeteringPointsAf().isEmpty() == false) goto L32;
        if (r105.getMeteringPointsAe().isEmpty() == false) goto L32;
        if (r105.getMeteringPointsAwb().isEmpty() == false) goto L32;
        return null;
    L32:
        return r102.build();
    L18:
        if (isOperationSupported(r100, new int[]{4}) == true) goto L20;
        r102.removePoints(4);
        goto L21
    L7:
        if (isOperationSupported(r100, new int[]{1, 2}) == true) goto L9;
        r102.removePoints(1);
        r104 = true;
        goto L11
    }

    public static boolean isOperationSupported(SessionProcessor r100, int... r101) {
        if (r100 != null) goto L5;
        return true;
    L5:
        ArrayList r102 = new ArrayList(r101.length);
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L9;
        r102.add(Integer.valueOf(r101[r104]));
        r104 = r104 + 1;
        goto L6
    L9:
        return r100.getSupportedCameraOperations().containsAll(r102);
    }
}
