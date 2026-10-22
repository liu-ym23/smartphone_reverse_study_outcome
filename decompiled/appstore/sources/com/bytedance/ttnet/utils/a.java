package com.bytedance.ttnet.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.util.g;
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

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f8198a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List f8199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ReentrantReadWriteLock f8200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Lock f8201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Lock f8202e;

    /* JADX INFO: renamed from: com.bytedance.ttnet.utils.a$a, reason: collision with other inner class name */
    public static class C0104a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8204b;

        public C0104a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Pattern f8205a;

        public b() {
        }

        public boolean a(URI r10) {
            if (r10 != null) goto L4;
            return false;
        L4:
            if (TextUtils.isEmpty(r10.getHost()) == false) goto L6;
            return false;
        L6:
            if (this.f8205a == null) goto L16;
            String r11 = r10.getHost();
            if (TextUtils.isEmpty(r10.getPath()) == true) goto L12;
            r11 = r11 + r10.getPath();
        L12:
            return this.f8205a.matcher(r11).matches();
        L16:
            return false;
        }

        public boolean b(String r10) {
            this.f8205a = Pattern.compile(r10);     // Catch: PatternSyntaxException -> L5
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static {
        f8199b = new ArrayList();
        ReentrantReadWriteLock r10 = new ReentrantReadWriteLock();
        f8200c = r10;
        f8201d = r10.readLock();
        f8202e = f8200c.writeLock();
    }

    public static boolean a(URI r10) {
        f8201d.lock();     // Catch: Throwable -> L9
        Iterator r11 = f8199b.iterator();     // Catch: Throwable -> L9
    L4:
        if (r11.hasNext() == false) goto L11;
        if (((b) r11.next()).a(r10) == false) goto L4;
        f8201d.unlock();
        return true;
    L11:
        f8201d.unlock();
        return false;
    L9:
        th = move-exception;
        f8201d.unlock();
        throw th;
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    public static String c(URI r10) {
        if (a(r10) == true) goto L5;
        return null;
    L5:
        return b();
    }

    public static void d(SharedPreferences r10) {
        int r11 = r10.getInt("ttnet_response_verify_enabled", -1);
        String r12 = r10.getString("ttnet_response_verify", "");
        if (TextUtils.isEmpty(r12) == false) goto L11;
    L8:
        JSONArray r13 = null;
    L9:
        j(r11, r13);
        return;
    L11:
        r13 = new JSONArray(r12);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    public static C0104a e(JSONObject r10) {
        int r11 = r10.optInt("ttnet_response_verify_enabled", -1);
        JSONArray r12 = r10.optJSONArray("ttnet_response_verify");
        if (r12 == null) goto L5;
        String r13 = r12.toString();
    L6:
        j(r11, r12);
        C0104a r14 = new C0104a();
        r14.f8203a = r11;
        r14.f8204b = r13;
        return r14;
    L5:
        r13 = "";
        goto L6
    }

    public static void f(g6.b r10, g6.c r11, p6.b r12) {
        if (f8198a == true) goto L5;
        return;
    L5:
        if (r12 != null) goto L8;
        Logger.w("CDN_CACHE_VERIFY", "Req info is null");
        return;
    L8:
        g(r10, r11, r12);
    }

    public static void g(g6.b r10, g6.c r11, p6.b r12) {
        g6.a r13 = r10.t("X-TT-VERIFY-ID");
        String r14 = null;
        if (r13 == null) goto L5;
        String r15 = r13.b();
    L6:
        g6.a r16 = r11.c("X-TT-VERIFY-ID");
        if (r16 == null) goto L9;
        r14 = r16.b();
    L9:
        if (r15 != null) goto L11;
        return;
    L11:
        if (r14 != null) goto L14;
        r12.N = 1;
        Logger.w("CDN_CACHE_VERIFY", "Cdn cache verify accessible");
    L21:
        RequestTicketUtil.ICdnCacheVerifyCallback r17 = RequestTicketUtil.b();
        if (r17 == null) goto L25;
        r17.onCallback(r10.D(), r12);
    L25:
        if (r12.N == 3) goto L28;
        return;
    L28:
        throw new CdnCacheVerifyException("Fail to verify cdn cache");
    L14:
        if (r15.equals(r14) == false) goto L16;
        r12.N = 2;
        Logger.w("CDN_CACHE_VERIFY", "Cdn cache verify success");
        goto L21
    L16:
        r12.N = 3;
        Logger.w("CDN_CACHE_VERIFY", "Cdn cache verify fail");
        r11.a().in().close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
        Logger.w("CDN_CACHE_VERIFY", "Cdn cache verify stream close fail:" + th.toString());
        goto L21
    L5:
        r15 = null;
        goto L6
    }

    public static void h(String r10, List r11) {
        if (f8198a == true) goto L5;
        return;
    L5:
        i(r10, r11);
    }

    public static void i(String r10, List r11) {
        String r12 = c(g.b(r10));     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r12) == true) goto L11;
        r11.add(new g6.a("X-TT-VERIFY-ID", r12));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public static void j(int r10, JSONArray r11) {
        int r12 = 0;
        if (r10 <= 0) goto L16;
        ArrayList r13 = new ArrayList();
        if (r11 == null) goto L15;
        int r14 = r11.length();
    L7:
        if (r12 >= r14) goto L14;
        String r15 = r11.optString(r12);
        if (TextUtils.isEmpty(r15) == true) goto L13;
        b r16 = new b();
        if (r16.b(r15) == false) goto L13;
        r13.add(r16);
    L13:
        r12 = r12 + 1;
        goto L7
    L14:
        l(r13);
    L15:
        k(true);
        return;
    L16:
        k(false);
    }

    public static void k(boolean r10) {
        f8198a = r10;
    }

    public static void l(List r10) {
        f8202e.lock();     // Catch: Throwable -> L5
        f8199b = r10;     // Catch: Throwable -> L5
        f8202e.unlock();
        return;
    L5:
        th = move-exception;
        f8202e.unlock();
        throw th;
    }
}
