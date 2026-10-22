package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;

/* loaded from: classes2.dex */
public class k extends androidx.appcompat.view.menu.e {
    public k(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) a(i10, i11, i12, charSequence);
        m mVar = new m(w(), this, gVar);
        gVar.x(mVar);
        return mVar;
    }
}
