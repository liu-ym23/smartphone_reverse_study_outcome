package com.bytedance.android.live.ktv.common.search.view;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes45.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSearchEnterView f70316a;

    public m(CommonSearchEnterView r100) {
        this.f70316a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        EditText r101 = CommonSearchEnterView.b(this.f70316a);
        if (r101 == null) goto L5;
        r101.setText(null);
    L5:
        EditText r102 = CommonSearchEnterView.b(this.f70316a);
        if (r102 == null) goto L8;
        r102.setCursorVisible(true);
    L8:
        this.f70316a.f();
        this.f70316a.i(1);
    }
}
