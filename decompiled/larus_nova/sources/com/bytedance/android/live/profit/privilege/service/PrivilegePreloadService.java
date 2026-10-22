package com.bytedance.android.live.profit.privilege.service;

import android.content.Context;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.misc.m;
import com.bytedance.android.live.revenue.core.util.AsyncService;
import com.bytedance.android.livesdk.message.model.fb;
import com.bytedance.android.livesdk.revenue.message.i;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;
import yz0.k;

/* JADX INFO: loaded from: classes47.dex */
public final class PrivilegePreloadService extends AsyncService {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f88444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f88445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.message.d f88446f;

    public static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PublishSubject f88447a;

        public a(PublishSubject r100) {
            this.f88447a = r100;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            if ((r100 instanceof fb) == false) goto L6;
            this.f88447a.onNext(r100);
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrivilegePreloadService f88448a;

        public b(PrivilegePreloadService r100) {
            this.f88448a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            fb r101 = (fb) r100;
            PrivilegePreloadService.w0(this.f88448a, r101.getScene(), r101.getParam());
        }
    }

    private final Context getContext() {
        return this.f88445e.getContext();
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService, com.bytedance.android.scope.o
    public final void onStop() {
        super.onStop();
        this.f88444d.dispose();
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService
    public final Object o0(Continuation<? super Unit> r100) {
        if ((r100 instanceof PrivilegePreloadService$onStartAsync$1) == false) goto L7;
        PrivilegePreloadService$onStartAsync$1 r101 = (PrivilegePreloadService$onStartAsync$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        PrivilegePreloadService r106 = (PrivilegePreloadService) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L18:
        com.bytedance.android.livesdk.revenue.service.message.d r107 = r106.f88446f;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        String r108 = com.bytedance.android.live.revenue.common.message.b.I.f567604a;
        PublishSubject r109 = PublishSubject.create();
        a r110 = new a(r109);
        i r111 = r107.getMessageManager();
        if (r111 != null) goto L21;
        Observable r112 = null;
    L22:
        if (r112 == null) goto L26;
        Disposable r113 = r112.subscribe(new b(r106));
        if (r113 == null) goto L26;
        RxUtilKt.c(r113, r106.f88444d);
    L28:
        return Unit.INSTANCE;
    L26:
        ALogger.e("PrivilegePreloadService", "failed to listen message");
        Unit r114 = Unit.INSTANCE;
        goto L28
    L21:
        r112 = r109.doOnSubscribe(new com.bytedance.android.live.misc.l(r111, r108, r110)).doOnDispose(new m(r111, r108, r110));
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        ALogger.w("PrivilegePreloadService", "service starting");
        com.bytedance.android.livesdk.revenue.service.message.d r115 = this.f88446f;
        r101.L$0 = this;
        r101.label = 1;
        if (r115.g(r101) != r104) goto L17;
        return r104;
    L17:
        r106 = this;
    L7:
        r101 = new PrivilegePreloadService$onStartAsync$1(this, r100);
        goto L8
    }

    public PrivilegePreloadService(k r100, com.bytedance.android.livesdk.revenue.service.message.d r101) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "messageManagerService");
        this.f88445e = r100;
        this.f88446f = r101;
        this.f88444d = new CompositeDisposable();
    }

    public static final void w0(PrivilegePreloadService r100, long r101, String r102) {
        r100.getClass();
        ALogger.w("PrivilegePreloadService", "creating preload card");
        com.bytedance.android.annie.ng.c r103 = Annie.with(r100.getContext(), UriProtector.parse((String) com.bytedance.android.live.profit.privilege.d.f88375b.getValue(null, com.bytedance.android.live.profit.privilege.d.f88374a[0])), "webcast");
        e r104 = new e();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "commonLifecycle");
        r103.f39655d = r104;
        HybridCard r105 = r103.a();
        if (r105 == null) goto L5;
        r105.registerMethod("close", new f(r105));
        a7.a.a(r105, null, MapsKt.mapOf(TuplesKt.to("preloadData", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", Long.valueOf(r101)), TuplesKt.to("param", r102)}))), 1);
        RxUtilKt.c(Disposables.fromAction(new g(new WeakReference(r105))), r100.f88444d);
        return;
    L5:
        ALogger.e("PrivilegePreloadService", "create card failed");
    }
}
