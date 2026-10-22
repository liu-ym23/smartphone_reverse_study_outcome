package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes46.dex */
public final class p implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExplainCardTitleEditorDialog f84443a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public p(ExplainCardTitleEditorDialog r100) {
        this.f84443a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        ExplainCardTitleEditorDialog r101 = this.f84443a;
        if (r100 == null) goto L6;
        String r102 = r100.toString();
        if (r102 == null) goto L6;
    L7:
        int r103 = ExplainCardTitleEditorDialog.f84410k;
        r101.V90(r102);
        return;
    L6:
        r102 = "";
        goto L7
    }
}
