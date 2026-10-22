package com.bytedance.android.shopping.widget.rittag;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.shopping.extensions.k;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static final int a() {
        return b(Float.valueOf(0.5f));
    }

    public static final int b(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dpCeil");
        float r101 = r100.floatValue();
        Resources r102 = uf4.a.a().getResources();
        return (int) Math.ceil(TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
    }

    public static final Drawable c(float[] r110, float r111, String r112, String r113) {
        if (r110 == null) goto L16;
        int r100 = r110.length;
        int r101 = 0;
    L5:
        if (r101 >= r100) goto L13;
        if (r110[r101] <= 0.0f) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L11;
        r101 = r101 + 1;
        goto L5
    L11:
        boolean r103 = true;
    L14:
        if (r103 != true) goto L16;
        boolean r104 = true;
    L17:
        if (r112 != null) goto L19;
    L21:
        boolean r105 = false;
    L22:
        if (r104 == true) goto L26;
        if (r105 == true) goto L26;
        return new ColorDrawable(s.a(r113, 0));
    L26:
        int r114 = s.a(r113, 0);
        GradientDrawable r106 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{r114, r114});
        r106.setShape(0);
        float[] r115 = null;
        if (r110 == null) goto L38;
        int r107 = r110.length;
        if (r107 == 1) goto L35;
        if (r107 == 4) goto L34;
        if (r107 != 8) goto L36;
    L37:
        r115 = r110;
    L36:
        r110 = r115;
        goto L37
    L34:
        float r108 = r110[1];
        float r109 = r110[2];
        float r116 = r110[3];
        r115 = new float[]{r110[0], r110[0], r108, r108, r109, r109, r116, r116};
        goto L36
    L35:
        float r117 = r110[0];
        r115 = new float[]{r110[0], r117, r117, r117, r117, r117, r117, r117};
    L38:
        if (r115 == null) goto L42;
        int r118 = r115.length;
        int r119 = 0;
        int r120 = 0;
    L40:
        if (r119 >= r118) goto L42;
        r115[r120] = q.a(Float.valueOf(r115[r119]));
        r119 = r119 + 1;
        r120 = r120 + 1;
    L42:
        if (r115 == null) goto L46;
        int r121 = r115.length;
        int r122 = 0;
        int r123 = 0;
    L44:
        if (r122 >= r121) goto L46;
        r115[r123] = RangesKt.coerceAtMost(r115[r122], r111);
        r122 = r122 + 1;
        r123 = r123 + 1;
    L46:
        r106.setCornerRadii(r115);
        if (k.c(r112) == false) goto L50;
        r106.setStroke(a(), s.a(r112, 0));
    L50:
        return r106;
    L19:
        if ((!StringsKt.isBlank(r112)) != true) goto L21;
        r105 = true;
        goto L22
    L9:
        r102 = false;
        goto L10
    L13:
        r103 = false;
    L16:
        r104 = false;
        goto L17
    }
}
