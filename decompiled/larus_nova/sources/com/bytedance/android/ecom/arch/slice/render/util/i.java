package com.bytedance.android.ecom.arch.slice.render.util;

import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.widget.span.SlcTypefaceSpan;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class i {
    public static final void a(TextPaint r100, int r101) {
        Typeface r102 = r100.getTypeface();     // Catch: Throwable -> L14
        boolean r103 = false;
        if (r102 == null) goto L6;
        int r104 = r102.getStyle();     // Catch: Throwable -> L14
    L8:
        if (((r101 & (~r104)) & 2) == 0) goto L10;
        r103 = true;
    L10:
        if (r103 == false) goto L12;
        r100.setTextSkewX(-0.25f);     // Catch: Throwable -> L14
        return;
    L12:
        r100.setTextSkewX(0.0f);     // Catch: Throwable -> L14
        return;
    L6:
        r104 = 0;
    L14:
        th = move-exception;
        nq.a.c(th, null, 2);
    }

    public static void e(TextView r100, Integer r101) {
        TextPaint r102 = r100.getPaint();
        if (r102 == null) goto L35;
        if (r101 == null) goto L6;
        int r103 = r101.intValue();
    L7:
        Typeface r104 = r102.getTypeface();
        boolean r105 = true;
        int r106 = 0;
        if (r104 != null) goto L10;
    L12:
        boolean r107 = false;
    L13:
        boolean r108 = com.bytedance.android.ecom.arch.slice.render.h.a(Integer.valueOf(r103));
        if (r107 == false) goto L16;
        int r109 = 2;
    L17:
        Typeface r110 = d(r104, r103, r109 | (r108 ? 1 : 0));
        boolean r111 = com.bytedance.android.ecom.arch.slice.render.h.a(Integer.valueOf(r103));
        if (r110 != null) goto L20;
    L21:
        if (r104 != null) goto L23;
    L25:
        r105 = false;
    L26:
        if (r105 == false) goto L28;
        r106 = 2;
    L28:
        int r112 = (r111 ? 1 : 0) | r106;
        if (r110 != null) goto L31;
        Typeface r113 = Typeface.defaultFromStyle(r112);
    L32:
        r110 = r113;
    L33:
        r102.setTypeface(r110);
        return;
    L31:
        r113 = Typeface.create(r110, r112);
        goto L32
    L23:
        if (r104.isItalic() != true) goto L25;
    L20:
        if (r110.isBold() == r111) goto L33;
    L16:
        r109 = 0;
        goto L17
    L10:
        if (r104.isItalic() == false) goto L12;
        r107 = true;
        goto L13
    L6:
        r103 = 400;
        goto L7
    }

    public static final SlcTypefaceSpan b(int r100, String r101, String r102) {
        boolean r103 = com.bytedance.android.ecom.arch.slice.render.h.a(Integer.valueOf(r100));
        int r104 = 0;
        if (r101 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L11;
        r104 = 2;
    L11:
        return new SlcTypefaceSpan((r103 ? 1 : 0) | r104, r100, r102);
    L5:
        if ("italic".equals(r101) == false) goto L7;
        r105 = true;
        goto L8
    }

    public static final Typeface d(Typeface r100, int r101, int r102) {
        int r103 = 0;
        if ((r102 & 2) != 2) goto L5;
        boolean r104 = true;
    L6:
        Typeface r105 = null;
        if (Build.VERSION.SDK_INT >= 28) goto L26;
        if (r100 != null) goto L25;
    L17:
        int r106 = r103 | r102;     // Catch: Throwable -> L15
        if (r100 != null) goto L21;
        return Typeface.defaultFromStyle(r106);
    L21:
        return Typeface.create(r100, r106);
    L25:
        r103 = r100.getStyle();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        nq.a.c(th, null, 2);
        return null;
    L26:
        return Typeface.create(r100, r101, r104);
    L10:
        r105 = Typeface.create(null, r102);     // Catch: Throwable -> L24
    L12:
        return r105;
    L5:
        r104 = false;
        goto L6
    }

    public static final Typeface c(Typeface r100, int r101, int r102, String r103) {
        boolean r104 = true;
        if ((r102 & 2) != 2) goto L5;
        boolean r105 = true;
    L6:
        if (r103 != null) goto L8;
    L11:
        Typeface r106 = null;
        if (r104 == true) goto L16;
        SliceRender.f50121o.getClass();
        pq.a r107 = SliceRender.f50108b;
        if (r107 == null) goto L16;
        r106 = r107.j(r103, r101, r105);
    L16:
        if (r106 == null) goto L18;
        return r106;
    L18:
        return d(r100, r101, r102);
    L8:
        if (StringsKt.isBlank(r103) == true) goto L11;
        r104 = false;
        goto L11
    L5:
        r105 = false;
        goto L6
    }
}
