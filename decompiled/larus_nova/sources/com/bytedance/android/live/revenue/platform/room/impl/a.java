package com.bytedance.android.live.revenue.platform.room.impl;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.platform.room.impl.b f91589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.message.b f91590b;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.room.impl.a$a, reason: collision with other inner class name */
    public static final class C1415a implements ttc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f91591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vlc.l f91592b;

        public C1415a(a r100, vlc.l r101) {
            this.f91591a = r100;
            this.f91592b = r101;
        }

        @Override // ttc.c
        public final void cancel() {
            a r100 = this.f91591a;
            r100.f91590b.removeMessageListener(r100.f91589a.f91597b, this.f91592b);
        }
    }

    public static final class b implements vlc.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f91593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f91594b;

        public b(a r100, ObservableEmitter r101) {
            this.f91593a = r100;
            this.f91594b = r101;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            ObservableEmitter r101 = this.f91594b;
            if (r100 == null) goto L11;
            vh7.e r102 = com.bytedance.android.live.base.model.m.a((vh7.c) r100, this.f91593a.f91589a.f91596a);
            if (r102 == null) goto L9;
            r101.onNext((yh6.c) r102);
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type T");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<*>");
        }
    }

    public static final class c implements vlc.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f91595a;

        public c(ObservableEmitter r100) {
            this.f91595a = r100;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            ObservableEmitter r101 = this.f91595a;
            if (r100 == null) goto L7;
            r101.onNext((yh6.c) r100);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
    }

    public a(com.bytedance.android.live.revenue.platform.room.impl.b r100, com.bytedance.android.livesdk.revenue.message.b r101) {
        this.f91589a = r100;
        this.f91590b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        if (vh7.e.class.isAssignableFrom(this.f91589a.f91596a) == false) goto L5;
        vlc.l r101 = new b(this, r100);
    L6:
        r100.setCancellable(new C1415a(this, r101));
        com.bytedance.android.live.revenue.platform.room.impl.b r102 = this.f91589a;
        if (r102.f91598c == false) goto L9;
        this.f91590b.i(r102.f91597b, r101, r102.f91599d);
        return;
    L9:
        this.f91590b.addMessageListener(r102.f91597b, r101);
        return;
    L5:
        r101 = new c(r100);
        goto L6
    }
}
