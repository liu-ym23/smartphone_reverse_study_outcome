package com.android.contacts.util;

import android.app.Activity;
import android.view.Window;
import com.android.contacts.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StatusBar.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0007\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\b\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0014\u0010\t\u001a\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"COLOR_TRANSPARENT", "", "immersive", "", "Landroid/app/Activity;", "setLightStatusBarIcon", "lightMode", "", "setNavigationBarBtnColor", "statusBarColor", "color", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StatusBarKt {
    private static final int COLOR_TRANSPARENT = 0;

    public static final void statusBarColor(Activity r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.getWindow().addFlags(Integer.MIN_VALUE);
        Window r4 = r2.getWindow();
        if (r4 == null) goto L7;
        r4.setStatusBarColor(r3);
        return;
    }

    public static final void immersive(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.getWindow().getDecorView().setSystemUiVisibility(1280);
        r3.getWindow().addFlags(Integer.MIN_VALUE);
        r3.getWindow().setStatusBarColor(r3.getColor(R.color.obric_page_background));
        r3.getWindow().setNavigationBarColor(r3.getColor(R.color.obric_page_background));
        setLightStatusBarIcon(r3, true);
        setNavigationBarBtnColor(r3, true);
    }

    public static final void setLightStatusBarIcon(Activity r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r0 = r1.getWindow().getDecorView().getSystemUiVisibility();
        if (r2 == false) goto L5;
        int r3 = r0 | 8192;
    L6:
        r1.getWindow().getDecorView().setSystemUiVisibility(r3);
        return;
    L5:
        r3 = r0 & (-8193);
        goto L6
    }

    public static final void setNavigationBarBtnColor(Activity r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r0 = r1.getWindow().getDecorView().getSystemUiVisibility();
        if (r2 == false) goto L5;
        int r3 = r0 | 16;
    L6:
        r1.getWindow().getDecorView().setSystemUiVisibility(r3);
        return;
    L5:
        r3 = r0 & (-17);
        goto L6
    }
}
