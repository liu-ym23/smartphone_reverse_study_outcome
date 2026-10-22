package w2;

import D7.N;
import a.AbstractC0291a;
import android.content.Context;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.core.os.EnvironmentCompat;
import ca.AbstractC0897f;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.entity.Header;
import com.apm.insight.nativecrash.NativeImpl;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k2.C1621a;
import org.json.JSONArray;
import org.json.JSONObject;
import p2.AbstractC1790a;
import s2.C1912a;

/* loaded from: classes2.dex */
public final class f {
    public static volatile f h;

    /* renamed from: a, reason: collision with root package name */
    public Context f6835a;
    public int b;
    public e c;
    public HashMap d;
    public volatile boolean e;
    public c f;
    public c g;

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject b(k2.C1621a r13) {
        /*
            Method dump skipped, instructions count: 592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.f.b(k2.a):org.json.JSONObject");
    }

    public static f c() {
        if (h == null) {
            synchronized (f.class) {
                try {
                    if (h == null) {
                        Context context = com.apm.insight.g.f2160a;
                        f fVar = new f();
                        new ArrayList();
                        new ArrayList();
                        fVar.b = -1;
                        fVar.e = false;
                        fVar.f = new c(fVar, 0);
                        fVar.g = new c(fVar, 1);
                        fVar.f6835a = context;
                        h = fVar;
                    }
                } finally {
                }
            }
        }
        return h;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(java.util.HashMap r11, w2.e r12, java.io.File r13, java.lang.String r14) {
        /*
            java.lang.String r0 = "G"
            boolean r0 = r14.endsWith(r0)
            if (r0 == 0) goto Lce
            java.lang.String r0 = "_"
            java.lang.String[] r0 = r14.split(r0)
            int r1 = r0.length
            r2 = 5
            r3 = 0
            if (r1 >= r2) goto L1e
            java.util.ArrayList r11 = r12.b
            w2.d r12 = new w2.d
            r12.<init>(r13, r3)
            r11.add(r12)
            return
        L1e:
            r1 = 0
            r2 = r0[r1]     // Catch: java.lang.Throwable -> Lb1
            long r4 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> Lb1
            r2 = 4
            r2 = r0[r2]     // Catch: java.lang.Throwable -> Lb1
            long r6 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> Lb1
            r12 = 2
            r2 = r0[r12]
            r8 = 1
            r0 = r0[r8]
            r0.getClass()
            int r9 = r0.hashCode()
            r10 = -1
            switch(r9) {
                case -1109843021: goto L55;
                case 96741: goto L4a;
                case 3254818: goto L3f;
                default: goto L3d;
            }
        L3d:
            r1 = r10
            goto L5e
        L3f:
            java.lang.String r1 = "java"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L48
            goto L3d
        L48:
            r1 = r12
            goto L5e
        L4a:
            java.lang.String r12 = "anr"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L53
            goto L3d
        L53:
            r1 = r8
            goto L5e
        L55:
            java.lang.String r12 = "launch"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L5e
            goto L3d
        L5e:
            switch(r1) {
                case 0: goto L68;
                case 1: goto L65;
                case 2: goto L62;
                default: goto L61;
            }
        L61:
            goto L6a
        L62:
            com.apm.insight.CrashType r3 = com.apm.insight.CrashType.JAVA
            goto L6a
        L65:
            com.apm.insight.CrashType r3 = com.apm.insight.CrashType.ANR
            goto L6a
        L68:
            com.apm.insight.CrashType r3 = com.apm.insight.CrashType.LAUNCH
        L6a:
            java.lang.Object r12 = r11.get(r2)
            w2.e r12 = (w2.e) r12
            if (r12 != 0) goto L7a
            w2.e r12 = new w2.e
            r12.<init>(r2)
            r11.put(r2, r12)
        L7a:
            w2.d r11 = new w2.d
            r11.<init>()
            r0 = -1
            r11.c = r0
            r11.f6833a = r13
            r11.b = r4
            r11.d = r3
            java.lang.String r13 = r13.getName()
            r11.e = r13
            r11.c = r6
            w2.d r13 = r12.d
            if (r13 == 0) goto L9b
            long r0 = r13.b
            int r13 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r13 <= 0) goto Lab
        L9b:
            if (r3 == 0) goto Lab
            com.apm.insight.CrashType r13 = com.apm.insight.CrashType.ANR
            if (r3 == r13) goto Lab
            java.lang.String r13 = "ignore"
            boolean r13 = r14.contains(r13)
            if (r13 != 0) goto Lab
            r12.d = r11
        Lab:
            java.util.ArrayList r12 = r12.b
            r12.add(r11)
            return
        Lb1:
            java.util.ArrayList r11 = r12.b
            w2.d r12 = new w2.d
            r12.<init>(r13, r3)
            r11.add(r12)
            int r11 = com.apm.insight.b.f2156a
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            java.lang.String r12 = "err format crashTime:"
            java.lang.String r12 = r12.concat(r14)
            r11.<init>(r12)
            java.lang.String r12 = "NPTH_CATCH"
            M0.i.k(r12, r11)
            return
        Lce:
            M.a.u(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.f.d(java.util.HashMap, w2.e, java.io.File, java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final F1.b a(File file, CrashType crashType, String str, long j5, long j6) {
        F1.b bVarB;
        JSONObject jSONObjectOptJSONObject;
        String str2 = str;
        Context context = this.f6835a;
        try {
            try {
                if (file.isFile()) {
                    M.a.u(file);
                    return null;
                }
                boolean z10 = crashType == CrashType.LAUNCH;
                if (crashType == null) {
                    try {
                        return M.a.N(new File(file, file.getName()).getAbsolutePath());
                    } catch (Throwable th) {
                        th = th;
                        bVarB = null;
                        M.a.u(file);
                        int i = com.apm.insight.b.f2156a;
                        M0.i.k("NPTH_CATCH", th);
                        return bVarB;
                    }
                }
                bVarB = M.a.b(file, crashType);
                try {
                    JSONObject jSONObject = (JSONObject) bVarB.b;
                    try {
                        if (jSONObject != null) {
                            boolean z11 = z10;
                            try {
                                if (crashType == CrashType.ANR) {
                                    return bVarB;
                                }
                                jSONObject.put("crash_time", j5);
                                try {
                                    jSONObject.put("app_start_time", j6);
                                    jSONObjectOptJSONObject = jSONObject.optJSONObject("header");
                                } catch (Throwable th2) {
                                    th = th2;
                                    str2 = bVarB;
                                    bVarB = str2;
                                    M.a.u(file);
                                    int i6 = com.apm.insight.b.f2156a;
                                    M0.i.k("NPTH_CATCH", th);
                                    return bVarB;
                                }
                                try {
                                    if (jSONObjectOptJSONObject == null) {
                                        jSONObjectOptJSONObject = Header.b(j5).f2158a;
                                    } else if (z11) {
                                        jSONObject.remove("header");
                                    }
                                    String strOptString = jSONObjectOptJSONObject.optString("sdk_version_name", null);
                                    if (strOptString == null) {
                                        strOptString = "1.5.0";
                                    }
                                    n2.a.i(jSONObject, "filters", "sdk_version", strOptString);
                                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("logcat");
                                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                                        jSONObject.put("logcat", M.a.g(0L, str2));
                                    }
                                    n2.a.i(jSONObject, "filters", "has_dump", "true");
                                    n2.a.i(jSONObject, "filters", "has_logcat", String.valueOf(!N.h(jSONObject)));
                                    n2.a.i(jSONObject, "filters", "memory_leak", String.valueOf(n2.a.p(str2)));
                                    n2.a.i(jSONObject, "filters", "fd_leak", String.valueOf(n2.a.s(str2)));
                                    n2.a.i(jSONObject, "filters", "threads_leak", String.valueOf(n2.a.t(str2)));
                                    n2.a.i(jSONObject, "filters", "is_64_devices", String.valueOf(Header.e()));
                                    n2.a.i(jSONObject, "filters", "is_64_runtime", String.valueOf(NativeImpl.s()));
                                    n2.a.i(jSONObject, "filters", "is_x86_devices", String.valueOf(Header.g()));
                                    n2.a.i(jSONObject, "filters", "has_meminfo_file", String.valueOf(new File(N9.j.g(com.apm.insight.g.f2160a, str2), "meminfo.txt").exists()));
                                    n2.a.i(jSONObject, "filters", "is_root", String.valueOf(C1621a.v()));
                                    jSONObject.put("launch_did", C1912a.a(context));
                                    jSONObject.put("crash_uuid", file.getName());
                                    jSONObject.put("jiffy", M0.i.c());
                                    try {
                                        long j10 = Long.parseLong(z2.l.c(j5, str2));
                                        n2.a.i(jSONObject, "filters", "lastAliveTime", Math.abs(j10 - j5) < 60000 ? "< 60s" : "> 60s");
                                        jSONObject.put("lastAliveTime", String.valueOf(j10));
                                    } catch (Throwable unused) {
                                        jSONObject.put("lastAliveTime", EnvironmentCompat.MEDIA_UNKNOWN);
                                        n2.a.i(jSONObject, "filters", "lastAliveTime", EnvironmentCompat.MEDIA_UNKNOWN);
                                    }
                                    jSONObject.put("has_dump", "true");
                                    if (jSONObject.opt("storage") == null) {
                                        Context context2 = com.apm.insight.g.f2160a;
                                        n2.a.l(jSONObject, AbstractC0897f.e());
                                    }
                                    if (jSONObjectOptJSONObject.optInt("unauthentic_version", 0) == 1) {
                                        n2.a.i(jSONObject, "filters", "unauthentic_version", "unauthentic_version");
                                    }
                                    AbstractC0291a.q(jSONObject);
                                    F1.b bVar = bVarB;
                                    ((JSONObject) bVar.b).put("upload_scene", "launch_scan");
                                    if (z11) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject.put("event_type", "start_crash");
                                        jSONObject.put("stack", jSONObject.remove(SettingsConfig.KEY_DATA));
                                        jSONObject2.put(SettingsConfig.KEY_DATA, new JSONArray().put(jSONObject));
                                        jSONObject2.put("header", jSONObjectOptJSONObject);
                                        bVar.b = jSONObject2;
                                        str2 = bVar;
                                    } else {
                                        jSONObject.put("isJava", 1);
                                        str2 = bVar;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    bVarB = bVarB;
                                    M.a.u(file);
                                    int i62 = com.apm.insight.b.f2156a;
                                    M0.i.k("NPTH_CATCH", th);
                                    return bVarB;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } else {
                            str2 = bVarB;
                            M.a.u(file);
                        }
                        return str2;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    str2 = bVarB;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            th = th8;
            bVarB = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:(5:92|42|43|(1:45)(1:47)|48)|(16:50|96|51|(1:53)|86|59|68|69|(1:71)(1:73)|72|74|75|90|76|67|111)(1:56)|57|(2:86|59)(3:(0)(1:66)|67|111)|68|69|(0)(0)|72|74|75|90|76|67|111) */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0185, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(w2.e r19, boolean r20, A0.d r21) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.f.e(w2.e, boolean, A0.d):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:167|(1:176)|177|(2:316|178)|(6:180|(4:182|183|288|184)(2:186|(1:188))|300|196|(1:208)(5:200|201|306|202|(1:(1:205)(1:206)))|(3:296|213|(4:224|(1:226)|229|(2:312|231)(1:233))))(1:190)|195|300|196|(3:198|208|(4:210|296|213|(8:215|217|219|221|224|(0)|229|(0)(0))))(0)) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0393 A[Catch: all -> 0x03b0, TryCatch #11 {all -> 0x03b0, blocks: (B:196:0x038d, B:198:0x0393, B:200:0x039b), top: B:300:0x038d }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x042b A[Catch: all -> 0x042f, TryCatch #9 {all -> 0x042f, blocks: (B:213:0x03bc, B:215:0x03ca, B:217:0x03d4, B:219:0x03de, B:221:0x03e4, B:224:0x03eb, B:226:0x042b, B:229:0x0431, B:233:0x044a), top: B:296:0x03bc }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x044a A[Catch: all -> 0x042f, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x042f, blocks: (B:213:0x03bc, B:215:0x03ca, B:217:0x03d4, B:219:0x03de, B:221:0x03e4, B:224:0x03eb, B:226:0x042b, B:229:0x0431, B:233:0x044a), top: B:296:0x03bc }] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0442 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0146 A[Catch: all -> 0x0105, TryCatch #1 {all -> 0x0105, blocks: (B:49:0x00f3, B:51:0x0101, B:54:0x0107, B:58:0x0116, B:70:0x0135, B:73:0x0146, B:75:0x014c, B:76:0x0150, B:69:0x0130, B:57:0x010f, B:61:0x011d, B:63:0x0127), top: B:280:0x00f3, inners: #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(boolean r26) {
        /*
            Method dump skipped, instructions count: 1268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.f.f(boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0181 A[Catch: all -> 0x01a6, TRY_ENTER, TryCatch #2 {all -> 0x01a6, blocks: (B:104:0x018c, B:103:0x0186, B:102:0x0181, B:111:0x01b5), top: B:121:0x0186 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011e A[Catch: all -> 0x00b5, TRY_LEAVE, TryCatch #1 {all -> 0x00b5, blocks: (B:69:0x00fb, B:73:0x0115, B:76:0x011e, B:79:0x0126, B:81:0x0133, B:89:0x0153, B:91:0x0161, B:93:0x016a, B:92:0x0166, B:94:0x016e, B:39:0x009d, B:41:0x00a3, B:43:0x00a7, B:45:0x00ad, B:48:0x00b7, B:59:0x00d7, B:51:0x00bf, B:53:0x00c3, B:55:0x00cb, B:58:0x00d4, B:61:0x00dc, B:66:0x00f4), top: B:119:0x0115 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(w2.e r22, boolean r23, A0.d r24) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.f.g(w2.e, boolean, A0.d):void");
    }

    public final void h() {
        if (this.e || this.d == null) {
            return;
        }
        if (!D2.b.f(this.f6835a)) {
            this.e = true;
            this.d = null;
            NativeImpl.x();
        }
        if (this.b == -1) {
            int i = z2.b.f6926a;
            if (z2.k.f6933a && z2.b.a("custom_event_settings", "npth_simple_setting", "upload_crash_crash") == 1) {
                this.b = 1;
            } else {
                this.b = 0;
            }
        }
        boolean z10 = this.b == 1;
        Context context = this.f6835a;
        A0.d dVar = new A0.d();
        dVar.c = null;
        dVar.f70a = 50;
        dVar.b = 100;
        dVar.d = context;
        File file = new File(N9.j.C(context) + "/apminsight/issueCrashTimes/current.times");
        HashMap map = new HashMap();
        map.put("time", Long.valueOf(System.currentTimeMillis()));
        try {
            JSONArray jSONArrayC = M.a.C(file.getAbsolutePath());
            if (!N.g(jSONArrayC)) {
                Long lDecode = Long.decode(jSONArrayC.optString(0, null));
                if (System.currentTimeMillis() - lDecode.longValue() > CalendarModelKt.MillisecondsIn24Hours) {
                    dVar.c(file);
                } else {
                    map.put("time", lDecode);
                    for (int i6 = 1; i6 < jSONArrayC.length(); i6++) {
                        String[] strArrSplit = jSONArrayC.optString(i6, "").split(" ");
                        if (strArrSplit.length == 2) {
                            map.put(strArrSplit[0], Long.decode(strArrSplit[1]));
                        }
                    }
                }
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            int i10 = com.apm.insight.b.f2156a;
            M0.i.k("NPTH_CATCH", th);
        }
        dVar.c = map;
        dVar.f70a = N.b(z2.b.b(), dVar.f70a, "custom_event_settings", "npth_simple_setting", "crash_limit_issue");
        dVar.b = N.b(z2.b.b(), dVar.b, "custom_event_settings", "npth_simple_setting", "crash_limit_all");
        Iterator it = this.d.values().iterator();
        while (it.hasNext()) {
            g((e) it.next(), z10, dVar);
        }
        Iterator it2 = this.d.values().iterator();
        while (it2.hasNext()) {
            e((e) it2.next(), z10, dVar);
        }
        for (e eVar : this.d.values()) {
            Context context2 = this.f6835a;
            if (eVar != null) {
                String str = eVar.f6834a;
                if (eVar.h) {
                    M.a.u(N9.j.g(context2, str));
                    M.a.u(N9.j.k(context2, str));
                }
            }
        }
        if (com.apm.insight.g.f2162q > 0) {
            AbstractC1790a.a();
        }
        HashMap map2 = (HashMap) dVar.c;
        Long l = (Long) map2.remove("time");
        if (l == null) {
            int i11 = com.apm.insight.b.f2156a;
            M0.i.k("NPTH_CATCH", new RuntimeException("err times, no time"));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(l);
            sb.append('\n');
            for (Map.Entry entry : map2.entrySet()) {
                sb.append((String) entry.getKey());
                sb.append(' ');
                sb.append(entry.getValue());
                sb.append('\n');
            }
            try {
                M.a.t(sb.toString(), new File(N9.j.C((Context) dVar.d) + "/apminsight/issueCrashTimes/current.times"), false);
            } catch (IOException unused2) {
            }
        }
        File file2 = new File(N9.j.C(com.apm.insight.g.f2160a), "apminsight/TrackInfo/");
        String[] list = file2.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            for (int i12 = 0; i12 < list.length - 5; i12++) {
                M.a.u(new File(file2, list[i12]));
            }
        }
        this.e = true;
        this.d = null;
        NativeImpl.x();
    }

    public final void i() {
        if (this.e) {
            return;
        }
        if (!D2.b.f(this.f6835a) || (System.currentTimeMillis() - com.apm.insight.g.c <= 5000 && com.apm.insight.g.g.isApmExists() && !Npth.hasCrash())) {
            z2.l.i().b(this.f, 5000L);
        } else {
            h();
        }
    }
}
