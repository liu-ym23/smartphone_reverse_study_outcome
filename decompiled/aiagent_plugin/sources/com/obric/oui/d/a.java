package com.obric.oui.d;

import android.app.Activity;
import android.content.res.Resources;
import android.view.Window;
import android.view.WindowInsetsController;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActivityUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "ActivityUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35004a = null;

    static {
        f35004a = new a();
    }

    private a() {
    }

    public static final void a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        Window r5 = ZeusTransformUtils.getWindow(r4, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        WindowInsetsController r6 = null;
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        if (a() == false) goto L10;
    L13:
        r6.setSystemBarsAppearance(0, 8);
        r6.setSystemBarsAppearance(0, 16);
        return;
    L10:
        if (b() == true) goto L13;
        r6.setSystemBarsAppearance(8, 8);
        r6.setSystemBarsAppearance(16, 16);
        return;
    L5:
        r6 = r5.getInsetsController();
        goto L6
    }

    public static final boolean a() {
        int r0 = Resources.getSystem().getConfiguration().uiMode & 48;
        if (r0 != 32) goto L5;
        boolean r1 = true;
    L6:
        com.obric.oui.d.a.b.b(TAG, "isSystemInDarkTheme: " + r1 + ", currentNightMode" + r0);
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    public static final boolean b() {
        if (androidx.appcompat.app.c.getDefaultNightMode() != 2) goto L5;
        boolean r0 = true;
    L6:
        com.obric.oui.d.a.b.b(TAG, o.a("isAppInDarkTheme: ", Boolean.valueOf(r0)));
        return r0;
    L5:
        r0 = false;
        goto L6
    }
}
