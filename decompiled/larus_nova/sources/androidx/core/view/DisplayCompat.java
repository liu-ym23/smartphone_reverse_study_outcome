package androidx.core.view;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.core.util.Preconditions;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static boolean isCurrentModeTheLargestMode(Display r100) {
            Display.Mode r101 = r100.getMode();
            Display.Mode[] r102 = r100.getSupportedModes();
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L11;
            Display.Mode r105 = r102[r104];
            if (r101.getPhysicalHeight() < r105.getPhysicalHeight()) goto L10;
            if (r101.getPhysicalWidth() < r105.getPhysicalWidth()) goto L10;
            r104 = r104 + 1;
        L10:
            return false;
        L11:
            return true;
        }

        public static ModeCompat getMode(Context r100, Display r101) {
            Display.Mode r102 = r101.getMode();
            Point r103 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(r100, r101);
            if (r103 == null) goto L9;
            if (physicalSizeEquals(r102, r103) == true) goto L9;
            return new ModeCompat(r102, r103);
        L9:
            return new ModeCompat(r102, true);
        }

        public static ModeCompat[] getSupportedModes(Context r100, Display r101) {
            Display.Mode[] r102 = r101.getSupportedModes();
            ModeCompat[] r103 = new ModeCompat[r102.length];
            Display.Mode r104 = r101.getMode();
            Point r105 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(r100, r101);
            int r106 = 0;
            if (r105 == null) goto L16;
            if (physicalSizeEquals(r104, r105) == true) goto L16;
            int r107 = 0;
        L9:
            if (r107 >= r102.length) goto L18;
            if (physicalSizeEquals(r102[r107], r104) == false) goto L13;
            ModeCompat r108 = new ModeCompat(r102[r107], r105);
        L14:
            r103[r107] = r108;
            r107 = r107 + 1;
            goto L9
        L13:
            r108 = new ModeCompat(r102[r107], false);
        L18:
            return r103;
        L16:
            if (r106 >= r102.length) goto L18;
            boolean r109 = physicalSizeEquals(r102[r106], r104);
            r103[r106] = new ModeCompat(r102[r106], r109);
            r106 = r106 + 1;
            goto L16
        }

        public static boolean physicalSizeEquals(Display.Mode r100, Point r101) {
            if (r100.getPhysicalWidth() != r101.x) goto L7;
            if (r100.getPhysicalHeight() != r101.y) goto L7;
        L10:
            return true;
        L7:
            if (r100.getPhysicalWidth() == r101.y) goto L9;
        L11:
            return false;
        L9:
            if (r100.getPhysicalHeight() != r101.x) goto L11;
            goto L10
        }

        public static boolean physicalSizeEquals(Display.Mode r100, Display.Mode r101) {
            if (r100.getPhysicalWidth() == r101.getPhysicalWidth()) goto L5;
        L7:
            return false;
        L5:
            if (r100.getPhysicalHeight() != r101.getPhysicalHeight()) goto L7;
            return true;
        }
    }

    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalSize;

        public static class Api23Impl {
            private Api23Impl() {
            }

            public static int getPhysicalHeight(Display.Mode r100) {
                return r100.getPhysicalHeight();
            }

            public static int getPhysicalWidth(Display.Mode r100) {
                return r100.getPhysicalWidth();
            }
        }

        public int getPhysicalHeight() {
            return this.mPhysicalSize.y;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalSize.x;
        }

        public boolean isNative() {
            return this.mIsNative;
        }

        public Display.Mode toMode() {
            return this.mMode;
        }

        public ModeCompat(Point r100) {
            Preconditions.checkNotNull(r100, "physicalSize == null");
            this.mPhysicalSize = r100;
            this.mMode = null;
            this.mIsNative = true;
        }

        public ModeCompat(Display.Mode r100, boolean r101) {
            Preconditions.checkNotNull(r100, "mode == null, can't wrap a null reference");
            this.mPhysicalSize = new Point(Api23Impl.getPhysicalWidth(r100), Api23Impl.getPhysicalHeight(r100));
            this.mMode = r100;
            this.mIsNative = r101;
        }

        public ModeCompat(Display.Mode r100, Point r101) {
            Preconditions.checkNotNull(r100, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(r101, "physicalSize == null");
            this.mPhysicalSize = r101;
            this.mMode = r100;
            this.mIsNative = true;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private DisplayCompat() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_core_view_DisplayCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static String getSystemProperty(String r100) {
        Class r101 = INVOKESTATIC_androidx_core_view_DisplayCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L4
        return (String) r101.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{r100});
    L4:
        return null;
    }

    public static boolean isCurrentModeTheLargestMode(Display r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return true;
    L5:
        return Api23Impl.isCurrentModeTheLargestMode(r100);
    }

    private static boolean isSonyBravia4kTv(Context r100) {
        if (isTv(r100) == true) goto L5;
    L11:
        return false;
    L5:
        if ("Sony".equals(Build.MANUFACTURER) == false) goto L11;
        if (Build.MODEL.startsWith("BRAVIA") == false) goto L11;
        if (r100.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd") == false) goto L11;
        return true;
    }

    private static boolean isTv(Context r100) {
        UiModeManager r101 = (UiModeManager) r100.getSystemService("uimode");
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.getCurrentModeType() != 4) goto L7;
        return true;
    }

    private static Point parseDisplaySize(String r100) throws NumberFormatException {
        String[] r101 = r100.trim().split("x", -1);
        if (r101.length != 2) goto L10;
        int r102 = CastIntegerProtector.parseInt(r101[0]);
        int r103 = CastIntegerProtector.parseInt(r101[1]);
        if (r102 <= 0) goto L10;
        if (r103 <= 0) goto L10;
        return new Point(r102, r103);
    L10:
        throw new NumberFormatException();
    }

    public static Point getCurrentDisplaySizeFromWorkarounds(Context r100, Display r101) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        Point r102 = parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", r101);
    L6:
        if (r102 == null) goto L9;
        return r102;
    L9:
        if (isSonyBravia4kTv(r100) == true) goto L11;
        return null;
    L11:
        if (isCurrentModeTheLargestMode(r101) == true) goto L13;
        return null;
    L13:
        return new Point(DISPLAY_SIZE_4K_WIDTH, DISPLAY_SIZE_4K_HEIGHT);
    L5:
        r102 = parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", r101);
        goto L6
    }

    private static Point getDisplaySize(Context r100, Display r101) {
        Point r102 = getCurrentDisplaySizeFromWorkarounds(r100, r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        Point r103 = new Point();
        r101.getRealSize(r103);
        return r103;
    }

    public static ModeCompat getMode(Context r100, Display r101) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getMode(r100, r101);
    L7:
        return new ModeCompat(getDisplaySize(r100, r101));
    }

    public static ModeCompat[] getSupportedModes(Context r100, Display r101) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getSupportedModes(r100, r101);
    L7:
        return new ModeCompat[]{getMode(r100, r101)};
    }

    private static Point parsePhysicalDisplaySizeFromSystemProperties(String r100, Display r101) {
        if (r101.getDisplayId() == 0) goto L5;
        return null;
    L5:
        String r102 = getSystemProperty(r100);
        if (TextUtils.isEmpty(r102) == true) goto L11;
        if (r102 == null) goto L11;
        return parseDisplaySize(r102);
    L11:
        return null;
    }
}
