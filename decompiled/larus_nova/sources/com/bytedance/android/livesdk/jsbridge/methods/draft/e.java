package com.bytedance.android.livesdk.jsbridge.methods.draft;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Integer, Unit> f142078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f142079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Throwable, Unit> f142080c;

    public e(int r100) {
        RealDownloadListener$1 r101 = RealDownloadListener$1.INSTANCE;
        RealDownloadListener$2 r102 = RealDownloadListener$2.INSTANCE;
        RealDownloadListener$3 r103 = RealDownloadListener$3.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "onProgress");
        Intrinsics.checkNotNullParameter(r102, "onFinish");
        Intrinsics.checkNotNullParameter(r103, "onFail");
        this.f142078a = r101;
        this.f142079b = r102;
        this.f142080c = r103;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.a
    public final void a(Function1<? super Throwable, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f142080c = r100;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.a
    public final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f142079b = r100;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.a
    public final void c(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f142078a = r100;
    }
}
