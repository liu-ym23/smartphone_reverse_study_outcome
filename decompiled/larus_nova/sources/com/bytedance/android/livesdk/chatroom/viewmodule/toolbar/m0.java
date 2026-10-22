package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m0 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0.c f116481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0.f f116482b;

    public m0(i0.c r100, i0.g r101) {
        this.f116481a = r100;
        this.f116482b = r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r101, "path");
        i0.c r102 = this.f116481a;
        r102.f116338c = r101;
        r102.f116337b = true;
        r102.getClass();
        this.f116482b.onFinish();
        i0.f116328e.getClass();
        ((ArrayList) i0.f116327d).add(r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a
    public final void onFail(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r101, "path");
        this.f116481a.f116337b = true;
        this.f116482b.onFinish();
    }
}
