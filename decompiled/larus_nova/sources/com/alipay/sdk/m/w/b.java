package com.alipay.sdk.m.w;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes28.dex */
public class b {

    public static class a implements com.alipay.sdk.m.w.a.InterfaceC0495a<Object, Boolean> {
        public a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0495a
        public Boolean a(Object r100) {
            if ((r100 instanceof String) == true) goto L7;
            if (r100 == null) goto L7;
            boolean r101 = false;
        L9:
            return Boolean.valueOf(r101);
        L7:
            r101 = true;
            goto L9
        }

        @Override // com.alipay.sdk.m.w.a.InterfaceC0495a
        public /* bridge */ /* synthetic */ Boolean a(Object r100) {
            return a(r100);
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.w.b$b, reason: collision with other inner class name */
    public static class CallableC0496b implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25891a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public String call2() {
            return com.alipay.sdk.m.b.c.a(this.f25891a);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ String call() throws Exception {
            return call2();
        }

        public CallableC0496b(Context r100) {
            this.f25891a = r100;
        }
    }

    public static class c implements com.alipay.sdk.m.w.a.InterfaceC0495a<Object, Boolean> {
        public c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0495a
        public Boolean a(Object r100) {
            if ((r100 instanceof NetworkInfo) == true) goto L7;
            if (r100 == null) goto L7;
            boolean r101 = false;
        L9:
            return Boolean.valueOf(r101);
        L7:
            r101 = true;
            goto L9
        }

        @Override // com.alipay.sdk.m.w.a.InterfaceC0495a
        public /* bridge */ /* synthetic */ Boolean a(Object r100) {
            return a(r100);
        }
    }

    public static class d implements Callable<NetworkInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25892a;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public NetworkInfo call() {
            return ((ConnectivityManager) this.f25892a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ NetworkInfo call() throws Exception {
            return call();
        }

        public d(Context r100) {
            this.f25892a = r100;
        }
    }

    public static class e implements com.alipay.sdk.m.w.a.InterfaceC0495a<Object, Boolean> {
        public e() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0495a
        public Boolean a(Object r100) {
            if ((r100 instanceof String) == true) goto L7;
            if (r100 == null) goto L7;
            boolean r101 = false;
        L9:
            return Boolean.valueOf(r101);
        L7:
            r101 = true;
            goto L9
        }

        @Override // com.alipay.sdk.m.w.a.InterfaceC0495a
        public /* bridge */ /* synthetic */ Boolean a(Object r100) {
            return a(r100);
        }
    }

    public static class f implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.s.a f25894b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public String call2() {
            return com.alipay.sdk.m.n0.a.c(this.f25893a);
        L4:
            th = move-exception;
            com.alipay.sdk.m.k.a.b(this.f25894b, com.alipay.sdk.m.k.b.f25414o, com.alipay.sdk.m.k.b.f25426u, th.getClass().getName());
            return "";
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ String call() throws Exception {
            return call2();
        }

        public f(Context r100, com.alipay.sdk.m.s.a r101) {
            this.f25893a = r100;
            this.f25894b = r101;
        }
    }

    public static class g implements com.alipay.sdk.m.w.a.InterfaceC0495a<Object, Boolean> {
        public g() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0495a
        public Boolean a(Object r100) {
            if ((r100 instanceof String) == true) goto L7;
            if (r100 == null) goto L7;
            boolean r101 = false;
        L9:
            return Boolean.valueOf(r101);
        L7:
            r101 = true;
            goto L9
        }

        @Override // com.alipay.sdk.m.w.a.InterfaceC0495a
        public /* bridge */ /* synthetic */ Boolean a(Object r100) {
            return a(r100);
        }
    }

    public static class h implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f25895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f25896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f25897c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.s.a f25898d;

        public class a implements APSecuritySdk.InitResultListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String[] f25899a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ConditionVariable f25900b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ h f25901c;

            @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
            public void onResult(APSecuritySdk.TokenResult r100) {
                if (r100 == null) goto L4;
                this.f25899a[0] = r100.apdidToken;
            L4:
                this.f25900b.open();
            }

            public a(h r100, String[] r101, ConditionVariable r102) {
                this.f25901c = r100;
                this.f25899a = r101;
                this.f25900b = r102;
            }
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public String call2() {
            HashMap r100 = new HashMap();
            r100.put("tid", this.f25895a);
            r100.put(com.alipay.sdk.m.l.b.f25485g, this.f25896b);
            String[] r101 = {""};
            APSecuritySdk r102 = APSecuritySdk.getInstance(this.f25897c);     // Catch: Throwable -> L5
            ConditionVariable r103 = new ConditionVariable();     // Catch: Throwable -> L5
            r102.initToken(0, r100, new a(this, r101, r103));     // Catch: Throwable -> L5
            r103.block(3000);     // Catch: Throwable -> L5
        L8:
            if (TextUtils.isEmpty(r101[0]) == false) goto L11;
            com.alipay.sdk.m.k.a.b(this.f25898d, com.alipay.sdk.m.k.b.f25414o, com.alipay.sdk.m.k.b.f25422s, "missing token");
        L11:
            return r101[0];
        L5:
            th = move-exception;
            com.alipay.sdk.m.u.e.a(th);
            com.alipay.sdk.m.k.a.b(this.f25898d, com.alipay.sdk.m.k.b.f25414o, com.alipay.sdk.m.k.b.f25420r, th.getClass().getName());
            goto L8
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ String call() throws Exception {
            return call2();
        }

        public h(String r100, String r101, Context r102, com.alipay.sdk.m.s.a r103) {
            this.f25895a = r100;
            this.f25896b = r101;
            this.f25897c = r102;
            this.f25898d = r103;
        }
    }

    public b() {
    }

    public static NetworkInfo a(com.alipay.sdk.m.s.a r110, Context r111) {
        Context r112 = com.alipay.sdk.m.w.a.a(r111);
        TimeUnit r100 = TimeUnit.SECONDS;
        return (NetworkInfo) com.alipay.sdk.m.w.a.a(2, 10, r100, new c(), new d(r112), false, 10, r100, r110, false);
    }

    public static String b(com.alipay.sdk.m.s.a r110, Context r111) {
        if (com.alipay.sdk.m.m.a.D().x() == true) goto L6;
        return "";
    L6:
        Context r112 = com.alipay.sdk.m.w.a.a(r111);
        return (String) com.alipay.sdk.m.w.a.a(1, 1, TimeUnit.DAYS, new a(), new CallableC0496b(r112), true, 200, TimeUnit.MILLISECONDS, r110, true);
    }

    public static String c(com.alipay.sdk.m.s.a r110, Context r111) {
        Context r112 = com.alipay.sdk.m.w.a.a(r111);
        return (String) com.alipay.sdk.m.w.a.a(3, 1, TimeUnit.DAYS, new e(), new f(r112, r110), true, 3, TimeUnit.SECONDS, r110, false);
    }

    public static String a(com.alipay.sdk.m.s.a r110, Context r111, String r112, String r113) {
        Context r114 = com.alipay.sdk.m.w.a.a(r111);
        TimeUnit r100 = TimeUnit.SECONDS;
        return (String) com.alipay.sdk.m.w.a.a(4, 10, r100, new g(), new h(r112, r113, r114, r110), true, 3, r100, r110, true);
    }
}
