package com.stepos.textinputlayout;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import com.stepos.aiengine.R;
import wa.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class EditTextWithClearIcon extends EditText {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f8106c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f8107a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8108b;

    public EditTextWithClearIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8107a = context.getDrawable(R.drawable.stepos_text_input_layout_ic_clear);
        this.f8108b = context.getResources().getConfiguration().getLayoutDirection() == 1;
        addTextChangedListener(new c(this));
        if (length() <= 0) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (this.f8108b) {
            setCompoundDrawablesWithIntrinsicBounds(this.f8107a, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f8107a, (Drawable) null);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable = this.f8108b ? getCompoundDrawables()[0] : getCompoundDrawables()[2];
        if (motionEvent.getAction() == 1 && drawable != null) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i10 = iArr[0];
            rect.set(i10, iArr[1], getWidth() + i10, getHeight() + iArr[1]);
            int intrinsicHeight = ((rect.bottom - rect.top) - drawable.getIntrinsicHeight()) / 2;
            if (this.f8108b) {
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
