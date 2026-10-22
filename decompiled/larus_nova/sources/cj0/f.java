package cj0;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f23916a;

    public f(Context r100) {
        this.f23916a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Context r102 = this.f23916a;
        if (h.a() == true) goto L5;
        h.b(r102, "");
    L5:
        r100.dismiss();
    }
}
