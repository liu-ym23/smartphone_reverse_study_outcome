package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class p implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublicScreenConfigSliderView f140265a;

    public p(PublicScreenConfigSliderView r100) {
        this.f140265a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        PublicScreenConfigSliderView r102 = this.f140265a;
        if (r102.f140191i == true) goto L30;
        if (r102.getDisable() == true) goto L30;
        int r103 = r101.getAction();
        if (r103 != 0) goto L9;
        this.f140265a.requestDisallowInterceptTouchEvent(true);
        this.f140265a.f140193k = r101.getRawY();
        PublicScreenConfigSliderView r104 = this.f140265a;
        r104.f140192j = r104.f140189g[r104.f140188f];
    L36:
        return true;
    L9:
        if (r103 != 1) goto L11;
    L27:
        this.f140265a.requestDisallowInterceptTouchEvent(false);
        PublicScreenConfigSliderView r105 = this.f140265a;
        r105.b(r105.a(), true);
        goto L36
    L11:
        if (r103 != 2) goto L13;
        float r106 = this.f140265a.f140192j;
        float r107 = r101.getRawY();
        PublicScreenConfigSliderView r108 = this.f140265a;
        float r109 = r106 + (r107 - r108.f140193k);
        float[] r110 = r108.f140189g;
        if (r109 >= r110[2]) goto L18;
    L22:
        PublicScreenConfigSliderView r111 = this.f140265a;
        int r112 = r111.a();
        if (r111.f140188f == r112) goto L36;
        r111.f140188f = r112;
        r111.f140185c.setText(r111.f140190h[r112]);
        PublicScreenConfigSliderView.a r113 = r111.f140186d;
        if (r113 == null) goto L36;
        r113.a(r112);
        goto L36
    L18:
        if (r109 > r110[0]) goto L22;
        r100.setY(r109);
        PublicScreenConfigSliderView r114 = this.f140265a;
        PublicScreenConfigSliderView.a r115 = r114.f140186d;
        if (r115 == null) goto L22;
        float[] r116 = r114.f140189g;
        r115.b(1 - (r109 / (r116[0] - r116[2])));
        goto L22
    L13:
        if (r103 == 3) goto L27;
    L30:
        if (this.f140265a.getDisable() == false) goto L36;
        if (r101.getAction() != 0) goto L36;
        la2.a r117 = this.f140265a.f140187e;
        if (r117 == null) goto L36;
        r117.a();
        goto L36
    }
}
