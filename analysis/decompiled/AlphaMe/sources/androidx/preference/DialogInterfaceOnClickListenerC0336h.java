package androidx.preference;

import android.content.DialogInterface;

/* renamed from: androidx.preference.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC0336h implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0337i f4142a;

    public DialogInterfaceOnClickListenerC0336h(C0337i c0337i) {
        this.f4142a = c0337i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        C0337i c0337i = this.f4142a;
        c0337i.f4144y = i4;
        c0337i.f4162x = -1;
        dialogInterface.dismiss();
    }
}
