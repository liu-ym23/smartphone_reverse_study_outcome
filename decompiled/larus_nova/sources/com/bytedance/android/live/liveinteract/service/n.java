package com.bytedance.android.live.liveinteract.service;

import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n implements gd0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataCenter f78615a;

    @Override // gd0.c
    public final void onCancelClick() {
    }

    public n(DataCenter r100) {
        this.f78615a = r100;
    }

    @Override // gd0.c
    public final void a(LiveDialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        DataCenter r101 = this.f78615a;
        if (r101 == null) goto L6;
        r101.put("data_voice_chat_room_close_page", "link_panel");
        return;
    }
}
