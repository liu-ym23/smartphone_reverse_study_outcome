package com.bytedance.android.gamecp.hybrid_impl.lynx;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class t1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridCardRecyclePool f57652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f57653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f57654c;

    public t1(HybridCardRecyclePool r100, Context r101, Map r102) {
        this.f57652a = r100;
        this.f57653b = r101;
        this.f57654c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Disposable r102 = this.f57652a.f57573g;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        Context r103 = this.f57653b;
        if ((r103 instanceof AppCompatActivity) == true) goto L8;
        r103 = null;
    L8:
        AppCompatActivity r104 = (AppCompatActivity) r103;
        if (r104 != null) goto L11;
    L19:
        HybridCardRecyclePool r105 = this.f57652a;
        if (r105.f57568b != null) goto L25;
        Context r106 = this.f57653b;
        r105.getClass();
        HybridCardRecyclePool.b(r105, r106, HybridCardRecyclePool.c(), this.f57654c);
        return;
    L25:
        return;
    L11:
        if (r104.isFinishing() == false) goto L13;
    L16:
        boolean r107 = true;
    L17:
        if (r107 != true) goto L19;
        return;
    L13:
        if (r104.isDestroyed() == true) goto L16;
        r107 = false;
        goto L17
    }
}
