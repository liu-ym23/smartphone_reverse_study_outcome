package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import kotlinx.coroutines.channels.Channel;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b f7280c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7281d = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f7282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f7283b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f7284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f7285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f7286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f7287d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f7288e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Set f7289f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7290g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7291h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f7292i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public volatile int f7293j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public volatile long f7294k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public volatile boolean f7295l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7296m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f7297n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f7298o;

        public a(List r10, List r11) {
            this.f7284a = r10;
            this.f7285b = r11;
            this.f7294k = SystemClock.uptimeMillis();
            this.f7293j = 0;
            this.f7291h = Channel.UNLIMITED;
            this.f7290g = 0;
            this.f7295l = false;
            this.f7292i = UUID.randomUUID().toString();
            this.f7297n = false;
            this.f7296m = 4000;
            this.f7298o = true;
        }

        public List a() {
            return this.f7285b;
        }

        public String b() {
            return this.f7292i;
        }
    }

    static {
    }

    public b() {
        this.f7282a = 0;
        this.f7283b = new CopyOnWriteArrayList();
    }

    public static b d() {
        if (f7280c != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f7280c != null) goto L11;
        f7280c = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f7280c;
    }

    public static boolean f(List r10) {
        if (r10 != null) goto L4;
        return true;
    L4:
        if (r10.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean j(JSONObject r10, String r11, List r12) {
        int r13 = 0;
        if (r10 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L19;
        if (r12 == null) goto L19;
        JSONArray r14 = r10.optJSONArray(r11);
        if (r14 != null) goto L12;
        return false;
    L12:
        if (r13 >= r14.length()) goto L17;
        String r15 = r14.optString(r13);
        if (TextUtils.isEmpty(r15) == true) goto L16;
        r12.add(r15);
    L16:
        r13 = r13 + 1;
        goto L12
    L17:
        return true;
    }

    public final a a(String r10) {
        Iterator r11 = this.f7283b.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        a r12 = (a) r11.next();
        if (r12.b().equals(r10) == false) goto L4;
        return r12;
    L8:
        return null;
    }

    public a b(g6.b r10) {
        l();
        Iterator r11 = this.f7283b.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        a r12 = (a) r11.next();
        if (g(r10, r12) == false) goto L4;
        return r12;
    L8:
        return null;
    }

    public boolean c(int r10, String r11) {
        if (r10 != 0) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L14;
        a r12 = a(r11);
        if (r12 == null) goto L14;
        Set r13 = r12.f7289f;
        if (r13 == null) goto L14;
        return r13.contains(Integer.valueOf(r10));
    }

    public boolean e() {
        if (this.f7282a <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean g(g6.b r10, a r11) {
        if (r11.f7290g > 0) goto L5;
    L7:
        String r12 = r10.D();
        if (TextUtils.isEmpty(r12) == false) goto L10;
        return false;
    L10:
        Iterator r13 = r11.f7284a.iterator();
    L12:
        if (r13.hasNext() == false) goto L45;
        if (i.i(r10.v(), (String) r13.next()) == false) goto L12;
        String r14 = r10.z();
        if (TextUtils.isEmpty(r14) == false) goto L19;
        return false;
    L19:
        if (f(r11.f7286c) == true) goto L27;
        Iterator r15 = r11.f7286c.iterator();
    L22:
        if (r15.hasNext() == false) goto L27;
        if (r14.equals((String) r15.next()) == false) goto L22;
        return true;
    L27:
        if (f(r11.f7287d) == true) goto L35;
        Iterator r16 = r11.f7287d.iterator();
    L30:
        if (r16.hasNext() == false) goto L35;
        if (r14.startsWith((String) r16.next()) == false) goto L30;
        return true;
    L35:
        if (f(r11.f7288e) == true) goto L44;
        Iterator r17 = r11.f7288e.iterator();
    L38:
        if (r17.hasNext() == false) goto L44;
        Pattern r18 = (Pattern) r17.next();
        if (r18 == null) goto L38;
        if (r18.matcher(r14).matches() == false) goto L38;
        return true;
    L44:
        return false;
    L45:
        Logger.d(f7281d, "host not match: " + r12);
        return false;
    L5:
        if (r11.f7295l == false) goto L7;
        return false;
    }

    public void h(String r10, boolean r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        a r12 = a(r10);
        if (r12 != null) goto L8;
        return;
    L8:
        m(r12, r11);
    }

    public void i(String r10) {
        Logger.d(f7281d, "onNetConfigChanged config: " + r10);
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return;
    L12:
        JSONObject r11 = new JSONObject(r10);     // Catch: Throwable -> L10
        int r12 = 0;
        this.f7282a = r11.optInt("enabled_v2", 0);     // Catch: Throwable -> L10
        this.f7283b.clear();     // Catch: Throwable -> L10
        JSONArray r13 = r11.getJSONArray("match_rules");     // Catch: Throwable -> L10
    L7:
        if (r12 >= r13.length()) goto L15;
        k((JSONObject) r13.get(r12));     // Catch: Throwable -> L10
        r12 = r12 + 1;
        goto L7
    L15:
        return;
    L10:
        Logger.d(f7281d, "parse json config error");
    }

    public final void k(JSONObject r10) {
        ArrayList r11 = new ArrayList();
        j(r10, "host_group", r11);
        ArrayList r12 = new ArrayList();
        j(r10, "concurrent_hosts", r12);
        if (r11.isEmpty() == false) goto L5;
        return;
    L5:
        if (r12.size() < 2) goto L50;
        a r13 = new a(r11, r12);
        ArrayList r14 = new ArrayList();
        if (j(r10, "equal_group", r14) == false) goto L10;
        r13.f7286c = r14;
    L10:
        ArrayList r15 = new ArrayList();
        if (j(r10, "prefix_group", r15) == false) goto L13;
        r13.f7287d = r15;
    L13:
        ArrayList r16 = new ArrayList();
        JSONArray r17 = r10.optJSONArray("pattern_group");
        int r18 = 0;
        if (r17 == null) goto L23;
        int r19 = 0;
    L17:
        if (r19 >= r17.length()) goto L22;
        String r20 = r17.optString(r19);
        if (TextUtils.isEmpty(r20) == true) goto L21;
        r16.add(Pattern.compile(r20, 2));     // Catch: Throwable -> L42
    L21:
        r19 = r19 + 1;
        goto L17
    L22:
        r13.f7288e = r16;
    L23:
        r13.f7291h = r10.optInt("fail_count", Channel.UNLIMITED);
        r13.f7290g = r10.optInt("forbid_seconds", 0);
        r13.f7296m = r10.optInt("connect_interval_millis", 4000);
        boolean r21 = true;
        if (r10.optInt("bypass_rs_enabled", 1) <= 0) goto L26;
        boolean r22 = true;
    L27:
        r13.f7298o = r22;
        if (r13.f7296m > 0) goto L31;
        return;
    L31:
        if (r10.optInt("retry_for_not_2xx_code", 0) > 0) goto L34;
        r21 = false;
    L34:
        r13.f7297n = r21;
        HashSet r23 = new HashSet();
        JSONArray r24 = r10.optJSONArray("block_code_list");
        if (r24 != null) goto L37;
    L40:
        this.f7283b.add(r13);
        return;
    L37:
        if (r18 >= r24.length()) goto L39;
        r23.add(Integer.valueOf(r24.optInt(r18)));
        r18 = r18 + 1;
        goto L37
    L39:
        r13.f7289f = r23;
        goto L40
    L26:
        r22 = false;
        goto L27
    }

    public final void l() {
        Iterator r10 = this.f7283b.iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        a r11 = (a) r10.next();
        if (r11.f7295l == false) goto L4;
        long r12 = SystemClock.uptimeMillis() - r11.f7294k;
        if (r12 <= (r11.f7290g * 1000)) goto L11;
        r11.f7295l = false;
    L11:
        if (Logger.debug() == false) goto L4;
        Logger.d(f7281d, "Rule id: " + r11.f7292i + " has forbidden duration: " + r12 + " fail count: " + r11.f7293j + " forbidden duration: " + (r11.f7290g * 1000));
        goto L4
    }

    public final void m(a r10, boolean r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f7281d, "Forbidden: " + r10.f7295l + " failed count: " + r10.f7293j + " max count: " + r10.f7291h);
    L5:
        if (r11 == true) goto L7;
        int r12 = r10.f7293j + 1;
        r10.f7293j = r12;
        if (r12 >= r10.f7291h) goto L17;
        return;
    L17:
        if (r10.f7295l == true) goto L20;
        r10.f7295l = true;
        r10.f7294k = SystemClock.uptimeMillis();
    L20:
        if (Logger.debug() == false) goto L23;
        Logger.d(f7281d, "Forbidden: " + r10.f7295l + " failed count: " + r10.f7293j);
        return;
    L23:
        return;
    L7:
        if (r10.f7293j == 0) goto L9;
    L11:
        r10.f7293j = 0;
        r10.f7295l = false;
        return;
    L9:
        if (r10.f7295l == true) goto L11;
    }
}
