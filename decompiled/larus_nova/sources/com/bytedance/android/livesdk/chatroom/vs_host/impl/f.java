package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements vr1.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.expression.b f118296a;

    public final View b() {
        return ((com.bytedance.android.livesdk.widget.newboard.f) this.f118296a).getView();
    }

    public f(com.bytedance.android.livesdk.interactivity.api.expression.b r100) {
        Intrinsics.checkNotNullParameter(r100, "realExpressionBoard");
        this.f118296a = r100;
    }

    @Override // vr1.f
    public final void a(boolean r100) {
        com.bytedance.android.livesdk.widget.newboard.f r101 = (com.bytedance.android.livesdk.widget.newboard.f) this.f118296a;
        r101.getClass();
        if (r100 == false) goto L5;
        float r102 = 1.0f;
    L6:
        ImageView r103 = (ImageView) r101.a(R.id.emoji_delete_btn);
        if (r103 == null) goto L9;
        r103.setEnabled(r100);
        r103.setAlpha(r102);
    L9:
        TextView r104 = (TextView) r101.a(R.id.emoji_send_btn);
        if (r104 == null) goto L13;
        r104.setEnabled(r100);
        r104.setAlpha(r102);
        return;
    L13:
        return;
    L5:
        r102 = 0.34f;
        goto L6
    }
}
