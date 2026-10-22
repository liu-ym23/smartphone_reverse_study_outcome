package com.bytedance.ttnet.utils;

import com.bytedance.frameworks.baselib.network.http.util.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class RequestTicketUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IRequestTicketProcessor f8190a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ICdnCacheVerifyCallback f8191b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f8192c = true;

    public interface ICdnCacheVerifyCallback {
        void onCallback(String r10, p6.b r11);
    }

    public interface IRequestTicketProcessor {
        void checkReqTicket(String r10, String r11, String r12, p6.b r13);

        void sendSetCookieEvent(String r10, String r11, int r12, boolean r13, JSONObject r14);
    }

    static {
    }

    public static void a(String r10, String r11, String r12, p6.b r13) {
        IRequestTicketProcessor r14 = f8190a;
        if (r14 == null) goto L6;
        r14.checkReqTicket(r10, r11, r12, r13);
        return;
    }

    public static ICdnCacheVerifyCallback b() {
        return f8191b;
    }

    public static IRequestTicketProcessor c() {
        return f8190a;
    }

    public static void d(String r10, String r11, int r12, boolean r13, JSONObject r14) {
        IRequestTicketProcessor r15 = f8190a;
        if (r15 == null) goto L6;
        r15.sendSetCookieEvent(r10, r11, r12, r13, r14);
        return;
    }

    public static void e(boolean r10) {
        f8192c = r10;
    }

    public static void f(IRequestTicketProcessor r10) {
        f8190a = r10;
    }

    public static String g(String r10) {
        if (f8192c == true) goto L11;
        return null;
    L11:
        if (g.b(r10).getHost().endsWith(k6.a.b()) == false) goto L9;
        return String.valueOf(System.currentTimeMillis());
    L9:
        return null;
    }
}
