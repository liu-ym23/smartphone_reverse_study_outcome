package com.smartisanos.appstore.apm;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.i;
import ec.d;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ApmHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ApmHelper f17867a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f17868b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f17869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Runnable f17870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f17871e;

    public static final class a implements IDynamicParams {
        public a() {
        }

        @Override // com.bytedance.apm.core.IDynamicParams
        public Map getCommonParams() {
            HashMap r10 = new HashMap();
            r10.put(CommonKey.KEY_REGION, "CN");
            i.e(ApmHelper.b(), "getCommonParams ");
            return r10;
        }

        @Override // com.bytedance.apm.core.IDynamicParams
        public String getSessionId() {
            i.e(ApmHelper.b(), "getSessionId ");
            return "";
        }

        @Override // com.bytedance.apm.core.IDynamicParams
        public long getUid() {
            i.e(ApmHelper.b(), "getUid ");
            return 0;
        }
    }

    public static final class b implements IConfigChangeListener {
        public b() {
        }

        @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
        public void onConfigChanged(JSONObject r10, boolean r11) {
            g3.a.g().l(this);
            ApmHelper.c(ApmHelper.f17867a);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f17872a;

        public c(Application r10) {
            this.f17872a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            re.a.q(ApmHelper.b(), "checkConditionRunnable getDid1");
            String r10 = d.f19371l.a().t();
            i.e(ApmHelper.b(), "checkConditionRunnable getDid2");
            if (r10 == null) goto L28;
            int r11 = r10.length() - 1;
            int r12 = 0;
            boolean r13 = false;
        L5:
            if (r12 > r11) goto L21;
            if (r13 == true) goto L8;
            int r14 = r12;
        L10:
            if (q.i(r10.charAt(r14), 32) > 0) goto L12;
            boolean r15 = true;
        L13:
            if (r13 == false) goto L14;
            if (r15 == false) goto L21;
            r11 = r11 - 1;
            goto L5
        L14:
            if (r15 == false) goto L15;
            r12 = r12 + 1;
            goto L5
        L15:
            r13 = true;
            goto L5
        L12:
            r15 = false;
            goto L13
        L8:
            r14 = r11;
        L21:
            if (r10.subSequence(r12, r11 + 1).toString().length() == 0) goto L28;
            if (q.b(r10, AdReportParam.ClickPosType.SKIP) == true) goto L28;
            if (q.b(r10, "-1") == true) goto L28;
            ApmHelper.f17867a.e(this.f17872a, "560514", r10);
            return;
        L28:
            ApmHelper.a().postDelayed(this, 1000);
        }
    }

    static {
        f17867a = new ApmHelper();
        f17868b = "ApmHelper";
        f17869c = new Handler(Looper.getMainLooper());
    }

    public ApmHelper() {
    }

    public static final /* synthetic */ Handler a() {
        return f17869c;
    }

    public static final /* synthetic */ String b() {
        return f17868b;
    }

    public static final /* synthetic */ void c(ApmHelper r10) {
        r10.h();
    }

    public final void d(Context r10, boolean r11) {
        q.g(r10, "context");
        w0.b.a().b(r10, h1.b.a().H(true).I(new r1.c.a().d().c().e().b().f(20000).a()).J(true).G(1000).F(r11).E());
        w0.c.i0(false);
        w0.c.h0(true);
    }

    public final void e(Context r10, String r11, String r12) {
        q.g(r10, "context");
        q.g(r11, "appId");
        q.g(r12, "did");
        h.d(d0.b(), l0.c(), null, new ApmHelper$initAndStartApm$1(r10, r11, r12, null), 2, null);
    }

    public final void f(Context r10) {
        if (f17871e == false) goto L10;
        return;
    L10:
        IntentFilter r11 = new IntentFilter();     // Catch: Exception -> L7
        r11.addAction("android.intent.action.SCREEN_ON");     // Catch: Exception -> L7
        r11.addAction("android.intent.action.SCREEN_OFF");     // Catch: Exception -> L7
        r10.getApplicationContext().registerReceiver(new ApmHelper$registerScreenReceiver$1(), r11);     // Catch: Exception -> L7
        f17871e = true;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        re.a.k(f17868b, "registerScreenReceiver error", e);
    }

    public final void g(Context r10, int r11, String r12) {
        q.g(r10, "context");
        q.g(r12, "did");
        fc.a r13 = fc.a.f19643a;
        String r14 = r13.a();
        re.a.q(f17868b, "startApm channel:" + r14);
        w0.b.a().c(h1.c.a().a(r11).b("1.0.3").g(r13.a()).h(r12).m("100003070").i(new a()).c(true).d(true).l(true).e(PerfConsts.DEFAULT_BLOCK_INTERVAL_MS).n(new v9.b()).f());
        g3.a.g().k(new b());
        h();
        f(r10);
    }

    public final void h() {
        Result.a r10 = Result.Companion;     // Catch: Throwable -> L4
        Result.m35constructorimpl(y3.a.a(MemoryCollector.class, "stop", new Object[]{MemoryCollector.getInstance()}));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.a r11 = Result.Companion;
        Result.m35constructorimpl(kotlin.c.a(th));
    }

    public final void i(Application r10) {
        q.g(r10, ServerElements.APP);
        c r11 = new c(r10);
        f17870d = r11;
        f17869c.post(r11);
    }
}
