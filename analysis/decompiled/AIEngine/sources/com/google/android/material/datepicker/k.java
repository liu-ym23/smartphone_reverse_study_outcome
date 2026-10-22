package com.google.android.material.datepicker;

import android.content.Intent;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager.n;
import com.stepos.aiengine.modelmanager.ModelManagerActivity;
import com.stepos.aiengine.modelmanager.settings.AiEngineSettingsActivity;
import com.stepos.aiengine.modelmanager.settings.ModelManagerSettingsActivity;
import com.stepos.common.widget.Switch;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4969a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4970b;

    public /* synthetic */ k(Object obj, int i10) {
        this.f4969a = i10;
        this.f4970b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f4969a;
        Object obj = this.f4970b;
        switch (i10) {
            case 0:
                ((MaterialDatePicker) obj).onPositiveButtonClick(view);
                break;
            case 1:
                com.google.android.material.textfield.c cVar = (com.google.android.material.textfield.c) obj;
                EditText editText = cVar.f5238i;
                if (editText != null) {
                    Editable text = editText.getText();
                    if (text != null) {
                        text.clear();
                    }
                    cVar.p();
                    break;
                }
                break;
            case 2:
                ((com.google.android.material.textfield.j) obj).t();
                break;
            case 3:
                com.google.android.material.textfield.s sVar = (com.google.android.material.textfield.s) obj;
                EditText editText2 = sVar.f5331f;
                if (editText2 != null) {
                    int selectionEnd = editText2.getSelectionEnd();
                    EditText editText3 = sVar.f5331f;
                    if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        sVar.f5331f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    } else {
                        sVar.f5331f.setTransformationMethod(null);
                    }
                    if (selectionEnd >= 0) {
                        sVar.f5331f.setSelection(selectionEnd);
                    }
                    sVar.p();
                    break;
                }
                break;
            case 4:
                ((Switch) obj).toggle();
                break;
            case 5:
                ModelManagerActivity modelManagerActivity = (ModelManagerActivity) obj;
                boolean z = ModelManagerActivity.f5846t;
                Intent intent = new Intent("com.stepos.aiengine.action.MODEL_MANAGER_SETTINGS");
                intent.setPackage("com.stepos.aiengine");
                intent.setClassName("com.stepos.aiengine", ModelManagerSettingsActivity.class.getName());
                intent.putExtra("com.stepos.aiengine.extra.CALLER_PACKAGE", modelManagerActivity.getPackageName());
                modelManagerActivity.startActivity(intent);
                break;
            case 6:
                AiEngineSettingsActivity aiEngineSettingsActivity = (AiEngineSettingsActivity) obj;
                int i11 = AiEngineSettingsActivity.f5904d;
                ArrayList<androidx.fragment.app.a> arrayList = aiEngineSettingsActivity.getSupportFragmentManager().f2016d;
                if ((arrayList != null ? arrayList.size() : 0) <= 0) {
                    aiEngineSettingsActivity.finish();
                    break;
                } else {
                    FragmentManager supportFragmentManager = aiEngineSettingsActivity.getSupportFragmentManager();
                    supportFragmentManager.getClass();
                    supportFragmentManager.v(supportFragmentManager.new n(-1, 0), false);
                    break;
                }
            default:
                int i12 = ModelManagerSettingsActivity.f5907b;
                ((ModelManagerSettingsActivity) obj).finish();
                break;
        }
    }
}
