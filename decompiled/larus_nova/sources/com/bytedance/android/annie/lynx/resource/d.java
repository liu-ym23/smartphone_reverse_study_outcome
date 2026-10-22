package com.bytedance.android.annie.lynx.resource;

import android.os.AsyncTask;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements com.bytedance.android.annie.card.base.d, k7a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.annie.service.resource.g f39510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f39511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k7a.a f39512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.bytedance.android.annie.service.resource.h> f39513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.annie.card.base.c f39514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, ? extends k7a.a> f39515f;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f39516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f39517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k7a.a.InterfaceC6515a f39518c;

        public b(d r100, String r101, k7a.a.InterfaceC6515a r102) {
            this.f39516a = r100;
            this.f39517b = r101;
            this.f39518c = r102;
        }

        public final void a() {
            final d r100 = this.f39516a;
            final String r101 = this.f39517b;
            final k7a.a.InterfaceC6515a r102 = this.f39518c;
            r100.getClass();
            LinkedHashMap r103 = new LinkedHashMap();
            com.bytedance.android.annie.card.base.c r104 = r100.f39514e;
            if (r104 == null) goto L5;
            r104.b(r101, AnnieResType.COMPONENT, IHybridComponent.HybridType.LYNX, r103);
        L5:
            RequestConfig r105 = new RequestConfig(AnnieResType.LYNX_CHILD_RESOURCE);
            r105.f40018c = n.c(IHybridComponent.HybridType.LYNX);
            com.bytedance.android.annie.service.resource.g r106 = r100.f39510a;
            r105.f40027l = r106.f40036e;
            if (r106.f40034c == false) goto L8;
            r105.f40023h = r106.f40035d;
        L8:
            r105.a().putAll(r103);
            com.bytedance.android.annie.service.resource.h r107 = n.g(r101, r105, new LynxDynamicComponentProvider$useGeckoLoader$2(r100, r101, r102));
            if (r107 == null) goto L11;
            r100.f39513d.put(r101, r107);
            return;
        L11:
            if (r102 == null) goto L15;
            r102.a(null, new Throwable("gecko loader is null"));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.annie.card.base.d
    public final ConcurrentHashMap<String, com.bytedance.android.annie.service.resource.h> a() {
        return this.f39513d;
    }

    public d(com.bytedance.android.annie.service.resource.g r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f39510a = r100;
        ConcurrentHashMap<String, d8.b> r101 = e8.d.f471282a;
        f8.c r102 = e8.d.a(r100.f40037f).f467380g;
        Map<String, k7a.a> r103 = null;
        if (r102 == null) goto L5;
        k7a.a r104 = r102.provide();
    L6:
        this.f39512c = r104;
        this.f39513d = new ConcurrentHashMap();
        f8.b r105 = com.bytedance.android.annie.lynx.e.a().f467381h;
        if (r105 == null) goto L9;
        r103 = r105.provide();
    L9:
        this.f39515f = r103;
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void b(String r100, k7a.a.InterfaceC6515a r101) {
        if (r100 != null) goto L5;
        if (r101 == null) goto L19;
        r101.a(null, new Throwable("url is null"));
        return;
    L19:
        return;
    L5:
        if (this.f39510a.f40032a == false) goto L7;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new b(this, r100, r101));
        return;
    L7:
        k7a.a r102 = this.f39512c;
        if (r102 == null) goto L10;
        r102.loadDynamicComponent(r100, r101);
        return;
    L10:
        if (r101 == null) goto L17;
        r101.a(null, new Throwable("provider is null"));
        return;
    }

    @Override // k7a.a
    public final void loadDynamicComponent(String r100, k7a.a.InterfaceC6515a r101) {
        if (this.f39511b == false) goto L5;
        return;
    L5:
        boolean r102 = false;
        if (r100 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L44;
        Map<String, ? extends k7a.a> r104 = this.f39515f;
        if (r104 == null) goto L44;
        if (r104.isEmpty() != true) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == true) goto L44;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L42
        String r107 = UriProtector.getQueryParameter(UriProtector.parse(r100), "res_biz_name");     // Catch: Throwable -> L42
        if (r107 != null) goto L24;
    L27:
        boolean r108 = true;
    L28:
        if (r108 == true) goto L44;
        Map<String, ? extends k7a.a> r109 = this.f39515f;     // Catch: Throwable -> L42
        if (r109 == null) goto L39;
        Iterator<Map.Entry<String, ? extends k7a.a>> r110 = r109.entrySet().iterator();     // Catch: Throwable -> L42
    L34:
        if (r110.hasNext() == false) goto L38;
        Map.Entry<String, ? extends k7a.a> r111 = r110.next();     // Catch: Throwable -> L42
        if (Intrinsics.areEqual(r111.getKey(), r107) == false) goto L34;
        r111.getValue().loadDynamicComponent(r100, new e(this, r100, r101));     // Catch: Throwable -> L42
        r102 = true;
        goto L44
    L38:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L42
    L40:
        Result.m9449constructorimpl(r112);     // Catch: Throwable -> L42
        goto L44
    L39:
        r112 = null;
        goto L40
    L24:
        if (r107.length() == 0) goto L27;
        r108 = false;
    L42:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L44
    L18:
        r105 = false;
    L44:
        if (r102 == false) goto L46;
        return;
    L46:
        b(r100, r101);
        return;
    L8:
        if (r100.length() == 0) goto L11;
        r103 = false;
        goto L12
    }
}
