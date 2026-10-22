package com.bytedance.ai.resource;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements a.InterfaceC0711a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f37294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f37295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Continuation<Boolean> f37296c;

    @Override // com.bytedance.ai.resource.a.InterfaceC0711a
    public final void a() {
    }

    @Override // com.bytedance.ai.resource.a.InterfaceC0711a
    public final void onFailed() {
        com.bytedance.ai.utils.g.f37637a.i("AIPackageManager", "url: " + this.f37294a + ", path: " + this.f37295b + " ===> download failed");
        Continuation<Boolean> r100 = this.f37296c;
        Result.Companion r101 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
    }

    @Override // com.bytedance.ai.resource.a.InterfaceC0711a
    public final void onSuccess() {
        com.bytedance.ai.utils.g.f37637a.i("AIPackageManager", "url: " + this.f37294a + ", path: " + this.f37295b + " ===> download successful");
        Continuation<Boolean> r100 = this.f37296c;
        Result.Companion r101 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(Boolean.TRUE));
    }

    public b(String r100, String r101, SafeContinuation r102) {
        this.f37294a = r100;
        this.f37295b = r101;
        this.f37296c = r102;
    }
}
