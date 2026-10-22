package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectedMsgViewManager f139434a;

    public e(SelectedMsgViewManager r100) {
        this.f139434a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        o42.b r101 = (o42.b) r100;
        SelectedMsgViewManager r102 = this.f139434a;
        if (r102.f139414c == false) goto L7;
        r102.d().onEvent(r101);
        return;
    }
}
