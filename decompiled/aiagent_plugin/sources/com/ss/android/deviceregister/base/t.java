package com.ss.android.deviceregister.base;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OaidWrapper.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile t f37389c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f37390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r f37391b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f37392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f37393e;
    private final AtomicBoolean f;
    private Future<q> g;
    private q h;

    static /* synthetic */ q a(t r0) {
        return r0.d();
    }

    public static t a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f37389c != null) goto L15;
        monitor-enter(t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f37389c != null) goto L9;
        f37389c = new t(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(t.class);     // Catch: Throwable -> L11
    L15:
        return f37389c;
    }

    private t(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        this.f = new AtomicBoolean(false);
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f37393e = r0;
        o r1 = p.a(r6);
        this.f37390a = r1;
        if (r1 == null) goto L5;
        this.f37392d = r1.b(r6);
    L6:
        this.f37391b = new r(r0);
        return;
    L5:
        this.f37392d = false;
        goto L6
    }

    public void a() {
        if (this.f.compareAndSet(false, true) == false) goto L6;
        this.g = com.bytedance.common.utility.a.a.c().submit(new AnonymousClass1(this));
        return;
    }

    private q d() {
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "Oaid#initOaid");
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "Oaid#initOaid exec");
        q r0 = this.f37391b.a();
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "Oaid#initOaid fetch=" + r0);
        if (r0 == null) goto L5;
        this.h = r0;
    L5:
        q r1 = a(this.f37393e, r0);
        if (r1 == null) goto L8;
        this.f37391b.a(r1);
    L8:
        if (r1 == null) goto L10;
        this.h = r1;
    L10:
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "Oaid#initOaid oaidModel=" + r1);
        return r1;
    }

    public Map<String, String> a(long r10) {
        Map<String, String> r3 = null;
        if (this.f37392d == true) goto L5;
        return null;
    L5:
        a();
        q r2 = this.h;
        if (r2 != null) goto L19;
        long r4 = SystemClock.elapsedRealtime();
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
    L16:
        th = move-exception;
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
        throw th;
    L9:
        if (ZeusTransformUtils.instanceOf(this.f37390a, h.class) == false) goto L11;
        r10 = r10 + 100;     // Catch: Throwable -> L13
    L11:
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "Oaid#getOaid timeoutMills=" + r10);     // Catch: Throwable -> L13
        q r11 = (q) ZeusTransformUtils.preCheckCast(this.g.get(r10, TimeUnit.MILLISECONDS), q.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
        r2 = r11;
    L19:
        if (r2 != null) goto L21;
        r2 = this.h;
    L21:
        if (r2 == null) goto L23;
        r3 = r2.a();
    L23:
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "Oaid#getOaid return apiMap=" + r3);
        return r3;
    }

    public String b() {
        a();
        q r3 = this.h;
        if (r3 == null) goto L5;
        String r4 = r3.f37382a;
    L6:
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "Oaid#getOaidId sOaidId = " + r4);
        return r4;
    L5:
        r4 = null;
        goto L6
    }

    public boolean c() {
        a();
        return this.f37392d;
    }

    private q a(Context r13, q r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        long r0 = SystemClock.elapsedRealtime();
        o r12 = this.f37390a;
        String r2 = null;
        if (r12 == null) goto L18;
        o.a r16 = r12.c(r15);
        if (r16 == null) goto L19;
        int r17 = -1;
        int r3 = 1;
        if (r14 == null) goto L10;
        r2 = r14.f37383b;
        r17 = r14.f.intValue() + 1;
    L10:
        if (TextUtils.isEmpty(r2) == false) goto L12;
        r2 = UUID.randomUUID().toString();
    L12:
        String r6 = r2;
        if (r17 <= 0) goto L16;
        r3 = r17;
    L16:
        long r18 = SystemClock.elapsedRealtime() - r0;
        long r1 = r16.f37381c;
        return new q(r16.f37379a, r6, Boolean.valueOf(r16.f37380b), Long.valueOf(r18), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r3), Long.valueOf(r1));
    L19:
        return null;
    L18:
        return null;
    }

    static void a(JSONObject r1, String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (r3 == null) goto L13;
        r1.put(r2, r3);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        return;
    }

    static <K, V> void a(Map<K, V> r2, K r3, V r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        if (r4 == null) goto L8;
        r5.put(r3, r4);
        return;
    L8:
        return;
    }

    static boolean a(Context r2, String r3) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo(r3, 128) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    static long a(String r0, long r1) {
        return Long.parseLong(r0);
    L4:
        e = move-exception;
        e.printStackTrace();
        return r1;
    }
}
