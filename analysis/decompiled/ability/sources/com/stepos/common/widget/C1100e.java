package com.stepos.common.widget;

/* renamed from: com.stepos.common.widget.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1100e implements InterfaceC1105j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressButton f3801a;

    public C1100e(CircularProgressButton circularProgressButton) {
        this.f3801a = circularProgressButton;
    }

    @Override // com.stepos.common.widget.InterfaceC1105j
    public final void onAnimationEnd() {
        CircularProgressButton circularProgressButton = this.f3801a;
        circularProgressButton.b0 = false;
        circularProgressButton.setClickable(true);
        circularProgressButton.setText((CharSequence) null);
        circularProgressButton.requestLayout();
    }
}
