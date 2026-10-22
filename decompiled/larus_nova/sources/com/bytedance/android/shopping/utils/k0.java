package com.bytedance.android.shopping.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import androidx.camera.core.processing.util.GLUtils;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187151a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f187152a;

        public a(View r100) {
            this.f187152a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = k0.f187151a;     // Catch: Throwable -> L4
            k0.c(this.f187152a, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static String a(long r100) {
        if (r100 < 100000000) goto L7;
        DecimalFormat r101 = new DecimalFormat(GLUtils.VERSION_UNKNOWN);
        r101.setRoundingMode(RoundingMode.HALF_UP);
        return com.bytedance.android.shopping.extensions.j.d(R.string.commerce_count_hundred_million, r101.format(Float.valueOf(r100 / 100000000)));
    L7:
        if (r100 < 10000) goto L11;
        DecimalFormat r102 = new DecimalFormat(GLUtils.VERSION_UNKNOWN);
        r102.setRoundingMode(RoundingMode.HALF_UP);
        return com.bytedance.android.shopping.extensions.j.d(R.string.commerce_count_ten_thousand, r102.format(Float.valueOf(r100 / 10000)));
    L11:
        return String.valueOf(r100);
    }

    public static String b(long r100) {
        long r101 = 10000;
        float r102 = r100;
        if (r100 < r101) goto L6;
        r102 = r102 + 0.5f;
    L6:
        if (r100 < 100000000) goto L9;
        DecimalFormat r103 = new DecimalFormat(GLUtils.VERSION_UNKNOWN);
        r103.setRoundingMode(RoundingMode.FLOOR);
        return com.bytedance.android.shopping.extensions.j.d(R.string.commerce_count_hundred_million_plus, r103.format(Float.valueOf(r102 / 100000000)));
    L9:
        if (r100 < r101) goto L13;
        DecimalFormat r104 = new DecimalFormat(GLUtils.VERSION_UNKNOWN);
        r104.setRoundingMode(RoundingMode.FLOOR);
        return com.bytedance.android.shopping.extensions.j.d(R.string.commerce_count_ten_thousand_plus, r104.format(Float.valueOf(r102 / 10000)));
    L13:
        return String.valueOf(r100);
    }

    public static void c(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Drawable r102 = r100.getBackground();
        if ((r102 instanceof GradientDrawable) == true) goto L5;
        r102 = null;
    L5:
        GradientDrawable r103 = (GradientDrawable) r102;
        if (r103 != null) goto L8;
        return;
    L8:
        float r104 = RangesKt.coerceAtMost(r100.getWidth(), r100.getHeight()) / 2.0f;
        if (r104 > 0) goto L13;
        if (r101 == false) goto L15;
        r100.post(new a(r100));
        return;
    L15:
        return;
    L13:
        r103.setCornerRadius(r104);
    }

    public static void d(TextView r100, String r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        if (r101 != null) goto L5;
        return;
    L5:
        TextPaint r103 = r100.getPaint();
        int r104 = g1.f45599a;
        if (r100.getPaint().measureText(r101) > (r102 - r103.measureText(g1.a.c(r100.getContext(), R.string.commerce_anchor_v3_ellipse, new Object[]{""})))) goto L9;
        r100.setText(r101);
        return;
    L9:
        String r105 = r101;
    L11:
        if (r100.getPaint().measureText(r101) <= r102) goto L18;
        if (a2.b(r105) == false) goto L18;
        if (r105 == null) goto L16;
        String r106 = r105.substring(0, r105.length() - 1);
    L17:
        r105 = r106;
        int r107 = g1.f45599a;
        r101 = g1.a.c(r100.getContext(), R.string.commerce_anchor_v3_ellipse, new Object[]{r105});
        goto L11
    L16:
        r106 = null;
    L18:
        r100.setText(r101);
    }
}
