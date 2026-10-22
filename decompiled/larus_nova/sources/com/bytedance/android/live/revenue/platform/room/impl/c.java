package com.bytedance.android.live.revenue.platform.room.impl;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f91600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.message.c f91601b;

    public static final class a implements ttc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f91602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vlc.l f91603b;

        public a(c r100, vlc.l r101) {
            this.f91602a = r100;
            this.f91603b = r101;
        }

        @Override // ttc.c
        public final void cancel() {
            c r100 = this.f91602a;
            r100.f91601b.K0(r100.f91600a.f91608b, this.f91603b);
        }
    }

    public static final class b implements vlc.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f91604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f91605b;

        public b(c r100, ObservableEmitter r101) {
            this.f91604a = r100;
            this.f91605b = r101;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            ObservableEmitter r101 = this.f91605b;
            if (r100 == null) goto L11;
            vh7.e r102 = com.bytedance.android.live.base.model.m.a((vh7.c) r100, this.f91604a.f91600a.f91607a);
            if (r102 == null) goto L9;
            r101.onNext((yh6.c) r102);
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type T");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<*>");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.room.impl.c$c, reason: collision with other inner class name */
    public static final class C1416c implements vlc.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f91606a;

        public C1416c(ObservableEmitter r100) {
            this.f91606a = r100;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            ObservableEmitter r101 = this.f91606a;
            if (r100 == null) goto L7;
            r101.onNext((yh6.c) r100);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
    }

    public c(d r100, com.bytedance.android.livesdk.revenue.message.c r101) {
        this.f91600a = r100;
        this.f91601b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        if (vh7.e.class.isAssignableFrom(this.f91600a.f91607a) == false) goto L5;
        vlc.l r101 = new b(this, r100);
    L6:
        r100.setCancellable(new a(this, r101));
        this.f91601b.L0(this.f91600a.f91608b, r101);
        return;
    L5:
        r101 = new C1416c(r100);
        goto L6
    }
}
