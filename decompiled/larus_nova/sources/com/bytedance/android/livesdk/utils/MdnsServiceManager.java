package com.bytedance.android.livesdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.NetworkCapabilities;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.b80;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import io.reactivex.disposables.Disposable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class MdnsServiceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Pair<Disposable, c>> f158765a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, d> f158766b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MdnsServiceManager f158767c = null;

    public static final class a {
        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
        }
    }

    public interface b {
        void c(String r100);

        void d(String r100);

        void e(NsdServiceInfo r100, a r101);

        void f(String r100);
    }

    public interface c {
        void a();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f158768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f158769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f158770c;

        public d() {
            this.f158770c = 0;
            this.f158768a = "";
        }
    }

    public MdnsServiceManager() {
    }

    static {
        f158767c = new MdnsServiceManager();
        f158765a = new ConcurrentHashMap();
        f158766b = new ConcurrentHashMap();
    }

    public static String a(Context r110) {
        if (Intrinsics.areEqual(b80.f119848a.getValue(), Boolean.FALSE) == false) goto L7;
        return "setting disable";
    L7:
        if (r110 != null) goto L52;
        Object r111 = null;
    L13:
        if ((r111 instanceof ConnectivityManager) == true) goto L15;
        r111 = null;
    L15:
        ConnectivityManager r112 = (ConnectivityManager) r111;     // Catch: Throwable -> L9
        if (r112 != null) goto L18;
    L48:
        return "VERSION.SDK_INT < Q";
    L18:
        if (Build.VERSION.SDK_INT < 29) goto L48;
        NetworkCapabilities r100 = r112.getNetworkCapabilities(r112.getActiveNetwork());     // Catch: Throwable -> L9
        boolean r101 = true;
        if (r100 != null) goto L22;
    L23:
        if (r100 != null) goto L25;
    L27:
        r101 = false;
    L28:
        if (r101 == false) goto L63;
        LinkProperties r113 = r112.getLinkProperties(r112.getActiveNetwork());     // Catch: Throwable -> L9
        if (r113 == null) goto L59;
        List<LinkAddress> r114 = r113.getLinkAddresses();     // Catch: Throwable -> L9
        if (r114 == null) goto L60;
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L9
        Iterator<T> r115 = r114.iterator();     // Catch: Throwable -> L9
    L35:
        if (r115.hasNext() == false) goto L43;
        Object r103 = r115.next();     // Catch: Throwable -> L9
        LinkAddress r104 = (LinkAddress) r103;     // Catch: Throwable -> L9
        if (r104 == null) goto L39;
        InetAddress r105 = r104.getAddress();     // Catch: Throwable -> L9
    L41:
        if ((r105 instanceof Inet4Address) == false) goto L35;
        r102.add(r103);     // Catch: Throwable -> L9
        goto L35
    L39:
        r105 = null;
        goto L41
    L43:
        String r116 = CollectionsKt.joinToString$default(r102, null, null, null, 0, null, MdnsServiceManager$getWIfiLocalIp$2.INSTANCE, 31, null);     // Catch: Throwable -> L9
        if (r116 != null) goto L62;
        return "";
    L62:
        return r116;
    L9:
        th = move-exception;
        ALogger.e("MdnsServiceManager", th);
        return "";
    L60:
        return "";
    L59:
        return "";
    L63:
        return "not wifi";
    L25:
        if (r100.hasTransport(5) != true) goto L27;
    L22:
        if (r100.hasTransport(1) == true) goto L28;
    L52:
        r111 = r110.getSystemService("connectivity");     // Catch: Throwable -> L9
        goto L13
    }

    public static void b(String r110, Context r111) {
        d r100 = f158766b.get(r110);
        if (r100 == null) goto L30;
        LiveMonitor.a r101 = new LiveMonitor.a("ttlive_anchor_prefix_discover_services", LiveTracingMonitor.EventModule.PREVIEW);
        r101.f64904g = true;
        JSONObject r102 = new JSONObject();
        r102.put("message", r100.f158768a);
        r102.put("code", r100.f158769b);
        r101.k(r102);
        r101.l(r100.f158770c);
        r101.a().report();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L24
        IMiddlewareUserService r104 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);     // Catch: Throwable -> L24
        if (r104 == null) goto L11;
        com.bytedance.android.livesdk.user.e r105 = r104.user();     // Catch: Throwable -> L24
        if (r105 == null) goto L11;
        String r106 = r105.n();     // Catch: Throwable -> L24
        if (r106 == null) goto L11;
    L12:
        int r107 = r100.f158770c;     // Catch: Throwable -> L24
        if (r107 != 1) goto L15;
        String r108 = "start success";
    L22:
        String r112 = a(r111);     // Catch: Throwable -> L24
        ALogger.i("MdnsServiceManager", r112);     // Catch: Throwable -> L24
        int r109 = com.bytedance.android.live.core.monitor.trace.e.f64997m;     // Catch: Throwable -> L24
        com.bytedance.android.live.core.monitor.trace.e.a r113 = com.bytedance.android.live.core.monitor.trace.e.b.a("ttlive_anchor_prefix_discover_services", NewBroadcastMonitor.BUSINESSTYPE.CORE);     // Catch: Throwable -> L24
        r113.f65017h = 0;     // Catch: Throwable -> L24
        r113.f65012c = "webcast_client_broadcast";     // Catch: Throwable -> L24
        r113.f65018i = r108;     // Catch: Throwable -> L24
        r113.f65016g = r106;     // Catch: Throwable -> L24
        com.bytedance.android.live.core.monitor.trace.e r114 = r113.a();     // Catch: Throwable -> L24
        JSONObject r115 = new JSONObject();     // Catch: Throwable -> L24
        r115.put("service_type", r110);     // Catch: Throwable -> L24
        r115.put("status_code", r100.f158770c);     // Catch: Throwable -> L24
        r115.put("local", r112);     // Catch: Throwable -> L24
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L24
        JSONObject r117 = new JSONObject();     // Catch: Throwable -> L24
        r117.put("message", r100.f158768a);     // Catch: Throwable -> L24
        r117.put("code", r100.f158769b);     // Catch: Throwable -> L24
        a60.e r118 = com.bytedance.android.live.core.monitor.trace.c.f64995a;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r114, "traceMeta");     // Catch: Throwable -> L24
        TraceMonitor.i(r114, r115, r117, null);     // Catch: Throwable -> L24
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        f158766b.remove(r110);
        ALogger.i("MdnsServiceManager", "reportTrace");
        return;
    L15:
        if (r107 != 2) goto L17;
        r108 = "found service success";
        goto L22
    L17:
        if (r107 == 3) goto L19;
        r108 = "discovery failed,statusCode = " + r100.f158770c;     // Catch: Throwable -> L24
        goto L22
    L19:
        r108 = "resolve service success";
    L11:
        r106 = "0";
    L24:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    public final synchronized boolean c(Context r100, String r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L30
        Intrinsics.checkNotNullParameter(r101, NsdHelper.serviceTypeKey);     // Catch: Throwable -> L30
        ConcurrentHashMap<String, Pair<Disposable, c>> r102 = f158765a;     // Catch: Throwable -> L30
        if (r102.containsKey(r101) == true) goto L9;
        b(r101, r100);     // Catch: Throwable -> L30
        monitor-exit(this);
        return false;
    L9:
        Pair<Disposable, c> r103 = r102.get(r101);     // Catch: Throwable -> L30
        if (r103 == null) goto L34;
        Disposable r104 = r103.getFirst();     // Catch: Throwable -> L30
        if (r104 == null) goto L34;
        if ((!r104.isDisposed()) == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L34;
        r104.dispose();     // Catch: Throwable -> L30
    L34:
        Pair<Disposable, c> r105 = r102.get(r101);     // Catch: Throwable -> L25
        if (r105 == null) goto L27;
        c r106 = r105.getSecond();     // Catch: Throwable -> L25
        if (r106 == null) goto L27;
        r106.a();     // Catch: Throwable -> L25
    L27:
        f158765a.remove(r101);     // Catch: Throwable -> L30
        b(r101, r100);     // Catch: Throwable -> L30
        ALogger.i("MdnsServiceManager", "stopDiscovery");     // Catch: Throwable -> L30
        monitor-exit(this);
        return true;
    L25:
        th = move-exception;
        ALogger.e("MdnsServiceManager", th);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }
}
