package androidx.preference;

import android.content.DialogInterface;

/* renamed from: androidx.preference.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnMultiChoiceClickListenerC0339k implements DialogInterface.OnMultiChoiceClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0340l f4148a;

    public DialogInterfaceOnMultiChoiceClickListenerC0339k(C0340l c0340l) {
        this.f4148a = c0340l;
    }

    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
    public final void onClick(DialogInterface dialogInterface, int i4, boolean z4) {
        C0340l c0340l = this.f4148a;
        if (z4) {
            c0340l.f4152z |= c0340l.f4151y.add(c0340l.f4150B[i4].toString());
        } else {
            c0340l.f4152z |= c0340l.f4151y.remove(c0340l.f4150B[i4].toString());
        }
    }
}
