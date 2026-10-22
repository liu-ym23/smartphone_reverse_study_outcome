package b47;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.pia.core.utils.DefaultResourceLoader;
import com.bytedance.pia.core.utils.ThreadUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p47.h;
import p47.i;
import s47.e;
import s47.j;
import s47.n;

/* JADX INFO: loaded from: classes21.dex */
public class b extends s47.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static Context f17554y;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Config f17555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f17557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f17558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Uri f17559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f17560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m47.b f17561j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f17562k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i47.c f17563l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final g47.a f17564m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f17565n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object f17566o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, ?> f17567p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, String> f17568q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final j47.a f17569r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final u47.c f17570s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final i f17571t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.bytedance.pia.core.tracing.d f17572u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final OnlineTracing f17573v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f17574w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final j f17575x;

    public final void d(l47.b<Set<PiaMethod<?, ?>>> r100) {
        if (r100 != null) goto L15;
    L7:
        Set<PiaMethod<?, ?>> r101 = null;
    L8:
        if (r101 != null) goto L10;
        return;
    L10:
        Iterator<PiaMethod<?, ?>> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        final PiaMethod<?, ?> r103 = r102.next();
        final m47.b r104 = this.f17561j;
        r104.getClass();
        ThreadUtil.c(new m47.a(r104, r103));
        goto L12
    L14:
        return;
    L15:
        r101 = r100.create(this.f17566o);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        com.bytedance.pia.core.utils.d.d("[Runtime] create bridge method error:", th);
        goto L7
    }

    public final void e(List<l47.b<f47.a>> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<l47.b<f47.a>> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L14;
        l47.b<f47.a> r102 = r101.next();
        final f47.a r103 = r102.create(this.f17566o);     // Catch: Throwable -> L12
        if (r103 == null) goto L6;
        final h r104 = this.f17562k;     // Catch: Throwable -> L12
        r104.getClass();     // Catch: Throwable -> L12
        ThreadUtil.d(new p47.d(r104, r103));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        com.bytedance.pia.core.utils.d.d("[Runtime] create MetricsObserver error:", th);
        goto L6
    }

    public b(Uri r110, String r111, final String r112, Object r113, DefaultResourceLoader r114, g47.a r115, String r116, Config r117, Map r210, f47.c r211, e r212, j r213, Map r214, j47.a r215) {
        this.f17561j = new m47.b();
        com.bytedance.pia.core.tracing.d r100 = new com.bytedance.pia.core.tracing.d();
        this.f17572u = r100;
        OnlineTracing.a r101 = OnlineTracing.f266316r;
        monitor-enter(OnlineTracing.class);
        long r102 = OnlineTracing.f266316r.a(r111);     // Catch: Throwable -> L15
        monitor-exit(OnlineTracing.class);
        EventName r103 = EventName.NavigateStart;
        if (r102 != 0) goto L9;
        r102 = System.currentTimeMillis();
    L9:
        com.bytedance.pia.core.tracing.d.a r104 = new com.bytedance.pia.core.tracing.d.a(r100, r103, r102);
        r104.args.put("url", r110.toString());
        r104.a();
        this.f17555d = r117;
        this.f17556e = r112;
        this.f17558g = r111;
        if (UriProtector.getQueryParameterNames(r110).contains("_pia_") == false) goto L12;
        this.f17559h = r110;
    L13:
        this.f17560i = com.bytedance.pia.core.utils.j.g(r110, null);
        this.f17566o = r113;
        this.f17563l = r114;
        this.f17564m = r115;
        h r105 = new h(r110.toString());
        this.f17562k = r105;
        b(r105);
        this.f17567p = r210;
        this.f17568q = r214;
        this.f17569r = r215;
        this.f17570s = new u47.c(r111);
        this.f17571t = new i(r211);
        this.f17573v = new OnlineTracing(r111);
        this.f17574w = r212;
        this.f17575x = r213;
        this.f17565n = q47.h.f531676a + " " + r116;
        final n r106 = (n) this;
        ThreadUtil.d(new a(r106, r112));
        return;
    L12:
        this.f17559h = com.bytedance.pia.core.utils.j.a(r110);
    L15:
        th = move-exception;
        throw th;
    }
}
