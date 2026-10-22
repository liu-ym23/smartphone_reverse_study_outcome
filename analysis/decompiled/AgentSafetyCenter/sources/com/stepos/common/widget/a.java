package com.stepos.common.widget;

import android.content.res.Resources;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2660a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ CircularProgressButton f2661b;

    public /* synthetic */ a(int i) {
        this.f2660a = i;
    }

    public final void a() throws Resources.NotFoundException {
        switch (this.f2660a) {
            case 0:
                CircularProgressButton circularProgressButton = this.f2661b;
                circularProgressButton.f2559b0 = false;
                circularProgressButton.setClickable(true);
                circularProgressButton.setText((CharSequence) null);
                circularProgressButton.requestLayout();
                break;
            case 1:
                CircularProgressButton circularProgressButton2 = this.f2661b;
                if (circularProgressButton2.f2583x != 0) {
                    circularProgressButton2.setText((CharSequence) null);
                    circularProgressButton2.setIcon(circularProgressButton2.f2583x);
                } else {
                    circularProgressButton2.setText(circularProgressButton2.f2577r);
                }
                circularProgressButton2.s();
                circularProgressButton2.f2559b0 = false;
                circularProgressButton2.setClickable(true);
                circularProgressButton2.setTextColor(circularProgressButton2.J);
                break;
            case 2:
                CircularProgressButton circularProgressButton3 = this.f2661b;
                circularProgressButton3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                circularProgressButton3.setPadding(0, 0, 0, 0);
                circularProgressButton3.setText(circularProgressButton3.f2576q);
                circularProgressButton3.s();
                circularProgressButton3.f2559b0 = false;
                circularProgressButton3.setClickable(true);
                circularProgressButton3.setTextColor(circularProgressButton3.I);
                break;
            case 3:
                CircularProgressButton circularProgressButton4 = this.f2661b;
                if (circularProgressButton4.f2584y == 0) {
                    circularProgressButton4.setWidth(circularProgressButton4.getCompoundPaddingLeft() + circularProgressButton4.getCompoundPaddingRight() + circularProgressButton4.h(circularProgressButton4.getPaint(), circularProgressButton4.f2578s));
                    circularProgressButton4.setText(circularProgressButton4.f2578s);
                    circularProgressButton4.T = false;
                    circularProgressButton4.U = true;
                    break;
                } else {
                    circularProgressButton4.setText((CharSequence) null);
                    circularProgressButton4.setIcon(circularProgressButton4.f2584y);
                    break;
                }
            case 4:
                CircularProgressButton circularProgressButton5 = this.f2661b;
                if (circularProgressButton5.f2584y != 0) {
                    circularProgressButton5.setText((CharSequence) null);
                    circularProgressButton5.setIcon(circularProgressButton5.f2584y);
                } else {
                    circularProgressButton5.setText(circularProgressButton5.f2578s);
                }
                circularProgressButton5.f2559b0 = false;
                circularProgressButton5.setClickable(true);
                circularProgressButton5.setTextColor(circularProgressButton5.K);
                break;
            default:
                CircularProgressButton circularProgressButton6 = this.f2661b;
                circularProgressButton6.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                circularProgressButton6.setPadding(0, 0, 0, 0);
                circularProgressButton6.setText(circularProgressButton6.f2576q);
                circularProgressButton6.s();
                circularProgressButton6.f2559b0 = false;
                circularProgressButton6.setClickable(true);
                break;
        }
    }
}
