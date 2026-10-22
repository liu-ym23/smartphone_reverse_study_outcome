package com.bytedance.android.livesdk.castscreen.pad.controller;

import com.byted.cast.common.api.ISendResultListener;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements ISendResultListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f104608a;

    @Override // com.byted.cast.common.api.ISendResultListener
    public final /* synthetic */ void onReceive(String r100) {
        ISendResultListener.CC.$default$onReceive(this, r100);
    }

    @Override // com.byted.cast.common.api.ISendResultListener
    public final void onSuccess() {
        nf1.b r100 = (nf1.b) this.f104608a.get();
        if (r100 == null) goto L6;
        r100.onSuccess();
        return;
    }

    public b(WeakReference r100) {
        this.f104608a = r100;
    }

    @Override // com.byted.cast.common.api.ISendResultListener
    public final void onFailure(int r100, String r101) {
        nf1.b r102 = (nf1.b) this.f104608a.get();
        if (r102 == null) goto L6;
        r102.onFailure(r100, r101);
        return;
    }
}
