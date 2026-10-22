package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes2.dex */
public class DialogTitle extends AppCompatTextView {
    public DialogTitle(Context r100) {
        super(r100);
    }

    public DialogTitle(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        Layout r102 = getLayout();
        if (r102 == null) goto L13;
        int r103 = r102.getLineCount();
        if (r103 > 0) goto L7;
        return;
    L7:
        if (r102.getEllipsisCount(r103 - 1) <= 0) goto L15;
        setSingleLine(false);
        setMaxLines(2);
        TypedArray r104 = getContext().obtainStyledAttributes(null, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale}, R.attr.textAppearanceMedium, R.style.TextAppearance.Medium);
        int r105 = r104.getDimensionPixelSize(0, 0);
        if (r105 == 0) goto L11;
        setTextSize(0, r105);
    L11:
        r104.recycle();
        super.onMeasure(r100, r101);
        return;
    L15:
        return;
    }

    public DialogTitle(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
