package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import com.huawei.hms.android.SystemUtils;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.ttvecamera.TECameraUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExcludedSupportedSizesQuirk implements Quirk {
    private static final String TAG = "ExcludedSupportedSizesQuirk";
    private static final int UNKNOWN_IMAGE_FORMAT = -1;

    public ExcludedSupportedSizesQuirk() {
    }

    private static boolean isHuaweiP20Lite() {
        if (SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("HWANE".equalsIgnoreCase(Build.DEVICE) == false) goto L7;
        return true;
    }

    private static boolean isOnePlus6() {
        if ("OnePlus".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("OnePlus6".equalsIgnoreCase(Build.DEVICE) == false) goto L7;
        return true;
    }

    private static boolean isOnePlus6T() {
        if ("OnePlus".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("OnePlus6T".equalsIgnoreCase(Build.DEVICE) == false) goto L7;
        return true;
    }

    private static boolean isRedmiNote9Pro() {
        if ("REDMI".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("joyeuse".equalsIgnoreCase(Build.DEVICE) == false) goto L7;
        return true;
    }

    private static boolean isSamsungJ7Api27Above() {
        if ("SAMSUNG".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L9:
        return false;
    L5:
        if ("J7XELTE".equalsIgnoreCase(Build.DEVICE) == false) goto L9;
        if (Build.VERSION.SDK_INT < 27) goto L9;
        return true;
    }

    private static boolean isSamsungJ7PrimeApi27Above() {
        if ("SAMSUNG".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L9:
        return false;
    L5:
        if ("ON7XELTE".equalsIgnoreCase(Build.DEVICE) == false) goto L9;
        if (Build.VERSION.SDK_INT < 27) goto L9;
        return true;
    }

    public static boolean load() {
        if (isOnePlus6() == false) goto L5;
    L16:
        return true;
    L5:
        if (isOnePlus6T() == true) goto L16;
        if (isHuaweiP20Lite() == true) goto L16;
        if (isSamsungJ7PrimeApi27Above() == true) goto L16;
        if (isSamsungJ7Api27Above() == true) goto L16;
        if (isRedmiNote9Pro() == true) goto L16;
        return false;
    }

    private List<Size> getOnePlus6ExcludedSizes(String r100, int r101) {
        ArrayList r102 = new ArrayList();
        if (r100.equals("0") == true) goto L5;
    L7:
        return r102;
    L5:
        if (r101 != 256) goto L7;
        r102.add(new Size(4160, 3120));
        r102.add(new Size(4000, 3000));
        goto L7
    }

    private List<Size> getOnePlus6TExcludedSizes(String r100, int r101) {
        ArrayList r102 = new ArrayList();
        if (r100.equals("0") == true) goto L5;
    L7:
        return r102;
    L5:
        if (r101 != 256) goto L7;
        r102.add(new Size(4160, 3120));
        r102.add(new Size(4000, 3000));
        goto L7
    }

    private List<Size> getRedmiNote9ProExcludedSizes(String r100, int r101) {
        ArrayList r102 = new ArrayList();
        if (r100.equals("0") == true) goto L5;
    L7:
        return r102;
    L5:
        if (r101 != 256) goto L7;
        r102.add(new Size(9280, 6944));
        goto L7
    }

    public List<Size> getExcludedSizes(String r100, int r101) {
        if (isOnePlus6() == false) goto L7;
        return getOnePlus6ExcludedSizes(r100, r101);
    L7:
        if (isOnePlus6T() == false) goto L11;
        return getOnePlus6TExcludedSizes(r100, r101);
    L11:
        if (isHuaweiP20Lite() == false) goto L15;
        return getHuaweiP20LiteExcludedSizes(r100, r101, null);
    L15:
        if (isSamsungJ7PrimeApi27Above() == false) goto L19;
        return getSamsungJ7PrimeApi27AboveExcludedSizes(r100, r101, null);
    L19:
        if (isSamsungJ7Api27Above() == false) goto L23;
        return getSamsungJ7Api27AboveExcludedSizes(r100, r101, null);
    L23:
        if (isRedmiNote9Pro() == true) goto L25;
        Logger.w(TAG, "Cannot retrieve list of supported sizes to exclude on this device.");
        return Collections.emptyList();
    L25:
        return getRedmiNote9ProExcludedSizes(r100, r101);
    }

    public List<Size> getExcludedSizes(String r100, Class<?> r101) {
        if (isHuaweiP20Lite() == false) goto L7;
        return getHuaweiP20LiteExcludedSizes(r100, -1, r101);
    L7:
        if (isSamsungJ7PrimeApi27Above() == false) goto L11;
        return getSamsungJ7PrimeApi27AboveExcludedSizes(r100, -1, r101);
    L11:
        if (isSamsungJ7Api27Above() == true) goto L13;
        Logger.w(TAG, "Cannot retrieve list of supported sizes to exclude on this device.");
        return Collections.emptyList();
    L13:
        return getSamsungJ7Api27AboveExcludedSizes(r100, -1, r101);
    }

    private List<Size> getHuaweiP20LiteExcludedSizes(String r100, int r101, Class<?> r102) {
        ArrayList r103 = new ArrayList();
        if (r100.equals("0") == true) goto L5;
    L10:
        return r103;
    L5:
        if (r101 != 34) goto L7;
    L9:
        r103.add(new Size(720, 720));
        r103.add(new Size(400, 400));
        goto L10
    L7:
        if (r101 == 35) goto L9;
        if (r102 == null) goto L10;
        goto L9
    }

    private List<Size> getSamsungJ7Api27AboveExcludedSizes(String r110, int r111, Class<?> r112) {
        ArrayList r100 = new ArrayList();
        if (r110.equals("0") == false) goto L11;
        if (r111 == 34) goto L9;
        if (r112 != null) goto L9;
        if (r111 != 35) goto L16;
        r100.add(new Size(2048, ISmModel.VERSION_0600));
        r100.add(new Size(2048, 1152));
        r100.add(new Size(TECameraUtils.CAPTURE_NORMAL, 1080));
    L16:
        return r100;
    L9:
        r100.add(new Size(4128, 3096));
        r100.add(new Size(4128, 2322));
        r100.add(new Size(3088, 3088));
        r100.add(new Size(TECameraUtils.CAPTURE_HQ_3X, 2448));
        r100.add(new Size(TECameraUtils.CAPTURE_HQ_3X, 1836));
        r100.add(new Size(2048, ISmModel.VERSION_0600));
        r100.add(new Size(2048, 1152));
        r100.add(new Size(TECameraUtils.CAPTURE_NORMAL, 1080));
        goto L16
    L11:
        if (r110.equals("1") == false) goto L16;
        if (r111 == 34) goto L15;
        if (r111 == 35) goto L15;
        if (r112 == null) goto L16;
    L15:
        r100.add(new Size(2576, 1932));
        r100.add(new Size(TECameraUtils.CAPTURE_HQ_2X, 1440));
        r100.add(new Size(TECameraUtils.CAPTURE_NORMAL, TECameraUtils.CAPTURE_NORMAL));
        r100.add(new Size(2048, ISmModel.VERSION_0600));
        r100.add(new Size(2048, 1152));
        r100.add(new Size(TECameraUtils.CAPTURE_NORMAL, 1080));
        goto L16
    }

    private List<Size> getSamsungJ7PrimeApi27AboveExcludedSizes(String r110, int r111, Class<?> r112) {
        ArrayList r100 = new ArrayList();
        if (r110.equals("0") == false) goto L12;
        if (r111 == 34) goto L10;
        if (r112 != null) goto L10;
        if (r111 != 35) goto L17;
        r100.add(new Size(4128, 2322));
        r100.add(new Size(3088, 3088));
        r100.add(new Size(TECameraUtils.CAPTURE_HQ_3X, 2448));
        r100.add(new Size(TECameraUtils.CAPTURE_HQ_3X, 1836));
        r100.add(new Size(2048, ISmModel.VERSION_0600));
        r100.add(new Size(2048, 1152));
        r100.add(new Size(TECameraUtils.CAPTURE_NORMAL, 1080));
    L17:
        return r100;
    L10:
        r100.add(new Size(4128, 3096));
        r100.add(new Size(4128, 2322));
        r100.add(new Size(3088, 3088));
        r100.add(new Size(TECameraUtils.CAPTURE_HQ_3X, 2448));
        r100.add(new Size(TECameraUtils.CAPTURE_HQ_3X, 1836));
        r100.add(new Size(2048, ISmModel.VERSION_0600));
        r100.add(new Size(2048, 1152));
        r100.add(new Size(TECameraUtils.CAPTURE_NORMAL, 1080));
        goto L17
    L12:
        if (r110.equals("1") == false) goto L17;
        if (r111 == 34) goto L16;
        if (r111 == 35) goto L16;
        if (r112 == null) goto L17;
    L16:
        r100.add(new Size(TECameraUtils.CAPTURE_HQ_3X, 2448));
        r100.add(new Size(TECameraUtils.CAPTURE_HQ_3X, 1836));
        r100.add(new Size(2448, 2448));
        r100.add(new Size(TECameraUtils.CAPTURE_NORMAL, TECameraUtils.CAPTURE_NORMAL));
        r100.add(new Size(2048, ISmModel.VERSION_0600));
        r100.add(new Size(2048, 1152));
        r100.add(new Size(TECameraUtils.CAPTURE_NORMAL, 1080));
        goto L17
    }
}
