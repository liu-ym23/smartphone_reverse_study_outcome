package bn5;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaPickerFragment;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormulaPickerFragment f19759a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public m(FormulaPickerFragment r100) {
        this.f19759a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        FormulaPickerFragment r101 = this.f19759a;
        if (r100 == null) goto L5;
        String r102 = r100.toString().trim();
    L6:
        r101.f237997n = r102;
        this.f19759a.aa0();
        return;
    L5:
        r102 = "";
        goto L6
    }
}
