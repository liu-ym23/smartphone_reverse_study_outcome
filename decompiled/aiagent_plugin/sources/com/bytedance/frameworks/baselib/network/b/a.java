package com.bytedance.frameworks.baselib.network.b;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import okhttp3.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InsecureRequestControlConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f7977a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArraySet<String> f7978b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CopyOnWriteArraySet<String> f7979c = null;

    static {
        f7978b = new CopyOnWriteArraySet();
        f7979c = new CopyOnWriteArraySet();
    }

    public static boolean a() {
        return f7977a;
    }

    public static Set<String> a(List<String> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        CopyOnWriteArraySet<String> r0 = f7978b;
        if (r0.isEmpty() == true) goto L31;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.isEmpty() == true) goto L34;
        HashSet r2 = new HashSet();
        Iterator<String> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L20;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        Iterator r5 = r10.iterator();
    L13:
        if (r5.hasNext() == false) goto L10;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L13;
        if (r6.contains(r4 + "=") == false) goto L13;
        r2.add(r4);
        goto L13
    L20:
        if (r2.size() > 0) goto L22;
        return null;
    L22:
        return r2;
    L34:
        return null;
    L31:
        return null;
    }

    public static Set<String> a(u r6) {
        CopyOnWriteArraySet<String> r0 = f7979c;
        if (r0.isEmpty() == true) goto L23;
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r6.a() == 0) goto L26;
        HashSet r1 = new HashSet();
        Iterator<String> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        if (r6.a(r3) == null) goto L10;
        r1.add(r3);
        goto L10
    L15:
        if (r1.size() > 0) goto L17;
        return null;
    L17:
        return r1;
    L26:
        return null;
    L23:
        return null;
    }

    public static void a(JSONObject r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        b();
        JSONObject r3 = r2.optJSONObject("insecure_request_control");
        if (r3 != null) goto L7;
        return;
    L7:
        boolean r1 = false;
        if (r3.optInt("disable_share_insecure_cookie", 0) <= 0) goto L10;
        r1 = true;
    L10:
        f7977a = r1;
        a(r3.optJSONArray("secret_cookie_list"), f7978b);
        a(r3.optJSONArray("secret_header_list"), f7979c);
    }

    private static void b() {
        f7977a = false;
        f7978b.clear();
        f7979c.clear();
    }

    private static void a(JSONArray r3, CopyOnWriteArraySet<String> r4) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L19;
        int r0 = 0;
    L14:
        if (r0 >= r3.length()) goto L21;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r4.add(r1);     // Catch: JSONException -> L13
    L11:
        r0 = r0 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }
}
