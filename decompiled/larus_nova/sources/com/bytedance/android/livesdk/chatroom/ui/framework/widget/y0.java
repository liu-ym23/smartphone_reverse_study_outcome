package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.plugin_api.LivePluginSPIManager;

/* JADX INFO: loaded from: classes8.dex */
public final class y0 implements LivePluginSPIManager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenLinkTriggerWidget f113537a;

    @Override // com.bytedance.android.live.plugin_api.LivePluginSPIManager.a
    public final void afterReady() {
        this.f113537a.wq();
    }

    public y0(ScreenLinkTriggerWidget r100) {
        this.f113537a = r100;
    }
}
