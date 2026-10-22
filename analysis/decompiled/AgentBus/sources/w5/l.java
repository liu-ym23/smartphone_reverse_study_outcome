package w5;

import android.content.Context;
import com.stepos.agentbus.config.CloudBridgeConfig;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10732f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Context f10733g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ v4.k f10734h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(Context context, v4.k kVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f10732f = i2;
        this.f10733g = context;
        this.f10734h = kVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f10732f) {
            case 0:
                return new l(this.f10733g, this.f10734h, dVar, 0);
            case 1:
                return new l(this.f10733g, this.f10734h, dVar, 1);
            default:
                return new l(this.f10733g, this.f10734h, dVar, 2);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f10732f) {
        }
        return ((l) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        a aVar;
        switch (this.f10732f) {
            case 0:
                h7.a aVar2 = h7.a.f4212f;
                w7.e0.N(obj);
                Context context = this.f10733g;
                v4.k kVar = this.f10734h;
                long jCurrentTimeMillis = System.currentTimeMillis();
                CloudBridgeConfig cloudBridgeConfig = kVar.f10442k0;
                if (!(cloudBridgeConfig != null ? cloudBridgeConfig.getEnabled() : false)) {
                    return new a("TOKEN_ACCOUNT", "账户 Token", b.SKIPPED, "云桥未启用", System.currentTimeMillis() - jCurrentTimeMillis, 16);
                }
                try {
                    Context applicationContext = context.getApplicationContext();
                    q7.k.d(applicationContext, "getApplicationContext(...)");
                    v5.a aVar3 = new v5.a(applicationContext);
                    String strB = aVar3.b();
                    if (strB.length() == 0) {
                        return new a("TOKEN_ACCOUNT", "账户 Token", b.FAIL, "未登录", d7.e0.T(new c7.j("logged_in", Boolean.FALSE)), System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                    String strA = aVar3.a();
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (strA.length() == 0) {
                        aVar = new a("TOKEN_ACCOUNT", "账户 Token", b.FAIL, "已登录(uid_len=" + strB.length() + ") 但 Token 获取失败", d7.e0.U(new c7.j("logged_in", Boolean.TRUE), new c7.j("user_id_len", Integer.valueOf(strB.length())), new c7.j("token_ok", Boolean.FALSE)), jCurrentTimeMillis2);
                    } else {
                        b bVar = b.PASS;
                        String str = "uid_len=" + strB.length() + ", token_ok=true, token_len=" + strA.length();
                        Boolean bool = Boolean.TRUE;
                        aVar = new a("TOKEN_ACCOUNT", "账户 Token", bVar, str, d7.e0.U(new c7.j("logged_in", bool), new c7.j("user_id_len", Integer.valueOf(strB.length())), new c7.j("token_ok", bool)), jCurrentTimeMillis2);
                    }
                    return aVar;
                } catch (Throwable th) {
                    return new a("TOKEN_ACCOUNT", "账户 Token", b.FAIL, a1.a.x(q7.w.f8821a.b(th.getClass()).t(), ": ", th.getMessage()), System.currentTimeMillis() - jCurrentTimeMillis, 16);
                }
            case 1:
                h7.a aVar4 = h7.a.f4212f;
                w7.e0.N(obj);
                Context context2 = this.f10733g;
                v4.k kVar2 = this.f10734h;
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                try {
                    File filesDir = context2.getFilesDir();
                    q7.k.d(filesDir, "getFilesDir(...)");
                    String str2 = new o4.c0(context2, n7.l.O(filesDir, kVar2.f10423b.getGateway().getOpenclaw().getDeviceKeyFile())).c().f7301a;
                    o4.d0 d0Var = new o4.d0(context2, 0);
                    String strO = d0Var.O(str2, "operator");
                    String strO2 = d0Var.O(str2, "node");
                    long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis3;
                    String strJ = m.j(strO);
                    String strJ2 = m.j(strO2);
                    boolean z4 = (strO == null && strO2 == null) ? false : true;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("operator=".concat(strO != null ? "有" : "无"));
                    arrayList.add("node=".concat(strO2 != null ? "有" : "无"));
                    if (strJ != null) {
                        arrayList.add("op.uid=".concat(strJ));
                    }
                    if (strJ2 != null && !strJ2.equals(strJ)) {
                        arrayList.add("nd.uid=".concat(strJ2));
                    }
                    return new a("TOKEN_DEVICE", "设备 Token", z4 ? b.PASS : b.WARNING, d7.r.U0(arrayList, ", ", null, null, null, 62), d7.e0.U(new c7.j("has_operator", Boolean.valueOf(strO != null)), new c7.j("has_node", Boolean.valueOf(strO2 != null)), new c7.j("op_uid", strJ), new c7.j("nd_uid", strJ2)), jCurrentTimeMillis4);
                } catch (Throwable th2) {
                    return new a("TOKEN_DEVICE", "设备 Token", b.FAIL, a1.a.x(q7.w.f8821a.b(th2.getClass()).t(), ": ", th2.getMessage()), System.currentTimeMillis() - jCurrentTimeMillis3, 16);
                }
            default:
                h7.a aVar5 = h7.a.f4212f;
                w7.e0.N(obj);
                Context context3 = this.f10733g;
                v4.k kVar3 = this.f10734h;
                long jCurrentTimeMillis5 = System.currentTimeMillis();
                try {
                    File filesDir2 = context3.getFilesDir();
                    q7.k.d(filesDir2, "getFilesDir(...)");
                    String str3 = new o4.c0(context3, n7.l.O(filesDir2, kVar3.f10423b.getGateway().getOpenclaw().getDeviceKeyFile())).c().f7301a;
                    long jCurrentTimeMillis6 = System.currentTimeMillis() - jCurrentTimeMillis5;
                    return new a("TOKEN_DEVICE_IDENTITY", "设备身份密钥", b.PASS, "deviceId=" + ga.k.L0(16, str3) + "...", d7.e0.T(new c7.j("device_id", str3)), jCurrentTimeMillis6);
                } catch (Throwable th3) {
                    return new a("TOKEN_DEVICE_IDENTITY", "设备身份密钥", b.FAIL, a1.a.k("密钥加载失败: ", q7.w.f8821a.b(th3.getClass()).t(), ": ", th3.getMessage()), System.currentTimeMillis() - jCurrentTimeMillis5, 16);
                }
        }
    }
}
