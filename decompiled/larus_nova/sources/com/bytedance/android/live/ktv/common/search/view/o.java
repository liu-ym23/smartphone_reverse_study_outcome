package com.bytedance.android.live.ktv.common.search.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes45.dex */
public final class o implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSearchEnterView f70318a;

    public o(CommonSearchEnterView r100) {
        this.f70318a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101 != null) goto L5;
    L15:
        if (r101 != null) goto L17;
        return false;
    L17:
        if (r101.getAction() != 0) goto L26;
        EditText r102 = CommonSearchEnterView.b(this.f70318a);
        if (r102 == null) goto L27;
        r102.setCursorVisible(true);
        return false;
    L27:
        return false;
    L26:
        return false;
    L5:
        if (r101.getAction() != 1) goto L15;
        CommonSearchEnterView r103 = this.f70318a;
        int r104 = CommonSearchEnterView.f70261v;
        if (r103.f70264c == 1) goto L9;
        r103.i(1);
    L9:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r105 = r103.f70278q;
        if (r105 == null) goto L12;
        r105.syncHotWords();
    L12:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r106 = r103.f70278q;
        if (r106 == null) goto L23;
        r106.loadSearchHistory();
        return false;
    L23:
        return false;
    }
}
