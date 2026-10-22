package com.bytedance.android.livesdk.revenue.external.hybrid;

import com.bytedance.android.annie.api.data.subscribe.BaseDataObsProvider;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.xiaomi.mipush.sdk.MiPushClient;
import cq2.h;
import cq2.i;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveRevenueHybridServiceImpl implements gy0.a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Function2<Gson, i, cq2.e>> f157154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Function3<Gson, DataCenter, i, h>> f157155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<DataCenter, c> f157156c;

    public static abstract class a extends BaseDataObsProvider<JsonElement> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f157157b;

        @Override // com.bytedance.android.annie.api.data.subscribe.e
        public final void onRelease() {
            e r100 = this.f157157b;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("stub");
        L5:
            r100.f157164a.dispose();
        }

        public a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f157158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final cq2.e f157159d;

        @Override // com.bytedance.android.annie.api.data.subscribe.g
        public final Object g() {
            return this.f157159d.getCurrentValue();
        }

        @Override // com.bytedance.android.annie.api.data.subscribe.g
        public final String key() {
            return this.f157158c;
        }

        public b(String r100, cq2.e r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "state");
            this.f157158c = r100;
            this.f157159d = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Disposable> f157160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function2<c, BaseDataObsProvider<?>, Disposable> f157161b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Gson r100, DataCenter r101, Function2<? super c, ? super BaseDataObsProvider<?>, ? extends Disposable> r102) {
            Intrinsics.checkNotNullParameter(r100, "gson");
            Intrinsics.checkNotNullParameter(r101, "dataCenter");
            Intrinsics.checkNotNullParameter(r102, MiPushClient.COMMAND_REGISTER);
            this.f157161b = r102;
            this.f157160a = new LinkedHashMap();
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f157162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h f157163d;

        @Override // com.bytedance.android.annie.api.data.subscribe.g
        public final Object g() {
            return this.f157163d.getCurrentValue();
        }

        @Override // com.bytedance.android.annie.api.data.subscribe.g
        public final String key() {
            return this.f157162c;
        }

        public d(String r100, h r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "state");
            this.f157162c = r100;
            this.f157163d = r101;
        }
    }

    public static final class e implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CompositeDisposable f157164a;

        public e() {
            this.f157164a = new CompositeDisposable();
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public LiveRevenueHybridServiceImpl() {
        this.f157154a = new LinkedHashMap();
        this.f157155b = new LinkedHashMap();
        this.f157156c = new LinkedHashMap();
    }

    @Override // gy0.a
    public final synchronized void P2(DataCenter r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "dataCenter");     // Catch: Throwable -> L16
        c r101 = this.f157156c.remove(r100);     // Catch: Throwable -> L16
        if (r101 == null) goto L14;
        Map<String, Disposable> r102 = r101.f157160a;     // Catch: Throwable -> L16
        if (r102 == null) goto L14;
        Collection r103 = ((LinkedHashMap) r102).values();     // Catch: Throwable -> L16
        if (r103 == null) goto L14;
        Iterator r104 = r103.iterator();     // Catch: Throwable -> L16
    L11:
        if (r104.hasNext() == false) goto L14;
        ((Disposable) r104.next()).dispose();     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // gy0.a
    public final synchronized void D3(Gson r100, Function1<? super BaseDataObsProvider<?>, ? extends Disposable> r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "gson");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r101, MiPushClient.COMMAND_REGISTER);     // Catch: Throwable -> L10
        Iterator r102 = ((LinkedHashMap) this.f157154a).entrySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L8;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Throwable -> L10
        String r104 = (String) r103.getKey();     // Catch: Throwable -> L10
        Function2 r105 = (Function2) r103.getValue();     // Catch: Throwable -> L10
        e r106 = new e();     // Catch: Throwable -> L10
        b r107 = new b(r104, (cq2.e) r105.invoke(r100, r106));     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r106, "stub");     // Catch: Throwable -> L10
        r107.f157157b = r106;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(new LiveRevenueHybridServiceImpl$BaseStateImpl$attachStub$1(r107), "<set-?>");     // Catch: Throwable -> L10
        r101.invoke(r107);     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // gy0.a
    public final synchronized void m5(Gson r100, DataCenter r101, final Function1<? super BaseDataObsProvider<?>, ? extends Disposable> r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "gson");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r101, "dataCenter");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r102, MiPushClient.COMMAND_REGISTER);     // Catch: Throwable -> L10
        c r103 = new c(r100, r101, new LiveRevenueHybridServiceImpl$registerRoomScopedStates$roomScope$1(r102));     // Catch: Throwable -> L10
        Iterator r104 = ((LinkedHashMap) this.f157155b).entrySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r104.hasNext() == false) goto L7;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L10
        String r106 = (String) r105.getKey();     // Catch: Throwable -> L10
        Function3 r107 = (Function3) r105.getValue();     // Catch: Throwable -> L10
        e r108 = new e();     // Catch: Throwable -> L10
        d r109 = new d(r106, (h) r107.invoke(r100, r101, r108));     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r108, "stub");     // Catch: Throwable -> L10
        r109.f157157b = r108;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(new LiveRevenueHybridServiceImpl$BaseStateImpl$attachStub$1(r109), "<set-?>");     // Catch: Throwable -> L10
        r103.f157160a.put(r106, r102.invoke(r109));     // Catch: Throwable -> L10
        goto L5
    L7:
        this.f157156c.put(r101, r103);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
