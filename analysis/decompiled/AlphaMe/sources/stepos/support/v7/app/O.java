package stepos.support.v7.app;

import android.content.DialogInterface;

/* loaded from: classes2.dex */
public final class O implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14328a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ K3.e f14329b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ U f14330c;

    public /* synthetic */ O(U u4, K3.e eVar, int i4) {
        this.f14328a = i4;
        this.f14330c = u4;
        this.f14329b = eVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        int i5 = this.f14328a;
        U u4 = this.f14330c;
        K3.e eVar = this.f14329b;
        switch (i5) {
            case 0:
                boolean zIsChecked = eVar.getCheckBox().isChecked();
                eVar.getItemCheckedMap();
                S s4 = u4.f14346j;
                if (s4 != null) {
                    s4.onPermissionClick(dialogInterface, zIsChecked, true);
                    break;
                }
                break;
            default:
                boolean zIsChecked2 = eVar.getCheckBox().isChecked();
                eVar.getItemCheckedMap();
                S s5 = u4.f14346j;
                if (s5 != null) {
                    s5.onPermissionClick(dialogInterface, zIsChecked2, false);
                    break;
                }
                break;
        }
    }
}
