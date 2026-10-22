package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.revenue.service.effect.RevStickerPanel;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k3 implements com.bytedance.android.livesdk.revenue.service.effect.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.service.effect.c f131616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m3 f131617b;

    public static final class a<T> implements SingleOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k3 f131618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f131619b;

        public a(k3 r100, List r101) {
            this.f131618a = r100;
            this.f131619b = r101;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<List<yp2.b>> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            r100.onSuccess(this.f131618a.f131616a.lk(this.f131619b));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k3 f131620a;

        public b(k3 r100) {
            this.f131620a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Iterator r101 = ((List) r100).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            yp2.b r102 = (yp2.b) r101.next();
            com.bytedance.android.livesdk.revenue.service.effect.c.a.a(this.f131620a.f131616a, RevStickerPanel.EFFECT_ATMOSPHERE, r102, null, 12);
            goto L4
        }
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.d
    public final void onFail() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.d
    public final void onSuccess(List<? extends com.bytedance.android.livesdk.revenue.service.effect.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Disposable r101 = this.f131617b.f131644b;
        if (r101 == null) goto L7;
        if (r101.isDisposed() == true) goto L7;
        return;
    L7:
        if ((!r100.isEmpty()) == false) goto L11;
        this.f131617b.f131644b = Single.create(new a(this, r100)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), l3.f131631a);
        return;
    }

    public k3(com.bytedance.android.livesdk.revenue.service.effect.c r100, m3 r101) {
        this.f131616a = r100;
        this.f131617b = r101;
    }
}
