package w5;

import b0.f1;
import b0.t1;
import b0.z1;
import java.util.List;
import y.i0;
import y.k0;

/* loaded from: classes.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f10694a = u0.z.c(4294111991L);

    /* renamed from: b, reason: collision with root package name */
    public static final long f10695b = u0.z.c(4294967295L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f10696c = u0.z.c(4280032286L);

    /* renamed from: d, reason: collision with root package name */
    public static final long f10697d = u0.z.c(4285295728L);

    /* renamed from: e, reason: collision with root package name */
    public static final long f10698e = u0.z.c(4278221567L);

    /* renamed from: f, reason: collision with root package name */
    public static final long f10699f = u0.z.c(4294916912L);

    /* renamed from: g, reason: collision with root package name */
    public static final List f10700g = d7.s.u0(new f0(c0.SERVICE_NOT_READY, "AgentBus Service 进程未完成初始化，Container 不可用", "联系 AgentBus 业务处理"), new f0(c0.GATEWAY_OFFLINE, "Gateway 会话离线。Cloud Gateway 离线通常是云端服务异常；Edge Gateway 离线可能是本地配置或连接问题", "Cloud 离线 → 联系云 Claw 业务；Edge 离线 → 联系 AgentBus 业务"), new f0(c0.POOL_EMPTY, "连接池中无可用 Gateway 连接，可能 vendor 配置异常或 Service 需要重启", "联系 AgentBus 业务处理"), new f0(c0.NO_NETWORK, "设备无网络连接，WiFi 和移动数据均不可用", "检查 WiFi/移动数据是否开启；检查飞行模式；重新连接网络"), new f0(c0.DNS_FAILURE, "DNS 服务器不可达，所有域名（包括基准域名）解析失败", "切换 DNS（如 114.114.114.114）；检查路由器设置；尝试切换到移动数据"), new f0(c0.DNS_PARTIAL, "stepos.com 域名解析异常但基准域名正常，可能被 DNS 污染或运营商劫持", "使用 114.114.114.114 或 8.8.8.8；切换网络环境"), new f0(c0.TCP_BLOCKED, "DNS 解析正常但 TCP 连接被阻断，可能防火墙或路由规则拦截了目标端口", "检查防火墙/路由规则；切换网络；关闭代理"), new f0(c0.TLS_CERT_ERROR, "TLS 证书验证失败，可能系统时间错误或网络中存在中间人代理", "检查系统时间是否正确；切换网络环境"), new f0(c0.SECURE_SDK_NOT_READY, "SecureData SDK 未完成初始化，无法进行安全通信签名", "联系 AgentBus 业务处理"), new f0(c0.ACCOUNT_TOKEN_EXPIRED, "账户 Token 获取失败，账号 SDK 返回异常或 Token 已过期", "联系 AgentBus 业务处理"), new f0(c0.ACCOUNT_NOT_LOGGED_IN, "设备未登录魅族账号，无法获取身份凭证用于云端认证", "前往系统设置 → 账号 → 登录魅族账号"), new f0(c0.DEVICE_TOKEN_EXPIRED, "设备 Token 缓存过期或无效，需要重新走认证流程获取新 Token", "联系 AgentBus 业务处理"), new f0(c0.DEVICE_IDENTITY_CORRUPT, "设备身份密钥文件损坏或不可读，无法进行签名认证", "联系 AgentBus 业务处理"), new f0(c0.WS_SERVER_REJECT, "服务端返回 401/403 拒绝 WebSocket 连接，Token 无效或设备未授权", "联系云 Claw 业务处理"), new f0(c0.WS_TIMEOUT, "WebSocket 连接超时，服务端未在规定时间内响应", "联系云 Claw 业务处理"), new f0(c0.PING_PONG_FAILURE, "WebSocket 心跳超时，发送 Ping 后未收到 Pong 响应，连接处于半开状态", "联系云 Claw 业务处理"), new f0(c0.KEEPALIVE_DEAD, "保活机制失效，连接长时间无活动后被系统或网络中间设备断开", "联系 AgentBus 业务处理"), new f0(c0.VPN_INTERFERENCE, "检测到 VPN/代理且云端连接失败，代理可能阻断了到服务器的流量", "关闭 VPN 后重试；检查代理白名单配置"), new f0(c0.UNKNOWN, "存在检测失败项但无法自动判定具体根因，需人工排查", "查看各检测项详情；联系 AgentBus 业务处理"));

    public static final void a(c0 c0Var, b0.p pVar, int i2) {
        b0.p pVar2;
        pVar.T(1789324454);
        if ((((pVar.f(c0Var) ? 4 : 2) | i2) & 3) == 2 && pVar.z()) {
            pVar.O();
            pVar2 = pVar;
        } else {
            pVar.S(-1487710721);
            Object objJ = pVar.J();
            if (objJ == b0.k.f1229a) {
                objJ = b0.b.n(Boolean.FALSE);
                pVar.b0(objJ);
            }
            pVar.q(false);
            pVar2 = pVar;
            i0.a(null, t.e.a(12), f10695b, j0.i.d(-1852694613, new d0(0, (f1) objJ, c0Var), pVar), pVar2, 12583296, 121);
        }
        z1 z1VarS = pVar2.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new b0.r(i2, 12, c0Var);
        }
    }

    public static final void b(e eVar, f0 f0Var, b0.p pVar, int i2) {
        b0.p pVar2;
        pVar.T(1693509217);
        if ((((pVar.h(eVar) ? 4 : 2) | i2 | (pVar.f(f0Var) ? 32 : 16)) & 19) == 18 && pVar.z()) {
            pVar.O();
            pVar2 = pVar;
        } else {
            pVar2 = pVar;
            i0.a(null, t.e.a(12), f10695b, j0.i.d(108072934, new d0(1, f0Var, eVar), pVar), pVar2, 12583296, 121);
        }
        z1 z1VarS = pVar2.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new b0.y(i2, 5, eVar, f0Var);
        }
    }

    public static final void c(e eVar, p7.a aVar, b0.p pVar, int i2) {
        b0.p pVar2;
        q7.k.e(aVar, "onBack");
        pVar.T(728191278);
        if ((((pVar.h(eVar) ? 4 : 2) | i2) & 19) == 18 && pVar.z()) {
            pVar.O();
            pVar2 = pVar;
        } else {
            pVar.S(1702264722);
            Object objJ = pVar.J();
            if (objJ == b0.k.f1229a) {
                objJ = new p(aVar, 1);
                pVar.b0(objJ);
            }
            pVar.q(false);
            a.a.a(false, (p7.a) objJ, pVar, 0);
            pVar2 = pVar;
            i0.a(androidx.compose.foundation.layout.a.f745b, null, f10694a, j0.i.d(-1483044727, new d0(2, aVar, eVar), pVar), pVar2, 12583302, 122);
        }
        z1 z1VarS = pVar2.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new b0.y(i2, 4, eVar, aVar);
        }
    }

    public static final void d(f0 f0Var, boolean z4, b0.p pVar, int i2) {
        f0 f0Var2;
        b0.p pVar2 = pVar;
        pVar2.T(-294187667);
        if (((i2 | (pVar2.f(f0Var) ? 4 : 2) | (pVar2.g(z4) ? 32 : 16)) & 19) == 18 && pVar2.z()) {
            pVar2.O();
            f0Var2 = f0Var;
        } else {
            long j2 = z4 ? f10699f : f10696c;
            r.r rVarA = r.p.a(r.i.f8867b, n0.b.f6784r, pVar2, 0);
            int iHashCode = Long.hashCode(pVar2.Q);
            t1 t1VarL = pVar2.l();
            n0.j jVar = n0.j.f6796a;
            n0.m mVarV = a.a.V(pVar2, jVar);
            i1.h.f4488c.getClass();
            i1.y yVar = i1.g.f4474b;
            pVar2.U();
            if (pVar2.P) {
                pVar2.k(yVar);
            } else {
                pVar2.e0();
            }
            b0.b.q(pVar2, rVarA, i1.g.f4477e);
            b0.b.q(pVar2, t1VarL, i1.g.f4476d);
            i1.f fVar = i1.g.f4478f;
            if (pVar2.P || !q7.k.a(pVar2.J(), Integer.valueOf(iHashCode))) {
                a1.a.r(iHashCode, pVar2, iHashCode, fVar);
            }
            b0.b.q(pVar2, mVarV, i1.g.f4475c);
            k0.a(f0Var.f10707a.getLabel(), null, j2, s7.a.z(13), v1.k.f10360j, null, 0L, 0L, 0, false, 0, 0, null, pVar, 199680, 0, 131026);
            n7.m.b(pVar, androidx.compose.foundation.layout.a.b(jVar, 2));
            f0Var2 = f0Var;
            k0.a(f0Var2.f10708b, null, f10697d, s7.a.z(11), null, null, 0L, 0L, 0, false, 0, 0, null, pVar, 3456, 0, 131058);
            n7.m.b(pVar, androidx.compose.foundation.layout.a.b(jVar, 4));
            k0.a("→ ".concat(f0Var2.f10709c), null, f10698e, s7.a.z(11), null, null, 0L, 0L, 0, false, 0, 0, null, pVar, 3456, 0, 131058);
            pVar2 = pVar;
            pVar2.q(true);
        }
        z1 z1VarS = pVar2.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new d.b(f0Var2, z4, i2);
        }
    }
}
