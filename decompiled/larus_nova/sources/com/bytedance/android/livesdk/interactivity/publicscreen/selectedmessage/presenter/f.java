package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectedMsgViewManager f139435a;

    public f(SelectedMsgViewManager r100) {
        this.f139435a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        o42.d r101 = (o42.d) r100;
        SelectedMsgViewManager r102 = this.f139435a;
        if (r102.f139414c == true) goto L6;
        return;
    L6:
        if (r102.d().d() == false) goto L9;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r103 = SelectedMsgViewManager.f139411m;
        Boolean r104 = Boolean.TRUE;
        r103.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r103, r104);
        return;
    }
}
