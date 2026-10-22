package am4;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.dux.stepper.DuxSteppers;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxSteppers f4389a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public e(DuxSteppers r100) {
        this.f4389a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toString();
    L5:
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        this.f4389a.getOnValueChangeListener();
    L13:
        DuxSteppers r103 = this.f4389a;
        int r104 = DuxSteppers.f205659l;
        r103.S5();
        return;
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r102 = false;
        goto L11
    L4:
        r101 = null;
        goto L5
    }
}
