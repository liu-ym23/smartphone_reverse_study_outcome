package com.obric.oui.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.appcompat.app.AppCompatDelegate;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007J\f\u0010\r\u001a\u00020\u0006*\u00020\bH\u0007J\f\u0010\u000e\u001a\u00020\u0006*\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/utils/ActivityUtils;", "", "()V", "TAG", "", "hideNavBar", "", "activity", "Landroid/app/Activity;", "hideNavBar$OUI_standardRelease", "isAppInDarkTheme", "", "isSystemInDarkTheme", "adaptLightDarkStatusBar", "adaptLightDarkSystemBars", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActivityUtils {
    public static final ActivityUtils INSTANCE = null;
    private static final String TAG = "ActivityUtils";

    static {
        INSTANCE = new ActivityUtils();
    }

    private ActivityUtils() {
    }

    @JvmStatic
    public static final void adaptLightDarkStatusBar(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Window r3 = r2.getWindow();
        if (r3 != null) goto L5;
        WindowInsetsController r4 = null;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        if (isSystemInDarkTheme() == false) goto L10;
    L13:
        r4.setSystemBarsAppearance(0, 8);
        return;
    L10:
        if (isAppInDarkTheme() == true) goto L13;
        r4.setSystemBarsAppearance(8, 8);
        return;
    L5:
        r4 = r3.getInsetsController();
        goto L6
    }

    @JvmStatic
    public static final void adaptLightDarkSystemBars(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Window r4 = r3.getWindow();
        if (r4 != null) goto L5;
        WindowInsetsController r5 = null;
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        if (isSystemInDarkTheme() == false) goto L10;
    L13:
        r5.setSystemBarsAppearance(0, 8);
        r5.setSystemBarsAppearance(0, 16);
        return;
    L10:
        if (isAppInDarkTheme() == true) goto L13;
        r5.setSystemBarsAppearance(8, 8);
        r5.setSystemBarsAppearance(16, 16);
        return;
    L5:
        r5 = r4.getInsetsController();
        goto L6
    }

    @JvmStatic
    public static final boolean isSystemInDarkTheme() {
        int r0 = Resources.getSystem().getConfiguration().uiMode & 48;
        if (r0 != 32) goto L5;
        boolean r1 = true;
    L6:
        L.d(TAG, "isSystemInDarkTheme: " + r1 + ", currentNightMode" + r0);
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean isAppInDarkTheme() {
        if (AppCompatDelegate.getDefaultNightMode() != 2) goto L5;
        boolean r0 = true;
    L6:
        L.d(TAG, Intrinsics.stringPlus("isAppInDarkTheme: ", Boolean.valueOf(r0)));
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    public final void hideNavBar$OUI_standardRelease(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        int r1 = r2.getWindow().getDecorView().getSystemUiVisibility();     // Catch: Exception -> L5
        r2.getWindow().getDecorView().setSystemUiVisibility(r1 | 512);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        L.e(TAG, "hideNavBar error", e);
    }
}
