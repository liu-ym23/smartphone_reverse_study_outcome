package uc;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f24930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f24931b;

    public a(float r10, float r11) {
        this.f24930a = r10;
        this.f24931b = r11;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r10, MotionEvent r11) {
        int r12 = r11.getAction();
        if (r12 != 0) goto L5;
        r10.setAlpha(this.f24930a);
        return false;
    L5:
        if (r12 != 1) goto L7;
    L9:
        r10.setAlpha(this.f24931b);
        return false;
    L7:
        if (r12 == 3) goto L9;
        return false;
    }
}
