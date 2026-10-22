package com.bytedance.android.shopping.feed.utils;

import android.content.res.Resources;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f175449a = 0;

    static {
    }

    public static int a(TextView r100, String r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return 0;
    L6:
        TextPaint r102 = r100.getPaint();
        Layout.Alignment r103 = Layout.Alignment.ALIGN_NORMAL;
        Resources r104 = Resources.getSystem();
        return new StaticLayout(r101, r102, r110, r103, 1.0f, MathKt.roundToInt(TypedValue.applyDimension(1, 1, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()))), true).getHeight();
    }
}
