package com.bytedance.ttnet.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.i.j;
import com.bytedance.retrofit2.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CdnCacheVerifyUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "CDN_CACHE_VERIFY";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f11522a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<b> f11523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ReentrantReadWriteLock f11524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Lock f11525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Lock f11526e;

    /* JADX INFO: renamed from: com.bytedance.ttnet.utils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CdnCacheVerifyUtils.java */
    public static class C0260a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11528b;

        public C0260a() {
        }
    }

    /* JADX INFO: compiled from: CdnCacheVerifyUtils.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Pattern f11529a;

        public b() {
        }

        public boolean a(URI r4) {
            if (r4 != null) goto L5;
        L14:
            return false;
        L5:
            if (TextUtils.isEmpty(r4.getHost()) == true) goto L14;
            if (this.f11529a == null) goto L14;
            String r1 = r4.getHost();
            if (TextUtils.isEmpty(r4.getPath()) == true) goto L16;
            r1 = r1 + r4.getPath();
        L16:
            return this.f11529a.matcher(r1).matches();
        }

        public boolean a(String r1) {
            this.f11529a = Pattern.compile(r1);     // Catch: PatternSyntaxException -> L5
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static {
        f11523b = new ArrayList();
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        f11524c = r0;
        f11525d = r0.readLock();
        f11526e = f11524c.writeLock();
    }

    public static void a(String r2, List<com.bytedance.retrofit2.b.b> r3, af r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (f11522a == true) goto L5;
        return;
    L5:
        if (r4 == null) goto L15;
        r4.P();
    L15:
        a(r2, r5);     // Catch: Throwable -> L11
        if (r4 == null) goto L17;
        r4.Q();
        return;
    L17:
        return;
    L11:
        th = move-exception;
        if (r4 == null) goto L14;
        r4.Q();
    L14:
        throw th;
    }

    public static void a(com.bytedance.retrofit2.b.c r1, com.bytedance.retrofit2.b.d r2, com.bytedance.ttnet.d.b r3) {
        if (f11522a == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L8;
        Logger.w(TAG, "Req info is null");
        return;
    L8:
        b(r1, r2, r3);
    }

    private static void a(String r2, List<com.bytedance.retrofit2.b.b> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        String r5 = a(j.a(r2));     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r5) == true) goto L12;
        r4.add(new com.bytedance.retrofit2.b.b("X-TT-VERIFY-ID", r5));     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    private static String a(URI r0) {
        if (b(r0) == true) goto L5;
        return null;
    L5:
        return a();
    }

    private static boolean b(URI r4) {
        f11525d.lock();     // Catch: Throwable -> L12
        Iterator<b> r0 = f11523b.iterator();     // Catch: Throwable -> L12
    L4:
        if (r0.hasNext() == false) goto L10;
        goto L4
    L7:
        if (((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.aiagent.plugin")).a(r4) == false) goto L4;
        f11525d.unlock();
        return true;
    L10:
        f11525d.unlock();
        return false;
    L12:
        th = move-exception;
        f11525d.unlock();
        throw th;
    }

    private static String a() {
        return UUID.randomUUID().toString();
    }

    private static void b(com.bytedance.retrofit2.b.c r4, com.bytedance.retrofit2.b.d r5, com.bytedance.ttnet.d.b r6) {
        com.bytedance.retrofit2.b.b r1 = r4.a("X-TT-VERIFY-ID");
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.b();
    L6:
        com.bytedance.retrofit2.b.b r0 = r5.a("X-TT-VERIFY-ID");
        if (r0 == null) goto L9;
        r2 = r0.b();
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        if (r2 != null) goto L14;
        r6.ae = 1;
        Logger.w(TAG, "Cdn cache verify accessible");
    L21:
        c.a r7 = c.b();
        if (r7 == null) goto L36;
        if (r4.p() == null) goto L41;
        r4.p().B();
    L41:
        r7.a(r4.b(), r6);     // Catch: Throwable -> L30
        if (r4.p() == null) goto L36;
        r4.p().C();
    L30:
        th = move-exception;
        if (r4.p() == null) goto L34;
        r4.p().C();
    L34:
        throw th;
    L36:
        if (r6.ae == 3) goto L39;
        return;
    L39:
        throw new com.bytedance.frameworks.baselib.network.http.c.a("Fail to verify cdn cache");
    L14:
        if (r3.equals(r2) == false) goto L16;
        r6.ae = 2;
        Logger.w(TAG, "Cdn cache verify success");
        goto L21
    L16:
        r6.ae = 3;
        Logger.w(TAG, "Cdn cache verify fail");
        r5.d().e_().close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
        Logger.w(TAG, "Cdn cache verify stream close fail:" + th.toString());
        goto L21
    L5:
        r3 = null;
        goto L6
    }

    public static void a(SharedPreferences r3) {
        SharedPreferences r4 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.class, "com.obric.aiagent.plugin");
        int r0 = r4.getInt("ttnet_response_verify_enabled", -1);
        String r5 = r4.getString("ttnet_response_verify", "");
        if (TextUtils.isEmpty(r5) == false) goto L11;
    L8:
        JSONArray r1 = null;
    L9:
        a(r0, r1);
        return;
    L11:
        r1 = new JSONArray(r5);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    public static C0260a a(JSONObject r2) {
        int r0 = r2.optInt("ttnet_response_verify_enabled", -1);
        JSONArray r3 = r2.optJSONArray("ttnet_response_verify");
        if (r3 == null) goto L5;
        String r1 = r3.toString();
    L6:
        a(r0, r3);
        C0260a r4 = new C0260a();
        r4.f11527a = r0;
        r4.f11528b = r1;
        return r4;
    L5:
        r1 = "";
        goto L6
    }

    private static void a(int r4, JSONArray r5) {
        int r0 = 0;
        if (r4 <= 0) goto L16;
        ArrayList r6 = new ArrayList();
        if (r5 == null) goto L15;
        int r1 = r5.length();
    L7:
        if (r0 >= r1) goto L14;
        String r2 = r5.optString(r0);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        b r3 = new b();
        if (r3.a(r2) == false) goto L13;
        r6.add(r3);
    L13:
        r0 = r0 + 1;
        goto L7
    L14:
        a(r6);
    L15:
        a(true);
        return;
    L16:
        a(false);
    }

    public static void a(boolean r0) {
        f11522a = r0;
    }

    public static void a(List<b> r2) {
        List<b> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        f11526e.lock();     // Catch: Throwable -> L6
        f11523b = r3;     // Catch: Throwable -> L6
        f11526e.unlock();
        return;
    L6:
        th = move-exception;
        f11526e.unlock();
        throw th;
    }
}
