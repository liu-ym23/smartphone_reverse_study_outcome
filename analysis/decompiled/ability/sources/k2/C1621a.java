package k2;

import B0.f;
import D9.t;
import F9.v;
import M0.i;
import N9.j;
import O5.d;
import S0.b;
import W5.c;
import X6.n;
import X6.o;
import Z6.k;
import a.AbstractC0291a;
import a7.AbstractC0307c;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import ca.AbstractC0897f;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.g;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.ConfigManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.stepos.ability.App;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.statsapp.v3.SdkVer;
import com.stepos.statsrpk.IRpkStatsInterface;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import com.volcengine.tos.model.bucket.CreateBucketV2Input;
import com.volcengine.tos.model.bucket.CreateBucketV2Output;
import com.volcengine.tos.model.bucket.HeadBucketV2Input;
import com.volcengine.tos.model.bucket.HeadBucketV2Output;
import com.volcengine.tos.model.bucket.ListBucketsV2Input;
import com.volcengine.tos.model.bucket.ListBucketsV2Output;
import e1.C1403b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qa.C1860l;
import qa.InterfaceC1854f;
import s2.C1912a;
import stepos.support.v7.app.S;
import stepos.support.v7.permission.e;
import x2.C2113a;
import z3.G;

/* renamed from: k2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1621a implements InterfaceC1854f, e, G {
    public static volatile C1621a c;
    public static boolean d;
    public static Boolean e;

    /* renamed from: a, reason: collision with root package name */
    public Object f4793a;
    public Object b;

    public /* synthetic */ C1621a(Object obj, Object obj2) {
        this.f4793a = obj;
        this.b = obj2;
    }

    public static C1621a a() {
        if (c == null) {
            synchronized (C1621a.class) {
                try {
                    if (c == null) {
                        c = new C1621a();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public static void s(App app) {
        File externalFilesDir;
        if (d) {
            return;
        }
        boolean z10 = true;
        d = true;
        if (TextUtils.isEmpty("20014673")) {
            throw new IllegalArgumentException("appId is null!");
        }
        C1621a c1621a = G5.a.f676a;
        c1621a.f4793a = app;
        c1621a.b = "20014673";
        if (c.c && (externalFilesDir = app.getExternalFilesDir(null)) != null) {
            String absolutePath = externalFilesDir.getAbsolutePath();
            t tVar = new t();
            tVar.b = absolutePath;
            File file = new File(absolutePath);
            if (!file.exists() || !file.isDirectory()) {
                file.mkdirs();
            }
            tVar.d = new File(absolutePath, "usage_logs_v2.txt");
            W5.a aVar = new W5.a();
            int i = 0;
            aVar.c = 0;
            aVar.f1489a = new char[64];
            aVar.c = "copyright".charAt(0) % '\r';
            while (true) {
                char[] cArr = W5.a.d;
                if (i >= 64) {
                    break;
                }
                aVar.f1489a[i] = cArr[(aVar.c + i) % 64];
                i++;
            }
            aVar.b = aVar.f1489a;
            tVar.e = aVar;
            tVar.f = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
            tVar.c = Process.myPid();
            c.f1491a = tVar;
        }
        d dVar = O5.c.f1037a;
        App app2 = (App) c1621a.f4793a;
        String str = (String) c1621a.b;
        StringBuilder sbV = B7.a.v("SDKInstanceImpl, pkgType: 0, appId: ", str, ", channel: StepOS, initConfig: ");
        sbV.append(new C1403b(2));
        sbV.append(", sdkVersion: ");
        sbV.append(SdkVer.verName);
        c.d("SDKInstanceImpl", sbV.toString());
        dVar.f1038a = app2;
        dVar.b = str;
        dVar.c = "StepOS";
        b.n = "6KAIUyh8oTuWsB0JiE9";
        b.f1164j = "https://uxip.stepaos.com/api/v3/event/";
        b.k = "https://uxip-config.stepaos.com/api/v3/umid/privacy";
        b.l = "https://uxip-res.stepaos.com/resource/v3/config/";
        b.m = "https://uxip-res.stepaos.com/resource/v3/config/rpk/";
        f fVar = new f();
        fVar.b = false;
        fVar.f177a = str;
        dVar.e = fVar;
        dVar.g = new v(1);
        dVar.f = new A5.c(app2);
        new LinkedList();
        c.a("PageController", "PageController init");
        I9.d.a(new O5.b(dVar, z10, 0));
        c.a("UsageStatsProxy3", "UsageStatsProxy3 init complete");
    }

    public static boolean v() {
        Boolean bool = e;
        if (bool != null) {
            return bool.booleanValue();
        }
        String[] strArr = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        for (int i = 0; i < 11; i++) {
            try {
            } catch (Throwable th) {
                int i6 = com.apm.insight.b.f2156a;
                i.k("NPTH_CATCH", th);
            }
            if (new File(strArr[i]).exists()) {
                e = Boolean.TRUE;
                return true;
            }
            continue;
        }
        e = Boolean.FALSE;
        return false;
    }

    public synchronized void b(Context context) {
        try {
            this.b = new Y5.b(context, "npth_log.db", null, 1, 1).getWritableDatabase();
        } finally {
            this.f4793a = new C1912a();
        }
        this.f4793a = new C1912a();
    }

    public void c(RpkEvent rpkEvent, RpkInfo rpkInfo) {
        c.a("RpkEmitter", "rpk track: " + rpkEvent + "," + rpkInfo);
        IRpkStatsInterface iRpkStatsInterface = (IRpkStatsInterface) this.b;
        if (iRpkStatsInterface != null) {
            try {
                iRpkStatsInterface.track(rpkEvent, rpkInfo);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(n2.a r5) {
        /*
            r4 = this;
            com.apm.insight.entity.Header r0 = new com.apm.insight.entity.Header
            r0.<init>()
            u1.d r1 = u1.d.B()
            java.lang.Object r2 = r4.b
            A5.c r2 = (A5.c) r2
            java.lang.Object r2 = r2.c
            B1.c r2 = (B1.c) r2
            java.lang.Object r2 = r2.f180a
            java.util.HashMap r2 = (java.util.HashMap) r2
            if (r2 == 0) goto L28
            boolean r3 = r2.isEmpty()     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L28
            java.lang.String r3 = "start_time"
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L26
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L26
            goto L29
        L26:
            r2 = move-exception
            goto L30
        L28:
            r2 = 0
        L29:
            if (r2 == 0) goto L37
            long r2 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L26
            goto L3b
        L30:
            int r3 = com.apm.insight.b.f2156a
            java.lang.String r3 = "NPTH_CATCH"
            M0.i.k(r3, r2)
        L37:
            long r2 = java.lang.System.currentTimeMillis()
        L3b:
            org.json.JSONObject r1 = r1.r(r2)
            if (r1 == 0) goto L4a
            r0.d(r1)
            r0.j()
            r0.k()
        L4a:
            com.apm.insight.entity.Header.f(r0)
            r5.d(r0)
            r0 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "is_native_crash"
            r5.e(r0, r1)
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "repack_time"
            r5.e(r0, r1)
            java.lang.Object r4 = r4.b
            A5.c r4 = (A5.c) r4
            java.lang.Object r4 = r4.d
            java.io.File r4 = (java.io.File) r4
            java.lang.String r4 = r4.getName()
            java.lang.String r0 = "crash_uuid"
            r5.e(r4, r0)
            long r0 = M0.i.c()
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            java.lang.String r0 = "jiffy"
            r5.e(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.C1621a.d(n2.a):void");
    }

    public synchronized boolean e(String str) {
        if (((C1912a) this.f4793a) == null) {
            b(g.f2160a);
        }
        C1912a c1912a = (C1912a) this.f4793a;
        if (c1912a == null) {
            return false;
        }
        return c1912a.e((SQLiteDatabase) this.b, str);
    }

    public String f() {
        A5.c cVar = (A5.c) this.b;
        if (cVar == null) {
            return null;
        }
        String strB = ((x2.d) cVar.b).b();
        return (strB == null || strB.isEmpty()) ? (String) ((HashMap) ((B1.c) ((A5.c) this.b).c).f180a).get("signal_line") : strB;
    }

    public void g(n2.a aVar) {
        AbstractC0291a.q(aVar.f5345a);
        HashMap map = new HashMap();
        if (v()) {
            map.put("is_root", "true");
            aVar.e("true", "is_root");
        } else {
            map.put("is_root", "false");
            aVar.e("false", "is_root");
        }
        map.put("has_fds_file", new File(j.g(g.f2160a, ((File) ((A5.c) this.b).d).getName()), "fds.txt").exists() ? "true" : "false");
        File file = new File(j.g(g.f2160a, ((File) ((A5.c) this.b).d).getName()), "logcat.txt");
        map.put("has_logcat_file", (!file.exists() || file.length() <= 128) ? "false" : "true");
        map.put("has_maps_file", new File(j.g(g.f2160a, ((File) ((A5.c) this.b).d).getName()), "maps.txt").exists() ? "true" : "false");
        map.put("has_tombstone_file", new File((File) ((A5.c) this.b).d, "tombstone.txt").exists() ? "true" : "false");
        map.put("has_meminfo_file", new File(j.g(g.f2160a, ((File) ((A5.c) this.b).d).getName()), "meminfo.txt").exists() ? "true" : "false");
        map.put("has_threads_file", new File(j.g(g.f2160a, ((File) ((A5.c) this.b).d).getName()), "threads.txt").exists() ? "true" : "false");
        C2113a c2113a = new C2113a();
        c2113a.c = "Total FD Count:";
        c2113a.b = new File(j.g(g.f2160a, ((File) ((A5.c) this.b).d).getName()), "fds.txt");
        c2113a.d = ":";
        c2113a.e = -2;
        int iA = c2113a.a();
        if (iA > 0) {
            if (iA > 960) {
                map.put("fd_leak", "true");
            } else {
                map.put("fd_leak", "false");
            }
            aVar.e(Integer.valueOf(iA), "fd_count");
        }
        C2113a c2113a2 = new C2113a();
        c2113a2.c = "Total Threads Count:";
        c2113a2.b = new File(j.g(g.f2160a, ((File) ((A5.c) this.b).d).getName()), "threads.txt");
        c2113a2.d = ":";
        c2113a2.e = -2;
        int iA2 = c2113a2.a();
        if (iA2 > 0) {
            if (iA2 > 350) {
                map.put("threads_leak", "true");
            } else {
                map.put("threads_leak", "false");
            }
            aVar.e(Integer.valueOf(iA2), "threads_count");
        }
        C2113a c2113a3 = new C2113a();
        c2113a3.c = "VmSize:";
        c2113a3.b = new File(j.g(g.f2160a, ((File) ((A5.c) this.b).d).getName()), "meminfo.txt");
        c2113a3.d = "\\s+";
        c2113a3.e = -1;
        int iA3 = c2113a3.a();
        if (iA3 > 0) {
            if (iA3 > (NativeImpl.s() ? Long.MAX_VALUE : Header.e() ? 3891200L : 2867200L)) {
                map.put("memory_leak", "true");
            } else {
                map.put("memory_leak", "false");
            }
            aVar.e(Integer.valueOf(iA3), "memory_size");
        }
        map.put("sdk_version", "1.5.0");
        map.put("has_java_stack", String.valueOf(aVar.f5345a.opt("java_data") != null));
        JSONArray jSONArrayI = AbstractC0291a.i(new File(j.g(g.f2160a, ((File) ((A5.c) this.b).d).getName()), "pthreads.txt"), new File(j.g(g.f2160a, ((File) ((A5.c) this.b).d).getName()), "rountines.txt"));
        map.put("leak_threads_count", String.valueOf(jSONArrayI.length()));
        if (jSONArrayI.length() > 0) {
            try {
                M.a.o(new File(j.g(g.f2160a, ((File) ((A5.c) this.b).d).getName()), "leakd_threads.txt"), jSONArrayI);
            } catch (Throwable unused) {
            }
        }
        aVar.f("has_logcat", String.valueOf(aVar.m()));
        aVar.q();
        aVar.r(map);
    }

    @Override // qa.InterfaceC1854f
    public Type h() {
        return (Type) this.f4793a;
    }

    @Override // qa.InterfaceC1854f
    public Object i(qa.v vVar) {
        Executor executor = (Executor) this.b;
        return executor == null ? vVar : new C1860l(executor, vVar);
    }

    public void j(n2.a aVar) {
        HashMap map = ((x2.d) ((A5.c) this.b).b).f;
        if (map.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : map.keySet()) {
            String str2 = (String) map.get(str);
            StringBuilder sb = new StringBuilder();
            try {
                if (str2.length() < 16) {
                    sb.append(str2);
                } else {
                    sb.append(str2.charAt(6));
                    sb.append(str2.charAt(7));
                    sb.append(str2.charAt(4));
                    sb.append(str2.charAt(5));
                    sb.append(str2.charAt(2));
                    sb.append(str2.charAt(3));
                    sb.append(str2.charAt(0));
                    sb.append(str2.charAt(1));
                    sb.append(str2.charAt(10));
                    sb.append(str2.charAt(11));
                    sb.append(str2.charAt(8));
                    sb.append(str2.charAt(9));
                    sb.append(str2.charAt(14));
                    sb.append(str2.charAt(15));
                    sb.append(str2.charAt(12));
                    sb.append(str2.charAt(13));
                    if (str2.length() >= 32) {
                        sb.append((CharSequence) str2, 16, 32);
                        sb.append('0');
                    }
                }
            } catch (Throwable th) {
                int i = com.apm.insight.b.f2156a;
                i.k("NPTH_CATCH", th);
            }
            String upperCase = sb.toString().toUpperCase();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lib_name", str);
                jSONObject.put("lib_uuid", upperCase);
                jSONArray.put(jSONObject);
            } catch (JSONException e6) {
                int i6 = com.apm.insight.b.f2156a;
                i.k("NPTH_CATCH", e6);
            }
        }
        aVar.e(jSONArray, "crash_lib_uuid");
    }

    public CreateBucketV2Output k(CreateBucketV2Input createBucketV2Input) {
        AbstractC0307c.a(createBucketV2Input, "CreateBucketV2Input");
        n(createBucketV2Input.getBucket());
        X6.c cVarC = ((o) this.b).c(createBucketV2Input.getBucket(), "", null);
        cVarC.c("X-Tos-Acl", createBucketV2Input.getAcl() == null ? null : createBucketV2Input.getAcl().f4219a);
        cVarC.c("X-Tos-Grant-Full-Control", createBucketV2Input.getGrantFullControl());
        cVarC.c("X-Tos-Grant-Read", createBucketV2Input.getGrantRead());
        cVarC.c("X-Tos-Grant-Read-Acp", createBucketV2Input.getGrantReadAcp());
        cVarC.c("X-Tos-Grant-Write", createBucketV2Input.getGrantWrite());
        cVarC.c("X-Tos-Grant-Write-Acp", createBucketV2Input.getGrantWriteAcp());
        cVarC.c("X-Tos-Storage-Class", createBucketV2Input.getStorageClass() == null ? null : createBucketV2Input.getStorageClass().f4230a);
        ((o) this.b).getClass();
        n nVarA = o.a(cVarC, "PUT", null);
        nVarA.g = false;
        return (CreateBucketV2Output) ((A0.b) this.f4793a).z(nVarA, 200, new G4.a(25));
    }

    public void l(n2.a aVar) {
        File file = new File((File) ((A5.c) this.b).d, "callback.json");
        if (!file.exists() && ((JSONObject) this.f4793a) == null) {
            Context context = g.f2160a;
            n2.a.l(aVar.f5345a, AbstractC0897f.e());
            aVar.f("has_callback", "false");
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) this.f4793a;
            if (jSONObject == null) {
                jSONObject = new JSONObject(M.a.w(file.getAbsolutePath()));
            }
            n2.a.o(aVar.f5345a, jSONObject);
            aVar.f("has_callback", "true");
            if (aVar.f5345a.opt("storage") == null) {
                Context context2 = g.f2160a;
                n2.a.l(aVar.f5345a, AbstractC0897f.e());
            }
            k.i(aVar, aVar.u(), CrashType.NATIVE);
        } catch (Throwable th) {
            int i = com.apm.insight.b.f2156a;
            i.k("NPTH_CATCH", th);
        }
        long j5 = -1;
        long jOptLong = aVar.f5345a.optLong("crash_time", -1L);
        long jOptLong2 = aVar.f5345a.optLong("java_end", -1L);
        if (jOptLong2 != -1 && jOptLong != -1) {
            j5 = jOptLong2 - jOptLong;
        }
        try {
            aVar.n("total_cost", String.valueOf(j5));
            aVar.f("total_cost", String.valueOf(j5 / 1000));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bb A[Catch: all -> 0x00c1, TRY_LEAVE, TryCatch #1 {all -> 0x00c1, blocks: (B:39:0x00b5, B:41:0x00bb), top: B:48:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(n2.a r9) {
        /*
            r8 = this;
            java.lang.String r0 = "\n"
            java.lang.Object r1 = r8.b
            A5.c r1 = (A5.c) r1
            java.lang.Object r1 = r1.d
            java.io.File r1 = (java.io.File) r1
            java.io.File r2 = new java.io.File
            java.lang.String r3 = "javastack.txt"
            r2.<init>(r1, r3)
            boolean r1 = r2.exists()
            java.lang.String r3 = "NPTH_CATCH"
            java.lang.String r4 = ""
            if (r1 == 0) goto L2a
            java.lang.String r1 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = y2.e.a(r1)     // Catch: java.lang.Throwable -> L24
            goto L2b
        L24:
            r1 = move-exception
            int r2 = com.apm.insight.b.f2156a
            M0.i.k(r3, r1)
        L2a:
            r1 = r4
        L2b:
            java.lang.Object r8 = r8.b
            A5.c r8 = (A5.c) r8
            java.lang.Object r8 = r8.d
            java.io.File r8 = (java.io.File) r8
            java.io.File r2 = new java.io.File
            java.lang.String r5 = "abortmsg.txt"
            r2.<init>(r8, r5)
            boolean r8 = r2.exists()
            if (r8 == 0) goto Lb5
            r8 = 0
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L9a
            java.io.FileReader r6 = new java.io.FileReader     // Catch: java.lang.Throwable -> L9a
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L9a
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r8 = r5.readLine()     // Catch: java.lang.Throwable -> L93
            if (r8 != 0) goto L55
        L51:
            M0.i.i(r5)
            goto La3
        L55:
            java.lang.String r2 = "[FATAL:jni_android.cc"
            boolean r2 = r8.startsWith(r2)     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L51
            java.lang.String r2 = "Please include Java exception stack in crash report ttwebview:"
            boolean r2 = r8.contains(r2)     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L51
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r2.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r6 = " ttwebview:"
            int r6 = r8.indexOf(r6)     // Catch: java.lang.Throwable -> L93
            java.lang.String r7 = "Caused by: "
            r2.append(r7)     // Catch: java.lang.Throwable -> L93
            java.lang.String r7 = "Please include Java exception stack in crash report"
            r2.append(r7)     // Catch: java.lang.Throwable -> L93
            r2.append(r0)     // Catch: java.lang.Throwable -> L93
            int r6 = r6 + 11
            java.lang.String r8 = r8.substring(r6)     // Catch: java.lang.Throwable -> L93
            r2.append(r8)     // Catch: java.lang.Throwable -> L93
        L86:
            r2.append(r0)     // Catch: java.lang.Throwable -> L93
            java.lang.String r8 = r5.readLine()     // Catch: java.lang.Throwable -> L93
            if (r8 == 0) goto L95
            r2.append(r8)     // Catch: java.lang.Throwable -> L93
            goto L86
        L93:
            r8 = move-exception
            goto L9d
        L95:
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Throwable -> L93
            goto L51
        L9a:
            r2 = move-exception
            r5 = r8
            r8 = r2
        L9d:
            int r2 = com.apm.insight.b.f2156a     // Catch: java.lang.Throwable -> Lb0
            M0.i.k(r3, r8)     // Catch: java.lang.Throwable -> Lb0
            goto L51
        La3:
            boolean r8 = r1.isEmpty()
            if (r8 != 0) goto Lae
            java.lang.String r1 = B7.a.B(r1, r0, r4)
            goto Lb5
        Lae:
            r1 = r4
            goto Lb5
        Lb0:
            r8 = move-exception
            M0.i.i(r5)
            throw r8
        Lb5:
            boolean r8 = r1.isEmpty()     // Catch: java.lang.Throwable -> Lc1
            if (r8 != 0) goto Lc7
            java.lang.String r8 = "java_data"
            r9.e(r1, r8)     // Catch: java.lang.Throwable -> Lc1
            goto Lc7
        Lc1:
            r8 = move-exception
            int r9 = com.apm.insight.b.f2156a
            M0.i.k(r3, r8)
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.C1621a.m(n2.a):void");
    }

    public void n(String str) {
        ((o) this.b).getClass();
        AbstractC0307c.b(str);
    }

    public void o(n2.a aVar) {
        File file = new File((File) ((A5.c) this.b).d, "flog.txt");
        if (file.exists()) {
            try {
                String strW = M.a.w(file.getAbsolutePath());
                JSONArray jSONArray = new JSONArray();
                if (strW != null) {
                    for (String str : strW.split("\n")) {
                        jSONArray.put(str);
                    }
                }
                aVar.e(jSONArray, "native_log");
            } catch (Throwable th) {
                int i = com.apm.insight.b.f2156a;
                i.k("NPTH_CATCH", th);
            }
        }
    }

    @Override // stepos.support.v7.permission.e
    public void onPrivacyPolicyClick(Context context) {
        com.stepos.policy.sdk.a aVar = ((S) this.b).f;
        if (aVar != null) {
            aVar.onClick((TextView) this.f4793a);
        }
    }

    @Override // stepos.support.v7.permission.e
    public void onUserAgreementClick(Context context) {
        View.OnClickListener onClickListener = ((S) this.b).g;
        if (onClickListener != null) {
            onClickListener.onClick((TextView) this.f4793a);
        }
    }

    public void p(n2.a aVar) {
        BufferedReader bufferedReader;
        File file = new File(j.g(g.f2160a, ((File) ((A5.c) this.b).d).getName()), "logcat.txt");
        if (!file.exists()) {
            String absolutePath = file.getAbsolutePath();
            ConfigManager configManager = g.g;
            NativeImpl.e(absolutePath, String.valueOf(configManager.getLogcatDumpCount()), String.valueOf(configManager.getLogcatLevel()));
        }
        JSONArray jSONArray = new JSONArray();
        String strQ = B7.a.q(new StringBuilder(" "), (String) ((HashMap) ((B1.c) ((A5.c) this.b).c).f180a).get(Constants.PARAM_PID), " ");
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (Throwable unused) {
        }
        try {
            if (file.length() > 512000) {
                bufferedReader.skip(file.length() - 512000);
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if ((line.length() > 32 ? line.substring(0, 31) : line).contains(strQ)) {
                    jSONArray.put(line);
                }
            }
            i.i(bufferedReader);
        } catch (Throwable unused2) {
            bufferedReader2 = bufferedReader;
            i.i(bufferedReader2);
            aVar.e(jSONArray, "logcat");
        }
        aVar.e(jSONArray, "logcat");
    }

    public void q(n2.a aVar) {
        A5.c cVar = (A5.c) this.b;
        HashMap map = cVar != null ? (HashMap) ((B1.c) cVar.c).f180a : null;
        if (map != null) {
            String str = (String) map.get("process_name");
            if (str != null) {
                aVar.e(str, "process_name");
            }
            String str2 = (String) map.get("start_time");
            if (str2 != null) {
                try {
                    aVar.c(Long.decode(str2).longValue());
                } catch (Throwable th) {
                    int i = com.apm.insight.b.f2156a;
                    i.k("NPTH_CATCH", th);
                }
            }
            String str3 = (String) map.get(Constants.PARAM_PID);
            if (str3 != null) {
                try {
                    aVar.e(Long.decode(str3), Constants.PARAM_PID);
                } catch (Throwable th2) {
                    int i6 = com.apm.insight.b.f2156a;
                    i.k("NPTH_CATCH", th2);
                }
            }
            String str4 = (String) map.get("crash_thread_name");
            if (str4 != null) {
                aVar.e(str4, "crash_thread_name");
            }
            String str5 = (String) map.get("crash_time");
            if (str5 != null) {
                try {
                    aVar.e(Long.decode(str5), "crash_time");
                } catch (Throwable th3) {
                    int i10 = com.apm.insight.b.f2156a;
                    i.k("NPTH_CATCH", th3);
                }
            }
            aVar.e(f(), SettingsConfig.KEY_DATA);
        }
    }

    public HeadBucketV2Output r(HeadBucketV2Input headBucketV2Input) {
        AbstractC0307c.a(headBucketV2Input, "HeadBucketInput");
        n(headBucketV2Input.getBucket());
        X6.c cVarC = ((o) this.b).c(headBucketV2Input.getBucket(), "", null);
        ((o) this.b).getClass();
        return (HeadBucketV2Output) ((A0.b) this.f4793a).z(o.a(cVarC, "HEAD", null), 200, new G4.a(5));
    }

    public boolean t() {
        return M.a.u((File) ((A5.c) this.b).d);
    }

    public ListBucketsV2Output u(ListBucketsV2Input listBucketsV2Input) {
        AbstractC0307c.a(listBucketsV2Input, "ListBucketsV2Input");
        X6.c cVarC = ((o) this.b).c("", "", null);
        ((o) this.b).getClass();
        return (ListBucketsV2Output) ((A0.b) this.f4793a).z(o.a(cVarC, "GET", null), 200, new G4.a(this));
    }

    @Override // z3.G
    public String w() {
        return (String) this.b;
    }

    @Override // z3.G
    public boolean x(JsonNode jsonNode) {
        JsonNode jsonNode2 = (JsonNode) this.f4793a;
        if (jsonNode2.isDouble() && jsonNode2.doubleValue() == Double.POSITIVE_INFINITY) {
            return false;
        }
        if (jsonNode2.isDouble() && jsonNode2.doubleValue() == Double.NEGATIVE_INFINITY) {
            return true;
        }
        if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.NEGATIVE_INFINITY) {
            return false;
        }
        if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.POSITIVE_INFINITY) {
            return true;
        }
        int iCompareTo = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal((String) this.b));
        return iCompareTo > 0 || iCompareTo == 0;
    }

    public Map y() {
        String string;
        CharSequence charSequenceLoadLabel;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.b;
        try {
            j.H("Querying installed apps", "InstalledAppManager");
            PackageManager packageManager = ((Context) this.f4793a).getPackageManager();
            linkedHashMap.clear();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            kotlin.jvm.internal.k.e(installedPackages, "getInstalledPackages(...)");
            j.H("Found " + installedPackages.size() + " installed packages", "InstalledAppManager");
            int i = 0;
            int i6 = 0;
            int i10 = 0;
            for (PackageInfo packageInfo : installedPackages) {
                try {
                    String packageName = packageInfo.packageName;
                    kotlin.jvm.internal.k.e(packageName, "packageName");
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    if (applicationInfo == null || (charSequenceLoadLabel = applicationInfo.loadLabel(packageManager)) == null || (string = charSequenceLoadLabel.toString()) == null) {
                        string = packageName;
                    }
                    i++;
                    ApplicationInfo applicationInfo2 = packageInfo.applicationInfo;
                    if ((applicationInfo2 != null ? applicationInfo2.flags : 0) != 0) {
                        i6++;
                    } else {
                        i10++;
                    }
                    linkedHashMap.put(string, packageName);
                } catch (Exception unused) {
                    j.G("Failed to process app info: " + packageInfo.packageName, "InstalledAppManager");
                }
            }
            j.H("Installed apps query completed: total=" + i + ", system=" + i6 + ", user=" + i10 + ", mapped=" + linkedHashMap.size(), "InstalledAppManager");
            return kotlin.collections.a.Y(linkedHashMap);
        } catch (Exception e6) {
            j.G("Failed to query installed apps: " + e6.getMessage(), "InstalledAppManager");
            return kotlin.collections.a.M();
        }
    }

    public C1621a(Context context, int i) {
        switch (i) {
            case 10:
                this.f4793a = null;
                break;
            default:
                kotlin.jvm.internal.k.f(context, "context");
                this.f4793a = context;
                this.b = new LinkedHashMap();
                break;
        }
    }
}
