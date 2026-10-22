package com.bytedance.android.livesdk.interactivity.chatchannel.toolbar;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelWidgetManager f134397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f134398b;

    public e(ChatChannelWidgetManager r100, f r101) {
        this.f134397a = r100;
        this.f134398b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        s22.e r100 = this.f134397a.f134379c;
        if (r100 == null) goto L6;
        r100.removeListener(this.f134398b);
        return;
    }
}
