package stepos.support.v7.app;

import android.content.DialogInterface;

/* loaded from: classes4.dex */
public final class N implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6230a;
    public final /* synthetic */ Ua.e b;
    public final /* synthetic */ S c;

    public /* synthetic */ N(S s5, Ua.e eVar, int i) {
        this.f6230a = i;
        this.c = s5;
        this.b = eVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f6230a) {
            case 0:
                Ua.e eVar = this.b;
                boolean zIsChecked = eVar.getCheckBox().isChecked();
                eVar.getItemCheckedMap();
                P p = this.c.f6235j;
                if (p != null) {
                    p.onPermissionClick(dialogInterface, zIsChecked, true);
                    break;
                }
                break;
            default:
                Ua.e eVar2 = this.b;
                boolean zIsChecked2 = eVar2.getCheckBox().isChecked();
                eVar2.getItemCheckedMap();
                P p3 = this.c.f6235j;
                if (p3 != null) {
                    p3.onPermissionClick(dialogInterface, zIsChecked2, false);
                    break;
                }
                break;
        }
    }
}
