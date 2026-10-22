package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e9 implements Observer<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d9 f112765a;

    @Override // io.reactivex.Observer
    public final void onComplete() {
        this.f112765a.b();
    }

    public e9(d9 r100) {
        this.f112765a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        ALogger.e("RoomTimer", "timer error: " + r100.getMessage());
        this.f112765a.b();
    }

    @Override // io.reactivex.Observer
    public final void onNext(Long r110) {
        long r100 = r110.longValue();
        Iterator r111 = ((ArrayList) this.f112765a.f112738b).iterator();
    L4:
        if (r111.hasNext() == false) goto L10;
        d9.c r101 = (d9.c) r111.next();
        d9.b r102 = r101.f112744c;
        if (r102 == null) goto L4;
        if (r102.a(r100, this.f112765a.f112741e, r101.f112743b) != true) goto L4;
        r101.f112743b++;
        goto L4
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.f112765a.f112737a = r100;
    }
}
