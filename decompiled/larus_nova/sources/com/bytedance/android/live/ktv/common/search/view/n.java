package com.bytedance.android.live.ktv.common.search.view;

import android.view.View;
import android.widget.EditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSearchEnterView f70317a;

    public n(CommonSearchEnterView r100) {
        this.f70317a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        EditText r101 = CommonSearchEnterView.b(this.f70317a);
        if (r101 == null) goto L5;
        r101.setText(null);
    L5:
        this.f70317a.e();
        Function0<Unit> r102 = this.f70317a.f70281t;
        if (r102 == null) goto L9;
        Unit r103 = r102.invoke();
        return;
    }
}
