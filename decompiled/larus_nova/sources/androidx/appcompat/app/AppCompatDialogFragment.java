package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatDialogFragment extends DialogFragment {
    public AppCompatDialogFragment() {
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r100) {
        return new AppCompatDialog(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog r100, int r101) {
        if ((r100 instanceof AppCompatDialog) == false) goto L13;
        AppCompatDialog r102 = (AppCompatDialog) r100;
        if (r101 != 1) goto L7;
    L12:
        r102.supportRequestWindowFeature(1);
        return;
    L7:
        if (r101 == 2) goto L12;
        if (r101 != 3) goto L16;
        r100.getWindow().addFlags(24);
        goto L12
    L16:
        return;
    L13:
        super.setupDialog(r100, r101);
    }
}
