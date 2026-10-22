package c58;

import android.text.Editable;
import android.text.TextWatcher;
import com.larus.asr.direct.AsrDirectFillComponent;
import com.larus.asr.direct.IAsrDirectFillAbility;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes24.dex */
public final class n implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AsrDirectFillComponent f22502a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public n(AsrDirectFillComponent r100) {
        this.f22502a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        AsrDirectFillComponent r101 = this.f22502a;
        int r102 = AsrDirectFillComponent.A;
        va8.o r103 = (va8.o) r101.f287240k.getValue();
        boolean r104 = false;
        if (r103 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L25;
        AsrDirectFillComponent r106 = this.f22502a;
        IAsrDirectFillAbility.DirectFillStatus r107 = r106.f287250u;
        if (r107 == null) goto L27;
        IAsrDirectFillAbility.DirectFillStatus r108 = IAsrDirectFillAbility.DirectFillStatus.FillBackClear;
        if (r107 == r108) goto L28;
        if (r100 != null) goto L17;
    L18:
        r104 = true;
    L19:
        if (r104 == true) goto L22;
        r108 = IAsrDirectFillAbility.DirectFillStatus.FillBackEdit;
    L22:
        if (r107 == r108) goto L26;
        FLogger.f375446a.i("AsrDirectFillComponent", "directFillStatus changed: " + r107 + " -> " + r108);
        r106.Y2(r108);
        return;
    L26:
        return;
    L17:
        if (r100.length() != 0) goto L19;
    L28:
        return;
    L27:
        return;
    L25:
        return;
    L5:
        if (r103.n5() != true) goto L7;
        r105 = true;
        goto L8
    }
}
