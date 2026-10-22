package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.net.nsd.NsdManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.MdnsServiceManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.startDiscoveryService")
public final class z6 extends l<d7, LiveStartDiscoveryServiceResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f63750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f63751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f63752c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        this.f63750a.clear();
        super.onDestroy();
    }

    public z6() {
        this.f63750a = new CompositeDisposable();
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        this.f63751b = r100;
        this.f63752c = new CompositeDisposable();
        return;
    L5:
        if (com.bytedance.android.livesdk.h1.f132623a.getValue().booleanValue() == false) goto L7;
        r100 = true;
        goto L8
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        d7 r112 = (d7) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = r112.b();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        finishWithFailure();
        return;
    L11:
        String r102 = r112.a();
        if (r102 != null) goto L14;
        r102 = "";
    L14:
        String r103 = r112.b();
        Integer r113 = r112.c();
        if (r113 == null) goto L17;
        long r104 = r113.intValue();
    L18:
        MdnsServiceManager r114 = MdnsServiceManager.f158767c;
        Intrinsics.checkNotNull(r103);
        Context r105 = r111.getContext();
        a7 r106 = new a7(this, r111, r102);
        Intrinsics.checkNotNullParameter(r102, "serviceName");
        Intrinsics.checkNotNullParameter(r103, NsdHelper.serviceTypeKey);
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r106, "callback");
        ConcurrentHashMap<String, Pair<Disposable, MdnsServiceManager.c>> r107 = MdnsServiceManager.f158765a;
        if (r107.get(r103) == null) goto L21;
        r114.c(r105, r103);
    L21:
        ConcurrentHashMap<String, MdnsServiceManager.d> r115 = MdnsServiceManager.f158766b;
        if (r115.containsKey(r103) == true) goto L24;
        r115.put(r103, new MdnsServiceManager.d());
    L24:
        Object r116 = r105.getSystemService("servicediscovery");
        if ((r116 instanceof NsdManager) == true) goto L27;
        r116 = null;
    L27:
        NsdManager r117 = (NsdManager) r116;
        if (r117 != null) goto L30;
        r106.f("get nsdManager failed");
    L41:
        this.f63750a.add(Observable.timer(r104, TimeUnit.MILLISECONDS).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new b7(this, r111, r103), c7.f63339a));
        return;
    L30:
        ALogger.i("MdnsServiceManager", "startDiscovery  manager = " + r117);
        com.bytedance.android.livesdk.utils.x4 r108 = new com.bytedance.android.livesdk.utils.x4(r106, r103, r102, r117);
        r117.discoverServices(r103, 1, r108);     // Catch: Throwable -> L33
        r107.put(r103, new Pair(Observable.timer(r104, TimeUnit.MILLISECONDS).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.utils.v4(r105, r103), com.bytedance.android.livesdk.utils.w4.f159203a), new com.bytedance.android.livesdk.utils.y4(r117, r108)));
    L33:
        th = move-exception;
        String r109 = th.getMessage();
        if (r109 != null) goto L37;
        r109 = "invoke discoverServices exception";
    L37:
        r106.f(r109);
        MdnsServiceManager.d r118 = MdnsServiceManager.f158766b.get(r103);
        if (r118 == null) goto L40;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r118.f158768a = r109;
    L40:
        MdnsServiceManager.b(r103, r105);
        ALogger.e("MdnsServiceManager", th);
        goto L41
    L17:
        r104 = 60000;
        goto L18
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }
}
