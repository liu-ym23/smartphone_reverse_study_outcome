package com.stepos.alphame.persona.ui;

import android.content.DialogInterface;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11211a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11212b;

    public /* synthetic */ b(int i4, Object obj) {
        this.f11211a = i4;
        this.f11212b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        int i5 = this.f11211a;
        Object obj = this.f11212b;
        switch (i5) {
            case 0:
                PersonalMainFragment.showInfoUpdateDialog$lambda$3((IDialogClickListener) obj, dialogInterface, i4);
                break;
            case 1:
                PersonalMainFragment.showInfoUpdateDialog$lambda$4((IDialogClickListener) obj, dialogInterface, i4);
                break;
            default:
                PersonalMainAdapter.onPreferenceClick$lambda$2$lambda$1((PersonalMainAdapter) obj, dialogInterface, i4);
                break;
        }
    }
}
