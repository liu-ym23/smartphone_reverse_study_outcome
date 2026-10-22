package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.gesture.EffectGestureDetectorV2;
import com.bytedance.android.live.effect.t;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/view/EffectLiveCameraActivityProxy;", "Lcom/bytedance/android/live/effect/view/LiveEffectActivityProxy;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EffectLiveCameraActivityProxy extends LiveEffectActivityProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f68883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f68884b;

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onCreate() {
        super.onCreate();
        this.f68883a = xs2.b.a().b(com.bytedance.android.live.effect.gesture.a.class).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        LiveEffectContextFactoryDelegate$Type r100 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        new EffectGestureDetectorV2(null, r100);
        this.f68884b = new t(r100);
    }

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onDestroy() {
        super.onDestroy();
        Disposable r100 = this.f68883a;
        if (r100 == null) goto L5;
        r100.isDisposed();
    L5:
        Disposable r101 = this.f68883a;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }
}
