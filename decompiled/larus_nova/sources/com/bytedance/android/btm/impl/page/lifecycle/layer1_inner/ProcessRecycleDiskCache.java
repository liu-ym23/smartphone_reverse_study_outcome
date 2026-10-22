package com.bytedance.android.btm.impl.page.lifecycle.layer1_inner;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.api.model.e;
import com.bytedance.android.btm.impl.BtmServiceImpl;
import com.bytedance.android.btm.impl.chain.BtmChainRecorder;
import com.bytedance.android.btm.impl.g;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.BufferQueue;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.i;
import com.bytedance.android.btm.impl.page.unknown.UnionChainRecorder;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.startnode.StartNodeManager;
import com.bytedance.android.btm.impl.util.SharedPreferenceUtil;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class ProcessRecycleDiskCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f42271a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f42272a = null;

        static {
            f42272a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ProcessRecycleDiskCache.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static SharedPreferenceUtil a() {
        return (SharedPreferenceUtil) f42271a.getValue();
    }

    static {
        f42271a = LazyKt.lazy(ProcessRecycleDiskCache$sharePreference$2.INSTANCE);
    }

    public static void c() {
        BtmHostDependManager r100 = BtmHostDependManager.F;
        r100.getClass();
        if (((Boolean) BtmHostDependManager.f41936d.getValue(r100, BtmHostDependManager.f41933a[2])).booleanValue() == true) goto L5;
    L7:
        d();
        return;
    L5:
        if (BtmSetting.f42469d.c().b().d() != 1) goto L7;
        ALogger.e(ALogger.f41996d, "ProcessRecycleDiskCache_downgrade", ProcessRecycleDiskCache$saveToCache$1.INSTANCE);
        com.bytedance.android.btm.impl.thread.b.f42488e.b(a.f42272a, true);
    }

    public static void d() {
        BtmChainRecorder r100 = com.bytedance.android.btm.impl.b.f42126e.c();
        r100.getClass();
        Unit r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L34
        SharedPreferenceUtil r103 = (SharedPreferenceUtil) r100.f42129b.getValue();     // Catch: Throwable -> L34
        if (r103 == null) goto L17;
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L34
        Map<String, String> r105 = r100.f42133f;     // Catch: Throwable -> L34
        monitor-enter(r105);     // Catch: Throwable -> L34
        Iterator<Map.Entry<String, String>> r106 = r100.f42133f.entrySet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r106.hasNext() == false) goto L11;
        Map.Entry<String, String> r107 = r106.next();     // Catch: Throwable -> L14
        r104.putOpt(r107.getKey(), r107.getValue());     // Catch: Throwable -> L14
        goto L9
    L11:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r105);     // Catch: Throwable -> L34
        r103.a("key_btm_chain", r104.toString());     // Catch: Throwable -> L34
        goto L17
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L17:
        SharedPreferenceUtil r109 = (SharedPreferenceUtil) r100.f42129b.getValue();     // Catch: Throwable -> L34
        if (r109 == null) goto L31;
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L34
        Map<String, e> r111 = BtmPageRecorder.f42222k;     // Catch: Throwable -> L34
        monitor-enter(r111);     // Catch: Throwable -> L34
        Iterator<Map.Entry<String, e>> r112 = r111.entrySet().iterator();     // Catch: Throwable -> L28
    L23:
        if (r112.hasNext() == false) goto L25;
        Map.Entry<String, e> r113 = r112.next();     // Catch: Throwable -> L28
        r110.putOpt(r113.getKey(), ((Gson) r100.f42128a.getValue()).toJson(r113.getValue()));     // Catch: Throwable -> L28
        goto L23
    L25:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r111);     // Catch: Throwable -> L34
        r109.a("btmId_btmPageInfo_map", r110.toString());     // Catch: Throwable -> L34
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L34
    L32:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L34
    L36:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L39;
        r117.printStackTrace();
    L39:
        UnionChainRecorder.a();
        SharedPreferenceUtil r118 = a();
        if (r118 == null) goto L42;
        r118.a("launch_id", com.bytedance.android.btm.impl.b.f42125d);
    L42:
        SharedPreferenceUtil r119 = a();
        if (r119 == null) goto L46;
        r119.a("last_btmId", com.bytedance.android.btm.impl.page.b.f42258d);
    L46:
        if (BtmSetting.f42469d.c().d().t() == 1) goto L96;
    L60:
        StartNodeManager.f();
        g r120 = BtmServiceImpl.INSTANCE.getSaveCacheCallback();
        if (r120 == null) goto L64;
        r120.a();
    L64:
        if (BtmSetting.f42469d.c().b().n() != 1) goto L107;
        String r121 = BufferQueue.f42231a;
        SharedPreferenceUtil r122 = a();
        if (r122 == null) goto L72;
        String r123 = BufferQueue.f42237g;
        BufferBtm r124 = BufferQueue.f42239i;
        if (r124 == null) goto L70;
        String r125 = r124.toString();
    L71:
        r122.a(r123, r125);
        goto L72
    L70:
        r125 = null;
    L72:
        SharedPreferenceUtil r126 = a();
        if (r126 == null) goto L79;
        i r127 = BtmPageLifecycleCallbackV2.f42319h;
        if (r127 == null) goto L77;
        String r128 = r127.toString();
    L78:
        r126.a("paused_info", r128);
        goto L79
    L77:
        r128 = null;
    L79:
        Map<String, PageInfoStack> r129 = fd.a.f476450a;
        SharedPreferenceUtil r130 = a();
        if (r130 != null) goto L98;
    L86:
        Object r131 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L88
    L91:
        if (Result.m9452exceptionOrNullimpl(r131) == null) goto L108;
        com.bytedance.android.btm.api.inner.g.a.b(BtmMonitor.f42161c, 1121, "SingletonCache", null, false, 28);
        return;
    L108:
        return;
    L88:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L91
    L98:
        JSONObject r133 = new JSONObject();     // Catch: Throwable -> L88
        Iterator r134 = ((LinkedHashMap) fd.a.f476450a).entrySet().iterator();     // Catch: Throwable -> L88
    L83:
        if (r134.hasNext() == false) goto L85;
        Map.Entry r135 = (Map.Entry) r134.next();     // Catch: Throwable -> L88
        r133.putOpt((String) r135.getKey(), r135.getValue());     // Catch: Throwable -> L88
        goto L83
    L85:
        r130.a("singleton_cache", r133.toString());     // Catch: Throwable -> L88
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L88
        goto L86
    L107:
        return;
    L96:
        Map<String, BufferBtm> r136 = BufferQueue.f42242l;     // Catch: Throwable -> L58
        JSONObject r137 = new JSONObject();     // Catch: Throwable -> L58
        Iterator<Map.Entry<String, BufferBtm>> r138 = r136.entrySet().iterator();     // Catch: Throwable -> L58
    L50:
        if (r138.hasNext() == false) goto L52;
        Map.Entry<String, BufferBtm> r139 = r138.next();     // Catch: Throwable -> L58
        r137.put(r139.getKey(), r139.getValue().toString());     // Catch: Throwable -> L58
        goto L50
    L52:
        SharedPreferenceUtil r140 = a();     // Catch: Throwable -> L58
        if (r140 == null) goto L55;
        r140.a("last_buffer_btm_map", r137.toString());     // Catch: Throwable -> L58
        Unit r141 = Unit.INSTANCE;     // Catch: Throwable -> L58
    L56:
        Result.m9449constructorimpl(r141);     // Catch: Throwable -> L58
        goto L60
    L55:
        r141 = null;
    L58:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L60
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L31:
        r115 = null;
    L34:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    }

    public static void b(PageInfoStack r100) {
        if (r100 == null) goto L4;
        final String r101 = r100.save();
    L5:
        ALogger.e(ALogger.f41996d, "ProcessRecycleDiskCache_saveInfoStack", new ProcessRecycleDiskCache$saveInfoStack$1(r101));
        SharedPreferenceUtil r102 = a();
        if (r102 == null) goto L12;
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        r102.a("page_info_stack", r101);
        return;
    L12:
        return;
    L4:
        r101 = null;
        goto L5
    }
}
