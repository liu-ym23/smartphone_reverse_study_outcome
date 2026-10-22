package com.android.contacts.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes2.dex */
public class WhiteView extends View {
    private float mLeft;
    private Paint mPaint;
    private float mY;

    public WhiteView(Context r1, float r2) {
        super(r1);
        this.mLeft = 100.0f;
        this.mY = r2 + 300.0f;
        init();
    }

    public WhiteView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mY = 200.0f;
        init();
    }

    public void init() {
        Paint r0 = new Paint();
        this.mPaint = r0;
        r0.setColor(-1);
    }

    public void setPointY(float r3) {
        this.mY = r3 + 254.0f;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("mY", "mY" + this.mY);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r17) {
        super.onDraw(r17);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("mY", "mY" + this.mY);
        r17.drawRect(0.0f, 131.0f, 480.0f, (this.mY + 131.0f) - 40.0f, this.mPaint);
        r17.drawRect(0.0f, (this.mY + 131.0f) + 40.0f, 480.0f, 686.0f, this.mPaint);
    }
}
