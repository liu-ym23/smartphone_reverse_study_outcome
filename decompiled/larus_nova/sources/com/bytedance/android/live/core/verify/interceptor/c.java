package com.bytedance.android.live.core.verify.interceptor;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import com.bytedance.android.livesdkapi.ILiveActivityResultListener;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements ILiveActivityResultListener.OnLiveActivityResultListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f66483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t80.a f66484b;

    public c(Activity r100, b r101) {
        this.f66483a = r100;
        this.f66484b = r101;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveActivityResultListener.OnLiveActivityResultListener
    public final void onActivityResult(int r100, int r101, Intent r102) {
        ComponentCallbacks2 r103 = this.f66483a;
        if (r103 == null) goto L19;
        ((ILiveActivityResultListener) r103).setOnLiveActivityResultListener(null);
        if (this.f66484b != null) goto L7;
        return;
    L7:
        if (r101 != (-1)) goto L12;
        if (r102 == null) goto L12;
        if (r102.getIntExtra("key_verify_result", 0) != 3) goto L12;
        this.f66484b.onVerifyResult(3);
        return;
    L12:
        if (r102 != null) goto L14;
    L16:
        this.f66484b.onVerifyResult(0);
        return;
    L14:
        if (r102.getIntExtra("key_verify_result", 0) != 2) goto L16;
        this.f66484b.onVerifyResult(2);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.ILiveActivityResultListener");
    }
}
