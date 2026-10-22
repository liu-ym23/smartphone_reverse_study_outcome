package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NetworkUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: compiled from: NetworkUtils.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7071a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f7072b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f7073c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f7074d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f7075e = null;
        public static final a f = null;
        private static final /* synthetic */ a[] h = null;
        final int g;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(h.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("NONE", 0, 0);
            f7071a = r0;
            a r1 = new a("MOBILE", 1, 1);
            f7072b = r1;
            a r3 = new a("MOBILE_2G", 2, 2);
            f7073c = r3;
            a r5 = new a("MOBILE_3G", 3, 3);
            f7074d = r5;
            a r7 = new a("WIFI", 4, 4);
            f7075e = r7;
            a r9 = new a("MOBILE_4G", 5, 5);
            f = r9;
            h = new a[]{r0, r1, r3, r5, r7, r9};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.g = r3;
        }
    }

    public static boolean a(Context r3) {
        NetworkInfo r4 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r4 == null) goto L12;
        if (r4.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static a b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        NetworkInfo r0 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")).getActiveNetworkInfo();     // Catch: Throwable -> L48
        if (r0 == null) goto L47;
        if (r0.isAvailable() == false) goto L47;
        int r1 = r0.getType();     // Catch: Throwable -> L48
        if (1 == r1) goto L11;
        if (r1 != 0) goto L45;
        TelephonyManager r5 = (TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        if (r5 != null) goto L18;
        return a.f7072b;
    L18:
        if (r5.getNetworkType() == 3) goto L43;
        if (r5.getNetworkType() == 5) goto L43;
        if (r5.getNetworkType() == 6) goto L43;
        if (r5.getNetworkType() == 8) goto L43;
        if (r5.getNetworkType() == 9) goto L43;
        if (r5.getNetworkType() == 10) goto L43;
        if (r5.getNetworkType() == 12) goto L43;
        if (r5.getNetworkType() == 14) goto L43;
        if (r5.getNetworkType() == 15) goto L43;
        if (r5.getNetworkType() != 13) goto L41;
        return a.f;
    L41:
        return a.f7072b;
    L43:
        return a.f7074d;
    L45:
        return a.f7072b;
    L11:
        return a.f7075e;
    L47:
        return a.f7071a;
    L49:
        return a.f7072b;
    }

    static int c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        boolean r0 = a(r3);
        a r4 = b(r3);
        if (r0 == true) goto L6;
        return 2;
    L6:
        if (a.f7075e != r4) goto L9;
        return 3;
    L9:
        if (a.f7071a == r4) goto L11;
        return 4;
    L11:
        return 1;
    }
}
