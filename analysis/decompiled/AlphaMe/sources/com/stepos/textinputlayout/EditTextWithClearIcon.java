package com.stepos.textinputlayout;

import W2.c;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.core.content.a;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public class EditTextWithClearIcon extends EditText {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f12383c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f12384a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12385b;

    public EditTextWithClearIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12384a = a.b(context, R.drawable.stepos_text_input_layout_ic_clear);
        this.f12385b = context.getResources().getConfiguration().getLayoutDirection() == 1;
        addTextChangedListener(new c(0, this));
        if (length() <= 0) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (this.f12385b) {
            setCompoundDrawablesWithIntrinsicBounds(this.f12384a, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f12384a, (Drawable) null);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable = this.f12385b ? getCompoundDrawables()[0] : getCompoundDrawables()[2];
        if (motionEvent.getAction() == 1 && drawable != null) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i4 = iArr[0];
            rect.set(i4, iArr[1], getWidth() + i4, getHeight() + iArr[1]);
            int intrinsicHeight = ((rect.bottom - rect.top) - drawable.getIntrinsicHeight()) / 2;
            if (this.f12385b) {
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
