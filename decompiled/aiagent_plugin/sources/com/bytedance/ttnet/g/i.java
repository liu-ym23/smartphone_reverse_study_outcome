package com.bytedance.ttnet.g;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.a.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTHttpCallPriorityControl.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements com.bytedance.retrofit2.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile i f11478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f11479b = "TTHttpCallPriorityControl";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f11480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, a> f11481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f11482e;
    private final ReadWriteLock f;

    /* JADX INFO: compiled from: TTHttpCallPriorityControl.java */
    public static abstract class a implements com.bytedance.retrofit2.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final e f11483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f11484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f11485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Date f11486d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Date f11487e;
        private boolean f;
        private int g;
        private com.bytedance.frameworks.baselib.network.a.a h;

        public a() {
            this.f11483a = new e();
            this.f11484b = "";
            this.f11485c = -1;
            this.f11486d = null;
            this.f11487e = null;
            this.f = true;
            this.g = 1000;
            this.h = null;
        }

        static /* synthetic */ boolean a(a r0) {
            return r0.d();
        }

        boolean a(JSONObject r3) {
            String r0 = r3.optString("state_name", "");
            this.f11484b = r0;
            if (TextUtils.isEmpty(r0) == false) goto L6;
            return false;
        L6:
            this.f11485c = r3.optInt("state", -1);
            int r1 = 1000;
            int r2 = r3.optInt("delay_disable_time_ms", 1000);
            this.g = r2;
            if (r2 <= 0) goto L10;
            r1 = r2;
        L10:
            this.g = r1;
            b(r3);
            return true;
        }

        public void a() {
            final long r2 = this.g;
            final long r4 = 0;
            com.bytedance.frameworks.baselib.network.a.a r6 = new AnonymousClass1(this, r2, r4);
            this.h = r6;
            if (r6 == null) goto L6;
            com.bytedance.frameworks.baselib.network.a.b.a(com.bytedance.frameworks.baselib.network.a.c.f7963a).a(this.h);
            return;
        }

        void b() {
            if (this.h == null) goto L6;
            com.bytedance.frameworks.baselib.network.a.b.a(com.bytedance.frameworks.baselib.network.a.c.f7963a).b(this.h);
            return;
        }

        @Override // com.bytedance.retrofit2.f.a
        public void b(com.bytedance.retrofit2.b.c r1) {
            this.f11483a.a(r1);
        }

        b c() {
            return b.f11493e;
        }

        private void b(JSONObject r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            String r6 = r5.optString("lifecycle");
            if ("".equals(r6) == false) goto L7;
            return;
        L7:
            ArrayList r0 = new ArrayList();
            if (com.bytedance.frameworks.baselib.network.http.i.g.b(r6, r0) == false) goto L17;
            if (r0.size() != 2) goto L17;
            this.f = true;
            this.f11486d = (Date) ZeusTransformUtils.preCheckCast(r0.get(0), Date.class, "com.obric.aiagent.plugin");
            this.f11487e = (Date) ZeusTransformUtils.preCheckCast(r0.get(1), Date.class, "com.obric.aiagent.plugin");
            if (Logger.debug() == false) goto L21;
            Logger.d(i.d(), "initLifecycle, stateName: " + this.f11484b + ", beginTime: " + this.f11486d.toString() + ", endTime: " + this.f11487e.toString());
            return;
        L21:
            return;
        L17:
            if (Logger.debug() == false) goto L19;
            Logger.d(i.d(), "initLifecycle, parse lifecycle failed");
        L19:
            this.f = false;
        }

        private boolean d() {
            if (Logger.debug() == false) goto L6;
            Logger.d(i.d(), "isInLifecycle, stateName: " + this.f11484b + ", beginTime: " + this.f11486d + ", endTime: " + this.f11487e);
        L6:
            if (this.f == true) goto L9;
            return false;
        L9:
            if (this.f11486d != null) goto L11;
        L19:
            return true;
        L11:
            if (this.f11487e == null) goto L19;
            Date r0 = new Date();
            if (r0.after(this.f11486d) == true) goto L16;
            return false;
        L16:
            if (r0.before(this.f11487e) == true) goto L18;
            return false;
        L18:
            return true;
        }
    }

    /* JADX INFO: compiled from: TTHttpCallPriorityControl.java */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11489a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f11490b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f11491c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f11492d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f11493e = null;
        private static final /* synthetic */ b[] g = null;
        private final int f;

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(g.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("DEFAULT", 0, 0);
            f11489a = r0;
            b r1 = new b("NORMAL_DELAY", 1, 1);
            f11490b = r1;
            b r3 = new b("RUNTIME_DELAY", 2, 2);
            f11491c = r3;
            b r5 = new b("PRIORITY", 3, 3);
            f11492d = r5;
            b r7 = new b("NOT_REACHED", 4, 4);
            f11493e = r7;
            g = new b[]{r0, r1, r3, r5, r7};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f = r3;
        }

        public int a() {
            return this.f;
        }

        public static b a(int r5) {
            b[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            b r3 = r0[r2];
            if (r3.a() == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            throw new IllegalArgumentException("Invalid value: " + r5);
        }
    }

    static {
    }

    public i() {
        this.f11480c = new AtomicBoolean(false);
        this.f11481d = new ConcurrentHashMap();
        this.f11482e = new com.bytedance.ttnet.g.a();
        this.f = new ReentrantReadWriteLock();
    }

    static /* synthetic */ String d() {
        return f11479b;
    }

    public static i a() {
        if (f11478a != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11478a != null) goto L9;
        f11478a = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f11478a;
    }

    public void b() {
        a(null);
    }

    private void a(a r3) {
        if (r3 != null) goto L4;
    L6:
        this.f.writeLock().lock();
        this.f11482e.b();     // Catch: Throwable -> L15
        if (r3 != null) goto L10;
        r3 = new com.bytedance.ttnet.g.a();     // Catch: Throwable -> L15
    L10:
        this.f11482e = r3;     // Catch: Throwable -> L15
        r3.a();     // Catch: Throwable -> L15
        if (Logger.debug() == false) goto L13;
        Logger.d(f11479b, "set mode " + this.f11482e.c());     // Catch: Throwable -> L15
    L13:
        this.f.writeLock().unlock();
        return;
    L15:
        th = move-exception;
        this.f.writeLock().unlock();
        throw th;
    L4:
        if (a.a(r3) == true) goto L6;
    }

    public b c() {
        this.f.writeLock().lock();
        b r0 = this.f11482e.c();     // Catch: Throwable -> L6
        this.f.writeLock().unlock();
        return r0;
    L6:
        th = move-exception;
        this.f.writeLock().unlock();
        throw th;
    }

    @Override // com.bytedance.retrofit2.f.a
    public void a(com.bytedance.retrofit2.b.c r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f11479b, "current mode is " + c());
    L6:
        if (this.f11480c.get() == true) goto L11;
        if (this.f11482e.c() == b.f11489a) goto L11;
        return;
    L11:
        if (d(r4) == true) goto L14;
        return;
    L14:
        if (a.a(this.f11482e) == true) goto L16;
        return;
    L16:
        this.f11482e.a(r4);
    }

    @Override // com.bytedance.retrofit2.f.a
    public boolean a(com.bytedance.retrofit2.b.c r4, Executor r5, Runnable r6) {
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d(f11479b, "current mode is " + c());
    L6:
        if (this.f11480c.get() == true) goto L11;
        if (this.f11482e.c() == b.f11489a) goto L11;
        return false;
    L11:
        if (d(r4) == true) goto L14;
        return false;
    L14:
        if (a.a(this.f11482e) == true) goto L17;
        return false;
    L17:
        return this.f11482e.a(r4, r7, r8);
    }

    @Override // com.bytedance.retrofit2.f.a
    public void b(com.bytedance.retrofit2.b.c r2) {
        if (this.f11480c.get() == false) goto L8;
        if (r2 == null) goto L9;
        this.f11482e.b(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.retrofit2.f.a
    public com.bytedance.retrofit2.b.c c(com.bytedance.retrofit2.b.c r2) {
        if (this.f11480c.get() == false) goto L8;
        if (r2 == null) goto L8;
        return this.f11482e.c(r2);
    L8:
        return r2;
    }

    public void a(JSONObject r9) {
        int r1 = 0;
        this.f11480c.set(false);
        this.f11481d.clear();
        JSONArray r0 = r9.optJSONArray("tt_req_delay_config");
        if (r9.optInt("state_delay_enabled") <= 0) goto L5;
        boolean r2 = true;
    L7:
        if (r9.optInt("state_new_strategy_enabled", 1) <= 0) goto L9;
        boolean r10 = true;
    L11:
        if (TTNetInit.getStateDelayNewStrategyEnabled() == false) goto L14;
        if (r10 == false) goto L14;
        boolean r11 = true;
    L15:
        if (r2 == false) goto L49;
        if (r0 == null) goto L49;
        if (r11 == false) goto L49;
        ConcurrentHashMap r12 = new ConcurrentHashMap();
    L21:
        if (r1 >= r0.length()) goto L45;
        JSONObject r3 = r0.optJSONObject(r1);
        String r4 = r3.optString("state_name", "");
        if (r3 == null) goto L43;
        if (TextUtils.isEmpty(r4) == true) goto L43;
        b r5 = b.a(r3.optInt("type", b.f11493e.a()));
        a r6 = null;
        if (r5 != b.f11490b) goto L31;
        r6 = new com.bytedance.ttnet.g.b();
    L36:
        if (r6 == null) goto L43;
        if (r6.a(r3) == false) goto L43;
        if (Logger.debug() == false) goto L42;
        Logger.d(f11479b, "mode name is " + r4);
    L42:
        r12.put(r4, r6);
        goto L43
    L31:
        if (r5 != b.f11491c) goto L34;
        r6 = new d();
        goto L36
    L34:
        if (r5 != b.f11492d) goto L36;
        r6 = new c();
    L43:
        r1 = r1 + 1;
        goto L21
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.d(f11479b, "mode size is " + r12.size());
    L47:
        this.f11481d.putAll(r12);
        this.f11480c.set(true);
        return;
    L49:
        b();
        return;
    L14:
        r11 = false;
        goto L15
    L9:
        r10 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    public static Integer a(Map<String, Integer> r5, String r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return null;
    L5:
        Iterator r0 = r7.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        if (r6.startsWith(r3) == false) goto L7;
        return (Integer) ZeusTransformUtils.preCheckCast(r7.get(r3), Integer.class, "com.obric.aiagent.plugin");
    L12:
        return null;
    }

    public static boolean a(Set<String> r4, String r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        if (r6 != null) goto L7;
        return false;
    L7:
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        if (r5.startsWith((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return true;
    L14:
        return false;
    }

    public static Set<String> a(JSONObject r3, String r4) {
        CopyOnWriteArraySet r0 = new CopyOnWriteArraySet();
        if (r3 != null) goto L5;
        return r0;
    L5:
        JSONArray r5 = r3.optJSONArray(r4);
        if (r5 != null) goto L8;
        return r0;
    L8:
        int r6 = 0;
    L10:
        if (r6 >= r5.length()) goto L15;
        String r1 = r5.optString(r6);
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r0.add(r1);
    L14:
        r6 = r6 + 1;
        goto L10
    L15:
        return r0;
    }

    private boolean d(com.bytedance.retrofit2.b.c r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r1.o()) == true) goto L6;
        return true;
    }
}
