package com.google.android.material.datepicker;

import K.C0069b;
import android.view.View;
import com.stepos.alphame.R;

/* renamed from: com.google.android.material.datepicker.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0434m extends C0069b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10694a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10695b;

    public /* synthetic */ C0434m(int i4, Object obj) {
        this.f10694a = i4;
        this.f10695b = obj;
    }

    @Override // K.C0069b
    public final void onInitializeAccessibilityNodeInfo(View view, L.g gVar) {
        switch (this.f10694a) {
            case 0:
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                gVar.f1142a.setCollectionInfo(null);
                break;
            case 1:
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                gVar.h(false);
                break;
            case 2:
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                s sVar = (s) this.f10695b;
                gVar.b(new L.b(16, sVar.f10717n.getVisibility() == 0 ? sVar.getString(R.string.mtrl_picker_toggle_to_year_selection) : sVar.getString(R.string.mtrl_picker_toggle_to_day_selection)));
                break;
            default:
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                gVar.f1142a.setCollectionInfo(null);
                break;
        }
    }
}
