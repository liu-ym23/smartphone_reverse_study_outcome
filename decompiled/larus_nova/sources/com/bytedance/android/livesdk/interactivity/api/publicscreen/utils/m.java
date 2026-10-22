package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.DynamicDrawableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class m extends LinkMovementMethod {
    public m() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView r110, Spannable r111, MotionEvent r112) {
        Intrinsics.checkNotNull(r112);
        int r100 = r112.getAction();
        if (r100 == 1) goto L7;
        if (r100 == 0) goto L7;
    L57:
        return super.onTouchEvent(r110, r111, r112);
    L7:
        int r101 = (int) r112.getX();
        int r102 = (int) r112.getY();
        Intrinsics.checkNotNull(r110);
        int r103 = r101 - r110.getTotalPaddingLeft();
        int r104 = r102 - r110.getTotalPaddingTop();
        int r105 = r103 + r110.getScrollX();
        int r106 = r104 + r110.getScrollY();
        Layout r107 = r110.getLayout();
        int r108 = r107.getLineForVertical(r106);
        float r109 = r105;
        int r113 = r107.getOffsetForHorizontal(r108, r109);
        Intrinsics.checkNotNull(r111);
        ClickableSpan[] r114 = (ClickableSpan[]) r111.getSpans(r113, r113, ClickableSpan.class);
        ClickableSpan[] r115 = null;
        if (r114.length <= 1) goto L37;
        LinkedHashMap r116 = new LinkedHashMap();
        int r117 = r114.length;
        int r118 = 0;
    L10:
        if (r118 >= r117) goto L22;
        ClickableSpan r119 = r114[r118];
        int r120 = r111.getSpanStart(r119);
        if (((DynamicDrawableSpan[]) r111.getSpans(r120, r111.getSpanEnd(r119), DynamicDrawableSpan.class)).length != 0) goto L14;
        boolean r121 = true;
    L16:
        if ((!r121) == false) goto L20;
        float r122 = r107.getPrimaryHorizontal(r120);
        if (r109 <= r122) goto L20;
        r116.put(r119, Float.valueOf(r109 - r122));
    L20:
        r118 = r118 + 1;
        goto L10
    L14:
        r121 = false;
        goto L16
    L22:
        if ((!r116.isEmpty()) == false) goto L37;
        Iterator r123 = r116.entrySet().iterator();
        float r124 = Float.MAX_VALUE;
        ClickableSpan r125 = null;
    L25:
        if (r123.hasNext() == false) goto L29;
        Map.Entry r126 = (Map.Entry) r123.next();
        if (((Number) r126.getValue()).floatValue() >= r124) goto L25;
        r125 = (ClickableSpan) r126.getKey();
        r124 = ((Number) r126.getValue()).floatValue();
        goto L25
    L29:
        List r127 = CollectionsKt.listOf(r125);
        if ((!r127.isEmpty()) == false) goto L37;
        Object[] r128 = r127.toArray(new ClickableSpan[0]);
        if (r128 == null) goto L35;
        r114 = (ClickableSpan[]) r128;
        goto L37
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L37:
        if (r108 == (r107.getLineCount() - 1)) goto L39;
    L41:
        r115 = r114;
    L42:
        if (r115 != null) goto L44;
    L55:
        Selection.removeSelection(r111);
        goto L57
    L44:
        if (r115.length != 0) goto L46;
        boolean r129 = true;
    L48:
        if ((!r129) == false) goto L55;
        ClickableSpan r130 = r115[0];
        if (r100 != 1) goto L52;
        r130.onClick(r110);
    L54:
        return true;
    L52:
        if (r100 != 0) goto L54;
        Selection.setSelection(r111, r111.getSpanStart(r130), r111.getSpanEnd(r130));
        goto L54
    L46:
        r129 = false;
        goto L48
    L39:
        if (r109 <= r107.getLineRight(r108)) goto L41;
        goto L41
    }
}
