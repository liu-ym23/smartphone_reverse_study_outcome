package com.c.a.d;

import android.content.Context;
import com.bytedance.apm.h.e;
import com.c.a.i.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, Long> f11901a;

    public abstract String b();

    public abstract boolean d(com.c.a.c.a r1);

    public a() {
    }

    static {
        f11901a = new ConcurrentHashMap();
    }

    @Override // com.c.a.d.b
    public synchronized boolean a(com.c.a.c.a r7) {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (b().equals(r7.getType()) == true) goto L36;
        monitor-exit(this);
        return false;
    L36:
    L28:
        e = move-exception;
        a(e.getMessage(), r7);     // Catch: Throwable -> L32
        return false;
    L24:
        e = move-exception;
        a(String.format("系统错误：%s", new Object[]{com.c.a.i.a.a(e)}), r7);     // Catch: Throwable -> L32
        return false;
    L10:
        if (a() == false) goto L15;
        e(r7);     // Catch: Exception -> L24 com.c.a.c.b -> L28 Throwable -> L32
        monitor-exit(this);
        return true;
    L15:
        if (f(r7) == true) goto L17;
    L21:
        e.d("cloudmessage", new String[]{"checkCmdInterval false: ignored for now."});     // Catch: Exception -> L24 com.c.a.c.b -> L28 Throwable -> L32
        monitor-exit(this);
        return false;
    L17:
        if (b(r7) == false) goto L21;
        e.d("cloudmessage", new String[]{"start handle message:" + r7});     // Catch: Exception -> L24 com.c.a.c.b -> L28 Throwable -> L32
        boolean r8 = d(r7);     // Catch: Exception -> L24 com.c.a.c.b -> L28 Throwable -> L32
        monitor-exit(this);
        return r8;
    }

    public boolean b(com.c.a.c.a r3) {
        if (com.c.a.g.b.a().a(r3.d()) == true) goto L5;
        return true;
    L5:
        if (c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L10;
        com.c.a.g.a.a("产物超过阈值，等待WiFi环境执行", r3);
        return false;
    L10:
        return true;
    }

    public boolean a() {
        if (com.c.a.a.i() == null) goto L11;
        String[] r0 = com.c.a.a.i();
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        if (b().equals(r0[r3]) == true) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    private void e(com.c.a.c.a r7) {
        com.c.a.h.b.b r6 = new com.c.a.h.b.b(0, false, r7.d(), null);
        r6.a(3);
        r6.a("当前云控指令已被sdk禁用");
        com.c.a.h.a.a(r6);
    }

    private boolean f(com.c.a.c.a r5) {
        String r4 = r5.d();
        if (f11901a.containsKey(r4) == false) goto L9;
        long r0 = ((Long) ZeusTransformUtils.preCheckCast(f11901a.get(r4), Long.class, "com.obric.aiagent.plugin")).longValue();
        if ((System.currentTimeMillis() - r0) >= 10000) goto L8;
        return false;
    L8:
        f11901a.put(r4, Long.valueOf(System.currentTimeMillis()));
        return true;
    L9:
        f11901a.put(r4, Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    public boolean a(JSONObject r8, com.c.a.c.a r9) {
        if (r8.optBoolean("wifiOnly", false) == true) goto L5;
    L8:
        return false;
    L5:
        if (c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L8;
        com.c.a.h.b.b r7 = new com.c.a.h.b.b(0, false, r9.d(), null);
        r7.a(0);
        r7.a("4G环境下不执行指令");
        com.c.a.h.a.a(r7);
        return true;
    }

    public void a(String r7, com.c.a.c.a r8) {
        com.c.a.h.b.b r6 = new com.c.a.h.b.b(0, false, r8.d(), null);
        r6.a(3);
        r6.a(r7);
        com.c.a.h.a.a(r6);
    }

    public void c(com.c.a.c.a r7) {
        com.c.a.h.b.b r6 = new com.c.a.h.b.b(0, false, r7.d(), null);
        r6.a(2);
        com.c.a.h.a.a(r6);
    }

    public void a(String r7, HashMap<String, String> r8, com.c.a.c.a r9) {
        com.c.a.h.b.b r6 = new com.c.a.h.b.b(0, false, r9.d(), r8);
        r6.a(3);
        r6.a(r7);
        com.c.a.h.a.a(r6);
    }
}
