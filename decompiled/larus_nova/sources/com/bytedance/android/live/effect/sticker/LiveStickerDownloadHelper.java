package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.sticker.presenter.p0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveStickerDownloadHelper implements com.bytedance.android.live.effect.api.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f68138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.live.effect.api.l.b> f68139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f68140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f68141d;

    public static final class a {
    }

    public static final class b<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveStickerDownloadHelper f68142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Effect f68143b;

        public b(LiveStickerDownloadHelper r100, Effect r101) {
            this.f68142a = r100;
            this.f68143b = r101;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            r100.onNext(Boolean.valueOf(((EffectManager) this.f68142a.f68138a.getValue()).isEffectDownloaded(this.f68143b)));
        }
    }

    public static final class c extends p0<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.effect.api.l.a f68144a;

        public c(com.bytedance.android.live.effect.api.l.a r100) {
            this.f68144a = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f68144a.a(false);
        }

        @Override // io.reactivex.Observer
        public final void onNext(Object r100) {
            boolean r101 = ((Boolean) r100).booleanValue();
            this.f68144a.a(r101);
        }
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f68141d;
    }

    public LiveStickerDownloadHelper(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f68141d = r100;
        this.f68138a = LazyKt.lazy(new LiveStickerDownloadHelper$effectManager$2(this));
        this.f68139b = new ArrayList();
        this.f68140c = new ArrayList();
    }

    @Override // com.bytedance.android.live.effect.api.l
    public final void a(Effect r100, boolean r101, com.bytedance.android.live.effect.api.l.a r102) {
        Intrinsics.checkNotNullParameter(r102, "listener");
        if (r100 != null) goto L6;
        r102.a(false);
        return;
    L6:
        Observable r103 = Observable.create(new b(this, r100)).subscribeOn(Schedulers.io());
        if (r101 == false) goto L9;
        Scheduler r104 = AndroidSchedulers.mainThread();
    L10:
        r103.observeOn(r104).subscribe(new c(r102));
        return;
    L9:
        r104 = Schedulers.io();
        goto L10
    }

    @Override // com.bytedance.android.live.effect.api.l
    public final void b(String r100, Sticker r101, com.bytedance.android.live.effect.api.l.c r102) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "sticker");
        a(r101.getEffect(), false, new f(this, r102, r101, r100));
    }
}
