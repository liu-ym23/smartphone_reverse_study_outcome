package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* renamed from: androidx.fragment.app.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnCancelListenerC0292n implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f3785a;

    public DialogInterfaceOnCancelListenerC0292n(r rVar) {
        this.f3785a = rVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        r rVar = this.f3785a;
        Dialog dialog = rVar.f3820l;
        if (dialog != null) {
            rVar.onCancel(dialog);
        }
    }
}
