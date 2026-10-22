package com.google.android.material.datepicker;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4962a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f4963b;

    public /* synthetic */ f(int i10, View view) {
        this.f4962a = i10;
        this.f4963b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4962a) {
            case 0:
                DateSelector.lambda$showKeyboardWithAutoHideBehavior$1(this.f4963b);
                break;
            default:
                View view = this.f4963b;
                ((InputMethodManager) view.getContext().getSystemService(InputMethodManager.class)).showSoftInput(view, 1);
                break;
        }
    }
}
