package stepos.support.v7.app;

import android.content.DialogInterface;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class c0 implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12290c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ se.d f12291f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ h0 f12292g;

    public /* synthetic */ c0(int i) {
        this.f12290c = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f12290c) {
            case 0:
                h0 h0Var = this.f12292g;
                se.d dVar = this.f12291f;
                boolean zIsChecked = dVar.getCheckBox().isChecked();
                dVar.getItemCheckedMap();
                f0 f0Var = h0Var.f12328j;
                if (f0Var != null) {
                    f0Var.onPermissionClick(dialogInterface, zIsChecked, true);
                    break;
                }
                break;
            default:
                h0 h0Var2 = this.f12292g;
                se.d dVar2 = this.f12291f;
                boolean zIsChecked2 = dVar2.getCheckBox().isChecked();
                dVar2.getItemCheckedMap();
                f0 f0Var2 = h0Var2.f12328j;
                if (f0Var2 != null) {
                    f0Var2.onPermissionClick(dialogInterface, zIsChecked2, false);
                    break;
                }
                break;
        }
    }
}
