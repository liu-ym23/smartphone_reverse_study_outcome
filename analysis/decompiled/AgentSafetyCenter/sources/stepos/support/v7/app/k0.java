package stepos.support.v7.app;

import android.content.DialogInterface;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class k0 implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            try {
                dialogInterface.dismiss();
            } catch (Exception unused) {
            }
        }
    }
}
