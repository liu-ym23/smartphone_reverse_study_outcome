package com.bytedance.android.livesdk.dslservice.slice;

import com.bytedance.android.ecom.arch.slice.render.r;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.q;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f122919a;

    public a() {
    }

    public final synchronized b a(q r100, r r101, yt1.r r102, Function2<? super q, ? super k, Unit> r103) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r101, "sliceView");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r103, "onRelease");     // Catch: Throwable -> L10
        b r104 = this.f122919a;     // Catch: Throwable -> L10
        if (r104 == null) goto L7;
        monitor-exit(this);
        return r104;
    L7:
        int r105 = b.f122923g;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r101, "sliceView");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r103, "onRelease");     // Catch: Throwable -> L10
        b r106 = new b(r101, r100);     // Catch: Throwable -> L10
        r106.f122817a = r103;     // Catch: Throwable -> L10
        r106.f122924c = r102;     // Catch: Throwable -> L10
        this.f122919a = r106;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r106;
    L10:
        th = move-exception;
        throw th;
    }
}
