package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.link.model.IPropInfoNotifyResponse;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.scope.m;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f92829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f92830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f92831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Integer> f92832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRoom f92833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e f92834f;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f92835a = null;

        static {
            f92835a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f92836a = null;

        static {
            f92836a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.revenue.common.k.c((Throwable) r100);
        }
    }

    public final void a(int r110) {
        Disposable r100 = this.f92830b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        cy0.e.f465759a.getClass();
        cy0.j r101 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r102 = m.b(r101).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
        Intrinsics.checkNotNull(r102);
        if (((com.bytedance.android.livesdk.revenue.service.gift.a) ((com.bytedance.live.kmp.core.c) r102)).hasPKPropCard() == true) goto L8;
        return;
    L8:
        com.bytedance.android.live.revlink.impl.global.c r103 = this.f92831c;
        LinkCrossRoomDataHolder r104 = null;
        if (r103 == null) goto L11;
        r31.a r105 = r103.getLinkNetwork();
    L12:
        if (r105 == null) goto L34;
        com.bytedance.android.live.revlink.impl.global.c r106 = this.f92831c;
        if (r106 == null) goto L16;
        r104 = r106.getLinkCrossRoomDataHolder();
    L16:
        if (r104 == null) goto L18;
        long r107 = r104.c();
    L19:
        long r108 = r107;
        long r109 = this.f92834f.getPkId();
        IRoom r111 = this.f92833e;
        if (r111 == null) goto L23;
        String r112 = IRoomKt_androidKt.getAnchorId(r111);
        if (r112 == null) goto L23;
    L24:
        Observable<ExtraResponse<IPropInfoNotifyResponse, Extra>> r113 = r105.A(r110, r108, r109, r112);
        if (r113 == null) goto L35;
        int r114 = p.f267522a;
        Observable<ExtraResponse<IPropInfoNotifyResponse, Extra>> r115 = r113.subscribeOn(Schedulers.io());
        if (r115 == null) goto L36;
        Observable<ExtraResponse<IPropInfoNotifyResponse, Extra>> r116 = r115.observeOn(AndroidSchedulers.mainThread());
        if (r116 == null) goto L37;
        Disposable r117 = r116.subscribe(a.f92835a, b.f92836a);
        if (r117 == null) goto L38;
        this.f92829a.add(r117);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L23:
        r112 = "";
        goto L24
    L18:
        r107 = 0;
        goto L19
    L34:
        return;
    L11:
        r105 = null;
        goto L12
    }

    public j(com.bytedance.android.live.revlink.impl.global.c r100, Function0<Integer> r101, IRoom r102, com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r103) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r103, "pkBaseService");
        this.f92831c = r100;
        this.f92832d = r101;
        this.f92833e = r102;
        this.f92834f = r103;
        this.f92829a = new CompositeDisposable();
    }
}
