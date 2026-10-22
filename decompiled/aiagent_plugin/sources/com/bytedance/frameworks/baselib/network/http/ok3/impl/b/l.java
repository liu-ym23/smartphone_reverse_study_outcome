package com.bytedance.frameworks.baselib.network.http.ok3.impl.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: URLDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    private static final String TAG = "l";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f8457a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile l f8458b;
    private static AtomicBoolean o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f8459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f8460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicLong f8461e;
    private List<k> f;
    private final ReentrantReadWriteLock g;
    private List<c> h;
    private final ReentrantReadWriteLock i;
    private AtomicInteger j;
    private AtomicLong k;
    private ConcurrentMap<String, String> l;
    private String m;
    private String n;

    /* JADX INFO: compiled from: URLDispatcher.java */
    static class a implements Comparator<com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a> {
        a() {
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a r3, com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a r4) {
            return a((com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a) ZeusTransformUtils.preCheckCast(r3, com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a.class, "com.obric.aiagent.plugin"), (com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a) ZeusTransformUtils.preCheckCast(r4, com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a.class, "com.obric.aiagent.plugin"));
        }

        public int a(com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a r1, com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a r2) {
            return r1.a() - r2.a();
        }
    }

    public l() {
        this.f8459c = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
        this.f8460d = new AtomicBoolean(true);
        this.f8461e = new AtomicLong(0);
        this.f = new ArrayList();
        this.g = new ReentrantReadWriteLock();
        this.h = new ArrayList();
        this.i = new ReentrantReadWriteLock();
        this.j = new AtomicInteger(0);
        this.k = new AtomicLong(0);
        this.l = new ConcurrentHashMap();
    }

    static {
        o = new AtomicBoolean(false);
    }

    public static l a() {
        if (f8458b != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8458b != null) goto L9;
        f8458b = new l();     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f8458b;
    }

    public void a(Context r3) {
        this.f8459c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public Context getContext() {
        return this.f8459c;
    }

    public void a(String r1) {
        this.n = r1;
    }

    public e a(m r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "getDispatchResultForUrl: " + r4.b());
    L6:
        if (com.bytedance.frameworks.baselib.network.http.i.l.b(r4.b()) == true) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "illegal url");
    L10:
        return null;
    L12:
        if (this.f8460d.get() == true) goto L18;
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "dispatch is unabled by tnc");
    L16:
        return null;
    L18:
        return b(r4);
    }

    private e b(m r13) {
        String r0 = r13.b();
        e r1 = new e();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        r3.add(0, r0);
        this.g.readLock().lock();
        Iterator<k> r5 = this.f.iterator();
        String r6 = r0;
    L4:
        if (r5.hasNext() == false) goto L21;
        k r7 = (k) ZeusTransformUtils.preCheckCast(r5.next(), k.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L8;
        String r9 = TAG;
        Logger.d(r9, "action url = " + r3);
        Logger.d(r9, "current action priority is " + r7.a());
    L8:
        com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a.EnumC0191a r8 = r7.a(r13, r6, r3, r2);
        String r10 = (String) ZeusTransformUtils.preCheckCast(r3.get(0), String.class, "com.obric.aiagent.plugin");
        if (r8 == com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a.EnumC0191a.f8432c) goto L11;
        r6 = r10;
        goto L4
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "the url has been dropped by urldispatcher, skip follow-up actions");
    L13:
        r1.f8447d = r7.f();
        if (f8457a == true) goto L21;
        if (((String) ZeusTransformUtils.preCheckCast(r3.get(0), String.class, "com.obric.aiagent.plugin")).length() == 0) goto L21;
        throw new AssertionError();
    L21:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r3.get(0), String.class, "com.obric.aiagent.plugin");
        this.g.readLock().unlock();
        ArrayList r12 = new ArrayList();
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L31
        r4.put("origin_url", r0);     // Catch: JSONException -> L31
        r4.put("dispatched_url", r14);     // Catch: JSONException -> L31
        JSONArray r11 = new JSONArray();     // Catch: JSONException -> L31
        Iterator r15 = r2.iterator();     // Catch: JSONException -> L31
    L24:
        if (r15.hasNext() == false) goto L29;
        d r16 = (d) ZeusTransformUtils.preCheckCast(r15.next(), d.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L31
        if (r16.f8442d == false) goto L24;
        JSONObject r17 = new JSONObject();     // Catch: JSONException -> L31
        r12.add(Long.valueOf(r16.f8440b));     // Catch: JSONException -> L31
        r17.put("rule_id", r16.f8440b);     // Catch: JSONException -> L31
        r17.put("service_name", r16.f8439a);     // Catch: JSONException -> L31
        r17.put("priority", r16.f8441c);     // Catch: JSONException -> L31
        r11.put(r17);     // Catch: JSONException -> L31
        goto L24
    L29:
        r4.put("action_info_list", r11);     // Catch: JSONException -> L31
        JSONObject r18 = new JSONObject();     // Catch: JSONException -> L31
        r18.put("dispatch", r4);     // Catch: JSONException -> L31
        new JSONObject().put("dispatchersdk", r18);     // Catch: JSONException -> L31
    L33:
        r1.f8445b = r12;
        r1.f8444a = r14;
        r1.f8446c = r2;
        return r1;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    }

    public int a(String r9, String r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "getDelayResultForUrl: " + r9);
    L6:
        if (com.bytedance.frameworks.baselib.network.http.i.l.b(r9) == false) goto L8;
        this.i.readLock().lock();
        ArrayList r0 = new ArrayList();
        r0.add(0, 0);
        Iterator<c> r2 = this.h.iterator();
    L13:
        if (r2.hasNext() == false) goto L22;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "current action priority is " + r3.a());
    L18:
        if (r3.a(r9, r10, r0) != com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a.EnumC0191a.f8433d) goto L13;
        if (Logger.debug() == false) goto L22;
        Logger.d(TAG, "the url has been delayed by delay action, skip follow-up actions");
    L22:
        this.i.readLock().unlock();
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.get(0), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "illegal url");
    L10:
        return 0;
    }

    public void a(JSONObject r6, int r7, String r8, String r9, long r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "URLDispatcher::onServerConfigChanged, tnc source is " + r7 + "etag is " + r8);
    L5:
        this.j.set(r7);
        this.m = r8;
        this.n = r9;
        this.k.set(r10);
        int r11 = r6.optInt("ignore_retrofit_slash_enabled_v2", -1);
        int r12 = 0;
        boolean r13 = true;
        if (r11 < (-1)) goto L11;
        if (r11 != 1) goto L9;
        boolean r14 = true;
    L10:
        TTConfigManager.setIgnoreSlashEnabledV2(r14);
        goto L11
    L9:
        r14 = false;
    L11:
        JSONArray r15 = r6.optJSONArray("request_delay_actions");
        this.i.writeLock().lock();     // Catch: Throwable -> L62
        this.h.clear();     // Catch: Throwable -> L62
        if (r15 == null) goto L22;
        int r16 = 0;
    L16:
        if (r16 >= r15.length()) goto L22;
        JSONObject r2 = r15.optJSONObject(r16);     // Catch: Throwable -> L62
        if (r2 == null) goto L20;
        b(r2);     // Catch: Throwable -> L62
    L20:
        r16 = r16 + 1;     // Catch: Throwable -> L62
    L22:
        if (this.h.isEmpty() == true) goto L24;
        Collections.sort(this.h, new a());     // Catch: Throwable -> L62
    L24:
        this.i.writeLock().unlock();
        if (Logger.debug() == false) goto L27;
        Logger.d(TAG, "parse delay actions completed, actions size is " + this.h.size());
    L27:
        int r17 = r6.optInt("ttnet_url_dispatcher_enabled", -1);
        if (r17 < 0) goto L34;
        AtomicBoolean r18 = this.f8460d;
        if (r17 == 1) goto L33;
        r13 = false;
    L33:
        r18.set(r13);
    L34:
        long r19 = r6.optInt("ttnet_dispatch_actions_epoch", -1);
        if (r19 == this.f8461e.get()) goto L37;
        this.f8461e.set(r19);
        JSONArray r20 = r6.optJSONArray("ttnet_dispatch_actions");
        if (r20 != null) goto L69;
        return;
    L69:
        this.g.writeLock().lock();     // Catch: Throwable -> L57
        this.f.clear();     // Catch: Throwable -> L57
    L45:
        if (r12 >= r20.length()) goto L51;
        JSONObject r21 = r20.optJSONObject(r12);     // Catch: Throwable -> L57
        if (r21 == null) goto L49;
        a(r21);     // Catch: Throwable -> L57
    L49:
        r12 = r12 + 1;     // Catch: Throwable -> L57
        goto L45
    L51:
        if (this.f.isEmpty() == true) goto L53;
        Collections.sort(this.f, new a());     // Catch: Throwable -> L57
    L53:
        this.g.writeLock().unlock();
        if (Logger.debug() == false) goto L78;
        Logger.d(TAG, "parse dispatch actions completed, actions size is " + this.f.size());
        return;
    L78:
        return;
    L57:
        th = move-exception;
        this.g.writeLock().unlock();
        if (Logger.debug() == false) goto L61;
        Logger.d(TAG, "parse dispatch actions completed, actions size is " + this.f.size());
    L61:
        throw th;
    L37:
        if (Logger.debug() == false) goto L77;
        Logger.d(TAG, "dispatch action epoch not changed");
        return;
    L77:
        return;
    L62:
        th = move-exception;
        this.i.writeLock().unlock();
        if (Logger.debug() == false) goto L66;
        Logger.d(TAG, "parse delay actions completed, actions size is " + this.h.size());
    L66:
        throw th;
    }

    private void a(JSONObject r21) {
        String r3 = r21.optString("action");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        int r5 = r21.optInt("act_priority", -1);
        if (r5 >= 0) goto L8;
        return;
    L8:
        JSONObject r4 = r21.optJSONObject(AutoTestConstant.PARAM);
        if (r4 != null) goto L11;
        return;
    L11:
        String r2 = r21.optString("lifecycle");
        int r7 = 0;
        long r8 = 0;
        long r10 = -1;
        if ("".equals(r2) == false) goto L14;
        r10 = 0;
    L20:
        long r12 = r21.optInt("rule_id");
        String r6 = r21.optString("sign");
        ArrayList r14 = new ArrayList();
        JSONArray r9 = r21.optJSONArray("request_method");
        if (r9 != null) goto L23;
    L28:
        int r1 = r21.optInt("set_req_priority", r5);
        com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a r11 = com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a.a(r3, r4, r5, r8, r10, r12, r6, this.f8461e.get(), r14, r1);
        if (ZeusTransformUtils.instanceOf(r11, k.class) == false) goto L35;
        this.f.add((k) ZeusTransformUtils.preCheckCast(r11, k.class, "com.obric.aiagent.plugin"));
        return;
    L35:
        return;
    L23:
        if (r7 >= r9.length()) goto L28;
        String r15 = r9.optString(r7);
        if (TextUtils.isEmpty(r15) == true) goto L27;
        r14.add(r15);
    L27:
        r7 = r7 + 1;
        goto L23
    L14:
        ArrayList r13 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.i.g.a(r2, r13) == true) goto L17;
    L19:
        r8 = -1;
        goto L20
    L17:
        if (r13.size() != 2) goto L19;
        r8 = ((Long) ZeusTransformUtils.preCheckCast(r13.get(0), Long.class, "com.obric.aiagent.plugin")).longValue();
        r10 = ((Long) ZeusTransformUtils.preCheckCast(r13.get(1), Long.class, "com.obric.aiagent.plugin")).longValue();
        goto L20
    }

    private void b(JSONObject r19) {
        int r6 = r19.optInt("act_priority", -1);
        if (r6 >= 0) goto L5;
        return;
    L5:
        JSONObject r5 = r19.optJSONObject(AutoTestConstant.PARAM);
        if (r5 != null) goto L8;
        return;
    L8:
        String r1 = r19.optString("lifecycle");
        long r7 = -1;
        if ("".equals(r1) == false) goto L11;
        r7 = 0;
    L16:
        long r9 = r7;
    L17:
        com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a r2 = com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a.a("delay", r5, r6, r7, r9, 0, "", this.f8461e.get(), null, 0);
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L21;
        this.h.add((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin"));
        return;
    L21:
        return;
    L11:
        ArrayList r3 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.i.g.a(r1, r3) != true) goto L16;
        if (r3.size() != 2) goto L16;
        r7 = ((Long) ZeusTransformUtils.preCheckCast(r3.get(0), Long.class, "com.obric.aiagent.plugin")).longValue();
        r9 = ((Long) ZeusTransformUtils.preCheckCast(r3.get(1), Long.class, "com.obric.aiagent.plugin")).longValue();
        goto L17
    }

    public boolean b() {
        return this.f.isEmpty();
    }

    public long c() {
        return this.f8461e.get();
    }

    public int d() {
        return this.j.get();
    }

    public long e() {
        return this.k.get();
    }

    public String f() {
        return this.m;
    }

    public String g() {
        return this.n;
    }

    public ConcurrentMap<String, String> h() {
        return this.l;
    }

    public String b(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
    L50:
        return r6;
    L5:
        if (r6.contains("/network/get_network") == true) goto L50;
        if (r6.contains("/get_domains/v5") == true) goto L50;
        if (r6.contains("/ies/speed") == true) goto L50;
        String r0 = null;
        URL r1 = new URL(r6);     // Catch: Throwable -> L17
        String r2 = r1.getProtocol();     // Catch: Throwable -> L17
        r0 = r1.getHost();     // Catch: Throwable -> L15
    L21:
        if (TextUtils.isEmpty(r2) == true) goto L50;
        if ("http".equals(r2) == true) goto L27;
        if ("https".equals(r2) == false) goto L50;
    L27:
        if (TextUtils.isEmpty(r0) == true) goto L50;
        ConcurrentMap<String, String> r3 = this.l;
        if (r3 == null) goto L48;
        if (r3.containsKey(r0) == false) goto L48;
        String r5 = (String) ZeusTransformUtils.preCheckCast(this.l.get(r0), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r5) == false) goto L38;
        return r6;
    L38:
        if (Logger.debug() == false) goto L40;
        Logger.d(TAG, "handleHostMapping, match, origin: " + r6);
    L40:
        String r4 = r2 + "://" + r0;
        String r7 = r2 + "://" + r5;
        if (r6.startsWith(r4) == false) goto L44;
        r6 = r6.replaceFirst(r4, r7);
    L44:
        if (Logger.debug() == false) goto L46;
        Logger.d(TAG, "handleHostMapping, target: " + r6);
    L46:
        return r6;
    L48:
        if (Logger.debug() == false) goto L50;
        Logger.d(TAG, "handleHostMapping, nomatch: " + r0);
    L15:
        th = th;
    L19:
        th.printStackTrace();
    L17:
        th = th;
        r2 = null;
        goto L19
    }

    public void b(Context r11) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        if (com.bytedance.frameworks.baselib.network.http.i.h.b(r10) == true) goto L5;
        return;
    L5:
        if (o.get() == true) goto L23;
        SharedPreferences r12 = r10.getSharedPreferences("ttnet_tnc_config", 0);
        boolean r13 = r12.getBoolean("is_full_config", false);
        String r0 = r12.getString("tnc_config_str", null);
        String r6 = r12.getString("ttnet_tnc_etag", null);
        String r7 = r12.getString("ttnet_tnc_abtest", null);
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        o.set(true);
        return;
    L8:
        if (TextUtils.isEmpty(r0) == true) goto L18;
        JSONObject r14 = new JSONObject(r0);     // Catch: JSONException -> L16
        if (r13 == false) goto L14;
        JSONObject r15 = r14.optJSONObject("data");     // Catch: JSONException -> L16
        if (r15 == null) goto L14;
        r14 = r15;
    L14:
        l r3 = a();     // Catch: JSONException -> L16
        r3.a(r14, 0, r6, r7, System.currentTimeMillis());     // Catch: JSONException -> L16
        goto L18
    }
}
