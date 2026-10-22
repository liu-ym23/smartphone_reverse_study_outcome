package com.bytedance.android.monitorV2.webview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i implements sz2.a.InterfaceC7672a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewDataManager f163355a;

    public i(WebViewDataManager r100) {
        this.f163355a = r100;
    }

    @Override // sz2.a.InterfaceC7672a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        WebViewDataManager r101 = this.f163355a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f163288d = r100;
    }
}
