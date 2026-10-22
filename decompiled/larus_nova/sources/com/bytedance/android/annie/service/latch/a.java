package com.bytedance.android.annie.service.latch;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.ies.web.jsbridge2.d0;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements ILatchService {

    /* JADX INFO: renamed from: com.bytedance.android.annie.service.latch.a$a, reason: collision with other inner class name */
    public static final class C0747a implements ILatchService.e {
        public C0747a() {
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
        }

        @Override // com.bytedance.android.annie.service.latch.ILatchService.e
        public final void f(d0 r100) {
            Intrinsics.checkNotNullParameter(r100, "jsBridge2");
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return true;
        }
    }

    public a() {
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final boolean O0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return false;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void Q0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final String R0(View r100) {
        return null;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void S0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final boolean c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return false;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final int d1(Context r100, String r101, Uri r102, ILatchService.d r103) {
        Intrinsics.checkNotNullParameter(r102, "schema");
        Intrinsics.checkNotNullParameter(r103, "latchProcessOptions");
        return -1;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final String i(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        return null;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void initPrefetch() {
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void s(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final Pair<ILatchService.PrefetchStrategy, String> k(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "url");
        return new Pair(ILatchService.PrefetchStrategy.Nothing, "annie is not ready.");
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final ILatchService.d e(long r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "display");
        Intrinsics.checkNotNullParameter(r102, "errMsg");
        return new ILatchService.d();
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final ILatchService.e u0(Context r100, String r101, Uri r102, long r103, ILatchService.d r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r102, "schema");
        Intrinsics.checkNotNullParameter(r104, "latchProcessOptions");
        return new C0747a();
    }
}
