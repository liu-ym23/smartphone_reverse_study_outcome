package com.google.android.material.datepicker;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;

/* renamed from: com.google.android.material.datepicker.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC0908k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2429a;
    public final /* synthetic */ View b;

    public /* synthetic */ RunnableC0908k(int i, View view) {
        this.f2429a = i;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2429a) {
            case 0:
                DateSelector.lambda$showKeyboardWithAutoHideBehavior$1(this.b);
                break;
            default:
                View view = this.b;
                ((InputMethodManager) ContextCompat.getSystemService(view.getContext(), InputMethodManager.class)).showSoftInput(view, 1);
                break;
        }
    }
}
