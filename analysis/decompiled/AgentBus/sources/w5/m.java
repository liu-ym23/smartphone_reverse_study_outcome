package w5;

import android.util.Base64;
import fi.iki.elonen.NanoHTTPD;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f10735a = new m();

    /* JADX WARN: Removed duplicated region for block: B:29:0x0077 A[Catch: all -> 0x008a, TryCatch #3 {all -> 0x008a, blocks: (B:27:0x006d, B:29:0x0077, B:33:0x008d, B:35:0x0098, B:38:0x00a2, B:39:0x00a8), top: B:55:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d A[Catch: all -> 0x008a, TryCatch #3 {all -> 0x008a, blocks: (B:27:0x006d, B:29:0x0077, B:33:0x008d, B:35:0x0098, B:38:0x00a2, B:39:0x00a8), top: B:55:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(java.lang.String r18, java.lang.String r19, java.lang.String r20, i7.c r21) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.m.a(java.lang.String, java.lang.String, java.lang.String, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(v4.k r11, i7.c r12) {
        /*
            java.lang.String r0 = "积压 "
            boolean r1 = r12 instanceof w5.g
            if (r1 == 0) goto L15
            r1 = r12
            w5.g r1 = (w5.g) r1
            int r2 = r1.f10712h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f10712h = r2
            goto L1a
        L15:
            w5.g r1 = new w5.g
            r1.<init>(r12)
        L1a:
            java.lang.Object r12 = r1.f10711g
            h7.a r2 = h7.a.f4212f
            int r3 = r1.f10712h
            r4 = 1
            if (r3 == 0) goto L37
            if (r3 != r4) goto L2f
            long r1 = r1.f10710f
            w7.e0.N(r12)     // Catch: java.lang.Throwable -> L2b
            goto L55
        L2b:
            r0 = move-exception
            r11 = r0
            goto L9f
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L37:
            w7.e0.N(r12)
            long r5 = java.lang.System.currentTimeMillis()
            pa.e r12 = ia.n0.f4982a     // Catch: java.lang.Throwable -> L9c
            pa.d r12 = pa.d.f8556h     // Catch: java.lang.Throwable -> L9c
            v4.i r3 = new v4.i     // Catch: java.lang.Throwable -> L9c
            r7 = 0
            r8 = 4
            r3.<init>(r11, r7, r8)     // Catch: java.lang.Throwable -> L9c
            r1.f10710f = r5     // Catch: java.lang.Throwable -> L9c
            r1.f10712h = r4     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r12 = ia.d0.B(r12, r3, r1)     // Catch: java.lang.Throwable -> L9c
            if (r12 != r2) goto L54
            return r2
        L54:
            r1 = r5
        L55:
            java.lang.Number r12 = (java.lang.Number) r12     // Catch: java.lang.Throwable -> L2b
            int r11 = r12.intValue()     // Catch: java.lang.Throwable -> L2b
            if (r11 != 0) goto L61
            w5.b r12 = w5.b.PASS     // Catch: java.lang.Throwable -> L2b
        L5f:
            r6 = r12
            goto L64
        L61:
            w5.b r12 = w5.b.WARNING     // Catch: java.lang.Throwable -> L2b
            goto L5f
        L64:
            w5.a r3 = new w5.a     // Catch: java.lang.Throwable -> L2b
            java.lang.String r4 = "BUS_OFFLINE_QUEUE"
            java.lang.String r5 = "离线队列"
            if (r11 != 0) goto L70
            java.lang.String r12 = "empty"
        L6e:
            r7 = r12
            goto L82
        L70:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r12.<init>(r0)     // Catch: java.lang.Throwable -> L2b
            r12.append(r11)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r0 = " 条"
            r12.append(r0)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L2b
            goto L6e
        L82:
            java.lang.String r12 = "count"
            java.lang.Integer r0 = new java.lang.Integer     // Catch: java.lang.Throwable -> L2b
            r0.<init>(r11)     // Catch: java.lang.Throwable -> L2b
            c7.j r11 = new c7.j     // Catch: java.lang.Throwable -> L2b
            r11.<init>(r12, r0)     // Catch: java.lang.Throwable -> L2b
            java.util.Map r8 = d7.e0.T(r11)     // Catch: java.lang.Throwable -> L2b
            long r11 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2b
            long r9 = r11 - r1
            r3.<init>(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L2b
            return r3
        L9c:
            r0 = move-exception
            r11 = r0
            r1 = r5
        L9f:
            w5.a r3 = new w5.a
            w5.b r6 = w5.b.FAIL
            java.lang.Class r12 = r11.getClass()
            q7.x r0 = q7.w.f8821a
            w7.d r12 = r0.b(r12)
            java.lang.String r12 = r12.t()
            java.lang.String r11 = r11.getMessage()
            java.lang.String r0 = ": "
            java.lang.String r7 = a1.a.x(r12, r0, r11)
            long r11 = java.lang.System.currentTimeMillis()
            long r8 = r11 - r1
            r10 = 16
            java.lang.String r4 = "BUS_OFFLINE_QUEUE"
            java.lang.String r5 = "离线队列"
            r3.<init>(r4, r5, r6, r7, r8, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.m.b(v4.k, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(i7.c r14) {
        /*
            java.lang.String r0 = "SDK 就绪 ("
            boolean r1 = r14 instanceof w5.h
            if (r1 == 0) goto L15
            r1 = r14
            w5.h r1 = (w5.h) r1
            int r2 = r1.f10715h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f10715h = r2
            goto L1a
        L15:
            w5.h r1 = new w5.h
            r1.<init>(r14)
        L1a:
            java.lang.Object r14 = r1.f10714g
            h7.a r2 = h7.a.f4212f
            int r3 = r1.f10715h
            r4 = 1
            if (r3 == 0) goto L36
            if (r3 != r4) goto L2e
            long r1 = r1.f10713f
            w7.e0.N(r14)     // Catch: java.lang.Throwable -> L2b
            goto L4b
        L2b:
            r0 = move-exception
            r14 = r0
            goto L90
        L2e:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L36:
            w7.e0.N(r14)
            long r5 = java.lang.System.currentTimeMillis()
            x5.b r14 = x5.b.f11221a     // Catch: java.lang.Throwable -> L8d
            r1.f10713f = r5     // Catch: java.lang.Throwable -> L8d
            r1.f10715h = r4     // Catch: java.lang.Throwable -> L8d
            java.lang.Object r14 = x5.b.b(r1)     // Catch: java.lang.Throwable -> L8d
            if (r14 != r2) goto L4a
            return r2
        L4a:
            r1 = r5
        L4b:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch: java.lang.Throwable -> L2b
            boolean r3 = r14.booleanValue()     // Catch: java.lang.Throwable -> L2b
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2b
            long r12 = r4 - r1
            w5.a r6 = new w5.a     // Catch: java.lang.Throwable -> L2b
            java.lang.String r7 = "SECURE_DATA_SDK"
            java.lang.String r8 = "SecureData SDK"
            if (r3 == 0) goto L63
            w5.b r4 = w5.b.PASS     // Catch: java.lang.Throwable -> L2b
        L61:
            r9 = r4
            goto L66
        L63:
            w5.b r4 = w5.b.FAIL     // Catch: java.lang.Throwable -> L2b
            goto L61
        L66:
            if (r3 == 0) goto L7b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L2b
            r3.append(r12)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r0 = "ms)"
            r3.append(r0)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L2b
        L79:
            r10 = r0
            goto L7e
        L7b:
            java.lang.String r0 = "SDK 未就绪"
            goto L79
        L7e:
            java.lang.String r0 = "ready"
            c7.j r3 = new c7.j     // Catch: java.lang.Throwable -> L2b
            r3.<init>(r0, r14)     // Catch: java.lang.Throwable -> L2b
            java.util.Map r11 = d7.e0.T(r3)     // Catch: java.lang.Throwable -> L2b
            r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L2b
            return r6
        L8d:
            r0 = move-exception
            r14 = r0
            r1 = r5
        L90:
            w5.a r3 = new w5.a
            w5.b r6 = w5.b.FAIL
            java.lang.Class r0 = r14.getClass()
            q7.x r4 = q7.w.f8821a
            w7.d r0 = r4.b(r0)
            java.lang.String r0 = r0.t()
            java.lang.String r14 = r14.getMessage()
            java.lang.String r4 = ": "
            java.lang.String r7 = a1.a.x(r0, r4, r14)
            long r4 = java.lang.System.currentTimeMillis()
            long r8 = r4 - r1
            r10 = 16
            java.lang.String r4 = "SECURE_DATA_SDK"
            java.lang.String r5 = "SecureData SDK"
            r3.<init>(r4, r5, r6, r7, r8, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.m.c(i7.c):java.lang.Object");
    }

    public static final a d(String str, String str2, String str3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            Socket socket = new Socket();
            try {
                socket.connect(new InetSocketAddress(str3, 443), NanoHTTPD.SOCKET_READ_TIMEOUT);
                socket.close();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                return new a(str, str2, b.PASS, str3 + ":443 OK (" + jCurrentTimeMillis2 + "ms)", d7.e0.U(new c7.j("host", str3), new c7.j("port", 443), new c7.j("latency_ms", Long.valueOf(jCurrentTimeMillis2))), jCurrentTimeMillis2);
            } finally {
            }
        } catch (Throwable th) {
            return new a(str, str2, b.FAIL, m.x.l(str3, ":443 ", q7.w.f8821a.b(th.getClass()).t(), ": ", th.getMessage()), d7.e0.U(new c7.j("host", str3), new c7.j("port", 443), new c7.j("error", th.getMessage())), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005e A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:12:0x0027, B:23:0x0054, B:25:0x005e, B:27:0x006e), top: B:35:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e A[Catch: all -> 0x002b, TRY_LEAVE, TryCatch #1 {all -> 0x002b, blocks: (B:12:0x0027, B:23:0x0054, B:25:0x005e, B:27:0x006e), top: B:35:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(i7.c r13) {
        /*
            java.lang.String r0 = "OK ("
            boolean r1 = r13 instanceof w5.i
            if (r1 == 0) goto L15
            r1 = r13
            w5.i r1 = (w5.i) r1
            int r2 = r1.f10718h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f10718h = r2
            goto L1a
        L15:
            w5.i r1 = new w5.i
            r1.<init>(r13)
        L1a:
            java.lang.Object r13 = r1.f10717g
            h7.a r2 = h7.a.f4212f
            int r3 = r1.f10718h
            r4 = 1
            if (r3 == 0) goto L37
            if (r3 != r4) goto L2f
            long r1 = r1.f10716f
            w7.e0.N(r13)     // Catch: java.lang.Throwable -> L2b
            goto L54
        L2b:
            r0 = move-exception
            r13 = r0
            goto La9
        L2f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L37:
            w7.e0.N(r13)
            long r5 = java.lang.System.currentTimeMillis()
            b.j r13 = new b.j     // Catch: java.lang.Throwable -> La6
            r3 = 2
            r7 = 5
            r8 = 0
            r13.<init>(r3, r8, r7)     // Catch: java.lang.Throwable -> La6
            r1.f10716f = r5     // Catch: java.lang.Throwable -> La6
            r1.f10718h = r4     // Catch: java.lang.Throwable -> La6
            r3 = 8000(0x1f40, double:3.9525E-320)
            java.lang.Object r13 = ia.d0.D(r3, r13, r1)     // Catch: java.lang.Throwable -> La6
            if (r13 != r2) goto L53
            return r2
        L53:
            r1 = r5
        L54:
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Throwable -> L2b
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2b
            long r10 = r3 - r1
            if (r13 != 0) goto L6e
            w5.a r5 = new w5.a     // Catch: java.lang.Throwable -> L2b
            java.lang.String r6 = "TLS_HANDSHAKE"
            java.lang.String r7 = "TLS 握手"
            w5.b r8 = w5.b.TIMEOUT     // Catch: java.lang.Throwable -> L2b
            java.lang.String r9 = "超时 8000ms"
            r12 = 16
            r5.<init>(r6, r7, r8, r9, r10, r12)     // Catch: java.lang.Throwable -> L2b
            return r5
        L6e:
            w5.a r5 = new w5.a     // Catch: java.lang.Throwable -> L2b
            java.lang.String r6 = "TLS_HANDSHAKE"
            java.lang.String r7 = "TLS 握手"
            w5.b r8 = w5.b.PASS     // Catch: java.lang.Throwable -> L2b
            r3 = 16
            java.lang.String r3 = ga.k.L0(r3, r13)     // Catch: java.lang.Throwable -> L2b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L2b
            r4.append(r10)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r0 = "ms), fingerprint="
            r4.append(r0)     // Catch: java.lang.Throwable -> L2b
            r4.append(r3)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r0 = "..."
            r4.append(r0)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r9 = r4.toString()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r0 = "fingerprint"
            c7.j r3 = new c7.j     // Catch: java.lang.Throwable -> L2b
            r3.<init>(r0, r13)     // Catch: java.lang.Throwable -> L2b
            java.util.Map r13 = d7.e0.T(r3)     // Catch: java.lang.Throwable -> L2b
            r11 = r10
            r10 = r13
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L2b
            return r5
        La6:
            r0 = move-exception
            r13 = r0
            r1 = r5
        La9:
            w5.a r3 = new w5.a
            w5.b r6 = w5.b.FAIL
            java.lang.Class r0 = r13.getClass()
            q7.x r4 = q7.w.f8821a
            w7.d r0 = r4.b(r0)
            java.lang.String r0 = r0.t()
            java.lang.String r13 = r13.getMessage()
            java.lang.String r4 = ": "
            java.lang.String r7 = a1.a.x(r0, r4, r13)
            long r4 = java.lang.System.currentTimeMillis()
            long r8 = r4 - r1
            r10 = 16
            java.lang.String r4 = "TLS_HANDSHAKE"
            java.lang.String r5 = "TLS 握手"
            r3.<init>(r4, r5, r6, r7, r8, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.m.e(i7.c):java.lang.Object");
    }

    public static String f(n7.o oVar) {
        if (oVar instanceof o5.g) {
            return "OK";
        }
        if (oVar instanceof o5.i) {
            return a1.a.j("DOWN(", ((o5.i) oVar).f7763b, ")");
        }
        if (oVar instanceof o5.h) {
            return "DEGRADED(bff ws connected, awaiting auth)";
        }
        throw new a4.u();
    }

    public static String g(Long l6) {
        if (l6 == null || l6.longValue() <= 0) {
            return "?";
        }
        String str = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(l6.longValue()));
        q7.k.d(str, "format(...)");
        return str;
    }

    public static e h(List list) {
        boolean z4;
        String str;
        String str2;
        q7.k.e(list, "results");
        int iS = d7.e0.S(d7.t.A0(list, 10));
        if (iS < 16) {
            iS = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iS);
        for (Object obj : list) {
            linkedHashMap.put(((a) obj).f10660a, obj);
        }
        b bVarI = i(linkedHashMap, "BUS_SERVICE_STATE");
        b bVar = b.FAIL;
        if (bVarI == bVar) {
            return new e(c0.SERVICE_NOT_READY, 0.95f, "AgentBusContainer 未就绪", d7.s.u0("等待 Service 完成初始化", "尝试重启 AgentBus"));
        }
        if (i(linkedHashMap, "NET_CONNECTIVITY") == bVar) {
            return new e(c0.NO_NETWORK, 0.95f, "设备无网络连接", d7.s.u0("检查 WiFi/移动数据是否开启", "检查飞行模式", "重新连接网络"));
        }
        if (i(linkedHashMap, "NET_PROXY") == b.WARNING && (i(linkedHashMap, "TCP_CLOUD_PROD") == bVar || i(linkedHashMap, "TCP_CLOUD_NODE") == bVar)) {
            return new e(c0.VPN_INTERFERENCE, 0.75f, "VPN/代理可能阻断了云端连接", d7.s.u0("尝试关闭 VPN 后重试", "检查代理配置"));
        }
        if (i(linkedHashMap, "DNS_BASELINE") == bVar && i(linkedHashMap, "DNS_CLOUD_PROD") == bVar) {
            return new e(c0.DNS_FAILURE, 0.9f, "DNS 全局解析失败", d7.s.u0("DNS 服务器不可用，尝试切换 DNS", "检查路由器设置", "尝试切换到移动数据"));
        }
        b bVarI2 = i(linkedHashMap, "DNS_BASELINE");
        b bVar2 = b.PASS;
        if (bVarI2 == bVar2 && (i(linkedHashMap, "DNS_CLOUD_PROD") == bVar || i(linkedHashMap, "DNS_CLOUD_NODE") == bVar)) {
            return new e(c0.DNS_PARTIAL, 0.85f, "stepos.com 域名解析异常", d7.s.u0("可能被 DNS 污染", "尝试使用 114.114.114.114", "尝试切换网络"));
        }
        if (i(linkedHashMap, "TCP_BASELINE") == bVar2 && (i(linkedHashMap, "TCP_CLOUD_PROD") == bVar || i(linkedHashMap, "TCP_CLOUD_NODE") == bVar)) {
            return new e(c0.TCP_BLOCKED, 0.8f, "云端服务器 TCP 连接被阻断", d7.s.u0("检查防火墙/路由规则", "尝试切换网络", "检查是否有代理干扰"));
        }
        if (i(linkedHashMap, "TLS_HANDSHAKE") == bVar) {
            return new e(c0.TLS_CERT_ERROR, 0.85f, "TLS 证书验证失败", d7.s.u0("检查系统时间是否正确", "可能存在中间人攻击", "尝试切换网络"));
        }
        if (i(linkedHashMap, "SECURE_DATA_SDK") == bVar) {
            return new e(c0.SECURE_SDK_NOT_READY, 0.8f, "SecureData SDK 未就绪", d7.s.u0("等待 SDK 初始化完成", "检查网络后重试"));
        }
        String str3 = "";
        boolean z10 = false;
        if (i(linkedHashMap, "TOKEN_ACCOUNT") == bVar) {
            a aVar = (a) linkedHashMap.get("TOKEN_ACCOUNT");
            if (aVar == null || (str2 = aVar.f10663d) == null) {
                str2 = "";
            }
            if (ga.k.k0(str2, "未登录", false)) {
                return new e(c0.ACCOUNT_NOT_LOGGED_IN, 0.95f, "账户未登录", a.a.S("请先登录魅族账号"));
            }
        }
        if (i(linkedHashMap, "TOKEN_ACCOUNT") == bVar) {
            return new e(c0.ACCOUNT_TOKEN_EXPIRED, 0.85f, "账户 Token 获取失败", d7.s.u0("尝试重新登录魅族账号", "检查账号 SDK 状态"));
        }
        if (i(linkedHashMap, "TOKEN_DEVICE_IDENTITY") == bVar) {
            return new e(c0.DEVICE_IDENTITY_CORRUPT, 0.9f, "设备身份密钥损坏", d7.s.u0("清除 AgentBus 数据重新初始化", "设备密钥文件可能被损坏"));
        }
        if (i(linkedHashMap, "WS_LAST_FAILURE") == bVar) {
            a aVar2 = (a) linkedHashMap.get("WS_LAST_FAILURE");
            if (aVar2 != null && (str = aVar2.f10663d) != null) {
                str3 = str;
            }
            if (ga.k.k0(str3, "401", false) || ga.k.k0(str3, "403", false)) {
                return new e(c0.WS_SERVER_REJECT, 0.85f, a1.a.j("服务端拒绝连接 (", str3, ")"), d7.s.u0("Token 可能已失效", "尝试清除设备 Token 缓存", "重新登录账号"));
            }
        }
        if (i(linkedHashMap, "BUS_GATEWAY_STATE") == bVar || i(linkedHashMap, "WS_CONNECT_STATE") == bVar) {
            return new e(c0.GATEWAY_OFFLINE, 0.8f, "Gateway 会话离线", d7.s.u0("检查云端服务可用性", "查看最近失败原因", "尝试重启 AgentBus"));
        }
        if (i(linkedHashMap, "BUS_POOL_STATE") == bVar) {
            return new e(c0.POOL_EMPTY, 0.85f, "连接池无 Gateway 连接", d7.s.u0("检查 vendor 配置", "可能需要重启 Service"));
        }
        if (i(linkedHashMap, "PING_PONG") == bVar) {
            return new e(c0.PING_PONG_FAILURE, 0.75f, "WebSocket 心跳超时", d7.s.u0("连接可能处于半开状态", "网络质量差", "尝试重连"));
        }
        if (list.isEmpty()) {
            z4 = false;
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((a) it.next()).f10662c == b.FAIL) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
        }
        if (!list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (((a) it2.next()).f10662c == b.WARNING) {
                    z10 = true;
                    break;
                }
            }
        }
        return z4 ? new e(c0.UNKNOWN, 0.5f, "存在检测失败项，但无法确定根因", d7.s.u0("查看各检测项详情", "联系技术支持")) : z10 ? new e(c0.UNKNOWN, 0.3f, "连接基本正常，存在潜在风险", a.a.S("关注警告项")) : new e(c0.UNKNOWN, 0.0f, "所有检测项通过，连接正常", d7.z.f2978f);
    }

    public static final b i(LinkedHashMap linkedHashMap, String str) {
        a aVar = (a) linkedHashMap.get(str);
        if (aVar != null) {
            return aVar.f10662c;
        }
        return null;
    }

    public static String j(String str) {
        Object objN;
        if (str == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        if (str.length() == 0) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(str, 0);
        q7.k.d(bArrDecode, "decode(...)");
        String strOptString = new JSONObject(new String(bArrDecode, ga.a.f4005a)).optString("u");
        q7.k.b(strOptString);
        int length = strOptString.length();
        objN = strOptString;
        if (length <= 0) {
            objN = null;
        }
        return (String) (objN instanceof c7.l ? null : objN);
    }

    public static void l(List list, String str, String str2) {
        list.add(new a(str, str2, b.SKIPPED, "网络不可用", 0L, 48));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(1:(1:(1:(37:15|126|282|127|(1:132)(1:131)|133|(1:135)|138|(1:140)(1:142)|141|143|146|280|147|148|(4:150|151|279|152)(1:157)|158|(1:160)|161|162|(1:164)|165|(1:167)|168|(1:170)(5:172|(1:177)(1:176)|(1:183)(1:181)|182|184)|171|187|278|188|(1:190)(1:191)|192|(1:199)(1:196)|200|(1:202)(1:203)|(1:208)(1:207)|(1:210)(1:211)|(18:215|(1:222)(1:221)|(1:229)(1:228)|230|(1:243)(1:241)|242|246|276|247|(1:249)(1:250)|251|(1:258)(1:255)|259|(2:(1:265)(1:264)|(1:267)(3:268|272|288))|269|270|272|288)(9:214|246|276|247|(0)(0)|251|(6:253|258|259|(0)|269|270)(0)|272|288))(2:16|17))(6:18|19|120|(1:122)|(34:125|126|282|127|(7:132|133|(0)|138|(0)(0)|141|143)(0)|146|280|147|148|(0)(0)|158|(0)|161|162|(0)|165|(0)|168|(0)(0)|171|187|278|188|(0)(0)|192|(5:194|199|200|(0)(0)|(6:205|208|(0)(0)|(0)|215|(3:217|222|(4:224|229|230|(3:232|243|242)(2:243|242))(0))(0))(0))(0)|246|276|247|(0)(0)|251|(0)(0)|272|288)|124))(5:20|113|(1:116)|(5:119|19|120|(0)|(0))|124))(5:21|107|(1:110)|(3:113|(0)|(0))|124))(1:22))(4:23|(1:26)|(1:29)|124)|30|277|31|(1:33)(1:36)|(1:38)(3:40|(1:42)(1:43)|(1:45)(22:46|(1:48)(2:49|(1:51)(2:52|(1:54)(1:55)))|56|(1:(1:62)(1:63))(1:59)|60|64|65|(1:67)(1:68)|(1:70)|71|72|74|(1:80)(1:79)|81|(1:83)(1:85)|84|(1:87)(1:89)|88|90|(3:93|(3:96|(2:287|273)(5:284|100|(1:103)|(4:106|107|(0)|(0))|124)|94)|285)|274|275))|39|74|(1:76)|80|81|(0)(0)|84|(0)(0)|88|90|(0)|274|275|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01b5, code lost:
    
        r22 = new w5.a("NET_CONNECTIVITY", "网络连通性", w5.b.FAIL, a1.a.x(q7.w.f8821a.b(r0.getClass()).t(), ": ", r0.getMessage()), java.lang.System.currentTimeMillis() - r16, 16);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02ad A[PHI: r0 r1 r6 r9
      0x02ad: PHI (r0v45 java.util.List) = (r0v44 java.util.List), (r0v89 java.util.List) binds: [B:111:0x02aa, B:20:0x0068] A[DONT_GENERATE, DONT_INLINE]
      0x02ad: PHI (r1v18 v4.k) = (r1v17 v4.k), (r1v28 v4.k) binds: [B:111:0x02aa, B:20:0x0068] A[DONT_GENERATE, DONT_INLINE]
      0x02ad: PHI (r6v4 android.content.Context) = (r6v3 android.content.Context), (r6v20 android.content.Context) binds: [B:111:0x02aa, B:20:0x0068] A[DONT_GENERATE, DONT_INLINE]
      0x02ad: PHI (r9v3 w5.m) = (r9v2 w5.m), (r9v11 w5.m) binds: [B:111:0x02aa, B:20:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0351 A[Catch: all -> 0x036b, TryCatch #5 {all -> 0x036b, blocks: (B:127:0x0310, B:133:0x0331, B:135:0x0351, B:138:0x036d, B:140:0x037a, B:143:0x0381, B:142:0x037e), top: B:282:0x0310 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x037a A[Catch: all -> 0x036b, TryCatch #5 {all -> 0x036b, blocks: (B:127:0x0310, B:133:0x0331, B:135:0x0351, B:138:0x036d, B:140:0x037a, B:143:0x0381, B:142:0x037e), top: B:282:0x0310 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x037e A[Catch: all -> 0x036b, TryCatch #5 {all -> 0x036b, blocks: (B:127:0x0310, B:133:0x0331, B:135:0x0351, B:138:0x036d, B:140:0x037a, B:143:0x0381, B:142:0x037e), top: B:282:0x0310 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03da A[Catch: all -> 0x03fb, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x03fb, blocks: (B:147:0x03c5, B:150:0x03da), top: B:280:0x03c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0406 A[Catch: all -> 0x03f8, TryCatch #3 {all -> 0x03f8, blocks: (B:152:0x03e2, B:158:0x0402, B:160:0x0406, B:161:0x0421, B:164:0x0427, B:165:0x0442, B:167:0x0446, B:168:0x0461, B:170:0x0467, B:172:0x047f, B:174:0x0487, B:181:0x0498, B:184:0x04a0, B:183:0x049d), top: B:279:0x03e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0427 A[Catch: all -> 0x03f8, TRY_ENTER, TryCatch #3 {all -> 0x03f8, blocks: (B:152:0x03e2, B:158:0x0402, B:160:0x0406, B:161:0x0421, B:164:0x0427, B:165:0x0442, B:167:0x0446, B:168:0x0461, B:170:0x0467, B:172:0x047f, B:174:0x0487, B:181:0x0498, B:184:0x04a0, B:183:0x049d), top: B:279:0x03e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0446 A[Catch: all -> 0x03f8, TryCatch #3 {all -> 0x03f8, blocks: (B:152:0x03e2, B:158:0x0402, B:160:0x0406, B:161:0x0421, B:164:0x0427, B:165:0x0442, B:167:0x0446, B:168:0x0461, B:170:0x0467, B:172:0x047f, B:174:0x0487, B:181:0x0498, B:184:0x04a0, B:183:0x049d), top: B:279:0x03e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0467 A[Catch: all -> 0x03f8, TryCatch #3 {all -> 0x03f8, blocks: (B:152:0x03e2, B:158:0x0402, B:160:0x0406, B:161:0x0421, B:164:0x0427, B:165:0x0442, B:167:0x0446, B:168:0x0461, B:170:0x0467, B:172:0x047f, B:174:0x0487, B:181:0x0498, B:184:0x04a0, B:183:0x049d), top: B:279:0x03e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x047f A[Catch: all -> 0x03f8, TryCatch #3 {all -> 0x03f8, blocks: (B:152:0x03e2, B:158:0x0402, B:160:0x0406, B:161:0x0421, B:164:0x0427, B:165:0x0442, B:167:0x0446, B:168:0x0461, B:170:0x0467, B:172:0x047f, B:174:0x0487, B:181:0x0498, B:184:0x04a0, B:183:0x049d), top: B:279:0x03e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04f2 A[Catch: all -> 0x0508, TryCatch #2 {all -> 0x0508, blocks: (B:188:0x04ee, B:190:0x04f2, B:192:0x04f7, B:194:0x04fb, B:196:0x0501, B:200:0x050d, B:205:0x0516, B:207:0x051c, B:214:0x052e, B:215:0x0545, B:217:0x054d, B:219:0x0553, B:221:0x055b, B:224:0x0561, B:226:0x0567, B:228:0x056f, B:232:0x0577, B:241:0x058c, B:237:0x0583, B:243:0x05a3), top: B:278:0x04ee }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x04fb A[Catch: all -> 0x0508, TryCatch #2 {all -> 0x0508, blocks: (B:188:0x04ee, B:190:0x04f2, B:192:0x04f7, B:194:0x04fb, B:196:0x0501, B:200:0x050d, B:205:0x0516, B:207:0x051c, B:214:0x052e, B:215:0x0545, B:217:0x054d, B:219:0x0553, B:221:0x055b, B:224:0x0561, B:226:0x0567, B:228:0x056f, B:232:0x0577, B:241:0x058c, B:237:0x0583, B:243:0x05a3), top: B:278:0x04ee }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x05ee A[Catch: all -> 0x0605, TryCatch #0 {all -> 0x0605, blocks: (B:247:0x05ea, B:249:0x05ee, B:251:0x05f3, B:253:0x05f7, B:255:0x05fd, B:259:0x0609, B:262:0x060f, B:264:0x0615, B:268:0x0622, B:269:0x0638), top: B:276:0x05ea }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x05f7 A[Catch: all -> 0x0605, TryCatch #0 {all -> 0x0605, blocks: (B:247:0x05ea, B:249:0x05ee, B:251:0x05f3, B:253:0x05f7, B:255:0x05fd, B:259:0x0609, B:262:0x060f, B:264:0x0615, B:268:0x0622, B:269:0x0638), top: B:276:0x05ea }] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x060d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x024a  */
    /* JADX WARN: Type inference failed for: r0v47, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v87, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(android.content.Context r32, v4.k r33, i7.c r34) {
        /*
            Method dump skipped, instructions count: 1775
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.m.k(android.content.Context, v4.k, i7.c):java.lang.Object");
    }
}
