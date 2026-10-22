package com.bytedanceos.common.utils;

import android.R;
import android.view.View;
import androidx.activity.ComponentActivity;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityUtilKt {
    public static final void a(ComponentActivity r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        androidx.activity.i.b(r10, null, null, 3, null);
        View r11 = r10.findViewById(R.id.content);
        if (r11 == null) goto L6;
        u8.c.c(r11, ActivityUtilKt$edgeToEdge$1.INSTANCE);
        return;
    }

    public static final void b(View r10, final Function1 r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "callback");
        u8.c.c(r10, new ActivityUtilKt$getSystemBars$1(r11));
    }
}
