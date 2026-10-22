package com.bytedance.android.livesdk.chatroom.newcontainer.business.saas;

import com.bytedance.android.livesdk.chatroom.widget.SlideGuideView;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements SlideGuideView.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f107556a;

    public g(h r100) {
        this.f107556a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.SlideGuideView.e
    public final void onClick() {
        this.f107556a.run();
    }
}
