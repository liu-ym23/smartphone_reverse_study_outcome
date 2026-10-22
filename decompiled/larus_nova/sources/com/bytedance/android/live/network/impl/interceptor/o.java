package com.bytedance.android.live.network.impl.interceptor;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import com.bytedance.android.livesdkapi.ILiveActivityResultListener;

/* JADX INFO: loaded from: classes46.dex */
public final class o implements ILiveActivityResultListener.OnLiveActivityResultListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f83889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t80.a f83890b;

    public o(Activity r100, j r101) {
        this.f83889a = r100;
        this.f83890b = r101;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveActivityResultListener.OnLiveActivityResultListener
    public final void onActivityResult(int r100, int r101, Intent r102) {
        ComponentCallbacks2 r103 = this.f83889a;
        if (r103 == null) goto L15;
        ((ILiveActivityResultListener) r103).setOnLiveActivityResultListener(null);
        if (this.f83890b != null) goto L7;
        return;
    L7:
        if (r101 != (-1)) goto L12;
        if (r102 == null) goto L12;
        if (r102.getIntExtra("key_verify_result", 0) != 2) goto L12;
        this.f83890b.onVerifyResult(2);
        return;
    L12:
        this.f83890b.onVerifyResult(0);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.ILiveActivityResultListener");
    }
}
