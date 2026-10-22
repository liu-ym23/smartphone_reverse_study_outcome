package com.bytedance.android.live.revenue.platform.stream.impl;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import or2.j;
import or2.m;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.platform.stream.impl.a f91692a;

    public static final class a implements ttc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ or2.c f91693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Observer f91694b;

        public a(or2.c r100, C1420b r101) {
            this.f91693a = r100;
            this.f91694b = r101;
        }

        @Override // ttc.c
        public final void cancel() {
            this.f91693a.getSeiUpdate().removeObserver(this.f91694b);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.stream.impl.b$b, reason: collision with other inner class name */
    public static final class C1420b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f91695a;

        public C1420b(ObservableEmitter r100) {
            this.f91695a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ObservableEmitter r101 = this.f91695a;
            r101.onNext((String) r100);
        }
    }

    public b(com.bytedance.android.live.revenue.platform.stream.impl.a r100) {
        this.f91692a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        j r101 = this.f91692a.f91680f.getCurrentClient();
        if (r101 == null) goto L5;
        m r102 = r101.d();
    L6:
        if (r102 != null) goto L9;
        jy0.b.c("SeiServiceImpl", "roomEventHub is null", null, 4);
        r100.onComplete();
        return;
    L9:
        C1420b r103 = new C1420b(r100);
        r100.setCancellable(new a(r102, r103));
        r102.getSeiUpdate().observeForever(r103);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
