package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* renamed from: androidx.fragment.app.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnDismissListenerC0293o implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f3791a;

    public DialogInterfaceOnDismissListenerC0293o(r rVar) {
        this.f3791a = rVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        r rVar = this.f3791a;
        Dialog dialog = rVar.f3820l;
        if (dialog != null) {
            rVar.onDismiss(dialog);
        }
    }
}
