package c30;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f22264a;

    public b(Context r100) {
        this.f22264a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        int r102 = c.f22265a;     // Catch: Exception -> L4
        c.a(this.f22264a);     // Catch: Exception -> L4
    L5:
        if (r100 == null) goto L10;
        r100.dismiss();
        return;
    L10:
        return;
    L4:
        this.f22264a.startActivity(new Intent("android.settings.SETTINGS"));
        goto L5
    }
}
