package com.bytedance.android.live.broadcast;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements IHostPlugin.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f58961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f58962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f58963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f58964d = null;

    public a() {
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
    public final void onCancel(String r100) {
    }

    static {
        f58964d = new a();
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
    public final void onSuccess(String r100) {
        if (f58962b == false) goto L5;
        return;
    L5:
        f2.b(R.string.ttlive_audio_comment_loaded, 0);
        f58962b = true;
    }
}
