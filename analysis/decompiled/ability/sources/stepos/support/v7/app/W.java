package stepos.support.v7.app;

import android.content.DialogInterface;

/* loaded from: classes4.dex */
public final class W implements DialogInterface.OnClickListener {
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
