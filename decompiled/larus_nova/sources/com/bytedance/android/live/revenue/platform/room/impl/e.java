package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f91609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ wlc.c f91610b;

    public static final class a implements ttc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f91611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ wlc.b f91612b;

        public a(e r100, wlc.b r101) {
            this.f91611a = r100;
            this.f91612b = r101;
        }

        @Override // ttc.c
        public final void cancel() {
            e r100 = this.f91611a;
            r100.f91610b.removeMessageListener(r100.f91609a.f91618b, this.f91612b);
        }
    }

    public static final class b implements wlc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f91613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f91614b;

        public b(e r100, ObservableEmitter r101) {
            this.f91613a = r100;
            this.f91614b = r101;
        }

        @Override // wlc.b
        public final void Rk(IStreamMessage r100) {
            ObservableEmitter r101 = this.f91614b;
            if (r100 == null) goto L11;
            vh7.e r102 = com.bytedance.android.live.base.model.m.a((vh7.c) r100, this.f91613a.f91609a.f91617a);
            if (r102 == null) goto L9;
            r101.onNext((yh6.c) r102);
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type T");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<*>");
        }
    }

    public static final class c implements wlc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f91615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f91616b;

        public c(e r100, ObservableEmitter r101) {
            this.f91615a = r100;
            this.f91616b = r101;
        }

        @Override // wlc.b
        public final void Rk(IStreamMessage r100) {
            if (this.f91615a.f91609a.f91617a.isInstance(r100) == false) goto L9;
            ObservableEmitter r101 = this.f91616b;
            if (r100 == null) goto L8;
            r101.onNext((yh6.c) r100);
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
    }

    public e(f r100, wlc.c r101) {
        this.f91609a = r100;
        this.f91610b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        if (vh7.e.class.isAssignableFrom(this.f91609a.f91617a) == false) goto L5;
        wlc.b r101 = new b(this, r100);
    L6:
        r100.setCancellable(new a(this, r101));
        this.f91610b.addMessageListener(MessageType.GROUP_COMPONENT_CONTAINER_MESSAGE.getIntTypeExt(), r101);
        return;
    L5:
        r101 = new c(this, r100);
        goto L6
    }
}
