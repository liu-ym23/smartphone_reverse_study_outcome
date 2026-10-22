package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes9.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j.b f137319a;

    public n(j.b r100) {
        this.f137319a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        KeyEvent r101 = new KeyEvent(0, 67);
        k82.a r102 = this.f137319a.f137314n.f137299a;
        if (r102 == null) goto L8;
        EditText r103 = r102.f502082a;
        if (r103 == null) goto L9;
        r103.dispatchKeyEvent(r101);
        return;
    L9:
        return;
    }
}
