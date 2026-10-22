package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedanceos.common.toolbox.ServerElements;
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
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f7492m = "g";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile g f7493n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static AtomicBoolean f7494o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f7496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicLong f7497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f7498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReentrantReadWriteLock f7499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f7500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReentrantReadWriteLock f7501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AtomicInteger f7502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AtomicLong f7503i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ConcurrentMap f7504j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f7505k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f7506l;

    public static class a implements Comparator {
        public a() {
        }

        public int a(BaseDispatchAction r10, BaseDispatchAction r11) {
            return r10.b() - r11.b();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((BaseDispatchAction) r10, (BaseDispatchAction) r11);
        }
    }

    static {
        f7494o = new AtomicBoolean(false);
    }

    public g() {
        this.f7495a = null;
        this.f7496b = new AtomicBoolean(true);
        this.f7497c = new AtomicLong(0);
        this.f7498d = new ArrayList();
        this.f7499e = new ReentrantReadWriteLock();
        this.f7500f = new ArrayList();
        this.f7501g = new ReentrantReadWriteLock();
        this.f7502h = new AtomicInteger(0);
        this.f7503i = new AtomicLong(0);
        this.f7504j = new ConcurrentHashMap();
    }

    public static g l() {
        if (f7493n != null) goto L16;
        monitor-enter(g.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f7493n != null) goto L11;
        f7493n = new g();     // Catch: Throwable -> L9
    L11:
        monitor-exit(g.class);     // Catch: Throwable -> L9
    L16:
        return f7493n;
    }

    public final u4.b a(u4.c r12) {
        String r10 = r12.c();
        u4.b r11 = new u4.b();
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        r14.add(0, r10);
        this.f7499e.readLock().lock();
        Iterator r15 = this.f7498d.iterator();
        String r16 = r10;
    L4:
        if (r15.hasNext() == false) goto L9;
        f r17 = (f) r15.next();
        String r18 = f7492m;
        Logger.d(r18, "action url = " + r14);
        Logger.d(r18, "current action priority is " + r17.b());
        BaseDispatchAction.DispatchResultEnum r19 = r17.u(r12, r16, r14, r13);
        String r20 = (String) r14.get(0);
        if (r19 == BaseDispatchAction.DispatchResultEnum.DISPATCH_DROP) goto L7;
        r16 = r20;
        goto L4
    L7:
        Logger.d(r18, "the url has been dropped by urldispatcher, skip follow-up actions");
    L9:
        String r110 = (String) r14.get(0);
        this.f7499e.readLock().unlock();
        ArrayList r111 = new ArrayList();
        JSONObject r21 = new JSONObject();     // Catch: JSONException -> L17
        r21.put("origin_url", r10);     // Catch: JSONException -> L17
        r21.put("dispatched_url", r110);     // Catch: JSONException -> L17
        JSONArray r22 = new JSONArray();     // Catch: JSONException -> L17
        Iterator r23 = r13.iterator();     // Catch: JSONException -> L17
    L12:
        if (r23.hasNext() == false) goto L19;
        u4.a r24 = (u4.a) r23.next();     // Catch: JSONException -> L17
        if (r24.f24854d == false) goto L12;
        JSONObject r25 = new JSONObject();     // Catch: JSONException -> L17
        r111.add(Long.valueOf(r24.f24852b));     // Catch: JSONException -> L17
        r25.put("rule_id", r24.f24852b);     // Catch: JSONException -> L17
        r25.put("service_name", r24.f24851a);     // Catch: JSONException -> L17
        r25.put("priority", r24.f24853c);     // Catch: JSONException -> L17
        r22.put(r25);     // Catch: JSONException -> L17
        goto L12
    L19:
        r21.put("action_info_list", r22);     // Catch: JSONException -> L17
        JSONObject r26 = new JSONObject();     // Catch: JSONException -> L17
        r26.put("dispatch", r21);     // Catch: JSONException -> L17
        new JSONObject().put("dispatchersdk", r26);     // Catch: JSONException -> L17
    L22:
        r11.f24859b = r111;
        r11.f24858a = r110;
        r11.f24860c = r13;
        return r11;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public Context b() {
        return this.f7495a;
    }

    public int c(String r10, String r11) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f7492m, "getDelayResultForUrl: " + r10);
    L6:
        if (i.f(r10) == false) goto L8;
        this.f7501g.readLock().lock();
        ArrayList r12 = new ArrayList();
        r12.add(0, 0);
        Iterator r13 = this.f7500f.iterator();
    L13:
        if (r13.hasNext() == false) goto L22;
        b r14 = (b) r13.next();
        if (Logger.debug() == false) goto L18;
        Logger.d(f7492m, "current action priority is " + r14.b());
    L18:
        if (r14.s(r10, r11, r12) != BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY) goto L13;
        if (Logger.debug() == false) goto L22;
        Logger.d(f7492m, "the url has been delayed by delay action, skip follow-up actions");
    L22:
        this.f7501g.readLock().unlock();
        return ((Integer) r12.get(0)).intValue();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d(f7492m, "illegal url");
    L10:
        return 0;
    }

    public u4.b d(u4.c r10) {
        String r11 = f7492m;
        Logger.d(r11, "getDispatchResultForUrl: " + r10.c());
        if (i.f(r10.c()) == true) goto L7;
        Logger.d(r11, "illegal url");
        return null;
    L7:
        if (this.f7496b.get() == true) goto L11;
        Logger.d(r11, "dispatch is unabled by tnc");
        return null;
    L11:
        return a(r10);
    }

    public long e() {
        return this.f7497c.get();
    }

    public ConcurrentMap f() {
        return this.f7504j;
    }

    public String g() {
        return this.f7506l;
    }

    public String h() {
        return this.f7505k;
    }

    public int i() {
        return this.f7502h.get();
    }

    public long j() {
        return this.f7503i.get();
    }

    public String k(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L45:
        return r10;
    L5:
        if (r10.contains("/network/get_network") == true) goto L45;
        if (r10.contains("/get_domains/v5") == true) goto L45;
        if (r10.contains("/ies/speed") == true) goto L45;
        String r11 = null;
        URL r12 = new URL(r10);     // Catch: Throwable -> L17
        String r13 = r12.getProtocol();     // Catch: Throwable -> L17
        r11 = r12.getHost();     // Catch: Throwable -> L15
    L21:
        if (TextUtils.isEmpty(r13) == true) goto L45;
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(r13) == true) goto L27;
        if ("https".equals(r13) == false) goto L45;
    L27:
        if (TextUtils.isEmpty(r11) == true) goto L45;
        ConcurrentMap r14 = this.f7504j;
        if (r14 == null) goto L43;
        if (r14.containsKey(r11) == false) goto L43;
        String r15 = (String) this.f7504j.get(r11);
        if (TextUtils.isEmpty(r15) == false) goto L37;
        return r10;
    L37:
        String r16 = f7492m;
        Logger.d(r16, "handleHostMapping, match, origin: " + r10);
        String r17 = r13 + "://" + r11;
        String r18 = r13 + "://" + r15;
        if (r10.startsWith(r17) == false) goto L40;
        r10 = r10.replaceFirst(r17, r18);
    L40:
        Logger.d(r16, "handleHostMapping, target: " + r10);
        return r10;
    L43:
        if (Logger.debug() == false) goto L45;
        Logger.d(f7492m, "handleHostMapping, nomatch: " + r11);
    L15:
        th = th;
    L19:
        th.printStackTrace();
    L17:
        th = th;
        r13 = null;
        goto L19
    }

    public boolean m() {
        return this.f7498d.isEmpty();
    }

    public boolean n() {
        return !this.f7500f.isEmpty();
    }

    public void o(Context r10) {
        if (com.bytedance.frameworks.baselib.network.http.util.f.e(r10) == true) goto L5;
        return;
    L5:
        if (f7494o.get() == true) goto L18;
        SharedPreferences r11 = r10.getSharedPreferences("ttnet_tnc_config", 0);
        String r12 = r11.getString("tnc_config_str", null);
        String r13 = r11.getString("ttnet_tnc_etag", null);
        String r14 = r11.getString("ttnet_tnc_abtest", null);
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        f7494o.set(true);
        return;
    L8:
        if (TextUtils.isEmpty(r12) == true) goto L13;
        JSONObject r15 = new JSONObject(r12);     // Catch: JSONException -> L11
        l().p(r15, 0, r13, r14, System.currentTimeMillis());     // Catch: JSONException -> L11
        goto L13
    }

    public void p(JSONObject r10, int r11, String r12, String r13, long r14) {
        Logger.d(f7492m, "URLDispatcher::onServerConfigChanged, tnc source is " + r11 + "etag is " + r12);
        this.f7502h.set(r11);
        this.f7505k = r12;
        this.f7506l = r13;
        this.f7503i.set(r14);
        JSONArray r15 = r10.optJSONArray("request_delay_actions");
        this.f7501g.writeLock().lock();     // Catch: Throwable -> L11
        this.f7500f.clear();     // Catch: Throwable -> L11
        int r16 = 0;
        if (r15 == null) goto L15;
        int r17 = 0;
    L7:
        if (r17 >= r15.length()) goto L15;
        JSONObject r18 = r15.optJSONObject(r17);     // Catch: Throwable -> L11
        if (r18 == null) goto L13;
        r(r18);     // Catch: Throwable -> L11
    L13:
        r17 = r17 + 1;     // Catch: Throwable -> L11
    L15:
        if (this.f7500f.isEmpty() == true) goto L17;
        Collections.sort(this.f7500f, new a());     // Catch: Throwable -> L11
    L17:
        this.f7501g.writeLock().unlock();
        if (Logger.debug() == false) goto L20;
        Logger.d(f7492m, "parse delay actions completed, actions size is " + this.f7500f.size());
    L20:
        int r19 = r10.optInt("ttnet_url_dispatcher_enabled", -1);
        if (r19 < 0) goto L27;
        AtomicBoolean r110 = this.f7496b;
        boolean r111 = true;
        if (r19 == 1) goto L26;
        r111 = false;
    L26:
        r110.set(r111);
    L27:
        long r20 = r10.optInt("ttnet_dispatch_actions_epoch", -1);
        if (r20 != this.f7497c.get()) goto L31;
        Logger.d(f7492m, "dispatch action epoch not changed");
        return;
    L31:
        this.f7497c.set(r20);
        JSONArray r21 = r10.optJSONArray("ttnet_dispatch_actions");
        if (r21 != null) goto L54;
        return;
    L54:
        this.f7499e.writeLock().lock();     // Catch: Throwable -> L40
        this.f7498d.clear();     // Catch: Throwable -> L40
    L36:
        if (r16 >= r21.length()) goto L44;
        JSONObject r22 = r21.optJSONObject(r16);     // Catch: Throwable -> L40
        if (r22 == null) goto L42;
        q(r22);     // Catch: Throwable -> L40
    L42:
        r16 = r16 + 1;     // Catch: Throwable -> L40
        goto L36
    L44:
        if (this.f7498d.isEmpty() == true) goto L46;
        Collections.sort(this.f7498d, new a());     // Catch: Throwable -> L40
    L46:
        this.f7499e.writeLock().unlock();
        Logger.d(f7492m, "parse dispatch actions completed, actions size is " + this.f7498d.size());
        return;
    L40:
        th = move-exception;
        this.f7499e.writeLock().unlock();
        Logger.d(f7492m, "parse dispatch actions completed, actions size is " + this.f7498d.size());
        throw th;
    L11:
        th = move-exception;
        this.f7501g.writeLock().unlock();
        if (Logger.debug() == false) goto L53;
        Logger.d(f7492m, "parse delay actions completed, actions size is " + this.f7500f.size());
    L53:
        throw th;
    }

    public final void q(JSONObject r20) {
        String r10 = r20.optString("action");
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        int r11 = r20.optInt("act_priority", -1);
        if (r11 >= 0) goto L8;
        return;
    L8:
        JSONObject r12 = r20.optJSONObject("param");
        if (r12 != null) goto L11;
        return;
    L11:
        String r13 = r20.optString("lifecycle");
        int r14 = 0;
        if ("".equals(r13) == false) goto L15;
        long r15 = 0;
    L14:
        long r16 = r15;
    L21:
        long r17 = r20.optInt("rule_id");
        String r18 = r20.optString(ServerElements.SIGN);
        ArrayList r19 = new ArrayList();
        JSONArray r21 = r20.optJSONArray("request_method");
        if (r21 != null) goto L24;
    L29:
        long r22 = r15;
        long r23 = r16;
        BaseDispatchAction r24 = BaseDispatchAction.a(r10, r12, r11, r22, r23, r17, r18, this.f7497c.get(), r19, r20.optInt("set_req_priority", r11));
        if ((r24 instanceof f) == false) goto L36;
        this.f7498d.add((f) r24);
        return;
    L36:
        return;
    L24:
        if (r14 >= r21.length()) goto L29;
        String r110 = r21.optString(r14);
        if (TextUtils.isEmpty(r110) == true) goto L28;
        r19.add(r110);
    L28:
        r14 = r14 + 1;
        goto L24
    L15:
        ArrayList r25 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.util.e.c(r13, r25) == true) goto L18;
    L20:
        r15 = -1;
        goto L14
    L18:
        if (r25.size() != 2) goto L20;
        long r26 = ((Long) r25.get(0)).longValue();
        r16 = ((Long) r25.get(1)).longValue();
        r15 = r26;
        goto L21
    }

    public final void r(JSONObject r19) {
        int r10 = r19.optInt("act_priority", -1);
        if (r10 >= 0) goto L5;
        return;
    L5:
        JSONObject r11 = r19.optJSONObject("param");
        if (r11 != null) goto L8;
        return;
    L8:
        String r12 = r19.optString("lifecycle");
        if ("".equals(r12) == false) goto L12;
        long r13 = 0;
    L11:
        long r14 = r13;
        long r15 = r14;
    L18:
        BaseDispatchAction r16 = BaseDispatchAction.a("delay", r11, r10, r14, r15, 0, "", this.f7497c.get(), null, 0);
        if ((r16 instanceof b) == false) goto L22;
        this.f7500f.add((b) r16);
        return;
    L22:
        return;
    L12:
        ArrayList r17 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.util.e.c(r12, r17) == true) goto L15;
    L17:
        r13 = -1;
        goto L11
    L15:
        if (r17.size() != 2) goto L17;
        r14 = ((Long) r17.get(0)).longValue();
        r15 = ((Long) r17.get(1)).longValue();
        goto L18
    }

    public void s(Context r10) {
        this.f7495a = r10;
    }
}
