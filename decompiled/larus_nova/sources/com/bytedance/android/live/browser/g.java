package com.bytedance.android.live.browser;

import com.lynx.tasm.LynxViewBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements d8.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f62638a;

    public g(w r100) {
        this.f62638a = r100;
    }

    @Override // d8.f
    public final void b(LynxViewBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f62638a.setEnableJSRuntime(r100, false);
    }

    @Override // d8.f
    public final void a(LynxViewBuilder r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f62638a.setEnableUserCodeCache(r100, true, r101);
    }
}
