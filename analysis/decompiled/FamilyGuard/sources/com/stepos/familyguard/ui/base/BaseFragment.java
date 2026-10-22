package com.stepos.familyguard.ui.base;

import android.content.Context;
import androidx.fragment.app.ComponentCallbacksC0511f;

/* loaded from: classes.dex */
public abstract class BaseFragment extends ComponentCallbacksC0511f {
    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void S0() {
        super.S0();
        V1((Q().getConfiguration().uiMode & 48) == 32);
    }

    protected void U1(stepos.support.v7.app.a aVar) {
    }

    public void V1(boolean z5) {
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void s0(Context context) {
        a aVar;
        super.s0(context);
        if (!(q() instanceof a) || (aVar = (a) q()) == null) {
            return;
        }
        U1(aVar.getSupportActionBar());
    }
}
