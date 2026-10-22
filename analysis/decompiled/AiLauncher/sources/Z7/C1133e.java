package Z7;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.bq;
import com.tencent.bugly.proguard.br;
import com.tencent.bugly.proguard.bu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: Z7.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1133e {
    public static bq a(Context context, int i10, byte[] bArr) {
        String str;
        C1130b c1130bL = C1130b.l();
        StrategyBean strategyBeanI = C1131c.a().i();
        if (c1130bL == null || strategyBeanI == null) {
            C1139k.j("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            bq bqVar = new bq();
            synchronized (c1130bL) {
                try {
                    bqVar.f31617a = c1130bL.f7451d;
                    bqVar.f31618b = c1130bL.r();
                    bqVar.f31619c = c1130bL.f7453e;
                    bqVar.f31620d = c1130bL.f7422D;
                    bqVar.f31621e = c1130bL.f7426H;
                    bqVar.f31622f = c1130bL.f7463j;
                    bqVar.f31623g = i10;
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    bqVar.f31624h = bArr;
                    bqVar.f31625i = c1130bL.v();
                    bqVar.f31626j = c1130bL.f7471n;
                    bqVar.f31627k = new HashMap();
                    bqVar.f31628l = c1130bL.p();
                    bqVar.f31629m = strategyBeanI.f31461o;
                    bqVar.f31631o = c1130bL.u();
                    bqVar.f31632p = ab.f(context);
                    bqVar.f31633q = System.currentTimeMillis();
                    bqVar.f31635s = c1130bL.w();
                    bqVar.f31638v = c1130bL.u();
                    bqVar.f31639w = bqVar.f31632p;
                    bqVar.f31630n = "com.tencent.bugly";
                    bqVar.f31627k.put("A26", c1130bL.G());
                    Map<String, String> map = bqVar.f31627k;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(C1130b.c());
                    map.put("A62", sb2.toString());
                    Map<String, String> map2 = bqVar.f31627k;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(C1130b.d());
                    map2.put("A63", sb3.toString());
                    Map<String, String> map3 = bqVar.f31627k;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(c1130bL.f7456f0);
                    map3.put("F11", sb4.toString());
                    Map<String, String> map4 = bqVar.f31627k;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(c1130bL.f7454e0);
                    map4.put("F12", sb5.toString());
                    bqVar.f31627k.put("D3", c1130bL.f7424F);
                    List<N> list = O.f7340b;
                    if (list != null) {
                        for (N n10 : list) {
                            String str2 = n10.f7337b;
                            if (str2 != null && (str = n10.f7338c) != null) {
                                bqVar.f31627k.put(str2, str);
                            }
                        }
                    }
                    bqVar.f31627k.put("G15", C1143o.M("G15", ""));
                    bqVar.f31627k.put("G10", C1143o.M("G10", ""));
                    bqVar.f31627k.put("D4", C1143o.M("D4", "0"));
                } catch (Throwable th) {
                    throw th;
                }
            }
            Map<String, String> mapI = c1130bL.I();
            if (mapI != null) {
                for (Map.Entry<String, String> entry : mapI.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getValue())) {
                        bqVar.f31627k.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            return bqVar;
        } catch (Throwable th2) {
            if (!C1139k.g(th2)) {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public static br b(byte[] bArr) {
        if (bArr != null) {
            try {
                H h10 = new H();
                h10.e();
                h10.a("utf-8");
                h10.g(bArr);
                Object objD = h10.d("detail", new br());
                if (br.class.isInstance(objD)) {
                    return (br) br.class.cast(objD);
                }
                return null;
            } catch (Throwable th) {
                if (!C1139k.g(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static bu c(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        bu buVar = new bu();
        buVar.f31669a = userInfoBean.f31429e;
        buVar.f31673e = userInfoBean.f31434j;
        buVar.f31672d = userInfoBean.f31427c;
        buVar.f31671c = userInfoBean.f31428d;
        buVar.f31676h = userInfoBean.f31439o == 1;
        int i10 = userInfoBean.f31426b;
        if (i10 == 1) {
            buVar.f31670b = (byte) 1;
        } else if (i10 == 2) {
            buVar.f31670b = (byte) 4;
        } else if (i10 == 3) {
            buVar.f31670b = (byte) 2;
        } else if (i10 == 4) {
            buVar.f31670b = (byte) 3;
        } else if (i10 == 8) {
            buVar.f31670b = (byte) 8;
        } else {
            if (i10 < 10 || i10 >= 20) {
                C1139k.j("unknown uinfo type %d ", Integer.valueOf(i10));
                return null;
            }
            buVar.f31670b = (byte) i10;
        }
        HashMap map = new HashMap();
        buVar.f31674f = map;
        if (userInfoBean.f31440p >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.f31440p);
            map.put("C01", sb2.toString());
        }
        if (userInfoBean.f31441q >= 0) {
            Map<String, String> map2 = buVar.f31674f;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(userInfoBean.f31441q);
            map2.put("C02", sb3.toString());
        }
        Map<String, String> map3 = userInfoBean.f31442r;
        if (map3 != null && map3.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f31442r.entrySet()) {
                buVar.f31674f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map4 = userInfoBean.f31443s;
        if (map4 != null && map4.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f31443s.entrySet()) {
                buVar.f31674f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map5 = buVar.f31674f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(true ^ userInfoBean.f31436l);
        map5.put("A36", sb4.toString());
        Map<String, String> map6 = buVar.f31674f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f31431g);
        map6.put("F02", sb5.toString());
        Map<String, String> map7 = buVar.f31674f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f31432h);
        map7.put("F03", sb6.toString());
        buVar.f31674f.put("F04", userInfoBean.f31434j);
        Map<String, String> map8 = buVar.f31674f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.f31433i);
        map8.put("F05", sb7.toString());
        buVar.f31674f.put("F06", userInfoBean.f31437m);
        Map<String, String> map9 = buVar.f31674f;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(userInfoBean.f31435k);
        map9.put("F10", sb8.toString());
        C1139k.h("summary type %d vm:%d", Byte.valueOf(buVar.f31670b), Integer.valueOf(buVar.f31674f.size()));
        return buVar;
    }

    public static <T extends com.tencent.bugly.proguard.m> T d(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T tNewInstance = cls.newInstance();
                K k10 = new K(bArr);
                k10.f("utf-8");
                tNewInstance.a(k10);
                return tNewInstance;
            } catch (Throwable th) {
                if (!C1139k.g(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] e(com.tencent.bugly.proguard.m mVar) {
        try {
            L l10 = new L();
            l10.a("utf-8");
            mVar.d(l10);
            byte[] bArr = new byte[l10.f7332a.position()];
            System.arraycopy(l10.f7332a.array(), 0, bArr, 0, l10.f7332a.position());
            return bArr;
        } catch (Throwable th) {
            if (C1139k.g(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] f(Object obj) {
        try {
            H h10 = new H();
            h10.e();
            h10.a("utf-8");
            h10.j();
            h10.i("RqdServer");
            h10.k("sync");
            h10.b("detail", obj);
            return h10.h();
        } catch (Throwable th) {
            if (C1139k.g(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
