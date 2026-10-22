package com.android.contacts.forcetouch;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import bytedanceos.api.ViewSmt;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;

/* JADX INFO: loaded from: classes.dex */
public class BytedanceosForceTouchDetector extends ForceTouchDetector {
    private Context mContext;
    private MotionEvent mCurrentDownEvent;
    private ForceTouchDetector.OnForceTouchListener mListener;

    public BytedanceosForceTouchDetector(Context r1) {
        super(r1);
        this.mContext = r1;
    }

    private boolean isForceTouch(View r1, Context r2, MotionEvent r3) {
        return ViewSmt.getInstance().isForceTouch(r1, r2, r3.getPressure());
    }

    @Override // com.android.contacts.forcetouch.ForceTouchDetector
    public void setOnForceTouchListener(ForceTouchDetector.OnForceTouchListener r1) {
        this.mListener = r1;
    }

    @Override // com.android.contacts.forcetouch.ForceTouchDetector
    public void onTouchEvent(View r7, MotionEvent r8) {
        int r0 = r8.getAction() & 255;
        if (r0 != 0) goto L5;
        MotionEvent r9 = this.mCurrentDownEvent;
        if (r9 == null) goto L26;
        r9.recycle();
    L26:
        this.mCurrentDownEvent = MotionEvent.obtain(r8);
        return;
    L5:
        if (r0 == 2) goto L8;
        return;
    L8:
        if (isForceTouch(r7, this.mContext, r8) == false) goto L28;
        MotionEvent r10 = this.mCurrentDownEvent;
        if (r10 == null) goto L12;
        int r11 = r10.getActionIndex();
        int r1 = r8.getActionIndex();
        int r2 = r8.getPointerId(r1);
        float r3 = r8.getX(r1);
        float r4 = r8.getY(r1);
        int r5 = this.mCurrentDownEvent.getPointerId(r11);
        float r6 = this.mCurrentDownEvent.getX(r11);
        float r12 = this.mCurrentDownEvent.getY(r11);
        if (r2 == r5) goto L17;
        return;
    L17:
        if (Math.abs(r6 - r3) < 100.0f) goto L19;
        return;
    L19:
        if (Math.abs(r12 - r4) >= 100.0f) goto L33;
        ForceTouchDetector.OnForceTouchListener r13 = this.mListener;
        if (r13 == null) goto L34;
        r13.onForceTouch(r8);
        return;
    L34:
        return;
    L33:
        return;
    L12:
        if (ContactsUtils.DEBUG == false) goto L29;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("BytedanceosForceTouchDetector", "MotionEvent ACTION_MOVE mCurrentDownEvent is null");
        return;
    L29:
        return;
    }
}
