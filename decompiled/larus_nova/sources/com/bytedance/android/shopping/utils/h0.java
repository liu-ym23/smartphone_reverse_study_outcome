package com.bytedance.android.shopping.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.g2;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.OpenAppActivity;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187145a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f187146a;

        public a(Function2 r100) {
            this.f187146a = r100;
        }
    }

    static {
    }

    public static void a(Context r100, String r101) {
        int r102 = f0.f187080a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        int r103 = m0.f187153a;
        String r104 = r100.getString(R.string.taobao_default_title);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter("title", "key");
        Intrinsics.checkNotNullParameter(r104, "value");
        g2 r105 = new g2(r101);
        r105.a("title", r104);
        String r106 = r105.b();
        Activity r107 = com.bytedance.android.shopping.anchorv3.utils.d0.f165305a.getActivity(r100);
        if (r107 == null) goto L6;
        jj.a.C6443a.b(com.bytedance.android.ec.sdk.helper.p.f48130a, r106, r107, null, 28);
        return;
    }

    public static void b(Context r110, String r111, String r112, String r113, String r114, String r115, String r116, Function2 r117) {
        OpenAppActivity.a r100 = OpenAppActivity.f164108k;
        r100.getClass();
        OpenAppActivity.f164106i = false;
        Ref.BooleanRef r101 = new Ref.BooleanRef();
        r101.element = false;
        if (TextUtils.isEmpty(r112) == true) goto L5;
    L12:
        r100.startActivity(r110, r112, r113, r114, r115, r116, Long.valueOf(System.currentTimeMillis()));
        r101.element = true;
    L31:
        new HashMap().put(ILiveRoomPlayFragmentConstant.EXTRA_BACK_URL, "taobao://openapp.aweme.sdk.com");     // Catch: Throwable -> L23
        int r102 = com.bytedance.android.shopping.utils.a.f187044a;     // Catch: Throwable -> L23
        a r103 = new a(r117);     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r111, "url");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r103, "callback");     // Catch: Throwable -> L19
        return;
    L19:
        th = th;
    L25:
        a(r110, r111);
        MonitorUtils.monitorEvent("goods_alibc_open_error_rate", new JSONObject().put("status", 1), null, null);
        ECExceptionMonitor.f(th, "Jump to Taobao failed");
        return;
    L21:
        th = th;
    L23:
        th = th;
        goto L25
    L5:
        if (TextUtils.isEmpty(r113) == false) goto L12;
        if (TextUtils.isEmpty(r114) == false) goto L12;
        if (TextUtils.isEmpty(r115) == false) goto L12;
        if (TextUtils.isEmpty(r116) == true) goto L31;
        goto L12
    }

    public static void c(Context r110, String r111, String r112, String r113, String r114, String r115, String r116, Function2 r117) {
        Intrinsics.checkNotNullParameter(r110, "fromAct");
        Intrinsics.checkNotNullParameter(r111, "url");
        if (ita.k.h(r110, "com.taobao.taobao") == false) goto L17;
        n1.f45660i.getClass();
        if (n1.f45659h == false) goto L12;
        n1.f45659h = false;
        int r100 = com.bytedance.android.shopping.utils.a.f187044a;     // Catch: Throwable -> L9
        g0 r118 = new g0(r110, r111, r112, r113, r114, r115, r116, r117);     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r118, "callback");     // Catch: Throwable -> L9
        r118.a();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        MonitorUtils.monitorEvent("goods_alibc_init_error_rate", new JSONObject().put("status", 1), null, null);
        ECExceptionMonitor.f(th, "Baichuan SDK not init");
        th.printStackTrace();
        return;
    L12:
        if (n1.f45658g == false) goto L14;
        b(r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    L14:
        a(r110, r111);
        if (r117 == null) goto L25;
        Unit r101 = (Unit) r117.invoke(Boolean.FALSE, Boolean.TRUE);
        return;
    L25:
        return;
    L17:
        a(r110, r111);
        if (r117 == null) goto L27;
        Unit r102 = (Unit) r117.invoke(Boolean.FALSE, Boolean.TRUE);
        return;
    }
}
