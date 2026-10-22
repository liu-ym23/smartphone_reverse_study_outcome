package com.bytedance.android.shopping.card_list.service;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListPostFrameTask implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f171745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f171746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f171747c;

    public CardListPostFrameTask(Function0 r100) {
        this.f171747c = r100;
        this.f171746b = new Handler(Looper.getMainLooper());
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        boolean r101 = true;
        int r102 = this.f171745a + 1;
        this.f171745a = r102;
        if (r102 != 1) goto L7;
        Function0<Unit> r103 = this.f171747c;
        if (r103 == null) goto L15;
        Unit r104 = r103.invoke();
        return;
    L15:
        return;
    L7:
        Function0<Unit> r105 = new AnonymousClass1(this);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L11;
        r101 = false;
    L11:
        if (r101 == false) goto L13;
        r105.invoke();
        return;
    L13:
        this.f171746b.post(new a(r105));
    }
}
