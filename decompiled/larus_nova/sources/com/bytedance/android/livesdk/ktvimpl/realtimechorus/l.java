package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f146688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f146689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f146690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f146691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f146692e;

    public static final class a implements zt0.b {
        public a() {
        }

        @Override // zt0.b
        public final void a(String r100) {
            ALogger.i("RTChorusRoomDressResource", "onSyncSuccess: " + r100);
        }

        @Override // zt0.b
        public final void b(String r100, String r101, int r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "version");
            Intrinsics.checkNotNullParameter(r101, "version");
            ALogger.e("RTChorusRoomDressResource", "onSyncFailed: " + r100 + ", " + r101 + ", " + r102 + ", " + r103);
        }
    }

    public l(k r100, String r101, long r102) {
        this.f146688a = r100;
        this.f146689b = r101;
        this.f146690c = 35;
        this.f146691d = r102;
        this.f146692e = "rt_chorus";
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<com.bytedance.android.live.profit.dress.t> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f146688a.getClass();
        com.bytedance.android.live.profit.dress.t r101 = (com.bytedance.android.live.profit.dress.t) yt0.c.a().getDressData(this.f146689b, this.f146690c, this.f146691d, this.f146692e, new a());
        if (r101 == null) goto L5;
        r100.onNext(r101);
        r100.onComplete();
        return;
    L5:
        r100.onError(new Throwable("dressData is null"));
    }
}
