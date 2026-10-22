package com.bytedance.bdtracker;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j0 {
    public static b q;
    public long a;
    public final e0 b;
    public o4 c;
    public o4 d;
    public volatile String e;
    public volatile long g;
    public int h;
    public volatile boolean j;
    public long k;
    public int l;
    public String m;
    public volatile String n;
    public final AtomicLong f = new AtomicLong(1000);
    public long i = -1;
    public volatile boolean o = false;
    public volatile boolean p = false;

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ d a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;

        public a(d dVar, boolean z, long j) {
            this.a = dVar;
            this.b = z;
            this.c = j;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", this.a.m);
                jSONObject.put("sessionId", j0.this.e);
                boolean z = true;
                jSONObject.put("isBackground", !this.b);
                if (this.c == -1) {
                    z = false;
                }
                jSONObject.put("newLaunch", z);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public static class b extends r4 {
        public /* synthetic */ b(a aVar) {
        }
    }

    public j0(e0 e0Var) {
        this.b = e0Var;
    }

    public static boolean a(e4 e4Var) {
        if (e4Var instanceof o4) {
            return ((o4) e4Var).k();
        }
        return false;
    }

    public void a(e4 e4Var, List<e4> list, d dVar) {
        if (!(e4Var instanceof o4)) {
            if (e4Var instanceof b) {
                return;
            }
            list.add(e4Var);
            return;
        }
        o4 o4Var = (o4) e4Var;
        if (!o4Var.k()) {
            Bundle bundleA = a(e4Var.c, 0L);
            if (dVar != null && bundleA != null) {
                dVar.onEventV3("play_session", bundleA, 1);
            }
            this.k = o4Var.c;
            list.add(e4Var);
            if (!o4Var.D) {
                this.c = o4Var;
                return;
            } else {
                this.d = o4Var;
                this.c = null;
                return;
            }
        }
        this.k = 0L;
        list.add(e4Var);
        if (TextUtils.isEmpty(o4Var.t)) {
            o4 o4Var2 = this.d;
            if (o4Var2 != null && (o4Var.c - o4Var2.c) - o4Var2.s < 500) {
                o4Var.t = o4Var2.u;
                return;
            }
            o4 o4Var3 = this.c;
            if (o4Var3 == null || (o4Var.c - o4Var3.c) - o4Var3.s >= 500) {
                return;
            }
            o4Var.t = o4Var3.u;
        }
    }

    public void a(IAppLogInstance iAppLogInstance, e4 e4Var) {
        JSONObject jSONObject;
        if (e4Var != null) {
            w1 w1Var = this.b.i;
            e4Var.m = iAppLogInstance.getAppId();
            e4Var.f = this.a;
            e4Var.g = w1Var.k();
            e4Var.h = w1Var.l();
            e4Var.i = w1Var.i();
            e4Var.e = this.e;
            e4Var.d = this.f.incrementAndGet();
            String strA = e4Var.j;
            String strB = w1Var.b();
            if (TextUtils.isEmpty(strA)) {
                strA = strB;
            } else if (!TextUtils.isEmpty(strB)) {
                Set<String> setC = w1Var.c(strB);
                setC.addAll(w1Var.c(strA));
                strA = w1Var.a(setC);
            }
            e4Var.j = strA;
            e4Var.k = j5.b(this.b.b(), true).a;
            if ((e4Var instanceof l4) && this.i > 0 && r.a(((l4) e4Var).u, "$crash") && (jSONObject = e4Var.o) != null) {
                try {
                    jSONObject.put("$session_duration", System.currentTimeMillis() - this.i);
                } catch (Throwable unused) {
                }
            }
            this.b.d.D.debug("[event_process] fillSessionParams data: " + e4Var, new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized android.os.Bundle a(long r5, long r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.g     // Catch: java.lang.Throwable -> L51
            com.bytedance.bdtracker.e0 r2 = r4.b     // Catch: java.lang.Throwable -> L51
            com.bytedance.bdtracker.u1 r2 = r2.e     // Catch: java.lang.Throwable -> L51
            com.bytedance.applog.InitConfig r2 = r2.c     // Catch: java.lang.Throwable -> L51
            boolean r2 = r2.isPlayEnable()     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L4e
            boolean r2 = r4.a()     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L4e
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L4e
            long r0 = r5 - r0
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 <= 0) goto L4e
            android.os.Bundle r7 = new android.os.Bundle     // Catch: java.lang.Throwable -> L51
            r7.<init>()     // Catch: java.lang.Throwable -> L51
            int r8 = r4.l     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = "session_no"
            r7.putInt(r2, r8)     // Catch: java.lang.Throwable -> L51
            int r8 = r4.h     // Catch: java.lang.Throwable -> L51
            int r8 = r8 + 1
            r4.h = r8     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = "send_times"
            r7.putInt(r2, r8)     // Catch: java.lang.Throwable -> L51
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
            java.lang.String r8 = "current_duration"
            r7.putLong(r8, r0)     // Catch: java.lang.Throwable -> L51
            long r0 = r4.i     // Catch: java.lang.Throwable -> L51
            java.lang.String r8 = com.bytedance.bdtracker.e4.b(r0)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = "session_start_time"
            r7.putString(r0, r8)     // Catch: java.lang.Throwable -> L51
            r4.g = r5     // Catch: java.lang.Throwable -> L51
            goto L4f
        L4e:
            r7 = 0
        L4f:
            monitor-exit(r4)
            return r7
        L51:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L51
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.j0.a(long, long):android.os.Bundle");
    }

    public boolean a() {
        return this.j && this.k == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        if (r11.i > (r13.c + 7200000)) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.bytedance.bdtracker.d r12, com.bytedance.bdtracker.e4 r13, java.util.List<com.bytedance.bdtracker.e4> r14) {
        /*
            r11 = this;
            com.bytedance.bdtracker.e0 r0 = r11.b
            com.bytedance.bdtracker.u1 r0 = r0.e
            boolean r0 = r0.j()
            if (r0 == 0) goto L61
            boolean r0 = r13 instanceof com.bytedance.bdtracker.o4
            r1 = 0
            if (r0 == 0) goto L17
            r0 = r13
            com.bytedance.bdtracker.o4 r0 = (com.bytedance.bdtracker.o4) r0
            boolean r0 = r0.k()
            goto L18
        L17:
            r0 = r1
        L18:
            long r2 = r11.i
            r4 = -1
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r3 = 1
            if (r2 != 0) goto L22
            goto L58
        L22:
            boolean r2 = r11.j
            if (r2 != 0) goto L2c
            if (r0 == 0) goto L2c
            r11.a(r12, r13, r14, r3)
            goto L5b
        L2c:
            long r4 = r11.k
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L4c
            long r6 = r13.c
            com.bytedance.bdtracker.e0 r2 = r11.b
            com.bytedance.bdtracker.u1 r2 = r2.e
            com.bytedance.applog.store.kv.IKVStore r2 = r2.f
            java.lang.String r8 = "session_interval"
            r9 = 30000(0x7530, double:1.4822E-319)
            long r8 = r2.getLong(r8, r9)
            long r8 = r8 + r4
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 <= 0) goto L4c
            r11.o = r3
            goto L58
        L4c:
            long r4 = r11.i
            long r6 = r13.c
            r8 = 7200000(0x6ddd00, double:3.5572727E-317)
            long r6 = r6 + r8
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L5c
        L58:
            r11.a(r12, r13, r14, r0)
        L5b:
            r1 = r3
        L5c:
            r11.a(r12, r13)
            r11.p = r1
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.j0.a(com.bytedance.bdtracker.d, com.bytedance.bdtracker.e4, java.util.List):void");
    }

    public synchronized m4 a(d dVar, e4 e4Var, List<e4> list, boolean z) {
        boolean z2;
        m4 m4Var;
        long j = e4Var instanceof b ? -1L : e4Var.c;
        this.e = UUID.randomUUID().toString();
        if (LogUtils.isDisabled()) {
            z2 = z;
        } else {
            z2 = z;
            LogUtils.sendJsonFetcher("session_start", new a(dVar, z2, j));
        }
        if (z2 && !this.b.v && TextUtils.isEmpty(this.n)) {
            this.n = this.e;
        }
        this.f.set(1000L);
        this.i = j;
        this.j = z2;
        this.k = 0L;
        this.g = 0L;
        if (z2) {
            Calendar calendar = Calendar.getInstance();
            StringBuilder sbA = com.bytedance.bdtracker.a.a("");
            sbA.append(calendar.get(1));
            sbA.append(calendar.get(2));
            sbA.append(calendar.get(5));
            String string = sbA.toString();
            u1 u1Var = this.b.e;
            if (TextUtils.isEmpty(this.m)) {
                this.m = u1Var.e.getString("session_last_day", "");
                this.l = u1Var.e.getInt("session_order", 0);
            }
            if (string.equals(this.m)) {
                this.l++;
            } else {
                this.m = string;
                this.l = 1;
            }
            u1Var.e.putString("session_last_day", string).putInt("session_order", this.l);
            this.h = 0;
            this.g = e4Var.c;
        }
        if (j != -1) {
            m4Var = new m4();
            m4Var.m = e4Var.m;
            m4Var.e = this.e;
            m4Var.u = !this.j;
            m4Var.d = this.f.incrementAndGet();
            m4Var.a(this.i);
            m4Var.t = this.b.i.n();
            m4Var.s = this.b.i.m();
            m4Var.f = this.a;
            m4Var.g = this.b.i.k();
            m4Var.h = this.b.i.l();
            m4Var.i = dVar.getSsid();
            m4Var.j = dVar.getAbSdkVersion();
            m4Var.w = z2 ? this.b.e.f.getInt("is_first_time_launch", 1) : 0;
            if (z2 && m4Var.w == 1) {
                this.b.e.f.putInt("is_first_time_launch", 0);
            }
            o4 o4VarA = w.a();
            if (o4VarA != null) {
                m4Var.y = o4VarA.u;
                m4Var.x = o4VarA.v;
            }
            if ((e4Var instanceof o4) && o4VarA == null) {
                o4 o4Var = (o4) e4Var;
                m4Var.y = o4Var.u;
                m4Var.x = o4Var.v;
            }
            if (this.j && this.o) {
                m4Var.z = this.o;
                this.o = false;
            }
            this.b.d.D.debug("[event_process] fillSessionParams launch: " + m4Var, new Object[0]);
            list.add(m4Var);
        } else {
            m4Var = null;
        }
        d dVar2 = this.b.d;
        if (dVar2.l <= 0) {
            dVar2.l = 6;
        }
        dVar.D.debug("Start new session:{} with background:{}", this.e, Boolean.valueOf(true ^ this.j));
        return m4Var;
    }
}
