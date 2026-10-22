package com.stepos.textinputlayout;

import H1.g;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class EditTextWithClearIcon extends EditText {

    /* renamed from: a, reason: collision with root package name */
    Drawable f15995a;

    /* renamed from: b, reason: collision with root package name */
    boolean f15996b;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EditTextWithClearIcon.this.c();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }
    }

    public EditTextWithClearIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    private void b(Context context) {
        this.f15995a = androidx.core.content.a.e(context, g.f2179O);
        this.f15996b = context.getResources().getConfiguration().getLayoutDirection() == 1;
        addTextChangedListener(new a());
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (length() <= 0) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (this.f15996b) {
            setCompoundDrawablesWithIntrinsicBounds(this.f15995a, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f15995a, (Drawable) null);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable = this.f15996b ? getCompoundDrawables()[0] : getCompoundDrawables()[2];
        if (motionEvent.getAction() == 1 && drawable != null) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i5 = iArr[0];
            rect.set(i5, iArr[1], getWidth() + i5, iArr[1] + getHeight());
            int intrinsicHeight = ((rect.bottom - rect.top) - drawable.getIntrinsicHeight()) / 2;
            if (this.f15996b) {
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
                setText(BuildConfig.FLAVOR);
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
