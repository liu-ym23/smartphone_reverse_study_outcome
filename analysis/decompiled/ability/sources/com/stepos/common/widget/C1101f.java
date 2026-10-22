package com.stepos.common.widget;

import android.content.res.Resources;

/* renamed from: com.stepos.common.widget.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1101f implements InterfaceC1105j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3802a;
    public final /* synthetic */ CircularProgressButton b;

    public /* synthetic */ C1101f(CircularProgressButton circularProgressButton, int i) {
        this.f3802a = i;
        this.b = circularProgressButton;
    }

    @Override // com.stepos.common.widget.InterfaceC1105j
    public final void onAnimationEnd() throws Resources.NotFoundException {
        switch (this.f3802a) {
            case 0:
                CircularProgressButton circularProgressButton = this.b;
                if (circularProgressButton.f3655t != 0) {
                    circularProgressButton.setText((CharSequence) null);
                    circularProgressButton.setIcon(circularProgressButton.f3655t);
                } else {
                    circularProgressButton.setText(circularProgressButton.n);
                }
                circularProgressButton.s();
                circularProgressButton.b0 = false;
                circularProgressButton.setClickable(true);
                circularProgressButton.setTextColor(circularProgressButton.f3628F);
                break;
            case 1:
                CircularProgressButton circularProgressButton2 = this.b;
                circularProgressButton2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                circularProgressButton2.setPadding(0, 0, 0, 0);
                circularProgressButton2.setText(circularProgressButton2.m);
                circularProgressButton2.s();
                circularProgressButton2.b0 = false;
                circularProgressButton2.setClickable(true);
                circularProgressButton2.setTextColor(circularProgressButton2.E);
                break;
            case 2:
                CircularProgressButton circularProgressButton3 = this.b;
                if (circularProgressButton3.u == 0) {
                    circularProgressButton3.setWidth(circularProgressButton3.getCompoundPaddingLeft() + circularProgressButton3.getCompoundPaddingRight() + circularProgressButton3.h(circularProgressButton3.getPaint(), circularProgressButton3.o));
                    circularProgressButton3.setText(circularProgressButton3.o);
                    circularProgressButton3.f3638T = false;
                    circularProgressButton3.f3639U = true;
                    break;
                } else {
                    circularProgressButton3.setText((CharSequence) null);
                    circularProgressButton3.setIcon(circularProgressButton3.u);
                    break;
                }
            case 3:
                CircularProgressButton circularProgressButton4 = this.b;
                if (circularProgressButton4.u != 0) {
                    circularProgressButton4.setText((CharSequence) null);
                    circularProgressButton4.setIcon(circularProgressButton4.u);
                } else {
                    circularProgressButton4.setText(circularProgressButton4.o);
                }
                circularProgressButton4.b0 = false;
                circularProgressButton4.setClickable(true);
                circularProgressButton4.setTextColor(circularProgressButton4.f3629G);
                break;
            default:
                CircularProgressButton circularProgressButton5 = this.b;
                circularProgressButton5.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                circularProgressButton5.setPadding(0, 0, 0, 0);
                circularProgressButton5.setText(circularProgressButton5.m);
                circularProgressButton5.s();
                circularProgressButton5.b0 = false;
                circularProgressButton5.setClickable(true);
                break;
        }
    }
}
