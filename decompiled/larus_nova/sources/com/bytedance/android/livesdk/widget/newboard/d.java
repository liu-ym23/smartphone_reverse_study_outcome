package com.bytedance.android.livesdk.widget.newboard;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.expression.j;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f161889a;

    public d(f r100) {
        this.f161889a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        j r101 = this.f161889a.f161896f.getOnCommentSendDelegate().getValue();
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
