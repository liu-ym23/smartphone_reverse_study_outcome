package com.bytedance.android.livesdk.account.impl;

import android.app.Activity;
import com.bytedance.android.livehostapi.platform.IHostDouyinOpenSDKAuth;
import com.bytedance.android.livesdk.account.api.AuthScope;
import com.bytedance.android.livesdk.user.i0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements IHostDouyinOpenSDKAuth.Callback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f103021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f103022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IHostDouyinOpenSDKAuth f103023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AuthScope f103024d;

    @Override // com.bytedance.android.livehostapi.platform.IHostDouyinOpenSDKAuth.Callback
    public final void onFailed(Throwable r100) {
        Activity r101 = this.f103022b;
        if (r101 != null) goto L6;
        od1.a.InterfaceC7035a r102 = this.f103021a.f103013a;
        return;
    L6:
        f r103 = this.f103021a;
        IHostDouyinOpenSDKAuth r104 = this.f103023c;
        AuthScope r105 = this.f103024d;
        r103.getClass();
        f.b(r104, r101, r105);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostDouyinOpenSDKAuth.Callback
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        od1.a.InterfaceC7035a r101 = this.f103021a.f103013a;
        if (r101 == null) goto L6;
        ((i0) r101).a();
        return;
    }

    public h(f r100, Activity r101, IHostDouyinOpenSDKAuth r102, AuthScope r103) {
        this.f103021a = r100;
        this.f103022b = r101;
        this.f103023c = r102;
        this.f103024d = r103;
    }
}
