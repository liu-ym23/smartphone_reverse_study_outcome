package com.bytedance.bdinstall.d;

import android.content.Context;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DRCommonHeader.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    private static final String TAG = "DRCommonHeader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f6217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final an f6218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, d> f6219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f6221e;
    private boolean f;
    private com.bytedance.bdinstall.u g;
    private int h;

    public i(Context r4, an r5, com.bytedance.bdinstall.u r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f6219c = new LinkedHashMap(32);
        this.f6220d = false;
        this.h = 0;
        this.f6221e = new JSONObject();
        this.f6217a = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        this.g = r6;
        this.f6218b = r5;
    }

    public synchronized boolean a() {
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L4:
        if (c() == false) goto L9;
        com.bytedance.bdinstall.t.a("DRCommonHeaderload: mAllReady is true  header : " + b());     // Catch: Throwable -> L35
        monitor-exit(this);
        return true;
    L9:
        if (this.f6220d == true) goto L11;
        this.f6220d = true;     // Catch: Throwable -> L35
        this.f6219c.put(e.class, new e(this.f6217a));     // Catch: Throwable -> L35
        this.f6219c.put(o.class, new o(this.f6217a));     // Catch: Throwable -> L35
        this.f6219c.put(u.class, new u(this.f6217a));     // Catch: Throwable -> L35
        this.f6219c.put(x.class, new x());     // Catch: Throwable -> L35
        this.f6219c.put(s.class, new s(this.f6217a, this.f6218b));     // Catch: Throwable -> L35
        this.f6219c.put(aa.class, new aa(this.f6217a, this.f6218b));     // Catch: Throwable -> L35
        this.f6219c.put(n.class, new n(this.f6217a, this.f6218b, this.g));     // Catch: Throwable -> L35
        this.f6219c.put(p.class, new p(this.f6217a, this.f6218b));     // Catch: Throwable -> L35
    L11:
        JSONObject r0 = b();     // Catch: Throwable -> L35
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L35
        ba.a(r2, r0);     // Catch: Throwable -> L35
        Iterator<d> r1 = this.f6219c.values().iterator();     // Catch: Throwable -> L35
        boolean r3 = true;
    L13:
        if (r1.hasNext() == false) goto L32;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r1.next(), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        if (r4.f6209a == true) goto L17;
    L40:
        r4.b(r2);     // Catch: JSONException -> L22 SecurityException -> L38 Throwable -> L35
        r4.f6209a = r4.a(r2);     // Catch: JSONException -> L22 SecurityException -> L38 Throwable -> L35
    L22:
        e = move-exception;
        com.bytedance.bdinstall.t.a(e);     // Catch: Throwable -> L35
    L25:
        if (r4.f6209a == false) goto L27;
    L30:
        boolean r5 = true;
    L31:
        r3 = r3 & r5;     // Catch: Throwable -> L35
        this.f6221e = r2;     // Catch: Throwable -> L35
        com.bytedance.bdinstall.t.a("DRCommonHeaderload: allReady : " + r3 + " mHeader : " + this.f6221e);     // Catch: Throwable -> L35
        this.f = r3;     // Catch: Throwable -> L35
        goto L13
    L27:
        if (r4.f6210b == true) goto L30;
        r5 = false;
        goto L31
    L17:
        if (r4.f6211c == true) goto L40;
        if (a(r4) == false) goto L25;
    L32:
        boolean r6 = this.f;     // Catch: Throwable -> L35
        monitor-exit(this);
        return r6;
    }

    public JSONObject b() {
        return this.f6221e;
    }

    public boolean c() {
        return this.f;
    }

    private boolean a(d r3) {
        if (ba.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6218b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (com.bytedance.bdinstall.t.a() == false) goto L11;
        com.bytedance.bdinstall.t.a("needSyncFromSub " + r3 + " " + r2);
    L11:
        return r2;
    L5:
        if (r3.f6212d == false) goto L7;
        r2 = true;
        goto L9
    }
}
