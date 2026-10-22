package com.android.contacts.dialpad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class DialButtonView extends TextView {
    private boolean mIsActionDown;
    private NinePatch mNinePatch;
    private Rect mRect;

    static /* synthetic */ NinePatch access$002(DialButtonView r0, NinePatch r1) {
        r0.mNinePatch = r1;
        return r1;
    }

    public DialButtonView(Context r1) {
        super(r1);
        this.mIsActionDown = false;
        this.mRect = new Rect();
    }

    public DialButtonView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mIsActionDown = false;
        this.mRect = new Rect();
    }

    public DialButtonView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mIsActionDown = false;
        this.mRect = new Rect();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.contacts.dialpad.DialButtonView$1] */
    public void setPressedBackground(final int r2) {
        new AnonymousClass1(this, r2).execute(new Void[0]);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        super.setOnClickListener(r1);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        int r0 = r4.getAction();
        if (r0 != 0) goto L5;
        this.mIsActionDown = true;
        invalidate();
    L13:
        return super.onTouchEvent(r4);
    L5:
        if (r0 != 1) goto L7;
        this.mIsActionDown = false;
        invalidate();
        goto L13
    L7:
        if (r0 != 3) goto L13;
        this.mIsActionDown = false;
        invalidate();
        goto L13
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r3) {
        super.onDraw(r3);
        if (this.mIsActionDown == true) goto L5;
        return;
    L5:
        if (isEnabled() == true) goto L7;
        return;
    L7:
        if (this.mNinePatch == null) goto L12;
        Rect r0 = this.mRect;
        r0.right = getWidth();
        Rect r1 = this.mRect;
        r1.bottom = getHeight();
        this.mNinePatch.draw(r3, this.mRect);
        return;
    }
}
