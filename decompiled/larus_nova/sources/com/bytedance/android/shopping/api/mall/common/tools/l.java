package com.bytedance.android.shopping.api.mall.common.tools;

import android.os.SystemClock;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f170445a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f170446a;

        public a(JSONObject r100) {
            this.f170446a = r100;
        }

        public final void a() {
            l r100 = l.f170445a;
            JSONObject r101 = this.f170446a;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "params");
            l.c(r101);
            l.d(r101);
            IHybridHostService r102 = com.bytedance.android.ec.hybrid.a.h();
            if (r102 == null) goto L8;
            yj.g r103 = r102.getHostAB();
            if (r103 == null) goto L9;
            r103.l();
            return;
        L9:
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

    public l() {
    }

    static {
        f170445a = new l();
    }

    public static void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.bytedance.android.ec.hybrid.a.d().submit(new a(r100));
    }

    public static void c(JSONObject r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        JSONObject r102 = r100.optJSONObject("detail");     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        Iterator<String> r103 = r102.keys();     // Catch: Throwable -> L12
    L6:
        if (r103.hasNext() == false) goto L8;
        String r104 = r103.next();     // Catch: Throwable -> L12
        r100.putOpt(r104, r102.opt(r104));     // Catch: Throwable -> L12
        goto L6
    L8:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L12
        return;
    L9:
        r105 = null;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void d(JSONObject r100) {
        Long r101 = HybridAppInfoService.f47545p.f();
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
        r100.putOpt("t_app_launch_time", Long.valueOf(System.currentTimeMillis() - (SystemClock.uptimeMillis() - r102)));
    L5:
        r100.putOpt(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        AppLogNewUtils.onEventV3("ies_ecommerce_client_custom_log", r100);
    }

    public static void b(l r100, JSONObject r101, Integer r102, boolean r103, int r104) {
        boolean r105 = false;
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r105 = true;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "params");
        com.bytedance.android.ec.hybrid.a.d().submit(new m(r101, r102, r103, r105));
    }
}
