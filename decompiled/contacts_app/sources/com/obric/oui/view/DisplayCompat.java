package com.obric.oui.view;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.core.util.Preconditions;
import com.obric.oui.material.MaterialConfigFormatNames;

/* JADX INFO: loaded from: classes4.dex */
public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    static class Api17Impl {
        private Api17Impl() {
        }

        static void getRealSize(Display r0, Point r1) {
            r0.getRealSize(r1);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static ModeCompat getMode(Context r1, Display r2) {
            Display.Mode r0 = r2.getMode();
            Point r3 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(r1, r2);
            if (r3 == null) goto L9;
            if (physicalSizeEquals(r0, r3) == true) goto L9;
            return new ModeCompat(r0, r3);
        L9:
            return new ModeCompat(r0, true);
        }

        public static ModeCompat[] getSupportedModes(Context r6, Display r7) {
            Display.Mode[] r0 = r7.getSupportedModes();
            ModeCompat[] r1 = new ModeCompat[r0.length];
            Display.Mode r2 = r7.getMode();
            Point r8 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(r6, r7);
            int r9 = 0;
            if (r8 == null) goto L16;
            if (physicalSizeEquals(r2, r8) == true) goto L16;
            int r3 = 0;
        L9:
            if (r3 >= r0.length) goto L18;
            if (physicalSizeEquals(r0[r3], r2) == false) goto L13;
            ModeCompat r4 = new ModeCompat(r0[r3], r8);
        L14:
            r1[r3] = r4;
            r3 = r3 + 1;
            goto L9
        L13:
            r4 = new ModeCompat(r0[r3], false);
        L18:
            return r1;
        L16:
            if (r9 >= r0.length) goto L18;
            r1[r9] = new ModeCompat(r0[r9], physicalSizeEquals(r0[r9], r2));
            r9 = r9 + 1;
            goto L16
        }

        static boolean isCurrentModeTheLargestMode(Display r5) {
            Display.Mode r0 = r5.getMode();
            Display.Mode[] r6 = r5.getSupportedModes();
            int r2 = 0;
        L4:
            if (r2 >= r6.length) goto L12;
            if (r0.getPhysicalHeight() < r6[r2].getPhysicalHeight()) goto L11;
            if (r0.getPhysicalWidth() < r6[r2].getPhysicalWidth()) goto L11;
            r2 = r2 + 1;
        L11:
            return false;
        L12:
            return true;
        }

        static boolean physicalSizeEquals(Display.Mode r2, Point r3) {
            if (r2.getPhysicalWidth() != r3.x) goto L7;
            if (r2.getPhysicalHeight() != r3.y) goto L7;
        L10:
            return true;
        L7:
            if (r2.getPhysicalWidth() == r3.y) goto L9;
        L11:
            return false;
        L9:
            if (r2.getPhysicalHeight() != r3.x) goto L11;
            goto L10
        }

        static boolean physicalSizeEquals(Display.Mode r2, Display.Mode r3) {
            if (r2.getPhysicalWidth() == r3.getPhysicalWidth()) goto L5;
        L7:
            return false;
        L5:
            if (r2.getPhysicalHeight() != r3.getPhysicalHeight()) goto L7;
            return true;
        }
    }

    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalSize;

        ModeCompat(Point r2) {
            Preconditions.checkNotNull(r2, "physicalSize == null");
            this.mPhysicalSize = r2;
            this.mMode = null;
            this.mIsNative = true;
        }

        ModeCompat(Display.Mode r4, boolean r5) {
            Preconditions.checkNotNull(r4, "mode == null, can't wrap a null reference");
            this.mPhysicalSize = new Point(r4.getPhysicalWidth(), r4.getPhysicalHeight());
            this.mMode = r4;
            this.mIsNative = r5;
        }

        ModeCompat(Display.Mode r2, Point r3) {
            Preconditions.checkNotNull(r2, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(r3, "physicalSize == null");
            this.mPhysicalSize = r3;
            this.mMode = r2;
            this.mIsNative = true;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalSize.x;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalSize.y;
        }

        public boolean isNative() {
            return this.mIsNative;
        }

        public Display.Mode toMode() {
            return this.mMode;
        }
    }

    private DisplayCompat() {
    }

    static ModeCompat getMode(Context r0, Display r1) {
        return Api23Impl.getMode(r0, r1);
    }

    private static Point getDisplaySize(Context r0, Display r1) {
        Point r2 = getCurrentDisplaySizeFromWorkarounds(r0, r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        Point r3 = new Point();
        Api17Impl.getRealSize(r1, r3);
        return r3;
    }

    public static ModeCompat[] getSupportedModes(Context r0, Display r1) {
        return Api23Impl.getSupportedModes(r0, r1);
    }

    private static Point parseDisplaySize(String r2) throws NumberFormatException {
        String[] r3 = r2.trim().split(MaterialConfigFormatNames.X, -1);
        if (r3.length != 2) goto L10;
        int r0 = Integer.parseInt(r3[0]);
        int r4 = Integer.parseInt(r3[1]);
        if (r0 <= 0) goto L10;
        if (r4 <= 0) goto L10;
        return new Point(r0, r4);
    L10:
        throw new NumberFormatException();
    }

    private static String getSystemProperty(String r6) {
        Class<?> r0 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L4
        return (String) r0.getMethod("get", new Class[]{String.class}).invoke(r0, new Object[]{r6});
    L4:
        return null;
    }

    private static boolean isTv(Context r1) {
        UiModeManager r2 = (UiModeManager) r1.getSystemService("uimode");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getCurrentModeType() != 4) goto L7;
        return true;
    }

    private static Point parsePhysicalDisplaySizeFromSystemProperties(String r1, Display r2) {
        if (r2.getDisplayId() == 0) goto L5;
        return null;
    L5:
        String r3 = getSystemProperty(r1);
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return null;
    L11:
        return parseDisplaySize(r3);
    L10:
        return null;
    }

    static Point getCurrentDisplaySizeFromWorkarounds(Context r1, Display r2) {
        Point r0 = parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (isSonyBravia4kTv(r1) == true) goto L8;
        return null;
    L8:
        if (isCurrentModeTheLargestMode(r2) == true) goto L10;
        return null;
    L10:
        return new Point(DISPLAY_SIZE_4K_WIDTH, DISPLAY_SIZE_4K_HEIGHT);
    }

    private static boolean isSonyBravia4kTv(Context r2) {
        if (isTv(r2) == true) goto L5;
    L11:
        return false;
    L5:
        if ("Sony".equals(Build.MANUFACTURER) == false) goto L11;
        if (Build.MODEL.startsWith("BRAVIA") == false) goto L11;
        if (r2.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd") == false) goto L11;
        return true;
    }

    static boolean isCurrentModeTheLargestMode(Display r0) {
        return Api23Impl.isCurrentModeTheLargestMode(r0);
    }
}
