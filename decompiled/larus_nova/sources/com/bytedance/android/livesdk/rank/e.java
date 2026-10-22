package com.bytedance.android.livesdk.rank;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f156961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f156962b;

    public e(Function1 r100, int r101) {
        this.f156961a = r100;
        this.f156962b = r101;
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        Function1 r102 = this.f156961a;
        if (r102 == null) goto L7;
        Void r103 = (Void) r102.invoke(Integer.valueOf(this.f156962b));
        return true;
    L7:
        return true;
    }
}
