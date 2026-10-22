package com.stepos.common.widget;

import android.content.res.Resources;

/* renamed from: com.stepos.common.widget.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0488d implements InterfaceC0491g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11890a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CircularProgressButton f11891b;

    public /* synthetic */ C0488d(CircularProgressButton circularProgressButton, int i4) {
        this.f11890a = i4;
        this.f11891b = circularProgressButton;
    }

    public final void a() throws Resources.NotFoundException {
        int i4 = this.f11890a;
        CircularProgressButton circularProgressButton = this.f11891b;
        switch (i4) {
            case 0:
                circularProgressButton.f11467U = false;
                circularProgressButton.setClickable(true);
                circularProgressButton.setText((CharSequence) null);
                circularProgressButton.requestLayout();
                break;
            case 1:
                if (circularProgressButton.f11494t != 0) {
                    circularProgressButton.setText((CharSequence) null);
                    circularProgressButton.setIcon(circularProgressButton.f11494t);
                } else {
                    circularProgressButton.setText(circularProgressButton.f11486n);
                }
                circularProgressButton.s();
                circularProgressButton.f11467U = false;
                circularProgressButton.setClickable(true);
                circularProgressButton.setTextColor(circularProgressButton.f11453F);
                break;
            case 2:
                circularProgressButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                circularProgressButton.setPadding(0, 0, 0, 0);
                circularProgressButton.setText(circularProgressButton.f11484m);
                circularProgressButton.s();
                circularProgressButton.f11467U = false;
                circularProgressButton.setClickable(true);
                circularProgressButton.setTextColor(circularProgressButton.f11452E);
                break;
            case 3:
                if (circularProgressButton.f11495u == 0) {
                    circularProgressButton.setWidth(circularProgressButton.getCompoundPaddingLeft() + circularProgressButton.getCompoundPaddingRight() + circularProgressButton.h(circularProgressButton.getPaint(), circularProgressButton.f11488o));
                    circularProgressButton.setText(circularProgressButton.f11488o);
                    circularProgressButton.f11463P = false;
                    circularProgressButton.f11464Q = true;
                    break;
                } else {
                    circularProgressButton.setText((CharSequence) null);
                    circularProgressButton.setIcon(circularProgressButton.f11495u);
                    break;
                }
            case 4:
                if (circularProgressButton.f11495u != 0) {
                    circularProgressButton.setText((CharSequence) null);
                    circularProgressButton.setIcon(circularProgressButton.f11495u);
                } else {
                    circularProgressButton.setText(circularProgressButton.f11488o);
                }
                circularProgressButton.f11467U = false;
                circularProgressButton.setClickable(true);
                circularProgressButton.setTextColor(circularProgressButton.f11454G);
                break;
            default:
                circularProgressButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                circularProgressButton.setPadding(0, 0, 0, 0);
                circularProgressButton.setText(circularProgressButton.f11484m);
                circularProgressButton.s();
                circularProgressButton.f11467U = false;
                circularProgressButton.setClickable(true);
                break;
        }
    }
}
