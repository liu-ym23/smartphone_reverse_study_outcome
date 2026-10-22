package com.alipay.sdk.m.k;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes28.dex */
public class a {

    /* JADX INFO: renamed from: com.alipay.sdk.m.k.a$a, reason: collision with other inner class name */
    public static final class C0482a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f25388a = "RecordPref";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f25389b = "alipay_cashier_statistic_record";

        /* JADX INFO: renamed from: com.alipay.sdk.m.k.a$a$a, reason: collision with other inner class name */
        public static final class C0483a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final LinkedHashMap<String, String> f25390a;

            public String a() {
                JSONArray r100 = new JSONArray();     // Catch: Throwable -> L8
                Iterator<Map.Entry<String, String>> r101 = this.f25390a.entrySet().iterator();     // Catch: Throwable -> L8
            L4:
                if (r101.hasNext() == false) goto L6;
                Map.Entry<String, String> r102 = r101.next();     // Catch: Throwable -> L8
                JSONArray r103 = new JSONArray();     // Catch: Throwable -> L8
                r103.put(r102.getKey()).put(r102.getValue());     // Catch: Throwable -> L8
                r100.put(r103);     // Catch: Throwable -> L8
                goto L4
            L6:
                return r100.toString();
            L8:
                th = move-exception;
                com.alipay.sdk.m.u.e.a(th);
                return new JSONArray().toString();
            }

            public C0483a() {
                this.f25390a = new LinkedHashMap();
            }

            public C0483a(String r100) {
                this.f25390a = new LinkedHashMap();
                JSONArray r101 = new JSONArray(r100);     // Catch: Throwable -> L8
                int r102 = 0;
            L5:
                if (r102 >= r101.length()) goto L14;
                JSONArray r103 = r101.getJSONArray(r102);     // Catch: Throwable -> L8
                this.f25390a.put(r103.getString(0), r103.getString(1));     // Catch: Throwable -> L8
                r102 = r102 + 1;
                goto L5
            L14:
                return;
            L8:
                th = move-exception;
                com.alipay.sdk.m.u.e.a(th);
            }
        }

        public C0482a() {
        }

        public static synchronized C0483a a(Context r100) {
            monitor-enter(C0482a.class);
            String r101 = j.a(null, r100, f25389b, null);     // Catch: Throwable -> L12
            if (TextUtils.isEmpty(r101) == false) goto L9;
            C0483a r102 = new C0483a();     // Catch: Throwable -> L12
            monitor-exit(C0482a.class);
            return r102;
        L9:
            C0483a r103 = new C0483a(r101);     // Catch: Throwable -> L12
            monitor-exit(C0482a.class);
            return r103;
        L12:
            th = move-exception;
            com.alipay.sdk.m.u.e.a(th);     // Catch: Throwable -> L16
            return new C0483a();
        L16:
            th = move-exception;
            throw th;
        }

        public static synchronized String b(Context r100) {
            monitor-enter(C0482a.class);
            com.alipay.sdk.m.u.e.b(f25388a, "stat peek");     // Catch: Throwable -> L20
            if (r100 != null) goto L9;
            monitor-exit(C0482a.class);
            return null;
        L9:
            C0483a r101 = a(r100);     // Catch: Throwable -> L20
            if (r101.f25390a.isEmpty() == false) goto L23;
            monitor-exit(C0482a.class);
            return null;
        L23:
            String r102 = r101.f25390a.entrySet().iterator().next().getValue();     // Catch: Throwable -> L16
            monitor-exit(C0482a.class);
            return r102;
        L16:
            th = move-exception;
            com.alipay.sdk.m.u.e.a(th);     // Catch: Throwable -> L20
            return null;
        L20:
            th = move-exception;
            throw th;
        }

        public static synchronized int a(Context r100, String r101) {
            monitor-enter(C0482a.class);
            com.alipay.sdk.m.u.e.b(f25388a, "stat remove " + r101);     // Catch: Throwable -> L32
            if (r100 != null) goto L7;
        L30:
            monitor-exit(C0482a.class);
            return 0;
        L7:
            if (TextUtils.isEmpty(r101) == true) goto L30;
            C0483a r102 = a(r100);     // Catch: Throwable -> L32
            if (r102.f25390a.isEmpty() == false) goto L36;
            monitor-exit(C0482a.class);
            return 0;
        L36:
            ArrayList r103 = new ArrayList();     // Catch: Throwable -> L26
            Iterator<Map.Entry<String, String>> r104 = r102.f25390a.entrySet().iterator();     // Catch: Throwable -> L26
        L15:
            if (r104.hasNext() == false) goto L19;
            Map.Entry<String, String> r105 = r104.next();     // Catch: Throwable -> L26
            if (r101.equals(r105.getValue()) == false) goto L15;
            r103.add(r105.getKey());     // Catch: Throwable -> L26
            goto L15
        L19:
            Iterator r106 = r103.iterator();     // Catch: Throwable -> L26
        L21:
            if (r106.hasNext() == false) goto L23;
            r102.f25390a.remove((String) r106.next());     // Catch: Throwable -> L26
            goto L21
        L23:
            a(r100, r102);     // Catch: Throwable -> L26
            int r107 = r103.size();     // Catch: Throwable -> L26
            monitor-exit(C0482a.class);
            return r107;
        L26:
            th = move-exception;
            com.alipay.sdk.m.u.e.a(th);     // Catch: Throwable -> L32
            int r108 = r102.f25390a.size();     // Catch: Throwable -> L32
            a(r100, new C0483a());     // Catch: Throwable -> L32
            return r108;
        L32:
            th = move-exception;
            throw th;
        }

        public static synchronized void a(Context r100, C0483a r101) {
            monitor-enter(C0482a.class);
            if (r101 == null) goto L15;
        L6:
            j.b(null, r100, f25389b, r101.a());     // Catch: Throwable -> L8
        L10:
            monitor-exit(C0482a.class);
            return;
        L8:
            th = move-exception;
            com.alipay.sdk.m.u.e.a(th);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L15:
            r101 = new C0483a();     // Catch: Throwable -> L8
            goto L6
        }

        public static synchronized String a(Context r100, String r101, String r102) {
            monitor-enter(C0482a.class);
            com.alipay.sdk.m.u.e.b(f25388a, "stat append " + r102 + " , " + r101);     // Catch: Throwable -> L21
            if (r100 != null) goto L7;
        L18:
            monitor-exit(C0482a.class);
            return null;
        L7:
            if (TextUtils.isEmpty(r101) == true) goto L18;
            if (TextUtils.isEmpty(r102) == false) goto L12;
            r102 = UUID.randomUUID().toString();     // Catch: Throwable -> L21
        L12:
            C0483a r103 = a(r100);     // Catch: Throwable -> L21
            if (r103.f25390a.size() <= 20) goto L15;
            r103.f25390a.clear();     // Catch: Throwable -> L21
        L15:
            r103.f25390a.put(r102, r101);     // Catch: Throwable -> L21
            a(r100, r103);     // Catch: Throwable -> L21
            monitor-exit(C0482a.class);
            return r102;
        L21:
            th = move-exception;
            throw th;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: com.alipay.sdk.m.k.a$b$a, reason: collision with other inner class name */
        public static class RunnableC0484a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f25391a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f25392b;

            @Override // java.lang.Runnable
            public void run() {
                com_alipay_sdk_m_k_a$b$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_alipay_sdk_m_k_a$b$a__run$___twin___() {
                if (TextUtils.isEmpty(this.f25391a) == false) goto L5;
            L7:
                int r100 = 0;
            L9:
                if (r100 >= 4) goto L17;
                String r101 = C0482a.b(this.f25392b);
                if (TextUtils.isEmpty(r101) == true) goto L21;
                if (b.a(this.f25392b, r101) == false) goto L22;
                r100 = r100 + 1;
                goto L9
            L22:
                return;
            L21:
                return;
            L17:
                return;
            L5:
                if (b.a(this.f25392b, this.f25391a) == true) goto L7;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_alipay_sdk_m_k_a$b$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0484a r100) {
                r100.com_alipay_sdk_m_k_a$b$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0484a(String r100, Context r101) {
                this.f25391a = r100;
                this.f25392b = r101;
            }
        }

        public b() {
        }

        public static synchronized void a(Context r100) {
            monitor-enter(b.class);
            a(r100, null, null);     // Catch: Throwable -> L8
            monitor-exit(b.class);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public static /* synthetic */ boolean a(Context r100, String r101) {
            return b(r100, r101);
        }

        public static synchronized boolean b(Context r100, String r101) {
            monitor-enter(b.class);
            com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.A, "stat sub " + r101);     // Catch: Throwable -> L21
            if (com.alipay.sdk.m.m.a.D().e() == false) goto L7;
            com.alipay.sdk.m.p.e r102 = new com.alipay.sdk.m.q.d();     // Catch: Throwable -> L21
        L25:
        L17:
            th = move-exception;
            com.alipay.sdk.m.u.e.a(th);     // Catch: Throwable -> L21
            return false;
        L10:
            if (r102.a(null, r100, r101) == null) goto L15;
            C0482a.a(r100, r101);     // Catch: Throwable -> L17
            monitor-exit(b.class);
            return true;
        L15:
            monitor-exit(b.class);
            return false;
        L7:
            r102 = new com.alipay.sdk.m.q.e();     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            throw th;
        }

        public static synchronized void a(Context r100, String r101, String r102) {
            monitor-enter(b.class);
            if (r100 != null) goto L16;
            monitor-exit(b.class);
            return;
        L16:
        L13:
            th = move-exception;
            throw th;
        L8:
            if (TextUtils.isEmpty(r101) == true) goto L10;
            C0482a.a(r100, r101, r102);     // Catch: Throwable -> L13
        L10:
            ThreadMethodProxy.start(new PthreadThreadV2(new RunnableC0484a(r101, r100), "y/sdk/m/k/a$b"));     // Catch: Throwable -> L13
            monitor-exit(b.class);
        }

        public static synchronized void a(Context r100, com.alipay.sdk.m.k.b r101, String r102, String r103) {
            monitor-enter(b.class);
            if (r100 == null) goto L14;
            if (r101 == null) goto L14;
            if (r102 == null) goto L14;
            a(r100, r101.a(r102), r103);     // Catch: Throwable -> L11
            monitor-exit(b.class);
            return;
        L11:
            th = move-exception;
            throw th;
        L14:
            monitor-exit(b.class);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f25393a = "alipay_cashier_ap_seq_v";

        public c() {
        }

        public static synchronized long a(Context r100) {
            monitor-enter(c.class);
            long r101 = d.a(r100, f25393a);     // Catch: Throwable -> L7
            monitor-exit(c.class);
            return r101;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static final class d {
        public d() {
        }

        public static synchronized long a(Context r100, String r101) {
            monitor-enter(d.class);
            String r102 = j.a(null, r100, r101, null);     // Catch: Throwable -> L15
            if (TextUtils.isEmpty(r102) == true) goto L9;
            long r103 = Long.parseLong(r102);     // Catch: Throwable -> L15
        L10:
            long r104 = r103 + 1;
            j.b(null, r100, r101, Long.toString(r104));     // Catch: Throwable -> L14
        L12:
            monitor-exit(d.class);
            return r104;
        L9:
            r103 = 0;
            goto L10
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f25394a = "alipay_cashier_statistic_v";

        public e() {
        }

        public static synchronized long a(Context r100) {
            monitor-enter(e.class);
            long r101 = d.a(r100, f25394a);     // Catch: Throwable -> L7
            monitor-exit(e.class);
            return r101;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public a() {
    }

    public static synchronized void a(Context r100) {
        monitor-enter(a.class);
        b.a(r100);     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void a(com.alipay.sdk.m.s.a r100, String r101, Throwable r102) {
        if (r100 == null) goto L6;
        if (r102 == null) goto L7;
        r100.f25780l.a(r101, r102.getClass().getSimpleName(), r102);
        return;
    L7:
        return;
    }

    public static void a(com.alipay.sdk.m.s.a r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.f25780l.a(r101, r102);
    }

    public static synchronized void a(Context r100, com.alipay.sdk.m.s.a r101, String r102, String r103) {
        monitor-enter(a.class);
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        C0482a.a(r100, r101.f25780l.a(r102), r103);     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);
        return;
    L9:
        th = move-exception;
        com.alipay.sdk.m.u.e.a(th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        monitor-exit(a.class);
    }

    public static synchronized void b(Context r100, com.alipay.sdk.m.s.a r101, String r102, String r103) {
        monitor-enter(a.class);
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        b.a(r100, r101.f25780l, r102, r103);     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(a.class);
    }

    public static void a(com.alipay.sdk.m.s.a r100, String r101, String r102, String r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.f25780l.a(r101, r102, r103);
    }

    public static void b(com.alipay.sdk.m.s.a r100, String r101, String r102, String r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.f25780l.b(r101, r102, r103);
    }

    public static void a(com.alipay.sdk.m.s.a r100, String r101, String r102, Throwable r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.f25780l.a(r101, r102, r103);
    }

    public static void a(com.alipay.sdk.m.s.a r100, String r101, String r102, Throwable r103, String r104) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.f25780l.a(r101, r102, r103, r104);
    }
}
