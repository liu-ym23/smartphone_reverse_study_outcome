package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;

/* renamed from: com.google.android.material.datepicker.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class ViewOnFocusChangeListenerC0907j implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2428a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ViewOnFocusChangeListenerC0907j(Object obj, int i) {
        this.f2428a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        int i = this.f2428a;
        Object obj = this.b;
        switch (i) {
            case 0:
                DateSelector.lambda$showKeyboardWithAutoHideBehavior$0((EditText[]) obj, view, z10);
                break;
            case 1:
                com.google.android.material.textfield.c cVar = (com.google.android.material.textfield.c) obj;
                cVar.t(cVar.u());
                break;
            default:
                com.google.android.material.textfield.j jVar = (com.google.android.material.textfield.j) obj;
                jVar.l = z10;
                jVar.q();
                if (!z10) {
                    jVar.t(false);
                    jVar.m = false;
                    break;
                }
                break;
        }
    }
}
