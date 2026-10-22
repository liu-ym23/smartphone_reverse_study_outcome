package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes9.dex */
public final class l0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0.c f135928a;

    public l0(j0.c r100) {
        this.f135928a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        KeyEvent r101 = new KeyEvent(0, 67);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102 = this.f135928a.f135911o.f135895a;
        if (r102 == null) goto L8;
        EditText r103 = r102.f135496a;
        if (r103 == null) goto L9;
        r103.dispatchKeyEvent(r101);
        return;
    L9:
        return;
    }
}
