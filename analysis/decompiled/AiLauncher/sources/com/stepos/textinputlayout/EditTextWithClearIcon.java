package com.stepos.textinputlayout;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import com.stepos.common.R$drawable;

/* loaded from: classes2.dex */
public class EditTextWithClearIcon extends EditText {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f31078a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f31079b;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EditTextWithClearIcon.this.c();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public EditTextWithClearIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public final void b(Context context) {
        this.f31078a = androidx.core.content.a.e(context, R$drawable.stepos_text_input_layout_ic_clear);
        this.f31079b = context.getResources().getConfiguration().getLayoutDirection() == 1;
        addTextChangedListener(new a());
        c();
    }

    public final void c() {
        if (length() <= 0) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (this.f31079b) {
            setCompoundDrawablesWithIntrinsicBounds(this.f31078a, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f31078a, (Drawable) null);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable = this.f31079b ? getCompoundDrawables()[0] : getCompoundDrawables()[2];
        if (motionEvent.getAction() == 1 && drawable != null) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i10 = iArr[0];
            rect.set(i10, iArr[1], getWidth() + i10, iArr[1] + getHeight());
            int intrinsicHeight = ((rect.bottom - rect.top) - drawable.getIntrinsicHeight()) / 2;
            if (this.f31079b) {
                int paddingLeft = rect.left + getPaddingLeft() + getCompoundDrawablePadding();
                rect.left = paddingLeft;
                rect.right = paddingLeft + drawable.getIntrinsicWidth();
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
