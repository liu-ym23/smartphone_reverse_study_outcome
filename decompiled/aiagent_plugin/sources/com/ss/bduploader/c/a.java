package com.ss.bduploader.c;

import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.i.l;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.bduploader.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BDUrlDispatch.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String TAG = "ttmn";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f37483d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f37484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f37485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReentrantReadWriteLock f37486c;

    public a() {
        this.f37486c = new ReentrantReadWriteLock();
        this.f37484a = -1;
        this.f37485b = null;
    }

    public static a a() {
        if (f37483d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f37483d != null) goto L9;
        f37483d = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f37483d;
    }

    public String a(String r3, String r4) {
        this.f37486c.writeLock().lock();
        this.f37484a = -1;
        String r5 = c(r3, r4);     // Catch: Exception -> L5
    L10:
        this.f37486c.writeLock().unlock();
        return r5;
    L5:
        e = move-exception;
        e.printStackTrace();
        b(TAG, e.toString());
        if (t.f == null) goto L9;
        r5 = t.f.a(r3, r4);
        goto L10
    L9:
        r5 = null;
        goto L10
    }

    private String c(String r18, String r19) {
        String r1 = r18;
        b(TAG, "url is " + r1 + ", method:" + r19);
        Class r3 = ZeusTransformUtils.forName("com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher", "com.obric.aiagent.plugin");
        Object r8 = r3.getMethod("inst", new Class[0]).invoke(null, new Object[0]);
        Boolean r9 = (Boolean) ZeusTransformUtils.preCheckCast(r3.getMethod("isDispatchActionsEmpty", new Class[0]).invoke(r8, new Object[0]), Boolean.class, "com.obric.aiagent.plugin");
        this.f37485b = (String) ZeusTransformUtils.preCheckCast(r3.getMethod("getTncEtag", new Class[0]).invoke(r8, new Object[0]), String.class, "com.obric.aiagent.plugin");
        b(TAG, "isDispatchActionsEmpty:" + r9 + "getTncEtag:" + this.f37485b);
        if (r9.booleanValue() == true) goto L18;
        b(TAG, "isDispatchActionsEmpty" + r9);
        long r10 = System.currentTimeMillis();
        Class<?> r11 = ZeusTransformUtils.forName("com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest", "com.obric.aiagent.plugin");
        Object r2 = r3.getMethod("getDispatchResultForUrl", new Class[]{r11}).invoke(r8, new Object[]{r11.getConstructor(new Class[]{String.class, String.class}).newInstance(new Object[]{r1, r19})});
        this.f37484a = System.currentTimeMillis() - r10;
        b(TAG, "dispatchTime:" + this.f37484a);
        if (r2 == null) goto L23;
        Class r0 = ZeusTransformUtils.forName("com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult", "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r0.getField("mDispatchedURL").get(r2), String.class, "com.obric.aiagent.plugin");
        if (r1.equals(r4) == true) goto L23;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r0.getField("mActionRuleIdList").get(r2), List.class, "com.obric.aiagent.plugin");
        if (r4.isEmpty() == false) goto L16;
        if (r5.isEmpty() == true) goto L16;
        throw new Exception("ERR_TTNET_TRAFFIC_CONTROL_DROP, -555");
    L16:
        if (l.b(r4) == false) goto L23;
        r1 = r4;
    L23:
        b(TAG, "url is " + r1);
        return r1;
    L18:
        b(TAG, "fallback to host replace map");
        long r12 = System.currentTimeMillis();
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3.getMethod("handleHostMapping", new Class[]{String.class}).invoke(r8, new Object[]{r1}), String.class, "com.obric.aiagent.plugin");
        this.f37484a = System.currentTimeMillis() - r12;
        b(TAG, "dispatchTime:" + this.f37484a);
        if (r1.equals(r6) == true) goto L23;
        if (l.b(r6) == false) goto L23;
        r1 = r6;
        goto L23
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
