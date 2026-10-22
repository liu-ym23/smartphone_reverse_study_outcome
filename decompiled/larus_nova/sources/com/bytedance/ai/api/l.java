package com.bytedance.ai.api;

/* JADX INFO: loaded from: classes43.dex */
public final class l implements f09.a.b {
    public l() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppForeground() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        AppsInstalledStatusUtils.a("com.ss.android.ugc.aweme", new j());
        AppsInstalledStatusUtils.a("com.luna.music", new k());
    }
}
