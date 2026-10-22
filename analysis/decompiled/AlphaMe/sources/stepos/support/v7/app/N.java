package stepos.support.v7.app;

import android.content.DialogInterface;

/* loaded from: classes2.dex */
public final class N implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ K3.e f14326a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ U f14327b;

    public N(U u4, K3.e eVar) {
        this.f14327b = u4;
        this.f14326a = eVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        K3.e eVar = this.f14326a;
        boolean zIsChecked = eVar.getCheckBox().isChecked();
        eVar.getItemCheckedMap();
        S s4 = this.f14327b.f14346j;
        if (s4 == null) {
            return;
        }
        s4.onPermissionClick(dialogInterface, zIsChecked, false);
    }
}
