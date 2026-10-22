package com.google.android.material.textfield;

import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.stepos.alphame.utils.GlobalKt;
import kotlin.jvm.functions.Function1;

/* renamed from: com.google.android.material.textfield.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0435a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10996a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10997b;

    public /* synthetic */ ViewOnClickListenerC0435a(int i4, Object obj) {
        this.f10996a = i4;
        this.f10997b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f10996a;
        Object obj = this.f10997b;
        switch (i4) {
            case 0:
                d dVar = (d) obj;
                EditText editText = dVar.f11006i;
                if (editText != null) {
                    Editable text = editText.getText();
                    if (text != null) {
                        text.clear();
                    }
                    dVar.q();
                    break;
                }
                break;
            case 1:
                ((k) obj).u();
                break;
            case 2:
                v vVar = (v) obj;
                EditText editText2 = vVar.f11108f;
                if (editText2 != null) {
                    int selectionEnd = editText2.getSelectionEnd();
                    EditText editText3 = vVar.f11108f;
                    if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        vVar.f11108f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    } else {
                        vVar.f11108f.setTransformationMethod(null);
                    }
                    if (selectionEnd >= 0) {
                        vVar.f11108f.setSelection(selectionEnd);
                    }
                    vVar.q();
                    break;
                }
                break;
            default:
                GlobalKt.setOnClickListener$lambda$0((Function1) obj, view);
                break;
        }
    }
}
