package com.bytedance.android.livesdk.gamesticker.hok;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f125606a = 0;

    static {
    }

    public static void a(Paint r100, int r101) {
        if (r101 >= 0) goto L4;
        return;
    L4:
        if (r101 <= 1000) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 28) goto L18;
        if (r100 == null) goto L19;
        Typeface r102 = r100.getTypeface();
        Typeface r103 = r100.getTypeface();
        if (r103 != null) goto L12;
    L14:
        boolean r104 = false;
    L15:
        r100.setTypeface(Typeface.create(r102, r101, r104));
        return;
    L12:
        if (r103.getStyle() != 2) goto L14;
        r104 = true;
        goto L15
    L19:
        return;
    }
}
