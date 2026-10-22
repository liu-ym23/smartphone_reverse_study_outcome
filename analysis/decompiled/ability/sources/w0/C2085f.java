package w0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import com.apm.insight.CrashType;
import com.apm.insight.ICommonParams;
import com.apm.insight.MonitorCrash;
import com.apm.insight.entity.Header;
import com.apm.insight.log.ILog;
import com.apm.insight.log.VLog;
import com.bytedance.android.monitor.logger.MonitorLog;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import e2.C1404a;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONObject;
import u2.C2032a;

/* renamed from: w0.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2085f implements F.b, a5.k, g2.b, ICommonParams {
    public static volatile C2085f b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6810a;

    public /* synthetic */ C2085f(int i) {
        this.f6810a = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList a() {
        /*
            java.lang.String r0 = "-"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = z2.b.f6926a
            java.util.HashMap r2 = z2.d.c     // Catch: java.lang.Throwable -> L29
            com.apm.insight.MonitorCrash r3 = com.apm.insight.f.b     // Catch: java.lang.Throwable -> L29
            java.lang.String r3 = n2.c.f(r3)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L29
            z2.d r2 = (z2.d) r2     // Catch: java.lang.Throwable -> L29
            org.json.JSONObject r2 = r2.f6928a     // Catch: java.lang.Throwable -> L29
            if (r2 != 0) goto L1c
            goto L29
        L1c:
            java.lang.String r3 = "protector_module"
            java.lang.String r4 = "metas"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L29
            org.json.JSONArray r2 = D7.N.f(r2, r3)     // Catch: java.lang.Throwable -> L29
            goto L2a
        L29:
            r2 = 0
        L2a:
            if (r2 == 0) goto L8e
            r3 = 0
        L2d:
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L8e
            if (r3 >= r4) goto L8e
            org.json.JSONObject r4 = r2.optJSONObject(r3)     // Catch: java.lang.Throwable -> L8e
            u2.a r5 = new u2.a     // Catch: java.lang.Throwable -> L8e
            r5.<init>()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = "clazzName"
            java.lang.String r6 = r4.optString(r6)     // Catch: java.lang.Throwable -> L8e
            boolean r7 = android.text.TextUtils.equals(r0, r6)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = ""
            if (r7 == 0) goto L4d
            r5.c = r8     // Catch: java.lang.Throwable -> L8e
            goto L4f
        L4d:
            r5.c = r6     // Catch: java.lang.Throwable -> L8e
        L4f:
            java.lang.String r6 = "rule_id"
            java.lang.String r6 = r4.optString(r6)     // Catch: java.lang.Throwable -> L8e
            r5.f6691a = r6     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = "throwableClassName"
            java.lang.String r6 = r4.optString(r6)     // Catch: java.lang.Throwable -> L8e
            r5.g = r6     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = "methodName"
            java.lang.String r6 = r4.optString(r6)     // Catch: java.lang.Throwable -> L8e
            boolean r7 = android.text.TextUtils.equals(r0, r6)     // Catch: java.lang.Throwable -> L8e
            if (r7 == 0) goto L6e
            r5.d = r8     // Catch: java.lang.Throwable -> L8e
            goto L70
        L6e:
            r5.d = r6     // Catch: java.lang.Throwable -> L8e
        L70:
            java.lang.String r6 = "threadName"
            java.lang.String r6 = r4.optString(r6)     // Catch: java.lang.Throwable -> L8e
            r5.e = r6     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = "processName"
            java.lang.String r6 = r4.optString(r6)     // Catch: java.lang.Throwable -> L8e
            r5.b = r6     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = "detailMessage"
            java.lang.String r4 = r4.optString(r6)     // Catch: java.lang.Throwable -> L8e
            r5.f = r4     // Catch: java.lang.Throwable -> L8e
            r1.add(r5)     // Catch: java.lang.Throwable -> L8e
            int r3 = r3 + 1
            goto L2d
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.C2085f.a():java.util.ArrayList");
    }

    public static void d(Throwable th, Thread thread, C2032a c2032a, String str, String str2) {
        u1.d dVarS = u1.d.s();
        CrashType crashType = CrashType.PORTRAIT;
        n2.a aVarO = dVarS.o(crashType, new A5.c(c2032a, th, thread, 16));
        Context context = com.apm.insight.g.f2160a;
        Header headerA = Header.a();
        headerA.j();
        headerA.k();
        headerA.h();
        Header.addRuntimeHeader(headerA.f2158a);
        Header.f(headerA);
        Z6.k.i(aVarO, headerA, crashType);
        JSONObject jSONObject = new JSONObject();
        try {
            aVarO.e("crash_defend", "event_type");
            aVarO.e(str, "crash_md5");
            aVarO.e(str2, "crash_uuid");
            com.stepos.statsrpk.d.b(com.apm.insight.g.f2160a, aVarO.f5345a);
            jSONObject.put(SettingsConfig.KEY_DATA, aVarO.f5345a);
            jSONObject.put("header", headerA.f2158a);
        } catch (Throwable unused) {
        }
        w2.i.a().getClass();
        if (jSONObject.length() != 0) {
            z2.l.i().a(new H.f(4, jSONObject));
        }
        MonitorCrash monitorCrash = com.apm.insight.f.b;
        if (monitorCrash != null) {
            monitorCrash.addTags("crash_after_portrait", "true");
        }
    }

    public static final String e(byte[] bArr, byte[][] bArr2, int i) {
        int i6;
        boolean z10;
        int i10;
        int i11;
        byte[] bArr3 = PublicSuffixDatabase.e;
        int length = bArr.length;
        int i12 = 0;
        while (i12 < length) {
            int i13 = (i12 + length) / 2;
            while (i13 > -1 && bArr[i13] != 10) {
                i13--;
            }
            int i14 = i13 + 1;
            int i15 = 1;
            while (true) {
                i6 = i14 + i15;
                if (bArr[i6] == 10) {
                    break;
                }
                i15++;
            }
            int i16 = i6 - i14;
            int i17 = i;
            boolean z11 = false;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                if (z11) {
                    i10 = 46;
                    z10 = false;
                } else {
                    byte b5 = bArr2[i17][i18];
                    byte[] bArr4 = G9.b.f704a;
                    int i20 = b5 & 255;
                    z10 = z11;
                    i10 = i20;
                }
                byte b10 = bArr[i14 + i19];
                byte[] bArr5 = G9.b.f704a;
                i11 = i10 - (b10 & 255);
                if (i11 != 0) {
                    break;
                }
                i19++;
                i18++;
                if (i19 == i16) {
                    break;
                }
                if (bArr2[i17].length != i18) {
                    z11 = z10;
                } else {
                    if (i17 == bArr2.length - 1) {
                        break;
                    }
                    i17++;
                    i18 = -1;
                    z11 = true;
                }
            }
            if (i11 >= 0) {
                if (i11 <= 0) {
                    int i21 = i16 - i19;
                    int length2 = bArr2[i17].length - i18;
                    int length3 = bArr2.length;
                    for (int i22 = i17 + 1; i22 < length3; i22++) {
                        length2 += bArr2[i22].length;
                    }
                    if (length2 >= i21) {
                        if (length2 <= i21) {
                            Charset UTF_8 = StandardCharsets.UTF_8;
                            kotlin.jvm.internal.k.e(UTF_8, "UTF_8");
                            return new String(bArr, i14, i16, UTF_8);
                        }
                    }
                }
                i12 = i6 + 1;
            }
            length = i13;
        }
        return null;
    }

    public static C2085f f() {
        if (b == null) {
            synchronized (C2085f.class) {
                try {
                    if (b == null) {
                        b = new C2085f(0);
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void b(String str) {
        try {
            try {
                ILog vLog = VLog.getInstance(str);
                if (vLog != null) {
                    vLog.asyncFlush();
                } else if (TextUtils.equals(com.apm.insight.f.j(), str)) {
                    VLog.flush();
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            if (TextUtils.equals(com.apm.insight.f.j(), str)) {
                VLog.flush();
            }
        }
    }

    @Override // F.b
    public void c(JSONObject jSONObject) {
        try {
            if (H.h.b) {
                Log.d("ApmInsight", U7.a.e(new String[]{"Receive:HybridData"}));
            }
            MonitorLog.d("TTLiveWebViewMonitorDefault", "monitorStatusAndDuration:begin:" + jSONObject);
            O.a.g().c(new P.b(0, "hybrid", jSONObject));
        } catch (Exception unused) {
        }
    }

    public m6.b g(Context context) {
        m6.b bVar;
        m6.b bVar2 = m6.b.e;
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (this) {
            bVar = m6.b.e;
            if (bVar == null) {
                Context applicationContext = context.getApplicationContext();
                kotlin.jvm.internal.k.e(applicationContext, "getApplicationContext(...)");
                bVar = new m6.b(applicationContext);
                m6.b.e = bVar;
            }
        }
        return bVar;
    }

    @Override // com.apm.insight.ICommonParams
    public Map getCommonParams() {
        return new HashMap();
    }

    @Override // com.apm.insight.ICommonParams
    public String getDeviceId() {
        C1404a c1404aC = C1404a.c(com.apm.insight.g.a().s());
        return c1404aC != null ? c1404aC.b() : "";
    }

    @Override // com.apm.insight.ICommonParams
    public List getPatchInfo() {
        return null;
    }

    @Override // com.apm.insight.ICommonParams
    public Map getPluginInfo() {
        return null;
    }

    @Override // com.apm.insight.ICommonParams
    public String getSessionId() {
        return null;
    }

    @Override // com.apm.insight.ICommonParams
    public long getUserId() {
        return 0L;
    }

    @Override // a5.k
    public void i(TextView textView, int i, int i6) {
        textView.measure(i, i6);
    }

    @Override // a5.k
    public void p(TextView textView, float f) {
        textView.setTextSize(0, f);
    }

    public String toString() {
        switch (this.f6810a) {
            case 2:
                return "CpuAbnormalConfig{cpuHardWare='unknown', scene='default', cpuSpeed=0.0, smallCpuCoreTimePercent=0.0, middleCpuCoreTimePercent=0.0, BigCpuCoreTimePercent=0.0}";
            default:
                return super.toString();
        }
    }
}
