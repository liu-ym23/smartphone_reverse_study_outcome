package com.bytedance.android.marketing.sdk.impl.data;

import android.view.KeyEvent;
import android.view.View;
import com.bytedance.android.marketing.sdk.impl.actions.p;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompDataWrapper f162791a;

    public c(CompDataWrapper r100, p r101) {
        this.f162791a = r100;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r100, int r101, KeyEvent r102) {
        if (r101 == 4) goto L5;
        return false;
    L5:
        if (r102.getAction() != 1) goto L10;
        this.f162791a.c();
        return true;
    L10:
        return false;
    }
}
