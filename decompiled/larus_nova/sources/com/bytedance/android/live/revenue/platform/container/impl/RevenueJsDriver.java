package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.platform.aio.ServiceHub;
import com.bytedance.platform.aio.Severity;
import com.bytedance.platform.aio.channel.AbstractChannelClient;
import com.bytedance.platform.aio.channel.js.JsBridgeChannelClient;
import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class RevenueJsDriver implements com.bytedance.platform.aio.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f91050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0<Object, Object> f91051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f91052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.platform.aio.channel.js.c f91053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.platform.aio.channel.js.c f91054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.platform.aio.channel.js.a f91055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i57.a f91056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Pair<View, String>> f91057h;

    public static final class a implements com.bytedance.platform.aio.channel.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f91058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f91059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f91060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.platform.aio.channel.b f91061d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f91062e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f91063f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Object f91064g;

        @Override // com.bytedance.platform.aio.channel.b.a
        public final void a() {
        }

        @Override // com.bytedance.platform.aio.channel.b.a
        public final void b(boolean r110) {
            if (r110 == false) goto L4;
            return;
        L4:
            if (this.f91058a.element == true) goto L8;
            int r111 = d.f91211a;
            View r100 = this.f91059b;
            String r101 = this.f91060c;
            String r102 = this.f91061d.getChannelId();
            String r103 = this.f91062e;
            String r104 = this.f91063f;
            i97.a r112 = i97.a.f488802a;
            long r105 = System.currentTimeMillis() - ((z) this.f91064g).f91370b;
            Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.Notification.CHANNEL_ID);
            Intrinsics.checkNotNullParameter(r103, "interfaceId");
            Intrinsics.checkNotNullParameter(r104, "methodId");
            Single.just(1).subscribeOn(Schedulers.computation()).subscribe(new h(r100, r101, r103, r104, r102, r105), k.f91302a);
            return;
        }

        public a(Ref.BooleanRef r100, View r101, String r102, AbstractChannelClient.a r103, String r104, String r105, Object r106) {
            this.f91058a = r100;
            this.f91059b = r101;
            this.f91060c = r102;
            this.f91061d = r103;
            this.f91062e = r104;
            this.f91063f = r105;
            this.f91064g = r106;
        }
    }

    public final JsBridgeChannelClient a() {
        return (JsBridgeChannelClient) this.f91050a.getValue();
    }

    @Override // com.bytedance.platform.aio.a
    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        return false;
    }

    @Override // com.bytedance.platform.aio.a
    public final void g(ServiceHub r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceHub");
        jy0.b.d("RevenueJsDriver", WidgetCostModule.TYPE_ON_LOAD + r100 + ", current url is: " + this.f91057h.invoke().getSecond());
        JsBridgeChannelClient r101 = a();
        r101.getClass();
        Intrinsics.checkNotNullParameter("RevenueNativeJsDriver", "tag");
        com.bytedance.platform.aio.channel.f r102 = r101.f266560f;
        r102.getClass();
        Intrinsics.checkNotNullParameter("RevenueNativeJsDriver", "tag");
        r102.f266591a.add("RevenueNativeJsDriver");
        h0<Object, Object> r103 = new h0(r100, this.f91052c, this.f91056g, this.f91057h);
        this.f91051b = r103;
        Unit r104 = Unit.INSTANCE;
        r101.f266558d = r103;
        r101.f266559e = new f0(this, r100);
    }

    @Override // com.bytedance.platform.aio.a
    public final void i(com.bytedance.platform.aio.c r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceHub");
        jy0.b.d("RevenueJsDriver", "onUnload" + r100 + ", current url is: " + this.f91057h.invoke().getSecond());
        h0<Object, Object> r101 = this.f91051b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L5:
        r101.f91269a.clear();
        JsBridgeChannelClient r102 = a();
        r102.f266597k.a("rpcChannelMessage", r102.f266593g);
        r102.f266597k.a("rpcChannelMessageV2", r102.f266594h);
    }

    public RevenueJsDriver(com.bytedance.platform.aio.channel.js.a r100, i57.g r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "jsBridge");
        Intrinsics.checkNotNullParameter(r101, "aioCallContext");
        Intrinsics.checkNotNullParameter(r102, "getMonitorParams");
        this.f91055f = r100;
        this.f91056g = r101;
        this.f91057h = r102;
        this.f91050a = LazyKt.lazy(new RevenueJsDriver$client$2(this));
        this.f91052c = new g0();
        this.f91053d = a().f266593g;
        this.f91054e = a().f266594h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.platform.aio.a
    public final <T, R> j57.a<R> c(String r110, String r111, T r210) {
        Intrinsics.checkNotNullParameter(r110, "interfaceId");
        Intrinsics.checkNotNullParameter(r111, "methodId");
        Intrinsics.checkNotNullParameter(r210, "arguments");
        i97.a r100 = i97.a.f488802a;
        System.currentTimeMillis();
        long r101 = ((z) r210).f91370b;
        JsBridgeChannelClient r102 = a();
        BytesContentType r103 = BytesContentType.PROTOBUF;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r110, "interfaceId");
        Intrinsics.checkNotNullParameter(r111, "methodId");
        Intrinsics.checkNotNullParameter(r103, "contentType");
        StringBuilder r104 = new StringBuilder();
        r104.append(Integer.toString(r102.hashCode(), CharsKt.checkRadix(16)));
        r104.append('.');
        int r105 = r102.f266557c;
        r102.f266557c = r105 + 1;
        r104.append(r105);
        String r106 = r104.toString();
        AbstractChannelClient<Object, Object>.a r112 = r102.b(r106);
        r102.f266556b.put(r106, (AbstractChannelClient<T, R>.a) r112);
        String r107 = r102.f266555a;
        com.bytedance.platform.aio.b.f266552a.getClass();
        com.bytedance.platform.aio.b r113 = com.bytedance.platform.aio.b.a.f266553a;
        Severity r114 = Severity.DEBUG;
        if (r113.b(r114, r107) == false) goto L5;
        r113.a(r114, r107, "connect: interfaceId = " + r110 + ", methodId = " + r111 + ", channel = " + r112);
    L5:
        r102.e(r110, r111, r106);
        Intrinsics.checkNotNullParameter(r110, "interfaceId");
        Intrinsics.checkNotNullParameter(r111, "methodId");
        Intrinsics.checkNotNullParameter(r103, "contentType");
        if (r112.f266563c == true) goto L9;
        ((ArrayList) r112.f266567g).add(new com.bytedance.platform.aio.channel.e.b(r112.f266568h, r110, r111, r103));
    L9:
        String r108 = r110 + '.' + r111;
        Intrinsics.checkNotNullParameter(r108, "tag");
        com.bytedance.platform.aio.channel.f r109 = r112.f266570j;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r108, "tag");
        r109.f266591a.add(r108);
        Ref.BooleanRef r115 = new Ref.BooleanRef();
        r115.element = false;
        Pair<View, String> r116 = this.f91057h.invoke();
        View r117 = r116.component1();
        String r118 = r116.component2();
        r112.f266566f = new a(r115, r117, r118, r112, r110, r111, r210);
        com.bytedance.revenue.platform.api.core.rx.l r119 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        return new j57.a(Observable.create(new RevenueJsDriver$invokeMethod$2(this, r117, r118, r112, r110, r111, r210, r115)), null, 4);
    }
}
