package com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel;

import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.room.controller.l;
import com.bytedance.android.livesdk.livecommerce.room.controller.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import vi2.h;
import vi2.p;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f151895a;

    public c(a r100) {
        this.f151895a = r100;
    }

    public final void a() {
        a r100 = this.f151895a;
        r100.getClass();
        CompositeDisposable r101 = CoreRequests.f151395a;
        String r102 = r100.f151892e;
        String r103 = r100.f151893f;
        b r104 = new b(r100);
        r100.f151891d = h.e(null, null, "https://ecom.snssdk.com/live/ecom/small_window/", new p(r102, r103)).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(r104), new m(r104));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
