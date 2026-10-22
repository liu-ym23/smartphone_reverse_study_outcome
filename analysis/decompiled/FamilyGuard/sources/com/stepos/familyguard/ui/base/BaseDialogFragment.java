package com.stepos.familyguard.ui.base;

import androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e;
import androidx.fragment.app.G;
import androidx.fragment.app.x;

/* loaded from: classes.dex */
public abstract class BaseDialogFragment extends DialogInterfaceOnCancelListenerC0510e {
    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e
    public void h2(x xVar, String str) {
        try {
            N1.h.a(DialogInterfaceOnCancelListenerC0510e.class).b("mDismissed").b(this, false);
            N1.h.a(DialogInterfaceOnCancelListenerC0510e.class).b("mShownByMe").b(this, true);
            G gM = xVar.m();
            gM.e(this, str);
            gM.j();
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
        } catch (NoSuchFieldException e7) {
            e7.printStackTrace();
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }
}
