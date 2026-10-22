package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.platform.aio.ServiceHub;
import com.bytedance.platform.aio.channel.AbstractChannelClient;
import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import com.bytedance.platform.aio.settings.GiftPanelOptSettingsKt;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h0<T, R> implements com.bytedance.platform.aio.channel.c<T, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f91269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.platform.aio.c f91270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<T, R> f91271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i57.a f91272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Pair<View, String>> f91273e;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f91274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BytesContentType f91275b;

        public a(T r100, BytesContentType r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, "contentType");
            this.f91274a = r100;
            this.f91275b = r101;
        }
    }

    public interface b<T, R> {
        <V> a<T> a(V r100, BytesContentType r101);

        <W> Map<String, String> b(W r100);
    }

    public h0(ServiceHub r100, g0 r101, i57.a r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceHub");
        Intrinsics.checkNotNullParameter(r101, "typeAdapter");
        Intrinsics.checkNotNullParameter(r102, "aioCallContext");
        Intrinsics.checkNotNullParameter(r103, "getMonitorParams");
        this.f91270b = r100;
        this.f91271c = r101;
        this.f91272d = r102;
        this.f91273e = r103;
        this.f91269a = new CompositeDisposable();
        GiftPanelOptSettingsKt.a();
    }

    @Override // com.bytedance.platform.aio.channel.c
    public final void a(String r110, String r111, AbstractChannelClient.a r112, BytesContentType r113) {
        Intrinsics.checkNotNullParameter(r110, "interfaceId");
        Intrinsics.checkNotNullParameter(r111, "methodId");
        Intrinsics.checkNotNullParameter(r112, "channel");
        Intrinsics.checkNotNullParameter(r113, "preferredContentType");
        jy0.b.d("RevenueJsMethodServer", "onAccept interfaceid: " + r110 + ", methodId: " + r111);
        com.bytedance.platform.aio.a r100 = this.f91270b.b(r110);
        if (r100 != null) goto L5;
        r100 = new l();
    L5:
        com.bytedance.platform.aio.a r101 = r100;
        h57.a r102 = new h57.a();
        r112.c(r102);
        CompositeDisposable r103 = new CompositeDisposable();
        this.f91269a.add(r103);
        r112.f266566f = new i0(r103);
        com.bytedance.revenue.platform.api.core.rx.f.a(r102.f483880b.take(1).subscribe(new j0(this, r113, r112, r101, r110, r111, r103), new k0(this, r112, r110, r111)), this.f91269a);
    }
}
