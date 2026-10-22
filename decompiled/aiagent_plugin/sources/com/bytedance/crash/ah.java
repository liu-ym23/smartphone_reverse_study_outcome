package com.bytedance.crash;

import android.text.TextUtils;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: UserDataCenter.java */
/* JADX INFO: loaded from: classes.dex */
public class ah {
    private static boolean t;
    private static boolean u;
    private static boolean v;
    private static boolean w;
    private static boolean x;
    private static boolean y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f7144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, String> f7145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f7146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.crash.o.n<CrashType, AttachUserData> f7147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.crash.o.n<CrashType, ICrashCallback> f7148e;
    private final com.bytedance.crash.o.n<CrashType, d> f;
    private final List<IOOMCallback> g;
    private final List<IOOMCallback> h;
    private final List<k> i;
    private final com.bytedance.crash.o.n<CrashType, t> j;
    private final com.bytedance.crash.o.n<CrashType, x> k;
    private final List<s> l;
    private final List<l> m;
    private final Map<String, LinkedList<String>> n;
    private final Map<String, Integer> o;
    private ICrashFilter p;
    private e q;
    private boolean r;
    private volatile boolean s;

    @Deprecated
    public static boolean j() {
        return false;
    }

    static /* synthetic */ ConcurrentHashMap a(ah r0) {
        return r0.f7144a;
    }

    static /* synthetic */ boolean a(ah r0, boolean r1) {
        r0.s = r1;
        return r1;
    }

    public ah() {
        this.s = true;
        this.f7144a = new ConcurrentHashMap();
        this.f7145b = new ConcurrentHashMap();
        this.f7146c = new ConcurrentHashMap();
        this.f7147d = new com.bytedance.crash.o.n();
        this.f7148e = new com.bytedance.crash.o.n();
        this.f = new com.bytedance.crash.o.n();
        this.g = new CopyOnWriteArrayList();
        this.h = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
        this.l = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.n = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap();
        this.j = new com.bytedance.crash.o.n();
        this.k = new com.bytedance.crash.o.n();
    }

    public void a(String r1, int r2) {
        this.o.put(r1, Integer.valueOf(r2));
    }

    void a(String r1) {
        this.n.remove(r1);
    }

    void a(String r4, String r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.n.containsKey(r4) == true) goto L16;
        Map<String, LinkedList<String>> r0 = this.n;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.n.containsKey(r4) == true) goto L11;
        this.n.put(r4, new LinkedList());     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L16:
        LinkedList r1 = (LinkedList) ZeusTransformUtils.preCheckCast(this.n.get(r4), LinkedList.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L19;
        return;
    L19:
        monitor-enter(r1);
    L33:
        th = move-exception;
        throw th;
    L21:
        if (r1.contains(r5) == false) goto L25;
        monitor-exit(r1);     // Catch: Throwable -> L33
        return;
    L25:
        if (this.o.containsKey(r4) == false) goto L30;
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(this.o.get(r4), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L33
        if (r1.size() <= r3) goto L29;
        r1.removeFirst();     // Catch: Throwable -> L33
    L29:
        r1.add(r5);     // Catch: Throwable -> L33
    L31:
        monitor-exit(r1);     // Catch: Throwable -> L33
        return;
    L30:
        r1.add(r5);     // Catch: Throwable -> L33
        goto L31
    }

    public Map<String, JSONArray> a() {
        HashMap r0 = new HashMap();
        Iterator<String> r1 = this.n.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        JSONArray r3 = new JSONArray();
        LinkedList r4 = (LinkedList) ZeusTransformUtils.preCheckCast(this.n.get(r2), LinkedList.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L17;
        monitor-enter(r4);
        Iterator r5 = r4.iterator();     // Catch: Throwable -> L14
    L10:
        if (r5.hasNext() == false) goto L12;
        r3.put((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r4);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        r0.put(r2, r3);
        goto L4
    L18:
        return r0;
    }

    public void a(AttachUserData r4, CrashType r5) {
        AttachUserData r6 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r4, AttachUserData.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L15;
        com.bytedance.crash.o.n<CrashType, AttachUserData> r0 = this.f7147d;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r5 != CrashType.ALL) goto L9;
        this.f7147d.a(r6, new CrashType[]{CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE});     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        this.f7147d.a(r5, r6);     // Catch: Throwable -> L12
        goto L10
    }

    public void a(CrashType r3, AttachUserData r4) {
        AttachUserData r5 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r4, AttachUserData.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L15;
        com.bytedance.crash.o.n<CrashType, AttachUserData> r0 = this.f7147d;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r3 != CrashType.ALL) goto L9;
        this.f7147d.a(r5);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        this.f7147d.b(r3, r5);     // Catch: Throwable -> L12
        goto L10
    }

    public List<AttachUserData> a(CrashType r2) {
        com.bytedance.crash.o.n<CrashType, AttachUserData> r0 = this.f7147d;
        monitor-enter(r0);
        List<AttachUserData> r1 = this.f7147d.b(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<String, String> b(CrashType r5) {
        com.bytedance.crash.o.n<CrashType, AttachUserData> r0 = this.f7147d;
        monitor-enter(r0);
        List<AttachUserData> r4 = this.f7147d.b(r5);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        HashMap r1 = new HashMap();
        Iterator<AttachUserData> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        Map<? extends String, ? extends String> r2 = ((AttachUserData) ZeusTransformUtils.preCheckCast(r6.next(), AttachUserData.class, "com.obric.aiagent.plugin")).getUserData(r5);
        if (r2 == null) goto L8;
        r1.putAll(r2);
        goto L8
    L12:
        return r1;
    L13:
        th = move-exception;
        throw th;
    }

    public void a(boolean r2) {
        if (this.r == true) goto L10;
        if (r2 == false) goto L10;
        this.r = true;
        if (this.f7144a.isEmpty() == true) goto L10;
        if (NativeBridge.b() == false) goto L10;
        this.s = false;
        DefaultWorkThread.post(new AnonymousClass1(this));
    L10:
        this.r = r2;
    }

    public boolean b() {
        return this.r;
    }

    public void a(Map<? extends String, ? extends String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L25;
        return;
    L25:
        if (r6.isEmpty() == true) goto L44;
        Iterator r7 = r6.entrySet().iterator();     // Catch: Throwable -> L24
    L7:
        if (r7.hasNext() == false) goto L46;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (NativeBridge.b() == false) goto L18;
        if (this.r == false) goto L18;
        if (r1 == null) goto L14;
        if (TextUtils.isEmpty(r2) == true) goto L7;
        NativeBridge.a(r2, r1);     // Catch: Throwable -> L24
        goto L7
    L14:
        NativeBridge.s(r2);     // Catch: Throwable -> L24
    L18:
        if (r1 == null) goto L19;
        if (r2 == null) goto L7;
        this.f7144a.put(r2, r1);     // Catch: Throwable -> L24
        goto L7
    L19:
        this.f7144a.remove(r2);     // Catch: Throwable -> L24
        goto L7
    L46:
        return;
    L44:
        return;
    }

    public void b(String r2, String r3) {
        if (NativeBridge.b() == true) goto L5;
    L11:
        if (r3 != null) goto L13;
        this.f7144a.remove(r2);
        return;
    L13:
        if (r2 == null) goto L20;
        this.f7144a.put(r2, r3);
        return;
    L20:
        return;
    L5:
        if (this.r == false) goto L11;
        if (r3 != null) goto L9;
        NativeBridge.s(r2);
        return;
    L9:
        if (TextUtils.isEmpty(r2) == true) goto L17;
        NativeBridge.a(r2, r3);
        return;
    }

    public void b(String r2) {
        if (NativeBridge.b() == true) goto L5;
    L10:
        this.f7144a.remove(r2);
        return;
    L5:
        if (this.r == false) goto L10;
        if (this.s == false) goto L9;
        NativeBridge.s(r2);
        return;
    L9:
        this.f7144a.remove(r2);
    }

    public Map<String, String> c() {
        if (ag.b() == null) goto L7;
        return ag.a();
    L7:
        if (NativeBridge.b() == false) goto L13;
        if (this.r == false) goto L13;
        return NativeBridge.j();
    L13:
        return this.f7144a;
    }

    public Map<String, String> d() {
        if (NativeBridge.b() == false) goto L9;
        if (this.r == false) goto L9;
        return NativeBridge.j();
    L9:
        return this.f7144a;
    }

    public void e() {
        this.f7144a.clear();
    }

    public void a(ICrashCallback r4, CrashType r5) {
        ICrashCallback r6 = (ICrashCallback) ZeusTransformUtils.wrapperContextForParams(r4, ICrashCallback.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.o.n<CrashType, ICrashCallback> r0 = this.f7148e;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r5 != CrashType.ALL) goto L7;
        this.f7148e.a(r6, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        this.f7148e.a(r5, r6);     // Catch: Throwable -> L10
        goto L8
    }

    public void b(ICrashCallback r3, CrashType r4) {
        ICrashCallback r5 = (ICrashCallback) ZeusTransformUtils.wrapperContextForParams(r3, ICrashCallback.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.o.n<CrashType, ICrashCallback> r0 = this.f7148e;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r4 != CrashType.ALL) goto L7;
        this.f7148e.a(r5);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        this.f7148e.b(r4, r5);     // Catch: Throwable -> L10
        goto L8
    }

    public List<ICrashCallback> c(CrashType r2) {
        com.bytedance.crash.o.n<CrashType, ICrashCallback> r0 = this.f7148e;
        monitor-enter(r0);
        List<ICrashCallback> r1 = this.f7148e.b(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(d r4, CrashType r5) {
        com.bytedance.crash.o.n<CrashType, d> r0 = this.f;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r5 != CrashType.ALL) goto L7;
        this.f.a(r4, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        this.f.a(r5, r4);     // Catch: Throwable -> L10
        goto L8
    }

    public List<d> d(CrashType r2) {
        com.bytedance.crash.o.n<CrashType, d> r0 = this.f;
        monitor-enter(r0);
        List<d> r1 = this.f.b(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(IOOMCallback r3) {
        IOOMCallback r4 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOOMCallback.class, "com.obric.aiagent.plugin");
        this.g.add(r4);
    }

    public void a(k r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.aiagent.plugin");
        this.i.add(r4);
    }

    public void b(IOOMCallback r3) {
        IOOMCallback r4 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOOMCallback.class, "com.obric.aiagent.plugin");
        this.g.remove(r4);
    }

    public List<IOOMCallback> f() {
        return this.g;
    }

    public void c(IOOMCallback r3) {
        IOOMCallback r4 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOOMCallback.class, "com.obric.aiagent.plugin");
        this.h.add(r4);
    }

    public void d(IOOMCallback r3) {
        IOOMCallback r4 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOOMCallback.class, "com.obric.aiagent.plugin");
        this.h.remove(r4);
    }

    public void a(int r1, String r2) {
        this.f7145b.put(Integer.valueOf(r1), r2);
    }

    public ConcurrentHashMap<Integer, String> g() {
        return this.f7145b;
    }

    public void c(String r1, String r2) {
        this.f7146c.put(r1, r2);
    }

    public JSONObject h() {
        return new JSONObject(this.f7146c);
    }

    public void a(ICrashFilter r3) {
        this.p = (ICrashFilter) ZeusTransformUtils.wrapperContextForParams(r3, ICrashFilter.class, "com.obric.aiagent.plugin");
    }

    public boolean a(Thread r2, Throwable r3) {
        ICrashFilter r1 = this.p;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        if (r1.onJavaCrashFilter(r3, r2) == true) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    private boolean b(CrashType r4, JSONObject r5) {
        if (this.p != null) goto L19;
        return false;
    L19:
        if (r4 != CrashType.NATIVE) goto L11;
        return !this.p.onNativeCrashFilter(r5.optString("data"), r5.optString("crash_thread_name"));
    L11:
        if (r4 != CrashType.ANR) goto L17;
        if (ZeusTransformUtils.instanceOf(this.p, m.class) == false) goto L17;
        return !((m) ZeusTransformUtils.preCheckCast(this.p, m.class, "com.obric.aiagent.plugin")).a(r5.optString("data"), r5.optString("anr_info"));
    L17:
        return false;
    }

    public boolean a(CrashType r12, JSONObject r13) {
        if (b(r12, r13) == false) goto L6;
        return true;
    L6:
        e r0 = this.q;     // Catch: Throwable -> L18
        if (r0 == null) goto L10;
        r0.a(r12, r13);     // Catch: Throwable -> L18
    L10:
        if (r12 != CrashType.ANR) goto L16;
        long r7 = r13.optLong("app_start_time");     // Catch: Throwable -> L18
        long r9 = r13.optLong("crash_time");     // Catch: Throwable -> L18
        String r14 = r13.optString("process_name");     // Catch: Throwable -> L18
        Iterator<l> r11 = this.m.iterator();     // Catch: Throwable -> L18
    L12:
        if (r11.hasNext() == false) goto L23;
        ((l) ZeusTransformUtils.preCheckCast(r11.next(), l.class, "com.obric.aiagent.plugin")).a(r7, r9, r14, r13);     // Catch: Throwable -> L18
        goto L12
    L23:
        return false;
    L16:
        return false;
    L22:
        return false;
    }

    public void a(e r3) {
        this.q = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
    }

    public static boolean i() {
        return t;
    }

    public static void b(boolean r0) {
        t = r0;
    }

    static void c(boolean r0) {
        u = r0;
    }

    @Deprecated
    public static boolean k() {
        if (u == true) goto L5;
    L7:
        return false;
    L5:
        if (j() == false) goto L7;
        return true;
    }

    static void l() {
        v = true;
    }

    public static void d(boolean r0) {
        w = r0;
    }

    public static void e(boolean r0) {
        x = r0;
    }

    public static void f(boolean r0) {
        y = r0;
    }

    public void a(s r3) {
        s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.aiagent.plugin");
        this.l.add(r4);
    }

    public void b(s r3) {
        s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.aiagent.plugin");
        this.l.remove(r4);
    }

    public List<s> m() {
        return this.l;
    }

    public void a(l r3) {
        l r4 = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.aiagent.plugin");
        this.m.add(r4);
    }

    public void a(t r4, CrashType r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.o.n<CrashType, t> r0 = this.j;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r5 != CrashType.ALL) goto L7;
        this.j.a(r6, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        this.j.a(r5, r6);     // Catch: Throwable -> L10
        goto L8
    }

    public void b(t r3, CrashType r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.o.n<CrashType, t> r0 = this.j;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r4 != CrashType.ALL) goto L7;
        this.j.a(r5);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        this.j.b(r4, r5);     // Catch: Throwable -> L10
        goto L8
    }

    public List<t> e(CrashType r2) {
        com.bytedance.crash.o.n<CrashType, t> r0 = this.j;
        monitor-enter(r0);
        List<t> r1 = this.j.b(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(x r4, CrashType r5) {
        x r6 = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L15;
        com.bytedance.crash.o.n<CrashType, x> r0 = this.k;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r5 != CrashType.ALL) goto L9;
        this.k.a(r6, new CrashType[]{CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE});     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        this.k.a(r5, r6);     // Catch: Throwable -> L12
        goto L10
    }

    public void b(x r3, CrashType r4) {
        x r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L15;
        com.bytedance.crash.o.n<CrashType, x> r0 = this.k;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r4 != CrashType.ALL) goto L9;
        this.k.a(r5);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        this.k.b(r4, r5);     // Catch: Throwable -> L12
        goto L10
    }

    public List<x> f(CrashType r2) {
        com.bytedance.crash.o.n<CrashType, x> r0 = this.k;
        monitor-enter(r0);
        List<x> r1 = this.k.b(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
