package com.baidu.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class c extends BroadcastReceiver {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f4650f = true;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f4651g = true;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4653b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4654c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4655d = true;

    /* renamed from: e, reason: collision with root package name */
    private String f4656e = "";

    /* renamed from: a, reason: collision with root package name */
    ExecutorService f4652a = Executors.newFixedThreadPool(1);

    public class a implements Callable<Object> {
        public a() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(2:35|3)|(2:37|4)|(2:27|9)|31|13|29|14|(2:33|19)|23|24|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        
            r4 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
        
            r0 = com.baidu.a.c.f4650f = false;
            r0 = r4;
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object call() throws java.net.SocketException {
            /*
                r5 = this;
                java.net.InetSocketAddress r5 = new java.net.InetSocketAddress
                java.lang.String r0 = "2001:4860:4860::8888"
                r1 = 443(0x1bb, float:6.21E-43)
                r5.<init>(r0, r1)
                java.net.InetSocketAddress r0 = new java.net.InetSocketAddress
                java.lang.String r1 = "180.76.76.76"
                r2 = 80
                r0.<init>(r1, r2)
                r1 = 0
                r2 = 1
                r3 = 0
                java.net.DatagramSocket r4 = new java.net.DatagramSocket     // Catch: java.net.SocketException -> L21
                r4.<init>()     // Catch: java.net.SocketException -> L21
                r4.connect(r0)     // Catch: java.net.SocketException -> L22
                com.baidu.a.c.c(r2)     // Catch: java.net.SocketException -> L22
                goto L25
            L21:
                r4 = r3
            L22:
                com.baidu.a.c.c(r1)
            L25:
                if (r4 == 0) goto L2f
                r4.close()     // Catch: java.lang.Exception -> L2b
                goto L2f
            L2b:
                r0 = move-exception
                r0.printStackTrace()
            L2f:
                java.net.DatagramSocket r0 = new java.net.DatagramSocket     // Catch: java.net.SocketException -> L3c
                r0.<init>()     // Catch: java.net.SocketException -> L3c
                r0.connect(r5)     // Catch: java.net.SocketException -> L3b
                com.baidu.a.c.d(r2)     // Catch: java.net.SocketException -> L3b
                goto L40
            L3b:
                r4 = r0
            L3c:
                com.baidu.a.c.d(r1)
                r0 = r4
            L40:
                if (r0 == 0) goto L4a
                r0.close()     // Catch: java.lang.Exception -> L46
                goto L4a
            L46:
                r5 = move-exception
                r5.printStackTrace()
            L4a:
                boolean r5 = com.baidu.a.c.d()
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                boolean r0 = com.baidu.a.c.e()
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                java.lang.Object[] r5 = new java.lang.Object[]{r5, r0}
                java.lang.String r0 = "isIPv4Reachable(%s), isIPv6Reachable(%s)"
                com.baidu.a.j.a(r0, r5)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.a.c.a.call():java.lang.Object");
        }
    }

    public static boolean c() {
        return f4650f;
    }

    public void a() {
        this.f4652a.submit(new a());
    }

    public void b(boolean z4) {
        this.f4655d = z4;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:12|(1:(6:23|42|24|(1:27)|37|38)(1:21))(1:16)|17|42|24|(1:27)|37|38) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        r4 = r0;
        r0 = r7;
        r7 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        a(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
    
        r6.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
    
        r0 = r7;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r6, android.content.Intent r7) {
        /*
            r5 = this;
            java.lang.String r7 = ""
            boolean r0 = r5.f4653b
            r1 = 1
            if (r0 != 0) goto La
            r5.f4653b = r1
            return
        La:
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r6.getSystemService(r0)     // Catch: java.lang.RuntimeException -> L18
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.RuntimeException -> L18
            if (r0 != 0) goto L1a
            r5.a(r6)     // Catch: java.lang.RuntimeException -> L18
            return
        L18:
            r0 = move-exception
            goto L61
        L1a:
            android.net.NetworkInfo r1 = r0.getNetworkInfo(r1)     // Catch: java.lang.RuntimeException -> L18
            r2 = 0
            android.net.NetworkInfo r0 = r0.getNetworkInfo(r2)     // Catch: java.lang.RuntimeException -> L18
            if (r1 == 0) goto L36
            android.net.NetworkInfo$State r2 = r1.getState()     // Catch: java.lang.RuntimeException -> L18
            android.net.NetworkInfo$State r3 = android.net.NetworkInfo.State.CONNECTED     // Catch: java.lang.RuntimeException -> L18
            if (r2 != r3) goto L36
            java.lang.String r0 = r1.getExtraInfo()     // Catch: java.lang.RuntimeException -> L18
        L31:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.RuntimeException -> L18
            goto L46
        L36:
            if (r0 == 0) goto L45
            android.net.NetworkInfo$State r1 = r0.getState()     // Catch: java.lang.RuntimeException -> L18
            android.net.NetworkInfo$State r2 = android.net.NetworkInfo.State.CONNECTED     // Catch: java.lang.RuntimeException -> L18
            if (r1 != r2) goto L45
            java.lang.String r0 = r0.getExtraInfo()     // Catch: java.lang.RuntimeException -> L18
            goto L31
        L45:
            r0 = r7
        L46:
            java.lang.String r1 = r5.f4656e     // Catch: java.lang.RuntimeException -> L5d
            boolean r1 = r1.equals(r0)     // Catch: java.lang.RuntimeException -> L5d
            if (r1 != 0) goto L6d
            if (r0 == r7) goto L6d
            java.lang.String r7 = "Current net type: %s."
            java.lang.Object[] r1 = new java.lang.Object[]{r0}     // Catch: java.lang.RuntimeException -> L5d
            com.baidu.a.j.a(r7, r1)     // Catch: java.lang.RuntimeException -> L5d
            r5.a(r6)     // Catch: java.lang.RuntimeException -> L5d
            goto L6d
        L5d:
            r7 = move-exception
            r4 = r0
            r0 = r7
            r7 = r4
        L61:
            r0.printStackTrace()
            r5.a(r6)     // Catch: java.lang.Exception -> L68
            goto L6c
        L68:
            r6 = move-exception
            r6.printStackTrace()
        L6c:
            r0 = r7
        L6d:
            r5.f4656e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.a.c.onReceive(android.content.Context, android.content.Intent):void");
    }

    private void a(Context context) {
        j.a("Network change, clearCache(%b) httpDnsPrefetch(%b)", Boolean.valueOf(this.f4654c), Boolean.valueOf(this.f4655d));
        g gVarA = g.a();
        gVarA.b();
        com.baidu.a.a aVarA = com.baidu.a.a.a(context);
        a();
        ArrayList<String> arrayListB = aVarA.a().b();
        if (this.f4654c) {
            aVarA.a().a();
            aVarA.b().a();
        }
        if (!this.f4655d || arrayListB == null || arrayListB.isEmpty()) {
            return;
        }
        gVarA.a(arrayListB, new i(context));
    }

    public static boolean b() {
        return f4651g;
    }

    public void a(boolean z4) {
        this.f4654c = z4;
    }
}
