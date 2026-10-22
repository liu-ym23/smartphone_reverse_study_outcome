package stepos.support.v7.app;

import android.content.DialogInterface;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class b0 implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ se.d f12288a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ h0 f12289b;

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        h0 h0Var = this.f12289b;
        se.d dVar = this.f12288a;
        boolean zIsChecked = dVar.getCheckBox().isChecked();
        dVar.getItemCheckedMap();
        f0 f0Var = h0Var.f12328j;
        if (f0Var == null) {
            return;
        }
        f0Var.onPermissionClick(dialogInterface, zIsChecked, false);
    }
}
