package com.bytedance.android.shopping.deepfeed.utlis;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.Locale;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f173989a = 0;

    static {
    }

    public static int a(Context r100) {
        String r101 = Build.BRAND;
        if (r101 == null) goto L5;
        String r102 = r101.toLowerCase(Locale.ROOT);
    L7:
        if (Intrinsics.areEqual(r102, RomUtils.BRAND_HUAWEI) == false) goto L12;
        if (r100 == null) goto L12;
        return k1.h(r100);
    L12:
        if (k1.s(k1.t(r100)) == false) goto L19;
        boolean r103 = true;
        if (Settings.Secure.getInt(r100.getContentResolver(), "navigation_gesture_on", 0) == 0) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == true) goto L19;
    L20:
        if (r103 == true) goto L22;
        return 0;
    L22:
        if (r100 == null) goto L35;
        Resources r105 = th.a.f(r100);
        int r106 = r105.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r106 <= 0) goto L36;
        return r105.getDimensionPixelSize(r106);
    L27:
        e = move-exception;
        String r107 = e.getMessage();
        if (r107 != null) goto L31;
        r107 = "";
    L31:
        ECExceptionMonitor.c(r107);
        return 0;
    L36:
        return 0;
    L35:
        return 0;
    L16:
        r104 = false;
    L19:
        r103 = false;
        goto L20
    L5:
        r102 = null;
        goto L7
    }

    public static Pair b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = r101[0];
        int r103 = r101[1];
        return new Pair(Integer.valueOf(r102), Integer.valueOf(r103));
    }
}
