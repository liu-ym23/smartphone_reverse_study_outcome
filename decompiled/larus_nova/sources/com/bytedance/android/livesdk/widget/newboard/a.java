package com.bytedance.android.livesdk.widget.newboard;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.expression.j;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f161872a;

    public a(c r100) {
        this.f161872a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        j r101 = this.f161872a.f161884j.getOnCommentSendDelegate().getValue();
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
