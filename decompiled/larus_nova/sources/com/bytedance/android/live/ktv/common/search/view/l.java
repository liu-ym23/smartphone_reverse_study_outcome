package com.bytedance.android.live.ktv.common.search.view;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes45.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSearchEnterView f70315a;

    public l(CommonSearchEnterView r100) {
        this.f70315a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CommonSearchEnterView r101 = this.f70315a;
        EditText r102 = CommonSearchEnterView.b(r101);
        if (r102 == null) goto L8;
        Editable r103 = r102.getText();
        if (r103 == null) goto L8;
        String r104 = r103.toString();
        if (r104 == null) goto L8;
    L9:
        r101.h(r104, "ugc", false);
        return;
    L8:
        r104 = "";
        goto L9
    }
}
