package com.bytedance.android.livesdk.utils;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j3<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f158995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n4 f158996b;

    public j3(String r100, n4 r101) {
        this.f158995a = r100;
        this.f158996b = r101;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<vl2.m> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L12
        r101.append(this.f158995a);     // Catch: Throwable -> L12
        this.f158996b.b();     // Catch: Throwable -> L12
        r101.append("lottie");     // Catch: Throwable -> L12
        String r102 = r101.toString();     // Catch: Throwable -> L12
        this.f158996b.a();     // Catch: Throwable -> L12
        vl2.m r103 = vl2.f.a(r102, 0);     // Catch: Throwable -> L12
        if ((r103 instanceof vl2.m) == true) goto L8;
        r103 = null;
    L8:
        if (r103 == null) goto L10;
        r100.onSuccess(r103);     // Catch: Throwable -> L12
    L15:
        return;
    L10:
        r100.tryOnError(new Exception("lottie resource entity is null"));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r100.tryOnError(th);
    }
}
