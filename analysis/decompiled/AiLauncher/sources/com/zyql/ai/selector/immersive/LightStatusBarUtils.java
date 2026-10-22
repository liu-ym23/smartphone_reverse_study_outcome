package com.zyql.ai.selector.immersive;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.stepos.agentframework.chatui.longtext.b;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class LightStatusBarUtils {
    private static void initStatusBarStyle(Activity activity, boolean z10, boolean z11) {
        if (z10 && z11) {
            activity.getWindow().getDecorView().setSystemUiVisibility(256);
            return;
        }
        if (!z10 && !z11) {
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else {
            if (z10 || !z11) {
                return;
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        }
    }

    @TargetApi(11)
    private static void setAndroidNativeLightStatusBar(Activity activity, boolean z10, boolean z11, boolean z12, boolean z13) {
        try {
            if (!z12) {
                View decorView = activity.getWindow().getDecorView();
                if (z13) {
                    decorView.setSystemUiVisibility(b.THRESHOLD);
                    return;
                } else {
                    decorView.setSystemUiVisibility(0);
                    return;
                }
            }
            Window window = activity.getWindow();
            if (z10 && z11) {
                if (z13) {
                    window.getDecorView().setSystemUiVisibility(8448);
                    return;
                } else {
                    window.getDecorView().setSystemUiVisibility(256);
                    return;
                }
            }
            if (!z10 && !z11) {
                if (z13) {
                    window.getDecorView().setSystemUiVisibility(9472);
                    return;
                } else {
                    window.getDecorView().setSystemUiVisibility(1280);
                    return;
                }
            }
            if (z10 || !z11) {
                return;
            }
            if (z13) {
                window.getDecorView().setSystemUiVisibility(9472);
            } else {
                window.getDecorView().setSystemUiVisibility(1280);
            }
        } catch (Exception unused) {
        }
    }

    private static boolean setFlymeLightStatusBar(Activity activity, boolean z10, boolean z11, boolean z12, boolean z13) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        boolean z14 = false;
        if (activity != null) {
            initStatusBarStyle(activity, z10, z11);
            try {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i10 = declaredField.getInt(null);
                int i11 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z13 ? i10 | i11 : (~i10) & i11);
                activity.getWindow().setAttributes(attributes);
            } catch (Exception unused) {
            }
            try {
                if (RomUtils.getFlymeVersion() < 7) {
                    return true;
                }
                setAndroidNativeLightStatusBar(activity, z10, z11, z12, z13);
                return true;
            } catch (Exception unused2) {
                z14 = true;
                setAndroidNativeLightStatusBar(activity, z10, z11, z12, z13);
                return z14;
            }
        }
        return z14;
    }

    public static void setLightStatusBar(Activity activity, boolean z10) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        setLightStatusBar(activity, false, false, false, z10);
    }

    public static void setLightStatusBarAboveAPI23(Activity activity, boolean z10, boolean z11, boolean z12, boolean z13) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        setLightStatusBar(activity, z10, z11, z12, z13);
    }

    private static boolean setMIUILightStatusBar(Activity activity, boolean z10, boolean z11, boolean z12, boolean z13) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        initStatusBarStyle(activity, z10, z11);
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i10 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class cls3 = Integer.TYPE;
            cls.getMethod("setExtraFlags", cls3, cls3).invoke(activity.getWindow(), Integer.valueOf(z13 ? i10 : 0), Integer.valueOf(i10));
            return true;
        } catch (Exception unused) {
            setAndroidNativeLightStatusBar(activity, z10, z11, z12, z13);
            return false;
        }
    }

    public static void setLightStatusBar(Activity activity, boolean z10, boolean z11, boolean z12, boolean z13) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int lightStatausBarAvailableRomType = RomUtils.getLightStatausBarAvailableRomType();
        if (lightStatausBarAvailableRomType == 1) {
            if (RomUtils.getMIUIVersionCode() >= 7) {
                setAndroidNativeLightStatusBar(activity, z10, z11, z12, z13);
                return;
            } else {
                setMIUILightStatusBar(activity, z10, z11, z12, z13);
                return;
            }
        }
        if (lightStatausBarAvailableRomType == 2) {
            setFlymeLightStatusBar(activity, z10, z11, z12, z13);
        } else {
            if (lightStatausBarAvailableRomType != 3) {
                return;
            }
            setAndroidNativeLightStatusBar(activity, z10, z11, z12, z13);
        }
    }
}
