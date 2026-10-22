package androidx.camera.video.internal.compat.quirk;

import android.graphics.Rect;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SizeCannotEncodeVideoQuirk implements Quirk {
    public SizeCannotEncodeVideoQuirk() {
    }

    private static boolean isMotoC() {
        if ("motorola".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("moto c".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static Set<Size> getProblematicSizes() {
        if (isMotoC() == false) goto L7;
        return new HashSet(Collections.singletonList(new Size(720, 1280)));
    L7:
        return Collections.emptySet();
    }

    public static boolean load() {
        return isMotoC();
    }

    public boolean isProblematicEncodeSize(Size r100) {
        return getProblematicSizes().contains(r100);
    }

    public Rect adjustCropRectForProblematicEncodeSize(Rect r100, int r101, VideoEncoderInfo r102) {
        Size r103 = TransformUtils.rotateSize(TransformUtils.rectToSize(r100), r101);
        if (isProblematicEncodeSize(r103) == true) goto L5;
        return r100;
    L5:
        if (r102 == null) goto L7;
        int r104 = r102.getHeightAlignment() / 2;
    L8:
        Rect r105 = new Rect(r100);
        if (r100.width() != r103.getHeight()) goto L11;
        r105.left += r104;
        r105.right -= r104;
    L12:
        return r105;
    L11:
        r105.top += r104;
        r105.bottom -= r104;
        goto L12
    L7:
        r104 = 8;
        goto L8
    }
}
