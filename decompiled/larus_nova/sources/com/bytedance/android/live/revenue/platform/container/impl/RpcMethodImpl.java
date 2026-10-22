package com.bytedance.android.live.revenue.platform.container.impl;

import android.content.Context;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.platform.aio.ServiceHub;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import com.google.gson.JsonObject;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class RpcMethodImpl<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f91095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f91096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f91097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f91098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f91099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Method f91100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ServiceHub f91101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Type f91102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Class<T> f91103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.platform.container.impl.core.g f91104j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CenterServiceType f91105k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Object> f91106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f91107b;

        public a(List<? extends Object> r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "args");
            this.f91106a = r100;
            this.f91107b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f91108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f91109b;

        public b(String r100, Type r101) {
            Intrinsics.checkNotNullParameter(r100, "paramKey");
            Intrinsics.checkNotNullParameter(r101, "paramType");
            this.f91108a = r100;
            this.f91109b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f91110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f91111b;

        public final int getType() {
            return this.f91111b;
        }

        public c(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "fallbackUrl");
            this.f91110a = r100;
            this.f91111b = r101;
        }
    }

    public final /* synthetic */ class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f91112a;

        public d(Function0 r100) {
            this.f91112a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final /* synthetic */ void run() {
            this.f91112a.invoke();
        }
    }

    public final /* synthetic */ class e implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f91113a;

        public e(Function1 r100) {
            this.f91113a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f91113a.invoke(r100);
        }
    }

    public static z c(a r100, List r101) {
        ArrayList r102 = (ArrayList) r101;
        if (r102.isEmpty() == false) goto L8;
        Object r103 = CollectionsKt.firstOrNull(r100.f91106a);
        if (r103 != null) goto L22;
        r103 = new JsonObject();
    L22:
        return new z(r103, r100.f91107b);
    L8:
        JsonObject r104 = new JsonObject();
        if (r100.f91106a == null) goto L18;
        Iterator<T> r105 = r102.iterator();
        int r106 = 0;
    L12:
        if (r105.hasNext() == false) goto L18;
        T r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        b r109 = (b) r107;
        r104.add(r109.f91108a, GsonProtectorUtils.toJsonTree(GsonHelper.get(), ListProtector.get(r100.f91106a, r106), r109.f91109b));
        r106 = r108;
    L18:
        return new z(r104, r100.f91107b);
    }

    public final Observable<JsonObject> b(a r100, boolean r110) {
        jy0.b.d("[AioLink]", "start invokeServiceCenter, interfaceId: " + this.f91099e + ", methodId: " + this.f91095a);
        com.bytedance.android.live.revenue.platform.container.impl.core.g r101 = this.f91104j;
        com.bytedance.android.live.revenue.platform.container.impl.core.g.a r102 = com.bytedance.android.live.revenue.platform.container.impl.core.g.D0;
        CenterServiceType r103 = this.f91105k;
        r102.getClass();
        Observable<JsonObject> r104 = r101.K(com.bytedance.android.live.revenue.platform.container.impl.core.g.a.a(r103), this.f91099e, this.f91095a, c(r100, this.f91096b), r110);
        int r111 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Scheduler r112 = Schedulers.computation();
        if (((Boolean) u0.f91351b.getValue(null, u0.f91350a[0])).booleanValue() == true) goto L5;
        return r104;
    L5:
        return r104.subscribeOn(r112);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v4 */
    public final void a(a r100, CompositeDisposable r101, final Function1<Object, Unit> r110, Function1<? super Throwable, Unit> r111, Function0<Unit> r112, Context r113) {
        Function1<JsonObject, Unit> r102 = new RpcMethodImpl$invokeService$convertResultCallback$1(this, r110);
        if (m.f91312e.contains(this.f91099e) == false) goto L6;
        RxUtilKt.c(this.f91101g.d(this.f91099e).subscribe(new p0(this, r100, r102, r111, r112, r101)), r101);
        return;
    L6:
        if (((c) this.f91097c.getValue()) == null) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L22;
        if (r113 != null) goto L12;
        Observable<T> r104 = Observable.error(com.bytedance.platform.aio.d.b("please provide context when call routerService", null));
    L13:
        if (r110 == 0) goto L15;
        r110 = new e(r110);
    L15:
        Consumer<? super T> r114 = (Consumer) r110;
        Object r115 = r111;
        if (r111 == null) goto L18;
        r115 = new e(r111);
    L18:
        Consumer<? super Throwable> r116 = (Consumer) r115;
        Object r117 = r112;
        if (r112 == null) goto L21;
        r117 = new d(r112);
    L21:
        RxUtilKt.c(r104.subscribe(r114, r116, (Action) r117), r101);
        return;
    L12:
        r104 = b(r100, true).map(new q0(this)).onErrorResumeNext(new s0(this, r113, r100));
        goto L13
    L22:
        Observable<JsonObject> r105 = b(r100, false);
        e r118 = new e(r102);
        Object r119 = r111;
        if (r111 == null) goto L25;
        r119 = new e(r111);
    L25:
        Consumer<? super Throwable> r120 = (Consumer) r119;
        Object r121 = r112;
        if (r112 == null) goto L28;
        r121 = new d(r112);
    L28:
        RxUtilKt.c(r105.subscribe(r118, r120, (Action) r121), r101);
        return;
    L8:
        r103 = false;
        goto L9
    }

    public RpcMethodImpl(String r100, Method r101, ServiceHub r102, Type r103, Class r110, com.bytedance.android.live.revenue.platform.container.impl.b r111, CenterServiceType r112) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "serviceHub");
        Intrinsics.checkNotNullParameter(r103, "returnType");
        Intrinsics.checkNotNullParameter(r110, "returnRawType");
        Intrinsics.checkNotNullParameter(r111, "centerService");
        Intrinsics.checkNotNullParameter(r112, NsdHelper.serviceTypeKey);
        this.f91099e = r100;
        this.f91100f = r101;
        this.f91101g = r102;
        this.f91102h = r103;
        this.f91103i = r110;
        this.f91104j = r111;
        this.f91105k = r112;
        Annotation r104 = r101.getAnnotation(BindsRpc.class);
        Intrinsics.checkNotNull(r104);
        this.f91095a = ((BindsRpc) r104).rpcName();
        ArrayList r105 = new ArrayList();
        Annotation[][] r106 = r101.getParameterAnnotations();
        int r107 = r106.length;
        int r113 = 0;
        int r114 = 0;
    L3:
        if (r113 >= r107) goto L16;
        int r108 = r114 + 1;
        Annotation[] r115 = r106[r113];
        Type r116 = this.f91100f.getGenericParameterTypes()[r114];
        if (r115 == null) goto L15;
        int r109 = r115.length;
        int r117 = 0;
    L7:
        if (r117 >= r109) goto L12;
        Annotation r118 = r115[r117];
        if ((r118 instanceof RpcParam) == true) goto L13;
        r117 = r117 + 1;
    L13:
        if (r118 == null) goto L15;
        r105.add(new b(((RpcParam) r118).paramName(), r116));
        goto L15
    L12:
        r118 = null;
    L15:
        r113 = r113 + 1;
        r114 = r108;
        goto L3
    L16:
        this.f91096b = r105;
        this.f91097c = LazyKt.lazy(new RpcMethodImpl$routerServiceInfo$2(this));
    }
}
