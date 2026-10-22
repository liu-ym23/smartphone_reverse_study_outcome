package com.google.android.material.textfield;

import ca.AbstractC0897f;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes3.dex */
public final class d extends n {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(m mVar, int i) {
        super(mVar);
        this.e = i;
    }

    @Override // com.google.android.material.textfield.n
    public void r() {
        switch (this.e) {
            case 0:
                m mVar = this.b;
                mVar.o = null;
                CheckableImageButton checkableImageButton = mVar.g;
                checkableImageButton.setOnLongClickListener(null);
                AbstractC0897f.J(checkableImageButton, null);
                break;
        }
    }
}
