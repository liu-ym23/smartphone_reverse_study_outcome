package androidx.core.view.autofill;

import android.view.autofill.AutofillId;

/* JADX INFO: loaded from: classes17.dex */
public class AutofillIdCompat {
    private final Object mWrappedObj;

    public AutofillId toAutofillId() {
        return (AutofillId) this.mWrappedObj;
    }

    private AutofillIdCompat(AutofillId r100) {
        this.mWrappedObj = r100;
    }

    public static AutofillIdCompat toAutofillIdCompat(AutofillId r100) {
        return new AutofillIdCompat(r100);
    }
}
