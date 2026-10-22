package com.google.android.material.textfield;

import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
public final class e extends o {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f11011e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(n nVar, int i4) {
        super(nVar);
        this.f11011e = i4;
    }

    @Override // com.google.android.material.textfield.o
    public final void r() {
        switch (this.f11011e) {
            case 0:
                n nVar = this.f11058b;
                nVar.f11049o = null;
                CheckableImageButton checkableImageButton = nVar.f11041g;
                checkableImageButton.setOnLongClickListener(null);
                com.stepos.statsrpk.c.N(checkableImageButton, null);
                break;
        }
    }
}
