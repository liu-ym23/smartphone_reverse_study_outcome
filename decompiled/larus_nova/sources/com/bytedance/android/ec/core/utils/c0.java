package com.bytedance.android.ec.core.utils;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45558a = 0;

    static {
    }

    public static Typeface a(Paint r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "textPaint");
        boolean r102 = true;
        if (Build.VERSION.SDK_INT < 28) goto L12;
        Typeface r103 = r100.getTypeface();
        int r104 = RangesKt.coerceIn(r101, 1, 1000);
        Typeface r105 = r100.getTypeface();
        if (r105 != null) goto L7;
    L9:
        r102 = false;
    L27:
        return Typeface.create(r103, r104, r102);
    L7:
        if (r105.getStyle() != 2) goto L9;
    L12:
        if (r101 < 500) goto L18;
        Typeface r106 = r100.getTypeface();
        if (r106 == null) goto L18;
        if (r106.getStyle() != 2) goto L18;
        return Typeface.create(r100.getTypeface(), 3);
    L18:
        if (r101 >= 500) goto L29;
        Typeface r107 = r100.getTypeface();
        if (r107 == null) goto L26;
        if (r107.getStyle() != 2) goto L26;
        return Typeface.create(r100.getTypeface(), 2);
    L26:
        return Typeface.DEFAULT;
    L29:
        return Typeface.create(r100.getTypeface(), 1);
    }

    public static void b(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setWeight");
        r100.setTypeface(a(r100.getPaint(), r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
