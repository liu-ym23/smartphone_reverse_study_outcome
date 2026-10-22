package com.stepos.familyguard.ui.widget;

import C2.b;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import androidx.preference.l;

/* loaded from: classes.dex */
public class ListPreference extends androidx.preference.ListPreference {

    /* renamed from: e0, reason: collision with root package name */
    private int f15176e0;

    /* renamed from: f0, reason: collision with root package name */
    private b f15177f0;

    public ListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(DialogInterface dialogInterface, int i5) {
        this.f15176e0 = i5;
        if (i5 >= 0 && Y0() != null) {
            String string = a1()[this.f15176e0].toString();
            if (d(string)) {
                f1(string);
            }
        }
        dialogInterface.dismiss();
    }

    @Override // androidx.preference.Preference
    public void W(l lVar) {
        super.W(lVar);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void X() {
        b bVar = new b(l());
        this.f15177f0 = bVar;
        bVar.y(I()).w(Y0(), X0(b1()), new DialogInterface.OnClickListener() { // from class: x2.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f23801a.h1(dialogInterface, i5);
            }
        });
        this.f15177f0.c().show();
    }

    public ListPreference(Context context) {
        this(context, null);
    }
}
