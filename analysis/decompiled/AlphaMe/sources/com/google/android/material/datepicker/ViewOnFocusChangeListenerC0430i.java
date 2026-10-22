package com.google.android.material.datepicker;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.stepos.alphame.persona.address.ui.AddressMainActivity;

/* renamed from: com.google.android.material.datepicker.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnFocusChangeListenerC0430i implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10684a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10685b;

    public /* synthetic */ ViewOnFocusChangeListenerC0430i(int i4, Object obj) {
        this.f10684a = i4;
        this.f10685b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z4) {
        int i4 = this.f10684a;
        Object obj = this.f10685b;
        switch (i4) {
            case 0:
                for (EditText editText : (EditText[]) obj) {
                    if (editText.hasFocus()) {
                        break;
                    }
                }
                InputMethodManager inputMethodManager = (InputMethodManager) androidx.core.content.b.b(view.getContext(), InputMethodManager.class);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    break;
                }
                break;
            case 1:
                com.google.android.material.textfield.d dVar = (com.google.android.material.textfield.d) obj;
                dVar.t(dVar.u());
                break;
            case 2:
                com.google.android.material.textfield.k kVar = (com.google.android.material.textfield.k) obj;
                kVar.f11025l = z4;
                kVar.q();
                if (!z4) {
                    kVar.t(false);
                    kVar.f11026m = false;
                    break;
                }
                break;
            default:
                AddressMainActivity.setMainPage$lambda$9$lambda$5$lambda$4((AddressMainActivity) obj, view, z4);
                break;
        }
    }
}
