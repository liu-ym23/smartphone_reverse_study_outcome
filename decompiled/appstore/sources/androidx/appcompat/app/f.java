package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: loaded from: classes.dex */
public class f extends DialogFragment {
    public f() {
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r10) {
        return new e(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog r10, int r11) {
        if ((r10 instanceof e) == false) goto L13;
        e r12 = (e) r10;
        if (r11 != 1) goto L7;
    L12:
        r12.supportRequestWindowFeature(1);
        return;
    L7:
        if (r11 == 2) goto L12;
        if (r11 != 3) goto L16;
        r10.getWindow().addFlags(24);
        goto L12
    L16:
        return;
    L13:
        super.setupDialog(r10, r11);
    }
}
