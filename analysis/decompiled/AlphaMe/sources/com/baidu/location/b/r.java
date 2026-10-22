package com.baidu.location.b;

import android.text.TextUtils;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.baidu.platform.comapi.UIMsg;
import com.stepos.alphame.utils.Consts;
import h3.C0611u;
import h3.InterfaceC0593b;
import h3.M;
import h3.Q;
import h3.S;
import h3.U;
import h3.V;
import h3.Z;
import h3.b0;
import h3.f0;
import h3.g0;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;

/* loaded from: classes.dex */
public class r {

    /* renamed from: c, reason: collision with root package name */
    private static final Lock f5447c = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    private S f5448a;

    /* renamed from: b, reason: collision with root package name */
    private String f5449b = null;

    public interface a {
        void a(int i4, String str);

        void a(int i4, String str, byte[] bArr);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final r f5453a = new r();
    }

    public r() {
        b();
    }

    public static r a() {
        return b.f5453a;
    }

    private synchronized void b() {
        try {
            if (this.f5448a == null) {
                Q q4 = new Q();
                try {
                    String str = com.baidu.location.e.h.aZ;
                    int i4 = com.baidu.location.e.h.ba;
                    if (!TextUtils.isEmpty(str) && i4 != -1) {
                        Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(str, i4));
                        if (!Intrinsics.areEqual(proxy, q4.f12767m)) {
                            q4.f12754D = null;
                        }
                        q4.f12767m = proxy;
                        final String str2 = com.baidu.location.e.h.bb;
                        final String str3 = com.baidu.location.e.h.bc;
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            InterfaceC0593b authenticator = new InterfaceC0593b() { // from class: com.baidu.location.b.r.1
                                @Override // h3.InterfaceC0593b
                                public V authenticate(g0 g0Var, b0 b0Var) {
                                    String username = str2;
                                    String password = str3;
                                    Intrinsics.checkNotNullParameter(username, "username");
                                    Intrinsics.checkNotNullParameter(password, "password");
                                    Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
                                    Intrinsics.checkNotNullExpressionValue(ISO_8859_1, "ISO_8859_1");
                                    String strG = com.stepos.statsrpk.c.g(username, password, ISO_8859_1);
                                    U uC = b0Var.f12864a.c();
                                    uC.c("Proxy-Authorization", strG);
                                    return uC.b();
                                }
                            };
                            Intrinsics.checkNotNullParameter(authenticator, "authenticator");
                            Intrinsics.checkNotNullParameter(authenticator, "<set-?>");
                            q4.f12761g = authenticator;
                        }
                    }
                    TimeUnit unit = TimeUnit.MILLISECONDS;
                    Intrinsics.checkNotNullParameter(unit, "unit");
                    q4.f12779y = Util.checkDuration("timeout", 12000L, unit);
                    Intrinsics.checkNotNullParameter(unit, "unit");
                    q4.f12780z = Util.checkDuration("timeout", 12000L, unit);
                    Intrinsics.checkNotNullParameter(unit, "unit");
                    q4.f12751A = Util.checkDuration("timeout", 12000L, unit);
                    q4.a(l.a().c());
                    this.f5448a = new S(q4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private U c() {
        U u4 = new U();
        u4.a("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        String str = com.baidu.location.e.h.aw;
        if (str != null) {
            u4.a("bd-loc-android", str);
        }
        return u4;
    }

    private Z a(Map<String, Object> map) {
        f5447c.lock();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(Consts.SPLITTER_EQUAL);
            sb.append(entry.getValue());
            sb.append("&");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Pattern pattern = M.f12732d;
        M mT = C0611u.t(FastJsonJsonView.DEFAULT_CONTENT_TYPE);
        String string = sb.toString();
        f5447c.unlock();
        return Z.create(mT, string);
    }

    public void a(String str) {
        this.f5449b = str;
    }

    public void a(Map<String, Object> map, String str, a aVar) {
        StringBuilder sb;
        try {
            Z body = a(map);
            U uC = c();
            String str2 = this.f5449b;
            if (str2 != null) {
                uC.a("alwd", str2);
            }
            uC.g(str);
            Intrinsics.checkNotNullParameter(body, "body");
            uC.d("POST", body);
            V request = uC.b();
            S s4 = this.f5448a;
            s4.getClass();
            Intrinsics.checkNotNullParameter(request, "request");
            b0 b0VarExecute = new RealCall(s4, request, false).execute();
            boolean zD = b0VarExecute.d();
            String str3 = b0VarExecute.f12866c;
            if (zD) {
                f0 f0Var = b0VarExecute.f12870g;
                if (f0Var != null) {
                    aVar.a(200, f0Var.string(), new byte[1]);
                    return;
                } else {
                    aVar.a(UIMsg.MsgDefine.RENDER_STATE_FIRST_TILE, str3);
                    return;
                }
            }
            aVar.a(b0VarExecute.f12867d, str3);
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            if (aVar != null) {
                sb = new StringBuilder("e=");
                sb.append(e.getMessage());
                aVar.a(-100, sb.toString());
            }
        } catch (Exception e5) {
            e = e5;
            if (aVar != null) {
                sb = new StringBuilder("e=");
                sb.append(e.getMessage());
                aVar.a(-100, sb.toString());
            }
        }
    }
}
