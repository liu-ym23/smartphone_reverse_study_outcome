package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableLiveData f115833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Observer f115834b;

    public h(MutableLiveData r100, i r101) {
        this.f115833a = r100;
        this.f115834b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        MutableLiveData r100 = this.f115833a;
        if (r100 == null) goto L6;
        r100.removeObserver(this.f115834b);
        return;
    }
}
