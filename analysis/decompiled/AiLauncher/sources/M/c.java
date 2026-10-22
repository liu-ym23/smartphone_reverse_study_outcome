package M;

import D.C0761b0;
import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public final class c {
    public static int a(int i10, int i11, boolean z10) {
        int i12 = z10 ? ((i11 - i10) + 360) % 360 : (i11 + i10) % 360;
        if (C0761b0.j("CameraOrientationUtil")) {
            C0761b0.a("CameraOrientationUtil", String.format("getRelativeImageRotation: destRotationDegrees=%s, sourceRotationDegrees=%s, isOppositeFacing=%s, result=%s", Integer.valueOf(i10), Integer.valueOf(i11), Boolean.valueOf(z10), Integer.valueOf(i12)));
        }
        return i12;
    }

    public static int b(int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (i10 == 1) {
            return 90;
        }
        if (i10 == 2) {
            return 180;
        }
        if (i10 == 3) {
            return SubsamplingScaleImageView.ORIENTATION_270;
        }
        throw new IllegalArgumentException("Unsupported surface rotation: " + i10);
    }
}
