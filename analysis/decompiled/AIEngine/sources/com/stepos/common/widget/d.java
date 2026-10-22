package com.stepos.common.widget;

import android.content.res.Resources;
import com.stepos.common.widget.CircularProgressButton;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements CircularProgressButton.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressButton f7149a;

    public d(CircularProgressButton circularProgressButton) {
        this.f7149a = circularProgressButton;
    }

    @Override // com.stepos.common.widget.CircularProgressButton.g
    public final void a() throws Resources.NotFoundException {
        CircularProgressButton circularProgressButton = this.f7149a;
        if (circularProgressButton.f6800x != 0) {
            circularProgressButton.setText((CharSequence) null);
            circularProgressButton.setIcon(circularProgressButton.f6800x);
            return;
        }
        circularProgressButton.setWidth(circularProgressButton.getCompoundPaddingLeft() + circularProgressButton.getCompoundPaddingRight() + circularProgressButton.h(circularProgressButton.getPaint(), circularProgressButton.r));
        circularProgressButton.setText(circularProgressButton.r);
        circularProgressButton.S = false;
        circularProgressButton.T = true;
    }
}
