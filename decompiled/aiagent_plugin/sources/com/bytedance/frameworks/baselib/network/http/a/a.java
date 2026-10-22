package com.bytedance.frameworks.baselib.network.http.a;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonParamConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "CommonParamConfig";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f8126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f8127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f8128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile String f8129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f8130e;
    private CopyOnWriteArraySet<String> f;
    private CopyOnWriteArraySet<String> g;
    private CopyOnWriteArraySet<Pattern> h;
    private CopyOnWriteArraySet<String> i;
    private CopyOnWriteArraySet<String> j;
    private CopyOnWriteArraySet<Pattern> k;
    private CopyOnWriteArraySet<String> l;

    public boolean a() {
        return this.f8126a;
    }

    public boolean b() {
        return this.f8127b;
    }

    public boolean c() {
        return this.f8128c;
    }

    public Set<String> d() {
        return this.f8130e;
    }

    public Set<String> e() {
        return this.f;
    }

    public Set<String> f() {
        return this.g;
    }

    public Set<Pattern> g() {
        return this.h;
    }

    public Set<String> h() {
        return this.i;
    }

    public Set<String> i() {
        return this.j;
    }

    public Set<Pattern> j() {
        return this.k;
    }

    public Set<String> k() {
        return this.l;
    }

    public void a(String r7) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onNetConfigChanged config: " + r7);
    L6:
        if (TextUtils.isEmpty(r7) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.f8129d) == false) goto L11;
    L25:
        JSONObject r0 = new JSONObject(r7);     // Catch: Throwable -> L24
        this.f8129d = r7;     // Catch: Throwable -> L24
        b(r0.optJSONArray("host_group"), this.f8130e);     // Catch: Throwable -> L24
        b(r0.optJSONArray("min_params_exclude"), this.l);     // Catch: Throwable -> L24
        JSONObject r8 = r0.optJSONObject("L0_path");     // Catch: Throwable -> L24
        if (r8 == null) goto L20;
        b(r8.optJSONArray("equal_group"), this.f);     // Catch: Throwable -> L24
        b(r8.optJSONArray("prefix_group"), this.g);     // Catch: Throwable -> L24
        a(r8.optJSONArray("pattern_group"), this.h);     // Catch: Throwable -> L24
    L20:
        JSONObject r9 = r0.optJSONObject("L1_path");     // Catch: Throwable -> L24
        if (r9 == null) goto L28;
        b(r9.optJSONArray("equal_group"), this.i);     // Catch: Throwable -> L24
        b(r9.optJSONArray("prefix_group"), this.j);     // Catch: Throwable -> L24
        a(r9.optJSONArray("pattern_group"), this.k);     // Catch: Throwable -> L24
        return;
    L28:
        return;
    L29:
        return;
    L11:
        if (this.f8129d.equals(r7) == false) goto L25;
        if (Logger.debug() == false) goto L27;
        Logger.d(TAG, "Config is same with local config, do not parse.");
        return;
    }

    private static void a(JSONArray r5, Set<Pattern> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L19;
        if (r7 == null) goto L28;
        HashSet r0 = new HashSet();
        Iterator r2 = r7.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r0.add(((Pattern) ZeusTransformUtils.preCheckCast(r2.next(), Pattern.class, "com.obric.aiagent.plugin")).toString());
        goto L8
    L10:
        int r1 = 0;
    L21:
        if (r1 >= r5.length()) goto L30;
        String r3 = r5.getString(r1);     // Catch: JSONException -> L20
        if (TextUtils.isEmpty(r3) == true) goto L18;
        if (r0.contains(r3) == true) goto L18;
        r7.add(Pattern.compile(r3, 2));     // Catch: JSONException -> L20
    L18:
        r1 = r1 + 1;
        goto L21
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    private static void b(JSONArray r2, Set<String> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        if (r4 == null) goto L16;
        int r0 = 0;
    L13:
        if (r0 >= r2.length()) goto L18;
        r4.add(r2.getString(r0));     // Catch: JSONException -> L12
        r0 = r0 + 1;
        goto L13
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }
}
