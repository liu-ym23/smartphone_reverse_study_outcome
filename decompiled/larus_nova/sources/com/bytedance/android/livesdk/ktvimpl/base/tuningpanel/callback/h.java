package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f143488a;

    public h(j r100) {
        this.f143488a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        j r102 = this.f143488a;
        Disposable r103 = r102.f143491b;
        if (r103 != null) goto L5;
    L7:
        ALogger.d("ttlive_ktv_realTimeChorus_KSongTuningMusicControlOuterCallback", "observePlayProgressEvent");
        ec0.a r104 = r102.f143492c;
        if (r104 == null) goto L10;
        Disposable r105 = r104.n(new i(r102));
    L11:
        r102.f143491b = r105;
        return;
    L10:
        r105 = null;
        goto L11
    L5:
        if (r103.isDisposed() == true) goto L7;
        r103.dispose();
        goto L7
    }
}
