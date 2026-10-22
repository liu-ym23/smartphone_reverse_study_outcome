package com.stepos.textinputlayout;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.stepos.ability.R;
import v6.c;

/* loaded from: classes3.dex */
public class EditTextWithClearIcon extends EditText {
    public static final /* synthetic */ int c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f4077a;
    public final boolean b;

    public EditTextWithClearIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4077a = ContextCompat.getDrawable(context, R.drawable.stepos_text_input_layout_ic_clear);
        this.b = context.getResources().getConfiguration().getLayoutDirection() == 1;
        addTextChangedListener(new c(0, this));
        if (length() <= 0) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (this.b) {
            setCompoundDrawablesWithIntrinsicBounds(this.f4077a, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f4077a, (Drawable) null);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable = this.b ? getCompoundDrawables()[0] : getCompoundDrawables()[2];
        if (motionEvent.getAction() == 1 && drawable != null) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i = iArr[0];
            rect.set(i, iArr[1], getWidth() + i, getHeight() + iArr[1]);
            int intrinsicHeight = ((rect.bottom - rect.top) - drawable.getIntrinsicHeight()) / 2;
            if (this.b) {
                int compoundDrawablePadding = getCompoundDrawablePadding() + getPaddingLeft() + rect.left;
                rect.left = compoundDrawablePadding;
                rect.right = drawable.getIntrinsicWidth() + compoundDrawablePadding;
            } else {
                int paddingRight = (rect.right - getPaddingRight()) - getCompoundDrawablePadding();
                rect.right = paddingRight;
                rect.left = paddingRight - drawable.getIntrinsicWidth();
            }
            rect.top += intrinsicHeight;
            rect.bottom -= intrinsicHeight;
            if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                setText("");
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
