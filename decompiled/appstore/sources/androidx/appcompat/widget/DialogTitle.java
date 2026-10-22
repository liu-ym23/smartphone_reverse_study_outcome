package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$styleable;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DialogTitle extends AppCompatTextView {
    public DialogTitle(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        Layout r12 = getLayout();
        if (r12 == null) goto L13;
        int r13 = r12.getLineCount();
        if (r13 > 0) goto L7;
        return;
    L7:
        if (r12.getEllipsisCount(r13 - 1) <= 0) goto L15;
        setSingleLine(false);
        setMaxLines(2);
        TypedArray r14 = getContext().obtainStyledAttributes(null, R$styleable.TextAppearance, R.attr.textAppearanceMedium, R.style.TextAppearance.Medium);
        int r15 = r14.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, 0);
        if (r15 == 0) goto L11;
        setTextSize(0, r15);
    L11:
        r14.recycle();
        super.onMeasure(r10, r11);
        return;
    L15:
        return;
    }

    public DialogTitle(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
    }

    public DialogTitle(@NonNull Context r10) {
        super(r10);
    }
}
