package com.google.android.material.dialog;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class InsetDialogOnTouchListener implements View.OnTouchListener {

    @NonNull
    private final Dialog dialog;
    private final int leftInset;
    private final int prePieSlop;
    private final int topInset;

    public InsetDialogOnTouchListener(@NonNull Dialog r10, @NonNull Rect r11) {
        this.dialog = r10;
        this.leftInset = r11.left;
        this.topInset = r11.top;
        this.prePieSlop = ViewConfiguration.get(r10.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View r10, @NonNull MotionEvent r11) {
        View r12 = r10.findViewById(R.id.content);
        int r13 = this.leftInset + r12.getLeft();
        int r14 = r12.getWidth() + r13;
        int r15 = this.topInset + r12.getTop();
        if (new RectF(r13, r15, r14, r12.getHeight() + r15).contains(r11.getX(), r11.getY()) == false) goto L6;
        return false;
    L6:
        MotionEvent r16 = MotionEvent.obtain(r11);
        if (r11.getAction() != 1) goto L9;
        r16.setAction(4);
    L9:
        r10.performClick();
        return this.dialog.onTouchEvent(r16);
    }
}
