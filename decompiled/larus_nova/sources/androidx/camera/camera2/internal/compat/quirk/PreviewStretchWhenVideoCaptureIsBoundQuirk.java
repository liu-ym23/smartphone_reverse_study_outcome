package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import com.huawei.hms.android.SystemUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PreviewStretchWhenVideoCaptureIsBoundQuirk implements CaptureIntentPreviewQuirk {
    public PreviewStretchWhenVideoCaptureIsBoundQuirk() {
    }

    @Override // androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk
    public final /* synthetic */ boolean workaroundByCaptureIntentPreview() {
        return CaptureIntentPreviewQuirk.CC.$default$workaroundByCaptureIntentPreview(this);
    }

    private static boolean isHuaweiP8Lite() {
        if (SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER) == true) goto L5;
    L7:
        return false;
    L5:
        if ("HUAWEI ALE-L04".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isOppoA37F() {
        if ("OPPO".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L5;
    L7:
        return false;
    L5:
        if ("A37F".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungJ1AceNeo() {
        if ("Samsung".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L5;
    L7:
        return false;
    L5:
        if ("sm-j111f".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungJ3() {
        if ("Samsung".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L5;
    L7:
        return false;
    L5:
        if ("sm-j320f".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungJ5() {
        if ("Samsung".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L5;
    L7:
        return false;
    L5:
        if ("sm-j510fn".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungJ7() {
        if ("Samsung".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L5;
    L7:
        return false;
    L5:
        if ("sm-j700f".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        if (isHuaweiP8Lite() == false) goto L5;
    L16:
        return true;
    L5:
        if (isSamsungJ3() == true) goto L16;
        if (isSamsungJ7() == true) goto L16;
        if (isSamsungJ1AceNeo() == true) goto L16;
        if (isOppoA37F() == true) goto L16;
        if (isSamsungJ5() == true) goto L16;
        return false;
    }
}
