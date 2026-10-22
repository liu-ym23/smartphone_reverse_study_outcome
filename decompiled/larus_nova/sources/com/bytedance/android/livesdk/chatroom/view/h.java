package com.bytedance.android.livesdk.chatroom.view;

import android.view.View;
import com.ss.android.videoshop.mediaview.SimpleMediaView;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f114758a;

    public h(f r100) {
        this.f114758a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SimpleMediaView r101 = this.f114758a.f114745b;
        if (r101 != null) goto L5;
    L7:
        this.f114758a.a(true);
        return;
    L5:
        if (r101.h() != true) goto L7;
        this.f114758a.b();
    }
}
