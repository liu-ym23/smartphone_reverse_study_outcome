package com.bytedance.android.live.profile.ui.component;

import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.utils.a1;

/* JADX INFO: loaded from: classes47.dex */
public final class x implements a1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f86918a;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a1.c
    public final void onFail() {
    }

    public x(View r100) {
        this.f86918a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a1.c
    public final void a(NinePatchDrawable r100) {
        this.f86918a.setBackgroundDrawable(r100);
    }
}
