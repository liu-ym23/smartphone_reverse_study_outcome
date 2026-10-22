package com.bytedance.ai.view.popup;

import androidx.fragment.app.FragmentTransaction;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f37902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentTransaction f37903b;

    public /* synthetic */ f(String r100, FragmentTransaction r101) {
        this.f37902a = r100;
        this.f37903b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f37902a;
        FragmentTransaction r101 = this.f37903b;
        int r102 = AppletPopup.R;
        if (r100 != null) goto L10;
    L5:
        r101.commitAllowingStateLoss();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("AppletPopup", "commitNowAllowingStateLossSafely", th);
        return;
    L10:
        r101.addToBackStack(r100);     // Catch: Throwable -> L7
        goto L5
    }
}
