package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableLiveData f115836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Observer f115837b;

    public j(MutableLiveData r100, k r101) {
        this.f115836a = r100;
        this.f115837b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        MutableLiveData r100 = this.f115836a;
        if (r100 == null) goto L6;
        r100.removeObserver(this.f115837b);
        return;
    }
}
