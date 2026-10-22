package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.base.Highlight;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class v {
    public static final SpannableString a(TextElement r100) {
        String r101 = "";
        if (r100 == null) goto L67;
        String r102 = r100.getText();
        if (r102 == null) goto L9;
        r101 = r102;
    L9:
        SpannableString r103 = new SpannableString(r101);
        FontStyle r104 = r100.getFontStyle();
        Integer r105 = null;
        if (r104 == null) goto L12;
        String r106 = r104.getTextColor();
    L13:
        r103.setSpan(new ForegroundColorSpan(com.bytedance.android.shopping.extensions.a.a(r106, ColorProtector.parseColor("#161823"))), 0, r103.length(), 33);
        FontStyle r107 = r100.getFontStyle();
        if (r107 == null) goto L16;
        r105 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r107.getFontSize())));
    L16:
        r103.setSpan(new AbsoluteSizeSpan(com.bytedance.android.shopping.extensions.k.g(r105, com.bytedance.android.shopping.extensions.b.b(13))), 0, r103.length(), 33);
        FontStyle r108 = r100.getFontStyle();
        if (r108 == null) goto L19;
        int r109 = r108.getFontWeight();
    L21:
        if (r109 <= 500) goto L23;
        r103.setSpan(new StyleSpan(1), 0, r103.length(), 33);
    L23:
        List<Highlight> r110 = r100.getHighlights();
        if (r110 != null) goto L26;
    L29:
        boolean r111 = true;
    L30:
        if (r111 == true) goto L59;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L55
        Iterator<T> r113 = r100.getHighlights().iterator();     // Catch: Throwable -> L55
    L33:
        if (r113.hasNext() == false) goto L53;
        Highlight r114 = (Highlight) r113.next();     // Catch: Throwable -> L55
        FontStyle r115 = r114.getHighlightStyle();     // Catch: Throwable -> L55
        if (r115 == null) goto L33;
        ForegroundColorSpan r116 = new ForegroundColorSpan(com.bytedance.android.shopping.extensions.a.a(r115.getTextColor(), 0));     // Catch: Throwable -> L55
        Integer r117 = r114.getStart();     // Catch: Throwable -> L55
        if (r117 == null) goto L39;
        int r118 = r117.intValue();     // Catch: Throwable -> L55
    L40:
        Integer r119 = r114.getEnd();     // Catch: Throwable -> L55
        if (r119 == null) goto L43;
        int r120 = r119.intValue();     // Catch: Throwable -> L55
    L44:
        r103.setSpan(r116, r118, r120 + 1, 18);     // Catch: Throwable -> L55
        AbsoluteSizeSpan r121 = new AbsoluteSizeSpan(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r115.getFontSize())));     // Catch: Throwable -> L55
        Integer r122 = r114.getStart();     // Catch: Throwable -> L55
        if (r122 == null) goto L47;
        int r123 = r122.intValue();     // Catch: Throwable -> L55
    L48:
        Integer r124 = r114.getEnd();     // Catch: Throwable -> L55
        if (r124 == null) goto L51;
        int r125 = r124.intValue();     // Catch: Throwable -> L55
    L52:
        r103.setSpan(r121, r123, r125 + 1, 18);     // Catch: Throwable -> L55
        goto L33
    L51:
        r125 = 0;
        goto L52
    L47:
        r123 = 0;
        goto L48
    L43:
        r120 = 0;
        goto L44
    L39:
        r118 = 0;
        goto L40
    L53:
        Object r126 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L55
    L57:
        Result.m9452exceptionOrNullimpl(r126);
    L55:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L59:
        return r103;
    L26:
        if (r110.isEmpty() == true) goto L29;
        r111 = false;
        goto L30
    L19:
        r109 = 0;
        goto L21
    L12:
        r106 = null;
        goto L13
    L67:
        return new SpannableString("");
    }
}
