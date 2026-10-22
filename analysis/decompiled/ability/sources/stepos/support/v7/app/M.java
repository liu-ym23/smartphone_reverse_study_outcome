package stepos.support.v7.app;

import android.content.DialogInterface;

/* loaded from: classes4.dex */
public final class M implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ua.e f6229a;
    public final /* synthetic */ S b;

    public M(S s5, Ua.e eVar) {
        this.b = s5;
        this.f6229a = eVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Ua.e eVar = this.f6229a;
        boolean zIsChecked = eVar.getCheckBox().isChecked();
        eVar.getItemCheckedMap();
        P p = this.b.f6235j;
        if (p == null) {
            return;
        }
        p.onPermissionClick(dialogInterface, zIsChecked, false);
    }
}
