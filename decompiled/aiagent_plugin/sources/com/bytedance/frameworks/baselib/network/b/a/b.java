package com.bytedance.frameworks.baselib.network.b.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.b.a.c;
import com.bytedance.frameworks.baselib.network.http.i.l;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTHostPathRuleBaseTNCConfig.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends c> {
    private static final String TAG = "TTHostPathMatchRule";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AtomicBoolean f7985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Pair<a, T>> f7986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f7987c;

    public abstract T a(Object r1);

    public abstract String a();

    boolean a(JSONObject r1) {
        return true;
    }

    public b() {
        this.f7985a = new AtomicBoolean(false);
        this.f7986b = new CopyOnWriteArrayList();
    }

    public boolean b(JSONObject r10) {
        int r1 = 0;
        this.f7985a.set(false);
        this.f7986b.clear();
        if (r10 != null) goto L5;
    L95:
        return false;
    L5:
        if (r10.length() == 0) goto L95;
        JSONObject r11 = r10.optJSONObject(a());
        if (r11 != null) goto L10;
    L94:
        return true;
    L10:
        if (r11.length() == 0) goto L94;
        AtomicBoolean r2 = this.f7985a;
        if (r11.optInt("enabled", 0) <= 0) goto L15;
        boolean r3 = true;
    L16:
        r2.set(r3);
        if (this.f7985a.get() == true) goto L20;
        return true;
    L20:
        if (a(r11) == true) goto L22;
        return false;
    L22:
        Object r4 = r11.opt(DownloadSettingKeys.BugFix.DEFAULT);
        if (r4 == null) goto L25;
        this.f7987c = (T) a(r4);
    L25:
        JSONArray r12 = r11.optJSONArray("rule_list");
        if (r12 != null) goto L28;
    L93:
        return false;
    L28:
        if (r12.length() == 0) goto L93;
    L31:
        if (r1 >= r12.length()) goto L92;
        JSONObject r5 = r12.optJSONObject(r1);
        if (r5 == null) goto L91;
        if (r5.length() == 0) goto L91;
        a r6 = new a();
        r6.f7980a = a(r5.optJSONArray("host_eq"));
        r6.f7981b = a(r5.optJSONArray("host_wc"));
        if (r6.f7980a == null) goto L42;
        if (r6.f7980a.isEmpty() == true) goto L42;
    L46:
        r6.f7982c = a(r5.optJSONArray("path_eq"));
        r6.f7983d = a(r5.optJSONArray("path_prefix"));
        r6.f7984e = a(r5.optJSONArray("path_contain"));
        Set<String> r7 = a(r5.optJSONArray("path_pattern"));
        if (r7 == null) goto L55;
        r6.f = new HashSet();
        Iterator<String> r8 = r7.iterator();
    L50:
        if (r8.hasNext() == false) goto L55;
        r6.f.add(Pattern.compile((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L96
    L55:
        if (r6.f7982c == null) goto L59;
        if (r6.f7982c.isEmpty() == true) goto L59;
    L71:
        Object r9 = r5.opt("value");
        if (r9 == null) goto L74;
        c r13 = a(r9);
        if (r13 == null) goto L79;
        String r14 = r5.optString("sign");
        if (TextUtils.isEmpty(r14) == true) goto L84;
        r13.f7988a = r14;
    L84:
        this.f7986b.add(new Pair(r6, r13));
        goto L91
    L79:
        if (Logger.debug() == false) goto L91;
        Logger.d(TAG, "ParseHostPathValue failed.");
        goto L91
    L74:
        if (Logger.debug() == false) goto L91;
        Logger.d(TAG, "value is null.");
    L59:
        if (r6.f7983d == null) goto L63;
        if (r6.f7983d.isEmpty() == false) goto L71;
    L63:
        if (r6.f7984e == null) goto L67;
        if (r6.f7984e.isEmpty() == false) goto L71;
    L67:
        if (r6.f == null) goto L86;
        if (r6.f.isEmpty() == false) goto L71;
    L86:
        if (Logger.debug() == false) goto L91;
        Logger.d(TAG, "no path filter exist.");
    L42:
        if (r6.f7981b == null) goto L89;
        if (r6.f7981b.isEmpty() == false) goto L46;
    L89:
        if (Logger.debug() == false) goto L91;
        Logger.d(TAG, "both host_eq and host_wc empty.");
    L91:
        r1 = r1 + 1;
        goto L31
    L92:
        return true;
    L15:
        r3 = false;
        goto L16
    }

    public T a(String r13) {
        if (TextUtils.isEmpty(r13) == false) goto L5;
    L104:
        return null;
    L5:
        if (this.f7985a.get() == false) goto L104;
        Uri r14 = Uri.parse(r13);
        if (r14 != null) goto L10;
        return null;
    L10:
        String r0 = r14.getHost();
        String r15 = r14.getPath();
        if (TextUtils.isEmpty(r0) == true) goto L104;
        if (TextUtils.isEmpty(r15) == true) goto L104;
        Iterator<Pair<a, T>> r1 = this.f7986b.iterator();
    L17:
        if (r1.hasNext() == false) goto L100;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r1.next(), Pair.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L17;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r2.first, a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L17;
        boolean r7 = false;
        boolean r8 = true;
        if (r4.f7980a != null) goto L27;
    L32:
        boolean r6 = false;
    L33:
        if (r6 == false) goto L35;
    L45:
        if (r6 == false) goto L100;
        if (r4.f7982c != null) goto L50;
    L55:
        if (r7 == false) goto L57;
    L67:
        if (r7 == false) goto L69;
    L79:
        if (r7 == false) goto L81;
    L94:
        r8 = r7;
    L95:
        if (r8 == false) goto L17;
        return (T) ZeusTransformUtils.preCheckCast(r2.second, c.class, "com.obric.aiagent.plugin");
    L81:
        if (r4.f == null) goto L94;
        Iterator<Pattern> r5 = r4.f.iterator();
    L84:
        if (r5.hasNext() == false) goto L94;
        Pattern r9 = (Pattern) ZeusTransformUtils.preCheckCast(r5.next(), Pattern.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L84;
        if (r9.matcher(r15).matches() == false) goto L84;
    L93:
        r7 = true;
        goto L84
    L90:
        if (Logger.debug() == false) goto L95;
        Logger.d(TAG, "hitRule: path_pattern.");     // Catch: Throwable -> L93
        goto L95
    L69:
        if (r4.f7984e == null) goto L79;
        Iterator<String> r10 = r4.f7984e.iterator();
    L72:
        if (r10.hasNext() == false) goto L79;
        if (r15.contains((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L72;
        if (Logger.debug() == false) goto L78;
        Logger.d(TAG, "hitRule: path_contain.");
    L78:
        r7 = true;
        goto L79
    L57:
        if (r4.f7983d == null) goto L67;
        Iterator<String> r11 = r4.f7983d.iterator();
    L60:
        if (r11.hasNext() == false) goto L67;
        if (r15.startsWith((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L60;
        if (Logger.debug() == false) goto L66;
        Logger.d(TAG, "hitRule: path_prefix.");
    L66:
        r7 = true;
        goto L67
    L50:
        if (r4.f7982c.contains(r15) == false) goto L55;
        if (Logger.debug() == false) goto L54;
        Logger.d(TAG, "hitRule: path_eq.");
    L54:
        r7 = true;
        goto L55
    L35:
        if (r4.f7981b == null) goto L45;
        Iterator<String> r12 = r4.f7981b.iterator();
    L38:
        if (r12.hasNext() == false) goto L45;
        if (l.a(r0, (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L38;
        if (Logger.debug() == false) goto L44;
        Logger.d(TAG, "hitRule: host_wc.");
    L44:
        r6 = true;
        goto L38
    L27:
        if (r4.f7980a.contains(r0) == false) goto L32;
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "hitRule: host_eq.");
    L31:
        r6 = true;
    L100:
        if (Logger.debug() == false) goto L103;
        Logger.d(TAG, "use default config");
    L103:
        return this.f7987c;
    }

    public void a(boolean r1) {
        this.f7985a.set(r1);
    }

    public boolean b() {
        return this.f7985a.get();
    }

    public List<Pair<a, T>> c() {
        return this.f7986b;
    }

    public Set<String> a(JSONArray r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.length() == 0) goto L19;
        HashSet r3 = new HashSet();
        int r0 = 0;
    L8:
        if (r0 >= r4.length()) goto L13;
        String r1 = r4.optString(r0);
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r3.add(r1);
    L12:
        r0 = r0 + 1;
        goto L8
    L13:
        return r3;
    L19:
        return null;
    }
}
